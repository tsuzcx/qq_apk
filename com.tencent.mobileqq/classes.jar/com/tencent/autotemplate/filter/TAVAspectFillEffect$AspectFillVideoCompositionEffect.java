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
    this.scaleTextureFilter.scale(paramFloat1, Math.round(paramFloat2), Math.round(paramFloat3));
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
  
  private void prepareFilter(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    float f = 0.0F;
    this.scaleTextureFilter.setRendererWidth((int)TAVAspectFillEffect.access$100(this.this$0).width);
    this.scaleTextureFilter.setRendererHeight((int)TAVAspectFillEffect.access$100(this.this$0).height);
    this.hGaosiBlurFilter.setRendererWidth((int)TAVAspectFillEffect.access$100(this.this$0).width);
    this.hGaosiBlurFilter.setRendererHeight((int)TAVAspectFillEffect.access$100(this.this$0).height);
    this.vGaosiBlurFilter.setRendererWidth((int)TAVAspectFillEffect.access$100(this.this$0).width);
    this.vGaosiBlurFilter.setRendererHeight((int)TAVAspectFillEffect.access$100(this.this$0).height);
    this.mergeTextureFilter.setRendererWidth((int)TAVAspectFillEffect.access$100(this.this$0).width);
    this.mergeTextureFilter.setRendererHeight((int)TAVAspectFillEffect.access$100(this.this$0).height);
    if (paramBoolean)
    {
      paramFloat3 = -(TAVAspectFillEffect.access$100(this.this$0).height / paramFloat4 * TAVAspectFillEffect.access$100(this.this$0).width - TAVAspectFillEffect.access$100(this.this$0).width) / 2.0F;
      paramFloat1 = TAVAspectFillEffect.access$100(this.this$0).height / paramFloat2;
      paramFloat2 = f;
    }
    for (;;)
    {
      this.hGaosiBlurFilter.scale(paramFloat1, paramFloat3, paramFloat2);
      return;
      paramFloat2 = -(TAVAspectFillEffect.access$100(this.this$0).width / paramFloat3 * TAVAspectFillEffect.access$100(this.this$0).height - TAVAspectFillEffect.access$100(this.this$0).height) / 2.0F;
      paramFloat1 = TAVAspectFillEffect.access$100(this.this$0).width / paramFloat1;
      paramFloat3 = 0.0F;
    }
  }
  
  public CIImage apply(TAVVideoEffect paramTAVVideoEffect, CIImage paramCIImage, RenderInfo paramRenderInfo)
  {
    float f4 = 0.0F;
    float f1 = paramCIImage.getSize().width;
    float f6 = paramCIImage.getSize().height;
    float f2 = TAVAspectFillEffect.access$100(this.this$0).width / TAVAspectFillEffect.access$100(this.this$0).height;
    float f3 = f1 / f6;
    if (f3 == f2) {
      return paramCIImage;
    }
    float f5;
    if (f3 > f2)
    {
      f2 = TAVAspectFillEffect.access$100(this.this$0).width;
      float f7 = f2 / f3;
      f3 = (TAVAspectFillEffect.access$100(this.this$0).height - f7) / 2.0F;
      f5 = (TAVAspectFillEffect.access$100(this.this$0).height - f7) / 2.0F / TAVAspectFillEffect.access$100(this.this$0).height;
      prepareFilter(f1, f6, f2, f7, true);
      f1 = (TAVAspectFillEffect.access$100(this.this$0).height - Math.round(f3) * 2) * 1.0F / f6;
      f2 = 0.0F;
    }
    for (;;)
    {
      return applyFilter(paramRenderInfo, paramCIImage, f1, f2, f3, f4, f5);
      f5 = TAVAspectFillEffect.access$100(this.this$0).height;
      f3 = f5 * f3;
      f2 = (TAVAspectFillEffect.access$100(this.this$0).width - f3) / 2.0F;
      f4 = (TAVAspectFillEffect.access$100(this.this$0).width - f3) / 2.0F / TAVAspectFillEffect.access$100(this.this$0).width;
      prepareFilter(f1, f6, f3, f5, false);
      f1 = (TAVAspectFillEffect.access$100(this.this$0).width - Math.round(f2) * 2) * 1.0F / f1;
      f3 = 0.0F;
      f5 = 0.0F;
    }
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