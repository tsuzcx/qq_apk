package com.tencent.mobileqq.activity.aio.rebuild;

import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
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
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    MultiForwardChatPie localMultiForwardChatPie;
    do
    {
      HashMap localHashMap;
      do
      {
        do
        {
          return;
          localMultiForwardChatPie = (MultiForwardChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if ((localMultiForwardChatPie != null) && (localMultiForwardChatPie.jdField_b_of_type_JavaLangRunnable != null))
          {
            MultiForwardChatPie.a(localMultiForwardChatPie).removeCallbacks(localMultiForwardChatPie.jdField_b_of_type_JavaLangRunnable);
            localMultiForwardChatPie.jdField_b_of_type_JavaLangRunnable = null;
          }
          if ((paramDownResult.jdField_a_of_type_Int != 0) || (paramDownResult.jdField_a_of_type_ArrayOfByte == null)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload success");
          }
        } while (localMultiForwardChatPie == null);
        localHashMap = new HashMap();
        MessageRecord localMessageRecord = localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMultiForwardChatPie.jdField_b_of_type_Long);
        localObject = localMessageRecord;
        if (localMessageRecord == null)
        {
          localObject = localMessageRecord;
          if (this.jdField_a_of_type_Long == 0L)
          {
            localObject = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(35).a(HardCodeUtil.a(2131707014)).a(3).a("viewMultiMsg", "", null, null, null).c("MultiMsg").b(localMultiForwardChatPie.f).a();
            localObject = MessageRecordFactory.a(localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0", "0", "0", 0, 0L, (AbsStructMsg)localObject);
          }
        }
        localObject = localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(paramDownResult.jdField_a_of_type_ArrayOfByte, localHashMap, (MessageRecord)localObject, null);
      } while ((localObject == null) || (((HashMap)localObject).size() <= 0));
      MultiMsgManager.a().a(localHashMap, localMultiForwardChatPie.jdField_b_of_type_Long, localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramDownResult = new ArrayList();
      Object localObject = ((ArrayList)((HashMap)localObject).get("MultiMsg")).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramDownResult.add((ChatMessage)((Iterator)localObject).next());
      }
      localMultiForwardChatPie.b(paramDownResult);
      localObject = ChatActivityUtils.a(MultiForwardChatPie.a(localMultiForwardChatPie), localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject = ChatActivityUtils.a(localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject, -1L);
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload, requestReceiveMultiMsg uses " + (System.currentTimeMillis() - MultiForwardChatPie.a(localMultiForwardChatPie)));
      }
      MultiMsgManager.a().a(localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, MultiForwardChatPie.a(localMultiForwardChatPie), true);
      if (this.jdField_a_of_type_Long == 0L)
      {
        paramDownResult = ChatActivityFacade.a(localMultiForwardChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, "", paramDownResult, localHashMap, true);
        if (paramDownResult != null)
        {
          MultiForwardChatPie.a(localMultiForwardChatPie, MessageRecordFactory.a(localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0", "0", "0", 0, 0L, paramDownResult));
          paramDownResult = (AbsStructMsgElement)paramDownResult.mStructMsgItemLists.get(0);
          if ((paramDownResult instanceof AbsStructMsgItem))
          {
            paramDownResult = (AbsStructMsgElement)((AbsStructMsgItem)paramDownResult).a.get(0);
            if ((paramDownResult instanceof StructMsgItemTitle)) {
              ((StructMsgItemTitle)paramDownResult).a(localMultiForwardChatPie.g);
            }
          }
        }
      }
      localMultiForwardChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new MultiForwardChatPie.MultiMsgDownloadCallback.1(this, localMultiForwardChatPie, (CharSequence)localObject));
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload failed");
      }
    } while (localMultiForwardChatPie == null);
    MultiMsgManager.a().a(localMultiForwardChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, false);
    localMultiForwardChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new MultiForwardChatPie.MultiMsgDownloadCallback.2(this, localMultiForwardChatPie));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.MultiMsgDownloadCallback
 * JD-Core Version:    0.7.0.1
 */