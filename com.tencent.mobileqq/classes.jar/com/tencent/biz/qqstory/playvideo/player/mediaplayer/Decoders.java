package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Decoders
{
  private MediaCodecAudioDecoder jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecAudioDecoder;
  private MediaCodecVideoDecoder jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecVideoDecoder;
  private List<MediaCodecDecoder> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public long a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    label15:
    long l2;
    for (long l1 = 9223372036854775807L; localIterator.hasNext(); l1 = l2)
    {
      l2 = ((MediaCodecDecoder)localIterator.next()).a();
      if ((l2 == -9223372036854775808L) || (l1 <= l2)) {
        break label15;
      }
    }
    return l1;
  }
  
  public MediaCodecDecoder.FrameInfo a(boolean paramBoolean)
  {
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        break label148;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      Object localObject1 = null;
      i = 0;
      while (localIterator.hasNext())
      {
        MediaCodecDecoder localMediaCodecDecoder = (MediaCodecDecoder)localIterator.next();
        MediaCodecDecoder.FrameInfo localFrameInfo = localMediaCodecDecoder.a();
        Object localObject2 = localObject1;
        if (localFrameInfo != null) {
          if (localMediaCodecDecoder == this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecVideoDecoder) {
            localObject2 = localFrameInfo;
          } else {
            localMediaCodecDecoder.a(localFrameInfo, 0L);
          }
        }
        while (localMediaCodecDecoder.a(false)) {}
        localObject1 = localObject2;
        if (localMediaCodecDecoder.b())
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
      if (i != this.jdField_a_of_type_JavaUtilList.size()) {
        break;
      }
    }
    label148:
    Log.d("Decoders", "EOS NULL");
    return null;
  }
  
  public MediaCodecVideoDecoder a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecVideoDecoder;
  }
  
  public List<MediaCodecDecoder> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((MediaCodecDecoder)localIterator.next()).e();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(MediaCodecDecoder paramMediaCodecDecoder)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramMediaCodecDecoder);
    if ((paramMediaCodecDecoder instanceof MediaCodecVideoDecoder))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecVideoDecoder = ((MediaCodecVideoDecoder)paramMediaCodecDecoder);
      return;
    }
    if ((paramMediaCodecDecoder instanceof MediaCodecAudioDecoder)) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecAudioDecoder = ((MediaCodecAudioDecoder)paramMediaCodecDecoder);
    }
  }
  
  public void a(MediaPlayer.SeekMode paramSeekMode, long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((MediaCodecDecoder)localIterator.next()).a(paramSeekMode, paramLong);
    }
  }
  
  public boolean a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    boolean bool = false;
    int i = 0;
    while (localIterator.hasNext()) {
      if (((MediaCodecDecoder)localIterator.next()).b()) {
        i += 1;
      }
    }
    if (i == this.jdField_a_of_type_JavaUtilList.size()) {
      bool = true;
    }
    return bool;
  }
  
  public long b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (long l = 9223372036854775807L; localIterator.hasNext(); l = Math.min(((MediaCodecDecoder)localIterator.next()).b(), l)) {}
    if (l == 9223372036854775807L) {
      return -1L;
    }
    return l;
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((MediaCodecDecoder)localIterator.next()).c();
    }
  }
  
  public boolean b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (!((MediaCodecDecoder)localIterator.next()).d()) {
        return false;
      }
    }
    return true;
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((MediaCodecDecoder)localIterator.next()).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.Decoders
 * JD-Core Version:    0.7.0.1
 */