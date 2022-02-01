package com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon;

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
  protected void b()
  {
    Object localObject = BaseBubbleBuilderUtil.a(this.b, this.a);
    DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)this.b.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).g(Long.parseLong((String)localObject));
    if ((localDeviceInfo != null) && (((String)localObject).equals(String.valueOf(localDeviceInfo.din)))) {
      localObject = new BitmapDrawable(BaseApplication.getContext().getResources(), DeviceHeadMgr.getInstance().getDeviceHeadByDin((String)localObject));
    } else {
      localObject = a(1, (String)localObject);
    }
    b(localObject);
  }
  
  public boolean h()
  {
    return (this.a.istroop == 9501) && (!this.a.isSend());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon.DeviceMsgHeadIconController
 * JD-Core Version:    0.7.0.1
 */