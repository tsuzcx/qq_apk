package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.dimen;
import com.google.android.material.R.id;
import com.google.android.material.R.styleable;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class SnackbarContentLayout
  extends LinearLayout
  implements ContentViewCallback
{
  private int jdField_a_of_type_Int;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private int b;
  
  public SnackbarContentLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SnackbarContentLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.at);
    this.jdField_a_of_type_Int = paramContext.getDimensionPixelSize(R.styleable.eH, -1);
    this.b = paramContext.getDimensionPixelSize(R.styleable.eO, -1);
    paramContext.recycle();
  }
  
  private static void a(@NonNull View paramView, int paramInt1, int paramInt2)
  {
    if (ViewCompat.isPaddingRelative(paramView))
    {
      ViewCompat.setPaddingRelative(paramView, ViewCompat.getPaddingStart(paramView), paramInt1, ViewCompat.getPaddingEnd(paramView), paramInt2);
      return;
    }
    paramView.setPadding(paramView.getPaddingLeft(), paramInt1, paramView.getPaddingRight(), paramInt2);
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool;
    if (paramInt1 != getOrientation())
    {
      setOrientation(paramInt1);
      bool = true;
    }
    else
    {
      bool = false;
    }
    if ((this.jdField_a_of_type_AndroidWidgetTextView.getPaddingTop() != paramInt2) || (this.jdField_a_of_type_AndroidWidgetTextView.getPaddingBottom() != paramInt3))
    {
      a(this.jdField_a_of_type_AndroidWidgetTextView, paramInt2, paramInt3);
      bool = true;
    }
    return bool;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(0.0F);
    ViewPropertyAnimator localViewPropertyAnimator = this.jdField_a_of_type_AndroidWidgetTextView.animate().alpha(1.0F);
    long l1 = paramInt2;
    localViewPropertyAnimator = localViewPropertyAnimator.setDuration(l1);
    long l2 = paramInt1;
    localViewPropertyAnimator.setStartDelay(l2).start();
    if (this.jdField_a_of_type_AndroidWidgetButton.getVisibility() == 0)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setAlpha(0.0F);
      this.jdField_a_of_type_AndroidWidgetButton.animate().alpha(1.0F).setDuration(l1).setStartDelay(l2).start();
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
    ViewPropertyAnimator localViewPropertyAnimator = this.jdField_a_of_type_AndroidWidgetTextView.animate().alpha(0.0F);
    long l1 = paramInt2;
    localViewPropertyAnimator = localViewPropertyAnimator.setDuration(l1);
    long l2 = paramInt1;
    localViewPropertyAnimator.setStartDelay(l2).start();
    if (this.jdField_a_of_type_AndroidWidgetButton.getVisibility() == 0)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setAlpha(1.0F);
      this.jdField_a_of_type_AndroidWidgetButton.animate().alpha(0.0F).setDuration(l1).setStartDelay(l2).start();
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(R.id.ad));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(R.id.ac));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = paramInt1;
    if (this.jdField_a_of_type_Int > 0)
    {
      j = getMeasuredWidth();
      k = this.jdField_a_of_type_Int;
      i = paramInt1;
      if (j > k)
      {
        i = View.MeasureSpec.makeMeasureSpec(k, 1073741824);
        super.onMeasure(i, paramInt2);
      }
    }
    int k = getResources().getDimensionPixelSize(R.dimen.p);
    int m = getResources().getDimensionPixelSize(R.dimen.o);
    paramInt1 = this.jdField_a_of_type_AndroidWidgetTextView.getLayout().getLineCount();
    int j = 1;
    if (paramInt1 > 1) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if ((paramInt1 != 0) && (this.b > 0) && (this.jdField_a_of_type_AndroidWidgetButton.getMeasuredWidth() > this.b))
    {
      if (a(1, k, k - m))
      {
        paramInt1 = j;
        break label177;
      }
    }
    else
    {
      if (paramInt1 != 0) {
        paramInt1 = k;
      } else {
        paramInt1 = m;
      }
      if (a(0, paramInt1, paramInt1))
      {
        paramInt1 = j;
        break label177;
      }
    }
    paramInt1 = 0;
    label177:
    if (paramInt1 != 0) {
      super.onMeasure(i, paramInt2);
    }
  }
  
  public void setMaxInlineActionWidth(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.snackbar.SnackbarContentLayout
 * JD-Core Version:    0.7.0.1
 */