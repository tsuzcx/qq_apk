import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class axga
  extends axge
{
  private afsv jdField_a_of_type_Afsv;
  boolean jdField_a_of_type_Boolean = false;
  
  public axga(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramQQAppInterface, paramFragmentActivity, paramContext, paramViewGroup);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Afsv != null)
    {
      this.jdField_a_of_type_Afsv.a(null);
      this.jdField_a_of_type_Afsv = null;
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_Afsv == null) {
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Afsv.c(true);
      this.jdField_a_of_type_Afsv.b(true);
      this.jdField_a_of_type_Afsv.c();
      this.jdField_a_of_type_Afsv.a(3);
      return;
    }
    this.jdField_a_of_type_Afsv.b(false);
    this.jdField_a_of_type_Afsv.c(false);
    this.jdField_a_of_type_Afsv.a(4);
  }
  
  public void a(axfy paramaxfy)
  {
    super.a(paramaxfy);
    if (this.jdField_a_of_type_Afsv != null)
    {
      if (a() != 0) {
        this.jdField_a_of_type_Afsv.b(false);
      }
      this.jdField_a_of_type_Afsv.a(a(), a());
      this.jdField_a_of_type_Afsv.b();
    }
  }
  
  public boolean a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_Afsv == null)
    {
      paramBundle = null;
      Bundle localBundle = a();
      if (localBundle != null) {
        paramBundle = localBundle.getString("uin");
      }
      this.jdField_a_of_type_Afsv = new afsv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext, paramBundle);
      this.jdField_a_of_type_Afsv.a(this);
      b(1);
      a(this.jdField_a_of_type_Afsv.a());
    }
    b(this.jdField_a_of_type_Afsv.a());
    if (a() != null) {
      this.jdField_a_of_type_Afsv.a(a(), a());
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Afsv.h();
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
    if (this.jdField_a_of_type_Afsv == null) {
      return;
    }
    if (a() == 0)
    {
      this.jdField_a_of_type_Afsv.b(true);
      this.jdField_a_of_type_Afsv.c();
    }
    for (;;)
    {
      this.jdField_a_of_type_Afsv.l();
      this.jdField_a_of_type_Afsv.h();
      return;
      this.jdField_a_of_type_Afsv.b(false);
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoViewDelegete", 2, "doOnPause() called");
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Afsv == null) {
      return;
    }
    this.jdField_a_of_type_Afsv.g();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Afsv == null) {
      return;
    }
    this.jdField_a_of_type_Afsv.a(true);
    this.jdField_a_of_type_Afsv.b();
  }
  
  public void f() {}
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_Afsv == null) {
      return;
    }
    this.jdField_a_of_type_Afsv.i();
  }
  
  public void h() {}
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Afsv != null) {
      this.jdField_a_of_type_Afsv.n();
    }
  }
  
  public void j()
  {
    super.j();
    if (this.jdField_a_of_type_Afsv != null) {
      this.jdField_a_of_type_Afsv.o();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axga
 * JD-Core Version:    0.7.0.1
 */