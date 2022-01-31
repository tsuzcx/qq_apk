import android.content.Context;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.ViewSwitcher.ViewFactory;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;

class aqqq
  implements ViewSwitcher.ViewFactory
{
  aqqq(aqqo paramaqqo) {}
  
  public View makeView()
  {
    CornerImageView localCornerImageView = new CornerImageView(aqqo.a(this.a));
    localCornerImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    localCornerImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localCornerImageView.setRadius(actn.a(30.0F, aqqo.a(this.a).getResources()) / 2);
    return localCornerImageView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqqq
 * JD-Core Version:    0.7.0.1
 */