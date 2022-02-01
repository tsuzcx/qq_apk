package com.tencent.av.smallscreen;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.BadTokenException;
import android.view.WindowManager.LayoutParams;
import com.tencent.av.AVLog;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public class SmallScreenToast
{
  Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView = null;
  WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
  WindowManager jdField_a_of_type_AndroidViewWindowManager;
  boolean jdField_a_of_type_Boolean = false;
  
  public SmallScreenToast(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window"));
    paramContext = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
    paramContext.height = -2;
    paramContext.width = -2;
    paramContext.flags = 776;
    paramContext.format = -3;
    paramContext.windowAnimations = 0;
    paramContext.type = 2010;
    paramContext.gravity = 51;
    paramContext.setTitle("Toast");
    this.jdField_a_of_type_AndroidViewView = paramView;
    a();
  }
  
  public WindowManager.LayoutParams a()
  {
    return this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  }
  
  void a()
  {
    try
    {
      int i = ((Integer)this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.getClass().getField("privateFlags").get(this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams)).intValue();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.getClass().getField("privateFlags").set(this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams, Integer.valueOf(i | 0x40));
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean a()
  {
    for (;;)
    {
      try
      {
        bool1 = this.jdField_a_of_type_Boolean;
        bool2 = false;
        if (bool1) {
          break label390;
        }
        this.jdField_a_of_type_Boolean = true;
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("SmallScreenToast", 2, "startHandler addView start");
          }
          this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
          if (!QLog.isColorLevel()) {
            break label390;
          }
          QLog.d("SmallScreenToast", 2, "startHandler addView end");
        }
        catch (Exception localException)
        {
          this.jdField_a_of_type_Boolean = false;
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("startHandler error : ");
          localStringBuilder2.append(localException);
          AVLog.printErrorLog("SmallScreenToast", localStringBuilder2.toString());
          bool1 = bool2;
          continue;
        }
        catch (SecurityException localSecurityException)
        {
          this.jdField_a_of_type_Boolean = false;
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("startHandler error : ");
          localStringBuilder2.append(localSecurityException);
          QLog.d("SmallScreenToast", 2, localStringBuilder2.toString());
          bool1 = bool2;
          continue;
        }
        catch (WindowManager.BadTokenException localBadTokenException)
        {
          this.jdField_a_of_type_Boolean = false;
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("startHandler error : ");
          localStringBuilder2.append(localBadTokenException);
          QLog.d("SmallScreenToast", 2, localStringBuilder2.toString());
          bool1 = bool2;
          continue;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
          if (!QLog.isColorLevel()) {
            break label390;
          }
        }
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("startHandler error : ");
        localStringBuilder2.append(localIllegalStateException);
        QLog.d("SmallScreenToast", 2, localStringBuilder2.toString());
      }
      finally {}
      boolean bool2 = bool1;
      if ((WindowManager.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams() != null)
      {
        bool2 = bool1;
        if (bool1) {
          bool2 = SmallScreenUtils.c(this.jdField_a_of_type_AndroidContentContext);
        }
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("startHandler isVisible = ");
        localStringBuilder1.append(this.jdField_a_of_type_Boolean);
        QLog.d("SmallScreenToast", 2, localStringBuilder1.toString());
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("startHandler result = ");
        localStringBuilder1.append(bool2);
        QLog.d("SmallScreenToast", 2, localStringBuilder1.toString());
      }
      return bool2;
      label390:
      boolean bool1 = true;
    }
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("SmallScreenToast", 2, "stopHandler removeView start");
          }
          this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_AndroidViewView);
          if (QLog.isColorLevel()) {
            QLog.d("SmallScreenToast", 2, "stopHandler removeView end");
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("stopHandler error : ");
            localStringBuilder.append(localIllegalArgumentException);
            QLog.d("SmallScreenToast", 2, localStringBuilder.toString());
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Boolean) {
      try
      {
        this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("layout error : ");
          localStringBuilder.append(localIllegalArgumentException);
          QLog.d("SmallScreenToast", 2, localStringBuilder.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenToast
 * JD-Core Version:    0.7.0.1
 */