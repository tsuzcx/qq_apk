import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;

class blrc
  implements Observer<Boolean>
{
  blrc(blqw paramblqw) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    bmbx.a("VideoStoryCapturePart", "【抠背开关】->observe:" + paramBoolean);
    if (paramBoolean == null) {}
    while (blqw.a(this.a) == null) {
      return;
    }
    blqw.a(this.a).switchSegment(paramBoolean.booleanValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blrc
 * JD-Core Version:    0.7.0.1
 */