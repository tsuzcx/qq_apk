import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.widget.immersive.ImmersiveTitleBar2;

class atrv
  implements Animation.AnimationListener
{
  atrv(atqw paramatqw) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == atqw.b(this.a))
    {
      atqw.a(this.a).setVisibility(8);
      atqw.a(this.a).setVisibility(4);
      atqw.a(this.a).clearAnimation();
      atqw.a(this.a).clearAnimation();
      atqw.a(this.a).setBackgroundResource(2130848202);
      atqw.a(this.a).setTextColor(this.a.a.getResources().getColor(2131166557));
      atqw.b(this.a).setTextColor(this.a.a.getResources().getColor(2131166557));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == atqw.a(this.a))
    {
      atqw.a(this.a).setVisibility(0);
      atqw.a(this.a).setVisibility(0);
      atqw.a(this.a).setBackgroundResource(2130849547);
      atqw.a(this.a).setTextColor(this.a.a.getResources().getColor(2131166848));
      atqw.b(this.a).setTextColor(this.a.a.getResources().getColor(2131166848));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atrv
 * JD-Core Version:    0.7.0.1
 */