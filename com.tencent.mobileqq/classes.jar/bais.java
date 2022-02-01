import android.widget.FrameLayout;
import com.tencent.mobileqq.profilecard.vas.view.VasProfilePhotoView;

public class bais
  extends baik
{
  public bais(baei parambaei, azxr paramazxr)
  {
    super(parambaei, paramazxr);
  }
  
  public String a()
  {
    return "VasProfileHeaderPhotoComponent";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView == null)
    {
      VasProfilePhotoView localVasProfilePhotoView = new VasProfilePhotoView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (azxr)this.b);
      localVasProfilePhotoView.setClickListener(this);
      localVasProfilePhotoView.a();
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView = localVasProfilePhotoView;
      ((FrameLayout)this.jdField_a_of_type_JavaLangObject).removeAllViews();
      ((FrameLayout)this.jdField_a_of_type_JavaLangObject).addView(this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView);
    }
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bais
 * JD-Core Version:    0.7.0.1
 */