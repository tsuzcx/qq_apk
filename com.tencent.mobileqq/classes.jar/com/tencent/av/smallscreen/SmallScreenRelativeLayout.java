package com.tencent.av.smallscreen;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.tencent.av.AVLog;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;

public class SmallScreenRelativeLayout
  extends RelativeLayout
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
{
  final int jdField_a_of_type_Int;
  ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  RectF jdField_a_of_type_AndroidGraphicsRectF;
  Display jdField_a_of_type_AndroidViewDisplay;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  SmallScreenRelativeLayout.FloatListener jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener;
  SmallScreenRelativeLayout.SmallScreenOrientationEventListener jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$SmallScreenOrientationEventListener = null;
  boolean jdField_a_of_type_Boolean = false;
  final int jdField_b_of_type_Int;
  ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int;
  boolean jdField_d_of_type_Boolean = true;
  final int e;
  final int f;
  int g;
  final int h;
  int i = -1;
  int j = -1;
  int k = -1;
  int l = -1;
  int m = -1;
  int n = -1;
  int o = 6;
  int p = 0;
  int q = 0;
  int r = 0;
  int s = 7;
  
  public SmallScreenRelativeLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SmallScreenRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SmallScreenRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenRelativeLayout", 2, "SmallScreenRelativeLayout");
    }
    this.jdField_b_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.e = getResources().getDimensionPixelSize(2131297967);
    this.f = getResources().getDimensionPixelSize(2131297968);
    this.jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131297977);
    this.g = getResources().getDimensionPixelSize(2131299168);
    this.h = getResources().getDimensionPixelSize(2131297963);
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(200L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(this);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(this);
    this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(400L);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addListener(this);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(this);
    this.jdField_a_of_type_AndroidViewDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    this.p = b();
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$SmallScreenOrientationEventListener = new SmallScreenRelativeLayout.SmallScreenOrientationEventListener(this, getContext(), 2);
  }
  
  private int b()
  {
    try
    {
      int i1 = this.jdField_a_of_type_AndroidViewDisplay.getRotation();
      return i1;
    }
    catch (Exception localException)
    {
      AVLog.printErrorLog("SmallScreenRelativeLayout", localException.getMessage());
    }
    return 0;
  }
  
  public int a()
  {
    if ((this.q != 0) && (this.r != 0))
    {
      SmallScreenRelativeLayout.FloatListener localFloatListener = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener;
      int i1;
      int i2;
      if (localFloatListener != null)
      {
        i1 = localFloatListener.a(this);
        i2 = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener.b(this);
      }
      else
      {
        i1 = getLeft();
        i2 = getTop();
      }
      this.s = a(i1, i2, i1, i2);
    }
    return this.s;
  }
  
  int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = 1;
    paramInt2 = 2147483647;
    int i2 = 0;
    while (paramInt1 < 14)
    {
      Point localPoint = a(paramInt1);
      int i3 = (paramInt3 - localPoint.x) * (paramInt3 - localPoint.x) + (paramInt4 - localPoint.y) * (paramInt4 - localPoint.y);
      int i1 = paramInt2;
      if (i3 < paramInt2)
      {
        i2 = paramInt1;
        i1 = i3;
      }
      paramInt1 += 1;
      paramInt2 = i1;
    }
    return i2;
  }
  
  int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i2 = 1;
    int i1;
    if ((paramInt1 < paramInt2) && (paramInt3 > paramInt4)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((paramInt1 > paramInt2) && (paramInt3 < paramInt4)) {
      paramInt2 = i2;
    } else {
      paramInt2 = 0;
    }
    if (i1 == 0)
    {
      paramInt1 = paramInt5;
      if (paramInt2 == 0) {}
    }
    else
    {
      SharedPreferences localSharedPreferences = SharedPreUtils.a(getContext());
      SharedPreferences.Editor localEditor = localSharedPreferences.edit();
      if (i1 != 0)
      {
        paramInt1 = localSharedPreferences.getInt("small_window_position_land", 12);
      }
      else
      {
        paramInt1 = paramInt5;
        if (paramInt2 != 0)
        {
          localEditor.putInt("small_window_position_land", paramInt5);
          paramInt1 = 7;
        }
      }
      localEditor.commit();
    }
    return paramInt1;
  }
  
  Point a(int paramInt)
  {
    Rect localRect = a();
    Point localPoint = new Point();
    switch (paramInt)
    {
    default: 
      return localPoint;
    case 13: 
      localPoint.x = (localRect.centerX() * 3 / 2);
      localPoint.y = localRect.top;
      return localPoint;
    case 12: 
      localPoint.x = localRect.centerX();
      localPoint.y = localRect.top;
      return localPoint;
    case 11: 
      localPoint.x = (localRect.centerX() / 2);
      localPoint.y = localRect.top;
      return localPoint;
    case 10: 
      localPoint.x = localRect.right;
      localPoint.y = localRect.bottom;
      return localPoint;
    case 9: 
      localPoint.x = localRect.right;
      localPoint.y = (localRect.bottom - this.h);
      return localPoint;
    case 8: 
      localPoint.x = localRect.right;
      localPoint.y = localRect.centerY();
      return localPoint;
    case 7: 
      localPoint.x = localRect.right;
      localPoint.y = (localRect.top + this.g);
      return localPoint;
    case 6: 
      localPoint.x = localRect.right;
      localPoint.y = localRect.top;
      return localPoint;
    case 5: 
      localPoint.x = localRect.left;
      localPoint.y = localRect.bottom;
      return localPoint;
    case 4: 
      localPoint.x = localRect.left;
      localPoint.y = (localRect.bottom - this.h);
      return localPoint;
    case 3: 
      localPoint.x = localRect.left;
      localPoint.y = localRect.centerY();
      return localPoint;
    case 2: 
      localPoint.x = localRect.left;
      localPoint.y = (localRect.top + this.g);
      return localPoint;
    case 1: 
      localPoint.x = localRect.left;
      localPoint.y = localRect.top;
      return localPoint;
    }
    localPoint.x = localRect.centerX();
    localPoint.y = localRect.centerY();
    return localPoint;
  }
  
  Rect a()
  {
    int i3;
    if (b() % 2 == 0) {
      i3 = 1;
    } else {
      i3 = 0;
    }
    int i1;
    if (i3 != 0) {
      i1 = this.e;
    } else {
      i1 = this.f;
    }
    int i2;
    if (i3 != 0) {
      i2 = this.f;
    } else {
      i2 = this.e;
    }
    Rect localRect = new Rect();
    localRect.left = i1;
    localRect.top = i2;
    int i4;
    if ((i3 == 0) && (this.jdField_a_of_type_Boolean))
    {
      i3 = this.jdField_d_of_type_Int;
      i4 = this.jdField_c_of_type_Int;
    }
    else
    {
      i3 = this.jdField_c_of_type_Int;
      i4 = this.jdField_d_of_type_Int;
    }
    int i5 = this.q;
    if (i5 != 0)
    {
      int i6 = this.r;
      if (i6 != 0)
      {
        localRect.right = (i5 - i3 - i1);
        localRect.bottom = (i6 - i4 - i2);
        return localRect;
      }
    }
    try
    {
      localRect.right = (this.jdField_a_of_type_AndroidViewDisplay.getWidth() - i3 - i1);
      localRect.bottom = (this.jdField_a_of_type_AndroidViewDisplay.getHeight() - i4 - i2);
      return localRect;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getPositionRect e = ");
        localStringBuilder.append(localException);
        QLog.e("SmallScreenRelativeLayout", 2, localStringBuilder.toString());
      }
    }
    return localRect;
  }
  
  public void a()
  {
    int i3 = b();
    Object localObject = new Rect();
    try
    {
      getWindowVisibleDisplayFrame((Rect)localObject);
    }
    catch (Exception localException)
    {
      label23:
      boolean bool;
      int i4;
      int i2;
      int i1;
      break label23;
    }
    if (QLog.isColorLevel()) {
      QLog.e("SmallScreenRelativeLayout", 2, "Can not getWindowVisibleDisplayFrame");
    }
    bool = SmallScreenUtils.i();
    i4 = ((Rect)localObject).width();
    i2 = ((Rect)localObject).height();
    i1 = i2;
    if (bool) {
      i1 = i2 - this.jdField_a_of_type_Int;
    }
    i2 = this.p;
    this.s = a(this.q, this.r, i4, i1, this.s);
    if ((this.p != i3) || (i4 != this.q) || ((i3 == 0) && (this.r < i1)) || ((i3 != 0) && (this.r != i1)))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onOrientationChangedInner, mPosition[");
        ((StringBuilder)localObject).append(i2);
        ((StringBuilder)localObject).append("->");
        ((StringBuilder)localObject).append(this.s);
        ((StringBuilder)localObject).append("], mRotation[");
        ((StringBuilder)localObject).append(this.p);
        ((StringBuilder)localObject).append("->");
        ((StringBuilder)localObject).append(i3);
        ((StringBuilder)localObject).append("], mScreenWidth[");
        ((StringBuilder)localObject).append(this.q);
        ((StringBuilder)localObject).append("->");
        ((StringBuilder)localObject).append(i4);
        ((StringBuilder)localObject).append("], mScreenHeight[");
        ((StringBuilder)localObject).append(this.r);
        ((StringBuilder)localObject).append("->");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append("], mIsInit[");
        ((StringBuilder)localObject).append(this.jdField_d_of_type_Boolean);
        ((StringBuilder)localObject).append("]");
        QLog.w("SmallScreenRelativeLayout", 1, ((StringBuilder)localObject).toString());
      }
      if ((this.jdField_d_of_type_Boolean) && (i3 != 0)) {
        this.jdField_d_of_type_Boolean = false;
      }
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.p = i3;
      this.q = i4;
      this.r = i1;
      setCurPosition(this.s);
      localObject = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener;
      if (localObject != null)
      {
        i1 = ((SmallScreenRelativeLayout.FloatListener)localObject).a(this);
        this.m = i1;
        this.i = i1;
        i1 = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener.b(this);
        this.n = i1;
        this.j = i1;
      }
      else
      {
        i1 = getLeft();
        this.m = i1;
        this.i = i1;
        i1 = getTop();
        this.n = i1;
        this.j = i1;
      }
      if (!this.jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      }
    }
  }
  
  void a(int paramInt1, int paramInt2)
  {
    int i2 = this.i + paramInt1 - this.k;
    int i3 = this.j + paramInt2 - this.l;
    int i1;
    if ((this.p % 2 != 0) && (this.jdField_a_of_type_Boolean))
    {
      i1 = this.jdField_d_of_type_Int;
      paramInt2 = this.jdField_c_of_type_Int;
    }
    else
    {
      i1 = this.jdField_c_of_type_Int;
      paramInt2 = this.jdField_d_of_type_Int;
    }
    int i5 = this.q - i1;
    int i4 = this.r - paramInt2;
    paramInt1 = i2;
    if (i2 < 0) {
      paramInt1 = 0;
    }
    if (paramInt1 > i5) {
      i2 = i5;
    } else {
      i2 = paramInt1;
    }
    paramInt1 = i3;
    if (i3 < 0) {
      paramInt1 = 0;
    }
    if (paramInt1 > i4) {
      paramInt1 = i4;
    }
    SmallScreenRelativeLayout.FloatListener localFloatListener = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener;
    if (localFloatListener != null)
    {
      localFloatListener.a(this, i2, paramInt1, i2 + i1, paramInt1 + paramInt2);
      return;
    }
    layout(i2, paramInt1, i1 + i2, paramInt2 + paramInt1);
  }
  
  void a(boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startShowHideAnimation mIsShow = ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      QLog.d("SmallScreenRelativeLayout", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startShowHideAnimation isShow = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("SmallScreenRelativeLayout", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    setVisibility(i1);
    if (!paramBoolean)
    {
      localObject = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener;
      if (localObject != null) {
        ((SmallScreenRelativeLayout.FloatListener)localObject).a(this);
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenRelativeLayout", 2, "onCreate");
    }
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$SmallScreenOrientationEventListener.enable();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenRelativeLayout", 2, "onDestroy");
    }
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener = null;
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$SmallScreenOrientationEventListener.disable();
  }
  
  public void d()
  {
    a(true);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = (int)paramMotionEvent.getRawX();
    int i2 = (int)paramMotionEvent.getRawY();
    int i3 = paramMotionEvent.getAction();
    boolean bool2 = false;
    if (i3 != 0)
    {
      if (i3 != 1)
      {
        if (i3 != 2)
        {
          if (i3 != 3) {
            return true;
          }
          if (this.jdField_c_of_type_Boolean) {
            a(i1, i2);
          }
          paramMotionEvent = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener;
          if (paramMotionEvent != null)
          {
            this.m = paramMotionEvent.a(this);
            this.n = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener.b(this);
          }
          else
          {
            this.m = getLeft();
            this.n = getTop();
          }
          this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
          return true;
        }
        if (this.jdField_c_of_type_Boolean)
        {
          a(i1, i2);
          return true;
        }
        if ((Math.abs(i1 - this.k) > this.jdField_b_of_type_Int) || (Math.abs(i2 - this.l) > this.jdField_b_of_type_Int))
        {
          this.jdField_c_of_type_Boolean = true;
          return true;
        }
      }
      else
      {
        boolean bool1;
        if (this.jdField_c_of_type_Boolean)
        {
          a(i1, i2);
          bool1 = bool2;
        }
        else
        {
          RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
          if ((localRectF != null) && (localRectF.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          paramMotionEvent = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener;
          if ((paramMotionEvent != null) && (i1 == 0))
          {
            bool1 = paramMotionEvent.a(this);
          }
          else
          {
            paramMotionEvent = this.jdField_a_of_type_AndroidViewView$OnClickListener;
            bool1 = bool2;
            if (paramMotionEvent != null)
            {
              paramMotionEvent.onClick(this);
              bool1 = bool2;
            }
          }
        }
        paramMotionEvent = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener;
        if (paramMotionEvent != null)
        {
          this.m = paramMotionEvent.a(this);
          this.n = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener.b(this);
        }
        else
        {
          this.m = getLeft();
          this.n = getTop();
        }
        if (!bool1)
        {
          this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
          return true;
        }
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.k = i1;
      this.l = i2;
      paramMotionEvent = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener;
      if (paramMotionEvent != null)
      {
        this.i = paramMotionEvent.a(this);
        this.j = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener.b(this);
      }
      else
      {
        this.i = getLeft();
        this.j = getTop();
      }
      this.jdField_c_of_type_Boolean = false;
    }
    return true;
  }
  
  public void e()
  {
    a(false);
  }
  
  public void f()
  {
    if ((this.q != 0) && (this.r != 0))
    {
      Point localPoint = a(this.s);
      int i1;
      int i2;
      if ((this.p % 2 != 0) && (this.jdField_a_of_type_Boolean))
      {
        i1 = this.jdField_d_of_type_Int;
        i2 = this.jdField_c_of_type_Int;
      }
      else
      {
        i1 = this.jdField_c_of_type_Int;
        i2 = this.jdField_d_of_type_Int;
      }
      SmallScreenRelativeLayout.FloatListener localFloatListener = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener;
      if (localFloatListener != null)
      {
        localFloatListener.a(this, localPoint.x, localPoint.y, localPoint.x + i1, localPoint.y + i2);
        return;
      }
      layout(localPoint.x, localPoint.y, localPoint.x + i1, localPoint.y + i2);
    }
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (paramAnimator == this.jdField_a_of_type_AndroidAnimationValueAnimator)
    {
      Point localPoint = a(this.o);
      paramAnimator = null;
      int i1 = this.o;
      if (i1 != 1) {
        if (i1 != 10) {
          if (i1 != 5) {
            if (i1 != 6) {
              break label78;
            }
          }
        }
      }
      for (;;)
      {
        paramAnimator = "0X80057E2";
        continue;
        paramAnimator = "0X80057E3";
        continue;
        paramAnimator = "0X80057E4";
        continue;
        paramAnimator = "0X80057E1";
      }
      label78:
      int i2;
      if ((this.p % 2 != 0) && (this.jdField_a_of_type_Boolean))
      {
        i1 = this.jdField_d_of_type_Int;
        i2 = this.jdField_c_of_type_Int;
      }
      else
      {
        i1 = this.jdField_c_of_type_Int;
        i2 = this.jdField_d_of_type_Int;
      }
      SmallScreenRelativeLayout.FloatListener localFloatListener = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener;
      if (localFloatListener != null) {
        localFloatListener.a(this, localPoint.x, localPoint.y, localPoint.x + i1, localPoint.y + i2);
      } else {
        layout(localPoint.x, localPoint.y, localPoint.x + i1, localPoint.y + i2);
      }
      this.jdField_d_of_type_Boolean = false;
      this.s = this.o;
      if (paramAnimator != null) {
        ReportController.b(null, "CliOper", "", "", paramAnimator, paramAnimator, 0, 0, "", "", "", "");
      }
    }
    else if ((paramAnimator == this.jdField_b_of_type_AndroidAnimationValueAnimator) && (!this.jdField_b_of_type_Boolean))
    {
      setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenRelativeLayout", 2, "onAnimationEnd setVisibility(GONE)");
      }
      paramAnimator = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener;
      if (paramAnimator != null) {
        paramAnimator.a(this);
      }
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (paramAnimator == this.jdField_a_of_type_AndroidAnimationValueAnimator)
    {
      this.o = a(this.i, this.j, this.m, this.n);
      return;
    }
    if ((paramAnimator == this.jdField_b_of_type_AndroidAnimationValueAnimator) && (this.jdField_b_of_type_Boolean))
    {
      setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenRelativeLayout", 2, "onAnimationStart setVisibility(VISIBLE)");
      }
    }
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (paramValueAnimator == this.jdField_a_of_type_AndroidAnimationValueAnimator)
    {
      paramValueAnimator = a(this.o);
      int i3 = (int)(this.m + (paramValueAnimator.x - this.m) * f1);
      int i4 = (int)(this.n + (paramValueAnimator.y - this.n) * f1);
      int i2;
      int i1;
      if ((this.p % 2 != 0) && (this.jdField_a_of_type_Boolean))
      {
        i2 = this.jdField_d_of_type_Int;
        i1 = this.jdField_c_of_type_Int;
      }
      else
      {
        i2 = this.jdField_c_of_type_Int;
        i1 = this.jdField_d_of_type_Int;
      }
      paramValueAnimator = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener;
      if (paramValueAnimator != null)
      {
        paramValueAnimator.a(this, i3, i4, i3 + i2, i4 + i1);
        return;
      }
      layout(i3, i4, i2 + i3, i1 + i4);
      return;
    }
    if (paramValueAnimator == this.jdField_b_of_type_AndroidAnimationValueAnimator) {
      boolean bool = this.jdField_b_of_type_Boolean;
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    a();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.q == 0) || (this.r == 0))
    {
      Rect localRect = new Rect();
      getWindowVisibleDisplayFrame(localRect);
      this.q = localRect.width();
      if (this.r < localRect.height()) {
        this.r = localRect.height();
      }
      setCurPosition(this.s);
    }
  }
  
  public void setCurPosition(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setCurPosition position = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("SmallScreenRelativeLayout", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setCurPosition mScreenWidth = ");
      ((StringBuilder)localObject).append(this.q);
      QLog.d("SmallScreenRelativeLayout", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setCurPosition mScreenHeight = ");
      ((StringBuilder)localObject).append(this.r);
      QLog.d("SmallScreenRelativeLayout", 2, ((StringBuilder)localObject).toString());
    }
    this.s = paramInt;
    if ((this.q != 0) && (this.r != 0))
    {
      localObject = a(paramInt);
      int i1;
      if ((this.p % 2 != 0) && (this.jdField_a_of_type_Boolean))
      {
        paramInt = this.jdField_d_of_type_Int;
        i1 = this.jdField_c_of_type_Int;
      }
      else
      {
        paramInt = this.jdField_c_of_type_Int;
        i1 = this.jdField_d_of_type_Int;
      }
      SmallScreenRelativeLayout.FloatListener localFloatListener = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener;
      if (localFloatListener != null)
      {
        localFloatListener.a(this, ((Point)localObject).x, ((Point)localObject).y, ((Point)localObject).x + paramInt, ((Point)localObject).y + i1);
        return;
      }
      layout(((Point)localObject).x, ((Point)localObject).y, ((Point)localObject).x + paramInt, ((Point)localObject).y + i1);
    }
  }
  
  public void setFloatListener(SmallScreenRelativeLayout.FloatListener paramFloatListener)
  {
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout$FloatListener = paramFloatListener;
  }
  
  public void setIntercetRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void setIsRotateSize(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
  }
  
  public void setTitleHeight(int paramInt)
  {
    this.g = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenRelativeLayout
 * JD-Core Version:    0.7.0.1
 */