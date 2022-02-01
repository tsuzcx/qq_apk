import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.widget.ParticipleView;

public class biqt
  extends AnimatorListenerAdapter
{
  public biqt(ParticipleView paramParticipleView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ParticipleView.a(this.a, 1.0F);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biqt
 * JD-Core Version:    0.7.0.1
 */