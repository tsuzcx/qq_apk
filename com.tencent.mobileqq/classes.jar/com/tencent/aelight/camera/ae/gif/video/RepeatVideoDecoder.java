package com.tencent.aelight.camera.ae.gif.video;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.nio.ByteBuffer;

@TargetApi(16)
public class RepeatVideoDecoder
{
  private static String jdField_a_of_type_JavaLangString = "RepeatVideoDecoder";
  private int jdField_a_of_type_Int = 0;
  private final long jdField_a_of_type_Long = 0L;
  private MediaCodec.BufferInfo jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = new MediaCodec.BufferInfo();
  private MediaCodec jdField_a_of_type_AndroidMediaMediaCodec;
  private MediaExtractor jdField_a_of_type_AndroidMediaMediaExtractor;
  private boolean jdField_a_of_type_Boolean = false;
  private final long jdField_b_of_type_Long = 2147483647L;
  private String jdField_b_of_type_JavaLangString = "";
  private long c = 0L;
  
  private void a(Surface paramSurface)
  {
    this.jdField_a_of_type_AndroidMediaMediaExtractor = new MediaExtractor();
    Object localObject;
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaExtractor.setDataSource(this.jdField_b_of_type_JavaLangString);
    }
    catch (IOException localIOException1)
    {
      str = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("video decoder media extractor setDataSource() exception, msg = ");
      ((StringBuilder)localObject).append(localIOException1.getMessage());
      QLog.e(str, 4, ((StringBuilder)localObject).toString());
    }
    int j = this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackCount();
    int i = 0;
    while (i < j)
    {
      if (this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackFormat(i).getString("mime").contains("video"))
      {
        this.jdField_a_of_type_Int = i;
        break;
      }
      i += 1;
    }
    i = this.jdField_a_of_type_Int;
    if (i == -1)
    {
      this.jdField_a_of_type_AndroidMediaMediaExtractor.release();
      return;
    }
    MediaFormat localMediaFormat = this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackFormat(i);
    String str = localMediaFormat.getString("mime");
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createDecoderByType(str);
    }
    catch (IOException localIOException2)
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("video decoder media codec create exception, msg = ");
      localStringBuilder.append(localIOException2.getMessage());
      QLog.e((String)localObject, 4, localStringBuilder.toString());
    }
    this.jdField_a_of_type_AndroidMediaMediaCodec.configure(localMediaFormat, paramSurface, null, 0);
    this.jdField_a_of_type_AndroidMediaMediaCodec.start();
    this.jdField_a_of_type_AndroidMediaMediaExtractor.selectTrack(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidMediaMediaExtractor.seekTo(0L, 0);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidMediaMediaExtractor.seekTo(0L, 1);
      this.jdField_a_of_type_AndroidMediaMediaCodec.flush();
    }
  }
  
  public void a(String paramString, Surface paramSurface)
  {
    try
    {
      this.jdField_b_of_type_JavaLangString = paramString;
      a(paramSurface);
      return;
    }
    catch (Exception paramString)
    {
      paramSurface = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("video decoder init exception, msg = ");
      localStringBuilder.append(paramString.getMessage());
      QLog.e(paramSurface, 4, localStringBuilder.toString());
    }
  }
  
  public boolean a()
  {
    QLog.e(jdField_a_of_type_JavaLangString, 4, "decodeToSurface start");
    while (!Thread.interrupted())
    {
      QLog.e(jdField_a_of_type_JavaLangString, 4, "decodeToSurface loop");
      int i;
      if (!this.jdField_a_of_type_Boolean)
      {
        i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueInputBuffer(10000L);
        if (i >= 0)
        {
          ByteBuffer localByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getInputBuffers()[i];
          j = this.jdField_a_of_type_AndroidMediaMediaExtractor.readSampleData(localByteBuffer, 0);
          if (j < 0)
          {
            QLog.e(jdField_a_of_type_JavaLangString, 4, "decodeToSurface BUFFER_FLAG_END_OF_STREAM");
            this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, 0, 0L, 4);
            this.jdField_a_of_type_Boolean = true;
          }
          else
          {
            QLog.e(jdField_a_of_type_JavaLangString, 4, "decodeToSurface mediaCodec.queueInputBuffer");
            this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, j, this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTime(), 0);
            this.jdField_a_of_type_AndroidMediaMediaExtractor.advance();
          }
        }
      }
      int j = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, 10000L);
      QLog.e(jdField_a_of_type_JavaLangString, 4, new Object[] { "mediaCodec.dequeueOutputBuffer, outputBufferIndex = ", Integer.valueOf(j) });
      if ((j != -3) && (j != -2) && (j != -1))
      {
        this.c = this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs;
        QLog.e(jdField_a_of_type_JavaLangString, 4, new Object[] { "mediaCodec.releaseOutputBuffer, outputBufferIndex = ", Integer.valueOf(j), ", timestamp = ", Long.valueOf(this.c) });
        if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x4) != 0) {
          i = 1;
        } else {
          i = 0;
        }
        this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(j, i ^ 0x1);
        if (i != 0)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 4, "decodeToSurface decode complete");
          return false;
        }
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaExtractor.unselectTrack(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidMediaMediaExtractor.release();
      this.jdField_a_of_type_AndroidMediaMediaCodec.stop();
      this.jdField_a_of_type_AndroidMediaMediaCodec.release();
      return;
    }
    catch (Exception localException)
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("video decoder exception, msg = ");
      localStringBuilder.append(localException.getMessage());
      QLog.e(str, 4, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.video.RepeatVideoDecoder
 * JD-Core Version:    0.7.0.1
 */