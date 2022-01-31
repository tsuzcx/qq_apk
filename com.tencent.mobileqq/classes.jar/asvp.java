import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.widget.immersive.ImmersiveTitleBar2;

class asvp
  implements Animation.AnimationListener
{
  asvp(asuq paramasuq) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == asuq.b(this.a))
    {
      asuq.a(this.a).setVisibility(8);
      asuq.a(this.a).setVisibility(4);
      asuq.a(this.a).clearAnimation();
      asuq.a(this.a).clearAnimation();
      asuq.a(this.a).setBackgroundResource(2130847966);
      asuq.a(this.a).setTextColor(this.a.a.getResources().getColor(2131100964));
      asuq.b(this.a).setTextColor(this.a.a.getResources().getColor(2131100964));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == asuq.a(this.a))
    {
      asuq.a(this.a).setVisibility(0);
      asuq.a(this.a).setVisibility(0);
      asuq.a(this.a).setBackgroundResource(2130849303);
      asuq.a(this.a).setTextColor(this.a.a.getResources().getColor(2131101254));
      asuq.b(this.a).setTextColor(this.a.a.getResources().getColor(2131101254));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asvp
 * JD-Core Version:    0.7.0.1
 */