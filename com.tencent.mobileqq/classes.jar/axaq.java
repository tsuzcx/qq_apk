import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.widget.immersive.ImmersiveTitleBar2;

class axaq
  implements Animation.AnimationListener
{
  axaq(awzr paramawzr) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == awzr.b(this.a))
    {
      awzr.a(this.a).setVisibility(8);
      awzr.a(this.a).setVisibility(4);
      awzr.a(this.a).clearAnimation();
      awzr.a(this.a).clearAnimation();
      awzr.a(this.a).setBackgroundResource(2130849066);
      awzr.a(this.a).setTextColor(this.a.a.getResources().getColor(2131166709));
      awzr.b(this.a).setTextColor(this.a.a.getResources().getColor(2131166709));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == awzr.a(this.a))
    {
      awzr.a(this.a).setVisibility(0);
      awzr.a(this.a).setVisibility(0);
      awzr.a(this.a).setBackgroundResource(2130850593);
      awzr.a(this.a).setTextColor(this.a.a.getResources().getColor(2131167006));
      awzr.b(this.a).setTextColor(this.a.a.getResources().getColor(2131167006));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axaq
 * JD-Core Version:    0.7.0.1
 */