import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class awzi
  implements Animation.AnimationListener
{
  awzi(awyf paramawyf) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == awyf.b(this.a))
    {
      awyf.a(this.a).setVisibility(8);
      awyf.a(this.a).clearAnimation();
      awyf.a(this.a).setBackgroundResource(2130849066);
      awyf.a(this.a).setTextColor(this.a.a.getResources().getColor(2131166709));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == awyf.a(this.a))
    {
      awyf.a(this.a).setVisibility(0);
      awyf.a(this.a).setBackgroundResource(2130850593);
      awyf.a(this.a).setTextColor(this.a.a.getResources().getColor(2131167006));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awzi
 * JD-Core Version:    0.7.0.1
 */