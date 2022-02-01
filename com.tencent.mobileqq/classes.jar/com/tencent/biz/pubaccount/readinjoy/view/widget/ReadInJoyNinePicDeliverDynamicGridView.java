package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ListAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tco;
import tcp;
import tcq;
import tcr;
import tcs;
import tct;
import tcv;
import tcx;
import tcy;
import tda;
import tdc;
import tdd;
import tde;
import tdf;
import tdg;
import tdh;

public class ReadInJoyNinePicDeliverDynamicGridView
  extends GridView
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  private View jdField_a_of_type_AndroidViewView;
  private AbsListView.OnScrollListener jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener;
  private AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener;
  private List<Long> jdField_a_of_type_JavaUtilList = new ArrayList();
  private tdc jdField_a_of_type_Tdc;
  private tdd jdField_a_of_type_Tdd;
  private tde jdField_a_of_type_Tde;
  private tdf jdField_a_of_type_Tdf;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  private AbsListView.OnScrollListener jdField_b_of_type_AndroidWidgetAbsListView$OnScrollListener = new tct(this);
  private AdapterView.OnItemClickListener jdField_b_of_type_AndroidWidgetAdapterView$OnItemClickListener = new tco(this);
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = -1;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean = true;
  private int jdField_h_of_type_Int = -1;
  private boolean jdField_h_of_type_Boolean;
  private int i;
  private int j = 0;
  
  public ReadInJoyNinePicDeliverDynamicGridView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ReadInJoyNinePicDeliverDynamicGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ReadInJoyNinePicDeliverDynamicGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  public static float a(View paramView)
  {
    return Math.abs((paramView.getRight() - paramView.getLeft()) / 2);
  }
  
  private int a()
  {
    return a().a();
  }
  
  private long a(int paramInt)
  {
    return getAdapter().getItemId(paramInt);
  }
  
  @TargetApi(11)
  private AnimatorSet a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "translationX", new float[] { paramFloat1, paramFloat2 });
    paramView = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { paramFloat3, paramFloat4 });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator, paramView });
    return localAnimatorSet;
  }
  
  private Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      if (paramConfig == Bitmap.Config.ARGB_8888) {
        return a(paramInt1, paramInt2, Bitmap.Config.ARGB_4444);
      }
    }
    return null;
  }
  
  private Bitmap a(View paramView, float paramFloat, int paramInt)
  {
    int k = (int)(paramView.getWidth() * paramFloat);
    int m = (int)(paramView.getHeight() * paramFloat);
    Bitmap localBitmap = a(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
    if (localBitmap == null) {}
    do
    {
      return null;
      paramView.draw(new Canvas(localBitmap));
      paramView = a(k + paramInt, m + paramInt, Bitmap.Config.ARGB_8888);
    } while (paramView == null);
    Canvas localCanvas = new Canvas(paramView);
    Paint localPaint = new Paint();
    localPaint.setDither(true);
    localPaint.setFilterBitmap(true);
    localCanvas.drawBitmap(localBitmap, null, new Rect(paramInt, paramInt, paramView.getWidth() - paramInt, paramView.getHeight() - paramInt), localPaint);
    return paramView;
  }
  
  private Point a(View paramView)
  {
    int k = getPositionForView(paramView);
    int m = a();
    return new Point(k % m, k / m);
  }
  
  private BitmapDrawable a(View paramView)
  {
    int k = ((int)(paramView.getWidth() * 1.1F) + 0) / 2;
    int m = ((int)(paramView.getHeight() * 1.1F) + 0) / 2;
    int n = (paramView.getRight() + paramView.getLeft()) / 2;
    int i1 = (paramView.getBottom() + paramView.getTop()) / 2;
    paramView = a(paramView, 1.1F, 0);
    paramView = new BitmapDrawable(getResources(), paramView);
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect(n - k, i1 - m, k + n, m + i1);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(this.jdField_b_of_type_AndroidGraphicsRect);
    paramView.setBounds(this.jdField_a_of_type_AndroidGraphicsRect);
    return paramView;
  }
  
  private tcx a()
  {
    return (tcx)getAdapter();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Tdc != null) {
      this.jdField_a_of_type_Tdc.a(paramInt1, paramInt2);
    }
    a().a(paramInt1, paramInt2);
  }
  
  private void a(long paramLong)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    int m = a(paramLong);
    int k = getFirstVisiblePosition();
    while (k <= getLastVisiblePosition())
    {
      if ((m != k) && (a().a(k))) {
        this.jdField_a_of_type_JavaUtilList.add(Long.valueOf(a(k)));
      }
      k += 1;
    }
  }
  
  @TargetApi(11)
  private void a(View paramView)
  {
    Object localObject = new tcp(this);
    localObject = ObjectAnimator.ofObject(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable, "bounds", (TypeEvaluator)localObject, new Object[] { this.jdField_a_of_type_AndroidGraphicsRect });
    ((ObjectAnimator)localObject).addUpdateListener(new tcq(this));
    ((ObjectAnimator)localObject).addListener(new tcr(this, paramView));
    ((ObjectAnimator)localObject).start();
  }
  
  public static void a(List paramList, int paramInt1, int paramInt2)
  {
    paramList.add(paramInt2, paramList.remove(paramInt1));
  }
  
  private boolean a(Point paramPoint1, Point paramPoint2)
  {
    return (paramPoint1.y > paramPoint2.y) && (paramPoint1.x < paramPoint2.x);
  }
  
  public static float b(View paramView)
  {
    return Math.abs((paramView.getBottom() - paramView.getTop()) / 2);
  }
  
  private void b()
  {
    this.jdField_b_of_type_Boolean = a(this.jdField_a_of_type_AndroidGraphicsRect);
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    View localView = getChildAt(paramInt - getFirstVisiblePosition());
    if (localView != null)
    {
      this.jdField_a_of_type_Long = getAdapter().getItemId(paramInt);
      if (this.jdField_a_of_type_Tdf != null) {
        this.jdField_a_of_type_Tdf.a(localView, paramInt, this.jdField_a_of_type_Long);
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = a(localView);
      if (this.jdField_a_of_type_Tdf != null) {
        this.jdField_a_of_type_Tdf.b(localView, paramInt, this.jdField_a_of_type_Long);
      }
      if (c()) {
        localView.setVisibility(4);
      }
      this.jdField_a_of_type_Boolean = true;
      a(this.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_Tdc != null) {
        this.jdField_a_of_type_Tdc.a(paramInt);
      }
    }
  }
  
  @TargetApi(11)
  private void b(int paramInt1, int paramInt2)
  {
    LinkedList localLinkedList;
    if (paramInt2 > paramInt1)
    {
      k = 1;
      localLinkedList = new LinkedList();
      if (k == 0) {
        break label131;
      }
      k = Math.min(paramInt1, paramInt2);
      label26:
      if (k >= Math.max(paramInt1, paramInt2)) {
        break label241;
      }
      localObject = a(a(k));
      if ((k + 1) % a() != 0) {
        break label105;
      }
      localLinkedList.add(a((View)localObject, -((View)localObject).getWidth() * (a() - 1), 0.0F, ((View)localObject).getHeight(), 0.0F));
    }
    for (;;)
    {
      k += 1;
      break label26;
      k = 0;
      break;
      label105:
      localLinkedList.add(a((View)localObject, ((View)localObject).getWidth(), 0.0F, 0.0F, 0.0F));
    }
    label131:
    int k = Math.max(paramInt1, paramInt2);
    if (k > Math.min(paramInt1, paramInt2))
    {
      localObject = a(a(k));
      if ((a() + k) % a() == 0) {
        localLinkedList.add(a((View)localObject, ((View)localObject).getWidth() * (a() - 1), 0.0F, -((View)localObject).getHeight(), 0.0F));
      }
      for (;;)
      {
        k -= 1;
        break;
        localLinkedList.add(a((View)localObject, -((View)localObject).getWidth(), 0.0F, 0.0F, 0.0F));
      }
    }
    label241:
    Object localObject = new AnimatorSet();
    ((AnimatorSet)localObject).playTogether(localLinkedList);
    ((AnimatorSet)localObject).setDuration(300L);
    ((AnimatorSet)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
    ((AnimatorSet)localObject).addListener(new tcs(this));
    ((AnimatorSet)localObject).start();
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Long = -1L;
    paramView.setVisibility(0);
    this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = null;
    int k = 0;
    while (k < getLastVisiblePosition() - getFirstVisiblePosition())
    {
      paramView = getChildAt(k);
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      k += 1;
    }
    invalidate();
  }
  
  public static boolean b()
  {
    return Build.VERSION.SDK_INT < 21;
  }
  
  private boolean b(Point paramPoint1, Point paramPoint2)
  {
    return (paramPoint1.y > paramPoint2.y) && (paramPoint1.x > paramPoint2.x);
  }
  
  private void c()
  {
    View localView = a(this.jdField_a_of_type_Long);
    if ((localView != null) && ((this.jdField_a_of_type_Boolean) || (this.jdField_c_of_type_Boolean)))
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_h_of_type_Int = -1;
      if (this.j != 0)
      {
        this.jdField_c_of_type_Boolean = true;
        return;
      }
      this.jdField_a_of_type_AndroidGraphicsRect.offsetTo(localView.getLeft(), localView.getTop());
      if (Build.VERSION.SDK_INT > 11)
      {
        a(localView);
        return;
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.setBounds(this.jdField_a_of_type_AndroidGraphicsRect);
      invalidate();
      b(localView);
      return;
    }
    e();
  }
  
  private boolean c()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  private boolean c(Point paramPoint1, Point paramPoint2)
  {
    return (paramPoint1.y < paramPoint2.y) && (paramPoint1.x < paramPoint2.x);
  }
  
  private void d()
  {
    if ((!this.jdField_e_of_type_Boolean) && (!this.jdField_f_of_type_Boolean)) {}
    for (boolean bool = true;; bool = false)
    {
      setEnabled(bool);
      return;
    }
  }
  
  private boolean d(Point paramPoint1, Point paramPoint2)
  {
    return (paramPoint1.y < paramPoint2.y) && (paramPoint1.x > paramPoint2.x);
  }
  
  private void e()
  {
    View localView = a(this.jdField_a_of_type_Long);
    if (this.jdField_a_of_type_Boolean) {
      b(localView);
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_h_of_type_Int = -1;
  }
  
  private boolean e(Point paramPoint1, Point paramPoint2)
  {
    return (paramPoint1.y < paramPoint2.y) && (paramPoint1.x == paramPoint2.x);
  }
  
  private void f()
  {
    float f2 = 0.0F;
    int k = this.jdField_e_of_type_Int - this.jdField_d_of_type_Int;
    int m = this.jdField_f_of_type_Int - this.jdField_c_of_type_Int;
    int n = this.jdField_b_of_type_AndroidGraphicsRect.centerY() + this.jdField_a_of_type_Int + k;
    int i1 = this.jdField_b_of_type_AndroidGraphicsRect.centerX() + this.jdField_b_of_type_Int + m;
    this.jdField_a_of_type_AndroidViewView = a(this.jdField_a_of_type_Long);
    Object localObject = null;
    Point localPoint1 = a(this.jdField_a_of_type_AndroidViewView);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    float f1 = 0.0F;
    float f3;
    if (localIterator.hasNext())
    {
      View localView = a(((Long)localIterator.next()).longValue());
      if (localView == null) {
        break label637;
      }
      Point localPoint2 = a(localView);
      if (((!d(localPoint2, localPoint1)) || (n >= localView.getBottom()) || (i1 <= localView.getLeft())) && ((!c(localPoint2, localPoint1)) || (n >= localView.getBottom()) || (i1 >= localView.getRight())) && ((!b(localPoint2, localPoint1)) || (n <= localView.getTop()) || (i1 <= localView.getLeft())) && ((!a(localPoint2, localPoint1)) || (n <= localView.getTop()) || (i1 >= localView.getRight())) && ((!e(localPoint2, localPoint1)) || (n >= localView.getBottom() - this.jdField_g_of_type_Int)) && ((!f(localPoint2, localPoint1)) || (n <= localView.getTop() + this.jdField_g_of_type_Int)) && ((!g(localPoint2, localPoint1)) || (i1 <= localView.getLeft() + this.jdField_g_of_type_Int)) && ((!h(localPoint2, localPoint1)) || (i1 >= localView.getRight() - this.jdField_g_of_type_Int))) {
        break label637;
      }
      float f4 = Math.abs(a(localView) - a(this.jdField_a_of_type_AndroidViewView));
      f3 = Math.abs(b(localView) - b(this.jdField_a_of_type_AndroidViewView));
      if ((f4 < f1) || (f3 < f2)) {
        break label637;
      }
      f2 = f4;
      localObject = localView;
      f1 = f3;
    }
    for (;;)
    {
      f3 = f2;
      f2 = f1;
      f1 = f3;
      break;
      if (localObject != null)
      {
        n = getPositionForView(this.jdField_a_of_type_AndroidViewView);
        i1 = getPositionForView((View)localObject);
        if (!((tcv)getAdapter()).a().get(i1).equals(""))
        {
          localObject = a();
          if ((i1 != -1) && (((tcx)localObject).a(n)) && (((tcx)localObject).a(i1))) {
            break label526;
          }
          a(this.jdField_a_of_type_Long);
        }
      }
      return;
      label526:
      a(n, i1);
      this.jdField_d_of_type_Int = this.jdField_e_of_type_Int;
      this.jdField_c_of_type_Int = this.jdField_f_of_type_Int;
      if ((c()) && (b())) {
        localObject = new tcy(this, m, k);
      }
      for (;;)
      {
        a(this.jdField_a_of_type_Long);
        ((tdh)localObject).a(n, i1);
        return;
        if (b()) {
          localObject = new tdg(this, m, k);
        } else {
          localObject = new tda(this, m, k);
        }
      }
      label637:
      f3 = f1;
      f1 = f2;
      f2 = f3;
    }
  }
  
  private boolean f(Point paramPoint1, Point paramPoint2)
  {
    return (paramPoint1.y > paramPoint2.y) && (paramPoint1.x == paramPoint2.x);
  }
  
  private boolean g(Point paramPoint1, Point paramPoint2)
  {
    return (paramPoint1.y == paramPoint2.y) && (paramPoint1.x > paramPoint2.x);
  }
  
  private boolean h(Point paramPoint1, Point paramPoint2)
  {
    return (paramPoint1.y == paramPoint2.y) && (paramPoint1.x < paramPoint2.x);
  }
  
  public int a(long paramLong)
  {
    View localView = a(paramLong);
    if (localView == null) {
      return -1;
    }
    return getPositionForView(localView);
  }
  
  public View a(long paramLong)
  {
    int m = getFirstVisiblePosition();
    ListAdapter localListAdapter = getAdapter();
    int k = 0;
    while (k < getChildCount())
    {
      View localView = getChildAt(k);
      if (localListAdapter.getItemId(m + k) == paramLong) {
        return localView;
      }
      k += 1;
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_d_of_type_Boolean = false;
    requestDisallowInterceptTouchEvent(false);
    if (this.jdField_a_of_type_Tde != null) {
      this.jdField_a_of_type_Tde.a(false);
    }
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_g_of_type_Boolean) {}
    do
    {
      return;
      requestDisallowInterceptTouchEvent(true);
      if (paramInt != -1) {
        b(paramInt);
      }
      this.jdField_d_of_type_Boolean = true;
    } while (this.jdField_a_of_type_Tde == null);
    this.jdField_a_of_type_Tde.a(true);
  }
  
  public void a(Context paramContext)
  {
    super.setOnScrollListener(this.jdField_b_of_type_AndroidWidgetAbsListView$OnScrollListener);
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.i = ((int)(8.0F * paramContext.density + 0.5F));
    this.jdField_g_of_type_Int = ((int)(paramContext.density * 16.0F + 0.5F));
  }
  
  public boolean a()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public boolean a(Rect paramRect)
  {
    int k = computeVerticalScrollOffset();
    int m = getHeight();
    int n = computeVerticalScrollExtent();
    int i1 = computeVerticalScrollRange();
    int i2 = paramRect.top;
    int i3 = paramRect.height();
    if ((i2 <= 0) && (k > 0))
    {
      smoothScrollBy(-this.i, 0);
      return true;
    }
    if ((i2 + i3 >= m) && (k + n < i1))
    {
      smoothScrollBy(this.i, 0);
      return true;
    }
    return false;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.draw(paramCanvas);
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_h_of_type_Boolean)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(16777215, -2147483648));
      getLayoutParams().height = getMeasuredHeight();
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.jdField_c_of_type_Int = ((int)paramMotionEvent.getX());
      this.jdField_d_of_type_Int = ((int)paramMotionEvent.getY());
      this.jdField_h_of_type_Int = paramMotionEvent.getPointerId(0);
      if ((this.jdField_d_of_type_Boolean) && (isEnabled()))
      {
        layoutChildren();
        b(pointToPosition(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int));
      }
      else if (!isEnabled())
      {
        return false;
        if (this.jdField_h_of_type_Int != -1)
        {
          int k = paramMotionEvent.findPointerIndex(this.jdField_h_of_type_Int);
          this.jdField_e_of_type_Int = ((int)paramMotionEvent.getY(k));
          this.jdField_f_of_type_Int = ((int)paramMotionEvent.getX(k));
          k = this.jdField_e_of_type_Int;
          int m = this.jdField_d_of_type_Int;
          int n = this.jdField_f_of_type_Int;
          int i1 = this.jdField_c_of_type_Int;
          if (this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidGraphicsRect.offsetTo(n - i1 + this.jdField_b_of_type_AndroidGraphicsRect.left + this.jdField_b_of_type_Int, k - m + this.jdField_b_of_type_AndroidGraphicsRect.top + this.jdField_a_of_type_Int);
            this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.setBounds(this.jdField_a_of_type_AndroidGraphicsRect);
            invalidate();
            f();
            this.jdField_b_of_type_Boolean = false;
            b();
            return false;
            c();
            if ((this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != null) && (this.jdField_a_of_type_Tdd != null))
            {
              this.jdField_a_of_type_Tdd.a();
              continue;
              e();
              if ((this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != null) && (this.jdField_a_of_type_Tdd != null))
              {
                this.jdField_a_of_type_Tdd.a();
                continue;
                if (paramMotionEvent.getPointerId((paramMotionEvent.getAction() & 0xFF00) >> 8) == this.jdField_h_of_type_Int) {
                  c();
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(paramListAdapter);
  }
  
  public void setEditModeEnabled(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  public void setExpendable(boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = paramBoolean;
  }
  
  public void setOnDragListener(tdc paramtdc)
  {
    this.jdField_a_of_type_Tdc = paramtdc;
  }
  
  public void setOnDropListener(tdd paramtdd)
  {
    this.jdField_a_of_type_Tdd = paramtdd;
  }
  
  public void setOnEditModeChangeListener(tde paramtde)
  {
    this.jdField_a_of_type_Tde = paramtde;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = paramOnItemClickListener;
    super.setOnItemClickListener(this.jdField_b_of_type_AndroidWidgetAdapterView$OnItemClickListener);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener = paramOnScrollListener;
  }
  
  public void setOnSelectedItemBitmapCreationListener(tdf paramtdf)
  {
    this.jdField_a_of_type_Tdf = paramtdf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyNinePicDeliverDynamicGridView
 * JD-Core Version:    0.7.0.1
 */