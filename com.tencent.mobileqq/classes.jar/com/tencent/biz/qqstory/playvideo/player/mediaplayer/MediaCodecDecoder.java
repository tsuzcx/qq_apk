package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.SystemClock;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
abstract class MediaCodecDecoder
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private MediaCodec.BufferInfo jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo;
  private MediaCodec jdField_a_of_type_AndroidMediaMediaCodec;
  private MediaFormat jdField_a_of_type_AndroidMediaMediaFormat;
  private MediaCodecDecoder.FrameInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecDecoder$FrameInfo;
  private MediaCodecDecoder.OnDecoderEventListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecDecoder$OnDecoderEventListener;
  private MediaExtractor jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor;
  protected String a;
  private List<MediaCodecDecoder.FrameInfo> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private ByteBuffer[] jdField_a_of_type_ArrayOfJavaNioByteBuffer;
  private boolean jdField_b_of_type_Boolean;
  private ByteBuffer[] jdField_b_of_type_ArrayOfJavaNioByteBuffer;
  private boolean c;
  private boolean d;
  private boolean e;
  
  public MediaCodecDecoder(MediaExtractor paramMediaExtractor, boolean paramBoolean, int paramInt, MediaCodecDecoder.OnDecoderEventListener paramOnDecoderEventListener)
  {
    this.jdField_a_of_type_JavaLangString = MediaCodecDecoder.class.getSimpleName();
    this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    if ((paramMediaExtractor == null) || (paramInt == -1)) {
      throw new IllegalArgumentException("no track specified");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor = paramMediaExtractor;
    this.e = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaExtractor.a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecDecoder$OnDecoderEventListener = paramOnDecoderEventListener;
    this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createDecoderByType(this.jdField_a_of_type_AndroidMediaMediaFormat.getString("mime"));
    this.jdField_a_of_type_Long = -9223372036854775808L;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  protected final MediaCodec a()
  {
    return this.jdField_a_of_type_AndroidMediaMediaCodec;
  }
  
  protected final MediaFormat a()
  {
    return this.jdField_a_of_type_AndroidMediaMediaFormat;
  }
  
  public final MediaCodecDecoder.FrameInfo a()
  {
    if (this.jdField_b_of_type_Boolean) {
      return null;
    }
    int i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, 0L);
    boolean bool;
    if ((i >= 0) && ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x4) != 0))
    {
      bool = true;
      this.jdField_b_of_type_Boolean = bool;
      if ((!this.jdField_b_of_type_Boolean) || (!this.c)) {
        break label85;
      }
      a();
      this.jdField_b_of_type_Boolean = false;
      this.c = false;
      this.d = true;
    }
    for (;;)
    {
      return null;
      bool = false;
      break;
      label85:
      Object localObject;
      if (i >= 0)
      {
        localObject = this.jdField_b_of_type_ArrayOfJavaNioByteBuffer[i];
        if ((localObject != null) && (this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size != 0))
        {
          ((ByteBuffer)localObject).position(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset);
          ((ByteBuffer)localObject).limit(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset + this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size);
        }
        MediaCodecDecoder.FrameInfo localFrameInfo = (MediaCodecDecoder.FrameInfo)this.jdField_a_of_type_JavaUtilList.get(0);
        localFrameInfo.jdField_a_of_type_Int = i;
        localFrameInfo.jdField_a_of_type_JavaNioByteBuffer = ((ByteBuffer)localObject);
        localFrameInfo.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs;
        localFrameInfo.jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
        if (this.d)
        {
          this.d = false;
          localFrameInfo.jdField_b_of_type_Boolean = true;
        }
        if (localFrameInfo.jdField_a_of_type_Boolean)
        {
          Log.d(this.jdField_a_of_type_JavaLangString, "EOS output");
          return localFrameInfo;
        }
        this.jdField_a_of_type_Long = localFrameInfo.jdField_a_of_type_Long;
        return localFrameInfo;
      }
      if (i == -3)
      {
        this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
        Log.d(this.jdField_a_of_type_JavaLangString, "output buffers have changed.");
      }
      else if (i == -2)
      {
        localObject = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat();
        Log.d(this.jdField_a_of_type_JavaLangString, "output format has changed to " + localObject);
        a((MediaFormat)localObject);
      }
      else if (i != -1) {}
    }
  }
  
  protected MediaCodecDecoder.FrameInfo a(MediaPlayer.SeekMode paramSeekMode, long paramLong, MediaExtractor paramMediaExtractor, MediaCodec paramMediaCodec)
  {
    if (this.e)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      paramMediaCodec.flush();
      return null;
    }
    Log.d(this.jdField_a_of_type_JavaLangString, "seeking to:                 " + paramLong);
    Log.d(this.jdField_a_of_type_JavaLangString, "extractor current position: " + paramMediaExtractor.a());
    paramMediaExtractor.a(paramLong, paramSeekMode.a());
    Log.d(this.jdField_a_of_type_JavaLangString, "extractor new position:     " + paramMediaExtractor.a());
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    paramMediaCodec.flush();
    if (paramMediaExtractor.c())
    {
      a();
      this.d = true;
    }
    return a(true, true);
  }
  
  public final MediaCodecDecoder.FrameInfo a(boolean paramBoolean1, boolean paramBoolean2)
  {
    while (!this.jdField_b_of_type_Boolean)
    {
      MediaCodecDecoder.FrameInfo localFrameInfo = a();
      while (a(paramBoolean1)) {}
      if (localFrameInfo != null) {
        return localFrameInfo;
      }
      if (!paramBoolean2) {
        return null;
      }
    }
    Log.d(this.jdField_a_of_type_JavaLangString, "EOS NULL");
    return null;
  }
  
  protected final void a()
  {
    int i = 0;
    try
    {
      long l = SystemClock.elapsedRealtime();
      this.jdField_a_of_type_AndroidMediaMediaFormat = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor.a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidMediaMediaCodec.stop();
      a(this.jdField_a_of_type_AndroidMediaMediaCodec, this.jdField_a_of_type_AndroidMediaMediaFormat);
      this.jdField_a_of_type_AndroidMediaMediaCodec.start();
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getInputBuffers();
      this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
      this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = new MediaCodec.BufferInfo();
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      while (i < this.jdField_b_of_type_ArrayOfJavaNioByteBuffer.length)
      {
        this.jdField_a_of_type_JavaUtilList.add(new MediaCodecDecoder.FrameInfo());
        i += 1;
      }
      Log.d(this.jdField_a_of_type_JavaLangString, "reinitCodec " + (SystemClock.elapsedRealtime() - l) + "ms");
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec.release();
      Log.e(this.jdField_a_of_type_JavaLangString, "reinitCodec: invalid surface or format");
      throw localIllegalArgumentException;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec.release();
      Log.e(this.jdField_a_of_type_JavaLangString, "reinitCodec: illegal state");
      throw localIllegalStateException;
    }
  }
  
  protected void a(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    paramMediaCodec.configure(paramMediaFormat, null, null, 0);
  }
  
  protected void a(MediaFormat paramMediaFormat) {}
  
  public void a(MediaCodecDecoder.FrameInfo paramFrameInfo)
  {
    b(paramFrameInfo);
  }
  
  public void a(MediaCodecDecoder.FrameInfo paramFrameInfo, long paramLong)
  {
    b(paramFrameInfo);
  }
  
  public final void a(MediaPlayer.SeekMode paramSeekMode, long paramLong)
  {
    this.jdField_a_of_type_Long = -9223372036854775808L;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecDecoder$FrameInfo = a(paramSeekMode, paramLong, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor, this.jdField_a_of_type_AndroidMediaMediaCodec);
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public final boolean a(boolean paramBoolean)
  {
    int j = 4;
    long l = 0L;
    if ((this.jdField_a_of_type_Boolean) || (!a())) {}
    int k;
    Object localObject;
    do
    {
      do
      {
        do
        {
          return false;
          if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor.b() == -1) || (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor.b() == this.jdField_a_of_type_Int)) {
            break;
          }
        } while (!paramBoolean);
        return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor.a();
        k = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueInputBuffer(0L);
      } while (k < 0);
      localObject = this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[k];
      if (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor.c()) {
        break;
      }
      this.c = true;
      this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(k, 0, 0, 0L, 4);
    } while ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor.b() <= -1L) || (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecDecoder$OnDecoderEventListener == null));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecDecoder$OnDecoderEventListener.a(this);
    return false;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor.b() > -1L) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecDecoder$OnDecoderEventListener != null)) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecDecoder$OnDecoderEventListener.a(this);
    }
    int i = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor.a((ByteBuffer)localObject, 0);
    if (i < 0)
    {
      Log.d(this.jdField_a_of_type_JavaLangString, "EOS input");
      this.jdField_a_of_type_Boolean = true;
      i = 0;
      paramBoolean = false;
      localObject = this.jdField_a_of_type_AndroidMediaMediaCodec;
      if (!this.jdField_a_of_type_Boolean) {
        break label265;
      }
    }
    for (;;)
    {
      ((MediaCodec)localObject).queueInputBuffer(k, 0, i, l, j);
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor.a();
      }
      return paramBoolean;
      l = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor.a();
      paramBoolean = true;
      break;
      label265:
      j = 0;
    }
  }
  
  public long b()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor.b();
  }
  
  public final void b()
  {
    if (this.e) {
      return;
    }
    for (;;)
    {
      int i = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor.b();
      if ((i == -1) || (i == this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Boolean)) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor.a();
    }
  }
  
  public void b(MediaCodecDecoder.FrameInfo paramFrameInfo)
  {
    this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(paramFrameInfo.jdField_a_of_type_Int, false);
    c(paramFrameInfo);
  }
  
  protected final boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecDecoder$FrameInfo != null) {
      a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecDecoder$FrameInfo, 0L);
    }
  }
  
  protected final void c(MediaCodecDecoder.FrameInfo paramFrameInfo)
  {
    paramFrameInfo.a();
    this.jdField_a_of_type_JavaUtilList.add(paramFrameInfo);
  }
  
  protected final boolean c()
  {
    return this.e;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecDecoder$FrameInfo != null) {
      a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecDecoder$FrameInfo);
    }
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor.b();
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidMediaMediaCodec.stop();
    this.jdField_a_of_type_AndroidMediaMediaCodec.release();
    Log.d(this.jdField_a_of_type_JavaLangString, "decoder released");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaCodecDecoder
 * JD-Core Version:    0.7.0.1
 */