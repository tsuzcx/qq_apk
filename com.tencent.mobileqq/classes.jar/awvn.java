import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class awvn
  extends awuc
{
  private agol a;
  
  public awvn(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramQQAppInterface, paramFragmentActivity, paramContext, paramViewGroup);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Agol != null)
    {
      this.jdField_a_of_type_Agol.a(null);
      this.jdField_a_of_type_Agol = null;
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_Agol == null) {
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Agol.c(true);
      this.jdField_a_of_type_Agol.b(true);
      this.jdField_a_of_type_Agol.d();
      return;
    }
    this.jdField_a_of_type_Agol.b(false);
    this.jdField_a_of_type_Agol.c(false);
  }
  
  public void a(awtw paramawtw)
  {
    super.a(paramawtw);
    if (this.jdField_a_of_type_Agol != null)
    {
      if (a() != 0) {
        this.jdField_a_of_type_Agol.b(false);
      }
      this.jdField_a_of_type_Agol.a(a(), a());
      this.jdField_a_of_type_Agol.b();
    }
  }
  
  public boolean a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_Agol == null)
    {
      paramBundle = null;
      Bundle localBundle = a();
      if (localBundle != null) {
        paramBundle = localBundle.getString("uin");
      }
      this.jdField_a_of_type_Agol = new agol(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext, paramBundle);
      this.jdField_a_of_type_Agol.a(this);
      b(1);
      a(this.jdField_a_of_type_Agol.a());
    }
    b(this.jdField_a_of_type_Agol.a());
    if (a() != null) {
      this.jdField_a_of_type_Agol.a(a(), a());
    }
    return true;
  }
  
  public void b() {}
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StrangerIntimateViewDelegete", 2, "doOnResume() called");
    }
    if (this.jdField_a_of_type_Agol == null) {
      return;
    }
    if (a() == 0)
    {
      this.jdField_a_of_type_Agol.b(true);
      this.jdField_a_of_type_Agol.d();
    }
    for (;;)
    {
      this.jdField_a_of_type_Agol.n();
      return;
      this.jdField_a_of_type_Agol.b(false);
      this.jdField_a_of_type_Agol.e();
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
    if (this.jdField_a_of_type_Agol == null) {
      return;
    }
    this.jdField_a_of_type_Agol.a(true);
    this.jdField_a_of_type_Agol.b();
  }
  
  public void f() {}
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_Agol == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_Agol.a());
      this.jdField_a_of_type_AndroidViewViewGroup = null;
    }
    this.jdField_a_of_type_Agol.j();
  }
  
  public void h() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awvn
 * JD-Core Version:    0.7.0.1
 */