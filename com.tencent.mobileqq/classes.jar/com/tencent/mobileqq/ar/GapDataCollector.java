package com.tencent.mobileqq.ar;

import java.util.ArrayList;
import java.util.Arrays;

public class GapDataCollector
{
  private int jdField_a_of_type_Int;
  private ArrayList<Long> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int b;
  
  public GapDataCollector(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private int a(float paramFloat)
  {
    if ((paramFloat <= 1.0F) && (paramFloat > 0.0F))
    {
      int j = (int)(paramFloat * this.jdField_a_of_type_JavaUtilArrayList.size() - 1.0F);
      int i = j;
      if (j < 0) {
        i = 0;
      }
      return i;
    }
    throw new IndexOutOfBoundsException("the percent out of index");
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public GapDataCollector.RefreshData a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)
      {
        localObject1 = new GapDataCollector.RefreshData(-1L, -1L, -1L, -1L, -1L, -1.0D, null, 0);
        return localObject1;
      }
      Object localObject1 = new long[this.jdField_a_of_type_JavaUtilArrayList.size()];
      int j = 0;
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject1[i] = ((Long)this.jdField_a_of_type_JavaUtilArrayList.get(i)).longValue();
        i += 1;
      }
      Arrays.sort((long[])localObject1);
      long l2 = localObject1[a(0.9F)];
      long l3 = localObject1[a(0.8F)];
      long l4 = localObject1[a(0.7F)];
      long l5 = localObject1[0];
      long l1 = localObject1[(localObject1.length - 1)];
      double d1 = 0.0D;
      i = j;
      while (i < localObject1.length)
      {
        d2 = localObject1[i];
        Double.isNaN(d2);
        d1 += d2;
        i += 1;
      }
      double d2 = localObject1.length;
      Double.isNaN(d2);
      return new GapDataCollector.RefreshData(l2, l3, l4, l5, l1, d1 / d2, (long[])localObject1, this.b);
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.GapDataCollector
 * JD-Core Version:    0.7.0.1
 */