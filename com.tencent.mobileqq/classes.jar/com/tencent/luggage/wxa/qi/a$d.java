package com.tencent.luggage.wxa.qi;

import com.tencent.luggage.wxa.am.j;
import com.tencent.luggage.wxa.h.k;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.z.f.a;
import java.io.IOException;

class a$d
  implements com.tencent.luggage.wxa.z.a, f.a
{
  private a$d(a parama) {}
  
  public void a()
  {
    o.d("MicroMsg.Music.ExoMusicPlayer", "onHasEndTag");
    a.c(this.a, true);
  }
  
  public void a(int paramInt1, k paramk, int paramInt2, Object paramObject, long paramLong) {}
  
  public void a(j paramj, int paramInt1, int paramInt2, k paramk, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void a(j paramj, int paramInt1, int paramInt2, k paramk, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    o.d("MicroMsg.Music.ExoMusicPlayer", "onLoadCompleted");
  }
  
  public void a(j paramj, int paramInt1, int paramInt2, k paramk, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, IOException paramIOException, boolean paramBoolean)
  {
    a.a(this.a, "loadError", paramIOException);
    if ((paramj != null) && (paramk != null)) {
      o.b("MicroMsg.Music.ExoMusicPlayer", "uri:%s, Format:%s", new Object[] { paramj.a, paramk.toString() });
    }
    a.a(this.a, -4004, -40);
  }
  
  public void a(IOException paramIOException)
  {
    a.a(this.a, "loadError", paramIOException);
    o.a("MicroMsg.Music.ExoMusicPlayer", paramIOException, "onLoadError", new Object[0]);
    a.a(this.a, -4004, -40);
  }
  
  public void b(j paramj, int paramInt1, int paramInt2, k paramk, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qi.a.d
 * JD-Core Version:    0.7.0.1
 */