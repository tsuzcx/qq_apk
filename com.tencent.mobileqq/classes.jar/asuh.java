import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class asuh
  implements Animation.AnimationListener
{
  asuh(aste paramaste) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == aste.b(this.a))
    {
      aste.a(this.a).setVisibility(8);
      aste.a(this.a).clearAnimation();
      aste.a(this.a).setBackgroundResource(2130847966);
      aste.a(this.a).setTextColor(this.a.a.getResources().getColor(2131100964));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == aste.a(this.a))
    {
      aste.a(this.a).setVisibility(0);
      aste.a(this.a).setBackgroundResource(2130849303);
      aste.a(this.a).setTextColor(this.a.a.getResources().getColor(2131101254));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asuh
 * JD-Core Version:    0.7.0.1
 */