package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;

public final class CircularProgressIndicatorSpec
  extends BaseProgressIndicatorSpec
{
  @Px
  public int f;
  @Px
  public int g;
  public int h;
  
  public CircularProgressIndicatorSpec(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.i);
  }
  
  public CircularProgressIndicatorSpec(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, CircularProgressIndicator.b);
  }
  
  public CircularProgressIndicatorSpec(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    int i = paramContext.getResources().getDimensionPixelSize(R.dimen.ah);
    int j = paramContext.getResources().getDimensionPixelSize(R.dimen.ag);
    paramAttributeSet = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.l, paramInt1, paramInt2, new int[0]);
    this.f = MaterialResources.a(paramContext, paramAttributeSet, R.styleable.ba, i);
    this.g = MaterialResources.a(paramContext, paramAttributeSet, R.styleable.aZ, j);
    this.h = paramAttributeSet.getInt(R.styleable.aY, 0);
    paramAttributeSet.recycle();
    a();
  }
  
  void a()
  {
    if (this.f >= this.a * 2) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("The indicatorSize (");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" px) cannot be less than twice of the trackThickness (");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" px).");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.progressindicator.CircularProgressIndicatorSpec
 * JD-Core Version:    0.7.0.1
 */