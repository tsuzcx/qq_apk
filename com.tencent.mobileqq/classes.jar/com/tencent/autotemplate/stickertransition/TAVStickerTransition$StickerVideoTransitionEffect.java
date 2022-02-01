package com.tencent.autotemplate.stickertransition;

import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoTransition;
import com.tencent.tavkit.composition.video.TAVVideoTransition.Filter;
import com.tencent.tavsticker.core.TAVStickerRenderContext;
import com.tencent.tavsticker.model.TAVSourceImage;
import com.tencent.tavsticker.model.TAVStickerTexture;
import java.util.ArrayList;
import java.util.List;

class TAVStickerTransition$StickerVideoTransitionEffect
  implements TAVVideoTransition.Filter
{
  private RenderContext renderContext;
  private TAVStickerRenderContext stickerContext;
  
  public TAVStickerTransition$StickerVideoTransitionEffect(TAVStickerTransition paramTAVStickerTransition, TAVStickerRenderContext paramTAVStickerRenderContext)
  {
    this.stickerContext = paramTAVStickerRenderContext;
  }
  
  public CIImage apply(TAVVideoTransition paramTAVVideoTransition, CIImage paramCIImage1, CIImage paramCIImage2, float paramFloat, RenderInfo paramRenderInfo)
  {
    paramTAVVideoTransition = this.stickerContext;
    if (paramTAVVideoTransition == null) {
      return paramCIImage1;
    }
    paramTAVVideoTransition.setRenderSize(paramRenderInfo.getRenderSize());
    this.renderContext = paramRenderInfo.getCiContext().getRenderContext();
    ArrayList localArrayList = new ArrayList();
    paramTAVVideoTransition = CIContext.newTextureInfo((int)paramCIImage2.getSize().width, (int)paramCIImage2.getSize().height);
    paramRenderInfo.getCiContext().convertImageToTexture(paramCIImage2, paramTAVVideoTransition);
    localArrayList.add(new TAVSourceImage(paramTAVVideoTransition, 0));
    paramCIImage2 = CIContext.newTextureInfo((int)paramCIImage1.getSize().width, (int)paramCIImage1.getSize().height);
    paramRenderInfo.getCiContext().convertImageToTexture(paramCIImage1, paramCIImage2);
    localArrayList.add(new TAVSourceImage(paramCIImage2, 1));
    paramRenderInfo = this.stickerContext.renderSticker(paramFloat, localArrayList, this.renderContext.eglContext());
    this.renderContext.makeCurrent();
    if (paramCIImage2 != null) {
      paramCIImage2.release();
    }
    if (paramTAVVideoTransition != null) {
      paramTAVVideoTransition.release();
    }
    if (paramRenderInfo != null)
    {
      try
      {
        if (paramRenderInfo.isNewFrame()) {
          this.stickerContext.getStickerTexture().awaitNewImage(1000L);
        }
      }
      catch (Exception paramTAVVideoTransition)
      {
        paramTAVVideoTransition.printStackTrace();
      }
      paramCIImage1 = new CIImage(paramRenderInfo.getTextureInfo());
    }
    return paramCIImage1;
  }
  
  public void release()
  {
    Object localObject = this.renderContext;
    if (localObject != null) {
      ((RenderContext)localObject).makeCurrent();
    }
    localObject = this.stickerContext;
    if (localObject != null)
    {
      ((TAVStickerRenderContext)localObject).release();
      this.stickerContext = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.stickertransition.TAVStickerTransition.StickerVideoTransitionEffect
 * JD-Core Version:    0.7.0.1
 */