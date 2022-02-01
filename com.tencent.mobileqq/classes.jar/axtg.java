import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class axtg
  implements Animation.AnimationListener
{
  axtg(axsd paramaxsd) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == axsd.b(this.a))
    {
      axsd.a(this.a).setVisibility(8);
      axsd.a(this.a).clearAnimation();
      axsd.a(this.a).setBackgroundResource(2130849136);
      axsd.a(this.a).setTextColor(this.a.a.getResources().getColor(2131166686));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == axsd.a(this.a))
    {
      axsd.a(this.a).setVisibility(0);
      axsd.a(this.a).setBackgroundResource(2130850652);
      axsd.a(this.a).setTextColor(this.a.a.getResources().getColor(2131166980));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axtg
 * JD-Core Version:    0.7.0.1
 */