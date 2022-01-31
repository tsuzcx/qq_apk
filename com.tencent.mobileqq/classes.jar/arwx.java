import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class arwx
  extends arvm
{
  private acze a;
  
  public arwx(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramQQAppInterface, paramFragmentActivity, paramContext, paramViewGroup);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Acze != null)
    {
      this.jdField_a_of_type_Acze.a(null);
      this.jdField_a_of_type_Acze = null;
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_Acze == null) {
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Acze.c(true);
      this.jdField_a_of_type_Acze.b(true);
      this.jdField_a_of_type_Acze.d();
      return;
    }
    this.jdField_a_of_type_Acze.b(false);
    this.jdField_a_of_type_Acze.c(false);
  }
  
  public void a(arve paramarve)
  {
    super.a(paramarve);
    if (this.jdField_a_of_type_Acze != null)
    {
      if (a() != 0) {
        this.jdField_a_of_type_Acze.b(false);
      }
      this.jdField_a_of_type_Acze.a(a(), a());
      this.jdField_a_of_type_Acze.b();
    }
  }
  
  public boolean a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_Acze == null)
    {
      paramBundle = null;
      Bundle localBundle = a();
      if (localBundle != null) {
        paramBundle = localBundle.getString("uin");
      }
      this.jdField_a_of_type_Acze = new acze(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext, paramBundle);
      this.jdField_a_of_type_Acze.a(this);
      b(1);
      a(this.jdField_a_of_type_Acze.a());
    }
    b(this.jdField_a_of_type_Acze.a());
    if (a() != null) {
      this.jdField_a_of_type_Acze.a(a(), a());
    }
    return true;
  }
  
  public void b() {}
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StrangerIntimateViewDelegete", 2, "doOnResume() called");
    }
    if (this.jdField_a_of_type_Acze == null) {
      return;
    }
    if (a() == 0)
    {
      this.jdField_a_of_type_Acze.b(true);
      this.jdField_a_of_type_Acze.d();
    }
    for (;;)
    {
      this.jdField_a_of_type_Acze.o();
      return;
      this.jdField_a_of_type_Acze.b(false);
      this.jdField_a_of_type_Acze.e();
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
    if (this.jdField_a_of_type_Acze == null) {
      return;
    }
    this.jdField_a_of_type_Acze.a(true);
    this.jdField_a_of_type_Acze.b();
  }
  
  public void f() {}
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_Acze == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_Acze.a());
      this.jdField_a_of_type_AndroidViewViewGroup = null;
    }
    this.jdField_a_of_type_Acze.i();
  }
  
  public void h() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arwx
 * JD-Core Version:    0.7.0.1
 */