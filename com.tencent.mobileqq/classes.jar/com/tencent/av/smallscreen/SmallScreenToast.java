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
  WindowManager a;
  Context b;
  WindowManager.LayoutParams c = new WindowManager.LayoutParams();
  View d = null;
  boolean e = false;
  
  public SmallScreenToast(Context paramContext, View paramView)
  {
    this.b = paramContext;
    this.a = ((WindowManager)this.b.getSystemService("window"));
    paramContext = this.c;
    paramContext.height = -2;
    paramContext.width = -2;
    paramContext.flags = 776;
    paramContext.format = -3;
    paramContext.windowAnimations = 0;
    paramContext.type = 2010;
    paramContext.gravity = 51;
    paramContext.setTitle("Toast");
    this.d = paramView;
    a();
  }
  
  void a()
  {
    try
    {
      int i = ((Integer)this.c.getClass().getField("privateFlags").get(this.c)).intValue();
      this.c.getClass().getField("privateFlags").set(this.c, Integer.valueOf(i | 0x40));
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean b()
  {
    for (;;)
    {
      try
      {
        bool1 = this.e;
        bool2 = false;
        if (bool1) {
          break label390;
        }
        this.e = true;
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("SmallScreenToast", 2, "startHandler addView start");
          }
          this.a.addView(this.d, this.c);
          if (!QLog.isColorLevel()) {
            break label390;
          }
          QLog.d("SmallScreenToast", 2, "startHandler addView end");
        }
        catch (Exception localException)
        {
          this.e = false;
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("startHandler error : ");
          localStringBuilder2.append(localException);
          AVLog.printErrorLog("SmallScreenToast", localStringBuilder2.toString());
          bool1 = bool2;
          continue;
        }
        catch (SecurityException localSecurityException)
        {
          this.e = false;
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
          this.e = false;
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
          this.a.updateViewLayout(this.d, this.c);
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
      if ((WindowManager.LayoutParams)this.d.getLayoutParams() != null)
      {
        bool2 = bool1;
        if (bool1) {
          bool2 = SmallScreenUtils.c(this.b);
        }
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("startHandler isVisible = ");
        localStringBuilder1.append(this.e);
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
  
  public void c()
  {
    try
    {
      if (this.e)
      {
        this.e = false;
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("SmallScreenToast", 2, "stopHandler removeView start");
          }
          this.a.removeView(this.d);
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
  
  public void d()
  {
    if (this.e) {
      try
      {
        this.a.updateViewLayout(this.d, this.c);
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
  
  public boolean e()
  {
    return this.e;
  }
  
  public WindowManager.LayoutParams f()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenToast
 * JD-Core Version:    0.7.0.1
 */