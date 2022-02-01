import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;

class bnde
  implements Animation.AnimationListener
{
  bnde(bnda parambnda, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.jdField_a_of_type_Bnda.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView != null) && (!bnda.a(this.jdField_a_of_type_Bnda)))
    {
      this.jdField_a_of_type_Bnda.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setAlpha(1.0F);
      this.jdField_a_of_type_Bnda.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setVisibility(4);
    }
    if (bnda.b(this.jdField_a_of_type_Bnda) != null)
    {
      bnda.c(this.jdField_a_of_type_Bnda).a(this.jdField_a_of_type_Int, new Object[0]);
      bnda.d(this.jdField_a_of_type_Bnda).a(196612, new Object[0]);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.jdField_a_of_type_Bnda.jdField_a_of_type_Bmxa.a().a(true, 150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnde
 * JD-Core Version:    0.7.0.1
 */