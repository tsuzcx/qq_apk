import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class awbn
  extends awac
{
  private afud a;
  
  public awbn(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramQQAppInterface, paramFragmentActivity, paramContext, paramViewGroup);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Afud != null)
    {
      this.jdField_a_of_type_Afud.a(null);
      this.jdField_a_of_type_Afud = null;
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_Afud == null) {
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Afud.c(true);
      this.jdField_a_of_type_Afud.b(true);
      this.jdField_a_of_type_Afud.d();
      return;
    }
    this.jdField_a_of_type_Afud.b(false);
    this.jdField_a_of_type_Afud.c(false);
  }
  
  public void a(avzw paramavzw)
  {
    super.a(paramavzw);
    if (this.jdField_a_of_type_Afud != null)
    {
      if (a() != 0) {
        this.jdField_a_of_type_Afud.b(false);
      }
      this.jdField_a_of_type_Afud.a(a(), a());
      this.jdField_a_of_type_Afud.b();
    }
  }
  
  public boolean a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_Afud == null)
    {
      paramBundle = null;
      Bundle localBundle = a();
      if (localBundle != null) {
        paramBundle = localBundle.getString("uin");
      }
      this.jdField_a_of_type_Afud = new afud(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext, paramBundle);
      this.jdField_a_of_type_Afud.a(this);
      b(1);
      a(this.jdField_a_of_type_Afud.a());
    }
    b(this.jdField_a_of_type_Afud.a());
    if (a() != null) {
      this.jdField_a_of_type_Afud.a(a(), a());
    }
    return true;
  }
  
  public void b() {}
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StrangerIntimateViewDelegete", 2, "doOnResume() called");
    }
    if (this.jdField_a_of_type_Afud == null) {
      return;
    }
    if (a() == 0)
    {
      this.jdField_a_of_type_Afud.b(true);
      this.jdField_a_of_type_Afud.d();
    }
    for (;;)
    {
      this.jdField_a_of_type_Afud.n();
      return;
      this.jdField_a_of_type_Afud.b(false);
      this.jdField_a_of_type_Afud.e();
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
    if (this.jdField_a_of_type_Afud == null) {
      return;
    }
    this.jdField_a_of_type_Afud.a(true);
    this.jdField_a_of_type_Afud.b();
  }
  
  public void f() {}
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_Afud == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_Afud.a());
      this.jdField_a_of_type_AndroidViewViewGroup = null;
    }
    this.jdField_a_of_type_Afud.j();
  }
  
  public void h() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awbn
 * JD-Core Version:    0.7.0.1
 */