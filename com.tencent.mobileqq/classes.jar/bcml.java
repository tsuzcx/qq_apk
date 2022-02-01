import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

public class bcml
{
  public static void a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, float paramFloat5, float paramFloat6)
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat5, paramFloat6);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0, paramFloat1, 0, paramFloat2, 0, paramFloat3, 0, paramFloat4);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.setDuration(paramInt);
    localAnimationSet.setFillEnabled(true);
    localAnimationSet.setFillBefore(true);
    localAnimationSet.setFillAfter(true);
    paramView.startAnimation(localAnimationSet);
  }
  
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
  
  public static void a(View paramView, boolean paramBoolean)
  {
    a(paramView, paramBoolean, 200);
  }
  
  public static void a(View paramView, boolean paramBoolean, int paramInt)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.2F, 1.0F);
    localAlphaAnimation.setDuration(paramInt);
    localAlphaAnimation.setFillAfter(paramBoolean);
    paramView.startAnimation(localAlphaAnimation);
  }
  
  public static void b(View paramView, boolean paramBoolean)
  {
    b(paramView, paramBoolean, 200);
  }
  
  public static void b(View paramView, boolean paramBoolean, int paramInt)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.2F);
    localAlphaAnimation.setFillAfter(paramBoolean);
    localAlphaAnimation.setDuration(paramInt);
    paramView.startAnimation(localAlphaAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcml
 * JD-Core Version:    0.7.0.1
 */