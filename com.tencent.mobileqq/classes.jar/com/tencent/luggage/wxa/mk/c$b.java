package com.tencent.luggage.wxa.mk;

import com.tencent.luggage.wxa.am.j;
import com.tencent.luggage.wxa.h.k;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.z.a;
import com.tencent.luggage.wxa.z.f.a;
import java.io.IOException;

class c$b
  implements a, f.a
{
  private c$b(c paramc) {}
  
  public void a()
  {
    o.e("MicroMsg.SameLayer.ExoMediaPlayer", "onHasEndTag");
  }
  
  public void a(int paramInt1, k paramk, int paramInt2, Object paramObject, long paramLong)
  {
    o.d("MicroMsg.SameLayer.ExoMediaPlayer", "[TRACE_ADAPTIVE] onDownstreamFormatChanged, trackType:%s, trackFormat:%s, mediaTimeMs:%s", new Object[] { Integer.valueOf(paramInt1), paramk, Long.valueOf(paramLong) });
    c.a(this.a, paramk.a);
  }
  
  public void a(j paramj, int paramInt1, int paramInt2, k paramk, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3)
  {
    o.e("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadStarted, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt2), paramk, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
  }
  
  public void a(j paramj, int paramInt1, int paramInt2, k paramk, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    o.e("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadCompleted, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt2), paramk, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
  }
  
  public void a(j paramj, int paramInt1, int paramInt2, k paramk, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, IOException paramIOException, boolean paramBoolean)
  {
    o.a("MicroMsg.SameLayer.ExoMediaPlayer", paramIOException, "onLoadError1, IOException, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s, loadDurationMs:%s, bytesLoaded:%s, wasCanceled:%s", new Object[] { paramj, Integer.valueOf(paramInt2), paramk, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Long.valueOf(paramLong5), Boolean.valueOf(paramBoolean) });
    c.g(this.a);
  }
  
  public void a(IOException paramIOException)
  {
    o.a("MicroMsg.SameLayer.ExoMediaPlayer", paramIOException, "onLoadError2, IOException", new Object[0]);
    c.g(this.a);
  }
  
  public void b(j paramj, int paramInt1, int paramInt2, k paramk, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    o.e("MicroMsg.SameLayer.ExoMediaPlayer", "onLoadCanceled, dataSpec:%s, trackType:%s, trackFormat:%s, mediaStartTimeMs:%s, mediaEndTimeMs:%s, elapsedRealtimeMs:%s", new Object[] { paramj, Integer.valueOf(paramInt2), paramk, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mk.c.b
 * JD-Core Version:    0.7.0.1
 */