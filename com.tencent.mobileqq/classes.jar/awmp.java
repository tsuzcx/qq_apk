import android.view.View;
import android.view.animation.Animation;
import com.tencent.mobileqq.portal.FormalView;
import com.tencent.mobileqq.portal.StrokeTextView;

public class awmp
  extends bhry
{
  public awmp(FormalView paramFormalView, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.c();
    this.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a = true;
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if (FormalView.a(this.jdField_a_of_type_ComTencentMobileqqPortalFormalView) != null) {
      FormalView.a(this.jdField_a_of_type_ComTencentMobileqqPortalFormalView).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awmp
 * JD-Core Version:    0.7.0.1
 */