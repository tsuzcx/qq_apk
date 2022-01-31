import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class avlw
  implements Animation.AnimationListener
{
  avlw(avkt paramavkt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == avkt.b(this.a))
    {
      avkt.a(this.a).setVisibility(8);
      avkt.a(this.a).clearAnimation();
      avkt.a(this.a).setBackgroundResource(2130848660);
      avkt.a(this.a).setTextColor(this.a.a.getResources().getColor(2131166606));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == avkt.a(this.a))
    {
      avkt.a(this.a).setVisibility(0);
      avkt.a(this.a).setBackgroundResource(2130850060);
      avkt.a(this.a).setTextColor(this.a.a.getResources().getColor(2131166897));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avlw
 * JD-Core Version:    0.7.0.1
 */