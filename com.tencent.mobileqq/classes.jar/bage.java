import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.ByteBuffer;

@TargetApi(18)
public class bage
{
  private double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private MediaCodec.BufferInfo jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = new MediaCodec.BufferInfo();
  private MediaCodec jdField_a_of_type_AndroidMediaMediaCodec;
  private MediaFormat jdField_a_of_type_AndroidMediaMediaFormat;
  private MediaMuxer jdField_a_of_type_AndroidMediaMediaMuxer;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = ThreadManagerV2.newFreeHandlerThread("HWAudioEncoder", 0);
  bagg jdField_a_of_type_Bagg;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  
  public bage()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new bagf(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
  }
  
  private void b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidMediaMediaFormat = new MediaFormat();
    this.jdField_a_of_type_AndroidMediaMediaFormat.setString("mime", "audio/mp4a-latm");
    int i;
    if (CodecParam.mAudioChannel == 16)
    {
      i = 1;
      this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("channel-count", i);
      this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("sample-rate", this.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("aac-profile", 2);
      this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("bitrate", CodecParam.mDstAudioEncBitrate);
      this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("max-input-size", AudioCapture.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createEncoderByType("audio/mp4a-latm");
      this.jdField_a_of_type_AndroidMediaMediaCodec.configure(this.jdField_a_of_type_AndroidMediaMediaFormat, null, null, 1);
      this.jdField_a_of_type_AndroidMediaMediaCodec.start();
      paramString = new File(this.jdField_a_of_type_JavaLangString);
      if (!paramString.exists()) {
        FileUtils.createFileIfNotExits(paramString.getAbsolutePath());
      }
      this.jdField_a_of_type_AndroidMediaMediaMuxer = new MediaMuxer(this.jdField_a_of_type_JavaLangString, 0);
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = new MediaCodec.BufferInfo();
      this.jdField_b_of_type_Long = 0L;
      if (CodecParam.mAudioFormat != 2) {
        break label239;
      }
    }
    label239:
    for (int j = 16;; j = 8)
    {
      this.jdField_a_of_type_Double = (i * (j * this.jdField_b_of_type_Int) / 8 / Math.pow(10.0D, 6.0D));
      return;
      i = 2;
      break;
    }
  }
  
  private void d() {}
  
  void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_AndroidMediaMediaCodec != null)
    {
      long l = SystemClock.elapsedRealtimeNanos();
      a(new byte[0], l, true);
      this.jdField_a_of_type_AndroidMediaMediaCodec.stop();
      this.jdField_a_of_type_AndroidMediaMediaCodec.release();
      this.jdField_a_of_type_AndroidMediaMediaCodec = null;
    }
    if ((this.jdField_a_of_type_AndroidMediaMediaMuxer != null) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Boolean = false;
    }
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaMuxer.release();
      if (QLog.isColorLevel()) {
        QLog.d("HWAudioEncoder", 2, "MediaMuxer stop.");
      }
      if (this.jdField_a_of_type_Bagg != null) {
        this.jdField_a_of_type_Bagg.h();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (this.jdField_a_of_type_Bagg != null) {
        this.jdField_a_of_type_Bagg.i();
      }
      return;
    }
    finally
    {
      this.jdField_a_of_type_AndroidMediaMediaMuxer = null;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(bagg parambagg)
  {
    this.jdField_a_of_type_Bagg = parambagg;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, paramString).sendToTarget();
    }
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      paramLong = SystemClock.elapsedRealtimeNanos();
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, new Object[] { paramArrayOfByte, Long.valueOf(paramLong) }).sendToTarget();
    }
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    int i = (int)(paramArrayOfByte.length / this.jdField_a_of_type_Double);
    this.jdField_b_of_type_Long += i;
    if (QLog.isColorLevel()) {
      QLog.d("HWAudioEncoder", 2, String.format("handleAudioFrame audioData=%s mAudioDataSize=%s frameTime=%s mLastAudioFrameTime=%s timestampNanos=%s endOfStream=&s", new Object[] { Integer.valueOf(paramArrayOfByte.length), Double.valueOf(this.jdField_a_of_type_Double), Integer.valueOf(i), Long.valueOf(this.jdField_b_of_type_Long), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) }));
    }
    i = 0;
    Object localObject = this.jdField_a_of_type_AndroidMediaMediaCodec.getInputBuffers();
    int j = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueInputBuffer(10000L);
    if (QLog.isColorLevel()) {
      QLog.d("HWAudioEncoder", 2, String.format("handleAudioFrame inputIndex=%s endTryTimes=%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) }));
    }
    if (j >= 0)
    {
      localObject = localObject[j];
      ((ByteBuffer)localObject).clear();
      ((ByteBuffer)localObject).put(paramArrayOfByte);
      this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(j, 0, paramArrayOfByte.length, this.jdField_b_of_type_Long, 0);
      label205:
      i = 0;
      paramArrayOfByte = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
    }
    label216:
    do
    {
      for (;;)
      {
        j = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, 10000L);
        if (QLog.isColorLevel()) {
          QLog.d("HWAudioEncoder", 2, String.format("handleAudioFrame outputIndex=%s endTryTimes=%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) }));
        }
        if (j == -1)
        {
          if (!paramBoolean) {}
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("HWAudioEncoder", 2, String.format("handleAudioFrame time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
            }
            return;
            if (j != -1) {
              break;
            }
            if (!paramBoolean) {
              break label205;
            }
            j = i + 1;
            i = j;
            if (j <= 10) {
              break;
            }
            break label205;
            j = i + 1;
            i = j;
            if (j <= 10) {
              break label216;
            }
          }
        }
        if (j == -2)
        {
          localObject = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat();
          this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack((MediaFormat)localObject);
          if (!this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidMediaMediaMuxer.start();
            this.jdField_a_of_type_Boolean = true;
          }
        }
        else
        {
          if (j != -3) {
            break label436;
          }
          paramArrayOfByte = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
        }
      }
    } while (j < 0);
    label281:
    label436:
    i = 0;
    localObject = paramArrayOfByte[j];
    if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x2) != 0) {
      this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size = 0;
    }
    if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size != 0) && (this.jdField_a_of_type_Boolean))
    {
      ((ByteBuffer)localObject).position(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset);
      ((ByteBuffer)localObject).limit(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset + this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size);
      if (QLog.isColorLevel()) {
        QLog.d("HWAudioEncoder", 2, String.format("handleAudioFrame presentationTimeUs=%s", new Object[] { Long.valueOf(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs) }));
      }
      if (this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs < this.jdField_a_of_type_Long) {
        break label624;
      }
      this.jdField_a_of_type_AndroidMediaMediaMuxer.writeSampleData(this.jdField_a_of_type_Int, (ByteBuffer)localObject, this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
      this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(j, false);
      if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x4) == 0) {
        break;
      }
      break label281;
      label624:
      QLog.e("HWAudioEncoder", 1, "handleAudioFrame audio timestamp revert? throw this frame.");
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bage
 * JD-Core Version:    0.7.0.1
 */