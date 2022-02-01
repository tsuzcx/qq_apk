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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.tavsticker.model.TAVSourceImage;>;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.libpag.PAGSurface;

public class TAVAutomaticRenderContext
  extends TAVStickerRenderContext
{
  private static final String KEY_EXTRA_STICKER_SPEED = "key_extra_sticker_speed";
  private static final String KEY_EXTRA_STICKER_TYPE = "key_extra_sticker_type";
  private static final String STICKER_VIDEO_TRANSITION = "sticker_video_transition";
  public static final String VIDEO_TRACK = "videoTrack";
  private final String TAG = "TAVAutomaticRenderConte@" + Integer.toHexString(hashCode());
  private List<TAVSourceImage> cacheImagesForRelease = null;
  private CopyFilter mCopyFilter = new CopyFilter();
  private TextureInfo mCopyTextureInfo;
  private ArrayList<TAVSticker> mEffectStickers = new ArrayList();
  private ArrayList<TAVSticker> mTransitionStickers = new ArrayList();
  private Map<String, List<TAVStickerImageItem>> mapVideoTrack = new HashMap();
  private long renderThreadId = -1L;
  
  private boolean checkVideoTrack(TAVStickerImageItem paramTAVStickerImageItem)
  {
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
                return 1 == i;
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
  
  private void createTavStickerTexture()
  {
    if (this.stickerTexture != null) {}
    while (!TAVStickerUtil.isValidCGSize(this.renderSize)) {
      return;
    }
    this.stickerTexture = new TAVStickerTexture((int)this.renderSize.width, (int)this.renderSize.height, 3553, 0);
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
  
  private static boolean isLayerFillAble(TAVStickerLayerInfo paramTAVStickerLayerInfo)
  {
    label4:
    Iterator localIterator;
    if (paramTAVStickerLayerInfo == null) {}else
    {
      do
      {
        return false;
        paramTAVStickerLayerInfo = paramTAVStickerLayerInfo.getUserDataList();
      } while ((paramTAVStickerLayerInfo == null) || (paramTAVStickerLayerInfo.isEmpty()));
      localIterator = paramTAVStickerLayerInfo.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label4;
      }
      paramTAVStickerLayerInfo = (TAVStickerLayerInfo.TAVStickerUserData)localIterator.next();
      if (paramTAVStickerLayerInfo == null) {
        break;
      }
      paramTAVStickerLayerInfo = paramTAVStickerLayerInfo.getData();
      if (TextUtils.isEmpty(paramTAVStickerLayerInfo)) {
        break;
      }
      try
      {
        paramTAVStickerLayerInfo = new JSONObject(paramTAVStickerLayerInfo);
        if (paramTAVStickerLayerInfo == null) {
          continue;
        }
        if (paramTAVStickerLayerInfo.optInt("videoTrack", 0) > 0)
        {
          bool = true;
          return bool;
        }
      }
      catch (JSONException paramTAVStickerLayerInfo)
      {
        for (;;)
        {
          Logger.e("TAVAutomaticRenderContext", "isLayerFillAble JSONException " + paramTAVStickerLayerInfo.getMessage());
          paramTAVStickerLayerInfo.printStackTrace();
          paramTAVStickerLayerInfo = null;
          continue;
          boolean bool = false;
        }
      }
    }
  }
  
  private void updateIndexForImages(long paramLong, List<TAVSourceImage> paramList, TAVSticker paramTAVSticker)
  {
    Object localObject1;
    if ((!CollectionUtil.isEmptyList(paramList)) && (paramTAVSticker != null))
    {
      localObject1 = (List)this.mapVideoTrack.get(paramTAVSticker.getUniqueId());
      if (CollectionUtil.isEmptyList((List)localObject1)) {
        break label434;
      }
    }
    label434:
    for (int i = ((List)localObject1).size();; i = 0)
    {
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
      if (CollectionUtil.isEmptyList((List)localObject1)) {}
      float f;
      do
      {
        return;
        Collections.sort((List)localObject1, new TAVAutomaticRenderContext.1(this));
        bool = "sticker_video_transition".equals(paramTAVSticker.getExtraBundle().getString("key_extra_sticker_type"));
        f = paramTAVSticker.getExtraBundle().getFloat("key_extra_sticker_speed", 1.0F);
      } while ((!bool) || (k != 1) || (((List)localObject1).size() != 2));
      if (new CMTime(paramLong, 1000).sub(paramTAVSticker.getTimeRange().getStart()).multi(f).sub(((TAVStickerLayerInfo)((List)localObject1).get(0)).getTimeRange().getEnd()).getTimeUs() >= 0L) {}
      for (boolean bool = true;; bool = false)
      {
        if (bool) {
          ((TAVSourceImage)paramList.get(0)).setIndex(1);
        }
        for (;;)
        {
          Log.i(this.TAG, "updateIndexForImages: presentationTimeMs = " + paramLong + ", sticker start = " + paramTAVSticker.getTimeRange().getStart().getTimeUs() / 1000L + ",isNextLayer = " + bool);
          return;
          ((TAVSourceImage)paramList.get(0)).setIndex(0);
        }
      }
    }
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
    localTAVAutomaticRenderContext.mapVideoTrack.putAll(this.mapVideoTrack);
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
    TLog.d(this.TAG, "getCopyTextureInfo const time : " + (System.nanoTime() - l) + " 纳秒");
    return this.mCopyTextureInfo;
  }
  
  public void readAllVideoTracks()
  {
    checkStickerList();
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
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 86	com/tencent/autotemplate/TAVAutomaticRenderContext:renderThreadId	J
    //   6: ldc2_w 83
    //   9: lcmp
    //   10: ifeq +24 -> 34
    //   13: aload_0
    //   14: getfield 86	com/tencent/autotemplate/TAVAutomaticRenderContext:renderThreadId	J
    //   17: lstore_1
    //   18: invokestatic 440	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   21: invokevirtual 443	java/lang/Thread:getId	()J
    //   24: lstore_3
    //   25: lload_1
    //   26: lload_3
    //   27: lcmp
    //   28: ifeq +6 -> 34
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: aload_0
    //   35: invokespecial 445	com/tencent/tavsticker/core/TAVStickerRenderContext:release	()V
    //   38: aload_0
    //   39: getfield 380	com/tencent/autotemplate/TAVAutomaticRenderContext:mCopyTextureInfo	Lcom/tencent/tav/coremedia/TextureInfo;
    //   42: ifnull -11 -> 31
    //   45: aload_0
    //   46: getfield 380	com/tencent/autotemplate/TAVAutomaticRenderContext:mCopyTextureInfo	Lcom/tencent/tav/coremedia/TextureInfo;
    //   49: invokevirtual 446	com/tencent/tav/coremedia/TextureInfo:release	()V
    //   52: aload_0
    //   53: aconst_null
    //   54: putfield 380	com/tencent/autotemplate/TAVAutomaticRenderContext:mCopyTextureInfo	Lcom/tencent/tav/coremedia/TextureInfo;
    //   57: goto -26 -> 31
    //   60: astore 5
    //   62: aload_0
    //   63: monitorexit
    //   64: aload 5
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	TAVAutomaticRenderContext
    //   17	9	1	l1	long
    //   24	3	3	l2	long
    //   60	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	25	60	finally
    //   34	57	60	finally
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
    TAVStickerProvider localTAVStickerProvider = null;
    Iterator localIterator = null;
    this.presentationTimeMs = paramLong;
    checkStickerList();
    checkStickerProviderList();
    if ((this.pagSurface == null) && (paramSurface != null)) {
      if (paramEGLContext == null) {
        break label59;
      }
    }
    label59:
    for (this.pagSurface = PAGSurface.FromSurface(paramSurface, paramEGLContext); this.pagSurface == null; this.pagSurface = PAGSurface.FromSurface(paramSurface))
    {
      paramList = localIterator;
      return paramList;
    }
    if (this.cacheImagesForRelease != null) {
      releaseCacheImages(this.cacheImagesForRelease);
    }
    if (this.stickers.size() != this.providers.size())
    {
      reloadAllProviders();
      sortedAllProviders();
    }
    if (!CollectionUtil.isEmptyList(paramList)) {}
    for (paramSurface = new ArrayList(paramList);; paramSurface = null)
    {
      if (!CollectionUtil.isEmptyList(paramSurface))
      {
        this.cacheImagesForRelease = new ArrayList(paramSurface);
        paramList = localIterator;
        if (CollectionUtil.isEmptyList(this.providers)) {
          break;
        }
        localIterator = this.providers.iterator();
        paramList = paramSurface;
        paramSurface = localTAVStickerProvider;
        label182:
        do
        {
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localTAVStickerProvider = (TAVStickerProvider)localIterator.next();
          } while ((localTAVStickerProvider == null) || (!shouldRenderSticker(localTAVStickerProvider.getSticker(), paramLong)));
          paramEGLContext = paramSurface;
          if (paramSurface == null) {
            paramEGLContext = new CMSampleBuffer(new CMTime(TAVStickerUtil.millisecond2Seconds(paramLong)), this.stickerTexture.getTextureInfo(), false);
          }
          updateIndexForImages(paramLong, paramList, localTAVStickerProvider.getSticker());
          localTAVStickerProvider.setRenderSize(this.renderSize);
          localTAVStickerProvider.setPagSurface(this.pagSurface);
          localTAVStickerProvider.replaceSourceImages(paramList);
          localTAVStickerProvider.updateRender(paramLong);
          paramSurface = paramEGLContext;
        } while (!this.pagSurface.present());
        if (paramList != null) {
          break label396;
        }
      }
      for (paramSurface = new ArrayList();; paramSurface = paramList)
      {
        this.stickerTexture.awaitNewImage(1000L);
        paramList = new TAVSourceImage(this.stickerTexture.getTextureInfo(), 0);
        paramSurface.add(paramList);
        this.cacheImagesForRelease.add(paramList);
        paramList = paramSurface;
        paramSurface = paramEGLContext;
        break label182;
        this.cacheImagesForRelease = new ArrayList();
        break;
        label396:
        paramList.clear();
      }
      boolean bool = this.pagSurface.present();
      paramList = paramSurface;
      if (paramSurface == null) {
        break;
      }
      paramSurface.setNewFrame(bool);
      return paramSurface;
    }
  }
  
  public CMSampleBuffer renderStickerChainWithTexture(long paramLong, List<TAVSourceImage> paramList)
  {
    TAVStickerProvider localTAVStickerProvider = null;
    Iterator localIterator = null;
    this.renderThreadId = Thread.currentThread().getId();
    this.presentationTimeMs = paramLong;
    Object localObject;
    if (!TAVStickerUtil.isValidCGSize(this.renderSize))
    {
      TLog.e(this.TAG, "renderSticker -> mRenderSize is invalid!");
      localObject = localIterator;
    }
    do
    {
      do
      {
        return localObject;
        createTavStickerTexture();
        if (this.stickerTexture == null)
        {
          TLog.e(this.TAG, "renderSticker -> mStickerTexture is null!");
          return null;
        }
        checkStickerList();
        checkStickerProviderList();
        if (this.pagSurface == null) {
          this.pagSurface = PAGSurface.FromTexture(this.stickerTexture.getTextureInfo().textureID, this.stickerTexture.getTextureInfo().width, this.stickerTexture.getTextureInfo().height, true);
        }
        localObject = localIterator;
      } while (this.pagSurface == null);
      if (this.cacheImagesForRelease != null) {
        releaseCacheImages(this.cacheImagesForRelease);
      }
      if (this.stickers.size() != this.providers.size())
      {
        reloadAllProviders();
        sortedAllProviders();
      }
      if (!CollectionUtil.isEmptyList(paramList)) {}
      for (this.cacheImagesForRelease = new ArrayList(paramList);; this.cacheImagesForRelease = new ArrayList())
      {
        ArrayList localArrayList = new ArrayList(paramList);
        localObject = localIterator;
        if (CollectionUtil.isEmptyList(this.providers)) {
          break;
        }
        localIterator = this.providers.iterator();
        int i = 0;
        paramList = localTAVStickerProvider;
        while (localIterator.hasNext())
        {
          localTAVStickerProvider = (TAVStickerProvider)localIterator.next();
          if (localTAVStickerProvider != null)
          {
            localObject = localTAVStickerProvider.getSticker();
            if (shouldRenderSticker((TAVSticker)localObject, paramLong))
            {
              boolean bool = "sticker_video_transition".equals(((TAVSticker)localObject).getExtraBundle().getString("key_extra_sticker_type"));
              if ((i == 0) || (!bool))
              {
                int j = i;
                if (bool) {
                  j = 1;
                }
                localObject = paramList;
                if (paramList == null) {
                  localObject = new CMSampleBuffer(new CMTime(TAVStickerUtil.millisecond2Seconds(paramLong)), this.stickerTexture.getTextureInfo(), false);
                }
                updateIndexForImages(paramLong, localArrayList, localTAVStickerProvider.getSticker());
                localTAVStickerProvider.setRenderSize(this.renderSize);
                localTAVStickerProvider.setPagSurface(this.pagSurface);
                localTAVStickerProvider.replaceSourceImages(localArrayList);
                localTAVStickerProvider.updateRender(paramLong);
                paramList = (List<TAVSourceImage>)localObject;
                i = j;
                if (this.pagSurface.present())
                {
                  localArrayList.clear();
                  paramList = new TAVSourceImage(getCopyTextureInfo(), true, 0);
                  localArrayList.add(paramList);
                  this.cacheImagesForRelease.add(paramList);
                  paramList = (List<TAVSourceImage>)localObject;
                  i = j;
                }
              }
            }
          }
        }
      }
      localObject = paramList;
    } while (paramList == null);
    paramList.setNewFrame(true);
    return paramList;
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
  
  public boolean shouldRenderSticker(TAVSticker paramTAVSticker, long paramLong)
  {
    if (paramTAVSticker == null) {}
    for (;;)
    {
      return false;
      if (this.renderContextDataSource != null) {
        return this.renderContextDataSource.shouldRenderSticker(paramTAVSticker, paramLong);
      }
      CMTimeRange localCMTimeRange = paramTAVSticker.getTimeRange();
      int i;
      if (localCMTimeRange == null) {
        i = 1;
      }
      while ((i != 0) && (TAVStickerMode.INACTIVE == paramTAVSticker.getMode()))
      {
        return true;
        CMTime localCMTime = new CMTime(paramLong, 1000);
        if (((localCMTimeRange.getStart().smallThan(localCMTime)) || (localCMTimeRange.getStart().equals(localCMTime))) && ((localCMTimeRange.getEnd().bigThan(localCMTime)) || (localCMTimeRange.getEnd().equals(localCMTime)))) {
          i = 1;
        } else {
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.autotemplate.TAVAutomaticRenderContext
 * JD-Core Version:    0.7.0.1
 */