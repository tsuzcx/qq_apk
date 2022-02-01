import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.QLog;

public final class bjdt
  implements ValueAnimator.AnimatorUpdateListener
{
  public float a;
  private final TabDragAnimationView a;
  public boolean a;
  public boolean b = false;
  
  public bjdt(TabDragAnimationView paramTabDragAnimationView)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView = paramTabDragAnimationView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    this.jdField_a_of_type_Float = 1.0F;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f - this.jdField_a_of_type_Float > 0.0F) {
      this.jdField_a_of_type_Boolean = true;
    }
    if ((this.jdField_a_of_type_Boolean) && (f > 0.8F)) {
      this.b = false;
    }
    this.jdField_a_of_type_Float = f;
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView.c();
    if (QLog.isColorLevel()) {
      QLog.d(TabDragAnimationView.class.getSimpleName(), 2, "do mScale animation, percent=" + this.jdField_a_of_type_Float + ",reversed=" + this.jdField_a_of_type_Boolean + ",doAnim=" + this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjdt
 * JD-Core Version:    0.7.0.1
 */