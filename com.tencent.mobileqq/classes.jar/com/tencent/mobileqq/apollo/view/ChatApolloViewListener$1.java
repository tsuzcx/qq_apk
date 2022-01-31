package com.tencent.mobileqq.apollo.view;

import albf;
import alku;
import alnq;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ChatApolloViewListener$1
  implements Runnable
{
  public ChatApolloViewListener$1(alnq paramalnq) {}
  
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
      ((albf)localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249)).a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    alku.b("TraceReport_initApolloSurfaceView_PreLoadJS");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ChatApolloViewListener.1
 * JD-Core Version:    0.7.0.1
 */