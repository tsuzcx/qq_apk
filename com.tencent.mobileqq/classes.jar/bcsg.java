import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.widget.TabDragAnimationView;

public final class bcsg
  implements ValueAnimator.AnimatorUpdateListener
{
  private final TabDragAnimationView a;
  
  public bcsg(TabDragAnimationView paramTabDragAnimationView)
  {
    this.a = paramTabDragAnimationView;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.a(f, 0.0F, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcsg
 * JD-Core Version:    0.7.0.1
 */