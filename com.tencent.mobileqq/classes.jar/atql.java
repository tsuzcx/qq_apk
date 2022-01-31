import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class atql
  implements Animation.AnimationListener
{
  atql(atpi paramatpi) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == atpi.b(this.a))
    {
      atpi.a(this.a).setVisibility(8);
      atpi.a(this.a).clearAnimation();
      atpi.a(this.a).setBackgroundResource(2130848196);
      atpi.a(this.a).setTextColor(this.a.a.getResources().getColor(2131166557));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == atpi.a(this.a))
    {
      atpi.a(this.a).setVisibility(0);
      atpi.a(this.a).setBackgroundResource(2130849538);
      atpi.a(this.a).setTextColor(this.a.a.getResources().getColor(2131166848));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atql
 * JD-Core Version:    0.7.0.1
 */