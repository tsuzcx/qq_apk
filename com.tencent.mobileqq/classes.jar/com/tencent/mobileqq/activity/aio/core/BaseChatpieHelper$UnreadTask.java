package com.tencent.mobileqq.activity.aio.core;

import acnh;
import admh;
import afqz;
import afuu;
import avhz;
import axna;
import axnp;
import bcrg;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class BaseChatpieHelper$UnreadTask
  implements Runnable
{
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  
  BaseChatpieHelper$UnreadTask(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.getSessionInfo();
  }
  
  private void a(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (ChatMessage)paramList.next();
      if ((localObject instanceof MessageForUniteGrayTip))
      {
        localObject = (MessageForUniteGrayTip)localObject;
        if (((MessageForUniteGrayTip)localObject).tipParam != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FriendReactive", 2, "graytips lgraymr.hasRead=" + ((MessageForUniteGrayTip)localObject).hasRead + "grayTipId=" + ((MessageForUniteGrayTip)localObject).tipParam.b + "subtype = " + ((MessageForUniteGrayTip)localObject).subType);
          }
          if ((((MessageForUniteGrayTip)localObject).tipParam.b == 2097153) && (((MessageForUniteGrayTip)localObject).hasRead == 0))
          {
            axna.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForUniteGrayTip)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.uiHandler, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAnimContainer, ((MessageForUniteGrayTip)localObject).subType);
            ((MessageForUniteGrayTip)localObject).hasRead = 1;
            ((MessageForUniteGrayTip)localObject).updateUniteGrayTipMsgData(paramQQAppInterface);
          }
        }
      }
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    boolean bool1 = true;
    int j = 0;
    boolean bool2;
    int i;
    if (paramInt > 0)
    {
      bool2 = true;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 3000)) {
        break label99;
      }
      i = 1;
      bool1 = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("sendback", 2, "onPreSetReadConfirm_AIOEggs hasUnreadCount=" + paramInt + "isC2C=" + bool1);
      }
      if ((i == 0) && (!bool1))
      {
        return;
        bool2 = false;
        break;
        label99:
        if (!acnh.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType)) {
          break label387;
        }
        i = 0;
        continue;
      }
      int k;
      ChatMessage localChatMessage;
      long l2;
      if (bool2)
      {
        paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getAIOList();
        k = paramQQAppInterface.size();
        if (j >= k) {
          break label379;
        }
        localChatMessage = (ChatMessage)paramQQAppInterface.get(j);
        if (!localChatMessage.isread) {
          if (i != 0) {
            l2 = localChatMessage.shmsgseq;
          }
        }
      }
      for (;;)
      {
        label177:
        long l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.d("UnreadTask", 2, "onPreSetReadConfirm_AIOEggs hasUnreadCount=" + paramInt + "totalList count=" + k);
          l1 = l2;
        }
        for (;;)
        {
          label226:
          if (QLog.isColorLevel()) {
            QLog.d("AioAnimationDetector", 2, "onPreSetReadConfirm_AIOEggs: hasUnread=" + bool2 + ", lastMsgTimeOrSeq=" + l1);
          }
          paramQQAppInterface = afuu.a();
          paramQQAppInterface.jdField_a_of_type_Boolean = bool2;
          paramQQAppInterface.jdField_a_of_type_Long = l1;
          if (bool2) {}
          for (;;)
          {
            admh.jdField_a_of_type_Long = l1;
            return;
            l2 = localChatMessage.time;
            break label177;
            j += 1;
            break;
            paramQQAppInterface = paramQQAppInterface.getMessageFacade().getLastMessage(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
            if (paramQQAppInterface == null) {
              break label371;
            }
            if (i != 0)
            {
              l1 = paramQQAppInterface.shmsgseq;
              break label226;
            }
            l1 = paramQQAppInterface.time;
            break label226;
            l1 += 1L;
          }
          label371:
          l1 = -1L;
        }
        label379:
        l2 = -1L;
      }
      label387:
      bool1 = false;
      i = 0;
    }
  }
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null)
    {
      QLog.d("UnreadTask", 1, "UnReadTask mApp==null");
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getAIOList();
    a(localQQAppInterface, (List)localObject);
    if (((List)localObject).size() > 0)
    {
      localObject = (ChatMessage)((List)localObject).get(((List)localObject).size() - 1);
      ((FlashChatManager)localQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a((ChatMessage)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hasUnreadCount = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.initHaveUnRead();
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hasUnreadCount > 0) {}
    ArrayList localArrayList;
    for (boolean bool = true;; bool = false)
    {
      ((BaseChatPie)localObject).hasUnread = bool;
      a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hasUnreadCount);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listAdapter.a();
      localArrayList = new ArrayList();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 0) {
        break label302;
      }
      if ((localObject == null) || (((List)localObject).isEmpty())) {
        break;
      }
      int i = ((List)localObject).size() - 1;
      while (i >= 0)
      {
        ChatMessage localChatMessage = (ChatMessage)((List)localObject).get(i);
        if (((localChatMessage instanceof MessageForPoke)) && (!localChatMessage.isSend())) {
          localArrayList.add((MessageForPoke)localChatMessage);
        }
        i -= 1;
      }
    }
    if (localArrayList.size() > 0)
    {
      localObject = (MessageForPoke)localArrayList.get(0);
      if (!((MessageForPoke)localObject).isPlayed) {
        localQQAppInterface.getMsgCache().a.put(Long.valueOf(((MessageForPoke)localObject).uniseq), localObject);
      }
    }
    label302:
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.uiHandler.sendEmptyMessageDelayed(16711689, 300000L);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hasUnread) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.isHaveNewAfterIn)) {
      admh.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    for (;;)
    {
      localQQAppInterface.getMessageFacade().setReaded(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, true, true);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) {
        axnp.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.onPostSetReadConfirm(localQQAppInterface);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.mLastReadMsgId == -1L) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.mLastReadMsgId = localQQAppInterface.getMessageFacade().getReadConfirmStamp(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatpieHelper.UnreadTask
 * JD-Core Version:    0.7.0.1
 */