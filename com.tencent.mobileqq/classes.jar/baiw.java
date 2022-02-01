import android.widget.FrameLayout;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileWZRYView;

public class baiw
  extends baik
{
  public baiw(baei parambaei, azxr paramazxr)
  {
    super(parambaei, paramazxr);
  }
  
  public String a()
  {
    return "VasProfileHeaderWZRYComponent";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView == null)
    {
      VasProfileWZRYView localVasProfileWZRYView = new VasProfileWZRYView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (azxr)this.b);
      localVasProfileWZRYView.setClickListener(this);
      localVasProfileWZRYView.a();
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView = localVasProfileWZRYView;
      ((FrameLayout)this.jdField_a_of_type_JavaLangObject).removeAllViews();
      ((FrameLayout)this.jdField_a_of_type_JavaLangObject).addView(this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baiw
 * JD-Core Version:    0.7.0.1
 */