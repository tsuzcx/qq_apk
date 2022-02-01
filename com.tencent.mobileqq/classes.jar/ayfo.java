import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class ayfo
  implements Animation.AnimationListener
{
  ayfo(ayek paramayek) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == ayek.b(this.a))
    {
      ayek.a(this.a).setVisibility(8);
      ayek.a(this.a).clearAnimation();
      ayek.a(this.a).setBackgroundResource(2130849158);
      ayek.a(this.a).setTextColor(this.a.a.getResources().getColor(2131166723));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == ayek.a(this.a))
    {
      ayek.a(this.a).setVisibility(0);
      ayek.a(this.a).setBackgroundResource(2130850724);
      ayek.a(this.a).setTextColor(this.a.a.getResources().getColor(2131167020));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayfo
 * JD-Core Version:    0.7.0.1
 */