package com.tencent.luggage.wxa.mk;

import android.view.Surface;
import com.tencent.luggage.wxa.ad.j.a;
import com.tencent.luggage.wxa.ap.g;
import com.tencent.luggage.wxa.h.k;
import com.tencent.luggage.wxa.i.e;
import com.tencent.luggage.wxa.j.d;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.v.f.a;
import java.util.List;

class c$d
  implements j.a, g, e, f.a
{
  private c$d(c paramc) {}
  
  public void a(int paramInt)
  {
    o.e("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioSessionId");
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    o.d("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoSizeChanged, width:%d, height:%d, rotationDegrees:%d, ratio:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Float.valueOf(paramFloat) });
    c.c(this.a, paramInt1);
    c.d(this.a, paramInt2);
    c.b(this.a, paramInt1, paramInt2);
  }
  
  public void a(int paramInt, long paramLong)
  {
    o.e("MicroMsg.SameLayer.ExoMediaPlayer", "onDroppedFrames");
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    o.e("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioTrackUnderrun");
  }
  
  public void a(Surface paramSurface)
  {
    o.d("MicroMsg.SameLayer.ExoMediaPlayer", "onRenderedFirstFrame");
    c.a(this.a, 3, 0);
  }
  
  public void a(k paramk)
  {
    o.e("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoInputFormatChanged");
  }
  
  public void a(d paramd)
  {
    o.e("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoEnabled");
  }
  
  public void a(com.tencent.luggage.wxa.v.a parama)
  {
    o.e("MicroMsg.SameLayer.ExoMediaPlayer", "onMetadata");
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    o.e("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoDecoderInitialized");
  }
  
  public void a(List<com.tencent.luggage.wxa.ad.a> paramList)
  {
    o.e("MicroMsg.SameLayer.ExoMediaPlayer", "onCues");
  }
  
  public void b(k paramk)
  {
    o.e("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioInputFormatChanged");
  }
  
  public void b(d paramd)
  {
    o.e("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoDisabled");
  }
  
  public void b(String paramString, long paramLong1, long paramLong2)
  {
    o.e("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioDecoderInitialized");
  }
  
  public void c(d paramd)
  {
    o.e("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioEnabled");
  }
  
  public void d(d paramd)
  {
    o.e("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioDisabled");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mk.c.d
 * JD-Core Version:    0.7.0.1
 */