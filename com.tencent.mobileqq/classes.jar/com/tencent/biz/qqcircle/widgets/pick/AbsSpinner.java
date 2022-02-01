package com.tencent.biz.qqcircle.widgets.pick;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

public abstract class AbsSpinner
  extends AdapterView<SpinnerAdapter>
{
  private static int G = -2;
  private DataSetObserver H;
  private Rect I;
  SpinnerAdapter a;
  int b;
  int c;
  boolean d;
  int e = 0;
  int f = 0;
  int g = 0;
  int h = 0;
  final Rect i = new Rect();
  final AbsSpinner.RecycleBin j = new AbsSpinner.RecycleBin(this);
  
  public AbsSpinner(Context paramContext)
  {
    super(paramContext);
    k();
  }
  
  public AbsSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AbsSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, true);
  }
  
  public AbsSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet, paramInt);
    k();
    if (paramBoolean)
    {
      if (G == -2) {
        G = a("AbsSpinner_entries");
      }
      paramAttributeSet = new TypedArrayWarpper(paramContext.obtainStyledAttributes(paramAttributeSet, b("AbsSpinner"), paramInt, 0));
      CharSequence[] arrayOfCharSequence = paramAttributeSet.a(G);
      if (arrayOfCharSequence != null)
      {
        paramContext = new ArrayAdapter(paramContext, 17367048, arrayOfCharSequence);
        paramContext.setDropDownViewResource(17367049);
        setAdapter(paramContext);
      }
      paramAttributeSet.a();
    }
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int m = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt2);
    if (m != -2147483648)
    {
      paramInt2 = paramInt1;
      if (m != 0) {
        if (m != 1073741824) {
          paramInt2 = paramInt1;
        } else {
          paramInt2 = k;
        }
      }
    }
    else
    {
      paramInt2 = paramInt1;
      if (k < paramInt1) {
        paramInt2 = 0x1000000 | k;
      }
    }
    return paramInt2 | 0xFF000000 & paramInt3;
  }
  
  private void k()
  {
    setFocusable(true);
    setWillNotDraw(false);
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    Object localObject2 = this.I;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      this.I = new Rect();
      localObject1 = this.I;
    }
    int k = getChildCount() - 1;
    while (k >= 0)
    {
      localObject2 = getChildAt(k);
      if (((View)localObject2).getVisibility() == 0)
      {
        ((View)localObject2).getHitRect((Rect)localObject1);
        if (((Rect)localObject1).contains(paramInt1, paramInt2)) {
          return this.k + k;
        }
      }
      k -= 1;
    }
    return -1;
  }
  
  int a(View paramView)
  {
    return paramView.getMeasuredHeight();
  }
  
  protected AdapterView.AdapterDataSetObserver a()
  {
    return new AdapterView.AdapterDataSetObserver(this);
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt != this.D)
    {
      this.d = true;
      int k = this.z;
      setNextSelectedPositionInt(paramInt);
      b(paramInt - k, paramBoolean);
      this.d = false;
    }
  }
  
  int b(View paramView)
  {
    return paramView.getMeasuredWidth();
  }
  
  void b()
  {
    this.w = false;
    this.p = false;
    removeAllViewsInLayout();
    this.D = -1;
    this.E = -9223372036854775808L;
    setSelectedPositionInt(-1);
    setNextSelectedPositionInt(-1);
    invalidate();
  }
  
  abstract void b(int paramInt, boolean paramBoolean);
  
  void c()
  {
    int m = getChildCount();
    AbsSpinner.RecycleBin localRecycleBin = this.j;
    int n = this.k;
    int k = 0;
    while (k < m)
    {
      localRecycleBin.a(n + k, getChildAt(k));
      k += 1;
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.LayoutParams(-1, -2);
  }
  
  public SpinnerAdapter getAdapter()
  {
    return this.a;
  }
  
  public int getCount()
  {
    return this.B;
  }
  
  public View getSelectedView()
  {
    if ((this.B > 0) && (this.z >= 0)) {
      return getChildAt(this.z - this.k);
    }
    return null;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i2 = View.MeasureSpec.getMode(paramInt1);
    this.i.left = Math.max(getPaddingLeft(), this.e);
    this.i.top = Math.max(getPaddingTop(), this.f);
    this.i.right = Math.max(getPaddingRight(), this.g);
    this.i.bottom = Math.max(getPaddingBottom(), this.h);
    if (this.w) {
      g();
    }
    int k = getSelectedItemPosition();
    int n = 1;
    if (k >= 0)
    {
      Object localObject = this.a;
      if ((localObject != null) && (k < ((SpinnerAdapter)localObject).getCount()))
      {
        View localView = this.j.a(k);
        localObject = localView;
        if (localView == null) {
          localObject = this.a.getView(k, null, this);
        }
        if (localObject != null) {
          this.j.a(k, (View)localObject);
        }
        if (localObject != null)
        {
          if (((View)localObject).getLayoutParams() == null)
          {
            this.d = true;
            ((View)localObject).setLayoutParams(generateDefaultLayoutParams());
            this.d = false;
          }
          measureChild((View)localObject, paramInt1, paramInt2);
          m = a((View)localObject) + this.i.top + this.i.bottom;
          k = b((View)localObject) + this.i.left + this.i.right;
          n = 0;
          break label269;
        }
      }
    }
    int m = 0;
    k = 0;
    label269:
    int i1 = m;
    m = k;
    if (n != 0)
    {
      n = this.i.top + this.i.bottom;
      i1 = n;
      m = k;
      if (i2 == 0)
      {
        m = this.i.left + this.i.right;
        i1 = n;
      }
    }
    k = Math.max(i1, getSuggestedMinimumHeight());
    m = Math.max(m, getSuggestedMinimumWidth());
    k = a(k, paramInt2, 0);
    setMeasuredDimension(a(m, paramInt1, 0), k);
    this.b = paramInt2;
    this.c = paramInt1;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (AbsSpinner.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (paramParcelable.a >= 0L)
    {
      this.w = true;
      this.p = true;
      this.n = paramParcelable.a;
      this.m = paramParcelable.b;
      this.q = 0;
      requestLayout();
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    AbsSpinner.SavedState localSavedState = new AbsSpinner.SavedState(super.onSaveInstanceState());
    localSavedState.a = getSelectedItemId();
    if (localSavedState.a >= 0L)
    {
      localSavedState.b = getSelectedItemPosition();
      return localSavedState;
    }
    localSavedState.b = -1;
    return localSavedState;
  }
  
  public void requestLayout()
  {
    if (!this.d) {
      super.requestLayout();
    }
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    SpinnerAdapter localSpinnerAdapter = this.a;
    if (localSpinnerAdapter != null)
    {
      localSpinnerAdapter.unregisterDataSetObserver(this.H);
      b();
    }
    this.a = paramSpinnerAdapter;
    int k = -1;
    this.D = -1;
    this.E = -9223372036854775808L;
    if (this.a != null)
    {
      this.C = this.B;
      this.B = this.a.getCount();
      e();
      this.H = a();
      this.a.registerDataSetObserver(this.H);
      if (this.B > 0) {
        k = 0;
      }
      setSelectedPositionInt(k);
      setNextSelectedPositionInt(k);
      if (this.B == 0) {
        h();
      }
    }
    else
    {
      e();
      b();
      h();
    }
    requestLayout();
  }
  
  public void setSelection(int paramInt)
  {
    setNextSelectedPositionInt(paramInt);
    requestLayout();
    invalidate();
  }
  
  public void setSelection(int paramInt, boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramBoolean) && (this.k <= paramInt) && (paramInt <= this.k + getChildCount() - 1)) {
      paramBoolean = bool;
    } else {
      paramBoolean = false;
    }
    a(paramInt, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.pick.AbsSpinner
 * JD-Core Version:    0.7.0.1
 */