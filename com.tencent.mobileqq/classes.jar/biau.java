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
public class biau
{
  private static String jdField_a_of_type_JavaLangString = biau.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long = 0L;
  private MediaCodec.BufferInfo jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = new MediaCodec.BufferInfo();
  private MediaCodec jdField_a_of_type_AndroidMediaMediaCodec;
  private MediaExtractor jdField_a_of_type_AndroidMediaMediaExtractor;
  private boolean jdField_a_of_type_Boolean;
  private final long jdField_b_of_type_Long = 2147483647L;
  private String jdField_b_of_type_JavaLangString = "";
  private long c;
  
  private void a(Surface paramSurface)
  {
    this.jdField_a_of_type_AndroidMediaMediaExtractor = new MediaExtractor();
    label121:
    MediaFormat localMediaFormat;
    String str;
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaExtractor.setDataSource(this.jdField_b_of_type_JavaLangString);
      int j = this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackCount();
      i = 0;
      if (i < j)
      {
        if (this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackFormat(i).getString("mime").contains("video")) {
          this.jdField_a_of_type_Int = i;
        }
      }
      else
      {
        if (this.jdField_a_of_type_Int != -1) {
          break label121;
        }
        this.jdField_a_of_type_AndroidMediaMediaExtractor.release();
        return;
      }
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        int i;
        QLog.e(jdField_a_of_type_JavaLangString, 4, "video decoder media extractor setDataSource() exception, msg = " + localIOException1.getMessage());
        continue;
        i += 1;
      }
      localMediaFormat = this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackFormat(this.jdField_a_of_type_Int);
      str = localMediaFormat.getString("mime");
    }
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createDecoderByType(str);
      this.jdField_a_of_type_AndroidMediaMediaCodec.configure(localMediaFormat, paramSurface, null, 0);
      this.jdField_a_of_type_AndroidMediaMediaCodec.start();
      this.jdField_a_of_type_AndroidMediaMediaExtractor.selectTrack(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidMediaMediaExtractor.seekTo(0L, 0);
      return;
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 4, "video decoder media codec create exception, msg = " + localIOException2.getMessage());
      }
    }
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
      QLog.e(jdField_a_of_type_JavaLangString, 4, "video decoder init exception, msg = " + paramString.getMessage());
    }
  }
  
  public boolean a()
  {
    QLog.e(jdField_a_of_type_JavaLangString, 4, "decodeToSurface start");
    if (!Thread.interrupted())
    {
      QLog.e(jdField_a_of_type_JavaLangString, 4, "decodeToSurface loop");
      int i;
      Object localObject;
      if (!this.jdField_a_of_type_Boolean)
      {
        i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueInputBuffer(10000L);
        if (i >= 0)
        {
          localObject = this.jdField_a_of_type_AndroidMediaMediaCodec.getInputBuffers()[i];
          j = this.jdField_a_of_type_AndroidMediaMediaExtractor.readSampleData((ByteBuffer)localObject, 0);
          if (j >= 0) {
            break label261;
          }
          QLog.e(jdField_a_of_type_JavaLangString, 4, "decodeToSurface BUFFER_FLAG_END_OF_STREAM");
          this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, 0, 0L, 4);
          this.jdField_a_of_type_Boolean = true;
        }
      }
      int j = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, 10000L);
      QLog.e(jdField_a_of_type_JavaLangString, 4, new Object[] { "mediaCodec.dequeueOutputBuffer, outputBufferIndex = ", Integer.valueOf(j) });
      switch (j)
      {
      }
      this.c = this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs;
      QLog.e(jdField_a_of_type_JavaLangString, 4, new Object[] { "mediaCodec.releaseOutputBuffer, outputBufferIndex = ", Integer.valueOf(j), ", timestamp = ", Long.valueOf(this.c) });
      if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x4) != 0)
      {
        i = 1;
        label227:
        localObject = this.jdField_a_of_type_AndroidMediaMediaCodec;
        if (i != 0) {
          break label304;
        }
      }
      label261:
      label304:
      for (boolean bool = true;; bool = false)
      {
        ((MediaCodec)localObject).releaseOutputBuffer(j, bool);
        if (i == 0) {
          break label309;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 4, "decodeToSurface decode complete");
        return false;
        QLog.e(jdField_a_of_type_JavaLangString, 4, "decodeToSurface mediaCodec.queueInputBuffer");
        this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, j, this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTime(), 0);
        this.jdField_a_of_type_AndroidMediaMediaExtractor.advance();
        break;
        i = 0;
        break label227;
      }
      label309:
      return true;
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
      QLog.e(jdField_a_of_type_JavaLangString, 4, "video decoder exception, msg = " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biau
 * JD-Core Version:    0.7.0.1
 */