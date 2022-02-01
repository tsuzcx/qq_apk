package com.tencent.av.qavperf.manager;

import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.qavperf.QAVPLogger;
import com.tencent.av.qavperf.report.QAVPReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QAVPMemoryManager
  implements Handler.Callback
{
  private final Handler a;
  private final Handler b;
  private final List<Integer> c = new ArrayList();
  private final List<Float> d = new ArrayList();
  private int e;
  private int f;
  private QAVPMemoryManager.Status g = QAVPMemoryManager.Status.IDLE;
  private VideoAppInterface h;
  private SessionInfo i;
  private volatile boolean j;
  
  public QAVPMemoryManager(VideoAppInterface paramVideoAppInterface)
  {
    this.h = paramVideoAppInterface;
    this.a = new Handler(QAVPThreadManager.a(), this);
    this.b = new Handler(QAVPThreadManager.a(), this);
  }
  
  private void a()
  {
    b();
    c();
  }
  
  private boolean a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat2 - paramFloat3 > paramFloat1 * 0.85F;
  }
  
  private void b()
  {
    if (this.g == QAVPMemoryManager.Status.RUNNING) {
      this.a.sendEmptyMessageDelayed(17, 10000L);
    }
  }
  
  private void c()
  {
    if (this.g == QAVPMemoryManager.Status.RUNNING) {
      this.b.sendEmptyMessageDelayed(34, 60000L);
    }
  }
  
  private void c(SessionInfo paramSessionInfo)
  {
    f();
    g();
    d(paramSessionInfo);
  }
  
  private void d()
  {
    this.j = true;
  }
  
  private void d(SessionInfo paramSessionInfo)
  {
    QAVPReport.a(new QAVPMemoryManager.1(this, paramSessionInfo));
  }
  
  private void e()
  {
    int k;
    StringBuilder localStringBuilder;
    if ((this.g == QAVPMemoryManager.Status.RUNNING) && (this.c.size() < 750))
    {
      try
      {
        Debug.MemoryInfo localMemoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(localMemoryInfo);
        k = localMemoryInfo.getTotalPss() / 1024;
        try
        {
          this.c.add(Integer.valueOf(k));
        }
        catch (Throwable localThrowable1) {}
        localStringBuilder = new StringBuilder();
      }
      catch (Throwable localThrowable2)
      {
        k = 0;
      }
      localStringBuilder.append("get memory value fail:");
      localStringBuilder.append(localThrowable2.getMessage());
      QAVPLogger.b(localStringBuilder.toString());
    }
    else
    {
      k = 0;
    }
    float f4 = 0.0F;
    float f3 = 0.0F;
    float f1 = f3;
    float f2;
    try
    {
      float f5 = (float)Runtime.getRuntime().maxMemory() / 1024.0F;
      f1 = f3;
      float f6 = (float)Runtime.getRuntime().totalMemory() / 1024.0F;
      f1 = f3;
      float f7 = (float)Runtime.getRuntime().freeMemory() / 1024.0F;
      f1 = f3;
      if (a(f5, f6, f7))
      {
        f1 = f3;
        this.e += 1;
      }
      f1 = f3;
      f2 = f4;
      if (this.g == QAVPMemoryManager.Status.RUNNING)
      {
        f1 = f3;
        f2 = f4;
        if (this.d.size() < 750)
        {
          f1 = f3;
          f2 = (f6 - f7) / f5;
          f1 = f2;
          this.d.add(Float.valueOf(f2));
        }
      }
    }
    catch (Throwable localThrowable3)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("get memory percent fail:");
      localStringBuilder.append(localThrowable3.getMessage());
      QAVPLogger.b(localStringBuilder.toString());
      f2 = f1;
    }
    if ((this.g == QAVPMemoryManager.Status.RUNNING) && (this.j))
    {
      int m = this.f;
      if (m < 10)
      {
        this.f = (m + 1);
        HashMap localHashMap = new HashMap();
        localHashMap.put("sample_type", "memory");
        localHashMap.put("mem_value", String.valueOf(k));
        localHashMap.put("mem_ratio", String.valueOf(f2));
        QAVPReport.a(this.h, this.i, localHashMap);
        this.j = false;
      }
    }
  }
  
  private void f()
  {
    Handler localHandler = this.a;
    if (localHandler != null) {
      localHandler.removeMessages(17);
    }
  }
  
  private void g()
  {
    if (this.a != null) {
      this.b.removeMessages(34);
    }
  }
  
  private void h()
  {
    this.j = false;
    this.c.clear();
    this.d.clear();
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    if (this.g == QAVPMemoryManager.Status.RUNNING) {
      return;
    }
    this.g = QAVPMemoryManager.Status.RUNNING;
    this.i = paramSessionInfo;
    a();
    QAVPLogger.a("start record memory");
  }
  
  public void b(SessionInfo paramSessionInfo)
  {
    if (this.g == QAVPMemoryManager.Status.IDLE) {
      return;
    }
    this.g = QAVPMemoryManager.Status.IDLE;
    c(paramSessionInfo);
    QAVPLogger.a("finish record memory");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int k = paramMessage.what;
    if (k != 17)
    {
      if (k == 34)
      {
        d();
        c();
      }
    }
    else
    {
      e();
      b();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.qavperf.manager.QAVPMemoryManager
 * JD-Core Version:    0.7.0.1
 */