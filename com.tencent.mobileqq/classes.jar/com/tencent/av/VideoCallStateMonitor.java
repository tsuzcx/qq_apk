package com.tencent.av;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class VideoCallStateMonitor
{
  private VideoAppInterface a;
  private String b;
  private VideoController c;
  private int d;
  private long e;
  private List<VideoCallStateMonitor.MemoryDetail> f;
  private volatile long g;
  private volatile long h;
  private long i;
  private boolean j;
  private VideoCallStateMonitor.TimerHandler k;
  private volatile int l;
  private int m;
  
  VideoCallStateMonitor(@NonNull VideoAppInterface paramVideoAppInterface, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VideoCallStateMonitor <");
      localStringBuilder.append(this);
      localStringBuilder.append("> created");
      QLog.d("VideoCallStateMonitor", 2, localStringBuilder.toString());
    }
    this.a = paramVideoAppInterface;
    this.b = paramString;
    if (TextUtils.isEmpty(this.b)) {
      this.b = "0";
    }
    this.c = VideoController.f();
    this.d = 0;
    this.e = 0L;
    this.g = 0L;
    this.h = 0L;
    this.f = new ArrayList();
    this.i = 0L;
    this.k = new VideoCallStateMonitor.TimerHandler(this);
    this.l = 0;
    this.m = 2;
  }
  
  private long a(Map<String, Integer> paramMap, String paramString)
  {
    if ((paramMap != null) && (paramMap.containsKey(paramString))) {
      return ((Integer)paramMap.get(paramString)).intValue();
    }
    return -1L;
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("begin monitor ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("VideoCallStateMonitor", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = DeviceInfoUtil.b(this.a.getApp());
    if (a((Map)localObject, "summary.total-pss") <= 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VideoCallStateMonitor", 1, "getTotalPss error!");
      }
    }
    else
    {
      a(SystemClock.uptimeMillis(), (Map)localObject);
      a(DeviceInfoUtil.r() / 1000L);
    }
    if (this.g > 0L)
    {
      long l1 = SystemClock.uptimeMillis() - this.g;
      if (l1 > 0L) {
        b(l1);
      }
    }
  }
  
  private void a(long paramLong)
  {
    if (paramLong > 0L)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("call avail mem: ");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("kb");
        QLog.d("VideoCallStateMonitor", 2, localStringBuilder.toString());
      }
      this.c.a(this.b, "availMem2", String.valueOf(paramLong));
    }
  }
  
  private void a(long paramLong, Map<String, Integer> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    this.d += 1;
    this.e += a(paramMap, "summary.total-pss");
    long l1 = this.e / this.d;
    this.c.a(this.b, "avgMemory", String.valueOf(l1));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("call avg pss: ");
      localStringBuilder.append(l1);
      localStringBuilder.append("kb");
      QLog.d("VideoCallStateMonitor", 2, localStringBuilder.toString());
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoCallStateMonitor", 2, String.format("report memory type=%s value=%sKB, time=%s", new Object[] { Integer.valueOf(d()), paramMap.toString(), Long.valueOf(paramLong) }));
    }
    this.f.add(new VideoCallStateMonitor.MemoryDetail(d(), a(paramMap, "summary.total-pss"), a(paramMap, "summary.java-heap"), a(paramMap, "summary.native-heap"), a(paramMap, "summary.code"), a(paramMap, "summary.graphics"), paramLong));
  }
  
  private void b(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("call time: ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("ms");
      QLog.d("VideoCallStateMonitor", 2, localStringBuilder.toString());
    }
    this.c.a(this.b, "callDur", String.valueOf(paramLong));
  }
  
  private void c()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("postReportMemory size = ");
      ((StringBuilder)localObject1).append(this.f.size());
      QLog.d("VideoCallStateMonitor", 2, ((StringBuilder)localObject1).toString());
    }
    int n = this.f.size();
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    if (n >= 4)
    {
      Object localObject3 = this.f;
      int i1 = n - 1 - 1;
      long l3 = ((VideoCallStateMonitor.MemoryDetail)((List)localObject3).get(i1)).b;
      long l4 = ((VideoCallStateMonitor.MemoryDetail)this.f.get(1)).b;
      long l1 = ((VideoCallStateMonitor.MemoryDetail)this.f.get(i1)).c - ((VideoCallStateMonitor.MemoryDetail)this.f.get(1)).c;
      long l2 = ((VideoCallStateMonitor.MemoryDetail)this.f.get(i1)).d - ((VideoCallStateMonitor.MemoryDetail)this.f.get(1)).d;
      n = 1;
      double d1;
      double d2;
      double d4;
      while (n < i1)
      {
        localObject3 = (VideoCallStateMonitor.MemoryDetail)this.f.get(n);
        Object localObject4 = this.f;
        n += 1;
        localObject4 = (VideoCallStateMonitor.MemoryDetail)((List)localObject4).get(n);
        if ((((VideoCallStateMonitor.MemoryDetail)localObject3).a != 0) && (((VideoCallStateMonitor.MemoryDetail)localObject3).a != ((VideoCallStateMonitor.MemoryDetail)localObject4).a)) {
          if (QLog.isColorLevel()) {
            QLog.d("VideoCallStateMonitor", 2, "postReportMemory failed, session type changed");
          }
        }
        for (;;)
        {
          n = 1;
          break label579;
          this.m = ((VideoCallStateMonitor.MemoryDetail)localObject4).a;
          if ((!((VideoCallStateMonitor.MemoryDetail)localObject3).a()) || (!((VideoCallStateMonitor.MemoryDetail)localObject4).a())) {
            break label560;
          }
          d1 = ((VideoCallStateMonitor.MemoryDetail)localObject4).g - ((VideoCallStateMonitor.MemoryDetail)localObject3).g;
          d2 = ((VideoCallStateMonitor.MemoryDetail)localObject4).b - ((VideoCallStateMonitor.MemoryDetail)localObject3).b;
          d3 = ((VideoCallStateMonitor.MemoryDetail)localObject4).c - ((VideoCallStateMonitor.MemoryDetail)localObject3).c;
          d4 = ((VideoCallStateMonitor.MemoryDetail)localObject4).d - ((VideoCallStateMonitor.MemoryDetail)localObject3).d;
          if (d1 > 0.0D) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("VideoCallStateMonitor", 2, "postReportMemory failed, timestamp fatal error");
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoCallStateMonitor", 2, String.format("total pss grow %skb, java pss grow %skb, native pss grow %skb [in %sms]", new Object[] { Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d1) }));
        }
        Double.isNaN(d2);
        Double.isNaN(d1);
        ((List)localObject1).add(Double.valueOf(d2 * 1000.0D / d1));
        Double.isNaN(d3);
        Double.isNaN(d1);
        ((List)localObject2).add(Double.valueOf(d3 * 1000.0D / d1));
        Double.isNaN(d4);
        Double.isNaN(d1);
        localArrayList.add(Double.valueOf(d4 * 1000.0D / d1));
        continue;
        label560:
        if (QLog.isColorLevel()) {
          QLog.d("VideoCallStateMonitor", 2, "postReportMemory failed, cannot get memory info");
        }
        return;
      }
      n = 0;
      label579:
      double d3 = 0.0D;
      if (n == 0)
      {
        localObject3 = ((List)localObject1).iterator();
        for (d1 = 0.0D; ((Iterator)localObject3).hasNext(); d1 += ((Double)((Iterator)localObject3).next()).doubleValue()) {}
        localObject3 = ((List)localObject2).iterator();
        for (d2 = 0.0D; ((Iterator)localObject3).hasNext(); d2 += ((Double)((Iterator)localObject3).next()).doubleValue()) {}
        localObject3 = localArrayList.iterator();
        while (((Iterator)localObject3).hasNext()) {
          d3 += ((Double)((Iterator)localObject3).next()).doubleValue();
        }
        d4 = ((List)localObject1).size();
        Double.isNaN(d4);
        d1 /= d4;
        d4 = ((List)localObject2).size();
        Double.isNaN(d4);
        d2 /= d4;
        d4 = localArrayList.size();
        Double.isNaN(d4);
        d3 /= d4;
        localObject2 = new HashMap(9);
        ((HashMap)localObject2).put("selfUin", this.a.getCurrentAccountUin());
        ((HashMap)localObject2).put("peerUin", this.b);
        ((HashMap)localObject2).put("sessionId", String.valueOf(this.i));
        ((HashMap)localObject2).put("startTimestamp", String.valueOf(this.h));
        if (this.j) {
          localObject1 = "1";
        } else {
          localObject1 = "0";
        }
        ((HashMap)localObject2).put("firstChat", localObject1);
        ((HashMap)localObject2).put("chatType", String.valueOf(this.m));
        ((HashMap)localObject2).put("device_memory", String.valueOf(DeviceInfoUtil.a() / 1024L));
        ((HashMap)localObject2).put("totalPss_growth", String.valueOf(l3 - l4));
        ((HashMap)localObject2).put("totalPss_growthRate", String.valueOf(d1));
        ((HashMap)localObject2).put("javaPss_growth", String.valueOf(l1));
        ((HashMap)localObject2).put("javaPss_growthRate", String.valueOf(d2));
        ((HashMap)localObject2).put("nativePss_growth", String.valueOf(l2));
        ((HashMap)localObject2).put("nativePss_growthRate", String.valueOf(d3));
        if (this.g > 0L) {
          localObject1 = String.valueOf(SystemClock.uptimeMillis() - this.g);
        } else {
          localObject1 = "";
        }
        ((HashMap)localObject2).put("call_dur", localObject1);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("postReportMemory success: ");
          ((StringBuilder)localObject1).append(((HashMap)localObject2).toString());
          QLog.d("VideoCallStateMonitor", 2, ((StringBuilder)localObject1).toString());
        }
        ThreadManager.post(new VideoCallStateMonitor.1(this, (HashMap)localObject2), 5, null, false);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoCallStateMonitor", 2, "postReportMemory failed, skip");
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("postReportMemory failed, node size = ");
      ((StringBuilder)localObject1).append(n);
      QLog.d("VideoCallStateMonitor", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  private int d()
  {
    int n = this.c.k().g;
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }
    if (n == 0) {
      return 0;
    }
    return 2;
  }
  
  void a()
  {
    if (this.l == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCallStateMonitor", 2, "startCallMonitor");
      }
      this.j = this.c.s;
      this.g = SystemClock.uptimeMillis();
      this.h = System.currentTimeMillis();
      this.i = this.c.p(this.b);
      this.k.a();
      this.l = 1;
      return;
    }
    QLog.e("VideoCallStateMonitor", 1, "startCallMonitor state error");
  }
  
  public void b()
  {
    if (this.l != 2)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("stopMonitor ");
        localStringBuilder.append(Log.getStackTraceString(new RuntimeException()));
        QLog.d("VideoCallStateMonitor", 2, localStringBuilder.toString());
      }
      this.l = 2;
      this.k.b();
      return;
    }
    QLog.e("VideoCallStateMonitor", 1, "stopMonitor state error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoCallStateMonitor
 * JD-Core Version:    0.7.0.1
 */