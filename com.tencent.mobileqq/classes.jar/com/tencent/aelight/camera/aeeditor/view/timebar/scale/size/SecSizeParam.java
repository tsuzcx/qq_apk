package com.tencent.aelight.camera.aeeditor.view.timebar.scale.size;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class SecSizeParam
  extends SizeParam
{
  private SimpleDateFormat b = new SimpleDateFormat("mm:ss", Locale.US);
  
  public SecSizeParam(float paramFloat)
  {
    super(paramFloat);
  }
  
  public float a(long paramLong)
  {
    return (float)paramLong / 1000.0F / this.a;
  }
  
  public long a(float paramFloat)
  {
    return Math.round(paramFloat * 1000.0F * this.a);
  }
  
  public String b(long paramLong)
  {
    return this.b.format(Long.valueOf(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.timebar.scale.size.SecSizeParam
 * JD-Core Version:    0.7.0.1
 */