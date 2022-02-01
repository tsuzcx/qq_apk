import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendSearchBarView;

public class arqf
  implements Animator.AnimatorListener
{
  public arqf(ExtendFriendSearchBarView paramExtendFriendSearchBarView, View paramView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    paramAnimator = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramAnimator.topMargin = (-ExtendFriendSearchBarView.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView));
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramAnimator);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramAnimator.topMargin = (-ExtendFriendSearchBarView.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView));
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramAnimator);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arqf
 * JD-Core Version:    0.7.0.1
 */