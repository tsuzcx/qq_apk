import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;

class azll
  extends bkfi
{
  azll(azlk paramazlk) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (azlk.a(this.a) != null)
    {
      if (paramAnimation == azlk.b(this.a)) {
        azlk.a(this.a, 1);
      }
      azlk.a(this.a).clearAnimation();
      azlk.a(this.a).clearAnimation();
    }
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if ((azlk.a(this.a) != null) && (paramAnimation == azlk.a(this.a))) {
      azlk.a(this.a, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azll
 * JD-Core Version:    0.7.0.1
 */