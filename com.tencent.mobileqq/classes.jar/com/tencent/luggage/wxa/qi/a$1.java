package com.tencent.luggage.wxa.qi;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.luggage.wxa.h.w;
import com.tencent.luggage.wxa.qz.o;

class a$1
  extends Handler
{
  a$1(a parama, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (100 == paramMessage.what)
    {
      o.d("MicroMsg.Music.ExoMusicPlayer", "duration:%d, position:%d, bufferSize:%d, percent:%d", new Object[] { Long.valueOf(a.a(this.a).g()), Long.valueOf(a.a(this.a).h()), Long.valueOf(a.a(this.a).i()), Long.valueOf(a.a(this.a).j()) });
      this.a.f.removeMessages(100);
      if (a.b(this.a)) {
        this.a.f.sendEmptyMessageDelayed(100, 5000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qi.a.1
 * JD-Core Version:    0.7.0.1
 */