import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;

public class bbdd
  implements Animation.AnimationListener
{
  public bbdd(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.b.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbdd
 * JD-Core Version:    0.7.0.1
 */