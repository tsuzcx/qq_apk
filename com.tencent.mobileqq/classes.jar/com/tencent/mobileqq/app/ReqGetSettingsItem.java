package com.tencent.mobileqq.app;

import KQQ.ReqItem;
import KQQ.RespItem;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.service.MobileQQServiceExtend;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.troop.roamsetting.IReqGetSettingsHandler;
import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class ReqGetSettingsItem
  implements CheckUpdateItemInterface
{
  QQAppInterface a;
  IReqGetSettingsHandler b;
  
  public ReqGetSettingsItem(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.b = ((IRoamSettingService)this.a.getRuntimeService(IRoamSettingService.class, "")).getReqGetSettingsHandler();
  }
  
  public int a()
  {
    return 1;
  }
  
  public ReqItem a(int paramInt)
  {
    if (this.a.mAutomator.b == 2) {
      this.b.a(true);
    }
    if (this.b.a() != null)
    {
      Object localObject = this.a.mqqService.lookupCoder(this.b.a().getServiceCmd());
      if (localObject != null)
      {
        UniPacket localUniPacket = new UniPacket(true);
        localUniPacket.setEncodeName("utf-8");
        if (((BaseProtocolCoder)localObject).encodeReqMsg(this.b.a(), localUniPacket))
        {
          localObject = new ReqItem();
          ((ReqItem)localObject).eServiceID = 115;
          ((ReqItem)localObject).vecParam = localUniPacket.encode();
          return localObject;
        }
      }
    }
    return null;
  }
  
  public void a(RespItem paramRespItem)
  {
    if ((paramRespItem.eServiceID == 115) && (paramRespItem.cResult == 2)) {
      this.b.a(paramRespItem.vecUpdate);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ReqGetSettingsItem
 * JD-Core Version:    0.7.0.1
 */