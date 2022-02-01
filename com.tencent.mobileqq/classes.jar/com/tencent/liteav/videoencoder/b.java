package com.tencent.liteav.videoencoder;

import android.os.Bundle;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.a;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.beauty.b.k;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import javax.microedition.khronos.egl.EGLContext;

public class b
  extends a
{
  private static Integer r = Integer.valueOf(1);
  private static final String u = b.class.getSimpleName();
  private static int v = 0;
  private d a = null;
  private e b = null;
  private WeakReference<com.tencent.liteav.basic.b.b> c = null;
  private int d = 0;
  private int e = 2;
  private b.a f = b.a.a;
  private Timer g = null;
  private TimerTask h = null;
  private LinkedList<Runnable> i = new LinkedList();
  private TXSVideoEncoderParam j;
  private float k = 0.0F;
  private float l = 0.0F;
  private float m = 0.0F;
  private int n = 0;
  private int o = 0;
  private com.tencent.liteav.basic.c.b p;
  private g q;
  private boolean s;
  private k t;
  
  public b(int paramInt)
  {
    this.e = paramInt;
  }
  
  private void a(int paramInt, String paramString)
  {
    Object localObject = this.c;
    if (localObject == null) {
      return;
    }
    localObject = (com.tencent.liteav.basic.b.b)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("EVT_ID", paramInt);
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    localBundle.putCharSequence("EVT_MSG", paramString);
    ((com.tencent.liteav.basic.b.b)localObject).onNotifyEvent(paramInt, localBundle);
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    Object localObject = this.c;
    if (localObject == null) {
      return;
    }
    localObject = (com.tencent.liteav.basic.b.b)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("EVT_ID", paramInt1);
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    localBundle.putCharSequence("EVT_MSG", paramString);
    localBundle.putInt("EVT_PARAM1", paramInt2);
    localBundle.putInt("EVT_STREAM_TYPE", paramInt3);
    ((com.tencent.liteav.basic.b.b)localObject).onNotifyEvent(paramInt1, localBundle);
  }
  
  private boolean a(Queue<Runnable> paramQueue)
  {
    try
    {
      if (paramQueue.isEmpty()) {
        return false;
      }
      Runnable localRunnable = (Runnable)paramQueue.poll();
      if (localRunnable == null) {
        return false;
      }
      localRunnable.run();
      return true;
    }
    finally {}
  }
  
  private void g()
  {
    if (this.h == null) {
      this.h = new b.b(this);
    }
    this.g = new Timer();
    this.g.schedule(this.h, 1000L, 1000L);
  }
  
  private void h()
  {
    Timer localTimer = this.g;
    if (localTimer != null)
    {
      localTimer.cancel();
      this.g = null;
    }
    if (this.h != null) {
      this.h = null;
    }
  }
  
  private void i()
  {
    a(new b.7(this));
    TXCLog.w("TXCVideoEncoder", "switchSWToHW");
  }
  
  public int a(TXSVideoEncoderParam paramTXSVideoEncoderParam)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public long a(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    while (a(this.i)) {}
    if (this.a != null)
    {
      setStatusValue(4002, Long.valueOf(d()));
      setStatusValue(4001, this.j.streamType, Double.valueOf(c()));
      if ((this.f == b.a.a) || (this.f == b.a.c)) {
        setStatusValue(8002, this.j.streamType, Integer.valueOf(e()));
      }
      return this.a.pushVideoFrame(paramInt1, paramInt2, paramInt3, paramLong);
    }
    return 10000002L;
  }
  
  public long a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    if (this.p == null) {
      return -1L;
    }
    this.q.b(new b.2(this, paramInt2, paramInt3, paramInt1, paramArrayOfByte, paramLong));
    return 0L;
  }
  
  public EGLContext a(int paramInt1, int paramInt2)
  {
    boolean bool = this.s;
    ??? = null;
    if (!bool)
    {
      this.s = true;
      synchronized (r)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("CVGLThread");
        Integer localInteger = r;
        r = Integer.valueOf(r.intValue() + 1);
        localStringBuilder.append(localInteger);
        this.q = new g(localStringBuilder.toString());
        ??? = new boolean[1];
        this.q.a(new b.1(this, paramInt1, paramInt2, (boolean[])???));
        if (???[0] != 0) {
          return this.p.d();
        }
        return null;
      }
    }
    com.tencent.liteav.basic.c.b localb = this.p;
    if (localb != null) {
      ??? = localb.d();
    }
    return ???;
  }
  
  public void a()
  {
    Object localObject = this.q;
    if (localObject != null)
    {
      ((g)localObject).b(new b.3(this, this.p));
      this.q = null;
      this.p = null;
    }
    else
    {
      this.i.clear();
      localObject = this.a;
      if (localObject != null) {
        ((d)localObject).stop();
      }
    }
    if (this.e == 3)
    {
      this.k = 0.0F;
      this.l = 0.0F;
      this.m = 0.0F;
      this.n = 0;
      h();
    }
    this.b = null;
    this.d = 0;
  }
  
  public void a(int paramInt)
  {
    d locald = this.a;
    if (locald != null) {
      locald.setRotation(paramInt);
    }
  }
  
  public void a(com.tencent.liteav.basic.b.b paramb)
  {
    this.c = new WeakReference(paramb);
  }
  
  public void a(e parame)
  {
    this.b = parame;
    a(new b.4(this));
  }
  
  protected void a(Runnable paramRunnable)
  {
    synchronized (this.i)
    {
      this.i.add(paramRunnable);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    d locald = this.a;
    if (locald != null) {
      locald.setXMirror(paramBoolean);
    }
  }
  
  public void b()
  {
    d locald = this.a;
    if (locald != null) {
      locald.restartIDR();
    }
  }
  
  public boolean b(int paramInt)
  {
    d locald = this.a;
    if (locald != null)
    {
      locald.setFPS(paramInt);
      return true;
    }
    return false;
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    d locald = this.a;
    if (locald != null)
    {
      this.d = paramInt1;
      locald.setBitrateFromQos(paramInt1, paramInt2);
      return true;
    }
    return false;
  }
  
  public double c()
  {
    d locald = this.a;
    if (locald != null) {
      return locald.getRealFPS();
    }
    return 0.0D;
  }
  
  public void c(int paramInt)
  {
    this.d = paramInt;
    a(new b.5(this));
  }
  
  public long d()
  {
    d locald = this.a;
    if (locald != null) {
      return locald.getRealBitrate();
    }
    return 0L;
  }
  
  public boolean d(int paramInt)
  {
    d locald = this.a;
    if (locald != null)
    {
      locald.setEncodeIdrFpsFromQos(paramInt);
      return true;
    }
    return false;
  }
  
  public int e()
  {
    d locald = this.a;
    if (locald != null) {
      return locald.getEncodeCost();
    }
    return 0;
  }
  
  public void e(int paramInt)
  {
    a(new b.6(this, paramInt));
  }
  
  public void setID(String paramString)
  {
    super.setID(paramString);
    d locald = this.a;
    if (locald != null) {
      locald.setID(paramString);
    }
    setStatusValue(4007, Long.valueOf(this.f.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.b
 * JD-Core Version:    0.7.0.1
 */