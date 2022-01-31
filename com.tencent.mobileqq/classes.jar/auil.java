import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class auil
  extends auip
{
  private aenv jdField_a_of_type_Aenv;
  boolean jdField_a_of_type_Boolean = false;
  
  public auil(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramQQAppInterface, paramFragmentActivity, paramContext, paramViewGroup);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Aenv != null)
    {
      this.jdField_a_of_type_Aenv.a(null);
      this.jdField_a_of_type_Aenv = null;
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_Aenv == null) {
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Aenv.c(true);
      this.jdField_a_of_type_Aenv.b(true);
      this.jdField_a_of_type_Aenv.d();
      this.jdField_a_of_type_Aenv.a(3);
      return;
    }
    this.jdField_a_of_type_Aenv.b(false);
    this.jdField_a_of_type_Aenv.c(false);
    this.jdField_a_of_type_Aenv.a(4);
  }
  
  public void a(auij paramauij)
  {
    super.a(paramauij);
    if (this.jdField_a_of_type_Aenv != null)
    {
      if (a() != 0) {
        this.jdField_a_of_type_Aenv.b(false);
      }
      this.jdField_a_of_type_Aenv.a(a(), a());
      this.jdField_a_of_type_Aenv.b();
    }
  }
  
  public boolean a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_Aenv == null)
    {
      paramBundle = null;
      Bundle localBundle = a();
      if (localBundle != null) {
        paramBundle = localBundle.getString("uin");
      }
      this.jdField_a_of_type_Aenv = new aenv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext, paramBundle);
      this.jdField_a_of_type_Aenv.a(this);
      b(1);
      a(this.jdField_a_of_type_Aenv.a());
    }
    b(this.jdField_a_of_type_Aenv.a());
    if (a() != null) {
      this.jdField_a_of_type_Aenv.a(a(), a());
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Aenv.i();
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
    if (this.jdField_a_of_type_Aenv == null) {
      return;
    }
    if (a() == 0)
    {
      this.jdField_a_of_type_Aenv.b(true);
      this.jdField_a_of_type_Aenv.d();
    }
    for (;;)
    {
      this.jdField_a_of_type_Aenv.p();
      this.jdField_a_of_type_Aenv.i();
      return;
      this.jdField_a_of_type_Aenv.b(false);
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoViewDelegete", 2, "doOnPause() called");
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Aenv == null) {
      return;
    }
    this.jdField_a_of_type_Aenv.h();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Aenv == null) {
      return;
    }
    this.jdField_a_of_type_Aenv.a(true);
    this.jdField_a_of_type_Aenv.b();
  }
  
  public void f() {}
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_Aenv == null) {
      return;
    }
    this.jdField_a_of_type_Aenv.j();
  }
  
  public void h() {}
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Aenv != null) {
      this.jdField_a_of_type_Aenv.r();
    }
  }
  
  public void j()
  {
    super.j();
    if (this.jdField_a_of_type_Aenv != null) {
      this.jdField_a_of_type_Aenv.s();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auil
 * JD-Core Version:    0.7.0.1
 */