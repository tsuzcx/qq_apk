import android.widget.FrameLayout;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileQVipDiyView;

public class bads
  extends badm
{
  public bads(azxt paramazxt, azrb paramazrb)
  {
    super(paramazxt, paramazrb);
  }
  
  public String a()
  {
    return "VasProfileHeaderDiyComponent";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView == null)
    {
      VasProfileQVipDiyView localVasProfileQVipDiyView = new VasProfileQVipDiyView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (azrb)this.b);
      localVasProfileQVipDiyView.setProfileArgs(this.jdField_a_of_type_AndroidViewViewGroup);
      localVasProfileQVipDiyView.setClickListener(this);
      localVasProfileQVipDiyView.a();
      localVasProfileQVipDiyView.e();
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView = localVasProfileQVipDiyView;
      ((FrameLayout)this.jdField_a_of_type_JavaLangObject).removeAllViews();
      ((FrameLayout)this.jdField_a_of_type_JavaLangObject).addView(this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bads
 * JD-Core Version:    0.7.0.1
 */