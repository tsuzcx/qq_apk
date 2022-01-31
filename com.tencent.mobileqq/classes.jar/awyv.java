import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;

class awyv
  implements View.OnClickListener
{
  awyv(awyu paramawyu) {}
  
  public void onClick(View paramView)
  {
    if (TextUtils.isEmpty(this.a.W)) {
      return;
    }
    for (;;)
    {
      String str;
      try
      {
        str = axsu.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.V);
        if (TextUtils.isEmpty(str))
        {
          this.a.a();
          this.a.a(this.a.W, paramView);
          awqx.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005C9B", "0X8005C9B", 0, 1, 0, this.a.W, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.a.U, this.a.V);
          return;
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      if (new File(str).exists())
      {
        if (this.a.jdField_a_of_type_Boolean) {
          this.a.d();
        } else {
          this.a.c();
        }
      }
      else
      {
        this.a.a();
        this.a.a(this.a.W, paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awyv
 * JD-Core Version:    0.7.0.1
 */