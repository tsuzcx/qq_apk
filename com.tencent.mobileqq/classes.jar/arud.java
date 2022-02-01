import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arud
  implements View.OnClickListener
{
  public arud(MessageForArkApp paramMessageForArkApp, QQAppInterface paramQQAppInterface, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.ark_app_message.appId))
    {
      MessageForArkApp.access$000(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
      apyp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.ark_app_message.appName, "AIOArkSdkTailClick", 1, 0, 0L, 0L, 0L, this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.ark_app_message.appView, "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arud
 * JD-Core Version:    0.7.0.1
 */