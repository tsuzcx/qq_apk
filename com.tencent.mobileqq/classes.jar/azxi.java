import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;

class azxi
  extends bkxp
{
  azxi(azxh paramazxh) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (azxh.a(this.a) != null)
    {
      if (paramAnimation == azxh.b(this.a)) {
        azxh.a(this.a, 1);
      }
      azxh.a(this.a).clearAnimation();
      azxh.a(this.a).clearAnimation();
    }
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if ((azxh.a(this.a) != null) && (paramAnimation == azxh.a(this.a))) {
      azxh.a(this.a, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azxi
 * JD-Core Version:    0.7.0.1
 */