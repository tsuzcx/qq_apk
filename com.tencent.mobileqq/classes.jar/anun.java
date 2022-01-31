import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;

public class anun
  implements bhqd
{
  public anun(BusinessCardEditActivity paramBusinessCardEditActivity, String paramString, bhpy parambhpy) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhpy.e();
      return;
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0))
      {
        paramView = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.getActivity().startActivity(paramView);
        this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.app.a().b(this.jdField_a_of_type_JavaLangString);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.a(2131693561, 1);
        continue;
        if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0))
        {
          paramView = new Intent();
          paramView.setAction("android.intent.action.SENDTO");
          paramView.setData(Uri.parse("smsto:" + this.jdField_a_of_type_JavaLangString));
          this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.getActivity().startActivity(paramView);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.a(2131693561, 1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anun
 * JD-Core Version:    0.7.0.1
 */