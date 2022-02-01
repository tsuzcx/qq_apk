import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class anqp
  implements View.OnClickListener
{
  anqp(anqo paramanqo) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 1036) {
        break label69;
      }
      ((amsx)anqo.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a().c(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label69:
      amst localamst = (amst)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(211);
      if (localamst != null) {
        localamst.e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anqp
 * JD-Core Version:    0.7.0.1
 */