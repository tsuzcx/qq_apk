import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.widget.immersive.ImmersiveTitleBar2;

class axuo
  implements Animation.AnimationListener
{
  axuo(axtp paramaxtp) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == axtp.b(this.a))
    {
      axtp.a(this.a).setVisibility(8);
      axtp.a(this.a).setVisibility(4);
      axtp.a(this.a).clearAnimation();
      axtp.a(this.a).clearAnimation();
      axtp.a(this.a).setBackgroundResource(2130849136);
      axtp.a(this.a).setTextColor(this.a.a.getResources().getColor(2131166686));
      axtp.b(this.a).setTextColor(this.a.a.getResources().getColor(2131166686));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == axtp.a(this.a))
    {
      axtp.a(this.a).setVisibility(0);
      axtp.a(this.a).setVisibility(0);
      axtp.a(this.a).setBackgroundResource(2130850652);
      axtp.a(this.a).setTextColor(this.a.a.getResources().getColor(2131166980));
      axtp.b(this.a).setTextColor(this.a.a.getResources().getColor(2131166980));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axuo
 * JD-Core Version:    0.7.0.1
 */