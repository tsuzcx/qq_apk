package com.tencent.biz.pubaccount.api.impl;

import android.os.Bundle;
import android.os.Message;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPttImpl;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class PublicAccountH5ManagerImpl$1
  extends TransProcessorHandler
{
  PublicAccountH5ManagerImpl$1(PublicAccountH5ManagerImpl paramPublicAccountH5ManagerImpl) {}
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if (localFileMsg != null)
    {
      if ((localFileMsg.fileType != 24) && (localFileMsg.fileType != 32)) {
        return;
      }
      if ((localFileMsg.fileType == 24) && (localFileMsg.commandId != 10)) {
        return;
      }
      int i = paramMessage.what;
      if (i != 2001) {
        if (i != 2003) {
          if (i == 2005) {}
        }
      }
      StringBuilder localStringBuilder;
      switch (i)
      {
      default: 
      case 1005: 
        paramMessage = (Bundle)this.a.mapDone.remove(Long.valueOf(localFileMsg.uniseq));
        this.a.removeUploadByKey(localFileMsg.uniseq);
        this.a.removeJSPttByKey(localFileMsg.uniseq);
        if (paramMessage != null)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("error");
            localStringBuilder.append(localFileMsg.uniseq);
            QLog.d("PAH5Manager", 2, localStringBuilder.toString());
          }
          paramMessage.putLong("uniseq", localFileMsg.uniseq);
          paramMessage.putString("pic_server_id", "-1");
          this.a.troopMemberApiService.a(24, paramMessage);
          return;
        }
        break;
      case 1003: 
        paramMessage = (Bundle)this.a.mapDone.remove(Long.valueOf(localFileMsg.uniseq));
        this.a.removeUploadByKey(localFileMsg.uniseq);
        this.a.removeJSPttByKey(localFileMsg.uniseq);
        if (paramMessage != null)
        {
          if (localFileMsg.fileType == 32)
          {
            new PublicAccountH5AbilityPttImpl();
            paramMessage.putLong("uniseq", localFileMsg.uniseq);
            paramMessage.putString("pic_server_id", PublicAccountH5AbilityPttImpl.getServerIdForPtt());
          }
          else
          {
            paramMessage.putLong("uniseq", localFileMsg.uniseq);
            paramMessage.putString("pic_server_id", localFileMsg.fileUrl);
          }
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("finished");
            localStringBuilder.append(localFileMsg.uniseq);
            QLog.d("PAH5Manager", 2, localStringBuilder.toString());
          }
          this.a.troopMemberApiService.a(24, paramMessage);
          return;
        }
        break;
      case 1001: 
        paramMessage = (Bundle)this.a.mapStart.remove(Long.valueOf(localFileMsg.uniseq));
        if ((paramMessage != null) && (paramMessage.getInt("is_showProgress_tips") == 1))
        {
          this.a.troopMemberApiService.a(23, paramMessage);
          if (QLog.isColorLevel())
          {
            paramMessage = new StringBuilder();
            paramMessage.append("start");
            paramMessage.append(localFileMsg.uniseq);
            QLog.d("PAH5Manager", 2, paramMessage.toString());
            return;
            this.a.removeJSPttByKey(localFileMsg.uniseq);
            paramMessage = (Bundle)this.a.mapDone.remove(Long.valueOf(localFileMsg.uniseq));
            if (paramMessage != null)
            {
              paramMessage.putString("pic_local_id", "-1");
              this.a.troopMemberApiService.a(26, paramMessage);
              return;
              this.a.removeJSPttByKey(localFileMsg.uniseq);
              paramMessage = (Bundle)this.a.mapDone.remove(Long.valueOf(localFileMsg.uniseq));
              if (paramMessage != null)
              {
                if (localFileMsg.fileType == 32) {
                  paramMessage.putString("pic_local_id", new PublicAccountH5AbilityPttImpl().getLocalIdForPTTDownLoad(null));
                }
                this.a.troopMemberApiService.a(26, paramMessage);
                return;
                paramMessage = (Bundle)this.a.mapStart.remove(Long.valueOf(localFileMsg.uniseq));
                if ((paramMessage != null) && (paramMessage.getInt("is_showProgress_tips") == 1)) {
                  this.a.troopMemberApiService.a(25, paramMessage);
                }
              }
            }
          }
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountH5ManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */