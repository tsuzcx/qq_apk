import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.view.Surface;

@TargetApi(16)
public class bcpg
  extends bcpd
{
  public int a;
  public SurfaceTexture a;
  private Surface a;
  
  public bcpg(bcpf parambcpf, bcpe parambcpe, int paramInt, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener)
  {
    super(parambcpf, parambcpe);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(paramInt);
    this.jdField_a_of_type_AndroidViewSurface = new Surface(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(paramOnFrameAvailableListener);
  }
  
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
        urk.b("Q.qqstory.mediadecoderMediaCodecVideoRender", "output EOS");
        this.jdField_b_of_type_Boolean = true;
      }
      if (paramBufferInfo.size == 0) {
        break;
      }
    }
    for (;;)
    {
      paramMediaCodec.releaseOutputBuffer(i, bool);
      urk.b("Q.qqstory.mediadecoderMediaCodecVideoRender", "dequeueOutputBuffer render");
      return;
      urk.b("Q.qqstory.mediadecoderMediaCodecVideoRender", "INFO_OUTPUT_BUFFERS_CHANGED");
      this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = paramMediaCodec.getOutputBuffers();
      return;
      urk.b("Q.qqstory.mediadecoderMediaCodecVideoRender", "New format " + this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat());
      return;
      urk.b("Q.qqstory.mediadecoderMediaCodecVideoRender", "dequeueOutputBuffer timed out!");
      return;
      bool = false;
    }
  }
  
  protected void a(bcpe parambcpe, MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    paramMediaCodec.configure(paramMediaFormat, this.jdField_a_of_type_AndroidViewSurface, null, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bcpg
 * JD-Core Version:    0.7.0.1
 */