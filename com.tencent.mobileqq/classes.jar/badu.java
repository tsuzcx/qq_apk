import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.profilecard.bussiness.colorscreen.ProfileColorScreenComponent;

public class badu
  extends badc<FrameLayout>
{
  private bagb jdField_a_of_type_Bagb;
  private bagt jdField_a_of_type_Bagt;
  private ProfileColorScreenComponent jdField_a_of_type_ComTencentMobileqqProfilecardBussinessColorscreenProfileColorScreenComponent;
  
  public badu(baei parambaei, azxr paramazxr)
  {
    super(parambaei, paramazxr);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessColorscreenProfileColorScreenComponent == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessColorscreenProfileColorScreenComponent = ((ProfileColorScreenComponent)baeg.a(1004, this.jdField_a_of_type_Baei, (azxr)this.b));
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessColorscreenProfileColorScreenComponent.a(this.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessColorscreenProfileColorScreenComponent.g();
      a(this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessColorscreenProfileColorScreenComponent);
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessColorscreenProfileColorScreenComponent != null)
    {
      b(this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessColorscreenProfileColorScreenComponent);
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessColorscreenProfileColorScreenComponent.h();
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessColorscreenProfileColorScreenComponent = null;
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Bagb == null)
    {
      this.jdField_a_of_type_Bagb = ((bagb)baeg.a(1020, this.jdField_a_of_type_Baei, (azxr)this.b));
      this.jdField_a_of_type_Bagb.a(this.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_Bagb.g();
      a(this.jdField_a_of_type_Bagb);
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_Bagb != null)
    {
      b(this.jdField_a_of_type_Bagb);
      this.jdField_a_of_type_Bagb.h();
      this.jdField_a_of_type_Bagb = null;
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_Bagt == null)
    {
      this.jdField_a_of_type_Bagt = ((bagt)baeg.a(1025, this.jdField_a_of_type_Baei, (azxr)this.b));
      this.jdField_a_of_type_Bagt.a(this.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_Bagt.g();
      a(this.jdField_a_of_type_Bagt);
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Bagt != null)
    {
      b(this.jdField_a_of_type_Bagt);
      this.jdField_a_of_type_Bagt.h();
      this.jdField_a_of_type_Bagt = null;
    }
  }
  
  public int a()
  {
    return 105;
  }
  
  public String a()
  {
    return "ProfileFgContainer";
  }
  
  public void a(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    super.a(paramBaseActivity, paramBundle);
    a();
    j();
    l();
  }
  
  public void f()
  {
    i();
    k();
    m();
    super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     badu
 * JD-Core Version:    0.7.0.1
 */