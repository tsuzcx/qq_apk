import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class ayma
  implements Animation.AnimationListener
{
  ayma(aykx paramaykx) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == aykx.b(this.a))
    {
      aykx.a(this.a).setVisibility(8);
      aykx.a(this.a).clearAnimation();
      aykx.a(this.a).setBackgroundResource(2130849155);
      aykx.a(this.a).setTextColor(this.a.a.getResources().getColor(2131166690));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == aykx.a(this.a))
    {
      aykx.a(this.a).setVisibility(0);
      aykx.a(this.a).setBackgroundResource(2130850668);
      aykx.a(this.a).setTextColor(this.a.a.getResources().getColor(2131166984));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayma
 * JD-Core Version:    0.7.0.1
 */