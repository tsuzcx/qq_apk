import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.PickerContainer;

public class bqxe
  implements Animator.AnimatorListener
{
  public bqxe(PickerContainer paramPickerContainer) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (PickerContainer.a(this.a))
    {
      if (PickerContainer.b(this.a).floatValue() < 0.01F) {
        this.a.setVisibility(4);
      }
      PickerContainer.a(this.a, false);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (PickerContainer.a(this.a))
    {
      if (PickerContainer.b(this.a).floatValue() < 0.01F) {
        this.a.setVisibility(4);
      }
      PickerContainer.a(this.a, false);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqxe
 * JD-Core Version:    0.7.0.1
 */