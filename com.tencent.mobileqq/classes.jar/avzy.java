import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class avzy
  extends awac
{
  private afbj jdField_a_of_type_Afbj;
  boolean jdField_a_of_type_Boolean = false;
  
  public avzy(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramQQAppInterface, paramFragmentActivity, paramContext, paramViewGroup);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Afbj != null)
    {
      this.jdField_a_of_type_Afbj.a(null);
      this.jdField_a_of_type_Afbj = null;
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_Afbj == null) {
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Afbj.c(true);
      this.jdField_a_of_type_Afbj.b(true);
      this.jdField_a_of_type_Afbj.d();
      this.jdField_a_of_type_Afbj.a(3);
      return;
    }
    this.jdField_a_of_type_Afbj.b(false);
    this.jdField_a_of_type_Afbj.c(false);
    this.jdField_a_of_type_Afbj.a(4);
  }
  
  public void a(avzw paramavzw)
  {
    super.a(paramavzw);
    if (this.jdField_a_of_type_Afbj != null)
    {
      if (a() != 0) {
        this.jdField_a_of_type_Afbj.b(false);
      }
      this.jdField_a_of_type_Afbj.a(a(), a());
      this.jdField_a_of_type_Afbj.b();
    }
  }
  
  public boolean a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_Afbj == null)
    {
      paramBundle = null;
      Bundle localBundle = a();
      if (localBundle != null) {
        paramBundle = localBundle.getString("uin");
      }
      this.jdField_a_of_type_Afbj = new afbj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext, paramBundle);
      this.jdField_a_of_type_Afbj.a(this);
      b(1);
      a(this.jdField_a_of_type_Afbj.a());
    }
    b(this.jdField_a_of_type_Afbj.a());
    if (a() != null) {
      this.jdField_a_of_type_Afbj.a(a(), a());
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Afbj.i();
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
    if (this.jdField_a_of_type_Afbj == null) {
      return;
    }
    if (a() == 0)
    {
      this.jdField_a_of_type_Afbj.b(true);
      this.jdField_a_of_type_Afbj.d();
    }
    for (;;)
    {
      this.jdField_a_of_type_Afbj.n();
      this.jdField_a_of_type_Afbj.i();
      return;
      this.jdField_a_of_type_Afbj.b(false);
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoViewDelegete", 2, "doOnPause() called");
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Afbj == null) {
      return;
    }
    this.jdField_a_of_type_Afbj.h();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Afbj == null) {
      return;
    }
    this.jdField_a_of_type_Afbj.a(true);
    this.jdField_a_of_type_Afbj.b();
  }
  
  public void f() {}
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_Afbj == null) {
      return;
    }
    this.jdField_a_of_type_Afbj.j();
  }
  
  public void h() {}
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Afbj != null) {
      this.jdField_a_of_type_Afbj.p();
    }
  }
  
  public void j()
  {
    super.j();
    if (this.jdField_a_of_type_Afbj != null) {
      this.jdField_a_of_type_Afbj.q();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avzy
 * JD-Core Version:    0.7.0.1
 */