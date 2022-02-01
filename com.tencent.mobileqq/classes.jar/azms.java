import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class azms
  implements View.OnClickListener
{
  public azms(AbsProfileHeaderView paramAbsProfileHeaderView, String paramString, int paramInt, View paramView) {}
  
  public void onClick(View paramView)
  {
    if ((bbdu.a(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Int >= 0))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("key_sign_topic_name", this.jdField_a_of_type_JavaLangString);
      localBundle.putInt("key_sign_topic_id", this.jdField_a_of_type_Int);
      localBundle.putInt("from_type", 2);
      if ((this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
        SignTextEditFragment.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null, null, localBundle, -1);
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      azfy.a().c(this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      bcst.b(null, "dc00898", "", "", "0X800A4D5", "0X800A4D5", 0, 0, "2", "0", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azms
 * JD-Core Version:    0.7.0.1
 */