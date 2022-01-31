import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class bkis
  implements blzb, bmam, bmcw
{
  private bmad jdField_a_of_type_Bmad = new bmad(this);
  private bmal jdField_a_of_type_Bmal;
  
  public View a()
  {
    return null;
  }
  
  public blyx a()
  {
    return this.jdField_a_of_type_Bmad;
  }
  
  @NonNull
  public bmal a()
  {
    if (BaseApplicationImpl.getApplication() == null) {
      throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }
    if (this.jdField_a_of_type_Bmal == null) {
      this.jdField_a_of_type_Bmal = new bmal();
    }
    return this.jdField_a_of_type_Bmal;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Intent paramIntent) {}
  
  @CallSuper
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_Bmad = new bmad(this);
    try
    {
      this.jdField_a_of_type_Bmad.a(blyy.a);
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
      this.jdField_a_of_type_Bmad.a(blyy.d);
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
      this.jdField_a_of_type_Bmad.a(blyy.f);
      if (this.jdField_a_of_type_Bmal != null) {
        this.jdField_a_of_type_Bmal.a();
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
      this.jdField_a_of_type_Bmad.a(blyy.c);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QIMCameraLifeCycleBaseUnit", 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  @CallSuper
  public void p()
  {
    try
    {
      this.jdField_a_of_type_Bmad.a(blyy.b);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QIMCameraLifeCycleBaseUnit", 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  public void s() {}
  
  @CallSuper
  public void t()
  {
    try
    {
      this.jdField_a_of_type_Bmad.a(blyy.e);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QIMCameraLifeCycleBaseUnit", 1, "mLifecycleRegistry 初始化失败");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkis
 * JD-Core Version:    0.7.0.1
 */