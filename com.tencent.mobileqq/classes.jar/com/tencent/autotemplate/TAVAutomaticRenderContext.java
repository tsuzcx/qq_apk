package com.tencent.autotemplate;

import android.opengl.EGLContext;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import com.tencent.autotemplate.filter.CopyFilter;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavsticker.core.ITAVRenderContextDataSource;
import com.tencent.tavsticker.core.TAVStickerRenderContext;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVSourceImage;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerImageItem;
import com.tencent.tavsticker.model.TAVStickerLayerInfo;
import com.tencent.tavsticker.model.TAVStickerLayerInfo.TAVStickerUserData;
import com.tencent.tavsticker.model.TAVStickerMode;
import com.tencent.tavsticker.model.TAVStickerProvider;
import com.tencent.tavsticker.model.TAVStickerTexture;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.tavsticker.model.TAVSourceImage;>;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import org.libpag.PAGComposition;
import org.libpag.PAGLayer;
import org.libpag.PAGPlayer;
import org.libpag.PAGSurface;

public class TAVAutomaticRenderContext
  extends TAVStickerRenderContext
{
  private static final String KEY_EXTRA_STICKER_SPEED = "key_extra_sticker_speed";
  public static final String KEY_EXTRA_STICKER_TYPE = "key_extra_sticker_type";
  private static final int LAST_DROP_FRAME = 4;
  public static final String STICKER_VIDEO_TRANSITION = "sticker_video_transition";
  public static final int TRANSITION_LAYER_SUM = 2;
  private static final long US_UNIT = 1000000L;
  public static final String VIDEO_TRACK = "videoTrack";
  private final String TAG;
  private List<TAVSourceImage> cacheImagesForRelease;
  private CopyFilter mCopyFilter;
  private TextureInfo mCopyTextureInfo;
  private ArrayList<TAVSticker> mEffectStickers;
  private ArrayList<TAVSticker> mTransitionStickers;
  private Map<String, List<TAVStickerImageItem>> mapVideoTrack;
  private long renderThreadId;
  
  public TAVAutomaticRenderContext()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TAVAutomaticRenderConte@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.TAG = localStringBuilder.toString();
    this.mTransitionStickers = new ArrayList();
    this.mEffectStickers = new ArrayList();
    this.mapVideoTrack = new ConcurrentHashMap();
    this.mCopyFilter = new CopyFilter();
    this.renderThreadId = -1L;
    this.cacheImagesForRelease = null;
  }
  
  private boolean checkVideoTrack(TAVStickerImageItem paramTAVStickerImageItem)
  {
    boolean bool = false;
    if ((paramTAVStickerImageItem != null) && (paramTAVStickerImageItem.getLayerInfo() != null) && (paramTAVStickerImageItem.getLayerInfo().getUserDataList() != null))
    {
      paramTAVStickerImageItem = paramTAVStickerImageItem.getLayerInfo().getUserDataList();
      if (!CollectionUtil.isEmptyList(paramTAVStickerImageItem))
      {
        paramTAVStickerImageItem = paramTAVStickerImageItem.iterator();
        while (paramTAVStickerImageItem.hasNext())
        {
          Object localObject = (TAVStickerLayerInfo.TAVStickerUserData)paramTAVStickerImageItem.next();
          if (localObject != null)
          {
            localObject = ((TAVStickerLayerInfo.TAVStickerUserData)localObject).getData();
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              try
              {
                int i = new JSONObject((String)localObject).optInt("videoTrack", 0);
                if (1 == i) {
                  bool = true;
                }
                return bool;
              }
              catch (Exception localException)
              {
                localException.printStackTrace();
              }
            }
          }
        }
      }
    }
    return false;
  }
  
  private long getCurTimeUs(long paramLong)
  {
    long l1 = TimeUtil.milli2Us(paramLong);
    paramLong = this.rootComposition.duration();
    float f = this.rootComposition.frameRate();
    long l2 = ((float)paramLong * f / 1000000.0F) - ((float)l1 * f / 1000000.0F);
    paramLong = l1;
    if (l2 >= 0L)
    {
      paramLong = l1;
      if (l2 <= 4L) {
        paramLong = Math.abs(l1 - l1 % 1000000L);
      }
    }
    return paramLong;
  }
  
  private List<TAVStickerImageItem> getVideoTracks(TAVSticker paramTAVSticker)
  {
    if (paramTAVSticker != null)
    {
      Object localObject = paramTAVSticker.getStickerImageItems();
      if (!CollectionUtil.isEmptyList((List)localObject))
      {
        paramTAVSticker = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          TAVStickerImageItem localTAVStickerImageItem = (TAVStickerImageItem)((Iterator)localObject).next();
          if (checkVideoTrack(localTAVStickerImageItem)) {
            paramTAVSticker.add(localTAVStickerImageItem);
          }
        }
        return paramTAVSticker;
      }
    }
    return null;
  }
  
  private void initPagPlayer()
  {
    if (this.pagPlayer == null)
    {
      this.pagPlayer = new PAGPlayer();
      this.pagPlayer.setSurface(this.pagSurface);
      if (this.rootComposition != null) {
        this.pagPlayer.setComposition(this.rootComposition);
      }
      resetRenderConfigs();
    }
    if ((this.rootComposition == null) || (this.rootComposition.width() != this.renderSize.width) || (this.rootComposition.height() != this.renderSize.height))
    {
      createCompositionRenderTree();
      this.pagPlayer.setComposition(this.rootComposition);
    }
  }
  
  public static boolean isLayerFillAble(TAVStickerLayerInfo paramTAVStickerLayerInfo)
  {
    boolean bool2 = false;
    if (paramTAVStickerLayerInfo == null) {
      return false;
    }
    paramTAVStickerLayerInfo = paramTAVStickerLayerInfo.getUserDataList();
    boolean bool1 = bool2;
    if (paramTAVStickerLayerInfo != null)
    {
      if (paramTAVStickerLayerInfo.isEmpty()) {
        return false;
      }
      Iterator localIterator = paramTAVStickerLayerInfo.iterator();
      do
      {
        Object localObject;
        do
        {
          do
          {
            bool1 = bool2;
            if (!localIterator.hasNext()) {
              break;
            }
            paramTAVStickerLayerInfo = (TAVStickerLayerInfo.TAVStickerUserData)localIterator.next();
          } while (paramTAVStickerLayerInfo == null);
          localObject = paramTAVStickerLayerInfo.getData();
        } while (TextUtils.isEmpty((CharSequence)localObject));
        paramTAVStickerLayerInfo = null;
        try
        {
          localObject = new JSONObject((String)localObject);
          paramTAVStickerLayerInfo = (TAVStickerLayerInfo)localObject;
        }
        catch (JSONException localJSONException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("isLayerFillAble JSONException ");
          localStringBuilder.append(localJSONException.getMessage());
          Logger.e("TAVAutomaticRenderContext", localStringBuilder.toString());
          localJSONException.printStackTrace();
        }
      } while (paramTAVStickerLayerInfo == null);
      bool1 = bool2;
      if (paramTAVStickerLayerInfo.optInt("videoTrack", 0) > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean updateIndexForImages(long paramLong, List<TAVSourceImage> paramList, TAVSticker paramTAVSticker)
  {
    if ((!CollectionUtil.isEmptyList(paramList)) && (paramTAVSticker != null))
    {
      Object localObject1 = (List)this.mapVideoTrack.get(paramTAVSticker.getUniqueId());
      int i;
      if (!CollectionUtil.isEmptyList((List)localObject1)) {
        i = ((List)localObject1).size();
      } else {
        i = 0;
      }
      int k = paramList.size();
      int j = 0;
      while ((j < i) && (j < k))
      {
        localObject2 = (TAVSourceImage)paramList.get(j);
        if ((localObject2 != null) && (((List)localObject1).get(j) != null)) {
          ((TAVSourceImage)localObject2).setIndex(((TAVStickerImageItem)((List)localObject1).get(j)).getLayerIndex());
        }
        j += 1;
      }
      localObject1 = new ArrayList();
      Object localObject2 = paramTAVSticker.getStickerLayerInfos().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        TAVStickerLayerInfo localTAVStickerLayerInfo = (TAVStickerLayerInfo)((Iterator)localObject2).next();
        if (isLayerFillAble(localTAVStickerLayerInfo)) {
          ((List)localObject1).add(localTAVStickerLayerInfo);
        }
      }
      boolean bool = "sticker_video_transition".equals(paramTAVSticker.getExtraBundle().getString("key_extra_sticker_type"));
      if ((CollectionUtil.isEmptyList((List)localObject1)) && (bool))
      {
        localObject2 = paramTAVSticker.getStickerImageItems();
        if (((ArrayList)localObject2).size() == 2)
        {
          i = 0;
          while (i < ((ArrayList)localObject2).size())
          {
            ((List)localObject1).add(((TAVStickerImageItem)((ArrayList)localObject2).get(i)).getLayerInfo());
            i += 1;
          }
        }
        return false;
      }
      Collections.sort((List)localObject1, new TAVAutomaticRenderContext.1(this));
      float f = paramTAVSticker.getExtraBundle().getFloat("key_extra_sticker_speed", 1.0F);
      if ((bool) && (k == 1) && (((List)localObject1).size() == 2))
      {
        localObject2 = new CMTime(paramLong, 1000).sub(paramTAVSticker.getTimeRange().getStart()).multi(f);
        if ((((TAVStickerLayerInfo)((List)localObject1).get(0)).getTimeRange().getEnd().bigThan(((TAVStickerLayerInfo)((List)localObject1).get(1)).getTimeRange().getStart())) && (((CMTime)localObject2).bigThan(((TAVStickerLayerInfo)((List)localObject1).get(1)).getTimeRange().getStart())) && (((TAVStickerLayerInfo)((List)localObject1).get(0)).getTimeRange().getEnd().bigThan((CMTime)localObject2))) {
          return false;
        }
        if (((CMTime)localObject2).sub(((TAVStickerLayerInfo)((List)localObject1).get(0)).getTimeRange().getEnd()).getTimeUs() >= 0L) {
          bool = true;
        } else {
          bool = false;
        }
        if (bool) {
          ((TAVSourceImage)paramList.get(0)).setIndex(1);
        } else {
          ((TAVSourceImage)paramList.get(0)).setIndex(0);
        }
        paramList = this.TAG;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("updateIndexForImages: presentationTimeMs = ");
        ((StringBuilder)localObject1).append(paramLong);
        ((StringBuilder)localObject1).append(", sticker start = ");
        ((StringBuilder)localObject1).append(paramTAVSticker.getTimeRange().getStart().getTimeUs() / 1000L);
        ((StringBuilder)localObject1).append(",isNextLayer = ");
        ((StringBuilder)localObject1).append(bool);
        Log.i(paramList, ((StringBuilder)localObject1).toString());
      }
    }
    return true;
  }
  
  @Deprecated
  public TAVAutomaticRenderContext copy()
  {
    TAVAutomaticRenderContext localTAVAutomaticRenderContext = new TAVAutomaticRenderContext();
    localTAVAutomaticRenderContext.checkStickerList();
    if (this.stickers != null) {
      localTAVAutomaticRenderContext.stickers = this.stickers;
    }
    localTAVAutomaticRenderContext.setRenderSize(this.renderSize);
    localTAVAutomaticRenderContext.stickerLayerIndex = this.stickerLayerIndex;
    localTAVAutomaticRenderContext.renderContextDataSource = this.renderContextDataSource;
    localTAVAutomaticRenderContext.quality = this.quality;
    checkChildContexts();
    this.childContexts.add(localTAVAutomaticRenderContext);
    return localTAVAutomaticRenderContext;
  }
  
  public TAVAutomaticRenderContext copyRenderContext()
  {
    TAVAutomaticRenderContext localTAVAutomaticRenderContext = new TAVAutomaticRenderContext();
    localTAVAutomaticRenderContext.checkStickerList();
    if (this.stickers != null) {
      localTAVAutomaticRenderContext.stickers = this.stickers;
    }
    localTAVAutomaticRenderContext.setRenderSize(this.renderSize);
    localTAVAutomaticRenderContext.stickerLayerIndex = this.stickerLayerIndex;
    localTAVAutomaticRenderContext.renderContextDataSource = this.renderContextDataSource;
    localTAVAutomaticRenderContext.quality = this.quality;
    checkChildContexts();
    this.childContexts.add(localTAVAutomaticRenderContext);
    localTAVAutomaticRenderContext.mapVideoTrack = this.mapVideoTrack;
    return localTAVAutomaticRenderContext;
  }
  
  public TextureInfo getCopyTextureInfo()
  {
    long l = System.nanoTime();
    if (this.mCopyTextureInfo == null) {
      this.mCopyTextureInfo = CIContext.newTextureInfo(this.stickerTexture.getTextureInfo().width, this.stickerTexture.getTextureInfo().height);
    }
    this.mCopyFilter.setRenderForScreen(false);
    this.mCopyFilter.setRendererWidth(this.stickerTexture.getTextureInfo().width);
    this.mCopyFilter.setRendererHeight(this.stickerTexture.getTextureInfo().height);
    this.mCopyFilter.setDesTextureInfo(this.mCopyTextureInfo);
    this.mCopyFilter.clearBufferBuffer(-16777216);
    this.mCopyFilter.applyFilter(this.stickerTexture.getTextureInfo());
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCopyTextureInfo const time : ");
    localStringBuilder.append(System.nanoTime() - l);
    localStringBuilder.append(" 纳秒");
    TLog.d(str, localStringBuilder.toString());
    return this.mCopyTextureInfo;
  }
  
  public void readAllVideoTracks()
  {
    checkStickerList();
    this.mapVideoTrack.clear();
    Iterator localIterator = this.stickers.iterator();
    while (localIterator.hasNext())
    {
      TAVSticker localTAVSticker = (TAVSticker)localIterator.next();
      if (localTAVSticker != null)
      {
        List localList = getVideoTracks(localTAVSticker);
        if (!CollectionUtil.isEmptyList(localList)) {
          this.mapVideoTrack.put(localTAVSticker.getUniqueId(), localList);
        }
      }
    }
  }
  
  public void release()
  {
    try
    {
      if (this.renderThreadId != -1L)
      {
        long l1 = this.renderThreadId;
        long l2 = Thread.currentThread().getId();
        if (l1 != l2) {
          return;
        }
      }
      super.release();
      if (this.mCopyTextureInfo != null)
      {
        this.mCopyTextureInfo.release();
        this.mCopyTextureInfo = null;
      }
      return;
    }
    finally {}
  }
  
  public CMSampleBuffer renderStickerChain(long paramLong, List<TAVSourceImage> paramList, EGLContext paramEGLContext)
  {
    if (!TAVStickerUtil.isValidCGSize(this.renderSize))
    {
      TLog.e(this.TAG, "renderSticker -> mRenderSize is invalid!");
      return null;
    }
    createSurface();
    if (this.stickerSurface == null)
    {
      TLog.e(this.TAG, "renderSticker -> mStickerSurface is null!");
      return null;
    }
    if (this.stickerTexture == null)
    {
      TLog.e(this.TAG, "renderSticker -> mStickerTexture is null!");
      return null;
    }
    return renderStickerChain(this.stickerSurface, paramLong, paramList, paramEGLContext);
  }
  
  public CMSampleBuffer renderStickerChain(Surface paramSurface, long paramLong, List<TAVSourceImage> paramList, EGLContext paramEGLContext)
  {
    this.presentationTimeMs = paramLong;
    checkStickerList();
    checkStickerProviderList();
    if ((this.pagSurface == null) && (paramSurface != null)) {
      if (paramEGLContext != null) {
        this.pagSurface = PAGSurface.FromSurface(paramSurface, paramEGLContext);
      } else {
        this.pagSurface = PAGSurface.FromSurface(paramSurface);
      }
    }
    paramSurface = this.pagSurface;
    paramEGLContext = null;
    TAVStickerProvider localTAVStickerProvider = null;
    if (paramSurface == null) {
      return null;
    }
    initPagPlayer();
    paramSurface = this.cacheImagesForRelease;
    if (paramSurface != null) {
      releaseCacheImages(paramSurface);
    }
    if (this.stickers.size() != this.providers.size())
    {
      reloadAllProviders();
      sortedAllProviders();
    }
    if (!CollectionUtil.isEmptyList(paramList)) {
      paramSurface = new ArrayList(paramList);
    } else {
      paramSurface = null;
    }
    if (!CollectionUtil.isEmptyList(paramSurface)) {
      this.cacheImagesForRelease = new ArrayList(paramSurface);
    } else {
      this.cacheImagesForRelease = new ArrayList();
    }
    if (!CollectionUtil.isEmptyList(this.providers))
    {
      Iterator localIterator = this.providers.iterator();
      for (paramList = localTAVStickerProvider;; paramList = paramEGLContext)
      {
        do
        {
          paramEGLContext = paramList;
          if (!localIterator.hasNext()) {
            break;
          }
          localTAVStickerProvider = (TAVStickerProvider)localIterator.next();
        } while ((localTAVStickerProvider == null) || (!shouldRenderSticker(localTAVStickerProvider.getSticker(), paramLong)));
        paramEGLContext = paramList;
        if (paramList == null) {
          paramEGLContext = new CMSampleBuffer(new CMTime(TAVStickerUtil.millisecond2Seconds(paramLong)), this.stickerTexture.getTextureInfo(), false);
        }
        int i = 0;
        while (i < this.rootComposition.numLayers())
        {
          this.rootComposition.getLayerAt(i).setVisible(false);
          i += 1;
        }
        updateIndexForImages(paramLong, paramSurface, localTAVStickerProvider.getSticker());
        localTAVStickerProvider.setRenderSize(this.renderSize);
        localTAVStickerProvider.setPagPlayer(this.pagPlayer);
        localTAVStickerProvider.replaceSourceImages(paramSurface);
        this.rootComposition.setCurrentTime(1000L * paramLong);
        boolean bool = this.pagPlayer.flush();
        paramList = paramSurface;
        if (bool)
        {
          if (paramSurface == null) {
            paramSurface = new ArrayList();
          } else {
            paramSurface.clear();
          }
          paramList = new TAVSourceImage(this.stickerTexture.getTextureInfo(), 0);
          paramSurface.add(paramList);
          this.cacheImagesForRelease.add(paramList);
          paramList = paramSurface;
        }
        paramEGLContext.setNewFrame(bool);
        paramSurface = paramList;
      }
    }
    return paramEGLContext;
  }
  
  public CMSampleBuffer renderStickerChainWithTexture(long paramLong, List<TAVSourceImage> paramList)
  {
    long l1 = System.currentTimeMillis();
    this.renderThreadId = Thread.currentThread().getId();
    this.presentationTimeMs = paramLong;
    if (!TAVStickerUtil.isValidCGSize(this.renderSize))
    {
      TLog.e(this.TAG, "renderSticker -> mRenderSize is invalid!");
      return null;
    }
    checkStickerList();
    checkStickerProviderList();
    if (this.stickers.isEmpty()) {
      return null;
    }
    createTavStickerTexture();
    if (this.stickerTexture == null)
    {
      TLog.e(this.TAG, "renderSticker -> mStickerTexture is null!");
      return null;
    }
    checkStickerList();
    checkStickerProviderList();
    createPagSurface();
    if (this.pagSurface == null) {
      return null;
    }
    initPagPlayer();
    Object localObject1 = this.cacheImagesForRelease;
    if (localObject1 != null) {
      releaseCacheImages((List)localObject1);
    }
    if (this.stickers.size() != this.providers.size())
    {
      reloadAllProviders();
      sortedAllProviders();
    }
    if (!CollectionUtil.isEmptyList(paramList)) {
      this.cacheImagesForRelease = new ArrayList(paramList);
    } else {
      this.cacheImagesForRelease = new ArrayList();
    }
    Object localObject2 = new ArrayList(paramList);
    if (!CollectionUtil.isEmptyList(this.providers))
    {
      Iterator localIterator = this.providers.iterator();
      paramList = null;
      int j = 0;
      while (localIterator.hasNext())
      {
        TAVStickerProvider localTAVStickerProvider = (TAVStickerProvider)localIterator.next();
        if (localTAVStickerProvider != null)
        {
          localObject1 = localTAVStickerProvider.getSticker();
          if (shouldRenderSticker((TAVSticker)localObject1, paramLong))
          {
            boolean bool = "sticker_video_transition".equals(((TAVSticker)localObject1).getExtraBundle().getString("key_extra_sticker_type"));
            if ((j == 0) || (!bool))
            {
              int i = j;
              if (bool) {
                i = 1;
              }
              localObject1 = paramList;
              if (paramList == null) {
                localObject1 = new CMSampleBuffer(new CMTime(TAVStickerUtil.millisecond2Seconds(paramLong)), this.stickerTexture.getTextureInfo(), false);
              }
              if (!updateIndexForImages(paramLong, (List)localObject2, localTAVStickerProvider.getSticker()))
              {
                paramList = (List<TAVSourceImage>)localObject1;
                j = i;
              }
              else
              {
                j = 0;
                while (j < this.rootComposition.numLayers())
                {
                  this.rootComposition.getLayerAt(j).setVisible(false);
                  j += 1;
                }
                localTAVStickerProvider.setRenderSize(this.renderSize);
                localTAVStickerProvider.setPagPlayer(this.pagPlayer);
                localTAVStickerProvider.replaceSourceImages((List)localObject2);
                long l2 = getCurTimeUs(paramLong);
                this.rootComposition.setCurrentTime(l2);
                paramList = (List<TAVSourceImage>)localObject1;
                j = i;
                if (this.pagPlayer.flush())
                {
                  ((ArrayList)localObject2).clear();
                  paramList = new TAVSourceImage(getCopyTextureInfo(), true, 0);
                  ((ArrayList)localObject2).add(paramList);
                  this.cacheImagesForRelease.add(paramList);
                  paramList = (List<TAVSourceImage>)localObject1;
                  j = i;
                }
              }
            }
          }
        }
      }
      localObject1 = paramList;
      if (paramList != null)
      {
        paramList.setNewFrame(true);
        localObject1 = paramList;
      }
    }
    else
    {
      localObject1 = null;
    }
    paramLong = System.currentTimeMillis();
    paramList = this.TAG;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("贴纸渲染耗时：");
    ((StringBuilder)localObject2).append(paramLong - l1);
    Logger.e(paramList, ((StringBuilder)localObject2).toString(), null);
    return localObject1;
  }
  
  public void setEffectStickers(List<TAVSticker> paramList)
  {
    checkStickerList();
    if (!CollectionUtil.isEmptyList(this.mEffectStickers)) {
      this.stickers.removeAll(this.mEffectStickers);
    }
    this.mEffectStickers.clear();
    if (paramList != null) {
      this.mEffectStickers.addAll(paramList);
    }
    if (!CollectionUtil.isEmptyList(this.mEffectStickers))
    {
      int i = this.stickers.size();
      this.stickers.addAll(i, this.mEffectStickers);
    }
    reloadAllStickers();
    reloadAllProviders();
    sortedAllProviders();
  }
  
  public void setTransitionStickers(List<TAVSticker> paramList)
  {
    checkStickerList();
    if (!CollectionUtil.isEmptyList(this.mTransitionStickers)) {
      this.stickers.removeAll(this.mTransitionStickers);
    }
    this.mTransitionStickers.clear();
    if (paramList != null) {
      this.mTransitionStickers.addAll(paramList);
    }
    if (!CollectionUtil.isEmptyList(this.mTransitionStickers)) {
      this.stickers.addAll(0, this.mTransitionStickers);
    }
    reloadAllStickers();
    reloadAllProviders();
    sortedAllProviders();
  }
  
  protected boolean shouldRenderSticker(TAVSticker paramTAVSticker, long paramLong)
  {
    if (paramTAVSticker == null) {
      return false;
    }
    if (this.renderContextDataSource != null) {
      return this.renderContextDataSource.shouldRenderSticker(paramTAVSticker, paramLong);
    }
    CMTimeRange localCMTimeRange = paramTAVSticker.getTimeRange();
    if (localCMTimeRange == null) {}
    CMTime localCMTime;
    do
    {
      i = 1;
      break;
      localCMTime = new CMTime(paramLong, 1000);
    } while (((localCMTimeRange.getStart().smallThan(localCMTime)) || (localCMTimeRange.getStart().equalsTo(localCMTime))) && ((localCMTimeRange.getEnd().bigThan(localCMTime)) || (localCMTimeRange.getEnd().equalsTo(localCMTime))));
    int i = 0;
    return (i != 0) && (TAVStickerMode.INACTIVE == paramTAVSticker.getMode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.TAVAutomaticRenderContext
 * JD-Core Version:    0.7.0.1
 */