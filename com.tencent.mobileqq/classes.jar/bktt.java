import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.tencent.mobileqq.richmedia.capture.view.AEPituCameraCaptureButtonLayout;

class bktt
  implements bmeo<blfi>
{
  bktt(bktp parambktp) {}
  
  public void a(@Nullable blfi paramblfi)
  {
    int i = 1;
    if (paramblfi == null) {}
    label305:
    label336:
    do
    {
      return;
      paramblfi = paramblfi.a;
      bktp.a(this.a, paramblfi);
      bljn.a("VideoStoryPiecesPart", "[GifAuthor]---checkShowGifAuthor when capture mode change");
      bktp.a(this.a);
      bktp.a(this.a).q();
      if (paramblfi == AECaptureMode.NORMAL) {
        bktp.a(this.a).c(true);
      }
      for (;;)
      {
        if (bktp.a(this.a) != null) {
          bktp.a(this.a).a(paramblfi);
        }
        if (paramblfi != AECaptureMode.NORMAL) {
          break label336;
        }
        bktp.a(this.a).setVisibility(0);
        if (bktp.a(this.a) != null)
        {
          if ((!blat.g(bktp.b(this.a).getIntent())) && (!blat.h(bktp.c(this.a).getIntent()))) {
            break label305;
          }
          bktp.a(this.a).setFunctionFlag(bktp.d(this.a).getIntent().getIntExtra("ability_flag", 2));
        }
        bktp.a(this.a).setMaxDuration(bktp.a());
        bktp.a(this.a).a(false);
        bktp.a(this.a).b(blat.i(bktp.e(this.a).getIntent()));
        bktp.a(this.a).c(false);
        if (bktp.b(this.a)) {
          bktp.a(this.a).setVisibility(0);
        }
        bktp.a(this.a).setVisibility(0);
        if (blat.a(bktp.a(this.a).a())) {
          break;
        }
        bktp.a(this.a).a().b();
        return;
        bktp.a(this.a).c(false);
      }
      paramblfi = bktp.a(this.a);
      if (bktp.a(this.a)) {}
      for (;;)
      {
        paramblfi.setFunctionFlag(i);
        break;
        i = 3;
      }
      if (paramblfi == AECaptureMode.GIF)
      {
        bktp.a(this.a).setVisibility(0);
        bktp.a(this.a).setFunctionFlag(4);
        bktp.a(this.a).setMaxDuration(bktp.b());
        bktp.a(this.a).a(true);
        bktp.a(this.a).c(true);
        if (bktp.b(this.a)) {
          bktp.a(this.a).setVisibility(0);
        }
        bktp.a(this.a).setVisibility(0);
        bktp.a(this.a).a();
        return;
      }
    } while (paramblfi != AECaptureMode.PLAY);
    bktp.a(this.a).setVisibility(8);
    bktp.a(this.a).setVisibility(8);
    bktp.a(this.a).setVisibility(8);
    bktp.a(this.a).setMaterial(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bktt
 * JD-Core Version:    0.7.0.1
 */