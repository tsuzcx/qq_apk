import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.ViewPropertyAnimator;
import android.widget.LinearLayout;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenRelativeLayout;
import java.util.Iterator;
import java.util.List;

public class aoas
  implements Animator.AnimatorListener
{
  public aoas(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout, LinearLayout paramLinearLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ColorNoteSmallScreenRelativeLayout.c(this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout, false);
    paramAnimator = ColorNoteSmallScreenRelativeLayout.a(this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout).iterator();
    while (paramAnimator.hasNext()) {
      ((ColorNote)paramAnimator.next()).animate = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.f();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.animate().setListener(null).translationX(0.0F).setDuration(200L).start();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoas
 * JD-Core Version:    0.7.0.1
 */