package com.tencent.mobileqq.activity.aio.core;

import android.os.Handler;
import android.widget.Toast;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppService;
import com.tencent.mobileqq.troop.utils.TroopRemindSettingManager;
import java.util.Set;

class TroopChatPie$28
  implements Runnable
{
  TroopChatPie$28(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    if (TroopRemindSettingManager.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      localObject = this.this$0;
      ((TroopChatPie)localObject).jdField_a_of_type_AndroidWidgetToast = ChatActivityUtils.a(((TroopChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131689877));
      this.this$0.jdField_a_of_type_AndroidWidgetToast.show();
      TroopRemindSettingManager.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    Object localObject = (DiscussionManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    if ((localObject != null) && (((DiscussionManager)localObject).a.contains(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      ((DiscussionManager)localObject).a.remove(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    }
    localObject = (ITroopAppService)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopAppService.class, "all");
    TroopManager localTroopManager = (TroopManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (this.this$0.g != ((ITroopAppService)localObject).getAppListTimestamp(0))
    {
      this.this$0.g = ((ITroopAppService)localObject).getAppListTimestamp(0);
      this.this$0.b.sendEmptyMessage(4);
    }
    localTroopManager.c(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    ((ITroopAppService)localObject).clickReport();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.28
 * JD-Core Version:    0.7.0.1
 */