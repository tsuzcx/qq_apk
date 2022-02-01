package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.RectF;

public class CenterMarginCoverter
  extends BaseCovert
{
  private float a;
  private float b;
  
  public CenterMarginCoverter(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  void a(int paramInt, BaseTextModel paramBaseTextModel)
  {
    float f3 = paramBaseTextModel.c.right;
    float f4 = paramBaseTextModel.c.left;
    float f1 = paramBaseTextModel.c.bottom;
    float f2 = paramBaseTextModel.c.top;
    f3 = Math.abs(f3 - f4 - this.a) / 2.0F;
    Math.abs(f1 - f2 - this.b);
    RectF localRectF = paramBaseTextModel.c;
    localRectF.left += f3;
    paramBaseTextModel = paramBaseTextModel.c;
    paramBaseTextModel.right += f3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.CenterMarginCoverter
 * JD-Core Version:    0.7.0.1
 */