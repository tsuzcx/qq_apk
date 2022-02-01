import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.profilecard.bussiness.colorscreen.ProfileColorScreenComponent;

public class azxf
  extends azwn<FrameLayout>
{
  private baan jdField_a_of_type_Baan;
  private babf jdField_a_of_type_Babf;
  private ProfileColorScreenComponent jdField_a_of_type_ComTencentMobileqqProfilecardBussinessColorscreenProfileColorScreenComponent;
  
  public azxf(azxt paramazxt, azrb paramazrb)
  {
    super(paramazxt, paramazrb);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessColorscreenProfileColorScreenComponent == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessColorscreenProfileColorScreenComponent = ((ProfileColorScreenComponent)azxr.a(1004, this.jdField_a_of_type_Azxt, (azrb)this.b));
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
    if (this.jdField_a_of_type_Baan == null)
    {
      this.jdField_a_of_type_Baan = ((baan)azxr.a(1020, this.jdField_a_of_type_Azxt, (azrb)this.b));
      this.jdField_a_of_type_Baan.a(this.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_Baan.g();
      a(this.jdField_a_of_type_Baan);
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_Baan != null)
    {
      b(this.jdField_a_of_type_Baan);
      this.jdField_a_of_type_Baan.h();
      this.jdField_a_of_type_Baan = null;
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_Babf == null)
    {
      this.jdField_a_of_type_Babf = ((babf)azxr.a(1025, this.jdField_a_of_type_Azxt, (azrb)this.b));
      this.jdField_a_of_type_Babf.a(this.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_Babf.g();
      a(this.jdField_a_of_type_Babf);
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Babf != null)
    {
      b(this.jdField_a_of_type_Babf);
      this.jdField_a_of_type_Babf.h();
      this.jdField_a_of_type_Babf = null;
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
 * Qualified Name:     azxf
 * JD-Core Version:    0.7.0.1
 */