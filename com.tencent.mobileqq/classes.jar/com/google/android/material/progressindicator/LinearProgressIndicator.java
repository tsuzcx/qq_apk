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
  public static final int b = R.style.C;
  
  public LinearProgressIndicator(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LinearProgressIndicator(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.t);
  }
  
  public LinearProgressIndicator(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, b);
    a();
  }
  
  private void a()
  {
    setIndeterminateDrawable(IndeterminateDrawable.a(getContext(), (LinearProgressIndicatorSpec)this.a));
    setProgressDrawable(DeterminateDrawable.a(getContext(), (LinearProgressIndicatorSpec)this.a));
  }
  
  LinearProgressIndicatorSpec a(@NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet)
  {
    return new LinearProgressIndicatorSpec(paramContext, paramAttributeSet);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    LinearProgressIndicatorSpec localLinearProgressIndicatorSpec = (LinearProgressIndicatorSpec)this.a;
    paramInt1 = ((LinearProgressIndicatorSpec)this.a).g;
    boolean bool = true;
    paramBoolean = bool;
    if (paramInt1 != 1) {
      if (ViewCompat.getLayoutDirection(this) == 1)
      {
        paramBoolean = bool;
        if (((LinearProgressIndicatorSpec)this.a).g == 2) {}
      }
      else if ((ViewCompat.getLayoutDirection(this) == 0) && (((LinearProgressIndicatorSpec)this.a).g == 3))
      {
        paramBoolean = bool;
      }
      else
      {
        paramBoolean = false;
      }
    }
    localLinearProgressIndicatorSpec.a = paramBoolean;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 -= getPaddingLeft() + getPaddingRight();
    paramInt2 -= getPaddingTop() + getPaddingBottom();
    Object localObject = a();
    if (localObject != null) {
      ((Drawable)localObject).setBounds(0, 0, paramInt1, paramInt2);
    }
    localObject = a();
    if (localObject != null) {
      ((Drawable)localObject).setBounds(0, 0, paramInt1, paramInt2);
    }
  }
  
  public void setIndeterminateAnimationType(int paramInt)
  {
    if (((LinearProgressIndicatorSpec)this.a).f == paramInt) {
      return;
    }
    if ((a()) && (isIndeterminate())) {
      throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
    }
    ((LinearProgressIndicatorSpec)this.a).f = paramInt;
    ((LinearProgressIndicatorSpec)this.a).a();
    if (paramInt == 0) {
      a().a(new LinearIndeterminateContiguousAnimatorDelegate((LinearProgressIndicatorSpec)this.a));
    } else {
      a().a(new LinearIndeterminateDisjointAnimatorDelegate(getContext(), (LinearProgressIndicatorSpec)this.a));
    }
    invalidate();
  }
  
  public void setIndicatorColor(@NonNull int... paramVarArgs)
  {
    super.setIndicatorColor(paramVarArgs);
    ((LinearProgressIndicatorSpec)this.a).a();
  }
  
  public void setIndicatorDirection(int paramInt)
  {
    ((LinearProgressIndicatorSpec)this.a).g = paramInt;
    LinearProgressIndicatorSpec localLinearProgressIndicatorSpec = (LinearProgressIndicatorSpec)this.a;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 1) {
      if (ViewCompat.getLayoutDirection(this) == 1)
      {
        bool1 = bool2;
        if (((LinearProgressIndicatorSpec)this.a).g == 2) {}
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
    localLinearProgressIndicatorSpec.a = bool1;
    invalidate();
  }
  
  public void setProgressCompat(int paramInt, boolean paramBoolean)
  {
    if ((this.a != null) && (((LinearProgressIndicatorSpec)this.a).f == 0) && (isIndeterminate())) {
      return;
    }
    super.setProgressCompat(paramInt, paramBoolean);
  }
  
  public void setTrackCornerRadius(int paramInt)
  {
    super.setTrackCornerRadius(paramInt);
    ((LinearProgressIndicatorSpec)this.a).a();
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.progressindicator.LinearProgressIndicator
 * JD-Core Version:    0.7.0.1
 */