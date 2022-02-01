import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.mode.AECaptureMode;

class bniw
  implements Observer<bnpk>
{
  bniw(bniq parambniq) {}
  
  public void a(@Nullable bnpk parambnpk)
  {
    if (bniq.a(this.a) == AECaptureMode.GIF)
    {
      String str = null;
      if (parambnpk != null) {
        str = bnpg.a().a(parambnpk.a);
      }
      bniq.a(this.a).setMaterial(str);
      bnzb.a("VideoStoryPiecesPart", "[GifAuthor]---checkShowGifAuthor when material change");
      bniq.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bniw
 * JD-Core Version:    0.7.0.1
 */