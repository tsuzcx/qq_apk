package com.tencent.autotemplate.filter;

import android.graphics.PointF;
import android.util.Log;
import android.util.Pair;
import com.tencent.autotemplate.TAVAutomaticRenderContext;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.model.TAVVideoCompositionTrack;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.tavkit.composition.video.ImageCollection;
import com.tencent.tavkit.composition.video.ImageCollection.TrackImagePair;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavkit.report.MemoryReportHelper;
import com.tencent.tavkit.utils.BenchUtil;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVSourceImage;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.utils.CollectionUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class TAVOneClickFilmStickerEffect$StickerVideoCompositionMixerEffect
  extends TAVBaseMixFilter
{
  private TAVFaceMorphingFilter faceMorphingFilter;
  private TAVAutomaticRenderContext stickerContext;
  
  private TAVOneClickFilmStickerEffect$StickerVideoCompositionMixerEffect(TAVOneClickFilmStickerEffect paramTAVOneClickFilmStickerEffect, TAVAutomaticRenderContext paramTAVAutomaticRenderContext)
  {
    this.stickerContext = paramTAVAutomaticRenderContext;
    if (!CollectionUtil.isEmptyList(TAVOneClickFilmStickerEffect.access$100(paramTAVOneClickFilmStickerEffect))) {
      this.faceMorphingFilter = new TAVFaceMorphingFilter(TAVOneClickFilmStickerEffect.access$100(paramTAVOneClickFilmStickerEffect));
    }
  }
  
  public CIImage apply(TAVVideoMixEffect paramTAVVideoMixEffect, ImageCollection paramImageCollection, RenderInfo paramRenderInfo)
  {
    Object localObject2 = null;
    super.apply(paramTAVVideoMixEffect, paramImageCollection, paramRenderInfo);
    CGSize localCGSize = paramRenderInfo.getRenderSize();
    Object localObject1 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    if ((this.faceMorphingFilter != null) && (this.faceMorphingFilter.needRender(paramImageCollection, this.currentTime)))
    {
      paramTAVVideoMixEffect = this.faceMorphingFilter.apply(paramTAVVideoMixEffect, paramImageCollection, paramRenderInfo);
      paramTAVVideoMixEffect = getCachedTexture(paramTAVVideoMixEffect, paramTAVVideoMixEffect.getSize(), paramRenderInfo);
      ((List)localObject1).add(new TAVSourceImage(paramTAVVideoMixEffect, true, 0));
      this.stickerContext.setRenderSize(localCGSize);
      BenchUtil.benchStart("renderStickerChain");
      long l = this.currentTime.getTimeUs() / 1000L;
      localObject1 = this.stickerContext.renderStickerChainWithTexture(l, (List)localObject1);
      BenchUtil.benchEnd("renderStickerChain");
      this.renderContext.makeCurrent();
      if (localObject1 == null) {
        break label190;
      }
      paramTAVVideoMixEffect = new CIImage(((CMSampleBuffer)localObject1).getTextureInfo());
    }
    label190:
    do
    {
      return paramTAVVideoMixEffect;
      localObject1 = getCachedTextures(paramImageCollection.getVideoChannelImages(), localArrayList, paramRenderInfo, localCGSize);
      paramTAVVideoMixEffect = null;
      break;
      if (paramTAVVideoMixEffect != null) {
        return new CIImage(paramTAVVideoMixEffect);
      }
      paramTAVVideoMixEffect = localObject2;
    } while (!needCropTexture(paramImageCollection));
    return getOutputImage((TextureInfo)localArrayList.get(0), paramRenderInfo);
  }
  
  public List<TAVSourceImage> getCachedTextures(List<ImageCollection.TrackImagePair> paramList, List<TextureInfo> paramList1, RenderInfo paramRenderInfo, CGSize paramCGSize)
  {
    ArrayList localArrayList = new ArrayList();
    if (CollectionUtil.isEmptyList(paramList)) {
      return localArrayList;
    }
    int j = paramList.size();
    int i = 0;
    if (i < j)
    {
      Object localObject = (ImageCollection.TrackImagePair)paramList.get(i);
      int k;
      if (localObject != null)
      {
        k = getPAGLayerIndex((ImageCollection.TrackImagePair)localObject);
        if ((TAVOneClickFilmStickerEffect.access$200(this.this$0) != 1) || (k != -1)) {
          break label89;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label89:
        localObject = applyContentMode((ImageCollection.TrackImagePair)localObject, paramCGSize, paramRenderInfo);
        localObject = getCachedTexture((CIImage)((Pair)localObject).first, (CGSize)((Pair)localObject).second, paramRenderInfo);
        paramList1.add(localObject);
        TLog.d("TAVStickerOverlayEffect", "PAGImage::layerIndex: " + i + ", renderSize: " + ((TextureInfo)localObject).width + ", " + ((TextureInfo)localObject).height + ", textureID: " + ((TextureInfo)localObject).textureID + ", context: " + this.renderContext.eglContext());
        if (k == -1) {
          localArrayList.add(new TAVSourceImage((TextureInfo)localObject, true, i));
        } else {
          localArrayList.add(new TAVSourceImage((TextureInfo)localObject, true, k));
        }
      }
    }
    return localArrayList;
  }
  
  public CIImage getOutputImage(TextureInfo paramTextureInfo, RenderInfo paramRenderInfo)
  {
    paramTextureInfo = new CIImage(paramTextureInfo);
    paramTextureInfo.applyFillInFrame(new CGRect(new PointF(), paramRenderInfo.getRenderSize()), TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
    CGSize localCGSize = paramTextureInfo.getSize();
    localCGSize.width = paramRenderInfo.getRenderWidth();
    localCGSize.height = paramRenderInfo.getRenderHeight();
    return paramTextureInfo;
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
  
  public boolean needCropTexture(ImageCollection paramImageCollection)
  {
    paramImageCollection = paramImageCollection.getVideoChannelImages();
    if (!paramImageCollection.isEmpty())
    {
      paramImageCollection = ((ImageCollection.TrackImagePair)paramImageCollection.get(0)).getTrack();
      if ((isTAVClip(paramImageCollection)) && (paramImageCollection.getExtraTrackInfo("extra_frame_info") != null)) {
        return true;
      }
    }
    return false;
  }
  
  public void release()
  {
    super.release();
    if (this.stickerContext != null)
    {
      this.stickerContext.release();
      this.stickerContext = null;
    }
    TLog.d("TAVStickerOverlayEffect", "release cache." + Log.getStackTraceString(new RuntimeException()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.autotemplate.filter.TAVOneClickFilmStickerEffect.StickerVideoCompositionMixerEffect
 * JD-Core Version:    0.7.0.1
 */