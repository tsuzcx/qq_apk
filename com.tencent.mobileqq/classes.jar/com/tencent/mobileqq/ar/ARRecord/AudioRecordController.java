package com.tencent.mobileqq.ar.ARRecord;

import java.lang.ref.WeakReference;

public abstract class AudioRecordController
  extends Thread
{
  public WeakReference a;
  
  public AudioRecordController(VideoRecordController paramVideoRecordController)
  {
    super("AudioRecordThread");
    this.a = new WeakReference(paramVideoRecordController);
  }
  
  public abstract void a();
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract void e();
  
  public void run()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.AudioRecordController
 * JD-Core Version:    0.7.0.1
 */