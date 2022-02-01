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
  SmallScreenRelativeLayout.SmallScreenOrientationEventListener A = null;
  int B = 7;
  RectF C;
  View.OnClickListener D;
  SmallScreenRelativeLayout.FloatListener a;
  ValueAnimator b;
  ValueAnimator c;
  Display d;
  boolean e = false;
  boolean f = false;
  boolean g = false;
  boolean h = true;
  final int i;
  final int j;
  int k;
  int l;
  final int m;
  final int n;
  int o;
  final int p;
  int q = -1;
  int r = -1;
  int s = -1;
  int t = -1;
  int u = -1;
  int v = -1;
  int w = 6;
  int x = 0;
  int y = 0;
  int z = 0;
  
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
    this.j = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.m = getResources().getDimensionPixelSize(2131298637);
    this.n = getResources().getDimensionPixelSize(2131298638);
    this.i = getResources().getDimensionPixelSize(2131298647);
    this.o = getResources().getDimensionPixelSize(2131299920);
    this.p = getResources().getDimensionPixelSize(2131298633);
    this.b = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.b.setDuration(200L);
    this.b.addListener(this);
    this.b.addUpdateListener(this);
    this.c = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.c.setDuration(400L);
    this.c.addListener(this);
    this.b.addUpdateListener(this);
    this.d = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    this.x = getSysRotation();
    this.A = new SmallScreenRelativeLayout.SmallScreenOrientationEventListener(this, getContext(), 2);
  }
  
  private int getSysRotation()
  {
    try
    {
      int i1 = this.d.getRotation();
      return i1;
    }
    catch (Exception localException)
    {
      AVLog.printErrorLog("SmallScreenRelativeLayout", localException.getMessage());
    }
    return 0;
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
      SharedPreferences localSharedPreferences = SharedPreUtils.B(getContext());
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
    Rect localRect = getPositionRect();
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
      localPoint.y = (localRect.bottom - this.p);
      return localPoint;
    case 8: 
      localPoint.x = localRect.right;
      localPoint.y = localRect.centerY();
      return localPoint;
    case 7: 
      localPoint.x = localRect.right;
      localPoint.y = (localRect.top + this.o);
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
      localPoint.y = (localRect.bottom - this.p);
      return localPoint;
    case 3: 
      localPoint.x = localRect.left;
      localPoint.y = localRect.centerY();
      return localPoint;
    case 2: 
      localPoint.x = localRect.left;
      localPoint.y = (localRect.top + this.o);
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
  
  public void a()
  {
    int i3 = getSysRotation();
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
    bool = SmallScreenUtils.j();
    i4 = ((Rect)localObject).width();
    i2 = ((Rect)localObject).height();
    i1 = i2;
    if (bool) {
      i1 = i2 - this.i;
    }
    i2 = this.x;
    this.B = a(this.y, this.z, i4, i1, this.B);
    if ((this.x != i3) || (i4 != this.y) || ((i3 == 0) && (this.z < i1)) || ((i3 != 0) && (this.z != i1)))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onOrientationChangedInner, mPosition[");
        ((StringBuilder)localObject).append(i2);
        ((StringBuilder)localObject).append("->");
        ((StringBuilder)localObject).append(this.B);
        ((StringBuilder)localObject).append("], mRotation[");
        ((StringBuilder)localObject).append(this.x);
        ((StringBuilder)localObject).append("->");
        ((StringBuilder)localObject).append(i3);
        ((StringBuilder)localObject).append("], mScreenWidth[");
        ((StringBuilder)localObject).append(this.y);
        ((StringBuilder)localObject).append("->");
        ((StringBuilder)localObject).append(i4);
        ((StringBuilder)localObject).append("], mScreenHeight[");
        ((StringBuilder)localObject).append(this.z);
        ((StringBuilder)localObject).append("->");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append("], mIsInit[");
        ((StringBuilder)localObject).append(this.h);
        ((StringBuilder)localObject).append("]");
        QLog.w("SmallScreenRelativeLayout", 1, ((StringBuilder)localObject).toString());
      }
      if ((this.h) && (i3 != 0)) {
        this.h = false;
      }
      this.b.cancel();
      this.x = i3;
      this.y = i4;
      this.z = i1;
      setCurPosition(this.B);
      localObject = this.a;
      if (localObject != null)
      {
        i1 = ((SmallScreenRelativeLayout.FloatListener)localObject).a(this);
        this.u = i1;
        this.q = i1;
        i1 = this.a.b(this);
        this.v = i1;
        this.r = i1;
      }
      else
      {
        i1 = getLeft();
        this.u = i1;
        this.q = i1;
        i1 = getTop();
        this.v = i1;
        this.r = i1;
      }
      if (!this.h) {
        this.b.start();
      }
    }
  }
  
  void a(int paramInt1, int paramInt2)
  {
    int i2 = this.q + paramInt1 - this.s;
    int i3 = this.r + paramInt2 - this.t;
    int i1;
    if ((this.x % 2 != 0) && (this.e))
    {
      i1 = this.l;
      paramInt2 = this.k;
    }
    else
    {
      i1 = this.k;
      paramInt2 = this.l;
    }
    int i5 = this.y - i1;
    int i4 = this.z - paramInt2;
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
    SmallScreenRelativeLayout.FloatListener localFloatListener = this.a;
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
      ((StringBuilder)localObject).append(this.f);
      QLog.d("SmallScreenRelativeLayout", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startShowHideAnimation isShow = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("SmallScreenRelativeLayout", 2, ((StringBuilder)localObject).toString());
    }
    this.f = paramBoolean;
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    setVisibility(i1);
    if (!paramBoolean)
    {
      localObject = this.a;
      if (localObject != null) {
        ((SmallScreenRelativeLayout.FloatListener)localObject).c(this);
      }
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenRelativeLayout", 2, "onCreate");
    }
    this.h = true;
    this.A.enable();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenRelativeLayout", 2, "onDestroy");
    }
    this.a = null;
    this.A.disable();
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
          if (this.g) {
            a(i1, i2);
          }
          paramMotionEvent = this.a;
          if (paramMotionEvent != null)
          {
            this.u = paramMotionEvent.a(this);
            this.v = this.a.b(this);
          }
          else
          {
            this.u = getLeft();
            this.v = getTop();
          }
          this.b.start();
          return true;
        }
        if (this.g)
        {
          a(i1, i2);
          return true;
        }
        if ((Math.abs(i1 - this.s) > this.j) || (Math.abs(i2 - this.t) > this.j))
        {
          this.g = true;
          return true;
        }
      }
      else
      {
        boolean bool1;
        if (this.g)
        {
          a(i1, i2);
          bool1 = bool2;
        }
        else
        {
          RectF localRectF = this.C;
          if ((localRectF != null) && (localRectF.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          paramMotionEvent = this.a;
          if ((paramMotionEvent != null) && (i1 == 0))
          {
            bool1 = paramMotionEvent.d(this);
          }
          else
          {
            paramMotionEvent = this.D;
            bool1 = bool2;
            if (paramMotionEvent != null)
            {
              paramMotionEvent.onClick(this);
              bool1 = bool2;
            }
          }
        }
        paramMotionEvent = this.a;
        if (paramMotionEvent != null)
        {
          this.u = paramMotionEvent.a(this);
          this.v = this.a.b(this);
        }
        else
        {
          this.u = getLeft();
          this.v = getTop();
        }
        if (!bool1)
        {
          this.b.start();
          return true;
        }
      }
    }
    else
    {
      this.b.cancel();
      this.s = i1;
      this.t = i2;
      paramMotionEvent = this.a;
      if (paramMotionEvent != null)
      {
        this.q = paramMotionEvent.a(this);
        this.r = this.a.b(this);
      }
      else
      {
        this.q = getLeft();
        this.r = getTop();
      }
      this.g = false;
    }
    return true;
  }
  
  public void e()
  {
    a(false);
  }
  
  public void f()
  {
    if ((this.y != 0) && (this.z != 0))
    {
      Point localPoint = a(this.B);
      int i1;
      int i2;
      if ((this.x % 2 != 0) && (this.e))
      {
        i1 = this.l;
        i2 = this.k;
      }
      else
      {
        i1 = this.k;
        i2 = this.l;
      }
      SmallScreenRelativeLayout.FloatListener localFloatListener = this.a;
      if (localFloatListener != null)
      {
        localFloatListener.a(this, localPoint.x, localPoint.y, localPoint.x + i1, localPoint.y + i2);
        return;
      }
      layout(localPoint.x, localPoint.y, localPoint.x + i1, localPoint.y + i2);
    }
  }
  
  public int getCurPosition()
  {
    if ((this.y != 0) && (this.z != 0))
    {
      SmallScreenRelativeLayout.FloatListener localFloatListener = this.a;
      int i1;
      int i2;
      if (localFloatListener != null)
      {
        i1 = localFloatListener.a(this);
        i2 = this.a.b(this);
      }
      else
      {
        i1 = getLeft();
        i2 = getTop();
      }
      this.B = a(i1, i2, i1, i2);
    }
    return this.B;
  }
  
  public boolean getIsShow()
  {
    return this.f;
  }
  
  Rect getPositionRect()
  {
    int i3;
    if (getSysRotation() % 2 == 0) {
      i3 = 1;
    } else {
      i3 = 0;
    }
    int i1;
    if (i3 != 0) {
      i1 = this.m;
    } else {
      i1 = this.n;
    }
    int i2;
    if (i3 != 0) {
      i2 = this.n;
    } else {
      i2 = this.m;
    }
    Rect localRect = new Rect();
    localRect.left = i1;
    localRect.top = i2;
    int i4;
    if ((i3 == 0) && (this.e))
    {
      i3 = this.l;
      i4 = this.k;
    }
    else
    {
      i3 = this.k;
      i4 = this.l;
    }
    int i5 = this.y;
    if (i5 != 0)
    {
      int i6 = this.z;
      if (i6 != 0)
      {
        localRect.right = (i5 - i3 - i1);
        localRect.bottom = (i6 - i4 - i2);
        return localRect;
      }
    }
    try
    {
      localRect.right = (this.d.getWidth() - i3 - i1);
      localRect.bottom = (this.d.getHeight() - i4 - i2);
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
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (paramAnimator == this.b)
    {
      Point localPoint = a(this.w);
      paramAnimator = null;
      int i1 = this.w;
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
      if ((this.x % 2 != 0) && (this.e))
      {
        i1 = this.l;
        i2 = this.k;
      }
      else
      {
        i1 = this.k;
        i2 = this.l;
      }
      SmallScreenRelativeLayout.FloatListener localFloatListener = this.a;
      if (localFloatListener != null) {
        localFloatListener.a(this, localPoint.x, localPoint.y, localPoint.x + i1, localPoint.y + i2);
      } else {
        layout(localPoint.x, localPoint.y, localPoint.x + i1, localPoint.y + i2);
      }
      this.h = false;
      this.B = this.w;
      if (paramAnimator != null) {
        ReportController.b(null, "CliOper", "", "", paramAnimator, paramAnimator, 0, 0, "", "", "", "");
      }
    }
    else if ((paramAnimator == this.c) && (!this.f))
    {
      setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenRelativeLayout", 2, "onAnimationEnd setVisibility(GONE)");
      }
      paramAnimator = this.a;
      if (paramAnimator != null) {
        paramAnimator.c(this);
      }
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (paramAnimator == this.b)
    {
      this.w = a(this.q, this.r, this.u, this.v);
      return;
    }
    if ((paramAnimator == this.c) && (this.f))
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
    if (paramValueAnimator == this.b)
    {
      paramValueAnimator = a(this.w);
      int i3 = (int)(this.u + (paramValueAnimator.x - this.u) * f1);
      int i4 = (int)(this.v + (paramValueAnimator.y - this.v) * f1);
      int i2;
      int i1;
      if ((this.x % 2 != 0) && (this.e))
      {
        i2 = this.l;
        i1 = this.k;
      }
      else
      {
        i2 = this.k;
        i1 = this.l;
      }
      paramValueAnimator = this.a;
      if (paramValueAnimator != null)
      {
        paramValueAnimator.a(this, i3, i4, i3 + i2, i4 + i1);
        return;
      }
      layout(i3, i4, i2 + i3, i1 + i4);
      return;
    }
    if (paramValueAnimator == this.c) {
      boolean bool = this.f;
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    a();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.y == 0) || (this.z == 0))
    {
      Rect localRect = new Rect();
      getWindowVisibleDisplayFrame(localRect);
      this.y = localRect.width();
      if (this.z < localRect.height()) {
        this.z = localRect.height();
      }
      setCurPosition(this.B);
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
      ((StringBuilder)localObject).append(this.y);
      QLog.d("SmallScreenRelativeLayout", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setCurPosition mScreenHeight = ");
      ((StringBuilder)localObject).append(this.z);
      QLog.d("SmallScreenRelativeLayout", 2, ((StringBuilder)localObject).toString());
    }
    this.B = paramInt;
    if ((this.y != 0) && (this.z != 0))
    {
      localObject = a(paramInt);
      int i1;
      if ((this.x % 2 != 0) && (this.e))
      {
        paramInt = this.l;
        i1 = this.k;
      }
      else
      {
        paramInt = this.k;
        i1 = this.l;
      }
      SmallScreenRelativeLayout.FloatListener localFloatListener = this.a;
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
    this.a = paramFloatListener;
  }
  
  public void setIntercetRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View.OnClickListener paramOnClickListener)
  {
    this.C = new RectF(paramInt1, paramInt2, paramInt3, paramInt4);
    this.D = paramOnClickListener;
  }
  
  public void setIsRotateSize(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    this.k = paramInt1;
    this.l = paramInt2;
  }
  
  public void setTitleHeight(int paramInt)
  {
    this.o = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenRelativeLayout
 * JD-Core Version:    0.7.0.1
 */