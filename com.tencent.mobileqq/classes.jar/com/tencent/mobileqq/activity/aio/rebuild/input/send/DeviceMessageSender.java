package com.tencent.mobileqq.activity.aio.rebuild.input.send;

import android.text.Editable;
import android.text.TextUtils;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.input.BaseMessageSender;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgAIOContext;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;

public class DeviceMessageSender
  extends BaseMessageSender
{
  public DeviceMessageSender(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  public void b()
  {
    Object localObject3 = this.a.p().d().f();
    int i = ((EditTextUI)localObject3).a().length();
    boolean bool = true;
    Object localObject1;
    if (i > 0)
    {
      localObject2 = ((EditTextUI)localObject3).a().toString();
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).length() > 3478) {
          ChatActivityUtils.a(this.a.b(), 2131916265, 1);
        }
      }
    }
    else
    {
      localObject1 = null;
    }
    ((EditTextUI)localObject3).a("");
    localObject3 = (SmartDeviceProxyMgr)this.b.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    Object localObject2 = ((SmartDeviceProxyMgr)localObject3).g(Long.parseLong(this.c.b));
    if (localObject2 != null)
    {
      localObject3 = ((SmartDeviceProxyMgr)localObject3).b(((DeviceInfo)localObject2).productId);
      if ((localObject3 != null) && (((ProductInfo)localObject3).isSupportMainMsgType(1)))
      {
        i = 1;
        break label160;
      }
    }
    i = 0;
    label160:
    long l;
    int j;
    if (localObject2 != null)
    {
      l = ((DeviceInfo)localObject2).din;
      j = ((DeviceInfo)localObject2).productId;
    }
    else
    {
      l = 0L;
      j = 0;
    }
    if (i == 0)
    {
      localObject1 = (DeviceMsgHandle)this.b.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
      SmartDeviceReport.a(this.b, l, "Usr_AIO_SendMsg", 7, 0, j);
      return;
    }
    localObject2 = (DeviceMsgHandle)this.b.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject3 = this.b;
      BaseSessionInfo localBaseSessionInfo = this.c;
      if ((!DeviceMsgChatPie.br) || (!((DeviceMsgAIOContext)this.a).P())) {
        bool = false;
      }
      ((DeviceMsgHandle)localObject2).a((QQAppInterface)localObject3, localBaseSessionInfo, (String)localObject1, bool);
    }
    SmartDeviceReport.a(this.b, l, "Usr_AIO_SendMsg", 6, 0, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.send.DeviceMessageSender
 * JD-Core Version:    0.7.0.1
 */