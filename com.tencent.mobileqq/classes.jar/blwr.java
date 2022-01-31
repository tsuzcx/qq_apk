import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.capture.view.ProviderView;
import dov.com.qq.im.capture.view.QIMProviderContainerView;

public class blwr
  implements Animation.AnimationListener
{
  public blwr(QIMProviderContainerView paramQIMProviderContainerView) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QIMProviderContainerView.a(this.a) != null)
    {
      QIMProviderContainerView.a(this.a).setAlpha(1.0F);
      QIMProviderContainerView.a(this.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blwr
 * JD-Core Version:    0.7.0.1
 */