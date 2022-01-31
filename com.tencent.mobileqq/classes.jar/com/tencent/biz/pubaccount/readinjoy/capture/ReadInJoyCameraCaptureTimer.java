package com.tencent.biz.pubaccount.readinjoy.capture;

import java.util.ArrayList;

public class ReadInJoyCameraCaptureTimer
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public int a()
  {
    return 600000;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = ((int)(System.currentTimeMillis() - this.jdField_a_of_type_Long) + this.jdField_a_of_type_Int);
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(this.jdField_a_of_type_Int));
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = this.jdField_a_of_type_Int + (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long); i < 600000; i = this.jdField_a_of_type_Int) {
      return i;
    }
    return 600000;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      this.jdField_a_of_type_Int = ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).intValue();
      return;
    }
    this.jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraCaptureTimer
 * JD-Core Version:    0.7.0.1
 */