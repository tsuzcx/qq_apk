package com.tencent.luggage.wxa.gx;

import android.media.AudioTrack;
import android.os.Process;
import com.tencent.luggage.wxa.ry.b;
import java.io.DataInputStream;

class c$1
  implements Runnable
{
  c$1(c paramc) {}
  
  public void run()
  {
    try
    {
      if (c.a(this.a) == null) {
        return;
      }
      c.a(this.a).play();
      Process.setThreadPriority(-19);
      byte[] arrayOfByte = new byte[c.b(this.a)];
      while (c.c(this.a).available() > 0)
      {
        int i = c.c(this.a).read(arrayOfByte);
        if ((i != -3) && (i != -2) && (i != 0) && (i != -1)) {
          c.a(this.a).write(arrayOfByte, 0, i);
        }
      }
      this.a.c();
      if (c.d(this.a) != null)
      {
        c.d(this.a).a();
        return;
      }
    }
    catch (Exception localException)
    {
      b.a("MicroMsg.VoicePlayerPcm", localException, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gx.c.1
 * JD-Core Version:    0.7.0.1
 */