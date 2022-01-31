import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.RelativeLayout;

class aqrh
  extends AnimatorListenerAdapter
{
  aqrh(aqrd paramaqrd) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    this.a.d.setVisibility(8);
    this.a.a.setVisibility(8);
    this.a.a.setFocusable(false);
    aqrd.a(this.a).sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqrh
 * JD-Core Version:    0.7.0.1
 */