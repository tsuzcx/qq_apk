package android.support.v4.view;

import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;

class ViewPropertyAnimatorCompatICS
{
  public static void alpha(View paramView, float paramFloat)
  {
    paramView.animate().alpha(paramFloat);
  }
  
  public static void alphaBy(View paramView, float paramFloat)
  {
    paramView.animate().alphaBy(paramFloat);
  }
  
  public static void cancel(View paramView)
  {
    paramView.animate().cancel();
  }
  
  public static long getDuration(View paramView)
  {
    return paramView.animate().getDuration();
  }
  
  public static long getStartDelay(View paramView)
  {
    return paramView.animate().getStartDelay();
  }
  
  public static void rotation(View paramView, float paramFloat)
  {
    paramView.animate().rotation(paramFloat);
  }
  
  public static void rotationBy(View paramView, float paramFloat)
  {
    paramView.animate().rotationBy(paramFloat);
  }
  
  public static void rotationX(View paramView, float paramFloat)
  {
    paramView.animate().rotationX(paramFloat);
  }
  
  public static void rotationXBy(View paramView, float paramFloat)
  {
    paramView.animate().rotationXBy(paramFloat);
  }
  
  public static void rotationY(View paramView, float paramFloat)
  {
    paramView.animate().rotationY(paramFloat);
  }
  
  public static void rotationYBy(View paramView, float paramFloat)
  {
    paramView.animate().rotationYBy(paramFloat);
  }
  
  public static void scaleX(View paramView, float paramFloat)
  {
    paramView.animate().scaleX(paramFloat);
  }
  
  public static void scaleXBy(View paramView, float paramFloat)
  {
    paramView.animate().scaleXBy(paramFloat);
  }
  
  public static void scaleY(View paramView, float paramFloat)
  {
    paramView.animate().scaleY(paramFloat);
  }
  
  public static void scaleYBy(View paramView, float paramFloat)
  {
    paramView.animate().scaleYBy(paramFloat);
  }
  
  public static void setDuration(View paramView, long paramLong)
  {
    paramView.animate().setDuration(paramLong);
  }
  
  public static void setInterpolator(View paramView, Interpolator paramInterpolator)
  {
    paramView.animate().setInterpolator(paramInterpolator);
  }
  
  public static void setListener(View paramView, ViewPropertyAnimatorListener paramViewPropertyAnimatorListener)
  {
    if (paramViewPropertyAnimatorListener != null)
    {
      paramView.animate().setListener(new ViewPropertyAnimatorCompatICS.1(paramViewPropertyAnimatorListener, paramView));
      return;
    }
    paramView.animate().setListener(null);
  }
  
  public static void setStartDelay(View paramView, long paramLong)
  {
    paramView.animate().setStartDelay(paramLong);
  }
  
  public static void start(View paramView)
  {
    paramView.animate().start();
  }
  
  public static void translationX(View paramView, float paramFloat)
  {
    paramView.animate().translationX(paramFloat);
  }
  
  public static void translationXBy(View paramView, float paramFloat)
  {
    paramView.animate().translationXBy(paramFloat);
  }
  
  public static void translationY(View paramView, float paramFloat)
  {
    paramView.animate().translationY(paramFloat);
  }
  
  public static void translationYBy(View paramView, float paramFloat)
  {
    paramView.animate().translationYBy(paramFloat);
  }
  
  public static void x(View paramView, float paramFloat)
  {
    paramView.animate().x(paramFloat);
  }
  
  public static void xBy(View paramView, float paramFloat)
  {
    paramView.animate().xBy(paramFloat);
  }
  
  public static void y(View paramView, float paramFloat)
  {
    paramView.animate().y(paramFloat);
  }
  
  public static void yBy(View paramView, float paramFloat)
  {
    paramView.animate().yBy(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.view.ViewPropertyAnimatorCompatICS
 * JD-Core Version:    0.7.0.1
 */