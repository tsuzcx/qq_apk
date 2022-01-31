import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.RelativeLayout;

class apxf
  extends AnimatorListenerAdapter
{
  apxf(apxb paramapxb) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    this.a.d.setVisibility(8);
    this.a.a.setVisibility(8);
    this.a.a.setFocusable(false);
    apxb.a(this.a).sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apxf
 * JD-Core Version:    0.7.0.1
 */