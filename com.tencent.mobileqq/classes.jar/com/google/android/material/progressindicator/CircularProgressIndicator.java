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
  public static final int d = R.style.z;
  
  public CircularProgressIndicator(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CircularProgressIndicator(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.l);
  }
  
  public CircularProgressIndicator(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, d);
    c();
  }
  
  private void c()
  {
    setIndeterminateDrawable(IndeterminateDrawable.a(getContext(), (CircularProgressIndicatorSpec)this.b));
    setProgressDrawable(DeterminateDrawable.a(getContext(), (CircularProgressIndicatorSpec)this.b));
  }
  
  CircularProgressIndicatorSpec b(@NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet)
  {
    return new CircularProgressIndicatorSpec(paramContext, paramAttributeSet);
  }
  
  public int getIndicatorDirection()
  {
    return ((CircularProgressIndicatorSpec)this.b).i;
  }
  
  @Px
  public int getIndicatorInset()
  {
    return ((CircularProgressIndicatorSpec)this.b).h;
  }
  
  @Px
  public int getIndicatorSize()
  {
    return ((CircularProgressIndicatorSpec)this.b).g;
  }
  
  public void setIndicatorDirection(int paramInt)
  {
    ((CircularProgressIndicatorSpec)this.b).i = paramInt;
    invalidate();
  }
  
  public void setIndicatorInset(@Px int paramInt)
  {
    if (((CircularProgressIndicatorSpec)this.b).h != paramInt)
    {
      ((CircularProgressIndicatorSpec)this.b).h = paramInt;
      invalidate();
    }
  }
  
  public void setIndicatorSize(@Px int paramInt)
  {
    if (((CircularProgressIndicatorSpec)this.b).g != paramInt)
    {
      ((CircularProgressIndicatorSpec)this.b).g = paramInt;
      ((CircularProgressIndicatorSpec)this.b).c();
      invalidate();
    }
  }
  
  public void setTrackThickness(int paramInt)
  {
    super.setTrackThickness(paramInt);
    ((CircularProgressIndicatorSpec)this.b).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.progressindicator.CircularProgressIndicator
 * JD-Core Version:    0.7.0.1
 */