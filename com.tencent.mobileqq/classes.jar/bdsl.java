import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.PAAudioPttDownloadProcessor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;

class bdsl
  implements View.OnClickListener
{
  bdsl(bdsk parambdsk) {}
  
  public void onClick(View paramView)
  {
    if (TextUtils.isEmpty(this.a.ag))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    for (;;)
    {
      try
      {
        String str = PAAudioPttDownloadProcessor.getPttPath(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.af);
        if (!TextUtils.isEmpty(str)) {
          break label133;
        }
        this.a.a();
        this.a.a(this.a.ag, paramView);
        bdla.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005C9B", "0X8005C9B", 0, 1, 0, this.a.ag, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.a.ae, this.a.af);
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
        this.a.a(this.a.ag, paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdsl
 * JD-Core Version:    0.7.0.1
 */