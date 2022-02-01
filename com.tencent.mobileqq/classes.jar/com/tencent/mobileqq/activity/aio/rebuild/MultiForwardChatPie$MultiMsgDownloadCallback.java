package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class MultiForwardChatPie$MultiMsgDownloadCallback
  implements DownCallBack
{
  long jdField_a_of_type_Long;
  WeakReference<MultiForwardChatPie> jdField_a_of_type_JavaLangRefWeakReference;
  
  public MultiForwardChatPie$MultiMsgDownloadCallback(MultiForwardChatPie paramMultiForwardChatPie, long paramLong)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramMultiForwardChatPie);
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(DownCallBack.DownResult paramDownResult)
  {
    Object localObject1 = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject1 == null) {
      return;
    }
    MultiForwardChatPie localMultiForwardChatPie = (MultiForwardChatPie)((WeakReference)localObject1).get();
    if ((localMultiForwardChatPie != null) && (localMultiForwardChatPie.jdField_a_of_type_JavaLangRunnable != null))
    {
      MultiForwardChatPie.a(localMultiForwardChatPie).removeCallbacks(localMultiForwardChatPie.jdField_a_of_type_JavaLangRunnable);
      localMultiForwardChatPie.jdField_a_of_type_JavaLangRunnable = null;
    }
    if ((paramDownResult.jdField_a_of_type_Int == 0) && (paramDownResult.jdField_a_of_type_ArrayOfByte != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload success");
      }
      if (localMultiForwardChatPie == null) {
        return;
      }
      HashMap localHashMap = new HashMap();
      Object localObject2 = localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMultiForwardChatPie.jdField_a_of_type_Long);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Long == 0L)
        {
          localObject1 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(35).a(HardCodeUtil.a(2131707036)).a(3).a("viewMultiMsg", "", null, null, null).c("MultiMsg").b(localMultiForwardChatPie.d).a();
          localObject1 = MessageRecordFactory.a(localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0", "0", "0", 0, 0L, (AbsStructMsg)localObject1);
        }
      }
      localObject1 = localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(paramDownResult.jdField_a_of_type_ArrayOfByte, localHashMap, (MessageRecord)localObject1, null);
      if ((localObject1 != null) && (((HashMap)localObject1).size() > 0))
      {
        MultiMsgManager.a().a(localHashMap, localMultiForwardChatPie.jdField_a_of_type_Long, localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        paramDownResult = new ArrayList();
        localObject1 = ((ArrayList)((HashMap)localObject1).get("MultiMsg")).iterator();
        while (((Iterator)localObject1).hasNext()) {
          paramDownResult.add((ChatMessage)((Iterator)localObject1).next());
        }
        localMultiForwardChatPie.b(paramDownResult);
        localObject1 = ChatActivityUtils.a(MultiForwardChatPie.a(localMultiForwardChatPie), localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localObject1 = ChatActivityUtils.a(localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject1, -1L);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("MultiForwardActivity.onDownload, requestReceiveMultiMsg uses ");
          ((StringBuilder)localObject2).append(System.currentTimeMillis() - MultiForwardChatPie.a(localMultiForwardChatPie));
          QLog.d("MultiMsg_TAG", 2, ((StringBuilder)localObject2).toString());
        }
        MultiMsgManager.a().a(localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, MultiForwardChatPie.a(localMultiForwardChatPie), true);
        if (this.jdField_a_of_type_Long == 0L)
        {
          paramDownResult = ChatActivityFacade.a(localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "", paramDownResult, localHashMap, true);
          if (paramDownResult != null)
          {
            MultiForwardChatPie.a(localMultiForwardChatPie, MessageRecordFactory.a(localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0", "0", "0", 0, 0L, paramDownResult));
            paramDownResult = (AbsStructMsgElement)paramDownResult.mStructMsgItemLists.get(0);
            if ((paramDownResult instanceof AbsStructMsgItem))
            {
              paramDownResult = (AbsStructMsgElement)((AbsStructMsgItem)paramDownResult).a.get(0);
              if ((paramDownResult instanceof StructMsgItemTitle)) {
                ((StructMsgItemTitle)paramDownResult).a(localMultiForwardChatPie.e);
              }
            }
          }
        }
        localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new MultiForwardChatPie.MultiMsgDownloadCallback.1(this, localMultiForwardChatPie, (CharSequence)localObject1));
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload failed");
      }
      if (localMultiForwardChatPie == null) {
        return;
      }
      MultiMsgManager.a().a(localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, false);
      localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new MultiForwardChatPie.MultiMsgDownloadCallback.2(this, localMultiForwardChatPie));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.MultiMsgDownloadCallback
 * JD-Core Version:    0.7.0.1
 */