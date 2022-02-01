import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class bowm
  extends AnimatorListenerAdapter
{
  bowm(bowi parambowi) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    ykq.b(bowf.a, "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ykq.b(bowf.a, "scaleAnimator end!");
    this.a.w = 1.0F;
    this.a.j = false;
    this.a.a.k();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ykq.b(bowf.a, "scaleAnimator start!");
    this.a.j = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bowm
 * JD-Core Version:    0.7.0.1
 */