package com.tencent.aelight.camera.aeeditor.view.timebar.scale.size;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class FrameSizeParam
  extends SizeParam
{
  private SimpleDateFormat b = new SimpleDateFormat("mm:ss", Locale.US);
  private int c = 30;
  
  public FrameSizeParam(float paramFloat)
  {
    super(paramFloat);
  }
  
  public float a(long paramLong)
  {
    long l = paramLong / 1000L;
    return (float)(l * this.c) / this.a + (float)(paramLong - 1000L * l) / (1000.0F / this.c) / this.a;
  }
  
  public long a(float paramFloat)
  {
    return Math.round(paramFloat * this.a * 1000.0F / this.c);
  }
  
  public String b(long paramLong)
  {
    int i = Math.round((float)(paramLong % 1000L) / (1000.0F / this.c));
    if ((i != this.c) && (i != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("f");
      return localStringBuilder.toString();
    }
    return this.b.format(Long.valueOf(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.timebar.scale.size.FrameSizeParam
 * JD-Core Version:    0.7.0.1
 */