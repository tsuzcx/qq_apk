import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.jsp.UiApiPlugin;

public class atfd
  implements Animation.AnimationListener
{
  public atfd(UiApiPlugin paramUiApiPlugin, View paramView, int paramInt1, int paramInt2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidViewView.clearAnimation();
    this.jdField_a_of_type_AndroidViewView.layout(this.jdField_a_of_type_AndroidViewView.getLeft(), this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView.getRight(), this.b);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atfd
 * JD-Core Version:    0.7.0.1
 */