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
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  IReqGetSettingsHandler jdField_a_of_type_ComTencentMobileqqTroopRoamsettingIReqGetSettingsHandler;
  
  public ReqGetSettingsItem(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTroopRoamsettingIReqGetSettingsHandler = ((IRoamSettingService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRoamSettingService.class, "")).getReqGetSettingsHandler();
  }
  
  public int a()
  {
    return 1;
  }
  
  public ReqItem a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mAutomator.a == 2) {
      this.jdField_a_of_type_ComTencentMobileqqTroopRoamsettingIReqGetSettingsHandler.a(true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopRoamsettingIReqGetSettingsHandler.a() != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mqqService.lookupCoder(this.jdField_a_of_type_ComTencentMobileqqTroopRoamsettingIReqGetSettingsHandler.a().getServiceCmd());
      if (localObject != null)
      {
        UniPacket localUniPacket = new UniPacket(true);
        localUniPacket.setEncodeName("utf-8");
        if (((BaseProtocolCoder)localObject).encodeReqMsg(this.jdField_a_of_type_ComTencentMobileqqTroopRoamsettingIReqGetSettingsHandler.a(), localUniPacket))
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
      this.jdField_a_of_type_ComTencentMobileqqTroopRoamsettingIReqGetSettingsHandler.a(paramRespItem.vecUpdate);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.ReqGetSettingsItem
 * JD-Core Version:    0.7.0.1
 */