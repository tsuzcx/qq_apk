import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;

class azkm
  implements Animation.AnimationListener
{
  azkm(azkl paramazkl) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (!azkl.a(this.a)) {
      for (;;)
      {
        int j = (int)(azkl.a(this.a) * (Math.random() * 2.0D - 1.0D));
        int i = (int)Math.sqrt(azkl.a(this.a) * azkl.a(this.a) - j * j);
        if (Math.random() > 0.5D) {}
        while ((azkl.b(this.a) + j) * (azkl.b(this.a) + j) + (azkl.c(this.a) + i) * (azkl.c(this.a) + i) <= azkl.d(this.a) * azkl.d(this.a))
        {
          azkl.a(this.a, new TranslateAnimation(azkl.b(this.a), azkl.b(this.a) + j, azkl.c(this.a), azkl.c(this.a) + i));
          azkl.a(this.a, j + azkl.b(this.a));
          azkl.b(this.a, i + azkl.c(this.a));
          azkl.a(this.a).setAnimationListener(azkl.a(this.a));
          azkl.a(this.a).setDuration(azkl.a(this.a) * (int)(50.0D + Math.random() * 30.0D));
          azkl.a(this.a).startAnimation(azkl.a(this.a));
          return;
          i = -i;
        }
      }
    }
    azkl.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azkm
 * JD-Core Version:    0.7.0.1
 */