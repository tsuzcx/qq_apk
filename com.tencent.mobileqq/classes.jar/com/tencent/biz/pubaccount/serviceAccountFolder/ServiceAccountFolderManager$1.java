package com.tencent.biz.pubaccount.serviceAccountFolder;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;

class ServiceAccountFolderManager$1
  extends MessageObserver
{
  ServiceAccountFolderManager$1(ServiceAccountFolderManager paramServiceAccountFolderManager) {}
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSendResult->puin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", isSuccess:");
      localStringBuilder.append(paramBoolean);
      QLog.d("ServiceAccountFolderManager", 2, localStringBuilder.toString());
    }
    ServiceAccountFolderManager.a(this.a, paramString);
  }
  
  protected void onUpdateSendMsgError(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      paramSendMessageHandler = new StringBuilder();
      paramSendMessageHandler.append("onUpdateSendMsgError->uin:");
      paramSendMessageHandler.append(paramString1);
      paramSendMessageHandler.append(", type:");
      paramSendMessageHandler.append(paramInt1);
      paramSendMessageHandler.append(", uniseq:");
      paramSendMessageHandler.append(paramLong2);
      paramSendMessageHandler.append(", errorCode:");
      paramSendMessageHandler.append(paramInt2);
      QLog.d("ServiceAccountFolderManager", 2, paramSendMessageHandler.toString());
    }
    ServiceAccountFolderManager.a(this.a, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager.1
 * JD-Core Version:    0.7.0.1
 */