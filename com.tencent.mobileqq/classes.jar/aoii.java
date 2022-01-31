import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment;

public class aoii
  implements ValueAnimator.AnimatorUpdateListener
{
  public aoii(ExtendFriendSquareFragment paramExtendFriendSquareFragment, FrameLayout.LayoutParams paramLayoutParams, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (paramValueAnimator.getAnimatedValue() == null) {
      return;
    }
    int i = (int)((1.0F - ((Integer)paramValueAnimator.getAnimatedValue()).intValue() * 1.0F / 1000.0F) * -this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment.j);
    this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams.topMargin = i;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aoii
 * JD-Core Version:    0.7.0.1
 */