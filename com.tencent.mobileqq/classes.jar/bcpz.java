import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast.ProtectedToast.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import mqq.os.MqqHandler;

public class bcpz
  extends Toast
{
  private static WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  private static Class jdField_a_of_type_JavaLangClass;
  private static Field jdField_a_of_type_JavaLangReflectField;
  private static Method jdField_a_of_type_JavaLangReflectMethod;
  private static Field jdField_b_of_type_JavaLangReflectField;
  private static Method jdField_b_of_type_JavaLangReflectMethod;
  public Runnable a;
  
  public bcpz(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRunnable = new QQToast.ProtectedToast.1(this);
  }
  
  public void cancel()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQToast", 2, new Object[] { "", "cancel!" });
      }
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      if (!bcpw.a(false))
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
      if (QLog.isColorLevel()) {
        QLog.d("QQToast", 2, "", localThrowable);
      }
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
      if (QLog.isColorLevel()) {
        QLog.d("QQToast", 2, "", localThrowable);
      }
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
    if (bcpw.a())
    {
      localObject2 = localObject1.getClass().getDeclaredField("mParams");
      ((Field)localObject2).setAccessible(true);
      jdField_a_of_type_AndroidViewWindowManager$LayoutParams = (WindowManager.LayoutParams)((Field)localObject2).get(localObject1);
      jdField_a_of_type_AndroidViewWindowManager$LayoutParams.flags = 40;
      jdField_a_of_type_AndroidViewWindowManager$LayoutParams.windowAnimations = 2131755528;
    }
    for (;;)
    {
      try
      {
        if (("" + Build.MANUFACTURER).equalsIgnoreCase("SAMSUNG")) {
          jdField_a_of_type_AndroidViewWindowManager$LayoutParams.getClass().getField("layoutInDisplayCutoutMode").setInt(jdField_a_of_type_AndroidViewWindowManager$LayoutParams, 1);
        }
        localObject2 = (TextView)getView().findViewById(2131377522);
        if ((localObject2 != null) && (((TextView)localObject2).getText().length() < 6))
        {
          l = 900L;
          ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, l);
          if (QLog.isColorLevel()) {
            QLog.d("QQToast", 2, "show");
          }
          if (!bcpw.a(false))
          {
            super.show();
            return;
          }
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("QQToast", 2, QLog.getStackTraceString(localException));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bcpz
 * JD-Core Version:    0.7.0.1
 */