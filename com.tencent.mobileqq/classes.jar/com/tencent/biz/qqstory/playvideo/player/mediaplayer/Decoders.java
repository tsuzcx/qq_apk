package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Decoders
{
  private List<MediaCodecDecoder> a = new ArrayList();
  private MediaCodecVideoDecoder b;
  private MediaCodecAudioDecoder c;
  
  public MediaCodecDecoder.FrameInfo a(boolean paramBoolean)
  {
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        break label148;
      }
      Iterator localIterator = this.a.iterator();
      Object localObject1 = null;
      i = 0;
      while (localIterator.hasNext())
      {
        MediaCodecDecoder localMediaCodecDecoder = (MediaCodecDecoder)localIterator.next();
        MediaCodecDecoder.FrameInfo localFrameInfo = localMediaCodecDecoder.h();
        Object localObject2 = localObject1;
        if (localFrameInfo != null) {
          if (localMediaCodecDecoder == this.b) {
            localObject2 = localFrameInfo;
          } else {
            localMediaCodecDecoder.a(localFrameInfo, 0L);
          }
        }
        while (localMediaCodecDecoder.a(false)) {}
        localObject1 = localObject2;
        if (localMediaCodecDecoder.d())
        {
          i += 1;
          localObject1 = localObject2;
        }
      }
      if (localObject1 != null) {
        return localObject1;
      }
      if (!paramBoolean) {
        return null;
      }
      if (i != this.a.size()) {
        break;
      }
    }
    label148:
    Log.d("Decoders", "EOS NULL");
    return null;
  }
  
  public List<MediaCodecDecoder> a()
  {
    return this.a;
  }
  
  public void a(MediaCodecDecoder paramMediaCodecDecoder)
  {
    this.a.add(paramMediaCodecDecoder);
    if ((paramMediaCodecDecoder instanceof MediaCodecVideoDecoder))
    {
      this.b = ((MediaCodecVideoDecoder)paramMediaCodecDecoder);
      return;
    }
    if ((paramMediaCodecDecoder instanceof MediaCodecAudioDecoder)) {
      this.c = ((MediaCodecAudioDecoder)paramMediaCodecDecoder);
    }
  }
  
  public void a(MediaPlayer.SeekMode paramSeekMode, long paramLong)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((MediaCodecDecoder)localIterator.next()).a(paramSeekMode, paramLong);
    }
  }
  
  public MediaCodecVideoDecoder b()
  {
    return this.b;
  }
  
  public void c()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((MediaCodecDecoder)localIterator.next()).n();
    }
    this.a.clear();
  }
  
  public void d()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((MediaCodecDecoder)localIterator.next()).l();
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((MediaCodecDecoder)localIterator.next()).m();
    }
  }
  
  public long f()
  {
    Iterator localIterator = this.a.iterator();
    label15:
    long l2;
    for (long l1 = 9223372036854775807L; localIterator.hasNext(); l1 = l2)
    {
      l2 = ((MediaCodecDecoder)localIterator.next()).i();
      if ((l2 == -9223372036854775808L) || (l1 <= l2)) {
        break label15;
      }
    }
    return l1;
  }
  
  public boolean g()
  {
    Iterator localIterator = this.a.iterator();
    boolean bool = false;
    int i = 0;
    while (localIterator.hasNext()) {
      if (((MediaCodecDecoder)localIterator.next()).d()) {
        i += 1;
      }
    }
    if (i == this.a.size()) {
      bool = true;
    }
    return bool;
  }
  
  public long h()
  {
    Iterator localIterator = this.a.iterator();
    for (long l = 9223372036854775807L; localIterator.hasNext(); l = Math.min(((MediaCodecDecoder)localIterator.next()).j(), l)) {}
    if (l == 9223372036854775807L) {
      return -1L;
    }
    return l;
  }
  
  public boolean i()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      if (!((MediaCodecDecoder)localIterator.next()).k()) {
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.Decoders
 * JD-Core Version:    0.7.0.1
 */