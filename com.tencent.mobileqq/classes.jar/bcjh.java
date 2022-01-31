import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.widget.immersive.ImmersiveTitleBar2;

public class bcjh
  implements Animation.AnimationListener
{
  public bcjh(VisitorTroopCardFragment paramVisitorTroopCardFragment) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    if (paramAnimation == this.a.b) {
      VisitorTroopCardFragment.a(this.a, false);
    }
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setFocusable(true);
    this.a.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if ((this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (paramAnimation == this.a.jdField_a_of_type_AndroidViewAnimationAlphaAnimation)) {
      VisitorTroopCardFragment.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcjh
 * JD-Core Version:    0.7.0.1
 */