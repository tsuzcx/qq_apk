import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.view.Surface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.ByteBuffer;

@TargetApi(18)
public class bbmo
{
  private int jdField_a_of_type_Int;
  private MediaCodec.BufferInfo jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = new MediaCodec.BufferInfo();
  private MediaCodec jdField_a_of_type_AndroidMediaMediaCodec;
  public MediaFormat a;
  private MediaMuxer jdField_a_of_type_AndroidMediaMediaMuxer;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private bbms jdField_a_of_type_Bbms;
  private bbnf jdField_a_of_type_Bbnf;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoEncoder", 2, "drainEncoder(" + paramBoolean + ")");
    }
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HWVideoEncoder", 2, "sending EOS to encoder");
      }
      this.jdField_a_of_type_AndroidMediaMediaCodec.signalEndOfInputStream();
    }
    ByteBuffer[] arrayOfByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
    int i = 0;
    for (;;)
    {
      int j = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, 10000L);
      if (j == -1) {
        if (!paramBoolean) {
          if (QLog.isColorLevel()) {
            QLog.d("HWVideoEncoder", 2, "no output available yet");
          }
        }
      }
      for (;;)
      {
        if ((paramBoolean) && (this.jdField_a_of_type_Bbms != null)) {
          this.jdField_a_of_type_Bbms.a();
        }
        return;
        if (QLog.isColorLevel()) {
          QLog.d("HWVideoEncoder", 2, "no output available, spinning to await EOS");
        }
        j = i + 1;
        i = j;
        if (j <= 100) {
          break;
        }
        throw new RuntimeException("Encoder is not stopped after dequeue 100 times.");
        if (j == -3)
        {
          arrayOfByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
          break;
        }
        if (j == -2)
        {
          this.jdField_a_of_type_AndroidMediaMediaFormat = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat();
          a(this.jdField_a_of_type_AndroidMediaMediaFormat);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("HWVideoEncoder", 2, "encoder output format changed: " + this.jdField_a_of_type_AndroidMediaMediaFormat);
          break;
        }
        if (j < 0)
        {
          QLog.w("HWVideoEncoder", 2, "unexpected result from encoder.dequeueOutputBuffer: " + j);
          break;
        }
        ByteBuffer localByteBuffer = arrayOfByteBuffer[j];
        if (localByteBuffer == null) {
          throw new RuntimeException("encoderOutputBuffer " + j + " was null");
        }
        if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x2) != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("HWVideoEncoder", 2, "ignoring BUFFER_FLAG_CODEC_CONFIG");
          }
          this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size = 0;
        }
        if (this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size != 0)
        {
          a(localByteBuffer, this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
          if (QLog.isColorLevel()) {
            QLog.d("HWVideoEncoder", 2, "sent " + this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size + " bytes to muxer, ts=" + this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs * 1000L);
          }
        }
        this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(j, false);
        if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x4) == 0) {
          break label485;
        }
        if (!paramBoolean) {
          QLog.w("HWVideoEncoder", 2, "reached end of stream unexpectedly");
        } else if (QLog.isColorLevel()) {
          QLog.d("HWVideoEncoder", 2, "end of stream reached");
        }
      }
      label485:
      i = 0;
    }
  }
  
  public Surface a()
  {
    return this.jdField_a_of_type_AndroidViewSurface;
  }
  
  public void a()
  {
    a(false);
  }
  
  public void a(MediaFormat paramMediaFormat)
  {
    if (QLog.isColorLevel()) {
      if (this.jdField_a_of_type_Bbnf != null) {
        break label61;
      }
    }
    label61:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("HWVideoEncoder", 2, new Object[] { "setOutputFormat, ", Boolean.valueOf(bool) });
      if (this.jdField_a_of_type_Bbnf != null) {
        break label114;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      throw new RuntimeException("format changed twice");
    }
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack(this.jdField_a_of_type_AndroidMediaMediaFormat);
    this.jdField_a_of_type_AndroidMediaMediaMuxer.start();
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bbms != null) {
      this.jdField_a_of_type_Bbms.a(this.jdField_a_of_type_AndroidMediaMediaFormat);
    }
    return;
    label114:
    this.jdField_a_of_type_Bbnf.a(0, paramMediaFormat);
  }
  
  public void a(bbmm parambbmm)
  {
    this.jdField_a_of_type_JavaLangString = parambbmm.jdField_a_of_type_JavaLangString;
    Object localObject = MediaFormat.createVideoFormat("video/avc", parambbmm.jdField_a_of_type_Int, parambbmm.jdField_b_of_type_Int);
    ((MediaFormat)localObject).setInteger("color-format", 2130708361);
    ((MediaFormat)localObject).setInteger("bitrate", parambbmm.c);
    ((MediaFormat)localObject).setInteger("frame-rate", parambbmm.d);
    ((MediaFormat)localObject).setInteger("i-frame-interval", parambbmm.e);
    if (parambbmm.j != -1) {
      ((MediaFormat)localObject).setInteger("bitrate-mode", parambbmm.j);
    }
    if (parambbmm.k != -1)
    {
      ((MediaFormat)localObject).setInteger("profile", 8);
      ((MediaFormat)localObject).setInteger("level", 32768);
    }
    if (parambbmm.jdField_b_of_type_Boolean)
    {
      ((MediaFormat)localObject).setInteger("profile", 1);
      ((MediaFormat)localObject).setInteger("level", 512);
    }
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoEncoder", 2, "start : encodeConfig = + " + parambbmm.toString() + " ; format: " + localObject);
    }
    this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createEncoderByType("video/avc");
    this.jdField_a_of_type_AndroidMediaMediaCodec.configure((MediaFormat)localObject, null, null, 1);
    this.jdField_a_of_type_AndroidViewSurface = this.jdField_a_of_type_AndroidMediaMediaCodec.createInputSurface();
    this.jdField_a_of_type_AndroidMediaMediaCodec.start();
    localObject = new File(parambbmm.jdField_a_of_type_JavaLangString);
    if (!((File)localObject).exists()) {
      FileUtils.createFileIfNotExits(((File)localObject).getAbsolutePath());
    }
    if (parambbmm.jdField_a_of_type_Bbnf == null)
    {
      this.jdField_a_of_type_AndroidMediaMediaMuxer = new MediaMuxer(parambbmm.jdField_a_of_type_JavaLangString, 0);
      this.jdField_a_of_type_AndroidMediaMediaMuxer.setOrientationHint(parambbmm.g);
    }
    for (;;)
    {
      if (parambbmm.jdField_a_of_type_Bbms != null) {
        this.jdField_a_of_type_Bbms = parambbmm.jdField_a_of_type_Bbms;
      }
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_Boolean = false;
      return;
      this.jdField_a_of_type_Bbnf = parambbmm.jdField_a_of_type_Bbnf;
      this.jdField_a_of_type_Bbnf.jdField_a_of_type_AndroidMediaMediaMuxer.setOrientationHint(parambbmm.g);
    }
  }
  
  public void a(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    if (this.jdField_a_of_type_Bbnf == null)
    {
      if (!this.jdField_a_of_type_Boolean) {
        throw new RuntimeException("muxer hasn't started");
      }
      paramByteBuffer.position(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset);
      paramByteBuffer.limit(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset + this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size);
      if (this.jdField_a_of_type_Bbms != null)
      {
        paramBufferInfo = new bbmp(this);
        paramBufferInfo.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        Object localObject = ByteBuffer.allocate(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size);
        ((ByteBuffer)localObject).put(paramByteBuffer);
        ((ByteBuffer)localObject).flip();
        paramBufferInfo.jdField_a_of_type_JavaNioByteBuffer = ((ByteBuffer)localObject);
        localObject = new MediaCodec.BufferInfo();
        ((MediaCodec.BufferInfo)localObject).flags = this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags;
        ((MediaCodec.BufferInfo)localObject).offset = 0;
        ((MediaCodec.BufferInfo)localObject).presentationTimeUs = this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs;
        ((MediaCodec.BufferInfo)localObject).size = this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size;
        paramBufferInfo.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = ((MediaCodec.BufferInfo)localObject);
        this.jdField_a_of_type_Bbms.a(paramBufferInfo);
        paramByteBuffer.rewind();
        paramByteBuffer.position(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset);
        paramByteBuffer.limit(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset + this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size);
      }
      this.jdField_a_of_type_AndroidMediaMediaMuxer.writeSampleData(this.jdField_a_of_type_Int, paramByteBuffer, this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
      return;
    }
    this.jdField_a_of_type_Bbnf.a(0, paramByteBuffer, paramBufferInfo);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoEncoder", 2, "HWVideoEncoder stop.");
    }
    a(true);
    c();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoEncoder", 2, "HWVideoEncoder release.");
    }
    if (this.jdField_a_of_type_AndroidMediaMediaCodec != null) {}
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec.stop();
      if (QLog.isColorLevel()) {
        QLog.d("HWVideoEncoder", 2, "MediaCodec stop.");
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          this.jdField_a_of_type_AndroidMediaMediaCodec.release();
          if (QLog.isColorLevel()) {
            QLog.d("HWVideoEncoder", 2, "MediaCodec release.");
          }
          this.jdField_a_of_type_AndroidMediaMediaCodec = null;
          if ((this.jdField_a_of_type_Bbnf != null) || (this.jdField_a_of_type_AndroidMediaMediaMuxer == null)) {
            break label237;
          }
          try
          {
            if (this.jdField_a_of_type_Boolean)
            {
              this.jdField_a_of_type_Boolean = false;
              this.jdField_a_of_type_AndroidMediaMediaMuxer.stop();
              if (QLog.isColorLevel()) {
                QLog.d("HWVideoEncoder", 2, "MediaMuxer stop.");
              }
            }
            this.jdField_a_of_type_AndroidMediaMediaMuxer.release();
            if (QLog.isColorLevel()) {
              QLog.d("HWVideoEncoder", 2, "MediaMuxer release.");
            }
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              QLog.w("HWVideoEncoder", 2, "Muxer stop exception:" + localException3);
            }
          }
          this.jdField_a_of_type_AndroidMediaMediaMuxer = null;
          return;
          localException1 = localException1;
          QLog.w("HWVideoEncoder", 2, "mEncoder stop exception:" + localException1);
        }
      }
      catch (Exception localException2)
      {
        label237:
        do
        {
          for (;;)
          {
            QLog.w("HWVideoEncoder", 2, "mEncoder release exception:" + localException2);
          }
        } while (this.jdField_a_of_type_Bbnf == null);
        QLog.d("HWVideoEncoder", 1, "HWVideoEncoder release");
        this.jdField_a_of_type_Bbnf.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbmo
 * JD-Core Version:    0.7.0.1
 */