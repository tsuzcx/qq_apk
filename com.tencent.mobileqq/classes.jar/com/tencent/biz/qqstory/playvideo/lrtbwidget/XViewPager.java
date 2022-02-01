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
import androidx.viewpager.widget.PagerAdapter;
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
  private final Rect jdField_a_of_type_AndroidGraphicsRect;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Parcelable jdField_a_of_type_AndroidOsParcelable;
  private EdgeEffectCompat jdField_a_of_type_AndroidSupportV4WidgetEdgeEffectCompat;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private PagerAdapter jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter;
  private final XViewPager.ItemInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$ItemInfo;
  private XViewPager.OnAdapterChangeListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnAdapterChangeListener;
  private XViewPager.OnDragStatusChangedListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnDragStatusChangedListener;
  private XViewPager.OnPageChangeListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener;
  private XViewPager.OnVisibilityChangeListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnVisibilityChangeListener;
  private XViewPager.PageTransformer jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$PageTransformer = null;
  private XViewPager.PagerObserver jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$PagerObserver;
  private ClassLoader jdField_a_of_type_JavaLangClassLoader;
  private final Runnable jdField_a_of_type_JavaLangRunnable;
  public String a;
  private Method jdField_a_of_type_JavaLangReflectMethod;
  private final ArrayList<XViewPager.ItemInfo> jdField_a_of_type_JavaUtilArrayList;
  private List<XViewPager.OnPageChangeListener> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = -1;
  private EdgeEffectCompat jdField_b_of_type_AndroidSupportV4WidgetEdgeEffectCompat;
  private XViewPager.OnPageChangeListener jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener;
  private XViewPager.PageTransformer jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$PageTransformer;
  private ArrayList<View> jdField_b_of_type_JavaUtilArrayList;
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float;
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
  private int jdField_f_of_type_Int;
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
  private boolean jdField_l_of_type_Boolean;
  private int jdField_m_of_type_Int;
  private boolean jdField_m_of_type_Boolean;
  private int jdField_n_of_type_Int;
  private boolean jdField_n_of_type_Boolean;
  private int jdField_o_of_type_Int;
  private boolean jdField_o_of_type_Boolean;
  private int jdField_p_of_type_Int;
  private boolean jdField_p_of_type_Boolean;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  private int w;
  private int x;
  private int y;
  private int z;
  
  static
  {
    jdField_a_of_type_JavaUtilComparator = new XViewPager.1();
  }
  
  public XViewPager(Context paramContext)
  {
    super(paramContext);
    paramContext = new StringBuilder();
    paramContext.append("XViewPager");
    paramContext.append(System.identityHashCode(this));
    this.jdField_a_of_type_JavaLangString = paramContext.toString();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$ItemInfo = new XViewPager.ItemInfo();
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_f_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsParcelable = null;
    this.jdField_a_of_type_JavaLangClassLoader = null;
    this.jdField_b_of_type_Float = -3.402824E+038F;
    this.jdField_c_of_type_Float = 3.4028235E+38F;
    this.jdField_n_of_type_Int = 1;
    this.r = -1;
    this.jdField_l_of_type_Boolean = true;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_n_of_type_Boolean = false;
    this.jdField_p_of_type_Boolean = false;
    this.y = 0;
    this.jdField_a_of_type_JavaLangRunnable = new XViewPager.3(this);
    this.z = 0;
    a();
  }
  
  public XViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = new StringBuilder();
    paramContext.append("XViewPager");
    paramContext.append(System.identityHashCode(this));
    this.jdField_a_of_type_JavaLangString = paramContext.toString();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$ItemInfo = new XViewPager.ItemInfo();
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_f_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsParcelable = null;
    this.jdField_a_of_type_JavaLangClassLoader = null;
    this.jdField_b_of_type_Float = -3.402824E+038F;
    this.jdField_c_of_type_Float = 3.4028235E+38F;
    this.jdField_n_of_type_Int = 1;
    this.r = -1;
    this.jdField_l_of_type_Boolean = true;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_n_of_type_Boolean = false;
    this.jdField_p_of_type_Boolean = false;
    this.y = 0;
    this.jdField_a_of_type_JavaLangRunnable = new XViewPager.3(this);
    this.z = 0;
    a();
  }
  
  private int a(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    if ((Math.abs(paramInt3) > this.u) && (Math.abs(paramInt2) > this.s))
    {
      if (paramInt2 <= 0) {
        paramInt1 += 1;
      }
    }
    else
    {
      float f1;
      if (paramInt1 >= this.jdField_e_of_type_Int) {
        f1 = 1.0F - this.jdField_a_of_type_Float;
      } else {
        f1 = this.jdField_a_of_type_Float;
      }
      paramInt1 = (int)(paramInt1 + paramFloat + f1);
    }
    paramInt2 = paramInt1;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      if (this.jdField_n_of_type_Int == 0) {
        return Math.max(0, Math.min(paramInt1, this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getCount()));
      }
      XViewPager.ItemInfo localItemInfo = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
      localObject = (XViewPager.ItemInfo)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
      paramInt2 = Math.max(localItemInfo.jdField_a_of_type_Int, Math.min(paramInt1, ((XViewPager.ItemInfo)localObject).jdField_a_of_type_Int));
    }
    return paramInt2;
  }
  
  private Rect a(Rect paramRect, View paramView)
  {
    Rect localRect = paramRect;
    if (paramRect == null) {
      localRect = new Rect();
    }
    if (paramView == null)
    {
      localRect.set(0, 0, 0, 0);
      return localRect;
    }
    localRect.left = paramView.getLeft();
    localRect.right = paramView.getRight();
    localRect.top = paramView.getTop();
    localRect.bottom = paramView.getBottom();
    for (paramRect = paramView.getParent(); ((paramRect instanceof ViewGroup)) && (paramRect != this); paramRect = paramRect.getParent())
    {
      paramRect = (ViewGroup)paramRect;
      localRect.left += paramRect.getLeft();
      localRect.right += paramRect.getRight();
      localRect.top += paramRect.getTop();
      localRect.bottom += paramRect.getBottom();
    }
    return localRect;
  }
  
  private XViewPager.ItemInfo a()
  {
    if (f()) {
      return b();
    }
    int i1 = d();
    float f1;
    if (i1 > 0) {
      f1 = getScrollX() / i1;
    } else {
      f1 = 0.0F;
    }
    float f2;
    if (i1 > 0) {
      f2 = this.jdField_g_of_type_Int / i1;
    } else {
      f2 = 0.0F;
    }
    Object localObject = null;
    i1 = 0;
    int i2 = 1;
    int i3 = -1;
    float f3 = 0.0F;
    float f4 = 0.0F;
    while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      XViewPager.ItemInfo localItemInfo2 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      int i4 = i1;
      XViewPager.ItemInfo localItemInfo1 = localItemInfo2;
      if (i2 == 0)
      {
        int i5 = localItemInfo2.jdField_a_of_type_Int;
        i3 += 1;
        i4 = i1;
        localItemInfo1 = localItemInfo2;
        if (i5 != i3)
        {
          localItemInfo1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$ItemInfo;
          localItemInfo1.jdField_b_of_type_Float = (f3 + f4 + f2);
          localItemInfo1.jdField_a_of_type_Int = i3;
          localItemInfo1.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getPageWidth(localItemInfo1.jdField_a_of_type_Int);
          i4 = i1 - 1;
        }
      }
      f3 = localItemInfo1.jdField_b_of_type_Float;
      f4 = localItemInfo1.jdField_a_of_type_Float;
      if ((i2 == 0) && (f1 < f3)) {
        return localObject;
      }
      if (f1 >= f4 + f3 + f2)
      {
        if (i4 == this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
          return localItemInfo1;
        }
        i3 = localItemInfo1.jdField_a_of_type_Int;
        f4 = localItemInfo1.jdField_a_of_type_Float;
        i1 = i4 + 1;
        i2 = 0;
        localObject = localItemInfo1;
      }
      else
      {
        return localItemInfo1;
      }
    }
    return localObject;
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
    XViewPager.ItemInfo localItemInfo;
    if ((paramInt2 > 0) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      int i1 = getPaddingLeft();
      int i2 = getPaddingRight();
      int i3 = getPaddingLeft();
      int i4 = getPaddingRight();
      paramInt2 = (int)(getScrollX() / (paramInt2 - i3 - i4 + paramInt4) * (paramInt1 - i1 - i2 + paramInt3));
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
    }
    else
    {
      localItemInfo = a(this.jdField_e_of_type_Int);
      float f1;
      if (localItemInfo != null) {
        f1 = Math.min(localItemInfo.jdField_b_of_type_Float, this.jdField_c_of_type_Float);
      } else {
        f1 = 0.0F;
      }
      paramInt1 = (int)(f1 * (paramInt1 - getPaddingLeft() - getPaddingRight()));
      if (paramInt1 != getScrollX())
      {
        b(false);
        scrollTo(paramInt1, getScrollY());
      }
    }
  }
  
  private void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    Object localObject = a(paramInt1);
    int i2 = 0;
    int i1;
    if (localObject != null) {
      i1 = (int)(d() * Math.max(this.jdField_b_of_type_Float, Math.min(((XViewPager.ItemInfo)localObject).jdField_b_of_type_Float, this.jdField_c_of_type_Float)));
    } else {
      i1 = 0;
    }
    if (paramBoolean1)
    {
      a(i1, 0, paramInt2);
      if (paramBoolean2)
      {
        localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener;
        if (localObject != null) {
          ((XViewPager.OnPageChangeListener)localObject).a(paramInt1);
        }
      }
      if (paramBoolean2)
      {
        localObject = this.jdField_a_of_type_JavaUtilList;
        if (localObject != null)
        {
          i1 = ((List)localObject).size();
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
      }
      if (paramBoolean2)
      {
        localObject = this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener;
        if (localObject != null) {
          ((XViewPager.OnPageChangeListener)localObject).a(paramInt1);
        }
      }
    }
    else
    {
      if (paramBoolean2)
      {
        localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener;
        if (localObject != null) {
          ((XViewPager.OnPageChangeListener)localObject).a(paramInt1);
        }
      }
      if (paramBoolean2)
      {
        localObject = this.jdField_a_of_type_JavaUtilList;
        if (localObject != null)
        {
          i2 = ((List)localObject).size();
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
      }
      if (paramBoolean2)
      {
        localObject = this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener;
        if (localObject != null) {
          ((XViewPager.OnPageChangeListener)localObject).a(paramInt1);
        }
      }
      b(false);
      if (this.jdField_p_of_type_Boolean)
      {
        a(paramInt1, i1);
        return;
      }
      scrollTo(i1, 0);
      b(i1);
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (MotionEventCompat.getPointerId(paramMotionEvent, i1) == this.r)
    {
      if (i1 == 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      this.jdField_d_of_type_Float = MotionEventCompat.getX(paramMotionEvent, i1);
      this.jdField_e_of_type_Float = MotionEventCompat.getY(paramMotionEvent, i1);
      this.r = MotionEventCompat.getPointerId(paramMotionEvent, i1);
      paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
      if (paramMotionEvent != null) {
        paramMotionEvent.clear();
      }
    }
  }
  
  private void a(XViewPager.ItemInfo paramItemInfo1, int paramInt, XViewPager.ItemInfo paramItemInfo2)
  {
    int i4 = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getCount();
    int i1 = d();
    float f2;
    if (i1 > 0) {
      f2 = this.jdField_g_of_type_Int / i1;
    } else {
      f2 = 0.0F;
    }
    if (paramItemInfo2 != null)
    {
      i1 = paramItemInfo2.jdField_a_of_type_Int;
      if (i1 < paramItemInfo1.jdField_a_of_type_Int)
      {
        f1 = paramItemInfo2.jdField_b_of_type_Float + paramItemInfo2.jdField_a_of_type_Float + f2;
        i1 += 1;
        i2 = 0;
        while ((i1 <= paramItemInfo1.jdField_a_of_type_Int) && (i2 < this.jdField_a_of_type_JavaUtilArrayList.size()))
        {
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
          while (i3 < paramItemInfo2.jdField_a_of_type_Int)
          {
            f3 += this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getPageWidth(i3) + f2;
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
            f3 -= this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getPageWidth(i3) + f2;
            i3 -= 1;
          }
          f1 = f3 - (paramItemInfo2.jdField_a_of_type_Float + f2);
          paramItemInfo2.jdField_b_of_type_Float = f1;
          i1 = i3 - 1;
        }
      }
    }
    int i3 = this.jdField_a_of_type_JavaUtilArrayList.size();
    float f3 = paramItemInfo1.jdField_b_of_type_Float;
    i1 = paramItemInfo1.jdField_a_of_type_Int - 1;
    if (paramItemInfo1.jdField_a_of_type_Int == 0) {
      f1 = paramItemInfo1.jdField_b_of_type_Float;
    } else {
      f1 = -3.402824E+038F;
    }
    this.jdField_b_of_type_Float = f1;
    int i2 = paramItemInfo1.jdField_a_of_type_Int;
    i4 -= 1;
    if (i2 == i4) {
      f1 = paramItemInfo1.jdField_b_of_type_Float + paramItemInfo1.jdField_a_of_type_Float - 1.0F;
    } else {
      f1 = 3.4028235E+38F;
    }
    this.jdField_c_of_type_Float = f1;
    i2 = paramInt - 1;
    float f1 = f3;
    while (i2 >= 0)
    {
      paramItemInfo2 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i2);
      while (i1 > paramItemInfo2.jdField_a_of_type_Int)
      {
        f1 -= this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getPageWidth(i1) + f2;
        i1 -= 1;
      }
      f1 -= paramItemInfo2.jdField_a_of_type_Float + f2;
      paramItemInfo2.jdField_b_of_type_Float = f1;
      if (paramItemInfo2.jdField_a_of_type_Int == 0) {
        this.jdField_b_of_type_Float = f1;
      }
      i2 -= 1;
      i1 -= 1;
    }
    f1 = paramItemInfo1.jdField_b_of_type_Float + paramItemInfo1.jdField_a_of_type_Float + f2;
    i2 = paramItemInfo1.jdField_a_of_type_Int + 1;
    i1 = paramInt + 1;
    paramInt = i2;
    while (i1 < i3)
    {
      paramItemInfo1 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      while (paramInt < paramItemInfo1.jdField_a_of_type_Int)
      {
        f1 += this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getPageWidth(paramInt) + f2;
        paramInt += 1;
      }
      if (paramItemInfo1.jdField_a_of_type_Int == i4) {
        this.jdField_c_of_type_Float = (paramItemInfo1.jdField_a_of_type_Float + f1 - 1.0F);
      }
      paramItemInfo1.jdField_b_of_type_Float = f1;
      f1 += paramItemInfo1.jdField_a_of_type_Float + f2;
      i1 += 1;
      paramInt += 1;
    }
    this.jdField_n_of_type_Boolean = false;
  }
  
  private boolean a(float paramFloat)
  {
    f();
    float f1 = this.jdField_d_of_type_Float;
    this.jdField_d_of_type_Float = paramFloat;
    float f2 = getScrollX() + (f1 - paramFloat);
    float f3 = d();
    paramFloat = this.jdField_b_of_type_Float * f3;
    f1 = this.jdField_c_of_type_Float * f3;
    Object localObject1 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList;
    localObject2 = (XViewPager.ItemInfo)((ArrayList)localObject2).get(((ArrayList)localObject2).size() - 1);
    if (((XViewPager.ItemInfo)localObject1).jdField_a_of_type_Int != 0)
    {
      paramFloat = ((XViewPager.ItemInfo)localObject1).jdField_b_of_type_Float * f3;
      i1 = 0;
    }
    else
    {
      i1 = 1;
    }
    int i2;
    if (((XViewPager.ItemInfo)localObject2).jdField_a_of_type_Int != this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getCount() - 1)
    {
      f1 = ((XViewPager.ItemInfo)localObject2).jdField_b_of_type_Float * f3;
      i2 = 0;
    }
    else
    {
      i2 = 1;
    }
    boolean bool;
    if (f2 < paramFloat)
    {
      if (i1 != 0) {
        bool = this.jdField_a_of_type_AndroidSupportV4WidgetEdgeEffectCompat.onPull(Math.abs(paramFloat - f2) / f3);
      } else {
        bool = false;
      }
      if (this.jdField_e_of_type_Boolean) {
        paramFloat = f2;
      }
    }
    else if (f2 > f1)
    {
      if (i2 != 0) {
        bool = this.jdField_b_of_type_AndroidSupportV4WidgetEdgeEffectCompat.onPull(Math.abs(f2 - f1) / f3);
      } else {
        bool = false;
      }
      if (this.jdField_e_of_type_Boolean) {
        paramFloat = f2;
      } else {
        paramFloat = f1;
      }
    }
    else
    {
      bool = false;
      paramFloat = f2;
    }
    localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnDragStatusChangedListener;
    f1 = paramFloat;
    if (localObject1 != null)
    {
      f1 = paramFloat;
      if (!((XViewPager.OnDragStatusChangedListener)localObject1).a())
      {
        i1 = getWidth() * (c() - 1);
        if (this.jdField_o_of_type_Int == 3)
        {
          f1 = i1;
          if (paramFloat < f1) {}
        }
        else
        {
          f1 = paramFloat;
          if (this.jdField_o_of_type_Int == 5)
          {
            f2 = i1;
            f1 = paramFloat;
            if (paramFloat > f2) {
              f1 = f2;
            }
          }
        }
      }
    }
    paramFloat = this.jdField_d_of_type_Float;
    int i1 = (int)f1;
    this.jdField_d_of_type_Float = (paramFloat + (f1 - i1));
    scrollTo(i1, 0);
    b(i1);
    return bool;
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return ((paramFloat1 < this.q) && (paramFloat2 > 0.0F)) || ((paramFloat1 > getWidth() - this.q) && (paramFloat2 < 0.0F));
  }
  
  private XViewPager.ItemInfo b()
  {
    int i1 = e();
    float f1;
    if (i1 > 0) {
      f1 = getScrollY() / i1;
    } else {
      f1 = 0.0F;
    }
    float f2;
    if (i1 > 0) {
      f2 = this.jdField_g_of_type_Int / i1;
    } else {
      f2 = 0.0F;
    }
    Object localObject = null;
    i1 = 0;
    int i2 = 1;
    int i3 = -1;
    float f3 = 0.0F;
    float f4 = 0.0F;
    while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      XViewPager.ItemInfo localItemInfo2 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      int i4 = i1;
      XViewPager.ItemInfo localItemInfo1 = localItemInfo2;
      if (i2 == 0)
      {
        int i5 = localItemInfo2.jdField_a_of_type_Int;
        i3 += 1;
        i4 = i1;
        localItemInfo1 = localItemInfo2;
        if (i5 != i3)
        {
          localItemInfo1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$ItemInfo;
          localItemInfo1.jdField_b_of_type_Float = (f3 + f4 + f2);
          localItemInfo1.jdField_a_of_type_Int = i3;
          localItemInfo1.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getPageWidth(localItemInfo1.jdField_a_of_type_Int);
          i4 = i1 - 1;
        }
      }
      f3 = localItemInfo1.jdField_b_of_type_Float;
      f4 = localItemInfo1.jdField_a_of_type_Float;
      if ((i2 == 0) && (f1 < f3)) {
        return localObject;
      }
      if (f1 >= f4 + f3 + f2)
      {
        if (i4 == this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
          return localItemInfo1;
        }
        i3 = localItemInfo1.jdField_a_of_type_Int;
        f4 = localItemInfo1.jdField_a_of_type_Float;
        i1 = i4 + 1;
        i2 = 0;
        localObject = localItemInfo1;
      }
      else
      {
        return localItemInfo1;
      }
    }
    return localObject;
  }
  
  private void b(int paramInt)
  {
    if (this.z == paramInt) {
      return;
    }
    this.z = paramInt;
    Object localObject = this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$PageTransformer;
    int i1 = 0;
    if (localObject != null)
    {
      boolean bool;
      if (paramInt != 0) {
        bool = true;
      } else {
        bool = false;
      }
      c(bool);
    }
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener;
    if (localObject != null) {
      ((XViewPager.OnPageChangeListener)localObject).b(paramInt);
    }
    localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      int i2 = ((List)localObject).size();
      while (i1 < i2)
      {
        localObject = (XViewPager.OnPageChangeListener)this.jdField_a_of_type_JavaUtilList.get(i1);
        if (localObject != null) {
          ((XViewPager.OnPageChangeListener)localObject).b(paramInt);
        }
        i1 += 1;
      }
    }
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    XViewPager.ItemInfo localItemInfo;
    if ((paramInt2 > 0) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      int i1 = getPaddingTop();
      int i2 = getPaddingBottom();
      int i3 = getPaddingTop();
      int i4 = getPaddingBottom();
      paramInt2 = (int)(getScrollY() / (paramInt2 - i3 - i4 + paramInt4) * (paramInt1 - i1 - i2 + paramInt3));
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
    }
    else
    {
      localItemInfo = a(this.jdField_e_of_type_Int);
      float f1;
      if (localItemInfo != null) {
        f1 = Math.min(localItemInfo.jdField_b_of_type_Float, this.jdField_c_of_type_Float);
      } else {
        f1 = 0.0F;
      }
      paramInt1 = (int)(f1 * (paramInt1 - getPaddingTop() - getPaddingBottom()));
      if (paramInt1 != getScrollY())
      {
        b(false);
        scrollTo(getScrollX(), paramInt1);
      }
    }
  }
  
  private void b(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    Object localObject = a(paramInt1);
    int i2 = 0;
    int i1;
    if (localObject != null) {
      i1 = (int)(e() * Math.max(this.jdField_b_of_type_Float, Math.min(((XViewPager.ItemInfo)localObject).jdField_b_of_type_Float, this.jdField_c_of_type_Float)));
    } else {
      i1 = 0;
    }
    if (paramBoolean1)
    {
      a(0, i1, paramInt2);
      if (paramBoolean2)
      {
        localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener;
        if (localObject != null) {
          ((XViewPager.OnPageChangeListener)localObject).a(paramInt1);
        }
      }
      if (paramBoolean2)
      {
        localObject = this.jdField_a_of_type_JavaUtilList;
        if (localObject != null)
        {
          i1 = ((List)localObject).size();
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
      }
      if (paramBoolean2)
      {
        localObject = this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener;
        if (localObject != null) {
          ((XViewPager.OnPageChangeListener)localObject).a(paramInt1);
        }
      }
    }
    else
    {
      if (paramBoolean2)
      {
        localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener;
        if (localObject != null) {
          ((XViewPager.OnPageChangeListener)localObject).a(paramInt1);
        }
      }
      if (paramBoolean2)
      {
        localObject = this.jdField_a_of_type_JavaUtilList;
        if (localObject != null)
        {
          i2 = ((List)localObject).size();
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
      }
      if (paramBoolean2)
      {
        localObject = this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener;
        if (localObject != null) {
          ((XViewPager.OnPageChangeListener)localObject).a(paramInt1);
        }
      }
      b(false);
      scrollTo(0, i1);
      c(i1);
    }
  }
  
  private void b(XViewPager.ItemInfo paramItemInfo1, int paramInt, XViewPager.ItemInfo paramItemInfo2)
  {
    int i4 = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getCount();
    int i1 = e();
    float f2;
    if (i1 > 0) {
      f2 = this.jdField_g_of_type_Int / i1;
    } else {
      f2 = 0.0F;
    }
    if (paramItemInfo2 != null)
    {
      i1 = paramItemInfo2.jdField_a_of_type_Int;
      if (i1 < paramItemInfo1.jdField_a_of_type_Int)
      {
        f1 = paramItemInfo2.jdField_b_of_type_Float + paramItemInfo2.jdField_a_of_type_Float + f2;
        i1 += 1;
        i2 = 0;
        while ((i1 <= paramItemInfo1.jdField_a_of_type_Int) && (i2 < this.jdField_a_of_type_JavaUtilArrayList.size()))
        {
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
          while (i3 < paramItemInfo2.jdField_a_of_type_Int)
          {
            f3 += this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getPageWidth(i3) + f2;
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
            f3 -= this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getPageWidth(i3) + f2;
            i3 -= 1;
          }
          f1 = f3 - (paramItemInfo2.jdField_a_of_type_Float + f2);
          paramItemInfo2.jdField_b_of_type_Float = f1;
          i1 = i3 - 1;
        }
      }
    }
    int i3 = this.jdField_a_of_type_JavaUtilArrayList.size();
    float f3 = paramItemInfo1.jdField_b_of_type_Float;
    i1 = paramItemInfo1.jdField_a_of_type_Int - 1;
    if (paramItemInfo1.jdField_a_of_type_Int == 0) {
      f1 = paramItemInfo1.jdField_b_of_type_Float;
    } else {
      f1 = -3.402824E+038F;
    }
    this.jdField_b_of_type_Float = f1;
    int i2 = paramItemInfo1.jdField_a_of_type_Int;
    i4 -= 1;
    if (i2 == i4) {
      f1 = paramItemInfo1.jdField_b_of_type_Float + paramItemInfo1.jdField_a_of_type_Float - 1.0F;
    } else {
      f1 = 3.4028235E+38F;
    }
    this.jdField_c_of_type_Float = f1;
    i2 = paramInt - 1;
    float f1 = f3;
    while (i2 >= 0)
    {
      paramItemInfo2 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i2);
      while (i1 > paramItemInfo2.jdField_a_of_type_Int)
      {
        f1 -= this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getPageWidth(i1) + f2;
        i1 -= 1;
      }
      f1 -= paramItemInfo2.jdField_a_of_type_Float + f2;
      paramItemInfo2.jdField_b_of_type_Float = f1;
      if (paramItemInfo2.jdField_a_of_type_Int == 0) {
        this.jdField_b_of_type_Float = f1;
      }
      i2 -= 1;
      i1 -= 1;
    }
    f1 = paramItemInfo1.jdField_b_of_type_Float + paramItemInfo1.jdField_a_of_type_Float + f2;
    i2 = paramItemInfo1.jdField_a_of_type_Int + 1;
    i1 = paramInt + 1;
    paramInt = i2;
    while (i1 < i3)
    {
      paramItemInfo1 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      while (paramInt < paramItemInfo1.jdField_a_of_type_Int)
      {
        f1 += this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getPageWidth(paramInt) + f2;
        paramInt += 1;
      }
      if (paramItemInfo1.jdField_a_of_type_Int == i4) {
        this.jdField_c_of_type_Float = (paramItemInfo1.jdField_a_of_type_Float + f1 - 1.0F);
      }
      paramItemInfo1.jdField_b_of_type_Float = f1;
      f1 += paramItemInfo1.jdField_a_of_type_Float + f2;
      i1 += 1;
      paramInt += 1;
    }
    this.jdField_n_of_type_Boolean = false;
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.z == 2) {
      i1 = 1;
    } else {
      i1 = 0;
    }
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
    int i2 = i1;
    int i1 = i3;
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
    if (i2 != 0)
    {
      if (paramBoolean)
      {
        ViewCompat.postOnAnimation(this, this.jdField_a_of_type_JavaLangRunnable);
        return;
      }
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
  }
  
  private boolean b(float paramFloat)
  {
    f();
    float f1 = this.jdField_e_of_type_Float;
    this.jdField_e_of_type_Float = paramFloat;
    float f2 = getScrollY() + (f1 - paramFloat);
    float f3 = e();
    paramFloat = this.jdField_b_of_type_Float * f3;
    f1 = this.jdField_c_of_type_Float * f3;
    XViewPager.ItemInfo localItemInfo = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    int i1 = ((ArrayList)localObject).size();
    int i2 = 1;
    localObject = (XViewPager.ItemInfo)((ArrayList)localObject).get(i1 - 1);
    if (localItemInfo.jdField_a_of_type_Int != 0)
    {
      paramFloat = localItemInfo.jdField_b_of_type_Float * f3;
      i1 = 0;
    }
    else
    {
      i1 = 1;
    }
    if (((XViewPager.ItemInfo)localObject).jdField_a_of_type_Int != this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getCount() - 1)
    {
      f1 = ((XViewPager.ItemInfo)localObject).jdField_b_of_type_Float * f3;
      i2 = 0;
    }
    boolean bool;
    if (f2 < paramFloat)
    {
      if (i1 != 0) {
        bool = this.jdField_c_of_type_AndroidSupportV4WidgetEdgeEffectCompat.onPull(Math.abs(paramFloat - f2) / f3);
      } else {
        bool = false;
      }
      if (this.jdField_e_of_type_Boolean) {
        paramFloat = f2;
      }
    }
    else if (f2 > f1)
    {
      if (i2 != 0) {
        bool = this.jdField_d_of_type_AndroidSupportV4WidgetEdgeEffectCompat.onPull(Math.abs(f2 - f1) / f3);
      } else {
        bool = false;
      }
      if (this.jdField_e_of_type_Boolean) {
        paramFloat = f2;
      } else {
        paramFloat = f1;
      }
    }
    else
    {
      bool = false;
      paramFloat = f2;
    }
    f1 = this.jdField_e_of_type_Float;
    i1 = (int)paramFloat;
    this.jdField_e_of_type_Float = (f1 + (paramFloat - i1));
    scrollTo(0, i1);
    c(i1);
    return bool;
  }
  
  private boolean b(float paramFloat1, float paramFloat2)
  {
    return ((paramFloat1 < this.q) && (paramFloat2 > 0.0F)) || ((paramFloat1 > getHeight() - this.q) && (paramFloat2 < 0.0F));
  }
  
  private boolean b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      this.jdField_o_of_type_Boolean = false;
      a(0, 0.0F, 0);
      if (this.jdField_o_of_type_Boolean) {
        return false;
      }
      throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }
    XViewPager.ItemInfo localItemInfo = a();
    int i2 = d();
    int i3 = this.jdField_g_of_type_Int;
    float f2 = i3;
    float f1 = i2;
    f2 /= f1;
    int i1 = localItemInfo.jdField_a_of_type_Int;
    f1 = (paramInt / f1 - localItemInfo.jdField_b_of_type_Float) / (localItemInfo.jdField_a_of_type_Float + f2);
    paramInt = (int)((i2 + i3) * f1);
    this.jdField_o_of_type_Boolean = false;
    a(i1, f1, paramInt);
    if (this.jdField_o_of_type_Boolean) {
      return true;
    }
    throw new IllegalStateException("onPageScrolled did not call superclass implementation");
  }
  
  private void c(boolean paramBoolean)
  {
    int i3 = getChildCount();
    int i1 = 0;
    while (i1 < i3)
    {
      int i2;
      if (paramBoolean) {
        i2 = 2;
      } else {
        i2 = 0;
      }
      ViewCompat.setLayerType(getChildAt(i1), i2, null);
      i1 += 1;
    }
  }
  
  private boolean c()
  {
    return (this.jdField_c_of_type_Boolean) && (this.jdField_d_of_type_Boolean);
  }
  
  private boolean c(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      this.jdField_o_of_type_Boolean = false;
      b(0, 0.0F, 0);
      if (this.jdField_o_of_type_Boolean) {
        return false;
      }
      throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }
    XViewPager.ItemInfo localItemInfo = a();
    int i2 = e();
    int i3 = this.jdField_g_of_type_Int;
    float f2 = i3;
    float f1 = i2;
    f2 /= f1;
    int i1 = localItemInfo.jdField_a_of_type_Int;
    f1 = (paramInt / f1 - localItemInfo.jdField_b_of_type_Float) / (localItemInfo.jdField_a_of_type_Float + f2);
    paramInt = (int)((i2 + i3) * f1);
    this.jdField_o_of_type_Boolean = false;
    b(i1, f1, paramInt);
    if (this.jdField_o_of_type_Boolean) {
      return true;
    }
    throw new IllegalStateException("onPageScrolled did not call superclass implementation");
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
      Object localObject = this.jdField_b_of_type_JavaUtilArrayList;
      if (localObject == null) {
        this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      } else {
        ((ArrayList)localObject).clear();
      }
      int i2 = getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        localObject = getChildAt(i1);
        this.jdField_b_of_type_JavaUtilArrayList.add(localObject);
        i1 += 1;
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
    return (Gravity.isHorizontal(this.jdField_o_of_type_Int)) || (((this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean)) && ((this.jdField_o_of_type_Int == 0) || (!f())));
  }
  
  private void f()
  {
    int i4 = getChildCount();
    int i5 = d();
    int i6 = e();
    int i3 = 0;
    int i2;
    for (int i1 = 0; i3 < i4; i1 = i2)
    {
      View localView = getChildAt(i3);
      i2 = i1;
      if (localView.getVisibility() != 8)
      {
        i2 = i1;
        if (!((XViewPager.LayoutParams)localView.getLayoutParams()).jdField_a_of_type_Boolean)
        {
          XViewPager.ItemInfo localItemInfo = a(localView);
          i2 = i1;
          if (localItemInfo != null)
          {
            int i7;
            int i8;
            if (Gravity.isHorizontal(this.jdField_o_of_type_Int))
            {
              i7 = (int)(i5 * localItemInfo.jdField_b_of_type_Float);
              i8 = getPaddingLeft();
              i2 = getPaddingTop();
              i7 = i8 + i7 - localView.getLeft();
              i2 -= localView.getTop();
              if (i7 != 0)
              {
                localView.offsetLeftAndRight(i7);
                i1 = 1;
              }
              if (i2 != 0)
              {
                localView.offsetTopAndBottom(i2);
                i1 = 1;
              }
              i2 = i1;
              if (i1 != 0)
              {
                this.jdField_m_of_type_Boolean = false;
                i2 = i1;
              }
            }
            else
            {
              i2 = i1;
              if (Gravity.isVertical(this.jdField_o_of_type_Int))
              {
                i7 = (int)(i6 * localItemInfo.jdField_b_of_type_Float);
                i8 = getPaddingTop();
                i2 = getPaddingLeft();
                i7 = i8 + i7 - localView.getTop();
                i2 -= localView.getLeft();
                if (i7 != 0)
                {
                  localView.offsetTopAndBottom(i7);
                  i1 = 1;
                }
                if (i2 != 0)
                {
                  localView.offsetLeftAndRight(i2);
                  i1 = 1;
                }
                i2 = i1;
                if (i1 != 0)
                {
                  this.jdField_m_of_type_Boolean = true;
                  i2 = i1;
                }
              }
            }
          }
        }
      }
      i3 += 1;
    }
    if (i1 != 0)
    {
      if (Gravity.isHorizontal(this.jdField_o_of_type_Int))
      {
        a(this.jdField_e_of_type_Int, false, 0, false);
        return;
      }
      if (Gravity.isVertical(this.jdField_o_of_type_Int)) {
        b(this.jdField_e_of_type_Int, false, 0, false);
      }
    }
  }
  
  private boolean f()
  {
    return (Gravity.isVertical(this.jdField_o_of_type_Int)) || (((this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) && ((this.jdField_o_of_type_Int == 0) || (!e())));
  }
  
  private void g()
  {
    this.jdField_i_of_type_Boolean = false;
    this.jdField_j_of_type_Boolean = false;
    VelocityTracker localVelocityTracker = this.jdField_a_of_type_AndroidViewVelocityTracker;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  float a(float paramFloat)
  {
    double d1 = paramFloat - 0.5F;
    Double.isNaN(d1);
    return (float)Math.sin((float)(d1 * 0.47123891676382D));
  }
  
  public int a()
  {
    return this.z;
  }
  
  public PagerAdapter a()
  {
    return this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter;
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
    localItemInfo.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.instantiateItem(this, paramInt1);
    localItemInfo.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getPageWidth(paramInt1);
    if ((paramInt2 >= 0) && (paramInt2 < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramInt2, localItemInfo);
      return localItemInfo;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(localItemInfo);
    return localItemInfo;
  }
  
  XViewPager.ItemInfo a(View paramView)
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      XViewPager.ItemInfo localItemInfo = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if (this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.isViewFromObject(paramView, localItemInfo.jdField_a_of_type_JavaLangObject)) {
        return localItemInfo;
      }
      i1 += 1;
    }
    return null;
  }
  
  public List<XViewPager.OnPageChangeListener> a()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return Collections.emptyList();
    }
    return Collections.unmodifiableList(localList);
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
    this.jdField_p_of_type_Int = ((int)(f1 * 16.0F));
    ViewCompat.setAccessibilityDelegate(this, new XViewPager.MyAccessibilityDelegate(this));
    if (ViewCompat.getImportantForAccessibility(this) == 0) {
      ViewCompat.setImportantForAccessibility(this, 1);
    }
  }
  
  void a(int paramInt)
  {
    int i1 = this.jdField_e_of_type_Int;
    int i4;
    if (i1 != paramInt)
    {
      if (i1 < paramInt) {
        i1 = 66;
      } else {
        i1 = 17;
      }
      localObject2 = a(this.jdField_e_of_type_Int);
      this.jdField_e_of_type_Int = paramInt;
      i4 = i1;
    }
    else
    {
      i4 = 2;
      localObject2 = null;
    }
    if (this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter == null)
    {
      e();
      return;
    }
    if (this.jdField_h_of_type_Boolean)
    {
      e();
      return;
    }
    if (getWindowToken() == null) {
      return;
    }
    this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.startUpdate(this);
    int i8 = this.jdField_n_of_type_Int;
    int i9 = Math.max(0, this.jdField_e_of_type_Int - i8);
    int i6 = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getCount();
    int i7 = Math.min(i6 - 1, this.jdField_e_of_type_Int + i8);
    if (i6 == this.jdField_d_of_type_Int)
    {
      int i2 = 0;
      while (i2 < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject1 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i2);
        if (((XViewPager.ItemInfo)localObject1).jdField_a_of_type_Int >= this.jdField_e_of_type_Int)
        {
          if (((XViewPager.ItemInfo)localObject1).jdField_a_of_type_Int != this.jdField_e_of_type_Int) {
            break;
          }
          break label218;
        }
        i2 += 1;
      }
      localObject1 = null;
      label218:
      Object localObject3 = localObject1;
      if (localObject1 == null)
      {
        localObject3 = localObject1;
        if (i6 > 0) {
          localObject3 = a(this.jdField_e_of_type_Int, i2);
        }
      }
      if (localObject3 != null)
      {
        int i3 = i2 - 1;
        if (i3 >= 0) {
          localObject1 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i3);
        } else {
          localObject1 = null;
        }
        int i10 = d();
        float f1;
        if (i10 <= 0) {
          f1 = 0.0F;
        } else {
          f1 = 2.0F - ((XViewPager.ItemInfo)localObject3).jdField_a_of_type_Float + getPaddingLeft() / i10;
        }
        float f3 = f1;
        if (i8 == 0) {
          f3 = 0.0F;
        }
        int i5 = this.jdField_e_of_type_Int - 1;
        float f2 = 0.0F;
        for (Object localObject4 = localObject1; i5 >= 0; localObject4 = localObject1)
        {
          if ((f2 >= f3) && (i5 < i9))
          {
            if (localObject4 == null) {
              break;
            }
            f1 = f2;
            i1 = i2;
            paramInt = i3;
            localObject1 = localObject4;
            if (i5 != localObject4.jdField_a_of_type_Int) {
              break label625;
            }
            f1 = f2;
            i1 = i2;
            paramInt = i3;
            localObject1 = localObject4;
            if (localObject4.jdField_a_of_type_Boolean) {
              break label625;
            }
            this.jdField_a_of_type_JavaUtilArrayList.remove(i3);
            this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.destroyItem(this, i5, localObject4.jdField_a_of_type_JavaLangObject);
            i3 -= 1;
            i2 -= 1;
            f1 = f2;
            i1 = i2;
            paramInt = i3;
            if (i3 >= 0)
            {
              localObject1 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i3);
              f1 = f2;
              i1 = i2;
              paramInt = i3;
              break label625;
            }
          }
          do
          {
            do
            {
              localObject1 = null;
              break label625;
              if ((localObject4 == null) || (i5 != localObject4.jdField_a_of_type_Int)) {
                break;
              }
              f2 += localObject4.jdField_a_of_type_Float;
              i3 -= 1;
              f1 = f2;
              i1 = i2;
              paramInt = i3;
            } while (i3 < 0);
            localObject1 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i3);
            f1 = f2;
            i1 = i2;
            paramInt = i3;
            break;
            f2 += a(i5, i3 + 1).jdField_a_of_type_Float;
            i2 += 1;
            f1 = f2;
            i1 = i2;
            paramInt = i3;
          } while (i3 < 0);
          localObject1 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i3);
          paramInt = i3;
          i1 = i2;
          f1 = f2;
          label625:
          i5 -= 1;
          f2 = f1;
          i2 = i1;
          i3 = paramInt;
        }
        f2 = ((XViewPager.ItemInfo)localObject3).jdField_a_of_type_Float;
        i1 = i2 + 1;
        if (f2 < 2.0F)
        {
          if (i1 < this.jdField_a_of_type_JavaUtilArrayList.size()) {
            localObject1 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
          } else {
            localObject1 = null;
          }
          if (i10 <= 0) {
            f1 = 0.0F;
          } else {
            f1 = getPaddingRight() / i10 + 2.0F;
          }
          f3 = f1;
          if (i8 == 0) {
            f3 = 0.0F;
          }
          i3 = this.jdField_e_of_type_Int;
          for (localObject4 = localObject1;; localObject4 = localObject1)
          {
            i3 += 1;
            if (i3 >= i6) {
              break;
            }
            if ((f2 >= f3) && (i3 > i7))
            {
              if (localObject4 == null) {
                break;
              }
              f1 = f2;
              paramInt = i1;
              localObject1 = localObject4;
              if (i3 != localObject4.jdField_a_of_type_Int) {
                break label1009;
              }
              f1 = f2;
              paramInt = i1;
              localObject1 = localObject4;
              if (localObject4.jdField_a_of_type_Boolean) {
                break label1009;
              }
              this.jdField_a_of_type_JavaUtilArrayList.remove(i1);
              this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.destroyItem(this, i3, localObject4.jdField_a_of_type_JavaLangObject);
              f1 = f2;
              paramInt = i1;
              if (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
              {
                localObject1 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
                f1 = f2;
                paramInt = i1;
                break label1009;
              }
            }
            do
            {
              do
              {
                localObject1 = null;
                break label1009;
                if ((localObject4 == null) || (i3 != localObject4.jdField_a_of_type_Int)) {
                  break;
                }
                f2 += localObject4.jdField_a_of_type_Float;
                i1 += 1;
                f1 = f2;
                paramInt = i1;
              } while (i1 >= this.jdField_a_of_type_JavaUtilArrayList.size());
              localObject1 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
              f1 = f2;
              paramInt = i1;
              break;
              localObject1 = a(i3, i1);
              i1 += 1;
              f2 += ((XViewPager.ItemInfo)localObject1).jdField_a_of_type_Float;
              f1 = f2;
              paramInt = i1;
            } while (i1 >= this.jdField_a_of_type_JavaUtilArrayList.size());
            localObject1 = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
            paramInt = i1;
            f1 = f2;
            label1009:
            f2 = f1;
            i1 = paramInt;
          }
        }
        if (f()) {
          b((XViewPager.ItemInfo)localObject3, i2, (XViewPager.ItemInfo)localObject2);
        } else {
          a((XViewPager.ItemInfo)localObject3, i2, (XViewPager.ItemInfo)localObject2);
        }
      }
      localObject2 = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter;
      paramInt = this.jdField_e_of_type_Int;
      if (localObject3 != null) {
        localObject1 = ((XViewPager.ItemInfo)localObject3).jdField_a_of_type_JavaLangObject;
      } else {
        localObject1 = null;
      }
      ((PagerAdapter)localObject2).setPrimaryItem(this, paramInt, localObject1);
      this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.finishUpdate(this);
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
      e();
      if (hasFocus())
      {
        localObject1 = findFocus();
        if (localObject1 != null) {
          localObject1 = b((View)localObject1);
        } else {
          localObject1 = null;
        }
        if ((localObject1 == null) || (((XViewPager.ItemInfo)localObject1).jdField_a_of_type_Int != this.jdField_e_of_type_Int))
        {
          paramInt = 0;
          while (paramInt < getChildCount())
          {
            localObject1 = getChildAt(paramInt);
            localObject2 = a((View)localObject1);
            if ((localObject2 != null) && (((XViewPager.ItemInfo)localObject2).jdField_a_of_type_Int == this.jdField_e_of_type_Int) && (((View)localObject1).requestFocus(i4))) {
              return;
            }
            paramInt += 1;
          }
        }
      }
      return;
    }
    try
    {
      localObject1 = getResources().getResourceName(getId());
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label1325:
      break label1325;
    }
    Object localObject1 = Integer.toHexString(getId());
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ");
    ((StringBuilder)localObject2).append(this.jdField_d_of_type_Int);
    ((StringBuilder)localObject2).append(", found: ");
    ((StringBuilder)localObject2).append(i6);
    ((StringBuilder)localObject2).append(" Pager id: ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" Pager class: ");
    ((StringBuilder)localObject2).append(getClass());
    ((StringBuilder)localObject2).append(" Problematic adapter: ");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getClass());
    localObject1 = new IllegalStateException(((StringBuilder)localObject2).toString());
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  protected void a(int paramInt1, float paramFloat, int paramInt2)
  {
    int i1 = this.w;
    int i6 = 0;
    int i2;
    if (i1 > 0)
    {
      int i7 = getScrollX();
      i1 = getPaddingLeft();
      i2 = getPaddingRight();
      int i8 = getWidth();
      int i9 = getChildCount();
      int i4 = 0;
      while (i4 < i9)
      {
        localObject = getChildAt(i4);
        XViewPager.LayoutParams localLayoutParams = (XViewPager.LayoutParams)((View)localObject).getLayoutParams();
        if (localLayoutParams.jdField_a_of_type_Boolean)
        {
          int i3 = localLayoutParams.jdField_a_of_type_Int & 0x7;
          if (i3 != 1)
          {
            int i5;
            if (i3 != 3)
            {
              if (i3 != 5)
              {
                i5 = i1;
                i3 = i1;
                i1 = i5;
              }
              else
              {
                i3 = i8 - i2 - ((View)localObject).getMeasuredWidth();
                i2 += ((View)localObject).getMeasuredWidth();
              }
            }
            else
            {
              i5 = ((View)localObject).getWidth() + i1;
              i3 = i1;
              i1 = i5;
            }
          }
          else
          {
            i3 = Math.max((i8 - ((View)localObject).getMeasuredWidth()) / 2, i1);
          }
          i3 = i3 + i7 - ((View)localObject).getLeft();
          if (i3 != 0) {
            ((View)localObject).offsetLeftAndRight(i3);
          }
        }
        i4 += 1;
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener;
    if (localObject != null) {
      ((XViewPager.OnPageChangeListener)localObject).a(paramInt1, paramFloat, paramInt2);
    }
    localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      i2 = ((List)localObject).size();
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
    localObject = this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener;
    if (localObject != null) {
      ((XViewPager.OnPageChangeListener)localObject).a(paramInt1, paramFloat, paramInt2);
    }
    if (this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$PageTransformer != null)
    {
      paramInt2 = getScrollX();
      i1 = getChildCount();
      paramInt1 = i6;
      while (paramInt1 < i1)
      {
        localObject = getChildAt(paramInt1);
        if (!((XViewPager.LayoutParams)((View)localObject).getLayoutParams()).jdField_a_of_type_Boolean)
        {
          paramFloat = (((View)localObject).getLeft() - paramInt2) / d();
          this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$PageTransformer.a((View)localObject, paramFloat);
        }
        paramInt1 += 1;
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
    float f2 = Math.abs(i3);
    float f1 = paramInt1;
    float f5 = Math.min(1.0F, f2 * 1.0F / f1);
    float f3 = Math.abs(paramInt2);
    f2 = i4;
    float f4 = Math.min(1.0F, f3 * 1.0F / f2);
    f3 = i5;
    f5 = a(f5);
    float f6 = i6;
    f4 = a(f4);
    paramInt1 = Math.abs(paramInt3);
    if (paramInt1 > 0)
    {
      if (f()) {
        paramInt1 = Math.round(Math.abs((f6 + f4 * f6) / paramInt1) * 1000.0F);
      } else {
        paramInt1 = Math.round(Math.abs((f3 + f5 * f3) / paramInt1) * 1000.0F);
      }
      paramInt1 *= 4;
    }
    else if (f())
    {
      f1 = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getPageWidth(this.jdField_e_of_type_Int);
      paramInt1 = (int)((Math.abs(paramInt2) / (f2 * f1 + this.jdField_g_of_type_Int) + 1.0F) * 100.0F);
    }
    else
    {
      f2 = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getPageWidth(this.jdField_e_of_type_Int);
      paramInt1 = (int)((Math.abs(i3) / (f1 * f2 + this.jdField_g_of_type_Int) + 1.0F) * 100.0F);
    }
    paramInt1 = Math.min(paramInt1, 600);
    paramInt3 = this.jdField_c_of_type_Int;
    if ((paramInt3 != 2) && (paramInt3 != 3))
    {
      paramInt3 = this.jdField_b_of_type_Int;
      if (paramInt3 > 0) {
        this.jdField_a_of_type_AndroidWidgetScroller.startScroll(i1, i2, i3, paramInt2, paramInt3);
      } else {
        this.jdField_a_of_type_AndroidWidgetScroller.startScroll(i1, i2, i3, paramInt2, paramInt1);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(i1, i2, i3, paramInt2, paramInt1 / this.jdField_c_of_type_Int);
    }
    ViewCompat.postInvalidateOnAnimation(this);
  }
  
  void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt, paramBoolean1, paramBoolean2, 0);
  }
  
  void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter;
    int i2 = 0;
    if ((localObject != null) && (((PagerAdapter)localObject).getCount() > 0))
    {
      if ((!paramBoolean2) && (this.jdField_e_of_type_Int == paramInt1) && (this.jdField_a_of_type_JavaUtilArrayList.size() != 0))
      {
        e(false);
        return;
      }
      int i1 = this.jdField_e_of_type_Int;
      paramBoolean2 = true;
      if (paramInt1 < 0)
      {
        i1 = 0;
      }
      else
      {
        i1 = paramInt1;
        if (paramInt1 >= this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getCount()) {
          i1 = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getCount() - 1;
        }
      }
      paramInt1 = this.jdField_n_of_type_Int;
      int i3 = this.jdField_e_of_type_Int;
      if ((i1 > i3 + paramInt1) || (i1 < i3 - paramInt1))
      {
        paramInt1 = 0;
        while (paramInt1 < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          ((XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1)).jdField_a_of_type_Boolean = true;
          paramInt1 += 1;
        }
      }
      if (this.jdField_e_of_type_Int == i1) {
        paramBoolean2 = false;
      }
      if (this.jdField_l_of_type_Boolean)
      {
        this.jdField_e_of_type_Int = i1;
        if (paramBoolean2)
        {
          localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener;
          if (localObject != null) {
            ((XViewPager.OnPageChangeListener)localObject).a(i1);
          }
        }
        if (paramBoolean2)
        {
          localObject = this.jdField_a_of_type_JavaUtilList;
          if (localObject != null)
          {
            paramInt2 = ((List)localObject).size();
            paramInt1 = i2;
            while (paramInt1 < paramInt2)
            {
              localObject = (XViewPager.OnPageChangeListener)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
              if (localObject != null) {
                ((XViewPager.OnPageChangeListener)localObject).a(i1);
              }
              paramInt1 += 1;
            }
          }
        }
        if (paramBoolean2)
        {
          localObject = this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener;
          if (localObject != null) {
            ((XViewPager.OnPageChangeListener)localObject).a(i1);
          }
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
      return;
    }
    e(false);
  }
  
  protected void a(Canvas paramCanvas)
  {
    if ((this.jdField_g_of_type_Int > 0) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter != null))
    {
      int i3 = getScrollY();
      int i4 = getHeight();
      float f1 = this.jdField_g_of_type_Int;
      float f5 = i4;
      float f2 = f1 / f5;
      Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
      int i2 = 0;
      localObject = (XViewPager.ItemInfo)((ArrayList)localObject).get(0);
      f1 = ((XViewPager.ItemInfo)localObject).jdField_b_of_type_Float;
      int i5 = this.jdField_a_of_type_JavaUtilArrayList.size();
      int i1 = ((XViewPager.ItemInfo)localObject).jdField_a_of_type_Int;
      int i6 = ((XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i5 - 1)).jdField_a_of_type_Int;
      while (i1 < i6)
      {
        while ((i1 > ((XViewPager.ItemInfo)localObject).jdField_a_of_type_Int) && (i2 < i5))
        {
          localObject = this.jdField_a_of_type_JavaUtilArrayList;
          i2 += 1;
          localObject = (XViewPager.ItemInfo)((ArrayList)localObject).get(i2);
        }
        float f3;
        if (i1 == ((XViewPager.ItemInfo)localObject).jdField_a_of_type_Int)
        {
          f3 = (((XViewPager.ItemInfo)localObject).jdField_b_of_type_Float + ((XViewPager.ItemInfo)localObject).jdField_a_of_type_Float) * f5;
          f1 = ((XViewPager.ItemInfo)localObject).jdField_b_of_type_Float + ((XViewPager.ItemInfo)localObject).jdField_a_of_type_Float + f2;
        }
        else
        {
          float f4 = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getPageWidth(i1);
          f3 = f1 + (f4 + f2);
          f4 = (f1 + f4) * f5;
          f1 = f3;
          f3 = f4;
        }
        int i7 = this.jdField_g_of_type_Int;
        if (i7 + f3 > i3)
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.jdField_j_of_type_Int, (int)f3, this.jdField_k_of_type_Int, (int)(i7 + f3 + 0.5F));
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        }
        if (f3 > i3 + i4) {
          return;
        }
        i1 += 1;
      }
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
    if (Build.VERSION.SDK_INT >= 7)
    {
      if (this.jdField_a_of_type_JavaLangReflectMethod == null) {
        try
        {
          this.jdField_a_of_type_JavaLangReflectMethod = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[] { Boolean.TYPE });
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          SLog.c(this.jdField_a_of_type_JavaLangString, "Can't find setChildrenDrawingOrderEnabled", localNoSuchMethodException);
        }
      }
      try
      {
        this.jdField_a_of_type_JavaLangReflectMethod.invoke(this, new Object[] { Boolean.valueOf(paramBoolean) });
        return;
      }
      catch (Exception localException)
      {
        SLog.c(this.jdField_a_of_type_JavaLangString, "Error changing children drawing order", localException);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i8 = getChildCount();
    int i9 = paramInt3 - paramInt1;
    int i10 = paramInt4 - paramInt2;
    paramInt2 = getPaddingLeft();
    paramInt1 = getPaddingTop();
    int i1 = getPaddingRight();
    paramInt4 = getPaddingBottom();
    int i11 = getScrollY();
    int i3 = 0;
    int i4 = 0;
    View localView;
    int i5;
    XViewPager.LayoutParams localLayoutParams;
    while (i4 < i8)
    {
      localView = getChildAt(i4);
      i2 = paramInt2;
      int i7 = i1;
      int i6 = paramInt1;
      i5 = paramInt4;
      paramInt3 = i3;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (XViewPager.LayoutParams)localView.getLayoutParams();
        i2 = paramInt2;
        i7 = i1;
        i6 = paramInt1;
        i5 = paramInt4;
        paramInt3 = i3;
        if (localLayoutParams.jdField_a_of_type_Boolean)
        {
          paramInt3 = localLayoutParams.jdField_a_of_type_Int & 0x7;
          i5 = localLayoutParams.jdField_a_of_type_Int & 0x70;
          if (paramInt3 != 1)
          {
            if (paramInt3 != 3)
            {
              if (paramInt3 != 5)
              {
                paramInt3 = paramInt2;
                i2 = paramInt2;
              }
              else
              {
                paramInt3 = i9 - i1 - localView.getMeasuredWidth();
                i1 += localView.getMeasuredWidth();
                i2 = paramInt2;
              }
            }
            else
            {
              i2 = localView.getMeasuredWidth();
              paramInt3 = paramInt2;
              i2 += paramInt2;
            }
          }
          else
          {
            paramInt3 = Math.max((i9 - localView.getMeasuredWidth()) / 2, paramInt2);
            i2 = paramInt2;
          }
          if (i5 != 16)
          {
            if (i5 != 48)
            {
              if (i5 != 80)
              {
                paramInt2 = paramInt1;
              }
              else
              {
                paramInt2 = i10 - paramInt4 - localView.getMeasuredHeight();
                paramInt4 += localView.getMeasuredHeight();
              }
            }
            else
            {
              i5 = localView.getMeasuredHeight();
              paramInt2 = paramInt1;
              paramInt1 = i5 + paramInt1;
            }
          }
          else {
            paramInt2 = Math.max((i10 - localView.getMeasuredHeight()) / 2, paramInt1);
          }
          paramInt2 += i11;
          localView.layout(paramInt3, paramInt2, localView.getMeasuredWidth() + paramInt3, paramInt2 + localView.getMeasuredHeight());
          paramInt3 = i3 + 1;
          i5 = paramInt4;
          i6 = paramInt1;
          i7 = i1;
        }
      }
      i4 += 1;
      paramInt2 = i2;
      i1 = i7;
      paramInt1 = i6;
      paramInt4 = i5;
      i3 = paramInt3;
    }
    int i2 = i10 - paramInt1 - paramInt4;
    i4 = 0;
    paramInt3 = i8;
    while (i4 < paramInt3)
    {
      localView = getChildAt(i4);
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (XViewPager.LayoutParams)localView.getLayoutParams();
        if (!localLayoutParams.jdField_a_of_type_Boolean)
        {
          XViewPager.ItemInfo localItemInfo = a(localView);
          if (localItemInfo != null)
          {
            float f1 = i2;
            i5 = (int)(localItemInfo.jdField_b_of_type_Float * f1) + paramInt1;
            if (localLayoutParams.jdField_b_of_type_Boolean)
            {
              localLayoutParams.jdField_b_of_type_Boolean = false;
              localView.measure(View.MeasureSpec.makeMeasureSpec(i9 - paramInt2 - i1, 1073741824), View.MeasureSpec.makeMeasureSpec((int)(f1 * localLayoutParams.jdField_a_of_type_Float), 1073741824));
            }
            localView.layout(paramInt2, i5, localView.getMeasuredWidth() + paramInt2, localView.getMeasuredHeight() + i5);
          }
        }
      }
      i4 += 1;
    }
    this.jdField_h_of_type_Int = paramInt1;
    this.jdField_j_of_type_Int = paramInt2;
    this.jdField_i_of_type_Int = (i10 - paramInt4);
    this.jdField_k_of_type_Int = (i9 - i1);
    this.w = i3;
    if ((!this.jdField_l_of_type_Boolean) && (this.jdField_m_of_type_Boolean)) {
      break label640;
    }
    b(this.jdField_e_of_type_Int, false, 0, false);
    label640:
    this.jdField_l_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = true;
  }
  
  boolean a()
  {
    int i1 = this.jdField_e_of_type_Int;
    if (i1 > 0)
    {
      setCurrentItem(i1 - 1, true);
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt)
  {
    Object localObject2 = findFocus();
    boolean bool = false;
    View localView = null;
    Object localObject1;
    int i1;
    if (localObject2 == this)
    {
      localObject1 = localView;
    }
    else
    {
      if (localObject2 != null)
      {
        for (localObject1 = ((View)localObject2).getParent(); (localObject1 instanceof ViewGroup); localObject1 = ((ViewParent)localObject1).getParent()) {
          if (localObject1 == this)
          {
            i1 = 1;
            break label70;
          }
        }
        i1 = 0;
        label70:
        if (i1 == 0)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localObject2.getClass().getSimpleName());
          for (localObject1 = ((View)localObject2).getParent(); (localObject1 instanceof ViewGroup); localObject1 = ((ViewParent)localObject1).getParent())
          {
            localStringBuilder.append(" => ");
            localStringBuilder.append(localObject1.getClass().getSimpleName());
          }
          localObject1 = this.jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("arrowScroll tried to find focus based on non-child current focused view ");
          ((StringBuilder)localObject2).append(localStringBuilder.toString());
          SLog.e((String)localObject1, ((StringBuilder)localObject2).toString());
          localObject1 = localView;
          break label203;
        }
      }
      localObject1 = localObject2;
    }
    label203:
    localView = FocusFinder.getInstance().findNextFocus(this, (View)localObject1, paramInt);
    int i2;
    if ((localView != null) && (localView != localObject1)) {
      if (paramInt == 17)
      {
        i1 = a(this.jdField_a_of_type_AndroidGraphicsRect, localView).left;
        i2 = a(this.jdField_a_of_type_AndroidGraphicsRect, (View)localObject1).left;
        if ((localObject1 != null) && (i1 >= i2)) {
          bool = a();
        } else {
          bool = localView.requestFocus();
        }
      }
    }
    for (;;)
    {
      break;
      if (paramInt == 66)
      {
        i1 = a(this.jdField_a_of_type_AndroidGraphicsRect, localView).left;
        i2 = a(this.jdField_a_of_type_AndroidGraphicsRect, (View)localObject1).left;
        if ((localObject1 != null) && (i1 <= i2))
        {
          bool = b();
        }
        else
        {
          bool = localView.requestFocus();
          continue;
          if ((paramInt != 17) && (paramInt != 1))
          {
            if ((paramInt == 66) || (paramInt == 2)) {
              bool = b();
            }
          }
          else {
            bool = a();
          }
        }
      }
    }
    if (bool) {
      playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
    }
    return bool;
  }
  
  public boolean a(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 0)
    {
      int i1 = paramKeyEvent.getKeyCode();
      if (i1 != 61)
      {
        switch (i1)
        {
        default: 
          break;
        case 22: 
          return a(66);
        case 21: 
          return a(17);
        case 20: 
          return a(130);
        case 19: 
          return a(33);
        }
      }
      else if (Build.VERSION.SDK_INT >= 11)
      {
        if (KeyEventCompat.hasNoModifiers(paramKeyEvent)) {
          return a(2);
        }
        if (KeyEventCompat.hasModifiers(paramKeyEvent, 1)) {
          return a(1);
        }
      }
    }
    return false;
  }
  
  protected boolean a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i2 = paramView.getScrollX();
      int i3 = paramView.getScrollY();
      int i1 = localViewGroup.getChildCount() - 1;
      while (i1 >= 0)
      {
        View localView = localViewGroup.getChildAt(i1);
        int i4 = paramInt2 + i2;
        if ((i4 >= localView.getLeft()) && (i4 < localView.getRight()))
        {
          int i5 = paramInt3 + i3;
          if ((i5 >= localView.getTop()) && (i5 < localView.getBottom()) && (a(localView, true, paramInt1, i4 - localView.getLeft(), i5 - localView.getTop()))) {
            return true;
          }
        }
        i1 -= 1;
      }
    }
    return (paramBoolean) && (ViewCompat.canScrollHorizontally(paramView, -paramInt1));
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    if (paramArrayList == null) {
      return;
    }
    int i2 = paramArrayList.size();
    int i3 = getDescendantFocusability();
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
    if ((i3 != 262144) || (i2 == paramArrayList.size()))
    {
      if (!isFocusable()) {
        return;
      }
      if (((paramInt2 & 0x1) == 1) && (isInTouchMode()) && (!isFocusableInTouchMode())) {
        return;
      }
      paramArrayList.add(this);
    }
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
    ViewGroup.LayoutParams localLayoutParams = paramLayoutParams;
    if (!checkLayoutParams(paramLayoutParams)) {
      localLayoutParams = generateLayoutParams(paramLayoutParams);
    }
    paramLayoutParams = (XViewPager.LayoutParams)localLayoutParams;
    paramLayoutParams.jdField_a_of_type_Boolean |= paramView instanceof XViewPager.Decor;
    if (this.jdField_f_of_type_Boolean)
    {
      if (!paramLayoutParams.jdField_a_of_type_Boolean)
      {
        paramLayoutParams.jdField_b_of_type_Boolean = true;
        addViewInLayout(paramView, paramInt, localLayoutParams);
        return;
      }
      throw new IllegalStateException("Cannot add pager decor view during layout");
    }
    super.addView(paramView, paramInt, localLayoutParams);
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
        break label34;
      }
      if ((localViewParent == null) || (!(localViewParent instanceof View))) {
        break;
      }
      paramView = (View)localViewParent;
    }
    return null;
    label34:
    return a(paramView);
  }
  
  void b()
  {
    int i9 = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getCount();
    this.jdField_d_of_type_Int = i9;
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() < this.jdField_n_of_type_Int * 2 + 1) && (this.jdField_a_of_type_JavaUtilArrayList.size() < i9)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2 = this.jdField_e_of_type_Int;
    int i6 = i1;
    int i1 = i2;
    int i3 = 0;
    i2 = 0;
    Object localObject;
    while (i3 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i3);
      int i8 = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getItemPosition(((XViewPager.ItemInfo)localObject).jdField_a_of_type_JavaLangObject);
      int i4;
      int i5;
      int i7;
      if (i8 == -1)
      {
        i4 = i3;
        i5 = i2;
        i7 = i1;
      }
      else
      {
        if (i8 == -2)
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(i3);
          i5 = i3 - 1;
          i4 = i2;
          if (i2 == 0)
          {
            this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.startUpdate(this);
            i4 = 1;
          }
          this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.destroyItem(this, ((XViewPager.ItemInfo)localObject).jdField_a_of_type_Int, ((XViewPager.ItemInfo)localObject).jdField_a_of_type_JavaLangObject);
          i3 = i5;
          i2 = i4;
          if (this.jdField_e_of_type_Int == ((XViewPager.ItemInfo)localObject).jdField_a_of_type_Int)
          {
            i1 = Math.max(0, Math.min(this.jdField_e_of_type_Int, i9 - 1));
            i2 = i4;
            i3 = i5;
          }
        }
        for (;;)
        {
          i6 = 1;
          i4 = i3;
          i5 = i2;
          i7 = i1;
          break;
          i4 = i3;
          i5 = i2;
          i7 = i1;
          if (((XViewPager.ItemInfo)localObject).jdField_a_of_type_Int == i8) {
            break;
          }
          if (((XViewPager.ItemInfo)localObject).jdField_a_of_type_Int == this.jdField_e_of_type_Int) {
            i1 = i8;
          }
          ((XViewPager.ItemInfo)localObject).jdField_a_of_type_Int = i8;
        }
      }
      i3 = i4 + 1;
      i2 = i5;
      i1 = i7;
    }
    if (i2 != 0) {
      this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.finishUpdate(this);
    }
    Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, jdField_a_of_type_JavaUtilComparator);
    if (i6 != 0)
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
  }
  
  protected void b(int paramInt1, float paramFloat, int paramInt2)
  {
    int i1 = this.w;
    int i6 = 0;
    int i2;
    if (i1 > 0)
    {
      int i7 = getScrollY();
      i1 = getPaddingTop();
      i2 = getPaddingBottom();
      int i8 = getHeight();
      int i9 = getChildCount();
      int i4 = 0;
      while (i4 < i9)
      {
        localObject = getChildAt(i4);
        XViewPager.LayoutParams localLayoutParams = (XViewPager.LayoutParams)((View)localObject).getLayoutParams();
        if (localLayoutParams.jdField_a_of_type_Boolean)
        {
          int i3 = localLayoutParams.jdField_a_of_type_Int & 0x70;
          if (i3 != 16)
          {
            int i5;
            if (i3 != 48)
            {
              if (i3 != 80)
              {
                i5 = i1;
                i3 = i1;
                i1 = i5;
              }
              else
              {
                i3 = i8 - i2 - ((View)localObject).getMeasuredHeight();
                i2 += ((View)localObject).getMeasuredHeight();
              }
            }
            else
            {
              i5 = ((View)localObject).getHeight() + i1;
              i3 = i1;
              i1 = i5;
            }
          }
          else
          {
            i3 = Math.max((i8 - ((View)localObject).getMeasuredHeight()) / 2, i1);
          }
          i3 = i3 + i7 - ((View)localObject).getTop();
          if (i3 != 0) {
            ((View)localObject).offsetTopAndBottom(i3);
          }
        }
        i4 += 1;
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener;
    if (localObject != null) {
      ((XViewPager.OnPageChangeListener)localObject).a(paramInt1, paramFloat, paramInt2);
    }
    localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      i2 = ((List)localObject).size();
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
    localObject = this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnPageChangeListener;
    if (localObject != null) {
      ((XViewPager.OnPageChangeListener)localObject).a(paramInt1, paramFloat, paramInt2);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$PageTransformer != null)
    {
      paramInt2 = getScrollY();
      i1 = getChildCount();
      paramInt1 = i6;
      while (paramInt1 < i1)
      {
        localObject = getChildAt(paramInt1);
        if (!((XViewPager.LayoutParams)((View)localObject).getLayoutParams()).jdField_a_of_type_Boolean)
        {
          paramFloat = (((View)localObject).getTop() - paramInt2) / e();
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$PageTransformer.a((View)localObject, paramFloat);
        }
        paramInt1 += 1;
      }
    }
    this.jdField_o_of_type_Boolean = true;
  }
  
  boolean b()
  {
    PagerAdapter localPagerAdapter = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter;
    if ((localPagerAdapter != null) && (this.jdField_e_of_type_Int < localPagerAdapter.getCount() - 1))
    {
      setCurrentItem(this.jdField_e_of_type_Int + 1, true);
      return true;
    }
    return false;
  }
  
  protected boolean b(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i2 = paramView.getScrollX();
      int i3 = paramView.getScrollY();
      int i1 = localViewGroup.getChildCount() - 1;
      while (i1 >= 0)
      {
        View localView = localViewGroup.getChildAt(i1);
        int i4 = paramInt2 + i2;
        if ((i4 >= localView.getLeft()) && (i4 < localView.getRight()))
        {
          int i5 = paramInt3 + i3;
          if ((i5 >= localView.getTop()) && (i5 < localView.getBottom()) && (b(localView, true, paramInt1, i4 - localView.getLeft(), i5 - localView.getTop()))) {
            return true;
          }
        }
        i1 -= 1;
      }
    }
    return (paramBoolean) && (ViewCompat.canScrollVertically(paramView, -paramInt1));
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
    PagerAdapter localPagerAdapter = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter;
    boolean bool3 = false;
    boolean bool2 = false;
    if (localPagerAdapter == null) {
      return false;
    }
    boolean bool1 = bool3;
    if (c())
    {
      int i1 = d();
      int i2 = getScrollX();
      if (paramInt < 0)
      {
        bool1 = bool2;
        if (i2 > (int)(i1 * this.jdField_b_of_type_Float)) {
          bool1 = true;
        }
        return bool1;
      }
      bool1 = bool3;
      if (paramInt > 0)
      {
        bool1 = bool3;
        if (i2 < (int)(i1 * this.jdField_c_of_type_Float)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
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
        if (Gravity.isHorizontal(this.jdField_o_of_type_Int))
        {
          if (!b(i3))
          {
            this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
            scrollTo(0, i4);
          }
        }
        else if (!c(i4))
        {
          this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
          scrollTo(i3, 0);
        }
      }
      ViewCompat.postInvalidateOnAnimation(this);
      return;
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
    if (paramAccessibilityEvent.getEventType() == 4096) {
      return super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    }
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
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
    return false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i4 = ViewCompat.getOverScrollMode(this);
    int i3 = 0;
    int i1 = 0;
    if (i4 != 0) {
      if (i4 == 1)
      {
        PagerAdapter localPagerAdapter = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter;
        if ((localPagerAdapter != null) && (localPagerAdapter.getCount() > 1)) {}
      }
      else
      {
        this.jdField_a_of_type_AndroidSupportV4WidgetEdgeEffectCompat.finish();
        this.jdField_b_of_type_AndroidSupportV4WidgetEdgeEffectCompat.finish();
        this.jdField_c_of_type_AndroidSupportV4WidgetEdgeEffectCompat.finish();
        this.jdField_d_of_type_AndroidSupportV4WidgetEdgeEffectCompat.finish();
        break label290;
      }
    }
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
    boolean bool;
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
    if (this.jdField_c_of_type_AndroidSupportV4WidgetEdgeEffectCompat.isFinished())
    {
      if (this.jdField_b_of_type_AndroidSupportV4WidgetEdgeEffectCompat.isFinished())
      {
        label290:
        if (bool) {
          ViewCompat.postInvalidateOnAnimation(this);
        }
        return;
      }
      throw new RuntimeException("do not support (OVER_SCROLL_ALWAYS, OVER_SCROLL_IF_CONTENT_SCROLLS)");
    }
    throw new RuntimeException("do not support (OVER_SCROLL_ALWAYS, OVER_SCROLL_IF_CONTENT_SCROLLS)");
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new XViewPager.LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new XViewPager.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return generateDefaultLayoutParams();
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      localArrayList = this.jdField_b_of_type_JavaUtilArrayList;
      if ((localArrayList == null) || (localArrayList.size() != getChildCount())) {
        e();
      }
    }
    int i1;
    if (this.x == 2) {
      i1 = paramInt1 - 1 - paramInt2;
    } else {
      i1 = paramInt2;
    }
    ArrayList localArrayList = this.jdField_b_of_type_JavaUtilArrayList;
    if (localArrayList != null) {
      return ((XViewPager.LayoutParams)((View)localArrayList.get(i1)).getLayoutParams()).jdField_c_of_type_Int;
    }
    return super.getChildDrawingOrder(paramInt1, paramInt2);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_l_of_type_Boolean = true;
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (f())
    {
      a(paramCanvas);
      return;
    }
    if ((this.jdField_g_of_type_Int > 0) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter != null))
    {
      int i3 = getScrollX();
      int i4 = getWidth();
      float f1 = this.jdField_g_of_type_Int;
      float f5 = i4;
      float f2 = f1 / f5;
      Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
      int i2 = 0;
      localObject = (XViewPager.ItemInfo)((ArrayList)localObject).get(0);
      f1 = ((XViewPager.ItemInfo)localObject).jdField_b_of_type_Float;
      int i5 = this.jdField_a_of_type_JavaUtilArrayList.size();
      int i1 = ((XViewPager.ItemInfo)localObject).jdField_a_of_type_Int;
      int i6 = ((XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i5 - 1)).jdField_a_of_type_Int;
      while (i1 < i6)
      {
        while ((i1 > ((XViewPager.ItemInfo)localObject).jdField_a_of_type_Int) && (i2 < i5))
        {
          localObject = this.jdField_a_of_type_JavaUtilArrayList;
          i2 += 1;
          localObject = (XViewPager.ItemInfo)((ArrayList)localObject).get(i2);
        }
        float f3;
        if (i1 == ((XViewPager.ItemInfo)localObject).jdField_a_of_type_Int)
        {
          f3 = (((XViewPager.ItemInfo)localObject).jdField_b_of_type_Float + ((XViewPager.ItemInfo)localObject).jdField_a_of_type_Float) * f5;
          f1 = ((XViewPager.ItemInfo)localObject).jdField_b_of_type_Float + ((XViewPager.ItemInfo)localObject).jdField_a_of_type_Float + f2;
        }
        else
        {
          float f4 = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getPageWidth(i1);
          f3 = f1 + (f4 + f2);
          f4 = (f1 + f4) * f5;
          f1 = f3;
          f3 = f4;
        }
        int i7 = this.jdField_g_of_type_Int;
        if (i7 + f3 > i3)
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds((int)f3, this.jdField_h_of_type_Int, (int)(i7 + f3 + 0.5F), this.jdField_i_of_type_Int);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        }
        if (f3 > i3 + i4) {
          return;
        }
        i1 += 1;
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i2 = paramMotionEvent.getAction() & 0xFF;
    int i1 = 3;
    if ((i2 != 3) && (i2 != 1))
    {
      if (i2 != 0)
      {
        if (this.jdField_i_of_type_Boolean) {
          return true;
        }
        if (this.jdField_j_of_type_Boolean) {
          return false;
        }
      }
      float f1;
      if (i2 != 0)
      {
        if (i2 != 2)
        {
          if (i2 == 6) {
            a(paramMotionEvent);
          }
        }
        else
        {
          i2 = this.r;
          if (i2 != -1)
          {
            i2 = MotionEventCompat.findPointerIndex(paramMotionEvent, i2);
            float f2 = MotionEventCompat.getX(paramMotionEvent, i2);
            f1 = f2 - this.jdField_d_of_type_Float;
            float f4 = Math.abs(f1);
            float f3 = MotionEventCompat.getY(paramMotionEvent, i2);
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
            if (((d()) || ((this.jdField_a_of_type_Boolean) && (f5 < 0.0F)) || ((this.jdField_b_of_type_Boolean) && (f5 > 0.0F))) && (!Gravity.isHorizontal(this.jdField_o_of_type_Int)) && (f6 > this.jdField_a_of_type_Int) && (f6 * 0.6F > f4))
            {
              this.jdField_i_of_type_Boolean = true;
              if (f5 > 0.0F) {
                i1 = 80;
              } else {
                i1 = 48;
              }
              this.jdField_o_of_type_Int = i1;
              d(true);
              b(1);
              this.jdField_d_of_type_Float = f2;
              if (f5 > 0.0F) {
                f1 = this.jdField_g_of_type_Float + this.jdField_a_of_type_Int;
              } else {
                f1 = this.jdField_g_of_type_Float - this.jdField_a_of_type_Int;
              }
              this.jdField_e_of_type_Float = f1;
              e(true);
            }
            else if (((c()) || ((this.jdField_c_of_type_Boolean) && (f1 < 0.0F)) || ((this.jdField_d_of_type_Boolean) && (f1 > 0.0F))) && (!Gravity.isVertical(this.jdField_o_of_type_Int)) && (f4 > this.jdField_a_of_type_Int) && (0.6F * f4 > f6))
            {
              this.jdField_i_of_type_Boolean = true;
              if (f1 > 0.0F) {
                i1 = 5;
              }
              this.jdField_o_of_type_Int = i1;
              d(true);
              b(1);
              if (f1 > 0.0F) {
                f1 = this.jdField_f_of_type_Float + this.jdField_a_of_type_Int;
              } else {
                f1 = this.jdField_f_of_type_Float - this.jdField_a_of_type_Int;
              }
              this.jdField_d_of_type_Float = f1;
              this.jdField_e_of_type_Float = f3;
              e(true);
            }
            else if (((!d()) || ((this.jdField_a_of_type_Boolean) && (f5 > 0.0F)) || ((this.jdField_b_of_type_Boolean) && (f5 < 0.0F))) && (f6 > this.jdField_a_of_type_Int))
            {
              this.jdField_j_of_type_Boolean = true;
            }
            else if (((!c()) || ((this.jdField_c_of_type_Boolean) && (f1 > 0.0F)) || ((this.jdField_d_of_type_Boolean) && (f1 < 0.0F))) && (f4 > this.jdField_a_of_type_Int))
            {
              this.jdField_j_of_type_Boolean = true;
            }
            if (this.jdField_i_of_type_Boolean) {
              if (Gravity.isHorizontal(this.jdField_o_of_type_Int))
              {
                if (a(f2)) {
                  ViewCompat.postInvalidateOnAnimation(this);
                }
              }
              else if (b(f3)) {
                ViewCompat.postInvalidateOnAnimation(this);
              }
            }
          }
        }
      }
      else
      {
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
        }
      }
      if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
        this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
      }
      this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
      return this.jdField_i_of_type_Boolean;
    }
    this.jdField_i_of_type_Boolean = false;
    this.jdField_j_of_type_Boolean = false;
    this.r = -1;
    paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
    if (paramMotionEvent != null)
    {
      paramMotionEvent.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (f())
    {
      a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    int i8 = getChildCount();
    int i9 = paramInt3 - paramInt1;
    int i10 = paramInt4 - paramInt2;
    paramInt2 = getPaddingLeft();
    paramInt1 = getPaddingTop();
    int i2 = getPaddingRight();
    paramInt4 = getPaddingBottom();
    int i11 = getScrollX();
    int i3 = 0;
    int i4 = 0;
    View localView;
    int i1;
    XViewPager.LayoutParams localLayoutParams;
    while (i4 < i8)
    {
      localView = getChildAt(i4);
      i1 = paramInt2;
      int i7 = i2;
      int i6 = paramInt1;
      int i5 = paramInt4;
      paramInt3 = i3;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (XViewPager.LayoutParams)localView.getLayoutParams();
        i1 = paramInt2;
        i7 = i2;
        i6 = paramInt1;
        i5 = paramInt4;
        paramInt3 = i3;
        if (localLayoutParams.jdField_a_of_type_Boolean)
        {
          paramInt3 = localLayoutParams.jdField_a_of_type_Int & 0x7;
          i5 = localLayoutParams.jdField_a_of_type_Int & 0x70;
          if (paramInt3 != 1)
          {
            if (paramInt3 != 3)
            {
              if (paramInt3 != 5)
              {
                paramInt3 = paramInt2;
                i1 = paramInt2;
              }
              else
              {
                paramInt3 = i9 - i2 - localView.getMeasuredWidth();
                i2 += localView.getMeasuredWidth();
                i1 = paramInt2;
              }
            }
            else
            {
              i1 = localView.getMeasuredWidth();
              paramInt3 = paramInt2;
              i1 += paramInt2;
            }
          }
          else
          {
            paramInt3 = Math.max((i9 - localView.getMeasuredWidth()) / 2, paramInt2);
            i1 = paramInt2;
          }
          if (i5 != 16)
          {
            if (i5 != 48)
            {
              if (i5 != 80)
              {
                paramInt2 = paramInt1;
              }
              else
              {
                paramInt2 = i10 - paramInt4 - localView.getMeasuredHeight();
                paramInt4 += localView.getMeasuredHeight();
              }
            }
            else
            {
              i5 = localView.getMeasuredHeight();
              paramInt2 = paramInt1;
              paramInt1 = i5 + paramInt1;
            }
          }
          else {
            paramInt2 = Math.max((i10 - localView.getMeasuredHeight()) / 2, paramInt1);
          }
          paramInt3 += i11;
          localView.layout(paramInt3, paramInt2, localView.getMeasuredWidth() + paramInt3, paramInt2 + localView.getMeasuredHeight());
          paramInt3 = i3 + 1;
          i5 = paramInt4;
          i6 = paramInt1;
          i7 = i2;
        }
      }
      i4 += 1;
      paramInt2 = i1;
      i2 = i7;
      paramInt1 = i6;
      paramInt4 = i5;
      i3 = paramInt3;
    }
    paramInt3 = 0;
    while (paramInt3 < i8)
    {
      localView = getChildAt(paramInt3);
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (XViewPager.LayoutParams)localView.getLayoutParams();
        if (!localLayoutParams.jdField_a_of_type_Boolean)
        {
          XViewPager.ItemInfo localItemInfo = a(localView);
          if (localItemInfo != null)
          {
            float f1 = i9 - paramInt2 - i2;
            i1 = (int)(localItemInfo.jdField_b_of_type_Float * f1) + paramInt2;
            if (localLayoutParams.jdField_b_of_type_Boolean)
            {
              localLayoutParams.jdField_b_of_type_Boolean = false;
              localView.measure(View.MeasureSpec.makeMeasureSpec((int)(f1 * localLayoutParams.jdField_a_of_type_Float), 1073741824), View.MeasureSpec.makeMeasureSpec(i10 - paramInt1 - paramInt4, 1073741824));
            }
            localView.layout(i1, paramInt1, localView.getMeasuredWidth() + i1, localView.getMeasuredHeight() + paramInt1);
          }
        }
      }
      paramInt3 += 1;
    }
    this.jdField_h_of_type_Int = paramInt1;
    this.jdField_j_of_type_Int = paramInt2;
    this.jdField_i_of_type_Int = (i10 - paramInt4);
    this.jdField_k_of_type_Int = (i9 - i2);
    this.w = i3;
    if ((!this.jdField_l_of_type_Boolean) && (!this.jdField_m_of_type_Boolean)) {
      break label647;
    }
    a(this.jdField_e_of_type_Int, false, 0, false);
    label647:
    this.jdField_l_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    paramInt1 = getMeasuredWidth();
    this.q = Math.min(paramInt1 / 10, this.jdField_p_of_type_Int);
    int i1 = getPaddingLeft();
    int i2 = getPaddingRight();
    paramInt2 = getMeasuredHeight();
    int i3 = getPaddingTop();
    int i4 = getPaddingBottom();
    int i9 = getChildCount();
    paramInt2 = paramInt2 - i3 - i4;
    paramInt1 = paramInt1 - i1 - i2;
    i3 = 0;
    View localView;
    XViewPager.LayoutParams localLayoutParams;
    for (;;)
    {
      int i6 = 1;
      int i8 = 1073741824;
      if (i3 >= i9) {
        break;
      }
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
            i2 = localLayoutParams.jdField_a_of_type_Int & 0x70;
            int i5;
            if ((i2 != 48) && (i2 != 80)) {
              i5 = 0;
            } else {
              i5 = 1;
            }
            i4 = i6;
            if (i1 != 3) {
              if (i1 == 5) {
                i4 = i6;
              } else {
                i4 = 0;
              }
            }
            i1 = -2147483648;
            if (i5 != 0)
            {
              i2 = 1073741824;
            }
            else
            {
              i2 = i1;
              if (i4 != 0)
              {
                i6 = 1073741824;
                i2 = i1;
                i1 = i6;
                break label269;
              }
            }
            i1 = -2147483648;
            label269:
            int i7;
            if (localLayoutParams.width != -2)
            {
              if (localLayoutParams.width != -1) {
                i2 = localLayoutParams.width;
              } else {
                i2 = paramInt1;
              }
              i6 = 1073741824;
              i7 = i2;
            }
            else
            {
              i7 = paramInt1;
              i6 = i2;
            }
            if (localLayoutParams.height != -2)
            {
              if (localLayoutParams.height != -1) {
                i1 = localLayoutParams.height;
              } else {
                i1 = paramInt2;
              }
            }
            else
            {
              i2 = paramInt2;
              i8 = i1;
              i1 = i2;
            }
            localView.measure(View.MeasureSpec.makeMeasureSpec(i7, i6), View.MeasureSpec.makeMeasureSpec(i1, i8));
            if (i5 != 0)
            {
              i2 = paramInt2 - localView.getMeasuredHeight();
              i1 = paramInt1;
            }
            else
            {
              i1 = paramInt1;
              i2 = paramInt2;
              if (i4 != 0)
              {
                i1 = paramInt1 - localView.getMeasuredWidth();
                i2 = paramInt2;
              }
            }
          }
        }
      }
      i3 += 1;
      paramInt1 = i1;
      paramInt2 = i2;
    }
    this.jdField_l_of_type_Int = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
    this.jdField_m_of_type_Int = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
    this.jdField_f_of_type_Boolean = true;
    c();
    paramInt2 = 0;
    this.jdField_f_of_type_Boolean = false;
    i1 = getChildCount();
    while (paramInt2 < i1)
    {
      localView = getChildAt(paramInt2);
      if ((localView != null) && (localView.getVisibility() != 8))
      {
        localLayoutParams = (XViewPager.LayoutParams)localView.getLayoutParams();
        if ((localLayoutParams != null) && (!localLayoutParams.jdField_a_of_type_Boolean)) {
          localView.measure(View.MeasureSpec.makeMeasureSpec((int)(paramInt1 * localLayoutParams.jdField_a_of_type_Float), 1073741824), this.jdField_m_of_type_Int);
        }
      }
      paramInt2 += 1;
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int i1 = getChildCount();
    int i3 = -1;
    int i2;
    if ((paramInt & 0x2) != 0)
    {
      i3 = i1;
      i1 = 0;
      i2 = 1;
    }
    else
    {
      i1 -= 1;
      i2 = -1;
    }
    while (i1 != i3)
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        XViewPager.ItemInfo localItemInfo = a(localView);
        if ((localItemInfo != null) && (localItemInfo.jdField_a_of_type_Int == this.jdField_e_of_type_Int) && (localView.requestFocus(paramInt, paramRect))) {
          return true;
        }
      }
      i1 += i2;
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
    PagerAdapter localPagerAdapter = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter;
    if (localPagerAdapter != null)
    {
      localPagerAdapter.restoreState(paramParcelable.jdField_a_of_type_AndroidOsParcelable, paramParcelable.jdField_a_of_type_JavaLangClassLoader);
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
    PagerAdapter localPagerAdapter = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter;
    if (localPagerAdapter != null) {
      localSavedState.jdField_a_of_type_AndroidOsParcelable = localPagerAdapter.saveState();
    }
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3)
    {
      int i1 = this.jdField_g_of_type_Int;
      a(paramInt1, paramInt3, i1, i1);
    }
    if (paramInt2 != paramInt4)
    {
      paramInt1 = this.jdField_g_of_type_Int;
      b(paramInt2, paramInt4, paramInt1, paramInt1);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_k_of_type_Boolean) {
      return true;
    }
    int i1 = paramMotionEvent.getAction();
    int i2 = 0;
    if ((i1 == 0) && (paramMotionEvent.getEdgeFlags() != 0)) {
      return false;
    }
    Object localObject = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter;
    if (localObject != null)
    {
      if (((PagerAdapter)localObject).getCount() == 0) {
        return false;
      }
      if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
        this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
      }
      this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
      int i3 = paramMotionEvent.getAction() & 0xFF;
      float f1;
      if (i3 != 0)
      {
        i1 = 5;
        boolean bool2;
        boolean bool1;
        if (i3 != 1)
        {
          float f2;
          if (i3 != 2)
          {
            if (i3 != 3)
            {
              if (i3 != 5)
              {
                if (i3 != 6)
                {
                  i1 = i2;
                  break label1282;
                }
                a(paramMotionEvent);
                this.jdField_d_of_type_Float = MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.r));
                this.jdField_e_of_type_Float = MotionEventCompat.getY(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.r));
                i1 = i2;
                break label1282;
              }
              i1 = MotionEventCompat.getActionIndex(paramMotionEvent);
              f1 = MotionEventCompat.getX(paramMotionEvent, i1);
              f2 = MotionEventCompat.getY(paramMotionEvent, i1);
              this.jdField_d_of_type_Float = f1;
              this.jdField_e_of_type_Float = f2;
              this.r = MotionEventCompat.getPointerId(paramMotionEvent, i1);
              i1 = i2;
              break label1282;
            }
            i1 = i2;
            if (!this.jdField_i_of_type_Boolean) {
              break label1282;
            }
            if (Gravity.isHorizontal(this.jdField_o_of_type_Int)) {
              a(this.jdField_e_of_type_Int, true, 0, false);
            } else {
              b(this.jdField_e_of_type_Int, true, 0, false);
            }
            this.r = -1;
            g();
            if (Gravity.isHorizontal(this.jdField_o_of_type_Int))
            {
              bool2 = this.jdField_a_of_type_AndroidSupportV4WidgetEdgeEffectCompat.onRelease();
              bool1 = this.jdField_b_of_type_AndroidSupportV4WidgetEdgeEffectCompat.onRelease();
            }
            else
            {
              bool2 = this.jdField_c_of_type_AndroidSupportV4WidgetEdgeEffectCompat.onRelease();
              bool1 = this.jdField_d_of_type_AndroidSupportV4WidgetEdgeEffectCompat.onRelease();
            }
          }
          else
          {
            if (!this.jdField_i_of_type_Boolean)
            {
              i3 = MotionEventCompat.findPointerIndex(paramMotionEvent, this.r);
              f1 = MotionEventCompat.getX(paramMotionEvent, i3);
              float f3 = Math.abs(f1 - this.jdField_d_of_type_Float);
              f2 = MotionEventCompat.getY(paramMotionEvent, i3);
              float f4 = Math.abs(f2 - this.jdField_e_of_type_Float);
              if (((d()) || ((this.jdField_a_of_type_Boolean) && (f2 < this.jdField_e_of_type_Float)) || ((this.jdField_b_of_type_Boolean) && (f2 > this.jdField_e_of_type_Float))) && ((!this.jdField_i_of_type_Boolean) || (!Gravity.isHorizontal(this.jdField_o_of_type_Int))) && (f4 > this.jdField_a_of_type_Int) && (f4 > f3))
              {
                this.jdField_i_of_type_Boolean = true;
                if (f2 < this.jdField_e_of_type_Float) {
                  i1 = 48;
                } else {
                  i1 = 80;
                }
                this.jdField_o_of_type_Int = i1;
                d(true);
                this.jdField_d_of_type_Float = f1;
                f1 = this.jdField_g_of_type_Float;
                if (f2 - f1 > 0.0F) {
                  f1 += this.jdField_a_of_type_Int;
                } else {
                  f1 -= this.jdField_a_of_type_Int;
                }
                this.jdField_e_of_type_Float = f1;
                b(1);
                e(true);
                localObject = getParent();
                if (localObject != null) {
                  ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
                }
              }
              else if (((c()) || ((this.jdField_c_of_type_Boolean) && (f1 < this.jdField_d_of_type_Float)) || ((this.jdField_d_of_type_Boolean) && (f1 > this.jdField_d_of_type_Float))) && ((!this.jdField_i_of_type_Boolean) || (!Gravity.isVertical(this.jdField_o_of_type_Int))) && (f3 > this.jdField_a_of_type_Int) && (f3 > f4))
              {
                this.jdField_i_of_type_Boolean = true;
                if (f1 < this.jdField_d_of_type_Float) {
                  i1 = 3;
                }
                this.jdField_o_of_type_Int = i1;
                d(true);
                f3 = this.jdField_f_of_type_Float;
                if (f1 - f3 > 0.0F) {
                  f1 = f3 + this.jdField_a_of_type_Int;
                } else {
                  f1 = f3 - this.jdField_a_of_type_Int;
                }
                this.jdField_d_of_type_Float = f1;
                this.jdField_e_of_type_Float = f2;
                b(1);
                e(true);
                localObject = getParent();
                if (localObject != null) {
                  ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
                }
              }
            }
            i1 = i2;
            if (!this.jdField_i_of_type_Boolean) {
              break label1282;
            }
            if (Gravity.isHorizontal(this.jdField_o_of_type_Int)) {
              bool1 = a(MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.r)));
            } else {
              bool1 = b(MotionEventCompat.getY(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.r)));
            }
            i1 = false | bool1;
            break label1282;
          }
        }
        else
        {
          i1 = i2;
          if (!this.jdField_i_of_type_Boolean) {
            break label1282;
          }
          if (Gravity.isHorizontal(this.jdField_o_of_type_Int))
          {
            localObject = this.jdField_a_of_type_AndroidViewVelocityTracker;
            ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.t);
            i3 = (int)VelocityTrackerCompat.getXVelocity((VelocityTracker)localObject, this.r);
            this.jdField_h_of_type_Boolean = true;
            i1 = d();
            i2 = getScrollX();
            localObject = a();
            i2 = a(((XViewPager.ItemInfo)localObject).jdField_a_of_type_Int, (i2 / i1 - ((XViewPager.ItemInfo)localObject).jdField_b_of_type_Float) / ((XViewPager.ItemInfo)localObject).jdField_a_of_type_Float, i3, (int)(MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.r)) - this.jdField_f_of_type_Float));
            paramMotionEvent = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnDragStatusChangedListener;
            i1 = i2;
            if (paramMotionEvent != null)
            {
              i1 = i2;
              if (!paramMotionEvent.a()) {
                if ((this.jdField_o_of_type_Int == 3) && (i2 < c()))
                {
                  i1 = c();
                }
                else
                {
                  i1 = i2;
                  if (this.jdField_o_of_type_Int == 5)
                  {
                    i1 = i2;
                    if (i2 > c()) {
                      i1 = c();
                    }
                  }
                }
              }
            }
            a(i1, true, true, i3);
            this.r = -1;
            g();
            bool2 = this.jdField_a_of_type_AndroidSupportV4WidgetEdgeEffectCompat.onRelease();
            bool1 = this.jdField_b_of_type_AndroidSupportV4WidgetEdgeEffectCompat.onRelease();
          }
          else
          {
            i1 = i2;
            if (!Gravity.isVertical(this.jdField_o_of_type_Int)) {
              break label1282;
            }
            localObject = this.jdField_a_of_type_AndroidViewVelocityTracker;
            ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.t);
            i1 = (int)VelocityTrackerCompat.getYVelocity((VelocityTracker)localObject, this.r);
            this.jdField_h_of_type_Boolean = true;
            i2 = e();
            i3 = getScrollY();
            localObject = a();
            a(a(((XViewPager.ItemInfo)localObject).jdField_a_of_type_Int, (i3 / i2 - ((XViewPager.ItemInfo)localObject).jdField_b_of_type_Float) / ((XViewPager.ItemInfo)localObject).jdField_a_of_type_Float, i1, (int)(MotionEventCompat.getY(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.r)) - this.jdField_g_of_type_Float)), true, true, i1);
            this.r = -1;
            g();
            bool2 = this.jdField_c_of_type_AndroidSupportV4WidgetEdgeEffectCompat.onRelease();
            bool1 = this.jdField_d_of_type_AndroidSupportV4WidgetEdgeEffectCompat.onRelease();
          }
        }
        i1 = bool2 | bool1;
      }
      else
      {
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
        i1 = i2;
      }
      label1282:
      if (i1 != 0) {
        ViewCompat.postInvalidateOnAnimation(this);
      }
      return true;
    }
    return false;
  }
  
  protected void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    XViewPager.OnVisibilityChangeListener localOnVisibilityChangeListener = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnVisibilityChangeListener;
    if (localOnVisibilityChangeListener != null) {
      localOnVisibilityChangeListener.a(paramView, paramInt);
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
    Object localObject = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter;
    if (localObject != null)
    {
      ((PagerAdapter)localObject).unregisterDataSetObserver(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$PagerObserver);
      this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.startUpdate(this);
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject = (XViewPager.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.destroyItem(this, ((XViewPager.ItemInfo)localObject).jdField_a_of_type_Int, ((XViewPager.ItemInfo)localObject).jdField_a_of_type_JavaLangObject);
        i1 += 1;
      }
      this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.finishUpdate(this);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      d();
      this.jdField_e_of_type_Int = 0;
      scrollTo(0, 0);
    }
    localObject = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter;
    this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter = paramPagerAdapter;
    this.jdField_d_of_type_Int = 0;
    if (this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter != null)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$PagerObserver == null) {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$PagerObserver = new XViewPager.PagerObserver(this, null);
      }
      this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.registerDataSetObserver(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$PagerObserver);
      this.jdField_h_of_type_Boolean = false;
      boolean bool = this.jdField_l_of_type_Boolean;
      this.jdField_l_of_type_Boolean = true;
      this.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.getCount();
      if (this.jdField_f_of_type_Int >= 0)
      {
        this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter.restoreState(this.jdField_a_of_type_AndroidOsParcelable, this.jdField_a_of_type_JavaLangClassLoader);
        a(this.jdField_f_of_type_Int, false, true);
        this.jdField_f_of_type_Int = -1;
        this.jdField_a_of_type_AndroidOsParcelable = null;
        this.jdField_a_of_type_JavaLangClassLoader = null;
      }
      else if (!bool)
      {
        c();
      }
      else
      {
        requestLayout();
      }
    }
    XViewPager.OnAdapterChangeListener localOnAdapterChangeListener = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$OnAdapterChangeListener;
    if ((localOnAdapterChangeListener != null) && (localObject != paramPagerAdapter)) {
      localOnAdapterChangeListener.a((PagerAdapter)localObject, paramPagerAdapter);
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.jdField_h_of_type_Boolean = false;
    a(paramInt, this.jdField_l_of_type_Boolean ^ true, false);
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
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Requested offscreen page limit ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" too small; defaulting to ");
      localStringBuilder.append(1);
      SLog.d(str, localStringBuilder.toString());
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
    else
    {
      i2 = getWidth();
      a(i2, i2, paramInt, i1);
    }
    requestLayout();
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
    boolean bool;
    if (paramDrawable == null) {
      bool = true;
    } else {
      bool = false;
    }
    setWillNotDraw(bool);
    invalidate();
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
    if (Build.VERSION.SDK_INT >= 11)
    {
      int i2 = 1;
      boolean bool1;
      if (paramPageTransformer != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool2;
      if (this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$PageTransformer != null) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      int i1;
      if (bool1 != bool2) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager$PageTransformer = paramPageTransformer;
      a(bool1);
      if (bool1)
      {
        if (paramBoolean) {
          i2 = 2;
        }
        this.x = i2;
      }
      else
      {
        this.x = 0;
      }
      if (i1 != 0) {
        c();
      }
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
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager
 * JD-Core Version:    0.7.0.1
 */