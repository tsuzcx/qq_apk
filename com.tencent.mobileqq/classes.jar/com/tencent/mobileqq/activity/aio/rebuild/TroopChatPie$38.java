package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;
import anws;
import axap;
import bgqm;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import java.util.Set;

class TroopChatPie$38
  implements Runnable
{
  TroopChatPie$38(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    if (axap.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      this.this$0.jdField_a_of_type_AndroidWidgetToast = ChatActivityUtils.a(this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131689877));
      this.this$0.jdField_a_of_type_AndroidWidgetToast.show();
      axap.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    Object localObject = (anws)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
    if ((localObject != null) && (((anws)localObject).a.contains(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      ((anws)localObject).a.remove(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    }
    localObject = (bgqm)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(109);
    TroopManager localTroopManager = (TroopManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    if (localObject != null)
    {
      if (this.this$0.q != ((bgqm)localObject).a(0))
      {
        this.this$0.q = ((bgqm)localObject).a(0);
        this.this$0.b.sendEmptyMessage(4);
      }
      localTroopManager.c(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      ((bgqm)localObject).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.38
 * JD-Core Version:    0.7.0.1
 */