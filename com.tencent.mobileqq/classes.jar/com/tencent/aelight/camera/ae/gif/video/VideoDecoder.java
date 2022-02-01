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
public class VideoDecoder
{
  private static String jdField_a_of_type_JavaLangString = "VideoDecoder";
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private MediaCodec.BufferInfo jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = new MediaCodec.BufferInfo();
  private MediaCodec jdField_a_of_type_AndroidMediaMediaCodec;
  private MediaExtractor jdField_a_of_type_AndroidMediaMediaExtractor;
  private ByteBuffer jdField_a_of_type_JavaNioByteBuffer;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = 0L;
  private String jdField_b_of_type_JavaLangString = "";
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long = 0L;
  private int jdField_d_of_type_Int = 0;
  private long jdField_d_of_type_Long = 0L;
  
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
    this.jdField_b_of_type_Int = localMediaFormat.getInteger("max-input-size");
    this.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocate(this.jdField_b_of_type_Int);
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
    this.jdField_a_of_type_AndroidMediaMediaExtractor.seekTo(this.jdField_a_of_type_Long, 0);
  }
  
  /* Error */
  private void a(String paramString, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: new 161	android/media/MediaMetadataRetriever
    //   3: dup
    //   4: invokespecial 162	android/media/MediaMetadataRetriever:<init>	()V
    //   7: astore 7
    //   9: aload_0
    //   10: aload_1
    //   11: putfield 52	com/tencent/aelight/camera/ae/gif/video/VideoDecoder:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   14: aload_0
    //   15: lload_2
    //   16: putfield 38	com/tencent/aelight/camera/ae/gif/video/VideoDecoder:jdField_a_of_type_Long	J
    //   19: aload_0
    //   20: lload 4
    //   22: putfield 40	com/tencent/aelight/camera/ae/gif/video/VideoDecoder:jdField_b_of_type_Long	J
    //   25: aload 7
    //   27: aload_1
    //   28: invokevirtual 163	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   31: aload 7
    //   33: bipush 24
    //   35: invokevirtual 167	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   38: invokestatic 172	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   41: istore 6
    //   43: aload_0
    //   44: aload 7
    //   46: bipush 18
    //   48: invokevirtual 167	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   51: invokestatic 172	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   54: putfield 44	com/tencent/aelight/camera/ae/gif/video/VideoDecoder:jdField_c_of_type_Int	I
    //   57: aload_0
    //   58: aload 7
    //   60: bipush 19
    //   62: invokevirtual 167	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   65: invokestatic 172	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   68: putfield 46	com/tencent/aelight/camera/ae/gif/video/VideoDecoder:jdField_d_of_type_Int	I
    //   71: iload 6
    //   73: bipush 90
    //   75: if_icmpeq +11 -> 86
    //   78: iload 6
    //   80: sipush 270
    //   83: if_icmpne +23 -> 106
    //   86: aload_0
    //   87: getfield 44	com/tencent/aelight/camera/ae/gif/video/VideoDecoder:jdField_c_of_type_Int	I
    //   90: istore 6
    //   92: aload_0
    //   93: aload_0
    //   94: getfield 46	com/tencent/aelight/camera/ae/gif/video/VideoDecoder:jdField_d_of_type_Int	I
    //   97: putfield 44	com/tencent/aelight/camera/ae/gif/video/VideoDecoder:jdField_c_of_type_Int	I
    //   100: aload_0
    //   101: iload 6
    //   103: putfield 46	com/tencent/aelight/camera/ae/gif/video/VideoDecoder:jdField_d_of_type_Int	I
    //   106: aload_0
    //   107: aload 7
    //   109: bipush 9
    //   111: invokevirtual 167	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   114: invokestatic 178	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   117: putfield 48	com/tencent/aelight/camera/ae/gif/video/VideoDecoder:jdField_d_of_type_Long	J
    //   120: goto +51 -> 171
    //   123: astore_1
    //   124: goto +53 -> 177
    //   127: astore_1
    //   128: getstatic 68	com/tencent/aelight/camera/ae/gif/video/VideoDecoder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   131: astore 8
    //   133: new 70	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   140: astore 9
    //   142: aload 9
    //   144: ldc 180
    //   146: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload 9
    //   152: aload_1
    //   153: invokevirtual 181	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   156: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload 8
    //   162: iconst_4
    //   163: aload 9
    //   165: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 90	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   171: aload 7
    //   173: invokevirtual 182	android/media/MediaMetadataRetriever:release	()V
    //   176: return
    //   177: aload 7
    //   179: invokevirtual 182	android/media/MediaMetadataRetriever:release	()V
    //   182: aload_1
    //   183: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	VideoDecoder
    //   0	184	1	paramString	String
    //   0	184	2	paramLong1	long
    //   0	184	4	paramLong2	long
    //   41	61	6	i	int
    //   7	171	7	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   131	30	8	str	String
    //   140	24	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   9	71	123	finally
    //   86	106	123	finally
    //   106	120	123	finally
    //   128	171	123	finally
    //   9	71	127	java/lang/Exception
    //   86	106	127	java/lang/Exception
    //   106	120	127	java/lang/Exception
  }
  
  public void a()
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
  
  public void a(String paramString, long paramLong1, long paramLong2, Surface paramSurface)
  {
    try
    {
      a(paramString, paramLong1, paramLong2);
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
    boolean bool2;
    int i;
    do
    {
      boolean bool3 = Thread.interrupted();
      bool2 = false;
      bool1 = bool2;
      if (bool3) {
        break;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 4, "decodeToSurface loop");
      if (!this.jdField_a_of_type_Boolean)
      {
        i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueInputBuffer(10000L);
        if (i >= 0)
        {
          localObject = this.jdField_a_of_type_AndroidMediaMediaCodec.getInputBuffers()[i];
          int j = this.jdField_a_of_type_AndroidMediaMediaExtractor.readSampleData((ByteBuffer)localObject, 0);
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
      i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, 10000L);
      QLog.e(jdField_a_of_type_JavaLangString, 4, new Object[] { "mediaCodec.dequeueOutputBuffer, outputBufferIndex = ", Integer.valueOf(i) });
      if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x4) != 0)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 4, "decodeToSurface decode complete");
        return false;
      }
    } while ((i == -3) || (i == -2) || (i == -1));
    this.jdField_c_of_type_Long = this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs;
    QLog.e(jdField_a_of_type_JavaLangString, 4, new Object[] { "mediaCodec.releaseOutputBuffer, outputBufferIndex = ", Integer.valueOf(i), ", timestamp = ", Long.valueOf(this.jdField_c_of_type_Long) });
    Object localObject = this.jdField_a_of_type_AndroidMediaMediaCodec;
    if (this.jdField_c_of_type_Long < this.jdField_b_of_type_Long) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((MediaCodec)localObject).releaseOutputBuffer(i, bool1);
    boolean bool1 = bool2;
    if (this.jdField_c_of_type_Long < this.jdField_b_of_type_Long) {
      bool1 = true;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.video.VideoDecoder
 * JD-Core Version:    0.7.0.1
 */