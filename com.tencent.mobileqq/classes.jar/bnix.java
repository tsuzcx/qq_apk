import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.biz.qqstory.view.widget.bubble.BubbleTextView;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.view.AECompoundButton;
import dov.com.tencent.mobileqq.richmedia.capture.view.AEPituCameraCaptureButtonLayout;

class bnix
  implements Observer<bnuq>
{
  bnix(bniq parambniq) {}
  
  public void a(@Nullable bnuq parambnuq)
  {
    if (parambnuq == null) {}
    label115:
    do
    {
      return;
      parambnuq = parambnuq.b;
      bniq.a(this.a, parambnuq);
      bnzb.a("VideoStoryPiecesPart", "[GifAuthor]---checkShowGifAuthor when capture mode change");
      bniq.a(this.a);
      if ((parambnuq == AECaptureMode.GIF) && (bniq.a(this.a) != null) && (bniq.a(this.a).getVisibility() == 0))
      {
        bnyp.a().a("sp_key_ae_comics_gif_tips", true, 0);
        bnzb.b("VideoStoryPiecesPart", "[ComicsTips]--set flag: comics gif tips has shown");
      }
      bniq.b(this.a);
      bniq.a(this.a).o();
      if (parambnuq == AECaptureMode.NORMAL)
      {
        bniq.a(this.a).b(true);
        if (bniq.a(this.a) != null) {
          bniq.a(this.a).a(parambnuq);
        }
        if (parambnuq != AECaptureMode.NORMAL) {
          break label471;
        }
        bniq.a(this.a).setVisibility(0);
        if (bniq.a(this.a) != null)
        {
          if ((!bnqb.h(bniq.b(this.a).getIntent())) && (!bnqb.i(bniq.c(this.a).getIntent()))) {
            break label414;
          }
          bniq.a(this.a).setFunctionFlag(bniq.d(this.a).getIntent().getIntExtra("ability_flag", 2));
        }
      }
      for (;;)
      {
        bniq.a(this.a).setMaxDuration(bniq.b());
        bniq.a(this.a).a(false);
        if (bniq.c(this.a)) {
          bniq.a(this.a).a(true, bnzg.a);
        }
        bniq.a(this.a).b(false);
        if (bniq.c(this.a))
        {
          i = this.a.a();
          if (i > 0)
          {
            parambnuq = (ViewGroup.MarginLayoutParams)bniq.c(this.a).getLayoutParams();
            if (parambnuq != null)
            {
              parambnuq.bottomMargin = i;
              bniq.c(this.a).setLayoutParams(parambnuq);
            }
          }
        }
        if (bniq.d(this.a)) {
          bniq.a(this.a).setVisibility(0);
        }
        bniq.a(this.a).setVisibility(0);
        if (bnqb.a(bniq.a(this.a).a())) {
          break;
        }
        bniq.a(this.a).a().b();
        return;
        bniq.a(this.a).b(false);
        break label115;
        if (!bniq.a(this.a)) {
          break label438;
        }
        bniq.a(this.a).setFunctionFlag(2);
      }
      parambnuq = bniq.a(this.a);
      if (bniq.b(this.a)) {}
      for (int i = 1;; i = 3)
      {
        parambnuq.setFunctionFlag(i);
        break;
      }
      if (parambnuq == AECaptureMode.GIF)
      {
        bniq.a(this.a).setVisibility(0);
        bniq.a(this.a).setFunctionFlag(4);
        bniq.a(this.a).setMaxDuration(bniq.c());
        bniq.a(this.a).a(true);
        bniq.a(this.a).b(true);
        if (bniq.d(this.a)) {
          bniq.a(this.a).setVisibility(0);
        }
        bniq.a(this.a).setVisibility(0);
        bniq.a(this.a).a();
        return;
      }
    } while (parambnuq != AECaptureMode.PLAY);
    label414:
    label438:
    label471:
    bniq.a(this.a).setVisibility(8);
    bniq.a(this.a).setVisibility(8);
    bniq.a(this.a).setVisibility(8);
    bniq.a(this.a).setMaterial(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnix
 * JD-Core Version:    0.7.0.1
 */