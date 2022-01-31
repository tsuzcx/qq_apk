import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;

class awwx
  implements Animation.AnimationListener
{
  awwx(awww paramawww) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (!awww.a(this.a)) {
      for (;;)
      {
        int j = (int)(awww.a(this.a) * (Math.random() * 2.0D - 1.0D));
        int i = (int)Math.sqrt(awww.a(this.a) * awww.a(this.a) - j * j);
        if (Math.random() > 0.5D) {}
        while ((awww.b(this.a) + j) * (awww.b(this.a) + j) + (awww.c(this.a) + i) * (awww.c(this.a) + i) <= awww.d(this.a) * awww.d(this.a))
        {
          awww.a(this.a, new TranslateAnimation(awww.b(this.a), awww.b(this.a) + j, awww.c(this.a), awww.c(this.a) + i));
          awww.a(this.a, j + awww.b(this.a));
          awww.b(this.a, i + awww.c(this.a));
          awww.a(this.a).setAnimationListener(awww.a(this.a));
          awww.a(this.a).setDuration(awww.a(this.a) * (int)(50.0D + Math.random() * 30.0D));
          awww.a(this.a).startAnimation(awww.a(this.a));
          return;
          i = -i;
        }
      }
    }
    awww.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awwx
 * JD-Core Version:    0.7.0.1
 */