package com.tencent.device.file;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.stt.ISttManagerApi;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;

public class DevAudioMsgProcessor
  implements DeviceAVFileMsgObserver.DevMsgProcessor
{
  public static MessageRecord a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    byte[] arrayOfByte = new byte[3];
    PkgTools.intToAscString(paramString1.length(), arrayOfByte, 0, 3, "utf-8");
    paramString2 = (MessageForDevPtt)MessageRecordFactory.f(paramQQAppInterface, paramString2, paramString3, paramInt);
    paramString2.url = paramString1;
    paramString2.fileSize = -3L;
    paramString2.itemType = 2;
    if ((((ISttManagerApi)QRoute.api(ISttManagerApi.class)).isSttSession(paramInt)) && (((ISttManagerApi)QRoute.api(ISttManagerApi.class)).getSttAbility(paramQQAppInterface))) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
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
  
  public void a(Session paramSession, String paramString, long paramLong, int paramInt, float paramFloat)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)localObject;
      localObject = localQQAppInterface.getMessageFacade().a(paramString, paramInt, paramLong);
      if (localObject == null) {
        return;
      }
      if ((localObject instanceof MessageForDevPtt))
      {
        MessageForDevPtt localMessageForDevPtt = (MessageForDevPtt)localObject;
        localMessageForDevPtt.fileSessionId = paramSession.uSessionID;
        localMessageForDevPtt.serial();
        localQQAppInterface.getMessageFacade().a(paramString, paramInt, ((MessageRecord)localObject).uniseq, localMessageForDevPtt.msgData);
        if (QLog.isColorLevel())
        {
          paramSession = new StringBuilder();
          paramSession.append("updatemsg msg.uniseq:");
          paramSession.append(((MessageRecord)localObject).uniseq);
          paramSession.append(" ===> filesize:");
          paramSession.append(localMessageForDevPtt.fileSize);
          QLog.d("DeviceAudioMsg", 2, paramSession.toString());
        }
      }
    }
  }
  
  public void a(Session paramSession, String paramString, long paramLong, int paramInt, boolean paramBoolean)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      MessageRecord localMessageRecord = ((QQAppInterface)localObject).getMessageFacade().a(paramString, paramInt, paramLong);
      if (localMessageRecord == null) {
        return;
      }
      if ((localMessageRecord instanceof MessageForDevPtt))
      {
        MessageForDevPtt localMessageForDevPtt = (MessageForDevPtt)localMessageRecord;
        localMessageForDevPtt.url = paramSession.strFilePathSrc;
        localMessageForDevPtt.itemType = 2;
        localMessageForDevPtt.issend = 1;
        if (paramBoolean)
        {
          localMessageForDevPtt.fileSize = paramSession.uFileSizeSrc;
          localMessageRecord.extraflag = 32770;
        }
        else
        {
          localMessageForDevPtt.fileSize = -1L;
          localMessageRecord.extraflag = 32768;
        }
        localMessageForDevPtt.msg = localMessageForDevPtt.getSummary();
        localMessageForDevPtt.serial();
        ((QQAppInterface)localObject).getMessageFacade().a(paramString, paramInt, localMessageRecord.uniseq, localMessageForDevPtt.msgData);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.file.DevAudioMsgProcessor
 * JD-Core Version:    0.7.0.1
 */