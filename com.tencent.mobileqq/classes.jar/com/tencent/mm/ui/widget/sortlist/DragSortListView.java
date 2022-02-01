package com.tencent.mm.ui.widget.sortlist;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AbsListView.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable;

public class DragSortListView
  extends ListView
{
  public static final int DRAG_NEG_X = 2;
  public static final int DRAG_NEG_Y = 8;
  public static final int DRAG_POS_X = 1;
  public static final int DRAG_POS_Y = 4;
  private View[] A = new View[1];
  private DragSortListView.DragScroller B;
  private float C = 0.3333333F;
  private float D = 0.3333333F;
  private int E;
  private int F;
  private float G;
  private float H;
  private float I;
  private float J;
  private float K = 0.5F;
  private DragSortListView.DragScrollProfile L = new DragSortListView.1(this);
  private int M;
  private int N;
  private int O;
  private int P;
  private int Q;
  private int R = 0;
  private boolean S = false;
  private boolean T = false;
  private DragSortListView.FloatViewManager U = null;
  private MotionEvent V;
  private int W = 0;
  private View a;
  private float aa = 0.25F;
  private float ab = 0.0F;
  private DragSortListView.AdapterWrapper ac;
  private boolean ad = false;
  private DragSortListView.DragSortTracker ae;
  private boolean af = false;
  private boolean ag = false;
  private DragSortListView.HeightCache ah = new DragSortListView.HeightCache(this, 3, null);
  private DragSortListView.RemoveAnimator ai;
  private DragSortListView.DropAnimator aj;
  private boolean ak;
  private float al = 0.0F;
  private boolean am = false;
  private boolean an = false;
  private Point b = new Point();
  private Point c = new Point();
  private int d;
  private boolean e = false;
  private DataSetObserver f;
  private float g = 1.0F;
  private float h = 1.0F;
  private int i;
  private int j;
  private int k;
  private boolean l = false;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private DragSortListView.DragListener r;
  private DragSortListView.DropListener s;
  private DragSortListView.RemoveListener t;
  private boolean u = true;
  private int v = 0;
  private int w = 1;
  private int x;
  private int y;
  private int z = 0;
  
  public DragSortListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i1 = 150;
    int i2;
    if (paramAttributeSet != null)
    {
      paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.DragSortListView, 0, 0);
      this.w = Math.max(1, paramContext.getDimensionPixelSize(R.styleable.DragSortListView_collapsed_height, 1));
      this.ad = paramContext.getBoolean(R.styleable.DragSortListView_track_drag_sort, false);
      if (this.ad) {
        this.ae = new DragSortListView.DragSortTracker(this);
      }
      this.g = paramContext.getFloat(R.styleable.DragSortListView_float_alpha, this.g);
      this.h = this.g;
      this.u = paramContext.getBoolean(R.styleable.DragSortListView_drag_enabled, this.u);
      this.aa = Math.max(0.0F, Math.min(1.0F, 1.0F - paramContext.getFloat(R.styleable.DragSortListView_slide_shuffle_speed, 0.75F)));
      boolean bool1;
      if (this.aa > 0.0F) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.l = bool1;
      setDragScrollStart(paramContext.getFloat(R.styleable.DragSortListView_drag_scroll_start, this.C));
      this.K = paramContext.getFloat(R.styleable.DragSortListView_max_drag_scroll_speed, this.K);
      i1 = paramContext.getInt(R.styleable.DragSortListView_remove_animation_duration, 150);
      i2 = paramContext.getInt(R.styleable.DragSortListView_drop_animation_duration, 150);
      if (paramContext.getBoolean(R.styleable.DragSortListView_use_default_controller, true))
      {
        bool1 = paramContext.getBoolean(R.styleable.DragSortListView_remove_enabled, false);
        int i3 = paramContext.getInt(R.styleable.DragSortListView_remove_mode, 1);
        boolean bool2 = paramContext.getBoolean(R.styleable.DragSortListView_sort_enabled, true);
        int i4 = paramContext.getInt(R.styleable.DragSortListView_drag_start_mode, 0);
        int i5 = paramContext.getResourceId(R.styleable.DragSortListView_drag_handle_id, 0);
        int i6 = paramContext.getResourceId(R.styleable.DragSortListView_fling_handle_id, 0);
        int i7 = paramContext.getResourceId(R.styleable.DragSortListView_click_remove_id, 0);
        int i8 = paramContext.getColor(R.styleable.DragSortListView_float_background_color, -16777216);
        paramAttributeSet = new DragSortController(this, i5, i4, i3, i7, i6);
        paramAttributeSet.setRemoveEnabled(bool1);
        paramAttributeSet.setSortEnabled(bool2);
        paramAttributeSet.setBackgroundColor(i8);
        this.U = paramAttributeSet;
        setOnTouchListener(paramAttributeSet);
      }
      paramContext.recycle();
    }
    else
    {
      i2 = 150;
    }
    this.B = new DragSortListView.DragScroller(this);
    if (i1 > 0) {
      this.ai = new DragSortListView.RemoveAnimator(this, 0.5F, i1, null);
    }
    if (i2 > 0) {
      this.aj = new DragSortListView.DropAnimator(this, 0.5F, i2, null);
    }
    this.V = MotionEvent.obtain(0L, 0L, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
    this.f = new DragSortListView.2(this);
  }
  
  private int a(int paramInt)
  {
    View localView = getChildAt(paramInt - getFirstVisiblePosition());
    if (localView != null) {
      return localView.getHeight();
    }
    return c(paramInt, c(paramInt));
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int i2 = getHeaderViewsCount();
    int i3 = getFooterViewsCount();
    int i1 = paramInt2;
    if (paramInt1 > i2)
    {
      if (paramInt1 >= getCount() - i3) {
        return paramInt2;
      }
      i3 = getDividerHeight();
      i2 = this.x - this.w;
      int i4 = c(paramInt1);
      int i5 = a(paramInt1);
      i1 = this.k;
      int i6 = this.m;
      if (i1 <= i6)
      {
        if ((paramInt1 == i1) && (this.j != i1))
        {
          if (paramInt1 == i6)
          {
            paramInt2 += i5;
            i1 = this.x;
          }
          else
          {
            paramInt2 += i5 - i4;
            i1 = i2;
          }
        }
        else
        {
          i1 = paramInt2;
          if (paramInt1 <= this.k) {
            break label212;
          }
          i1 = paramInt2;
          if (paramInt1 > this.m) {
            break label212;
          }
          i1 = i2;
        }
        i1 = paramInt2 - i1;
      }
      else if ((paramInt1 > i6) && (paramInt1 <= this.j))
      {
        i1 = paramInt2 + i2;
      }
      else
      {
        i2 = this.k;
        i1 = paramInt2;
        if (paramInt1 == i2)
        {
          i1 = paramInt2;
          if (this.j != i2) {
            i1 = paramInt2 + (i5 - i4);
          }
        }
      }
      label212:
      if (paramInt1 <= this.m) {
        return i1 + (this.x - i3 - c(paramInt1 - 1)) / 2;
      }
      i1 += (i4 - i3 - this.x) / 2;
    }
    return i1;
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = paramInt4 - paramInt3;
    paramInt2 = paramInt1 + paramInt2;
    if (paramInt2 < paramInt3) {
      return paramInt2 + i1;
    }
    paramInt1 = paramInt2;
    if (paramInt2 >= paramInt4) {
      paramInt1 = paramInt2 - i1;
    }
    return paramInt1;
  }
  
  private int a(int paramInt1, View paramView, int paramInt2, int paramInt3)
  {
    int i2 = c(paramInt1);
    int i4 = paramView.getHeight();
    int i5 = c(paramInt1, i2);
    int i1;
    if (paramInt1 != this.m)
    {
      i1 = i4 - i2;
      i2 = i5 - i2;
    }
    else
    {
      i1 = i4;
      i2 = i5;
    }
    int i6 = this.x;
    int i7 = this.m;
    int i3 = i6;
    if (i7 != this.j)
    {
      i3 = i6;
      if (i7 != this.k) {
        i3 = i6 - this.w;
      }
    }
    i6 = 0;
    if (paramInt1 <= paramInt2)
    {
      paramInt2 = i6;
      if (paramInt1 > this.j) {
        return 0 + (i3 - i2);
      }
    }
    else
    {
      if (paramInt1 == paramInt3)
      {
        if (paramInt1 <= this.j) {
          i1 -= i3;
        }
        while (paramInt1 != this.k) {
          return 0 + i1;
        }
        return 0 + (i4 - i5);
      }
      if (paramInt1 <= this.j) {
        return 0 - i3;
      }
      paramInt2 = i6;
      if (paramInt1 == this.k) {
        paramInt2 = 0 - i2;
      }
    }
    return paramInt2;
  }
  
  private static int a(SparseBooleanArray paramSparseBooleanArray, int paramInt)
  {
    int i2 = paramSparseBooleanArray.size();
    int i1 = 0;
    while (i2 - i1 > 0)
    {
      int i3 = i1 + i2 >> 1;
      if (paramSparseBooleanArray.keyAt(i3) < paramInt) {
        i1 = i3 + 1;
      } else {
        i2 = i3;
      }
    }
    return i1;
  }
  
  private static int a(SparseBooleanArray paramSparseBooleanArray, int paramInt1, int paramInt2)
  {
    int i1 = paramSparseBooleanArray.size();
    paramInt1 = a(paramSparseBooleanArray, paramInt1);
    while ((paramInt1 < i1) && (paramSparseBooleanArray.keyAt(paramInt1) < paramInt2) && (!paramSparseBooleanArray.valueAt(paramInt1))) {
      paramInt1 += 1;
    }
    if ((paramInt1 != i1) && (paramSparseBooleanArray.keyAt(paramInt1) < paramInt2)) {
      return paramInt1;
    }
    return -1;
  }
  
  private static int a(SparseBooleanArray paramSparseBooleanArray, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i2 = a(paramSparseBooleanArray, paramInt1, paramInt2);
    if (i2 == -1) {
      return 0;
    }
    int i4 = paramSparseBooleanArray.keyAt(i2);
    int i1 = i4 + 1;
    int i3 = i2 + 1;
    i2 = 0;
    while (i3 < paramSparseBooleanArray.size())
    {
      int i5 = paramSparseBooleanArray.keyAt(i3);
      if (i5 >= paramInt2) {
        break;
      }
      if (paramSparseBooleanArray.valueAt(i3)) {
        if (i5 == i1)
        {
          i1 += 1;
        }
        else
        {
          paramArrayOfInt1[i2] = i4;
          paramArrayOfInt2[i2] = i1;
          i2 += 1;
          i1 = i5 + 1;
          i4 = i5;
        }
      }
      i3 += 1;
    }
    i3 = i1;
    if (i1 == paramInt2) {
      i3 = paramInt1;
    }
    paramArrayOfInt1[i2] = i4;
    paramArrayOfInt2[i2] = i3;
    i1 = i2 + 1;
    paramInt2 = i1;
    if (i1 > 1)
    {
      paramInt2 = i1;
      if (paramArrayOfInt1[0] == paramInt1)
      {
        i2 = i1 - 1;
        paramInt2 = i1;
        if (paramArrayOfInt2[i2] == paramInt1)
        {
          paramArrayOfInt1[0] = paramArrayOfInt1[i2];
          paramInt2 = i1 - 1;
        }
      }
    }
    return paramInt2;
  }
  
  private void a(int paramInt, Canvas paramCanvas)
  {
    Drawable localDrawable = getDivider();
    int i4 = getDividerHeight();
    if ((localDrawable != null) && (i4 != 0))
    {
      ViewGroup localViewGroup = (ViewGroup)getChildAt(paramInt - getFirstVisiblePosition());
      if (localViewGroup != null)
      {
        int i2 = getPaddingLeft();
        int i3 = getWidth() - getPaddingRight();
        int i1 = localViewGroup.getChildAt(0).getHeight();
        if (paramInt > this.m)
        {
          i1 = localViewGroup.getTop() + i1;
          paramInt = i4 + i1;
        }
        else
        {
          i1 = localViewGroup.getBottom() - i1;
          paramInt = i1;
          i1 -= i4;
        }
        paramCanvas.save();
        paramCanvas.clipRect(i2, i1, i3, paramInt);
        localDrawable.setBounds(i2, i1, i3, paramInt);
        localDrawable.draw(paramCanvas);
        paramCanvas.restore();
      }
    }
  }
  
  private void a(int paramInt, View paramView, boolean paramBoolean)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if ((paramInt != this.m) && (paramInt != this.j) && (paramInt != this.k)) {
      i1 = -2;
    } else {
      i1 = c(paramInt, paramView, paramBoolean);
    }
    if (i1 != localLayoutParams.height)
    {
      localLayoutParams.height = i1;
      paramView.setLayoutParams(localLayoutParams);
    }
    if ((paramInt == this.j) || (paramInt == this.k))
    {
      i1 = this.m;
      if (paramInt < i1) {
        ((DragSortItemView)paramView).setGravity(80);
      } else if (paramInt > i1) {
        ((DragSortItemView)paramView).setGravity(48);
      }
    }
    int i3 = paramView.getVisibility();
    int i2 = 0;
    int i1 = i2;
    if (paramInt == this.m)
    {
      i1 = i2;
      if (this.a != null) {
        i1 = 4;
      }
    }
    if (i1 != i3) {
      paramView.setVisibility(i1);
    }
  }
  
  private void a(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null)
    {
      localObject = new AbsListView.LayoutParams(-1, -2);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    int i2 = ViewGroup.getChildMeasureSpec(this.z, getListPaddingLeft() + getListPaddingRight(), ((ViewGroup.LayoutParams)localObject).width);
    int i1;
    if (((ViewGroup.LayoutParams)localObject).height > 0) {
      i1 = View.MeasureSpec.makeMeasureSpec(((ViewGroup.LayoutParams)localObject).height, 1073741824);
    } else {
      i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    }
    paramView.measure(i2, i1);
  }
  
  private void a(boolean paramBoolean)
  {
    int i1 = getFirstVisiblePosition();
    int i2 = getChildCount() / 2;
    View localView = getChildAt(getChildCount() / 2);
    if (localView == null) {
      return;
    }
    d(i1 + i2, localView, paramBoolean);
  }
  
  private boolean a()
  {
    int i1 = getFirstVisiblePosition();
    int i3 = this.j;
    View localView = getChildAt(i3 - i1);
    Object localObject = localView;
    if (localView == null)
    {
      i3 = getChildCount() / 2 + i1;
      localObject = getChildAt(i3 - i1);
    }
    i1 = ((View)localObject).getTop();
    int i6 = ((View)localObject).getHeight();
    int i2 = a(i3, i1);
    int i7 = getDividerHeight();
    int i5;
    int i4;
    if (this.d < i2)
    {
      for (;;)
      {
        i5 = i3;
        i4 = i2;
        if (i3 < 0) {
          break;
        }
        i3 -= 1;
        i4 = a(i3);
        if (i3 == 0)
        {
          i1 = i1 - i7 - i4;
          break label279;
        }
        i4 = i1 - (i4 + i7);
        i1 = a(i3, i4);
        if (this.d >= i1) {
          break label279;
        }
        i2 = i1;
        i1 = i4;
      }
      i1 = i4;
      i3 = i5;
      i2 = i4;
    }
    else
    {
      i8 = getCount();
      for (;;)
      {
        i5 = i3;
        i4 = i2;
        if (i3 >= i8) {
          break;
        }
        if (i3 == i8 - 1)
        {
          i1 = i1 + i7 + i6;
          break label279;
        }
        i4 = i1 + (i6 + i7);
        i5 = i3 + 1;
        i6 = a(i5);
        i1 = a(i5, i4);
        if (this.d < i1) {
          break label279;
        }
        i3 = i5;
        i2 = i1;
        i1 = i4;
      }
    }
    label279:
    i6 = getHeaderViewsCount();
    int i9 = getFooterViewsCount();
    boolean bool = false;
    i7 = this.j;
    int i8 = this.k;
    float f1 = this.ab;
    if (this.l)
    {
      int i10 = Math.abs(i1 - i2);
      i5 = i1;
      i4 = i2;
      if (this.d < i1)
      {
        i4 = i1;
        i5 = i2;
      }
      i1 = (int)(this.aa * 0.5F * i10);
      float f2 = i1;
      i2 = i5 + i1;
      i5 = this.d;
      if (i5 < i2)
      {
        this.j = (i3 - 1);
        this.k = i3;
        this.ab = ((i2 - i5) * 0.5F / f2);
      }
      else if (i5 < i4 - i1)
      {
        this.j = i3;
        this.k = i3;
      }
      else
      {
        this.j = i3;
        this.k = (i3 + 1);
        this.ab = (((i4 - i5) / f2 + 1.0F) * 0.5F);
      }
    }
    else
    {
      this.j = i3;
      this.k = i3;
    }
    if (this.j < i6)
    {
      this.j = i6;
      this.k = i6;
      i3 = i6;
    }
    else if (this.k >= getCount() - i9)
    {
      i3 = getCount() - i9 - 1;
      this.j = i3;
      this.k = i3;
    }
    if ((this.j != i7) || (this.k != i8) || (Math.abs(this.ab - f1) > 0.0F)) {
      bool = true;
    }
    i1 = this.i;
    if (i3 != i1)
    {
      localObject = this.r;
      if (localObject != null) {
        ((DragSortListView.DragListener)localObject).drag(i1 - i6, i3 - i6);
      }
      this.i = i3;
      return true;
    }
    return bool;
  }
  
  private int b(int paramInt, View paramView, boolean paramBoolean)
  {
    if (paramInt == this.m) {
      return 0;
    }
    View localView = paramView;
    if (paramInt >= getHeaderViewsCount()) {
      if (paramInt >= getCount() - getFooterViewsCount()) {
        localView = paramView;
      } else {
        localView = ((ViewGroup)paramView).getChildAt(0);
      }
    }
    paramView = localView.getLayoutParams();
    if ((paramView != null) && (paramView.height > 0)) {
      return paramView.height;
    }
    paramInt = localView.getHeight();
    if ((paramInt == 0) || (paramBoolean))
    {
      a(localView);
      paramInt = localView.getMeasuredHeight();
    }
    return paramInt;
  }
  
  private void b()
  {
    this.m = -1;
    this.j = -1;
    this.k = -1;
    this.i = -1;
  }
  
  private void b(int paramInt)
  {
    this.v = 1;
    DragSortListView.RemoveListener localRemoveListener = this.t;
    if (localRemoveListener != null) {
      localRemoveListener.remove(paramInt);
    }
    k();
    e();
    b();
    if (this.T)
    {
      this.v = 3;
      return;
    }
    this.v = 0;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    Point localPoint = this.b;
    localPoint.x = (paramInt1 - this.n);
    localPoint.y = (paramInt2 - this.o);
    a(true);
    paramInt1 = Math.min(paramInt2, this.d + this.y);
    paramInt2 = Math.max(paramInt2, this.d - this.y);
    int i1 = this.B.getScrollDir();
    if ((paramInt1 > this.P) && (paramInt1 > this.F) && (i1 != 1))
    {
      if (i1 != -1) {
        this.B.stopScrolling(true);
      }
      this.B.startScrolling(1);
      return;
    }
    if ((paramInt2 < this.P) && (paramInt2 < this.E) && (i1 != 0))
    {
      if (i1 != -1) {
        this.B.stopScrolling(true);
      }
      this.B.startScrolling(0);
      return;
    }
    if ((paramInt2 >= this.E) && (paramInt1 <= this.F) && (this.B.isScrolling())) {
      this.B.stopScrolling(true);
    }
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 != 0)
    {
      this.O = this.M;
      this.P = this.N;
    }
    this.M = ((int)paramMotionEvent.getX());
    this.N = ((int)paramMotionEvent.getY());
    if (i1 == 0)
    {
      this.O = this.M;
      this.P = this.N;
    }
    this.p = ((int)paramMotionEvent.getRawX() - this.M);
    this.q = ((int)paramMotionEvent.getRawY() - this.N);
  }
  
  private int c(int paramInt)
  {
    if (paramInt == this.m) {
      return 0;
    }
    Object localObject = getChildAt(paramInt - getFirstVisiblePosition());
    if (localObject != null) {
      return b(paramInt, (View)localObject, false);
    }
    int i1 = this.ah.get(paramInt);
    if (i1 != -1) {
      return i1;
    }
    localObject = getAdapter();
    i1 = ((ListAdapter)localObject).getItemViewType(paramInt);
    int i2 = ((ListAdapter)localObject).getViewTypeCount();
    if (i2 != this.A.length) {
      this.A = new View[i2];
    }
    if (i1 >= 0)
    {
      View[] arrayOfView = this.A;
      if (arrayOfView[i1] == null)
      {
        localObject = ((ListAdapter)localObject).getView(paramInt, null, this);
        this.A[i1] = localObject;
      }
      else
      {
        localObject = ((ListAdapter)localObject).getView(paramInt, arrayOfView[i1], this);
      }
    }
    else
    {
      localObject = ((ListAdapter)localObject).getView(paramInt, null, this);
    }
    i1 = b(paramInt, (View)localObject, true);
    this.ah.add(paramInt, i1);
    return i1;
  }
  
  private int c(int paramInt1, int paramInt2)
  {
    if ((this.l) && (this.j != this.k)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i4 = this.x;
    int i5 = this.w;
    int i2 = i4 - i5;
    int i3 = (int)(this.ab * i2);
    int i6 = this.m;
    if (paramInt1 == i6)
    {
      if (i6 == this.j)
      {
        if (i1 != 0) {
          return i3 + i5;
        }
        return i4;
      }
      if (i6 == this.k) {
        return i4 - i3;
      }
      return i5;
    }
    if (paramInt1 == this.j)
    {
      if (i1 != 0) {
        return paramInt2 + i3;
      }
      return paramInt2 + i2;
    }
    int i1 = paramInt2;
    if (paramInt1 == this.k) {
      i1 = paramInt2 + i2 - i3;
    }
    return i1;
  }
  
  private int c(int paramInt, View paramView, boolean paramBoolean)
  {
    return c(paramInt, b(paramInt, paramView, paramBoolean));
  }
  
  private void c()
  {
    this.v = 2;
    if (this.s != null)
    {
      int i1 = this.i;
      if ((i1 >= 0) && (i1 < getCount()))
      {
        i1 = getHeaderViewsCount();
        this.s.drop(this.m - i1, this.i - i1);
      }
    }
    k();
    e();
    b();
    h();
    if (this.T)
    {
      this.v = 3;
      return;
    }
    this.v = 0;
  }
  
  private void d()
  {
    b(this.m - getHeaderViewsCount());
  }
  
  private void d(int paramInt, View paramView, boolean paramBoolean)
  {
    this.af = true;
    j();
    int i1 = this.j;
    int i2 = this.k;
    boolean bool = a();
    if (bool)
    {
      h();
      i1 = a(paramInt, paramView, i1, i2);
      setSelectionFromTop(paramInt, paramView.getTop() + i1 - getPaddingTop());
      layoutChildren();
    }
    if ((bool) || (paramBoolean)) {
      invalidate();
    }
    this.af = false;
  }
  
  private void e()
  {
    int i2 = getFirstVisiblePosition();
    if (this.m < i2)
    {
      int i1 = 0;
      View localView = getChildAt(0);
      if (localView != null) {
        i1 = localView.getTop();
      }
      setSelectionFromTop(i2 - 1, i1 - getPaddingTop());
    }
  }
  
  private void f()
  {
    this.W = 0;
    this.T = false;
    if (this.v == 3) {
      this.v = 0;
    }
    this.h = this.g;
    this.am = false;
    this.ah.clear();
  }
  
  private void g()
  {
    int i1 = getPaddingTop();
    int i2 = getHeight() - i1 - getPaddingBottom();
    float f2 = i2;
    float f1 = i1;
    this.H = (this.C * f2 + f1);
    this.G = ((1.0F - this.D) * f2 + f1);
    f2 = this.H;
    this.E = ((int)f2);
    float f3 = this.G;
    this.F = ((int)f3);
    this.I = (f2 - f1);
    this.J = (i1 + i2 - f3);
  }
  
  private void h()
  {
    int i2 = getFirstVisiblePosition();
    int i3 = getLastVisiblePosition();
    int i1 = Math.max(0, getHeaderViewsCount() - i2);
    i3 = Math.min(i3 - i2, getCount() - 1 - getFooterViewsCount() - i2);
    while (i1 <= i3)
    {
      View localView = getChildAt(i1);
      if (localView != null) {
        a(i2 + i1, localView, false);
      }
      i1 += 1;
    }
  }
  
  private void i()
  {
    View localView = this.a;
    if (localView != null)
    {
      a(localView);
      this.x = this.a.getMeasuredHeight();
      this.y = (this.x / 2);
    }
  }
  
  private void j()
  {
    if (this.U != null)
    {
      this.c.set(this.M, this.N);
      this.U.onDragFloatView(this.a, this.b, this.c);
    }
    int i1 = this.b.x;
    int i4 = this.b.y;
    int i2 = getPaddingLeft();
    if (((this.R & 0x1) == 0) && (i1 > i2)) {
      this.b.x = i2;
    } else if (((this.R & 0x2) == 0) && (i1 < i2)) {
      this.b.x = i2;
    }
    i2 = getHeaderViewsCount();
    int i3 = getFooterViewsCount();
    int i5 = getFirstVisiblePosition();
    int i6 = getLastVisiblePosition();
    i1 = getPaddingTop();
    if (i5 < i2) {
      i1 = getChildAt(i2 - i5 - 1).getBottom();
    }
    i2 = i1;
    int i7;
    if ((this.R & 0x8) == 0)
    {
      i7 = this.m;
      i2 = i1;
      if (i5 <= i7) {
        i2 = Math.max(getChildAt(i7 - i5).getTop(), i1);
      }
    }
    i1 = getHeight() - getPaddingBottom();
    if (i6 >= getCount() - i3 - 1) {
      i1 = getChildAt(getCount() - i3 - 1 - i5).getBottom();
    }
    i3 = i1;
    if ((this.R & 0x4) == 0)
    {
      i7 = this.m;
      i3 = i1;
      if (i6 >= i7) {
        i3 = Math.min(getChildAt(i7 - i5).getBottom(), i1);
      }
    }
    if (i4 < i2)
    {
      this.b.y = i2;
    }
    else
    {
      i1 = this.x;
      if (i4 + i1 > i3) {
        this.b.y = (i3 - i1);
      }
    }
    this.d = (this.b.y + this.y);
  }
  
  private void k()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      ((View)localObject).setVisibility(8);
      localObject = this.U;
      if (localObject != null) {
        ((DragSortListView.FloatViewManager)localObject).onDestroyFloatView(this.a);
      }
      this.a = null;
      invalidate();
    }
  }
  
  protected boolean a(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3) {
          return true;
        }
        if (this.v == 4) {
          cancelDrag();
        }
        f();
        return true;
      }
      b((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      return true;
    }
    if (this.v == 4) {
      stopDrag(false);
    }
    f();
    return true;
  }
  
  public void cancelDrag()
  {
    if (this.v == 4)
    {
      this.B.stopScrolling(true);
      k();
      b();
      h();
      if (this.T)
      {
        this.v = 3;
        return;
      }
      this.v = 0;
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    int i1;
    if (this.v != 0)
    {
      i1 = this.j;
      if (i1 != this.m) {
        a(i1, paramCanvas);
      }
      i1 = this.k;
      if ((i1 != this.j) && (i1 != this.m)) {
        a(i1, paramCanvas);
      }
    }
    View localView = this.a;
    if (localView != null)
    {
      int i3 = localView.getWidth();
      int i4 = this.a.getHeight();
      int i2 = this.b.x;
      int i5 = getWidth();
      i1 = i2;
      if (i2 < 0) {
        i1 = -i2;
      }
      float f1;
      if (i1 < i5)
      {
        f1 = (i5 - i1) / i5;
        f1 *= f1;
      }
      else
      {
        f1 = 0.0F;
      }
      i1 = (int)(this.h * 255.0F * f1);
      paramCanvas.save();
      paramCanvas.translate(this.b.x, this.b.y);
      paramCanvas.clipRect(0, 0, i3, i4);
      paramCanvas.saveLayerAlpha(0.0F, 0.0F, i3, i4, i1, 31);
      this.a.draw(paramCanvas);
      paramCanvas.restore();
      paramCanvas.restore();
    }
  }
  
  public float getFloatAlpha()
  {
    return this.h;
  }
  
  public ListAdapter getInputAdapter()
  {
    DragSortListView.AdapterWrapper localAdapterWrapper = this.ac;
    if (localAdapterWrapper == null) {
      return null;
    }
    return localAdapterWrapper.getAdapter();
  }
  
  public boolean isDragEnabled()
  {
    return this.u;
  }
  
  protected void layoutChildren()
  {
    super.layoutChildren();
    View localView = this.a;
    if (localView != null)
    {
      if ((localView.isLayoutRequested()) && (!this.e)) {
        i();
      }
      localView = this.a;
      localView.layout(0, 0, localView.getMeasuredWidth(), this.a.getMeasuredHeight());
      this.e = false;
    }
  }
  
  public boolean listViewIntercepted()
  {
    return this.am;
  }
  
  public void moveCheckState(int paramInt1, int paramInt2)
  {
    SparseBooleanArray localSparseBooleanArray = getCheckedItemPositions();
    if (localSparseBooleanArray == null) {
      return;
    }
    int i1;
    if (paramInt2 < paramInt1)
    {
      i2 = paramInt1;
      i1 = paramInt2;
    }
    else
    {
      i1 = paramInt1;
      i2 = paramInt2;
    }
    int i3 = i2 + 1;
    int[] arrayOfInt1 = new int[localSparseBooleanArray.size()];
    int[] arrayOfInt2 = new int[localSparseBooleanArray.size()];
    int i2 = a(localSparseBooleanArray, i1, i3, arrayOfInt1, arrayOfInt2);
    if ((i2 == 1) && (arrayOfInt1[0] == arrayOfInt2[0])) {
      return;
    }
    if (paramInt1 < paramInt2)
    {
      paramInt1 = 0;
      while (paramInt1 != i2)
      {
        setItemChecked(a(arrayOfInt1[paramInt1], -1, i1, i3), true);
        setItemChecked(a(arrayOfInt2[paramInt1], -1, i1, i3), false);
        paramInt1 += 1;
      }
    }
    paramInt1 = 0;
    while (paramInt1 != i2)
    {
      setItemChecked(arrayOfInt1[paramInt1], false);
      setItemChecked(arrayOfInt2[paramInt1], true);
      paramInt1 += 1;
    }
  }
  
  public void moveItem(int paramInt1, int paramInt2)
  {
    if (this.s != null)
    {
      int i1;
      if (getInputAdapter() == null) {
        i1 = 0;
      } else {
        i1 = getInputAdapter().getCount();
      }
      if ((paramInt1 >= 0) && (paramInt1 < i1) && (paramInt2 >= 0) && (paramInt2 < i1)) {
        this.s.drop(paramInt1, paramInt2);
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.ad) {
      this.ae.appendState();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.u) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    b(paramMotionEvent);
    this.S = true;
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 == 0)
    {
      if (this.v != 0)
      {
        this.ag = true;
        return true;
      }
      this.T = true;
    }
    boolean bool;
    if (this.a != null)
    {
      bool = true;
    }
    else
    {
      if (super.onInterceptTouchEvent(paramMotionEvent))
      {
        this.am = true;
        bool = true;
      }
      else
      {
        bool = false;
      }
      if ((i1 != 1) && (i1 != 3))
      {
        if (bool) {
          this.W = 1;
        } else {
          this.W = 2;
        }
      }
      else {
        f();
      }
    }
    if ((i1 == 1) || (i1 == 3)) {
      this.T = false;
    }
    return bool;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    View localView = this.a;
    if (localView != null)
    {
      if (localView.isLayoutRequested()) {
        i();
      }
      this.e = true;
    }
    this.z = paramInt1;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    g();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = this.ag;
    boolean bool2 = false;
    if (bool1)
    {
      this.ag = false;
      return false;
    }
    if (!this.u) {
      return super.onTouchEvent(paramMotionEvent);
    }
    bool1 = this.S;
    this.S = false;
    if (!bool1) {
      b(paramMotionEvent);
    }
    int i1 = this.v;
    if (i1 == 4)
    {
      a(paramMotionEvent);
      return true;
    }
    bool1 = bool2;
    if (i1 == 0)
    {
      bool1 = bool2;
      if (super.onTouchEvent(paramMotionEvent)) {
        bool1 = true;
      }
    }
    i1 = paramMotionEvent.getAction() & 0xFF;
    if ((i1 != 1) && (i1 != 3))
    {
      if (bool1)
      {
        this.W = 1;
        return bool1;
      }
    }
    else {
      f();
    }
    return bool1;
  }
  
  public void removeCheckState(int paramInt)
  {
    SparseBooleanArray localSparseBooleanArray = getCheckedItemPositions();
    if (localSparseBooleanArray != null)
    {
      if (localSparseBooleanArray.size() == 0) {
        return;
      }
      int[] arrayOfInt1 = new int[localSparseBooleanArray.size()];
      int[] arrayOfInt2 = new int[localSparseBooleanArray.size()];
      int i2 = localSparseBooleanArray.keyAt(localSparseBooleanArray.size() - 1) + 1;
      int i3 = a(localSparseBooleanArray, paramInt, i2, arrayOfInt1, arrayOfInt2);
      int i1 = 0;
      while (i1 != i3)
      {
        if ((arrayOfInt1[i1] != paramInt) && ((arrayOfInt2[i1] >= arrayOfInt1[i1]) || (arrayOfInt2[i1] <= paramInt))) {
          setItemChecked(a(arrayOfInt1[i1], -1, paramInt, i2), true);
        }
        setItemChecked(a(arrayOfInt2[i1], -1, paramInt, i2), false);
        i1 += 1;
      }
    }
  }
  
  public void removeItem(int paramInt)
  {
    this.ak = false;
    removeItem(paramInt, 0.0F);
  }
  
  public void removeItem(int paramInt, float paramFloat)
  {
    int i1 = this.v;
    if ((i1 == 0) || (i1 == 4))
    {
      if (this.v == 0)
      {
        this.m = (getHeaderViewsCount() + paramInt);
        i1 = this.m;
        this.j = i1;
        this.k = i1;
        this.i = i1;
        localObject = getChildAt(i1 - getFirstVisiblePosition());
        if (localObject != null) {
          ((View)localObject).setVisibility(4);
        }
      }
      this.v = 1;
      this.al = paramFloat;
      if (this.T)
      {
        i1 = this.W;
        if (i1 != 1)
        {
          if (i1 == 2) {
            super.onInterceptTouchEvent(this.V);
          }
        }
        else {
          super.onTouchEvent(this.V);
        }
      }
      Object localObject = this.ai;
      if (localObject != null)
      {
        ((DragSortListView.RemoveAnimator)localObject).start();
        return;
      }
      b(paramInt);
    }
  }
  
  public void requestLayout()
  {
    if (!this.af) {
      super.requestLayout();
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (paramListAdapter != null)
    {
      this.ac = new DragSortListView.AdapterWrapper(this, paramListAdapter, null);
      paramListAdapter.registerDataSetObserver(this.f);
      if ((paramListAdapter instanceof DragSortListView.DropListener)) {
        setDropListener((DragSortListView.DropListener)paramListAdapter);
      }
      if ((paramListAdapter instanceof DragSortListView.DragListener)) {
        setDragListener((DragSortListView.DragListener)paramListAdapter);
      }
      if ((paramListAdapter instanceof DragSortListView.RemoveListener)) {
        setRemoveListener((DragSortListView.RemoveListener)paramListAdapter);
      }
    }
    else
    {
      this.ac = null;
    }
    super.setAdapter(this.ac);
  }
  
  public void setDragEnabled(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  public void setDragListener(DragSortListView.DragListener paramDragListener)
  {
    this.r = paramDragListener;
  }
  
  public void setDragScrollProfile(DragSortListView.DragScrollProfile paramDragScrollProfile)
  {
    if (paramDragScrollProfile != null) {
      this.L = paramDragScrollProfile;
    }
  }
  
  public void setDragScrollStart(float paramFloat)
  {
    setDragScrollStarts(paramFloat, paramFloat);
  }
  
  public void setDragScrollStarts(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 > 0.5F) {
      this.D = 0.5F;
    } else {
      this.D = paramFloat2;
    }
    if (paramFloat1 > 0.5F) {
      this.C = 0.5F;
    } else {
      this.C = paramFloat1;
    }
    if (getHeight() != 0) {
      g();
    }
  }
  
  public void setDragSortListener(DragSortListView.DragSortListener paramDragSortListener)
  {
    setDropListener(paramDragSortListener);
    setDragListener(paramDragSortListener);
    setRemoveListener(paramDragSortListener);
  }
  
  public void setDropListener(DragSortListView.DropListener paramDropListener)
  {
    this.s = paramDropListener;
  }
  
  public void setFloatAlpha(float paramFloat)
  {
    this.h = paramFloat;
  }
  
  public void setFloatViewManager(DragSortListView.FloatViewManager paramFloatViewManager)
  {
    this.U = paramFloatViewManager;
  }
  
  public void setMaxScrollSpeed(float paramFloat)
  {
    this.K = paramFloat;
  }
  
  public void setRemoveListener(DragSortListView.RemoveListener paramRemoveListener)
  {
    this.t = paramRemoveListener;
  }
  
  public boolean startDrag(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.T)
    {
      Object localObject = this.U;
      if (localObject == null) {
        return false;
      }
      localObject = ((DragSortListView.FloatViewManager)localObject).onCreateFloatView(paramInt1);
      if (localObject == null) {
        return false;
      }
      return startDrag(paramInt1, (View)localObject, paramInt2, paramInt3, paramInt4);
    }
    return false;
  }
  
  public boolean startDrag(int paramInt1, View paramView, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.v == 0) && (this.T) && (this.a == null) && (paramView != null))
    {
      if (!this.u) {
        return false;
      }
      if (getParent() != null) {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      paramInt1 += getHeaderViewsCount();
      this.j = paramInt1;
      this.k = paramInt1;
      this.m = paramInt1;
      this.i = paramInt1;
      this.v = 4;
      this.R = 0;
      this.R = (paramInt2 | this.R);
      this.a = paramView;
      i();
      this.n = paramInt3;
      this.o = paramInt4;
      paramInt1 = this.N;
      this.Q = paramInt1;
      paramView = this.b;
      paramView.x = (this.M - this.n);
      paramView.y = (paramInt1 - this.o);
      paramView = getChildAt(this.m - getFirstVisiblePosition());
      if (paramView != null) {
        paramView.setVisibility(4);
      }
      if (this.ad) {
        this.ae.startTracking();
      }
      paramInt1 = this.W;
      if (paramInt1 != 1)
      {
        if (paramInt1 == 2) {
          super.onInterceptTouchEvent(this.V);
        }
      }
      else {
        super.onTouchEvent(this.V);
      }
      requestLayout();
      return true;
    }
    return false;
  }
  
  public boolean stopDrag(boolean paramBoolean)
  {
    this.ak = false;
    return stopDrag(paramBoolean, 0.0F);
  }
  
  public boolean stopDrag(boolean paramBoolean, float paramFloat)
  {
    if (this.a != null)
    {
      this.B.stopScrolling(true);
      if (paramBoolean)
      {
        removeItem(this.m - getHeaderViewsCount(), paramFloat);
      }
      else
      {
        DragSortListView.DropAnimator localDropAnimator = this.aj;
        if (localDropAnimator != null) {
          localDropAnimator.start();
        } else {
          c();
        }
      }
      if (this.ad) {
        this.ae.stopTracking();
      }
      return true;
    }
    return false;
  }
  
  public boolean stopDragWithVelocity(boolean paramBoolean, float paramFloat)
  {
    this.ak = true;
    return stopDrag(paramBoolean, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView
 * JD-Core Version:    0.7.0.1
 */