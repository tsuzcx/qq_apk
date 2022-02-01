package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;

public abstract class VirtualLayout
  extends ConstraintHelper
{
  private boolean mApplyElevationOnAttach;
  private boolean mApplyVisibilityOnAttach;
  
  public VirtualLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public VirtualLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VirtualLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void init(AttributeSet paramAttributeSet)
  {
    super.init(paramAttributeSet);
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int j = paramAttributeSet.getIndexCount();
      int i = 0;
      while (i < j)
      {
        int k = paramAttributeSet.getIndex(i);
        if (k == R.styleable.ConstraintLayout_Layout_android_visibility) {
          this.mApplyVisibilityOnAttach = true;
        } else if (k == R.styleable.ConstraintLayout_Layout_android_elevation) {
          this.mApplyElevationOnAttach = true;
        }
        i += 1;
      }
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.mApplyVisibilityOnAttach) || (this.mApplyElevationOnAttach))
    {
      Object localObject = getParent();
      if ((localObject != null) && ((localObject instanceof ConstraintLayout)))
      {
        localObject = (ConstraintLayout)localObject;
        int j = getVisibility();
        float f;
        if (Build.VERSION.SDK_INT >= 21) {
          f = getElevation();
        } else {
          f = 0.0F;
        }
        int i = 0;
        while (i < this.mCount)
        {
          View localView = ((ConstraintLayout)localObject).getViewById(this.mIds[i]);
          if (localView != null)
          {
            if (this.mApplyVisibilityOnAttach) {
              localView.setVisibility(j);
            }
            if ((this.mApplyElevationOnAttach) && (f > 0.0F) && (Build.VERSION.SDK_INT >= 21)) {
              localView.setTranslationZ(localView.getTranslationZ() + f);
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public void onMeasure(androidx.constraintlayout.solver.widgets.VirtualLayout paramVirtualLayout, int paramInt1, int paramInt2) {}
  
  public void setElevation(float paramFloat)
  {
    super.setElevation(paramFloat);
    applyLayoutFeatures();
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    applyLayoutFeatures();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.widget.VirtualLayout
 * JD-Core Version:    0.7.0.1
 */