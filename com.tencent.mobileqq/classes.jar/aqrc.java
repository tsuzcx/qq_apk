import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.graphics.Point;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.colornote.anim.MusicDanceImageView;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenRelativeLayout;
import com.tencent.mobileqq.util.DisplayUtil;

public class aqrc
  implements Animator.AnimatorListener
{
  public aqrc(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = (LinearLayout.LayoutParams)ColorNoteSmallScreenRelativeLayout.a(this.a).getLayoutParams();
    if (!this.a.a())
    {
      paramAnimator.leftMargin = DisplayUtil.dip2px(this.a.getContext(), 14.5F);
      paramAnimator.rightMargin = 0;
    }
    ColorNoteSmallScreenRelativeLayout.a(this.a).setLayoutParams(paramAnimator);
    ColorNoteSmallScreenRelativeLayout.a(this.a).setVisibility(0);
    ((LinearLayout.LayoutParams)ColorNoteSmallScreenRelativeLayout.a(this.a).getLayoutParams()).leftMargin = DisplayUtil.dip2px(this.a.getContext(), 13.5F);
    ColorNoteSmallScreenRelativeLayout.a(this.a).x = this.a.g();
    paramAnimator = this.a;
    if (ColorNoteSmallScreenRelativeLayout.a(this.a).x < 0) {}
    for (int i = 0;; i = 1)
    {
      ColorNoteSmallScreenRelativeLayout.b(paramAnimator, i);
      ColorNoteSmallScreenRelativeLayout.d(this.a, false);
      return;
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ColorNoteSmallScreenRelativeLayout.d(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqrc
 * JD-Core Version:    0.7.0.1
 */