package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.multimsg.LongTextMsgManager;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class MultiForwardChatPie$LongTextDownloadCallback
  implements DownCallBack
{
  WeakReference<MultiForwardChatPie> a;
  
  public MultiForwardChatPie$LongTextDownloadCallback(MultiForwardChatPie paramMultiForwardChatPie)
  {
    this.a = new WeakReference(paramMultiForwardChatPie);
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(DownCallBack.DownResult paramDownResult)
  {
    Object localObject1 = this.a;
    if (localObject1 == null) {
      return;
    }
    localObject1 = (MultiForwardChatPie)((WeakReference)localObject1).get();
    if ((localObject1 != null) && (((MultiForwardChatPie)localObject1).jdField_a_of_type_JavaLangRunnable != null))
    {
      MultiForwardChatPie.a((MultiForwardChatPie)localObject1).removeCallbacks(((MultiForwardChatPie)localObject1).jdField_a_of_type_JavaLangRunnable);
      ((MultiForwardChatPie)localObject1).jdField_a_of_type_JavaLangRunnable = null;
    }
    if ((paramDownResult.jdField_a_of_type_Int == 0) && (paramDownResult.jdField_a_of_type_ArrayOfByte != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructLongTextMsg", 2, "MultiForwardActivity.onDownload success");
      }
      if (localObject1 == null) {
        return;
      }
      Object localObject2 = new HashMap();
      Object localObject3 = ((MultiForwardChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(((MultiForwardChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((MultiForwardChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ((MultiForwardChatPie)localObject1).jdField_a_of_type_Long);
      localObject3 = ((MultiForwardChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(paramDownResult.jdField_a_of_type_ArrayOfByte, (HashMap)localObject2, (MessageRecord)localObject3, null);
      if ((localObject3 != null) && (((ArrayList)localObject3).size() == 1))
      {
        if (((MessageRecord)((ArrayList)localObject3).get(0)).msgtype == -1035) {
          ((MixedMsgManager)((MultiForwardChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MIXED_MSG_MANAGER)).a(false, ((MultiForwardChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
        MultiMsgManager.a().a((HashMap)localObject2, ((MultiForwardChatPie)localObject1).jdField_a_of_type_Long, ((MultiForwardChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localObject2 = new ArrayList();
        ((List)localObject2).add((ChatMessage)((ArrayList)localObject3).get(0));
        ((MultiForwardChatPie)localObject1).b((List)localObject2);
        localObject2 = ChatActivityUtils.a(MultiForwardChatPie.a((MultiForwardChatPie)localObject1), ((MultiForwardChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ((MultiForwardChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localObject2 = ChatActivityUtils.a(((MultiForwardChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), ((MultiForwardChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject2, -1L);
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("MultiForwardActivity.onDownload, requestReceiveMultiMsg uses ");
          ((StringBuilder)localObject3).append(System.currentTimeMillis() - MultiForwardChatPie.a((MultiForwardChatPie)localObject1));
          QLog.d("StructLongTextMsg", 2, ((StringBuilder)localObject3).toString());
        }
        ((MultiForwardChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new MultiForwardChatPie.LongTextDownloadCallback.1(this, (MultiForwardChatPie)localObject1, (CharSequence)localObject2));
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructLongTextMsg", 2, "MultiForwardActivity.onDownload failed");
      }
      if (localObject1 == null) {
        return;
      }
      ((MultiForwardChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new MultiForwardChatPie.LongTextDownloadCallback.2(this, (MultiForwardChatPie)localObject1));
    }
    if ((localObject1 != null) && (((MultiForwardChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      ((LongTextMsgManager)((MultiForwardChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER)).a(((MultiForwardChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MultiForwardChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramDownResult.jdField_a_of_type_Int, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.LongTextDownloadCallback
 * JD-Core Version:    0.7.0.1
 */