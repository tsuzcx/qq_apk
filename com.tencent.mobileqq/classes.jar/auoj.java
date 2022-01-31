import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class auoj
  extends aumy
{
  private afhd a;
  
  public auoj(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramQQAppInterface, paramFragmentActivity, paramContext, paramViewGroup);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Afhd != null)
    {
      this.jdField_a_of_type_Afhd.a(null);
      this.jdField_a_of_type_Afhd = null;
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_Afhd == null) {
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Afhd.c(true);
      this.jdField_a_of_type_Afhd.b(true);
      this.jdField_a_of_type_Afhd.d();
      return;
    }
    this.jdField_a_of_type_Afhd.b(false);
    this.jdField_a_of_type_Afhd.c(false);
  }
  
  public void a(aums paramaums)
  {
    super.a(paramaums);
    if (this.jdField_a_of_type_Afhd != null)
    {
      if (a() != 0) {
        this.jdField_a_of_type_Afhd.b(false);
      }
      this.jdField_a_of_type_Afhd.a(a(), a());
      this.jdField_a_of_type_Afhd.b();
    }
  }
  
  public boolean a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_Afhd == null)
    {
      paramBundle = null;
      Bundle localBundle = a();
      if (localBundle != null) {
        paramBundle = localBundle.getString("uin");
      }
      this.jdField_a_of_type_Afhd = new afhd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext, paramBundle);
      this.jdField_a_of_type_Afhd.a(this);
      b(1);
      a(this.jdField_a_of_type_Afhd.a());
    }
    b(this.jdField_a_of_type_Afhd.a());
    if (a() != null) {
      this.jdField_a_of_type_Afhd.a(a(), a());
    }
    return true;
  }
  
  public void b() {}
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StrangerIntimateViewDelegete", 2, "doOnResume() called");
    }
    if (this.jdField_a_of_type_Afhd == null) {
      return;
    }
    if (a() == 0)
    {
      this.jdField_a_of_type_Afhd.b(true);
      this.jdField_a_of_type_Afhd.d();
    }
    for (;;)
    {
      this.jdField_a_of_type_Afhd.p();
      return;
      this.jdField_a_of_type_Afhd.b(false);
      this.jdField_a_of_type_Afhd.e();
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
    if (this.jdField_a_of_type_Afhd == null) {
      return;
    }
    this.jdField_a_of_type_Afhd.a(true);
    this.jdField_a_of_type_Afhd.b();
  }
  
  public void f() {}
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_Afhd == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_Afhd.a());
      this.jdField_a_of_type_AndroidViewViewGroup = null;
    }
    this.jdField_a_of_type_Afhd.j();
  }
  
  public void h() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auoj
 * JD-Core Version:    0.7.0.1
 */