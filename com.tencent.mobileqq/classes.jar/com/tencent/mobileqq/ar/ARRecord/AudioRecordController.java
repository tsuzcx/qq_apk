package com.tencent.mobileqq.ar.ARRecord;

import apdx;
import java.lang.ref.WeakReference;

public abstract class AudioRecordController
  extends Thread
{
  public WeakReference<apdx> a;
  
  public AudioRecordController(apdx paramapdx)
  {
    super("AudioRecordThread");
    this.a = new WeakReference(paramapdx);
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