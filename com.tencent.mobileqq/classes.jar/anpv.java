import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class anpv
  implements View.OnClickListener
{
  anpv(anpu paramanpu) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1036) {
        break label69;
      }
      ((amme)anpu.a(this.a).app.getManager(QQManagerFactory.APOLLO_MANAGER)).a().c(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label69:
      amma localamma = (amma)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOLLO_GAME_MANAGER);
      if (localamma != null) {
        localamma.e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anpv
 * JD-Core Version:    0.7.0.1
 */