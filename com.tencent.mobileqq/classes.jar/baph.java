import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.mobileqq.qcall.QCallDetailActivity;

public class baph
  implements bkzq
{
  public baph(QCallDetailActivity paramQCallDetailActivity, String paramString, bkzi parambkzi) {}
  
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
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.app, "CliOper", "", "", "0X8005AF9", "0X8005AF9", 0, 0, "", "", "", "");
    this.jdField_a_of_type_Bkzi.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baph
 * JD-Core Version:    0.7.0.1
 */