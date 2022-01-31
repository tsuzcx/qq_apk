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
import bdkf;
import bhpo;
import bhqp;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import sid;
import sie;
import sif;
import sig;
import sih;
import sii;
import sik;
import sil;
import sim;
import sio;
import siq;
import sir;
import sis;
import sit;
import siu;
import siv;

public class ReadInJoyDynamicGridView
  extends GridView
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  private View jdField_a_of_type_AndroidViewView;
  private bhpo jdField_a_of_type_Bhpo;
  private bhqp jdField_a_of_type_Bhqp;
  private List<Long> jdField_a_of_type_JavaUtilList = new ArrayList();
  private siq jdField_a_of_type_Siq;
  private sir jdField_a_of_type_Sir;
  private sis jdField_a_of_type_Sis;
  private sit jdField_a_of_type_Sit;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  private bhpo jdField_b_of_type_Bhpo = new sii(this);
  private bhqp jdField_b_of_type_Bhqp = new sid(this);
  private boolean jdField_b_of_type_Boolean;
  private int c = -1;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = -1;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int = -1;
  private boolean jdField_h_of_type_Boolean = true;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean;
  private int j = 0;
  private int k;
  
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
    return Math.abs((paramView.getRight() - paramView.getLeft()) / 2);
  }
  
  private long a(int paramInt)
  {
    return a().getItemId(paramInt);
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
    int n = d();
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
  
  private sil a()
  {
    return (sil)a();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Siq != null) {
      this.jdField_a_of_type_Siq.a(paramInt1, paramInt2);
    }
    a().b(paramInt1, paramInt2);
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
    Object localObject = new sie(this);
    localObject = ObjectAnimator.ofObject(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable, "bounds", (TypeEvaluator)localObject, new Object[] { this.jdField_a_of_type_AndroidGraphicsRect });
    ((ObjectAnimator)localObject).addUpdateListener(new sif(this));
    ((ObjectAnimator)localObject).addListener(new sig(this, paramView));
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
      this.jdField_a_of_type_Long = a().getItemId(paramInt);
      if (this.jdField_a_of_type_Sit != null) {
        this.jdField_a_of_type_Sit.a(localView, paramInt, this.jdField_a_of_type_Long);
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = a(localView);
      if (this.jdField_a_of_type_Sit != null) {
        this.jdField_a_of_type_Sit.b(localView, paramInt, this.jdField_a_of_type_Long);
      }
      if (c()) {
        localView.setVisibility(4);
      }
      this.jdField_a_of_type_Boolean = true;
      a(this.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_Siq != null) {
        this.jdField_a_of_type_Siq.a(paramInt);
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
      if ((m + 1) % d() == 0) {
        localLinkedList.add(a((View)localObject, -((View)localObject).getWidth() * (d() - 1), 0.0F, ((View)localObject).getHeight(), 0.0F));
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
        if ((d() + m) % d() == 0) {
          localLinkedList.add(a((View)localObject, ((View)localObject).getWidth() * (d() - 1), 0.0F, -((View)localObject).getHeight(), 0.0F));
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
    ((AnimatorSet)localObject).addListener(new sih(this));
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
  
  private boolean b(Point paramPoint1, Point paramPoint2)
  {
    return (paramPoint1.y > paramPoint2.y) && (paramPoint1.x > paramPoint2.x);
  }
  
  private void c()
  {
    View localView = a(this.jdField_a_of_type_Long);
    if ((localView != null) && ((this.jdField_a_of_type_Boolean) || (this.jdField_d_of_type_Boolean)))
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_d_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_h_of_type_Int = -1;
      if (this.j != 0)
      {
        this.jdField_d_of_type_Boolean = true;
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
  
  private int d()
  {
    return a().a();
  }
  
  private void d()
  {
    if ((!this.jdField_f_of_type_Boolean) && (!this.jdField_g_of_type_Boolean)) {}
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
    int n = this.jdField_f_of_type_Int - this.c;
    int i1 = this.jdField_b_of_type_AndroidGraphicsRect.centerY() + this.jdField_a_of_type_Int + m;
    int i2 = this.jdField_b_of_type_AndroidGraphicsRect.centerX() + this.jdField_b_of_type_Int + n;
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
        break label620;
      }
      Point localPoint2 = a(localView);
      if (((!d(localPoint2, localPoint1)) || (i1 >= localView.getBottom()) || (i2 <= localView.getLeft())) && ((!c(localPoint2, localPoint1)) || (i1 >= localView.getBottom()) || (i2 >= localView.getRight())) && ((!b(localPoint2, localPoint1)) || (i1 <= localView.getTop()) || (i2 <= localView.getLeft())) && ((!a(localPoint2, localPoint1)) || (i1 <= localView.getTop()) || (i2 >= localView.getRight())) && ((!e(localPoint2, localPoint1)) || (i1 >= localView.getBottom() - this.jdField_g_of_type_Int)) && ((!f(localPoint2, localPoint1)) || (i1 <= localView.getTop() + this.jdField_g_of_type_Int)) && ((!g(localPoint2, localPoint1)) || (i2 <= localView.getLeft() + this.jdField_g_of_type_Int)) && ((!h(localPoint2, localPoint1)) || (i2 >= localView.getRight() - this.jdField_g_of_type_Int))) {
        break label620;
      }
      float f4 = Math.abs(a(localView) - a(this.jdField_a_of_type_AndroidViewView));
      f3 = Math.abs(b(localView) - b(this.jdField_a_of_type_AndroidViewView));
      if ((f4 < f1) || (f3 < f2)) {
        break label620;
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
        i1 = getPositionForView(this.jdField_a_of_type_AndroidViewView);
        i2 = getPositionForView((View)localObject);
        localObject = a();
        if ((i2 == -1) || (!((sil)localObject).a(i1)) || (!((sil)localObject).a(i2)) || (i2 < this.k)) {
          a(this.jdField_a_of_type_Long);
        }
      }
      else
      {
        return;
      }
      a(i1, i2);
      this.jdField_d_of_type_Int = this.jdField_e_of_type_Int;
      this.c = this.jdField_f_of_type_Int;
      if ((c()) && (b())) {
        localObject = new sim(this, n, m);
      }
      for (;;)
      {
        a(this.jdField_a_of_type_Long);
        ((siv)localObject).a(i1, i2);
        return;
        if (b()) {
          localObject = new siu(this, n, m);
        } else {
          localObject = new sio(this, n, m);
        }
      }
      label620:
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
    int n = getFirstVisiblePosition();
    ListAdapter localListAdapter = a();
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
    this.jdField_e_of_type_Boolean = false;
    requestDisallowInterceptTouchEvent(false);
    if (this.jdField_a_of_type_Sis != null) {
      this.jdField_a_of_type_Sis.a(false);
    }
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_h_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_e_of_type_Boolean = true;
      requestDisallowInterceptTouchEvent(true);
      if (paramInt != -1) {
        b(paramInt);
      }
    } while (this.jdField_a_of_type_Sis == null);
    this.jdField_a_of_type_Sis.a(true);
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    Object localObject;
    if ((c()) && (b())) {
      localObject = new sim(this, 0, 0);
    }
    for (;;)
    {
      if ((a() instanceof sik)) {
        ((sik)a()).a(0, paramObject);
      }
      ((siv)localObject).a(paramInt1 + 1, paramInt2);
      return;
      if (b()) {
        localObject = new siu(this, 0, 0);
      } else {
        localObject = new sio(this, 0, 0);
      }
    }
  }
  
  public void a(Context paramContext)
  {
    super.setOnScrollListener(this.jdField_b_of_type_Bhpo);
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.jdField_i_of_type_Int = ((int)(8.0F * paramContext.density + 0.5F));
    this.jdField_g_of_type_Int = ((int)(paramContext.density * 16.0F + 0.5F));
    setNumColumns(4);
    setHorizontalSpacing(bdkf.a(0.0F));
    setVerticalSpacing(bdkf.a(0.0F));
    setSelector(17170445);
    setClipChildren(false);
  }
  
  public void a(Object paramObject)
  {
    if ((a() instanceof sik)) {
      ((sik)a()).b(paramObject);
    }
  }
  
  public boolean a()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < this.k) {
      return false;
    }
    Object localObject;
    if ((c()) && (b())) {
      localObject = new sim(this, 0, 0);
    }
    for (;;)
    {
      a().b(paramInt1);
      ((siv)localObject).a(paramInt1, paramInt2);
      return true;
      if (b()) {
        localObject = new siu(this, 0, 0);
      } else {
        localObject = new sio(this, 0, 0);
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
      smoothScrollBy(-this.jdField_i_of_type_Int, 0);
      return true;
    }
    if ((i3 + i4 >= n) && (m + i1 < i2))
    {
      smoothScrollBy(this.jdField_i_of_type_Int, 0);
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
      return (this.jdField_e_of_type_Boolean) && (super.dispatchTouchEvent(paramMotionEvent));
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_i_of_type_Boolean)
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
      this.c = ((int)paramMotionEvent.getX());
      this.jdField_d_of_type_Int = ((int)paramMotionEvent.getY());
      this.jdField_h_of_type_Int = paramMotionEvent.getPointerId(0);
      if ((this.jdField_e_of_type_Boolean) && (isEnabled()))
      {
        layoutChildren();
        b(pointToPosition(this.c, this.jdField_d_of_type_Int));
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
          int i2 = this.c;
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
            if ((this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != null) && (this.jdField_a_of_type_Sir != null))
            {
              this.jdField_a_of_type_Sir.a();
              continue;
              e();
              if ((this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != null) && (this.jdField_a_of_type_Sir != null))
              {
                this.jdField_a_of_type_Sir.a();
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
    this.jdField_h_of_type_Boolean = paramBoolean;
  }
  
  public void setExpendable(boolean paramBoolean)
  {
    this.jdField_i_of_type_Boolean = paramBoolean;
  }
  
  public void setLockCount(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void setOnDragListener(siq paramsiq)
  {
    this.jdField_a_of_type_Siq = paramsiq;
  }
  
  public void setOnDropListener(sir paramsir)
  {
    this.jdField_a_of_type_Sir = paramsir;
  }
  
  public void setOnEditModeChangeListener(sis paramsis)
  {
    this.jdField_a_of_type_Sis = paramsis;
  }
  
  public void setOnItemClickListener(bhqp parambhqp)
  {
    this.jdField_a_of_type_Bhqp = parambhqp;
    super.setOnItemClickListener(this.jdField_b_of_type_Bhqp);
  }
  
  public void setOnScrollListener(bhpo parambhpo)
  {
    this.jdField_a_of_type_Bhpo = parambhpo;
  }
  
  public void setOnSelectedItemBitmapCreationListener(sit paramsit)
  {
    this.jdField_a_of_type_Sit = paramsit;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView
 * JD-Core Version:    0.7.0.1
 */