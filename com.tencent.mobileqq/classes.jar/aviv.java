import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.widget.immersive.ImmersiveTitleBar2;

class aviv
  implements Animation.AnimationListener
{
  aviv(avhw paramavhw) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == avhw.b(this.a))
    {
      avhw.a(this.a).setVisibility(8);
      avhw.a(this.a).setVisibility(4);
      avhw.a(this.a).clearAnimation();
      avhw.a(this.a).clearAnimation();
      avhw.a(this.a).setBackgroundResource(2130848587);
      avhw.a(this.a).setTextColor(this.a.a.getResources().getColor(2131166604));
      avhw.b(this.a).setTextColor(this.a.a.getResources().getColor(2131166604));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == avhw.a(this.a))
    {
      avhw.a(this.a).setVisibility(0);
      avhw.a(this.a).setVisibility(0);
      avhw.a(this.a).setBackgroundResource(2130849987);
      avhw.a(this.a).setTextColor(this.a.a.getResources().getColor(2131166895));
      avhw.b(this.a).setTextColor(this.a.a.getResources().getColor(2131166895));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aviv
 * JD-Core Version:    0.7.0.1
 */