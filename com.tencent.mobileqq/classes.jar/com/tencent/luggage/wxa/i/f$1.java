package com.tencent.luggage.wxa.i;

import android.media.AudioTrack;
import android.os.ConditionVariable;

class f$1
  extends Thread
{
  f$1(f paramf, AudioTrack paramAudioTrack) {}
  
  public void run()
  {
    try
    {
      this.a.flush();
      this.a.release();
      return;
    }
    finally
    {
      f.a(this.b).open();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.i.f.1
 * JD-Core Version:    0.7.0.1
 */