import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.profile.view.VipTagView;

public class bacu
  implements Animation.AnimationListener
{
  public bacu(VipTagView paramVipTagView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (VipTagView.a(this.a)) {
      VipTagView.a(this.a).a();
    }
    VipTagView.a(this.a, false);
    this.a.invalidate();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    VipTagView.a(this.a, 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bacu
 * JD-Core Version:    0.7.0.1
 */