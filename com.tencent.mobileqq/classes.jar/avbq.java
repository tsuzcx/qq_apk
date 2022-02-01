import android.content.Context;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.ViewSwitcher.ViewFactory;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;

class avbq
  implements ViewSwitcher.ViewFactory
{
  avbq(avbp paramavbp) {}
  
  public View makeView()
  {
    CornerImageView localCornerImageView = new CornerImageView(avbp.a(this.a));
    localCornerImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    localCornerImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localCornerImageView.setRadius(AIOUtils.dp2px(30.0F, avbp.a(this.a).getResources()) / 2);
    return localCornerImageView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avbq
 * JD-Core Version:    0.7.0.1
 */