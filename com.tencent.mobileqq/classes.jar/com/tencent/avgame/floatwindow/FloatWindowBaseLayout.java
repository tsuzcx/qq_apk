package com.tencent.avgame.floatwindow;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public class FloatWindowBaseLayout
  extends FrameLayout
{
  float jdField_a_of_type_Float;
  public int a;
  WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  WindowManager jdField_a_of_type_AndroidViewWindowManager;
  FloatPositionChangeCallback jdField_a_of_type_ComTencentAvgameFloatwindowFloatPositionChangeCallback;
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float;
  public int b;
  boolean jdField_b_of_type_Boolean = false;
  float jdField_c_of_type_Float;
  boolean jdField_c_of_type_Boolean = false;
  float d;
  float e = 6.0F;
  
  public FloatWindowBaseLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  private void a()
  {
    this.e = ViewUtils.a(3.0F);
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)getContext().getSystemService("window"));
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
    WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
    localLayoutParams.format = -3;
    localLayoutParams.flags = 808;
    if (Build.VERSION.SDK_INT >= 26) {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.type = 2038;
    } else {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.type = 2002;
    }
    localLayoutParams = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
    localLayoutParams.systemUiVisibility = 5892;
    localLayoutParams.gravity = 85;
    localLayoutParams.setTitle("FloatWindowBaseLayout");
    localLayoutParams = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
    localLayoutParams.x = 0;
    localLayoutParams.y = 0;
    b();
  }
  
  private void b()
  {
    try
    {
      int i = ((Integer)this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.getClass().getField("privateFlags").get(this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams)).intValue();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.getClass().getField("privateFlags").set(this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams, Integer.valueOf(i | 0x40));
      return;
    }
    catch (Exception localException) {}
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x + this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width / 2;
  }
  
  public WindowManager.LayoutParams a()
  {
    return this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x) || (paramInt2 != this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y))
    {
      WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
      localLayoutParams.x = paramInt1;
      localLayoutParams.y = paramInt2;
    }
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("showOrUpdate mAdded: ");
      localStringBuilder1.append(this.jdField_a_of_type_Boolean);
      QLog.d("FloatWindowBaseLayout", 2, localStringBuilder1.toString());
    }
    try
    {
      boolean bool2 = this.jdField_a_of_type_Boolean;
      boolean bool1 = false;
      StringBuilder localStringBuilder2;
      if (!bool2) {
        try
        {
          this.jdField_a_of_type_AndroidViewWindowManager.addView(this, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
          this.jdField_a_of_type_Boolean = true;
        }
        catch (Throwable localThrowable1)
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("showOrUpdate addView error:");
          localStringBuilder2.append(localThrowable1.getMessage());
          QLog.e("FloatWindowBaseLayout", 1, localStringBuilder2.toString());
          break label175;
        }
      }
      try
      {
        this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
        bool1 = true;
      }
      catch (Throwable localThrowable2)
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("showOrUpdate updateViewLayout error: ");
        localStringBuilder2.append(localThrowable2.getMessage());
        QLog.e("FloatWindowBaseLayout", 1, localStringBuilder2.toString());
      }
      label175:
      return bool1;
    }
    finally {}
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("hide: ");
      localStringBuilder1.append(this.jdField_a_of_type_Boolean);
      QLog.d("FloatWindowBaseLayout", 2, localStringBuilder1.toString());
    }
    for (;;)
    {
      try
      {
        boolean bool2 = this.jdField_a_of_type_Boolean;
        bool1 = false;
        if (bool2)
        {
          try
          {
            this.jdField_a_of_type_AndroidViewWindowManager.removeView(this);
            this.jdField_a_of_type_Boolean = false;
          }
          catch (Throwable localThrowable)
          {
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("hide removeView error: ");
            localStringBuilder2.append(localThrowable.getMessage());
            QLog.e("FloatWindowBaseLayout", 1, localStringBuilder2.toString());
          }
          return bool1;
        }
      }
      finally {}
      boolean bool1 = true;
    }
  }
  
  public int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int d()
  {
    return this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x;
  }
  
  public void d()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("applyChanges: ");
      localStringBuilder1.append(this.jdField_a_of_type_Boolean);
      QLog.d("FloatWindowBaseLayout", 2, localStringBuilder1.toString());
    }
    if (this.jdField_a_of_type_Boolean) {
      try
      {
        this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
        return;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("applyChanges updateViewLayout error: ");
        localStringBuilder2.append(localThrowable.getMessage());
        QLog.e("FloatWindowBaseLayout", 1, localStringBuilder2.toString());
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    int i = paramMotionEvent.getAction();
    boolean bool = false;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label245;
          }
        }
        else
        {
          if ((Math.abs(f1 - this.jdField_c_of_type_Float) > this.e) && (Math.abs(f2 - this.d) > this.e) && (this.jdField_c_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)) {
            this.jdField_b_of_type_Boolean = true;
          }
          localFloatPositionChangeCallback = this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatPositionChangeCallback;
          if ((localFloatPositionChangeCallback != null) && (this.jdField_b_of_type_Boolean)) {
            localFloatPositionChangeCallback.a((int)(f1 - this.jdField_a_of_type_Float), (int)(f2 - this.jdField_b_of_type_Float));
          }
          if (this.jdField_b_of_type_Boolean)
          {
            bool = true;
            break label245;
          }
          bool = super.dispatchTouchEvent(paramMotionEvent);
          break label245;
        }
      }
      FloatPositionChangeCallback localFloatPositionChangeCallback = this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatPositionChangeCallback;
      if ((localFloatPositionChangeCallback != null) && (this.jdField_b_of_type_Boolean)) {
        localFloatPositionChangeCallback.b();
      }
      if (this.jdField_b_of_type_Boolean) {
        bool = true;
      } else {
        bool = super.dispatchTouchEvent(paramMotionEvent);
      }
      this.jdField_b_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = false;
    }
    else
    {
      this.jdField_c_of_type_Float = f1;
      this.d = f2;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = true;
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    label245:
    this.jdField_a_of_type_Float = f1;
    this.jdField_b_of_type_Float = f2;
    return bool;
  }
  
  public int e()
  {
    return this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y;
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatPositionChangeCallback = null;
  }
  
  public void setFloatPositionChangeCallback(FloatPositionChangeCallback paramFloatPositionChangeCallback)
  {
    this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatPositionChangeCallback = paramFloatPositionChangeCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.floatwindow.FloatWindowBaseLayout
 * JD-Core Version:    0.7.0.1
 */