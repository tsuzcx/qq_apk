package com.tencent.aelight.camera.ae.camera.ui.bottom;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.aelight.camera.ae.camera.ui.Direction;
import com.tencent.aelight.camera.ae.camera.ui.Direction.End;
import com.tencent.aelight.camera.ae.camera.ui.Direction.Start;
import com.tencent.biz.videostory.capture.widgets.RecyclerViewProxy;
import com.tencent.biz.videostory.capture.widgets.VideoStoryScrollItemTransformer;
import java.util.Locale;

public class AEBottomListScrollLayoutManager
  extends RecyclerView.LayoutManager
{
  private RecyclerViewProxy A;
  private AEBottomListScrollView.LayoutCallback B;
  protected Point a;
  protected Point b;
  protected Point c;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  protected int h;
  protected int i;
  protected int j;
  protected int k;
  protected int l;
  protected SparseArray<View> m;
  protected boolean n;
  private DSVOrientation.Helper o;
  private Context p;
  private int q;
  private int r;
  private int s;
  private boolean t;
  private int u;
  private boolean v;
  private int w;
  private int x;
  @NonNull
  private final AEBottomListScrollLayoutManager.ScrollStateListener y;
  private VideoStoryScrollItemTransformer z;
  
  public AEBottomListScrollLayoutManager(@NonNull Context paramContext, @NonNull AEBottomListScrollLayoutManager.ScrollStateListener paramScrollStateListener, @NonNull DSVOrientation paramDSVOrientation)
  {
    this.p = paramContext;
    this.q = 100;
    this.l = -1;
    this.k = -1;
    this.u = 2100;
    this.v = false;
    this.b = new Point();
    this.c = new Point();
    this.a = new Point();
    this.m = new SparseArray();
    this.y = paramScrollStateListener;
    this.o = paramDSVOrientation.a();
    this.A = new RecyclerViewProxy(this);
    this.s = 1;
  }
  
  private float a(View paramView, int paramInt)
  {
    return Math.min(Math.max(-1.0F, this.o.a(this.b, getDecoratedLeft(paramView) + this.d, getDecoratedTop(paramView) + this.e) / paramInt), 1.0F);
  }
  
  private void a(RecyclerView.Recycler paramRecycler, Direction paramDirection, int paramInt)
  {
    int i4 = paramDirection.a(1);
    int i1 = this.l;
    if ((i1 != -1) && (paramDirection.b(i1 - this.k))) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    this.a.set(this.c.x, this.c.y);
    int i2 = this.k;
    int i3;
    do
    {
      for (;;)
      {
        i2 += i4;
        if (!h(i2)) {
          return;
        }
        i3 = i1;
        if (i2 == this.l) {
          i3 = 1;
        }
        this.o.a(paramDirection, this.g, this.a);
        if (!a(this.a, paramInt)) {
          break;
        }
        a(paramRecycler, i2, this.a);
        i1 = i3;
      }
      i1 = i3;
    } while (i3 == 0);
  }
  
  private void a(RecyclerView.State paramState, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < paramState.getItemCount())) {
      return;
    }
    throw new IllegalArgumentException(String.format(Locale.US, "target position out of bounds: position=%d, itemCount=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramState.getItemCount()) }));
  }
  
  private boolean a(Point paramPoint, int paramInt)
  {
    return this.o.a(paramPoint, this.d, this.e, paramInt, this.f);
  }
  
  private void c(RecyclerView.State paramState)
  {
    int i1 = this.k;
    if ((i1 == -1) || (i1 >= paramState.getItemCount())) {
      this.k = 0;
    }
  }
  
  private int d(RecyclerView.State paramState)
  {
    int i1 = e(paramState);
    int i2 = (int)(this.i / this.g * i1);
    return this.k * i1 + i2;
  }
  
  private int e(RecyclerView.State paramState)
  {
    if (getItemCount() == 0) {
      return 0;
    }
    return (int)(f(paramState) / getItemCount());
  }
  
  private void e(int paramInt)
  {
    if (this.k != paramInt)
    {
      this.k = paramInt;
      this.t = true;
    }
  }
  
  private int f(RecyclerView.State paramState)
  {
    if (getItemCount() == 0) {
      return 0;
    }
    return this.g * (getItemCount() - 1);
  }
  
  private void f(int paramInt)
  {
    this.j = (-this.i);
    Direction localDirection = Direction.c(paramInt - this.k);
    int i1 = Math.abs(paramInt - this.k);
    int i2 = this.g;
    this.j += localDirection.a(i1 * i2);
    this.l = paramInt;
    k();
  }
  
  private int g(int paramInt)
  {
    int i1 = this.A.b();
    if ((this.k != 0) && (paramInt < 0)) {
      return 0;
    }
    int i2 = this.k;
    int i3 = i1 - 1;
    if ((i2 != i3) && (paramInt >= i1)) {
      return i3;
    }
    return paramInt;
  }
  
  private boolean h(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < this.A.b());
  }
  
  private boolean i()
  {
    int i1 = this.l;
    if (i1 != -1)
    {
      this.k = i1;
      this.l = -1;
      this.j = 0;
      this.i = 0;
      return true;
    }
    Direction localDirection = Direction.c(this.i);
    if (l())
    {
      int i2 = Math.abs(this.i);
      int i3 = this.g;
      i1 = Math.abs(this.i);
      int i4 = this.g;
      i1 /= i4;
      if (i2 % i3 < i4 * 0.4F)
      {
        i2 = this.k;
        i1 = localDirection.a(i1);
      }
      else
      {
        i2 = this.k;
        i1 = localDirection.a(i1 + 1);
      }
      i1 = i2 + i1;
      if (i1 < 0) {
        i1 = 0;
      } else if (i1 > getItemCount() - 1) {
        i1 = getItemCount() - 1;
      }
      f(i1);
      return false;
    }
    this.j = (-this.i);
    if (this.j != 0)
    {
      k();
      return false;
    }
    return true;
  }
  
  private void j()
  {
    this.l = -1;
    this.j = 0;
  }
  
  private void k()
  {
    if (this.k == -1) {
      return;
    }
    AEBottomListScrollLayoutManager.DiscreteLinearSmoothScroller localDiscreteLinearSmoothScroller = new AEBottomListScrollLayoutManager.DiscreteLinearSmoothScroller(this, this.p);
    localDiscreteLinearSmoothScroller.setTargetPosition(this.k);
    this.A.a(localDiscreteLinearSmoothScroller);
  }
  
  private boolean l()
  {
    return Math.abs(this.i) >= this.g * 0.4F;
  }
  
  private void m()
  {
    int i1;
    if (this.l != -1) {
      i1 = Math.abs(this.i + this.j);
    } else {
      i1 = this.g;
    }
    float f1 = i1;
    f1 = -Math.min(Math.max(-1.0F, this.i / f1), 1.0F);
    this.y.a(f1);
  }
  
  protected int a(int paramInt, RecyclerView.Recycler paramRecycler)
  {
    if (this.A.a() == 0) {
      return 0;
    }
    this.i += paramInt;
    int i1 = this.j;
    if (i1 != 0) {
      this.j = (i1 - paramInt);
    }
    this.o.a(-paramInt, this.A);
    if (this.o.a(this)) {
      b(paramRecycler);
    }
    m();
    b();
    return paramInt;
  }
  
  protected void a()
  {
    this.m.clear();
    int i3 = 0;
    int i1 = 0;
    int i2;
    for (;;)
    {
      i2 = i3;
      if (i1 >= this.A.a()) {
        break;
      }
      View localView = this.A.a(i1);
      this.m.put(this.A.c(localView), localView);
      i1 += 1;
    }
    while (i2 < this.m.size())
    {
      this.A.b((View)this.m.valueAt(i2));
      i2 += 1;
    }
  }
  
  public void a(int paramInt)
  {
    this.q = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i2 = this.o.c(paramInt1, paramInt2);
    if (this.i * i2 >= 0) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt1 == 0)
    {
      c();
      return;
    }
    if (this.v) {
      paramInt1 = Math.abs(i2 / this.u);
    } else {
      paramInt1 = 1;
    }
    Direction localDirection = Direction.c(this.i);
    int i1 = this.k;
    paramInt2 = i1;
    if (l())
    {
      paramInt2 = i1;
      if (this.g != 0)
      {
        paramInt2 = Math.abs(this.i);
        int i3 = this.g;
        int i5 = Math.abs(this.i);
        int i4 = this.g;
        i5 /= i4;
        if (paramInt2 % i3 < i4 * 0.4F) {
          paramInt2 = localDirection.a(i5);
        } else {
          paramInt2 = localDirection.a(i5 + 1);
        }
        paramInt2 = i1 + paramInt2;
      }
    }
    paramInt1 = g(paramInt2 + Direction.c(i2).a(paramInt1));
    if (h(paramInt1))
    {
      f(paramInt1);
      return;
    }
    c();
  }
  
  protected void a(RecyclerView.Recycler paramRecycler)
  {
    View localView = this.A.a(0, paramRecycler);
    int i1 = this.A.d(localView);
    int i2 = this.A.e(localView);
    this.d = (i1 / 2);
    this.e = (i2 / 2);
    this.g = this.o.b(i1, i2);
    this.f = (this.g * this.r);
    this.A.a(localView, paramRecycler);
  }
  
  protected void a(RecyclerView.Recycler paramRecycler, int paramInt, Point paramPoint)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= getItemCount()) {
        return;
      }
      View localView = (View)this.m.get(paramInt);
      if (localView == null)
      {
        paramRecycler = this.A.a(paramInt, paramRecycler);
        this.A.a(paramRecycler, paramPoint.x - this.d, paramPoint.y - this.e, paramPoint.x + this.d, paramPoint.y + this.e);
        return;
      }
      this.A.a(localView);
      this.m.remove(paramInt);
    }
  }
  
  public void a(RecyclerView.State paramState)
  {
    if (this.n)
    {
      this.y.c();
      this.n = false;
      return;
    }
    if (this.t)
    {
      this.y.d();
      this.t = false;
      paramState = this.B;
      if (paramState != null) {
        paramState.l();
      }
    }
  }
  
  protected void a(AEBottomListScrollView.LayoutCallback paramLayoutCallback)
  {
    this.B = paramLayoutCallback;
  }
  
  public void a(DSVOrientation paramDSVOrientation)
  {
    this.o = paramDSVOrientation.a();
    this.A.f();
    this.A.e();
  }
  
  public void a(VideoStoryScrollItemTransformer paramVideoStoryScrollItemTransformer)
  {
    this.z = paramVideoStoryScrollItemTransformer;
  }
  
  public void a(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }
  
  protected void b()
  {
    if (this.z != null)
    {
      int i2 = this.g;
      int i3 = this.s;
      int i1 = 0;
      while (i1 < this.A.a())
      {
        View localView = this.A.a(i1);
        float f1 = a(localView, i2 * i3);
        this.z.a(localView, f1);
        i1 += 1;
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.r = paramInt;
    this.f = (this.g * paramInt);
    this.A.e();
  }
  
  protected void b(RecyclerView.Recycler paramRecycler)
  {
    a();
    this.o.a(this.b, this.i, this.c);
    int i1 = this.o.a(this.A.c(), this.A.d());
    if (a(this.c, i1)) {
      a(paramRecycler, this.k, this.c);
    }
    a(paramRecycler, new Direction.Start(), i1);
    a(paramRecycler, new Direction.End(), i1);
    c(paramRecycler);
  }
  
  protected void b(RecyclerView.State paramState)
  {
    int i1;
    if ((!paramState.isMeasuring()) && ((this.A.c() != this.w) || (this.A.d() != this.x))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      this.w = this.A.c();
      this.x = this.A.d();
      this.A.f();
    }
    this.b.set(this.A.c() / 2, this.A.d() / 2);
  }
  
  public void c()
  {
    this.j = (-this.i);
    if (this.j != 0) {
      k();
    }
  }
  
  public void c(int paramInt)
  {
    this.s = paramInt;
    b();
  }
  
  protected void c(RecyclerView.Recycler paramRecycler)
  {
    int i1 = 0;
    while (i1 < this.m.size())
    {
      View localView = (View)this.m.valueAt(i1);
      this.A.b(localView, paramRecycler);
      i1 += 1;
    }
    this.m.clear();
  }
  
  public boolean canScrollHorizontally()
  {
    return this.o.b();
  }
  
  public boolean canScrollVertically()
  {
    return this.o.a();
  }
  
  public int computeHorizontalScrollExtent(RecyclerView.State paramState)
  {
    return e(paramState);
  }
  
  public int computeHorizontalScrollOffset(RecyclerView.State paramState)
  {
    return d(paramState);
  }
  
  public int computeHorizontalScrollRange(RecyclerView.State paramState)
  {
    return f(paramState);
  }
  
  public int computeVerticalScrollExtent(RecyclerView.State paramState)
  {
    return e(paramState);
  }
  
  public int computeVerticalScrollOffset(RecyclerView.State paramState)
  {
    return d(paramState);
  }
  
  public int computeVerticalScrollRange(RecyclerView.State paramState)
  {
    return f(paramState);
  }
  
  public int d()
  {
    int i1 = this.i;
    if (i1 == 0) {
      return this.k;
    }
    int i2 = this.l;
    if (i2 != -1) {
      return i2;
    }
    return this.k + Direction.c(i1).a(1);
  }
  
  public void d(int paramInt)
  {
    this.u = paramInt;
  }
  
  public int e()
  {
    return this.k;
  }
  
  public View f()
  {
    return this.A.a(0);
  }
  
  public View g()
  {
    RecyclerViewProxy localRecyclerViewProxy = this.A;
    return localRecyclerViewProxy.a(localRecyclerViewProxy.a() - 1);
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    return new RecyclerView.LayoutParams(-2, -2);
  }
  
  public int h()
  {
    return this.f;
  }
  
  public boolean isAutoMeasureEnabled()
  {
    return true;
  }
  
  public void onAdapterChanged(RecyclerView.Adapter paramAdapter1, RecyclerView.Adapter paramAdapter2)
  {
    this.l = -1;
    this.j = 0;
    this.i = 0;
    if ((paramAdapter2 instanceof AEBottomListScrollLayoutManager.InitialPositionProvider)) {
      this.k = ((AEBottomListScrollLayoutManager.InitialPositionProvider)paramAdapter2).a();
    } else {
      this.k = 0;
    }
    this.A.f();
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (this.A.a() > 0)
    {
      paramAccessibilityEvent = AccessibilityEventCompat.asRecord(paramAccessibilityEvent);
      paramAccessibilityEvent.setFromIndex(getPosition(f()));
      paramAccessibilityEvent.setToIndex(getPosition(g()));
    }
  }
  
  public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    int i2 = this.k;
    int i1;
    if (i2 == -1)
    {
      i1 = 0;
    }
    else
    {
      i1 = i2;
      if (i2 >= paramInt1) {
        i1 = Math.min(i2 + paramInt2, this.A.b() - 1);
      }
    }
    e(i1);
  }
  
  public void onItemsChanged(RecyclerView paramRecyclerView)
  {
    this.k = Math.min(Math.max(0, this.k), this.A.b() - 1);
    this.t = true;
  }
  
  public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    int i1 = this.k;
    if (this.A.b() == 0)
    {
      i1 = -1;
    }
    else
    {
      int i2 = this.k;
      if (i2 >= paramInt1)
      {
        if (i2 < paramInt1 + paramInt2) {
          this.k = -1;
        }
        i1 = Math.max(0, this.k - paramInt2);
      }
    }
    e(i1);
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    int i1 = paramState.getItemCount();
    boolean bool = false;
    if (i1 == 0)
    {
      this.A.b(paramRecycler);
      this.l = -1;
      this.k = -1;
      this.j = 0;
      this.i = 0;
      return;
    }
    c(paramState);
    b(paramState);
    if (!this.n)
    {
      if (this.A.a() == 0) {
        bool = true;
      }
      this.n = bool;
      if (this.n) {
        a(paramRecycler);
      }
    }
    this.A.a(paramRecycler);
    b(paramRecycler);
    b();
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    this.k = ((Bundle)paramParcelable).getInt("extra_position");
  }
  
  public Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    int i1 = this.l;
    if (i1 != -1) {
      this.k = i1;
    }
    localBundle.putInt("extra_position", this.k);
    return localBundle;
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    int i1 = this.h;
    if ((i1 == 0) && (i1 != paramInt)) {
      this.y.a();
    }
    if (paramInt == 0)
    {
      if (i()) {
        this.y.b();
      }
    }
    else if (paramInt == 1) {
      j();
    }
    this.h = paramInt;
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return a(paramInt, paramRecycler);
  }
  
  public void scrollToPosition(int paramInt)
  {
    if (this.k == paramInt) {
      return;
    }
    this.k = paramInt;
    this.A.e();
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return a(paramInt, paramRecycler);
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.State paramState, int paramInt)
  {
    if (this.l != -1) {
      return;
    }
    a(paramState, paramInt);
    if (this.k == -1)
    {
      this.k = paramInt;
      return;
    }
    f(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListScrollLayoutManager
 * JD-Core Version:    0.7.0.1
 */