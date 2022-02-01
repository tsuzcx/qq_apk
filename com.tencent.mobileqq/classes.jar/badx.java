import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;

class badx
  extends blgm
{
  badx(badw parambadw) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (badw.a(this.a) != null)
    {
      if (paramAnimation == badw.b(this.a)) {
        badw.a(this.a, 1);
      }
      badw.a(this.a).clearAnimation();
      badw.a(this.a).clearAnimation();
    }
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if ((badw.a(this.a) != null) && (paramAnimation == badw.a(this.a))) {
      badw.a(this.a, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     badx
 * JD-Core Version:    0.7.0.1
 */