import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.qqmini.sdk.launcher.AppUIProxy.LoadingUI;

public class bgqf
  implements Animation.AnimationListener
{
  public bgqf(AppUIProxy.LoadingUI paramLoadingUI) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    AppUIProxy.LoadingUI.a(this.a).setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgqf
 * JD-Core Version:    0.7.0.1
 */