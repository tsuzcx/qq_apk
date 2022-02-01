package com.tencent.luggage.wxa.qk;

import android.media.MediaPlayer;
import com.tencent.luggage.wxa.qz.o;

public class b
  extends com.tencent.luggage.wxa.ql.b
{
  private b.a d;
  private MediaPlayer e;
  private boolean f = true;
  
  public b()
  {
    com.tencent.luggage.wxa.qj.b localb = (com.tencent.luggage.wxa.qj.b)com.tencent.luggage.wxa.qn.b.a(com.tencent.luggage.wxa.qj.b.class);
    if (localb != null) {
      this.e = localb.a();
    } else {
      o.b("MicroMsg.Music.MMMediaPlayer", "mediaResService is null");
    }
    if (this.e == null) {
      this.e = new MediaPlayer();
    }
    this.e.setAudioStreamType(3);
    this.e.setOnCompletionListener(new b.1(this));
    this.e.setOnSeekCompleteListener(new b.2(this));
    this.e.setOnPreparedListener(new b.3(this));
    this.e.setOnErrorListener(new b.4(this));
  }
  
  public void a(long paramLong)
  {
    o.d("MicroMsg.Music.MMMediaPlayer", "seek %d", new Object[] { Long.valueOf(paramLong) });
    this.e.seekTo((int)paramLong);
  }
  
  public void a(String paramString)
  {
    o.d("MicroMsg.Music.MMMediaPlayer", "setSourcePath, sourcePath:%s", new Object[] { paramString });
    try
    {
      this.e.setDataSource(paramString);
      return;
    }
    catch (Exception paramString)
    {
      o.a("MicroMsg.Music.MMMediaPlayer", paramString, "setSourcePath", new Object[0]);
    }
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.e.isPlaying();
      return bool;
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.Music.MMMediaPlayer", localException, "setSourcePath", new Object[0]);
    }
    return false;
  }
  
  public boolean b()
  {
    return this.f ^ true;
  }
  
  public int c()
  {
    try
    {
      int i = this.e.getCurrentPosition();
      return i;
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.Music.MMMediaPlayer", localException, "getCurrentPos", new Object[0]);
    }
    return 0;
  }
  
  public int d()
  {
    try
    {
      int i = this.e.getDuration();
      return i;
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.Music.MMMediaPlayer", localException, "getDuration", new Object[0]);
    }
    return 0;
  }
  
  public void e()
  {
    o.d("MicroMsg.Music.MMMediaPlayer", "play");
    if (b()) {
      try
      {
        if (!this.e.isPlaying())
        {
          this.e.start();
          return;
        }
        return;
      }
      catch (Exception localException1)
      {
        o.a("MicroMsg.Music.MMMediaPlayer", localException1, "start", new Object[0]);
        return;
      }
    }
    try
    {
      this.e.prepareAsync();
      return;
    }
    catch (Exception localException2)
    {
      o.a("MicroMsg.Music.MMMediaPlayer", localException2, "prepareAsync", new Object[0]);
    }
  }
  
  public void f()
  {
    o.d("MicroMsg.Music.MMMediaPlayer", "stop");
    this.f = true;
    try
    {
      if (this.e != null)
      {
        this.e.stop();
        this.e.release();
      }
      if (this.d != null)
      {
        this.d.b();
        this.d = null;
      }
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.Music.MMMediaPlayer", localException, "stop", new Object[0]);
    }
    b(false);
  }
  
  public void g()
  {
    o.d("MicroMsg.Music.MMMediaPlayer", "pause");
    if (!b()) {
      return;
    }
    this.e.pause();
  }
  
  public String h()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qk.b
 * JD-Core Version:    0.7.0.1
 */