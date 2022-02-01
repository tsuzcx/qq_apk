package com.tencent.mobileqq.activity.aio.anim;

import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IReadConfirmCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class EggReadConfirmCallback
  implements IReadConfirmCallback
{
  public void a(AIOContext paramAIOContext) {}
  
  public void a(AIOContext paramAIOContext, List<ChatMessage> paramList, int paramInt)
  {
    boolean bool1 = true;
    int j = 0;
    boolean bool2;
    SessionInfo localSessionInfo;
    int i;
    if (paramInt > 0)
    {
      bool2 = true;
      localSessionInfo = paramAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if ((localSessionInfo.jdField_a_of_type_Int != 1) && (localSessionInfo.jdField_a_of_type_Int != 3000)) {
        break label103;
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
        label103:
        if (!UinTypeUtil.b(localSessionInfo.jdField_a_of_type_Int)) {
          break label379;
        }
        i = 0;
        continue;
      }
      int k;
      long l2;
      if (bool2)
      {
        k = paramList.size();
        if (j >= k) {
          break label371;
        }
        paramAIOContext = (ChatMessage)paramList.get(j);
        if (!paramAIOContext.isread) {
          if (i != 0) {
            l2 = paramAIOContext.shmsgseq;
          }
        }
      }
      for (;;)
      {
        label170:
        long l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.d("EggReadConfirmCallback", 2, "onPreSetReadConfirm_AIOEggs hasUnreadCount=" + paramInt + "totalList count=" + k);
          l1 = l2;
        }
        for (;;)
        {
          label219:
          if (QLog.isColorLevel()) {
            QLog.d("AioAnimationDetector", 2, "onPreSetReadConfirm_AIOEggs: hasUnread=" + bool2 + ", lastMsgTimeOrSeq=" + l1);
          }
          paramAIOContext = AioAnimationDetector.a();
          paramAIOContext.jdField_a_of_type_Boolean = bool2;
          paramAIOContext.jdField_a_of_type_Long = l1;
          if (bool2) {}
          for (;;)
          {
            com.tencent.mobileqq.activity.ChatActivityFacade.jdField_a_of_type_Long = l1;
            return;
            l2 = paramAIOContext.time;
            break label170;
            j += 1;
            break;
            paramAIOContext = paramAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localSessionInfo.jdField_a_of_type_JavaLangString, localSessionInfo.jdField_a_of_type_Int);
            if (paramAIOContext == null) {
              break label363;
            }
            if (i != 0)
            {
              l1 = paramAIOContext.shmsgseq;
              break label219;
            }
            l1 = paramAIOContext.time;
            break label219;
            l1 += 1L;
          }
          label363:
          l1 = -1L;
        }
        label371:
        l2 = -1L;
      }
      label379:
      bool1 = false;
      i = 0;
    }
  }
  
  public void b(AIOContext paramAIOContext) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.EggReadConfirmCallback
 * JD-Core Version:    0.7.0.1
 */