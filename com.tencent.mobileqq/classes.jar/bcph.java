import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.qg.video.videodecoder.MediaDecoder;

public class bcph
  implements SurfaceTexture.OnFrameAvailableListener
{
  public bcph(MediaDecoder paramMediaDecoder, bcpi parambcpi) {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    this.jdField_a_of_type_Bcpi.a(paramSurfaceTexture);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bcph
 * JD-Core Version:    0.7.0.1
 */