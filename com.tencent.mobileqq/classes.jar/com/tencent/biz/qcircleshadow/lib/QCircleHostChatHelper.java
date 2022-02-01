package com.tencent.biz.qcircleshadow.lib;

import com.tencent.biz.qcircleshadow.annotation.SuppressShadowCheck;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;

public class QCircleHostChatHelper
{
  public static int getUnReadNum(String paramString, int paramInt)
  {
    return QCircleServiceImpl.getConversationFacade().getUnreadCount(paramString, paramInt);
  }
  
  @SuppressShadowCheck
  public static boolean isOneWayBoxConversation(MessageRecord paramMessageRecord)
  {
    return UinTypeUtil.a(paramMessageRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostChatHelper
 * JD-Core Version:    0.7.0.1
 */