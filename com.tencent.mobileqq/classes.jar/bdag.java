import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;

class bdag
  implements View.OnClickListener
{
  bdag(bdaf parambdaf) {}
  
  public void onClick(View paramView)
  {
    if (TextUtils.isEmpty(this.a.ae))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    for (;;)
    {
      try
      {
        String str = bdwx.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.ad);
        if (!TextUtils.isEmpty(str)) {
          break label133;
        }
        this.a.a();
        this.a.a(this.a.ae, paramView);
        bcst.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005C9B", "0X8005C9B", 0, 1, 0, this.a.ae, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.a.ac, this.a.ad);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      break;
      label133:
      if (new File(localException).exists())
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
        this.a.a(this.a.ae, paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdag
 * JD-Core Version:    0.7.0.1
 */