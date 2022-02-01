package com.tencent.mobileqq.activity.aio.item;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.base.ToastUtil;

class GrayTipsItemBuilder$3$2
  implements DialogInterface.OnClickListener
{
  GrayTipsItemBuilder$3$2(GrayTipsItemBuilder.3 param3) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!NetworkUtil.g(this.a.a.jdField_a_of_type_AndroidContentContext)) {
      ToastUtil.a().a(2131691604);
    }
    do
    {
      return;
      paramDialogInterface = (SmartDeviceProxyMgr)this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
      paramDialogInterface.a(Long.parseLong(this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), 0, 1, 0);
      paramDialogInterface = paramDialogInterface.a(Long.parseLong(this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a));
    } while (paramDialogInterface == null);
    SmartDeviceReport.a(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), "Usr_AIO_Menu", 5, 0, paramDialogInterface.productId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.3.2
 * JD-Core Version:    0.7.0.1
 */