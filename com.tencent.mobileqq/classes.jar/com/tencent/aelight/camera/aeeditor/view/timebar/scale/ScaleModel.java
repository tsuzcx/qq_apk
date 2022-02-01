package com.tencent.aelight.camera.aeeditor.view.timebar.scale;

public class ScaleModel
{
  private long a;
  private long b;
  private int c;
  private int d;
  private int e;
  private float f;
  private float g;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ScaleModel{mStartValue=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mEndValue=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mCurrSizeParamIndex=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mMaxSpace=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mMinSpace=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", mPixelsPerScaler=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", mCoursePosition=");
    localStringBuilder.append(this.g);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.timebar.scale.ScaleModel
 * JD-Core Version:    0.7.0.1
 */