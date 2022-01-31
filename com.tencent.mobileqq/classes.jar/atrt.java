import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.widget.immersive.ImmersiveTitleBar2;

class atrt
  implements Animation.AnimationListener
{
  atrt(atqu paramatqu) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == atqu.b(this.a))
    {
      atqu.a(this.a).setVisibility(8);
      atqu.a(this.a).setVisibility(4);
      atqu.a(this.a).clearAnimation();
      atqu.a(this.a).clearAnimation();
      atqu.a(this.a).setBackgroundResource(2130848196);
      atqu.a(this.a).setTextColor(this.a.a.getResources().getColor(2131166557));
      atqu.b(this.a).setTextColor(this.a.a.getResources().getColor(2131166557));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == atqu.a(this.a))
    {
      atqu.a(this.a).setVisibility(0);
      atqu.a(this.a).setVisibility(0);
      atqu.a(this.a).setBackgroundResource(2130849538);
      atqu.a(this.a).setTextColor(this.a.a.getResources().getColor(2131166848));
      atqu.b(this.a).setTextColor(this.a.a.getResources().getColor(2131166848));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atrt
 * JD-Core Version:    0.7.0.1
 */