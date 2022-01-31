import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;

class aqyl
  implements Animation.AnimationListener
{
  aqyl(aqyg paramaqyg) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseListenTogetherPanel", 2, "hidePanelView, onAnimationEnd, isDodingAnimation=" + this.a.jdField_a_of_type_Boolean);
    }
    this.a.jdField_a_of_type_AndroidWidgetFrameLayout.clearAnimation();
    paramAnimation.setAnimationListener(null);
    aqyg.a(this.a, false);
    this.a.a();
    this.a.jdField_a_of_type_Boolean = false;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseListenTogetherPanel", 2, "hidePanelView, onAnimationStart, isDodingAnimation=" + this.a.jdField_a_of_type_Boolean);
    }
    this.a.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aqyl
 * JD-Core Version:    0.7.0.1
 */