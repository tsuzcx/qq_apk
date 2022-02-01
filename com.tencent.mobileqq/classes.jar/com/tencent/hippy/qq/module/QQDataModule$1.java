package com.tencent.hippy.qq.module;

import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;
import org.json.JSONObject;

class QQDataModule$1
  implements WtTicketPromise
{
  QQDataModule$1(QQDataModule paramQQDataModule, String paramString, Promise paramPromise) {}
  
  public void Done(Ticket paramTicket)
  {
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("p_skey", QQDataModule.getPskeyFromTicket(paramTicket, this.val$domain));
      this.val$promise.resolve(((JSONObject)localObject).toString());
      return;
    }
    catch (Throwable paramTicket)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("asyncTicket wtTicketPromise error:");
      ((StringBuilder)localObject).append(paramTicket);
      QLog.e("QQDataModule", 1, ((StringBuilder)localObject).toString());
      this.val$promise.resolve("{}");
    }
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("asyncTicket wtTicketPromise error:");
    localStringBuilder.append(paramErrMsg.getMessage());
    QLog.e("QQDataModule", 1, localStringBuilder.toString());
    this.val$promise.resolve("{}");
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("asyncTicket wtTicketPromise error:");
    localStringBuilder.append(paramErrMsg.getMessage());
    QLog.e("QQDataModule", 1, localStringBuilder.toString());
    this.val$promise.resolve("{}");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQDataModule.1
 * JD-Core Version:    0.7.0.1
 */