import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.mode.AECaptureMode;

class bnby
  implements Observer<bnkg>
{
  bnby(bnbp parambnbp) {}
  
  public void a(@Nullable bnkg parambnkg)
  {
    if (bnbp.a(this.a) == AECaptureMode.GIF)
    {
      String str = null;
      if (parambnkg != null) {
        str = bnjw.a().a(parambnkg.a);
      }
      bnbp.a(this.a).setMaterial(str);
      bnrh.a("VideoStoryPiecesPart", "[GifAuthor]---checkShowGifAuthor when material change");
      bnbp.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnby
 * JD-Core Version:    0.7.0.1
 */