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
  private TextView a;
  private Button b;
  private int c;
  private int d;
  
  public SnackbarContentLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SnackbarContentLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.gP);
    this.c = paramContext.getDimensionPixelSize(R.styleable.gQ, -1);
    this.d = paramContext.getDimensionPixelSize(R.styleable.gX, -1);
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
    if ((this.a.getPaddingTop() != paramInt2) || (this.a.getPaddingBottom() != paramInt3))
    {
      a(this.a, paramInt2, paramInt3);
      bool = true;
    }
    return bool;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a.setAlpha(0.0F);
    ViewPropertyAnimator localViewPropertyAnimator = this.a.animate().alpha(1.0F);
    long l1 = paramInt2;
    localViewPropertyAnimator = localViewPropertyAnimator.setDuration(l1);
    long l2 = paramInt1;
    localViewPropertyAnimator.setStartDelay(l2).start();
    if (this.b.getVisibility() == 0)
    {
      this.b.setAlpha(0.0F);
      this.b.animate().alpha(1.0F).setDuration(l1).setStartDelay(l2).start();
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.a.setAlpha(1.0F);
    ViewPropertyAnimator localViewPropertyAnimator = this.a.animate().alpha(0.0F);
    long l1 = paramInt2;
    localViewPropertyAnimator = localViewPropertyAnimator.setDuration(l1);
    long l2 = paramInt1;
    localViewPropertyAnimator.setStartDelay(l2).start();
    if (this.b.getVisibility() == 0)
    {
      this.b.setAlpha(1.0F);
      this.b.animate().alpha(0.0F).setDuration(l1).setStartDelay(l2).start();
    }
  }
  
  public Button getActionView()
  {
    return this.b;
  }
  
  public TextView getMessageView()
  {
    return this.a;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((TextView)findViewById(R.id.ad));
    this.b = ((Button)findViewById(R.id.ac));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = paramInt1;
    if (this.c > 0)
    {
      j = getMeasuredWidth();
      k = this.c;
      i = paramInt1;
      if (j > k)
      {
        i = View.MeasureSpec.makeMeasureSpec(k, 1073741824);
        super.onMeasure(i, paramInt2);
      }
    }
    int k = getResources().getDimensionPixelSize(R.dimen.p);
    int m = getResources().getDimensionPixelSize(R.dimen.o);
    paramInt1 = this.a.getLayout().getLineCount();
    int j = 1;
    if (paramInt1 > 1) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if ((paramInt1 != 0) && (this.d > 0) && (this.b.getMeasuredWidth() > this.d))
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
    this.d = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.snackbar.SnackbarContentLayout
 * JD-Core Version:    0.7.0.1
 */