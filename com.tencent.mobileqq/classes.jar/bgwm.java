import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class bgwm
{
  private int jdField_a_of_type_Int = -1;
  private MediaCodec jdField_a_of_type_AndroidMediaMediaCodec;
  private MediaExtractor jdField_a_of_type_AndroidMediaMediaExtractor;
  private MediaFormat jdField_a_of_type_AndroidMediaMediaFormat;
  private bgwo jdField_a_of_type_Bgwo;
  private boolean jdField_a_of_type_Boolean = true;
  
  @RequiresApi(api=16)
  private boolean a()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackCount())
        {
          MediaFormat localMediaFormat = this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackFormat(i);
          String str = localMediaFormat.getString("mime");
          if (str.startsWith("audio"))
          {
            this.jdField_a_of_type_AndroidMediaMediaExtractor.selectTrack(i);
            this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createDecoderByType(str);
            this.jdField_a_of_type_AndroidMediaMediaCodec.configure(localMediaFormat, null, null, 0);
          }
        }
        else
        {
          if (this.jdField_a_of_type_AndroidMediaMediaCodec == null) {
            return false;
          }
          this.jdField_a_of_type_AndroidMediaMediaCodec.start();
          return true;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return false;
      }
      i += 1;
    }
  }
  
  @RequiresApi(api=16)
  private boolean a(String paramString)
  {
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaExtractor = new MediaExtractor();
      this.jdField_a_of_type_AndroidMediaMediaExtractor.setDataSource(paramString);
      return true;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  @RequiresApi(api=23)
  private boolean a(byte[] paramArrayOfByte)
  {
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaExtractor = new MediaExtractor();
      this.jdField_a_of_type_AndroidMediaMediaExtractor.setDataSource(new bgwn(this, paramArrayOfByte));
      return true;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return false;
  }
  
  @RequiresApi(api=16)
  private byte[] a()
  {
    int k = 0;
    int i = 0;
    ByteBuffer[] arrayOfByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getInputBuffers();
    Object localObject1 = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
    MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int j = 0;
    if ((k != 0) || (j == 0)) {}
    label493:
    label496:
    label499:
    for (;;)
    {
      try
      {
        int m = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueInputBuffer(2000L);
        if (m < 0) {
          break label499;
        }
        ByteBuffer localByteBuffer = arrayOfByteBuffer[m];
        int n = this.jdField_a_of_type_AndroidMediaMediaExtractor.readSampleData(localByteBuffer, 0);
        if (n < 0)
        {
          this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(m, 0, 0, 0L, 4);
          j = 1;
          m = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(localBufferInfo, 2000L);
          if (m < 0) {
            continue;
          }
          if ((localBufferInfo.flags & 0x2) == 0) {
            continue;
          }
          this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(m, false);
          break;
        }
        long l = this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTime();
        this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(m, 0, n, l, 0);
        this.jdField_a_of_type_AndroidMediaMediaExtractor.advance();
        break label499;
        if (localBufferInfo.size == 0) {
          break label496;
        }
        localByteBuffer = localObject1[m];
        byte[] arrayOfByte = new byte[localBufferInfo.size];
        localByteBuffer.get(arrayOfByte);
        if (this.jdField_a_of_type_Bgwo != null)
        {
          this.jdField_a_of_type_Bgwo.a(arrayOfByte, this.jdField_a_of_type_AndroidMediaMediaFormat, this.jdField_a_of_type_Boolean, false);
          this.jdField_a_of_type_Boolean = false;
        }
        i = arrayOfByte.length + i;
        localByteArrayOutputStream.write(arrayOfByte);
        this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(m, false);
        if ((localBufferInfo.flags & 0x4) == 0) {
          break label493;
        }
        k = 1;
        break label502;
        if (m == -3)
        {
          localObject1 = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
        }
        else
        {
          if (m != -2) {
            break label505;
          }
          this.jdField_a_of_type_AndroidMediaMediaFormat = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat();
          Log.i("AudioDecoder", "output format has changed to " + this.jdField_a_of_type_AndroidMediaMediaFormat);
        }
      }
      catch (Exception localException1)
      {
        localException1 = localException1;
        localException1.printStackTrace();
      }
      finally
      {
        try
        {
          localByteArrayOutputStream.close();
          this.jdField_a_of_type_AndroidMediaMediaCodec.stop();
          this.jdField_a_of_type_AndroidMediaMediaCodec.release();
          this.jdField_a_of_type_AndroidMediaMediaExtractor.release();
          return null;
          localObject2 = finally;
          try
          {
            localByteArrayOutputStream.close();
            this.jdField_a_of_type_AndroidMediaMediaCodec.stop();
            this.jdField_a_of_type_AndroidMediaMediaCodec.release();
            this.jdField_a_of_type_AndroidMediaMediaExtractor.release();
            throw localObject2;
          }
          catch (Exception localException3)
          {
            continue;
          }
        }
        catch (Exception localException2)
        {
          continue;
        }
      }
      if (this.jdField_a_of_type_Bgwo != null) {
        this.jdField_a_of_type_Bgwo.a(null, this.jdField_a_of_type_AndroidMediaMediaFormat, false, true);
      }
      localObject1 = localByteArrayOutputStream.toByteArray();
      break label502;
    }
    label502:
    label505:
    for (;;)
    {
      break;
    }
  }
  
  @RequiresApi(api=16)
  public int a()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaFormat == null) {
      return 0;
    }
    return this.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("sample-rate");
  }
  
  public void a(bgwo parambgwo)
  {
    this.jdField_a_of_type_Bgwo = parambgwo;
  }
  
  @RequiresApi(api=16)
  public byte[] a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if ((a(paramString)) && (a())) {
      return a();
    }
    return null;
  }
  
  @RequiresApi(api=23)
  public byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if ((a(paramArrayOfByte)) && (a())) {
      return a();
    }
    return null;
  }
  
  @RequiresApi(api=16)
  public int b()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaFormat == null) {
      return 0;
    }
    return this.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("channel-count");
  }
  
  @RequiresApi(api=16)
  public int c()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaFormat == null) {
      return 0;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      if (this.jdField_a_of_type_AndroidMediaMediaFormat.containsKey("pcm-encoding")) {}
      for (int i = this.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("pcm-encoding"); i == 3; i = 2) {
        return 8;
      }
      return 16;
    }
    return this.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("bit-width");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgwm
 * JD-Core Version:    0.7.0.1
 */