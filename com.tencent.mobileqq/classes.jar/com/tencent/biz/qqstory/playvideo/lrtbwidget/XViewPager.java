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
  private static final XViewPager.ViewPositionComparator ax = new XViewPager.ViewPositionComparator();
  private static final int[] n = { 16842931 };
  private static final Comparator<XViewPager.ItemInfo> p = new XViewPager.1();
  private static final Interpolator q = new XViewPager.2();
  private XViewPager.PagerObserver A;
  private int B;
  private Drawable C;
  private int D;
  private int E;
  private int F;
  private int G;
  private float H;
  private float I;
  private int J;
  private int K;
  private boolean L;
  private boolean M;
  private boolean N;
  private int O;
  private boolean P;
  private int Q;
  private boolean R;
  private int S;
  private int T;
  private float U;
  private float V;
  private float W;
  private float Z;
  public String a;
  private int aA;
  private final Runnable aB;
  private int aC;
  private int aa;
  private VelocityTracker ab;
  private int ac;
  private int ad;
  private int ae;
  private int af;
  private boolean ag;
  private EdgeEffectCompat ah;
  private EdgeEffectCompat ai;
  private EdgeEffectCompat aj;
  private EdgeEffectCompat ak;
  private boolean al;
  private boolean am;
  private boolean an;
  private boolean ao;
  private int ap;
  private XViewPager.OnPageChangeListener aq;
  private XViewPager.OnPageChangeListener ar;
  private XViewPager.OnAdapterChangeListener as;
  private XViewPager.PageTransformer at;
  private Method au;
  private int av;
  private ArrayList<View> aw;
  private XViewPager.OnDragStatusChangedListener ay;
  private boolean az;
  protected int b;
  private boolean c = false;
  private boolean d = false;
  private boolean e = true;
  private boolean f = true;
  private XViewPager.PageTransformer g = null;
  private boolean h = false;
  private float i = 0.6F;
  private int j = -1;
  private int k = 1;
  private XViewPager.OnVisibilityChangeListener l;
  private List<XViewPager.OnPageChangeListener> m;
  private int o;
  private final ArrayList<XViewPager.ItemInfo> r;
  private final XViewPager.ItemInfo s;
  private final Rect t;
  private PagerAdapter u;
  private int v;
  private int w;
  private Parcelable x;
  private ClassLoader y;
  private Scroller z;
  
  public XViewPager(Context paramContext)
  {
    super(paramContext);
    paramContext = new StringBuilder();
    paramContext.append("XViewPager");
    paramContext.append(System.identityHashCode(this));
    this.a = paramContext.toString();
    this.r = new ArrayList();
    this.s = new XViewPager.ItemInfo();
    this.t = new Rect();
    this.w = -1;
    this.x = null;
    this.y = null;
    this.H = -3.402824E+038F;
    this.I = 3.4028235E+38F;
    this.O = 1;
    this.aa = -1;
    this.al = true;
    this.am = false;
    this.an = false;
    this.az = false;
    this.aA = 0;
    this.aB = new XViewPager.3(this);
    this.aC = 0;
    a();
  }
  
  public XViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = new StringBuilder();
    paramContext.append("XViewPager");
    paramContext.append(System.identityHashCode(this));
    this.a = paramContext.toString();
    this.r = new ArrayList();
    this.s = new XViewPager.ItemInfo();
    this.t = new Rect();
    this.w = -1;
    this.x = null;
    this.y = null;
    this.H = -3.402824E+038F;
    this.I = 3.4028235E+38F;
    this.O = 1;
    this.aa = -1;
    this.al = true;
    this.am = false;
    this.an = false;
    this.az = false;
    this.aA = 0;
    this.aB = new XViewPager.3(this);
    this.aC = 0;
    a();
  }
  
  private int a(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    if ((Math.abs(paramInt3) > this.ae) && (Math.abs(paramInt2) > this.ac))
    {
      if (paramInt2 <= 0) {
        paramInt1 += 1;
      }
    }
    else
    {
      float f1;
      if (paramInt1 >= this.v) {
        f1 = 1.0F - this.i;
      } else {
        f1 = this.i;
      }
      paramInt1 = (int)(paramInt1 + paramFloat + f1);
    }
    paramInt2 = paramInt1;
    if (this.r.size() > 0)
    {
      if (this.O == 0) {
        return Math.max(0, Math.min(paramInt1, this.u.getCount()));
      }
      XViewPager.ItemInfo localItemInfo = (XViewPager.ItemInfo)this.r.get(0);
      Object localObject = this.r;
      localObject = (XViewPager.ItemInfo)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
      paramInt2 = Math.max(localItemInfo.b, Math.min(paramInt1, ((XViewPager.ItemInfo)localObject).b));
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
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    XViewPager.ItemInfo localItemInfo;
    if ((paramInt2 > 0) && (!this.r.isEmpty()))
    {
      int i1 = getPaddingLeft();
      int i2 = getPaddingRight();
      int i3 = getPaddingLeft();
      int i4 = getPaddingRight();
      paramInt2 = (int)(getScrollX() / (paramInt2 - i3 - i4 + paramInt4) * (paramInt1 - i1 - i2 + paramInt3));
      scrollTo(paramInt2, getScrollY());
      if (!this.z.isFinished())
      {
        paramInt3 = this.z.getDuration();
        paramInt4 = this.z.timePassed();
        localItemInfo = b(this.v);
        if (localItemInfo != null) {
          this.z.startScroll(paramInt2, 0, (int)(localItemInfo.e * paramInt1), 0, paramInt3 - paramInt4);
        }
      }
    }
    else
    {
      localItemInfo = b(this.v);
      float f1;
      if (localItemInfo != null) {
        f1 = Math.min(localItemInfo.e, this.I);
      } else {
        f1 = 0.0F;
      }
      paramInt1 = (int)(f1 * (paramInt1 - getPaddingLeft() - getPaddingRight()));
      if (paramInt1 != getScrollX())
      {
        a(false);
        scrollTo(paramInt1, getScrollY());
      }
    }
  }
  
  private void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    Object localObject = b(paramInt1);
    int i2 = 0;
    int i1;
    if (localObject != null) {
      i1 = (int)(getClientWidth() * Math.max(this.H, Math.min(((XViewPager.ItemInfo)localObject).e, this.I)));
    } else {
      i1 = 0;
    }
    if (paramBoolean1)
    {
      a(i1, 0, paramInt2);
      if (paramBoolean2)
      {
        localObject = this.aq;
        if (localObject != null) {
          ((XViewPager.OnPageChangeListener)localObject).a(paramInt1);
        }
      }
      if (paramBoolean2)
      {
        localObject = this.m;
        if (localObject != null)
        {
          i1 = ((List)localObject).size();
          paramInt2 = i2;
          while (paramInt2 < i1)
          {
            localObject = (XViewPager.OnPageChangeListener)this.m.get(paramInt2);
            if (localObject != null) {
              ((XViewPager.OnPageChangeListener)localObject).a(paramInt1);
            }
            paramInt2 += 1;
          }
        }
      }
      if (paramBoolean2)
      {
        localObject = this.ar;
        if (localObject != null) {
          ((XViewPager.OnPageChangeListener)localObject).a(paramInt1);
        }
      }
    }
    else
    {
      if (paramBoolean2)
      {
        localObject = this.aq;
        if (localObject != null) {
          ((XViewPager.OnPageChangeListener)localObject).a(paramInt1);
        }
      }
      if (paramBoolean2)
      {
        localObject = this.m;
        if (localObject != null)
        {
          i2 = ((List)localObject).size();
          paramInt2 = 0;
          while (paramInt2 < i2)
          {
            localObject = (XViewPager.OnPageChangeListener)this.m.get(paramInt2);
            if (localObject != null) {
              ((XViewPager.OnPageChangeListener)localObject).a(paramInt1);
            }
            paramInt2 += 1;
          }
        }
      }
      if (paramBoolean2)
      {
        localObject = this.ar;
        if (localObject != null) {
          ((XViewPager.OnPageChangeListener)localObject).a(paramInt1);
        }
      }
      a(false);
      if (this.az)
      {
        b(paramInt1, i1);
        return;
      }
      scrollTo(i1, 0);
      d(i1);
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (MotionEventCompat.getPointerId(paramMotionEvent, i1) == this.aa)
    {
      if (i1 == 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      this.U = MotionEventCompat.getX(paramMotionEvent, i1);
      this.V = MotionEventCompat.getY(paramMotionEvent, i1);
      this.aa = MotionEventCompat.getPointerId(paramMotionEvent, i1);
      paramMotionEvent = this.ab;
      if (paramMotionEvent != null) {
        paramMotionEvent.clear();
      }
    }
  }
  
  private void a(XViewPager.ItemInfo paramItemInfo1, int paramInt, XViewPager.ItemInfo paramItemInfo2)
  {
    int i4 = this.u.getCount();
    int i1 = getClientWidth();
    float f2;
    if (i1 > 0) {
      f2 = this.B / i1;
    } else {
      f2 = 0.0F;
    }
    if (paramItemInfo2 != null)
    {
      i1 = paramItemInfo2.b;
      if (i1 < paramItemInfo1.b)
      {
        f1 = paramItemInfo2.e + paramItemInfo2.d + f2;
        i1 += 1;
        i2 = 0;
        while ((i1 <= paramItemInfo1.b) && (i2 < this.r.size()))
        {
          for (paramItemInfo2 = (XViewPager.ItemInfo)this.r.get(i2);; paramItemInfo2 = (XViewPager.ItemInfo)this.r.get(i2))
          {
            i3 = i1;
            f3 = f1;
            if (i1 <= paramItemInfo2.b) {
              break;
            }
            i3 = i1;
            f3 = f1;
            if (i2 >= this.r.size() - 1) {
              break;
            }
            i2 += 1;
          }
          while (i3 < paramItemInfo2.b)
          {
            f3 += this.u.getPageWidth(i3) + f2;
            i3 += 1;
          }
          paramItemInfo2.e = f3;
          f1 = f3 + (paramItemInfo2.d + f2);
          i1 = i3 + 1;
        }
      }
      if (i1 > paramItemInfo1.b)
      {
        i2 = this.r.size() - 1;
        f1 = paramItemInfo2.e;
        i1 -= 1;
        while ((i1 >= paramItemInfo1.b) && (i2 >= 0))
        {
          for (paramItemInfo2 = (XViewPager.ItemInfo)this.r.get(i2);; paramItemInfo2 = (XViewPager.ItemInfo)this.r.get(i2))
          {
            i3 = i1;
            f3 = f1;
            if (i1 >= paramItemInfo2.b) {
              break;
            }
            i3 = i1;
            f3 = f1;
            if (i2 <= 0) {
              break;
            }
            i2 -= 1;
          }
          while (i3 > paramItemInfo2.b)
          {
            f3 -= this.u.getPageWidth(i3) + f2;
            i3 -= 1;
          }
          f1 = f3 - (paramItemInfo2.d + f2);
          paramItemInfo2.e = f1;
          i1 = i3 - 1;
        }
      }
    }
    int i3 = this.r.size();
    float f3 = paramItemInfo1.e;
    i1 = paramItemInfo1.b - 1;
    if (paramItemInfo1.b == 0) {
      f1 = paramItemInfo1.e;
    } else {
      f1 = -3.402824E+038F;
    }
    this.H = f1;
    int i2 = paramItemInfo1.b;
    i4 -= 1;
    if (i2 == i4) {
      f1 = paramItemInfo1.e + paramItemInfo1.d - 1.0F;
    } else {
      f1 = 3.4028235E+38F;
    }
    this.I = f1;
    i2 = paramInt - 1;
    float f1 = f3;
    while (i2 >= 0)
    {
      paramItemInfo2 = (XViewPager.ItemInfo)this.r.get(i2);
      while (i1 > paramItemInfo2.b)
      {
        f1 -= this.u.getPageWidth(i1) + f2;
        i1 -= 1;
      }
      f1 -= paramItemInfo2.d + f2;
      paramItemInfo2.e = f1;
      if (paramItemInfo2.b == 0) {
        this.H = f1;
      }
      i2 -= 1;
      i1 -= 1;
    }
    f1 = paramItemInfo1.e + paramItemInfo1.d + f2;
    i2 = paramItemInfo1.b + 1;
    i1 = paramInt + 1;
    paramInt = i2;
    while (i1 < i3)
    {
      paramItemInfo1 = (XViewPager.ItemInfo)this.r.get(i1);
      while (paramInt < paramItemInfo1.b)
      {
        f1 += this.u.getPageWidth(paramInt) + f2;
        paramInt += 1;
      }
      if (paramItemInfo1.b == i4) {
        this.I = (paramItemInfo1.d + f1 - 1.0F);
      }
      paramItemInfo1.e = f1;
      f1 += paramItemInfo1.d + f2;
      i1 += 1;
      paramInt += 1;
    }
    this.an = false;
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.aC == 2) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      setScrollingCacheEnabled(false);
      this.z.abortAnimation();
      i2 = getScrollX();
      i3 = getScrollY();
      int i4 = this.z.getCurrX();
      int i5 = this.z.getCurrY();
      if ((i2 != i4) || (i3 != i5)) {
        scrollTo(i4, i5);
      }
    }
    this.N = false;
    int i3 = 0;
    int i2 = i1;
    int i1 = i3;
    while (i1 < this.r.size())
    {
      XViewPager.ItemInfo localItemInfo = (XViewPager.ItemInfo)this.r.get(i1);
      if (localItemInfo.c)
      {
        localItemInfo.c = false;
        i2 = 1;
      }
      i1 += 1;
    }
    if (i2 != 0)
    {
      if (paramBoolean)
      {
        ViewCompat.postOnAnimation(this, this.aB);
        return;
      }
      this.aB.run();
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return ((paramFloat1 < this.T) && (paramFloat2 > 0.0F)) || ((paramFloat1 > getWidth() - this.T) && (paramFloat2 < 0.0F));
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { getScrollX(), paramInt2 });
    localValueAnimator.setDuration(this.aA);
    localValueAnimator.addUpdateListener(new XViewPager.4(this));
    localValueAnimator.addListener(new XViewPager.5(this));
    localValueAnimator.start();
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    XViewPager.ItemInfo localItemInfo;
    if ((paramInt2 > 0) && (!this.r.isEmpty()))
    {
      int i1 = getPaddingTop();
      int i2 = getPaddingBottom();
      int i3 = getPaddingTop();
      int i4 = getPaddingBottom();
      paramInt2 = (int)(getScrollY() / (paramInt2 - i3 - i4 + paramInt4) * (paramInt1 - i1 - i2 + paramInt3));
      scrollTo(getScrollX(), paramInt2);
      if (!this.z.isFinished())
      {
        paramInt3 = this.z.getDuration();
        paramInt4 = this.z.timePassed();
        localItemInfo = b(this.v);
        if (localItemInfo != null) {
          this.z.startScroll(0, paramInt2, 0, (int)(localItemInfo.e * paramInt1), paramInt3 - paramInt4);
        }
      }
    }
    else
    {
      localItemInfo = b(this.v);
      float f1;
      if (localItemInfo != null) {
        f1 = Math.min(localItemInfo.e, this.I);
      } else {
        f1 = 0.0F;
      }
      paramInt1 = (int)(f1 * (paramInt1 - getPaddingTop() - getPaddingBottom()));
      if (paramInt1 != getScrollY())
      {
        a(false);
        scrollTo(getScrollX(), paramInt1);
      }
    }
  }
  
  private void b(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    Object localObject = b(paramInt1);
    int i2 = 0;
    int i1;
    if (localObject != null) {
      i1 = (int)(getClientHeight() * Math.max(this.H, Math.min(((XViewPager.ItemInfo)localObject).e, this.I)));
    } else {
      i1 = 0;
    }
    if (paramBoolean1)
    {
      a(0, i1, paramInt2);
      if (paramBoolean2)
      {
        localObject = this.aq;
        if (localObject != null) {
          ((XViewPager.OnPageChangeListener)localObject).a(paramInt1);
        }
      }
      if (paramBoolean2)
      {
        localObject = this.m;
        if (localObject != null)
        {
          i1 = ((List)localObject).size();
          paramInt2 = i2;
          while (paramInt2 < i1)
          {
            localObject = (XViewPager.OnPageChangeListener)this.m.get(paramInt2);
            if (localObject != null) {
              ((XViewPager.OnPageChangeListener)localObject).a(paramInt1);
            }
            paramInt2 += 1;
          }
        }
      }
      if (paramBoolean2)
      {
        localObject = this.ar;
        if (localObject != null) {
          ((XViewPager.OnPageChangeListener)localObject).a(paramInt1);
        }
      }
    }
    else
    {
      if (paramBoolean2)
      {
        localObject = this.aq;
        if (localObject != null) {
          ((XViewPager.OnPageChangeListener)localObject).a(paramInt1);
        }
      }
      if (paramBoolean2)
      {
        localObject = this.m;
        if (localObject != null)
        {
          i2 = ((List)localObject).size();
          paramInt2 = 0;
          while (paramInt2 < i2)
          {
            localObject = (XViewPager.OnPageChangeListener)this.m.get(paramInt2);
            if (localObject != null) {
              ((XViewPager.OnPageChangeListener)localObject).a(paramInt1);
            }
            paramInt2 += 1;
          }
        }
      }
      if (paramBoolean2)
      {
        localObject = this.ar;
        if (localObject != null) {
          ((XViewPager.OnPageChangeListener)localObject).a(paramInt1);
        }
      }
      a(false);
      scrollTo(0, i1);
      e(i1);
    }
  }
  
  private void b(XViewPager.ItemInfo paramItemInfo1, int paramInt, XViewPager.ItemInfo paramItemInfo2)
  {
    int i4 = this.u.getCount();
    int i1 = getClientHeight();
    float f2;
    if (i1 > 0) {
      f2 = this.B / i1;
    } else {
      f2 = 0.0F;
    }
    if (paramItemInfo2 != null)
    {
      i1 = paramItemInfo2.b;
      if (i1 < paramItemInfo1.b)
      {
        f1 = paramItemInfo2.e + paramItemInfo2.d + f2;
        i1 += 1;
        i2 = 0;
        while ((i1 <= paramItemInfo1.b) && (i2 < this.r.size()))
        {
          for (paramItemInfo2 = (XViewPager.ItemInfo)this.r.get(i2);; paramItemInfo2 = (XViewPager.ItemInfo)this.r.get(i2))
          {
            i3 = i1;
            f3 = f1;
            if (i1 <= paramItemInfo2.b) {
              break;
            }
            i3 = i1;
            f3 = f1;
            if (i2 >= this.r.size() - 1) {
              break;
            }
            i2 += 1;
          }
          while (i3 < paramItemInfo2.b)
          {
            f3 += this.u.getPageWidth(i3) + f2;
            i3 += 1;
          }
          paramItemInfo2.e = f3;
          f1 = f3 + (paramItemInfo2.d + f2);
          i1 = i3 + 1;
        }
      }
      if (i1 > paramItemInfo1.b)
      {
        i2 = this.r.size() - 1;
        f1 = paramItemInfo2.e;
        i1 -= 1;
        while ((i1 >= paramItemInfo1.b) && (i2 >= 0))
        {
          for (paramItemInfo2 = (XViewPager.ItemInfo)this.r.get(i2);; paramItemInfo2 = (XViewPager.ItemInfo)this.r.get(i2))
          {
            i3 = i1;
            f3 = f1;
            if (i1 >= paramItemInfo2.b) {
              break;
            }
            i3 = i1;
            f3 = f1;
            if (i2 <= 0) {
              break;
            }
            i2 -= 1;
          }
          while (i3 > paramItemInfo2.b)
          {
            f3 -= this.u.getPageWidth(i3) + f2;
            i3 -= 1;
          }
          f1 = f3 - (paramItemInfo2.d + f2);
          paramItemInfo2.e = f1;
          i1 = i3 - 1;
        }
      }
    }
    int i3 = this.r.size();
    float f3 = paramItemInfo1.e;
    i1 = paramItemInfo1.b - 1;
    if (paramItemInfo1.b == 0) {
      f1 = paramItemInfo1.e;
    } else {
      f1 = -3.402824E+038F;
    }
    this.H = f1;
    int i2 = paramItemInfo1.b;
    i4 -= 1;
    if (i2 == i4) {
      f1 = paramItemInfo1.e + paramItemInfo1.d - 1.0F;
    } else {
      f1 = 3.4028235E+38F;
    }
    this.I = f1;
    i2 = paramInt - 1;
    float f1 = f3;
    while (i2 >= 0)
    {
      paramItemInfo2 = (XViewPager.ItemInfo)this.r.get(i2);
      while (i1 > paramItemInfo2.b)
      {
        f1 -= this.u.getPageWidth(i1) + f2;
        i1 -= 1;
      }
      f1 -= paramItemInfo2.d + f2;
      paramItemInfo2.e = f1;
      if (paramItemInfo2.b == 0) {
        this.H = f1;
      }
      i2 -= 1;
      i1 -= 1;
    }
    f1 = paramItemInfo1.e + paramItemInfo1.d + f2;
    i2 = paramItemInfo1.b + 1;
    i1 = paramInt + 1;
    paramInt = i2;
    while (i1 < i3)
    {
      paramItemInfo1 = (XViewPager.ItemInfo)this.r.get(i1);
      while (paramInt < paramItemInfo1.b)
      {
        f1 += this.u.getPageWidth(paramInt) + f2;
        paramInt += 1;
      }
      if (paramItemInfo1.b == i4) {
        this.I = (paramItemInfo1.d + f1 - 1.0F);
      }
      paramItemInfo1.e = f1;
      f1 += paramItemInfo1.d + f2;
      i1 += 1;
      paramInt += 1;
    }
    this.an = false;
  }
  
  private void b(boolean paramBoolean)
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
  
  private boolean b(float paramFloat)
  {
    m();
    float f1 = this.U;
    this.U = paramFloat;
    float f2 = getScrollX() + (f1 - paramFloat);
    float f3 = getClientWidth();
    paramFloat = this.H * f3;
    f1 = this.I * f3;
    Object localObject1 = (XViewPager.ItemInfo)this.r.get(0);
    Object localObject2 = this.r;
    localObject2 = (XViewPager.ItemInfo)((ArrayList)localObject2).get(((ArrayList)localObject2).size() - 1);
    if (((XViewPager.ItemInfo)localObject1).b != 0)
    {
      paramFloat = ((XViewPager.ItemInfo)localObject1).e * f3;
      i1 = 0;
    }
    else
    {
      i1 = 1;
    }
    int i2;
    if (((XViewPager.ItemInfo)localObject2).b != this.u.getCount() - 1)
    {
      f1 = ((XViewPager.ItemInfo)localObject2).e * f3;
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
        bool = this.ah.onPull(Math.abs(paramFloat - f2) / f3);
      } else {
        bool = false;
      }
      if (this.h) {
        paramFloat = f2;
      }
    }
    else if (f2 > f1)
    {
      if (i2 != 0) {
        bool = this.ai.onPull(Math.abs(f2 - f1) / f3);
      } else {
        bool = false;
      }
      if (this.h) {
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
    localObject1 = this.ay;
    f1 = paramFloat;
    if (localObject1 != null)
    {
      f1 = paramFloat;
      if (!((XViewPager.OnDragStatusChangedListener)localObject1).a())
      {
        i1 = getWidth() * (getCurrentItem() - 1);
        if (this.Q == 3)
        {
          f1 = i1;
          if (paramFloat < f1) {}
        }
        else
        {
          f1 = paramFloat;
          if (this.Q == 5)
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
    paramFloat = this.U;
    int i1 = (int)f1;
    this.U = (paramFloat + (f1 - i1));
    scrollTo(i1, 0);
    d(i1);
    return bool;
  }
  
  private boolean b(float paramFloat1, float paramFloat2)
  {
    return ((paramFloat1 < this.T) && (paramFloat2 > 0.0F)) || ((paramFloat1 > getHeight() - this.T) && (paramFloat2 < 0.0F));
  }
  
  private void c(boolean paramBoolean)
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  private boolean c(float paramFloat)
  {
    m();
    float f1 = this.V;
    this.V = paramFloat;
    float f2 = getScrollY() + (f1 - paramFloat);
    float f3 = getClientHeight();
    paramFloat = this.H * f3;
    f1 = this.I * f3;
    XViewPager.ItemInfo localItemInfo = (XViewPager.ItemInfo)this.r.get(0);
    Object localObject = this.r;
    int i1 = ((ArrayList)localObject).size();
    int i2 = 1;
    localObject = (XViewPager.ItemInfo)((ArrayList)localObject).get(i1 - 1);
    if (localItemInfo.b != 0)
    {
      paramFloat = localItemInfo.e * f3;
      i1 = 0;
    }
    else
    {
      i1 = 1;
    }
    if (((XViewPager.ItemInfo)localObject).b != this.u.getCount() - 1)
    {
      f1 = ((XViewPager.ItemInfo)localObject).e * f3;
      i2 = 0;
    }
    boolean bool;
    if (f2 < paramFloat)
    {
      if (i1 != 0) {
        bool = this.aj.onPull(Math.abs(paramFloat - f2) / f3);
      } else {
        bool = false;
      }
      if (this.h) {
        paramFloat = f2;
      }
    }
    else if (f2 > f1)
    {
      if (i2 != 0) {
        bool = this.ak.onPull(Math.abs(f2 - f1) / f3);
      } else {
        bool = false;
      }
      if (this.h) {
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
    f1 = this.V;
    i1 = (int)paramFloat;
    this.V = (f1 + (paramFloat - i1));
    scrollTo(0, i1);
    e(i1);
    return bool;
  }
  
  private boolean d(int paramInt)
  {
    if (this.r.size() == 0)
    {
      this.ao = false;
      a(0, 0.0F, 0);
      if (this.ao) {
        return false;
      }
      throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }
    XViewPager.ItemInfo localItemInfo = n();
    int i2 = getClientWidth();
    int i3 = this.B;
    float f2 = i3;
    float f1 = i2;
    f2 /= f1;
    int i1 = localItemInfo.b;
    f1 = (paramInt / f1 - localItemInfo.e) / (localItemInfo.d + f2);
    paramInt = (int)((i2 + i3) * f1);
    this.ao = false;
    a(i1, f1, paramInt);
    if (this.ao) {
      return true;
    }
    throw new IllegalStateException("onPageScrolled did not call superclass implementation");
  }
  
  private boolean e(int paramInt)
  {
    if (this.r.size() == 0)
    {
      this.ao = false;
      b(0, 0.0F, 0);
      if (this.ao) {
        return false;
      }
      throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }
    XViewPager.ItemInfo localItemInfo = n();
    int i2 = getClientHeight();
    int i3 = this.B;
    float f2 = i3;
    float f1 = i2;
    f2 /= f1;
    int i1 = localItemInfo.b;
    f1 = (paramInt / f1 - localItemInfo.e) / (localItemInfo.d + f2);
    paramInt = (int)((i2 + i3) * f1);
    this.ao = false;
    b(i1, f1, paramInt);
    if (this.ao) {
      return true;
    }
    throw new IllegalStateException("onPageScrolled did not call superclass implementation");
  }
  
  private boolean g()
  {
    return (this.e) && (this.f);
  }
  
  private int getClientHeight()
  {
    return getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
  }
  
  private int getClientWidth()
  {
    return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  private boolean h()
  {
    return (this.c) && (this.d);
  }
  
  private void i()
  {
    int i2;
    for (int i1 = 0; i1 < getChildCount(); i1 = i2 + 1)
    {
      i2 = i1;
      if (!((XViewPager.LayoutParams)getChildAt(i1).getLayoutParams()).a)
      {
        removeViewAt(i1);
        i2 = i1 - 1;
      }
    }
  }
  
  private boolean j()
  {
    return (Gravity.isHorizontal(this.Q)) || (((this.e) || (this.f)) && ((this.Q == 0) || (!k())));
  }
  
  private boolean k()
  {
    return (Gravity.isVertical(this.Q)) || (((this.c) || (this.d)) && ((this.Q == 0) || (!j())));
  }
  
  private void l()
  {
    if (this.av != 0)
    {
      Object localObject = this.aw;
      if (localObject == null) {
        this.aw = new ArrayList();
      } else {
        ((ArrayList)localObject).clear();
      }
      int i2 = getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        localObject = getChildAt(i1);
        this.aw.add(localObject);
        i1 += 1;
      }
      Collections.sort(this.aw, ax);
    }
  }
  
  private void m()
  {
    int i4 = getChildCount();
    int i5 = getClientWidth();
    int i6 = getClientHeight();
    int i3 = 0;
    int i2;
    for (int i1 = 0; i3 < i4; i1 = i2)
    {
      View localView = getChildAt(i3);
      i2 = i1;
      if (localView.getVisibility() != 8)
      {
        i2 = i1;
        if (!((XViewPager.LayoutParams)localView.getLayoutParams()).a)
        {
          XViewPager.ItemInfo localItemInfo = a(localView);
          i2 = i1;
          if (localItemInfo != null)
          {
            int i7;
            int i8;
            if (Gravity.isHorizontal(this.Q))
            {
              i7 = (int)(i5 * localItemInfo.e);
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
                this.am = false;
                i2 = i1;
              }
            }
            else
            {
              i2 = i1;
              if (Gravity.isVertical(this.Q))
              {
                i7 = (int)(i6 * localItemInfo.e);
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
                  this.am = true;
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
      if (Gravity.isHorizontal(this.Q))
      {
        a(this.v, false, 0, false);
        return;
      }
      if (Gravity.isVertical(this.Q)) {
        b(this.v, false, 0, false);
      }
    }
  }
  
  private XViewPager.ItemInfo n()
  {
    if (k()) {
      return o();
    }
    int i1 = getClientWidth();
    float f1;
    if (i1 > 0) {
      f1 = getScrollX() / i1;
    } else {
      f1 = 0.0F;
    }
    float f2;
    if (i1 > 0) {
      f2 = this.B / i1;
    } else {
      f2 = 0.0F;
    }
    Object localObject = null;
    i1 = 0;
    int i2 = 1;
    int i3 = -1;
    float f3 = 0.0F;
    float f4 = 0.0F;
    while (i1 < this.r.size())
    {
      XViewPager.ItemInfo localItemInfo2 = (XViewPager.ItemInfo)this.r.get(i1);
      int i4 = i1;
      XViewPager.ItemInfo localItemInfo1 = localItemInfo2;
      if (i2 == 0)
      {
        int i5 = localItemInfo2.b;
        i3 += 1;
        i4 = i1;
        localItemInfo1 = localItemInfo2;
        if (i5 != i3)
        {
          localItemInfo1 = this.s;
          localItemInfo1.e = (f3 + f4 + f2);
          localItemInfo1.b = i3;
          localItemInfo1.d = this.u.getPageWidth(localItemInfo1.b);
          i4 = i1 - 1;
        }
      }
      f3 = localItemInfo1.e;
      f4 = localItemInfo1.d;
      if ((i2 == 0) && (f1 < f3)) {
        return localObject;
      }
      if (f1 >= f4 + f3 + f2)
      {
        if (i4 == this.r.size() - 1) {
          return localItemInfo1;
        }
        i3 = localItemInfo1.b;
        f4 = localItemInfo1.d;
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
  
  private XViewPager.ItemInfo o()
  {
    int i1 = getClientHeight();
    float f1;
    if (i1 > 0) {
      f1 = getScrollY() / i1;
    } else {
      f1 = 0.0F;
    }
    float f2;
    if (i1 > 0) {
      f2 = this.B / i1;
    } else {
      f2 = 0.0F;
    }
    Object localObject = null;
    i1 = 0;
    int i2 = 1;
    int i3 = -1;
    float f3 = 0.0F;
    float f4 = 0.0F;
    while (i1 < this.r.size())
    {
      XViewPager.ItemInfo localItemInfo2 = (XViewPager.ItemInfo)this.r.get(i1);
      int i4 = i1;
      XViewPager.ItemInfo localItemInfo1 = localItemInfo2;
      if (i2 == 0)
      {
        int i5 = localItemInfo2.b;
        i3 += 1;
        i4 = i1;
        localItemInfo1 = localItemInfo2;
        if (i5 != i3)
        {
          localItemInfo1 = this.s;
          localItemInfo1.e = (f3 + f4 + f2);
          localItemInfo1.b = i3;
          localItemInfo1.d = this.u.getPageWidth(localItemInfo1.b);
          i4 = i1 - 1;
        }
      }
      f3 = localItemInfo1.e;
      f4 = localItemInfo1.d;
      if ((i2 == 0) && (f1 < f3)) {
        return localObject;
      }
      if (f1 >= f4 + f3 + f2)
      {
        if (i4 == this.r.size() - 1) {
          return localItemInfo1;
        }
        i3 = localItemInfo1.b;
        f4 = localItemInfo1.d;
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
  
  private void p()
  {
    this.P = false;
    this.R = false;
    VelocityTracker localVelocityTracker = this.ab;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.ab = null;
    }
  }
  
  private void setScrollState(int paramInt)
  {
    if (this.aC == paramInt) {
      return;
    }
    this.aC = paramInt;
    Object localObject = this.at;
    int i1 = 0;
    if (localObject != null)
    {
      boolean bool;
      if (paramInt != 0) {
        bool = true;
      } else {
        bool = false;
      }
      b(bool);
    }
    localObject = this.aq;
    if (localObject != null) {
      ((XViewPager.OnPageChangeListener)localObject).b(paramInt);
    }
    localObject = this.m;
    if (localObject != null)
    {
      int i2 = ((List)localObject).size();
      while (i1 < i2)
      {
        localObject = (XViewPager.OnPageChangeListener)this.m.get(i1);
        if (localObject != null) {
          ((XViewPager.OnPageChangeListener)localObject).b(paramInt);
        }
        i1 += 1;
      }
    }
  }
  
  private void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if (this.M != paramBoolean) {
      this.M = paramBoolean;
    }
  }
  
  float a(float paramFloat)
  {
    double d1 = paramFloat - 0.5F;
    Double.isNaN(d1);
    return (float)Math.sin((float)(d1 * 0.47123891676382D));
  }
  
  XViewPager.ItemInfo a(int paramInt1, int paramInt2)
  {
    XViewPager.ItemInfo localItemInfo = new XViewPager.ItemInfo();
    localItemInfo.b = paramInt1;
    localItemInfo.a = this.u.instantiateItem(this, paramInt1);
    localItemInfo.d = this.u.getPageWidth(paramInt1);
    if ((paramInt2 >= 0) && (paramInt2 < this.r.size()))
    {
      this.r.add(paramInt2, localItemInfo);
      return localItemInfo;
    }
    this.r.add(localItemInfo);
    return localItemInfo;
  }
  
  XViewPager.ItemInfo a(View paramView)
  {
    int i1 = 0;
    while (i1 < this.r.size())
    {
      XViewPager.ItemInfo localItemInfo = (XViewPager.ItemInfo)this.r.get(i1);
      if (this.u.isViewFromObject(paramView, localItemInfo.a)) {
        return localItemInfo;
      }
      i1 += 1;
    }
    return null;
  }
  
  void a()
  {
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    Context localContext = getContext();
    this.z = new Scroller(localContext, q);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(localContext);
    float f1 = localContext.getResources().getDisplayMetrics().density;
    this.b = ViewConfigurationCompat.getScaledPagingTouchSlop(localViewConfiguration);
    this.ac = ((int)(400.0F * f1));
    this.ad = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.ah = new EdgeEffectCompat(localContext);
    this.ai = new EdgeEffectCompat(localContext);
    this.aj = new EdgeEffectCompat(localContext);
    this.ak = new EdgeEffectCompat(localContext);
    this.ae = ((int)(25.0F * f1));
    this.af = ((int)(2.0F * f1));
    this.S = ((int)(f1 * 16.0F));
    ViewCompat.setAccessibilityDelegate(this, new XViewPager.MyAccessibilityDelegate(this));
    if (ViewCompat.getImportantForAccessibility(this) == 0) {
      ViewCompat.setImportantForAccessibility(this, 1);
    }
  }
  
  void a(int paramInt)
  {
    int i1 = this.v;
    int i4;
    if (i1 != paramInt)
    {
      if (i1 < paramInt) {
        i1 = 66;
      } else {
        i1 = 17;
      }
      localObject2 = b(this.v);
      this.v = paramInt;
      i4 = i1;
    }
    else
    {
      i4 = 2;
      localObject2 = null;
    }
    if (this.u == null)
    {
      l();
      return;
    }
    if (this.N)
    {
      l();
      return;
    }
    if (getWindowToken() == null) {
      return;
    }
    this.u.startUpdate(this);
    int i8 = this.O;
    int i9 = Math.max(0, this.v - i8);
    int i6 = this.u.getCount();
    int i7 = Math.min(i6 - 1, this.v + i8);
    if (i6 == this.o)
    {
      int i2 = 0;
      while (i2 < this.r.size())
      {
        localObject1 = (XViewPager.ItemInfo)this.r.get(i2);
        if (((XViewPager.ItemInfo)localObject1).b >= this.v)
        {
          if (((XViewPager.ItemInfo)localObject1).b != this.v) {
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
          localObject3 = a(this.v, i2);
        }
      }
      if (localObject3 != null)
      {
        int i3 = i2 - 1;
        if (i3 >= 0) {
          localObject1 = (XViewPager.ItemInfo)this.r.get(i3);
        } else {
          localObject1 = null;
        }
        int i10 = getClientWidth();
        float f1;
        if (i10 <= 0) {
          f1 = 0.0F;
        } else {
          f1 = 2.0F - ((XViewPager.ItemInfo)localObject3).d + getPaddingLeft() / i10;
        }
        float f3 = f1;
        if (i8 == 0) {
          f3 = 0.0F;
        }
        int i5 = this.v - 1;
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
            if (i5 != localObject4.b) {
              break label625;
            }
            f1 = f2;
            i1 = i2;
            paramInt = i3;
            localObject1 = localObject4;
            if (localObject4.c) {
              break label625;
            }
            this.r.remove(i3);
            this.u.destroyItem(this, i5, localObject4.a);
            i3 -= 1;
            i2 -= 1;
            f1 = f2;
            i1 = i2;
            paramInt = i3;
            if (i3 >= 0)
            {
              localObject1 = (XViewPager.ItemInfo)this.r.get(i3);
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
              if ((localObject4 == null) || (i5 != localObject4.b)) {
                break;
              }
              f2 += localObject4.d;
              i3 -= 1;
              f1 = f2;
              i1 = i2;
              paramInt = i3;
            } while (i3 < 0);
            localObject1 = (XViewPager.ItemInfo)this.r.get(i3);
            f1 = f2;
            i1 = i2;
            paramInt = i3;
            break;
            f2 += a(i5, i3 + 1).d;
            i2 += 1;
            f1 = f2;
            i1 = i2;
            paramInt = i3;
          } while (i3 < 0);
          localObject1 = (XViewPager.ItemInfo)this.r.get(i3);
          paramInt = i3;
          i1 = i2;
          f1 = f2;
          label625:
          i5 -= 1;
          f2 = f1;
          i2 = i1;
          i3 = paramInt;
        }
        f2 = ((XViewPager.ItemInfo)localObject3).d;
        i1 = i2 + 1;
        if (f2 < 2.0F)
        {
          if (i1 < this.r.size()) {
            localObject1 = (XViewPager.ItemInfo)this.r.get(i1);
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
          i3 = this.v;
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
              if (i3 != localObject4.b) {
                break label1009;
              }
              f1 = f2;
              paramInt = i1;
              localObject1 = localObject4;
              if (localObject4.c) {
                break label1009;
              }
              this.r.remove(i1);
              this.u.destroyItem(this, i3, localObject4.a);
              f1 = f2;
              paramInt = i1;
              if (i1 < this.r.size())
              {
                localObject1 = (XViewPager.ItemInfo)this.r.get(i1);
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
                if ((localObject4 == null) || (i3 != localObject4.b)) {
                  break;
                }
                f2 += localObject4.d;
                i1 += 1;
                f1 = f2;
                paramInt = i1;
              } while (i1 >= this.r.size());
              localObject1 = (XViewPager.ItemInfo)this.r.get(i1);
              f1 = f2;
              paramInt = i1;
              break;
              localObject1 = a(i3, i1);
              i1 += 1;
              f2 += ((XViewPager.ItemInfo)localObject1).d;
              f1 = f2;
              paramInt = i1;
            } while (i1 >= this.r.size());
            localObject1 = (XViewPager.ItemInfo)this.r.get(i1);
            paramInt = i1;
            f1 = f2;
            label1009:
            f2 = f1;
            i1 = paramInt;
          }
        }
        if (k()) {
          b((XViewPager.ItemInfo)localObject3, i2, (XViewPager.ItemInfo)localObject2);
        } else {
          a((XViewPager.ItemInfo)localObject3, i2, (XViewPager.ItemInfo)localObject2);
        }
      }
      localObject2 = this.u;
      paramInt = this.v;
      if (localObject3 != null) {
        localObject1 = ((XViewPager.ItemInfo)localObject3).a;
      } else {
        localObject1 = null;
      }
      ((PagerAdapter)localObject2).setPrimaryItem(this, paramInt, localObject1);
      this.u.finishUpdate(this);
      i1 = getChildCount();
      paramInt = 0;
      while (paramInt < i1)
      {
        localObject2 = getChildAt(paramInt);
        localObject1 = (XViewPager.LayoutParams)((View)localObject2).getLayoutParams();
        ((XViewPager.LayoutParams)localObject1).f = paramInt;
        if ((!((XViewPager.LayoutParams)localObject1).a) && (((XViewPager.LayoutParams)localObject1).c == 0.0F))
        {
          localObject2 = a((View)localObject2);
          if (localObject2 != null)
          {
            ((XViewPager.LayoutParams)localObject1).c = ((XViewPager.ItemInfo)localObject2).d;
            ((XViewPager.LayoutParams)localObject1).e = ((XViewPager.ItemInfo)localObject2).b;
          }
        }
        paramInt += 1;
      }
      l();
      if (hasFocus())
      {
        localObject1 = findFocus();
        if (localObject1 != null) {
          localObject1 = b((View)localObject1);
        } else {
          localObject1 = null;
        }
        if ((localObject1 == null) || (((XViewPager.ItemInfo)localObject1).b != this.v))
        {
          paramInt = 0;
          while (paramInt < getChildCount())
          {
            localObject1 = getChildAt(paramInt);
            localObject2 = a((View)localObject1);
            if ((localObject2 != null) && (((XViewPager.ItemInfo)localObject2).b == this.v) && (((View)localObject1).requestFocus(i4))) {
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
    ((StringBuilder)localObject2).append(this.o);
    ((StringBuilder)localObject2).append(", found: ");
    ((StringBuilder)localObject2).append(i6);
    ((StringBuilder)localObject2).append(" Pager id: ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" Pager class: ");
    ((StringBuilder)localObject2).append(getClass());
    ((StringBuilder)localObject2).append(" Problematic adapter: ");
    ((StringBuilder)localObject2).append(this.u.getClass());
    localObject1 = new IllegalStateException(((StringBuilder)localObject2).toString());
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  protected void a(int paramInt1, float paramFloat, int paramInt2)
  {
    int i1 = this.ap;
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
        if (localLayoutParams.a)
        {
          int i3 = localLayoutParams.b & 0x7;
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
    Object localObject = this.aq;
    if (localObject != null) {
      ((XViewPager.OnPageChangeListener)localObject).a(paramInt1, paramFloat, paramInt2);
    }
    localObject = this.m;
    if (localObject != null)
    {
      i2 = ((List)localObject).size();
      i1 = 0;
      while (i1 < i2)
      {
        localObject = (XViewPager.OnPageChangeListener)this.m.get(i1);
        if (localObject != null) {
          ((XViewPager.OnPageChangeListener)localObject).a(paramInt1, paramFloat, paramInt2);
        }
        i1 += 1;
      }
    }
    localObject = this.ar;
    if (localObject != null) {
      ((XViewPager.OnPageChangeListener)localObject).a(paramInt1, paramFloat, paramInt2);
    }
    if (this.at != null)
    {
      paramInt2 = getScrollX();
      i1 = getChildCount();
      paramInt1 = i6;
      while (paramInt1 < i1)
      {
        localObject = getChildAt(paramInt1);
        if (!((XViewPager.LayoutParams)((View)localObject).getLayoutParams()).a)
        {
          paramFloat = (((View)localObject).getLeft() - paramInt2) / getClientWidth();
          this.at.a((View)localObject, paramFloat);
        }
        paramInt1 += 1;
      }
    }
    this.ao = true;
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (getChildCount() == 0)
    {
      setScrollingCacheEnabled(false);
      return;
    }
    int i1 = getScrollX();
    int i2 = getScrollY();
    int i3 = paramInt1 - i1;
    paramInt2 -= i2;
    if ((i3 == 0) && (paramInt2 == 0))
    {
      a(false);
      c();
      setScrollState(0);
      return;
    }
    setScrollingCacheEnabled(true);
    setScrollState(2);
    paramInt1 = getClientWidth();
    int i4 = getClientHeight();
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
      if (k()) {
        paramInt1 = Math.round(Math.abs((f6 + f4 * f6) / paramInt1) * 1000.0F);
      } else {
        paramInt1 = Math.round(Math.abs((f3 + f5 * f3) / paramInt1) * 1000.0F);
      }
      paramInt1 *= 4;
    }
    else if (k())
    {
      f1 = this.u.getPageWidth(this.v);
      paramInt1 = (int)((Math.abs(paramInt2) / (f2 * f1 + this.B) + 1.0F) * 100.0F);
    }
    else
    {
      f2 = this.u.getPageWidth(this.v);
      paramInt1 = (int)((Math.abs(i3) / (f1 * f2 + this.B) + 1.0F) * 100.0F);
    }
    paramInt1 = Math.min(paramInt1, 600);
    paramInt3 = this.k;
    if ((paramInt3 != 2) && (paramInt3 != 3))
    {
      paramInt3 = this.j;
      if (paramInt3 > 0) {
        this.z.startScroll(i1, i2, i3, paramInt2, paramInt3);
      } else {
        this.z.startScroll(i1, i2, i3, paramInt2, paramInt1);
      }
    }
    else
    {
      this.z.startScroll(i1, i2, i3, paramInt2, paramInt1 / this.k);
    }
    ViewCompat.postInvalidateOnAnimation(this);
  }
  
  void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt, paramBoolean1, paramBoolean2, 0);
  }
  
  void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    Object localObject = this.u;
    int i2 = 0;
    if ((localObject != null) && (((PagerAdapter)localObject).getCount() > 0))
    {
      if ((!paramBoolean2) && (this.v == paramInt1) && (this.r.size() != 0))
      {
        setScrollingCacheEnabled(false);
        return;
      }
      int i1 = this.v;
      paramBoolean2 = true;
      if (paramInt1 < 0)
      {
        i1 = 0;
      }
      else
      {
        i1 = paramInt1;
        if (paramInt1 >= this.u.getCount()) {
          i1 = this.u.getCount() - 1;
        }
      }
      paramInt1 = this.O;
      int i3 = this.v;
      if ((i1 > i3 + paramInt1) || (i1 < i3 - paramInt1))
      {
        paramInt1 = 0;
        while (paramInt1 < this.r.size())
        {
          ((XViewPager.ItemInfo)this.r.get(paramInt1)).c = true;
          paramInt1 += 1;
        }
      }
      if (this.v == i1) {
        paramBoolean2 = false;
      }
      if (this.al)
      {
        this.v = i1;
        if (paramBoolean2)
        {
          localObject = this.aq;
          if (localObject != null) {
            ((XViewPager.OnPageChangeListener)localObject).a(i1);
          }
        }
        if (paramBoolean2)
        {
          localObject = this.m;
          if (localObject != null)
          {
            paramInt2 = ((List)localObject).size();
            paramInt1 = i2;
            while (paramInt1 < paramInt2)
            {
              localObject = (XViewPager.OnPageChangeListener)this.m.get(paramInt1);
              if (localObject != null) {
                ((XViewPager.OnPageChangeListener)localObject).a(i1);
              }
              paramInt1 += 1;
            }
          }
        }
        if (paramBoolean2)
        {
          localObject = this.ar;
          if (localObject != null) {
            ((XViewPager.OnPageChangeListener)localObject).a(i1);
          }
        }
        requestLayout();
        return;
      }
      a(i1);
      if (k())
      {
        b(i1, paramBoolean1, paramInt2, paramBoolean2);
        return;
      }
      a(i1, paramBoolean1, paramInt2, paramBoolean2);
      return;
    }
    setScrollingCacheEnabled(false);
  }
  
  protected void a(Canvas paramCanvas)
  {
    if ((this.B > 0) && (this.C != null) && (this.r.size() > 0) && (this.u != null))
    {
      int i3 = getScrollY();
      int i4 = getHeight();
      float f1 = this.B;
      float f5 = i4;
      float f2 = f1 / f5;
      Object localObject = this.r;
      int i2 = 0;
      localObject = (XViewPager.ItemInfo)((ArrayList)localObject).get(0);
      f1 = ((XViewPager.ItemInfo)localObject).e;
      int i5 = this.r.size();
      int i1 = ((XViewPager.ItemInfo)localObject).b;
      int i6 = ((XViewPager.ItemInfo)this.r.get(i5 - 1)).b;
      while (i1 < i6)
      {
        while ((i1 > ((XViewPager.ItemInfo)localObject).b) && (i2 < i5))
        {
          localObject = this.r;
          i2 += 1;
          localObject = (XViewPager.ItemInfo)((ArrayList)localObject).get(i2);
        }
        float f3;
        if (i1 == ((XViewPager.ItemInfo)localObject).b)
        {
          f3 = (((XViewPager.ItemInfo)localObject).e + ((XViewPager.ItemInfo)localObject).d) * f5;
          f1 = ((XViewPager.ItemInfo)localObject).e + ((XViewPager.ItemInfo)localObject).d + f2;
        }
        else
        {
          float f4 = this.u.getPageWidth(i1);
          f3 = f1 + (f4 + f2);
          f4 = (f1 + f4) * f5;
          f1 = f3;
          f3 = f4;
        }
        int i7 = this.B;
        if (i7 + f3 > i3)
        {
          this.C.setBounds(this.F, (int)f3, this.G, (int)(i7 + f3 + 0.5F));
          this.C.draw(paramCanvas);
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
    if (this.m == null) {
      this.m = new ArrayList();
    }
    this.m.add(paramOnPageChangeListener);
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
        if (localLayoutParams.a)
        {
          paramInt3 = localLayoutParams.b & 0x7;
          i5 = localLayoutParams.b & 0x70;
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
        if (!localLayoutParams.a)
        {
          XViewPager.ItemInfo localItemInfo = a(localView);
          if (localItemInfo != null)
          {
            float f1 = i2;
            i5 = (int)(localItemInfo.e * f1) + paramInt1;
            if (localLayoutParams.d)
            {
              localLayoutParams.d = false;
              localView.measure(View.MeasureSpec.makeMeasureSpec(i9 - paramInt2 - i1, 1073741824), View.MeasureSpec.makeMeasureSpec((int)(f1 * localLayoutParams.c), 1073741824));
            }
            localView.layout(paramInt2, i5, localView.getMeasuredWidth() + paramInt2, localView.getMeasuredHeight() + i5);
          }
        }
      }
      i4 += 1;
    }
    this.D = paramInt1;
    this.F = paramInt2;
    this.E = (i10 - paramInt4);
    this.G = (i9 - i1);
    this.ap = i3;
    if ((!this.al) && (this.am)) {
      break label640;
    }
    b(this.v, false, 0, false);
    label640:
    this.al = false;
    this.am = true;
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
          return c(66);
        case 21: 
          return c(17);
        case 20: 
          return c(130);
        case 19: 
          return c(33);
        }
      }
      else if (Build.VERSION.SDK_INT >= 11)
      {
        if (KeyEventCompat.hasNoModifiers(paramKeyEvent)) {
          return c(2);
        }
        if (KeyEventCompat.hasModifiers(paramKeyEvent, 1)) {
          return c(1);
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
          if ((localItemInfo != null) && (localItemInfo.b == this.v)) {
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
        if ((localItemInfo != null) && (localItemInfo.b == this.v)) {
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
    paramLayoutParams.a |= paramView instanceof XViewPager.Decor;
    if (this.L)
    {
      if (!paramLayoutParams.a)
      {
        paramLayoutParams.d = true;
        addViewInLayout(paramView, paramInt, localLayoutParams);
        return;
      }
      throw new IllegalStateException("Cannot add pager decor view during layout");
    }
    super.addView(paramView, paramInt, localLayoutParams);
  }
  
  XViewPager.ItemInfo b(int paramInt)
  {
    int i1 = 0;
    while (i1 < this.r.size())
    {
      XViewPager.ItemInfo localItemInfo = (XViewPager.ItemInfo)this.r.get(i1);
      if (localItemInfo.b == paramInt) {
        return localItemInfo;
      }
      i1 += 1;
    }
    return null;
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
    int i9 = this.u.getCount();
    this.o = i9;
    if ((this.r.size() < this.O * 2 + 1) && (this.r.size() < i9)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2 = this.v;
    int i6 = i1;
    int i1 = i2;
    int i3 = 0;
    i2 = 0;
    Object localObject;
    while (i3 < this.r.size())
    {
      localObject = (XViewPager.ItemInfo)this.r.get(i3);
      int i8 = this.u.getItemPosition(((XViewPager.ItemInfo)localObject).a);
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
          this.r.remove(i3);
          i5 = i3 - 1;
          i4 = i2;
          if (i2 == 0)
          {
            this.u.startUpdate(this);
            i4 = 1;
          }
          this.u.destroyItem(this, ((XViewPager.ItemInfo)localObject).b, ((XViewPager.ItemInfo)localObject).a);
          i3 = i5;
          i2 = i4;
          if (this.v == ((XViewPager.ItemInfo)localObject).b)
          {
            i1 = Math.max(0, Math.min(this.v, i9 - 1));
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
          if (((XViewPager.ItemInfo)localObject).b == i8) {
            break;
          }
          if (((XViewPager.ItemInfo)localObject).b == this.v) {
            i1 = i8;
          }
          ((XViewPager.ItemInfo)localObject).b = i8;
        }
      }
      i3 = i4 + 1;
      i2 = i5;
      i1 = i7;
    }
    if (i2 != 0) {
      this.u.finishUpdate(this);
    }
    Collections.sort(this.r, p);
    if (i6 != 0)
    {
      i3 = getChildCount();
      i2 = 0;
      while (i2 < i3)
      {
        localObject = (XViewPager.LayoutParams)getChildAt(i2).getLayoutParams();
        if (!((XViewPager.LayoutParams)localObject).a) {
          ((XViewPager.LayoutParams)localObject).c = 0.0F;
        }
        i2 += 1;
      }
      a(i1, false, true);
      requestLayout();
    }
  }
  
  protected void b(int paramInt1, float paramFloat, int paramInt2)
  {
    int i1 = this.ap;
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
        if (localLayoutParams.a)
        {
          int i3 = localLayoutParams.b & 0x70;
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
    Object localObject = this.aq;
    if (localObject != null) {
      ((XViewPager.OnPageChangeListener)localObject).a(paramInt1, paramFloat, paramInt2);
    }
    localObject = this.m;
    if (localObject != null)
    {
      i2 = ((List)localObject).size();
      i1 = 0;
      while (i1 < i2)
      {
        localObject = (XViewPager.OnPageChangeListener)this.m.get(i1);
        if (localObject != null) {
          ((XViewPager.OnPageChangeListener)localObject).a(paramInt1, paramFloat, paramInt2);
        }
        i1 += 1;
      }
    }
    localObject = this.ar;
    if (localObject != null) {
      ((XViewPager.OnPageChangeListener)localObject).a(paramInt1, paramFloat, paramInt2);
    }
    if (this.g != null)
    {
      paramInt2 = getScrollY();
      i1 = getChildCount();
      paramInt1 = i6;
      while (paramInt1 < i1)
      {
        localObject = getChildAt(paramInt1);
        if (!((XViewPager.LayoutParams)((View)localObject).getLayoutParams()).a)
        {
          paramFloat = (((View)localObject).getTop() - paramInt2) / getClientHeight();
          this.g.a((View)localObject, paramFloat);
        }
        paramInt1 += 1;
      }
    }
    this.ao = true;
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
  
  void c()
  {
    a(this.v);
  }
  
  public boolean c(int paramInt)
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
          localObject1 = this.a;
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
        i1 = a(this.t, localView).left;
        i2 = a(this.t, (View)localObject1).left;
        if ((localObject1 != null) && (i1 >= i2)) {
          bool = d();
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
        i1 = a(this.t, localView).left;
        i2 = a(this.t, (View)localObject1).left;
        if ((localObject1 != null) && (i1 <= i2))
        {
          bool = e();
        }
        else
        {
          bool = localView.requestFocus();
          continue;
          if ((paramInt != 17) && (paramInt != 1))
          {
            if ((paramInt == 66) || (paramInt == 2)) {
              bool = e();
            }
          }
          else {
            bool = d();
          }
        }
      }
    }
    if (bool) {
      playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
    }
    return bool;
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    PagerAdapter localPagerAdapter = this.u;
    boolean bool3 = false;
    boolean bool2 = false;
    if (localPagerAdapter == null) {
      return false;
    }
    boolean bool1 = bool3;
    if (g())
    {
      int i1 = getClientWidth();
      int i2 = getScrollX();
      if (paramInt < 0)
      {
        bool1 = bool2;
        if (i2 > (int)(i1 * this.H)) {
          bool1 = true;
        }
        return bool1;
      }
      bool1 = bool3;
      if (paramInt > 0)
      {
        bool1 = bool3;
        if (i2 < (int)(i1 * this.I)) {
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
    m();
    if ((!this.z.isFinished()) && (this.z.computeScrollOffset()))
    {
      int i1 = getScrollX();
      int i2 = getScrollY();
      int i3 = this.z.getCurrX();
      int i4 = this.z.getCurrY();
      if ((i1 != i3) || (i2 != i4))
      {
        scrollTo(i3, i4);
        if (Gravity.isHorizontal(this.Q))
        {
          if (!d(i3))
          {
            this.z.abortAnimation();
            scrollTo(0, i4);
          }
        }
        else if (!e(i4))
        {
          this.z.abortAnimation();
          scrollTo(i3, 0);
        }
      }
      ViewCompat.postInvalidateOnAnimation(this);
      return;
    }
    if (this.aC == 0) {
      this.Q = 0;
    }
    a(true);
  }
  
  boolean d()
  {
    int i1 = this.v;
    if (i1 > 0)
    {
      setCurrentItem(i1 - 1, true);
      return true;
    }
    return false;
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
        if ((localItemInfo != null) && (localItemInfo.b == this.v) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent))) {
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
        PagerAdapter localPagerAdapter = this.u;
        if ((localPagerAdapter != null) && (localPagerAdapter.getCount() > 1)) {}
      }
      else
      {
        this.ah.finish();
        this.ai.finish();
        this.aj.finish();
        this.ak.finish();
        break label290;
      }
    }
    int i2;
    if (!this.ah.isFinished())
    {
      i3 = paramCanvas.save();
      i1 = getHeight() - getPaddingTop() - getPaddingBottom();
      i4 = getWidth();
      paramCanvas.rotate(270.0F);
      paramCanvas.translate(-i1 + getPaddingTop(), this.H * i4);
      this.ah.setSize(i1, i4);
      i2 = false | this.ah.draw(paramCanvas);
      paramCanvas.restoreToCount(i3);
    }
    i3 = i2;
    boolean bool;
    if (!this.ai.isFinished())
    {
      i4 = paramCanvas.save();
      i3 = getWidth();
      int i5 = getHeight();
      int i6 = getPaddingTop();
      int i7 = getPaddingBottom();
      paramCanvas.rotate(90.0F);
      paramCanvas.translate(-getPaddingTop(), -(this.I + 1.0F) * i3);
      this.ai.setSize(i5 - i6 - i7, i3);
      bool = i2 | this.ai.draw(paramCanvas);
      paramCanvas.restoreToCount(i4);
    }
    if (this.aj.isFinished())
    {
      if (this.ai.isFinished())
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
    Drawable localDrawable = this.C;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  boolean e()
  {
    PagerAdapter localPagerAdapter = this.u;
    if ((localPagerAdapter != null) && (this.v < localPagerAdapter.getCount() - 1))
    {
      setCurrentItem(this.v + 1, true);
      return true;
    }
    return false;
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
  
  public PagerAdapter getAdapter()
  {
    return this.u;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      localArrayList = this.aw;
      if ((localArrayList == null) || (localArrayList.size() != getChildCount())) {
        l();
      }
    }
    int i1;
    if (this.av == 2) {
      i1 = paramInt1 - 1 - paramInt2;
    } else {
      i1 = paramInt2;
    }
    ArrayList localArrayList = this.aw;
    if (localArrayList != null) {
      return ((XViewPager.LayoutParams)((View)localArrayList.get(i1)).getLayoutParams()).f;
    }
    return super.getChildDrawingOrder(paramInt1, paramInt2);
  }
  
  public int getCurrentItem()
  {
    return this.v;
  }
  
  public int getOffscreenPageLimit()
  {
    return this.O;
  }
  
  public List<XViewPager.OnPageChangeListener> getOnPageChangeListeners()
  {
    List localList = this.m;
    if (localList == null) {
      return Collections.emptyList();
    }
    return Collections.unmodifiableList(localList);
  }
  
  public int getPageMargin()
  {
    return this.B;
  }
  
  public XViewPager.PageTransformer getPageTransformer()
  {
    return this.at;
  }
  
  public int getScrollState()
  {
    return this.aC;
  }
  
  public int getmDraggedDirection()
  {
    return this.Q;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.al = true;
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.aB);
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (k())
    {
      a(paramCanvas);
      return;
    }
    if ((this.B > 0) && (this.C != null) && (this.r.size() > 0) && (this.u != null))
    {
      int i3 = getScrollX();
      int i4 = getWidth();
      float f1 = this.B;
      float f5 = i4;
      float f2 = f1 / f5;
      Object localObject = this.r;
      int i2 = 0;
      localObject = (XViewPager.ItemInfo)((ArrayList)localObject).get(0);
      f1 = ((XViewPager.ItemInfo)localObject).e;
      int i5 = this.r.size();
      int i1 = ((XViewPager.ItemInfo)localObject).b;
      int i6 = ((XViewPager.ItemInfo)this.r.get(i5 - 1)).b;
      while (i1 < i6)
      {
        while ((i1 > ((XViewPager.ItemInfo)localObject).b) && (i2 < i5))
        {
          localObject = this.r;
          i2 += 1;
          localObject = (XViewPager.ItemInfo)((ArrayList)localObject).get(i2);
        }
        float f3;
        if (i1 == ((XViewPager.ItemInfo)localObject).b)
        {
          f3 = (((XViewPager.ItemInfo)localObject).e + ((XViewPager.ItemInfo)localObject).d) * f5;
          f1 = ((XViewPager.ItemInfo)localObject).e + ((XViewPager.ItemInfo)localObject).d + f2;
        }
        else
        {
          float f4 = this.u.getPageWidth(i1);
          f3 = f1 + (f4 + f2);
          f4 = (f1 + f4) * f5;
          f1 = f3;
          f3 = f4;
        }
        int i7 = this.B;
        if (i7 + f3 > i3)
        {
          this.C.setBounds((int)f3, this.D, (int)(i7 + f3 + 0.5F), this.E);
          this.C.draw(paramCanvas);
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
        if (this.P) {
          return true;
        }
        if (this.R) {
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
          i2 = this.aa;
          if (i2 != -1)
          {
            i2 = MotionEventCompat.findPointerIndex(paramMotionEvent, i2);
            float f2 = MotionEventCompat.getX(paramMotionEvent, i2);
            f1 = f2 - this.U;
            float f4 = Math.abs(f1);
            float f3 = MotionEventCompat.getY(paramMotionEvent, i2);
            float f5 = f3 - this.V;
            float f6 = Math.abs(f5);
            if (((h()) || ((this.c) && (f5 < 0.0F)) || ((this.d) && (f5 > 0.0F))) && (f5 != 0.0F) && (!b(this.V, f5)) && (b(this, false, (int)f5, (int)f2, (int)f3)))
            {
              this.U = f2;
              this.V = f3;
              this.R = true;
              this.Q = 0;
              return false;
            }
            if (((g()) || ((this.e) && (f1 < 0.0F)) || ((this.f) && (f1 > 0.0F))) && (f1 != 0.0F) && (!a(this.U, f1)) && (a(this, false, (int)f1, (int)f2, (int)f3)))
            {
              this.U = f2;
              this.V = f3;
              this.R = true;
              this.Q = 0;
              return false;
            }
            if (((h()) || ((this.c) && (f5 < 0.0F)) || ((this.d) && (f5 > 0.0F))) && (!Gravity.isHorizontal(this.Q)) && (f6 > this.b) && (f6 * 0.6F > f4))
            {
              this.P = true;
              if (f5 > 0.0F) {
                i1 = 80;
              } else {
                i1 = 48;
              }
              this.Q = i1;
              c(true);
              setScrollState(1);
              this.U = f2;
              if (f5 > 0.0F) {
                f1 = this.Z + this.b;
              } else {
                f1 = this.Z - this.b;
              }
              this.V = f1;
              setScrollingCacheEnabled(true);
            }
            else if (((g()) || ((this.e) && (f1 < 0.0F)) || ((this.f) && (f1 > 0.0F))) && (!Gravity.isVertical(this.Q)) && (f4 > this.b) && (0.6F * f4 > f6))
            {
              this.P = true;
              if (f1 > 0.0F) {
                i1 = 5;
              }
              this.Q = i1;
              c(true);
              setScrollState(1);
              if (f1 > 0.0F) {
                f1 = this.W + this.b;
              } else {
                f1 = this.W - this.b;
              }
              this.U = f1;
              this.V = f3;
              setScrollingCacheEnabled(true);
            }
            else if (((!h()) || ((this.c) && (f5 > 0.0F)) || ((this.d) && (f5 < 0.0F))) && (f6 > this.b))
            {
              this.R = true;
            }
            else if (((!g()) || ((this.e) && (f1 > 0.0F)) || ((this.f) && (f1 < 0.0F))) && (f4 > this.b))
            {
              this.R = true;
            }
            if (this.P) {
              if (Gravity.isHorizontal(this.Q))
              {
                if (b(f2)) {
                  ViewCompat.postInvalidateOnAnimation(this);
                }
              }
              else if (c(f3)) {
                ViewCompat.postInvalidateOnAnimation(this);
              }
            }
          }
        }
      }
      else
      {
        f1 = paramMotionEvent.getX();
        this.W = f1;
        this.U = f1;
        f1 = paramMotionEvent.getY();
        this.Z = f1;
        this.V = f1;
        this.aa = MotionEventCompat.getPointerId(paramMotionEvent, 0);
        this.R = false;
        this.z.computeScrollOffset();
        if ((Gravity.isHorizontal(this.Q)) && (this.aC == 2) && (Math.abs(this.z.getFinalX() - this.z.getCurrX()) > this.af))
        {
          this.z.abortAnimation();
          this.N = false;
          c();
          this.P = true;
          c(true);
          setScrollState(1);
        }
        else if ((Gravity.isVertical(this.Q)) && (this.aC == 2) && (Math.abs(this.z.getFinalY() - this.z.getCurrY()) > this.af))
        {
          this.z.abortAnimation();
          this.N = false;
          c();
          this.P = true;
          c(true);
          setScrollState(1);
        }
        else
        {
          a(false);
          this.P = false;
        }
      }
      if (this.ab == null) {
        this.ab = VelocityTracker.obtain();
      }
      this.ab.addMovement(paramMotionEvent);
      return this.P;
    }
    this.P = false;
    this.R = false;
    this.aa = -1;
    paramMotionEvent = this.ab;
    if (paramMotionEvent != null)
    {
      paramMotionEvent.recycle();
      this.ab = null;
    }
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (k())
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
        if (localLayoutParams.a)
        {
          paramInt3 = localLayoutParams.b & 0x7;
          i5 = localLayoutParams.b & 0x70;
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
        if (!localLayoutParams.a)
        {
          XViewPager.ItemInfo localItemInfo = a(localView);
          if (localItemInfo != null)
          {
            float f1 = i9 - paramInt2 - i2;
            i1 = (int)(localItemInfo.e * f1) + paramInt2;
            if (localLayoutParams.d)
            {
              localLayoutParams.d = false;
              localView.measure(View.MeasureSpec.makeMeasureSpec((int)(f1 * localLayoutParams.c), 1073741824), View.MeasureSpec.makeMeasureSpec(i10 - paramInt1 - paramInt4, 1073741824));
            }
            localView.layout(i1, paramInt1, localView.getMeasuredWidth() + i1, localView.getMeasuredHeight() + paramInt1);
          }
        }
      }
      paramInt3 += 1;
    }
    this.D = paramInt1;
    this.F = paramInt2;
    this.E = (i10 - paramInt4);
    this.G = (i9 - i2);
    this.ap = i3;
    if ((!this.al) && (!this.am)) {
      break label647;
    }
    a(this.v, false, 0, false);
    label647:
    this.al = false;
    this.am = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    paramInt1 = getMeasuredWidth();
    this.T = Math.min(paramInt1 / 10, this.S);
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
          if (localLayoutParams.a)
          {
            i1 = localLayoutParams.b & 0x7;
            i2 = localLayoutParams.b & 0x70;
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
    this.J = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
    this.K = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
    this.L = true;
    c();
    paramInt2 = 0;
    this.L = false;
    i1 = getChildCount();
    while (paramInt2 < i1)
    {
      localView = getChildAt(paramInt2);
      if ((localView != null) && (localView.getVisibility() != 8))
      {
        localLayoutParams = (XViewPager.LayoutParams)localView.getLayoutParams();
        if ((localLayoutParams != null) && (!localLayoutParams.a)) {
          localView.measure(View.MeasureSpec.makeMeasureSpec((int)(paramInt1 * localLayoutParams.c), 1073741824), this.K);
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
        if ((localItemInfo != null) && (localItemInfo.b == this.v) && (localView.requestFocus(paramInt, paramRect))) {
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
    PagerAdapter localPagerAdapter = this.u;
    if (localPagerAdapter != null)
    {
      localPagerAdapter.restoreState(paramParcelable.b, paramParcelable.c);
      a(paramParcelable.a, false, true);
      return;
    }
    this.w = paramParcelable.a;
    this.x = paramParcelable.b;
    this.y = paramParcelable.c;
  }
  
  public Parcelable onSaveInstanceState()
  {
    XViewPager.SavedState localSavedState = new XViewPager.SavedState(super.onSaveInstanceState());
    localSavedState.a = this.v;
    PagerAdapter localPagerAdapter = this.u;
    if (localPagerAdapter != null) {
      localSavedState.b = localPagerAdapter.saveState();
    }
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3)
    {
      int i1 = this.B;
      a(paramInt1, paramInt3, i1, i1);
    }
    if (paramInt2 != paramInt4)
    {
      paramInt1 = this.B;
      b(paramInt2, paramInt4, paramInt1, paramInt1);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.ag) {
      return true;
    }
    int i1 = paramMotionEvent.getAction();
    int i2 = 0;
    if ((i1 == 0) && (paramMotionEvent.getEdgeFlags() != 0)) {
      return false;
    }
    Object localObject = this.u;
    if (localObject != null)
    {
      if (((PagerAdapter)localObject).getCount() == 0) {
        return false;
      }
      if (this.ab == null) {
        this.ab = VelocityTracker.obtain();
      }
      this.ab.addMovement(paramMotionEvent);
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
                this.U = MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.aa));
                this.V = MotionEventCompat.getY(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.aa));
                i1 = i2;
                break label1282;
              }
              i1 = MotionEventCompat.getActionIndex(paramMotionEvent);
              f1 = MotionEventCompat.getX(paramMotionEvent, i1);
              f2 = MotionEventCompat.getY(paramMotionEvent, i1);
              this.U = f1;
              this.V = f2;
              this.aa = MotionEventCompat.getPointerId(paramMotionEvent, i1);
              i1 = i2;
              break label1282;
            }
            i1 = i2;
            if (!this.P) {
              break label1282;
            }
            if (Gravity.isHorizontal(this.Q)) {
              a(this.v, true, 0, false);
            } else {
              b(this.v, true, 0, false);
            }
            this.aa = -1;
            p();
            if (Gravity.isHorizontal(this.Q))
            {
              bool2 = this.ah.onRelease();
              bool1 = this.ai.onRelease();
            }
            else
            {
              bool2 = this.aj.onRelease();
              bool1 = this.ak.onRelease();
            }
          }
          else
          {
            if (!this.P)
            {
              i3 = MotionEventCompat.findPointerIndex(paramMotionEvent, this.aa);
              f1 = MotionEventCompat.getX(paramMotionEvent, i3);
              float f3 = Math.abs(f1 - this.U);
              f2 = MotionEventCompat.getY(paramMotionEvent, i3);
              float f4 = Math.abs(f2 - this.V);
              if (((h()) || ((this.c) && (f2 < this.V)) || ((this.d) && (f2 > this.V))) && ((!this.P) || (!Gravity.isHorizontal(this.Q))) && (f4 > this.b) && (f4 > f3))
              {
                this.P = true;
                if (f2 < this.V) {
                  i1 = 48;
                } else {
                  i1 = 80;
                }
                this.Q = i1;
                c(true);
                this.U = f1;
                f1 = this.Z;
                if (f2 - f1 > 0.0F) {
                  f1 += this.b;
                } else {
                  f1 -= this.b;
                }
                this.V = f1;
                setScrollState(1);
                setScrollingCacheEnabled(true);
                localObject = getParent();
                if (localObject != null) {
                  ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
                }
              }
              else if (((g()) || ((this.e) && (f1 < this.U)) || ((this.f) && (f1 > this.U))) && ((!this.P) || (!Gravity.isVertical(this.Q))) && (f3 > this.b) && (f3 > f4))
              {
                this.P = true;
                if (f1 < this.U) {
                  i1 = 3;
                }
                this.Q = i1;
                c(true);
                f3 = this.W;
                if (f1 - f3 > 0.0F) {
                  f1 = f3 + this.b;
                } else {
                  f1 = f3 - this.b;
                }
                this.U = f1;
                this.V = f2;
                setScrollState(1);
                setScrollingCacheEnabled(true);
                localObject = getParent();
                if (localObject != null) {
                  ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
                }
              }
            }
            i1 = i2;
            if (!this.P) {
              break label1282;
            }
            if (Gravity.isHorizontal(this.Q)) {
              bool1 = b(MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.aa)));
            } else {
              bool1 = c(MotionEventCompat.getY(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.aa)));
            }
            i1 = false | bool1;
            break label1282;
          }
        }
        else
        {
          i1 = i2;
          if (!this.P) {
            break label1282;
          }
          if (Gravity.isHorizontal(this.Q))
          {
            localObject = this.ab;
            ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.ad);
            i3 = (int)VelocityTrackerCompat.getXVelocity((VelocityTracker)localObject, this.aa);
            this.N = true;
            i1 = getClientWidth();
            i2 = getScrollX();
            localObject = n();
            i2 = a(((XViewPager.ItemInfo)localObject).b, (i2 / i1 - ((XViewPager.ItemInfo)localObject).e) / ((XViewPager.ItemInfo)localObject).d, i3, (int)(MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.aa)) - this.W));
            paramMotionEvent = this.ay;
            i1 = i2;
            if (paramMotionEvent != null)
            {
              i1 = i2;
              if (!paramMotionEvent.a()) {
                if ((this.Q == 3) && (i2 < getCurrentItem()))
                {
                  i1 = getCurrentItem();
                }
                else
                {
                  i1 = i2;
                  if (this.Q == 5)
                  {
                    i1 = i2;
                    if (i2 > getCurrentItem()) {
                      i1 = getCurrentItem();
                    }
                  }
                }
              }
            }
            a(i1, true, true, i3);
            this.aa = -1;
            p();
            bool2 = this.ah.onRelease();
            bool1 = this.ai.onRelease();
          }
          else
          {
            i1 = i2;
            if (!Gravity.isVertical(this.Q)) {
              break label1282;
            }
            localObject = this.ab;
            ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.ad);
            i1 = (int)VelocityTrackerCompat.getYVelocity((VelocityTracker)localObject, this.aa);
            this.N = true;
            i2 = getClientHeight();
            i3 = getScrollY();
            localObject = n();
            a(a(((XViewPager.ItemInfo)localObject).b, (i3 / i2 - ((XViewPager.ItemInfo)localObject).e) / ((XViewPager.ItemInfo)localObject).d, i1, (int)(MotionEventCompat.getY(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.aa)) - this.Z)), true, true, i1);
            this.aa = -1;
            p();
            bool2 = this.aj.onRelease();
            bool1 = this.ak.onRelease();
          }
        }
        i1 = bool2 | bool1;
      }
      else
      {
        this.z.abortAnimation();
        this.N = false;
        c();
        f1 = paramMotionEvent.getX();
        this.W = f1;
        this.U = f1;
        f1 = paramMotionEvent.getY();
        this.Z = f1;
        this.V = f1;
        this.aa = MotionEventCompat.getPointerId(paramMotionEvent, 0);
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
    XViewPager.OnVisibilityChangeListener localOnVisibilityChangeListener = this.l;
    if (localOnVisibilityChangeListener != null) {
      localOnVisibilityChangeListener.a(paramView, paramInt);
    }
  }
  
  public void removeView(View paramView)
  {
    if (this.L)
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
    Object localObject = this.u;
    if (localObject != null)
    {
      ((PagerAdapter)localObject).unregisterDataSetObserver(this.A);
      this.u.startUpdate(this);
      int i1 = 0;
      while (i1 < this.r.size())
      {
        localObject = (XViewPager.ItemInfo)this.r.get(i1);
        this.u.destroyItem(this, ((XViewPager.ItemInfo)localObject).b, ((XViewPager.ItemInfo)localObject).a);
        i1 += 1;
      }
      this.u.finishUpdate(this);
      this.r.clear();
      i();
      this.v = 0;
      scrollTo(0, 0);
    }
    localObject = this.u;
    this.u = paramPagerAdapter;
    this.o = 0;
    if (this.u != null)
    {
      if (this.A == null) {
        this.A = new XViewPager.PagerObserver(this, null);
      }
      this.u.registerDataSetObserver(this.A);
      this.N = false;
      boolean bool = this.al;
      this.al = true;
      this.o = this.u.getCount();
      if (this.w >= 0)
      {
        this.u.restoreState(this.x, this.y);
        a(this.w, false, true);
        this.w = -1;
        this.x = null;
        this.y = null;
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
    XViewPager.OnAdapterChangeListener localOnAdapterChangeListener = this.as;
    if ((localOnAdapterChangeListener != null) && (localObject != paramPagerAdapter)) {
      localOnAdapterChangeListener.a((PagerAdapter)localObject, paramPagerAdapter);
    }
  }
  
  void setChildrenDrawingOrderEnabledCompat(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 7)
    {
      if (this.au == null) {
        try
        {
          this.au = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[] { Boolean.TYPE });
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          SLog.c(this.a, "Can't find setChildrenDrawingOrderEnabled", localNoSuchMethodException);
        }
      }
      try
      {
        this.au.invoke(this, new Object[] { Boolean.valueOf(paramBoolean) });
        return;
      }
      catch (Exception localException)
      {
        SLog.c(this.a, "Error changing children drawing order", localException);
      }
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.N = false;
    a(paramInt, this.al ^ true, false);
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    this.N = false;
    a(paramInt, paramBoolean, false);
  }
  
  public void setCurrentItemWithTransform(int paramInt1, int paramInt2)
  {
    this.az = true;
    this.aA = paramInt2;
    setCurrentItem(paramInt1, false);
    this.az = false;
  }
  
  public void setDistanceAndVelocityThreshold(int paramInt1, int paramInt2)
  {
    this.ae = paramInt1;
    this.ac = paramInt2;
  }
  
  public void setEnableOverScroll(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setEnableScrollDirection(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.c = paramBoolean1;
    this.d = paramBoolean2;
    this.e = paramBoolean3;
    this.f = paramBoolean4;
  }
  
  public void setOffscreenPageLimit(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 1)
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Requested offscreen page limit ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" too small; defaulting to ");
      localStringBuilder.append(1);
      SLog.d(str, localStringBuilder.toString());
      i1 = 1;
    }
    if (i1 != this.O)
    {
      this.O = i1;
      c();
    }
  }
  
  void setOnAdapterChangeListener(XViewPager.OnAdapterChangeListener paramOnAdapterChangeListener)
  {
    this.as = paramOnAdapterChangeListener;
  }
  
  public void setOnDragStatusChangedListener(XViewPager.OnDragStatusChangedListener paramOnDragStatusChangedListener)
  {
    this.ay = paramOnDragStatusChangedListener;
  }
  
  public void setOnPageChangeListener(XViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.aq = paramOnPageChangeListener;
  }
  
  public void setOnVisibilityChangeListener(@Nullable XViewPager.OnVisibilityChangeListener paramOnVisibilityChangeListener)
  {
    this.l = paramOnVisibilityChangeListener;
  }
  
  public void setPageMargin(int paramInt)
  {
    int i1 = this.B;
    this.B = paramInt;
    int i2;
    if (h())
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
    this.C = paramDrawable;
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
    this.j = paramInt;
  }
  
  public void setPageScrollDurationDivisor(int paramInt)
  {
    this.k = paramInt;
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
      if (this.at != null) {
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
      this.at = paramPageTransformer;
      setChildrenDrawingOrderEnabledCompat(bool1);
      if (bool1)
      {
        if (paramBoolean) {
          i2 = 2;
        }
        this.av = i2;
      }
      else
      {
        this.av = 0;
      }
      if (i1 != 0) {
        c();
      }
    }
  }
  
  public void setPageTurningThreshold(float paramFloat)
  {
    if ((paramFloat > 0.0F) && (paramFloat < 1.0F)) {
      this.i = paramFloat;
    }
  }
  
  public void setScroller(Scroller paramScroller)
  {
    this.z = paramScroller;
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.C);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager
 * JD-Core Version:    0.7.0.1
 */