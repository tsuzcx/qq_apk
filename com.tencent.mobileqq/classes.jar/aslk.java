import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.RelativeLayout;

class aslk
  extends AnimatorListenerAdapter
{
  aslk(aslg paramaslg) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    this.a.d.setVisibility(8);
    this.a.a.setVisibility(8);
    this.a.a.setFocusable(false);
    aslg.a(this.a).sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aslk
 * JD-Core Version:    0.7.0.1
 */