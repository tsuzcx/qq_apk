import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class bjzz
  extends AnimatorListenerAdapter
{
  bjzz(bjzx parambjzx) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    veg.b(bjzt.a, "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    veg.b(bjzt.a, "scaleAnimator end!");
    this.a.w = 1.0F;
    this.a.j = false;
    this.a.b.k();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    veg.b(bjzt.a, "scaleAnimator start!");
    this.a.j = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjzz
 * JD-Core Version:    0.7.0.1
 */