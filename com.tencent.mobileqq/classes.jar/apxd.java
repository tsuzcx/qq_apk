import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.emoticonview.FastImagePreviewLayout;
import com.tencent.qphone.base.util.QLog;

public class apxd
  implements Animation.AnimationListener
{
  public apxd(FastImagePreviewLayout paramFastImagePreviewLayout) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d(FastImagePreviewLayout.a, 2, "removeFastImage fadeoutanimation ended");
    }
    this.a.removeAllViews();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apxd
 * JD-Core Version:    0.7.0.1
 */