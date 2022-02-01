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
    long l1 = 9223372036854775807L;
    if (localIterator.hasNext())
    {
      long l2 = ((MediaCodecDecoder)localIterator.next()).a();
      if ((l2 == -9223372036854775808L) || (l1 <= l2)) {
        break label60;
      }
      l1 = l2;
    }
    label60:
    for (;;)
    {
      break;
      return l1;
    }
  }
  
  public MediaCodecDecoder.FrameInfo a(boolean paramBoolean)
  {
    Object localObject2 = null;
    int i = 0;
    Object localObject1;
    label24:
    MediaCodecDecoder localMediaCodecDecoder;
    label46:
    MediaCodecDecoder.FrameInfo localFrameInfo;
    if (i == 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      localObject1 = null;
      i = 0;
      if (localIterator.hasNext())
      {
        localMediaCodecDecoder = (MediaCodecDecoder)localIterator.next();
        localFrameInfo = localMediaCodecDecoder.a();
        if (localFrameInfo == null) {
          break label151;
        }
        if (localMediaCodecDecoder == this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecVideoDecoder)
        {
          localObject1 = localFrameInfo;
          label70:
          if (localMediaCodecDecoder.a(false)) {
            break label152;
          }
          if (!localMediaCodecDecoder.b()) {
            break label154;
          }
          i += 1;
        }
      }
    }
    label151:
    label152:
    label154:
    for (;;)
    {
      break label24;
      localMediaCodecDecoder.a(localFrameInfo, 0L);
      break label46;
      if (localObject1 != null) {}
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (!paramBoolean);
      if (i == this.jdField_a_of_type_JavaUtilList.size())
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      Log.d("Decoders", "EOS NULL");
      return null;
      break label70;
      break label70;
    }
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
    if ((paramMediaCodecDecoder instanceof MediaCodecVideoDecoder)) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecVideoDecoder = ((MediaCodecVideoDecoder)paramMediaCodecDecoder);
    }
    while (!(paramMediaCodecDecoder instanceof MediaCodecAudioDecoder)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecAudioDecoder = ((MediaCodecAudioDecoder)paramMediaCodecDecoder);
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
    boolean bool = false;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!((MediaCodecDecoder)localIterator.next()).b()) {
        break label62;
      }
      i += 1;
    }
    label62:
    for (;;)
    {
      break;
      if (i == this.jdField_a_of_type_JavaUtilList.size()) {
        bool = true;
      }
      return bool;
    }
  }
  
  public long b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (long l1 = 9223372036854775807L; localIterator.hasNext(); l1 = Math.min(((MediaCodecDecoder)localIterator.next()).b(), l1)) {}
    long l2 = l1;
    if (l1 == 9223372036854775807L) {
      l2 = -1L;
    }
    return l2;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.Decoders
 * JD-Core Version:    0.7.0.1
 */