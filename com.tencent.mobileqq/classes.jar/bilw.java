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
import java.util.Locale;

public class bilw
  extends RecyclerView.LayoutManager
{
  protected int a;
  private Context jdField_a_of_type_AndroidContentContext;
  protected Point a;
  protected SparseArray<View> a;
  @NonNull
  private final bilz jdField_a_of_type_Bilz;
  private bimb jdField_a_of_type_Bimb;
  private bimg jdField_a_of_type_Bimg;
  private xfl jdField_a_of_type_Xfl;
  private xfq jdField_a_of_type_Xfq;
  protected boolean a;
  protected int b;
  protected Point b;
  private boolean b;
  protected int c;
  protected Point c;
  private boolean c;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  protected int h;
  protected int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  
  public bilw(@NonNull Context paramContext, @NonNull bilz parambilz, @NonNull bimf parambimf)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.j = 100;
    this.i = -1;
    this.h = -1;
    this.m = 2100;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidGraphicsPoint = new Point();
    this.jdField_c_of_type_AndroidGraphicsPoint = new Point();
    this.jdField_a_of_type_AndroidGraphicsPoint = new Point();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_Bilz = parambilz;
    this.jdField_a_of_type_Bimg = parambimf.a();
    this.jdField_a_of_type_Xfl = new xfl(this);
    this.l = 1;
  }
  
  private float a(View paramView, int paramInt)
  {
    return Math.min(Math.max(-1.0F, this.jdField_a_of_type_Bimg.a(this.jdField_b_of_type_AndroidGraphicsPoint, getDecoratedLeft(paramView) + this.jdField_a_of_type_Int, getDecoratedTop(paramView) + this.jdField_b_of_type_Int) / paramInt), 1.0F);
  }
  
  private int a(int paramInt)
  {
    int i2 = this.jdField_a_of_type_Xfl.b();
    int i1;
    if ((this.h != 0) && (paramInt < 0)) {
      i1 = 0;
    }
    do
    {
      do
      {
        return i1;
        i1 = paramInt;
      } while (this.h == i2 - 1);
      i1 = paramInt;
    } while (paramInt < i2);
    return i2 - 1;
  }
  
  private int a(RecyclerView.State paramState)
  {
    int i1 = b(paramState);
    int i2 = (int)(this.f / this.d * i1);
    return i1 * this.h + i2;
  }
  
  private void a(RecyclerView.Recycler paramRecycler, bijy parambijy, int paramInt)
  {
    int i4 = parambijy.a(1);
    int i1;
    int i2;
    if ((this.i == -1) || (!parambijy.a(this.i - this.h)))
    {
      i1 = 1;
      this.jdField_a_of_type_AndroidGraphicsPoint.set(this.jdField_c_of_type_AndroidGraphicsPoint.x, this.jdField_c_of_type_AndroidGraphicsPoint.y);
      i2 = this.h;
      int i3 = i2 + i4;
      i2 = i1;
      i1 = i3;
      label76:
      if (!a(i1)) {
        return;
      }
      if (i1 == this.i) {
        i2 = 1;
      }
      this.jdField_a_of_type_Bimg.a(parambijy, this.d, this.jdField_a_of_type_AndroidGraphicsPoint);
      if (!a(this.jdField_a_of_type_AndroidGraphicsPoint, paramInt)) {
        break label154;
      }
      a(paramRecycler, i1, this.jdField_a_of_type_AndroidGraphicsPoint);
    }
    label154:
    while (i2 == 0)
    {
      i1 += i4;
      break label76;
      i1 = 0;
      break;
    }
  }
  
  private void a(RecyclerView.State paramState, int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= paramState.getItemCount())) {
      throw new IllegalArgumentException(String.format(Locale.US, "target position out of bounds: position=%d, itemCount=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramState.getItemCount()) }));
    }
  }
  
  private boolean a()
  {
    if (this.i != -1)
    {
      this.h = this.i;
      this.i = -1;
      this.g = 0;
      this.f = 0;
      return true;
    }
    bijy localbijy = bijy.a(this.f);
    if (b())
    {
      int i1 = Math.abs(this.f);
      int i2 = this.d;
      int i3 = Math.abs(this.f) / this.d;
      if (i1 % i2 < this.d * 0.4F)
      {
        i1 = this.h + localbijy.a(i3);
        if (i1 >= 0) {
          break label133;
        }
        i2 = 0;
      }
      for (;;)
      {
        f(i2);
        return false;
        i1 = this.h + localbijy.a(i3 + 1);
        break;
        label133:
        i2 = i1;
        if (i1 > getItemCount() - 1) {
          i2 = getItemCount() - 1;
        }
      }
    }
    this.g = (-this.f);
    if (this.g != 0)
    {
      e();
      return false;
    }
    return true;
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < this.jdField_a_of_type_Xfl.b());
  }
  
  private boolean a(Point paramPoint, int paramInt)
  {
    return this.jdField_a_of_type_Bimg.a(paramPoint, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt, this.jdField_c_of_type_Int);
  }
  
  private int b(RecyclerView.State paramState)
  {
    if (getItemCount() == 0) {
      return 0;
    }
    return (int)(c(paramState) / getItemCount());
  }
  
  private boolean b()
  {
    return Math.abs(this.f) >= this.d * 0.4F;
  }
  
  private int c(RecyclerView.State paramState)
  {
    if (getItemCount() == 0) {
      return 0;
    }
    return this.d * (getItemCount() - 1);
  }
  
  private void c(RecyclerView.State paramState)
  {
    if ((this.h == -1) || (this.h >= paramState.getItemCount())) {
      this.h = 0;
    }
  }
  
  private void d()
  {
    this.i = -1;
    this.g = 0;
  }
  
  private void e()
  {
    if (this.h == -1) {
      return;
    }
    bilx localbilx = new bilx(this, this.jdField_a_of_type_AndroidContentContext);
    localbilx.setTargetPosition(this.h);
    this.jdField_a_of_type_Xfl.a(localbilx);
  }
  
  private void e(int paramInt)
  {
    if (this.h != paramInt)
    {
      this.h = paramInt;
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  private void f()
  {
    if (this.i != -1) {}
    for (float f1 = Math.abs(this.f + this.g);; f1 = this.d)
    {
      f1 = -Math.min(Math.max(-1.0F, this.f / f1), 1.0F);
      this.jdField_a_of_type_Bilz.a(f1);
      return;
    }
  }
  
  private void f(int paramInt)
  {
    this.g = (-this.f);
    bijy localbijy = bijy.a(paramInt - this.h);
    int i1 = Math.abs(paramInt - this.h);
    int i2 = this.d;
    int i3 = this.g;
    this.g = (localbijy.a(i1 * i2) + i3);
    this.i = paramInt;
    e();
  }
  
  public int a()
  {
    if (this.f == 0) {
      return this.h;
    }
    if (this.i != -1) {
      return this.i;
    }
    return this.h + bijy.a(this.f).a(1);
  }
  
  protected int a(int paramInt, RecyclerView.Recycler paramRecycler)
  {
    if (this.jdField_a_of_type_Xfl.a() == 0) {
      return 0;
    }
    this.f += paramInt;
    if (this.g != 0) {
      this.g -= paramInt;
    }
    this.jdField_a_of_type_Bimg.a(-paramInt, this.jdField_a_of_type_Xfl);
    if (this.jdField_a_of_type_Bimg.a(this)) {
      b(paramRecycler);
    }
    f();
    b();
    return paramInt;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_Xfl.a(0);
  }
  
  protected void a()
  {
    int i3 = 0;
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    int i1 = 0;
    int i2;
    for (;;)
    {
      i2 = i3;
      if (i1 >= this.jdField_a_of_type_Xfl.a()) {
        break;
      }
      View localView = this.jdField_a_of_type_Xfl.a(i1);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_Xfl.a(localView), localView);
      i1 += 1;
    }
    while (i2 < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      this.jdField_a_of_type_Xfl.b((View)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i2));
      i2 += 1;
    }
  }
  
  public void a(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i1 = 1;
    int i2 = this.jdField_a_of_type_Bimg.c(paramInt1, paramInt2);
    if (this.f * i2 >= 0) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      c();
      return;
    }
    paramInt2 = i1;
    if (this.jdField_c_of_type_Boolean) {
      paramInt2 = Math.abs(i2 / this.m);
    }
    bijy localbijy = bijy.a(this.f);
    i1 = this.h;
    paramInt1 = i1;
    int i4;
    if (b())
    {
      paramInt1 = i1;
      if (this.d != 0)
      {
        paramInt1 = Math.abs(this.f);
        int i3 = this.d;
        i4 = Math.abs(this.f) / this.d;
        if (paramInt1 % i3 >= this.d * 0.4F) {
          break label178;
        }
      }
    }
    label178:
    for (paramInt1 = i1 + localbijy.a(i4);; paramInt1 = i1 + localbijy.a(i4 + 1))
    {
      paramInt1 = a(bijy.a(i2).a(paramInt2) + paramInt1);
      if (!a(paramInt1)) {
        break;
      }
      f(paramInt1);
      return;
    }
    c();
  }
  
  protected void a(RecyclerView.Recycler paramRecycler)
  {
    View localView = this.jdField_a_of_type_Xfl.a(0, paramRecycler);
    int i1 = this.jdField_a_of_type_Xfl.b(localView);
    int i2 = this.jdField_a_of_type_Xfl.c(localView);
    this.jdField_a_of_type_Int = (i1 / 2);
    this.jdField_b_of_type_Int = (i2 / 2);
    this.d = this.jdField_a_of_type_Bimg.b(i1, i2);
    this.jdField_c_of_type_Int = (this.d * this.k);
    this.jdField_a_of_type_Xfl.a(localView, paramRecycler);
  }
  
  protected void a(RecyclerView.Recycler paramRecycler, int paramInt, Point paramPoint)
  {
    if ((paramInt < 0) || (paramInt >= getItemCount())) {
      return;
    }
    View localView = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localView == null)
    {
      paramRecycler = this.jdField_a_of_type_Xfl.a(paramInt, paramRecycler);
      this.jdField_a_of_type_Xfl.a(paramRecycler, paramPoint.x - this.jdField_a_of_type_Int, paramPoint.y - this.jdField_b_of_type_Int, paramPoint.x + this.jdField_a_of_type_Int, paramPoint.y + this.jdField_b_of_type_Int);
      return;
    }
    this.jdField_a_of_type_Xfl.a(localView);
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
  }
  
  public void a(RecyclerView.State paramState)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Bilz.c();
      this.jdField_a_of_type_Boolean = false;
    }
    do
    {
      do
      {
        return;
      } while (!this.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_Bilz.d();
      this.jdField_b_of_type_Boolean = false;
    } while (this.jdField_a_of_type_Bimb == null);
    this.jdField_a_of_type_Bimb.d();
  }
  
  public void a(bimb parambimb)
  {
    this.jdField_a_of_type_Bimb = parambimb;
  }
  
  public void a(bimf parambimf)
  {
    this.jdField_a_of_type_Bimg = parambimf.a();
    this.jdField_a_of_type_Xfl.b();
    this.jdField_a_of_type_Xfl.a();
  }
  
  public void a(xfq paramxfq)
  {
    this.jdField_a_of_type_Xfq = paramxfq;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public int b()
  {
    return this.h;
  }
  
  public View b()
  {
    return this.jdField_a_of_type_Xfl.a(this.jdField_a_of_type_Xfl.a() - 1);
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Xfq != null)
    {
      int i2 = this.d;
      int i3 = this.l;
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_Xfl.a())
      {
        View localView = this.jdField_a_of_type_Xfl.a(i1);
        float f1 = a(localView, i3 * i2);
        this.jdField_a_of_type_Xfq.a(localView, f1);
        i1 += 1;
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.k = paramInt;
    this.jdField_c_of_type_Int = (this.d * paramInt);
    this.jdField_a_of_type_Xfl.a();
  }
  
  protected void b(RecyclerView.Recycler paramRecycler)
  {
    a();
    this.jdField_a_of_type_Bimg.a(this.jdField_b_of_type_AndroidGraphicsPoint, this.f, this.jdField_c_of_type_AndroidGraphicsPoint);
    int i1 = this.jdField_a_of_type_Bimg.a(this.jdField_a_of_type_Xfl.c(), this.jdField_a_of_type_Xfl.d());
    if (a(this.jdField_c_of_type_AndroidGraphicsPoint, i1)) {
      a(paramRecycler, this.h, this.jdField_c_of_type_AndroidGraphicsPoint);
    }
    a(paramRecycler, new bika(), i1);
    a(paramRecycler, new bijz(), i1);
    c(paramRecycler);
  }
  
  protected void b(RecyclerView.State paramState)
  {
    if ((!paramState.isMeasuring()) && ((this.jdField_a_of_type_Xfl.c() != this.n) || (this.jdField_a_of_type_Xfl.d() != this.o))) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        this.n = this.jdField_a_of_type_Xfl.c();
        this.o = this.jdField_a_of_type_Xfl.d();
        this.jdField_a_of_type_Xfl.b();
      }
      this.jdField_b_of_type_AndroidGraphicsPoint.set(this.jdField_a_of_type_Xfl.c() / 2, this.jdField_a_of_type_Xfl.d() / 2);
      return;
    }
  }
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void c()
  {
    this.g = (-this.f);
    if (this.g != 0) {
      e();
    }
  }
  
  public void c(int paramInt)
  {
    this.l = paramInt;
    b();
  }
  
  protected void c(RecyclerView.Recycler paramRecycler)
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      View localView = (View)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i1);
      this.jdField_a_of_type_Xfl.b(localView, paramRecycler);
      i1 += 1;
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
  }
  
  public boolean canScrollHorizontally()
  {
    return this.jdField_a_of_type_Bimg.b();
  }
  
  public boolean canScrollVertically()
  {
    return this.jdField_a_of_type_Bimg.a();
  }
  
  public int computeHorizontalScrollExtent(RecyclerView.State paramState)
  {
    return b(paramState);
  }
  
  public int computeHorizontalScrollOffset(RecyclerView.State paramState)
  {
    return a(paramState);
  }
  
  public int computeHorizontalScrollRange(RecyclerView.State paramState)
  {
    return c(paramState);
  }
  
  public int computeVerticalScrollExtent(RecyclerView.State paramState)
  {
    return b(paramState);
  }
  
  public int computeVerticalScrollOffset(RecyclerView.State paramState)
  {
    return a(paramState);
  }
  
  public int computeVerticalScrollRange(RecyclerView.State paramState)
  {
    return c(paramState);
  }
  
  public void d(int paramInt)
  {
    this.m = paramInt;
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    return new RecyclerView.LayoutParams(-2, -2);
  }
  
  public boolean isAutoMeasureEnabled()
  {
    return true;
  }
  
  public void onAdapterChanged(RecyclerView.Adapter paramAdapter1, RecyclerView.Adapter paramAdapter2)
  {
    this.i = -1;
    this.g = 0;
    this.f = 0;
    if ((paramAdapter2 instanceof bily)) {}
    for (this.h = ((bily)paramAdapter2).a();; this.h = 0)
    {
      this.jdField_a_of_type_Xfl.b();
      return;
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (this.jdField_a_of_type_Xfl.a() > 0)
    {
      paramAccessibilityEvent = AccessibilityEventCompat.asRecord(paramAccessibilityEvent);
      paramAccessibilityEvent.setFromIndex(getPosition(a()));
      paramAccessibilityEvent.setToIndex(getPosition(b()));
    }
  }
  
  public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    int i1 = this.h;
    if (this.h == -1) {
      i1 = 0;
    }
    for (;;)
    {
      e(i1);
      return;
      if (this.h >= paramInt1) {
        i1 = Math.min(this.h + paramInt2, this.jdField_a_of_type_Xfl.b() - 1);
      }
    }
  }
  
  public void onItemsChanged(RecyclerView paramRecyclerView)
  {
    this.h = Math.min(Math.max(0, this.h), this.jdField_a_of_type_Xfl.b() - 1);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    int i1 = -1;
    int i2 = this.h;
    if (this.jdField_a_of_type_Xfl.b() == 0) {
      paramInt1 = i1;
    }
    for (;;)
    {
      e(paramInt1);
      return;
      if (this.h >= paramInt1)
      {
        if (this.h < paramInt1 + paramInt2) {
          this.h = -1;
        }
        paramInt1 = Math.max(0, this.h - paramInt2);
      }
      else
      {
        paramInt1 = i2;
      }
    }
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    boolean bool = false;
    if (paramState.getItemCount() == 0)
    {
      this.jdField_a_of_type_Xfl.b(paramRecycler);
      this.i = -1;
      this.h = -1;
      this.g = 0;
      this.f = 0;
      return;
    }
    c(paramState);
    b(paramState);
    if (!this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Xfl.a() == 0) {
        bool = true;
      }
      this.jdField_a_of_type_Boolean = bool;
      if (this.jdField_a_of_type_Boolean) {
        a(paramRecycler);
      }
    }
    this.jdField_a_of_type_Xfl.a(paramRecycler);
    b(paramRecycler);
    b();
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    this.h = ((Bundle)paramParcelable).getInt("extra_position");
  }
  
  public Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    if (this.i != -1) {
      this.h = this.i;
    }
    localBundle.putInt("extra_position", this.h);
    return localBundle;
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    if ((this.e == 0) && (this.e != paramInt)) {
      this.jdField_a_of_type_Bilz.a();
    }
    if (paramInt == 0) {
      if (a()) {
        this.jdField_a_of_type_Bilz.b();
      }
    }
    for (;;)
    {
      this.e = paramInt;
      return;
      if (paramInt == 1) {
        d();
      }
    }
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return a(paramInt, paramRecycler);
  }
  
  public void scrollToPosition(int paramInt)
  {
    if (this.h == paramInt) {
      return;
    }
    this.h = paramInt;
    this.jdField_a_of_type_Xfl.a();
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return a(paramInt, paramRecycler);
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.State paramState, int paramInt)
  {
    if (this.i != -1) {
      return;
    }
    a(paramState, paramInt);
    if (this.h == -1)
    {
      this.h = paramInt;
      return;
    }
    f(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bilw
 * JD-Core Version:    0.7.0.1
 */