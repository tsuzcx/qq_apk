import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;

class aqju
  implements Animation.AnimationListener
{
  aqju(aqjt paramaqjt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.a.removeView(this.a.jdField_a_of_type_AndroidViewView);
    this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.getWindow().setBackgroundDrawable(null);
    Face2FaceAddFriendActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity);
    this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.n = true;
    if (aqkl.a >= aqkl.b)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.a(aqkl.a, aqkl.b);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.a(aqkl.a, 0L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqju
 * JD-Core Version:    0.7.0.1
 */