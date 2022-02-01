package com.tencent.mobileqq.activity.aio.rebuild;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qqexpand.bean.chat.ExpandFriendData;
import com.tencent.mobileqq.qqexpand.chat.IExpandChatUtils;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class LimitChatPie$7
  implements Runnable
{
  LimitChatPie$7(LimitChatPie paramLimitChatPie) {}
  
  public void run()
  {
    IExpandManager localIExpandManager = (IExpandManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    if ((localIExpandManager != null) && (!TextUtils.isEmpty(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      LimitChatPie.a(this.this$0, ((IExpandChatUtils)QRoute.api(IExpandChatUtils.class)).getMatchAlgorithmId(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      Object localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, null, 500);
      LimitChatPie.a(this.this$0, (List)localObject);
      this.this$0.d((List)localObject);
      this.this$0.c((List)localObject);
      localObject = this.this$0;
      LimitChatPie.a((LimitChatPie)localObject, ExpandFriendData.getMatchSrc(((LimitChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      ((IExpandChatUtils)QRoute.api(IExpandChatUtils.class)).showIcebreakerTopic(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, LimitChatPie.a(this.this$0), this.this$0.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
      this.this$0.e(65536);
      LimitChatPie.a(this.this$0, localIExpandManager);
      if ((this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null)) {
        LimitChatPie.b(this.this$0, ((IExpandChatUtils)QRoute.api(IExpandChatUtils.class)).getLastMatchChatGrayTipsSection(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      }
      return;
    }
    QLog.e(this.this$0.b, 2, "getSubThreadHandler  extendFriendManager or sessionInfo.curFriendUin is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.7
 * JD-Core Version:    0.7.0.1
 */