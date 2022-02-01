import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;

class arsg
  implements Animation.AnimationListener
{
  arsg(arsf paramarsf) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.a.removeView(this.a.jdField_a_of_type_AndroidViewView);
    this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.getWindow().setBackgroundDrawable(null);
    Face2FaceAddFriendActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity);
    this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.n = true;
    if (arsx.a >= arsx.b)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.a(arsx.a, arsx.b);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.a(arsx.a, 0L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arsg
 * JD-Core Version:    0.7.0.1
 */