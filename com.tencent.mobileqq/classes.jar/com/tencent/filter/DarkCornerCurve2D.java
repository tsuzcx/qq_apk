package com.tencent.filter;

public class DarkCornerCurve2D
  extends BaseFilter
{
  float gradEnd;
  float gradStart;
  float[] trans_mat = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  
  public DarkCornerCurve2D(float[] paramArrayOfFloat, float paramFloat1, float paramFloat2)
  {
    super(GLSLRender.FILTER_DARKCORNER_CURVE);
    this.trans_mat = ((float[])paramArrayOfFloat.clone());
    this.gradStart = paramFloat1;
    this.gradEnd = paramFloat2;
    addParam(new Param.FloatsParam("colorMat", this.trans_mat));
    addParam(new Param.FloatParam("gradStart", paramFloat1));
    addParam(new Param.FloatParam("gradEnd", paramFloat2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.DarkCornerCurve2D
 * JD-Core Version:    0.7.0.1
 */