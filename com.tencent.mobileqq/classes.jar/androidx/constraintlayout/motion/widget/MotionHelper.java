package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R.styleable;

public class MotionHelper
  extends ConstraintHelper
  implements Animatable, MotionLayout.TransitionListener
{
  private float mProgress;
  private boolean mUseOnHide = false;
  private boolean mUseOnShow = false;
  protected View[] views;
  
  public MotionHelper(Context paramContext)
  {
    super(paramContext);
  }
  
  public MotionHelper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramAttributeSet);
  }
  
  public MotionHelper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramAttributeSet);
  }
  
  public float getProgress()
  {
    return this.mProgress;
  }
  
  protected void init(AttributeSet paramAttributeSet)
  {
    super.init(paramAttributeSet);
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.MotionHelper);
      int j = paramAttributeSet.getIndexCount();
      int i = 0;
      while (i < j)
      {
        int k = paramAttributeSet.getIndex(i);
        if (k == R.styleable.MotionHelper_onShow) {
          this.mUseOnShow = paramAttributeSet.getBoolean(k, this.mUseOnShow);
        } else if (k == R.styleable.MotionHelper_onHide) {
          this.mUseOnHide = paramAttributeSet.getBoolean(k, this.mUseOnHide);
        }
        i += 1;
      }
    }
  }
  
  public boolean isUseOnHide()
  {
    return this.mUseOnHide;
  }
  
  public boolean isUsedOnShow()
  {
    return this.mUseOnShow;
  }
  
  public void onTransitionChange(MotionLayout paramMotionLayout, int paramInt1, int paramInt2, float paramFloat) {}
  
  public void onTransitionCompleted(MotionLayout paramMotionLayout, int paramInt) {}
  
  public void onTransitionStarted(MotionLayout paramMotionLayout, int paramInt1, int paramInt2) {}
  
  public void onTransitionTrigger(MotionLayout paramMotionLayout, int paramInt, boolean paramBoolean, float paramFloat) {}
  
  public void setProgress(float paramFloat)
  {
    this.mProgress = paramFloat;
    int k = this.mCount;
    int i = 0;
    int j = 0;
    if (k > 0)
    {
      this.views = getViews((ConstraintLayout)getParent());
      i = j;
      while (i < this.mCount)
      {
        setProgress(this.views[i], paramFloat);
        i += 1;
      }
    }
    ViewGroup localViewGroup = (ViewGroup)getParent();
    j = localViewGroup.getChildCount();
    while (i < j)
    {
      View localView = localViewGroup.getChildAt(i);
      if (!(localView instanceof MotionHelper)) {
        setProgress(localView, paramFloat);
      }
      i += 1;
    }
  }
  
  public void setProgress(View paramView, float paramFloat) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.MotionHelper
 * JD-Core Version:    0.7.0.1
 */