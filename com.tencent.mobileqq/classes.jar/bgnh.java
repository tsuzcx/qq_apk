import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.widget.QQToast.ProtectedToast.1;
import com.tencent.qqmini.sdk.log.QMLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class bgnh
  extends Toast
{
  private static WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  private static Class jdField_a_of_type_JavaLangClass;
  private static Field jdField_a_of_type_JavaLangReflectField;
  private static Method jdField_a_of_type_JavaLangReflectMethod;
  private static Field jdField_b_of_type_JavaLangReflectField;
  private static Method jdField_b_of_type_JavaLangReflectMethod;
  public Runnable a;
  
  public bgnh(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRunnable = new QQToast.ProtectedToast.1(this);
  }
  
  public void cancel()
  {
    try
    {
      QMLog.d("QQToast", "cancel!");
      ThreadManager.c().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      if (!bgnf.a(getView().getContext(), false))
      {
        super.cancel();
        return;
      }
      Object localObject = jdField_a_of_type_JavaLangReflectField.get(this);
      if (jdField_b_of_type_JavaLangReflectMethod == null)
      {
        jdField_b_of_type_JavaLangReflectMethod = jdField_a_of_type_JavaLangClass.getDeclaredMethod("hide", new Class[0]);
        jdField_b_of_type_JavaLangReflectMethod.setAccessible(true);
      }
      jdField_b_of_type_JavaLangReflectMethod.invoke(localObject, new Object[0]);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.d("QQToast", "", localThrowable);
      if ((localThrowable instanceof NoSuchMethodException)) {
        super.cancel();
      }
    }
  }
  
  public void show()
  {
    try
    {
      if (getView() == null) {
        throw new RuntimeException("setView must have been called");
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.d("QQToast", "", localThrowable);
      if (((localThrowable instanceof NoSuchMethodException)) || ((localThrowable instanceof NoSuchFieldException))) {
        super.show();
      }
      return;
    }
    if (jdField_a_of_type_JavaLangReflectField == null)
    {
      jdField_a_of_type_JavaLangReflectField = Toast.class.getDeclaredField("mTN");
      jdField_a_of_type_JavaLangReflectField.setAccessible(true);
    }
    Object localObject1 = jdField_a_of_type_JavaLangReflectField.get(this);
    Object localObject2;
    if (bgnf.a())
    {
      localObject2 = localObject1.getClass().getDeclaredField("mParams");
      ((Field)localObject2).setAccessible(true);
      jdField_a_of_type_AndroidViewWindowManager$LayoutParams = (WindowManager.LayoutParams)((Field)localObject2).get(localObject1);
      jdField_a_of_type_AndroidViewWindowManager$LayoutParams.flags = 40;
      jdField_a_of_type_AndroidViewWindowManager$LayoutParams.windowAnimations = 2131755769;
    }
    for (;;)
    {
      try
      {
        if (("" + Build.MANUFACTURER).equalsIgnoreCase("SAMSUNG")) {
          jdField_a_of_type_AndroidViewWindowManager$LayoutParams.getClass().getField("layoutInDisplayCutoutMode").setInt(jdField_a_of_type_AndroidViewWindowManager$LayoutParams, 1);
        }
        localObject2 = (TextView)getView().findViewById(2131378059);
        if ((localObject2 != null) && (((TextView)localObject2).getText().length() < 6))
        {
          l = 900L;
          ThreadManager.c().postDelayed(this.jdField_a_of_type_JavaLangRunnable, l);
          QMLog.d("QQToast", "show");
          if (!bgnf.a(getView().getContext(), false))
          {
            super.show();
            return;
          }
        }
      }
      catch (Exception localException)
      {
        QMLog.e("QQToast", localException.getMessage(), localException);
        continue;
        if (jdField_a_of_type_JavaLangClass == null) {
          jdField_a_of_type_JavaLangClass = Class.forName("android.widget.Toast$TN");
        }
        if (jdField_b_of_type_JavaLangReflectField == null)
        {
          jdField_b_of_type_JavaLangReflectField = jdField_a_of_type_JavaLangClass.getDeclaredField("mNextView");
          jdField_b_of_type_JavaLangReflectField.setAccessible(true);
        }
        jdField_b_of_type_JavaLangReflectField.set(localObject1, getView());
        if (jdField_a_of_type_JavaLangReflectMethod == null)
        {
          jdField_a_of_type_JavaLangReflectMethod = jdField_a_of_type_JavaLangClass.getDeclaredMethod("show", new Class[0]);
          jdField_a_of_type_JavaLangReflectMethod.setAccessible(true);
        }
        jdField_a_of_type_JavaLangReflectMethod.invoke(localObject1, new Object[0]);
        return;
      }
      long l = 1900L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgnh
 * JD-Core Version:    0.7.0.1
 */