package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.RectF;

public class LineMarginCoverter
  extends BaseCovert
{
  private int a;
  
  public LineMarginCoverter(int paramInt)
  {
    this.a = paramInt;
  }
  
  void a(int paramInt, BaseTextModel paramBaseTextModel)
  {
    RectF localRectF = paramBaseTextModel.c;
    localRectF.top += this.a * paramInt;
    paramBaseTextModel = paramBaseTextModel.c;
    paramBaseTextModel.bottom += paramInt * this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.LineMarginCoverter
 * JD-Core Version:    0.7.0.1
 */