import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;

class aysm
  extends bjmc
{
  aysm(aysl paramaysl) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (aysl.a(this.a) != null)
    {
      if (paramAnimation == aysl.b(this.a)) {
        aysl.a(this.a, 1);
      }
      aysl.a(this.a).clearAnimation();
      aysl.a(this.a).clearAnimation();
    }
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if ((aysl.a(this.a) != null) && (paramAnimation == aysl.a(this.a))) {
      aysl.a(this.a, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aysm
 * JD-Core Version:    0.7.0.1
 */