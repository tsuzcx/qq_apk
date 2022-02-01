package com.tencent.autotemplate.filter;

import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Pair;
import com.tencent.autotemplate.extra.FrameInfo;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
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
import com.tencent.tavsticker.utils.CollectionUtil;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class TAVBaseMixFilter
  implements TAVVideoMixEffect.Filter, IReportable
{
  protected CMTime currentTime = CMTime.CMTimeZero;
  protected RenderContext renderContext;
  protected HashMap<String, Integer> sizeKeys = new HashMap();
  protected HashMap<String, TextureInfo> textureMap = new HashMap();
  
  private Rect transform(FrameInfo paramFrameInfo, CGSize paramCGSize)
  {
    Rect localRect = paramFrameInfo.frame;
    float f1 = paramCGSize.width / paramFrameInfo.sourceWidth;
    float f2 = paramCGSize.height / paramFrameInfo.sourceHeight;
    return new Rect((int)(localRect.left * f1), (int)(localRect.top * f2), (int)(localRect.right * f1), (int)(localRect.bottom * f2));
  }
  
  public CIImage apply(TAVVideoMixEffect paramTAVVideoMixEffect, ImageCollection paramImageCollection, RenderInfo paramRenderInfo)
  {
    this.currentTime = paramRenderInfo.getTime();
    this.renderContext = paramRenderInfo.getCiContext().getRenderContext();
    this.sizeKeys.clear();
    paramTAVVideoMixEffect = paramImageCollection.getVideoChannelImages();
    if (!CollectionUtil.isEmptyList(paramTAVVideoMixEffect))
    {
      sortTrackImages(paramTAVVideoMixEffect);
      removeRedundantImage(paramTAVVideoMixEffect);
    }
    return null;
  }
  
  public Pair<CIImage, CGSize> applyContentMode(ImageCollection.TrackImagePair paramTrackImagePair, CGSize paramCGSize, RenderInfo paramRenderInfo)
  {
    Rect localRect = getFrameCropRect(paramTrackImagePair.getTrack(), paramTrackImagePair.getImage().getSize());
    if (localRect != null)
    {
      paramTrackImagePair = paramTrackImagePair.getImage().clone();
      paramCGSize = paramTrackImagePair.getSize();
      paramTrackImagePair = new CIImage(getCachedTexture(paramTrackImagePair, paramCGSize, paramRenderInfo));
      paramTrackImagePair.imageByCroppingToRect(new CGRect(localRect.left, paramCGSize.height - localRect.bottom, localRect.right - localRect.left, localRect.bottom - localRect.top));
      paramCGSize = paramTrackImagePair.getSize();
    }
    else if ((isTAVClip(paramTrackImagePair.getTrack())) && (TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill.equals(getContentMode(paramTrackImagePair.getTrack()))))
    {
      paramTrackImagePair = paramTrackImagePair.getImage().clone();
      paramTrackImagePair.applyFillInFrame(new CGRect(new PointF(), paramCGSize), TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
    }
    else
    {
      paramTrackImagePair = paramTrackImagePair.getImage();
      paramCGSize = paramTrackImagePair.getSize();
    }
    return new Pair(paramTrackImagePair, paramCGSize);
  }
  
  public TextureInfo getCachedTexture(CIImage paramCIImage, CGSize paramCGSize, RenderInfo paramRenderInfo)
  {
    int i = (int)paramCGSize.width;
    int j = (int)paramCGSize.height;
    paramCGSize = new StringBuilder();
    paramCGSize.append(i);
    paramCGSize.append("_");
    paramCGSize.append(j);
    paramCGSize = paramCGSize.toString();
    Object localObject = (Integer)this.sizeKeys.get(paramCGSize);
    if (localObject == null) {
      this.sizeKeys.put(paramCGSize, Integer.valueOf(1));
    } else {
      this.sizeKeys.put(paramCGSize, Integer.valueOf(((Integer)localObject).intValue() + 1));
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramCGSize);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(this.sizeKeys.get(paramCGSize));
    String str = ((StringBuilder)localObject).toString();
    localObject = (TextureInfo)this.textureMap.get(str);
    paramCGSize = (CGSize)localObject;
    if (localObject == null)
    {
      this.renderContext.makeCurrent();
      paramCGSize = CIContext.newTextureInfo(i, j);
      this.textureMap.put(str, paramCGSize);
    }
    paramRenderInfo.getCiContext().convertImageToTexture(paramCIImage, paramCGSize);
    return paramCGSize;
  }
  
  public TAVVideoConfiguration.TAVVideoConfigurationContentMode getContentMode(TAVVideoCompositionTrack paramTAVVideoCompositionTrack)
  {
    return ((TAVClip)paramTAVVideoCompositionTrack).getVideoConfiguration().getContentMode();
  }
  
  public Rect getFrameCropRect(TAVVideoCompositionTrack paramTAVVideoCompositionTrack, CGSize paramCGSize)
  {
    if ((isTAVClip(paramTAVVideoCompositionTrack)) && (paramTAVVideoCompositionTrack.getExtraTrackInfo("extra_frame_info") != null)) {
      return transform((FrameInfo)paramTAVVideoCompositionTrack.getExtraTrackInfo("extra_frame_info"), paramCGSize);
    }
    return null;
  }
  
  public int getPAGLayerIndex(ImageCollection.TrackImagePair paramTrackImagePair)
  {
    int j = -1;
    int i = j;
    if (paramTrackImagePair != null)
    {
      if (paramTrackImagePair.getTrack() == null) {
        return -1;
      }
      paramTrackImagePair = paramTrackImagePair.getTrack().getExtraTrackInfo("pag_layer_index");
      i = j;
      if ((paramTrackImagePair instanceof String)) {
        i = Integer.parseInt((String)paramTrackImagePair);
      }
    }
    return i;
  }
  
  public int getTrackIndex(ImageCollection.TrackImagePair paramTrackImagePair)
  {
    if ((paramTrackImagePair != null) && (paramTrackImagePair.getTrack() != null) && ((paramTrackImagePair.getTrack().getExtraTrackInfo("trackIndex") instanceof Integer))) {
      return ((Integer)paramTrackImagePair.getTrack().getExtraTrackInfo("trackIndex")).intValue();
    }
    return 0;
  }
  
  public boolean isTAVClip(TAVVideoCompositionTrack paramTAVVideoCompositionTrack)
  {
    return paramTAVVideoCompositionTrack instanceof TAVClip;
  }
  
  public void release()
  {
    Object localObject = this.renderContext;
    if (localObject != null) {
      ((RenderContext)localObject).makeCurrent();
    }
    localObject = this.textureMap;
    if (localObject != null)
    {
      localObject = ((HashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((TextureInfo)((Iterator)localObject).next()).release();
      }
      this.textureMap.clear();
    }
    localObject = this.sizeKeys;
    if (localObject != null) {
      ((HashMap)localObject).clear();
    }
  }
  
  public void removeRedundantImage(List<ImageCollection.TrackImagePair> paramList)
  {
    if (paramList.size() > 1)
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
  
  public void sortTrackImages(List<ImageCollection.TrackImagePair> paramList)
  {
    if (CollectionUtil.isEmptyList(paramList)) {
      return;
    }
    Collections.sort(paramList, new TAVBaseMixFilter.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.filter.TAVBaseMixFilter
 * JD-Core Version:    0.7.0.1
 */