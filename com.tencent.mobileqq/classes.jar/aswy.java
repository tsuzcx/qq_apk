import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.qphone.base.util.QLog;

class aswy
  implements Animation.AnimationListener
{
  aswy(asww paramasww) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d(Face2FaceAddFriendActivity.a, 2, "startFriendDisappearAnimation disappear ( disappearCount: " + this.a.h + ", disappearSize: " + this.a.i + " )");
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aswy
 * JD-Core Version:    0.7.0.1
 */