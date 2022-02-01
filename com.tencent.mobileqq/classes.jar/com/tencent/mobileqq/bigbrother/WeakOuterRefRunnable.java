package com.tencent.mobileqq.bigbrother;

import com.tencent.mobileqq.haoliyou.JefsClass.IdSetter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public class WeakOuterRefRunnable
  implements JefsClass.IdSetter, Runnable
{
  private int jdField_a_of_type_Int;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<Object> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private int b = 1;
  
  public WeakOuterRefRunnable(Runnable paramRunnable, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
    if (paramBoolean) {
      a();
    }
  }
  
  private void a()
  {
    Object localObject = this.jdField_a_of_type_JavaLangRunnable;
    if (localObject == null) {
      return;
    }
    localObject = localObject.getClass();
    try
    {
      localObject = ((Class)localObject).getDeclaredField("this$0");
      ((Field)localObject).setAccessible(true);
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(((Field)localObject).get(this.jdField_a_of_type_JavaLangRunnable));
      ((Field)localObject).set(this.jdField_a_of_type_JavaLangRunnable, null);
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
  
  private boolean a()
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localObject != null) && (this.jdField_a_of_type_JavaLangRunnable != null))
    {
      localObject = ((WeakReference)localObject).get();
      if (localObject == null) {
        return false;
      }
      try
      {
        Field localField = this.jdField_a_of_type_JavaLangRunnable.getClass().getDeclaredField("this$0");
        localField.setAccessible(true);
        localField.set(this.jdField_a_of_type_JavaLangRunnable, localObject);
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
    this.b = paramInt;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void run()
  {
    int i;
    if ((this.jdField_a_of_type_JavaLangRunnable != null) && (a()))
    {
      i = 1;
      this.jdField_a_of_type_JavaLangRunnable.run();
      TeleScreen.a().a(this.jdField_a_of_type_Int, this.b);
    }
    else
    {
      TeleScreen.a().a(this.jdField_a_of_type_Int, -3);
      i = 0;
    }
    if (this.jdField_a_of_type_Boolean)
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
      String str3 = this.jdField_a_of_type_JavaLangString;
      if (str3 == null) {
        str3 = "";
      }
      ReportController.b(null, "dc00898", "", "", "0X8009C5A", "0X8009C5A", 0, 0, str1, str2, str3, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.WeakOuterRefRunnable
 * JD-Core Version:    0.7.0.1
 */