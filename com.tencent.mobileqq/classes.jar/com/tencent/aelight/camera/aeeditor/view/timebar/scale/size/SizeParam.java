package com.tencent.aelight.camera.aeeditor.view.timebar.scale.size;

public abstract class SizeParam
{
  protected float a;
  
  public SizeParam(float paramFloat)
  {
    this.a = paramFloat;
  }
  
  public abstract float a(long paramLong);
  
  public abstract long a(float paramFloat);
  
  public abstract String b(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.timebar.scale.size.SizeParam
 * JD-Core Version:    0.7.0.1
 */