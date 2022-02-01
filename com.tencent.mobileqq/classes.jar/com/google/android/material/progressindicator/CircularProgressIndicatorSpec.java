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
  public int g;
  @Px
  public int h;
  public int i;
  
  public CircularProgressIndicatorSpec(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.l);
  }
  
  public CircularProgressIndicatorSpec(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, CircularProgressIndicator.d);
  }
  
  public CircularProgressIndicatorSpec(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    int j = paramContext.getResources().getDimensionPixelSize(R.dimen.ah);
    int k = paramContext.getResources().getDimensionPixelSize(R.dimen.ag);
    paramAttributeSet = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.bG, paramInt1, paramInt2, new int[0]);
    this.g = MaterialResources.a(paramContext, paramAttributeSet, R.styleable.bJ, j);
    this.h = MaterialResources.a(paramContext, paramAttributeSet, R.styleable.bI, k);
    this.i = paramAttributeSet.getInt(R.styleable.bH, 0);
    paramAttributeSet.recycle();
    c();
  }
  
  void c()
  {
    if (this.g >= this.a * 2) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("The indicatorSize (");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" px) cannot be less than twice of the trackThickness (");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" px).");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.progressindicator.CircularProgressIndicatorSpec
 * JD-Core Version:    0.7.0.1
 */