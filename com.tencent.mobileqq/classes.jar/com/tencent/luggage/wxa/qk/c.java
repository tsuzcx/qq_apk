package com.tencent.luggage.wxa.qk;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import com.tencent.luggage.wxa.hd.e;
import com.tencent.luggage.wxa.ql.g;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;

@TargetApi(16)
public class c
  extends com.tencent.luggage.wxa.ql.b
{
  private com.tencent.luggage.wxa.hh.a d;
  private e e;
  private AudioTrack f;
  private String g;
  private boolean h = true;
  private String i = null;
  private int j = 0;
  private int k = 0;
  private long l = 0L;
  private long m = 0L;
  private int n = 0;
  private Runnable o = new c.1(this);
  
  private boolean m()
  {
    o.d("MicroMsg.Music.MMPlayer", "createAudioTrack");
    int i1;
    if (this.k == 1) {
      i1 = 4;
    } else {
      i1 = 12;
    }
    int i2 = AudioTrack.getMinBufferSize(this.j, i1, 2);
    Object localObject = (com.tencent.luggage.wxa.qj.b)com.tencent.luggage.wxa.qn.b.a(com.tencent.luggage.wxa.qj.b.class);
    if (localObject != null) {
      this.f = ((com.tencent.luggage.wxa.qj.b)localObject).a(3, this.j, i1, 2, i2, 1);
    } else {
      o.b("MicroMsg.Music.MMPlayer", "mediaResService null");
    }
    if (this.f == null)
    {
      o.b("MicroMsg.Music.MMPlayer", "audioTrack is null, new AudioTrack");
      this.f = new ReportAudioTrack(3, this.j, i1, 2, i2, 1);
    }
    localObject = this.f;
    if ((localObject != null) && (((AudioTrack)localObject).getState() == 1)) {
      return true;
    }
    o.b("MicroMsg.Music.MMPlayer", "audio track not initialized");
    localObject = this.f;
    if (localObject != null) {}
    try
    {
      ((AudioTrack)localObject).release();
      label151:
      return false;
    }
    catch (Exception localException)
    {
      break label151;
    }
  }
  
  private void n()
  {
    try
    {
      if (this.d != null)
      {
        this.d.a();
        this.d = null;
        return;
      }
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.Music.MMPlayer", localException, "releaseMediaExtractor", new Object[0]);
    }
  }
  
  private void o()
  {
    try
    {
      if (this.e != null)
      {
        this.e.c();
        this.e.a();
        this.e = null;
        return;
      }
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.Music.MMPlayer", localException, "releaseMediaCodec", new Object[0]);
    }
  }
  
  private void p()
  {
    try
    {
      if (this.f != null)
      {
        this.f.flush();
        this.f.release();
        this.f = null;
        return;
      }
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.Music.MMPlayer", localException, "releaseAudioTrack", new Object[0]);
    }
  }
  
  public void a(long paramLong)
  {
    this.d.a(paramLong * 1000L, 2);
  }
  
  public void a(String paramString)
  {
    this.g = paramString;
  }
  
  protected void a(boolean paramBoolean)
  {
    this.c.a(4);
    this.h = true;
    super.a(paramBoolean);
  }
  
  public boolean a()
  {
    return this.c.b();
  }
  
  protected void b(boolean paramBoolean)
  {
    this.c.a(4);
    this.h = true;
    super.b(paramBoolean);
  }
  
  public boolean b()
  {
    return this.h ^ true;
  }
  
  public int c()
  {
    return (int)(this.l / 1000L);
  }
  
  public int d()
  {
    return (int)(this.m / 1000L);
  }
  
  public void e()
  {
    o.d("MicroMsg.Music.MMPlayer", "play");
    if (!b())
    {
      this.h = false;
      com.tencent.luggage.wxa.rd.a.b(this.o, "music_player");
      return;
    }
    if ((b()) && (this.c.a()))
    {
      this.c.a(3);
      i();
    }
  }
  
  public void f()
  {
    o.d("MicroMsg.Music.MMPlayer", "stop");
    this.h = true;
    if (this.c.a()) {
      i();
    }
  }
  
  public void g()
  {
    o.d("MicroMsg.Music.MMPlayer", "pause");
    if (!b()) {
      return;
    }
    this.c.a(2);
  }
  
  public String h()
  {
    return this.i;
  }
  
  public void i()
  {
    try
    {
      o.d("MicroMsg.Music.MMPlayer", "sync notify");
      try
      {
        notify();
      }
      catch (Exception localException)
      {
        o.a("MicroMsg.Music.MMPlayer", localException, "syncNotify", new Object[0]);
      }
      return;
    }
    finally {}
  }
  
  public void j()
  {
    try
    {
      while (b())
      {
        boolean bool = this.c.a();
        if (!bool) {
          break;
        }
        try
        {
          o.d("MicroMsg.Music.MMPlayer", "wait play");
          wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          o.a("MicroMsg.Music.MMPlayer", localInterruptedException, "waitPlay", new Object[0]);
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public int k()
  {
    return this.n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qk.c
 * JD-Core Version:    0.7.0.1
 */