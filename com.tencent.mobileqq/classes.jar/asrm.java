import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class asrm
  extends asrs
{
  private acwl jdField_a_of_type_Acwl;
  boolean jdField_a_of_type_Boolean = false;
  
  public asrm(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramQQAppInterface, paramFragmentActivity, paramContext, paramViewGroup);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Acwl != null)
    {
      this.jdField_a_of_type_Acwl.a(null);
      this.jdField_a_of_type_Acwl = null;
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_Acwl == null) {
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Acwl.c(true);
      this.jdField_a_of_type_Acwl.b(true);
      this.jdField_a_of_type_Acwl.d();
      this.jdField_a_of_type_Acwl.a(3);
      return;
    }
    this.jdField_a_of_type_Acwl.b(false);
    this.jdField_a_of_type_Acwl.c(false);
    this.jdField_a_of_type_Acwl.a(4);
  }
  
  public void a(asrk paramasrk)
  {
    super.a(paramasrk);
    if (this.jdField_a_of_type_Acwl != null)
    {
      if (a() != 0) {
        this.jdField_a_of_type_Acwl.b(false);
      }
      this.jdField_a_of_type_Acwl.a(a(), a());
      this.jdField_a_of_type_Acwl.b();
    }
  }
  
  public boolean a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_Acwl == null)
    {
      paramBundle = null;
      Bundle localBundle = a();
      if (localBundle != null) {
        paramBundle = localBundle.getString("uin");
      }
      this.jdField_a_of_type_Acwl = new acwl(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext, paramBundle);
      this.jdField_a_of_type_Acwl.a(this);
      b(1);
      a(this.jdField_a_of_type_Acwl.a());
    }
    b(this.jdField_a_of_type_Acwl.a());
    if (a() != null) {
      this.jdField_a_of_type_Acwl.a(a(), a());
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Acwl.h();
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
    if (this.jdField_a_of_type_Acwl == null) {
      return;
    }
    if (a() == 0)
    {
      this.jdField_a_of_type_Acwl.b(true);
      this.jdField_a_of_type_Acwl.d();
    }
    for (;;)
    {
      this.jdField_a_of_type_Acwl.o();
      this.jdField_a_of_type_Acwl.h();
      return;
      this.jdField_a_of_type_Acwl.b(false);
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoViewDelegete", 2, "doOnPause() called");
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Acwl == null) {
      return;
    }
    this.jdField_a_of_type_Acwl.g();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Acwl == null) {
      return;
    }
    this.jdField_a_of_type_Acwl.a(true);
    this.jdField_a_of_type_Acwl.b();
  }
  
  public void f() {}
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_Acwl == null) {
      return;
    }
    this.jdField_a_of_type_Acwl.i();
  }
  
  public void h() {}
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Acwl != null) {
      this.jdField_a_of_type_Acwl.q();
    }
  }
  
  public void j()
  {
    super.j();
    if (this.jdField_a_of_type_Acwl != null) {
      this.jdField_a_of_type_Acwl.r();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asrm
 * JD-Core Version:    0.7.0.1
 */