package com.tencent.liteav.audio.impl.Record;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class a
  implements Runnable
{
  private WeakReference<c> a;
  private int b;
  private int c;
  private int d;
  private boolean e;
  private Thread f;
  private byte[] g;
  
  private void a(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    for (;;)
    {
      try
      {
        if (this.a != null)
        {
          localc = (c)this.a.get();
          if (localc != null)
          {
            localc.onAudioRecordPCM(paramArrayOfByte, paramInt, paramLong);
            return;
          }
          TXCLog.e("AudioCenter:TXCAudioBGMRecord", "onRecordPcmData:no callback");
          return;
        }
      }
      finally {}
      c localc = null;
    }
  }
  
  private void b()
  {
    for (;;)
    {
      try
      {
        if (this.a != null)
        {
          c localc = (c)this.a.get();
          if (localc != null)
          {
            localc.onAudioRecordStart();
            return;
          }
          TXCLog.e("AudioCenter:TXCAudioBGMRecord", "onRecordStart:no callback");
          return;
        }
      }
      finally {}
      Object localObject2 = null;
    }
  }
  
  private void c()
  {
    for (;;)
    {
      try
      {
        if (this.a != null)
        {
          c localc = (c)this.a.get();
          if (localc != null)
          {
            localc.onAudioRecordStop();
            return;
          }
          TXCLog.e("AudioCenter:TXCAudioBGMRecord", "onRecordStop:no callback");
          return;
        }
      }
      finally {}
      Object localObject2 = null;
    }
  }
  
  public void a()
  {
    this.e = false;
    long l = System.currentTimeMillis();
    Thread localThread = this.f;
    if ((localThread != null) && (localThread.isAlive()) && (Thread.currentThread().getId() != this.f.getId())) {
      try
      {
        this.f.join();
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("record stop Exception: ");
        localStringBuilder2.append(localException.getMessage());
        TXCLog.e("AudioCenter:TXCAudioBGMRecord", localStringBuilder2.toString());
      }
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("stop record cost time(MS): ");
    localStringBuilder1.append(System.currentTimeMillis() - l);
    TXCLog.i("AudioCenter:TXCAudioBGMRecord", localStringBuilder1.toString());
    this.f = null;
  }
  
  public void run()
  {
    if (!this.e)
    {
      TXCLog.w("AudioCenter:TXCAudioBGMRecord", "audio record: abandom start audio sys record thread!");
      return;
    }
    b();
    int i = this.b;
    int j = this.c;
    int k = this.d;
    int m = j * 1024 * k / 8;
    this.g = new byte[m];
    Arrays.fill(this.g, (byte)0);
    long l1 = 0L;
    long l2 = System.currentTimeMillis();
    for (;;)
    {
      if ((!this.e) || (Thread.interrupted()) || ((System.currentTimeMillis() - l2) * i * j * k / 8L / 1000L - l1 < m)) {}
      try
      {
        Thread.sleep(10L);
      }
      catch (InterruptedException localInterruptedException) {}
      byte[] arrayOfByte = this.g;
      l1 += arrayOfByte.length;
      a(arrayOfByte, arrayOfByte.length, TXCTimeUtil.getTimeTick());
      continue;
      c();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.Record.a
 * JD-Core Version:    0.7.0.1
 */