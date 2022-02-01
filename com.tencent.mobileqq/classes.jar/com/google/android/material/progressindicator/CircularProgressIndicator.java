package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import com.google.android.material.R.attr;
import com.google.android.material.R.style;

public final class CircularProgressIndicator
  extends BaseProgressIndicator<CircularProgressIndicatorSpec>
{
  public static final int b = R.style.x;
  
  public CircularProgressIndicator(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CircularProgressIndicator(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.i);
  }
  
  public CircularProgressIndicator(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, b);
    a();
  }
  
  private void a()
  {
    setIndeterminateDrawable(IndeterminateDrawable.a(getContext(), (CircularProgressIndicatorSpec)this.a));
    setProgressDrawable(DeterminateDrawable.a(getContext(), (CircularProgressIndicatorSpec)this.a));
  }
  
  CircularProgressIndicatorSpec a(@NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet)
  {
    return new CircularProgressIndicatorSpec(paramContext, paramAttributeSet);
  }
  
  public void setIndicatorDirection(int paramInt)
  {
    ((CircularProgressIndicatorSpec)this.a).h = paramInt;
    invalidate();
  }
  
  public void setIndicatorInset(@Px int paramInt)
  {
    if (((CircularProgressIndicatorSpec)this.a).g != paramInt)
    {
      ((CircularProgressIndicatorSpec)this.a).g = paramInt;
      invalidate();
    }
  }
  
  public void setIndicatorSize(@Px int paramInt)
  {
    if (((CircularProgressIndicatorSpec)this.a).f != paramInt)
    {
      ((CircularProgressIndicatorSpec)this.a).f = paramInt;
      ((CircularProgressIndicatorSpec)this.a).a();
      invalidate();
    }
  }
  
  public void setTrackThickness(int paramInt)
  {
    super.setTrackThickness(paramInt);
    ((CircularProgressIndicatorSpec)this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.progressindicator.CircularProgressIndicator
 * JD-Core Version:    0.7.0.1
 */