package com.tencent.luggage.wxa.qk;

import android.media.MediaPlayer;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rd.a;

class b$a
  implements Runnable
{
  private boolean b = true;
  
  private b$a(b paramb) {}
  
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
    o.d("MicroMsg.Music.MMMediaPlayer", "start run play progress task");
    while (!this.b)
    {
      try
      {
        if ((b.a(this.a) != null) && (b.a(this.a).isPlaying()))
        {
          int i = b.a(this.a).getCurrentPosition();
          int j = b.a(this.a).getDuration();
          if ((i > 0) && (j > 0))
          {
            i = i * 100 / j;
            b.a(this.a, i);
          }
        }
      }
      catch (Exception localException)
      {
        o.a("MicroMsg.Music.MMMediaPlayer", localException, "onPlayUpdate", new Object[0]);
      }
      try
      {
        Thread.sleep(200L);
      }
      catch (InterruptedException localInterruptedException)
      {
        o.a("MicroMsg.Music.MMMediaPlayer", localInterruptedException, "sleep", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qk.b.a
 * JD-Core Version:    0.7.0.1
 */