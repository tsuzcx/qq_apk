package com.tencent.mobileqq.apollo.view;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.impl.SpriteScriptManagerImpl;
import com.tencent.mobileqq.apollo.utils.CmShowStatUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ChatApolloViewListener$1
  implements Runnable
{
  ChatApolloViewListener$1(ChatApolloViewListener paramChatApolloViewListener) {}
  
  public void run()
  {
    int i = Thread.currentThread().getPriority();
    QLog.i("ChatApolloViewListener", 1, "TraceReport CmShowStatUtil onSurfaceReady threadPriority:" + i);
    if (this.this$0.a == null) {}
    BaseChatPie localBaseChatPie;
    do
    {
      return;
      localBaseChatPie = (BaseChatPie)this.this$0.a.get();
    } while (localBaseChatPie == null);
    if ((localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)) {
      ((SpriteScriptManagerImpl)localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all")).onSurfaceReady(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    CmShowStatUtil.b("TraceReport_initApolloSurfaceView_PreLoadJS");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ChatApolloViewListener.1
 * JD-Core Version:    0.7.0.1
 */