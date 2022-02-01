import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bhqj
  implements View.OnClickListener
{
  bhqj(bhqi parambhqi, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt) {}
  
  public void onClick(View paramView)
  {
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8009BE7", "0X8009BE7", 1, 0, "", "", "", "");
    this.jdField_a_of_type_Bhqi.hideSoftInputFromWindow();
    avar localavar = new avar(this.jdField_a_of_type_Bhqi);
    localavar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Bhqi.addPreviewView(localavar.b());
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8009AAD", "0X8009AAD", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhqj
 * JD-Core Version:    0.7.0.1
 */