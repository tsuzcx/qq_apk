import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;

class blpw
  implements Animation.AnimationListener
{
  blpw(blpr paramblpr, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.jdField_a_of_type_Blpr.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView != null) && (!blpr.a(this.jdField_a_of_type_Blpr)))
    {
      this.jdField_a_of_type_Blpr.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setAlpha(1.0F);
      this.jdField_a_of_type_Blpr.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setVisibility(4);
    }
    if (blpr.b(this.jdField_a_of_type_Blpr) != null)
    {
      blpr.c(this.jdField_a_of_type_Blpr).a(this.jdField_a_of_type_Int, new Object[0]);
      blpr.d(this.jdField_a_of_type_Blpr).a(196612, new Object[0]);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.jdField_a_of_type_Blpr.jdField_a_of_type_Bljy.a().a(true, 150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blpw
 * JD-Core Version:    0.7.0.1
 */