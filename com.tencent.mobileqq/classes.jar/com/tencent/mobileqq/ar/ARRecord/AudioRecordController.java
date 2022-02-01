package com.tencent.mobileqq.ar.ARRecord;

import aoav;
import java.lang.ref.WeakReference;

public abstract class AudioRecordController
  extends Thread
{
  public WeakReference<aoav> a;
  
  public AudioRecordController(aoav paramaoav)
  {
    super("AudioRecordThread");
    this.a = new WeakReference(paramaoav);
  }
  
  public abstract void a();
  
  public abstract void b();
  
  public abstract void c();
  
  public void run()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.AudioRecordController
 * JD-Core Version:    0.7.0.1
 */