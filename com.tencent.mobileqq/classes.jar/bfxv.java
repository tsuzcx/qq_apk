import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.util.Pair;
import java.nio.ByteBuffer;

@TargetApi(16)
public class bfxv
  extends bfxx
{
  private AudioTrack jdField_a_of_type_AndroidMediaAudioTrack;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private bfxw jdField_a_of_type_Bfxw;
  public bnno a;
  
  public bfxv(bfxz parambfxz, bfxy parambfxy, bnno parambnno)
  {
    super(parambfxz, parambfxy);
    this.jdField_a_of_type_Bnno = new bnno();
    this.jdField_a_of_type_Bnno.a(parambnno);
  }
  
  private AudioTrack a()
  {
    int j = 3;
    AudioTrack localAudioTrack;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Bnno.jdField_a_of_type_Azjw.e == 1)
        {
          i = 4;
          if (this.jdField_a_of_type_Bnno.jdField_a_of_type_Azjw.b == 16) {
            j = 2;
          }
          int k = AudioTrack.getMinBufferSize(this.jdField_a_of_type_Bnno.jdField_a_of_type_Azjw.d, i, j);
          localAudioTrack = new AudioTrack(3, this.jdField_a_of_type_Bnno.jdField_a_of_type_Azjw.d, i, j, k, 1);
        }
      }
      catch (Throwable localThrowable1)
      {
        int i;
        localAudioTrack = null;
      }
      try
      {
        localAudioTrack.play();
        return localAudioTrack;
      }
      catch (Throwable localThrowable2)
      {
        break label94;
      }
      i = 12;
    }
    label94:
    wxe.c("Q.qqstory.mediadecoderMediaCodecAudioRender", "AudioTrack init fail :%s", localThrowable1);
    return localAudioTrack;
  }
  
  private void a(AudioTrack paramAudioTrack, byte[] paramArrayOfByte, int paramInt)
  {
    int i;
    switch (this.jdField_a_of_type_Bnno.jdField_a_of_type_Int)
    {
    default: 
      if (!this.jdField_a_of_type_Bfxz.a) {
        paramAudioTrack.write(paramArrayOfByte, 0, paramInt);
      }
      paramInt = 1;
      paramArrayOfByte = null;
      i = 0;
    }
    for (;;)
    {
      if ((!this.jdField_a_of_type_Bfxz.a) && (paramInt == 0) && (paramArrayOfByte != null)) {
        paramAudioTrack.write(paramArrayOfByte, 0, i);
      }
      return;
      i = paramArrayOfByte.length / 2;
      byte[] arrayOfByte = new byte[i];
      bnom.a(paramArrayOfByte, 0, arrayOfByte, i);
      paramArrayOfByte = arrayOfByte;
      paramInt = 0;
      continue;
      i = paramArrayOfByte.length * 2;
      arrayOfByte = new byte[i];
      bnom.a(paramArrayOfByte, 0, arrayOfByte, i, 2);
      paramArrayOfByte = arrayOfByte;
      paramInt = 0;
      continue;
      i = paramArrayOfByte.length * 2 / 3;
      arrayOfByte = new byte[i];
      bnom.b(paramArrayOfByte, 0, arrayOfByte, i);
      paramArrayOfByte = arrayOfByte;
      paramInt = 0;
      continue;
      i = paramArrayOfByte.length * 4;
      arrayOfByte = new byte[i];
      bnom.a(paramArrayOfByte, 0, arrayOfByte, i, 4);
      paramArrayOfByte = arrayOfByte;
      paramInt = 0;
    }
  }
  
  public long a(long paramLong)
  {
    this.jdField_a_of_type_AndroidMediaAudioTrack.flush();
    return super.a(paramLong);
  }
  
  protected String a()
  {
    return "Q.qqstory.mediadecoderMediaCodecAudioRender";
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidMediaAudioTrack.play();
  }
  
  protected void a(MediaCodec paramMediaCodec, MediaCodec.BufferInfo paramBufferInfo)
  {
    int i = paramMediaCodec.dequeueOutputBuffer(paramBufferInfo, 10000L);
    switch (i)
    {
    default: 
      if ((paramBufferInfo.flags & 0x4) != 0)
      {
        wxe.b("Q.qqstory.mediadecoderMediaCodecAudioRender", "output EOS");
        this.jdField_b_of_type_Boolean = true;
      }
      break;
    }
    for (;;)
    {
      paramMediaCodec.releaseOutputBuffer(i, false);
      return;
      wxe.b("Q.qqstory.mediadecoderMediaCodecAudioRender", "INFO_OUTPUT_BUFFERS_CHANGED");
      this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = paramMediaCodec.getOutputBuffers();
      return;
      wxe.b("Q.qqstory.mediadecoderMediaCodecAudioRender", "New format " + paramMediaCodec.getOutputFormat());
      return;
      wxe.b("Q.qqstory.mediadecoderMediaCodecAudioRender", "dequeueOutputBuffer timed out!");
      return;
      try
      {
        localObject = this.jdField_b_of_type_ArrayOfJavaNioByteBuffer[i];
        if (localObject == null)
        {
          wxe.e("Q.qqstory.mediadecoderMediaCodecAudioRender", "find no data");
          return;
        }
      }
      catch (Exception paramMediaCodec)
      {
        wxe.c("Q.qqstory.mediadecoderMediaCodecAudioRender", "handle data error :%s", paramMediaCodec);
        return;
      }
      if (paramBufferInfo.size != 0)
      {
        ((ByteBuffer)localObject).position(paramBufferInfo.offset);
        ((ByteBuffer)localObject).limit(paramBufferInfo.offset + paramBufferInfo.size);
      }
      int j = ((ByteBuffer)localObject).remaining();
      paramBufferInfo = new byte[j];
      ((ByteBuffer)localObject).get(paramBufferInfo, 0, j);
      Object localObject = Message.obtain();
      ((Message)localObject).what = 1;
      ((Message)localObject).obj = new Pair(paramBufferInfo, Integer.valueOf(j));
      this.jdField_a_of_type_Bfxw.sendMessage((Message)localObject);
    }
  }
  
  protected void a(bfxy parambfxy, MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    try
    {
      this.jdField_a_of_type_Bnno.jdField_a_of_type_Azjw.e = paramMediaFormat.getInteger("channel-count");
      this.jdField_a_of_type_Bnno.jdField_a_of_type_Azjw.d = xqr.a(paramMediaFormat);
      wxe.b("Q.qqstory.mediadecoderMediaCodecAudioRender", "config after b=" + this.jdField_a_of_type_Bnno.jdField_a_of_type_Azjw.c + " c=" + this.jdField_a_of_type_Bnno.jdField_a_of_type_Azjw.e + " sc=" + this.jdField_a_of_type_Bnno.jdField_a_of_type_Azjw.d);
      paramMediaCodec.configure(paramMediaFormat, null, null, 0);
      this.jdField_a_of_type_AndroidMediaAudioTrack = a();
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("mc_audio_thread");
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_Bfxw = new bfxw(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      return;
    }
    catch (Throwable parambfxy)
    {
      for (;;)
      {
        parambfxy.printStackTrace();
      }
    }
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_AndroidMediaAudioTrack != null)
    {
      this.jdField_a_of_type_AndroidMediaAudioTrack.stop();
      this.jdField_a_of_type_AndroidMediaAudioTrack.release();
      this.jdField_a_of_type_AndroidMediaAudioTrack = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.getLooper().quit();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
      this.jdField_a_of_type_Bfxw = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfxv
 * JD-Core Version:    0.7.0.1
 */