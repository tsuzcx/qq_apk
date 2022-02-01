package com.tencent.luggage.wxa.gy;

import android.media.AudioRecord;
import com.tencent.luggage.wxa.qz.o;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class b
{
  private AudioRecord a;
  private int b = 1;
  private int c = 44100;
  private int d = 12;
  private int e = 2;
  private int f;
  private int g;
  private int h = 20;
  private final ExecutorService i = Executors.newSingleThreadExecutor();
  private Runnable j = new b.1(this);
  private byte[] k;
  private boolean l = false;
  private b.a m;
  
  public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    if (paramInt3 == 2) {
      this.d = 12;
    } else {
      this.d = 16;
    }
    this.e = paramInt4;
    this.f = AudioRecord.getMinBufferSize(this.c, this.d, paramInt4);
    this.a = new AudioRecord(this.b, this.c, this.d, this.e, this.f);
    this.g = (this.c * this.h * paramInt3 / 1000 * 2);
    o.d("MicroMsg.RecorderPcm", "mAudioSource:%d, mSampleRate:%d mAudioChannel:%d mAudioFormat:%d mBufferSize:%d mPreBufferSize:%d", new Object[] { Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.f), Integer.valueOf(this.g) });
  }
  
  private void g()
  {
    this.k = new byte[this.g];
    while (this.l)
    {
      int n = this.a.read(this.k, 0, this.g);
      if (n > 0) {
        this.m.a(this.k, n);
      }
    }
  }
  
  private boolean h()
  {
    if (this.a == null)
    {
      o.b("MicroMsg.RecorderPcm", "mAudioRecord is null, return");
      return true;
    }
    return false;
  }
  
  public int a()
  {
    return this.f;
  }
  
  public void a(b.a parama)
  {
    this.m = parama;
  }
  
  public boolean b()
  {
    if (h()) {
      return false;
    }
    this.l = true;
    try
    {
      this.a.startRecording();
      this.i.submit(this.j);
      return true;
    }
    catch (Exception localException)
    {
      o.h("MicroMsg.RecorderPcm", "", new Object[] { localException });
    }
    return false;
  }
  
  public boolean c()
  {
    if (h()) {
      return false;
    }
    this.l = false;
    return true;
  }
  
  public boolean d()
  {
    if (h()) {
      return false;
    }
    this.l = true;
    this.i.submit(this.j);
    return true;
  }
  
  public boolean e()
  {
    if (h()) {
      return false;
    }
    this.l = false;
    try
    {
      this.a.stop();
      f();
      return true;
    }
    catch (Exception localException)
    {
      o.h("MicroMsg.RecorderPcm", "", new Object[] { localException });
    }
    return false;
  }
  
  public void f()
  {
    try
    {
      if (this.a != null)
      {
        this.a.setRecordPositionUpdateListener(null);
        this.a.release();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gy.b
 * JD-Core Version:    0.7.0.1
 */