import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class bdlg
  implements View.OnClickListener
{
  bdlg(bdle parambdle, int paramInt, QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    long l2 = System.currentTimeMillis();
    Object localObject = paramView.getTag();
    if ((localObject instanceof Long)) {}
    for (long l1 = ((Long)localObject).longValue();; l1 = 0L)
    {
      if (l2 - l1 < 300L)
      {
        QLog.i("QQCustomDialogWithForwardAvatar", 2, "click in 300ms clickTime: " + l1 + " newTime :" + l2);
        return;
      }
      paramView.setTag(Long.valueOf(l2));
      if ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 3000)) {
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8009BE8", "0X8009BE8", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        this.jdField_a_of_type_Bdle.hideSoftInputFromWindow();
        MiniChatActivity.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b, 0.86F, this.jdField_a_of_type_Bdle.a(this.jdField_a_of_type_AndroidAppActivity, 0.78F));
        return;
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8009BE6", "0X8009BE6", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdlg
 * JD-Core Version:    0.7.0.1
 */