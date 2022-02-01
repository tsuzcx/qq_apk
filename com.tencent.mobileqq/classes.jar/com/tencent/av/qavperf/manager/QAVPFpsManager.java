package com.tencent.av.qavperf.manager;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import androidx.annotation.NonNull;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.qavperf.QAVPLogger;
import com.tencent.av.qavperf.QAVPUtils;
import com.tencent.av.qavperf.fps.QAVPFpsDrawImpl;
import com.tencent.av.qavperf.report.QAVPReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@TargetApi(16)
public class QAVPFpsManager
  implements Handler.Callback, Choreographer.FrameCallback
{
  private long a = 0L;
  private long b = 0L;
  private float c;
  private final Handler d;
  private final Handler e;
  private final List<Integer> f = new ArrayList();
  private final List<Float> g = new ArrayList();
  private final List<Float> h = new ArrayList();
  private int i = 0;
  private int j;
  private int k;
  private boolean l;
  private QAVPFpsManager.Status m = QAVPFpsManager.Status.IDLE;
  private SessionInfo n;
  private final VideoAppInterface o;
  private final QAVPFpsDrawImpl p;
  
  public QAVPFpsManager(VideoAppInterface paramVideoAppInterface)
  {
    this.o = paramVideoAppInterface;
    this.p = QAVPFpsDrawImpl.b();
    this.d = new Handler(QAVPThreadManager.b(), this);
    this.e = new Handler(QAVPThreadManager.b(), this);
  }
  
  private float a(int paramInt, float paramFloat)
  {
    if (paramFloat == 0.0F) {
      return 0.0F;
    }
    paramFloat /= paramInt;
    if ((this.m == QAVPFpsManager.Status.RUNNING) && (this.h.size() < 1440) && (paramFloat >= 1.0F)) {
      this.h.add(Float.valueOf(paramFloat));
    }
    if (paramFloat > 4.0F) {
      this.k += 1;
    }
    return paramFloat;
  }
  
  private void a()
  {
    if (this.m == QAVPFpsManager.Status.RUNNING) {
      this.d.sendEmptyMessageDelayed(17, 5000L);
    }
  }
  
  private void b()
  {
    if (this.m == QAVPFpsManager.Status.RUNNING) {
      this.e.sendEmptyMessageDelayed(34, 60000L);
    }
  }
  
  private void c()
  {
    this.l = true;
  }
  
  private void c(SessionInfo paramSessionInfo)
  {
    QAVPReport.a(new QAVPFpsManager.1(this, paramSessionInfo));
  }
  
  private void d()
  {
    long l1 = this.a;
    if (l1 == 0L)
    {
      this.a = this.b;
      return;
    }
    float f1 = (float)(this.b - l1) / 1.0E+009F;
    if ((this.i <= 0) && (f1 <= 0.0F)) {
      return;
    }
    int i1 = (int)(this.i / f1);
    f1 = this.p.c() / f1;
    this.a = this.b;
    if ((this.m == QAVPFpsManager.Status.RUNNING) && (this.f.size() < 1440)) {
      this.f.add(Integer.valueOf(i1));
    }
    if ((this.m == QAVPFpsManager.Status.RUNNING) && (this.g.size() < 1440)) {
      this.g.add(Float.valueOf(f1));
    }
    float f2 = a(i1, this.c);
    if (this.l)
    {
      int i2 = this.j;
      if (i2 < 10)
      {
        this.j = (i2 + 1);
        HashMap localHashMap = new HashMap();
        localHashMap.put("sample_type", "fps");
        localHashMap.put("fps_draw", String.valueOf(f1));
        localHashMap.put("fps_value", String.valueOf(i1));
        localHashMap.put("fps_ratio", String.valueOf(f2));
        QAVPReport.a(this.o, this.n, localHashMap);
        this.l = false;
      }
    }
    this.i = 0;
    this.p.d();
  }
  
  private void e()
  {
    Handler localHandler = this.d;
    if (localHandler != null) {
      localHandler.removeMessages(17);
    }
  }
  
  private void f()
  {
    Handler localHandler = this.e;
    if (localHandler != null) {
      localHandler.removeMessages(34);
    }
  }
  
  private void g()
  {
    this.l = false;
    this.f.clear();
    this.h.clear();
    this.g.clear();
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    if (this.m == QAVPFpsManager.Status.RUNNING) {
      return;
    }
    this.m = QAVPFpsManager.Status.RUNNING;
    this.n = paramSessionInfo;
    this.c = QAVPUtils.a(this.o.getApp());
    this.a = System.nanoTime();
    a();
    b();
    Choreographer.getInstance().postFrameCallback(this);
    QAVPLogger.a("start record fps");
    this.p.d();
  }
  
  public void b(SessionInfo paramSessionInfo)
  {
    if (this.m == QAVPFpsManager.Status.IDLE) {
      return;
    }
    this.m = QAVPFpsManager.Status.IDLE;
    Choreographer.getInstance().removeFrameCallback(this);
    e();
    f();
    c(paramSessionInfo);
    QAVPLogger.a("finish record fps");
  }
  
  public void doFrame(long paramLong)
  {
    this.i += 1;
    this.b = paramLong;
    Choreographer.getInstance().postFrameCallback(this);
  }
  
  public boolean handleMessage(@NonNull Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 17)
    {
      if (i1 == 34)
      {
        c();
        b();
      }
    }
    else
    {
      d();
      a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.qavperf.manager.QAVPFpsManager
 * JD-Core Version:    0.7.0.1
 */