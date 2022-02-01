package com.tencent.mobileqq.activity.aio.rebuild;

import android.support.v4.app.FragmentActivity;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtendFriendUserInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.apollo.aio.AioApolloHelper;
import com.tencent.mobileqq.extendfriend.bean.ExpandFriendData;
import com.tencent.mobileqq.extendfriend.limitchat.ExpandFriendChatUtil;
import com.tencent.mobileqq.extendfriend.utils.ExpandSharePreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class LimitChatPie$7
  implements Runnable
{
  LimitChatPie$7(LimitChatPie paramLimitChatPie) {}
  
  public void run()
  {
    ExtendFriendManager localExtendFriendManager = (ExtendFriendManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    if (localExtendFriendManager == null) {
      QLog.e(this.this$0.b, 2, "getSubThreadHandler  extendFriendManager Is null");
    }
    for (;;)
    {
      return;
      LimitChatPie.a(this.this$0, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localExtendFriendManager);
      Object localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, null, 500);
      LimitChatPie.a(this.this$0, (List)localObject);
      LimitChatPie.a(this.this$0, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (List)localObject);
      try
      {
        LimitChatPie.a(this.this$0, ((Integer)ExpandFriendData.getAttribute(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0)).intValue());
        ExpandFriendChatUtil.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, LimitChatPie.g(this.this$0), this.this$0.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver);
        if ((localObject != null) && (((List)localObject).size() > 0) && (!LimitChatPie.a(this.this$0).enableQQCall))
        {
          QLog.d(this.this$0.b, 2, "enableQQCall check");
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            if ((((MessageRecord)((Iterator)localObject).next()).senderuin.equals(LimitChatPie.a(this.this$0).uin)) && (LimitChatPie.h(this.this$0) > 4))
            {
              LimitChatPie.a(this.this$0).enableQQCall = true;
              localExtendFriendManager.a(LimitChatPie.a(this.this$0));
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.this$0.b, 2, "mAllMsgCount " + LimitChatPie.h(this.this$0));
        }
        this.this$0.g(65536);
        boolean bool2 = ExpandSharePreUtils.a("sp_extend_friend_prompt_aio_save_empty_node");
        int i = localExtendFriendManager.a("sp_extend_friend_prompt_safe_tip");
        if (i == 0)
        {
          bool1 = true;
          QLog.w("LimitChatPie", 1, String.format("openSaveEmptyAIONodeDialog : %b, popupDialogState : %d, notShowSafeTip : %b", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(i), Boolean.valueOf(bool1) }));
          ThreadManager.getUIHandler().post(new LimitChatPie.7.1(this, bool2, bool1));
          if (this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) {
            continue;
          }
          AioApolloHelper.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.w("LimitChatPie", 1, "initData getHasEnterAIO error" + localException);
          continue;
          boolean bool1 = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.7
 * JD-Core Version:    0.7.0.1
 */