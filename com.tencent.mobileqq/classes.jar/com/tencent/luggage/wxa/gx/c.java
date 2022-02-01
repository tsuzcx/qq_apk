package com.tencent.luggage.wxa.gx;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.luggage.wxa.rt.k;
import com.tencent.luggage.wxa.ry.b;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.Future;

@TargetApi(3)
public class c
  implements a
{
  Runnable a = new c.1(this);
  private volatile AudioTrack b;
  private int c;
  private DataInputStream d;
  private Thread e;
  private Future f;
  private a.a g;
  private int h = 44100;
  private int i = 12;
  private boolean j;
  
  private boolean b(String paramString)
  {
    try
    {
      i locali = new i(paramString);
      if (!locali.j()) {
        return false;
      }
      this.d = new DataInputStream(k.a(locali));
      return true;
    }
    catch (Exception localException)
    {
      b.a("MicroMsg.VoicePlayerPcm", localException, String.format(Locale.US, "openFile(%s)", new Object[] { paramString }));
    }
    return false;
  }
  
  private AudioTrack d()
  {
    if (this.b == null) {
      try
      {
        if (this.b == null)
        {
          this.c = AudioTrack.getMinBufferSize(this.h, this.i, 2);
          this.b = new ReportAudioTrack(3, this.h, this.i, 2, this.c, 1);
          if (this.b.getState() == 0)
          {
            f();
            this.b = new ReportAudioTrack(3, this.h, this.i, 2, this.c, 1);
          }
        }
      }
      finally {}
    }
    return this.b;
  }
  
  private void e()
  {
    g();
    if (this.f == null) {
      this.f = f.a.d(this.a);
    }
  }
  
  private void f()
  {
    try
    {
      if (this.b != null)
      {
        this.b.flush();
        this.b.release();
        this.b = null;
        return;
      }
    }
    catch (Exception localException)
    {
      b.a("MicroMsg.VoicePlayerPcm", localException, "");
    }
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 140	com/tencent/luggage/wxa/gx/c:e	Ljava/lang/Thread;
    //   4: ifnull +45 -> 49
    //   7: getstatic 146	java/lang/Thread$State:RUNNABLE	Ljava/lang/Thread$State;
    //   10: astore_1
    //   11: aload_0
    //   12: getfield 140	com/tencent/luggage/wxa/gx/c:e	Ljava/lang/Thread;
    //   15: invokevirtual 151	java/lang/Thread:getState	()Ljava/lang/Thread$State;
    //   18: astore_2
    //   19: aload_1
    //   20: aload_2
    //   21: if_acmpne +28 -> 49
    //   24: ldc2_w 152
    //   27: invokestatic 157	java/lang/Thread:sleep	(J)V
    //   30: aload_0
    //   31: getfield 120	com/tencent/luggage/wxa/gx/c:f	Ljava/util/concurrent/Future;
    //   34: iconst_1
    //   35: invokeinterface 163 2 0
    //   40: pop
    //   41: goto +8 -> 49
    //   44: aload_0
    //   45: aconst_null
    //   46: putfield 140	com/tencent/luggage/wxa/gx/c:e	Ljava/lang/Thread;
    //   49: aload_0
    //   50: aconst_null
    //   51: putfield 120	com/tencent/luggage/wxa/gx/c:f	Ljava/util/concurrent/Future;
    //   54: aload_0
    //   55: aconst_null
    //   56: putfield 120	com/tencent/luggage/wxa/gx/c:f	Ljava/util/concurrent/Future;
    //   59: return
    //   60: astore_1
    //   61: goto +15 -> 76
    //   64: astore_1
    //   65: ldc 75
    //   67: aload_1
    //   68: ldc 138
    //   70: invokestatic 94	com/tencent/luggage/wxa/ry/b:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   73: goto -19 -> 54
    //   76: aload_0
    //   77: aconst_null
    //   78: putfield 120	com/tencent/luggage/wxa/gx/c:f	Ljava/util/concurrent/Future;
    //   81: goto +5 -> 86
    //   84: aload_1
    //   85: athrow
    //   86: goto -2 -> 84
    //   89: astore_1
    //   90: goto -46 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	c
    //   10	10	1	localState1	java.lang.Thread.State
    //   60	1	1	localObject	Object
    //   64	21	1	localException1	Exception
    //   89	1	1	localException2	Exception
    //   18	3	2	localState2	java.lang.Thread.State
    // Exception table:
    //   from	to	target	type
    //   0	19	60	finally
    //   24	41	60	finally
    //   44	49	60	finally
    //   49	54	60	finally
    //   65	73	60	finally
    //   0	19	64	java/lang/Exception
    //   44	49	64	java/lang/Exception
    //   49	54	64	java/lang/Exception
    //   24	41	89	java/lang/Exception
  }
  
  private void h()
  {
    DataInputStream localDataInputStream = this.d;
    if (localDataInputStream != null)
    {
      try
      {
        localDataInputStream.close();
      }
      catch (IOException localIOException)
      {
        b.a("MicroMsg.VoicePlayerPcm", localIOException, "");
      }
      this.d = null;
    }
  }
  
  public void a()
  {
    f();
    g();
    h();
  }
  
  public void a(a.a parama)
  {
    this.g = parama;
  }
  
  public boolean a(String paramString)
  {
    if (this.j)
    {
      b.a("MicroMsg.VoicePlayerPcm", "already play");
      return false;
    }
    if (!b(paramString))
    {
      b.a("MicroMsg.VoicePlayerPcm", "openfile fail");
      return false;
    }
    d();
    if (this.b.getState() == 0)
    {
      this.b = null;
      return false;
    }
    this.j = true;
    e();
    return true;
  }
  
  public boolean b()
  {
    if (!this.j)
    {
      b.a("MicroMsg.VoicePlayerPcm", "pause() not start play");
      return false;
    }
    this.j = false;
    g();
    return true;
  }
  
  public boolean c()
  {
    if (this.b != null) {
      this.b.stop();
    }
    this.j = false;
    a();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gx.c
 * JD-Core Version:    0.7.0.1
 */