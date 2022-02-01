import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.biz.qqstory.view.widget.bubble.BubbleTextView;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.tencent.mobileqq.richmedia.capture.view.AbsAECaptureButton;

class bloo
  implements Observer<bmah>
{
  bloo(bloe parambloe) {}
  
  public void a(@Nullable bmah parambmah)
  {
    if (parambmah == null) {}
    label355:
    do
    {
      return;
      parambmah = parambmah.b;
      bloe.a(this.a, parambmah);
      bmbx.a("VideoStoryPiecesPart", "[GifAuthor]---checkShowGifAuthor when capture mode change");
      bloe.a(this.a);
      if ((parambmah == AECaptureMode.GIF) && (bloe.a(this.a) != null) && (bloe.a(this.a).getVisibility() == 0))
      {
        bmbk.a().a("sp_key_ae_comics_gif_tips", true, 0);
        bmbx.b("VideoStoryPiecesPart", "[ComicsTips]--set flag: comics gif tips has shown");
      }
      bloe.b(this.a);
      bloe.a(this.a).J();
      if (parambmah == AECaptureMode.NORMAL) {
        bloe.a(this.a).f(true);
      }
      for (;;)
      {
        if (bloe.a(this.a) != null) {
          bloe.a(this.a).a(parambmah);
        }
        if (parambmah != AECaptureMode.NORMAL) {
          break label355;
        }
        bloe.a(this.a).setVisibility(0);
        this.a.b();
        bloe.a(this.a).setMaxDuration(this.a.a(parambmah));
        bloe.a(this.a).a(false);
        if (bloe.a(this.a)) {
          bloe.a(this.a).a(true, bmcd.a);
        }
        bloe.a(this.a).b(false);
        if (bloe.a(this.a))
        {
          int i = this.a.a();
          if (i > 0)
          {
            parambmah = (ViewGroup.MarginLayoutParams)bloe.c(this.a).getLayoutParams();
            if (parambmah != null)
            {
              parambmah.bottomMargin = i;
              bloe.c(this.a).setLayoutParams(parambmah);
            }
          }
        }
        if (bloe.b(this.a)) {
          bloe.a(this.a).setVisibility(0);
        }
        bloe.a(this.a, true);
        if (blvr.a(bloe.a(this.a).a())) {
          break;
        }
        bloe.a(this.a).a().a();
        return;
        bloe.a(this.a).f(false);
      }
      if (parambmah == AECaptureMode.GIF)
      {
        bloe.a(this.a).setVisibility(0);
        bloe.a(this.a).setFunctionFlag(4);
        bloe.a(this.a).setMaxDuration(this.a.a(parambmah));
        bloe.a(this.a).a(true);
        bloe.a(this.a).b(true);
        if (bloe.b(this.a)) {
          bloe.a(this.a).setVisibility(0);
        }
        bloe.a(this.a, true);
        bloe.a(this.a).a();
        return;
      }
    } while (parambmah != AECaptureMode.PLAY);
    bloe.a(this.a).setVisibility(8);
    bloe.a(this.a).setVisibility(8);
    bloe.a(this.a, false);
    bloe.a(this.a).setMaterial(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bloo
 * JD-Core Version:    0.7.0.1
 */