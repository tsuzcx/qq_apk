import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.mobileqq.qcall.QCallDetailActivity;

public class axam
  implements bhuk
{
  public axam(QCallDetailActivity paramQCallDetailActivity, String paramString, bhuf parambhuf) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity) == null) || (paramInt >= QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity).length)) {
      return;
    }
    switch (QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity)[paramInt])
    {
    default: 
      return;
    }
    paramView = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.startActivity(paramView);
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.app, "CliOper", "", "", "0X8005AF9", "0X8005AF9", 0, 0, "", "", "", "");
    this.jdField_a_of_type_Bhuf.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axam
 * JD-Core Version:    0.7.0.1
 */