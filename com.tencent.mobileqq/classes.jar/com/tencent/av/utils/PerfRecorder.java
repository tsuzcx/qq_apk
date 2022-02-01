package com.tencent.av.utils;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class PerfRecorder
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private final ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
  private final HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  private boolean jdField_a_of_type_Boolean;
  private final long[] jdField_a_of_type_ArrayOfLong;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private final HashMap<String, Long> jdField_b_of_type_JavaUtilHashMap = new HashMap(10);
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private final long d;
  
  public PerfRecorder(int paramInt)
  {
    boolean bool = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_ArrayOfLong = new long[20];
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    if (AudioHelper.a(34) == 1) {
      bool = true;
    }
    this.jdField_a_of_type_Boolean = bool;
    Arrays.fill(this.jdField_a_of_type_ArrayOfLong, 0L);
    if (paramInt >= 7) {
      this.d = 30L;
    } else if (paramInt >= 4) {
      this.d = 48L;
    } else {
      this.d = 66L;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("logPerfData[");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append("], machineLevel[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], frameCostLine[");
      localStringBuilder.append(this.d);
      localStringBuilder.append("]");
      QLog.i("PerfRecorder", 2, localStringBuilder.toString());
    }
  }
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("endOfOneChat, frameAvgCost[");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append("], frameCount[");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("], frameTotalCost[");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append("], frameAvgCost2[");
    int i = this.jdField_a_of_type_Int;
    long l;
    if (i > 0) {
      l = this.jdField_b_of_type_Long / i;
    } else {
      l = 0L;
    }
    localStringBuilder.append(l);
    localStringBuilder.append("], frameCostLine[");
    localStringBuilder.append(this.d);
    localStringBuilder.append("], frameCostOverLineCnt[");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("], frameCostOverLine[");
    i = this.jdField_a_of_type_Int;
    float f;
    if (i > 0) {
      f = this.jdField_b_of_type_Int / i;
    } else {
      f = 0.0F;
    }
    localStringBuilder.append(f);
    localStringBuilder.append("], {");
    long[] arrayOfLong = this.jdField_a_of_type_ArrayOfLong;
    int j = arrayOfLong.length;
    i = 0;
    while (i < j)
    {
      localStringBuilder.append(arrayOfLong[i]);
      localStringBuilder.append(",");
      i += 1;
    }
    localStringBuilder.append("}");
    QLog.i("PerfRecorder", 2, localStringBuilder.toString());
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    Arrays.fill(this.jdField_a_of_type_ArrayOfLong, 0L);
    this.jdField_c_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
  }
  
  public void a(long paramLong)
  {
    long l3 = SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long;
    this.jdField_a_of_type_Int += 1;
    this.jdField_b_of_type_Long += l3;
    long l1 = this.jdField_c_of_type_Long;
    if (l1 == 0L) {
      this.jdField_c_of_type_Long = l3;
    } else {
      this.jdField_c_of_type_Long = ((l1 + l3) / 2L);
    }
    Object localObject = this.jdField_a_of_type_ArrayOfLong;
    int i = this.jdField_c_of_type_Int;
    if (l3 > localObject[i]) {
      localObject[i] = l3;
    }
    l1 = this.jdField_a_of_type_ArrayOfLong[this.jdField_c_of_type_Int];
    i = 0;
    for (;;)
    {
      localObject = this.jdField_a_of_type_ArrayOfLong;
      if (i >= localObject.length) {
        break;
      }
      long l2 = l1;
      if (localObject[i] < l1)
      {
        l2 = localObject[i];
        this.jdField_c_of_type_Int = i;
      }
      i += 1;
      l1 = l2;
    }
    if (l3 > this.d) {
      this.jdField_b_of_type_Int += 1;
    }
    this.jdField_b_of_type_JavaUtilHashMap.clear();
    if ((this.jdField_a_of_type_Boolean) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder(500);
      ((StringBuilder)localObject).append("frameEnd, frameIndex: ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", curFrameCost: ");
      ((StringBuilder)localObject).append(l3);
      ((StringBuilder)localObject).append(", frameCount: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(", frameTotalCost: ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Long);
      ((StringBuilder)localObject).append(", stepCost{");
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Long localLong = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(str);
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(" : ");
        ((StringBuilder)localObject).append(localLong);
        ((StringBuilder)localObject).append(", ");
      }
      ((StringBuilder)localObject).append("}, ");
      QLog.i("PerfRecorder", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_b_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(SystemClock.elapsedRealtime()));
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
  }
  
  public void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Long localLong = (Long)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
      if (localLong != null) {
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(SystemClock.elapsedRealtime() - localLong.longValue()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.PerfRecorder
 * JD-Core Version:    0.7.0.1
 */