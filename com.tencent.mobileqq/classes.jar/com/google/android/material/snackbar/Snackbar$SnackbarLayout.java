package com.google.android.material.snackbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public final class Snackbar$SnackbarLayout
  extends BaseTransientBottomBar.SnackbarBaseLayout
{
  public Snackbar$SnackbarLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public Snackbar$SnackbarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt2 = getChildCount();
    int i = getMeasuredWidth();
    int j = getPaddingLeft();
    int k = getPaddingRight();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (localView.getLayoutParams().width == -1) {
        localView.measure(View.MeasureSpec.makeMeasureSpec(i - j - k, 1073741824), View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), 1073741824));
      }
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.snackbar.Snackbar.SnackbarLayout
 * JD-Core Version:    0.7.0.1
 */