package com.tencent.mobileqq.ar.ARRecord;

import android.media.AudioRecord;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class MicRecordController
  extends AudioRecordController
{
  private AudioRecord b;
  private boolean c;
  private int d;
  private byte[] e;
  private volatile boolean f;
  
  public MicRecordController(VideoRecordController paramVideoRecordController)
  {
    super(paramVideoRecordController);
  }
  
  public void a()
  {
    while (this.c) {
      if ((this.b != null) && (!this.f)) {
        try
        {
          int i = this.b.read(this.e, 0, this.d);
          if (i > 0)
          {
            VideoRecordController localVideoRecordController = (VideoRecordController)this.a.get();
            if (localVideoRecordController != null)
            {
              byte[] arrayOfByte = new byte[i];
              System.arraycopy(this.e, 0, arrayOfByte, 0, i);
              localVideoRecordController.a(arrayOfByte, SystemClock.elapsedRealtimeNanos());
            }
          }
        }
        catch (Exception localException)
        {
          QLog.e("MicAudioRecordControlle", 1, "AudioRecordController read fail.", localException);
        }
      }
    }
  }
  
  public void b()
  {
    if (this.b == null)
    {
      this.d = (AudioRecord.getMinBufferSize(48000, 1, 2) * 4);
      this.b = new AudioRecord(1, 48000, 1, 2, this.d);
      this.e = new byte[this.d];
    }
    if (!this.c)
    {
      this.b.startRecording();
      this.c = true;
      start();
    }
  }
  
  public void c()
  {
    if (this.c)
    {
      AudioRecord localAudioRecord = this.b;
      if (localAudioRecord != null)
      {
        localAudioRecord.stop();
        this.b.release();
        this.b = null;
      }
      this.c = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.MicRecordController
 * JD-Core Version:    0.7.0.1
 */