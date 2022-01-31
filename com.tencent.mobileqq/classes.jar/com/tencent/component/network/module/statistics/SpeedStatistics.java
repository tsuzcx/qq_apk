package com.tencent.component.network.module.statistics;

import com.tencent.component.network.module.statistics.common.SortedFixedLinkedList;
import java.util.Comparator;
import ppj;
import ppk;
import ppl;

public class SpeedStatistics
{
  private static final Comparator jdField_a_of_type_JavaUtilComparator = new ppj();
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private final SortedFixedLinkedList jdField_a_of_type_ComTencentComponentNetworkModuleStatisticsCommonSortedFixedLinkedList = new SortedFixedLinkedList(100, jdField_a_of_type_JavaUtilComparator, false);
  private int b = 0;
  
  private static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      return paramInt1;
    }
    return paramInt2;
  }
  
  private static long a(long paramLong1, long paramLong2)
  {
    if (paramLong1 < paramLong2) {
      return paramLong1;
    }
    return paramLong2;
  }
  
  private static long a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (paramLong3 > paramLong2) {
      return paramLong3 - paramLong2;
    }
    if (paramLong1 > paramLong4) {
      return paramLong1 - paramLong4;
    }
    return 0L;
  }
  
  public static SpeedStatistics a()
  {
    return ppk.a;
  }
  
  private void a(int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentComponentNetworkModuleStatisticsCommonSortedFixedLinkedList.size();
    if (paramInt > 0)
    {
      paramInt = a(i, paramInt);
      if (paramInt > 0) {
        break label31;
      }
    }
    label31:
    long l1;
    long l4;
    do
    {
      return;
      paramInt = i;
      break;
      ppl localppl = (ppl)this.jdField_a_of_type_ComTencentComponentNetworkModuleStatisticsCommonSortedFixedLinkedList.get(paramInt - 1);
      long l2 = localppl.b;
      l1 = localppl.c;
      long l3 = 0L;
      l4 = 0L;
      paramInt -= 1;
      while (paramInt >= 0)
      {
        localppl = (ppl)this.jdField_a_of_type_ComTencentComponentNetworkModuleStatisticsCommonSortedFixedLinkedList.get(paramInt);
        l4 += localppl.a;
        long l6 = localppl.b;
        long l5 = localppl.c;
        l3 += a(l2, l1, l6, l5);
        l2 = a(l2, l6);
        l1 = b(l1, l5);
        paramInt -= 1;
      }
      l1 = l1 - l2 - l3;
    } while (l1 <= 0L);
    double d1 = l4 / 1024.0D;
    double d2 = l1 / 1000.0D;
    if ((d1 > 0.0D) && (d2 > 0.0D)) {}
    for (float f = (float)(d1 / d2);; f = 0.0F)
    {
      this.jdField_a_of_type_Float = f;
      return;
    }
  }
  
  private boolean a()
  {
    int i = this.b;
    this.b = (i + 1);
    if (i < 2) {
      return false;
    }
    this.b = 0;
    return true;
  }
  
  private static long b(long paramLong1, long paramLong2)
  {
    if (paramLong1 > paramLong2) {
      return paramLong1;
    }
    return paramLong2;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong1 < 51200L) {
      return;
    }
    ppl localppl = new ppl();
    localppl.a = paramLong1;
    localppl.b = a(paramLong2, paramLong3);
    localppl.c = b(paramLong2, paramLong3);
    synchronized (this.jdField_a_of_type_ComTencentComponentNetworkModuleStatisticsCommonSortedFixedLinkedList)
    {
      this.jdField_a_of_type_ComTencentComponentNetworkModuleStatisticsCommonSortedFixedLinkedList.add(localppl);
      this.jdField_a_of_type_Int += 1;
      if (a()) {
        a(5);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.statistics.SpeedStatistics
 * JD-Core Version:    0.7.0.1
 */