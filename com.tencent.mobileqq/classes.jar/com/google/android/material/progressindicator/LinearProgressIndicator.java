package com.google.android.material.progressindicator;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.style;

public final class LinearProgressIndicator
  extends BaseProgressIndicator<LinearProgressIndicatorSpec>
{
  public static final int d = R.style.E;
  
  public LinearProgressIndicator(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LinearProgressIndicator(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.A);
  }
  
  public LinearProgressIndicator(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, d);
    c();
  }
  
  private void c()
  {
    setIndeterminateDrawable(IndeterminateDrawable.a(getContext(), (LinearProgressIndicatorSpec)this.b));
    setProgressDrawable(DeterminateDrawable.a(getContext(), (LinearProgressIndicatorSpec)this.b));
  }
  
  LinearProgressIndicatorSpec b(@NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet)
  {
    return new LinearProgressIndicatorSpec(paramContext, paramAttributeSet);
  }
  
  public int getIndeterminateAnimationType()
  {
    return ((LinearProgressIndicatorSpec)this.b).g;
  }
  
  public int getIndicatorDirection()
  {
    return ((LinearProgressIndicatorSpec)this.b).h;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    LinearProgressIndicatorSpec localLinearProgressIndicatorSpec = (LinearProgressIndicatorSpec)this.b;
    paramInt1 = ((LinearProgressIndicatorSpec)this.b).h;
    boolean bool = true;
    paramBoolean = bool;
    if (paramInt1 != 1) {
      if (ViewCompat.getLayoutDirection(this) == 1)
      {
        paramBoolean = bool;
        if (((LinearProgressIndicatorSpec)this.b).h == 2) {}
      }
      else if ((ViewCompat.getLayoutDirection(this) == 0) && (((LinearProgressIndicatorSpec)this.b).h == 3))
      {
        paramBoolean = bool;
      }
      else
      {
        paramBoolean = false;
      }
    }
    localLinearProgressIndicatorSpec.i = paramBoolean;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 -= getPaddingLeft() + getPaddingRight();
    paramInt2 -= getPaddingTop() + getPaddingBottom();
    Object localObject = getIndeterminateDrawable();
    if (localObject != null) {
      ((Drawable)localObject).setBounds(0, 0, paramInt1, paramInt2);
    }
    localObject = getProgressDrawable();
    if (localObject != null) {
      ((Drawable)localObject).setBounds(0, 0, paramInt1, paramInt2);
    }
  }
  
  public void setIndeterminateAnimationType(int paramInt)
  {
    if (((LinearProgressIndicatorSpec)this.b).g == paramInt) {
      return;
    }
    if ((a()) && (isIndeterminate())) {
      throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
    }
    ((LinearProgressIndicatorSpec)this.b).g = paramInt;
    ((LinearProgressIndicatorSpec)this.b).c();
    if (paramInt == 0) {
      getIndeterminateDrawable().a(new LinearIndeterminateContiguousAnimatorDelegate((LinearProgressIndicatorSpec)this.b));
    } else {
      getIndeterminateDrawable().a(new LinearIndeterminateDisjointAnimatorDelegate(getContext(), (LinearProgressIndicatorSpec)this.b));
    }
    invalidate();
  }
  
  public void setIndicatorColor(@NonNull int... paramVarArgs)
  {
    super.setIndicatorColor(paramVarArgs);
    ((LinearProgressIndicatorSpec)this.b).c();
  }
  
  public void setIndicatorDirection(int paramInt)
  {
    ((LinearProgressIndicatorSpec)this.b).h = paramInt;
    LinearProgressIndicatorSpec localLinearProgressIndicatorSpec = (LinearProgressIndicatorSpec)this.b;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 1) {
      if (ViewCompat.getLayoutDirection(this) == 1)
      {
        bool1 = bool2;
        if (((LinearProgressIndicatorSpec)this.b).h == 2) {}
      }
      else if ((ViewCompat.getLayoutDirection(this) == 0) && (paramInt == 3))
      {
        bool1 = bool2;
      }
      else
      {
        bool1 = false;
      }
    }
    localLinearProgressIndicatorSpec.i = bool1;
    invalidate();
  }
  
  public void setProgressCompat(int paramInt, boolean paramBoolean)
  {
    if ((this.b != null) && (((LinearProgressIndicatorSpec)this.b).g == 0) && (isIndeterminate())) {
      return;
    }
    super.setProgressCompat(paramInt, paramBoolean);
  }
  
  public void setTrackCornerRadius(int paramInt)
  {
    super.setTrackCornerRadius(paramInt);
    ((LinearProgressIndicatorSpec)this.b).c();
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.progressindicator.LinearProgressIndicator
 * JD-Core Version:    0.7.0.1
 */