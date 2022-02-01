import android.content.Context;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.ViewSwitcher.ViewFactory;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;

class avjk
  implements ViewSwitcher.ViewFactory
{
  avjk(avji paramavji) {}
  
  public View makeView()
  {
    CornerImageView localCornerImageView = new CornerImageView(avji.a(this.a));
    localCornerImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    localCornerImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localCornerImageView.setRadius(agej.a(30.0F, avji.a(this.a).getResources()) / 2);
    return localCornerImageView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avjk
 * JD-Core Version:    0.7.0.1
 */