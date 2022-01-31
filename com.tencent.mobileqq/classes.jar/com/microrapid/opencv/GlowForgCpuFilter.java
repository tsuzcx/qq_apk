package com.microrapid.opencv;

import android.graphics.Bitmap;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.view.RendererUtils;
import java.util.Map;

public class GlowForgCpuFilter
  extends BaseFilter
{
  float alpha = 1.0F;
  int color = 0;
  int grayVal = 0;
  Bitmap imagebitmap = null;
  int paramTEXTRUEID = 0;
  int radius = 0;
  int type = 0;
  int width = 0;
  int xOffset = 0;
  int yOffset = 0;
  
  public GlowForgCpuFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.paramTEXTRUEID = RendererUtils.createTexture();
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void ClearGLSL()
  {
    if (this.imagebitmap != null)
    {
      this.imagebitmap.recycle();
      this.imagebitmap = null;
    }
    RendererUtils.clearTexture(this.paramTEXTRUEID);
    super.ClearGLSL();
  }
  
  public void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    Bitmap localBitmap = RendererUtils.saveTexture(paramInt1, paramInt2, paramInt3);
    if (localBitmap == null) {
      return;
    }
    QImage localQImage = QImage.BindBitmap(localBitmap);
    switch (this.type)
    {
    }
    for (;;)
    {
      GLSLRender.nativeTextImage(localQImage, this.paramTEXTRUEID);
      localQImage.UnBindBitmap(localBitmap);
      localQImage.Dispose();
      return;
      OpencvAlgorithm.nativeGlowFilterGlow(localQImage, this.color, this.radius, this.alpha);
      continue;
      OpencvAlgorithm.nativeGlowFilterPolyFit(localQImage, this.imagebitmap, this.width, this.alpha);
      continue;
      OpencvAlgorithm.nativeGlowFilterDropShadow(localQImage, this.xOffset, this.yOffset, this.grayVal, this.alpha);
    }
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    return super.renderTexture(this.paramTEXTRUEID, paramInt2, paramInt3);
  }
  
  public void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("pstbitmap")) {
      this.imagebitmap = ((Bitmap)paramMap.get("pstbitmap"));
    }
    if (paramMap.containsKey("effectIndex")) {
      this.type = ((Integer)paramMap.get("effectIndex")).intValue();
    }
    if (paramMap.containsKey("color")) {
      this.color = ((Integer)paramMap.get("color")).intValue();
    }
    if (paramMap.containsKey("radius")) {
      this.radius = ((Integer)paramMap.get("radius")).intValue();
    }
    if (paramMap.containsKey("width")) {
      this.width = ((Integer)paramMap.get("width")).intValue();
    }
    if (paramMap.containsKey("alpha")) {
      this.alpha = ((Float)paramMap.get("alpha")).floatValue();
    }
    if (paramMap.containsKey("xOffset")) {
      this.xOffset = ((Integer)paramMap.get("xOffset")).intValue();
    }
    if (paramMap.containsKey("yOffset")) {
      this.yOffset = ((Integer)paramMap.get("yOffset")).intValue();
    }
    if (paramMap.containsKey("grayVal")) {
      this.grayVal = ((Integer)paramMap.get("grayVal")).intValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.microrapid.opencv.GlowForgCpuFilter
 * JD-Core Version:    0.7.0.1
 */