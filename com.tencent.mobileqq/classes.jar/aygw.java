import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.widget.immersive.ImmersiveTitleBar2;

class aygw
  implements Animation.AnimationListener
{
  aygw(ayfx paramayfx) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == ayfx.b(this.a))
    {
      ayfx.a(this.a).setVisibility(8);
      ayfx.a(this.a).setVisibility(4);
      ayfx.a(this.a).clearAnimation();
      ayfx.a(this.a).clearAnimation();
      ayfx.a(this.a).setBackgroundResource(2130849158);
      ayfx.a(this.a).setTextColor(this.a.a.getResources().getColor(2131166723));
      ayfx.b(this.a).setTextColor(this.a.a.getResources().getColor(2131166723));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == ayfx.a(this.a))
    {
      ayfx.a(this.a).setVisibility(0);
      ayfx.a(this.a).setVisibility(0);
      ayfx.a(this.a).setBackgroundResource(2130850724);
      ayfx.a(this.a).setTextColor(this.a.a.getResources().getColor(2131167020));
      ayfx.b(this.a).setTextColor(this.a.a.getResources().getColor(2131167020));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aygw
 * JD-Core Version:    0.7.0.1
 */