import android.content.Context;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.ViewSwitcher.ViewFactory;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;

class asks
  implements ViewSwitcher.ViewFactory
{
  asks(askr paramaskr) {}
  
  public View makeView()
  {
    CornerImageView localCornerImageView = new CornerImageView(askr.a(this.a));
    localCornerImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    localCornerImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localCornerImageView.setRadius(aepi.a(30.0F, askr.a(this.a).getResources()) / 2);
    return localCornerImageView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asks
 * JD-Core Version:    0.7.0.1
 */