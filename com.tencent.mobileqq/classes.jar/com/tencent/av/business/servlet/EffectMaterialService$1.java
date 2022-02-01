package com.tencent.av.business.servlet;

import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.av.business.servlet.coder.BaseJCECoder;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

class EffectMaterialService$1
  implements Runnable
{
  EffectMaterialService$1(EffectMaterialService paramEffectMaterialService, ToServiceMsg paramToServiceMsg) {}
  
  public void run()
  {
    Object localObject1 = this.a.getServiceCmd();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sendRequest ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("EffectMaterialService", 2, ((StringBuilder)localObject2).toString());
    }
    int j = 0;
    Object localObject2 = EffectMaterialService.a(this.this$0, (String)localObject1);
    int i = j;
    if (localObject2 != null)
    {
      UniPacket localUniPacket = new UniPacket(true);
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.setRequestId(EffectMaterialService.a(this.this$0));
      i = j;
      if (((BaseJCECoder)localObject2).a(this.a, localUniPacket))
      {
        this.a.putWupBuffer(localUniPacket.encode());
        i = 1;
      }
    }
    if (i != 0)
    {
      this.a.extraData.putLong("KEY_REQUEST_TIME", System.currentTimeMillis());
      localObject1 = new NewIntent(EffectMaterialService.b(this.this$0).getApplication(), EffectMaterialServlet.class);
      ((NewIntent)localObject1).putExtra(ToServiceMsg.class.getSimpleName(), this.a);
      EffectMaterialService.b(this.this$0).startServlet((NewIntent)localObject1);
      return;
    }
    localObject1 = new FromServiceMsg(this.a.getUin(), (String)localObject1);
    EffectMaterialService.a(this.this$0, this.a, (FromServiceMsg)localObject1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.servlet.EffectMaterialService.1
 * JD-Core Version:    0.7.0.1
 */