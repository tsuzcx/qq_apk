import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.view.View;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;
import dov.com.qq.im.ae.view.AECompoundButton;
import dov.com.tencent.mobileqq.richmedia.capture.view.AEPituCameraCaptureButtonLayout;

class bnjb
  implements Observer<Boolean>
{
  bnjb(bniq parambniq) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return;
    }
    if (paramBoolean.booleanValue()) {
      if (bniq.a(this.a).a())
      {
        bniq.d(this.a).setVisibility(0);
        bniq.a(this.a).setVisibility(8);
        bniq.a(this.a).setVisibility(8);
        bniq.a(this.a).setEntryPresent(false);
      }
    }
    for (;;)
    {
      bnzb.a("VideoStoryPiecesPart", "[GifAuthor]---checkShowGifAuthor when other buttons visibility change");
      bniq.a(this.a);
      bniq.b(this.a);
      return;
      if (bniq.a(this.a).b())
      {
        bniq.d(this.a).setVisibility(0);
        bniq.a(this.a).setVisibility(0);
        bniq.a(this.a).setEntryPresent(true);
        if (bniq.d(this.a)) {
          bniq.a(this.a).setVisibility(0);
        }
      }
      else if (bniq.a(this.a).c())
      {
        bniq.d(this.a).setVisibility(0);
        bniq.a(this.a).setVisibility(8);
        bniq.a(this.a).setVisibility(8);
        bniq.a(this.a).setEntryPresent(false);
        continue;
        bniq.a(this.a).setVisibility(8);
        bniq.a(this.a).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnjb
 * JD-Core Version:    0.7.0.1
 */