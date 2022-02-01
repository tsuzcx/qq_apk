package com.tencent.autotemplate.filter;

import android.graphics.Matrix;
import android.opengl.GLES20;
import com.tencent.taveffect.core.CacheTextureFilter;
import com.tencent.taveffect.core.TAVRectangle;
import com.tencent.taveffect.core.TAVTextureInfo;

public class ScaleTextureFilter
  extends CacheTextureFilter
{
  private float blue = 0.0F;
  private float colorAlpha = 1.0F;
  private float green = 0.0F;
  private float red = 0.0F;
  
  public void onDraw(TAVTextureInfo paramTAVTextureInfo)
  {
    GLES20.glClearColor(this.red, this.green, this.blue, this.colorAlpha);
    GLES20.glClear(16384);
    super.onDraw(paramTAVTextureInfo);
  }
  
  public void scale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.xyMatrix == null) {
      this.xyMatrix = new Matrix();
    }
    this.xyMatrix.reset();
    this.xyMatrix.setScale(paramFloat1, paramFloat1);
    this.xyMatrix.postTranslate(paramFloat2, paramFloat3);
  }
  
  public void setBackgroundColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.red = paramFloat1;
    this.green = paramFloat2;
    this.blue = paramFloat3;
    this.colorAlpha = paramFloat4;
  }
  
  public void setParams(Matrix paramMatrix1, Matrix paramMatrix2, TAVRectangle paramTAVRectangle, float paramFloat)
  {
    this.xyMatrix = paramMatrix1;
    this.stMatrix = paramMatrix2;
    this.cropRect = paramTAVRectangle;
    this.alpha = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.autotemplate.filter.ScaleTextureFilter
 * JD-Core Version:    0.7.0.1
 */