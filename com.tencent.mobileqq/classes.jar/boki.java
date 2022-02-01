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
import dov.com.qq.im.ae.view.AEPituCameraCaptureButtonLayout;

class boki
  implements Observer<bowc>
{
  boki(bojy parambojy) {}
  
  public void a(@Nullable bowc parambowc)
  {
    if (parambowc == null) {}
    label115:
    do
    {
      return;
      parambowc = parambowc.b;
      bojy.a(this.a, parambowc);
      bpam.a("VideoStoryPiecesPart", "[GifAuthor]---checkShowGifAuthor when capture mode change");
      bojy.a(this.a);
      if ((parambowc == AECaptureMode.GIF) && (bojy.a(this.a) != null) && (bojy.a(this.a).getVisibility() == 0))
      {
        bozz.a().a("sp_key_ae_comics_gif_tips", true, 0);
        bpam.b("VideoStoryPiecesPart", "[ComicsTips]--set flag: comics gif tips has shown");
      }
      bojy.b(this.a);
      bojy.a(this.a).o();
      if (parambowc == AECaptureMode.NORMAL)
      {
        bojy.a(this.a).b(true);
        if (bojy.a(this.a) != null) {
          bojy.a(this.a).a(parambowc);
        }
        if (parambowc != AECaptureMode.NORMAL) {
          break label513;
        }
        bojy.a(this.a).setVisibility(0);
        if (bojy.h(this.a) != null)
        {
          if ((!born.h(bojy.i(this.a).getIntent())) && (!born.i(bojy.j(this.a).getIntent()))) {
            break label411;
          }
          bojy.a(this.a).setFunctionFlag(bojy.k(this.a).getIntent().getIntExtra("ability_flag", 2));
        }
      }
      for (;;)
      {
        bojy.a(this.a).setMaxDuration(bojy.b());
        bojy.a(this.a).a(false);
        if (bojy.c(this.a)) {
          bojy.a(this.a).a(true, bpas.a);
        }
        bojy.a(this.a).b(false);
        if (bojy.c(this.a))
        {
          i = this.a.a();
          if (i > 0)
          {
            parambowc = (ViewGroup.MarginLayoutParams)bojy.c(this.a).getLayoutParams();
            if (parambowc != null)
            {
              parambowc.bottomMargin = i;
              bojy.c(this.a).setLayoutParams(parambowc);
            }
          }
        }
        if (bojy.d(this.a)) {
          bojy.a(this.a).setVisibility(0);
        }
        bojy.a(this.a, true);
        if (born.a(bojy.a(this.a).a())) {
          break;
        }
        bojy.a(this.a).a().b();
        return;
        bojy.a(this.a).b(false);
        break label115;
        if (born.j(bojy.l(this.a).getIntent()))
        {
          bojy.a(this.a).setFunctionFlag(bojy.m(this.a).getIntent().getIntExtra("ability_flag", 1));
        }
        else
        {
          if (!bojy.a(this.a)) {
            break label480;
          }
          bojy.a(this.a).setFunctionFlag(2);
        }
      }
      parambowc = bojy.a(this.a);
      if (bojy.b(this.a)) {}
      for (int i = 1;; i = 3)
      {
        parambowc.setFunctionFlag(i);
        break;
      }
      if (parambowc == AECaptureMode.GIF)
      {
        bojy.a(this.a).setVisibility(0);
        bojy.a(this.a).setFunctionFlag(4);
        bojy.a(this.a).setMaxDuration(bojy.c());
        bojy.a(this.a).a(true);
        bojy.a(this.a).b(true);
        if (bojy.d(this.a)) {
          bojy.a(this.a).setVisibility(0);
        }
        bojy.a(this.a, true);
        bojy.a(this.a).a();
        return;
      }
    } while (parambowc != AECaptureMode.PLAY);
    label411:
    label480:
    bojy.a(this.a).setVisibility(8);
    label513:
    bojy.a(this.a).setVisibility(8);
    bojy.a(this.a, false);
    bojy.a(this.a).setMaterial(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boki
 * JD-Core Version:    0.7.0.1
 */