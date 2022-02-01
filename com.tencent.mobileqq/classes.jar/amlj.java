import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amlj
  implements View.OnClickListener
{
  amlj(amli paramamli) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1036) {
        break label69;
      }
      ((alnr)amli.a(this.a).app.getManager(153)).a().c(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label69:
      alnn localalnn = (alnn)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(211);
      if (localalnn != null) {
        localalnn.e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amlj
 * JD-Core Version:    0.7.0.1
 */