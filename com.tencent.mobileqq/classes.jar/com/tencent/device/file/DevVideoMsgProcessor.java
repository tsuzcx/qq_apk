package com.tencent.device.file;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.litetransfersdk.ActionInfo;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class DevVideoMsgProcessor
  implements DeviceAVFileMsgObserver.DevMsgProcessor
{
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2)
  {
    if (paramQQAppInterface != null)
    {
      if (paramContext == null) {
        return;
      }
      ThreadManager.getFileThreadHandler().post(new DevVideoMsgProcessor.1(paramString1, paramString2, paramQQAppInterface));
    }
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
      if ((localObject instanceof MessageForDevShortVideo))
      {
        MessageForDevShortVideo localMessageForDevShortVideo = (MessageForDevShortVideo)localObject;
        localMessageForDevShortVideo.videoFileSize = ((int)paramSession.uFileSizeSrc);
        localMessageForDevShortVideo.fileSessionId = paramSession.uSessionID;
        localMessageForDevShortVideo.videoFileProgress = ((int)(paramFloat * 100.0F));
        localMessageForDevShortVideo.serial();
        localQQAppInterface.getMessageFacade().a(paramString, paramInt, ((MessageRecord)localObject).uniseq, localMessageForDevShortVideo.msgData);
        if (QLog.isColorLevel())
        {
          paramSession = new StringBuilder();
          paramSession.append("updatemsg msg.uniseq:");
          paramSession.append(((MessageRecord)localObject).uniseq);
          paramSession.append(" ===> filesize:");
          paramSession.append(localMessageForDevShortVideo.videoFileSize);
          QLog.d("DeviceShortVideo", 2, paramSession.toString());
        }
      }
      else if ((localObject instanceof MessageForDevLittleVideo))
      {
        paramSession = (MessageForDevLittleVideo)localObject;
        paramSession.videoFileStatus = 1002;
        paramSession.videoFileProgress = ((int)(paramFloat * 100.0F));
        paramSession.serial();
        localQQAppInterface.getMessageFacade().a(paramString, paramInt, ((MessageRecord)localObject).uniseq, paramSession.msgData);
      }
    }
  }
  
  public void a(Session paramSession, String paramString, long paramLong, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)localObject1;
      localObject1 = localQQAppInterface.getMessageFacade().a(paramString, paramInt, paramLong);
      if (localObject1 == null) {
        return;
      }
      Object localObject2;
      if ((localObject1 instanceof MessageForDevShortVideo))
      {
        localObject2 = (MessageForDevShortVideo)localObject1;
        if (!paramSession.bSend)
        {
          if (paramSession.actionInfo.strServiceName.equalsIgnoreCase(DeviceMsgHandle.e))
          {
            Object localObject3 = new DevShortVideoSendOperator();
            ((DevShortVideoSendOperator)localObject3).jdField_c_of_type_JavaLangString = paramSession.strFilePathSrc;
            ((DevShortVideoSendOperator)localObject3).a();
            ((MessageForDevShortVideo)localObject2).md5 = ((DevShortVideoSendOperator)localObject3).e;
            ((MessageForDevShortVideo)localObject2).videoFileTime = ((int)(((DevShortVideoSendOperator)localObject3).jdField_b_of_type_Long / 1000L));
            ((MessageForDevShortVideo)localObject2).thumbWidth = ((DevShortVideoSendOperator)localObject3).jdField_b_of_type_Int;
            ((MessageForDevShortVideo)localObject2).thumbHeight = ((DevShortVideoSendOperator)localObject3).jdField_c_of_type_Int;
            ((MessageForDevShortVideo)localObject2).thumbMD5 = ((DevShortVideoSendOperator)localObject3).g;
            if (paramBoolean) {
              ((MessageForDevShortVideo)localObject2).videoFileStatus = 2003;
            } else {
              ((MessageForDevShortVideo)localObject2).videoFileStatus = 2005;
            }
            localObject3 = SVUtils.a((MessageForShortVideo)localObject2, "mp4");
            FileUtils.moveFile(paramSession.strFilePathSrc, (String)localObject3);
          }
        }
        else
        {
          ((MessageForDevShortVideo)localObject2).videoFileSize = ((int)paramSession.uFileSizeSrc);
          ((MessageRecord)localObject1).issend = 1;
          if (paramBoolean) {
            ((MessageForDevShortVideo)localObject2).videoFileStatus = 1003;
          } else {
            ((MessageForDevShortVideo)localObject2).videoFileStatus = 1005;
          }
        }
        ((MessageForDevShortVideo)localObject2).msg = ((MessageForDevShortVideo)localObject2).getSummary();
        ((MessageForDevShortVideo)localObject2).serial();
        localQQAppInterface.getMessageFacade().a(paramString, paramInt, ((MessageRecord)localObject1).uniseq, ((MessageForDevShortVideo)localObject2).msgData);
        if (QLog.isColorLevel())
        {
          paramSession = new StringBuilder();
          paramSession.append("updatemsg msg.uniseq:");
          paramSession.append(((MessageRecord)localObject1).uniseq);
          paramSession.append(" ===> fileStatus:");
          paramSession.append(SVUtils.b(((MessageForDevShortVideo)localObject2).videoFileStatus));
          QLog.d("DeviceShortVideo", 2, paramSession.toString());
        }
      }
      else if ((localObject1 instanceof MessageForDevLittleVideo))
      {
        localObject2 = (MessageForDevLittleVideo)localObject1;
        if (paramSession.bSend)
        {
          if (paramBoolean)
          {
            ((MessageForDevLittleVideo)localObject2).videoFileStatus = 1003;
            ((MessageForDevLittleVideo)localObject2).videoFileProgress = 100;
          }
          else
          {
            ((MessageForDevLittleVideo)localObject2).videoFileStatus = 1005;
            ((MessageForDevLittleVideo)localObject2).videoFileProgress = 0;
          }
          ((MessageForDevLittleVideo)localObject2).serial();
          localQQAppInterface.getMessageFacade().a(paramString, paramInt, ((MessageRecord)localObject1).uniseq, ((MessageRecord)localObject1).msgData);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.file.DevVideoMsgProcessor
 * JD-Core Version:    0.7.0.1
 */