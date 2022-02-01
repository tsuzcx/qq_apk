package com.tencent.mobileqq.apollo.lightGame;

import android.os.Message;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import java.lang.ref.WeakReference;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadInfo;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;

public class CmGameAudioManager$TPHandler
  extends TransProcessorHandler
{
  QQAppInterface a;
  
  public CmGameAudioManager$TPHandler(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject1 = (FileMsg)paramMessage.obj;
    if ((localObject1 == null) || (((FileMsg)localObject1).commandId != 36)) {}
    do
    {
      int i;
      do
      {
        do
        {
          return;
          switch (paramMessage.what)
          {
          case 1002: 
          default: 
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.d("CmGameTemp_CmGameAudioManager", 0, "start upload cmshow record");
        return;
        if (QLog.isColorLevel()) {
          QLog.d("CmGameTemp_CmGameAudioManager", 0, "finish upload cmshow record" + ((FileMsg)localObject1).serverPath);
        }
        try
        {
          paramMessage = new cmd0x346.RspBody();
          paramMessage.mergeFrom(((FileMsg)localObject1).bdhExtendInfo);
          paramMessage = (cmd0x346.ApplyDownloadRsp)paramMessage.msg_apply_download_rsp.get();
          i = paramMessage.int32_ret_code.get();
          if (i != 0) {
            break;
          }
          Object localObject2 = (cmd0x346.DownloadInfo)paramMessage.msg_download_info.get();
          localObject1 = null;
          paramMessage = (Message)localObject1;
          if (localObject2 != null)
          {
            paramMessage = (Message)localObject1;
            if (((cmd0x346.DownloadInfo)localObject2).str_download_url.has()) {
              paramMessage = ((cmd0x346.DownloadInfo)localObject2).str_download_url.get();
            }
          }
          QLog.i("CmGameTemp_CmGameAudioManager", 1, "[uploadFile] url:" + paramMessage);
          localObject1 = (ApolloManagerServiceImpl)this.a.getRuntimeService(IApolloManagerService.class, "all");
          localObject2 = ((ApolloManagerServiceImpl)localObject1).getCmGameAudioManager();
          ((ApolloManagerServiceImpl)localObject1).getGameTempMsgHandler().a(this.a.getCurrentUin(), paramMessage, ((CmGameAudioManager)localObject2).a);
          return;
        }
        catch (Exception paramMessage) {}
      } while (!QLog.isColorLevel());
      QLog.e("CmGameTemp_CmGameAudioManager", 0, "upload cmshow record response error e=" + paramMessage.toString());
      return;
      QLog.e("CmGameTemp_CmGameAudioManager", 1, "[TransProcessorHandler] upload fail," + i);
      paramMessage = ((ApolloManagerServiceImpl)this.a.getRuntimeService(IApolloManagerService.class, "all")).getCmGameAudioManager();
    } while ((paramMessage.b == null) || (paramMessage.b.get() == null));
    ((CmGameAudioManager.UploadEventListener)paramMessage.b.get()).a(-1);
    return;
    QLog.e("CmGameTemp_CmGameAudioManager", 1, "[TransProcessorHandler] upload error:" + ((FileMsg)localObject1).serverPath);
    return;
    QLog.i("CmGameTemp_CmGameAudioManager", 1, "upload cmshow cancel:" + ((FileMsg)localObject1).serverPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.lightGame.CmGameAudioManager.TPHandler
 * JD-Core Version:    0.7.0.1
 */