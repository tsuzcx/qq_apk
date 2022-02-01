package com.tencent.mobileqq.activity.aio.anim;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AnimateUtils;
import com.tencent.widget.ListView;

public class MoveToBottomScroller
  implements Runnable
{
  public static int b = 50;
  float jdField_a_of_type_Float;
  public int a;
  private long jdField_a_of_type_Long;
  AIOFooterViewDetector jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector;
  MoveToBottomScroller.OnScrollerListener jdField_a_of_type_ComTencentMobileqqActivityAioAnimMoveToBottomScroller$OnScrollerListener;
  ListView jdField_a_of_type_ComTencentWidgetListView;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  int jdField_d_of_type_Int;
  int e;
  int f;
  int g;
  int h;
  int i;
  int j;
  int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  
  public MoveToBottomScroller(ListView paramListView, AIOFooterViewDetector paramAIOFooterViewDetector)
  {
    boolean bool = false;
    this.l = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_Int = 0;
    this.e = 0;
    this.f = 0;
    this.jdField_a_of_type_Float = 1.0F;
    this.g = 0;
    this.h = 0;
    this.i = 0;
    this.j = 0;
    this.k = 0;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector = paramAIOFooterViewDetector;
    this.jdField_c_of_type_Int = ViewConfiguration.get(this.jdField_a_of_type_ComTencentWidgetListView.getContext()).getScaledMinimumFlingVelocity();
    if (DeviceInfoUtil.a() / 1048576L > 512L) {
      bool = true;
    }
    this.jdField_b_of_type_Boolean = bool;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentWidgetListView.getResources().getDisplayMetrics().density;
  }
  
  private int a(int paramInt)
  {
    int i1 = paramInt;
    if (this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() > 0)
    {
      ListView localListView = this.jdField_a_of_type_ComTencentWidgetListView;
      i1 = localListView.getChildAt(localListView.getChildCount() - 1).getBottom();
      int i2 = this.k;
      if ((i2 != 0) && (i2 >= i1))
      {
        double d1 = i2 - i1;
        int i3 = this.j;
        double d2 = i3;
        Double.isNaN(d2);
        if (d1 <= d2 * 0.75D) {
          this.i += i3 - (i2 - i1);
        }
      }
      this.k = i1;
      i2 = this.i;
      i1 = paramInt + i2 / 5;
      this.i = (i2 * 4 / 5);
      this.j = i1;
    }
    return i1;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MoveToBottomScroller", 2, "MoveToBottomScroller start");
    }
    if (this.jdField_c_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MoveToBottomScroller", 2, "start() mRunning, ignore request");
      }
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
    this.j = 0;
    this.i = 0;
    this.k = 0;
    if (!this.jdField_b_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetListView;
      ((ListView)localObject).setSelection(((ListView)localObject).getCount() - 1);
      b();
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetListView;
    if (localObject == null)
    {
      this.jdField_c_of_type_Boolean = false;
      return;
    }
    this.h = ((ListView)localObject).getResources().getDisplayMetrics().heightPixels;
    this.e = this.jdField_a_of_type_ComTencentWidgetListView.mFirstPosition;
    this.f = (this.e + this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() - 1);
    this.jdField_d_of_type_Int = (this.jdField_a_of_type_ComTencentWidgetListView.getCount() - this.f - 1);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("MoveToBottomScroller start scrollCount: ");
      ((StringBuilder)localObject).append(this.jdField_d_of_type_Int);
      QLog.d("MoveToBottomScroller", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_d_of_type_Int == 0)
    {
      if (this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() < 1)
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetListView;
        ((ListView)localObject).setSelection(((ListView)localObject).getCount() - 1);
        this.jdField_c_of_type_Boolean = false;
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentWidgetListView;
      this.p = ((ListView)localObject).getChildAt(((ListView)localObject).getChildCount() - 1).getBottom();
      if (this.p == 0)
      {
        b();
        return;
      }
      this.o = 800;
      this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
      this.l = 0;
      this.m = 3;
      this.jdField_a_of_type_ComTencentWidgetListView.removeCallbacks(this);
      if (Build.VERSION.SDK_INT >= 16) {
        this.jdField_a_of_type_ComTencentWidgetListView.postOnAnimation(this);
      } else {
        this.jdField_a_of_type_ComTencentWidgetListView.post(this);
      }
    }
    else
    {
      int i1 = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      if (this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() == 0) {
        i1 = 1;
      }
      if ((this.jdField_a_of_type_ComTencentWidgetListView.getFooterViewsCount() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.jdField_a_of_type_Int >= 0))
      {
        int i2 = this.jdField_d_of_type_Int;
        if (i2 > 1) {
          i2 -= 1;
        } else {
          i2 = 0;
        }
        this.jdField_d_of_type_Int = i2;
        this.p = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.jdField_a_of_type_Int;
      }
      else
      {
        this.p = 0;
      }
      this.p += this.jdField_d_of_type_Int * this.jdField_a_of_type_ComTencentWidgetListView.getHeight() / i1;
      this.jdField_d_of_type_Float = (this.p / 600.0F);
      this.jdField_b_of_type_Float = (this.jdField_d_of_type_Float / 200.0F);
      this.jdField_c_of_type_Float = 0.0F;
      this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
      this.m = 0;
      this.l = 0;
      this.n = (this.jdField_a_of_type_ComTencentWidgetListView.getCount() - 1);
      boolean bool;
      if (this.jdField_d_of_type_Int == 1) {
        bool = true;
      } else {
        bool = false;
      }
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_ComTencentWidgetListView.removeCallbacks(this);
      if (Build.VERSION.SDK_INT >= 16) {
        this.jdField_a_of_type_ComTencentWidgetListView.postOnAnimation(this);
      } else {
        this.jdField_a_of_type_ComTencentWidgetListView.post(this);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("MoveToBottomScroller start end with mDistance: ");
      ((StringBuilder)localObject).append(this.p);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" scrollCount: ");
      localStringBuilder.append(this.jdField_d_of_type_Int);
      QLog.d("MoveToBottomScroller", 2, new Object[] { localObject, localStringBuilder.toString() });
    }
  }
  
  public void b()
  {
    this.jdField_c_of_type_Boolean = false;
    MoveToBottomScroller.OnScrollerListener localOnScrollerListener = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimMoveToBottomScroller$OnScrollerListener;
    if (localOnScrollerListener != null) {
      localOnScrollerListener.a();
    }
    this.jdField_a_of_type_ComTencentWidgetListView.removeCallbacks(this);
  }
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("MoveToBottomScroller run with mDistance: ");
      ((StringBuilder)localObject).append(this.p);
      QLog.d("MoveToBottomScroller", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_Int >= jdField_b_of_type_Int)
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetListView;
      ((ListView)localObject).setSelectionFromBottom(((ListView)localObject).getCount() - 1, 0);
      b();
      return;
    }
    int i3 = (int)(AnimationUtils.currentAnimationTimeMillis() - this.jdField_a_of_type_Long);
    int i1 = this.m;
    float f1;
    float f2;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 != 4)
            {
              i1 = 0;
              break label336;
            }
            f1 = i3 / this.o;
            i1 = this.p;
          }
          else
          {
            f1 = AnimateUtils.a(i3 / this.o);
            i1 = this.p;
          }
          f1 *= i1;
        }
        else
        {
          f1 = this.jdField_d_of_type_Float;
        }
      }
      else {
        for (f1 = i3 * f1 - f1 * 800.0F / 8.0F;; f1 = this.p - this.jdField_c_of_type_Float * (i1 - i3) / 2.0F)
        {
          i1 = (int)f1;
          break;
          i1 = this.o;
          if (i3 > i1)
          {
            i1 = this.p;
            i1 = this.l;
            localObject = this.jdField_a_of_type_ComTencentWidgetListView;
            ((ListView)localObject).setSelectionFromBottom(((ListView)localObject).getCount() - 1, 0);
            b();
            return;
          }
          this.jdField_c_of_type_Float -= this.jdField_b_of_type_Float * i3;
        }
      }
    }
    else
    {
      f1 = this.jdField_b_of_type_Float;
      f2 = i3;
      this.jdField_c_of_type_Float = (f1 * f2);
      f1 = this.jdField_c_of_type_Float * f2 / 2.0F;
    }
    i1 = (int)f1;
    label336:
    int i2 = i1 - this.l;
    this.l = i1;
    i1 = i2;
    if (i2 < 0) {
      i1 = 0;
    }
    if (this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() - 1 > 0)
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetListView;
      this.g = ((ListView)localObject).getChildAt(((ListView)localObject).getChildCount() - 1).getHeight();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("run  delta=");
    ((StringBuilder)localObject).append(i1);
    QLog.d("MoveToBottomScroller", 2, ((StringBuilder)localObject).toString());
    i2 = i1;
    if (this.jdField_d_of_type_Int < 2)
    {
      double d1;
      if (this.g <= this.h)
      {
        f1 = i1;
        f2 = this.jdField_a_of_type_Float;
        i2 = i1;
        if (f1 >= f2 * 2.0F) {
          break label543;
        }
        d1 = f2 * 2.0F;
        Double.isNaN(d1);
      }
      else
      {
        f1 = i1;
        f2 = this.jdField_a_of_type_Float;
        i2 = i1;
        if (f1 <= f2 * 10.0F) {
          break label543;
        }
        d1 = f2 * 10.0F;
        Double.isNaN(d1);
      }
      i2 = (int)(d1 + 0.5D);
    }
    label543:
    i1 = a(i2);
    boolean bool;
    try
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetListView;
      i2 = -i1;
      bool = ((ListView)localObject).trackMotionScroll(i2, i2);
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("move delta=");
        ((StringBuilder)localObject).append(i1);
        QLog.d("MoveToBottomScroller", 2, ((StringBuilder)localObject).toString());
      }
      catch (Exception localException1) {}
      QLog.d("MoveToBottomScroller", 2, localException2, new Object[0]);
    }
    catch (Exception localException2)
    {
      bool = true;
    }
    if (!bool)
    {
      i1 = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      i2 = this.jdField_a_of_type_ComTencentWidgetListView.mFirstPosition;
      int i4 = this.m;
      if ((i4 != 3) && (i4 != 1) && (i2 + i1 - 1 >= this.n))
      {
        if (i1 >= 2) {
          this.p = (this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i1 - 1).getBottom() - this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i1 - 2).getBottom());
        } else if (i1 == 1) {
          this.p = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i1 - 1).getBottom();
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("at position mDistance=");
        localStringBuilder.append(this.p);
        QLog.d("MoveToBottomScroller", 2, localStringBuilder.toString());
        this.o = (800 - i3);
        if (this.o < 100) {
          this.o = 100;
        }
        if (this.o > 400) {
          this.o = 400;
        }
        this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
        this.l = 0;
        if ((this.jdField_c_of_type_Float * 1000.0F > this.jdField_c_of_type_Int) && (!this.jdField_a_of_type_Boolean))
        {
          this.m = 1;
          f1 = this.p;
          i1 = this.o;
          this.jdField_c_of_type_Float = (f1 * 2.0F / i1);
          this.jdField_b_of_type_Float = (this.jdField_c_of_type_Float / i1);
        }
        else
        {
          this.m = 3;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("at position mCurrVelocity=");
        localStringBuilder.append(this.jdField_c_of_type_Float);
        localStringBuilder.append("mCurrVelocity=");
        localStringBuilder.append(this.jdField_c_of_type_Float);
        localStringBuilder.append("mDuration=");
        localStringBuilder.append(this.o);
        QLog.d("MoveToBottomScroller", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentWidgetListView.removeCallbacks(this);
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.jdField_a_of_type_ComTencentWidgetListView.postOnAnimation(this);
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetListView.post(this);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MoveToBottomScroller", 2, "atEdge");
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.MoveToBottomScroller
 * JD-Core Version:    0.7.0.1
 */