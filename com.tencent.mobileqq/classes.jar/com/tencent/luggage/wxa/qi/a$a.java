package com.tencent.luggage.wxa.qi;

import com.tencent.luggage.wxa.al.f;
import com.tencent.luggage.wxa.h.e;
import com.tencent.luggage.wxa.h.f.a;
import com.tencent.luggage.wxa.h.q;
import com.tencent.luggage.wxa.h.x;

class a$a
  implements f.a
{
  private a$a(a parama) {}
  
  public void a()
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Music.ExoMusicPlayer", "positionDiscontinuity");
  }
  
  public void a(e parame)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("playerFailed [");
    localStringBuilder.append(a.k(this.a));
    localStringBuilder.append("]");
    com.tencent.luggage.wxa.qz.o.a("MicroMsg.Music.ExoMusicPlayer", parame, localStringBuilder.toString(), new Object[0]);
    a.a(this.a, parame);
  }
  
  public void a(q paramq)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("playbackParameters ");
    localStringBuilder.append(String.format("[speed=%.2f, pitch=%.2f]", new Object[] { Float.valueOf(paramq.b), Float.valueOf(paramq.c) }));
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Music.ExoMusicPlayer", localStringBuilder.toString());
  }
  
  public void a(x paramx, Object paramObject) {}
  
  public void a(com.tencent.luggage.wxa.z.o paramo, f paramf) {}
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loading [");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Music.ExoMusicPlayer", localStringBuilder.toString());
    if ((!paramBoolean) && (a.j(this.a)))
    {
      a.a(this.a, false);
      a.g(this.a);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("state [");
    localStringBuilder.append(a.k(this.a));
    localStringBuilder.append(", ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", ");
    localStringBuilder.append(com.tencent.luggage.wxa.qm.a.a(paramInt));
    localStringBuilder.append("]");
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Music.ExoMusicPlayer", localStringBuilder.toString());
    a.l(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qi.a.a
 * JD-Core Version:    0.7.0.1
 */