import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class axhp
  extends axge
{
  private aglx a;
  
  public axhp(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramQQAppInterface, paramFragmentActivity, paramContext, paramViewGroup);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Aglx != null)
    {
      this.jdField_a_of_type_Aglx.a(null);
      this.jdField_a_of_type_Aglx = null;
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_Aglx == null) {
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Aglx.c(true);
      this.jdField_a_of_type_Aglx.b(true);
      this.jdField_a_of_type_Aglx.c();
      return;
    }
    this.jdField_a_of_type_Aglx.b(false);
    this.jdField_a_of_type_Aglx.c(false);
  }
  
  public void a(axfy paramaxfy)
  {
    super.a(paramaxfy);
    if (this.jdField_a_of_type_Aglx != null)
    {
      if (a() != 0) {
        this.jdField_a_of_type_Aglx.b(false);
      }
      this.jdField_a_of_type_Aglx.a(a(), a());
      this.jdField_a_of_type_Aglx.b();
    }
  }
  
  public boolean a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_Aglx == null)
    {
      paramBundle = null;
      Bundle localBundle = a();
      if (localBundle != null) {
        paramBundle = localBundle.getString("uin");
      }
      this.jdField_a_of_type_Aglx = new aglx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext, paramBundle);
      this.jdField_a_of_type_Aglx.a(this);
      b(1);
      a(this.jdField_a_of_type_Aglx.a());
    }
    b(this.jdField_a_of_type_Aglx.a());
    if (a() != null) {
      this.jdField_a_of_type_Aglx.a(a(), a());
    }
    return true;
  }
  
  public void b() {}
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StrangerIntimateViewDelegete", 2, "doOnResume() called");
    }
    if (this.jdField_a_of_type_Aglx == null) {
      return;
    }
    if (a() == 0)
    {
      this.jdField_a_of_type_Aglx.b(true);
      this.jdField_a_of_type_Aglx.c();
    }
    for (;;)
    {
      this.jdField_a_of_type_Aglx.l();
      return;
      this.jdField_a_of_type_Aglx.b(false);
      this.jdField_a_of_type_Aglx.e();
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
    if (this.jdField_a_of_type_Aglx == null) {
      return;
    }
    this.jdField_a_of_type_Aglx.a(true);
    this.jdField_a_of_type_Aglx.b();
  }
  
  public void f() {}
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_Aglx == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_Aglx.a());
      this.jdField_a_of_type_AndroidViewViewGroup = null;
    }
    this.jdField_a_of_type_Aglx.i();
  }
  
  public void h() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axhp
 * JD-Core Version:    0.7.0.1
 */