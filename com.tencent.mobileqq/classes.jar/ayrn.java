import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;

class ayrn
  implements Animation.AnimationListener
{
  ayrn(ayrm paramayrm) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (!ayrm.a(this.a)) {
      for (;;)
      {
        int j = (int)(ayrm.a(this.a) * (Math.random() * 2.0D - 1.0D));
        int i = (int)Math.sqrt(ayrm.a(this.a) * ayrm.a(this.a) - j * j);
        if (Math.random() > 0.5D) {}
        while ((ayrm.b(this.a) + j) * (ayrm.b(this.a) + j) + (ayrm.c(this.a) + i) * (ayrm.c(this.a) + i) <= ayrm.d(this.a) * ayrm.d(this.a))
        {
          ayrm.a(this.a, new TranslateAnimation(ayrm.b(this.a), ayrm.b(this.a) + j, ayrm.c(this.a), ayrm.c(this.a) + i));
          ayrm.a(this.a, j + ayrm.b(this.a));
          ayrm.b(this.a, i + ayrm.c(this.a));
          ayrm.a(this.a).setAnimationListener(ayrm.a(this.a));
          ayrm.a(this.a).setDuration(ayrm.a(this.a) * (int)(50.0D + Math.random() * 30.0D));
          ayrm.a(this.a).startAnimation(ayrm.a(this.a));
          return;
          i = -i;
        }
      }
    }
    ayrm.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayrn
 * JD-Core Version:    0.7.0.1
 */