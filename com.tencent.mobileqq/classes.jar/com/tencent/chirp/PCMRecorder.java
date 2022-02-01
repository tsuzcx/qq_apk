package com.tencent.chirp;

import android.content.Context;

public class PCMRecorder
{
  private int a = 44100;
  private int b = 0;
  private volatile PCMRecorder.RecordThread c;
  private Context d;
  private PCMRecorder.OnQQRecorderListener e;
  
  public PCMRecorder(Context paramContext, int paramInt, PCMRecorder.OnQQRecorderListener paramOnQQRecorderListener)
  {
    this.d = paramContext;
    this.a = paramInt;
    this.b = (paramInt / 50 * 2 * 2);
    this.e = paramOnQQRecorderListener;
  }
  
  public boolean a()
  {
    if (this.c == null)
    {
      this.c = new PCMRecorder.RecordThread(this);
      this.c.start();
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (this.c != null)
    {
      this.c.a = false;
      this.c = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.chirp.PCMRecorder
 * JD-Core Version:    0.7.0.1
 */