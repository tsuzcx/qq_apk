package com.tencent.biz.qqcircle.publish.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListAdapter;
import androidx.core.view.ViewCompat;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HorizontalListView
  extends AdapterView<ListAdapter>
{
  public static final boolean a = false;
  public static final int b = 2131886912;
  private HorizontalListView.RunningOutOfDataListener A = null;
  private int B = 0;
  private boolean C = false;
  private HorizontalListView.OnScrollStateChangedListener D = null;
  private HorizontalListView.OnItemScrollEventListener E = null;
  private HorizontalListView.OnScrollLinstener F = null;
  private int G;
  private VelocityTracker H;
  private boolean I = false;
  private int J = -1;
  private int K;
  private int L;
  private float M;
  private int N;
  private int O;
  private int P;
  private ContextMenu.ContextMenuInfo Q = null;
  private Rect R;
  private Runnable S;
  private HorizontalListView.CheckForLongPress T;
  private HorizontalListView.PerformClick U;
  private Runnable V;
  private DataSetObserver W;
  private Runnable Z;
  private int aa;
  private int ab;
  private boolean ac = false;
  private Runnable ad = new HorizontalListView.1(this);
  private int ae;
  private int af;
  private HorizontalListView.RecycleListener ag;
  public int c = 50;
  protected OverScroller d;
  protected int e;
  protected ListAdapter f;
  protected boolean g = false;
  protected int h = 0;
  protected int i;
  protected int j;
  protected int k = 2147483647;
  protected int l = 0;
  protected int m;
  protected int n;
  protected int o;
  protected int p = 4097;
  protected int q;
  int r = -1;
  protected boolean s = false;
  protected boolean t = false;
  Runnable u;
  private List<Queue<View>> v = new ArrayList();
  private Rect w = new Rect();
  private View x = null;
  private Drawable y = null;
  private Integer z = null;
  
  public HorizontalListView(Context paramContext)
  {
    this(paramContext, null, false);
  }
  
  public HorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, false);
  }
  
  public HorizontalListView(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet);
    if (Build.VERSION.SDK_INT >= 9) {
      setOverScrollMode(0);
    }
    a(paramBoolean);
    ViewCompat.setImportantForAccessibility(this, 1);
  }
  
  public HorizontalListView(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, null, paramBoolean);
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = this.f;
    if (localObject == null) {
      return getPaddingLeft() + getPaddingRight();
    }
    int i4 = getPaddingLeft() + getPaddingRight();
    int i1 = this.h;
    if ((i1 <= 0) || (this.y == null)) {
      i1 = 0;
    }
    paramInt4 = i4;
    int i3 = paramInt1;
    int i2 = paramInt2;
    if (paramInt2 == -1)
    {
      i2 = ((ListAdapter)localObject).getCount() - 1;
      i3 = paramInt1;
    }
    for (paramInt4 = i4; i3 <= i2; paramInt4 = paramInt1)
    {
      localObject = l(i3);
      if (localObject != null)
      {
        a((View)localObject);
        paramInt1 = paramInt4;
        if (i3 > 0) {
          paramInt1 = paramInt4 + i1;
        }
        paramInt2 = paramInt1 + ((View)localObject).getMeasuredWidth();
        a(i3, (View)localObject);
        paramInt1 = paramInt2;
        if (paramInt2 > paramInt3) {
          return paramInt3;
        }
      }
      else
      {
        paramInt1 = paramInt4;
        if (QLog.isColorLevel())
        {
          QLog.i("HorizontalListView", 2, "measureWidthOfChildren obtainView is null");
          paramInt1 = paramInt4;
        }
      }
      i3 += 1;
    }
    return paramInt4;
  }
  
  private View a(int paramInt, boolean paramBoolean)
  {
    View localView1 = a(paramInt);
    setTag(2131435140, Boolean.valueOf(paramBoolean));
    View localView2 = this.f.getView(paramInt, localView1, this);
    b(localView2, paramInt);
    if ((localView1 != null) && (localView2 != localView1)) {
      a(paramInt, localView1);
    }
    if (localView2 != null) {
      c(localView2, paramInt);
    }
    return localView2;
  }
  
  private void a(float paramFloat, int paramInt)
  {
    int i3 = this.k;
    int i4 = this.l;
    int i5 = getOverScrollMode();
    int i2 = 1;
    int i1 = i2;
    if (i5 != 0) {
      if ((i5 == 1) && (i3 > 0)) {
        i1 = i2;
      } else {
        i1 = 0;
      }
    }
    i2 = getScrollX();
    i5 = this.j;
    int i7 = i2 + i5;
    int i6 = i7 + paramInt;
    if (i7 >= i4)
    {
      i2 = paramInt;
      if (i7 <= i3) {}
    }
    else
    {
      i2 = f(paramInt, i3);
    }
    if ((i1 != 0) && ((i6 < i4) || (i6 > i3)))
    {
      if (i6 < i4) {
        paramInt = i6 - getScrollX() - i4;
      } else {
        paramInt = i6 - getScrollX() - i3;
      }
      i1 = getWidth();
      i2 = this.c;
      overScrollBy(paramInt, 0, getScrollX(), 0, 0, 0, i1 - i2, 0, true);
    }
    else
    {
      if (i7 != i5) {
        scrollTo(0, 0);
      }
      this.j += i2;
    }
    if (i6 < i4) {
      this.j = i4;
    } else if (i6 > i3) {
      this.j = i3;
    }
    if (i5 != this.j)
    {
      g();
      requestLayout();
    }
    this.M = paramFloat;
  }
  
  private void a(Canvas paramCanvas)
  {
    int i2 = getChildCount();
    Rect localRect = this.w;
    localRect.top = getPaddingTop();
    Object localObject = this.w;
    ((Rect)localObject).bottom = (((Rect)localObject).top + getRenderHeight());
    int i1 = 0;
    while (i1 < i2)
    {
      if ((i1 != i2 - 1) || (!f(this.n)))
      {
        localObject = getChildAt(i1);
        localRect.left = ((View)localObject).getRight();
        localRect.right = (((View)localObject).getRight() + this.h);
        if (localRect.left < getPaddingLeft()) {
          localRect.left = getPaddingLeft();
        }
        if (localRect.right > getWidth() - getPaddingRight()) {
          localRect.right = (getWidth() - getPaddingRight());
        }
        a(paramCanvas, localRect);
        if ((i1 == 0) && (((View)localObject).getLeft() > getPaddingLeft()))
        {
          localRect.left = getPaddingLeft();
          localRect.right = ((View)localObject).getLeft();
          a(paramCanvas, localRect);
        }
      }
      i1 += 1;
    }
  }
  
  private void a(Canvas paramCanvas, Rect paramRect)
  {
    Drawable localDrawable = this.y;
    if (localDrawable != null)
    {
      localDrawable.setBounds(paramRect);
      this.y.draw(paramCanvas);
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = (paramMotionEvent.getAction() & 0xFF00) >> 8;
    if (paramMotionEvent.getPointerId(i1) == this.J)
    {
      if (i1 == 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      this.M = paramMotionEvent.getX(i1);
      this.J = paramMotionEvent.getPointerId(i1);
      VelocityTracker localVelocityTracker = this.H;
      if (localVelocityTracker != null) {
        localVelocityTracker.clear();
      }
      this.O = ((int)paramMotionEvent.getX(i1));
      this.P = ((int)paramMotionEvent.getY(i1));
    }
  }
  
  private void a(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = b(paramView);
    int i2 = ViewGroup.getChildMeasureSpec(this.G, getPaddingTop() + getPaddingBottom(), localLayoutParams.height);
    int i1;
    if (localLayoutParams.width > 0) {
      i1 = View.MeasureSpec.makeMeasureSpec(localLayoutParams.width, 1073741824);
    } else {
      i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    }
    paramView.measure(i1, i2);
  }
  
  private ViewGroup.LayoutParams b(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    paramView = localLayoutParams;
    if (localLayoutParams == null) {
      paramView = new ViewGroup.LayoutParams(-2, -1);
    }
    return paramView;
  }
  
  private void b(View paramView, int paramInt)
  {
    try
    {
      paramInt = this.f.getItemViewType(paramInt);
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      paramInt = -1;
    }
    if ((paramView != null) && (k(paramInt))) {
      paramView.setTag(b, Integer.valueOf(paramInt));
    }
  }
  
  private void c(View paramView)
  {
    if (this.x != paramView)
    {
      g();
      this.x = paramView;
    }
    paramView = this.x;
    if (paramView != null) {
      paramView.setPressed(true);
    }
    setPressed(true);
  }
  
  private void c(View paramView, int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1;
    if (localLayoutParams2 == null)
    {
      localLayoutParams1 = generateDefaultLayoutParams();
    }
    else
    {
      localLayoutParams1 = localLayoutParams2;
      if (!checkLayoutParams(localLayoutParams2)) {
        localLayoutParams1 = generateLayoutParams(localLayoutParams2);
      }
    }
    paramView.setLayoutParams(localLayoutParams1);
  }
  
  private void d()
  {
    int i1 = getFirstVisiblePosition();
    int i2 = getLastVisiblePosition();
    while ((i1 >= 0) && (i1 <= i2))
    {
      View localView = e(i1);
      if (localView != null)
      {
        HorizontalListView.RecycleListener localRecycleListener = this.ag;
        if (localRecycleListener != null) {
          localRecycleListener.a(localView);
        }
        a(i1, localView);
      }
      i1 += 1;
    }
  }
  
  private void e()
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      a(getChildAt(i1));
      i1 += 1;
    }
  }
  
  private boolean e(int paramInt1, int paramInt2)
  {
    int i1 = getChildCount();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i1 > 0)
    {
      i1 = getScrollX();
      View localView1;
      if (this.t) {
        localView1 = getChildAt(getChildCount() - 1);
      } else {
        localView1 = getChildAt(0);
      }
      View localView2;
      if (this.t) {
        localView2 = getChildAt(0);
      } else {
        localView2 = getChildAt(getChildCount() - 1);
      }
      bool1 = bool2;
      if (paramInt1 >= localView1.getLeft() - i1)
      {
        bool1 = bool2;
        if (paramInt2 >= localView1.getTop())
        {
          bool1 = bool2;
          if (paramInt1 < localView2.getRight() - i1)
          {
            bool1 = bool2;
            if (paramInt2 < localView2.getBottom()) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private int f(int paramInt1, int paramInt2)
  {
    int i2 = getScrollX();
    int i1 = i2;
    if (getScrollX() > 0)
    {
      i1 = i2;
      if (getScrollX() > paramInt2) {
        i1 = getScrollX() - paramInt2;
      }
    }
    paramInt2 = getWidth();
    if (paramInt1 * i1 < 0) {
      return paramInt1;
    }
    if (paramInt2 == 0) {
      return paramInt1;
    }
    return (paramInt2 - Math.abs(i1)) * paramInt1 / paramInt2 / 2;
  }
  
  private void f()
  {
    setLayoutDirection(this.t);
  }
  
  private void g()
  {
    View localView = this.x;
    if (localView != null)
    {
      localView.setPressed(false);
      this.x = null;
    }
    setPressed(false);
  }
  
  private int getRenderHeight()
  {
    return getHeight() - getPaddingTop() - getPaddingBottom();
  }
  
  private int getRenderWidth()
  {
    return getWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  private void h()
  {
    VelocityTracker localVelocityTracker = this.H;
    if (localVelocityTracker == null)
    {
      this.H = VelocityTracker.obtain();
      return;
    }
    localVelocityTracker.clear();
  }
  
  private void i()
  {
    if (this.H == null) {
      this.H = VelocityTracker.obtain();
    }
  }
  
  private void j()
  {
    VelocityTracker localVelocityTracker = this.H;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.H = null;
    }
  }
  
  private void j(int paramInt)
  {
    this.v.clear();
    int i1 = 0;
    while (i1 < paramInt)
    {
      this.v.add(new LinkedList());
      i1 += 1;
    }
  }
  
  private void k()
  {
    if (a) {
      a("checkSpringback", new Object[] { Integer.valueOf(this.r) });
    }
    if (this.Z == null) {
      this.Z = new HorizontalListView.3(this);
    }
    removeCallbacks(this.Z);
    getHandler().post(this.Z);
  }
  
  private boolean k(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < this.v.size());
  }
  
  private View l(int paramInt)
  {
    View localView1 = a(paramInt);
    setTag(2131435140, Boolean.valueOf(true));
    View localView2 = this.f.getView(paramInt, localView1, this);
    b(localView2, paramInt);
    if ((localView1 != null) && (localView2 != localView1)) {
      a(paramInt, localView1);
    }
    if (localView2 != null) {
      c(localView2, paramInt);
    }
    return localView2;
  }
  
  private void l()
  {
    this.I = false;
    j();
  }
  
  private void m()
  {
    if (this.A != null)
    {
      ListAdapter localListAdapter = this.f;
      if ((localListAdapter != null) && (localListAdapter.getCount() - (this.n + 1) < this.B) && (!this.C))
      {
        this.C = true;
        this.A.a();
      }
    }
  }
  
  ContextMenu.ContextMenuInfo a(View paramView, int paramInt, long paramLong)
  {
    return new AdapterView.AdapterContextMenuInfo(paramView, paramInt, paramLong);
  }
  
  protected View a(int paramInt)
  {
    try
    {
      paramInt = this.f.getItemViewType(paramInt);
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      paramInt = -1;
    }
    if (k(paramInt)) {
      return (View)((Queue)this.v.get(paramInt)).poll();
    }
    return null;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    int i1 = paramInt1;
    Object localObject;
    if (this.t) {
      while (paramInt1 + paramInt2 + this.h < getWidth())
      {
        i1 = this.n;
        if (i1 < 1) {
          break;
        }
        this.n = (i1 - 1);
        localObject = this.f;
        i1 = this.n;
        localObject = ((ListAdapter)localObject).getView(i1, a(i1), this);
        a((View)localObject, 0);
        if (this.n == 0) {
          i1 = 0;
        } else {
          i1 = this.h;
        }
        i1 = paramInt1 + (i1 + ((View)localObject).getMeasuredWidth());
        int i2 = this.e;
        if (getWidth() - (i1 + paramInt2) == 0)
        {
          paramInt1 = ((View)localObject).getMeasuredWidth();
        }
        else
        {
          paramInt1 = this.h;
          paramInt1 = ((View)localObject).getMeasuredWidth() + paramInt1;
        }
        this.e = (i2 - paramInt1);
        paramInt1 = i1;
      }
    }
    while ((i1 + paramInt2 + this.h < getWidth()) && (this.n + 1 < this.f.getCount()))
    {
      this.n += 1;
      if (this.m < 0) {
        this.m = this.n;
      }
      localObject = a(this.n, false);
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("HorizontalListView", 2, "fillListRight obtainView is null");
        }
      }
      else
      {
        a((View)localObject, -1);
        if (this.n == 0) {
          paramInt1 = 0;
        } else {
          paramInt1 = this.h;
        }
        paramInt1 = i1 + (paramInt1 + ((View)localObject).getMeasuredWidth());
        m();
        i1 = paramInt1;
        if (a)
        {
          a("fillListRight", new Object[] { "mRightViewAdapterIndex", Integer.valueOf(this.n) });
          i1 = paramInt1;
        }
      }
    }
  }
  
  protected void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    while (((paramBoolean) || (paramInt1 + paramInt2 - this.h > 0)) && (this.m + 1 < this.f.getCount()))
    {
      this.m += 1;
      if (this.n < 0) {
        this.n = this.m;
      }
      Object localObject = this.f;
      int i1 = this.m;
      localObject = ((ListAdapter)localObject).getView(i1, a(i1), this);
      a((View)localObject, -1);
      if (this.m == 0) {
        i1 = getWidth() - ((View)localObject).getMeasuredWidth();
      } else {
        i1 = -(this.h + ((View)localObject).getMeasuredWidth());
      }
      paramInt1 += i1;
      paramBoolean = false;
    }
  }
  
  protected void a(int paramInt, View paramView)
  {
    int i3 = -1;
    int i2 = i3;
    try
    {
      Object localObject = paramView.getTag(b);
      int i1 = i3;
      i2 = i3;
      if ((localObject instanceof Integer))
      {
        i2 = i3;
        i1 = ((Integer)localObject).intValue();
      }
      i2 = i1;
      i3 = i1;
      if (!k(i1))
      {
        i2 = i1;
        i3 = this.f.getItemViewType(paramInt);
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      i3 = i2;
    }
    if (k(i3))
    {
      ((Queue)this.v.get(i3)).offer(paramView);
      HorizontalListView.RecycleListener localRecycleListener = this.ag;
      if (localRecycleListener != null) {
        localRecycleListener.b(paramView);
      }
    }
  }
  
  protected void a(View paramView, int paramInt)
  {
    addViewInLayout(paramView, paramInt, b(paramView), true);
    a(paramView);
  }
  
  public void a(String paramString, Object... paramVarArgs)
  {
    if ((a) && (QLog.isDevelopLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder(200);
      int i1 = 0;
      localStringBuilder.setLength(0);
      localStringBuilder.append(paramString);
      localStringBuilder.append(", mDisplayOffset = ");
      localStringBuilder.append(this.e);
      localStringBuilder.append(", mMaxX = ");
      localStringBuilder.append(this.k);
      localStringBuilder.append(", mMinX = ");
      localStringBuilder.append(this.l);
      localStringBuilder.append(", mCurrentX = ");
      localStringBuilder.append(this.i);
      localStringBuilder.append(", mNextX = ");
      localStringBuilder.append(this.j);
      localStringBuilder.append(", mScrollX = ");
      localStringBuilder.append(getScrollX());
      localStringBuilder.append(", mLeftViewAdapterIndex= ");
      localStringBuilder.append(this.m);
      localStringBuilder.append(", mRightViewAdapterIndex = ");
      localStringBuilder.append(this.n);
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        int i2 = paramVarArgs.length;
        while (i1 < i2)
        {
          paramString = paramVarArgs[i1];
          localStringBuilder.append(",");
          localStringBuilder.append(paramString);
          i1 += 1;
        }
      }
      QLog.i("HorizontalListView", 4, localStringBuilder.toString());
    }
  }
  
  @TargetApi(9)
  protected void a(boolean paramBoolean)
  {
    this.d = new OverScroller(getContext());
    this.d.a(getScrollerFriction());
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    this.q = localViewConfiguration.getScaledTouchSlop();
    this.K = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.L = localViewConfiguration.getScaledMaximumFlingVelocity();
    setLayoutDirection(paramBoolean);
    this.i = 0;
    this.j = this.i;
    this.m = -1;
    this.n = -1;
    this.e = 0;
    setFocusable(true);
    setDescendantFocusability(262144);
    setWillNotDraw(false);
    this.r = -1;
    setCurrentScrollState(4097);
    this.W = new HorizontalListView.HorizontalAdapterDataObserver(this);
  }
  
  public boolean a()
  {
    return (this.ac) && ((getParent() instanceof View));
  }
  
  protected void b(int paramInt)
  {
    boolean bool = this.t;
    int i3 = 0;
    int i2 = 0;
    if (bool)
    {
      localView = getLeftmostChild();
      if (localView != null)
      {
        i1 = localView.getLeft();
        bool = false;
      }
      else
      {
        i1 = 0;
        bool = true;
      }
      a(i1, paramInt, bool);
      localView = getRightmostChild();
      i1 = i2;
      if (localView != null) {
        i1 = localView.getRight();
      }
      a(i1, paramInt);
      return;
    }
    View localView = getRightmostChild();
    if (localView != null) {
      i1 = localView.getRight();
    } else {
      i1 = 0;
    }
    a(i1, paramInt);
    localView = getLeftmostChild();
    int i1 = i3;
    if (localView != null) {
      i1 = localView.getLeft();
    }
    b(i1, paramInt);
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    while (paramInt1 + paramInt2 - this.h > 0)
    {
      int i1 = this.m;
      if (i1 < 1) {
        break;
      }
      this.m = (i1 - 1);
      View localView = a(this.m, false);
      if (localView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("HorizontalListView", 2, "fillListLeft obtainView is null");
        }
      }
      else
      {
        a(localView, 0);
        if (this.m == 0) {
          i1 = localView.getMeasuredWidth();
        } else {
          i1 = this.h + localView.getMeasuredWidth();
        }
        i1 = paramInt1 - i1;
        int i2 = this.e;
        if (i1 + paramInt2 == 0)
        {
          paramInt1 = localView.getMeasuredWidth();
        }
        else
        {
          paramInt1 = this.h;
          paramInt1 = localView.getMeasuredWidth() + paramInt1;
        }
        this.e = (i2 - paramInt1);
        paramInt1 = i1;
        if (a)
        {
          a("fillListLeft", new Object[] { "mLeftViewAdapterIndex", Integer.valueOf(this.m) });
          paramInt1 = i1;
        }
      }
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      d();
    }
    a(this.t);
    removeAllViewsInLayout();
    requestLayout();
  }
  
  protected boolean b()
  {
    View localView;
    int i1;
    if (this.t)
    {
      if (f(this.m))
      {
        localView = getLeftmostChild();
        if (localView != null)
        {
          i1 = this.l;
          this.l = (this.i + (localView.getLeft() - getPaddingLeft()));
          if (this.l > 0) {
            this.l = -2147483648;
          }
          if (this.l != i1) {
            return true;
          }
        }
      }
    }
    else if (f(this.n))
    {
      localView = getRightmostChild();
      if (localView != null)
      {
        i1 = this.k;
        this.k = (this.i + (localView.getRight() - getPaddingLeft()) - getRenderWidth());
        if (this.k < 0) {
          this.k = 0;
        }
        if (this.k != i1) {
          return true;
        }
      }
    }
    return false;
  }
  
  boolean b(View paramView, int paramInt, long paramLong)
  {
    AdapterView.OnItemLongClickListener localOnItemLongClickListener = getOnItemLongClickListener();
    boolean bool1;
    if (localOnItemLongClickListener != null) {
      bool1 = localOnItemLongClickListener.onItemLongClick(this, paramView, paramInt, paramLong);
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (!bool1)
    {
      this.Q = a(paramView, paramInt, paramLong);
      bool2 = super.showContextMenuForChild(this);
    }
    if (bool2) {
      performHapticFeedback(0);
    }
    return bool2;
  }
  
  public int c(int paramInt1, int paramInt2)
  {
    Object localObject2 = this.R;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      this.R = new Rect();
      localObject1 = this.R;
    }
    int i1 = getChildCount() - 1;
    while (i1 >= 0)
    {
      localObject2 = getChildAt(i1);
      if (((View)localObject2).getVisibility() == 0)
      {
        ((View)localObject2).getHitRect((Rect)localObject1);
        if (((Rect)localObject1).contains(paramInt1, paramInt2)) {
          return getFirstVisiblePosition() + i1;
        }
      }
      i1 -= 1;
    }
    return -1;
  }
  
  protected void c(int paramInt)
  {
    int i2;
    int i1;
    if (this.t)
    {
      for (localObject = getRightmostChild(); (localObject != null) && (((View)localObject).getLeft() + paramInt >= getWidth()); localObject = getRightmostChild())
      {
        i2 = this.e;
        if (f(this.n)) {
          i1 = ((View)localObject).getMeasuredWidth();
        } else {
          i1 = this.h + ((View)localObject).getMeasuredWidth();
        }
        this.e = (i2 + i1);
        a(this.n, (View)localObject);
        removeViewInLayout((View)localObject);
        this.n += 1;
      }
      for (localObject = getLeftmostChild(); (localObject != null) && (((View)localObject).getRight() + paramInt <= 0); localObject = getLeftmostChild())
      {
        a(this.m, (View)localObject);
        removeViewInLayout((View)localObject);
        this.m -= 1;
      }
    }
    for (Object localObject = getLeftmostChild(); (localObject != null) && (((View)localObject).getRight() + paramInt <= 0); localObject = getLeftmostChild())
    {
      i2 = this.e;
      if (f(this.m)) {
        i1 = ((View)localObject).getMeasuredWidth();
      } else {
        i1 = this.h + ((View)localObject).getMeasuredWidth();
      }
      this.e = (i2 + i1);
      a(this.m, (View)localObject);
      removeViewInLayout((View)localObject);
      localObject = this.E;
      if (localObject != null) {
        ((HorizontalListView.OnItemScrollEventListener)localObject).a(this.m, true);
      }
      this.m += 1;
    }
    for (localObject = getRightmostChild(); (localObject != null) && (((View)localObject).getLeft() + paramInt >= getWidth()); localObject = getRightmostChild())
    {
      a(this.n, (View)localObject);
      removeViewInLayout((View)localObject);
      localObject = this.E;
      if (localObject != null) {
        ((HorizontalListView.OnItemScrollEventListener)localObject).a(this.n, false);
      }
      this.n -= 1;
    }
  }
  
  protected boolean c()
  {
    boolean bool1 = this.s;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    if (!this.t ? Math.abs(this.i - this.k) < this.q : Math.abs(this.i - this.l) < this.q) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      i1 = this.k;
      this.i = i1;
      this.j = i1;
      invalidate();
      return false;
    }
    int i1 = this.q;
    int i2 = this.e;
    if (i1 + i2 >= 0)
    {
      this.j += i2;
      invalidate();
      return false;
    }
    Object localObject = getChildAt(0);
    bool1 = bool2;
    if (localObject != null)
    {
      i2 = this.j + this.e;
      int i3 = ((View)localObject).getMeasuredWidth();
      double d1 = this.e;
      double d2 = i3 / 2;
      Double.isNaN(d2);
      i1 = i2;
      if (d1 <= -(d2 + 0.5D)) {
        i1 = i2 + i3;
      }
      localObject = this.d;
      i2 = this.j;
      bool1 = bool2;
      if (((OverScroller)localObject).a(getScrollX() + i2, 0, i1, i1, 0, 0))
      {
        if (a) {
          a("checkScrollToChild", new Object[] { Integer.valueOf(this.r), Integer.valueOf(i1) });
        }
        invalidate();
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void computeScroll()
  {
    boolean bool = this.d.c();
    int i2 = 1;
    if (bool)
    {
      int i7 = getScrollX() + this.j;
      int i3 = this.d.b();
      int i4 = this.j;
      if (a) {
        a("computeScroll", new Object[] { "MOVING", Integer.valueOf(i7), Integer.valueOf(i3) });
      }
      if (i7 != i3)
      {
        int i5 = this.k;
        int i6 = this.l;
        i1 = getOverScrollMode();
        if ((i1 != 0) && ((i1 != 1) || (i5 <= 0))) {
          i1 = 0;
        } else {
          i1 = 1;
        }
        if ((i1 != 0) && ((i3 < i6) || (i3 > i5)))
        {
          int i8 = getWidth() - this.c;
          if ((i3 < i6) && (i3 < -i8) && (i3 < i7)) {
            i1 = i2;
          } else if ((i5 != 2147483647) && (i3 > i5 + i8) && (i3 > i7)) {
            i1 = i2;
          } else {
            i1 = 0;
          }
          if (i1 != 0)
          {
            this.d.d();
            OverScroller localOverScroller = this.d;
            i1 = getScrollX();
            i2 = this.j;
            i7 = getScrollY();
            i8 = this.j;
            localOverScroller.a(i2 + i1, i7, i8, i8, 0, 0);
          }
          else
          {
            overScrollBy(i3 - i7, 0, getScrollX(), getScrollY(), 0, 0, i8, 0, false);
          }
        }
        else
        {
          if (i7 != i4) {
            scrollTo(0, 0);
          }
          this.j += i3 - i7;
        }
        if (i3 < i6) {
          this.j = i6;
        } else if (i3 > i5) {
          this.j = i5;
        }
      }
      else if (Math.abs(getScrollX()) < this.q)
      {
        this.j = i7;
        scrollTo(0, 0);
      }
      else
      {
        k();
      }
      if (i4 != this.j)
      {
        g();
        requestLayout();
      }
      awakenScrollBars();
      postInvalidate();
      return;
    }
    int i1 = getScrollX();
    i2 = this.p;
    if ((i2 != 4099) && ((i2 != 4097) || (this.k != this.j) || (i1 == 0))) {
      bool = false;
    } else {
      bool = true;
    }
    if ((a) && (QLog.isDevelopLevel())) {
      a("computeScroll", new Object[] { "over", Integer.valueOf(this.p), Boolean.valueOf(bool) });
    }
    if (bool)
    {
      this.r = -1;
      if (Math.abs(i1) < this.q)
      {
        scrollTo(0, 0);
        setCurrentScrollState(4097);
        return;
      }
      k();
    }
  }
  
  protected void d(int paramInt)
  {
    int i4 = getChildCount();
    if (i4 > 0)
    {
      boolean bool = a;
      int i3 = 0;
      int i2 = 0;
      if (bool) {
        a("positionChildren", new Object[] { Integer.valueOf(this.e), Integer.valueOf(paramInt), Integer.valueOf(this.e + paramInt) });
      }
      View localView;
      if (this.t)
      {
        this.e -= paramInt;
        i1 = getWidth() - this.e;
        paramInt = i2;
        while (paramInt < i4)
        {
          localView = getChildAt(paramInt);
          i2 = getPaddingRight() + i1;
          i3 = localView.getMeasuredWidth();
          int i5 = getPaddingTop();
          localView.layout(i2 - i3, i5, i2, localView.getMeasuredHeight() + i5);
          i1 -= localView.getMeasuredWidth() + this.h;
          paramInt += 1;
        }
      }
      if (this.m == 0) {
        this.l = (this.e + this.i);
      }
      this.e += paramInt;
      int i1 = this.e;
      paramInt = i3;
      while (paramInt < i4)
      {
        localView = getChildAt(paramInt);
        i2 = getPaddingLeft() + i1;
        i3 = getPaddingTop();
        localView.layout(i2, i3, localView.getMeasuredWidth() + i2, localView.getMeasuredHeight() + i3);
        i1 += localView.getMeasuredWidth() + this.h;
        paramInt += 1;
      }
    }
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    this.r = 4;
    setCurrentScrollState(4099);
    int i1 = this.i;
    if (this.d.a()) {
      i1 = getScrollX() + this.j;
    }
    this.d.a(i1, 0, -paramInt1, 0, paramInt2);
    this.M = 0.0F;
    j();
    ViewCompat.postInvalidateOnAnimation(this);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    catch (Exception paramCanvas) {}
  }
  
  protected void dispatchSetPressed(boolean paramBoolean) {}
  
  public View e(int paramInt)
  {
    int i1 = this.m;
    if ((paramInt >= i1) && (paramInt <= this.n)) {
      return getChildAt(paramInt - i1);
    }
    return null;
  }
  
  protected boolean f(int paramInt)
  {
    return paramInt == this.f.getCount() - 1;
  }
  
  public void g(int paramInt)
  {
    this.r = 6;
    setCurrentScrollState(4099);
    if (getChildCount() > 0)
    {
      OverScroller localOverScroller = this.d;
      int i1 = this.j;
      localOverScroller.a(getScrollX() + i1, 0, h(paramInt), 0, this.l, this.k, 0, 0, Math.max(0, getWidth() / 2), 0);
      requestLayout();
    }
  }
  
  public ListAdapter getAdapter()
  {
    return this.f;
  }
  
  protected ContextMenu.ContextMenuInfo getContextMenuInfo()
  {
    return this.Q;
  }
  
  public int getCurrentX()
  {
    return this.i;
  }
  
  public int getFirstVisiblePosition()
  {
    if (this.t) {
      return this.n;
    }
    return this.m;
  }
  
  public int getLastVisiblePosition()
  {
    if (this.t) {
      return this.m;
    }
    return this.n;
  }
  
  protected View getLeftmostChild()
  {
    int i1;
    if (this.t) {
      i1 = getChildCount() - 1;
    } else {
      i1 = 0;
    }
    return getChildAt(i1);
  }
  
  @TargetApi(9)
  public int getOverScrollMode()
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return super.getOverScrollMode();
    }
    return 0;
  }
  
  protected View getRightmostChild()
  {
    int i1;
    if (this.t) {
      i1 = 0;
    } else {
      i1 = getChildCount() - 1;
    }
    return getChildAt(i1);
  }
  
  protected float getScrollerFriction()
  {
    return 0.005F;
  }
  
  public View getSelectedView()
  {
    return e(this.o);
  }
  
  protected int h(int paramInt)
  {
    return paramInt;
  }
  
  int i(int paramInt)
  {
    int i1 = getChildCount();
    if (i1 > 0)
    {
      i1 -= 1;
      while (i1 >= 0)
      {
        if (paramInt >= getChildAt(i1).getLeft()) {
          return getFirstVisiblePosition() + i1;
        }
        i1 -= 1;
      }
    }
    return -1;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      super.onDraw(paramCanvas);
      a(paramCanvas);
      return;
    }
    catch (Exception paramCanvas) {}
  }
  
  @TargetApi(16)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(AbsListView.class.getName());
    if (isEnabled())
    {
      if (getFirstVisiblePosition() > 0) {
        paramAccessibilityNodeInfo.addAction(8192);
      }
      ListAdapter localListAdapter = this.f;
      int i1;
      if (localListAdapter == null) {
        i1 = 0;
      } else {
        i1 = localListAdapter.getCount();
      }
      if (getLastVisiblePosition() < i1 - 1) {
        paramAccessibilityNodeInfo.addAction(4096);
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    boolean bool = true;
    if ((i1 == 2) && (this.I)) {
      return true;
    }
    i1 &= 0xFF;
    float f1;
    if (i1 != 0)
    {
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 != 6) {
              break label330;
            }
            a(paramMotionEvent);
            break label330;
          }
        }
        else
        {
          i1 = this.J;
          if (i1 == -1) {
            break label330;
          }
          f1 = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(i1));
          if ((int)Math.abs(f1 - this.M) <= this.q) {
            break label330;
          }
          this.I = true;
          this.M = f1;
          i();
          this.H.addMovement(paramMotionEvent);
          localObject = getParent();
          if (localObject == null) {
            break label330;
          }
          ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
          break label330;
        }
      }
      this.I = false;
      this.J = -1;
      j();
      Object localObject = this.d;
      i1 = getScrollX();
      int i2 = this.j;
      int i3 = getScrollY();
      int i4 = this.j;
      if (((OverScroller)localObject).a(i1 + i2, i3, i4, i4, 0, 0))
      {
        this.r = 6;
        setCurrentScrollState(4099);
        invalidate();
      }
      else
      {
        this.r = -1;
        setCurrentScrollState(4097);
      }
      g();
    }
    else
    {
      f1 = paramMotionEvent.getX();
      if (!e((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
      {
        this.I = false;
        j();
      }
      else
      {
        this.M = f1;
        this.J = paramMotionEvent.getPointerId(0);
        h();
        this.H.addMovement(paramMotionEvent);
        this.I = (this.d.a() ^ true);
        setCurrentScrollState(4097);
      }
    }
    label330:
    if (!this.I)
    {
      if (super.onInterceptTouchEvent(paramMotionEvent)) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  @SuppressLint({"WrongCall"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.f == null) {
      return;
    }
    invalidate();
    if (this.g)
    {
      d();
      i1 = this.i;
      a(this.t);
      removeAllViewsInLayout();
      this.j = i1;
      this.g = false;
      localObject = this.u;
      if (localObject != null)
      {
        post((Runnable)localObject);
        this.u = null;
      }
    }
    Object localObject = this.z;
    if (localObject != null)
    {
      this.j = ((Integer)localObject).intValue();
      this.z = null;
    }
    int i1 = this.j;
    int i2 = this.l;
    if (i1 < i2)
    {
      this.j = i2;
    }
    else
    {
      i2 = this.k;
      if (i1 > i2) {
        this.j = i2;
      }
    }
    e();
    i1 = this.i - this.j;
    c(i1);
    b(i1);
    d(i1);
    this.i = this.j;
    localObject = this.F;
    if (localObject != null) {
      ((HorizontalListView.OnScrollLinstener)localObject).a();
    }
    if (b())
    {
      onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    localObject = getRightmostChild();
    if ((localObject != null) && (((View)localObject).getRight() + this.h < getRenderWidth()) && (this.n < this.f.getCount() - 1))
    {
      onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    if (!this.d.a()) {
      ViewCompat.postOnAnimation(this, this.ad);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i4 = View.MeasureSpec.getMode(paramInt1);
    int i5 = View.MeasureSpec.getMode(paramInt2);
    int i2 = View.MeasureSpec.getSize(paramInt1);
    int i3 = View.MeasureSpec.getSize(paramInt2);
    Object localObject = this.f;
    if (localObject == null) {
      i1 = 0;
    } else {
      i1 = ((ListAdapter)localObject).getCount();
    }
    if ((i1 > 0) && ((i5 == 0) || (i5 == -2147483648) || (i4 == 0)))
    {
      localObject = l(0);
      if (localObject != null)
      {
        measureChild((View)localObject, paramInt1, paramInt2);
        paramInt1 = ((View)localObject).getMeasuredWidth();
        i1 = ((View)localObject).getMeasuredHeight();
        a(0, (View)localObject);
        break label137;
      }
      if (QLog.isColorLevel()) {
        QLog.i("HorizontalListView", 2, "onMeasure obtainView is null");
      }
    }
    paramInt1 = 0;
    int i1 = 0;
    label137:
    if ((i5 != 0) && (i5 != -2147483648))
    {
      this.G = paramInt2;
      paramInt2 = i3;
    }
    else
    {
      paramInt2 = getPaddingTop();
      i3 = getPaddingBottom();
      paramInt2 = getVerticalFadingEdgeLength() * 2 + (paramInt2 + i3 + i1);
      this.G = View.MeasureSpec.makeMeasureSpec(paramInt2, i5);
    }
    if (i4 == 0)
    {
      paramInt1 = getPaddingLeft() + getPaddingRight() + paramInt1 + getVerticalScrollbarWidth();
    }
    else
    {
      paramInt1 = i2;
      if (i4 == -2147483648) {
        paramInt1 = a(0, -1, i2, -1);
      }
    }
    setMeasuredDimension(paramInt1, paramInt2);
    i1 = this.aa;
    if ((i1 == 0) || (i1 == paramInt1))
    {
      i1 = this.ab;
      if ((i1 == 0) || (i1 == paramInt2)) {}
    }
    else
    {
      f();
    }
    this.aa = paramInt1;
    this.ab = paramInt2;
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.scrollTo(paramInt1, paramInt2);
    awakenScrollBars();
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.z = Integer.valueOf(paramParcelable.getInt("BUNDLE_ID_CURRENT_X"));
      super.onRestoreInstanceState(paramParcelable.getParcelable("BUNDLE_ID_PARENT_STATE"));
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("BUNDLE_ID_PARENT_STATE", super.onSaveInstanceState());
    localBundle.putInt("BUNDLE_ID_CURRENT_X", this.i);
    return localBundle;
  }
  
  @TargetApi(8)
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    i();
    this.H.addMovement(paramMotionEvent);
    int i1 = paramMotionEvent.getAction() & 0xFF;
    int i2;
    Object localObject;
    if (i1 != 0)
    {
      float f1;
      int i3;
      int i4;
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 != 5)
            {
              if (i1 != 6) {
                return true;
              }
              a(paramMotionEvent);
              i1 = paramMotionEvent.findPointerIndex(this.J);
              if ((i1 < paramMotionEvent.getPointerCount()) && (-1 != i1)) {
                this.M = paramMotionEvent.getX(i1);
              }
              i1 = c(this.O, this.P);
              if (i1 >= 0)
              {
                this.N = i1;
                return true;
              }
            }
            else
            {
              i1 = (paramMotionEvent.getAction() & 0xFF00) >> 8;
              f1 = paramMotionEvent.getX(i1);
              float f2 = paramMotionEvent.getY(i1);
              this.M = f1;
              this.J = paramMotionEvent.getPointerId(i1);
              i1 = (int)f1;
              this.O = i1;
              i2 = (int)f2;
              this.P = i2;
              i1 = c(i1, i2);
              if (i1 >= 0)
              {
                this.N = i1;
                return true;
              }
            }
          }
          else
          {
            g();
            if ((this.I) && (getChildCount() > 0))
            {
              paramMotionEvent = this.d;
              i1 = getScrollX();
              i2 = this.j;
              i3 = getScrollY();
              i4 = this.j;
              if (paramMotionEvent.a(i1 + i2, i3, i4, i4, 0, 0))
              {
                this.r = 6;
                setCurrentScrollState(4099);
                invalidate();
              }
              else
              {
                setCurrentScrollState(4097);
              }
              this.J = -1;
              l();
            }
            i1 = this.r;
            if ((i1 != 5) && (i1 != 6))
            {
              this.r = -1;
              g();
              paramMotionEvent = getHandler();
              if (paramMotionEvent != null) {
                paramMotionEvent.removeCallbacks(this.T);
              }
            }
            if (a)
            {
              a("onTouchEvent", new Object[] { "CANCEL", Integer.valueOf(this.r) });
              return true;
            }
          }
        }
        else
        {
          i1 = paramMotionEvent.findPointerIndex(this.J);
          if (i1 == -1) {
            return true;
          }
          f1 = paramMotionEvent.getX(i1);
          i2 = (int)(this.M - f1);
          i1 = i2;
          if (!this.I)
          {
            i1 = i2;
            if (Math.abs(i2) > this.q)
            {
              paramMotionEvent = getParent();
              if (paramMotionEvent != null) {
                paramMotionEvent.requestDisallowInterceptTouchEvent(true);
              }
              this.I = true;
              if (i2 > 0) {
                i1 = i2 - this.q;
              } else {
                i1 = i2 + this.q;
              }
            }
          }
          if (this.I)
          {
            i2 = this.r;
            if ((i2 != 0) && (i2 != 1) && (i2 != 2))
            {
              if ((i2 == 3) || (i2 == 5)) {
                if (getScrollX() != 0) {
                  this.r = 5;
                } else {
                  this.r = 3;
                }
              }
            }
            else
            {
              paramMotionEvent = getHandler();
              if (paramMotionEvent != null) {
                paramMotionEvent.removeCallbacks(this.T);
              }
              paramMotionEvent = this.V;
              if (paramMotionEvent != null) {
                removeCallbacks(paramMotionEvent);
              }
              g();
              if (getScrollX() != 0) {
                this.r = 5;
              } else {
                this.r = 3;
              }
            }
            setCurrentScrollState(4098);
            a(f1, i1);
            return true;
          }
        }
      }
      else
      {
        if ((this.I) || (Math.abs(getScrollX()) > this.q))
        {
          localObject = this.H;
          ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.L);
          if (Build.VERSION.SDK_INT >= 8) {
            f1 = ((VelocityTracker)localObject).getXVelocity(this.J);
          } else {
            f1 = ((VelocityTracker)localObject).getXVelocity();
          }
          i1 = (int)f1;
          if (getChildCount() > 0)
          {
            if (Math.abs(i1) > this.K)
            {
              g(-i1);
            }
            else
            {
              localObject = this.d;
              i1 = getScrollX();
              i2 = this.j;
              i3 = getScrollY();
              i4 = this.j;
              if (((OverScroller)localObject).a(i1 + i2, i3, i4, i4, 0, 0))
              {
                this.r = 6;
                setCurrentScrollState(4099);
                invalidate();
              }
              else
              {
                setCurrentScrollState(4097);
              }
            }
          }
          else {
            setCurrentScrollState(4097);
          }
          this.J = -1;
          l();
        }
        i1 = this.r;
        if ((i1 != 0) && (i1 != 1) && (i1 != 2))
        {
          if (i1 != 3)
          {
            if (i1 == 5) {
              this.r = -1;
            }
          }
          else {
            this.r = -1;
          }
        }
        else
        {
          i2 = this.N;
          localObject = getChildAt(i2 - getFirstVisiblePosition());
          f1 = paramMotionEvent.getX();
          if ((f1 > getPaddingLeft()) && (f1 < getWidth() - getPaddingRight())) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          if (this.U == null) {
            this.U = new HorizontalListView.PerformClick(this, null);
          }
          HorizontalListView.PerformClick localPerformClick = this.U;
          localPerformClick.a = i2;
          localPerformClick.a();
          if ((localObject != null) && (!((View)localObject).hasFocusable()) && (i1 != 0))
          {
            if (this.r != 0)
            {
              g();
              paramMotionEvent = this.V;
              if (paramMotionEvent != null) {
                removeCallbacks(paramMotionEvent);
              }
            }
            i1 = this.r;
            if ((i1 != 0) && (i1 != 1))
            {
              if ((!this.g) && (this.f.isEnabled(i2))) {
                localPerformClick.run();
              }
            }
            else
            {
              Handler localHandler = getHandler();
              if (localHandler != null)
              {
                if (this.r == 0) {
                  paramMotionEvent = this.S;
                } else {
                  paramMotionEvent = this.T;
                }
                localHandler.removeCallbacks(paramMotionEvent);
              }
              if ((!this.g) && (this.f.isEnabled(i2)))
              {
                this.r = 1;
                if (a()) {
                  c((View)getParent());
                } else {
                  c((View)localObject);
                }
                paramMotionEvent = this.V;
                if (paramMotionEvent != null) {
                  removeCallbacks(paramMotionEvent);
                }
                this.V = new HorizontalListView.2(this, localPerformClick);
                postDelayed(this.V, ViewConfiguration.getPressedStateDuration());
                return true;
              }
              this.r = -1;
              return true;
            }
          }
          else
          {
            localPerformClick.run();
          }
          this.r = -1;
        }
        setPressed(false);
        invalidate();
        paramMotionEvent = getHandler();
        if (paramMotionEvent != null) {
          paramMotionEvent.removeCallbacks(this.T);
        }
        if (a)
        {
          a("onTouchEvent", new Object[] { "UP", Integer.valueOf(this.r) });
          return true;
        }
      }
    }
    else
    {
      if (getChildCount() == 0) {
        return false;
      }
      if (this.r == 6)
      {
        this.r = 5;
        this.O = ((int)paramMotionEvent.getX());
        this.P = ((int)paramMotionEvent.getY());
      }
      else
      {
        if (a())
        {
          this.r = 0;
          if (this.S == null) {
            this.S = new HorizontalListView.CheckForTap(this);
          }
          postDelayed(this.S, ViewConfiguration.getTapTimeout());
          this.N = getFirstVisiblePosition();
        }
        else
        {
          i2 = c((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
          i1 = i2;
          if (!this.g) {
            if ((this.r != 4) && (i2 >= 0) && (getAdapter().isEnabled(i2)))
            {
              this.r = 0;
              if (this.S == null) {
                this.S = new HorizontalListView.CheckForTap(this);
              }
              postDelayed(this.S, ViewConfiguration.getTapTimeout());
              i1 = i2;
            }
            else
            {
              i1 = i2;
              if (this.r == 4)
              {
                this.r = 3;
                i1 = i((int)paramMotionEvent.getX());
              }
            }
          }
          this.N = i1;
        }
        this.O = ((int)paramMotionEvent.getX());
        this.P = ((int)paramMotionEvent.getY());
      }
      boolean bool = this.d.a() ^ true;
      this.I = bool;
      if (bool)
      {
        localObject = getParent();
        if (localObject != null) {
          ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
        }
      }
      if (!this.d.a()) {
        this.d.d();
      }
      this.M = paramMotionEvent.getX();
      this.J = paramMotionEvent.getPointerId(0);
      setCurrentScrollState(4097);
      if (a) {
        a("onTouchEvent", new Object[] { "DOWN", Boolean.valueOf(this.I) });
      }
    }
    return true;
  }
  
  protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    int i3 = getOverScrollMode();
    int i1 = computeHorizontalScrollRange();
    int i2 = computeHorizontalScrollExtent();
    boolean bool2 = false;
    if (i1 > i2) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (computeVerticalScrollRange() > computeVerticalScrollExtent()) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    if ((i3 != 0) && ((i3 != 1) || (i1 == 0))) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if ((i3 != 0) && ((i3 != 1) || (i2 == 0))) {
      i2 = 0;
    } else {
      i2 = 1;
    }
    paramInt3 += paramInt1;
    if (i1 == 0) {
      paramInt7 = 0;
    }
    paramInt4 += paramInt2;
    if (i2 == 0) {
      paramInt8 = 0;
    }
    i1 = -paramInt7;
    paramInt2 = 2147483647;
    if (paramInt7 == 2147483647) {
      paramInt1 = 2147483647;
    } else {
      paramInt1 = paramInt7 + paramInt5;
    }
    paramInt5 = -paramInt8;
    if (paramInt8 != 2147483647) {
      paramInt2 = paramInt8 + paramInt6;
    }
    if (paramInt3 > paramInt1) {}
    for (;;)
    {
      paramBoolean = true;
      break label215;
      if (paramInt3 >= i1) {
        break;
      }
      paramInt1 = i1;
    }
    paramInt1 = paramInt3;
    paramBoolean = false;
    label215:
    if (paramInt4 > paramInt2) {}
    for (;;)
    {
      bool1 = true;
      break label246;
      if (paramInt4 >= paramInt5) {
        break;
      }
      paramInt2 = paramInt5;
    }
    paramInt2 = paramInt4;
    boolean bool1 = false;
    label246:
    onOverScrolled(paramInt1, paramInt2, paramBoolean, bool1);
    if (!paramBoolean)
    {
      paramBoolean = bool2;
      if (!bool1) {}
    }
    else
    {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  @TargetApi(16)
  public boolean performAccessibilityAction(int paramInt, Bundle paramBundle)
  {
    if (super.performAccessibilityAction(paramInt, paramBundle)) {
      return true;
    }
    paramBundle = this.f;
    int i1;
    if (paramBundle == null) {
      i1 = 0;
    } else {
      i1 = paramBundle.getCount();
    }
    int i2;
    if (paramInt != 4096)
    {
      if (paramInt != 8192) {
        return false;
      }
      if ((isEnabled()) && (getFirstVisiblePosition() > 0))
      {
        paramInt = getWidth();
        i1 = getPaddingLeft();
        i2 = getPaddingRight();
        a(this.M, -(paramInt - i1 - i2));
        return true;
      }
      return false;
    }
    if ((isEnabled()) && (getLastVisiblePosition() < i1 - 1))
    {
      paramInt = getWidth();
      i1 = getPaddingLeft();
      i2 = getPaddingRight();
      a(this.M, paramInt - i1 - i2);
      return true;
    }
    return false;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (paramBoolean) {
      j();
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void sendAccessibilityEvent(int paramInt)
  {
    if (paramInt == 4096)
    {
      int i1 = getFirstVisiblePosition();
      int i2 = getLastVisiblePosition();
      if ((this.ae == i1) && (this.af == i2)) {
        return;
      }
      this.ae = i1;
      this.af = i2;
    }
    super.sendAccessibilityEvent(paramInt);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    ListAdapter localListAdapter = this.f;
    if (localListAdapter != null) {
      try
      {
        localListAdapter.unregisterDataSetObserver(this.W);
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    if (paramListAdapter != null)
    {
      this.C = false;
      this.f = paramListAdapter;
      this.f.registerDataSetObserver(this.W);
    }
    paramListAdapter = this.f;
    if (paramListAdapter != null) {
      j(paramListAdapter.getViewTypeCount());
    }
    b(false);
  }
  
  protected void setCurrentScrollState(int paramInt)
  {
    int i1 = paramInt;
    if (this.s)
    {
      int i2 = this.p;
      i1 = paramInt;
      if (i2 != paramInt)
      {
        i1 = paramInt;
        if (paramInt == 4097) {
          if (i2 != 4098)
          {
            if (i2 != 4099)
            {
              i1 = paramInt;
            }
            else
            {
              i1 = paramInt;
              if (c())
              {
                i1 = paramInt;
                if (a)
                {
                  a("setCurrentScrollState", new Object[] { "SCROLL_STATE_FLING" });
                  i1 = paramInt;
                }
              }
            }
          }
          else
          {
            i1 = paramInt;
            if (c())
            {
              if (a) {
                a("setCurrentScrollState", new Object[] { "SCROLL_STATE_TOUCH_SCROLL" });
              }
              i1 = 4099;
            }
          }
        }
      }
    }
    if (this.p != i1)
    {
      HorizontalListView.OnScrollStateChangedListener localOnScrollStateChangedListener = this.D;
      if (localOnScrollStateChangedListener != null) {
        localOnScrollStateChangedListener.a(i1);
      }
    }
    this.p = i1;
  }
  
  public void setDivider(Drawable paramDrawable)
  {
    this.y = paramDrawable;
    if (paramDrawable != null)
    {
      setDividerWidth(paramDrawable.getIntrinsicWidth());
      return;
    }
    setDividerWidth(0);
  }
  
  public void setDividerWidth(int paramInt)
  {
    this.h = paramInt;
    requestLayout();
    invalidate();
  }
  
  public void setLayoutDirection(boolean paramBoolean)
  {
    this.t = paramBoolean;
    if (paramBoolean)
    {
      this.k = 0;
      this.l = -2147483648;
      return;
    }
    this.k = 2147483647;
    this.l = 0;
  }
  
  public void setOnItemScollEventListener(HorizontalListView.OnItemScrollEventListener paramOnItemScrollEventListener)
  {
    this.E = paramOnItemScrollEventListener;
  }
  
  public void setOnScrollListener(HorizontalListView.OnScrollLinstener paramOnScrollLinstener)
  {
    this.F = paramOnScrollLinstener;
  }
  
  public void setOnScrollStateChangedListener(HorizontalListView.OnScrollStateChangedListener paramOnScrollStateChangedListener)
  {
    this.D = paramOnScrollStateChangedListener;
  }
  
  @TargetApi(9)
  public void setOverScrollMode(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      super.setOverScrollMode(paramInt);
    }
  }
  
  public void setRecycleListener(HorizontalListView.RecycleListener paramRecycleListener)
  {
    this.ag = paramRecycleListener;
  }
  
  public void setRestoreX(int paramInt)
  {
    this.z = Integer.valueOf(paramInt);
  }
  
  public void setRunningOutOfDataListener(HorizontalListView.RunningOutOfDataListener paramRunningOutOfDataListener, int paramInt)
  {
    this.A = paramRunningOutOfDataListener;
    this.B = paramInt;
  }
  
  public void setSelection(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void setStayDisplayOffsetZero(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }
  
  public void setTransTouchStateToParent(boolean paramBoolean)
  {
    this.ac = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.view.HorizontalListView
 * JD-Core Version:    0.7.0.1
 */