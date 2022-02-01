import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class awty
  extends awuc
{
  private afyw jdField_a_of_type_Afyw;
  boolean jdField_a_of_type_Boolean = false;
  
  public awty(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramQQAppInterface, paramFragmentActivity, paramContext, paramViewGroup);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Afyw != null)
    {
      this.jdField_a_of_type_Afyw.a(null);
      this.jdField_a_of_type_Afyw = null;
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_Afyw == null) {
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Afyw.c(true);
      this.jdField_a_of_type_Afyw.b(true);
      this.jdField_a_of_type_Afyw.d();
      this.jdField_a_of_type_Afyw.a(3);
      return;
    }
    this.jdField_a_of_type_Afyw.b(false);
    this.jdField_a_of_type_Afyw.c(false);
    this.jdField_a_of_type_Afyw.a(4);
  }
  
  public void a(awtw paramawtw)
  {
    super.a(paramawtw);
    if (this.jdField_a_of_type_Afyw != null)
    {
      if (a() != 0) {
        this.jdField_a_of_type_Afyw.b(false);
      }
      this.jdField_a_of_type_Afyw.a(a(), a());
      this.jdField_a_of_type_Afyw.b();
    }
  }
  
  public boolean a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_Afyw == null)
    {
      paramBundle = null;
      Bundle localBundle = a();
      if (localBundle != null) {
        paramBundle = localBundle.getString("uin");
      }
      this.jdField_a_of_type_Afyw = new afyw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext, paramBundle);
      this.jdField_a_of_type_Afyw.a(this);
      b(1);
      a(this.jdField_a_of_type_Afyw.a());
    }
    b(this.jdField_a_of_type_Afyw.a());
    if (a() != null) {
      this.jdField_a_of_type_Afyw.a(a(), a());
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Afyw.i();
    }
    return true;
  }
  
  public void b() {}
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoViewDelegete", 2, "doOnResume() called");
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Afyw == null) {
      return;
    }
    if (a() == 0)
    {
      this.jdField_a_of_type_Afyw.b(true);
      this.jdField_a_of_type_Afyw.d();
    }
    for (;;)
    {
      this.jdField_a_of_type_Afyw.n();
      this.jdField_a_of_type_Afyw.i();
      return;
      this.jdField_a_of_type_Afyw.b(false);
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoViewDelegete", 2, "doOnPause() called");
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Afyw == null) {
      return;
    }
    this.jdField_a_of_type_Afyw.h();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Afyw == null) {
      return;
    }
    this.jdField_a_of_type_Afyw.a(true);
    this.jdField_a_of_type_Afyw.b();
  }
  
  public void f() {}
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_Afyw == null) {
      return;
    }
    this.jdField_a_of_type_Afyw.j();
  }
  
  public void h() {}
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Afyw != null) {
      this.jdField_a_of_type_Afyw.p();
    }
  }
  
  public void j()
  {
    super.j();
    if (this.jdField_a_of_type_Afyw != null) {
      this.jdField_a_of_type_Afyw.q();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awty
 * JD-Core Version:    0.7.0.1
 */