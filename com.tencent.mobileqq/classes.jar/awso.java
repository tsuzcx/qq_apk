import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;

class awso
  implements Animation.AnimationListener
{
  awso(awsn paramawsn) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (!awsn.a(this.a)) {
      for (;;)
      {
        int j = (int)(awsn.a(this.a) * (Math.random() * 2.0D - 1.0D));
        int i = (int)Math.sqrt(awsn.a(this.a) * awsn.a(this.a) - j * j);
        if (Math.random() > 0.5D) {}
        while ((awsn.b(this.a) + j) * (awsn.b(this.a) + j) + (awsn.c(this.a) + i) * (awsn.c(this.a) + i) <= awsn.d(this.a) * awsn.d(this.a))
        {
          awsn.a(this.a, new TranslateAnimation(awsn.b(this.a), awsn.b(this.a) + j, awsn.c(this.a), awsn.c(this.a) + i));
          awsn.a(this.a, j + awsn.b(this.a));
          awsn.b(this.a, i + awsn.c(this.a));
          awsn.a(this.a).setAnimationListener(awsn.a(this.a));
          awsn.a(this.a).setDuration(awsn.a(this.a) * (int)(50.0D + Math.random() * 30.0D));
          awsn.a(this.a).startAnimation(awsn.a(this.a));
          return;
          i = -i;
        }
      }
    }
    awsn.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awso
 * JD-Core Version:    0.7.0.1
 */