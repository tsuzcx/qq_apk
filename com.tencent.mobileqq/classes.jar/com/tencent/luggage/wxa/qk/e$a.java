package com.tencent.luggage.wxa.qk;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rd.a;

class e$a
  implements Runnable
{
  private boolean b = true;
  
  private e$a(e parame) {}
  
  public void a()
  {
    this.b = false;
    a.b(this, "music_play_progress_runnable");
  }
  
  public void b()
  {
    this.b = true;
  }
  
  public void run()
  {
    o.d("MicroMsg.Music.QQMusicPlayer", "start run play progress task");
    while (!this.b)
    {
      try
      {
        if ((e.h(this.a) != null) && (this.a.t())) {
          this.a.g();
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("PlayProgressTask run exception:");
        localStringBuilder.append(localException.getMessage());
        o.b("MicroMsg.Music.QQMusicPlayer", localStringBuilder.toString());
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
 * Qualified Name:     com.tencent.luggage.wxa.qk.e.a
 * JD-Core Version:    0.7.0.1
 */