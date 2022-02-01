package com.tencent.avgame.gameresult;

import android.os.Looper;
import android.os.Message;
import com.tencent.avgame.business.handler.AvGameRoomListHandler;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;

class GameResultUploadMgrForRemote$1
  extends TransProcessorHandler
{
  GameResultUploadMgrForRemote$1(GameResultUploadMgrForRemote paramGameResultUploadMgrForRemote, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    Object localObject1;
    ITransFileController localITransFileController;
    int i;
    Object localObject2;
    if ((localFileMsg != null) && (localFileMsg.fileType == 24))
    {
      if (localFileMsg.commandId != 78) {
        return;
      }
      localObject1 = GameResultUploadMgrForRemote.a(this.a);
      if (localObject1 == null) {
        return;
      }
      localITransFileController = (ITransFileController)((BaseQQAppInterface)localObject1).getRuntimeService(ITransFileController.class);
      i = paramMessage.what;
      if (i != 1003)
      {
        if (i != 1005) {
          return;
        }
        if (QLog.isColorLevel())
        {
          paramMessage = new StringBuilder();
          paramMessage.append("STATUS_SEND_ERROR:");
          paramMessage.append(localFileMsg.errorCode);
          QLog.d("GameResultUploadMgrForRemote_GameRC", 2, paramMessage.toString());
        }
        localITransFileController.removeHandle(this);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("GameResultUploadMgrForRemote send finished:");
        paramMessage.append(localFileMsg.fileType);
        QLog.d("GameResultUploadMgrForRemote_GameRC", 2, paramMessage.toString());
      }
      localObject2 = new Bdh_extinfo.UploadPicExtInfo();
    }
    try
    {
      ((Bdh_extinfo.UploadPicExtInfo)localObject2).mergeFrom(localFileMsg.bdhExtendInfo);
      String str = ((Bdh_extinfo.UploadPicExtInfo)localObject2).bytes_file_resid.get().toStringUtf8();
      paramMessage = ((Bdh_extinfo.UploadPicExtInfo)localObject2).bytes_download_url.get().toStringUtf8();
      localObject2 = ((Bdh_extinfo.UploadPicExtInfo)localObject2).bytes_thumb_download_url.get().toStringUtf8();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleMessage imageUUID[");
        localStringBuilder.append(str);
        localStringBuilder.append("],imageUrl[");
        localStringBuilder.append(paramMessage);
        localStringBuilder.append("], imageThumbUrl");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append("]");
        QLog.i("GameResultUploadMgrForRemote_GameRC", 1, localStringBuilder.toString());
      }
      localObject1 = (AvGameRoomListHandler)((BaseQQAppInterface)localObject1).getBusinessHandler(AvGameRoomListHandler.a);
      i = Integer.parseInt(localFileMsg.friendUin);
      if (localObject1 != null) {
        ((AvGameRoomListHandler)localObject1).a(i, localFileMsg.compressUrl, paramMessage);
      }
    }
    catch (Exception paramMessage)
    {
      label349:
      break label349;
    }
    localITransFileController.removeHandle(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultUploadMgrForRemote.1
 * JD-Core Version:    0.7.0.1
 */