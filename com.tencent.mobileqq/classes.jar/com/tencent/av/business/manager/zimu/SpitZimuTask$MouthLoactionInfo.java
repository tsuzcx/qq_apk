package com.tencent.av.business.manager.zimu;

import android.graphics.PointF;

public class SpitZimuTask$MouthLoactionInfo
{
  long jdField_a_of_type_Long;
  PointF jdField_a_of_type_AndroidGraphicsPointF = null;
  boolean jdField_a_of_type_Boolean = false;
  
  public void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPointF = null;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(PointF paramPointF)
  {
    this.jdField_a_of_type_AndroidGraphicsPointF = paramPointF;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Boolean) {}
    while (System.currentTimeMillis() - this.jdField_a_of_type_Long <= 1500L) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.business.manager.zimu.SpitZimuTask.MouthLoactionInfo
 * JD-Core Version:    0.7.0.1
 */