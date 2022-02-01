import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.facetoface.Face2FaceFriendBubbleView;
import com.tencent.qphone.base.util.QLog;

class asqf
  implements Animation.AnimationListener
{
  asqf(asqe paramasqe, asqw paramasqw1, int paramInt1, double paramDouble, boolean paramBoolean1, boolean paramBoolean2, asqw paramasqw2, boolean paramBoolean3, boolean paramBoolean4, Face2FaceFriendBubbleView paramFace2FaceFriendBubbleView, int paramInt2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ((Face2FaceAddFriendActivity)this.jdField_a_of_type_Asqe.a).b(this.jdField_b_of_type_Asqw, this.c, this.d);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendBubbleView.setStatusWithAnimation(this.jdField_b_of_type_Int);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d(Face2FaceAddFriendActivity.a, 2, "startFriendInAnimation currentUin ( " + this.jdField_a_of_type_Asqw.e.substring(0, 4) + ", " + this.jdField_a_of_type_Int + " ) Animation Start  ");
    }
    double d2 = Math.atan(this.jdField_a_of_type_Double) * 180.0D / 3.141592653589793D * this.jdField_a_of_type_Asqe.jdField_b_of_type_Int;
    double d1 = d2;
    if (this.jdField_a_of_type_Boolean) {
      d1 = 180.0D - d2;
    }
    this.jdField_a_of_type_Asqe.jdField_b_of_type_Float = ((float)d1);
    if (QLog.isColorLevel()) {
      QLog.d(Face2FaceAddFriendActivity.a, 2, "startFriendInAnimation uinToHoleIndex add( " + this.jdField_a_of_type_Asqw.e.substring(0, 4) + ", " + this.jdField_a_of_type_Int + " )");
    }
    this.jdField_a_of_type_Asqe.a(2, this.jdField_b_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asqf
 * JD-Core Version:    0.7.0.1
 */