package com.tencent.mobileqq.activity.aio.basebubblebuilderheadicon;

import android.graphics.drawable.BitmapDrawable;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilderUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.BaseApplication;

public class DeviceMsgHeadIconController
  extends BaseDefaultHeadIconController
{
  protected void a()
  {
    Object localObject = BaseBubbleBuilderUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong((String)localObject));
    if ((localDeviceInfo != null) && (((String)localObject).equals(String.valueOf(localDeviceInfo.din)))) {}
    for (localObject = new BitmapDrawable(BaseApplication.getContext().getResources(), DeviceHeadMgr.getInstance().getDeviceHeadByDin((String)localObject));; localObject = a(1, (String)localObject))
    {
      a(localObject);
      return;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 9501) && (!this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.basebubblebuilderheadicon.DeviceMsgHeadIconController
 * JD-Core Version:    0.7.0.1
 */