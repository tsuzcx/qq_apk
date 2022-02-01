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
import android.widget.ListAdapter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ReadInJoyDynamicGridView
  extends GridView
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = -1L;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  private View jdField_a_of_type_AndroidViewView;
  private ReadInJoyDynamicGridView.OnDragListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$OnDragListener;
  private ReadInJoyDynamicGridView.OnDropListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$OnDropListener;
  private ReadInJoyDynamicGridView.OnEditModeChangeListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$OnEditModeChangeListener;
  private ReadInJoyDynamicGridView.OnSelectedItemBitmapCreationListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$OnSelectedItemBitmapCreationListener;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener;
  private List<Long> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  private AbsListView.OnScrollListener jdField_b_of_type_ComTencentWidgetAbsListView$OnScrollListener = new ReadInJoyDynamicGridView.6(this);
  private AdapterView.OnItemClickListener jdField_b_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new ReadInJoyDynamicGridView.1(this);
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = -1;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean = true;
  private int jdField_h_of_type_Int = -1;
  private boolean jdField_h_of_type_Boolean;
  private int i = 0;
  private int j = 0;
  private int k = 0;
  
  public ReadInJoyDynamicGridView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ReadInJoyDynamicGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ReadInJoyDynamicGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  public static float a(View paramView)
  {
    if (paramView == null) {
      return 0.0F;
    }
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
    int m = (int)(paramView.getWidth() * paramFloat);
    int n = (int)(paramView.getHeight() * paramFloat);
    Bitmap localBitmap = a(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
    if (localBitmap == null) {}
    do
    {
      return null;
      paramView.draw(new Canvas(localBitmap));
      paramView = a(m + paramInt, n + paramInt, Bitmap.Config.ARGB_8888);
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
    int m = getPositionForView(paramView);
    int n = a();
    return new Point(m % n, m / n);
  }
  
  private BitmapDrawable a(View paramView)
  {
    int m = ((int)(paramView.getWidth() * 1.1F) + 0) / 2;
    int n = ((int)(paramView.getHeight() * 1.1F) + 0) / 2;
    int i1 = (paramView.getRight() + paramView.getLeft()) / 2;
    int i2 = (paramView.getBottom() + paramView.getTop()) / 2;
    paramView = a(paramView, 1.1F, 0);
    paramView = new BitmapDrawable(getResources(), paramView);
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect(i1 - m, i2 - n, m + i1, n + i2);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(this.jdField_b_of_type_AndroidGraphicsRect);
    paramView.setBounds(this.jdField_a_of_type_AndroidGraphicsRect);
    return paramView;
  }
  
  private ReadInJoyDynamicGridView.DynamicGridAdapterInterface a()
  {
    return (ReadInJoyDynamicGridView.DynamicGridAdapterInterface)getAdapter();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$OnDragListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$OnDragListener.a(paramInt1, paramInt2);
    }
    a().b(paramInt1, paramInt2);
  }
  
  private void a(int paramInt1, int paramInt2, View paramView)
  {
    int m;
    int n;
    if (paramView != null)
    {
      m = getPositionForView(this.jdField_a_of_type_AndroidViewView);
      n = getPositionForView(paramView);
      paramView = a();
      if ((n == -1) || (!paramView.a(m)) || (!paramView.a(n)) || (n < this.k)) {
        a(this.jdField_a_of_type_Long);
      }
    }
    else
    {
      return;
    }
    a(m, n);
    this.jdField_d_of_type_Int = this.jdField_e_of_type_Int;
    this.jdField_c_of_type_Int = this.jdField_f_of_type_Int;
    if ((c()) && (b())) {
      paramView = new ReadInJoyDynamicGridView.KitKatSwitchCellAnimator(this, paramInt2, paramInt1);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Long);
      paramView.a(m, n);
      return;
      if (b()) {
        paramView = new ReadInJoyDynamicGridView.PreHoneycombCellAnimator(this, paramInt2, paramInt1);
      } else {
        paramView = new ReadInJoyDynamicGridView.LSwitchCellAnimator(this, paramInt2, paramInt1);
      }
    }
  }
  
  private void a(long paramLong)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    int n = a(paramLong);
    int m = getFirstVisiblePosition();
    while (m <= getLastVisiblePosition())
    {
      if ((n != m) && (a().a(m))) {
        this.jdField_a_of_type_JavaUtilList.add(Long.valueOf(a(m)));
      }
      m += 1;
    }
  }
  
  @TargetApi(11)
  private void a(View paramView)
  {
    Object localObject = new ReadInJoyDynamicGridView.2(this);
    localObject = ObjectAnimator.ofObject(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable, "bounds", (TypeEvaluator)localObject, new Object[] { this.jdField_a_of_type_AndroidGraphicsRect });
    ((ObjectAnimator)localObject).addUpdateListener(new ReadInJoyDynamicGridView.3(this));
    ((ObjectAnimator)localObject).addListener(new ReadInJoyDynamicGridView.4(this, paramView));
    ((ObjectAnimator)localObject).start();
  }
  
  public static void a(List paramList, int paramInt1, int paramInt2)
  {
    paramList.add(paramInt2, paramList.remove(paramInt1));
  }
  
  private boolean a(int paramInt1, int paramInt2, Point paramPoint1, View paramView, Point paramPoint2)
  {
    return (b(paramInt1, paramInt2, paramPoint1, paramView, paramPoint2)) || (c(paramInt1, paramInt2, paramPoint1, paramView, paramPoint2));
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
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$OnSelectedItemBitmapCreationListener != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$OnSelectedItemBitmapCreationListener.a(localView, paramInt, this.jdField_a_of_type_Long);
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = a(localView);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$OnSelectedItemBitmapCreationListener != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$OnSelectedItemBitmapCreationListener.b(localView, paramInt, this.jdField_a_of_type_Long);
      }
      if (c()) {
        localView.setVisibility(4);
      }
      this.jdField_a_of_type_Boolean = true;
      a(this.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$OnDragListener != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$OnDragListener.a(paramInt);
      }
    }
  }
  
  @TargetApi(11)
  private void b(int paramInt1, int paramInt2)
  {
    LinkedList localLinkedList;
    if (paramInt2 > paramInt1)
    {
      m = 1;
      localLinkedList = new LinkedList();
      if (m == 0) {
        break label139;
      }
      m = Math.min(paramInt1, paramInt2);
      label26:
      if (m >= Math.max(paramInt1, paramInt2)) {
        break label257;
      }
      localObject = a(a(m));
      if (localObject != null) {
        break label63;
      }
    }
    for (;;)
    {
      m += 1;
      break label26;
      m = 0;
      break;
      label63:
      if ((m + 1) % a() == 0) {
        localLinkedList.add(a((View)localObject, -((View)localObject).getWidth() * (a() - 1), 0.0F, ((View)localObject).getHeight(), 0.0F));
      } else {
        localLinkedList.add(a((View)localObject, ((View)localObject).getWidth(), 0.0F, 0.0F, 0.0F));
      }
    }
    label139:
    int m = Math.max(paramInt1, paramInt2);
    if (m > Math.min(paramInt1, paramInt2))
    {
      localObject = a(a(m));
      if (localObject == null) {}
      for (;;)
      {
        m -= 1;
        break;
        if ((a() + m) % a() == 0) {
          localLinkedList.add(a((View)localObject, ((View)localObject).getWidth() * (a() - 1), 0.0F, -((View)localObject).getHeight(), 0.0F));
        } else {
          localLinkedList.add(a((View)localObject, -((View)localObject).getWidth(), 0.0F, 0.0F, 0.0F));
        }
      }
    }
    label257:
    Object localObject = new AnimatorSet();
    ((AnimatorSet)localObject).playTogether(localLinkedList);
    ((AnimatorSet)localObject).setDuration(300L);
    ((AnimatorSet)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
    ((AnimatorSet)localObject).addListener(new ReadInJoyDynamicGridView.5(this));
    ((AnimatorSet)localObject).start();
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Long = -1L;
    paramView.setVisibility(0);
    this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = null;
    int m = 0;
    while (m < getLastVisiblePosition() - getFirstVisiblePosition())
    {
      paramView = getChildAt(m);
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      m += 1;
    }
    invalidate();
  }
  
  public static boolean b()
  {
    return Build.VERSION.SDK_INT < 21;
  }
  
  private boolean b(int paramInt1, int paramInt2, Point paramPoint1, View paramView, Point paramPoint2)
  {
    return ((d(paramPoint2, paramPoint1)) && (paramInt1 < paramView.getBottom()) && (paramInt2 > paramView.getLeft())) || ((c(paramPoint2, paramPoint1)) && (paramInt1 < paramView.getBottom()) && (paramInt2 < paramView.getRight())) || ((b(paramPoint2, paramPoint1)) && (paramInt1 > paramView.getTop()) && (paramInt2 > paramView.getLeft())) || ((a(paramPoint2, paramPoint1)) && (paramInt1 > paramView.getTop()) && (paramInt2 < paramView.getRight()));
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
  
  private boolean c(int paramInt1, int paramInt2, Point paramPoint1, View paramView, Point paramPoint2)
  {
    return ((e(paramPoint2, paramPoint1)) && (paramInt1 < paramView.getBottom() - this.jdField_g_of_type_Int)) || ((f(paramPoint2, paramPoint1)) && (paramInt1 > paramView.getTop() + this.jdField_g_of_type_Int)) || ((g(paramPoint2, paramPoint1)) && (paramInt2 > paramView.getLeft() + this.jdField_g_of_type_Int)) || ((h(paramPoint2, paramPoint1)) && (paramInt2 < paramView.getRight() - this.jdField_g_of_type_Int));
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
    int m = this.jdField_e_of_type_Int - this.jdField_d_of_type_Int;
    int n = this.jdField_f_of_type_Int - this.jdField_c_of_type_Int;
    int i1 = this.jdField_b_of_type_AndroidGraphicsRect.centerY();
    int i2 = this.jdField_a_of_type_Int;
    int i3 = this.jdField_b_of_type_AndroidGraphicsRect.centerX();
    int i4 = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_AndroidViewView = a(this.jdField_a_of_type_Long);
    Object localObject = null;
    Point localPoint = a(this.jdField_a_of_type_AndroidViewView);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    float f1 = 0.0F;
    if (localIterator.hasNext())
    {
      View localView = a(((Long)localIterator.next()).longValue());
      if ((localView == null) || (!a(i1 + i2 + m, i3 + i4 + n, localPoint, localView, a(localView)))) {
        break label230;
      }
      float f4 = Math.abs(a(localView) - a(this.jdField_a_of_type_AndroidViewView));
      float f3 = Math.abs(b(localView) - b(this.jdField_a_of_type_AndroidViewView));
      if ((f4 < f1) || (f3 < f2)) {
        break label230;
      }
      localObject = localView;
      f1 = f4;
      f2 = f3;
    }
    label230:
    for (;;)
    {
      break;
      a(m, n, localObject);
      return;
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
    int n = getFirstVisiblePosition();
    ListAdapter localListAdapter = getAdapter();
    int m = 0;
    while (m < getChildCount())
    {
      View localView = getChildAt(m);
      if (localListAdapter.getItemId(n + m) == paramLong) {
        return localView;
      }
      m += 1;
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_d_of_type_Boolean = false;
    requestDisallowInterceptTouchEvent(false);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$OnEditModeChangeListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$OnEditModeChangeListener.a(false);
    }
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_g_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_d_of_type_Boolean = true;
      requestDisallowInterceptTouchEvent(true);
      if (paramInt != -1) {
        b(paramInt);
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$OnEditModeChangeListener == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$OnEditModeChangeListener.a(true);
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    Object localObject;
    if ((c()) && (b())) {
      localObject = new ReadInJoyDynamicGridView.KitKatSwitchCellAnimator(this, 0, 0);
    }
    for (;;)
    {
      if ((getAdapter() instanceof ReadInJoyDynamicGridView.BaseDynamicGridAdapter)) {
        ((ReadInJoyDynamicGridView.BaseDynamicGridAdapter)getAdapter()).a(0, paramObject);
      }
      ((ReadInJoyDynamicGridView.SwitchCellAnimator)localObject).a(paramInt1 + 1, paramInt2);
      return;
      if (b()) {
        localObject = new ReadInJoyDynamicGridView.PreHoneycombCellAnimator(this, 0, 0);
      } else {
        localObject = new ReadInJoyDynamicGridView.LSwitchCellAnimator(this, 0, 0);
      }
    }
  }
  
  public void a(Context paramContext)
  {
    super.setOnScrollListener(this.jdField_b_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.i = ((int)(8.0F * paramContext.density + 0.5F));
    this.jdField_g_of_type_Int = ((int)(paramContext.density * 16.0F + 0.5F));
    setNumColumns(4);
    setHorizontalSpacing(ViewUtils.a(0.0F));
    setVerticalSpacing(ViewUtils.a(0.0F));
    setSelector(17170445);
    setClipChildren(false);
  }
  
  public void a(Object paramObject)
  {
    if ((getAdapter() instanceof ReadInJoyDynamicGridView.BaseDynamicGridAdapter)) {
      ((ReadInJoyDynamicGridView.BaseDynamicGridAdapter)getAdapter()).b(paramObject);
    }
  }
  
  public boolean a()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < this.k) {
      return false;
    }
    Object localObject;
    if ((c()) && (b())) {
      localObject = new ReadInJoyDynamicGridView.KitKatSwitchCellAnimator(this, 0, 0);
    }
    for (;;)
    {
      a().b(paramInt1);
      ((ReadInJoyDynamicGridView.SwitchCellAnimator)localObject).a(paramInt1, paramInt2);
      return true;
      if (b()) {
        localObject = new ReadInJoyDynamicGridView.PreHoneycombCellAnimator(this, 0, 0);
      } else {
        localObject = new ReadInJoyDynamicGridView.LSwitchCellAnimator(this, 0, 0);
      }
    }
  }
  
  public boolean a(Rect paramRect)
  {
    int m = computeVerticalScrollOffset();
    int n = getHeight();
    int i1 = computeVerticalScrollExtent();
    int i2 = computeVerticalScrollRange();
    int i3 = paramRect.top;
    int i4 = paramRect.height();
    if ((i3 <= 0) && (m > 0))
    {
      smoothScrollBy(-this.i, 0);
      return true;
    }
    if ((i3 + i4 >= n) && (m + i1 < i2))
    {
      smoothScrollBy(this.i, 0);
      return true;
    }
    return false;
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.draw(paramCanvas);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() & 0xFF) == 2) {
      return (this.jdField_d_of_type_Boolean) && (super.dispatchTouchEvent(paramMotionEvent));
    }
    return super.dispatchTouchEvent(paramMotionEvent);
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
          int m = paramMotionEvent.findPointerIndex(this.jdField_h_of_type_Int);
          this.jdField_e_of_type_Int = ((int)paramMotionEvent.getY(m));
          this.jdField_f_of_type_Int = ((int)paramMotionEvent.getX(m));
          m = this.jdField_e_of_type_Int;
          int n = this.jdField_d_of_type_Int;
          int i1 = this.jdField_f_of_type_Int;
          int i2 = this.jdField_c_of_type_Int;
          if (this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidGraphicsRect.offsetTo(i1 - i2 + this.jdField_b_of_type_AndroidGraphicsRect.left + this.jdField_b_of_type_Int, m - n + this.jdField_b_of_type_AndroidGraphicsRect.top + this.jdField_a_of_type_Int);
            this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.setBounds(this.jdField_a_of_type_AndroidGraphicsRect);
            invalidate();
            f();
            this.jdField_b_of_type_Boolean = false;
            b();
            return false;
            c();
            if ((this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$OnDropListener != null))
            {
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$OnDropListener.a();
              continue;
              e();
              if ((this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$OnDropListener != null))
              {
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$OnDropListener.a();
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
  
  public void setLockCount(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void setOnDragListener(ReadInJoyDynamicGridView.OnDragListener paramOnDragListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$OnDragListener = paramOnDragListener;
  }
  
  public void setOnDropListener(ReadInJoyDynamicGridView.OnDropListener paramOnDropListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$OnDropListener = paramOnDropListener;
  }
  
  public void setOnEditModeChangeListener(ReadInJoyDynamicGridView.OnEditModeChangeListener paramOnEditModeChangeListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$OnEditModeChangeListener = paramOnEditModeChangeListener;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = paramOnItemClickListener;
    super.setOnItemClickListener(this.jdField_b_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
  }
  
  public void setOnSelectedItemBitmapCreationListener(ReadInJoyDynamicGridView.OnSelectedItemBitmapCreationListener paramOnSelectedItemBitmapCreationListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$OnSelectedItemBitmapCreationListener = paramOnSelectedItemBitmapCreationListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView
 * JD-Core Version:    0.7.0.1
 */