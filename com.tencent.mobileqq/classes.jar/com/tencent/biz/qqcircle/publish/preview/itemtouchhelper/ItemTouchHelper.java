package com.tencent.biz.qqcircle.publish.preview.itemtouchhelper;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ChildDrawingOrderCallback;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener;
import androidx.recyclerview.widget.RecyclerView.OnItemTouchListener;
import androidx.recyclerview.widget.RecyclerView.State;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.List;

public class ItemTouchHelper
  extends RecyclerView.ItemDecoration
  implements RecyclerView.OnChildAttachStateChangeListener
{
  private final RecyclerView.OnItemTouchListener A = new ItemTouchHelper.2(this);
  private Rect B;
  private long C;
  final List<View> a = new ArrayList();
  RecyclerView.ViewHolder b = null;
  float c;
  float d;
  float e;
  float f;
  float g;
  float h;
  float i;
  float j;
  int k = -1;
  ItemTouchHelper.Callback l;
  int m = 0;
  int n;
  List<ItemTouchHelper.RecoverAnimation> o = new ArrayList();
  RecyclerView p;
  final Runnable q = new ItemTouchHelper.1(this);
  VelocityTracker r;
  View s = null;
  int t = -1;
  GestureDetectorCompat u;
  private final float[] v = new float[2];
  private int w;
  private List<RecyclerView.ViewHolder> x;
  private List<Integer> y;
  private RecyclerView.ChildDrawingOrderCallback z = null;
  
  public ItemTouchHelper(ItemTouchHelper.Callback paramCallback)
  {
    this.l = paramCallback;
  }
  
  private void a(float[] paramArrayOfFloat)
  {
    if ((this.n & 0xC) != 0) {
      paramArrayOfFloat[0] = (this.i + this.g - this.b.itemView.getLeft());
    } else {
      paramArrayOfFloat[0] = this.b.itemView.getTranslationX();
    }
    if ((this.n & 0x3) != 0)
    {
      paramArrayOfFloat[1] = (this.j + this.h - this.b.itemView.getTop());
      return;
    }
    paramArrayOfFloat[1] = this.b.itemView.getTranslationY();
  }
  
  private static boolean a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (paramFloat1 >= paramFloat3) && (paramFloat1 <= paramFloat3 + paramView.getWidth()) && (paramFloat2 >= paramFloat4) && (paramFloat2 <= paramFloat4 + paramView.getHeight());
  }
  
  private int b(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramInt & 0xC) != 0)
    {
      float f1 = this.g;
      int i2 = 8;
      int i1;
      if (f1 > 0.0F) {
        i1 = 8;
      } else {
        i1 = 4;
      }
      VelocityTracker localVelocityTracker = this.r;
      if ((localVelocityTracker != null) && (this.k > -1))
      {
        localVelocityTracker.computeCurrentVelocity(1000, this.l.d(this.f));
        f2 = this.r.getXVelocity(this.k);
        f1 = this.r.getYVelocity(this.k);
        if (f2 <= 0.0F) {
          i2 = 4;
        }
        f2 = Math.abs(f2);
        if (((i2 & paramInt) != 0) && (i1 == i2) && (f2 >= this.l.c(this.e)) && (f2 > Math.abs(f1))) {
          return i2;
        }
      }
      f1 = this.p.getWidth();
      float f2 = this.l.a(paramViewHolder);
      if (((paramInt & i1) != 0) && (Math.abs(this.g) > f1 * f2)) {
        return i1;
      }
    }
    return 0;
  }
  
  private List<RecyclerView.ViewHolder> b(RecyclerView.ViewHolder paramViewHolder)
  {
    Object localObject1 = paramViewHolder;
    Object localObject2 = this.x;
    if (localObject2 == null)
    {
      this.x = new ArrayList();
      this.y = new ArrayList();
    }
    else
    {
      ((List)localObject2).clear();
      this.y.clear();
    }
    int i2 = this.l.c();
    int i4 = Math.round(this.i + this.g) - i2;
    int i5 = Math.round(this.j + this.h) - i2;
    int i1 = ((RecyclerView.ViewHolder)localObject1).itemView.getWidth();
    i2 *= 2;
    int i6 = i1 + i4 + i2;
    int i7 = ((RecyclerView.ViewHolder)localObject1).itemView.getHeight() + i5 + i2;
    int i8 = (i4 + i6) / 2;
    int i9 = (i5 + i7) / 2;
    localObject1 = this.p.getLayoutManager();
    int i10 = ((RecyclerView.LayoutManager)localObject1).getChildCount();
    i1 = 0;
    while (i1 < i10)
    {
      localObject2 = ((RecyclerView.LayoutManager)localObject1).getChildAt(i1);
      if ((localObject2 != paramViewHolder.itemView) && (((View)localObject2).getBottom() >= i5) && (((View)localObject2).getTop() <= i7) && (((View)localObject2).getRight() >= i4) && (((View)localObject2).getLeft() <= i6))
      {
        RecyclerView.ViewHolder localViewHolder = this.p.getChildViewHolder((View)localObject2);
        if (this.l.b(this.p, this.b, localViewHolder))
        {
          i2 = Math.abs(i8 - (((View)localObject2).getLeft() + ((View)localObject2).getRight()) / 2);
          int i3 = Math.abs(i9 - (((View)localObject2).getTop() + ((View)localObject2).getBottom()) / 2);
          int i11 = i2 * i2 + i3 * i3;
          int i12 = this.x.size();
          i2 = 0;
          i3 = 0;
          while ((i2 < i12) && (i11 > ((Integer)this.y.get(i2)).intValue()))
          {
            i3 += 1;
            i2 += 1;
          }
          this.x.add(i3, localViewHolder);
          this.y.add(i3, Integer.valueOf(i11));
        }
      }
      i1 += 1;
    }
    return this.x;
  }
  
  private int c(RecyclerView.ViewHolder paramViewHolder)
  {
    if (this.m == 2) {
      return 0;
    }
    int i2 = this.l.a(this.p, paramViewHolder);
    int i1 = (this.l.d(i2, ViewCompat.getLayoutDirection(this.p)) & 0xFF00) >> 8;
    if (i1 == 0) {
      return 0;
    }
    int i3 = (i2 & 0xFF00) >> 8;
    if (Math.abs(this.g) > Math.abs(this.h))
    {
      i2 = b(paramViewHolder, i1);
      if (i2 > 0)
      {
        if ((i3 & i2) == 0) {
          return ItemTouchHelper.Callback.a(i2, ViewCompat.getLayoutDirection(this.p));
        }
        return i2;
      }
      i1 = c(paramViewHolder, i1);
      if (i1 > 0) {
        return i1;
      }
    }
    else
    {
      i2 = c(paramViewHolder, i1);
      if (i2 > 0) {
        return i2;
      }
      i2 = b(paramViewHolder, i1);
      if (i2 > 0)
      {
        i1 = i2;
        if ((i3 & i2) == 0) {
          i1 = ItemTouchHelper.Callback.a(i2, ViewCompat.getLayoutDirection(this.p));
        }
        return i1;
      }
    }
    return 0;
  }
  
  private int c(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramInt & 0x3) != 0)
    {
      float f1 = this.h;
      int i2 = 2;
      int i1;
      if (f1 > 0.0F) {
        i1 = 2;
      } else {
        i1 = 1;
      }
      VelocityTracker localVelocityTracker = this.r;
      if ((localVelocityTracker != null) && (this.k > -1))
      {
        localVelocityTracker.computeCurrentVelocity(1000, this.l.d(this.f));
        f1 = this.r.getXVelocity(this.k);
        f2 = this.r.getYVelocity(this.k);
        if (f2 <= 0.0F) {
          i2 = 1;
        }
        f2 = Math.abs(f2);
        if (((i2 & paramInt) != 0) && (i2 == i1) && (f2 >= this.l.c(this.e)) && (f2 > Math.abs(f1))) {
          return i2;
        }
      }
      f1 = this.p.getHeight();
      float f2 = this.l.a(paramViewHolder);
      if (((paramInt & i1) != 0) && (Math.abs(this.h) > f1 * f2)) {
        return i1;
      }
    }
    return 0;
  }
  
  private RecyclerView.ViewHolder c(MotionEvent paramMotionEvent)
  {
    RecyclerView.LayoutManager localLayoutManager = this.p.getLayoutManager();
    int i1 = this.k;
    if (i1 == -1) {
      return null;
    }
    i1 = paramMotionEvent.findPointerIndex(i1);
    float f3 = paramMotionEvent.getX(i1);
    float f4 = this.c;
    float f1 = paramMotionEvent.getY(i1);
    float f2 = this.d;
    f3 = Math.abs(f3 - f4);
    f1 = Math.abs(f1 - f2);
    i1 = this.w;
    if ((f3 < i1) && (f1 < i1)) {
      return null;
    }
    if ((f3 > f1) && (localLayoutManager.canScrollHorizontally())) {
      return null;
    }
    if ((f1 > f3) && (localLayoutManager.canScrollVertically())) {
      return null;
    }
    paramMotionEvent = a(paramMotionEvent);
    if (paramMotionEvent == null) {
      return null;
    }
    return this.p.getChildViewHolder(paramMotionEvent);
  }
  
  private void d()
  {
    this.w = ViewConfiguration.get(this.p.getContext()).getScaledTouchSlop();
    this.p.addItemDecoration(this);
    this.p.addOnItemTouchListener(this.A);
    this.p.addOnChildAttachStateChangeListener(this);
    f();
  }
  
  private void e()
  {
    this.p.removeItemDecoration(this);
    this.p.removeOnItemTouchListener(this.A);
    this.p.removeOnChildAttachStateChangeListener(this);
    int i1 = this.o.size() - 1;
    while (i1 >= 0)
    {
      ItemTouchHelper.RecoverAnimation localRecoverAnimation = (ItemTouchHelper.RecoverAnimation)this.o.get(0);
      this.l.b(this.p, localRecoverAnimation.h);
      i1 -= 1;
    }
    this.o.clear();
    this.s = null;
    this.t = -1;
    g();
  }
  
  private void f()
  {
    if (this.u != null) {
      return;
    }
    this.u = new GestureDetectorCompat(this.p.getContext(), new ItemTouchHelper.ItemTouchHelperGestureListener(this));
  }
  
  private void g()
  {
    VelocityTracker localVelocityTracker = this.r;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.r = null;
    }
  }
  
  private void h()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return;
    }
    if (this.z == null) {
      this.z = new ItemTouchHelper.5(this);
    }
    this.p.setChildDrawingOrderCallback(this.z);
  }
  
  int a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    int i1 = this.o.size() - 1;
    while (i1 >= 0)
    {
      ItemTouchHelper.RecoverAnimation localRecoverAnimation = (ItemTouchHelper.RecoverAnimation)this.o.get(i1);
      if (localRecoverAnimation.h == paramViewHolder)
      {
        localRecoverAnimation.n |= paramBoolean;
        if (!localRecoverAnimation.o) {
          localRecoverAnimation.b();
        }
        this.o.remove(i1);
        return localRecoverAnimation.j;
      }
      i1 -= 1;
    }
    return 0;
  }
  
  View a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    paramMotionEvent = this.b;
    if (paramMotionEvent != null)
    {
      paramMotionEvent = paramMotionEvent.itemView;
      if (a(paramMotionEvent, f1, f2, this.i + this.g, this.j + this.h)) {
        return paramMotionEvent;
      }
    }
    int i1 = this.o.size() - 1;
    while (i1 >= 0)
    {
      paramMotionEvent = (ItemTouchHelper.RecoverAnimation)this.o.get(i1);
      View localView = paramMotionEvent.h.itemView;
      if (a(localView, f1, f2, paramMotionEvent.l, paramMotionEvent.m)) {
        return localView;
      }
      i1 -= 1;
    }
    return this.p.findChildViewUnder(f1, f2);
  }
  
  void a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    float f1 = paramMotionEvent.getX(paramInt2);
    float f2 = paramMotionEvent.getY(paramInt2);
    this.g = (f1 - this.c);
    this.h = (f2 - this.d);
    if ((paramInt1 & 0x4) == 0) {
      this.g = Math.max(0.0F, this.g);
    }
    if ((paramInt1 & 0x8) == 0) {
      this.g = Math.min(0.0F, this.g);
    }
    if ((paramInt1 & 0x1) == 0) {
      this.h = Math.max(0.0F, this.h);
    }
    if ((paramInt1 & 0x2) == 0) {
      this.h = Math.min(0.0F, this.h);
    }
  }
  
  void a(View paramView)
  {
    if (paramView == this.s)
    {
      this.s = null;
      if (this.z != null) {
        this.p.setChildDrawingOrderCallback(null);
      }
    }
  }
  
  void a(RecyclerView.ViewHolder paramViewHolder)
  {
    if (this.p.isLayoutRequested()) {
      return;
    }
    if (this.m != 2) {
      return;
    }
    float f1 = this.l.b(paramViewHolder);
    int i1 = (int)(this.i + this.g);
    int i2 = (int)(this.j + this.h);
    if ((Math.abs(i2 - paramViewHolder.itemView.getTop()) < paramViewHolder.itemView.getHeight() * f1) && (Math.abs(i1 - paramViewHolder.itemView.getLeft()) < paramViewHolder.itemView.getWidth() * f1)) {
      return;
    }
    Object localObject = b(paramViewHolder);
    if (((List)localObject).size() == 0) {
      return;
    }
    localObject = this.l.a(paramViewHolder, (List)localObject, i1, i2);
    if (localObject == null)
    {
      this.x.clear();
      this.y.clear();
      return;
    }
    int i3 = ((RecyclerView.ViewHolder)localObject).getAdapterPosition();
    int i4 = paramViewHolder.getAdapterPosition();
    if (this.l.a(this.p, paramViewHolder, (RecyclerView.ViewHolder)localObject)) {
      this.l.a(this.p, paramViewHolder, i4, (RecyclerView.ViewHolder)localObject, i3, i1, i2);
    }
  }
  
  void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder == this.b) && (paramInt == this.m)) {
      return;
    }
    this.C = -9223372036854775808L;
    int i3 = this.m;
    a(paramViewHolder, true);
    this.m = paramInt;
    if (paramInt == 2)
    {
      this.s = paramViewHolder.itemView;
      h();
    }
    Object localObject = this.b;
    int i1;
    if (localObject != null)
    {
      if (((RecyclerView.ViewHolder)localObject).itemView.getParent() != null)
      {
        int i2;
        if (i3 == 2) {
          i2 = 0;
        } else {
          i2 = c((RecyclerView.ViewHolder)localObject);
        }
        g();
        if ((i2 != 1) && (i2 != 2))
        {
          if ((i2 != 4) && (i2 != 8) && (i2 != 16) && (i2 != 32)) {}
          for (f1 = 0.0F;; f1 = Math.signum(this.g) * this.p.getWidth())
          {
            f2 = 0.0F;
            break;
          }
        }
        float f2 = Math.signum(this.h) * this.p.getHeight();
        float f1 = 0.0F;
        if (i3 == 2) {
          i1 = 8;
        } else if (i2 > 0) {
          i1 = 2;
        } else {
          i1 = 4;
        }
        a(this.v);
        float[] arrayOfFloat = this.v;
        float f3 = arrayOfFloat[0];
        float f4 = arrayOfFloat[1];
        localObject = new ItemTouchHelper.3(this, (RecyclerView.ViewHolder)localObject, i1, i3, f3, f4, f1, f2, i2, (RecyclerView.ViewHolder)localObject);
        ((ItemTouchHelper.RecoverAnimation)localObject).a(this.l.a(this.p, i1, f1 - f3, f2 - f4));
        this.o.add(localObject);
        ((ItemTouchHelper.RecoverAnimation)localObject).a();
        i1 = 1;
      }
      else
      {
        a(((RecyclerView.ViewHolder)localObject).itemView);
        this.l.b(this.p, (RecyclerView.ViewHolder)localObject);
        i1 = 0;
      }
      this.b = null;
    }
    else
    {
      i1 = 0;
    }
    if (paramViewHolder != null)
    {
      this.n = ((this.l.c(this.p, paramViewHolder) & (1 << paramInt * 8 + 8) - 1) >> this.m * 8);
      this.i = paramViewHolder.itemView.getLeft();
      this.j = paramViewHolder.itemView.getTop();
      this.b = paramViewHolder;
      if (paramInt == 2) {
        this.b.itemView.performHapticFeedback(0);
      }
    }
    boolean bool = false;
    paramViewHolder = this.p.getParent();
    if (paramViewHolder != null)
    {
      if (this.b != null) {
        bool = true;
      }
      paramViewHolder.requestDisallowInterceptTouchEvent(bool);
    }
    if (i1 == 0) {
      this.p.getLayoutManager().requestSimpleAnimationsInNextLayout();
    }
    this.l.b(this.b, this.m);
    this.p.invalidate();
  }
  
  public void a(@Nullable RecyclerView paramRecyclerView)
  {
    RecyclerView localRecyclerView = this.p;
    if (localRecyclerView == paramRecyclerView) {
      return;
    }
    if (localRecyclerView != null) {
      e();
    }
    this.p = paramRecyclerView;
    if (this.p != null)
    {
      paramRecyclerView = paramRecyclerView.getResources();
      this.e = paramRecyclerView.getDimension(2131297707);
      this.f = paramRecyclerView.getDimension(2131297706);
      d();
    }
  }
  
  void a(ItemTouchHelper.RecoverAnimation paramRecoverAnimation, int paramInt)
  {
    this.p.post(new ItemTouchHelper.4(this, paramRecoverAnimation, paramInt));
  }
  
  boolean a()
  {
    int i2 = this.o.size();
    int i1 = 0;
    while (i1 < i2)
    {
      if (!((ItemTouchHelper.RecoverAnimation)this.o.get(i1)).o) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  boolean a(int paramInt1, MotionEvent paramMotionEvent, int paramInt2)
  {
    if ((this.b == null) && (paramInt1 == 2) && (this.m != 2))
    {
      if (!this.l.b()) {
        return false;
      }
      if (this.p.getScrollState() == 1) {
        return false;
      }
      RecyclerView.ViewHolder localViewHolder = c(paramMotionEvent);
      if (localViewHolder == null) {
        return false;
      }
      paramInt1 = (this.l.c(this.p, localViewHolder) & 0xFF00) >> 8;
      if (paramInt1 == 0) {
        return false;
      }
      float f1 = paramMotionEvent.getX(paramInt2);
      float f2 = paramMotionEvent.getY(paramInt2);
      f1 -= this.c;
      f2 -= this.d;
      float f3 = Math.abs(f1);
      float f4 = Math.abs(f2);
      paramInt2 = this.w;
      if ((f3 < paramInt2) && (f4 < paramInt2)) {
        return false;
      }
      if (f3 > f4)
      {
        if ((f1 < 0.0F) && ((paramInt1 & 0x4) == 0)) {
          return false;
        }
        if ((f1 > 0.0F) && ((paramInt1 & 0x8) == 0)) {
          return false;
        }
      }
      else
      {
        if ((f2 < 0.0F) && ((paramInt1 & 0x1) == 0)) {
          return false;
        }
        if ((f2 > 0.0F) && ((paramInt1 & 0x2) == 0)) {
          return false;
        }
      }
      this.h = 0.0F;
      this.g = 0.0F;
      this.k = paramMotionEvent.getPointerId(0);
      a(localViewHolder, 1);
      return true;
    }
    return false;
  }
  
  ItemTouchHelper.RecoverAnimation b(MotionEvent paramMotionEvent)
  {
    if (this.o.isEmpty()) {
      return null;
    }
    paramMotionEvent = a(paramMotionEvent);
    int i1 = this.o.size() - 1;
    while (i1 >= 0)
    {
      ItemTouchHelper.RecoverAnimation localRecoverAnimation = (ItemTouchHelper.RecoverAnimation)this.o.get(i1);
      if (localRecoverAnimation.h.itemView == paramMotionEvent) {
        return localRecoverAnimation;
      }
      i1 -= 1;
    }
    return null;
  }
  
  boolean b()
  {
    if (this.b == null)
    {
      this.C = -9223372036854775808L;
      return false;
    }
    long l2 = System.currentTimeMillis();
    long l1 = this.C;
    if (l1 == -9223372036854775808L) {
      l1 = 0L;
    } else {
      l1 = l2 - l1;
    }
    RecyclerView.LayoutManager localLayoutManager = this.p.getLayoutManager();
    if (this.B == null) {
      this.B = new Rect();
    }
    localLayoutManager.calculateItemDecorationsForChild(this.b.itemView, this.B);
    if (localLayoutManager.canScrollHorizontally())
    {
      i2 = (int)(this.i + this.g);
      i1 = i2 - this.B.left - this.p.getPaddingLeft();
      if ((this.g < 0.0F) && (i1 < 0)) {
        break label200;
      }
      if (this.g > 0.0F)
      {
        i1 = i2 + this.b.itemView.getWidth() + this.B.right - (this.p.getWidth() - this.p.getPaddingRight());
        if (i1 > 0) {
          break label200;
        }
      }
    }
    int i1 = 0;
    label200:
    if (localLayoutManager.canScrollVertically())
    {
      i3 = (int)(this.j + this.h);
      i2 = i3 - this.B.top - this.p.getPaddingTop();
      if ((this.h < 0.0F) && (i2 < 0)) {
        break label308;
      }
      if (this.h > 0.0F)
      {
        i2 = i3 + this.b.itemView.getHeight() + this.B.bottom - (this.p.getHeight() - this.p.getPaddingBottom());
        if (i2 > 0) {
          break label308;
        }
      }
    }
    int i2 = 0;
    label308:
    int i3 = i1;
    if (i1 != 0) {
      i3 = this.l.a(this.p, this.b.itemView.getWidth(), i1, this.p.getWidth(), l1);
    }
    if (i2 != 0) {
      i2 = this.l.a(this.p, this.b.itemView.getHeight(), i2, this.p.getHeight(), l1);
    }
    if ((i3 == 0) && (i2 == 0))
    {
      this.C = -9223372036854775808L;
      return false;
    }
    if (this.C == -9223372036854775808L) {
      this.C = l2;
    }
    this.p.scrollBy(i3, i2);
    return true;
  }
  
  void c()
  {
    VelocityTracker localVelocityTracker = this.r;
    if (localVelocityTracker != null) {
      localVelocityTracker.recycle();
    }
    this.r = VelocityTracker.obtain();
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    paramRect.setEmpty();
  }
  
  public void onChildViewAttachedToWindow(View paramView) {}
  
  public void onChildViewDetachedFromWindow(View paramView)
  {
    a(paramView);
    paramView = this.p.getChildViewHolder(paramView);
    if (paramView == null) {
      return;
    }
    RecyclerView.ViewHolder localViewHolder = this.b;
    if ((localViewHolder != null) && (paramView == localViewHolder))
    {
      a(null, 0);
      return;
    }
    a(paramView, false);
    if (this.a.remove(paramView.itemView)) {
      this.l.b(this.p, paramView);
    }
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    this.t = -1;
    float f1;
    float f2;
    if (this.b != null)
    {
      a(this.v);
      paramState = this.v;
      f1 = paramState[0];
      f2 = paramState[1];
    }
    else
    {
      f1 = 0.0F;
      f2 = 0.0F;
    }
    this.l.a(paramCanvas, paramRecyclerView, this.b, this.o, this.m, f1, f2);
  }
  
  public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    float f1;
    float f2;
    if (this.b != null)
    {
      a(this.v);
      paramState = this.v;
      f1 = paramState[0];
      f2 = paramState[1];
    }
    else
    {
      f1 = 0.0F;
      f2 = 0.0F;
    }
    this.l.b(paramCanvas, paramRecyclerView, this.b, this.o, this.m, f1, f2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.preview.itemtouchhelper.ItemTouchHelper
 * JD-Core Version:    0.7.0.1
 */