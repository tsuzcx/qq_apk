package com.tencent.luggage.wxa.qd;

import com.tencent.luggage.wxa.qz.o;

class j$a
  implements Runnable
{
  private boolean b = true;
  
  private j$a(j paramj) {}
  
  public void a()
  {
    this.b = false;
  }
  
  public void b()
  {
    this.b = true;
  }
  
  public void run()
  {
    o.d("MicroMsg.Audio.QQAudioPlayer", "start run play progress task");
    while (!this.b)
    {
      try
      {
        if ((this.a.e != null) && (this.a.t())) {
          this.a.M();
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("PlayProgressTask run exception:");
        localStringBuilder.append(localException.getMessage());
        o.b("MicroMsg.Audio.QQAudioPlayer", localStringBuilder.toString());
      }
      try
      {
        Thread.sleep(200L);
      }
      catch (InterruptedException localInterruptedException)
      {
        label87:
        break label87;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qd.j.a
 * JD-Core Version:    0.7.0.1
 */