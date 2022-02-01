import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class axog
  extends axmv
{
  private agxr a;
  
  public axog(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramQQAppInterface, paramFragmentActivity, paramContext, paramViewGroup);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Agxr != null)
    {
      this.jdField_a_of_type_Agxr.a(null);
      this.jdField_a_of_type_Agxr = null;
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_Agxr == null) {
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Agxr.c(true);
      this.jdField_a_of_type_Agxr.b(true);
      this.jdField_a_of_type_Agxr.d();
      return;
    }
    this.jdField_a_of_type_Agxr.b(false);
    this.jdField_a_of_type_Agxr.c(false);
  }
  
  public void a(axmp paramaxmp)
  {
    super.a(paramaxmp);
    if (this.jdField_a_of_type_Agxr != null)
    {
      if (a() != 0) {
        this.jdField_a_of_type_Agxr.b(false);
      }
      this.jdField_a_of_type_Agxr.a(a(), a());
      this.jdField_a_of_type_Agxr.b();
    }
  }
  
  public boolean a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_Agxr == null)
    {
      paramBundle = null;
      Bundle localBundle = a();
      if (localBundle != null) {
        paramBundle = localBundle.getString("uin");
      }
      this.jdField_a_of_type_Agxr = new agxr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext, paramBundle);
      this.jdField_a_of_type_Agxr.a(this);
      b(1);
      a(this.jdField_a_of_type_Agxr.a());
    }
    b(this.jdField_a_of_type_Agxr.a());
    if (a() != null) {
      this.jdField_a_of_type_Agxr.a(a(), a());
    }
    return true;
  }
  
  public void b() {}
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StrangerIntimateViewDelegete", 2, "doOnResume() called");
    }
    if (this.jdField_a_of_type_Agxr == null) {
      return;
    }
    if (a() == 0)
    {
      this.jdField_a_of_type_Agxr.b(true);
      this.jdField_a_of_type_Agxr.d();
    }
    for (;;)
    {
      this.jdField_a_of_type_Agxr.n();
      return;
      this.jdField_a_of_type_Agxr.b(false);
      this.jdField_a_of_type_Agxr.e();
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
    if (this.jdField_a_of_type_Agxr == null) {
      return;
    }
    this.jdField_a_of_type_Agxr.a(true);
    this.jdField_a_of_type_Agxr.b();
  }
  
  public void f() {}
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_Agxr == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_Agxr.a());
      this.jdField_a_of_type_AndroidViewViewGroup = null;
    }
    this.jdField_a_of_type_Agxr.j();
  }
  
  public void h() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axog
 * JD-Core Version:    0.7.0.1
 */