import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import java.io.IOException;
import java.nio.ByteBuffer;

@TargetApi(16)
public abstract class bfxx
{
  protected long a;
  protected MediaCodec.BufferInfo a;
  protected MediaCodec a;
  protected MediaExtractor a;
  protected MediaFormat a;
  protected bfxy a;
  protected bfxz a;
  protected bfyc a;
  protected boolean a;
  protected ByteBuffer[] a;
  protected long b;
  protected boolean b;
  protected ByteBuffer[] b;
  protected long c;
  
  public bfxx(bfxz parambfxz, bfxy parambfxy)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Bfxz = parambfxz;
    this.jdField_a_of_type_Bfxy = parambfxy;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo != null) {
      return this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs;
    }
    return 0L;
  }
  
  public long a(long paramLong)
  {
    long l1 = System.currentTimeMillis();
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec.flush();
      this.jdField_a_of_type_AndroidMediaMediaExtractor.seekTo(paramLong, 0);
      long l2 = this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTime();
      if (this.jdField_a_of_type_Bfyc != null) {
        this.jdField_a_of_type_Bfyc.b(l2 / 1000L);
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_b_of_type_Long = l2;
      this.c = l2;
      this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = new MediaCodec.BufferInfo();
      this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs = l2;
      this.jdField_a_of_type_Long = (System.currentTimeMillis() - l2 / 1000L);
      wxe.b(a(), "end seekTo timecost=" + (System.currentTimeMillis() - l1) + " seekTargetTimeUs:" + paramLong + " realStartTime:" + l2);
      return l2;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        wxe.c(a(), "decoder flush error %s", localRuntimeException);
      }
    }
  }
  
  protected abstract String a();
  
  public void a()
  {
    this.jdField_a_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs / 1000L);
  }
  
  protected abstract void a(MediaCodec paramMediaCodec, MediaCodec.BufferInfo paramBufferInfo);
  
  protected abstract void a(bfxy parambfxy, MediaCodec paramMediaCodec, MediaFormat paramMediaFormat);
  
  public void a(bfyc parambfyc)
  {
    this.jdField_a_of_type_Bfyc = parambfyc;
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    bfxu.a(this.jdField_a_of_type_Bfxz.jdField_a_of_type_Long, "[" + a() + "] init now");
    this.jdField_a_of_type_AndroidMediaMediaCodec = null;
    this.jdField_a_of_type_AndroidMediaMediaExtractor = new MediaExtractor();
    boolean bool1;
    for (;;)
    {
      int i;
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaExtractor.setDataSource(this.jdField_a_of_type_Bfxy.b);
        bfxu.a(this.jdField_a_of_type_Bfxz.jdField_a_of_type_Long, "[" + a() + "] extractor setDataSource");
        i = 0;
        bool1 = bool2;
        if (i < this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackCount())
        {
          this.jdField_a_of_type_AndroidMediaMediaFormat = this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackFormat(i);
          str = this.jdField_a_of_type_AndroidMediaMediaFormat.getString("mime");
          if (!str.startsWith(this.jdField_a_of_type_Bfxy.a)) {
            break label353;
          }
          this.jdField_a_of_type_AndroidMediaMediaExtractor.selectTrack(i);
          bfxu.a(this.jdField_a_of_type_Bfxz.jdField_a_of_type_Long, "[" + a() + "] find and selectTrack");
        }
      }
      catch (IOException localIOException)
      {
        String str;
        wxe.b(a(), "init set data source error :%s", localIOException);
        return false;
      }
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createDecoderByType(str);
        bfxu.a(this.jdField_a_of_type_Bfxz.jdField_a_of_type_Long, "[" + a() + "] create codec");
        a(this.jdField_a_of_type_Bfxy, this.jdField_a_of_type_AndroidMediaMediaCodec, this.jdField_a_of_type_AndroidMediaMediaFormat);
        bfxu.a(this.jdField_a_of_type_Bfxz.jdField_a_of_type_Long, "[" + a() + "] configureCodec");
        bool1 = true;
      }
      catch (Throwable localThrowable)
      {
        wxe.b(a(), "init createDecoderByType error :%s", localThrowable);
        bool1 = bool2;
        continue;
      }
      if (!bool1) {
        break;
      }
      wxe.b(a(), "create media decoder success!");
      return bool1;
      label353:
      i += 1;
    }
    wxe.d(a(), "create media decoder error!");
    return bool1;
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaCodec != null)
      {
        this.jdField_a_of_type_AndroidMediaMediaCodec.stop();
        this.jdField_a_of_type_AndroidMediaMediaCodec.release();
        this.jdField_a_of_type_AndroidMediaMediaCodec = null;
      }
      if (this.jdField_a_of_type_AndroidMediaMediaExtractor != null)
      {
        this.jdField_a_of_type_AndroidMediaMediaExtractor.release();
        this.jdField_a_of_type_AndroidMediaMediaExtractor = null;
      }
      return;
    }
    catch (Exception localException)
    {
      wxe.c(a(), "onRelease error :%s ", localException);
    }
  }
  
  public boolean b()
  {
    wxe.a(a(), "start ! %s", this.jdField_a_of_type_Bfxy);
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec.start();
      return false;
    }
    catch (Throwable localThrowable)
    {
      try
      {
        this.jdField_a_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getInputBuffers();
        this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
        this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = new MediaCodec.BufferInfo();
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        return true;
      }
      catch (Exception localException)
      {
        wxe.c(a(), "decode start error :%s", localException);
      }
      localThrowable = localThrowable;
      wxe.c(a(), "decode start error", localThrowable);
      return false;
    }
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_Boolean) {
      d();
    }
    if (!this.jdField_b_of_type_Boolean) {
      a(this.jdField_a_of_type_AndroidMediaMediaCodec, this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
    }
    if (this.jdField_b_of_type_Boolean) {}
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  protected void d()
  {
    int i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueInputBuffer(10000L);
    int j;
    long l1;
    if (i >= 0)
    {
      ByteBuffer localByteBuffer = this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[i];
      j = this.jdField_a_of_type_AndroidMediaMediaExtractor.readSampleData(localByteBuffer, 0);
      l1 = this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTime();
      if (j < 0)
      {
        this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, 0, 0L, 4);
        this.jdField_a_of_type_Boolean = true;
      }
    }
    else
    {
      return;
    }
    long l2 = this.jdField_b_of_type_Long;
    this.jdField_b_of_type_Long = l1;
    this.c += l1 - l2;
    this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, j, this.c, 0);
    this.jdField_a_of_type_AndroidMediaMediaExtractor.advance();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfxx
 * JD-Core Version:    0.7.0.1
 */