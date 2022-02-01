package com.tencent.mobileqq.app.message;

import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.GrayTipsSpan;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class AddMessageHelper
{
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddMessageHelper", 2, "-----addDatingSafetyGrayTipsMessage  frienduin:" + paramString1 + " istroop：" + paramInt + " msg:" + MessageRecordUtil.a(paramString2));
    }
    long l = MessageCache.a();
    MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)MessageRecordFactory.a(-1028);
    localMessageForGrayTips.init(paramQQAppInterface.getCurrentAccountUin(), paramString1, paramQQAppInterface.getCurrentAccountUin(), paramString2, l, -1028, paramInt, l);
    localMessageForGrayTips.isread = true;
    if (!MessageHandlerUtils.a(paramQQAppInterface, localMessageForGrayTips)) {
      paramQQAppInterface.getMessageFacade().a(localMessageForGrayTips, paramQQAppInterface.getCurrentAccountUin());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, ArrayList<GrayTipsSpan> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddMessageHelper", 2, "-----addGrayTipsMessage  frienduin:" + paramString1 + " istroop：" + paramInt + " msg:" + MessageRecordUtil.a(paramString2));
    }
    if ((paramBoolean1) && (MsgProxyUtils.a(paramInt)) && (QLog.isColorLevel())) {
      QLog.d("AddMessageHelper", 2, "-----addGrayTipsMessage faild : no troop uin");
    }
    long l = MessageCache.a();
    if (paramBoolean1) {}
    for (int i = -5001;; i = -5000)
    {
      Message localMessage = paramQQAppInterface.getMessageFacade().a(paramString1, paramInt);
      MessageForNewGrayTips localMessageForNewGrayTips = (MessageForNewGrayTips)MessageRecordFactory.a(i);
      localMessageForNewGrayTips.init(paramQQAppInterface.getCurrentAccountUin(), paramString1, paramQQAppInterface.getCurrentAccountUin(), paramString2, l, i, paramInt, l);
      if (localMessage != null) {
        localMessageForNewGrayTips.shmsgseq = localMessage.shmsgseq;
      }
      localMessageForNewGrayTips.isread = paramBoolean3;
      localMessageForNewGrayTips.spans = paramArrayList;
      localMessageForNewGrayTips.updateMsgData();
      if ((!paramBoolean2) || (!MessageHandlerUtils.a(paramQQAppInterface, localMessageForNewGrayTips, false))) {
        paramQQAppInterface.getMessageFacade().a(localMessageForNewGrayTips, paramQQAppInterface.getCurrentAccountUin());
      }
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramQQAppInterface, paramString1, paramString2, paramInt, null, paramBoolean1, paramBoolean2, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.AddMessageHelper
 * JD-Core Version:    0.7.0.1
 */