package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.RectF;
import android.text.TextPaint;

public abstract class BaseTextModel
{
  protected int a;
  protected int b;
  protected RectF c;
  protected TextPaint d;
  
  public BaseTextModel(int paramInt1, int paramInt2, TextPaint paramTextPaint, RectF paramRectF)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.d = paramTextPaint;
    this.c = paramRectF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.BaseTextModel
 * JD-Core Version:    0.7.0.1
 */