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
  protected int a;
  private Context jdField_a_of_type_AndroidContentContext;
  protected Point a;
  protected SparseArray<View> a;
  @NonNull
  private final AEBottomListScrollLayoutManager.ScrollStateListener jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollLayoutManager$ScrollStateListener;
  private AEBottomListScrollView.LayoutCallback jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView$LayoutCallback;
  private DSVOrientation.Helper jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomDSVOrientation$Helper;
  private RecyclerViewProxy jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy;
  private VideoStoryScrollItemTransformer jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsVideoStoryScrollItemTransformer;
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
  
  public AEBottomListScrollLayoutManager(@NonNull Context paramContext, @NonNull AEBottomListScrollLayoutManager.ScrollStateListener paramScrollStateListener, @NonNull DSVOrientation paramDSVOrientation)
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
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollLayoutManager$ScrollStateListener = paramScrollStateListener;
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomDSVOrientation$Helper = paramDSVOrientation.a();
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy = new RecyclerViewProxy(this);
    this.l = 1;
  }
  
  private float a(View paramView, int paramInt)
  {
    return Math.min(Math.max(-1.0F, this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomDSVOrientation$Helper.a(this.jdField_b_of_type_AndroidGraphicsPoint, getDecoratedLeft(paramView) + this.jdField_a_of_type_Int, getDecoratedTop(paramView) + this.jdField_b_of_type_Int) / paramInt), 1.0F);
  }
  
  private int a(int paramInt)
  {
    int i1 = this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.b();
    if ((this.h != 0) && (paramInt < 0)) {
      return 0;
    }
    int i2 = this.h;
    int i3 = i1 - 1;
    if ((i2 != i3) && (paramInt >= i1)) {
      return i3;
    }
    return paramInt;
  }
  
  private int a(RecyclerView.State paramState)
  {
    int i1 = b(paramState);
    int i2 = (int)(this.f / this.d * i1);
    return this.h * i1 + i2;
  }
  
  private void a(RecyclerView.Recycler paramRecycler, Direction paramDirection, int paramInt)
  {
    int i4 = paramDirection.a(1);
    int i1 = this.i;
    if ((i1 != -1) && (paramDirection.a(i1 - this.h))) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    this.jdField_a_of_type_AndroidGraphicsPoint.set(this.jdField_c_of_type_AndroidGraphicsPoint.x, this.jdField_c_of_type_AndroidGraphicsPoint.y);
    int i2 = this.h;
    int i3;
    do
    {
      for (;;)
      {
        i2 += i4;
        if (!a(i2)) {
          return;
        }
        i3 = i1;
        if (i2 == this.i) {
          i3 = 1;
        }
        this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomDSVOrientation$Helper.a(paramDirection, this.d, this.jdField_a_of_type_AndroidGraphicsPoint);
        if (!a(this.jdField_a_of_type_AndroidGraphicsPoint, paramInt)) {
          break;
        }
        a(paramRecycler, i2, this.jdField_a_of_type_AndroidGraphicsPoint);
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
  
  private boolean a()
  {
    int i1 = this.i;
    if (i1 != -1)
    {
      this.h = i1;
      this.i = -1;
      this.g = 0;
      this.f = 0;
      return true;
    }
    Direction localDirection = Direction.a(this.f);
    if (b())
    {
      int i2 = Math.abs(this.f);
      int i3 = this.d;
      i1 = Math.abs(this.f);
      int i4 = this.d;
      i1 /= i4;
      if (i2 % i3 < i4 * 0.4F)
      {
        i2 = this.h;
        i1 = localDirection.a(i1);
      }
      else
      {
        i2 = this.h;
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
    return (paramInt >= 0) && (paramInt < this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.b());
  }
  
  private boolean a(Point paramPoint, int paramInt)
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomDSVOrientation$Helper.a(paramPoint, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt, this.jdField_c_of_type_Int);
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
    int i1 = this.h;
    if ((i1 == -1) || (i1 >= paramState.getItemCount())) {
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
    AEBottomListScrollLayoutManager.DiscreteLinearSmoothScroller localDiscreteLinearSmoothScroller = new AEBottomListScrollLayoutManager.DiscreteLinearSmoothScroller(this, this.jdField_a_of_type_AndroidContentContext);
    localDiscreteLinearSmoothScroller.setTargetPosition(this.h);
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.a(localDiscreteLinearSmoothScroller);
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
    int i1;
    if (this.i != -1) {
      i1 = Math.abs(this.f + this.g);
    } else {
      i1 = this.d;
    }
    float f1 = i1;
    f1 = -Math.min(Math.max(-1.0F, this.f / f1), 1.0F);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollLayoutManager$ScrollStateListener.a(f1);
  }
  
  private void f(int paramInt)
  {
    this.g = (-this.f);
    Direction localDirection = Direction.a(paramInt - this.h);
    int i1 = Math.abs(paramInt - this.h);
    int i2 = this.d;
    this.g += localDirection.a(i1 * i2);
    this.i = paramInt;
    e();
  }
  
  public int a()
  {
    int i1 = this.f;
    if (i1 == 0) {
      return this.h;
    }
    int i2 = this.i;
    if (i2 != -1) {
      return i2;
    }
    return this.h + Direction.a(i1).a(1);
  }
  
  protected int a(int paramInt, RecyclerView.Recycler paramRecycler)
  {
    if (this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.a() == 0) {
      return 0;
    }
    this.f += paramInt;
    int i1 = this.g;
    if (i1 != 0) {
      this.g = (i1 - paramInt);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomDSVOrientation$Helper.a(-paramInt, this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy);
    if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomDSVOrientation$Helper.a(this)) {
      b(paramRecycler);
    }
    f();
    b();
    return paramInt;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.a(0);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    int i3 = 0;
    int i1 = 0;
    int i2;
    for (;;)
    {
      i2 = i3;
      if (i1 >= this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.a()) {
        break;
      }
      View localView = this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.a(i1);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.a(localView), localView);
      i1 += 1;
    }
    while (i2 < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.b((View)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i2));
      i2 += 1;
    }
  }
  
  public void a(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i2 = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomDSVOrientation$Helper.c(paramInt1, paramInt2);
    if (this.f * i2 >= 0) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt1 == 0)
    {
      c();
      return;
    }
    if (this.jdField_c_of_type_Boolean) {
      paramInt1 = Math.abs(i2 / this.m);
    } else {
      paramInt1 = 1;
    }
    Direction localDirection = Direction.a(this.f);
    int i1 = this.h;
    paramInt2 = i1;
    if (b())
    {
      paramInt2 = i1;
      if (this.d != 0)
      {
        paramInt2 = Math.abs(this.f);
        int i3 = this.d;
        int i5 = Math.abs(this.f);
        int i4 = this.d;
        i5 /= i4;
        if (paramInt2 % i3 < i4 * 0.4F) {
          paramInt2 = localDirection.a(i5);
        } else {
          paramInt2 = localDirection.a(i5 + 1);
        }
        paramInt2 = i1 + paramInt2;
      }
    }
    paramInt1 = a(paramInt2 + Direction.a(i2).a(paramInt1));
    if (a(paramInt1))
    {
      f(paramInt1);
      return;
    }
    c();
  }
  
  protected void a(RecyclerView.Recycler paramRecycler)
  {
    View localView = this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.a(0, paramRecycler);
    int i1 = this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.b(localView);
    int i2 = this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.c(localView);
    this.jdField_a_of_type_Int = (i1 / 2);
    this.jdField_b_of_type_Int = (i2 / 2);
    this.d = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomDSVOrientation$Helper.b(i1, i2);
    this.jdField_c_of_type_Int = (this.d * this.k);
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.a(localView, paramRecycler);
  }
  
  protected void a(RecyclerView.Recycler paramRecycler, int paramInt, Point paramPoint)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= getItemCount()) {
        return;
      }
      View localView = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      if (localView == null)
      {
        paramRecycler = this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.a(paramInt, paramRecycler);
        this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.a(paramRecycler, paramPoint.x - this.jdField_a_of_type_Int, paramPoint.y - this.jdField_b_of_type_Int, paramPoint.x + this.jdField_a_of_type_Int, paramPoint.y + this.jdField_b_of_type_Int);
        return;
      }
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.a(localView);
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
    }
  }
  
  public void a(RecyclerView.State paramState)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollLayoutManager$ScrollStateListener.c();
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollLayoutManager$ScrollStateListener.d();
      this.jdField_b_of_type_Boolean = false;
      paramState = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView$LayoutCallback;
      if (paramState != null) {
        paramState.i();
      }
    }
  }
  
  protected void a(AEBottomListScrollView.LayoutCallback paramLayoutCallback)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView$LayoutCallback = paramLayoutCallback;
  }
  
  public void a(DSVOrientation paramDSVOrientation)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomDSVOrientation$Helper = paramDSVOrientation.a();
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.b();
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.a();
  }
  
  public void a(VideoStoryScrollItemTransformer paramVideoStoryScrollItemTransformer)
  {
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsVideoStoryScrollItemTransformer = paramVideoStoryScrollItemTransformer;
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
    RecyclerViewProxy localRecyclerViewProxy = this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy;
    return localRecyclerViewProxy.a(localRecyclerViewProxy.a() - 1);
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsVideoStoryScrollItemTransformer != null)
    {
      int i2 = this.d;
      int i3 = this.l;
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.a())
      {
        View localView = this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.a(i1);
        float f1 = a(localView, i2 * i3);
        this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsVideoStoryScrollItemTransformer.a(localView, f1);
        i1 += 1;
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.k = paramInt;
    this.jdField_c_of_type_Int = (this.d * paramInt);
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.a();
  }
  
  protected void b(RecyclerView.Recycler paramRecycler)
  {
    a();
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomDSVOrientation$Helper.a(this.jdField_b_of_type_AndroidGraphicsPoint, this.f, this.jdField_c_of_type_AndroidGraphicsPoint);
    int i1 = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomDSVOrientation$Helper.a(this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.c(), this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.d());
    if (a(this.jdField_c_of_type_AndroidGraphicsPoint, i1)) {
      a(paramRecycler, this.h, this.jdField_c_of_type_AndroidGraphicsPoint);
    }
    a(paramRecycler, new Direction.Start(), i1);
    a(paramRecycler, new Direction.End(), i1);
    c(paramRecycler);
  }
  
  protected void b(RecyclerView.State paramState)
  {
    int i1;
    if ((!paramState.isMeasuring()) && ((this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.c() != this.n) || (this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.d() != this.o))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      this.n = this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.c();
      this.o = this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.d();
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.b();
    }
    this.jdField_b_of_type_AndroidGraphicsPoint.set(this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.c() / 2, this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.d() / 2);
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
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.b(localView, paramRecycler);
      i1 += 1;
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
  }
  
  public boolean canScrollHorizontally()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomDSVOrientation$Helper.b();
  }
  
  public boolean canScrollVertically()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomDSVOrientation$Helper.a();
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
    if ((paramAdapter2 instanceof AEBottomListScrollLayoutManager.InitialPositionProvider)) {
      this.h = ((AEBottomListScrollLayoutManager.InitialPositionProvider)paramAdapter2).a();
    } else {
      this.h = 0;
    }
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.b();
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.a() > 0)
    {
      paramAccessibilityEvent = AccessibilityEventCompat.asRecord(paramAccessibilityEvent);
      paramAccessibilityEvent.setFromIndex(getPosition(a()));
      paramAccessibilityEvent.setToIndex(getPosition(b()));
    }
  }
  
  public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    int i2 = this.h;
    int i1;
    if (i2 == -1)
    {
      i1 = 0;
    }
    else
    {
      i1 = i2;
      if (i2 >= paramInt1) {
        i1 = Math.min(i2 + paramInt2, this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.b() - 1);
      }
    }
    e(i1);
  }
  
  public void onItemsChanged(RecyclerView paramRecyclerView)
  {
    this.h = Math.min(Math.max(0, this.h), this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.b() - 1);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    int i1 = this.h;
    if (this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.b() == 0)
    {
      i1 = -1;
    }
    else
    {
      int i2 = this.h;
      if (i2 >= paramInt1)
      {
        if (i2 < paramInt1 + paramInt2) {
          this.h = -1;
        }
        i1 = Math.max(0, this.h - paramInt2);
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
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.b(paramRecycler);
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
      if (this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.a() == 0) {
        bool = true;
      }
      this.jdField_a_of_type_Boolean = bool;
      if (this.jdField_a_of_type_Boolean) {
        a(paramRecycler);
      }
    }
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.a(paramRecycler);
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
    int i1 = this.i;
    if (i1 != -1) {
      this.h = i1;
    }
    localBundle.putInt("extra_position", this.h);
    return localBundle;
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    int i1 = this.e;
    if ((i1 == 0) && (i1 != paramInt)) {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollLayoutManager$ScrollStateListener.a();
    }
    if (paramInt == 0)
    {
      if (a()) {
        this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollLayoutManager$ScrollStateListener.b();
      }
    }
    else if (paramInt == 1) {
      d();
    }
    this.e = paramInt;
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
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsRecyclerViewProxy.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListScrollLayoutManager
 * JD-Core Version:    0.7.0.1
 */