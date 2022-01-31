import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class atqn
  implements Animation.AnimationListener
{
  atqn(atpk paramatpk) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == atpk.b(this.a))
    {
      atpk.a(this.a).setVisibility(8);
      atpk.a(this.a).clearAnimation();
      atpk.a(this.a).setBackgroundResource(2130848202);
      atpk.a(this.a).setTextColor(this.a.a.getResources().getColor(2131166557));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == atpk.a(this.a))
    {
      atpk.a(this.a).setVisibility(0);
      atpk.a(this.a).setBackgroundResource(2130849547);
      atpk.a(this.a).setTextColor(this.a.a.getResources().getColor(2131166848));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atqn
 * JD-Core Version:    0.7.0.1
 */