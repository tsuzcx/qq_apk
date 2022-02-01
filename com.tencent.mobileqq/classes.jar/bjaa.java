import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.widget.ParticipleView;

public class bjaa
  extends AnimatorListenerAdapter
{
  public bjaa(ParticipleView paramParticipleView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ParticipleView.a(this.a, 1.0F);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjaa
 * JD-Core Version:    0.7.0.1
 */