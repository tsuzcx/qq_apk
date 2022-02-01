import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bcpo
  implements View.OnClickListener
{
  bcpo(bcpn parambcpn, Context paramContext, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    MiniAppLauncher.startMiniApp(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bcpn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "bar_url", ""), 4010, null);
    this.jdField_a_of_type_Bcpn.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), System.currentTimeMillis());
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B187", "0X800B187", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcpo
 * JD-Core Version:    0.7.0.1
 */