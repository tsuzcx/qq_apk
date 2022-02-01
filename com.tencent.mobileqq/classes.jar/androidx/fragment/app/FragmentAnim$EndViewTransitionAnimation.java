package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import androidx.annotation.NonNull;
import androidx.core.view.OneShotPreDrawListener;

class FragmentAnim$EndViewTransitionAnimation
  extends AnimationSet
  implements Runnable
{
  private boolean mAnimating = true;
  private final View mChild;
  private boolean mEnded;
  private final ViewGroup mParent;
  private boolean mTransitionEnded;
  
  FragmentAnim$EndViewTransitionAnimation(@NonNull Animation paramAnimation, @NonNull ViewGroup paramViewGroup, @NonNull View paramView)
  {
    super(false);
    this.mParent = paramViewGroup;
    this.mChild = paramView;
    addAnimation(paramAnimation);
    this.mParent.post(this);
  }
  
  public boolean getTransformation(long paramLong, @NonNull Transformation paramTransformation)
  {
    this.mAnimating = true;
    if (this.mEnded) {
      return this.mTransitionEnded ^ true;
    }
    if (!super.getTransformation(paramLong, paramTransformation))
    {
      this.mEnded = true;
      OneShotPreDrawListener.add(this.mParent, this);
    }
    return true;
  }
  
  public boolean getTransformation(long paramLong, @NonNull Transformation paramTransformation, float paramFloat)
  {
    this.mAnimating = true;
    if (this.mEnded) {
      return this.mTransitionEnded ^ true;
    }
    if (!super.getTransformation(paramLong, paramTransformation, paramFloat))
    {
      this.mEnded = true;
      OneShotPreDrawListener.add(this.mParent, this);
    }
    return true;
  }
  
  public void run()
  {
    if ((!this.mEnded) && (this.mAnimating))
    {
      this.mAnimating = false;
      this.mParent.post(this);
      return;
    }
    this.mParent.endViewTransition(this.mChild);
    this.mTransitionEnded = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.fragment.app.FragmentAnim.EndViewTransitionAnimation
 * JD-Core Version:    0.7.0.1
 */