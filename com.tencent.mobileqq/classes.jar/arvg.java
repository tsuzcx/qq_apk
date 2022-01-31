import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class arvg
  extends arvm
{
  private aclw jdField_a_of_type_Aclw;
  boolean jdField_a_of_type_Boolean = false;
  
  public arvg(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramQQAppInterface, paramFragmentActivity, paramContext, paramViewGroup);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Aclw != null)
    {
      this.jdField_a_of_type_Aclw.a(null);
      this.jdField_a_of_type_Aclw = null;
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_Aclw == null) {
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Aclw.c(true);
      this.jdField_a_of_type_Aclw.b(true);
      this.jdField_a_of_type_Aclw.d();
      this.jdField_a_of_type_Aclw.a(3);
      return;
    }
    this.jdField_a_of_type_Aclw.b(false);
    this.jdField_a_of_type_Aclw.c(false);
    this.jdField_a_of_type_Aclw.a(4);
  }
  
  public void a(arve paramarve)
  {
    super.a(paramarve);
    if (this.jdField_a_of_type_Aclw != null)
    {
      if (a() != 0) {
        this.jdField_a_of_type_Aclw.b(false);
      }
      this.jdField_a_of_type_Aclw.a(a(), a());
      this.jdField_a_of_type_Aclw.b();
    }
  }
  
  public boolean a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_Aclw == null)
    {
      paramBundle = null;
      Bundle localBundle = a();
      if (localBundle != null) {
        paramBundle = localBundle.getString("uin");
      }
      this.jdField_a_of_type_Aclw = new aclw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext, paramBundle);
      this.jdField_a_of_type_Aclw.a(this);
      b(1);
      a(this.jdField_a_of_type_Aclw.a());
    }
    b(this.jdField_a_of_type_Aclw.a());
    if (a() != null) {
      this.jdField_a_of_type_Aclw.a(a(), a());
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Aclw.h();
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
    if (this.jdField_a_of_type_Aclw == null) {
      return;
    }
    if (a() == 0)
    {
      this.jdField_a_of_type_Aclw.b(true);
      this.jdField_a_of_type_Aclw.d();
    }
    for (;;)
    {
      this.jdField_a_of_type_Aclw.o();
      this.jdField_a_of_type_Aclw.h();
      return;
      this.jdField_a_of_type_Aclw.b(false);
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoViewDelegete", 2, "doOnPause() called");
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Aclw == null) {
      return;
    }
    this.jdField_a_of_type_Aclw.g();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Aclw == null) {
      return;
    }
    this.jdField_a_of_type_Aclw.a(true);
    this.jdField_a_of_type_Aclw.b();
  }
  
  public void f() {}
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_Aclw == null) {
      return;
    }
    this.jdField_a_of_type_Aclw.i();
  }
  
  public void h() {}
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Aclw != null) {
      this.jdField_a_of_type_Aclw.q();
    }
  }
  
  public void j()
  {
    super.j();
    if (this.jdField_a_of_type_Aclw != null) {
      this.jdField_a_of_type_Aclw.r();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arvg
 * JD-Core Version:    0.7.0.1
 */