import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

public class aykf
  implements Animation.AnimationListener
{
  public aykf(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    NearbyPeopleProfileActivity.a(this.a).removeView(NearbyPeopleProfileActivity.a(this.a));
    NearbyPeopleProfileActivity.a(this.a).a();
    NearbyPeopleProfileActivity.a(this.a, null);
    NearbyPeopleProfileActivity.a(this.a, null);
    if (NearbyPeopleProfileActivity.a(this.a) == null)
    {
      NearbyPeopleProfileActivity.a(this.a, this.a.a(this.a.j));
      NearbyPeopleProfileActivity.b(this.a, NearbyPeopleProfileActivity.a(this.a).a());
      NearbyPeopleProfileActivity.a(this.a).a();
      NearbyPeopleProfileActivity.a(this.a).addView(NearbyPeopleProfileActivity.b(this.a), new FrameLayout.LayoutParams(-1, -1));
    }
    NearbyPeopleProfileActivity.a(this.a).a(NearbyPeopleProfileActivity.a(this.a));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aykf
 * JD-Core Version:    0.7.0.1
 */