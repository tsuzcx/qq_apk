package com.tencent.mobileqq.bigbrother;

import apdi;
import bcef;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public class WeakOuterRefRunnable
  implements Runnable
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
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaLangRunnable.getClass();
    try
    {
      localObject = ((Class)localObject).getDeclaredField("this$0");
      ((Field)localObject).setAccessible(true);
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(((Field)localObject).get(this.jdField_a_of_type_JavaLangRunnable));
      ((Field)localObject).set(this.jdField_a_of_type_JavaLangRunnable, null);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      QLog.e("WeakOuterRefRunnable", 1, localNoSuchFieldException, new Object[0]);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      QLog.e("WeakOuterRefRunnable", 1, localIllegalArgumentException, new Object[0]);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      QLog.e("WeakOuterRefRunnable", 1, localIllegalAccessException, new Object[0]);
    }
  }
  
  private boolean a()
  {
    Object localObject;
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRunnable != null))
    {
      localObject = this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject == null) {
        return false;
      }
    }
    try
    {
      Field localField = this.jdField_a_of_type_JavaLangRunnable.getClass().getDeclaredField("this$0");
      localField.setAccessible(true);
      localField.set(this.jdField_a_of_type_JavaLangRunnable, localObject);
      return true;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      QLog.e("WeakOuterRefRunnable", 1, localNoSuchFieldException, new Object[0]);
      return false;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      QLog.e("WeakOuterRefRunnable", 1, localIllegalArgumentException, new Object[0]);
      return false;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      QLog.e("WeakOuterRefRunnable", 1, localIllegalAccessException, new Object[0]);
    }
    return false;
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
    String str1;
    label53:
    String str2;
    if ((this.jdField_a_of_type_JavaLangRunnable != null) && (a()))
    {
      this.jdField_a_of_type_JavaLangRunnable.run();
      apdi.a().a(this.jdField_a_of_type_Int, this.b);
      i = 1;
      if (this.jdField_a_of_type_Boolean)
      {
        if (i == 0) {
          break label111;
        }
        str1 = "1";
        if (i == 0) {
          break label117;
        }
        str2 = "";
        label60:
        if (this.jdField_a_of_type_JavaLangString != null) {
          break label123;
        }
      }
    }
    label111:
    label117:
    label123:
    for (String str3 = "";; str3 = this.jdField_a_of_type_JavaLangString)
    {
      bcef.b(null, "dc00898", "", "", "0X8009C5A", "0X8009C5A", 0, 0, str1, str2, str3, "");
      return;
      apdi.a().a(this.jdField_a_of_type_Int, -3);
      i = 0;
      break;
      str1 = "";
      break label53;
      str2 = "1";
      break label60;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.WeakOuterRefRunnable
 * JD-Core Version:    0.7.0.1
 */