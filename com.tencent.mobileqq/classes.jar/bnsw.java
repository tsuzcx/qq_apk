import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;

public class bnsw
{
  public static void a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat3, paramFloat4, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(paramInt);
    localScaleAnimation.setFillEnabled(true);
    localScaleAnimation.setFillBefore(true);
    localScaleAnimation.setFillAfter(true);
    if (paramAnimationListener != null) {
      localScaleAnimation.setAnimationListener(paramAnimationListener);
    }
    paramView.startAnimation(localScaleAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnsw
 * JD-Core Version:    0.7.0.1
 */