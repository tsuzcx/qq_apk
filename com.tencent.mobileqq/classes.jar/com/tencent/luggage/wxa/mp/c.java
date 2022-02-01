package com.tencent.luggage.wxa.mp;

import android.annotation.TargetApi;
import androidx.annotation.CallSuper;
import com.tencent.luggage.wxa.mo.g;
import com.tencent.luggage.wxa.pc.l;
import com.tencent.luggage.wxa.pc.l.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rt.k;

@TargetApi(5)
public class c
  extends a
{
  private com.tencent.luggage.wxa.gy.a a;
  private e.d b;
  private long c;
  private int d;
  private Runnable e = new c.1(this);
  
  private void l()
  {
    this.c = System.currentTimeMillis();
    o.d("MicroMsg.DefaultLuggageRecorder", "resumeRecordTime mRecordingTime:%d mLastStartTime:%d", new Object[] { Integer.valueOf(this.d), Long.valueOf(this.c) });
    l.a().a(this.e, this.b.b - this.d);
  }
  
  private void m()
  {
    this.d = ((int)(this.d + (System.currentTimeMillis() - this.c)));
    o.d("MicroMsg.DefaultLuggageRecorder", "pauseRecordTime mRecordingTime:%d mLastStartTime:%d", new Object[] { Integer.valueOf(this.d), Long.valueOf(this.c) });
    l.a().b(this.e);
  }
  
  public g a(e.d paramd)
  {
    if (b(paramd)) {
      return new g("invalid params", new Object[0]);
    }
    g();
    this.b = paramd;
    if (this.b.b <= 0) {
      this.b.b = 60000;
    }
    this.a = new com.tencent.luggage.wxa.gy.a(this.b.h.g, this.b.c, this.b.d, 2, this.b.f, this.b.g, this.b.a, this.b.e);
    this.c = System.currentTimeMillis();
    this.d = 0;
    boolean bool = this.a.a();
    o.d("MicroMsg.DefaultLuggageRecorder", "startRecord() params:%s isOK:%b", new Object[] { paramd, Boolean.valueOf(bool) });
    if (bool)
    {
      this.a.a(new c.2(this));
      l();
      a();
      return g.c;
    }
    g();
    return new g("start fail", new Object[0]);
  }
  
  protected boolean b(e.d paramd)
  {
    return paramd == null;
  }
  
  public void d()
  {
    o.d("MicroMsg.DefaultLuggageRecorder", "onBackground");
  }
  
  public void e()
  {
    o.d("MicroMsg.DefaultLuggageRecorder", "onForeground");
  }
  
  public void f()
  {
    o.d("MicroMsg.DefaultLuggageRecorder", "onDestroy");
    g();
  }
  
  @CallSuper
  protected void g()
  {
    try
    {
      this.b = null;
      if (this.a != null)
      {
        this.a.e();
        this.a = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public g h()
  {
    o.d("MicroMsg.DefaultLuggageRecorder", "pauseRecord");
    com.tencent.luggage.wxa.gy.a locala = this.a;
    if (locala == null)
    {
      o.b("MicroMsg.DefaultLuggageRecorder", "mRecorderPcm is null, err");
      return new g("may be not start", new Object[0]);
    }
    locala.b();
    m();
    c();
    return g.c;
  }
  
  public g i()
  {
    o.d("MicroMsg.DefaultLuggageRecorder", "resumeRecord");
    com.tencent.luggage.wxa.gy.a locala = this.a;
    if (locala == null)
    {
      o.b("MicroMsg.DefaultLuggageRecorder", "mRecorderPcm is null, err");
      return new g("may be not start", new Object[0]);
    }
    locala.c();
    l();
    b();
    return g.c;
  }
  
  public g j()
  {
    Object localObject = this.a;
    if (localObject == null)
    {
      o.b("MicroMsg.DefaultLuggageRecorder", "mRecorderPcm is null, err");
      return new g("may be not start", new Object[0]);
    }
    ((com.tencent.luggage.wxa.gy.a)localObject).d();
    localObject = this.b.a;
    this.d = ((int)(this.d + (System.currentTimeMillis() - this.c)));
    int i = this.d;
    int j = (int)k.c(this.b.a);
    a((String)localObject, i, j);
    o.d("MicroMsg.DefaultLuggageRecorder", "stopRecord() filePath:%s duration:%d fileSize:%d", new Object[] { localObject, Integer.valueOf(i), Integer.valueOf(j) });
    g();
    return g.c;
  }
  
  public boolean k()
  {
    return this.a != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mp.c
 * JD-Core Version:    0.7.0.1
 */