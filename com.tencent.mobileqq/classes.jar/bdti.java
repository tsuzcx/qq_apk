import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.qg.video.videodecoder.MediaDecoder;

public class bdti
  implements SurfaceTexture.OnFrameAvailableListener
{
  public bdti(MediaDecoder paramMediaDecoder, bdtj parambdtj) {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    this.jdField_a_of_type_Bdtj.a(paramSurfaceTexture);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bdti
 * JD-Core Version:    0.7.0.1
 */