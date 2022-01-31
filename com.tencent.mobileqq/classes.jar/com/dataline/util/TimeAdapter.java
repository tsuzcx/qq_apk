package com.dataline.util;

import android.widget.BaseAdapter;
import java.util.HashMap;
import java.util.Map;

public abstract class TimeAdapter
  extends BaseAdapter
{
  long jdField_a_of_type_Long = 0L;
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public abstract int a();
  
  public abstract long a(int paramInt);
  
  public boolean a(long paramLong)
  {
    return this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong));
  }
  
  public abstract long b(int paramInt);
  
  public void b()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilMap.clear();
    int j = a();
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        long l = a(i);
        if (l > this.jdField_a_of_type_Long + 180L)
        {
          this.jdField_a_of_type_Long = l;
          this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(b(i)), Long.valueOf(this.jdField_a_of_type_Long));
        }
        i += 1;
      }
    }
  }
  
  public void c()
  {
    int i = a();
    if (i == 0) {}
    long l;
    do
    {
      return;
      l = a(i - 1);
    } while (l <= this.jdField_a_of_type_Long + 180L);
    this.jdField_a_of_type_Long = l;
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(b(i - 1)), Long.valueOf(this.jdField_a_of_type_Long));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.dataline.util.TimeAdapter
 * JD-Core Version:    0.7.0.1
 */