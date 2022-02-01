package com.tencent.mobileqq.ar.ARRecord;

import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class PcmRecordController
  extends AudioRecordController
{
  private AudioGenerator b;
  private volatile boolean c;
  private volatile boolean d;
  private long e;
  private String f;
  
  public PcmRecordController(VideoRecordController paramVideoRecordController, String paramString)
  {
    super(paramVideoRecordController);
    this.f = paramString;
  }
  
  public void a()
  {
    this.e = System.currentTimeMillis();
    while (this.c) {
      if ((this.b != null) && (this.e > 0L) && (!this.d)) {
        try
        {
          long l = System.currentTimeMillis() - this.e;
          byte[] arrayOfByte = this.b.a(l);
          VideoRecordController localVideoRecordController = (VideoRecordController)this.a.get();
          if (localVideoRecordController != null) {
            localVideoRecordController.a(arrayOfByte, SystemClock.elapsedRealtimeNanos());
          }
          if (QLog.isColorLevel()) {
            QLog.d("PcmRecordController", 2, String.format("record audio duration: %s, buffer length: %s", new Object[] { Long.valueOf(l), Integer.valueOf(arrayOfByte.length) }));
          }
          this.e = System.currentTimeMillis();
          sleep(200L);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          QLog.e("PcmRecordController", 1, "AudioRecordController read fail.", localException);
        }
      }
    }
  }
  
  public void b()
  {
    try
    {
      if (this.b == null) {
        this.b = new AudioGenerator(this.f, 48000, 1, 16);
      }
      if (!this.c)
      {
        this.c = true;
        this.d = false;
        start();
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if (QLog.isColorLevel()) {
      QLog.d("PcmRecordController", 2, String.format("startAudioRecord, mIsRecording: %s", new Object[] { Boolean.valueOf(this.c) }));
    }
  }
  
  public void c()
  {
    if (this.c)
    {
      AudioGenerator localAudioGenerator = this.b;
      if (localAudioGenerator != null)
      {
        localAudioGenerator.a();
        this.b = null;
      }
      this.c = false;
      this.e = 0L;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PcmRecordController", 2, String.format("stopAudioRecord, isRecording: %s", new Object[] { Boolean.valueOf(this.c) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.PcmRecordController
 * JD-Core Version:    0.7.0.1
 */