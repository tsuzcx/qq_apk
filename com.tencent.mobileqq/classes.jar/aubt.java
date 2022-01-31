import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;

class aubt
  implements Animation.AnimationListener
{
  aubt(aubs paramaubs) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (!aubs.a(this.a)) {
      for (;;)
      {
        int j = (int)(aubs.a(this.a) * (Math.random() * 2.0D - 1.0D));
        int i = (int)Math.sqrt(aubs.a(this.a) * aubs.a(this.a) - j * j);
        if (Math.random() > 0.5D) {}
        while ((aubs.b(this.a) + j) * (aubs.b(this.a) + j) + (aubs.c(this.a) + i) * (aubs.c(this.a) + i) <= aubs.d(this.a) * aubs.d(this.a))
        {
          aubs.a(this.a, new TranslateAnimation(aubs.b(this.a), aubs.b(this.a) + j, aubs.c(this.a), aubs.c(this.a) + i));
          aubs.a(this.a, j + aubs.b(this.a));
          aubs.b(this.a, i + aubs.c(this.a));
          aubs.a(this.a).setAnimationListener(aubs.a(this.a));
          aubs.a(this.a).setDuration(aubs.a(this.a) * (int)(50.0D + Math.random() * 30.0D));
          aubs.a(this.a).startAnimation(aubs.a(this.a));
          return;
          i = -i;
        }
      }
    }
    aubs.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aubt
 * JD-Core Version:    0.7.0.1
 */