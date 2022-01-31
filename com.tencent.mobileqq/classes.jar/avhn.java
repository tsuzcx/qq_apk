import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class avhn
  implements Animation.AnimationListener
{
  avhn(avgk paramavgk) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == avgk.b(this.a))
    {
      avgk.a(this.a).setVisibility(8);
      avgk.a(this.a).clearAnimation();
      avgk.a(this.a).setBackgroundResource(2130848587);
      avgk.a(this.a).setTextColor(this.a.a.getResources().getColor(2131166604));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == avgk.a(this.a))
    {
      avgk.a(this.a).setVisibility(0);
      avgk.a(this.a).setBackgroundResource(2130849987);
      avgk.a(this.a).setTextColor(this.a.a.getResources().getColor(2131166895));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avhn
 * JD-Core Version:    0.7.0.1
 */