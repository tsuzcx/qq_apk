import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileQVipV5View;

public class ayym
  extends ayyb
{
  private boolean a;
  
  public ayym(aysx paramaysx, aymg paramaymg)
  {
    super(paramaysx, paramaymg);
  }
  
  public String a()
  {
    return "VasProfileHeaderV5Component";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView == null)
    {
      VasProfileQVipV5View localVasProfileQVipV5View = new VasProfileQVipV5View(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (aymg)this.b);
      localVasProfileQVipV5View.setProfileArgs(this.jdField_a_of_type_Boolean);
      localVasProfileQVipV5View.setClickListener(this);
      localVasProfileQVipV5View.a();
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView = localVasProfileQVipV5View;
      ((FrameLayout)this.jdField_a_of_type_JavaLangObject).removeAllViews();
      ((FrameLayout)this.jdField_a_of_type_JavaLangObject).addView(this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView);
    }
  }
  
  public void a(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    Intent localIntent = paramBaseActivity.getIntent();
    if (localIntent != null) {
      this.jdField_a_of_type_Boolean = localIntent.getBooleanExtra("key_from_ark_babyq", false);
    }
    super.a(paramBaseActivity, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayym
 * JD-Core Version:    0.7.0.1
 */