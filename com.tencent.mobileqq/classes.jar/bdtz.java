import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.qg.video.videodecoder.MediaDecoder;

public class bdtz
  implements SurfaceTexture.OnFrameAvailableListener
{
  public bdtz(MediaDecoder paramMediaDecoder, bdua parambdua) {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    this.jdField_a_of_type_Bdua.a(paramSurfaceTexture);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bdtz
 * JD-Core Version:    0.7.0.1
 */