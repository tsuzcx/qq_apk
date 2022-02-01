package com.tencent.device.file;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;

public class DevAudioMsgProcessor
  implements DeviceAVFileMsgObserver.DevMsgProcessor
{
  public static MessageRecord a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    byte[] arrayOfByte = new byte[3];
    PkgTools.intToAscString(paramString1.length(), arrayOfByte, 0, 3, "utf-8");
    paramString2 = (MessageForDevPtt)MessageRecordFactory.b(paramQQAppInterface, paramString2, paramString3, paramInt);
    paramString2.url = paramString1;
    paramString2.fileSize = -3L;
    paramString2.itemType = 2;
    if ((SttManager.a(paramInt)) && (SttManager.a(paramQQAppInterface))) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramString2.sttAbility = paramInt;
      paramString2.longPttVipFlag = 0;
      paramString2.c2cViaOffline = true;
      paramString2.msg = paramString2.getSummary();
      paramString2.issend = 1;
      paramString2.isread = false;
      paramString2.serial();
      paramQQAppInterface.getMessageFacade().a(paramString2, paramQQAppInterface.getCurrentAccountUin());
      return paramString2;
    }
  }
  
  public void a(Session paramSession, String paramString, long paramLong, int paramInt, float paramFloat)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    MessageRecord localMessageRecord;
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      localMessageRecord = ((QQAppInterface)localObject).getMessageFacade().a(paramString, paramInt, paramLong);
      if (localMessageRecord != null) {
        break label43;
      }
    }
    label43:
    MessageForDevPtt localMessageForDevPtt;
    do
    {
      do
      {
        return;
      } while (!(localMessageRecord instanceof MessageForDevPtt));
      localMessageForDevPtt = (MessageForDevPtt)localMessageRecord;
      localMessageForDevPtt.fileSessionId = paramSession.uSessionID;
      localMessageForDevPtt.serial();
      ((QQAppInterface)localObject).getMessageFacade().a(paramString, paramInt, localMessageRecord.uniseq, localMessageForDevPtt.msgData);
    } while (!QLog.isColorLevel());
    QLog.d("DeviceAudioMsg", 2, "updatemsg msg.uniseq:" + localMessageRecord.uniseq + " ===> filesize:" + localMessageForDevPtt.fileSize);
  }
  
  public void a(Session paramSession, String paramString, long paramLong, int paramInt, boolean paramBoolean)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    MessageRecord localMessageRecord;
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      localMessageRecord = ((QQAppInterface)localObject).getMessageFacade().a(paramString, paramInt, paramLong);
      if (localMessageRecord != null) {
        break label43;
      }
    }
    label43:
    while (!(localMessageRecord instanceof MessageForDevPtt)) {
      return;
    }
    MessageForDevPtt localMessageForDevPtt = (MessageForDevPtt)localMessageRecord;
    localMessageForDevPtt.url = paramSession.strFilePathSrc;
    localMessageForDevPtt.itemType = 2;
    localMessageForDevPtt.issend = 1;
    if (paramBoolean) {
      localMessageForDevPtt.fileSize = paramSession.uFileSizeSrc;
    }
    for (localMessageRecord.extraflag = 32770;; localMessageRecord.extraflag = 32768)
    {
      localMessageForDevPtt.msg = localMessageForDevPtt.getSummary();
      localMessageForDevPtt.serial();
      ((QQAppInterface)localObject).getMessageFacade().a(paramString, paramInt, localMessageRecord.uniseq, localMessageForDevPtt.msgData);
      return;
      localMessageForDevPtt.fileSize = -1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.device.file.DevAudioMsgProcessor
 * JD-Core Version:    0.7.0.1
 */