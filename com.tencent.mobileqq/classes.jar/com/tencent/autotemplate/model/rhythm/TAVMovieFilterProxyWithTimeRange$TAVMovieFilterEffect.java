package com.tencent.autotemplate.model.rhythm;

import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.taveffect.effects.BaseEffect;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;

class TAVMovieFilterProxyWithTimeRange$TAVMovieFilterEffect
  implements TAVVideoEffect.Filter
{
  private TextureInfo cacheTextureInfo;
  private BaseEffect mEffect = TAVMovieFilterProxyWithTimeRange.access$000(this.this$0);
  
  public TAVMovieFilterProxyWithTimeRange$TAVMovieFilterEffect(TAVMovieFilterProxyWithTimeRange paramTAVMovieFilterProxyWithTimeRange) {}
  
  @NonNull
  public CIImage apply(TAVVideoEffect paramTAVVideoEffect, CIImage paramCIImage, RenderInfo paramRenderInfo)
  {
    if ((TAVMovieFilterProxyWithTimeRange.access$100(this.this$0) != null) && (!TAVMovieFilterProxyWithTimeRange.access$100(this.this$0).containsTime(paramRenderInfo.getTime()))) {}
    int i;
    int j;
    do
    {
      return paramCIImage;
      paramTAVVideoEffect = paramRenderInfo.getCiContext();
      i = (int)paramRenderInfo.getRenderSize().width;
      j = (int)paramRenderInfo.getRenderSize().height;
      if (this.mEffect != null) {
        break;
      }
      this.mEffect = TAVMovieFilterProxyWithTimeRange.access$000(this.this$0);
    } while (this.mEffect == null);
    this.mEffect.setRendererWidth(i);
    this.mEffect.setRendererHeight(j);
    if (this.cacheTextureInfo == null)
    {
      paramTAVVideoEffect.getRenderContext().makeCurrent();
      this.cacheTextureInfo = CIContext.newTextureInfo(i, j);
    }
    if ((this.cacheTextureInfo.width != i) || (this.cacheTextureInfo.height != j))
    {
      paramTAVVideoEffect.getRenderContext().makeCurrent();
      this.cacheTextureInfo.release();
      this.cacheTextureInfo = CIContext.newTextureInfo(i, j);
    }
    paramTAVVideoEffect.convertImageToTexture(paramCIImage, this.cacheTextureInfo);
    paramTAVVideoEffect = TAVMovieFilterProxyWithTimeRange.access$200(this.this$0, this.cacheTextureInfo);
    paramTAVVideoEffect = this.mEffect.applyFilter(paramTAVVideoEffect);
    paramTAVVideoEffect = TAVMovieFilterProxyWithTimeRange.access$300(this.this$0, paramTAVVideoEffect);
    paramTAVVideoEffect.setTextureMatrix(this.cacheTextureInfo.getTextureMatrix());
    return new CIImage(paramTAVVideoEffect);
  }
  
  public void release()
  {
    if (this.mEffect != null)
    {
      this.mEffect.release();
      this.mEffect = null;
    }
    if ((this.cacheTextureInfo != null) && (!this.cacheTextureInfo.isReleased())) {
      this.cacheTextureInfo.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.model.rhythm.TAVMovieFilterProxyWithTimeRange.TAVMovieFilterEffect
 * JD-Core Version:    0.7.0.1
 */