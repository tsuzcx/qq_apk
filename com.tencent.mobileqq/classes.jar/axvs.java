import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@TargetApi(18)
public class axvs
{
  private int jdField_a_of_type_Int = 1024;
  private long jdField_a_of_type_Long;
  private final MediaCodec.BufferInfo jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = new MediaCodec.BufferInfo();
  private MediaExtractor jdField_a_of_type_AndroidMediaMediaExtractor;
  private axvt jdField_a_of_type_Axvt;
  private final axwb jdField_a_of_type_Axwb;
  private final DecodeConfig jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig;
  private ByteBuffer jdField_a_of_type_JavaNioByteBuffer;
  private boolean b;
  private volatile boolean c;
  private volatile boolean d;
  
  static
  {
    if (!axvs.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public axvs(DecodeConfig paramDecodeConfig, axwb paramaxwb)
  {
    this.jdField_a_of_type_Axwb = paramaxwb;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig = paramDecodeConfig;
    this.jdField_a_of_type_Long = (paramDecodeConfig.endTimeMillSecond * 1000L);
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaExtractor = new MediaExtractor();
      this.jdField_a_of_type_AndroidMediaMediaExtractor.setDataSource(paramDecodeConfig.inputFilePath);
      this.jdField_a_of_type_Axvt = a(this.jdField_a_of_type_AndroidMediaMediaExtractor);
      if (this.jdField_a_of_type_Axvt.jdField_a_of_type_Int >= 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("HWAudioRecoder", 1, "audio track normal");
        }
        this.jdField_a_of_type_Axwb.a(1, this.jdField_a_of_type_Axvt.jdField_a_of_type_AndroidMediaMediaFormat);
        this.jdField_a_of_type_AndroidMediaMediaExtractor.selectTrack(this.jdField_a_of_type_Axvt.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_Axvt.jdField_a_of_type_AndroidMediaMediaFormat.containsKey("max-input-size")) {
          this.jdField_a_of_type_Int = this.jdField_a_of_type_Axvt.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("max-input-size");
        }
        if (this.jdField_a_of_type_Axvt.jdField_b_of_type_Int >= 0)
        {
          this.jdField_a_of_type_Axwb.a(2);
          this.jdField_a_of_type_Axwb.a(2, this.jdField_a_of_type_Axvt.jdField_b_of_type_AndroidMediaMediaFormat);
          this.jdField_a_of_type_AndroidMediaMediaExtractor.selectTrack(this.jdField_a_of_type_Axvt.jdField_b_of_type_Int);
          if (this.jdField_a_of_type_Axvt.jdField_b_of_type_AndroidMediaMediaFormat.containsKey("max-input-size"))
          {
            int i = this.jdField_a_of_type_Axvt.jdField_b_of_type_AndroidMediaMediaFormat.getInteger("max-input-size");
            if (i > this.jdField_a_of_type_Int) {
              this.jdField_a_of_type_Int = i;
            }
          }
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocateDirect(this.jdField_a_of_type_Int).order(ByteOrder.nativeOrder());
        this.jdField_a_of_type_AndroidMediaMediaExtractor.seekTo(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.startTimeMillSecond * 1000L, 0);
        return;
        this.jdField_a_of_type_Axwb.a(0);
        this.jdField_a_of_type_Axwb.a(1, null);
        if (QLog.isColorLevel()) {
          QLog.d("HWAudioRecoder", 1, "no audio track");
        }
      }
      return;
    }
    catch (Exception paramDecodeConfig)
    {
      QLog.e("HWAudioRecoder", 1, "getAudioTrack,", paramDecodeConfig);
    }
  }
  
  public axvt a(MediaExtractor paramMediaExtractor)
  {
    axvt localaxvt = new axvt();
    int j = paramMediaExtractor.getTrackCount();
    long l2 = 0L;
    int i = 0;
    MediaFormat localMediaFormat;
    String str;
    long l1;
    if (i < j)
    {
      localMediaFormat = paramMediaExtractor.getTrackFormat(i);
      str = localMediaFormat.getString("mime");
      l1 = l2;
      if (localaxvt.jdField_a_of_type_Int >= 0) {
        break label206;
      }
      l1 = l2;
      if (!str.startsWith("audio/")) {
        break label206;
      }
      l2 += 1L;
      if (l2 == 1L)
      {
        localaxvt.jdField_a_of_type_Int = i;
        localaxvt.jdField_a_of_type_JavaLangString = str;
        localaxvt.jdField_a_of_type_AndroidMediaMediaFormat = localMediaFormat;
        label99:
        l1 = l2;
        if (l2 < 2L) {
          break label206;
        }
      }
    }
    else
    {
      if (localaxvt.jdField_a_of_type_Int < 0) {
        break label217;
      }
    }
    label206:
    label217:
    for (boolean bool = true;; bool = false)
    {
      this.b = bool;
      QLog.d("HWAudioRecoder", 1, new Object[] { "getAudioTrack, ", Integer.valueOf(localaxvt.jdField_a_of_type_Int), " ", Integer.valueOf(localaxvt.jdField_b_of_type_Int) });
      return localaxvt;
      if (l2 != 2L) {
        break label99;
      }
      localaxvt.jdField_b_of_type_Int = i;
      localaxvt.jdField_b_of_type_JavaLangString = str;
      localaxvt.jdField_b_of_type_AndroidMediaMediaFormat = localMediaFormat;
      break label99;
      i += 1;
      l2 = l1;
      break;
    }
  }
  
  public void a()
  {
    QLog.d("HWAudioRecoder", 1, "stopRecording audio");
    while ((!a()) && (b())) {}
    QLog.d("HWAudioRecoder", 1, "stopRecording audio, indeed");
    this.jdField_a_of_type_Axwb.a();
    if (this.jdField_a_of_type_AndroidMediaMediaExtractor != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaExtractor.release();
      this.jdField_a_of_type_AndroidMediaMediaExtractor = null;
    }
  }
  
  public boolean a()
  {
    if (!this.b) {}
    do
    {
      return true;
      if (this.jdField_a_of_type_Axvt.jdField_b_of_type_Int < 0) {
        return this.c;
      }
    } while ((this.c) && (this.d));
    return false;
  }
  
  public boolean b()
  {
    int i = 2;
    if ((!this.b) || (a())) {
      return false;
    }
    int j = this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTrackIndex();
    if (j < 0)
    {
      this.jdField_a_of_type_JavaNioByteBuffer.clear();
      this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.set(0, 0, 0L, 4);
      this.jdField_a_of_type_Axwb.a(1, this.jdField_a_of_type_JavaNioByteBuffer, this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
      this.jdField_a_of_type_Axwb.a(2, this.jdField_a_of_type_JavaNioByteBuffer, this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
      this.c = true;
      this.d = true;
      return true;
    }
    if (j == this.jdField_a_of_type_Axvt.jdField_a_of_type_Int) {
      i = 1;
    }
    int k;
    long l;
    while (j == this.jdField_a_of_type_Axvt.jdField_b_of_type_Int)
    {
      this.jdField_a_of_type_JavaNioByteBuffer.clear();
      k = this.jdField_a_of_type_AndroidMediaMediaExtractor.readSampleData(this.jdField_a_of_type_JavaNioByteBuffer, 0);
      l = this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTime();
      if ((jdField_a_of_type_Boolean) || (k <= this.jdField_a_of_type_Int)) {
        break;
      }
      throw new AssertionError();
    }
    return false;
    if ((k < 0) || ((this.jdField_a_of_type_Long > 0L) && (l > this.jdField_a_of_type_Long)))
    {
      this.jdField_a_of_type_JavaNioByteBuffer.clear();
      this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.set(0, 0, 0L, 4);
      this.jdField_a_of_type_Axwb.a(i, this.jdField_a_of_type_JavaNioByteBuffer, this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
      if (j == this.jdField_a_of_type_Axvt.jdField_a_of_type_Int)
      {
        this.c = true;
        return true;
      }
      this.d = true;
      return true;
    }
    if ((this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleFlags() & 0x1) != 0)
    {
      j = 1;
      if (j == 0) {
        break label322;
      }
    }
    label322:
    for (j = 1;; j = 0)
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.set(0, k, this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTime(), j);
      this.jdField_a_of_type_Axwb.a(i, this.jdField_a_of_type_JavaNioByteBuffer, this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
      this.jdField_a_of_type_AndroidMediaMediaExtractor.advance();
      return true;
      j = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axvs
 * JD-Core Version:    0.7.0.1
 */