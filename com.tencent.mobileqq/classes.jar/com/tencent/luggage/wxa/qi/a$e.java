package com.tencent.luggage.wxa.qi;

import com.tencent.luggage.wxa.h.k;
import com.tencent.luggage.wxa.i.e;
import com.tencent.luggage.wxa.j.d;
import com.tencent.luggage.wxa.qz.o;

class a$e
  implements e
{
  private a$e(a parama) {}
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("audioSessionId [");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    o.d("MicroMsg.Music.ExoMusicPlayer", localStringBuilder.toString());
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    a locala = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("audioTrackUnderrun [");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append("]");
    a.a(locala, localStringBuilder.toString(), null);
  }
  
  public void b(k paramk)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("audioFormatChanged [");
    localStringBuilder.append(a.k(this.a));
    localStringBuilder.append(", ");
    localStringBuilder.append(k.a(paramk));
    localStringBuilder.append("]");
    o.d("MicroMsg.Music.ExoMusicPlayer", localStringBuilder.toString());
  }
  
  public void b(String paramString, long paramLong1, long paramLong2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("audioDecoderInitialized [");
    localStringBuilder.append(a.k(this.a));
    localStringBuilder.append(", ");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    o.d("MicroMsg.Music.ExoMusicPlayer", localStringBuilder.toString());
  }
  
  public void c(d paramd)
  {
    paramd = new StringBuilder();
    paramd.append("audioEnabled [");
    paramd.append(a.k(this.a));
    paramd.append("]");
    o.d("MicroMsg.Music.ExoMusicPlayer", paramd.toString());
  }
  
  public void d(d paramd)
  {
    paramd = new StringBuilder();
    paramd.append("audioDisabled [");
    paramd.append(a.k(this.a));
    paramd.append("]");
    o.d("MicroMsg.Music.ExoMusicPlayer", paramd.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qi.a.e
 * JD-Core Version:    0.7.0.1
 */