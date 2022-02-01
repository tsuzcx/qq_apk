import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

public class ayke
  implements Animation.AnimationListener
{
  public ayke(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = this.a;
    paramAnimation.k += 1;
    if (NearbyPeopleProfileActivity.a(this.a) != null) {
      NearbyPeopleProfileActivity.a(this.a).a(NearbyPeopleProfileActivity.a(this.a));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayke
 * JD-Core Version:    0.7.0.1
 */