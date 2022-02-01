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
  private static String a = "VideoDecoder";
  private int b = 0;
  private int c = 0;
  private MediaCodec.BufferInfo d = new MediaCodec.BufferInfo();
  private MediaExtractor e;
  private MediaCodec f;
  private ByteBuffer g;
  private long h = 0L;
  private long i = 0L;
  private long j = 0L;
  private int k = 0;
  private int l = 0;
  private long m = 0L;
  private String n = "";
  private boolean o = false;
  
  private void a(Surface paramSurface)
  {
    this.e = new MediaExtractor();
    Object localObject;
    try
    {
      this.e.setDataSource(this.n);
    }
    catch (IOException localIOException1)
    {
      str = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("video decoder media extractor setDataSource() exception, msg = ");
      ((StringBuilder)localObject).append(localIOException1.getMessage());
      QLog.e(str, 4, ((StringBuilder)localObject).toString());
    }
    int i2 = this.e.getTrackCount();
    int i1 = 0;
    while (i1 < i2)
    {
      if (this.e.getTrackFormat(i1).getString("mime").contains("video"))
      {
        this.b = i1;
        break;
      }
      i1 += 1;
    }
    i1 = this.b;
    if (i1 == -1)
    {
      this.e.release();
      return;
    }
    MediaFormat localMediaFormat = this.e.getTrackFormat(i1);
    String str = localMediaFormat.getString("mime");
    this.c = localMediaFormat.getInteger("max-input-size");
    this.g = ByteBuffer.allocate(this.c);
    try
    {
      this.f = MediaCodec.createDecoderByType(str);
    }
    catch (IOException localIOException2)
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("video decoder media codec create exception, msg = ");
      localStringBuilder.append(localIOException2.getMessage());
      QLog.e((String)localObject, 4, localStringBuilder.toString());
    }
    this.f.configure(localMediaFormat, paramSurface, null, 0);
    this.f.start();
    this.e.selectTrack(this.b);
    this.e.seekTo(this.h, 0);
  }
  
  /* Error */
  private void a(String paramString, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: new 171	android/media/MediaMetadataRetriever
    //   3: dup
    //   4: invokespecial 172	android/media/MediaMetadataRetriever:<init>	()V
    //   7: astore 7
    //   9: aload_0
    //   10: aload_1
    //   11: putfield 63	com/tencent/aelight/camera/ae/gif/video/VideoDecoder:n	Ljava/lang/String;
    //   14: aload_0
    //   15: lload_2
    //   16: putfield 49	com/tencent/aelight/camera/ae/gif/video/VideoDecoder:h	J
    //   19: aload_0
    //   20: lload 4
    //   22: putfield 51	com/tencent/aelight/camera/ae/gif/video/VideoDecoder:i	J
    //   25: aload 7
    //   27: aload_1
    //   28: invokevirtual 173	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   31: aload 7
    //   33: bipush 24
    //   35: invokevirtual 177	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   38: invokestatic 182	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   41: istore 6
    //   43: aload_0
    //   44: aload 7
    //   46: bipush 18
    //   48: invokevirtual 177	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   51: invokestatic 182	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   54: putfield 55	com/tencent/aelight/camera/ae/gif/video/VideoDecoder:k	I
    //   57: aload_0
    //   58: aload 7
    //   60: bipush 19
    //   62: invokevirtual 177	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   65: invokestatic 182	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   68: putfield 57	com/tencent/aelight/camera/ae/gif/video/VideoDecoder:l	I
    //   71: iload 6
    //   73: bipush 90
    //   75: if_icmpeq +11 -> 86
    //   78: iload 6
    //   80: sipush 270
    //   83: if_icmpne +23 -> 106
    //   86: aload_0
    //   87: getfield 55	com/tencent/aelight/camera/ae/gif/video/VideoDecoder:k	I
    //   90: istore 6
    //   92: aload_0
    //   93: aload_0
    //   94: getfield 57	com/tencent/aelight/camera/ae/gif/video/VideoDecoder:l	I
    //   97: putfield 55	com/tencent/aelight/camera/ae/gif/video/VideoDecoder:k	I
    //   100: aload_0
    //   101: iload 6
    //   103: putfield 57	com/tencent/aelight/camera/ae/gif/video/VideoDecoder:l	I
    //   106: aload_0
    //   107: aload 7
    //   109: bipush 9
    //   111: invokevirtual 177	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   114: invokestatic 188	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   117: putfield 59	com/tencent/aelight/camera/ae/gif/video/VideoDecoder:m	J
    //   120: goto +51 -> 171
    //   123: astore_1
    //   124: goto +53 -> 177
    //   127: astore_1
    //   128: getstatic 79	com/tencent/aelight/camera/ae/gif/video/VideoDecoder:a	Ljava/lang/String;
    //   131: astore 8
    //   133: new 81	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   140: astore 9
    //   142: aload 9
    //   144: ldc 190
    //   146: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload 9
    //   152: aload_1
    //   153: invokevirtual 191	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   156: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload 8
    //   162: iconst_4
    //   163: aload 9
    //   165: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 100	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   171: aload 7
    //   173: invokevirtual 192	android/media/MediaMetadataRetriever:release	()V
    //   176: return
    //   177: aload 7
    //   179: invokevirtual 192	android/media/MediaMetadataRetriever:release	()V
    //   182: aload_1
    //   183: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	VideoDecoder
    //   0	184	1	paramString	String
    //   0	184	2	paramLong1	long
    //   0	184	4	paramLong2	long
    //   41	61	6	i1	int
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
      paramSurface = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("video decoder init exception, msg = ");
      localStringBuilder.append(paramString.getMessage());
      QLog.e(paramSurface, 4, localStringBuilder.toString());
    }
  }
  
  public boolean a()
  {
    QLog.e(a, 4, "decodeToSurface start");
    boolean bool2;
    int i1;
    do
    {
      boolean bool3 = Thread.interrupted();
      bool2 = false;
      bool1 = bool2;
      if (bool3) {
        break;
      }
      QLog.e(a, 4, "decodeToSurface loop");
      if (!this.o)
      {
        i1 = this.f.dequeueInputBuffer(10000L);
        if (i1 >= 0)
        {
          localObject = this.f.getInputBuffers()[i1];
          int i2 = this.e.readSampleData((ByteBuffer)localObject, 0);
          if (i2 < 0)
          {
            QLog.e(a, 4, "decodeToSurface BUFFER_FLAG_END_OF_STREAM");
            this.f.queueInputBuffer(i1, 0, 0, 0L, 4);
            this.o = true;
          }
          else
          {
            QLog.e(a, 4, "decodeToSurface mediaCodec.queueInputBuffer");
            this.f.queueInputBuffer(i1, 0, i2, this.e.getSampleTime(), 0);
            this.e.advance();
          }
        }
      }
      i1 = this.f.dequeueOutputBuffer(this.d, 10000L);
      QLog.e(a, 4, new Object[] { "mediaCodec.dequeueOutputBuffer, outputBufferIndex = ", Integer.valueOf(i1) });
      if ((this.d.flags & 0x4) != 0)
      {
        QLog.e(a, 4, "decodeToSurface decode complete");
        return false;
      }
    } while ((i1 == -3) || (i1 == -2) || (i1 == -1));
    this.j = this.d.presentationTimeUs;
    QLog.e(a, 4, new Object[] { "mediaCodec.releaseOutputBuffer, outputBufferIndex = ", Integer.valueOf(i1), ", timestamp = ", Long.valueOf(this.j) });
    Object localObject = this.f;
    if (this.j < this.i) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((MediaCodec)localObject).releaseOutputBuffer(i1, bool1);
    boolean bool1 = bool2;
    if (this.j < this.i) {
      bool1 = true;
    }
    return bool1;
  }
  
  public void b()
  {
    try
    {
      this.e.unselectTrack(this.b);
      this.e.release();
      this.f.stop();
      this.f.release();
      return;
    }
    catch (Exception localException)
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("video decoder exception, msg = ");
      localStringBuilder.append(localException.getMessage());
      QLog.e(str, 4, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.video.VideoDecoder
 * JD-Core Version:    0.7.0.1
 */