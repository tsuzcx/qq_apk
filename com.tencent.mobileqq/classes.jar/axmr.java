import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class axmr
  extends axmv
{
  private agiq jdField_a_of_type_Agiq;
  boolean jdField_a_of_type_Boolean = false;
  
  public axmr(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramQQAppInterface, paramFragmentActivity, paramContext, paramViewGroup);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Agiq != null)
    {
      this.jdField_a_of_type_Agiq.a(null);
      this.jdField_a_of_type_Agiq = null;
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_Agiq == null) {
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Agiq.c(true);
      this.jdField_a_of_type_Agiq.b(true);
      this.jdField_a_of_type_Agiq.d();
      this.jdField_a_of_type_Agiq.a(3);
      return;
    }
    this.jdField_a_of_type_Agiq.b(false);
    this.jdField_a_of_type_Agiq.c(false);
    this.jdField_a_of_type_Agiq.a(4);
  }
  
  public void a(axmp paramaxmp)
  {
    super.a(paramaxmp);
    if (this.jdField_a_of_type_Agiq != null)
    {
      if (a() != 0) {
        this.jdField_a_of_type_Agiq.b(false);
      }
      this.jdField_a_of_type_Agiq.a(a(), a());
      this.jdField_a_of_type_Agiq.b();
    }
  }
  
  public boolean a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_Agiq == null)
    {
      paramBundle = null;
      Bundle localBundle = a();
      if (localBundle != null) {
        paramBundle = localBundle.getString("uin");
      }
      this.jdField_a_of_type_Agiq = new agiq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext, paramBundle);
      this.jdField_a_of_type_Agiq.a(this);
      b(1);
      a(this.jdField_a_of_type_Agiq.a());
    }
    b(this.jdField_a_of_type_Agiq.a());
    if (a() != null) {
      this.jdField_a_of_type_Agiq.a(a(), a());
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Agiq.i();
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
    if (this.jdField_a_of_type_Agiq == null) {
      return;
    }
    if (a() == 0)
    {
      this.jdField_a_of_type_Agiq.b(true);
      this.jdField_a_of_type_Agiq.d();
    }
    for (;;)
    {
      this.jdField_a_of_type_Agiq.n();
      this.jdField_a_of_type_Agiq.i();
      return;
      this.jdField_a_of_type_Agiq.b(false);
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoViewDelegete", 2, "doOnPause() called");
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Agiq == null) {
      return;
    }
    this.jdField_a_of_type_Agiq.h();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Agiq == null) {
      return;
    }
    this.jdField_a_of_type_Agiq.a(true);
    this.jdField_a_of_type_Agiq.b();
  }
  
  public void f() {}
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_Agiq == null) {
      return;
    }
    this.jdField_a_of_type_Agiq.j();
  }
  
  public void h() {}
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Agiq != null) {
      this.jdField_a_of_type_Agiq.p();
    }
  }
  
  public void j()
  {
    super.j();
    if (this.jdField_a_of_type_Agiq != null) {
      this.jdField_a_of_type_Agiq.q();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axmr
 * JD-Core Version:    0.7.0.1
 */