package androidx.appcompat.view;

import android.view.animation.Interpolator;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import java.util.ArrayList;
import java.util.Iterator;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ViewPropertyAnimatorCompatSet
{
  final ArrayList<ViewPropertyAnimatorCompat> mAnimators = new ArrayList();
  private long mDuration = -1L;
  private Interpolator mInterpolator;
  private boolean mIsStarted;
  ViewPropertyAnimatorListener mListener;
  private final ViewPropertyAnimatorListenerAdapter mProxyListener = new ViewPropertyAnimatorCompatSet.1(this);
  
  public void cancel()
  {
    if (!this.mIsStarted) {
      return;
    }
    Iterator localIterator = this.mAnimators.iterator();
    while (localIterator.hasNext()) {
      ((ViewPropertyAnimatorCompat)localIterator.next()).cancel();
    }
    this.mIsStarted = false;
  }
  
  void onAnimationsEnded()
  {
    this.mIsStarted = false;
  }
  
  public ViewPropertyAnimatorCompatSet play(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
  {
    if (!this.mIsStarted) {
      this.mAnimators.add(paramViewPropertyAnimatorCompat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompatSet playSequentially(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat1, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat2)
  {
    this.mAnimators.add(paramViewPropertyAnimatorCompat1);
    paramViewPropertyAnimatorCompat2.setStartDelay(paramViewPropertyAnimatorCompat1.getDuration());
    this.mAnimators.add(paramViewPropertyAnimatorCompat2);
    return this;
  }
  
  public ViewPropertyAnimatorCompatSet setDuration(long paramLong)
  {
    if (!this.mIsStarted) {
      this.mDuration = paramLong;
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompatSet setInterpolator(Interpolator paramInterpolator)
  {
    if (!this.mIsStarted) {
      this.mInterpolator = paramInterpolator;
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompatSet setListener(ViewPropertyAnimatorListener paramViewPropertyAnimatorListener)
  {
    if (!this.mIsStarted) {
      this.mListener = paramViewPropertyAnimatorListener;
    }
    return this;
  }
  
  public void start()
  {
    if (this.mIsStarted) {
      return;
    }
    Iterator localIterator = this.mAnimators.iterator();
    while (localIterator.hasNext())
    {
      ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = (ViewPropertyAnimatorCompat)localIterator.next();
      long l = this.mDuration;
      if (l >= 0L) {
        localViewPropertyAnimatorCompat.setDuration(l);
      }
      Interpolator localInterpolator = this.mInterpolator;
      if (localInterpolator != null) {
        localViewPropertyAnimatorCompat.setInterpolator(localInterpolator);
      }
      if (this.mListener != null) {
        localViewPropertyAnimatorCompat.setListener(this.mProxyListener);
      }
      localViewPropertyAnimatorCompat.start();
    }
    this.mIsStarted = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.view.ViewPropertyAnimatorCompatSet
 * JD-Core Version:    0.7.0.1
 */