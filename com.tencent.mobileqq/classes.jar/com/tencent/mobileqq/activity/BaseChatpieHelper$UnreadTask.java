package com.tencent.mobileqq.activity;

import aaod;
import acut;
import acyt;
import akpy;
import aquz;
import asyl;
import asyv;
import awzw;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
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
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  
  BaseChatpieHelper$UnreadTask(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.a();
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
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000)) {
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
        if (!akpy.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
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
        paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
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
          paramQQAppInterface = acyt.a();
          paramQQAppInterface.jdField_a_of_type_Boolean = bool2;
          paramQQAppInterface.jdField_a_of_type_Long = l1;
          if (bool2) {}
          for (;;)
          {
            aaod.jdField_a_of_type_Long = l1;
            return;
            l2 = localChatMessage.time;
            break label177;
            j += 1;
            break;
            paramQQAppInterface = paramQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    Object localObject2 = ((List)localObject1).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ChatMessage)((Iterator)localObject2).next();
      if ((localObject3 instanceof MessageForUniteGrayTip))
      {
        localObject3 = (MessageForUniteGrayTip)localObject3;
        if (((MessageForUniteGrayTip)localObject3).tipParam != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FriendReactive", 2, "graytips lgraymr.hasRead=" + ((MessageForUniteGrayTip)localObject3).hasRead + "grayTipId=" + ((MessageForUniteGrayTip)localObject3).tipParam.b + "subtype = " + ((MessageForUniteGrayTip)localObject3).subType);
          }
          if ((((MessageForUniteGrayTip)localObject3).tipParam.b == 2097153) && (((MessageForUniteGrayTip)localObject3).hasRead == 0))
          {
            asyl.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForUniteGrayTip)localObject3, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_MqqOsMqqHandler, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, ((MessageForUniteGrayTip)localObject3).subType);
            ((MessageForUniteGrayTip)localObject3).hasRead = 1;
            ((MessageForUniteGrayTip)localObject3).updateUniteGrayTipMsgData(localQQAppInterface);
          }
        }
      }
    }
    if (((List)localObject1).size() > 0)
    {
      localObject1 = (ChatMessage)((List)localObject1).get(((List)localObject1).size() - 1);
      ((FlashChatManager)localQQAppInterface.getManager(217)).a((ChatMessage)localObject1);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c();
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((BaseChatPie)localObject1).q = bool;
      a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Acut.a();
      localObject2 = new ArrayList();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) {
        break label478;
      }
      if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
        break;
      }
      int i = ((List)localObject1).size() - 1;
      while (i >= 0)
      {
        localObject3 = (ChatMessage)((List)localObject1).get(i);
        if (((localObject3 instanceof MessageForPoke)) && (!((ChatMessage)localObject3).isSend())) {
          ((List)localObject2).add((MessageForPoke)localObject3);
        }
        i -= 1;
      }
    }
    if (((List)localObject2).size() > 0)
    {
      localObject1 = (MessageForPoke)((List)localObject2).get(0);
      if (!((MessageForPoke)localObject1).isPlayed) {
        localQQAppInterface.a().a.put(Long.valueOf(((MessageForPoke)localObject1).uniseq), localObject1);
      }
    }
    label478:
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(16711689, 300000L);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.q) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.p)) {
      aaod.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    for (;;)
    {
      localQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true, true);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
        asyv.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(localQQAppInterface);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Long == -1L) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Long = localQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatpieHelper.UnreadTask
 * JD-Core Version:    0.7.0.1
 */