import android.widget.FrameLayout;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileGameView;

public class bair
  extends baik
{
  public bair(baei parambaei, azxr paramazxr)
  {
    super(parambaei, paramazxr);
  }
  
  public String a()
  {
    return "VasProfileHeaderGameComponent";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView == null)
    {
      VasProfileGameView localVasProfileGameView = new VasProfileGameView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (azxr)this.b);
      localVasProfileGameView.setClickListener(this);
      localVasProfileGameView.a();
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView = localVasProfileGameView;
      ((FrameLayout)this.jdField_a_of_type_JavaLangObject).removeAllViews();
      ((FrameLayout)this.jdField_a_of_type_JavaLangObject).addView(this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bair
 * JD-Core Version:    0.7.0.1
 */