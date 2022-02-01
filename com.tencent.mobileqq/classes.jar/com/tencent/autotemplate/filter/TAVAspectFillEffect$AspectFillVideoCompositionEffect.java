package com.tencent.autotemplate.filter;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;
import com.tencent.tavkit.report.IReportable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

class TAVAspectFillEffect$AspectFillVideoCompositionEffect
  implements TAVVideoEffect.Filter, IReportable
{
  private GaosiBlurFilter hGaosiBlurFilter = new GaosiBlurFilter(true, 20);
  private MergeTextureFilter mergeTextureFilter = new MergeTextureFilter();
  private ScaleTextureFilter scaleTextureFilter = new ScaleTextureFilter();
  private HashMap<String, TextureInfo> textureMap = new HashMap();
  private GaosiBlurFilter vGaosiBlurFilter = new GaosiBlurFilter(false, 20);
  
  private TAVAspectFillEffect$AspectFillVideoCompositionEffect(TAVAspectFillEffect paramTAVAspectFillEffect) {}
  
  private CIImage applyBackgroundColor(RenderInfo paramRenderInfo, CIImage paramCIImage, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    TextureInfo localTextureInfo = getCacheTextureInfo((int)paramCIImage.getSize().width, (int)paramCIImage.getSize().height);
    paramRenderInfo = paramRenderInfo.getCiContext();
    paramRenderInfo = TAVAspectFillEffect.access$300(this.this$0, paramRenderInfo.convertImageToTexture(paramCIImage, localTextureInfo));
    this.scaleTextureFilter.scale(paramFloat1, paramFloat2, paramFloat3);
    int i = Color.parseColor(TAVAspectFillEffect.access$200(this.this$0));
    this.scaleTextureFilter.setBackgroundColor((i >> 16 & 0xFF) / 255.0F, (i >> 8 & 0xFF) / 255.0F, (i >> 0 & 0xFF) / 255.0F, 1.0F);
    paramRenderInfo = this.scaleTextureFilter.applyFilter(paramRenderInfo);
    return new CIImage(TAVAspectFillEffect.access$400(this.this$0, paramRenderInfo));
  }
  
  private CIImage applyBlurFilter(RenderInfo paramRenderInfo, CIImage paramCIImage, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    TextureInfo localTextureInfo = getCacheTextureInfo((int)paramCIImage.getSize().width, (int)paramCIImage.getSize().height);
    paramRenderInfo = paramRenderInfo.getCiContext();
    paramCIImage = TAVAspectFillEffect.access$300(this.this$0, paramRenderInfo.convertImageToTexture(paramCIImage, localTextureInfo));
    this.scaleTextureFilter.scale(paramFloat1, paramFloat2, paramFloat3);
    paramRenderInfo = this.scaleTextureFilter.applyFilter(paramCIImage);
    paramCIImage = this.hGaosiBlurFilter.applyFilter(paramCIImage);
    paramCIImage = this.vGaosiBlurFilter.applyFilter(paramCIImage);
    this.mergeTextureFilter.setOffsetX(paramFloat4);
    this.mergeTextureFilter.setOffsetY(paramFloat5);
    paramRenderInfo = this.mergeTextureFilter.mergeTexture(paramCIImage, paramRenderInfo);
    return new CIImage(TAVAspectFillEffect.access$400(this.this$0, paramRenderInfo));
  }
  
  private CIImage applyFilter(RenderInfo paramRenderInfo, CIImage paramCIImage, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    if (!TextUtils.isEmpty(TAVAspectFillEffect.access$200(this.this$0))) {
      return applyBackgroundColor(paramRenderInfo, paramCIImage, paramFloat1, paramFloat2, paramFloat3);
    }
    return applyBlurFilter(paramRenderInfo, paramCIImage, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5);
  }
  
  private TextureInfo getCacheTextureInfo(int paramInt1, int paramInt2)
  {
    String str = paramInt1 + "_" + paramInt2;
    TextureInfo localTextureInfo1 = null;
    if (this.textureMap.containsKey(str)) {
      localTextureInfo1 = (TextureInfo)this.textureMap.get(str);
    }
    TextureInfo localTextureInfo2 = localTextureInfo1;
    if (localTextureInfo1 == null)
    {
      localTextureInfo2 = CIContext.newTextureInfo(paramInt1, paramInt2);
      this.textureMap.put(str, localTextureInfo2);
    }
    return localTextureInfo2;
  }
  
  private void prepareFilter(float paramFloat1, float paramFloat2)
  {
    float f2 = 1.0F;
    this.scaleTextureFilter.setRendererWidth((int)TAVAspectFillEffect.access$100(this.this$0).width);
    this.scaleTextureFilter.setRendererHeight((int)TAVAspectFillEffect.access$100(this.this$0).height);
    this.hGaosiBlurFilter.setRendererWidth((int)TAVAspectFillEffect.access$100(this.this$0).width);
    this.hGaosiBlurFilter.setRendererHeight((int)TAVAspectFillEffect.access$100(this.this$0).height);
    this.vGaosiBlurFilter.setRendererWidth((int)TAVAspectFillEffect.access$100(this.this$0).width);
    this.vGaosiBlurFilter.setRendererHeight((int)TAVAspectFillEffect.access$100(this.this$0).height);
    this.mergeTextureFilter.setRendererWidth((int)TAVAspectFillEffect.access$100(this.this$0).width);
    this.mergeTextureFilter.setRendererHeight((int)TAVAspectFillEffect.access$100(this.this$0).height);
    if (paramFloat1 < TAVAspectFillEffect.access$100(this.this$0).width) {}
    for (float f1 = TAVAspectFillEffect.access$100(this.this$0).width / paramFloat1;; f1 = 1.0F)
    {
      if (paramFloat2 < TAVAspectFillEffect.access$100(this.this$0).height) {
        f2 = TAVAspectFillEffect.access$100(this.this$0).height / paramFloat2;
      }
      if (f1 > f2) {}
      for (;;)
      {
        paramFloat1 = (TAVAspectFillEffect.access$100(this.this$0).width - f1 * paramFloat1) / 2.0F;
        paramFloat2 = (TAVAspectFillEffect.access$100(this.this$0).height - f1 * paramFloat2) / 2.0F;
        this.hGaosiBlurFilter.scale(f1, paramFloat1, paramFloat2);
        return;
        f1 = f2;
      }
    }
  }
  
  public CIImage apply(TAVVideoEffect paramTAVVideoEffect, CIImage paramCIImage, RenderInfo paramRenderInfo)
  {
    float f1 = paramCIImage.getSize().width;
    float f2 = paramCIImage.getSize().height;
    float f4 = TAVAspectFillEffect.access$100(this.this$0).width / TAVAspectFillEffect.access$100(this.this$0).height;
    float f3 = f1 / f2;
    float f5;
    if ((f4 > 1.0F) && (f3 < 1.0F))
    {
      f4 = TAVAspectFillEffect.access$100(this.this$0).height;
      f3 = f4 * f3;
      f4 /= f2;
      f5 = (TAVAspectFillEffect.access$100(this.this$0).width - f3) / 2.0F;
      f3 = (TAVAspectFillEffect.access$100(this.this$0).width - f3) / 2.0F / TAVAspectFillEffect.access$100(this.this$0).width;
      prepareFilter(f1, f2);
      return applyFilter(paramRenderInfo, paramCIImage, f4, f5, 0.0F, f3, 0.0F);
    }
    if ((f4 < 1.0F) && (f3 > 1.0F))
    {
      f4 = TAVAspectFillEffect.access$100(this.this$0).width;
      f3 = f4 / f3;
      f4 /= f1;
      f5 = (TAVAspectFillEffect.access$100(this.this$0).height - f3) / 2.0F;
      f3 = (TAVAspectFillEffect.access$100(this.this$0).height - f3) / 2.0F / TAVAspectFillEffect.access$100(this.this$0).height;
      prepareFilter(f1, f2);
      return applyFilter(paramRenderInfo, paramCIImage, f4, 0.0F, f5, 0.0F, f3);
    }
    return paramCIImage;
  }
  
  public String getReportKey()
  {
    return this.this$0.reportKey;
  }
  
  public void release()
  {
    if (this.hGaosiBlurFilter != null) {
      this.hGaosiBlurFilter.release();
    }
    if (this.vGaosiBlurFilter != null) {
      this.vGaosiBlurFilter.release();
    }
    if (this.scaleTextureFilter != null) {
      this.scaleTextureFilter.release();
    }
    if (this.mergeTextureFilter != null) {
      this.mergeTextureFilter.release();
    }
    if (this.textureMap != null)
    {
      Iterator localIterator = this.textureMap.values().iterator();
      while (localIterator.hasNext()) {
        ((TextureInfo)localIterator.next()).release();
      }
      this.textureMap.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.autotemplate.filter.TAVAspectFillEffect.AspectFillVideoCompositionEffect
 * JD-Core Version:    0.7.0.1
 */