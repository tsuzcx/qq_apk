import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Animation;

public class bbgc
{
  public static Animator a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt2, paramInt3 });
    localValueAnimator.addUpdateListener(new bbge(paramInt1, paramView));
    return localValueAnimator;
  }
  
  public static Animation a(View paramView, float paramFloat1, float paramFloat2)
  {
    return new bhtd(Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), new bbgd(paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbgc
 * JD-Core Version:    0.7.0.1
 */