import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;

class avbb
  implements Animation.AnimationListener
{
  avbb(avba paramavba) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (!avba.a(this.a)) {
      for (;;)
      {
        int j = (int)(avba.a(this.a) * (Math.random() * 2.0D - 1.0D));
        int i = (int)Math.sqrt(avba.a(this.a) * avba.a(this.a) - j * j);
        if (Math.random() > 0.5D) {}
        while ((avba.b(this.a) + j) * (avba.b(this.a) + j) + (avba.c(this.a) + i) * (avba.c(this.a) + i) <= avba.d(this.a) * avba.d(this.a))
        {
          avba.a(this.a, new TranslateAnimation(avba.b(this.a), avba.b(this.a) + j, avba.c(this.a), avba.c(this.a) + i));
          avba.a(this.a, j + avba.b(this.a));
          avba.b(this.a, i + avba.c(this.a));
          avba.a(this.a).setAnimationListener(avba.a(this.a));
          avba.a(this.a).setDuration(avba.a(this.a) * (int)(50.0D + Math.random() * 30.0D));
          avba.a(this.a).startAnimation(avba.a(this.a));
          return;
          i = -i;
        }
      }
    }
    avba.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avbb
 * JD-Core Version:    0.7.0.1
 */