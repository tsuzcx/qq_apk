package com.tencent.biz.qqcircle.widgets.pick;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewDebug.CapturedViewProperty;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Adapter;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public abstract class AdapterView<T extends Adapter>
  extends ViewGroup
{
  long A = -9223372036854775808L;
  @ViewDebug.ExportedProperty(category="list")
  protected int B;
  int C;
  protected int D = -1;
  long E = -9223372036854775808L;
  boolean F = false;
  private View a;
  private boolean b;
  private boolean c;
  private AdapterView<T>.SelectionNotifier d;
  private float e;
  @ViewDebug.ExportedProperty(category="scrolling")
  public int k = 0;
  int l;
  int m;
  long n = -9223372036854775808L;
  long o;
  boolean p = false;
  int q;
  int r;
  boolean s = false;
  AdapterView.OnItemSelectedListener t;
  AdapterView.OnItemClickListener u;
  AdapterView.OnItemLongClickListener v;
  boolean w;
  @ViewDebug.ExportedProperty(category="list")
  int x = -1;
  long y = -9223372036854775808L;
  @ViewDebug.ExportedProperty(category="list")
  protected int z = -1;
  
  public AdapterView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AdapterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AdapterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected static int a(String paramString)
  {
    try
    {
      int i = Class.forName("com.android.internal.R$styleable").getField(paramString).getInt(null);
      return i;
    }
    catch (Exception paramString)
    {
      label16:
      break label16;
    }
    return -1;
  }
  
  private void a()
  {
    if (this.t == null) {
      return;
    }
    int i = getSelectedItemPosition();
    if (i >= 0)
    {
      View localView = getSelectedView();
      this.t.a(this, localView, i, getAdapter().getItemId(i));
      return;
    }
    this.t.a(this);
  }
  
  private void a(boolean paramBoolean)
  {
    if (d()) {
      paramBoolean = false;
    }
    View localView;
    if (paramBoolean)
    {
      localView = this.a;
      if (localView != null)
      {
        localView.setVisibility(0);
        setVisibility(8);
      }
      else
      {
        setVisibility(0);
      }
      if (this.w) {
        onLayout(false, getLeft(), getTop(), getRight(), getBottom());
      }
    }
    else
    {
      localView = this.a;
      if (localView != null) {
        localView.setVisibility(8);
      }
      setVisibility(0);
    }
  }
  
  private boolean b()
  {
    Adapter localAdapter = getAdapter();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localAdapter != null)
    {
      int i = localAdapter.getCount();
      bool1 = bool2;
      if (i > 0) {
        if (getFirstVisiblePosition() <= 0)
        {
          bool1 = bool2;
          if (getLastVisiblePosition() >= i - 1) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected static int[] b(String paramString)
  {
    try
    {
      paramString = (int[])Class.forName("com.android.internal.R$styleable").getField(paramString).get(null);
      return paramString;
    }
    catch (Exception paramString)
    {
      label22:
      break label22;
    }
    return new int[0];
  }
  
  public long a(int paramInt)
  {
    Adapter localAdapter = getAdapter();
    if ((localAdapter != null) && (paramInt >= 0)) {
      return localAdapter.getItemId(paramInt);
    }
    return -9223372036854775808L;
  }
  
  public boolean a(View paramView, int paramInt, long paramLong)
  {
    if (this.u != null)
    {
      playSoundEffect(0);
      if (paramView != null) {
        paramView.sendAccessibilityEvent(1);
      }
      this.u.a(this, paramView, paramInt, paramLong);
      return true;
    }
    return false;
  }
  
  public void addView(View paramView)
  {
    throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
  }
  
  public void addView(View paramView, int paramInt)
  {
    throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
  }
  
  int c(int paramInt, boolean paramBoolean)
  {
    return paramInt;
  }
  
  public int c(View paramView)
  {
    try
    {
      for (;;)
      {
        View localView = (View)paramView.getParent();
        boolean bool = localView.equals(this);
        if (bool) {
          break;
        }
        paramView = localView;
      }
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        if (getChildAt(i).equals(paramView)) {
          return this.k + i;
        }
        i += 1;
      }
      return -1;
    }
    catch (ClassCastException|NullPointerException paramView) {}
    return -1;
  }
  
  protected boolean canAnimate()
  {
    return (super.canAnimate()) && (this.B > 0);
  }
  
  boolean d()
  {
    return false;
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    View localView = getSelectedView();
    return (localView != null) && (localView.getVisibility() == 0) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent));
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchThawSelfOnly(paramSparseArray);
  }
  
  protected void dispatchSaveInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchFreezeSelfOnly(paramSparseArray);
  }
  
  void e()
  {
    Adapter localAdapter = getAdapter();
    boolean bool2 = false;
    int i;
    if ((localAdapter != null) && (localAdapter.getCount() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if ((i != 0) && (!d())) {
      i = 0;
    } else {
      i = 1;
    }
    boolean bool1;
    if ((i != 0) && (this.c)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    super.setFocusableInTouchMode(bool1);
    if ((i != 0) && (this.b)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    super.setFocusable(bool1);
    if (this.a != null)
    {
      if (localAdapter != null)
      {
        bool1 = bool2;
        if (!localAdapter.isEmpty()) {}
      }
      else
      {
        bool1 = true;
      }
      a(bool1);
    }
  }
  
  void f()
  {
    if (this.t != null) {
      if ((!this.s) && (!this.F))
      {
        a();
      }
      else
      {
        if (this.d == null) {
          this.d = new AdapterView.SelectionNotifier(this, null);
        }
        post(this.d);
      }
    }
    if ((this.z != -1) && (isShown()) && (!isInTouchMode())) {
      sendAccessibilityEvent(4);
    }
  }
  
  void g()
  {
    int i1 = this.B;
    int i2 = 1;
    int i;
    if (i1 > 0)
    {
      if (this.p)
      {
        this.p = false;
        i = i();
        if ((i >= 0) && (c(i, true) == i))
        {
          setNextSelectedPositionInt(i);
          i = 1;
          break label55;
        }
      }
      i = 0;
      label55:
      if (i == 0)
      {
        int j = getSelectedItemPosition();
        if (j >= i1) {
          j = i1 - 1;
        }
        i1 = j;
        if (j < 0) {
          i1 = 0;
        }
        int i3 = c(i1, true);
        j = i3;
        if (i3 < 0) {
          j = c(i1, false);
        }
        if (j >= 0)
        {
          setNextSelectedPositionInt(j);
          h();
          i = i2;
          break label131;
        }
      }
    }
    else
    {
      i = 0;
    }
    label131:
    if (i == 0)
    {
      this.z = -1;
      this.A = -9223372036854775808L;
      this.x = -1;
      this.y = -9223372036854775808L;
      this.p = false;
      h();
    }
  }
  
  public abstract T getAdapter();
  
  @ViewDebug.CapturedViewProperty
  public int getCount()
  {
    return this.B;
  }
  
  public View getEmptyView()
  {
    return this.a;
  }
  
  public int getFirstVisiblePosition()
  {
    return this.k;
  }
  
  public int getLastVisiblePosition()
  {
    return this.k + getChildCount() - 1;
  }
  
  public final AdapterView.OnItemClickListener getOnItemClickListener()
  {
    return this.u;
  }
  
  public final AdapterView.OnItemLongClickListener getOnItemLongClickListener()
  {
    return this.v;
  }
  
  public final AdapterView.OnItemSelectedListener getOnItemSelectedListener()
  {
    return this.t;
  }
  
  public Object getSelectedItem()
  {
    Adapter localAdapter = getAdapter();
    int i = getSelectedItemPosition();
    if ((localAdapter != null) && (localAdapter.getCount() > 0) && (i >= 0)) {
      return localAdapter.getItem(i);
    }
    return null;
  }
  
  @ViewDebug.CapturedViewProperty
  public long getSelectedItemId()
  {
    return this.y;
  }
  
  @ViewDebug.CapturedViewProperty
  public int getSelectedItemPosition()
  {
    return this.x;
  }
  
  public abstract View getSelectedView();
  
  protected float getVerticalScrollFactor()
  {
    if (this.e == 0.0F)
    {
      TypedValue localTypedValue = new TypedValue();
      if (getContext().getTheme().resolveAttribute(16842829, localTypedValue, true)) {
        this.e = localTypedValue.getDimension(getContext().getResources().getDisplayMetrics());
      } else {
        throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
      }
    }
    return this.e;
  }
  
  void h()
  {
    if ((this.z != this.D) || (this.A != this.E))
    {
      f();
      this.D = this.z;
      this.E = this.A;
    }
  }
  
  int i()
  {
    int i = this.B;
    if (i == 0) {
      return -1;
    }
    long l1 = this.n;
    int j = this.m;
    if (l1 == -9223372036854775808L) {
      return -1;
    }
    j = Math.max(0, j);
    int i5 = i - 1;
    int i2 = Math.min(i5, j);
    long l2 = SystemClock.uptimeMillis();
    Adapter localAdapter = getAdapter();
    if (localAdapter == null) {
      return -1;
    }
    i = i2;
    int i1 = i;
    j = i;
    for (i = i2;; i = j)
    {
      for (i2 = 0;; i2 = 1)
      {
        int i3;
        int i4;
        do
        {
          if (SystemClock.uptimeMillis() > l2 + 100L) {
            break label206;
          }
          if (localAdapter.getItemId(i) == l1) {
            return i;
          }
          if (j == i5) {
            i3 = 1;
          } else {
            i3 = 0;
          }
          if (i1 == 0) {
            i4 = 1;
          } else {
            i4 = 0;
          }
          if ((i3 != 0) && (i4 != 0)) {
            return -1;
          }
          if ((i4 != 0) || ((i2 != 0) && (i3 == 0))) {
            break;
          }
        } while ((i3 == 0) && ((i2 != 0) || (i4 != 0)));
        i1 -= 1;
        i = i1;
      }
      j += 1;
    }
    label206:
    return -1;
  }
  
  void j()
  {
    if (getChildCount() > 0)
    {
      this.p = true;
      this.o = this.r;
      int i = this.z;
      if (i >= 0)
      {
        localView = getChildAt(i - this.k);
        this.n = this.y;
        this.m = this.x;
        if (localView != null) {
          this.l = localView.getTop();
        }
        this.q = 0;
        return;
      }
      View localView = getChildAt(0);
      Adapter localAdapter = getAdapter();
      i = this.k;
      if ((i >= 0) && (i < localAdapter.getCount())) {
        this.n = localAdapter.getItemId(this.k);
      } else {
        this.n = -1L;
      }
      this.m = this.k;
      if (localView != null) {
        this.l = localView.getTop();
      }
      this.q = 1;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.d);
  }
  
  @SuppressLint({"NewApi"})
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setScrollable(b());
    View localView = getSelectedView();
    if (localView != null) {
      paramAccessibilityEvent.setEnabled(localView.isEnabled());
    }
    paramAccessibilityEvent.setCurrentItemIndex(getSelectedItemPosition());
    paramAccessibilityEvent.setFromIndex(getFirstVisiblePosition());
    paramAccessibilityEvent.setToIndex(getLastVisiblePosition());
    paramAccessibilityEvent.setItemCount(getCount());
  }
  
  @SuppressLint({"NewApi"})
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    try
    {
      super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    paramAccessibilityNodeInfo.setScrollable(b());
    View localView = getSelectedView();
    if (localView != null) {
      paramAccessibilityNodeInfo.setEnabled(localView.isEnabled());
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.r = getHeight();
  }
  
  @SuppressLint({"NewApi"})
  public boolean onRequestSendAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    try
    {
      if (super.onRequestSendAccessibilityEvent(paramView, paramAccessibilityEvent))
      {
        AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain();
        onInitializeAccessibilityEvent(localAccessibilityEvent);
        paramView.dispatchPopulateAccessibilityEvent(localAccessibilityEvent);
        paramAccessibilityEvent.appendRecord(localAccessibilityEvent);
        return true;
      }
    }
    catch (Exception paramView)
    {
      QLog.e("AdapterView", 1, paramView, new Object[0]);
    }
    return false;
  }
  
  public void removeAllViews()
  {
    throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
  }
  
  public void removeView(View paramView)
  {
    throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
  }
  
  public void removeViewAt(int paramInt)
  {
    throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
  }
  
  public abstract void setAdapter(T paramT);
  
  public void setEmptyView(View paramView)
  {
    this.a = paramView;
    paramView = getAdapter();
    boolean bool;
    if ((paramView != null) && (!paramView.isEmpty())) {
      bool = false;
    } else {
      bool = true;
    }
    a(bool);
  }
  
  public void setFocusable(boolean paramBoolean)
  {
    Adapter localAdapter = getAdapter();
    boolean bool = true;
    int i;
    if ((localAdapter != null) && (localAdapter.getCount() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    this.b = paramBoolean;
    if (!paramBoolean) {
      this.c = false;
    }
    if (paramBoolean)
    {
      paramBoolean = bool;
      if (i == 0) {
        break label71;
      }
      if (d())
      {
        paramBoolean = bool;
        break label71;
      }
    }
    paramBoolean = false;
    label71:
    super.setFocusable(paramBoolean);
  }
  
  public void setFocusableInTouchMode(boolean paramBoolean)
  {
    Adapter localAdapter = getAdapter();
    boolean bool2 = false;
    int i;
    if ((localAdapter != null) && (localAdapter.getCount() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    this.c = paramBoolean;
    if (paramBoolean) {
      this.b = true;
    }
    boolean bool1 = bool2;
    if (paramBoolean) {
      if (i != 0)
      {
        bool1 = bool2;
        if (!d()) {}
      }
      else
      {
        bool1 = true;
      }
    }
    super.setFocusableInTouchMode(bool1);
  }
  
  void setNextSelectedPositionInt(int paramInt)
  {
    this.x = paramInt;
    this.y = a(paramInt);
    if ((this.p) && (this.q == 0) && (paramInt >= 0))
    {
      this.m = paramInt;
      this.n = this.y;
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.u = paramOnItemClickListener;
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    if (!isLongClickable()) {
      setLongClickable(true);
    }
    this.v = paramOnItemLongClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.t = paramOnItemSelectedListener;
  }
  
  void setSelectedPositionInt(int paramInt)
  {
    this.z = paramInt;
    this.A = a(paramInt);
  }
  
  public abstract void setSelection(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.pick.AdapterView
 * JD-Core Version:    0.7.0.1
 */