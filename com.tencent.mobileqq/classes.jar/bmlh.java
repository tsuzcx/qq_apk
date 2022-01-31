import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;

class bmlh
  extends AnimatorListenerAdapter
{
  bmlh(bmla parambmla) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.d.setVisibility(8);
    this.a.e.setVisibility(8);
    this.a.f.setVisibility(8);
    this.a.b = this.a.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmlh
 * JD-Core Version:    0.7.0.1
 */