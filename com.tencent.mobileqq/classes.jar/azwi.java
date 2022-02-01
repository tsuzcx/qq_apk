import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;

class azwi
  implements Animation.AnimationListener
{
  azwi(azwh paramazwh) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (!azwh.a(this.a)) {
      for (;;)
      {
        int j = (int)(azwh.a(this.a) * (Math.random() * 2.0D - 1.0D));
        int i = (int)Math.sqrt(azwh.a(this.a) * azwh.a(this.a) - j * j);
        if (Math.random() > 0.5D) {}
        while ((azwh.b(this.a) + j) * (azwh.b(this.a) + j) + (azwh.c(this.a) + i) * (azwh.c(this.a) + i) <= azwh.d(this.a) * azwh.d(this.a))
        {
          azwh.a(this.a, new TranslateAnimation(azwh.b(this.a), azwh.b(this.a) + j, azwh.c(this.a), azwh.c(this.a) + i));
          azwh.a(this.a, j + azwh.b(this.a));
          azwh.b(this.a, i + azwh.c(this.a));
          azwh.a(this.a).setAnimationListener(azwh.a(this.a));
          azwh.a(this.a).setDuration(azwh.a(this.a) * (int)(50.0D + Math.random() * 30.0D));
          azwh.a(this.a).startAnimation(azwh.a(this.a));
          return;
          i = -i;
        }
      }
    }
    azwh.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azwi
 * JD-Core Version:    0.7.0.1
 */