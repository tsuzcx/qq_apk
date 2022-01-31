import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.graphics.Point;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.colornote.anim.MusicDanceImageView;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenRelativeLayout;

public class amjy
  implements Animator.AnimatorListener
{
  public amjy(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = (LinearLayout.LayoutParams)ColorNoteSmallScreenRelativeLayout.a(this.a).getLayoutParams();
    if (!this.a.a())
    {
      paramAnimator.leftMargin = baxn.a(this.a.getContext(), 14.5F);
      paramAnimator.rightMargin = 0;
    }
    ColorNoteSmallScreenRelativeLayout.a(this.a).setLayoutParams(paramAnimator);
    ColorNoteSmallScreenRelativeLayout.a(this.a).setVisibility(0);
    ((LinearLayout.LayoutParams)ColorNoteSmallScreenRelativeLayout.a(this.a).getLayoutParams()).leftMargin = baxn.a(this.a.getContext(), 13.5F);
    ColorNoteSmallScreenRelativeLayout.a(this.a).x = this.a.g();
    paramAnimator = this.a;
    if (ColorNoteSmallScreenRelativeLayout.a(this.a).x < 0) {}
    for (int i = 0;; i = 1)
    {
      ColorNoteSmallScreenRelativeLayout.b(paramAnimator, i);
      return;
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amjy
 * JD-Core Version:    0.7.0.1
 */