import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;
import com.tencent.image.URLImageView;

class bnbr
  implements Observer<Boolean>
{
  bnbr(bnbp parambnbp) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return;
    }
    if (paramBoolean.booleanValue()) {
      if (bnbp.a(this.a).a())
      {
        bnbp.d(this.a).setVisibility(0);
        bnbp.a(this.a).setVisibility(8);
        this.a.a(false);
        bnbp.a(this.a, false);
      }
    }
    for (;;)
    {
      bnrh.a("VideoStoryPiecesPart", "[GifAuthor]---checkShowGifAuthor when other buttons visibility change");
      bnbp.a(this.a);
      bnbp.b(this.a);
      return;
      if (bnbp.a(this.a).b())
      {
        bnbp.d(this.a).setVisibility(0);
        this.a.a(true);
        bnbp.a(this.a, true);
        if (bnbp.b(this.a)) {
          bnbp.a(this.a).setVisibility(0);
        }
        if ((bnkb.a()) && (bnbp.a(this.a) != null)) {
          bnbp.a(this.a).setVisibility(0);
        }
        bnbp.a(this.a).a(786435, new Object[0]);
      }
      else if (bnbp.a(this.a).c())
      {
        bnbp.d(this.a).setVisibility(0);
        bnbp.a(this.a).setVisibility(8);
        bnbp.a(this.a, false);
        this.a.a(false);
        continue;
        bnbp.a(this.a).setVisibility(8);
        bnbp.a(this.a, false);
        if (bnbp.a(this.a) != null) {
          bnbp.a(this.a).setVisibility(8);
        }
        bnbp.b(this.a).a(786434, new Object[0]);
        if (bnbp.a(this.a) != null) {
          bnbp.a(this.a).setVisibility(8);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnbr
 * JD-Core Version:    0.7.0.1
 */