import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.util.List;

class bddw
  implements Animation.AnimationListener
{
  bddw(bddv parambddv) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (bddv.a(this.a) >= bddv.a(this.a).size())
    {
      this.a.a(4);
      return;
    }
    bddv.b(this.a);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (bddv.a(this.a) == 0) {
      this.a.a(3);
    }
    bddv.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bddw
 * JD-Core Version:    0.7.0.1
 */