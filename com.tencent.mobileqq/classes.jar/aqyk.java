import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;

class aqyk
  implements Animation.AnimationListener
{
  aqyk(aqyg paramaqyg) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseListenTogetherPanel", 2, "showPanelView, onAnimationEnd, isDodingAnimation=" + this.a.jdField_a_of_type_Boolean);
    }
    this.a.jdField_a_of_type_AndroidWidgetFrameLayout.clearAnimation();
    paramAnimation.setAnimationListener(null);
    aqyg.a(this.a, true);
    this.a.a();
    this.a.jdField_a_of_type_Boolean = false;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseListenTogetherPanel", 2, "showPanelView, onAnimationStart, isDodingAnimation=" + this.a.jdField_a_of_type_Boolean);
    }
    this.a.jdField_a_of_type_Boolean = true;
    aqyg.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aqyk
 * JD-Core Version:    0.7.0.1
 */