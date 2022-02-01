import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;

class aswm
  implements Animation.AnimationListener
{
  aswm(aswl paramaswl) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.a.removeView(this.a.jdField_a_of_type_AndroidViewView);
    this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.getWindow().setBackgroundDrawable(null);
    Face2FaceAddFriendActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity);
    this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.n = true;
    if (asxd.a >= asxd.b)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.a(asxd.a, asxd.b);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.a(asxd.a, 0L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aswm
 * JD-Core Version:    0.7.0.1
 */