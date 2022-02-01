import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.widget.immersive.ImmersiveTitleBar2;

class ayni
  implements Animation.AnimationListener
{
  ayni(aymj paramaymj) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == aymj.b(this.a))
    {
      aymj.a(this.a).setVisibility(8);
      aymj.a(this.a).setVisibility(4);
      aymj.a(this.a).clearAnimation();
      aymj.a(this.a).clearAnimation();
      aymj.a(this.a).setBackgroundResource(2130849155);
      aymj.a(this.a).setTextColor(this.a.a.getResources().getColor(2131166690));
      aymj.b(this.a).setTextColor(this.a.a.getResources().getColor(2131166690));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == aymj.a(this.a))
    {
      aymj.a(this.a).setVisibility(0);
      aymj.a(this.a).setVisibility(0);
      aymj.a(this.a).setBackgroundResource(2130850668);
      aymj.a(this.a).setTextColor(this.a.a.getResources().getColor(2131166984));
      aymj.b(this.a).setTextColor(this.a.a.getResources().getColor(2131166984));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayni
 * JD-Core Version:    0.7.0.1
 */