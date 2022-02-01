package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.FocusFinder;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class XViewPager
  extends ViewGroup
{
  private static final Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new XViewPager.2();
  private static final XViewPager.ViewPositionComparator jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$ViewPositionComparator = new XViewPager.ViewPositionComparator();
  private static final Comparator<XViewPager.ItemInfo> jdField_a_of_type_JavaUtilComparator;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16842931 };
  private float jdField_a_of_type_Float = 0.6F;
  protected int a;
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Parcelable jdField_a_of_type_AndroidOsParcelable = null;
  private PagerAdapter jdField_a_of_type_AndroidSupportV4ViewPagerAdapter;
  private EdgeEffectCompat jdField_a_of_type_AndroidSupportV4WidgetEdgeEffectCompat;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private final XViewPager.ItemInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$ItemInfo = new XViewPager.ItemInfo();
  private XViewPager.OnAdapterChangeListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnAdapterChangeListener;
  private XViewPager.OnDragStatusChangedListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnDragStatusChangedListener;
  private XViewPager.OnPageChangeListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener;
  private XViewPager.OnVisibilityChangeListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnVisibilityChangeListener;
  private XViewPager.PageTransformer jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$PageTransformer = null;
  private XViewPager.PagerObserver jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$PagerObserver;
  private ClassLoader jdField_a_of_type_JavaLangClassLoader = null;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new XViewPager.3(this);
  public String a;
  private Method jdField_a_of_type_JavaLangReflectMethod;
  private final ArrayList<XViewPager.ItemInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<XViewPager.OnPageChangeListener> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float = -3.402824E+038F;
  private int jdField_b_of_type_Int = -1;
  private EdgeEffectCompat jdField_b_of_type_AndroidSupportV4WidgetEdgeEffectCompat;
  private XViewPager.OnPageChangeListener jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener;
  private XViewPager.PageTransformer jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$PageTransformer;
  private ArrayList<View> jdField_b_of_type_JavaUtilArrayList;
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float = 3.4028235E+38F;
  private int jdField_c_of_type_Int = 1;
  private EdgeEffectCompat jdField_c_of_type_AndroidSupportV4WidgetEdgeEffectCompat;
  private boolean jdField_c_of_type_Boolean = true;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private EdgeEffectCompat jdField_d_of_type_AndroidSupportV4WidgetEdgeEffectCompat;
  private boolean jdField_d_of_type_Boolean = true;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean = false;
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int = -1;
  private boolean jdField_f_of_type_Boolean;
  private float jdField_g_of_type_Float;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int;
  private boolean jdField_l_of_type_Boolean = true;
  private int jdField_m_of_type_Int;
  private boolean jdField_m_of_type_Boolean = false;
  private int jdField_n_of_type_Int = 1;
  private boolean jdField_n_of_type_Boolean = false;
  private int jdField_o_of_type_Int;
  private boolean jdField_o_of_type_Boolean;
  private int jdField_p_of_type_Int;
  private boolean jdField_p_of_type_Boolean = false;
  private int q;
  private int r = -1;
  private int s;
  private int t;
  private int u;
  private int v;
  private int w;
  private int x;
  private int y = 0;
  private int z = 0;
  
  static
  {
    jdField_a_of_type_JavaUtilComparator = new XViewPager.1();
  }
  
  public XViewPager(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangString = ("XViewPager" + System.identityHashCode(this));
    a();
  }
  
  public XViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaLangString = ("XViewPager" + System.identityHashCode(this));
    a();
  }
  
  private int a(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    if ((Math.abs(paramInt3) > this.u) && (Math.abs(paramInt2) > this.s))
    {
      if (paramInt2 > 0) {}
      for (;;)
      {
        paramInt2 = paramInt1;
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          if (this.jdField_n_of_type_Int != 0) {
            break;
          }
          paramInt2 = Math.max(0, Math.min(paramInt1, this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getCount()));
        }
        return paramInt2;
        paramInt1 += 1;
      }
    }
    if (paramInt1 >= this.jdField_e_of_type_Int) {}
    for (float f1 = 1.0F - this.jdField_a_of_type_Float;; f1 = this.jdField_a_of_type_Float)
    {
      paramInt1 = (int)(f1 + (paramInt1 + paramFloat));
      break;
    }
    XViewPager.ItemInfo localItemInfo1 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    XViewPager.ItemInfo localItemInfo2 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    return Math.max(localItemInfo1.jdField_a_of_type_Int, Math.min(paramInt1, localItemInfo2.jdField_a_of_type_Int));
  }
  
  private Rect a(Rect paramRect, View paramView)
  {
    if (paramRect == null) {
      paramRect = new Rect();
    }
    for (;;)
    {
      if (paramView == null)
      {
        paramRect.set(0, 0, 0, 0);
        return paramRect;
      }
      paramRect.left = paramView.getLeft();
      paramRect.right = paramView.getRight();
      paramRect.top = paramView.getTop();
      paramRect.bottom = paramView.getBottom();
      for (paramView = paramView.getParent(); ((paramView instanceof ViewGroup)) && (paramView != this); paramView = paramView.getParent())
      {
        paramView = (ViewGroup)paramView;
        paramRect.left += paramView.getLeft();
        paramRect.right += paramView.getRight();
        paramRect.top += paramView.getTop();
        paramRect.bottom += paramView.getBottom();
      }
      return paramRect;
    }
  }
  
  private XViewPager.ItemInfo a()
  {
    Object localObject2;
    if (f()) {
      localObject2 = b();
    }
    int i1;
    float f1;
    label37:
    float f2;
    label52:
    float f4;
    float f3;
    int i3;
    int i2;
    Object localObject1;
    label69:
    do
    {
      return localObject2;
      i1 = d();
      if (i1 <= 0) {
        break;
      }
      f1 = getScrollX() / i1;
      if (i1 <= 0) {
        break label226;
      }
      f2 = this.jdField_g_of_type_Int / i1;
      f4 = 0.0F;
      f3 = 0.0F;
      i3 = -1;
      i1 = 0;
      i2 = 1;
      localObject1 = null;
      localObject2 = localObject1;
    } while (i1 >= this.jdField_a_of_type_JavaUtilArrayList.size());
    XViewPager.ItemInfo localItemInfo = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
    if ((i2 == 0) && (localItemInfo.jdField_a_of_type_Int != i3 + 1))
    {
      localItemInfo = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$ItemInfo;
      localItemInfo.jdField_b_of_type_Float = (f4 + f3 + f2);
      localItemInfo.jdField_a_of_type_Int = (i3 + 1);
      localItemInfo.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getPageWidth(localItemInfo.jdField_a_of_type_Int);
      i1 -= 1;
    }
    for (;;)
    {
      f3 = localItemInfo.jdField_b_of_type_Float;
      f4 = localItemInfo.jdField_a_of_type_Float;
      if (i2 == 0)
      {
        localObject2 = localObject1;
        if (f1 < f3) {
          break;
        }
      }
      if ((f1 < f4 + f3 + f2) || (i1 == this.jdField_a_of_type_JavaUtilArrayList.size() - 1))
      {
        return localItemInfo;
        f1 = 0.0F;
        break label37;
        label226:
        f2 = 0.0F;
        break label52;
      }
      i3 = localItemInfo.jdField_a_of_type_Int;
      f4 = localItemInfo.jdField_a_of_type_Float;
      i2 = 0;
      localObject1 = localItemInfo;
      i1 += 1;
      break label69;
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { getScrollX(), paramInt2 });
    localValueAnimator.setDuration(this.y);
    localValueAnimator.addUpdateListener(new XViewPager.4(this));
    localValueAnimator.addListener(new XViewPager.5(this));
    localValueAnimator.start();
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 > 0) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      int i1 = getPaddingLeft();
      int i2 = getPaddingRight();
      int i3 = getPaddingLeft();
      int i4 = getPaddingRight();
      f1 = getScrollX() / (paramInt2 - i3 - i4 + paramInt4);
      paramInt2 = (int)((paramInt1 - i1 - i2 + paramInt3) * f1);
      scrollTo(paramInt2, getScrollY());
      if (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished())
      {
        paramInt3 = this.jdField_a_of_type_AndroidWidgetScroller.getDuration();
        paramInt4 = this.jdField_a_of_type_AndroidWidgetScroller.timePassed();
        localItemInfo = a(this.jdField_e_of_type_Int);
        if (localItemInfo != null) {
          this.jdField_a_of_type_AndroidWidgetScroller.startScroll(paramInt2, 0, (int)(localItemInfo.jdField_b_of_type_Float * paramInt1), 0, paramInt3 - paramInt4);
        }
      }
      return;
    }
    XViewPager.ItemInfo localItemInfo = a(this.jdField_e_of_type_Int);
    if (localItemInfo != null) {}
    for (float f1 = Math.min(localItemInfo.jdField_b_of_type_Float, this.jdField_c_of_type_Float);; f1 = 0.0F)
    {
      paramInt1 = (int)(f1 * (paramInt1 - getPaddingLeft() - getPaddingRight()));
      if (paramInt1 == getScrollX()) {
        break;
      }
      b(false);
      scrollTo(paramInt1, getScrollY());
      return;
    }
  }
  
  private void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    int i2 = 0;
    Object localObject = a(paramInt1);
    float f1;
    if (localObject != null) {
      f1 = d();
    }
    for (int i1 = (int)(Math.max(this.jdField_b_of_type_Float, Math.min(((XViewPager.ItemInfo)localObject).jdField_b_of_type_Float, this.jdField_c_of_type_Float)) * f1);; i1 = 0)
    {
      if (paramBoolean1)
      {
        a(i1, 0, paramInt2);
        if ((paramBoolean2) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener != null)) {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener.a(paramInt1);
        }
        if ((paramBoolean2) && (this.jdField_a_of_type_JavaUtilList != null))
        {
          i1 = this.jdField_a_of_type_JavaUtilList.size();
          paramInt2 = i2;
          while (paramInt2 < i1)
          {
            localObject = (XViewPager.OnPageChangeListener)this.jdField_a_of_type_JavaUtilList.get(paramInt2);
            if (localObject != null) {
              ((XViewPager.OnPageChangeListener)localObject).a(paramInt1);
            }
            paramInt2 += 1;
          }
        }
        if ((paramBoolean2) && (this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener != null)) {
          this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener.a(paramInt1);
        }
        return;
      }
      if ((paramBoolean2) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener != null)) {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener.a(paramInt1);
      }
      if ((paramBoolean2) && (this.jdField_a_of_type_JavaUtilList != null))
      {
        i2 = this.jdField_a_of_type_JavaUtilList.size();
        paramInt2 = 0;
        while (paramInt2 < i2)
        {
          localObject = (XViewPager.OnPageChangeListener)this.jdField_a_of_type_JavaUtilList.get(paramInt2);
          if (localObject != null) {
            ((XViewPager.OnPageChangeListener)localObject).a(paramInt1);
          }
          paramInt2 += 1;
        }
      }
      if ((paramBoolean2) && (this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener != null)) {
        this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener.a(paramInt1);
      }
      b(false);
      if (this.jdField_p_of_type_Boolean)
      {
        a(paramInt1, i1);
        return;
      }
      scrollTo(i1, 0);
      b(i1);
      return;
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (MotionEventCompat.getPointerId(paramMotionEvent, i1) == this.r) {
      if (i1 != 0) {
        break label65;
      }
    }
    label65:
    for (i1 = 1;; i1 = 0)
    {
      this.jdField_d_of_type_Float = MotionEventCompat.getX(paramMotionEvent, i1);
      this.jdField_e_of_type_Float = MotionEventCompat.getY(paramMotionEvent, i1);
      this.r = MotionEventCompat.getPointerId(paramMotionEvent, i1);
      if (this.jdField_a_of_type_AndroidViewVelocityTracker != null) {
        this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
      }
      return;
    }
  }
  
  private void a(XViewPager.ItemInfo paramItemInfo1, int paramInt, XViewPager.ItemInfo paramItemInfo2)
  {
    int i4 = this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getCount();
    int i1 = d();
    float f2;
    if (i1 > 0)
    {
      f2 = this.jdField_g_of_type_Int / i1;
      if (paramItemInfo2 == null) {
        break label409;
      }
      i1 = paramItemInfo2.jdField_a_of_type_Int;
      if (i1 < paramItemInfo1.jdField_a_of_type_Int)
      {
        f1 = paramItemInfo2.jdField_b_of_type_Float + paramItemInfo2.jdField_a_of_type_Float + f2;
        i1 += 1;
        i2 = 0;
      }
    }
    else
    {
      for (;;)
      {
        if ((i1 > paramItemInfo1.jdField_a_of_type_Int) || (i2 >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
          break label409;
        }
        for (paramItemInfo2 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i2);; paramItemInfo2 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i2))
        {
          i3 = i1;
          f3 = f1;
          if (i1 <= paramItemInfo2.jdField_a_of_type_Int) {
            break;
          }
          i3 = i1;
          f3 = f1;
          if (i2 >= this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
            break;
          }
          i2 += 1;
        }
        f2 = 0.0F;
        break;
        while (i3 < paramItemInfo2.jdField_a_of_type_Int)
        {
          f3 += this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getPageWidth(i3) + f2;
          i3 += 1;
        }
        paramItemInfo2.jdField_b_of_type_Float = f3;
        f1 = f3 + (paramItemInfo2.jdField_a_of_type_Float + f2);
        i1 = i3 + 1;
      }
    }
    if (i1 > paramItemInfo1.jdField_a_of_type_Int)
    {
      i2 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
      f1 = paramItemInfo2.jdField_b_of_type_Float;
      i1 -= 1;
      while ((i1 >= paramItemInfo1.jdField_a_of_type_Int) && (i2 >= 0))
      {
        for (paramItemInfo2 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i2);; paramItemInfo2 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i2))
        {
          i3 = i1;
          f3 = f1;
          if (i1 >= paramItemInfo2.jdField_a_of_type_Int) {
            break;
          }
          i3 = i1;
          f3 = f1;
          if (i2 <= 0) {
            break;
          }
          i2 -= 1;
        }
        while (i3 > paramItemInfo2.jdField_a_of_type_Int)
        {
          f3 -= this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getPageWidth(i3) + f2;
          i3 -= 1;
        }
        f1 = f3 - (paramItemInfo2.jdField_a_of_type_Float + f2);
        paramItemInfo2.jdField_b_of_type_Float = f1;
        i1 = i3 - 1;
      }
    }
    label409:
    int i3 = this.jdField_a_of_type_JavaUtilArrayList.size();
    float f3 = paramItemInfo1.jdField_b_of_type_Float;
    i1 = paramItemInfo1.jdField_a_of_type_Int - 1;
    if (paramItemInfo1.jdField_a_of_type_Int == 0)
    {
      f1 = paramItemInfo1.jdField_b_of_type_Float;
      this.jdField_b_of_type_Float = f1;
      if (paramItemInfo1.jdField_a_of_type_Int != i4 - 1) {
        break label550;
      }
      f1 = paramItemInfo1.jdField_b_of_type_Float + paramItemInfo1.jdField_a_of_type_Float - 1.0F;
      label475:
      this.jdField_c_of_type_Float = f1;
      i2 = paramInt - 1;
      f1 = f3;
    }
    for (;;)
    {
      if (i2 < 0) {
        break label603;
      }
      paramItemInfo2 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i2);
      for (;;)
      {
        if (i1 > paramItemInfo2.jdField_a_of_type_Int)
        {
          f1 -= this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getPageWidth(i1) + f2;
          i1 -= 1;
          continue;
          f1 = -3.402824E+038F;
          break;
          label550:
          f1 = 3.4028235E+38F;
          break label475;
        }
      }
      f1 -= paramItemInfo2.jdField_a_of_type_Float + f2;
      paramItemInfo2.jdField_b_of_type_Float = f1;
      if (paramItemInfo2.jdField_a_of_type_Int == 0) {
        this.jdField_b_of_type_Float = f1;
      }
      i1 -= 1;
      i2 -= 1;
    }
    label603:
    float f1 = paramItemInfo1.jdField_b_of_type_Float + paramItemInfo1.jdField_a_of_type_Float + f2;
    int i2 = paramItemInfo1.jdField_a_of_type_Int + 1;
    i1 = paramInt + 1;
    paramInt = i2;
    while (i1 < i3)
    {
      paramItemInfo1 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      while (paramInt < paramItemInfo1.jdField_a_of_type_Int)
      {
        f1 = this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getPageWidth(paramInt) + f2 + f1;
        paramInt += 1;
      }
      if (paramItemInfo1.jdField_a_of_type_Int == i4 - 1) {
        this.jdField_c_of_type_Float = (paramItemInfo1.jdField_a_of_type_Float + f1 - 1.0F);
      }
      paramItemInfo1.jdField_b_of_type_Float = f1;
      f1 += paramItemInfo1.jdField_a_of_type_Float + f2;
      paramInt += 1;
      i1 += 1;
    }
    this.jdField_n_of_type_Boolean = false;
  }
  
  private boolean a(float paramFloat)
  {
    int i2 = 1;
    f();
    float f1 = this.jdField_d_of_type_Float;
    this.jdField_d_of_type_Float = paramFloat;
    f1 = getScrollX() + (f1 - paramFloat);
    int i3 = d();
    paramFloat = i3 * this.jdField_b_of_type_Float;
    float f2 = i3;
    float f3 = this.jdField_c_of_type_Float;
    XViewPager.ItemInfo localItemInfo1 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    XViewPager.ItemInfo localItemInfo2 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    if (localItemInfo1.jdField_a_of_type_Int != 0) {
      paramFloat = localItemInfo1.jdField_b_of_type_Float * i3;
    }
    for (int i1 = 0;; i1 = 1)
    {
      if (localItemInfo2.jdField_a_of_type_Int != this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getCount() - 1)
      {
        f2 = localItemInfo2.jdField_b_of_type_Float * i3;
        i2 = 0;
      }
      for (;;)
      {
        if (f1 < paramFloat) {
          if (i1 == 0) {
            break label359;
          }
        }
        label318:
        label359:
        for (boolean bool1 = this.jdField_a_of_type_AndroidSupportV4WidgetEdgeEffectCompat.onPull(Math.abs(paramFloat - f1) / i3);; bool1 = false)
        {
          boolean bool2 = bool1;
          if (this.jdField_e_of_type_Boolean)
          {
            paramFloat = f1;
            bool2 = bool1;
          }
          for (;;)
          {
            f1 = paramFloat;
            if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnDragStatusChangedListener != null)
            {
              f1 = paramFloat;
              if (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnDragStatusChangedListener.a())
              {
                i1 = getWidth() * (c() - 1);
                if ((this.jdField_o_of_type_Int != 3) || (paramFloat >= i1)) {
                  break label318;
                }
                f1 = i1;
              }
            }
            label240:
            this.jdField_d_of_type_Float += f1 - (int)f1;
            scrollTo((int)f1, 0);
            b((int)f1);
            return bool2;
            if (f1 > f2)
            {
              if (i2 != 0) {}
              for (bool2 = this.jdField_b_of_type_AndroidSupportV4WidgetEdgeEffectCompat.onPull(Math.abs(f1 - f2) / i3);; bool2 = false)
              {
                if (this.jdField_e_of_type_Boolean)
                {
                  paramFloat = f1;
                  break;
                }
                paramFloat = f2;
                break;
                f1 = paramFloat;
                if (this.jdField_o_of_type_Int != 5) {
                  break label240;
                }
                f1 = paramFloat;
                if (paramFloat <= i1) {
                  break label240;
                }
                f1 = i1;
                break label240;
              }
            }
            paramFloat = f1;
            bool2 = false;
          }
        }
        f2 *= f3;
      }
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return ((paramFloat1 < this.q) && (paramFloat2 > 0.0F)) || ((paramFloat1 > getWidth() - this.q) && (paramFloat2 < 0.0F));
  }
  
  private XViewPager.ItemInfo b()
  {
    int i1 = e();
    float f1;
    float f2;
    label36:
    float f4;
    float f3;
    int i3;
    int i2;
    Object localObject1;
    label53:
    Object localObject2;
    XViewPager.ItemInfo localItemInfo;
    if (i1 > 0)
    {
      f1 = getScrollY() / i1;
      if (i1 <= 0) {
        break label214;
      }
      f2 = this.jdField_g_of_type_Int / i1;
      f4 = 0.0F;
      f3 = 0.0F;
      i3 = -1;
      i1 = 0;
      i2 = 1;
      localObject1 = null;
      localObject2 = localObject1;
      if (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localItemInfo = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        if ((i2 != 0) || (localItemInfo.jdField_a_of_type_Int == i3 + 1)) {
          break label249;
        }
        localItemInfo = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$ItemInfo;
        localItemInfo.jdField_b_of_type_Float = (f4 + f3 + f2);
        localItemInfo.jdField_a_of_type_Int = (i3 + 1);
        localItemInfo.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getPageWidth(localItemInfo.jdField_a_of_type_Int);
        i1 -= 1;
      }
    }
    label214:
    label219:
    label249:
    for (;;)
    {
      f3 = localItemInfo.jdField_b_of_type_Float;
      f4 = localItemInfo.jdField_a_of_type_Float;
      if (i2 == 0)
      {
        localObject2 = localObject1;
        if (f1 < f3) {}
      }
      else
      {
        if ((f1 >= f4 + f3 + f2) && (i1 != this.jdField_a_of_type_JavaUtilArrayList.size() - 1)) {
          break label219;
        }
        localObject2 = localItemInfo;
      }
      return localObject2;
      f1 = 0.0F;
      break;
      f2 = 0.0F;
      break label36;
      i3 = localItemInfo.jdField_a_of_type_Int;
      f4 = localItemInfo.jdField_a_of_type_Float;
      i2 = 0;
      i1 += 1;
      localObject1 = localItemInfo;
      break label53;
    }
  }
  
  private void b(int paramInt)
  {
    int i1 = 0;
    if (this.z == paramInt) {
      return;
    }
    this.z = paramInt;
    if (this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$PageTransformer != null) {
      if (paramInt == 0) {
        break label110;
      }
    }
    label110:
    for (boolean bool = true;; bool = false)
    {
      c(bool);
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener.b(paramInt);
      }
      if (this.jdField_a_of_type_JavaUtilList == null) {
        break;
      }
      int i2 = this.jdField_a_of_type_JavaUtilList.size();
      while (i1 < i2)
      {
        XViewPager.OnPageChangeListener localOnPageChangeListener = (XViewPager.OnPageChangeListener)this.jdField_a_of_type_JavaUtilList.get(i1);
        if (localOnPageChangeListener != null) {
          localOnPageChangeListener.b(paramInt);
        }
        i1 += 1;
      }
      break;
    }
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 > 0) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      int i1 = getPaddingTop();
      int i2 = getPaddingBottom();
      int i3 = getPaddingTop();
      int i4 = getPaddingBottom();
      f1 = getScrollY() / (paramInt2 - i3 - i4 + paramInt4);
      paramInt2 = (int)((paramInt1 - i1 - i2 + paramInt3) * f1);
      scrollTo(getScrollX(), paramInt2);
      if (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished())
      {
        paramInt3 = this.jdField_a_of_type_AndroidWidgetScroller.getDuration();
        paramInt4 = this.jdField_a_of_type_AndroidWidgetScroller.timePassed();
        localItemInfo = a(this.jdField_e_of_type_Int);
        if (localItemInfo != null) {
          this.jdField_a_of_type_AndroidWidgetScroller.startScroll(0, paramInt2, 0, (int)(localItemInfo.jdField_b_of_type_Float * paramInt1), paramInt3 - paramInt4);
        }
      }
      return;
    }
    XViewPager.ItemInfo localItemInfo = a(this.jdField_e_of_type_Int);
    if (localItemInfo != null) {}
    for (float f1 = Math.min(localItemInfo.jdField_b_of_type_Float, this.jdField_c_of_type_Float);; f1 = 0.0F)
    {
      paramInt1 = (int)(f1 * (paramInt1 - getPaddingTop() - getPaddingBottom()));
      if (paramInt1 == getScrollY()) {
        break;
      }
      b(false);
      scrollTo(getScrollX(), paramInt1);
      return;
    }
  }
  
  private void b(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    int i2 = 0;
    Object localObject = a(paramInt1);
    float f1;
    if (localObject != null) {
      f1 = e();
    }
    for (int i1 = (int)(Math.max(this.jdField_b_of_type_Float, Math.min(((XViewPager.ItemInfo)localObject).jdField_b_of_type_Float, this.jdField_c_of_type_Float)) * f1);; i1 = 0)
    {
      if (paramBoolean1)
      {
        a(0, i1, paramInt2);
        if ((paramBoolean2) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener != null)) {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener.a(paramInt1);
        }
        if ((paramBoolean2) && (this.jdField_a_of_type_JavaUtilList != null))
        {
          i1 = this.jdField_a_of_type_JavaUtilList.size();
          paramInt2 = i2;
          while (paramInt2 < i1)
          {
            localObject = (XViewPager.OnPageChangeListener)this.jdField_a_of_type_JavaUtilList.get(paramInt2);
            if (localObject != null) {
              ((XViewPager.OnPageChangeListener)localObject).a(paramInt1);
            }
            paramInt2 += 1;
          }
        }
        if ((paramBoolean2) && (this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener != null)) {
          this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener.a(paramInt1);
        }
        return;
      }
      if ((paramBoolean2) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener != null)) {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener.a(paramInt1);
      }
      if ((paramBoolean2) && (this.jdField_a_of_type_JavaUtilList != null))
      {
        i2 = this.jdField_a_of_type_JavaUtilList.size();
        paramInt2 = 0;
        while (paramInt2 < i2)
        {
          localObject = (XViewPager.OnPageChangeListener)this.jdField_a_of_type_JavaUtilList.get(paramInt2);
          if (localObject != null) {
            ((XViewPager.OnPageChangeListener)localObject).a(paramInt1);
          }
          paramInt2 += 1;
        }
      }
      if ((paramBoolean2) && (this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener != null)) {
        this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener.a(paramInt1);
      }
      b(false);
      scrollTo(0, i1);
      c(i1);
      return;
    }
  }
  
  private void b(XViewPager.ItemInfo paramItemInfo1, int paramInt, XViewPager.ItemInfo paramItemInfo2)
  {
    int i4 = this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getCount();
    int i1 = e();
    float f2;
    if (i1 > 0)
    {
      f2 = this.jdField_g_of_type_Int / i1;
      if (paramItemInfo2 == null) {
        break label409;
      }
      i1 = paramItemInfo2.jdField_a_of_type_Int;
      if (i1 < paramItemInfo1.jdField_a_of_type_Int)
      {
        f1 = paramItemInfo2.jdField_b_of_type_Float + paramItemInfo2.jdField_a_of_type_Float + f2;
        i1 += 1;
        i2 = 0;
      }
    }
    else
    {
      for (;;)
      {
        if ((i1 > paramItemInfo1.jdField_a_of_type_Int) || (i2 >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
          break label409;
        }
        for (paramItemInfo2 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i2);; paramItemInfo2 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i2))
        {
          i3 = i1;
          f3 = f1;
          if (i1 <= paramItemInfo2.jdField_a_of_type_Int) {
            break;
          }
          i3 = i1;
          f3 = f1;
          if (i2 >= this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
            break;
          }
          i2 += 1;
        }
        f2 = 0.0F;
        break;
        while (i3 < paramItemInfo2.jdField_a_of_type_Int)
        {
          f3 += this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getPageWidth(i3) + f2;
          i3 += 1;
        }
        paramItemInfo2.jdField_b_of_type_Float = f3;
        f1 = f3 + (paramItemInfo2.jdField_a_of_type_Float + f2);
        i1 = i3 + 1;
      }
    }
    if (i1 > paramItemInfo1.jdField_a_of_type_Int)
    {
      i2 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
      f1 = paramItemInfo2.jdField_b_of_type_Float;
      i1 -= 1;
      while ((i1 >= paramItemInfo1.jdField_a_of_type_Int) && (i2 >= 0))
      {
        for (paramItemInfo2 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i2);; paramItemInfo2 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i2))
        {
          i3 = i1;
          f3 = f1;
          if (i1 >= paramItemInfo2.jdField_a_of_type_Int) {
            break;
          }
          i3 = i1;
          f3 = f1;
          if (i2 <= 0) {
            break;
          }
          i2 -= 1;
        }
        while (i3 > paramItemInfo2.jdField_a_of_type_Int)
        {
          f3 -= this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getPageWidth(i3) + f2;
          i3 -= 1;
        }
        f1 = f3 - (paramItemInfo2.jdField_a_of_type_Float + f2);
        paramItemInfo2.jdField_b_of_type_Float = f1;
        i1 = i3 - 1;
      }
    }
    label409:
    int i3 = this.jdField_a_of_type_JavaUtilArrayList.size();
    float f3 = paramItemInfo1.jdField_b_of_type_Float;
    i1 = paramItemInfo1.jdField_a_of_type_Int - 1;
    if (paramItemInfo1.jdField_a_of_type_Int == 0)
    {
      f1 = paramItemInfo1.jdField_b_of_type_Float;
      this.jdField_b_of_type_Float = f1;
      if (paramItemInfo1.jdField_a_of_type_Int != i4 - 1) {
        break label550;
      }
      f1 = paramItemInfo1.jdField_b_of_type_Float + paramItemInfo1.jdField_a_of_type_Float - 1.0F;
      label475:
      this.jdField_c_of_type_Float = f1;
      i2 = paramInt - 1;
      f1 = f3;
    }
    for (;;)
    {
      if (i2 < 0) {
        break label603;
      }
      paramItemInfo2 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i2);
      for (;;)
      {
        if (i1 > paramItemInfo2.jdField_a_of_type_Int)
        {
          f1 -= this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getPageWidth(i1) + f2;
          i1 -= 1;
          continue;
          f1 = -3.402824E+038F;
          break;
          label550:
          f1 = 3.4028235E+38F;
          break label475;
        }
      }
      f1 -= paramItemInfo2.jdField_a_of_type_Float + f2;
      paramItemInfo2.jdField_b_of_type_Float = f1;
      if (paramItemInfo2.jdField_a_of_type_Int == 0) {
        this.jdField_b_of_type_Float = f1;
      }
      i1 -= 1;
      i2 -= 1;
    }
    label603:
    float f1 = paramItemInfo1.jdField_b_of_type_Float + paramItemInfo1.jdField_a_of_type_Float + f2;
    int i2 = paramItemInfo1.jdField_a_of_type_Int + 1;
    i1 = paramInt + 1;
    paramInt = i2;
    while (i1 < i3)
    {
      paramItemInfo1 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      while (paramInt < paramItemInfo1.jdField_a_of_type_Int)
      {
        f1 = this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getPageWidth(paramInt) + f2 + f1;
        paramInt += 1;
      }
      if (paramItemInfo1.jdField_a_of_type_Int == i4 - 1) {
        this.jdField_c_of_type_Float = (paramItemInfo1.jdField_a_of_type_Float + f1 - 1.0F);
      }
      paramItemInfo1.jdField_b_of_type_Float = f1;
      f1 += paramItemInfo1.jdField_a_of_type_Float + f2;
      paramInt += 1;
      i1 += 1;
    }
    this.jdField_n_of_type_Boolean = false;
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.z == 2) {}
    int i2;
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        e(false);
        this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
        i2 = getScrollX();
        i3 = getScrollY();
        int i4 = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
        int i5 = this.jdField_a_of_type_AndroidWidgetScroller.getCurrY();
        if ((i2 != i4) || (i3 != i5)) {
          scrollTo(i4, i5);
        }
      }
      this.jdField_h_of_type_Boolean = false;
      int i3 = 0;
      i2 = i1;
      i1 = i3;
      while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        XViewPager.ItemInfo localItemInfo = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        if (localItemInfo.jdField_a_of_type_Boolean)
        {
          localItemInfo.jdField_a_of_type_Boolean = false;
          i2 = 1;
        }
        i1 += 1;
      }
    }
    if (i2 != 0)
    {
      if (paramBoolean) {
        ViewCompat.postOnAnimation(this, this.jdField_a_of_type_JavaLangRunnable);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_JavaLangRunnable.run();
  }
  
  private boolean b(float paramFloat)
  {
    int i2 = 1;
    f();
    float f1 = this.jdField_e_of_type_Float;
    this.jdField_e_of_type_Float = paramFloat;
    f1 = getScrollY() + (f1 - paramFloat);
    int i3 = e();
    paramFloat = i3 * this.jdField_b_of_type_Float;
    float f2 = i3;
    float f3 = this.jdField_c_of_type_Float;
    XViewPager.ItemInfo localItemInfo1 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    XViewPager.ItemInfo localItemInfo2 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    if (localItemInfo1.jdField_a_of_type_Int != 0) {
      paramFloat = localItemInfo1.jdField_b_of_type_Float * i3;
    }
    for (int i1 = 0;; i1 = 1)
    {
      if (localItemInfo2.jdField_a_of_type_Int != this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getCount() - 1)
      {
        f2 = localItemInfo2.jdField_b_of_type_Float * i3;
        i2 = 0;
      }
      for (;;)
      {
        if (f1 < paramFloat) {
          if (i1 == 0) {
            break label276;
          }
        }
        label276:
        for (boolean bool1 = this.jdField_c_of_type_AndroidSupportV4WidgetEdgeEffectCompat.onPull(Math.abs(paramFloat - f1) / i3);; bool1 = false)
        {
          boolean bool2 = bool1;
          if (this.jdField_e_of_type_Boolean)
          {
            paramFloat = f1;
            bool2 = bool1;
          }
          for (;;)
          {
            this.jdField_e_of_type_Float += paramFloat - (int)paramFloat;
            scrollTo(0, (int)paramFloat);
            c((int)paramFloat);
            return bool2;
            if (f1 > f2)
            {
              if (i2 != 0) {}
              for (bool2 = this.jdField_d_of_type_AndroidSupportV4WidgetEdgeEffectCompat.onPull(Math.abs(f1 - f2) / i3);; bool2 = false)
              {
                if (this.jdField_e_of_type_Boolean)
                {
                  paramFloat = f1;
                  break;
                }
                paramFloat = f2;
                break;
              }
            }
            paramFloat = f1;
            bool2 = false;
          }
        }
        f2 *= f3;
      }
    }
  }
  
  private boolean b(float paramFloat1, float paramFloat2)
  {
    return ((paramFloat1 < this.q) && (paramFloat2 > 0.0F)) || ((paramFloat1 > getHeight() - this.q) && (paramFloat2 < 0.0F));
  }
  
  private boolean b(int paramInt)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      this.jdField_o_of_type_Boolean = false;
      a(0, 0.0F, 0);
      if (!this.jdField_o_of_type_Boolean) {
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      }
    }
    else
    {
      XViewPager.ItemInfo localItemInfo = a();
      int i2 = d();
      int i3 = this.jdField_g_of_type_Int;
      float f1 = this.jdField_g_of_type_Int / i2;
      int i1 = localItemInfo.jdField_a_of_type_Int;
      f1 = (paramInt / i2 - localItemInfo.jdField_b_of_type_Float) / (localItemInfo.jdField_a_of_type_Float + f1);
      paramInt = (int)((i3 + i2) * f1);
      this.jdField_o_of_type_Boolean = false;
      a(i1, f1, paramInt);
      if (!this.jdField_o_of_type_Boolean) {
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      }
      bool = true;
    }
    return bool;
  }
  
  private void c(boolean paramBoolean)
  {
    int i3 = getChildCount();
    int i1 = 0;
    if (i1 < i3)
    {
      if (paramBoolean) {}
      for (int i2 = 2;; i2 = 0)
      {
        ViewCompat.setLayerType(getChildAt(i1), i2, null);
        i1 += 1;
        break;
      }
    }
  }
  
  private boolean c()
  {
    return (this.jdField_c_of_type_Boolean) && (this.jdField_d_of_type_Boolean);
  }
  
  private boolean c(int paramInt)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      this.jdField_o_of_type_Boolean = false;
      b(0, 0.0F, 0);
      if (!this.jdField_o_of_type_Boolean) {
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      }
    }
    else
    {
      XViewPager.ItemInfo localItemInfo = a();
      int i2 = e();
      int i3 = this.jdField_g_of_type_Int;
      float f1 = this.jdField_g_of_type_Int / i2;
      int i1 = localItemInfo.jdField_a_of_type_Int;
      f1 = (paramInt / i2 - localItemInfo.jdField_b_of_type_Float) / (localItemInfo.jdField_a_of_type_Float + f1);
      paramInt = (int)((i3 + i2) * f1);
      this.jdField_o_of_type_Boolean = false;
      b(i1, f1, paramInt);
      if (!this.jdField_o_of_type_Boolean) {
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      }
      bool = true;
    }
    return bool;
  }
  
  private int d()
  {
    return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  private void d()
  {
    int i2;
    for (int i1 = 0; i1 < getChildCount(); i1 = i2 + 1)
    {
      i2 = i1;
      if (!((XViewPager.LayoutParams)getChildAt(i1).getLayoutParams()).jdField_a_of_type_Boolean)
      {
        removeViewAt(i1);
        i2 = i1 - 1;
      }
    }
  }
  
  private void d(boolean paramBoolean)
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  private boolean d()
  {
    return (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean);
  }
  
  private int e()
  {
    return getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
  }
  
  private void e()
  {
    if (this.x != 0)
    {
      if (this.jdField_b_of_type_JavaUtilArrayList == null) {
        this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      }
      for (;;)
      {
        int i2 = getChildCount();
        int i1 = 0;
        while (i1 < i2)
        {
          View localView = getChildAt(i1);
          this.jdField_b_of_type_JavaUtilArrayList.add(localView);
          i1 += 1;
        }
        this.jdField_b_of_type_JavaUtilArrayList.clear();
      }
      Collections.sort(this.jdField_b_of_type_JavaUtilArrayList, jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$ViewPositionComparator);
    }
  }
  
  private void e(boolean paramBoolean)
  {
    if (this.jdField_g_of_type_Boolean != paramBoolean) {
      this.jdField_g_of_type_Boolean = paramBoolean;
    }
  }
  
  private boolean e()
  {
    return (Gravity.isHorizontal(this.jdField_o_of_type_Int)) || (((!this.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean)) || ((this.jdField_o_of_type_Int == 0) || (!f())));
  }
  
  private void f()
  {
    int i4 = getChildCount();
    int i5 = d();
    int i6 = e();
    int i3 = 0;
    int i1 = 0;
    View localView;
    XViewPager.ItemInfo localItemInfo;
    float f1;
    int i7;
    int i8;
    if (i3 < i4)
    {
      localView = getChildAt(i3);
      if ((localView.getVisibility() == 8) || (((XViewPager.LayoutParams)localView.getLayoutParams()).jdField_a_of_type_Boolean)) {
        break label336;
      }
      localItemInfo = a(localView);
      if (localItemInfo == null) {
        break label336;
      }
      if (Gravity.isHorizontal(this.jdField_o_of_type_Int))
      {
        f1 = i5;
        i7 = (int)(localItemInfo.jdField_b_of_type_Float * f1);
        i8 = getPaddingLeft();
        i2 = getPaddingTop();
        i8 = i7 + i8 - localView.getLeft();
        i7 = i2 - localView.getTop();
        if (i8 == 0) {
          break label339;
        }
        localView.offsetLeftAndRight(i8);
      }
    }
    label309:
    label336:
    label339:
    for (int i2 = 1;; i2 = i1)
    {
      if (i7 != 0)
      {
        localView.offsetTopAndBottom(i7);
        i2 = 1;
      }
      i1 = i2;
      if (i2 != 0)
      {
        this.jdField_m_of_type_Boolean = false;
        i1 = i2;
      }
      for (;;)
      {
        i3 += 1;
        break;
        if (Gravity.isVertical(this.jdField_o_of_type_Int))
        {
          f1 = i6;
          i7 = (int)(localItemInfo.jdField_b_of_type_Float * f1);
          i8 = getPaddingTop();
          i2 = getPaddingLeft();
          i8 = i7 + i8 - localView.getTop();
          i7 = i2 - localView.getLeft();
          if (i8 != 0) {
            localView.offsetTopAndBottom(i8);
          }
          for (i2 = 1;; i2 = i1)
          {
            if (i7 != 0)
            {
              localView.offsetLeftAndRight(i7);
              i2 = 1;
            }
            i1 = i2;
            if (i2 == 0) {
              break;
            }
            this.jdField_m_of_type_Boolean = true;
            i1 = i2;
            break;
            if (i1 != 0)
            {
              if (!Gravity.isHorizontal(this.jdField_o_of_type_Int)) {
                break label309;
              }
              a(this.jdField_e_of_type_Int, false, 0, false);
            }
            while (!Gravity.isVertical(this.jdField_o_of_type_Int)) {
              return;
            }
            b(this.jdField_e_of_type_Int, false, 0, false);
            return;
          }
        }
      }
    }
  }
  
  private boolean f()
  {
    return (Gravity.isVertical(this.jdField_o_of_type_Int)) || (((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)) || ((this.jdField_o_of_type_Int == 0) || (!e())));
  }
  
  private void g()
  {
    this.jdField_i_of_type_Boolean = false;
    this.jdField_j_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  float a(float paramFloat)
  {
    return (float)Math.sin((float)((paramFloat - 0.5F) * 0.47123891676382D));
  }
  
  public int a()
  {
    return this.z;
  }
  
  public PagerAdapter a()
  {
    return this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter;
  }
  
  XViewPager.ItemInfo a(int paramInt)
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      XViewPager.ItemInfo localItemInfo = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if (localItemInfo.jdField_a_of_type_Int == paramInt) {
        return localItemInfo;
      }
      i1 += 1;
    }
    return null;
  }
  
  XViewPager.ItemInfo a(int paramInt1, int paramInt2)
  {
    XViewPager.ItemInfo localItemInfo = new XViewPager.ItemInfo();
    localItemInfo.jdField_a_of_type_Int = paramInt1;
    localItemInfo.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.instantiateItem(this, paramInt1);
    localItemInfo.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getPageWidth(paramInt1);
    if ((paramInt2 < 0) || (paramInt2 >= this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(localItemInfo);
      return localItemInfo;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramInt2, localItemInfo);
    return localItemInfo;
  }
  
  XViewPager.ItemInfo a(View paramView)
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      XViewPager.ItemInfo localItemInfo = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if (this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.isViewFromObject(paramView, localItemInfo.jdField_a_of_type_JavaLangObject)) {
        return localItemInfo;
      }
      i1 += 1;
    }
    return null;
  }
  
  public List<XViewPager.OnPageChangeListener> a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return Collections.emptyList();
    }
    return Collections.unmodifiableList(this.jdField_a_of_type_JavaUtilList);
  }
  
  void a()
  {
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    Context localContext = getContext();
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(localContext, jdField_a_of_type_AndroidViewAnimationInterpolator);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(localContext);
    float f1 = localContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Int = ViewConfigurationCompat.getScaledPagingTouchSlop(localViewConfiguration);
    this.s = ((int)(400.0F * f1));
    this.t = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.jdField_a_of_type_AndroidSupportV4WidgetEdgeEffectCompat = new EdgeEffectCompat(localContext);
    this.jdField_b_of_type_AndroidSupportV4WidgetEdgeEffectCompat = new EdgeEffectCompat(localContext);
    this.jdField_c_of_type_AndroidSupportV4WidgetEdgeEffectCompat = new EdgeEffectCompat(localContext);
    this.jdField_d_of_type_AndroidSupportV4WidgetEdgeEffectCompat = new EdgeEffectCompat(localContext);
    this.u = ((int)(25.0F * f1));
    this.v = ((int)(2.0F * f1));
    this.jdField_p_of_type_Int = ((int)(16.0F * f1));
    ViewCompat.setAccessibilityDelegate(this, new XViewPager.MyAccessibilityDelegate(this));
    if (ViewCompat.getImportantForAccessibility(this) == 0) {
      ViewCompat.setImportantForAccessibility(this, 1);
    }
  }
  
  void a(int paramInt)
  {
    int i1;
    Object localObject2;
    if (this.jdField_e_of_type_Int != paramInt) {
      if (this.jdField_e_of_type_Int < paramInt)
      {
        i1 = 66;
        localObject2 = a(this.jdField_e_of_type_Int);
        this.jdField_e_of_type_Int = paramInt;
      }
    }
    for (int i2 = i1;; i2 = 2)
    {
      if (this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter == null) {
        e();
      }
      do
      {
        return;
        i1 = 17;
        break;
        if (this.jdField_h_of_type_Boolean)
        {
          e();
          return;
        }
      } while (getWindowToken() == null);
      this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.startUpdate(this);
      int i8 = this.jdField_n_of_type_Int;
      int i9 = Math.max(0, this.jdField_e_of_type_Int - i8);
      int i6 = this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getCount();
      int i7 = Math.min(i6 - 1, this.jdField_e_of_type_Int + i8);
      Object localObject1;
      if (i6 != this.jdField_d_of_type_Int) {
        try
        {
          String str = getResources().getResourceName(getId());
          throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.jdField_d_of_type_Int + ", found: " + i6 + " Pager id: " + str + " Pager class: " + getClass() + " Problematic adapter: " + this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getClass());
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          for (;;)
          {
            localObject1 = Integer.toHexString(getId());
          }
        }
      }
      paramInt = 0;
      label249:
      if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject1 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        if (((XViewPager.ItemInfo)localObject1).jdField_a_of_type_Int >= this.jdField_e_of_type_Int) {
          if (((XViewPager.ItemInfo)localObject1).jdField_a_of_type_Int != this.jdField_e_of_type_Int) {
            break label1322;
          }
        }
      }
      for (;;)
      {
        if ((localObject1 == null) && (i6 > 0)) {}
        label529:
        label1299:
        for (Object localObject3 = a(this.jdField_e_of_type_Int, paramInt);; localObject3 = localObject1)
        {
          int i5;
          label347:
          int i10;
          float f1;
          label360:
          float f3;
          int i4;
          int i3;
          Object localObject4;
          if (localObject3 != null)
          {
            i5 = paramInt - 1;
            if (i5 < 0) {
              break label671;
            }
            localObject1 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i5);
            i10 = d();
            if (i10 > 0) {
              break label677;
            }
            f1 = 0.0F;
            f2 = f1;
            if (i8 == 0) {
              f2 = 0.0F;
            }
            i1 = this.jdField_e_of_type_Int;
            f3 = 0.0F;
            i4 = i1 - 1;
            i3 = paramInt;
            localObject4 = localObject1;
            if (i4 >= 0)
            {
              if ((f3 < f2) || (i4 >= i9)) {
                break label832;
              }
              if (localObject4 != null) {
                break label698;
              }
            }
            f3 = ((XViewPager.ItemInfo)localObject3).jdField_a_of_type_Float;
            paramInt = i3 + 1;
            if (f3 < 2.0F)
            {
              if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
                break label952;
              }
              localObject1 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
              label458:
              if (i10 > 0) {
                break label958;
              }
              f1 = 0.0F;
              label465:
              if (i8 != 0) {
                break label1310;
              }
            }
          }
          label1176:
          label1305:
          label1310:
          for (float f2 = 0.0F;; f2 = f1)
          {
            i1 = this.jdField_e_of_type_Int;
            i1 += 1;
            f1 = f3;
            label487:
            if (i1 < i6)
            {
              if ((f1 < f2) || (i1 <= i7)) {
                break label1054;
              }
              if (localObject1 != null) {}
            }
            else
            {
              if (!f()) {
                break label1176;
              }
              b((XViewPager.ItemInfo)localObject3, i3, (XViewPager.ItemInfo)localObject2);
              localObject2 = this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter;
              paramInt = this.jdField_e_of_type_Int;
              if (localObject3 == null) {
                break label1189;
              }
              localObject1 = ((XViewPager.ItemInfo)localObject3).jdField_a_of_type_JavaLangObject;
              ((PagerAdapter)localObject2).setPrimaryItem(this, paramInt, localObject1);
              this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.finishUpdate(this);
              i1 = getChildCount();
              paramInt = 0;
              while (paramInt < i1)
              {
                localObject2 = getChildAt(paramInt);
                localObject1 = (XViewPager.LayoutParams)((View)localObject2).getLayoutParams();
                ((XViewPager.LayoutParams)localObject1).jdField_c_of_type_Int = paramInt;
                if ((!((XViewPager.LayoutParams)localObject1).jdField_a_of_type_Boolean) && (((XViewPager.LayoutParams)localObject1).jdField_a_of_type_Float == 0.0F))
                {
                  localObject2 = a((View)localObject2);
                  if (localObject2 != null)
                  {
                    ((XViewPager.LayoutParams)localObject1).jdField_a_of_type_Float = ((XViewPager.ItemInfo)localObject2).jdField_a_of_type_Float;
                    ((XViewPager.LayoutParams)localObject1).jdField_b_of_type_Int = ((XViewPager.ItemInfo)localObject2).jdField_a_of_type_Int;
                  }
                }
                paramInt += 1;
              }
              paramInt += 1;
              break label249;
              localObject1 = null;
              break label347;
              f1 = 2.0F - ((XViewPager.ItemInfo)localObject3).jdField_a_of_type_Float + getPaddingLeft() / i10;
              break label360;
              localObject1 = localObject4;
              paramInt = i5;
              f1 = f3;
              i1 = i3;
              if (i4 == localObject4.jdField_a_of_type_Int)
              {
                localObject1 = localObject4;
                paramInt = i5;
                f1 = f3;
                i1 = i3;
                if (!localObject4.jdField_a_of_type_Boolean)
                {
                  this.jdField_a_of_type_JavaUtilArrayList.remove(i5);
                  this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.destroyItem(this, i4, localObject4.jdField_a_of_type_JavaLangObject);
                  paramInt = i5 - 1;
                  i1 = i3 - 1;
                  if (paramInt < 0) {
                    break label823;
                  }
                  localObject1 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
                  f1 = f3;
                }
              }
              for (;;)
              {
                i4 -= 1;
                localObject4 = localObject1;
                i5 = paramInt;
                f3 = f1;
                i3 = i1;
                break;
                localObject1 = null;
                f1 = f3;
                continue;
                if ((localObject4 != null) && (i4 == localObject4.jdField_a_of_type_Int))
                {
                  f1 = f3 + localObject4.jdField_a_of_type_Float;
                  paramInt = i5 - 1;
                  if (paramInt >= 0)
                  {
                    localObject1 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
                    i1 = i3;
                  }
                  else
                  {
                    localObject1 = null;
                    i1 = i3;
                  }
                }
                else
                {
                  f1 = f3 + a(i4, i5 + 1).jdField_a_of_type_Float;
                  i1 = i3 + 1;
                  if (i5 >= 0)
                  {
                    localObject1 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i5);
                    paramInt = i5;
                  }
                  else
                  {
                    localObject1 = null;
                    paramInt = i5;
                  }
                }
              }
              localObject1 = null;
              break label458;
              f1 = getPaddingRight() / i10 + 2.0F;
              break label465;
            }
            label552:
            label698:
            label832:
            if ((i1 == ((XViewPager.ItemInfo)localObject1).jdField_a_of_type_Int) && (!((XViewPager.ItemInfo)localObject1).jdField_a_of_type_Boolean))
            {
              this.jdField_a_of_type_JavaUtilArrayList.remove(paramInt);
              this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.destroyItem(this, i1, ((XViewPager.ItemInfo)localObject1).jdField_a_of_type_JavaLangObject);
              if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()) {
                localObject1 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
              }
            }
            for (;;)
            {
              label671:
              label677:
              label823:
              label952:
              label958:
              i1 += 1;
              break label487;
              localObject1 = null;
              continue;
              label1054:
              if ((localObject1 != null) && (i1 == ((XViewPager.ItemInfo)localObject1).jdField_a_of_type_Int))
              {
                f3 = ((XViewPager.ItemInfo)localObject1).jdField_a_of_type_Float;
                paramInt += 1;
                if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()) {}
                for (localObject1 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);; localObject1 = null)
                {
                  f1 += f3;
                  break;
                }
              }
              localObject1 = a(i1, paramInt);
              paramInt += 1;
              f3 = ((XViewPager.ItemInfo)localObject1).jdField_a_of_type_Float;
              if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()) {}
              for (localObject1 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);; localObject1 = null)
              {
                f1 += f3;
                break;
              }
              a((XViewPager.ItemInfo)localObject3, i3, (XViewPager.ItemInfo)localObject2);
              break label529;
              label1189:
              localObject1 = null;
              break label552;
              e();
              if (!hasFocus()) {
                break;
              }
              localObject1 = findFocus();
              if (localObject1 != null) {}
              for (localObject1 = b((View)localObject1);; localObject1 = null)
              {
                if ((localObject1 != null) && (((XViewPager.ItemInfo)localObject1).jdField_a_of_type_Int == this.jdField_e_of_type_Int)) {
                  break label1305;
                }
                paramInt = 0;
                for (;;)
                {
                  if (paramInt >= getChildCount()) {
                    break label1299;
                  }
                  localObject1 = getChildAt(paramInt);
                  localObject2 = a((View)localObject1);
                  if ((localObject2 != null) && (((XViewPager.ItemInfo)localObject2).jdField_a_of_type_Int == this.jdField_e_of_type_Int) && (((View)localObject1).requestFocus(i2))) {
                    break;
                  }
                  paramInt += 1;
                }
                break;
              }
              break;
            }
          }
        }
        label1322:
        localObject1 = null;
      }
      localObject2 = null;
    }
  }
  
  protected void a(int paramInt1, float paramFloat, int paramInt2)
  {
    int i1;
    int i2;
    Object localObject;
    if (this.w > 0)
    {
      int i6 = getScrollX();
      i1 = getPaddingLeft();
      i2 = getPaddingRight();
      int i7 = getWidth();
      int i8 = getChildCount();
      int i5 = 0;
      while (i5 < i8)
      {
        localObject = getChildAt(i5);
        XViewPager.LayoutParams localLayoutParams = (XViewPager.LayoutParams)((View)localObject).getLayoutParams();
        int i4;
        int i3;
        if (!localLayoutParams.jdField_a_of_type_Boolean)
        {
          i4 = i1;
          i3 = i2;
          i5 += 1;
          i1 = i4;
          i2 = i3;
        }
        else
        {
          switch (localLayoutParams.jdField_a_of_type_Int & 0x7)
          {
          case 2: 
          case 4: 
          default: 
            i3 = i1;
            i4 = i2;
            i2 = i1;
            i1 = i4;
          }
          for (;;)
          {
            int i9 = i3 + i6 - ((View)localObject).getLeft();
            i3 = i1;
            i4 = i2;
            if (i9 == 0) {
              break;
            }
            ((View)localObject).offsetLeftAndRight(i9);
            i3 = i1;
            i4 = i2;
            break;
            i3 = ((View)localObject).getWidth();
            i4 = i3 + i1;
            i3 = i1;
            i1 = i2;
            i2 = i4;
            continue;
            i3 = Math.max((i7 - ((View)localObject).getMeasuredWidth()) / 2, i1);
            i4 = i1;
            i1 = i2;
            i2 = i4;
            continue;
            i3 = i7 - i2 - ((View)localObject).getMeasuredWidth();
            i9 = ((View)localObject).getMeasuredWidth();
            i4 = i1;
            i1 = i2 + i9;
            i2 = i4;
          }
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener.a(paramInt1, paramFloat, paramInt2);
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      i2 = this.jdField_a_of_type_JavaUtilList.size();
      i1 = 0;
      while (i1 < i2)
      {
        localObject = (XViewPager.OnPageChangeListener)this.jdField_a_of_type_JavaUtilList.get(i1);
        if (localObject != null) {
          ((XViewPager.OnPageChangeListener)localObject).a(paramInt1, paramFloat, paramInt2);
        }
        i1 += 1;
      }
    }
    if (this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener != null) {
      this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener.a(paramInt1, paramFloat, paramInt2);
    }
    if (this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$PageTransformer != null)
    {
      paramInt2 = getScrollX();
      i1 = getChildCount();
      paramInt1 = 0;
      if (paramInt1 < i1)
      {
        localObject = getChildAt(paramInt1);
        if (((XViewPager.LayoutParams)((View)localObject).getLayoutParams()).jdField_a_of_type_Boolean) {}
        for (;;)
        {
          paramInt1 += 1;
          break;
          paramFloat = (((View)localObject).getLeft() - paramInt2) / d();
          this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$PageTransformer.a((View)localObject, paramFloat);
        }
      }
    }
    this.jdField_o_of_type_Boolean = true;
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (getChildCount() == 0)
    {
      e(false);
      return;
    }
    int i1 = getScrollX();
    int i2 = getScrollY();
    int i3 = paramInt1 - i1;
    paramInt2 -= i2;
    if ((i3 == 0) && (paramInt2 == 0))
    {
      b(false);
      c();
      b(0);
      return;
    }
    e(true);
    b(2);
    paramInt1 = d();
    int i4 = e();
    int i5 = paramInt1 / 2;
    int i6 = i4 / 2;
    float f4 = Math.min(1.0F, 1.0F * Math.abs(i3) / paramInt1);
    float f3 = Math.min(1.0F, 1.0F * Math.abs(paramInt2) / i4);
    float f1 = i5;
    float f2 = i5;
    f4 = a(f4);
    float f5 = i6;
    float f6 = i6;
    f3 = a(f3);
    paramInt3 = Math.abs(paramInt3);
    if (paramInt3 > 0) {
      if (f())
      {
        paramInt1 = Math.round(1000.0F * Math.abs((f6 * f3 + f5) / paramInt3)) * 4;
        paramInt1 = Math.min(paramInt1, 600);
        if ((this.jdField_c_of_type_Int != 2) && (this.jdField_c_of_type_Int != 3)) {
          break label377;
        }
        this.jdField_a_of_type_AndroidWidgetScroller.startScroll(i1, i2, i3, paramInt2, paramInt1 / this.jdField_c_of_type_Int);
      }
    }
    for (;;)
    {
      ViewCompat.postInvalidateOnAnimation(this);
      return;
      paramInt1 = Math.round(1000.0F * Math.abs((f2 * f4 + f1) / paramInt3)) * 4;
      break;
      if (f())
      {
        f1 = i4;
        f2 = this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getPageWidth(this.jdField_e_of_type_Int);
        paramInt1 = (int)((Math.abs(paramInt2) / (f1 * f2 + this.jdField_g_of_type_Int) + 1.0F) * 100.0F);
        break;
      }
      f1 = paramInt1;
      f2 = this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getPageWidth(this.jdField_e_of_type_Int);
      paramInt1 = (int)((Math.abs(i3) / (f1 * f2 + this.jdField_g_of_type_Int) + 1.0F) * 100.0F);
      break;
      label377:
      if (this.jdField_b_of_type_Int > 0) {
        this.jdField_a_of_type_AndroidWidgetScroller.startScroll(i1, i2, i3, paramInt2, this.jdField_b_of_type_Int);
      } else {
        this.jdField_a_of_type_AndroidWidgetScroller.startScroll(i1, i2, i3, paramInt2, paramInt1);
      }
    }
  }
  
  void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt, paramBoolean1, paramBoolean2, 0);
  }
  
  void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    int i2 = 0;
    if ((this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter == null) || (this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getCount() <= 0))
    {
      e(false);
      return;
    }
    if ((!paramBoolean2) && (this.jdField_e_of_type_Int == paramInt1) && (this.jdField_a_of_type_JavaUtilArrayList.size() != 0))
    {
      e(false);
      return;
    }
    int i1 = this.jdField_e_of_type_Int;
    if (paramInt1 < 0) {
      i1 = 0;
    }
    for (;;)
    {
      paramInt1 = this.jdField_n_of_type_Int;
      if ((i1 <= this.jdField_e_of_type_Int + paramInt1) && (i1 >= this.jdField_e_of_type_Int - paramInt1)) {
        break;
      }
      paramInt1 = 0;
      while (paramInt1 < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1)).jdField_a_of_type_Boolean = true;
        paramInt1 += 1;
      }
      i1 = paramInt1;
      if (paramInt1 >= this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getCount()) {
        i1 = this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getCount() - 1;
      }
    }
    if (this.jdField_e_of_type_Int != i1) {
      paramBoolean2 = true;
    }
    while (this.jdField_l_of_type_Boolean)
    {
      this.jdField_e_of_type_Int = i1;
      if ((paramBoolean2) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener != null)) {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener.a(i1);
      }
      if ((paramBoolean2) && (this.jdField_a_of_type_JavaUtilList != null))
      {
        paramInt2 = this.jdField_a_of_type_JavaUtilList.size();
        paramInt1 = i2;
        for (;;)
        {
          if (paramInt1 < paramInt2)
          {
            XViewPager.OnPageChangeListener localOnPageChangeListener = (XViewPager.OnPageChangeListener)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
            if (localOnPageChangeListener != null) {
              localOnPageChangeListener.a(i1);
            }
            paramInt1 += 1;
            continue;
            paramBoolean2 = false;
            break;
          }
        }
      }
      if ((paramBoolean2) && (this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener != null)) {
        this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener.a(i1);
      }
      requestLayout();
      return;
    }
    a(i1);
    if (f())
    {
      b(i1, paramBoolean1, paramInt2, paramBoolean2);
      return;
    }
    a(i1, paramBoolean1, paramInt2, paramBoolean2);
  }
  
  protected void a(Canvas paramCanvas)
  {
    int i3;
    int i4;
    float f3;
    Object localObject;
    float f1;
    int i5;
    int i1;
    int i6;
    int i2;
    if ((this.jdField_g_of_type_Int > 0) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter != null))
    {
      i3 = getScrollY();
      i4 = getHeight();
      f3 = this.jdField_g_of_type_Int / i4;
      localObject = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      f1 = ((XViewPager.ItemInfo)localObject).jdField_b_of_type_Float;
      i5 = this.jdField_a_of_type_JavaUtilArrayList.size();
      i1 = ((XViewPager.ItemInfo)localObject).jdField_a_of_type_Int;
      i6 = ((XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i5 - 1)).jdField_a_of_type_Int;
      i2 = 0;
    }
    for (;;)
    {
      float f2;
      if (i1 < i6)
      {
        while ((i1 > ((XViewPager.ItemInfo)localObject).jdField_a_of_type_Int) && (i2 < i5))
        {
          localObject = this.jdField_a_of_type_JavaUtilArrayList;
          i2 += 1;
          localObject = (XViewPager.ItemInfo)((ArrayList)localObject).get(i2);
        }
        if (i1 != ((XViewPager.ItemInfo)localObject).jdField_a_of_type_Int) {
          break label266;
        }
        f2 = (((XViewPager.ItemInfo)localObject).jdField_b_of_type_Float + ((XViewPager.ItemInfo)localObject).jdField_a_of_type_Float) * i4;
      }
      label266:
      float f4;
      for (f1 = ((XViewPager.ItemInfo)localObject).jdField_b_of_type_Float + ((XViewPager.ItemInfo)localObject).jdField_a_of_type_Float + f3;; f1 += f4 + f3)
      {
        if (this.jdField_g_of_type_Int + f2 > i3)
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.jdField_j_of_type_Int, (int)f2, this.jdField_k_of_type_Int, (int)(this.jdField_g_of_type_Int + f2 + 0.5F));
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        }
        if (f2 <= i3 + i4) {
          break;
        }
        return;
        f4 = this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getPageWidth(i1);
        f2 = (f1 + f4) * i4;
      }
      i1 += 1;
    }
  }
  
  public void a(XViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramOnPageChangeListener);
  }
  
  void a(boolean paramBoolean)
  {
    if ((Build.VERSION.SDK_INT < 7) || (this.jdField_a_of_type_JavaLangReflectMethod == null)) {}
    try
    {
      this.jdField_a_of_type_JavaLangReflectMethod = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[] { Boolean.TYPE });
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_JavaLangReflectMethod.invoke(this, new Object[] { Boolean.valueOf(paramBoolean) });
          return;
        }
        catch (Exception localException)
        {
          SLog.c(this.jdField_a_of_type_JavaLangString, "Error changing children drawing order", localException);
        }
        localNoSuchMethodException = localNoSuchMethodException;
        SLog.c(this.jdField_a_of_type_JavaLangString, "Can't find setChildrenDrawingOrderEnabled", localNoSuchMethodException);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i6 = getChildCount();
    int i7 = paramInt3 - paramInt1;
    int i8 = paramInt4 - paramInt2;
    paramInt2 = getPaddingLeft();
    paramInt1 = getPaddingTop();
    paramInt4 = getPaddingRight();
    paramInt3 = getPaddingBottom();
    int i9 = getScrollY();
    int i2 = 0;
    int i4 = 0;
    View localView;
    XViewPager.LayoutParams localLayoutParams;
    int i1;
    int i10;
    int i3;
    label154:
    int i5;
    if (i4 < i6)
    {
      localView = getChildAt(i4);
      if (localView.getVisibility() == 8) {
        break label693;
      }
      localLayoutParams = (XViewPager.LayoutParams)localView.getLayoutParams();
      if (!localLayoutParams.jdField_a_of_type_Boolean) {
        break label693;
      }
      i1 = localLayoutParams.jdField_a_of_type_Int;
      i10 = localLayoutParams.jdField_a_of_type_Int;
      switch (i1 & 0x7)
      {
      case 2: 
      case 4: 
      default: 
        i1 = paramInt2;
        i3 = paramInt2;
        switch (i10 & 0x70)
        {
        default: 
          i5 = paramInt1;
          paramInt2 = paramInt1;
          paramInt1 = paramInt3;
          paramInt3 = i5;
          label204:
          paramInt3 += i9;
          localView.layout(i1, paramInt3, localView.getMeasuredWidth() + i1, localView.getMeasuredHeight() + paramInt3);
          i2 += 1;
          paramInt3 = i3;
          i1 = paramInt1;
          paramInt1 = i2;
        }
        break;
      }
    }
    for (;;)
    {
      i4 += 1;
      i3 = paramInt3;
      i2 = paramInt1;
      paramInt1 = paramInt2;
      paramInt3 = i1;
      paramInt2 = i3;
      break;
      i3 = localView.getMeasuredWidth();
      i1 = paramInt2;
      i3 += paramInt2;
      break label154;
      i1 = Math.max((i7 - localView.getMeasuredWidth()) / 2, paramInt2);
      i3 = paramInt2;
      break label154;
      i3 = localView.getMeasuredWidth();
      i1 = paramInt4 + localView.getMeasuredWidth();
      i5 = i7 - paramInt4 - i3;
      paramInt4 = i1;
      i3 = paramInt2;
      i1 = i5;
      break label154;
      i5 = localView.getMeasuredHeight();
      paramInt2 = paramInt3;
      i5 += paramInt1;
      paramInt3 = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = i5;
      break label204;
      i5 = Math.max((i8 - localView.getMeasuredHeight()) / 2, paramInt1);
      paramInt2 = paramInt1;
      paramInt1 = paramInt3;
      paramInt3 = i5;
      break label204;
      i5 = i8 - paramInt3 - localView.getMeasuredHeight();
      i10 = localView.getMeasuredHeight();
      paramInt2 = paramInt1;
      paramInt1 = paramInt3 + i10;
      paramInt3 = i5;
      break label204;
      i3 = i8 - paramInt1 - paramInt3;
      i1 = 0;
      while (i1 < i6)
      {
        localView = getChildAt(i1);
        if (localView.getVisibility() != 8)
        {
          localLayoutParams = (XViewPager.LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.jdField_a_of_type_Boolean)
          {
            XViewPager.ItemInfo localItemInfo = a(localView);
            if (localItemInfo != null)
            {
              float f1 = i3;
              i4 = (int)(localItemInfo.jdField_b_of_type_Float * f1) + paramInt1;
              if (localLayoutParams.jdField_b_of_type_Boolean)
              {
                localLayoutParams.jdField_b_of_type_Boolean = false;
                i5 = View.MeasureSpec.makeMeasureSpec(i7 - paramInt2 - paramInt4, 1073741824);
                f1 = i3;
                localView.measure(i5, View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.jdField_a_of_type_Float * f1), 1073741824));
              }
              localView.layout(paramInt2, i4, localView.getMeasuredWidth() + paramInt2, localView.getMeasuredHeight() + i4);
            }
          }
        }
        i1 += 1;
      }
      this.jdField_h_of_type_Int = paramInt1;
      this.jdField_j_of_type_Int = paramInt2;
      this.jdField_i_of_type_Int = (i8 - paramInt3);
      this.jdField_k_of_type_Int = (i7 - paramInt4);
      this.w = i2;
      if ((this.jdField_l_of_type_Boolean) || (!this.jdField_m_of_type_Boolean)) {
        b(this.jdField_e_of_type_Int, false, 0, false);
      }
      this.jdField_l_of_type_Boolean = false;
      this.jdField_m_of_type_Boolean = true;
      return;
      label693:
      i1 = i2;
      i2 = paramInt1;
      i3 = paramInt2;
      paramInt1 = i1;
      i1 = paramInt3;
      paramInt2 = i2;
      paramInt3 = i3;
    }
  }
  
  boolean a()
  {
    if (this.jdField_e_of_type_Int > 0)
    {
      setCurrentItem(this.jdField_e_of_type_Int - 1, true);
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt)
  {
    View localView = findFocus();
    Object localObject;
    int i2;
    boolean bool;
    if (localView == this)
    {
      localObject = null;
      localView = FocusFinder.getInstance().findNextFocus(this, (View)localObject, paramInt);
      if ((localView == null) || (localView == localObject)) {
        break label329;
      }
      if (paramInt != 17) {
        break label266;
      }
      i1 = a(this.jdField_a_of_type_AndroidGraphicsRect, localView).left;
      i2 = a(this.jdField_a_of_type_AndroidGraphicsRect, (View)localObject).left;
      if ((localObject != null) && (i1 >= i2))
      {
        bool = a();
        label89:
        if (bool) {
          playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
        }
        return bool;
      }
    }
    else
    {
      if (localView == null) {
        break label375;
      }
      localObject = localView.getParent();
      if (!(localObject instanceof ViewGroup)) {
        break label382;
      }
      if (localObject != this) {}
    }
    label266:
    label329:
    label375:
    label382:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localView.getClass().getSimpleName());
        localObject = localView.getParent();
        for (;;)
        {
          if ((localObject instanceof ViewGroup))
          {
            localStringBuilder.append(" => ").append(localObject.getClass().getSimpleName());
            localObject = ((ViewParent)localObject).getParent();
            continue;
            localObject = ((ViewParent)localObject).getParent();
            break;
          }
        }
        SLog.e(this.jdField_a_of_type_JavaLangString, "arrowScroll tried to find focus based on non-child current focused view " + localStringBuilder.toString());
        localObject = null;
        break;
        bool = localView.requestFocus();
        break label89;
        if (paramInt == 66)
        {
          i1 = a(this.jdField_a_of_type_AndroidGraphicsRect, localView).left;
          i2 = a(this.jdField_a_of_type_AndroidGraphicsRect, (View)localObject).left;
          if ((localObject != null) && (i1 <= i2))
          {
            bool = b();
            break label89;
          }
          bool = localView.requestFocus();
          break label89;
          if ((paramInt == 17) || (paramInt == 1))
          {
            bool = a();
            break label89;
          }
          if ((paramInt == 66) || (paramInt == 2))
          {
            bool = b();
            break label89;
          }
        }
        bool = false;
        break label89;
      }
      localObject = localView;
      break;
    }
  }
  
  public boolean a(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 0) {
      switch (paramKeyEvent.getKeyCode())
      {
      }
    }
    do
    {
      do
      {
        return false;
        return a(33);
        return a(130);
        return a(17);
        return a(66);
      } while (Build.VERSION.SDK_INT < 11);
      if (KeyEventCompat.hasNoModifiers(paramKeyEvent)) {
        return a(2);
      }
    } while (!KeyEventCompat.hasModifiers(paramKeyEvent, 1));
    return a(1);
  }
  
  protected boolean a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    int i1;
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i2 = paramView.getScrollX();
      int i3 = paramView.getScrollY();
      i1 = localViewGroup.getChildCount() - 1;
      if (i1 >= 0)
      {
        localView = localViewGroup.getChildAt(i1);
        if ((paramInt2 + i2 < localView.getLeft()) || (paramInt2 + i2 >= localView.getRight()) || (paramInt3 + i3 < localView.getTop()) || (paramInt3 + i3 >= localView.getBottom()) || (!a(localView, true, paramInt1, paramInt2 + i2 - localView.getLeft(), paramInt3 + i3 - localView.getTop()))) {}
      }
    }
    while ((paramBoolean) && (ViewCompat.canScrollHorizontally(paramView, -paramInt1)))
    {
      View localView;
      return true;
      i1 -= 1;
      break;
    }
    return false;
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    if (paramArrayList == null) {}
    int i2;
    int i3;
    do
    {
      return;
      i2 = paramArrayList.size();
      i3 = getDescendantFocusability();
      if (i3 != 393216)
      {
        int i1 = 0;
        while (i1 < getChildCount())
        {
          View localView = getChildAt(i1);
          if (localView.getVisibility() == 0)
          {
            XViewPager.ItemInfo localItemInfo = a(localView);
            if ((localItemInfo != null) && (localItemInfo.jdField_a_of_type_Int == this.jdField_e_of_type_Int)) {
              localView.addFocusables(paramArrayList, paramInt1, paramInt2);
            }
          }
          i1 += 1;
        }
      }
    } while (((i3 == 262144) && (i2 != paramArrayList.size())) || (!isFocusable()) || (((paramInt2 & 0x1) == 1) && (isInTouchMode()) && (!isFocusableInTouchMode())));
    paramArrayList.add(this);
  }
  
  public void addTouchables(ArrayList<View> paramArrayList)
  {
    int i1 = 0;
    while (i1 < getChildCount())
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        XViewPager.ItemInfo localItemInfo = a(localView);
        if ((localItemInfo != null) && (localItemInfo.jdField_a_of_type_Int == this.jdField_e_of_type_Int)) {
          localView.addTouchables(paramArrayList);
        }
      }
      i1 += 1;
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (!checkLayoutParams(paramLayoutParams)) {
      paramLayoutParams = generateLayoutParams(paramLayoutParams);
    }
    for (;;)
    {
      XViewPager.LayoutParams localLayoutParams = (XViewPager.LayoutParams)paramLayoutParams;
      localLayoutParams.jdField_a_of_type_Boolean |= paramView instanceof XViewPager.Decor;
      if (this.jdField_f_of_type_Boolean)
      {
        if (localLayoutParams.jdField_a_of_type_Boolean) {
          throw new IllegalStateException("Cannot add pager decor view during layout");
        }
        localLayoutParams.jdField_b_of_type_Boolean = true;
        addViewInLayout(paramView, paramInt, paramLayoutParams);
        return;
      }
      super.addView(paramView, paramInt, paramLayoutParams);
      return;
    }
  }
  
  public int b()
  {
    return this.jdField_o_of_type_Int;
  }
  
  XViewPager.ItemInfo b(View paramView)
  {
    for (;;)
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent == this) {
        break;
      }
      if ((localViewParent == null) || (!(localViewParent instanceof View))) {
        return null;
      }
      paramView = (View)localViewParent;
    }
    return a(paramView);
  }
  
  void b()
  {
    int i7 = this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getCount();
    this.jdField_d_of_type_Int = i7;
    int i1;
    int i2;
    int i3;
    int i5;
    int i4;
    label67:
    Object localObject;
    int i6;
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() < this.jdField_n_of_type_Int * 2 + 1) && (this.jdField_a_of_type_JavaUtilArrayList.size() < i7))
    {
      i1 = 1;
      i2 = this.jdField_e_of_type_Int;
      i3 = 0;
      i5 = 0;
      i4 = i1;
      i1 = i2;
      i2 = i3;
      i3 = i5;
      if (i3 >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label299;
      }
      localObject = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i3);
      i5 = this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getItemPosition(((XViewPager.ItemInfo)localObject).jdField_a_of_type_JavaLangObject);
      if (i5 != -1) {
        break label157;
      }
      i5 = i3;
      i6 = i2;
      i3 = i4;
      i2 = i1;
      i1 = i6;
      i4 = i5;
    }
    for (;;)
    {
      i5 = i3;
      i6 = i2;
      i3 = i4 + 1;
      i2 = i1;
      i1 = i6;
      i4 = i5;
      break label67;
      i1 = 0;
      break;
      label157:
      if (i5 == -2)
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(i3);
        i4 = i3 - 1;
        i3 = i2;
        if (i2 == 0)
        {
          this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.startUpdate(this);
          i3 = 1;
        }
        this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.destroyItem(this, ((XViewPager.ItemInfo)localObject).jdField_a_of_type_Int, ((XViewPager.ItemInfo)localObject).jdField_a_of_type_JavaLangObject);
        if (this.jdField_e_of_type_Int == ((XViewPager.ItemInfo)localObject).jdField_a_of_type_Int)
        {
          i2 = Math.max(0, Math.min(this.jdField_e_of_type_Int, i7 - 1));
          i1 = i3;
          i3 = 1;
        }
      }
      else
      {
        if (((XViewPager.ItemInfo)localObject).jdField_a_of_type_Int != i5)
        {
          if (((XViewPager.ItemInfo)localObject).jdField_a_of_type_Int == this.jdField_e_of_type_Int) {
            i1 = i5;
          }
          ((XViewPager.ItemInfo)localObject).jdField_a_of_type_Int = i5;
          i5 = i1;
          i6 = 1;
          i4 = i3;
          i1 = i2;
          i2 = i5;
          i3 = i6;
          continue;
          label299:
          if (i2 != 0) {
            this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.finishUpdate(this);
          }
          Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, jdField_a_of_type_JavaUtilComparator);
          if (i4 != 0)
          {
            i3 = getChildCount();
            i2 = 0;
            while (i2 < i3)
            {
              localObject = (XViewPager.LayoutParams)getChildAt(i2).getLayoutParams();
              if (!((XViewPager.LayoutParams)localObject).jdField_a_of_type_Boolean) {
                ((XViewPager.LayoutParams)localObject).jdField_a_of_type_Float = 0.0F;
              }
              i2 += 1;
            }
            a(i1, false, true);
            requestLayout();
          }
          return;
        }
        i5 = i1;
        i6 = i4;
        i4 = i3;
        i1 = i2;
        i2 = i5;
        i3 = i6;
        continue;
      }
      i2 = i1;
      i5 = 1;
      i1 = i3;
      i3 = i5;
    }
  }
  
  protected void b(int paramInt1, float paramFloat, int paramInt2)
  {
    int i1;
    int i2;
    Object localObject;
    if (this.w > 0)
    {
      int i6 = getScrollY();
      i1 = getPaddingTop();
      i2 = getPaddingBottom();
      int i7 = getHeight();
      int i8 = getChildCount();
      int i5 = 0;
      while (i5 < i8)
      {
        localObject = getChildAt(i5);
        XViewPager.LayoutParams localLayoutParams = (XViewPager.LayoutParams)((View)localObject).getLayoutParams();
        int i4;
        int i3;
        if (!localLayoutParams.jdField_a_of_type_Boolean)
        {
          i4 = i1;
          i3 = i2;
          i5 += 1;
          i1 = i4;
          i2 = i3;
        }
        else
        {
          switch (localLayoutParams.jdField_a_of_type_Int & 0x70)
          {
          default: 
            i3 = i1;
            i4 = i2;
            i2 = i1;
            i1 = i4;
          }
          for (;;)
          {
            int i9 = i3 + i6 - ((View)localObject).getTop();
            i3 = i1;
            i4 = i2;
            if (i9 == 0) {
              break;
            }
            ((View)localObject).offsetTopAndBottom(i9);
            i3 = i1;
            i4 = i2;
            break;
            i3 = ((View)localObject).getHeight();
            i4 = i3 + i1;
            i3 = i1;
            i1 = i2;
            i2 = i4;
            continue;
            i3 = Math.max((i7 - ((View)localObject).getMeasuredHeight()) / 2, i1);
            i4 = i1;
            i1 = i2;
            i2 = i4;
            continue;
            i3 = i7 - i2 - ((View)localObject).getMeasuredHeight();
            i9 = ((View)localObject).getMeasuredHeight();
            i4 = i1;
            i1 = i2 + i9;
            i2 = i4;
          }
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener.a(paramInt1, paramFloat, paramInt2);
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      i2 = this.jdField_a_of_type_JavaUtilList.size();
      i1 = 0;
      while (i1 < i2)
      {
        localObject = (XViewPager.OnPageChangeListener)this.jdField_a_of_type_JavaUtilList.get(i1);
        if (localObject != null) {
          ((XViewPager.OnPageChangeListener)localObject).a(paramInt1, paramFloat, paramInt2);
        }
        i1 += 1;
      }
    }
    if (this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener != null) {
      this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener.a(paramInt1, paramFloat, paramInt2);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$PageTransformer != null)
    {
      paramInt2 = getScrollY();
      i1 = getChildCount();
      paramInt1 = 0;
      if (paramInt1 < i1)
      {
        localObject = getChildAt(paramInt1);
        if (((XViewPager.LayoutParams)((View)localObject).getLayoutParams()).jdField_a_of_type_Boolean) {}
        for (;;)
        {
          paramInt1 += 1;
          break;
          paramFloat = (((View)localObject).getTop() - paramInt2) / e();
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$PageTransformer.a((View)localObject, paramFloat);
        }
      }
    }
    this.jdField_o_of_type_Boolean = true;
  }
  
  boolean b()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter != null) && (this.jdField_e_of_type_Int < this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getCount() - 1))
    {
      setCurrentItem(this.jdField_e_of_type_Int + 1, true);
      return true;
    }
    return false;
  }
  
  protected boolean b(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    int i1;
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i2 = paramView.getScrollX();
      int i3 = paramView.getScrollY();
      i1 = localViewGroup.getChildCount() - 1;
      if (i1 >= 0)
      {
        localView = localViewGroup.getChildAt(i1);
        if ((paramInt2 + i2 < localView.getLeft()) || (paramInt2 + i2 >= localView.getRight()) || (paramInt3 + i3 < localView.getTop()) || (paramInt3 + i3 >= localView.getBottom()) || (!b(localView, true, paramInt1, paramInt2 + i2 - localView.getLeft(), paramInt3 + i3 - localView.getTop()))) {}
      }
    }
    while ((paramBoolean) && (ViewCompat.canScrollVertically(paramView, -paramInt1)))
    {
      View localView;
      return true;
      i1 -= 1;
      break;
    }
    return false;
  }
  
  public int c()
  {
    return this.jdField_e_of_type_Int;
  }
  
  void c()
  {
    a(this.jdField_e_of_type_Int);
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter == null) {}
    int i1;
    int i2;
    do
    {
      do
      {
        return false;
      } while (!c());
      i1 = d();
      i2 = getScrollX();
      if (paramInt < 0)
      {
        if (i2 > (int)(i1 * this.jdField_b_of_type_Float)) {}
        for (;;)
        {
          return bool1;
          bool1 = false;
        }
      }
    } while (paramInt <= 0);
    if (i2 < (int)(i1 * this.jdField_c_of_type_Float)) {}
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof XViewPager.LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    f();
    if ((!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) && (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset()))
    {
      int i1 = getScrollX();
      int i2 = getScrollY();
      int i3 = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
      int i4 = this.jdField_a_of_type_AndroidWidgetScroller.getCurrY();
      if ((i1 != i3) || (i2 != i4))
      {
        scrollTo(i3, i4);
        if (!Gravity.isHorizontal(this.jdField_o_of_type_Int)) {
          break label106;
        }
        if (!b(i3))
        {
          this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
          scrollTo(0, i4);
        }
      }
      for (;;)
      {
        ViewCompat.postInvalidateOnAnimation(this);
        return;
        label106:
        if (!c(i4))
        {
          this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
          scrollTo(i3, 0);
        }
      }
    }
    if (this.z == 0) {
      this.jdField_o_of_type_Int = 0;
    }
    b(true);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyEvent(paramKeyEvent)) || (a(paramKeyEvent));
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramAccessibilityEvent.getEventType() == 4096)
    {
      bool1 = super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
      return bool1;
    }
    int i2 = getChildCount();
    int i1 = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i1 >= i2) {
        break;
      }
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        XViewPager.ItemInfo localItemInfo = a(localView);
        if ((localItemInfo != null) && (localItemInfo.jdField_a_of_type_Int == this.jdField_e_of_type_Int) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent))) {
          return true;
        }
      }
      i1 += 1;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i3 = 0;
    int i1 = 0;
    int i4 = ViewCompat.getOverScrollMode(this);
    boolean bool;
    if ((i4 == 0) || ((i4 == 1) && (this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter != null) && (this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getCount() > 1)))
    {
      int i2;
      if (!this.jdField_a_of_type_AndroidSupportV4WidgetEdgeEffectCompat.isFinished())
      {
        i3 = paramCanvas.save();
        i1 = getHeight() - getPaddingTop() - getPaddingBottom();
        i4 = getWidth();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(-i1 + getPaddingTop(), this.jdField_b_of_type_Float * i4);
        this.jdField_a_of_type_AndroidSupportV4WidgetEdgeEffectCompat.setSize(i1, i4);
        i2 = false | this.jdField_a_of_type_AndroidSupportV4WidgetEdgeEffectCompat.draw(paramCanvas);
        paramCanvas.restoreToCount(i3);
      }
      i3 = i2;
      if (!this.jdField_b_of_type_AndroidSupportV4WidgetEdgeEffectCompat.isFinished())
      {
        i4 = paramCanvas.save();
        i3 = getWidth();
        int i5 = getHeight();
        int i6 = getPaddingTop();
        int i7 = getPaddingBottom();
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(-getPaddingTop(), -(this.jdField_c_of_type_Float + 1.0F) * i3);
        this.jdField_b_of_type_AndroidSupportV4WidgetEdgeEffectCompat.setSize(i5 - i6 - i7, i3);
        bool = i2 | this.jdField_b_of_type_AndroidSupportV4WidgetEdgeEffectCompat.draw(paramCanvas);
        paramCanvas.restoreToCount(i4);
      }
      if (!this.jdField_c_of_type_AndroidSupportV4WidgetEdgeEffectCompat.isFinished()) {
        throw new RuntimeException("do not support (OVER_SCROLL_ALWAYS, OVER_SCROLL_IF_CONTENT_SCROLLS)");
      }
      if (!this.jdField_b_of_type_AndroidSupportV4WidgetEdgeEffectCompat.isFinished()) {
        throw new RuntimeException("do not support (OVER_SCROLL_ALWAYS, OVER_SCROLL_IF_CONTENT_SCROLLS)");
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidSupportV4WidgetEdgeEffectCompat.finish();
      this.jdField_b_of_type_AndroidSupportV4WidgetEdgeEffectCompat.finish();
      this.jdField_c_of_type_AndroidSupportV4WidgetEdgeEffectCompat.finish();
      this.jdField_d_of_type_AndroidSupportV4WidgetEdgeEffectCompat.finish();
    }
    if (bool) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  public ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new XViewPager.LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new XViewPager.LayoutParams(getContext(), paramAttributeSet);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return generateDefaultLayoutParams();
  }
  
  public int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if ((Build.VERSION.SDK_INT >= 24) && ((this.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_b_of_type_JavaUtilArrayList.size() != getChildCount()))) {
      e();
    }
    if (this.x == 2) {}
    for (int i1 = paramInt1 - 1 - paramInt2; this.jdField_b_of_type_JavaUtilArrayList != null; i1 = paramInt2) {
      return ((XViewPager.LayoutParams)((View)this.jdField_b_of_type_JavaUtilArrayList.get(i1)).getLayoutParams()).jdField_c_of_type_Int;
    }
    return super.getChildDrawingOrder(paramInt1, paramInt2);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_l_of_type_Boolean = true;
  }
  
  public void onDetachedFromWindow()
  {
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    super.onDetachedFromWindow();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (f()) {
      a(paramCanvas);
    }
    label17:
    while ((this.jdField_g_of_type_Int <= 0) || (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) || (this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter == null)) {
      return;
    }
    int i3 = getScrollX();
    int i4 = getWidth();
    float f3 = this.jdField_g_of_type_Int / i4;
    Object localObject = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    float f1 = ((XViewPager.ItemInfo)localObject).jdField_b_of_type_Float;
    int i5 = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i1 = ((XViewPager.ItemInfo)localObject).jdField_a_of_type_Int;
    int i6 = ((XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i5 - 1)).jdField_a_of_type_Int;
    int i2 = 0;
    label129:
    float f2;
    if (i1 < i6)
    {
      while ((i1 > ((XViewPager.ItemInfo)localObject).jdField_a_of_type_Int) && (i2 < i5))
      {
        localObject = this.jdField_a_of_type_JavaUtilArrayList;
        i2 += 1;
        localObject = (XViewPager.ItemInfo)((ArrayList)localObject).get(i2);
      }
      if (i1 != ((XViewPager.ItemInfo)localObject).jdField_a_of_type_Int) {
        break label292;
      }
      f2 = (((XViewPager.ItemInfo)localObject).jdField_b_of_type_Float + ((XViewPager.ItemInfo)localObject).jdField_a_of_type_Float) * i4;
    }
    label292:
    float f4;
    for (f1 = ((XViewPager.ItemInfo)localObject).jdField_b_of_type_Float + ((XViewPager.ItemInfo)localObject).jdField_a_of_type_Float + f3;; f1 += f4 + f3)
    {
      if (this.jdField_g_of_type_Int + f2 > i3)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds((int)f2, this.jdField_h_of_type_Int, (int)(this.jdField_g_of_type_Int + f2 + 0.5F), this.jdField_i_of_type_Int);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
      if (f2 > i3 + i4) {
        break;
      }
      i1 += 1;
      break label129;
      break label17;
      f4 = this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getPageWidth(i1);
      f2 = (f1 + f4) * i4;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if ((i1 == 3) || (i1 == 1))
    {
      this.jdField_i_of_type_Boolean = false;
      this.jdField_j_of_type_Boolean = false;
      this.r = -1;
      if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
      {
        this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
        this.jdField_a_of_type_AndroidViewVelocityTracker = null;
      }
      return false;
    }
    if (i1 != 0)
    {
      if (this.jdField_i_of_type_Boolean) {
        return true;
      }
      if (this.jdField_j_of_type_Boolean) {
        return false;
      }
    }
    switch (i1)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
        this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
      }
      this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
      return this.jdField_i_of_type_Boolean;
      i1 = this.r;
      if (i1 != -1)
      {
        i1 = MotionEventCompat.findPointerIndex(paramMotionEvent, i1);
        float f2 = MotionEventCompat.getX(paramMotionEvent, i1);
        float f1 = f2 - this.jdField_d_of_type_Float;
        float f4 = Math.abs(f1);
        float f3 = MotionEventCompat.getY(paramMotionEvent, i1);
        float f5 = f3 - this.jdField_e_of_type_Float;
        float f6 = Math.abs(f5);
        if (((d()) || ((this.jdField_a_of_type_Boolean) && (f5 < 0.0F)) || ((this.jdField_b_of_type_Boolean) && (f5 > 0.0F))) && (f5 != 0.0F) && (!b(this.jdField_e_of_type_Float, f5)) && (b(this, false, (int)f5, (int)f2, (int)f3)))
        {
          this.jdField_d_of_type_Float = f2;
          this.jdField_e_of_type_Float = f3;
          this.jdField_j_of_type_Boolean = true;
          this.jdField_o_of_type_Int = 0;
          return false;
        }
        if (((c()) || ((this.jdField_c_of_type_Boolean) && (f1 < 0.0F)) || ((this.jdField_d_of_type_Boolean) && (f1 > 0.0F))) && (f1 != 0.0F) && (!a(this.jdField_d_of_type_Float, f1)) && (a(this, false, (int)f1, (int)f2, (int)f3)))
        {
          this.jdField_d_of_type_Float = f2;
          this.jdField_e_of_type_Float = f3;
          this.jdField_j_of_type_Boolean = true;
          this.jdField_o_of_type_Int = 0;
          return false;
        }
        if (((d()) || ((this.jdField_a_of_type_Boolean) && (f5 < 0.0F)) || ((this.jdField_b_of_type_Boolean) && (f5 > 0.0F))) && (!Gravity.isHorizontal(this.jdField_o_of_type_Int)) && (f6 > this.jdField_a_of_type_Int) && (0.6F * f6 > f4))
        {
          this.jdField_i_of_type_Boolean = true;
          if (f5 > 0.0F)
          {
            i1 = 80;
            label475:
            this.jdField_o_of_type_Int = i1;
            d(true);
            b(1);
            this.jdField_d_of_type_Float = f2;
            if (f5 <= 0.0F) {
              break label563;
            }
            f1 = this.jdField_g_of_type_Float + this.jdField_a_of_type_Int;
            label514:
            this.jdField_e_of_type_Float = f1;
            e(true);
          }
        }
        while (this.jdField_i_of_type_Boolean)
        {
          if (!Gravity.isHorizontal(this.jdField_o_of_type_Int)) {
            break label834;
          }
          if (!a(f2)) {
            break;
          }
          ViewCompat.postInvalidateOnAnimation(this);
          break;
          i1 = 48;
          break label475;
          label563:
          f1 = this.jdField_g_of_type_Float - this.jdField_a_of_type_Int;
          break label514;
          if (((c()) || ((this.jdField_c_of_type_Boolean) && (f1 < 0.0F)) || ((this.jdField_d_of_type_Boolean) && (f1 > 0.0F))) && (!Gravity.isVertical(this.jdField_o_of_type_Int)) && (f4 > this.jdField_a_of_type_Int) && (0.6F * f4 > f6))
          {
            this.jdField_i_of_type_Boolean = true;
            if (f1 > 0.0F)
            {
              i1 = 5;
              label656:
              this.jdField_o_of_type_Int = i1;
              d(true);
              b(1);
              if (f1 <= 0.0F) {
                break label714;
              }
            }
            label714:
            for (f1 = this.jdField_f_of_type_Float + this.jdField_a_of_type_Int;; f1 = this.jdField_f_of_type_Float - this.jdField_a_of_type_Int)
            {
              this.jdField_d_of_type_Float = f1;
              this.jdField_e_of_type_Float = f3;
              e(true);
              break;
              i1 = 3;
              break label656;
            }
          }
          if (((!d()) || ((this.jdField_a_of_type_Boolean) && (f5 > 0.0F)) || ((this.jdField_b_of_type_Boolean) && (f5 < 0.0F))) && (f6 > this.jdField_a_of_type_Int)) {
            this.jdField_j_of_type_Boolean = true;
          } else if (((!c()) || ((this.jdField_c_of_type_Boolean) && (f1 > 0.0F)) || ((this.jdField_d_of_type_Boolean) && (f1 < 0.0F))) && (f4 > this.jdField_a_of_type_Int)) {
            this.jdField_j_of_type_Boolean = true;
          }
        }
        label834:
        if (b(f3))
        {
          ViewCompat.postInvalidateOnAnimation(this);
          continue;
          f1 = paramMotionEvent.getX();
          this.jdField_f_of_type_Float = f1;
          this.jdField_d_of_type_Float = f1;
          f1 = paramMotionEvent.getY();
          this.jdField_g_of_type_Float = f1;
          this.jdField_e_of_type_Float = f1;
          this.r = MotionEventCompat.getPointerId(paramMotionEvent, 0);
          this.jdField_j_of_type_Boolean = false;
          this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset();
          if ((Gravity.isHorizontal(this.jdField_o_of_type_Int)) && (this.z == 2) && (Math.abs(this.jdField_a_of_type_AndroidWidgetScroller.getFinalX() - this.jdField_a_of_type_AndroidWidgetScroller.getCurrX()) > this.v))
          {
            this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
            this.jdField_h_of_type_Boolean = false;
            c();
            this.jdField_i_of_type_Boolean = true;
            d(true);
            b(1);
          }
          else if ((Gravity.isVertical(this.jdField_o_of_type_Int)) && (this.z == 2) && (Math.abs(this.jdField_a_of_type_AndroidWidgetScroller.getFinalY() - this.jdField_a_of_type_AndroidWidgetScroller.getCurrY()) > this.v))
          {
            this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
            this.jdField_h_of_type_Boolean = false;
            c();
            this.jdField_i_of_type_Boolean = true;
            d(true);
            b(1);
          }
          else
          {
            b(false);
            this.jdField_i_of_type_Boolean = false;
            continue;
            a(paramMotionEvent);
          }
        }
      }
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (f())
    {
      a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    int i6 = getChildCount();
    int i7 = paramInt3 - paramInt1;
    int i8 = paramInt4 - paramInt2;
    paramInt2 = getPaddingLeft();
    paramInt1 = getPaddingTop();
    paramInt4 = getPaddingRight();
    paramInt3 = getPaddingBottom();
    int i9 = getScrollX();
    int i2 = 0;
    int i4 = 0;
    View localView;
    XViewPager.LayoutParams localLayoutParams;
    int i1;
    int i10;
    int i3;
    label174:
    int i5;
    if (i4 < i6)
    {
      localView = getChildAt(i4);
      if (localView.getVisibility() == 8) {
        break label709;
      }
      localLayoutParams = (XViewPager.LayoutParams)localView.getLayoutParams();
      if (!localLayoutParams.jdField_a_of_type_Boolean) {
        break label709;
      }
      i1 = localLayoutParams.jdField_a_of_type_Int;
      i10 = localLayoutParams.jdField_a_of_type_Int;
      switch (i1 & 0x7)
      {
      case 2: 
      case 4: 
      default: 
        i1 = paramInt2;
        i3 = paramInt2;
        switch (i10 & 0x70)
        {
        default: 
          i5 = paramInt1;
          paramInt2 = paramInt1;
          paramInt1 = paramInt3;
          paramInt3 = i5;
          label224:
          i1 += i9;
          localView.layout(i1, paramInt3, localView.getMeasuredWidth() + i1, localView.getMeasuredHeight() + paramInt3);
          i2 += 1;
          paramInt3 = i3;
          i1 = paramInt1;
          paramInt1 = i2;
        }
        break;
      }
    }
    for (;;)
    {
      i4 += 1;
      i3 = paramInt3;
      i2 = paramInt1;
      paramInt1 = paramInt2;
      paramInt3 = i1;
      paramInt2 = i3;
      break;
      i3 = localView.getMeasuredWidth();
      i1 = paramInt2;
      i3 += paramInt2;
      break label174;
      i1 = Math.max((i7 - localView.getMeasuredWidth()) / 2, paramInt2);
      i3 = paramInt2;
      break label174;
      i3 = localView.getMeasuredWidth();
      i1 = paramInt4 + localView.getMeasuredWidth();
      i5 = i7 - paramInt4 - i3;
      paramInt4 = i1;
      i3 = paramInt2;
      i1 = i5;
      break label174;
      i5 = localView.getMeasuredHeight();
      paramInt2 = paramInt3;
      i5 += paramInt1;
      paramInt3 = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = i5;
      break label224;
      i5 = Math.max((i8 - localView.getMeasuredHeight()) / 2, paramInt1);
      paramInt2 = paramInt1;
      paramInt1 = paramInt3;
      paramInt3 = i5;
      break label224;
      i5 = i8 - paramInt3 - localView.getMeasuredHeight();
      i10 = localView.getMeasuredHeight();
      paramInt2 = paramInt1;
      paramInt1 = paramInt3 + i10;
      paramInt3 = i5;
      break label224;
      i3 = i7 - paramInt2 - paramInt4;
      i1 = 0;
      while (i1 < i6)
      {
        localView = getChildAt(i1);
        if (localView.getVisibility() != 8)
        {
          localLayoutParams = (XViewPager.LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.jdField_a_of_type_Boolean)
          {
            XViewPager.ItemInfo localItemInfo = a(localView);
            if (localItemInfo != null)
            {
              float f1 = i3;
              i4 = (int)(localItemInfo.jdField_b_of_type_Float * f1) + paramInt2;
              if (localLayoutParams.jdField_b_of_type_Boolean)
              {
                localLayoutParams.jdField_b_of_type_Boolean = false;
                f1 = i3;
                localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.jdField_a_of_type_Float * f1), 1073741824), View.MeasureSpec.makeMeasureSpec(i8 - paramInt1 - paramInt3, 1073741824));
              }
              localView.layout(i4, paramInt1, localView.getMeasuredWidth() + i4, localView.getMeasuredHeight() + paramInt1);
            }
          }
        }
        i1 += 1;
      }
      this.jdField_h_of_type_Int = paramInt1;
      this.jdField_j_of_type_Int = paramInt2;
      this.jdField_i_of_type_Int = (i8 - paramInt3);
      this.jdField_k_of_type_Int = (i7 - paramInt4);
      this.w = i2;
      if ((this.jdField_l_of_type_Boolean) || (this.jdField_m_of_type_Boolean)) {
        a(this.jdField_e_of_type_Int, false, 0, false);
      }
      this.jdField_l_of_type_Boolean = false;
      this.jdField_m_of_type_Boolean = false;
      return;
      label709:
      i1 = i2;
      i2 = paramInt1;
      i3 = paramInt2;
      paramInt1 = i1;
      i1 = paramInt3;
      paramInt2 = i2;
      paramInt3 = i3;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    paramInt1 = getMeasuredWidth();
    this.q = Math.min(paramInt1 / 10, this.jdField_p_of_type_Int);
    paramInt1 = paramInt1 - getPaddingLeft() - getPaddingRight();
    paramInt2 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    int i9 = getChildCount();
    int i3 = 0;
    View localView;
    int i1;
    int i2;
    XViewPager.LayoutParams localLayoutParams;
    int i4;
    int i6;
    label183:
    int i5;
    if (i3 < i9)
    {
      localView = getChildAt(i3);
      i1 = paramInt1;
      i2 = paramInt2;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (XViewPager.LayoutParams)localView.getLayoutParams();
        i1 = paramInt1;
        i2 = paramInt2;
        if (localLayoutParams != null)
        {
          i1 = paramInt1;
          i2 = paramInt2;
          if (localLayoutParams.jdField_a_of_type_Boolean)
          {
            i1 = localLayoutParams.jdField_a_of_type_Int & 0x7;
            i4 = localLayoutParams.jdField_a_of_type_Int & 0x70;
            i6 = -2147483648;
            i2 = -2147483648;
            if ((i4 != 48) && (i4 != 80)) {
              break label333;
            }
            i4 = 1;
            if ((i1 != 3) && (i1 != 5)) {
              break label339;
            }
            i5 = 1;
            label198:
            if (i4 == 0) {
              break label345;
            }
            i1 = 1073741824;
            label208:
            if (localLayoutParams.width == -2) {
              break label533;
            }
            i6 = 1073741824;
            if (localLayoutParams.width == -1) {
              break label527;
            }
            i1 = localLayoutParams.width;
          }
        }
      }
    }
    for (;;)
    {
      int i8;
      if (localLayoutParams.height != -2)
      {
        i7 = 1073741824;
        i2 = i7;
        if (localLayoutParams.height != -1)
        {
          i8 = localLayoutParams.height;
          i2 = i7;
        }
      }
      for (int i7 = i8;; i7 = paramInt2)
      {
        localView.measure(View.MeasureSpec.makeMeasureSpec(i1, i6), View.MeasureSpec.makeMeasureSpec(i7, i2));
        if (i4 != 0)
        {
          i2 = paramInt2 - localView.getMeasuredHeight();
          i1 = paramInt1;
        }
        for (;;)
        {
          i3 += 1;
          paramInt1 = i1;
          paramInt2 = i2;
          break;
          label333:
          i4 = 0;
          break label183;
          label339:
          i5 = 0;
          break label198;
          label345:
          i1 = i6;
          if (i5 == 0) {
            break label208;
          }
          i2 = 1073741824;
          i1 = i6;
          break label208;
          i1 = paramInt1;
          i2 = paramInt2;
          if (i5 != 0)
          {
            i1 = paramInt1 - localView.getMeasuredWidth();
            i2 = paramInt2;
          }
        }
        this.jdField_l_of_type_Int = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
        this.jdField_m_of_type_Int = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
        this.jdField_f_of_type_Boolean = true;
        c();
        this.jdField_f_of_type_Boolean = false;
        i1 = getChildCount();
        paramInt2 = 0;
        while (paramInt2 < i1)
        {
          localView = getChildAt(paramInt2);
          if ((localView != null) && (localView.getVisibility() != 8))
          {
            localLayoutParams = (XViewPager.LayoutParams)localView.getLayoutParams();
            if ((localLayoutParams != null) && (!localLayoutParams.jdField_a_of_type_Boolean))
            {
              float f1 = paramInt1;
              localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.jdField_a_of_type_Float * f1), 1073741824), this.jdField_m_of_type_Int);
            }
          }
          paramInt2 += 1;
        }
        return;
      }
      label527:
      i1 = paramInt1;
      continue;
      label533:
      i6 = i1;
      i1 = paramInt1;
    }
  }
  
  public boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int i3 = -1;
    int i2 = getChildCount();
    int i1;
    if ((paramInt & 0x2) != 0)
    {
      i3 = 1;
      i1 = 0;
    }
    while (i1 != i2)
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        XViewPager.ItemInfo localItemInfo = a(localView);
        if ((localItemInfo != null) && (localItemInfo.jdField_a_of_type_Int == this.jdField_e_of_type_Int) && (localView.requestFocus(paramInt, paramRect)))
        {
          return true;
          i1 = i2 - 1;
          i2 = -1;
          continue;
        }
      }
      i1 += i3;
    }
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof XViewPager.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (XViewPager.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter != null)
    {
      this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.restoreState(paramParcelable.jdField_a_of_type_AndroidOsParcelable, paramParcelable.jdField_a_of_type_JavaLangClassLoader);
      a(paramParcelable.jdField_a_of_type_Int, false, true);
      return;
    }
    this.jdField_f_of_type_Int = paramParcelable.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidOsParcelable = paramParcelable.jdField_a_of_type_AndroidOsParcelable;
    this.jdField_a_of_type_JavaLangClassLoader = paramParcelable.jdField_a_of_type_JavaLangClassLoader;
  }
  
  public Parcelable onSaveInstanceState()
  {
    XViewPager.SavedState localSavedState = new XViewPager.SavedState(super.onSaveInstanceState());
    localSavedState.jdField_a_of_type_Int = this.jdField_e_of_type_Int;
    if (this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter != null) {
      localSavedState.jdField_a_of_type_AndroidOsParcelable = this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.saveState();
    }
    return localSavedState;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      a(paramInt1, paramInt3, this.jdField_g_of_type_Int, this.jdField_g_of_type_Int);
    }
    if (paramInt2 != paramInt4) {
      b(paramInt2, paramInt4, this.jdField_g_of_type_Int, this.jdField_g_of_type_Int);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i8 = 3;
    int i7 = 0;
    if (this.jdField_k_of_type_Boolean) {
      return true;
    }
    if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0)) {
      return false;
    }
    if ((this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter == null) || (this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getCount() == 0)) {
      return false;
    }
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    int i1 = i7;
    float f1;
    float f2;
    Object localObject;
    label467:
    label474:
    label488:
    int i3;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      i1 = i7;
    case 4: 
    case 0: 
    case 2: 
    case 1: 
      label581:
      do
      {
        for (;;)
        {
          if (i1 != 0) {
            ViewCompat.postInvalidateOnAnimation(this);
          }
          return true;
          this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
          this.jdField_h_of_type_Boolean = false;
          c();
          f1 = paramMotionEvent.getX();
          this.jdField_f_of_type_Float = f1;
          this.jdField_d_of_type_Float = f1;
          f1 = paramMotionEvent.getY();
          this.jdField_g_of_type_Float = f1;
          this.jdField_e_of_type_Float = f1;
          this.r = MotionEventCompat.getPointerId(paramMotionEvent, 0);
          i1 = i7;
          continue;
          float f3;
          float f4;
          if (!this.jdField_i_of_type_Boolean)
          {
            i1 = MotionEventCompat.findPointerIndex(paramMotionEvent, this.r);
            f1 = MotionEventCompat.getX(paramMotionEvent, i1);
            f3 = Math.abs(f1 - this.jdField_d_of_type_Float);
            f2 = MotionEventCompat.getY(paramMotionEvent, i1);
            f4 = Math.abs(f2 - this.jdField_e_of_type_Float);
            if (((!d()) && ((!this.jdField_a_of_type_Boolean) || (f2 >= this.jdField_e_of_type_Float)) && ((!this.jdField_b_of_type_Boolean) || (f2 <= this.jdField_e_of_type_Float))) || ((this.jdField_i_of_type_Boolean) && (Gravity.isHorizontal(this.jdField_o_of_type_Int))) || (f4 <= this.jdField_a_of_type_Int) || (f4 <= f3)) {
              break label488;
            }
            this.jdField_i_of_type_Boolean = true;
            if (f2 >= this.jdField_e_of_type_Float) {
              break label467;
            }
            i1 = 48;
            this.jdField_o_of_type_Int = i1;
            d(true);
            this.jdField_d_of_type_Float = f1;
            if (f2 - this.jdField_g_of_type_Float <= 0.0F) {
              break label474;
            }
            f1 = this.jdField_g_of_type_Float + this.jdField_a_of_type_Int;
            this.jdField_e_of_type_Float = f1;
            b(1);
            e(true);
            localObject = getParent();
            if (localObject != null) {
              ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
            }
          }
          int i2;
          while (((!c()) && ((!this.jdField_c_of_type_Boolean) || (f1 >= this.jdField_d_of_type_Float)) && ((!this.jdField_d_of_type_Boolean) || (f1 <= this.jdField_d_of_type_Float))) || ((this.jdField_i_of_type_Boolean) && (Gravity.isVertical(this.jdField_o_of_type_Int))) || (f3 <= this.jdField_a_of_type_Int) || (f3 <= f4)) {
            for (;;)
            {
              i1 = i7;
              if (!this.jdField_i_of_type_Boolean) {
                break;
              }
              if (!Gravity.isHorizontal(this.jdField_o_of_type_Int)) {
                break label676;
              }
              boolean bool1 = false | a(MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.r)));
              break;
              i2 = 80;
              continue;
              f1 = this.jdField_g_of_type_Float - this.jdField_a_of_type_Int;
            }
          }
          this.jdField_i_of_type_Boolean = true;
          if (f1 < this.jdField_d_of_type_Float)
          {
            i2 = i8;
            this.jdField_o_of_type_Int = i2;
            d(true);
            if (f1 - this.jdField_f_of_type_Float <= 0.0F) {
              break label662;
            }
          }
          for (f1 = this.jdField_f_of_type_Float + this.jdField_a_of_type_Int;; f1 = this.jdField_f_of_type_Float - this.jdField_a_of_type_Int)
          {
            this.jdField_d_of_type_Float = f1;
            this.jdField_e_of_type_Float = f2;
            b(1);
            e(true);
            localObject = getParent();
            if (localObject == null) {
              break;
            }
            ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
            break;
            i2 = 5;
            break label581;
          }
          bool2 = false | b(MotionEventCompat.getY(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.r)));
        }
        boolean bool2 = i7;
      } while (!this.jdField_i_of_type_Boolean);
      label662:
      label676:
      if (Gravity.isHorizontal(this.jdField_o_of_type_Int))
      {
        localObject = this.jdField_a_of_type_AndroidViewVelocityTracker;
        ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.t);
        i7 = (int)VelocityTrackerCompat.getXVelocity((VelocityTracker)localObject, this.r);
        this.jdField_h_of_type_Boolean = true;
        i3 = d();
        i8 = getScrollX();
        localObject = a();
        i3 = a(((XViewPager.ItemInfo)localObject).jdField_a_of_type_Int, (i8 / i3 - ((XViewPager.ItemInfo)localObject).jdField_b_of_type_Float) / ((XViewPager.ItemInfo)localObject).jdField_a_of_type_Float, i7, (int)(MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.r)) - this.jdField_f_of_type_Float));
        if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnDragStatusChangedListener == null) || (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnDragStatusChangedListener.a())) {
          break label1296;
        }
        if ((this.jdField_o_of_type_Int == 3) && (i3 < c())) {
          i3 = c();
        }
      }
      break;
    }
    label1296:
    for (;;)
    {
      a(i3, true, true, i7);
      this.r = -1;
      g();
      boolean bool4 = this.jdField_a_of_type_AndroidSupportV4WidgetEdgeEffectCompat.onRelease();
      int i4 = this.jdField_b_of_type_AndroidSupportV4WidgetEdgeEffectCompat.onRelease() | bool4;
      break;
      if ((this.jdField_o_of_type_Int == 5) && (i4 > c()))
      {
        int i5 = c();
        continue;
        i5 = i7;
        if (!Gravity.isVertical(this.jdField_o_of_type_Int)) {
          break;
        }
        localObject = this.jdField_a_of_type_AndroidViewVelocityTracker;
        ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.t);
        i5 = (int)VelocityTrackerCompat.getYVelocity((VelocityTracker)localObject, this.r);
        this.jdField_h_of_type_Boolean = true;
        i7 = e();
        i8 = getScrollY();
        localObject = a();
        a(a(((XViewPager.ItemInfo)localObject).jdField_a_of_type_Int, (i8 / i7 - ((XViewPager.ItemInfo)localObject).jdField_b_of_type_Float) / ((XViewPager.ItemInfo)localObject).jdField_a_of_type_Float, i5, (int)(MotionEventCompat.getY(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.r)) - this.jdField_g_of_type_Float)), true, true, i5);
        this.r = -1;
        g();
        bool4 = this.jdField_c_of_type_AndroidSupportV4WidgetEdgeEffectCompat.onRelease();
        boolean bool3 = this.jdField_d_of_type_AndroidSupportV4WidgetEdgeEffectCompat.onRelease() | bool4;
        break;
        bool3 = i7;
        if (!this.jdField_i_of_type_Boolean) {
          break;
        }
        if (Gravity.isHorizontal(this.jdField_o_of_type_Int)) {
          a(this.jdField_e_of_type_Int, true, 0, false);
        }
        for (;;)
        {
          this.r = -1;
          g();
          if (!Gravity.isHorizontal(this.jdField_o_of_type_Int)) {
            break label1181;
          }
          bool4 = this.jdField_a_of_type_AndroidSupportV4WidgetEdgeEffectCompat.onRelease();
          bool3 = this.jdField_b_of_type_AndroidSupportV4WidgetEdgeEffectCompat.onRelease() | bool4;
          break;
          b(this.jdField_e_of_type_Int, true, 0, false);
        }
        label1181:
        bool4 = this.jdField_c_of_type_AndroidSupportV4WidgetEdgeEffectCompat.onRelease();
        bool3 = this.jdField_d_of_type_AndroidSupportV4WidgetEdgeEffectCompat.onRelease() | bool4;
        break;
        int i6 = MotionEventCompat.getActionIndex(paramMotionEvent);
        f1 = MotionEventCompat.getX(paramMotionEvent, i6);
        f2 = MotionEventCompat.getY(paramMotionEvent, i6);
        this.jdField_d_of_type_Float = f1;
        this.jdField_e_of_type_Float = f2;
        this.r = MotionEventCompat.getPointerId(paramMotionEvent, i6);
        i6 = i7;
        break;
        a(paramMotionEvent);
        this.jdField_d_of_type_Float = MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.r));
        this.jdField_e_of_type_Float = MotionEventCompat.getY(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.r));
        i6 = i7;
        break;
      }
    }
  }
  
  public void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnVisibilityChangeListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnVisibilityChangeListener.a(paramView, paramInt);
    }
  }
  
  public void removeView(View paramView)
  {
    if (this.jdField_f_of_type_Boolean)
    {
      removeViewInLayout(paramView);
      return;
    }
    super.removeView(paramView);
  }
  
  public void requestLayout()
  {
    super.requestLayout();
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    super.scrollTo(paramInt1, paramInt2);
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    if (this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter != null)
    {
      this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.unregisterDataSetObserver(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$PagerObserver);
      this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.startUpdate(this);
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.destroyItem(this, ((XViewPager.ItemInfo)localObject).jdField_a_of_type_Int, ((XViewPager.ItemInfo)localObject).jdField_a_of_type_JavaLangObject);
        i1 += 1;
      }
      this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.finishUpdate(this);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      d();
      this.jdField_e_of_type_Int = 0;
      scrollTo(0, 0);
    }
    Object localObject = this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter;
    this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter = paramPagerAdapter;
    this.jdField_d_of_type_Int = 0;
    boolean bool;
    if (this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter != null)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$PagerObserver == null) {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$PagerObserver = new XViewPager.PagerObserver(this, null);
      }
      this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.registerDataSetObserver(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$PagerObserver);
      this.jdField_h_of_type_Boolean = false;
      bool = this.jdField_l_of_type_Boolean;
      this.jdField_l_of_type_Boolean = true;
      this.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getCount();
      if (this.jdField_f_of_type_Int < 0) {
        break label260;
      }
      this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.restoreState(this.jdField_a_of_type_AndroidOsParcelable, this.jdField_a_of_type_JavaLangClassLoader);
      a(this.jdField_f_of_type_Int, false, true);
      this.jdField_f_of_type_Int = -1;
      this.jdField_a_of_type_AndroidOsParcelable = null;
      this.jdField_a_of_type_JavaLangClassLoader = null;
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnAdapterChangeListener != null) && (localObject != paramPagerAdapter)) {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnAdapterChangeListener.a((PagerAdapter)localObject, paramPagerAdapter);
      }
      return;
      label260:
      if (!bool) {
        c();
      } else {
        requestLayout();
      }
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.jdField_h_of_type_Boolean = false;
    if (!this.jdField_l_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramInt, bool, false);
      return;
    }
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = false;
    a(paramInt, paramBoolean, false);
  }
  
  public void setCurrentItemWithTransform(int paramInt1, int paramInt2)
  {
    this.jdField_p_of_type_Boolean = true;
    this.y = paramInt2;
    setCurrentItem(paramInt1, false);
    this.jdField_p_of_type_Boolean = false;
  }
  
  public void setDistanceAndVelocityThreshold(int paramInt1, int paramInt2)
  {
    this.u = paramInt1;
    this.s = paramInt2;
  }
  
  public void setEnableOverScroll(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void setEnableScrollDirection(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_c_of_type_Boolean = paramBoolean3;
    this.jdField_d_of_type_Boolean = paramBoolean4;
  }
  
  public void setOffscreenPageLimit(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 1)
    {
      SLog.d(this.jdField_a_of_type_JavaLangString, "Requested offscreen page limit " + paramInt + " too small; defaulting to " + 1);
      i1 = 1;
    }
    if (i1 != this.jdField_n_of_type_Int)
    {
      this.jdField_n_of_type_Int = i1;
      c();
    }
  }
  
  public void setOnDragStatusChangedListener(XViewPager.OnDragStatusChangedListener paramOnDragStatusChangedListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnDragStatusChangedListener = paramOnDragStatusChangedListener;
  }
  
  public void setOnPageChangeListener(XViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener = paramOnPageChangeListener;
  }
  
  public void setOnVisibilityChangeListener(@Nullable XViewPager.OnVisibilityChangeListener paramOnVisibilityChangeListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnVisibilityChangeListener = paramOnVisibilityChangeListener;
  }
  
  public void setPageMargin(int paramInt)
  {
    int i1 = this.jdField_g_of_type_Int;
    this.jdField_g_of_type_Int = paramInt;
    int i2;
    if (d())
    {
      i2 = getHeight();
      b(i2, i2, paramInt, i1);
    }
    for (;;)
    {
      requestLayout();
      return;
      i2 = getWidth();
      a(i2, i2, paramInt, i1);
    }
  }
  
  public void setPageMarginDrawable(@DrawableRes int paramInt)
  {
    setPageMarginDrawable(getContext().getResources().getDrawable(paramInt));
  }
  
  public void setPageMarginDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (paramDrawable != null) {
      refreshDrawableState();
    }
    if (paramDrawable == null) {}
    for (boolean bool = true;; bool = false)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
    }
  }
  
  public void setPageScrollDuration(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setPageScrollDurationDivisor(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void setPageTransformer(boolean paramBoolean, XViewPager.PageTransformer paramPageTransformer)
  {
    int i2 = 1;
    boolean bool1;
    boolean bool2;
    label28:
    int i1;
    if (Build.VERSION.SDK_INT >= 11)
    {
      if (paramPageTransformer == null) {
        break label75;
      }
      bool1 = true;
      if (this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$PageTransformer == null) {
        break label81;
      }
      bool2 = true;
      if (bool1 == bool2) {
        break label87;
      }
      i1 = 1;
      label37:
      this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$PageTransformer = paramPageTransformer;
      a(bool1);
      if (!bool1) {
        break label92;
      }
      if (paramBoolean) {
        i2 = 2;
      }
    }
    label75:
    label81:
    label87:
    label92:
    for (this.x = i2;; this.x = 0)
    {
      if (i1 != 0) {
        c();
      }
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label28;
      i1 = 0;
      break label37;
    }
  }
  
  public void setPageTurningThreshold(float paramFloat)
  {
    if ((paramFloat > 0.0F) && (paramFloat < 1.0F)) {
      this.jdField_a_of_type_Float = paramFloat;
    }
  }
  
  public void setScroller(Scroller paramScroller)
  {
    this.jdField_a_of_type_AndroidWidgetScroller = paramScroller;
  }
  
  public boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager
 * JD-Core Version:    0.7.0.1
 */