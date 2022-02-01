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
  private final ArrayList<String> a = new ArrayList(10);
  private final HashMap<String, Long> b = new HashMap(10);
  private final HashMap<String, Long> c = new HashMap(10);
  private long d = 0L;
  private int e;
  private int f;
  private long g;
  private long h;
  private final long i;
  private final long[] j;
  private int k;
  private boolean l;
  
  public PerfRecorder(int paramInt)
  {
    boolean bool = false;
    this.e = 0;
    this.f = 0;
    this.g = 0L;
    this.h = 0L;
    this.j = new long[20];
    this.k = 0;
    this.l = false;
    if (AudioHelper.a(34) == 1) {
      bool = true;
    }
    this.l = bool;
    Arrays.fill(this.j, 0L);
    if (paramInt >= 7) {
      this.i = 30L;
    } else if (paramInt >= 4) {
      this.i = 48L;
    } else {
      this.i = 66L;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("logPerfData[");
      localStringBuilder.append(this.l);
      localStringBuilder.append("], machineLevel[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], frameCostLine[");
      localStringBuilder.append(this.i);
      localStringBuilder.append("]");
      QLog.i("PerfRecorder", 2, localStringBuilder.toString());
    }
  }
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("endOfOneChat, frameAvgCost[");
    localStringBuilder.append(this.h);
    localStringBuilder.append("], frameCount[");
    localStringBuilder.append(this.e);
    localStringBuilder.append("], frameTotalCost[");
    localStringBuilder.append(this.g);
    localStringBuilder.append("], frameAvgCost2[");
    int m = this.e;
    long l1;
    if (m > 0) {
      l1 = this.g / m;
    } else {
      l1 = 0L;
    }
    localStringBuilder.append(l1);
    localStringBuilder.append("], frameCostLine[");
    localStringBuilder.append(this.i);
    localStringBuilder.append("], frameCostOverLineCnt[");
    localStringBuilder.append(this.f);
    localStringBuilder.append("], frameCostOverLine[");
    m = this.e;
    float f1;
    if (m > 0) {
      f1 = this.f / m;
    } else {
      f1 = 0.0F;
    }
    localStringBuilder.append(f1);
    localStringBuilder.append("], {");
    long[] arrayOfLong = this.j;
    int n = arrayOfLong.length;
    m = 0;
    while (m < n)
    {
      localStringBuilder.append(arrayOfLong[m]);
      localStringBuilder.append(",");
      m += 1;
    }
    localStringBuilder.append("}");
    QLog.i("PerfRecorder", 2, localStringBuilder.toString());
    this.e = 0;
    this.g = 0L;
    this.h = 0L;
    Arrays.fill(this.j, 0L);
    this.k = 0;
    this.f = 0;
  }
  
  public void a(long paramLong)
  {
    long l3 = SystemClock.elapsedRealtime() - this.d;
    this.e += 1;
    this.g += l3;
    long l1 = this.h;
    if (l1 == 0L) {
      this.h = l3;
    } else {
      this.h = ((l1 + l3) / 2L);
    }
    Object localObject = this.j;
    int m = this.k;
    if (l3 > localObject[m]) {
      localObject[m] = l3;
    }
    l1 = this.j[this.k];
    m = 0;
    for (;;)
    {
      localObject = this.j;
      if (m >= localObject.length) {
        break;
      }
      long l2 = l1;
      if (localObject[m] < l1)
      {
        l2 = localObject[m];
        this.k = m;
      }
      m += 1;
      l1 = l2;
    }
    if (l3 > this.i) {
      this.f += 1;
    }
    this.c.clear();
    if ((this.l) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder(500);
      ((StringBuilder)localObject).append("frameEnd, frameIndex: ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", curFrameCost: ");
      ((StringBuilder)localObject).append(l3);
      ((StringBuilder)localObject).append(", frameCount: ");
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append(", frameTotalCost: ");
      ((StringBuilder)localObject).append(this.g);
      ((StringBuilder)localObject).append(", stepCost{");
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Long localLong = (Long)this.b.get(str);
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
      this.c.put(paramString, Long.valueOf(SystemClock.elapsedRealtime()));
      this.a.add(paramString);
    }
  }
  
  public void b()
  {
    this.b.clear();
    this.a.clear();
    this.d = SystemClock.elapsedRealtime();
  }
  
  public void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Long localLong = (Long)this.c.get(paramString);
      if (localLong != null) {
        this.b.put(paramString, Long.valueOf(SystemClock.elapsedRealtime() - localLong.longValue()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.PerfRecorder
 * JD-Core Version:    0.7.0.1
 */