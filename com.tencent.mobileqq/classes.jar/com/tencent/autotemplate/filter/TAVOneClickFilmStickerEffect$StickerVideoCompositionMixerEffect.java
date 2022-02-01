package com.tencent.autotemplate.filter;

import android.graphics.PointF;
import android.util.Log;
import com.tencent.autotemplate.TAVAutomaticRenderContext;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.model.TAVVideoCompositionTrack;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.tavkit.composition.video.ImageCollection;
import com.tencent.tavkit.composition.video.ImageCollection.TrackImagePair;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter;
import com.tencent.tavkit.report.IReportable;
import com.tencent.tavkit.report.MemoryReportHelper;
import com.tencent.tavkit.utils.BenchUtil;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVSourceImage;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.utils.CollectionUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class TAVOneClickFilmStickerEffect$StickerVideoCompositionMixerEffect
  implements TAVVideoMixEffect.Filter, IReportable
{
  private CMTime currentTime = CMTime.CMTimeZero;
  private RenderContext renderContext;
  private HashMap<String, Integer> sizeKeys = new HashMap();
  private TAVAutomaticRenderContext stickerContext;
  private HashMap<String, TextureInfo> textureMap = new HashMap();
  
  private TAVOneClickFilmStickerEffect$StickerVideoCompositionMixerEffect(TAVOneClickFilmStickerEffect paramTAVOneClickFilmStickerEffect, TAVAutomaticRenderContext paramTAVAutomaticRenderContext)
  {
    this.stickerContext = paramTAVAutomaticRenderContext;
  }
  
  private void sortTrackImages(List<ImageCollection.TrackImagePair> paramList)
  {
    if (CollectionUtil.isEmptyList(paramList)) {
      return;
    }
    Collections.sort(paramList, new TAVOneClickFilmStickerEffect.StickerVideoCompositionMixerEffect.1(this));
  }
  
  public CIImage apply(TAVVideoMixEffect paramTAVVideoMixEffect, ImageCollection paramImageCollection, RenderInfo paramRenderInfo)
  {
    List localList = paramImageCollection.getVideoChannelImages();
    CGSize localCGSize = paramRenderInfo.getRenderSize();
    this.currentTime = paramRenderInfo.getTime();
    this.stickerContext.setRenderSize(localCGSize);
    ArrayList localArrayList = new ArrayList();
    this.renderContext = paramRenderInfo.getCiContext().getRenderContext();
    this.sizeKeys.clear();
    if (!CollectionUtil.isEmptyList(localList))
    {
      sortTrackImages(localList);
      if (localList.size() > 1) {
        removeRedundantImage(localList);
      }
      int k = localList.size();
      int i = 0;
      if (i < k)
      {
        paramTAVVideoMixEffect = (ImageCollection.TrackImagePair)localList.get(i);
        int j;
        if (paramTAVVideoMixEffect != null)
        {
          paramImageCollection = paramTAVVideoMixEffect.getTrack().getExtraTrackInfo("pag_layer_index");
          j = -1;
          if ((paramImageCollection instanceof String)) {
            j = Integer.parseInt((String)paramImageCollection);
          }
          if ((TAVOneClickFilmStickerEffect.access$100(this.this$0) != 1) || (j != -1)) {
            break label180;
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label180:
          label246:
          int m;
          int n;
          Object localObject;
          if (((paramTAVVideoMixEffect.getTrack() instanceof TAVClip)) && (TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill.equals(((TAVClip)paramTAVVideoMixEffect.getTrack()).getVideoConfiguration().getContentMode())))
          {
            paramTAVVideoMixEffect = paramTAVVideoMixEffect.getImage().clone();
            paramTAVVideoMixEffect.applyFillInFrame(new CGRect(new PointF(), localCGSize), TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
            paramImageCollection = localCGSize;
            m = (int)paramImageCollection.width;
            n = (int)paramImageCollection.height;
            paramImageCollection = m + "_" + n;
            localObject = (Integer)this.sizeKeys.get(paramImageCollection);
            if (localObject != null) {
              break label539;
            }
            this.sizeKeys.put(paramImageCollection, Integer.valueOf(1));
          }
          for (;;)
          {
            String str = paramImageCollection + "_" + this.sizeKeys.get(paramImageCollection);
            localObject = (TextureInfo)this.textureMap.get(str);
            paramImageCollection = (ImageCollection)localObject;
            if (localObject == null)
            {
              this.renderContext.makeCurrent();
              paramImageCollection = CIContext.newTextureInfo(m, n);
              this.textureMap.put(str, paramImageCollection);
            }
            paramRenderInfo.getCiContext().convertImageToTexture(paramTAVVideoMixEffect, paramImageCollection);
            TLog.d("TAVStickerOverlayEffect", "PAGImage::layerIndex: " + i + ", renderSize: " + paramImageCollection.width + ", " + paramImageCollection.height + ", textureID: " + paramImageCollection.textureID + ", textureKey: " + str + ", context: " + this.renderContext.eglContext());
            if (j != -1) {
              break label561;
            }
            localArrayList.add(new TAVSourceImage(paramImageCollection, true, i));
            break;
            paramTAVVideoMixEffect = paramTAVVideoMixEffect.getImage();
            paramImageCollection = paramTAVVideoMixEffect.getSize();
            break label246;
            label539:
            this.sizeKeys.put(paramImageCollection, Integer.valueOf(((Integer)localObject).intValue() + 1));
          }
          label561:
          localArrayList.add(new TAVSourceImage(paramImageCollection, true, j));
        }
      }
    }
    BenchUtil.benchStart("renderStickerChain");
    paramTAVVideoMixEffect = this.stickerContext.renderStickerChainWithTexture(paramRenderInfo.getTime().getTimeUs() / 1000L, localArrayList);
    BenchUtil.benchEnd("renderStickerChain");
    this.renderContext.makeCurrent();
    if (paramTAVVideoMixEffect != null) {
      return new CIImage(paramTAVVideoMixEffect.getTextureInfo());
    }
    return null;
  }
  
  public String getReportKey()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.stickerContext != null) {
      synchronized (this.stickerContext.getStickers())
      {
        Iterator localIterator = this.stickerContext.getStickers().iterator();
        while (localIterator.hasNext())
        {
          TAVSticker localTAVSticker = (TAVSticker)localIterator.next();
          if ((localTAVSticker != null) && (localTAVSticker.getTimeRange() != null) && (localTAVSticker.getTimeRange().containsTime(this.currentTime))) {
            localArrayList.add(localTAVSticker.getStickerId());
          }
        }
      }
    }
    if (!localCollection.isEmpty()) {
      return this.this$0.reportKey + ":[" + MemoryReportHelper.appendKeys(localCollection) + "]";
    }
    return null;
  }
  
  public void release()
  {
    if (this.renderContext != null) {
      this.renderContext.makeCurrent();
    }
    if (this.stickerContext != null)
    {
      this.stickerContext.release();
      this.stickerContext = null;
    }
    if (this.textureMap != null)
    {
      Iterator localIterator = this.textureMap.values().iterator();
      while (localIterator.hasNext()) {
        ((TextureInfo)localIterator.next()).release();
      }
      this.textureMap.clear();
    }
    if (this.sizeKeys != null) {
      this.sizeKeys.clear();
    }
    TLog.d("TAVStickerOverlayEffect", "release cache." + Log.getStackTraceString(new RuntimeException()));
  }
  
  public void removeRedundantImage(List<ImageCollection.TrackImagePair> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ImageCollection.TrackImagePair localTrackImagePair = (ImageCollection.TrackImagePair)paramList.next();
      if ((localTrackImagePair != null) && (localTrackImagePair.getTrack() != null) && (localTrackImagePair.getTrack().getExtraTrackInfo("trackIndex") == null) && (localTrackImagePair.getTrack().getExtraTrackInfo("pag_layer_index") == null)) {
        paramList.remove();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.autotemplate.filter.TAVOneClickFilmStickerEffect.StickerVideoCompositionMixerEffect
 * JD-Core Version:    0.7.0.1
 */