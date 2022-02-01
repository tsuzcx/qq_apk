import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;

class bacy
  implements Animation.AnimationListener
{
  bacy(bacx parambacx) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (!bacx.a(this.a)) {
      for (;;)
      {
        int j = (int)(bacx.a(this.a) * (Math.random() * 2.0D - 1.0D));
        int i = (int)Math.sqrt(bacx.a(this.a) * bacx.a(this.a) - j * j);
        if (Math.random() > 0.5D) {}
        while ((bacx.b(this.a) + j) * (bacx.b(this.a) + j) + (bacx.c(this.a) + i) * (bacx.c(this.a) + i) <= bacx.d(this.a) * bacx.d(this.a))
        {
          bacx.a(this.a, new TranslateAnimation(bacx.b(this.a), bacx.b(this.a) + j, bacx.c(this.a), bacx.c(this.a) + i));
          bacx.a(this.a, j + bacx.b(this.a));
          bacx.b(this.a, i + bacx.c(this.a));
          bacx.a(this.a).setAnimationListener(bacx.a(this.a));
          bacx.a(this.a).setDuration(bacx.a(this.a) * (int)(50.0D + Math.random() * 30.0D));
          bacx.a(this.a).startAnimation(bacx.a(this.a));
          return;
          i = -i;
        }
      }
    }
    bacx.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bacy
 * JD-Core Version:    0.7.0.1
 */