import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class astd
  extends asrs
{
  private adke a;
  
  public astd(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramQQAppInterface, paramFragmentActivity, paramContext, paramViewGroup);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Adke != null)
    {
      this.jdField_a_of_type_Adke.a(null);
      this.jdField_a_of_type_Adke = null;
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_Adke == null) {
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Adke.c(true);
      this.jdField_a_of_type_Adke.b(true);
      this.jdField_a_of_type_Adke.d();
      return;
    }
    this.jdField_a_of_type_Adke.b(false);
    this.jdField_a_of_type_Adke.c(false);
  }
  
  public void a(asrk paramasrk)
  {
    super.a(paramasrk);
    if (this.jdField_a_of_type_Adke != null)
    {
      if (a() != 0) {
        this.jdField_a_of_type_Adke.b(false);
      }
      this.jdField_a_of_type_Adke.a(a(), a());
      this.jdField_a_of_type_Adke.b();
    }
  }
  
  public boolean a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_Adke == null)
    {
      paramBundle = null;
      Bundle localBundle = a();
      if (localBundle != null) {
        paramBundle = localBundle.getString("uin");
      }
      this.jdField_a_of_type_Adke = new adke(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext, paramBundle);
      this.jdField_a_of_type_Adke.a(this);
      b(1);
      a(this.jdField_a_of_type_Adke.a());
    }
    b(this.jdField_a_of_type_Adke.a());
    if (a() != null) {
      this.jdField_a_of_type_Adke.a(a(), a());
    }
    return true;
  }
  
  public void b() {}
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StrangerIntimateViewDelegete", 2, "doOnResume() called");
    }
    if (this.jdField_a_of_type_Adke == null) {
      return;
    }
    if (a() == 0)
    {
      this.jdField_a_of_type_Adke.b(true);
      this.jdField_a_of_type_Adke.d();
    }
    for (;;)
    {
      this.jdField_a_of_type_Adke.o();
      return;
      this.jdField_a_of_type_Adke.b(false);
      this.jdField_a_of_type_Adke.e();
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
    if (this.jdField_a_of_type_Adke == null) {
      return;
    }
    this.jdField_a_of_type_Adke.a(true);
    this.jdField_a_of_type_Adke.b();
  }
  
  public void f() {}
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_Adke == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_Adke.a());
      this.jdField_a_of_type_AndroidViewViewGroup = null;
    }
    this.jdField_a_of_type_Adke.i();
  }
  
  public void h() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     astd
 * JD-Core Version:    0.7.0.1
 */