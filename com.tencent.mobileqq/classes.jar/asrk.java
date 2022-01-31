import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class asrk
  extends asrq
{
  private acwp jdField_a_of_type_Acwp;
  boolean jdField_a_of_type_Boolean = false;
  
  public asrk(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramQQAppInterface, paramFragmentActivity, paramContext, paramViewGroup);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Acwp != null)
    {
      this.jdField_a_of_type_Acwp.a(null);
      this.jdField_a_of_type_Acwp = null;
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_Acwp == null) {
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Acwp.c(true);
      this.jdField_a_of_type_Acwp.b(true);
      this.jdField_a_of_type_Acwp.d();
      this.jdField_a_of_type_Acwp.a(3);
      return;
    }
    this.jdField_a_of_type_Acwp.b(false);
    this.jdField_a_of_type_Acwp.c(false);
    this.jdField_a_of_type_Acwp.a(4);
  }
  
  public void a(asri paramasri)
  {
    super.a(paramasri);
    if (this.jdField_a_of_type_Acwp != null)
    {
      if (a() != 0) {
        this.jdField_a_of_type_Acwp.b(false);
      }
      this.jdField_a_of_type_Acwp.a(a(), a());
      this.jdField_a_of_type_Acwp.b();
    }
  }
  
  public boolean a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_Acwp == null)
    {
      paramBundle = null;
      Bundle localBundle = a();
      if (localBundle != null) {
        paramBundle = localBundle.getString("uin");
      }
      this.jdField_a_of_type_Acwp = new acwp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext, paramBundle);
      this.jdField_a_of_type_Acwp.a(this);
      b(1);
      a(this.jdField_a_of_type_Acwp.a());
    }
    b(this.jdField_a_of_type_Acwp.a());
    if (a() != null) {
      this.jdField_a_of_type_Acwp.a(a(), a());
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Acwp.h();
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
    if (this.jdField_a_of_type_Acwp == null) {
      return;
    }
    if (a() == 0)
    {
      this.jdField_a_of_type_Acwp.b(true);
      this.jdField_a_of_type_Acwp.d();
    }
    for (;;)
    {
      this.jdField_a_of_type_Acwp.o();
      this.jdField_a_of_type_Acwp.h();
      return;
      this.jdField_a_of_type_Acwp.b(false);
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoViewDelegete", 2, "doOnPause() called");
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Acwp == null) {
      return;
    }
    this.jdField_a_of_type_Acwp.g();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Acwp == null) {
      return;
    }
    this.jdField_a_of_type_Acwp.a(true);
    this.jdField_a_of_type_Acwp.b();
  }
  
  public void f() {}
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_Acwp == null) {
      return;
    }
    this.jdField_a_of_type_Acwp.i();
  }
  
  public void h() {}
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Acwp != null) {
      this.jdField_a_of_type_Acwp.q();
    }
  }
  
  public void j()
  {
    super.j();
    if (this.jdField_a_of_type_Acwp != null) {
      this.jdField_a_of_type_Acwp.r();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asrk
 * JD-Core Version:    0.7.0.1
 */