import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.tencent.mobileqq.richmedia.capture.view.AEPituCameraCaptureButtonLayout;

class bkpm
  implements bmac<blbb>
{
  bkpm(bkpi parambkpi) {}
  
  public void a(@Nullable blbb paramblbb)
  {
    int i = 1;
    if (paramblbb == null) {}
    label305:
    label336:
    do
    {
      return;
      paramblbb = paramblbb.a;
      bkpi.a(this.a, paramblbb);
      blfg.a("VideoStoryPiecesPart", "[GifAuthor]---checkShowGifAuthor when capture mode change");
      bkpi.a(this.a);
      bkpi.a(this.a).q();
      if (paramblbb == AECaptureMode.NORMAL) {
        bkpi.a(this.a).c(true);
      }
      for (;;)
      {
        if (bkpi.a(this.a) != null) {
          bkpi.a(this.a).a(paramblbb);
        }
        if (paramblbb != AECaptureMode.NORMAL) {
          break label336;
        }
        bkpi.a(this.a).setVisibility(0);
        if (bkpi.a(this.a) != null)
        {
          if ((!bkwm.g(bkpi.b(this.a).getIntent())) && (!bkwm.h(bkpi.c(this.a).getIntent()))) {
            break label305;
          }
          bkpi.a(this.a).setFunctionFlag(bkpi.d(this.a).getIntent().getIntExtra("ability_flag", 2));
        }
        bkpi.a(this.a).setMaxDuration(bkpi.a());
        bkpi.a(this.a).a(false);
        bkpi.a(this.a).b(bkwm.i(bkpi.e(this.a).getIntent()));
        bkpi.a(this.a).c(false);
        if (bkpi.b(this.a)) {
          bkpi.a(this.a).setVisibility(0);
        }
        bkpi.a(this.a).setVisibility(0);
        if (bkwm.a(bkpi.a(this.a).a())) {
          break;
        }
        bkpi.a(this.a).a().b();
        return;
        bkpi.a(this.a).c(false);
      }
      paramblbb = bkpi.a(this.a);
      if (bkpi.a(this.a)) {}
      for (;;)
      {
        paramblbb.setFunctionFlag(i);
        break;
        i = 3;
      }
      if (paramblbb == AECaptureMode.GIF)
      {
        bkpi.a(this.a).setVisibility(0);
        bkpi.a(this.a).setFunctionFlag(4);
        bkpi.a(this.a).setMaxDuration(bkpi.b());
        bkpi.a(this.a).a(true);
        bkpi.a(this.a).c(true);
        if (bkpi.b(this.a)) {
          bkpi.a(this.a).setVisibility(0);
        }
        bkpi.a(this.a).setVisibility(0);
        bkpi.a(this.a).a();
        return;
      }
    } while (paramblbb != AECaptureMode.PLAY);
    bkpi.a(this.a).setVisibility(8);
    bkpi.a(this.a).setVisibility(8);
    bkpi.a(this.a).setVisibility(8);
    bkpi.a(this.a).setMaterial(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkpm
 * JD-Core Version:    0.7.0.1
 */