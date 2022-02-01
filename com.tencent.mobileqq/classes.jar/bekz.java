import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.util.List;

class bekz
  implements Animation.AnimationListener
{
  bekz(bekx parambekx) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (bekx.a(this.a) >= bekx.a(this.a).size())
    {
      this.a.a(4);
      return;
    }
    bekx.b(this.a);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (bekx.a(this.a) == 0) {
      this.a.a(3);
    }
    bekx.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bekz
 * JD-Core Version:    0.7.0.1
 */