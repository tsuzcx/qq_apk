package com.tencent.mobileqq.bigbrother;

import com.tencent.mobileqq.haoliyou.JefsClass.IdSetter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public class WeakOuterRefRunnable
  implements JefsClass.IdSetter, Runnable
{
  private WeakReference<Object> a;
  private Runnable b;
  private String c;
  private int d;
  private int e = 1;
  private boolean f;
  
  public WeakOuterRefRunnable(Runnable paramRunnable, boolean paramBoolean)
  {
    this.b = paramRunnable;
    if (paramBoolean) {
      a();
    }
  }
  
  private void a()
  {
    Object localObject = this.b;
    if (localObject == null) {
      return;
    }
    localObject = localObject.getClass();
    try
    {
      localObject = ((Class)localObject).getDeclaredField("this$0");
      ((Field)localObject).setAccessible(true);
      this.a = new WeakReference(((Field)localObject).get(this.b));
      ((Field)localObject).set(this.b, null);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      QLog.e("WeakOuterRefRunnable", 1, localIllegalAccessException, new Object[0]);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      QLog.e("WeakOuterRefRunnable", 1, localIllegalArgumentException, new Object[0]);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      QLog.e("WeakOuterRefRunnable", 1, localNoSuchFieldException, new Object[0]);
    }
  }
  
  private boolean b()
  {
    Object localObject = this.a;
    if ((localObject != null) && (this.b != null))
    {
      localObject = ((WeakReference)localObject).get();
      if (localObject == null) {
        return false;
      }
      try
      {
        Field localField = this.b.getClass().getDeclaredField("this$0");
        localField.setAccessible(true);
        localField.set(this.b, localObject);
        return true;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        QLog.e("WeakOuterRefRunnable", 1, localIllegalAccessException, new Object[0]);
        return false;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        QLog.e("WeakOuterRefRunnable", 1, localIllegalArgumentException, new Object[0]);
        return false;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        QLog.e("WeakOuterRefRunnable", 1, localNoSuchFieldException, new Object[0]);
        return false;
      }
    }
    return true;
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(String paramString)
  {
    this.f = true;
    this.c = paramString;
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void run()
  {
    int i;
    if ((this.b != null) && (b()))
    {
      i = 1;
      this.b.run();
      TeleScreen.a().a(this.d, this.e);
    }
    else
    {
      TeleScreen.a().a(this.d, -3);
      i = 0;
    }
    if (this.f)
    {
      String str1;
      if (i != 0) {
        str1 = "1";
      } else {
        str1 = "";
      }
      String str2;
      if (i != 0) {
        str2 = "";
      } else {
        str2 = "1";
      }
      String str3 = this.c;
      if (str3 == null) {
        str3 = "";
      }
      ReportController.b(null, "dc00898", "", "", "0X8009C5A", "0X8009C5A", 0, 0, str1, str2, str3, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.WeakOuterRefRunnable
 * JD-Core Version:    0.7.0.1
 */