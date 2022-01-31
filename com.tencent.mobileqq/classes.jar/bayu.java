import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;

public class bayu
  implements Animation.AnimationListener
{
  public bayu(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.b.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bayu
 * JD-Core Version:    0.7.0.1
 */