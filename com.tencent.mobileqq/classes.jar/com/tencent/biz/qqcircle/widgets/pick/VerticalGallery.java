package com.tencent.biz.qqcircle.widgets.pick;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.Transformation;
import android.widget.Scroller;
import android.widget.SpinnerAdapter;
import com.tencent.mobileqq.biz.qcircle.R.styleable;

public class VerticalGallery
  extends VerticalAbsSpinner
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener
{
  private int G = 0;
  private int H = 400;
  private float I;
  private int J;
  private int K;
  private int L;
  private GestureDetector M = new GestureDetector(paramContext, this);
  private int N;
  private View O;
  private VerticalGallery.FlingRunnable P = new VerticalGallery.FlingRunnable(this);
  private Runnable Q = new VerticalGallery.1(this);
  private boolean R;
  private View S;
  private boolean T = true;
  private boolean U = true;
  private boolean V;
  private boolean W;
  private AdapterView.AdapterContextMenuInfo Z;
  private boolean aa;
  private boolean ab = false;
  private boolean ac = false;
  private int ad = 0;
  private int ae = 0;
  private int af = 5;
  private float ag = 1.0F;
  private boolean ah = false;
  private boolean ai = true;
  private boolean aj = false;
  private int ak = 1;
  private VerticalGallery.OnEndFlingListener al = null;
  private VerticalGallery.OnEndMovementListener am = null;
  private VerticalGallery.OnSelectViewDataUpdateListener an = null;
  
  public VerticalGallery(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VerticalGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2131036373);
  }
  
  public VerticalGallery(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.M.setIsLongpressEnabled(true);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.dd, paramInt, 0);
    paramInt = paramAttributeSet.getInt(R.styleable.de, -1);
    if (paramInt >= 0) {
      setGravity(paramInt);
    }
    paramInt = paramAttributeSet.getInt(R.styleable.df, -1);
    if (paramInt > 0) {
      setAnimationDuration(paramInt);
    }
    setSpacing(paramAttributeSet.getDimensionPixelOffset(R.styleable.dg, 0));
    setUnselectedAlpha(paramAttributeSet.getFloat(R.styleable.dh, 0.5F));
    paramAttributeSet.recycle();
    setChildrenDrawingOrderEnabled(true);
    setStaticTransformationsEnabled(true);
    this.af = ViewConfiguration.get(paramContext).getScaledScrollBarSize();
    if (E())
    {
      this.L = 1;
      return;
    }
    this.L = 16;
  }
  
  private void A()
  {
    if (u())
    {
      G();
      return;
    }
    int k = this.G;
    int m = getPaddingTop();
    View localView = getChildAt(0);
    int j;
    int i;
    if (localView != null)
    {
      j = this.k - 1;
      i = localView.getTop() - k;
    }
    else
    {
      i = getBottom() - getTop() - getPaddingBottom();
      this.R = true;
      j = 0;
    }
    while ((i > m) && (j >= 0))
    {
      localView = b(j, j - this.z, i, false);
      this.k = j;
      i = localView.getTop() - k;
      j -= 1;
    }
  }
  
  private void B()
  {
    if (u())
    {
      H();
      return;
    }
    int k = this.G;
    int m = getRight();
    int n = getLeft();
    int i1 = getPaddingRight();
    int i = getChildCount();
    int i2 = this.B;
    View localView = getChildAt(i - 1);
    int j;
    if (localView != null)
    {
      j = this.k + i;
      i = localView.getRight() + k;
    }
    else
    {
      j = this.B - 1;
      this.k = j;
      i = getPaddingLeft();
      this.R = true;
    }
    while ((i < m - n - i1) && (j < i2))
    {
      i = a(j, j - this.z, i, true).getRight() + k;
      j += 1;
    }
  }
  
  private void C()
  {
    if (u())
    {
      I();
      return;
    }
    int k = this.G;
    int m = getBottom();
    int n = getTop();
    int i1 = getPaddingRight();
    int i = getChildCount();
    int i2 = this.B;
    View localView = getChildAt(i - 1);
    int j;
    if (localView != null)
    {
      j = this.k + i;
      i = localView.getBottom() + k;
    }
    else
    {
      j = this.B - 1;
      this.k = j;
      i = getPaddingTop();
      this.R = true;
    }
    while ((i < m - n - i1) && (j < i2))
    {
      i = b(j, j - this.z, i, true).getBottom() + k;
      j += 1;
    }
  }
  
  private void D()
  {
    int j = this.z - this.k;
    int i = j;
    if (u())
    {
      i = j;
      if (this.k > this.z) {
        i = this.B - this.k + this.z;
      }
    }
    View localView = getChildAt(i);
    this.S = localView;
    if (localView == null) {
      return;
    }
    localView.setSelected(true);
    localView.setFocusable(true);
    if (hasFocus()) {
      localView.requestFocus();
    }
    VerticalGallery.OnSelectViewDataUpdateListener localOnSelectViewDataUpdateListener = this.an;
    if (localOnSelectViewDataUpdateListener != null) {
      localOnSelectViewDataUpdateListener.a(localView, i);
    }
    if (this.S != null) {}
  }
  
  private boolean E()
  {
    return this.ak == 2;
  }
  
  private void F()
  {
    int k = this.G;
    int m = getPaddingLeft();
    View localView = getChildAt(0);
    int i;
    if (localView != null)
    {
      j = this.k - 1;
      i = localView.getLeft() - k;
    }
    else
    {
      i = getRight() - getLeft() - getPaddingRight();
      this.R = true;
      j = 0;
    }
    while ((i > m) && (j >= 0))
    {
      localView = a(j, j - this.z, i, false);
      this.k = j;
      i = localView.getLeft() - k;
      j -= 1;
    }
    int j = this.B - 1;
    while ((i > m) && (getChildCount() < this.B))
    {
      localView = a(j, j - this.z, i, false);
      this.k = j;
      i = localView.getLeft() - k;
      j -= 1;
    }
  }
  
  private void G()
  {
    int k = this.G;
    int m = getPaddingTop();
    View localView = getChildAt(0);
    int i;
    if (localView != null)
    {
      j = this.k - 1;
      i = localView.getTop() - k;
    }
    else
    {
      i = getBottom() - getTop() - getPaddingBottom();
      this.R = true;
      j = 0;
    }
    while ((i > m) && (j >= 0))
    {
      localView = b(j, j - this.z, i, false);
      this.k = j;
      i = localView.getTop() - k;
      j -= 1;
    }
    int j = this.B - 1;
    while ((i > m) && (getChildCount() < this.B))
    {
      localView = b(j, j - this.z, i, false);
      this.k = j;
      i = localView.getTop() - k;
      j -= 1;
    }
  }
  
  private void H()
  {
    int k = this.G;
    int m = getRight() - getLeft() - getPaddingRight();
    int i = getChildCount();
    int n = this.B;
    View localView = getChildAt(i - 1);
    int j;
    if (localView != null)
    {
      j = this.k + i;
      i = localView.getRight() + k;
    }
    else
    {
      j = this.B - 1;
      this.k = j;
      i = getPaddingLeft();
      this.R = true;
    }
    while ((i < m) && (j < n))
    {
      i = a(j, j - this.z, i, true).getRight() + k;
      j += 1;
    }
    j %= n;
    while ((i <= m) && (getChildCount() < this.B))
    {
      i = a(j, j - this.z, i, true).getRight() + k;
      j += 1;
    }
  }
  
  private void I()
  {
    int k = this.G;
    int m = getBottom() - getTop() - getPaddingBottom();
    int i = getChildCount();
    int n = this.B;
    View localView = getChildAt(i - 1);
    int j;
    if (localView != null)
    {
      j = this.k + i;
      i = localView.getBottom() + k;
    }
    else
    {
      j = this.B - 1;
      this.k = j;
      i = getPaddingTop();
      this.R = true;
    }
    while ((i < m) && (j < n))
    {
      i = b(j, j - this.z, i, true).getBottom() + k;
      j += 1;
    }
    j %= n;
    while ((i <= m) && (getChildCount() < this.B))
    {
      i = b(j, j - this.z, i, true).getBottom() + k;
      j += 1;
    }
  }
  
  private int a(View paramView, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = getMeasuredHeight();
    } else {
      i = getHeight();
    }
    int j;
    if (paramBoolean) {
      j = paramView.getMeasuredHeight();
    } else {
      j = paramView.getHeight();
    }
    int k = this.L;
    if (k != 16)
    {
      if (k != 48)
      {
        if (k != 80) {
          return 0;
        }
        return i - this.i.bottom - j;
      }
      return this.i.top;
    }
    k = this.i.bottom;
    int m = this.i.top;
    return this.i.top + (i - k - m - j) / 2;
  }
  
  private View a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (!this.w)
    {
      localView = this.j.a(paramInt1);
      if (localView != null)
      {
        paramInt1 = localView.getLeft();
        this.K = Math.max(this.K, localView.getMeasuredWidth() + paramInt1);
        this.J = Math.min(this.J, paramInt1);
        a(localView, paramInt2, paramInt3, paramBoolean);
        return localView;
      }
    }
    View localView = this.a.getView(paramInt1, null, this);
    a(localView, paramInt2, paramInt3, paramBoolean);
    return localView;
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    VerticalGallery.LayoutParams localLayoutParams2 = (VerticalGallery.LayoutParams)paramView.getLayoutParams();
    VerticalGallery.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = (VerticalGallery.LayoutParams)generateDefaultLayoutParams();
    }
    boolean bool = false;
    if (paramBoolean) {
      i = -1;
    } else {
      i = 0;
    }
    addViewInLayout(paramView, i, localLayoutParams1);
    if (paramInt1 == 0) {
      bool = true;
    }
    paramView.setSelected(bool);
    paramInt1 = ViewGroup.getChildMeasureSpec(this.b, this.i.top + this.i.bottom, localLayoutParams1.height);
    paramView.measure(ViewGroup.getChildMeasureSpec(this.c, this.i.left + this.i.right, localLayoutParams1.width), paramInt1);
    int i = a(paramView, true);
    int j = paramView.getMeasuredHeight();
    int k = paramView.getMeasuredWidth();
    if (paramBoolean)
    {
      paramInt1 = paramInt2 + k;
    }
    else
    {
      paramInt1 = paramInt2;
      paramInt2 -= k;
    }
    paramView.layout(paramInt2, i, paramInt1, j + i);
  }
  
  private void a(boolean paramBoolean)
  {
    int i1 = getChildCount();
    int n = this.k;
    int m = 0;
    int k;
    int j;
    int i;
    View localView;
    if (paramBoolean)
    {
      k = getPaddingLeft();
      j = 0;
      i = 0;
      while (j < i1)
      {
        localView = getChildAt(j);
        if (localView.getRight() >= k) {
          break;
        }
        i += 1;
        this.j.a(n + j, localView);
        j += 1;
      }
      j = m;
      k = i;
      if (i == i1)
      {
        k = i - 1;
        j = m;
      }
    }
    else
    {
      int i2 = getWidth();
      int i3 = getPaddingRight();
      k = i1 - 1;
      j = 0;
      i = 0;
      while (k >= 0)
      {
        localView = getChildAt(k);
        if (localView.getLeft() <= i2 - i3) {
          break;
        }
        i += 1;
        this.j.a(n + k, localView);
        m = k - 1;
        j = k;
        k = m;
      }
      if (j == 0)
      {
        j += 1;
        k = i;
      }
      else
      {
        k = i;
      }
    }
    detachViewsFromParent(j, k);
    if (paramBoolean)
    {
      this.k += k;
      if (u()) {
        this.k %= this.B;
      }
    }
  }
  
  private int b(View paramView, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = getMeasuredWidth();
    } else {
      i = getWidth();
    }
    int j;
    if (paramBoolean) {
      j = paramView.getMeasuredWidth();
    } else {
      j = paramView.getWidth();
    }
    int k = this.L;
    if (k != 1)
    {
      if (k != 3)
      {
        if (k != 5) {
          return 0;
        }
        return i - this.i.right - j;
      }
      return this.i.left;
    }
    k = this.i.right;
    int m = this.i.left;
    return this.i.left + (i - k - m - j) / 2;
  }
  
  private View b(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (!this.w)
    {
      localView = this.j.a(paramInt1);
      if (localView != null)
      {
        paramInt1 = localView.getTop();
        this.K = Math.max(this.K, localView.getMeasuredHeight() + paramInt1);
        this.J = Math.min(this.J, paramInt1);
        b(localView, paramInt2, paramInt3, paramBoolean);
        return localView;
      }
    }
    View localView = this.a.getView(paramInt1, null, this);
    b(localView, paramInt2, paramInt3, paramBoolean);
    return localView;
  }
  
  private void b(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    VerticalGallery.LayoutParams localLayoutParams2 = (VerticalGallery.LayoutParams)paramView.getLayoutParams();
    VerticalGallery.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = (VerticalGallery.LayoutParams)generateDefaultLayoutParams();
    }
    boolean bool = false;
    if (paramBoolean) {
      i = -1;
    } else {
      i = 0;
    }
    addViewInLayout(paramView, i, localLayoutParams1);
    if (paramInt1 == 0) {
      bool = true;
    }
    paramView.setSelected(bool);
    paramInt1 = ViewGroup.getChildMeasureSpec(this.b, this.i.top + this.i.bottom, localLayoutParams1.height);
    paramView.measure(ViewGroup.getChildMeasureSpec(this.c, this.i.left + this.i.right, localLayoutParams1.width), paramInt1);
    int i = b(paramView, true);
    int j = paramView.getMeasuredWidth();
    int k = paramView.getMeasuredHeight();
    if (paramBoolean)
    {
      paramInt1 = paramInt2 + k;
    }
    else
    {
      paramInt1 = paramInt2;
      paramInt2 -= k;
    }
    paramView.layout(i, paramInt2, j + i, paramInt1);
  }
  
  private void b(boolean paramBoolean)
  {
    int i1 = getChildCount();
    int n = this.k;
    int m = 0;
    int k;
    int j;
    int i;
    View localView;
    if (paramBoolean)
    {
      k = getPaddingTop();
      j = 0;
      i = 0;
      while (j < i1)
      {
        localView = getChildAt(j);
        if (localView.getBottom() >= k) {
          break;
        }
        i += 1;
        this.j.a(n + j, localView);
        j += 1;
      }
      j = m;
      k = i;
      if (i == i1)
      {
        k = i - 1;
        j = m;
      }
    }
    else
    {
      int i2 = getHeight();
      int i3 = getPaddingBottom();
      k = i1 - 1;
      j = 0;
      i = 0;
      while (k >= 0)
      {
        localView = getChildAt(k);
        if (localView.getTop() <= i2 - i3) {
          break;
        }
        i += 1;
        this.j.a(n + k, localView);
        m = k - 1;
        j = k;
        k = m;
      }
      if (j == 0)
      {
        j += 1;
        k = i;
      }
      else
      {
        k = i;
      }
    }
    detachViewsFromParent(j, k);
    if (paramBoolean)
    {
      this.k += k;
      if (u()) {
        this.k %= this.B;
      }
    }
  }
  
  private boolean b(View paramView, int paramInt, long paramLong)
  {
    boolean bool1;
    if (this.v != null) {
      bool1 = this.v.a(this, this.O, this.N, paramLong);
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (!bool1)
    {
      this.Z = new AdapterView.AdapterContextMenuInfo(paramView, paramInt, paramLong);
      bool2 = super.showContextMenuForChild(this);
    }
    if (bool2) {
      performHapticFeedback(0);
    }
    return bool2;
  }
  
  private int d(View paramView)
  {
    int i;
    if (E()) {
      i = paramView.getTop();
    }
    for (int j = paramView.getHeight() / 2;; j = paramView.getWidth() / 2)
    {
      return i + j;
      i = paramView.getLeft();
    }
  }
  
  private void e(View paramView)
  {
    if (paramView != null) {
      paramView.setPressed(true);
    }
    setPressed(true);
  }
  
  private boolean e(int paramInt)
  {
    View localView = getChildAt(paramInt);
    if (localView != null)
    {
      paramInt = getCenterOfGallery();
      int i = d(localView);
      this.P.b(paramInt - i);
      return true;
    }
    return false;
  }
  
  private boolean f(int paramInt)
  {
    if (paramInt != this.z)
    {
      setSelectedPositionInt(paramInt);
      setNextSelectedPositionInt(paramInt);
      h();
      return true;
    }
    return false;
  }
  
  private float getStopFlingPosition()
  {
    float f;
    if (E()) {
      f = (getHeight() - getPaddingTop() - getPaddingBottom()) * k();
    }
    for (int i = getPaddingTop();; i = getPaddingLeft())
    {
      return f + i;
      f = (getWidth() - getPaddingLeft() - getPaddingRight()) * k();
    }
  }
  
  private void v()
  {
    View localView1;
    if (r())
    {
      if (getChildCount() != 0)
      {
        localView1 = this.S;
        if (localView1 == null) {
          return;
        }
        i = d(localView1);
        i = getCenterOfGallery() - i;
        if (i != 0)
        {
          this.P.b(i);
          return;
        }
        w();
      }
      return;
    }
    if (getChildCount() == 0) {
      return;
    }
    int i = this.k;
    int j = 0;
    if (i == 0)
    {
      localView1 = getChildAt(0);
      if (localView1.getTop() >= 0)
      {
        j = getPaddingTop();
        i = localView1.getTop();
      }
      else
      {
        View localView2 = getChildAt(getChildCount() - 1);
        if (localView2.getBottom() - localView1.getTop() < getBottom() - getPaddingBottom()) {
          i = getPaddingLeft();
        }
        for (j = this.ad;; j = localView2.getBottom())
        {
          i -= j;
          break;
          i = j;
          if (localView2.getBottom() >= getBottom() - getPaddingBottom()) {
            break;
          }
          i = getHeight() - getPaddingBottom();
        }
      }
    }
    else
    {
      i = j;
      if (this.k + getChildCount() != this.B) {
        break label255;
      }
      localView1 = getChildAt(getChildCount() - 1);
      i = j;
      if (localView1.getBottom() >= getBottom() - getPaddingBottom()) {
        break label255;
      }
      j = getHeight() - getPaddingBottom();
      i = localView1.getBottom();
    }
    i = j - i;
    label255:
    if (i != 0)
    {
      this.P.b(i);
      return;
    }
    w();
  }
  
  private void w()
  {
    if (this.V)
    {
      this.V = false;
      super.f();
    }
    invalidate();
    VerticalGallery.OnEndMovementListener localOnEndMovementListener = this.am;
    if (localOnEndMovementListener != null) {
      localOnEndMovementListener.a(this);
    }
  }
  
  private void x()
  {
    View localView = this.S;
    if (localView == null) {
      return;
    }
    int i1 = getCenterOfGallery();
    if ((localView.getLeft() <= i1) && (localView.getRight() >= i1)) {
      return;
    }
    int k = 2147483647;
    int j = 0;
    int i = getChildCount() - 1;
    int m;
    for (;;)
    {
      m = j;
      if (i < 0) {
        break;
      }
      localView = getChildAt(i);
      if ((localView.getLeft() <= i1) && (localView.getRight() >= i1))
      {
        m = i;
        break;
      }
      int n = Math.min(Math.abs(localView.getLeft() - i1), Math.abs(localView.getRight() - i1));
      m = k;
      if (n < k)
      {
        j = i;
        m = n;
      }
      i -= 1;
      k = m;
    }
    j = this.k + m;
    i = j;
    if (u()) {
      i = j % this.B;
    }
    if (i != this.z)
    {
      setSelectedPositionInt(i);
      setNextSelectedPositionInt(i);
      h();
    }
  }
  
  private void y()
  {
    View localView = this.S;
    if (localView == null) {
      return;
    }
    int i1 = getCenterOfGallery();
    if ((localView != null) && (localView.getTop() <= i1) && (localView.getBottom() >= i1)) {
      return;
    }
    int k = 2147483647;
    int j = 0;
    int i = getChildCount() - 1;
    int m;
    for (;;)
    {
      m = j;
      if (i < 0) {
        break;
      }
      localView = getChildAt(i);
      if ((localView.getTop() <= i1) && (localView.getBottom() >= i1))
      {
        m = i;
        break;
      }
      int n = Math.min(Math.abs(localView.getTop() - i1), Math.abs(localView.getBottom() - i1));
      m = k;
      if (n < k)
      {
        j = i;
        m = n;
      }
      i -= 1;
      k = m;
    }
    j = this.k + m;
    i = j;
    if (u()) {
      i = j % this.B;
    }
    if (i != this.z)
    {
      setSelectedPositionInt(i);
      setNextSelectedPositionInt(i);
      h();
    }
  }
  
  private void z()
  {
    if (u())
    {
      F();
      return;
    }
    int k = this.G;
    int m = getPaddingLeft();
    View localView = getChildAt(0);
    int j;
    int i;
    if (localView != null)
    {
      j = this.k - 1;
      i = localView.getLeft() - k;
    }
    else
    {
      i = getRight() - getLeft() - getPaddingRight();
      this.R = true;
      j = 0;
    }
    while ((i > m) && (j >= 0))
    {
      localView = a(j, j - this.z, i, false);
      this.k = j;
      i = localView.getLeft() - k;
      j -= 1;
    }
  }
  
  int a(View paramView)
  {
    return paramView.getMeasuredHeight();
  }
  
  int a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      i = this.B - 1;
    } else {
      i = 0;
    }
    View localView = getChildAt(i - this.k);
    if (localView == null) {
      return paramInt;
    }
    int i = d(localView);
    int j = getCenterOfGallery();
    if (paramBoolean)
    {
      if (i <= j) {
        return 0;
      }
    }
    else if (i >= j) {
      return 0;
    }
    i = j - i;
    if (paramBoolean) {
      return Math.max(i, paramInt);
    }
    return Math.min(i, paramInt);
  }
  
  void b(int paramInt)
  {
    if (getChildCount() == 0) {
      return;
    }
    boolean bool;
    if (paramInt < 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (r())
    {
      if (((!u()) || (getChildCount() >= this.B)) && (a(bool, paramInt) != paramInt))
      {
        VerticalGallery.FlingRunnable.a(this.P, false);
        w();
      }
      d(paramInt);
      a(bool);
      if (bool) {
        B();
      } else {
        z();
      }
      this.j.a();
      x();
      invalidate();
      return;
    }
    Object localObject;
    if (bool)
    {
      localObject = getChildAt(getChildCount() - 1);
      i = paramInt;
      if (localObject == null) {
        break label221;
      }
      i = paramInt;
      if (((View)localObject).getRight() >= getStopFlingPosition()) {
        break label221;
      }
      localObject = this.P;
      if (localObject != null) {
        ((VerticalGallery.FlingRunnable)localObject).a(false);
      }
    }
    else
    {
      localObject = getChildAt(0);
      i = paramInt;
      if (localObject == null) {
        break label221;
      }
      i = paramInt;
      if (((View)localObject).getLeft() <= getWidth() - getStopFlingPosition()) {
        break label221;
      }
      localObject = this.P;
      if (localObject != null) {
        ((VerticalGallery.FlingRunnable)localObject).a(false);
      }
    }
    int i = 0;
    label221:
    d(i);
    a(bool);
    if (bool) {
      B();
    } else {
      z();
    }
    this.j.a();
    x();
    awakenScrollBars();
    invalidate();
  }
  
  void b(int paramInt, boolean paramBoolean)
  {
    if (E())
    {
      d(paramInt, paramBoolean);
      return;
    }
    if (this.w) {
      g();
    }
    if (this.B == 0)
    {
      b();
      return;
    }
    if (this.x >= 0) {
      setSelectedPositionInt(this.x);
    }
    c();
    detachAllViewsFromParent();
    paramBoolean = false;
    this.K = 0;
    this.J = 0;
    this.k = this.z;
    View localView = a(this.k, 0, 0, true);
    int i = this.i.left + this.ad;
    paramInt = this.G + i;
    if (r()) {
      paramInt = i + (getRight() - getLeft() - this.i.left - this.i.right) / 2 - localView.getWidth() / 2;
    }
    localView.offsetLeftAndRight(paramInt);
    B();
    z();
    this.j.a();
    invalidate();
    this.w = false;
    this.p = false;
    setNextSelectedPositionInt(this.z);
    D();
    if (getChildCount() < this.B) {
      paramBoolean = true;
    }
    this.ai = paramBoolean;
  }
  
  void c(int paramInt)
  {
    if (getChildCount() == 0) {
      return;
    }
    boolean bool;
    if (paramInt < 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (r())
    {
      if (((!u()) || (getChildCount() >= this.B)) && (a(bool, paramInt) != paramInt))
      {
        VerticalGallery.FlingRunnable.a(this.P, false);
        w();
      }
      offsetChildrenTopAndBottom(paramInt);
      b(bool);
      if (bool) {
        C();
      } else {
        A();
      }
      this.j.a();
      y();
      invalidate();
      return;
    }
    Object localObject;
    if (bool)
    {
      localObject = getChildAt(getChildCount() - 1);
      i = paramInt;
      if (localObject == null) {
        break label221;
      }
      i = paramInt;
      if (((View)localObject).getRight() >= getStopFlingPosition()) {
        break label221;
      }
      localObject = this.P;
      if (localObject != null) {
        ((VerticalGallery.FlingRunnable)localObject).a(false);
      }
    }
    else
    {
      localObject = getChildAt(0);
      i = paramInt;
      if (localObject == null) {
        break label221;
      }
      i = paramInt;
      if (((View)localObject).getLeft() <= getWidth() - getStopFlingPosition()) {
        break label221;
      }
      localObject = this.P;
      if (localObject != null) {
        ((VerticalGallery.FlingRunnable)localObject).a(false);
      }
    }
    int i = 0;
    label221:
    offsetChildrenTopAndBottom(i);
    b(bool);
    if (bool) {
      C();
    } else {
      A();
    }
    this.j.a();
    x();
    awakenScrollBars();
    invalidate();
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof VerticalGallery.LayoutParams;
  }
  
  protected int computeHorizontalScrollExtent()
  {
    int m = getChildCount();
    int k = 0;
    if (m > 0)
    {
      int j = m * 100;
      View localView = getChildAt(0);
      int n = localView.getLeft();
      int i1 = localView.getWidth();
      int i = j;
      if (i1 > 0)
      {
        if (this.k == 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          i = j;
          if (n > 0) {}
        }
        else
        {
          i = j + n * 100 / i1;
        }
      }
      localView = getChildAt(m - 1);
      n = localView.getRight();
      i1 = localView.getWidth();
      j = i;
      if (i1 > 0)
      {
        j = k;
        if (this.k + m == this.B) {
          j = 1;
        }
        if (j != 0)
        {
          j = i;
          if (n < getWidth()) {}
        }
        else
        {
          j = i - (n - getWidth()) * 100 / i1;
        }
      }
      return j;
    }
    return 0;
  }
  
  protected int computeHorizontalScrollOffset()
  {
    if ((this.k >= 0) && (getChildCount() > 0))
    {
      View localView = getChildAt(0);
      int i = localView.getLeft();
      int j = localView.getWidth();
      if (j > 0) {
        return Math.max(this.k / 1 * 100 - i * 100 / j, 0);
      }
    }
    return this.z;
  }
  
  protected int computeHorizontalScrollRange()
  {
    return Math.max((this.B + 1 - 1) / 1 * 100, 0);
  }
  
  public void d(int paramInt)
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      getChildAt(i).offsetLeftAndRight(paramInt);
      if (Build.VERSION.SDK_INT >= 11) {
        getChildAt(i).invalidate();
      }
      i -= 1;
    }
  }
  
  void d(int paramInt, boolean paramBoolean)
  {
    if (this.w) {
      g();
    }
    if (this.B == 0)
    {
      b();
      return;
    }
    if (this.x >= 0) {
      setSelectedPositionInt(this.x);
    }
    c();
    detachAllViewsFromParent();
    paramBoolean = false;
    this.K = 0;
    this.J = 0;
    this.k = this.z;
    View localView = b(this.k, 0, 0, true);
    int i = this.i.top + this.ad;
    paramInt = this.G + i;
    if (r()) {
      paramInt = i + (getBottom() - getTop() - this.i.top - this.i.bottom) / 2 - localView.getHeight() / 2;
    }
    localView.offsetTopAndBottom(paramInt);
    C();
    A();
    this.j.a();
    invalidate();
    this.w = false;
    this.p = false;
    setNextSelectedPositionInt(this.z);
    D();
    if (getChildCount() < this.B) {
      paramBoolean = true;
    }
    this.ai = paramBoolean;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return paramKeyEvent.dispatch(this);
  }
  
  protected void dispatchSetPressed(boolean paramBoolean)
  {
    View localView = this.S;
    if (localView != null) {
      localView.setPressed(paramBoolean);
    }
  }
  
  public void dispatchSetSelected(boolean paramBoolean) {}
  
  protected void f()
  {
    if (!this.V) {
      super.f();
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new VerticalGallery.LayoutParams(-2, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new VerticalGallery.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new VerticalGallery.LayoutParams(paramLayoutParams);
  }
  
  protected int getCenterOfGallery()
  {
    int i;
    if (E()) {
      i = (getHeight() - getPaddingTop() - getPaddingBottom()) / 2;
    }
    for (int j = getPaddingTop();; j = getPaddingLeft())
    {
      return i + j;
      i = (getWidth() - getPaddingLeft() - getPaddingRight()) / 2;
    }
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i = this.z - this.k;
    if (i < 0) {
      return paramInt2;
    }
    if (paramInt2 == paramInt1 - 1) {
      return i;
    }
    paramInt1 = paramInt2;
    if (paramInt2 >= i) {
      paramInt1 = paramInt2 + 1;
    }
    return paramInt1;
  }
  
  protected boolean getChildStaticTransformation(View paramView, Transformation paramTransformation)
  {
    paramTransformation.clear();
    float f;
    if (paramView == this.S) {
      f = 1.0F;
    } else {
      f = this.I;
    }
    paramTransformation.setAlpha(f);
    return true;
  }
  
  protected ContextMenu.ContextMenuInfo getContextMenuInfo()
  {
    return this.Z;
  }
  
  public int getFirstPosition()
  {
    return this.k;
  }
  
  public int getOrientation()
  {
    return this.ak;
  }
  
  public int getSpacing()
  {
    return this.G;
  }
  
  public float getVelocityRatio()
  {
    return this.ag;
  }
  
  public void invalidate(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.invalidate(paramInt1, paramInt2 - (this.af + this.ae), paramInt3, paramInt4);
  }
  
  protected float k()
  {
    return 0.0F;
  }
  
  public void l()
  {
    if (E())
    {
      v();
      return;
    }
    View localView1;
    if (r())
    {
      if (getChildCount() != 0)
      {
        localView1 = this.S;
        if (localView1 == null) {
          return;
        }
        i = d(localView1);
        i = getCenterOfGallery() - i;
        if (i != 0)
        {
          this.P.b(i);
          return;
        }
        w();
      }
      return;
    }
    if (getChildCount() == 0) {
      return;
    }
    int i = this.k;
    int j = 0;
    if (i == 0)
    {
      localView1 = getChildAt(0);
      if (localView1.getLeft() >= 0)
      {
        j = getPaddingLeft();
        i = localView1.getLeft();
      }
      else
      {
        View localView2 = getChildAt(getChildCount() - 1);
        if (localView2.getRight() - localView1.getLeft() < getRight() - getPaddingRight()) {
          i = getPaddingLeft();
        }
        for (j = this.ad;; j = localView2.getRight())
        {
          i -= j;
          break;
          i = j;
          if (localView2.getRight() >= getRight() - getPaddingRight()) {
            break;
          }
          i = getWidth() - getPaddingRight();
        }
      }
    }
    else
    {
      i = j;
      if (this.k + getChildCount() != this.B) {
        break label267;
      }
      localView1 = getChildAt(getChildCount() - 1);
      i = j;
      if (localView1.getRight() >= getRight() - getPaddingRight()) {
        break label267;
      }
      j = getWidth() - getPaddingRight();
      i = localView1.getRight();
    }
    i = j - i;
    label267:
    if (i != 0)
    {
      this.P.b(i);
      return;
    }
    w();
  }
  
  protected void m()
  {
    if (VerticalGallery.FlingRunnable.a(this.P).isFinished()) {
      l();
    }
    o();
  }
  
  void n()
  {
    m();
  }
  
  protected void o()
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      getChildAt(i).setPressed(false);
      i -= 1;
    }
    setPressed(false);
  }
  
  public void offsetChildrenTopAndBottom(int paramInt)
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      getChildAt(i).offsetTopAndBottom(paramInt);
      if (Build.VERSION.SDK_INT >= 11) {
        getChildAt(i).invalidate();
      }
      i -= 1;
    }
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    if ((1 == paramMotionEvent.getAction()) && (this.N >= 0))
    {
      if (!this.U) {
        int i = this.z;
      }
      return true;
    }
    return false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    this.P.a(false);
    this.N = a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    int i = this.N;
    if (i >= 0)
    {
      this.O = getChildAt(i - this.k);
      this.O.setPressed(true);
    }
    this.aa = true;
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (t()) {
      return true;
    }
    if (!this.T)
    {
      removeCallbacks(this.Q);
      if (!this.V) {
        this.V = true;
      }
    }
    if (E())
    {
      paramFloat1 = getVelocityRatio();
      this.P.a((int)-(paramFloat2 * paramFloat1));
      return true;
    }
    paramFloat2 = getVelocityRatio();
    this.P.a((int)-(paramFloat1 * paramFloat2));
    return true;
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if (paramBoolean)
    {
      paramRect = this.S;
      if (paramRect != null) {
        paramRect.requestFocus(paramInt);
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt != 66) {
      switch (paramInt)
      {
      default: 
        break;
      case 22: 
        if (q()) {
          playSoundEffect(3);
        }
        return true;
      case 21: 
        if (p()) {
          playSoundEffect(1);
        }
        return true;
      }
    } else {
      this.W = true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt != 23) && (paramInt != 66)) {
      return super.onKeyUp(paramInt, paramKeyEvent);
    }
    if ((this.W) && (this.B > 0))
    {
      e(this.S);
      postDelayed(new VerticalGallery.2(this), ViewConfiguration.getPressedStateDuration());
      a(getChildAt(this.z - this.k), this.z, this.a.getItemId(this.z));
    }
    this.W = false;
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.s = true;
    b(0, false);
    this.s = false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (this.N < 0) {
      return;
    }
    performHapticFeedback(0);
    long l = a(this.N);
    b(this.O, this.N, l);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (t()) {
      return true;
    }
    this.ac = true;
    getParent().requestDisallowInterceptTouchEvent(true);
    if (!this.T)
    {
      if (this.aa)
      {
        if (!this.V) {
          this.V = true;
        }
        postDelayed(this.Q, 250L);
      }
    }
    else if (this.V) {
      this.V = false;
    }
    if (E()) {
      c((int)paramFloat2 * -1);
    } else {
      b((int)paramFloat1 * -1);
    }
    this.aa = false;
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (this.N >= 0)
    {
      if (u()) {
        this.N %= getCount();
      }
      if (r()) {
        e(this.N - this.k);
      }
      f(this.N);
      if ((this.U) || (this.N == this.z)) {
        a(this.O, this.N, this.a.getItemId(this.N));
      }
      return true;
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = this.M.onTouchEvent(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    if (i == 1)
    {
      m();
      return bool;
    }
    if (i == 3) {
      n();
    }
    return bool;
  }
  
  boolean p()
  {
    return (this.B > 0) && (this.z > 0);
  }
  
  boolean q()
  {
    return (this.B > 0) && (this.z < this.B - 1);
  }
  
  public boolean r()
  {
    return this.aj;
  }
  
  protected void s()
  {
    VerticalGallery.OnEndFlingListener localOnEndFlingListener = this.al;
    if (localOnEndFlingListener != null) {
      localOnEndFlingListener.a(this);
    }
  }
  
  public void setAnimationDuration(int paramInt)
  {
    this.H = paramInt;
  }
  
  public void setCallbackDuringFling(boolean paramBoolean)
  {
    this.T = paramBoolean;
  }
  
  public void setCallbackOnUnselectedItemClick(boolean paramBoolean)
  {
    this.U = paramBoolean;
  }
  
  public void setDisableScroll(boolean paramBoolean)
  {
    this.ab = paramBoolean;
  }
  
  public void setFirstChildOffset(int paramInt)
  {
    this.ad = paramInt;
  }
  
  public void setFirstPosition(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void setGravity(int paramInt)
  {
    if (this.L != paramInt)
    {
      this.L = paramInt;
      requestLayout();
    }
  }
  
  public void setOnEndFlingListener(VerticalGallery.OnEndFlingListener paramOnEndFlingListener)
  {
    this.al = paramOnEndFlingListener;
  }
  
  public void setOnEndMovementListener(VerticalGallery.OnEndMovementListener paramOnEndMovementListener)
  {
    this.am = paramOnEndMovementListener;
  }
  
  public void setOnSelectViewDataUpdateListener(VerticalGallery.OnSelectViewDataUpdateListener paramOnSelectViewDataUpdateListener)
  {
    this.an = paramOnSelectViewDataUpdateListener;
  }
  
  public void setOrientation(int paramInt)
  {
    this.ak = paramInt;
  }
  
  public void setScrollBarBottomMargin(int paramInt)
  {
    this.ae = paramInt;
  }
  
  public void setScrollBarSize(int paramInt)
  {
    this.af = paramInt;
  }
  
  public void setScrollCycle(boolean paramBoolean)
  {
    this.ah = paramBoolean;
  }
  
  protected void setSelectedPositionInt(int paramInt)
  {
    super.setSelectedPositionInt(paramInt);
    D();
  }
  
  public void setSlotInCenter(boolean paramBoolean)
  {
    this.aj = paramBoolean;
  }
  
  public void setSpacing(int paramInt)
  {
    this.G = paramInt;
  }
  
  public void setUnselectedAlpha(float paramFloat)
  {
    this.I = paramFloat;
  }
  
  public void setVelocityRatio(float paramFloat)
  {
    this.ag = paramFloat;
    paramFloat = this.ag;
    if (paramFloat < 0.5F)
    {
      this.ag = 0.5F;
      return;
    }
    if (paramFloat > 1.5F) {
      this.ag = 1.5F;
    }
  }
  
  public boolean showContextMenu()
  {
    if ((isPressed()) && (this.z >= 0)) {
      return b(getChildAt(this.z - this.k), this.z, this.A);
    }
    return false;
  }
  
  public boolean showContextMenuForChild(View paramView)
  {
    int i = c(paramView);
    if (i < 0) {
      return false;
    }
    return b(paramView, i, this.a.getItemId(i));
  }
  
  protected boolean t()
  {
    if (this.ab)
    {
      if (getChildCount() < this.B) {
        return false;
      }
      View localView = getChildAt(0);
      if ((localView != null) && (localView.getLeft() < getLeft())) {
        return false;
      }
      localView = getChildAt(getChildCount() - 1);
      return (localView == null) || (localView.getRight() <= getRight());
    }
    return false;
  }
  
  public boolean u()
  {
    return (this.ah) && (this.ai);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.pick.VerticalGallery
 * JD-Core Version:    0.7.0.1
 */