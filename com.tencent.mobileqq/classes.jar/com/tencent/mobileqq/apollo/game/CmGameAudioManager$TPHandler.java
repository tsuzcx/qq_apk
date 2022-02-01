package com.tencent.mobileqq.apollo.game;

import android.os.Message;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.apollo.game.api.IApolloGameManager;
import com.tencent.mobileqq.apollo.game.api.impl.ApolloGameManagerImpl;
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
    if (localObject1 != null)
    {
      if (((FileMsg)localObject1).commandId != 36) {
        return;
      }
      switch (paramMessage.what)
      {
      default: 
      case 1005: 
        paramMessage = new StringBuilder();
        paramMessage.append("[TransProcessorHandler] upload error:");
        paramMessage.append(((FileMsg)localObject1).serverPath);
        QLog.e("[cmshow]CmGameTemp_CmGameAudioManager", 1, paramMessage.toString());
        return;
      case 1004: 
        paramMessage = new StringBuilder();
        paramMessage.append("upload cmshow cancel:");
        paramMessage.append(((FileMsg)localObject1).serverPath);
        QLog.i("[cmshow]CmGameTemp_CmGameAudioManager", 1, paramMessage.toString());
        return;
      case 1003: 
        if (QLog.isColorLevel())
        {
          paramMessage = new StringBuilder();
          paramMessage.append("finish upload cmshow record");
          paramMessage.append(((FileMsg)localObject1).serverPath);
          QLog.d("[cmshow]CmGameTemp_CmGameAudioManager", 0, paramMessage.toString());
        }
        try
        {
          paramMessage = new cmd0x346.RspBody();
          paramMessage.mergeFrom(((FileMsg)localObject1).bdhExtendInfo);
          paramMessage = (cmd0x346.ApplyDownloadRsp)paramMessage.msg_apply_download_rsp.get();
          int i = paramMessage.int32_ret_code.get();
          if (i == 0)
          {
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
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("[uploadFile] url:");
            ((StringBuilder)localObject1).append(paramMessage);
            QLog.i("[cmshow]CmGameTemp_CmGameAudioManager", 1, ((StringBuilder)localObject1).toString());
            localObject1 = (ApolloGameManagerImpl)this.a.getRuntimeService(IApolloGameManager.class, "all");
            localObject2 = ((ApolloGameManagerImpl)localObject1).getCmGameAudioManager();
            ((ApolloGameManagerImpl)localObject1).getGameTempMsgHandler().a(this.a.getCurrentUin(), paramMessage, ((CmGameAudioManager)localObject2).a);
            return;
          }
          paramMessage = new StringBuilder();
          paramMessage.append("[TransProcessorHandler] upload fail,");
          paramMessage.append(i);
          QLog.e("[cmshow]CmGameTemp_CmGameAudioManager", 1, paramMessage.toString());
          paramMessage = ((ApolloGameManagerImpl)this.a.getRuntimeService(IApolloGameManager.class, "all")).getCmGameAudioManager();
          if ((paramMessage.b == null) || (paramMessage.b.get() == null)) {
            break;
          }
          ((CmGameAudioManager.UploadEventListener)paramMessage.b.get()).a(-1);
          return;
        }
        catch (Exception paramMessage)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("upload cmshow record response error e=");
        ((StringBuilder)localObject1).append(paramMessage.toString());
        QLog.e("[cmshow]CmGameTemp_CmGameAudioManager", 0, ((StringBuilder)localObject1).toString());
        return;
      case 1001: 
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]CmGameTemp_CmGameAudioManager", 0, "start upload cmshow record");
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.CmGameAudioManager.TPHandler
 * JD-Core Version:    0.7.0.1
 */