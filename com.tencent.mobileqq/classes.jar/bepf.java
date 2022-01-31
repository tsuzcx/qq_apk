import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.qqmini.sdk.core.widget.media.danmu.BarrageView;

public class bepf
  implements Animation.AnimationListener
{
  private final View a;
  
  private bepf(BarrageView paramBarrageView, View paramView)
  {
    this.a = paramView;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.b.removeView(this.a);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bepf
 * JD-Core Version:    0.7.0.1
 */