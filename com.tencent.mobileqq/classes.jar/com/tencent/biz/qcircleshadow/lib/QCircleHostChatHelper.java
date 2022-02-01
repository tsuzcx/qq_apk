package com.tencent.biz.qcircleshadow.lib;

import abwp;
import abwz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import cooperation.qqcircle.utils.QCircleCommonUtil;

public class QCircleHostChatHelper
{
  public static int getUnReadNum(String paramString, int paramInt)
  {
    QQAppInterface localQQAppInterface = QCircleCommonUtil.getQQAppInterface();
    if ((localQQAppInterface != null) && (localQQAppInterface.getConversationFacade() != null)) {
      return localQQAppInterface.getConversationFacade().a(paramString, paramInt);
    }
    return 0;
  }
  
  public static boolean isOneWayBoxConversation(MessageRecord paramMessageRecord)
  {
    return abwz.d(paramMessageRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostChatHelper
 * JD-Core Version:    0.7.0.1
 */