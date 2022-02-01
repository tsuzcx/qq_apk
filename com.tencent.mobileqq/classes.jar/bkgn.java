import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.qg.video.videodecoder.MediaDecoder;

public class bkgn
  implements SurfaceTexture.OnFrameAvailableListener
{
  public bkgn(MediaDecoder paramMediaDecoder, bkgo parambkgo) {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    this.jdField_a_of_type_Bkgo.a(paramSurfaceTexture);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkgn
 * JD-Core Version:    0.7.0.1
 */