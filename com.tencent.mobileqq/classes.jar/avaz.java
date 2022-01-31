import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;

class avaz
  implements Animation.AnimationListener
{
  avaz(avay paramavay) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (!avay.a(this.a)) {
      for (;;)
      {
        int j = (int)(avay.a(this.a) * (Math.random() * 2.0D - 1.0D));
        int i = (int)Math.sqrt(avay.a(this.a) * avay.a(this.a) - j * j);
        if (Math.random() > 0.5D) {}
        while ((avay.b(this.a) + j) * (avay.b(this.a) + j) + (avay.c(this.a) + i) * (avay.c(this.a) + i) <= avay.d(this.a) * avay.d(this.a))
        {
          avay.a(this.a, new TranslateAnimation(avay.b(this.a), avay.b(this.a) + j, avay.c(this.a), avay.c(this.a) + i));
          avay.a(this.a, j + avay.b(this.a));
          avay.b(this.a, i + avay.c(this.a));
          avay.a(this.a).setAnimationListener(avay.a(this.a));
          avay.a(this.a).setDuration(avay.a(this.a) * (int)(50.0D + Math.random() * 30.0D));
          avay.a(this.a).startAnimation(avay.a(this.a));
          return;
          i = -i;
        }
      }
    }
    avay.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avaz
 * JD-Core Version:    0.7.0.1
 */