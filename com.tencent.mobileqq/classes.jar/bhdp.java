import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class bhdp
  implements bhvg, bhwq, bhzd
{
  private bhwh jdField_a_of_type_Bhwh = new bhwh(this);
  private bhwp jdField_a_of_type_Bhwp;
  
  public View a()
  {
    return null;
  }
  
  public bhvc a()
  {
    return this.jdField_a_of_type_Bhwh;
  }
  
  @NonNull
  public bhwp a()
  {
    if (BaseApplicationImpl.getApplication() == null) {
      throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }
    if (this.jdField_a_of_type_Bhwp == null) {
      this.jdField_a_of_type_Bhwp = new bhwp();
    }
    return this.jdField_a_of_type_Bhwp;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Intent paramIntent) {}
  
  @CallSuper
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_Bhwh = new bhwh(this);
    try
    {
      this.jdField_a_of_type_Bhwh.a(bhvd.a);
      return;
    }
    catch (Throwable paramBundle)
    {
      QLog.e("QIMCameraLifeCycleBaseUnit", 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent, boolean paramBoolean)
  {
    return false;
  }
  
  public boolean a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    return false;
  }
  
  public void b(Bundle paramBundle) {}
  
  public void b_(int paramInt1, int paramInt2) {}
  
  @CallSuper
  public void d()
  {
    try
    {
      this.jdField_a_of_type_Bhwh.a(bhvd.d);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QIMCameraLifeCycleBaseUnit", 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  @CallSuper
  public void e()
  {
    try
    {
      this.jdField_a_of_type_Bhwh.a(bhvd.f);
      if (this.jdField_a_of_type_Bhwp != null) {
        this.jdField_a_of_type_Bhwp.a();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("QIMCameraLifeCycleBaseUnit", 1, "mLifecycleRegistry 初始化失败");
      }
    }
  }
  
  @CallSuper
  public void f()
  {
    try
    {
      this.jdField_a_of_type_Bhwh.a(bhvd.c);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QIMCameraLifeCycleBaseUnit", 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  public void p() {}
  
  @CallSuper
  public void q()
  {
    try
    {
      this.jdField_a_of_type_Bhwh.a(bhvd.b);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QIMCameraLifeCycleBaseUnit", 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  @CallSuper
  public void r()
  {
    try
    {
      this.jdField_a_of_type_Bhwh.a(bhvd.e);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QIMCameraLifeCycleBaseUnit", 1, "mLifecycleRegistry 初始化失败");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhdp
 * JD-Core Version:    0.7.0.1
 */