import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.qg.video.videodecoder.MediaDecoder;

public class bftu
  implements SurfaceTexture.OnFrameAvailableListener
{
  public bftu(MediaDecoder paramMediaDecoder, bftv parambftv) {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    this.jdField_a_of_type_Bftv.a(paramSurfaceTexture);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bftu
 * JD-Core Version:    0.7.0.1
 */