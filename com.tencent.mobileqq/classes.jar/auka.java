import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class auka
  extends auip
{
  private afco a;
  
  public auka(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramQQAppInterface, paramFragmentActivity, paramContext, paramViewGroup);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Afco != null)
    {
      this.jdField_a_of_type_Afco.a(null);
      this.jdField_a_of_type_Afco = null;
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_Afco == null) {
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Afco.c(true);
      this.jdField_a_of_type_Afco.b(true);
      this.jdField_a_of_type_Afco.d();
      return;
    }
    this.jdField_a_of_type_Afco.b(false);
    this.jdField_a_of_type_Afco.c(false);
  }
  
  public void a(auij paramauij)
  {
    super.a(paramauij);
    if (this.jdField_a_of_type_Afco != null)
    {
      if (a() != 0) {
        this.jdField_a_of_type_Afco.b(false);
      }
      this.jdField_a_of_type_Afco.a(a(), a());
      this.jdField_a_of_type_Afco.b();
    }
  }
  
  public boolean a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_Afco == null)
    {
      paramBundle = null;
      Bundle localBundle = a();
      if (localBundle != null) {
        paramBundle = localBundle.getString("uin");
      }
      this.jdField_a_of_type_Afco = new afco(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext, paramBundle);
      this.jdField_a_of_type_Afco.a(this);
      b(1);
      a(this.jdField_a_of_type_Afco.a());
    }
    b(this.jdField_a_of_type_Afco.a());
    if (a() != null) {
      this.jdField_a_of_type_Afco.a(a(), a());
    }
    return true;
  }
  
  public void b() {}
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StrangerIntimateViewDelegete", 2, "doOnResume() called");
    }
    if (this.jdField_a_of_type_Afco == null) {
      return;
    }
    if (a() == 0)
    {
      this.jdField_a_of_type_Afco.b(true);
      this.jdField_a_of_type_Afco.d();
    }
    for (;;)
    {
      this.jdField_a_of_type_Afco.p();
      return;
      this.jdField_a_of_type_Afco.b(false);
      this.jdField_a_of_type_Afco.e();
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StrangerIntimateViewDelegete", 2, "doOnPause() called");
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Afco == null) {
      return;
    }
    this.jdField_a_of_type_Afco.a(true);
    this.jdField_a_of_type_Afco.b();
  }
  
  public void f() {}
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_Afco == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_Afco.a());
      this.jdField_a_of_type_AndroidViewViewGroup = null;
    }
    this.jdField_a_of_type_Afco.j();
  }
  
  public void h() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auka
 * JD-Core Version:    0.7.0.1
 */