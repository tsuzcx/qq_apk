package com.tencent.mobileqq.activity.aio.anim;

import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
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
    int j = 0;
    boolean bool1 = true;
    boolean bool2;
    if (paramInt > 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    BaseSessionInfo localBaseSessionInfo = paramAIOContext.a();
    int i;
    if ((localBaseSessionInfo.jdField_a_of_type_Int != 1) && (localBaseSessionInfo.jdField_a_of_type_Int != 3000))
    {
      if (!UinTypeUtil.b(localBaseSessionInfo.jdField_a_of_type_Int)) {
        bool1 = false;
      }
      i = 0;
    }
    else
    {
      bool1 = false;
      i = 1;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPreSetReadConfirm_AIOEggs hasUnreadCount=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("isC2C=");
      localStringBuilder.append(bool1);
      QLog.d("sendback", 2, localStringBuilder.toString());
    }
    if ((i == 0) && (!bool1)) {
      return;
    }
    long l1 = -1L;
    if (bool2)
    {
      int k = paramList.size();
      long l2;
      for (;;)
      {
        l2 = l1;
        if (j >= k) {
          break;
        }
        paramAIOContext = (ChatMessage)paramList.get(j);
        if (!paramAIOContext.isread)
        {
          if (i != 0) {
            l1 = paramAIOContext.shmsgseq;
          } else {
            l1 = paramAIOContext.time;
          }
          l2 = l1;
          break;
        }
        j += 1;
      }
      l1 = l2;
      if (QLog.isColorLevel())
      {
        paramAIOContext = new StringBuilder();
        paramAIOContext.append("onPreSetReadConfirm_AIOEggs hasUnreadCount=");
        paramAIOContext.append(paramInt);
        paramAIOContext.append("totalList count=");
        paramAIOContext.append(k);
        QLog.d("EggReadConfirmCallback", 2, paramAIOContext.toString());
        l1 = l2;
      }
    }
    else
    {
      paramAIOContext = paramAIOContext.a().getMessageFacade().getLastMessage(localBaseSessionInfo.jdField_a_of_type_JavaLangString, localBaseSessionInfo.jdField_a_of_type_Int);
      if (paramAIOContext != null) {
        if (i != 0) {
          l1 = paramAIOContext.shmsgseq;
        } else {
          l1 = paramAIOContext.time;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramAIOContext = new StringBuilder();
      paramAIOContext.append("onPreSetReadConfirm_AIOEggs: hasUnread=");
      paramAIOContext.append(bool2);
      paramAIOContext.append(", lastMsgTimeOrSeq=");
      paramAIOContext.append(l1);
      QLog.d("AioAnimationDetector", 2, paramAIOContext.toString());
    }
    paramAIOContext = AioAnimationDetector.a();
    paramAIOContext.jdField_a_of_type_Boolean = bool2;
    paramAIOContext.jdField_a_of_type_Long = l1;
    if (!bool2) {
      l1 += 1L;
    }
    com.tencent.mobileqq.activity.ChatActivityFacade.jdField_a_of_type_Long = l1;
  }
  
  public void b(AIOContext paramAIOContext) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.EggReadConfirmCallback
 * JD-Core Version:    0.7.0.1
 */