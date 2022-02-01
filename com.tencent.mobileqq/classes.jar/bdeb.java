import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;

class bdeb
  implements Animation.AnimationListener
{
  bdeb(bdea parambdea) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.b(8);
    if (bdea.a(this.a) != null) {
      bdea.a(this.a).setOnClickListener(null);
    }
    this.a.a(2);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdeb
 * JD-Core Version:    0.7.0.1
 */