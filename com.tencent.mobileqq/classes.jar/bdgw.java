import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;

class bdgw
  implements View.OnClickListener
{
  bdgw(bdgv parambdgv, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt) {}
  
  public void onClick(View paramView)
  {
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8009BE7", "0X8009BE7", 1, 0, "", "", "", "");
    this.jdField_a_of_type_Bdgv.hideSoftInputFromWindow();
    paramView = new arxj(this.jdField_a_of_type_Bdgv);
    paramView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Bdgv.addPreviewView(paramView.b());
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8009AAD", "0X8009AAD", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdgw
 * JD-Core Version:    0.7.0.1
 */