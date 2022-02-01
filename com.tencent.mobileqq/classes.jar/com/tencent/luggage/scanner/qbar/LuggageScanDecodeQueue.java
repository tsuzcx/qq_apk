package com.tencent.luggage.scanner.qbar;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.luggage.scanner.camera.ScanUtil;
import com.tencent.luggage.wxa.qz.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.qbar.QBar.QBarResult;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LuggageScanDecodeQueue
{
  private static LuggageScanDecodeQueue a = new LuggageScanDecodeQueue();
  private int[] b = { 1, 2, 4, 5 };
  private int[] c = this.b;
  private Map d = new HashMap();
  private Object e = new Object();
  private ExecutorService f;
  private ExecutorService g;
  private long h;
  private LuggageScanDecodeQueue.ScanDecodeCallBack i;
  private volatile boolean j;
  private volatile boolean k;
  private int l;
  private long m = 0L;
  private a n = new a("Luggage.WxScanDecodeQueue");
  private boolean o = false;
  private long p = 1000L;
  private Runnable q = null;
  private e r = null;
  private boolean s = false;
  private int t = 2;
  private int u = 0;
  
  private void a()
  {
    if (!this.d.isEmpty())
    {
      long l1 = this.h;
      if (l1 != 0L)
      {
        o.d("Luggage.WxScanDecodeQueue", "%d decode hit cache", new Object[] { Long.valueOf(l1) });
        localObject = this.g;
        if (localObject != null)
        {
          ((ExecutorService)localObject).execute(new LuggageScanDecodeQueue.b(this, this.h));
          return;
        }
        o.b("Luggage.WxScanDecodeQueue", "decode next task, but decode thread not init yet");
        return;
      }
    }
    Object localObject = this.i;
    if (localObject != null) {
      ((LuggageScanDecodeQueue.ScanDecodeCallBack)localObject).postTakeShot(this.h, 0L);
    }
  }
  
  private boolean a(List<QBar.QBarResult> paramList)
  {
    return (this.o) && (paramList != null) && (!paramList.isEmpty()) && (paramList.size() > 1) && (this.u <= this.t);
  }
  
  private void b()
  {
    o.d("Luggage.WxScanDecodeQueue", "alvinluo onZoomStart");
    this.o = true;
    this.u = 0;
  }
  
  private void c()
  {
    synchronized (this.e)
    {
      o.d("Luggage.WxScanDecodeQueue", "alvinluo onZoomEnd");
      this.o = false;
      return;
    }
  }
  
  private void d()
  {
    o.d("Luggage.WxScanDecodeQueue", "alvinluo triggerZoomFinishTimer zoomDuration: %d", new Object[] { Long.valueOf(this.p) });
    e();
    if (this.q == null) {
      this.q = new LuggageScanDecodeQueue.1(this);
    }
    t.a(this.q, this.p);
  }
  
  private void e()
  {
    Runnable localRunnable = this.q;
    if (localRunnable != null) {
      t.b(localRunnable);
    }
  }
  
  public static LuggageScanDecodeQueue getInstance()
  {
    return a;
  }
  
  public void addDecodeTask(byte[] paramArrayOfByte, Point paramPoint, int paramInt, Rect paramRect)
  {
    synchronized (this.e)
    {
      o.e("Luggage.WxScanDecodeQueue", "%d submit crop gray", new Object[] { Long.valueOf(this.h) });
      if (this.h != 0L) {
        if (this.f != null)
        {
          if (!this.j) {
            this.f.execute(new LuggageScanDecodeQueue.a(this, this.h, paramArrayOfByte, paramPoint, paramInt, paramRect));
          }
        }
        else {
          o.b("Luggage.WxScanDecodeQueue", "add decode task, but gray thread not init yet");
        }
      }
      if ((this.o) && (this.s)) {
        this.r = new e(paramArrayOfByte, paramPoint.x, paramPoint.y, paramInt);
      }
      return;
    }
  }
  
  public int getScanFrameCount()
  {
    return this.l;
  }
  
  public void init(Context paramContext)
  {
    synchronized (this.n)
    {
      if (!this.n.a())
      {
        this.n.a(0, ScanUtil.getAiModeParam(paramContext));
        if (this.n.a()) {
          this.n.a(this.c);
        }
      }
      boolean bool;
      if ((!c.b) && (!c.a)) {
        bool = false;
      } else {
        bool = true;
      }
      this.s = bool;
      this.p = 1000L;
      this.t = 2;
      this.f = Executors.newSingleThreadExecutor();
      this.g = Executors.newSingleThreadExecutor();
      o.d("Luggage.WxScanDecodeQueue", "alvinluo initScanDecodeQueue configValue: %d, needShowSuccessFrameWhenZoom: %b, zoomDuration: %d, ignoreFrameNum: %d", new Object[] { Integer.valueOf(0), Boolean.valueOf(this.s), Long.valueOf(this.p), Integer.valueOf(this.t) });
      return;
    }
  }
  
  public void release()
  {
    o.d("Luggage.WxScanDecodeQueue", "release QBar");
    this.c = this.b;
    stopSession(this.h);
    synchronized (this.n)
    {
      this.n.c();
      synchronized (this.e)
      {
        if ((this.f != null) && (!this.f.isShutdown()))
        {
          this.f.shutdownNow();
          this.f = null;
        }
        if ((this.g != null) && (!this.g.isShutdown()))
        {
          this.g.shutdownNow();
          this.g = null;
        }
        e();
        return;
      }
    }
  }
  
  public void setReaders(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
      synchronized (this.n)
      {
        this.c = paramArrayOfInt;
        if (this.n.a()) {
          this.n.a(this.c);
        }
        return;
      }
    }
  }
  
  public void startSession(long paramLong, LuggageScanDecodeQueue.ScanDecodeCallBack paramScanDecodeCallBack)
  {
    synchronized (this.e)
    {
      this.h = paramLong;
      this.i = paramScanDecodeCallBack;
      this.l = 0;
      this.m = System.currentTimeMillis();
      return;
    }
  }
  
  public void stopSession(long paramLong)
  {
    synchronized (this.e)
    {
      if (this.h == paramLong)
      {
        this.h = 0L;
        this.l = 0;
        this.i = null;
        this.d.clear();
        this.o = false;
        this.m = 0L;
      }
      e();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.qbar.LuggageScanDecodeQueue
 * JD-Core Version:    0.7.0.1
 */