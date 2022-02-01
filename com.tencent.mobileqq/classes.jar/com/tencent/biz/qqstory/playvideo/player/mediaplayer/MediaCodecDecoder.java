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
    if ((paramMediaExtractor != null) && (paramInt != -1))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor = paramMediaExtractor;
      this.e = paramBoolean;
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaExtractor.a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecDecoder$OnDecoderEventListener = paramOnDecoderEventListener;
      this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createDecoderByType(this.jdField_a_of_type_AndroidMediaMediaFormat.getString("mime"));
      this.jdField_a_of_type_Long = -9223372036854775808L;
      return;
    }
    throw new IllegalArgumentException("no track specified");
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
    if ((i >= 0) && ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x4) != 0)) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_b_of_type_Boolean = bool;
    if ((this.jdField_b_of_type_Boolean) && (this.c))
    {
      a();
      this.jdField_b_of_type_Boolean = false;
      this.c = false;
      this.d = true;
      return null;
    }
    Object localObject1;
    Object localObject2;
    if (i >= 0)
    {
      localObject1 = this.jdField_b_of_type_ArrayOfJavaNioByteBuffer[i];
      if ((localObject1 != null) && (this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size != 0))
      {
        ((ByteBuffer)localObject1).position(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset);
        ((ByteBuffer)localObject1).limit(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset + this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size);
      }
      localObject2 = (MediaCodecDecoder.FrameInfo)this.jdField_a_of_type_JavaUtilList.get(0);
      ((MediaCodecDecoder.FrameInfo)localObject2).jdField_a_of_type_Int = i;
      ((MediaCodecDecoder.FrameInfo)localObject2).jdField_a_of_type_JavaNioByteBuffer = ((ByteBuffer)localObject1);
      ((MediaCodecDecoder.FrameInfo)localObject2).jdField_a_of_type_Long = this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs;
      ((MediaCodecDecoder.FrameInfo)localObject2).jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
      if (this.d)
      {
        this.d = false;
        ((MediaCodecDecoder.FrameInfo)localObject2).jdField_b_of_type_Boolean = true;
      }
      if (((MediaCodecDecoder.FrameInfo)localObject2).jdField_a_of_type_Boolean)
      {
        Log.d(this.jdField_a_of_type_JavaLangString, "EOS output");
        return localObject2;
      }
      this.jdField_a_of_type_Long = ((MediaCodecDecoder.FrameInfo)localObject2).jdField_a_of_type_Long;
      return localObject2;
    }
    if (i == -3)
    {
      this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
      Log.d(this.jdField_a_of_type_JavaLangString, "output buffers have changed.");
      return null;
    }
    if (i == -2)
    {
      localObject1 = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat();
      localObject2 = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("output format has changed to ");
      localStringBuilder.append(localObject1);
      Log.d((String)localObject2, localStringBuilder.toString());
      a((MediaFormat)localObject1);
    }
    return null;
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
    Object localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seeking to:                 ");
    localStringBuilder.append(paramLong);
    Log.d((String)localObject, localStringBuilder.toString());
    localObject = this.jdField_a_of_type_JavaLangString;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("extractor current position: ");
    localStringBuilder.append(paramMediaExtractor.a());
    Log.d((String)localObject, localStringBuilder.toString());
    paramMediaExtractor.a(paramLong, paramSeekMode.a());
    paramSeekMode = this.jdField_a_of_type_JavaLangString;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("extractor new position:     ");
    ((StringBuilder)localObject).append(paramMediaExtractor.a());
    Log.d(paramSeekMode, ((StringBuilder)localObject).toString());
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
      int i = 0;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      while (i < this.jdField_b_of_type_ArrayOfJavaNioByteBuffer.length)
      {
        this.jdField_a_of_type_JavaUtilList.add(new MediaCodecDecoder.FrameInfo());
        i += 1;
      }
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reinitCodec ");
      localStringBuilder.append(SystemClock.elapsedRealtime() - l);
      localStringBuilder.append("ms");
      Log.d(str, localStringBuilder.toString());
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec.release();
      Log.e(this.jdField_a_of_type_JavaLangString, "reinitCodec: illegal state");
      throw localIllegalStateException;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec.release();
      Log.e(this.jdField_a_of_type_JavaLangString, "reinitCodec: invalid surface or format");
    }
    for (;;)
    {
      throw localIllegalArgumentException;
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
    if (!this.jdField_a_of_type_Boolean)
    {
      if (!a()) {
        return false;
      }
      if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor.b() != -1) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor.b() != this.jdField_a_of_type_Int))
      {
        if (paramBoolean) {
          return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor.a();
        }
        return false;
      }
      int k = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueInputBuffer(0L);
      if (k >= 0)
      {
        Object localObject = this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[k];
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor.c())
        {
          this.c = true;
          this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(k, 0, 0, 0L, 4);
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor.b() > -1L)
          {
            localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecDecoder$OnDecoderEventListener;
            if (localObject != null) {
              ((MediaCodecDecoder.OnDecoderEventListener)localObject).a(this);
            }
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor.b() > -1L)
          {
            MediaCodecDecoder.OnDecoderEventListener localOnDecoderEventListener = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecDecoder$OnDecoderEventListener;
            if (localOnDecoderEventListener != null) {
              localOnDecoderEventListener.a(this);
            }
          }
          int i = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor.a((ByteBuffer)localObject, 0);
          long l;
          if (i < 0)
          {
            Log.d(this.jdField_a_of_type_JavaLangString, "EOS input");
            this.jdField_a_of_type_Boolean = true;
            l = 0L;
            paramBoolean = false;
            i = 0;
          }
          else
          {
            l = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor.a();
            paramBoolean = true;
          }
          localObject = this.jdField_a_of_type_AndroidMediaMediaCodec;
          int j;
          if (this.jdField_a_of_type_Boolean) {
            j = 4;
          } else {
            j = 0;
          }
          ((MediaCodec)localObject).queueInputBuffer(k, 0, i, l, j);
          bool = paramBoolean;
          if (this.jdField_a_of_type_Boolean) {
            break label283;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaExtractor.a();
          return paramBoolean;
        }
      }
      boolean bool = false;
      label283:
      return bool;
    }
    return false;
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
    MediaCodecDecoder.FrameInfo localFrameInfo = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecDecoder$FrameInfo;
    if (localFrameInfo != null) {
      a(localFrameInfo, 0L);
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
    MediaCodecDecoder.FrameInfo localFrameInfo = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaCodecDecoder$FrameInfo;
    if (localFrameInfo != null) {
      a(localFrameInfo);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaCodecDecoder
 * JD-Core Version:    0.7.0.1
 */