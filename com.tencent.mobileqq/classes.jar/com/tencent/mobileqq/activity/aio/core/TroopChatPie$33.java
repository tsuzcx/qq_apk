package com.tencent.mobileqq.activity.aio.core;

import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.managers.TroopRemindSettingManager;
import com.tencent.mobileqq.troop.utils.TroopAppMgr;
import java.util.Set;

class TroopChatPie$33
  implements Runnable
{
  TroopChatPie$33(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    if (TroopRemindSettingManager.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      this.this$0.jdField_a_of_type_AndroidWidgetToast = ChatActivityUtils.a(this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131689962));
      this.this$0.jdField_a_of_type_AndroidWidgetToast.show();
      TroopRemindSettingManager.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    Object localObject = (DiscussionManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    if ((localObject != null) && (((DiscussionManager)localObject).a.contains(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      ((DiscussionManager)localObject).a.remove(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    }
    localObject = (TroopAppMgr)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_APP_MGR);
    TroopManager localTroopManager = (TroopManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject != null)
    {
      if (this.this$0.k != ((TroopAppMgr)localObject).a(0))
      {
        this.this$0.k = ((TroopAppMgr)localObject).a(0);
        this.this$0.b.sendEmptyMessage(4);
      }
      localTroopManager.c(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      ((TroopAppMgr)localObject).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.33
 * JD-Core Version:    0.7.0.1
 */