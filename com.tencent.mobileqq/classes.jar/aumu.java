import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aumu
  extends aumy
{
  private aesk jdField_a_of_type_Aesk;
  boolean jdField_a_of_type_Boolean = false;
  
  public aumu(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramQQAppInterface, paramFragmentActivity, paramContext, paramViewGroup);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Aesk != null)
    {
      this.jdField_a_of_type_Aesk.a(null);
      this.jdField_a_of_type_Aesk = null;
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_Aesk == null) {
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Aesk.c(true);
      this.jdField_a_of_type_Aesk.b(true);
      this.jdField_a_of_type_Aesk.d();
      this.jdField_a_of_type_Aesk.a(3);
      return;
    }
    this.jdField_a_of_type_Aesk.b(false);
    this.jdField_a_of_type_Aesk.c(false);
    this.jdField_a_of_type_Aesk.a(4);
  }
  
  public void a(aums paramaums)
  {
    super.a(paramaums);
    if (this.jdField_a_of_type_Aesk != null)
    {
      if (a() != 0) {
        this.jdField_a_of_type_Aesk.b(false);
      }
      this.jdField_a_of_type_Aesk.a(a(), a());
      this.jdField_a_of_type_Aesk.b();
    }
  }
  
  public boolean a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_Aesk == null)
    {
      paramBundle = null;
      Bundle localBundle = a();
      if (localBundle != null) {
        paramBundle = localBundle.getString("uin");
      }
      this.jdField_a_of_type_Aesk = new aesk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext, paramBundle);
      this.jdField_a_of_type_Aesk.a(this);
      b(1);
      a(this.jdField_a_of_type_Aesk.a());
    }
    b(this.jdField_a_of_type_Aesk.a());
    if (a() != null) {
      this.jdField_a_of_type_Aesk.a(a(), a());
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Aesk.i();
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
    if (this.jdField_a_of_type_Aesk == null) {
      return;
    }
    if (a() == 0)
    {
      this.jdField_a_of_type_Aesk.b(true);
      this.jdField_a_of_type_Aesk.d();
    }
    for (;;)
    {
      this.jdField_a_of_type_Aesk.p();
      this.jdField_a_of_type_Aesk.i();
      return;
      this.jdField_a_of_type_Aesk.b(false);
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoViewDelegete", 2, "doOnPause() called");
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Aesk == null) {
      return;
    }
    this.jdField_a_of_type_Aesk.h();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Aesk == null) {
      return;
    }
    this.jdField_a_of_type_Aesk.a(true);
    this.jdField_a_of_type_Aesk.b();
  }
  
  public void f() {}
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_Aesk == null) {
      return;
    }
    this.jdField_a_of_type_Aesk.j();
  }
  
  public void h() {}
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Aesk != null) {
      this.jdField_a_of_type_Aesk.r();
    }
  }
  
  public void j()
  {
    super.j();
    if (this.jdField_a_of_type_Aesk != null) {
      this.jdField_a_of_type_Aesk.s();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aumu
 * JD-Core Version:    0.7.0.1
 */