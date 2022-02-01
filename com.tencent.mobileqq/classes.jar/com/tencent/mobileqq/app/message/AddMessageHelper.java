package com.tencent.mobileqq.app.message;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.GrayTipsSpan;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class AddMessageHelper
{
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, int paramInt, ArrayList<GrayTipsSpan> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("-----addGrayTipsMessage  frienduin:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" istroop：");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" msg:");
      ((StringBuilder)localObject).append(MessageRecordUtil.a(paramString2));
      QLog.d("AddMessageHelper", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramBoolean1) && (MsgProxyUtils.a(paramInt)) && (QLog.isColorLevel())) {
      QLog.d("AddMessageHelper", 2, "-----addGrayTipsMessage faild : no troop uin");
    }
    long l = MessageCache.a();
    int i;
    if (paramBoolean1) {
      i = -5001;
    } else {
      i = -5000;
    }
    Object localObject = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).getLastMessage(paramString1, paramInt);
    MessageForNewGrayTips localMessageForNewGrayTips = (MessageForNewGrayTips)MessageRecordFactory.a(i);
    localMessageForNewGrayTips.init(paramAppInterface.getCurrentAccountUin(), paramString1, paramAppInterface.getCurrentAccountUin(), paramString2, l, i, paramInt, l);
    if (localObject != null) {
      localMessageForNewGrayTips.shmsgseq = ((MessageRecord)localObject).shmsgseq;
    }
    localMessageForNewGrayTips.isread = paramBoolean3;
    localMessageForNewGrayTips.spans = paramArrayList;
    localMessageForNewGrayTips.updateMsgData();
    if ((!paramBoolean2) || (!MessageHandlerUtils.a(paramAppInterface, localMessageForNewGrayTips, false))) {
      ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).addMessage(localMessageForNewGrayTips, paramAppInterface.getCurrentAccountUin());
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramAppInterface, paramString1, paramString2, paramInt, null, paramBoolean1, paramBoolean2, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("-----addDatingSafetyGrayTipsMessage  frienduin:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" istroop：");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" msg:");
      ((StringBuilder)localObject).append(MessageRecordUtil.a(paramString2));
      QLog.d("AddMessageHelper", 2, ((StringBuilder)localObject).toString());
    }
    long l = MessageCache.a();
    Object localObject = (MessageForGrayTips)MessageRecordFactory.a(-1028);
    ((MessageForGrayTips)localObject).init(paramQQAppInterface.getCurrentAccountUin(), paramString1, paramQQAppInterface.getCurrentAccountUin(), paramString2, l, -1028, paramInt, l);
    ((MessageForGrayTips)localObject).isread = true;
    if (!MessageHandlerUtils.a(paramQQAppInterface, (MessageRecord)localObject)) {
      paramQQAppInterface.getMessageFacade().a((MessageRecord)localObject, paramQQAppInterface.getCurrentAccountUin());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.AddMessageHelper
 * JD-Core Version:    0.7.0.1
 */