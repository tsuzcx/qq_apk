package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.annotation.RestrictTo;

@SuppressLint({"AppCompatCustomView"})
@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class VisibilityAwareImageButton
  extends ImageButton
{
  private int a = getVisibility();
  
  public VisibilityAwareImageButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VisibilityAwareImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VisibilityAwareImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void a(int paramInt, boolean paramBoolean)
  {
    super.setVisibility(paramInt);
    if (paramBoolean) {
      this.a = paramInt;
    }
  }
  
  public final int getUserSetVisibility()
  {
    return this.a;
  }
  
  public void setVisibility(int paramInt)
  {
    a(paramInt, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.internal.VisibilityAwareImageButton
 * JD-Core Version:    0.7.0.1
 */