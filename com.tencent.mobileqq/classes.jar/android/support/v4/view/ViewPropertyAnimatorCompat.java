package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public class ViewPropertyAnimatorCompat
{
  static final ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl IMPL = new ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl();
  static final int LISTENER_TAG_ID = 2113929216;
  private static final String TAG = "ViewAnimatorCompat";
  private Runnable mEndAction = null;
  private int mOldLayerType = -1;
  private Runnable mStartAction = null;
  private WeakReference<View> mView;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 19)
    {
      IMPL = new ViewPropertyAnimatorCompat.KitKatViewPropertyAnimatorCompatImpl();
      return;
    }
    if (i >= 18)
    {
      IMPL = new ViewPropertyAnimatorCompat.JBMr2ViewPropertyAnimatorCompatImpl();
      return;
    }
    if (i >= 16)
    {
      IMPL = new ViewPropertyAnimatorCompat.JBViewPropertyAnimatorCompatImpl();
      return;
    }
    if (i >= 14)
    {
      IMPL = new ViewPropertyAnimatorCompat.ICSViewPropertyAnimatorCompatImpl();
      return;
    }
  }
  
  ViewPropertyAnimatorCompat(View paramView)
  {
    this.mView = new WeakReference(paramView);
  }
  
  public ViewPropertyAnimatorCompat alpha(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.alpha(this, localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat alphaBy(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.alphaBy(this, localView, paramFloat);
    }
    return this;
  }
  
  public void cancel()
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.cancel(this, localView);
    }
  }
  
  public long getDuration()
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      return IMPL.getDuration(this, localView);
    }
    return 0L;
  }
  
  public Interpolator getInterpolator()
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      return IMPL.getInterpolator(this, localView);
    }
    return null;
  }
  
  public long getStartDelay()
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      return IMPL.getStartDelay(this, localView);
    }
    return 0L;
  }
  
  public ViewPropertyAnimatorCompat rotation(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.rotation(this, localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat rotationBy(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.rotationBy(this, localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat rotationX(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.rotationX(this, localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat rotationXBy(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.rotationXBy(this, localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat rotationY(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.rotationY(this, localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat rotationYBy(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.rotationYBy(this, localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat scaleX(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.scaleX(this, localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat scaleXBy(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.scaleXBy(this, localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat scaleY(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.scaleY(this, localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat scaleYBy(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.scaleYBy(this, localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat setDuration(long paramLong)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.setDuration(this, localView, paramLong);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat setInterpolator(Interpolator paramInterpolator)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.setInterpolator(this, localView, paramInterpolator);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat setListener(ViewPropertyAnimatorListener paramViewPropertyAnimatorListener)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.setListener(this, localView, paramViewPropertyAnimatorListener);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat setStartDelay(long paramLong)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.setStartDelay(this, localView, paramLong);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat setUpdateListener(ViewPropertyAnimatorUpdateListener paramViewPropertyAnimatorUpdateListener)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.setUpdateListener(this, localView, paramViewPropertyAnimatorUpdateListener);
    }
    return this;
  }
  
  public void start()
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.start(this, localView);
    }
  }
  
  public ViewPropertyAnimatorCompat translationX(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.translationX(this, localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat translationXBy(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.translationXBy(this, localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat translationY(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.translationY(this, localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat translationYBy(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.translationYBy(this, localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat withEndAction(Runnable paramRunnable)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.withEndAction(this, localView, paramRunnable);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat withLayer()
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.withLayer(this, localView);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat withStartAction(Runnable paramRunnable)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.withStartAction(this, localView, paramRunnable);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat x(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.x(this, localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat xBy(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.xBy(this, localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat y(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.y(this, localView, paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat yBy(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      IMPL.yBy(this, localView, paramFloat);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.view.ViewPropertyAnimatorCompat
 * JD-Core Version:    0.7.0.1
 */