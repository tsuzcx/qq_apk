import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.biz.qqstory.view.widget.bubble.BubbleTextView;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.tencent.mobileqq.richmedia.capture.view.AbsAECaptureButton;

class bnbz
  implements Observer<bnpr>
{
  bnbz(bnbp parambnbp) {}
  
  public void a(@Nullable bnpr parambnpr)
  {
    if (parambnpr == null) {}
    label355:
    do
    {
      return;
      parambnpr = parambnpr.b;
      bnbp.a(this.a, parambnpr);
      bnrh.a("VideoStoryPiecesPart", "[GifAuthor]---checkShowGifAuthor when capture mode change");
      bnbp.a(this.a);
      if ((parambnpr == AECaptureMode.GIF) && (bnbp.a(this.a) != null) && (bnbp.a(this.a).getVisibility() == 0))
      {
        bnqu.a().a("sp_key_ae_comics_gif_tips", true, 0);
        bnrh.b("VideoStoryPiecesPart", "[ComicsTips]--set flag: comics gif tips has shown");
      }
      bnbp.b(this.a);
      bnbp.a(this.a).e();
      if (parambnpr == AECaptureMode.NORMAL) {
        bnbp.a(this.a).f(true);
      }
      for (;;)
      {
        if (bnbp.a(this.a) != null) {
          bnbp.a(this.a).a(parambnpr);
        }
        if (parambnpr != AECaptureMode.NORMAL) {
          break label355;
        }
        bnbp.a(this.a).setVisibility(0);
        this.a.b();
        bnbp.a(this.a).setMaxDuration(this.a.a(parambnpr));
        bnbp.a(this.a).a(false);
        if (bnbp.a(this.a)) {
          bnbp.a(this.a).a(true, bnru.a);
        }
        bnbp.a(this.a).b(false);
        if (bnbp.a(this.a))
        {
          int i = this.a.a();
          if (i > 0)
          {
            parambnpr = (ViewGroup.MarginLayoutParams)bnbp.c(this.a).getLayoutParams();
            if (parambnpr != null)
            {
              parambnpr.bottomMargin = i;
              bnbp.c(this.a).setLayoutParams(parambnpr);
            }
          }
        }
        if (bnbp.b(this.a)) {
          bnbp.a(this.a).setVisibility(0);
        }
        bnbp.a(this.a, true);
        if (bnlb.a(bnbp.a(this.a).a())) {
          break;
        }
        bnbp.a(this.a).a().a();
        return;
        bnbp.a(this.a).f(false);
      }
      if (parambnpr == AECaptureMode.GIF)
      {
        bnbp.a(this.a).setVisibility(0);
        bnbp.a(this.a).setFunctionFlag(4);
        bnbp.a(this.a).setMaxDuration(this.a.a(parambnpr));
        bnbp.a(this.a).a(true);
        bnbp.a(this.a).b(true);
        if (bnbp.b(this.a)) {
          bnbp.a(this.a).setVisibility(0);
        }
        bnbp.a(this.a, true);
        bnbp.a(this.a).a();
        return;
      }
    } while (parambnpr != AECaptureMode.PLAY);
    bnbp.a(this.a).setVisibility(8);
    bnbp.a(this.a).setVisibility(8);
    bnbp.a(this.a, false);
    bnbp.a(this.a).setMaterial(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnbz
 * JD-Core Version:    0.7.0.1
 */