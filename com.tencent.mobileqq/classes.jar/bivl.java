import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.view.Surface;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.nio.ByteBuffer;

@TargetApi(16)
public class bivl
{
  private static String jdField_a_of_type_JavaLangString = bivl.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private MediaCodec.BufferInfo jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = new MediaCodec.BufferInfo();
  private MediaCodec jdField_a_of_type_AndroidMediaMediaCodec;
  private MediaExtractor jdField_a_of_type_AndroidMediaMediaExtractor;
  private ByteBuffer jdField_a_of_type_JavaNioByteBuffer;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString = "";
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  
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
      this.jdField_b_of_type_Int = localMediaFormat.getInteger("max-input-size");
      this.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocate(this.jdField_b_of_type_Int);
    }
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createDecoderByType(str);
      this.jdField_a_of_type_AndroidMediaMediaCodec.configure(localMediaFormat, paramSurface, null, 0);
      this.jdField_a_of_type_AndroidMediaMediaCodec.start();
      this.jdField_a_of_type_AndroidMediaMediaExtractor.selectTrack(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidMediaMediaExtractor.seekTo(this.jdField_a_of_type_Long, 0);
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
  
  private void a(String paramString, long paramLong1, long paramLong2)
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    try
    {
      this.jdField_b_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_Long = paramLong1;
      this.jdField_b_of_type_Long = paramLong2;
      localMediaMetadataRetriever.setDataSource(paramString);
      int i = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(24));
      this.jdField_c_of_type_Int = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(18));
      this.jdField_d_of_type_Int = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(19));
      if ((i == 90) || (i == 270))
      {
        i = this.jdField_c_of_type_Int;
        this.jdField_c_of_type_Int = this.jdField_d_of_type_Int;
        this.jdField_d_of_type_Int = i;
      }
      this.jdField_d_of_type_Long = Long.parseLong(localMediaMetadataRetriever.extractMetadata(9));
      return;
    }
    catch (Exception paramString)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 4, "video decoder init parameters exception, msg = " + paramString.getMessage());
      return;
    }
    finally
    {
      localMediaMetadataRetriever.release();
    }
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
      QLog.e(jdField_a_of_type_JavaLangString, 4, "video decoder exception, msg = " + localException.getMessage());
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
      int j;
      if (!this.jdField_a_of_type_Boolean)
      {
        i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueInputBuffer(10000L);
        if (i >= 0)
        {
          localObject = this.jdField_a_of_type_AndroidMediaMediaCodec.getInputBuffers()[i];
          j = this.jdField_a_of_type_AndroidMediaMediaExtractor.readSampleData((ByteBuffer)localObject, 0);
          if (j >= 0) {
            break label159;
          }
          QLog.e(jdField_a_of_type_JavaLangString, 4, "decodeToSurface BUFFER_FLAG_END_OF_STREAM");
          this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, 0, 0L, 4);
          this.jdField_a_of_type_Boolean = true;
        }
      }
      for (;;)
      {
        i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, 10000L);
        QLog.e(jdField_a_of_type_JavaLangString, 4, new Object[] { "mediaCodec.dequeueOutputBuffer, outputBufferIndex = ", Integer.valueOf(i) });
        if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x4) == 0) {
          break;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 4, "decodeToSurface decode complete");
        return false;
        label159:
        QLog.e(jdField_a_of_type_JavaLangString, 4, "decodeToSurface mediaCodec.queueInputBuffer");
        this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, j, this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTime(), 0);
        this.jdField_a_of_type_AndroidMediaMediaExtractor.advance();
      }
      switch (i)
      {
      }
      this.jdField_c_of_type_Long = this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs;
      QLog.e(jdField_a_of_type_JavaLangString, 4, new Object[] { "mediaCodec.releaseOutputBuffer, outputBufferIndex = ", Integer.valueOf(i), ", timestamp = ", Long.valueOf(this.jdField_c_of_type_Long) });
      Object localObject = this.jdField_a_of_type_AndroidMediaMediaCodec;
      if (this.jdField_c_of_type_Long < this.jdField_b_of_type_Long) {}
      for (boolean bool = true;; bool = false)
      {
        ((MediaCodec)localObject).releaseOutputBuffer(i, bool);
        if (this.jdField_c_of_type_Long >= this.jdField_b_of_type_Long) {
          break;
        }
        return true;
      }
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bivl
 * JD-Core Version:    0.7.0.1
 */