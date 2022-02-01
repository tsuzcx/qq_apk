import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.PickerContainer;

public class bqxd
  implements ValueAnimator.AnimatorUpdateListener
{
  public bqxd(PickerContainer paramPickerContainer) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.setAlpha(PickerContainer.b(this.a).floatValue());
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqxd
 * JD-Core Version:    0.7.0.1
 */