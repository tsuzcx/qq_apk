package com.tencent.luggage.wxa.mk;

import com.tencent.luggage.wxa.al.f;
import com.tencent.luggage.wxa.am.s.c;
import com.tencent.luggage.wxa.am.s.e;
import com.tencent.luggage.wxa.am.t.f;
import com.tencent.luggage.wxa.h.e;
import com.tencent.luggage.wxa.h.f.a;
import com.tencent.luggage.wxa.h.q;
import com.tencent.luggage.wxa.h.x;
import com.tencent.luggage.wxa.u.b.a;
import com.tencent.luggage.wxa.z.p;

class c$c
  implements f.a
{
  private c$c(c paramc) {}
  
  public void a()
  {
    com.tencent.luggage.wxa.qz.o.e("MicroMsg.SameLayer.ExoMediaPlayer", "onPositionDiscontinuity");
  }
  
  public void a(e parame)
  {
    com.tencent.luggage.wxa.qz.o.a("MicroMsg.SameLayer.ExoMediaPlayer", parame, "onPlayError, ExoPlaybackException", new Object[0]);
    if (c.b(this.a)) {
      c.a(this.a, false);
    }
    int j = -4999;
    int i = j;
    if (parame != null)
    {
      Object localObject = parame.getCause();
      i = j;
      if (localObject != null) {
        if ((localObject instanceof s.c))
        {
          i = -4000;
          if (((Throwable)localObject).toString().contains("Unable to connect"))
          {
            boolean bool = d.b(c.i(this.a));
            parame = new StringBuilder();
            parame.append("ExoPlaybackException hasNetwork=");
            parame.append(bool);
            com.tencent.luggage.wxa.qz.o.a("MicroMsg.SameLayer.ExoMediaPlayer", (Throwable)localObject, parame.toString(), new Object[0]);
            if (!bool)
            {
              this.a.b(-4000, -2);
              return;
            }
            this.a.b(-4000, -3);
            return;
          }
          if ((localObject instanceof s.e))
          {
            parame = ((Throwable)localObject).toString();
            if (parame.contains("403"))
            {
              this.a.b(-4000, -10);
              return;
            }
            if (parame.contains("404"))
            {
              this.a.b(-4000, -11);
              return;
            }
            if (parame.contains("500"))
            {
              this.a.b(-4000, -12);
              return;
            }
            if (parame.contains("502"))
            {
              this.a.b(-4000, -13);
              return;
            }
            this.a.b(-4000, -30);
          }
        }
        else
        {
          if ((localObject instanceof p))
          {
            com.tencent.luggage.wxa.qz.o.b("MicroMsg.SameLayer.ExoMediaPlayer", d.a());
            this.a.b(-4001, -1);
            return;
          }
          if ((localObject instanceof IllegalStateException))
          {
            com.tencent.luggage.wxa.qz.o.b("MicroMsg.SameLayer.ExoMediaPlayer", d.a());
            this.a.b(-4002, -1);
            return;
          }
          if ((localObject instanceof b.a))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onPlayError, error: ");
            ((StringBuilder)localObject).append(d.a(parame));
            com.tencent.luggage.wxa.qz.o.c("MicroMsg.SameLayer.ExoMediaPlayer", ((StringBuilder)localObject).toString());
            com.tencent.luggage.wxa.qz.o.b("MicroMsg.SameLayer.ExoMediaPlayer", d.a());
            this.a.b(-4003, -1);
            return;
          }
          i = j;
          if ((localObject instanceof t.f))
          {
            com.tencent.luggage.wxa.qz.o.b("MicroMsg.SameLayer.ExoMediaPlayer", d.a());
            this.a.b(-4004, -1);
            return;
          }
        }
      }
    }
    com.tencent.luggage.wxa.qz.o.b("MicroMsg.SameLayer.ExoMediaPlayer", d.a(0, null, 30));
    this.a.b(i, -1);
  }
  
  public void a(q paramq)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPlaybackParametersChanged, params=[");
    localStringBuilder.append(paramq.b);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramq.c);
    localStringBuilder.append("]");
    com.tencent.luggage.wxa.qz.o.e("MicroMsg.SameLayer.ExoMediaPlayer", localStringBuilder.toString());
  }
  
  public void a(x paramx, Object paramObject)
  {
    com.tencent.luggage.wxa.qz.o.e("MicroMsg.SameLayer.ExoMediaPlayer", "onTimelineChanged");
  }
  
  public void a(com.tencent.luggage.wxa.z.o paramo, f paramf)
  {
    com.tencent.luggage.wxa.qz.o.e("MicroMsg.SameLayer.ExoMediaPlayer", "onTracksChanged");
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoadingChanged, isLoading=");
    localStringBuilder.append(paramBoolean);
    com.tencent.luggage.wxa.qz.o.e("MicroMsg.SameLayer.ExoMediaPlayer", localStringBuilder.toString());
    if (paramBoolean) {
      c.a(this.a, true);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPlayerStateChanged, playWhenReady=");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", playbackState=");
    localStringBuilder.append(paramInt);
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.SameLayer.ExoMediaPlayer", localStringBuilder.toString());
    c.h(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mk.c.c
 * JD-Core Version:    0.7.0.1
 */