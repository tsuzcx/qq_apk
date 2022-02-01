package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AccountNotMatchException;

class AIOImageProviderService$4
  implements Runnable
{
  AIOImageProviderService$4(AIOImageProviderService paramAIOImageProviderService, long paramLong, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.this$0.h;
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return;
      }
      localObject = AIOImageProviderService.a(this.this$0, this.a, this.b);
      if ((localObject != null) && (MessageForPic.class.isInstance(localObject))) {
        localObject = (MessageForPic)localObject;
      }
    }
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("payFlow,id:");
        localStringBuilder.append(this.a);
        localStringBuilder.append(",subId:");
        localStringBuilder.append(this.b);
        QLog.d("AIOImageProviderService", 2, localStringBuilder.toString());
      }
      AIOImageProviderService.a((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.this$0.a), (MessageForPic)localObject);
      return;
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      label134:
      break label134;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageProviderService", 2, "no appRuntime");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService.4
 * JD-Core Version:    0.7.0.1
 */