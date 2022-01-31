import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class astb
  extends asrq
{
  private adkg a;
  
  public astb(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramQQAppInterface, paramFragmentActivity, paramContext, paramViewGroup);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Adkg != null)
    {
      this.jdField_a_of_type_Adkg.a(null);
      this.jdField_a_of_type_Adkg = null;
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_Adkg == null) {
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Adkg.c(true);
      this.jdField_a_of_type_Adkg.b(true);
      this.jdField_a_of_type_Adkg.d();
      return;
    }
    this.jdField_a_of_type_Adkg.b(false);
    this.jdField_a_of_type_Adkg.c(false);
  }
  
  public void a(asri paramasri)
  {
    super.a(paramasri);
    if (this.jdField_a_of_type_Adkg != null)
    {
      if (a() != 0) {
        this.jdField_a_of_type_Adkg.b(false);
      }
      this.jdField_a_of_type_Adkg.a(a(), a());
      this.jdField_a_of_type_Adkg.b();
    }
  }
  
  public boolean a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_Adkg == null)
    {
      paramBundle = null;
      Bundle localBundle = a();
      if (localBundle != null) {
        paramBundle = localBundle.getString("uin");
      }
      this.jdField_a_of_type_Adkg = new adkg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext, paramBundle);
      this.jdField_a_of_type_Adkg.a(this);
      b(1);
      a(this.jdField_a_of_type_Adkg.a());
    }
    b(this.jdField_a_of_type_Adkg.a());
    if (a() != null) {
      this.jdField_a_of_type_Adkg.a(a(), a());
    }
    return true;
  }
  
  public void b() {}
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StrangerIntimateViewDelegete", 2, "doOnResume() called");
    }
    if (this.jdField_a_of_type_Adkg == null) {
      return;
    }
    if (a() == 0)
    {
      this.jdField_a_of_type_Adkg.b(true);
      this.jdField_a_of_type_Adkg.d();
    }
    for (;;)
    {
      this.jdField_a_of_type_Adkg.o();
      return;
      this.jdField_a_of_type_Adkg.b(false);
      this.jdField_a_of_type_Adkg.e();
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
    if (this.jdField_a_of_type_Adkg == null) {
      return;
    }
    this.jdField_a_of_type_Adkg.a(true);
    this.jdField_a_of_type_Adkg.b();
  }
  
  public void f() {}
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_Adkg == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_Adkg.a());
      this.jdField_a_of_type_AndroidViewViewGroup = null;
    }
    this.jdField_a_of_type_Adkg.i();
  }
  
  public void h() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     astb
 * JD-Core Version:    0.7.0.1
 */