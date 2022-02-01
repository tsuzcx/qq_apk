import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;

class bolq
  implements Animation.AnimationListener
{
  bolq(boll paramboll, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.jdField_a_of_type_Boll.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView != null) && (!boll.a(this.jdField_a_of_type_Boll)))
    {
      this.jdField_a_of_type_Boll.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setAlpha(1.0F);
      this.jdField_a_of_type_Boll.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setVisibility(4);
    }
    if (boll.b(this.jdField_a_of_type_Boll) != null)
    {
      boll.c(this.jdField_a_of_type_Boll).a(this.jdField_a_of_type_Int, new Object[0]);
      boll.d(this.jdField_a_of_type_Boll).a(196612, new Object[0]);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.jdField_a_of_type_Boll.jdField_a_of_type_Bofh.a().a(true, 150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bolq
 * JD-Core Version:    0.7.0.1
 */