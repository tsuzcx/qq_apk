import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.view.Surface;

@TargetApi(16)
public class bjwu
  extends bjwr
{
  private Surface a;
  
  protected String a()
  {
    return "Q.qqstory.mediadecoderMediaCodecVideoRender";
  }
  
  protected void a(MediaCodec paramMediaCodec, MediaCodec.BufferInfo paramBufferInfo)
  {
    boolean bool = true;
    int i = paramMediaCodec.dequeueOutputBuffer(paramBufferInfo, 10000L);
    switch (i)
    {
    default: 
      if ((paramBufferInfo.flags & 0x4) != 0)
      {
        ykq.b("Q.qqstory.mediadecoderMediaCodecVideoRender", "output EOS");
        this.jdField_b_of_type_Boolean = true;
      }
      if (paramBufferInfo.size == 0) {
        break;
      }
    }
    for (;;)
    {
      paramMediaCodec.releaseOutputBuffer(i, bool);
      ykq.b("Q.qqstory.mediadecoderMediaCodecVideoRender", "dequeueOutputBuffer render");
      return;
      ykq.b("Q.qqstory.mediadecoderMediaCodecVideoRender", "INFO_OUTPUT_BUFFERS_CHANGED");
      this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = paramMediaCodec.getOutputBuffers();
      return;
      ykq.b("Q.qqstory.mediadecoderMediaCodecVideoRender", "New format " + this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat());
      return;
      ykq.b("Q.qqstory.mediadecoderMediaCodecVideoRender", "dequeueOutputBuffer timed out!");
      return;
      bool = false;
    }
  }
  
  protected void a(bjws parambjws, MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    paramMediaCodec.configure(paramMediaFormat, this.jdField_a_of_type_AndroidViewSurface, null, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjwu
 * JD-Core Version:    0.7.0.1
 */