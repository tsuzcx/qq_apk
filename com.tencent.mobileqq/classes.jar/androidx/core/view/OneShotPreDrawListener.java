package androidx.core.view;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import androidx.annotation.NonNull;

public final class OneShotPreDrawListener
  implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener
{
  private final Runnable mRunnable;
  private final View mView;
  private ViewTreeObserver mViewTreeObserver;
  
  private OneShotPreDrawListener(View paramView, Runnable paramRunnable)
  {
    this.mView = paramView;
    this.mViewTreeObserver = paramView.getViewTreeObserver();
    this.mRunnable = paramRunnable;
  }
  
  @NonNull
  public static OneShotPreDrawListener add(@NonNull View paramView, @NonNull Runnable paramRunnable)
  {
    if (paramView != null)
    {
      if (paramRunnable != null)
      {
        paramRunnable = new OneShotPreDrawListener(paramView, paramRunnable);
        paramView.getViewTreeObserver().addOnPreDrawListener(paramRunnable);
        paramView.addOnAttachStateChangeListener(paramRunnable);
        return paramRunnable;
      }
      throw new NullPointerException("runnable == null");
    }
    throw new NullPointerException("view == null");
  }
  
  public boolean onPreDraw()
  {
    removeListener();
    this.mRunnable.run();
    return true;
  }
  
  public void onViewAttachedToWindow(View paramView)
  {
    this.mViewTreeObserver = paramView.getViewTreeObserver();
  }
  
  public void onViewDetachedFromWindow(View paramView)
  {
    removeListener();
  }
  
  public void removeListener()
  {
    if (this.mViewTreeObserver.isAlive()) {
      this.mViewTreeObserver.removeOnPreDrawListener(this);
    } else {
      this.mView.getViewTreeObserver().removeOnPreDrawListener(this);
    }
    this.mView.removeOnAttachStateChangeListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.view.OneShotPreDrawListener
 * JD-Core Version:    0.7.0.1
 */