package com.tencent.aelight.camera.aeeditor.view.timebar.scale.size;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class SecSizeParam
  extends SizeParam
{
  private SimpleDateFormat a;
  
  public SecSizeParam(float paramFloat)
  {
    super(paramFloat);
    this.jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("mm:ss", Locale.US);
  }
  
  public float a(long paramLong)
  {
    return (float)paramLong / 1000.0F / this.jdField_a_of_type_Float;
  }
  
  public long a(float paramFloat)
  {
    return Math.round(paramFloat * 1000.0F * this.jdField_a_of_type_Float);
  }
  
  public String a(long paramLong)
  {
    return this.jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.timebar.scale.size.SecSizeParam
 * JD-Core Version:    0.7.0.1
 */