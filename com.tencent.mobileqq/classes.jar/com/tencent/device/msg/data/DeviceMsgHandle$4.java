package com.tencent.device.msg.data;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;

class DeviceMsgHandle$4
  extends SecSvcObserver
{
  DeviceMsgHandle$4(DeviceMsgHandle paramDeviceMsgHandle) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString)
  {
    if (paramBoolean)
    {
      if (paramInt == 1)
      {
        EquipmentLockImpl.a().a(DeviceMsgHandle.a(this.a), BaseApplicationImpl.getApplication(), DeviceMsgHandle.a(this.a).getCurrentAccountUin(), true);
        return;
      }
      EquipmentLockImpl.a().a(DeviceMsgHandle.a(this.a), BaseApplicationImpl.getApplication(), DeviceMsgHandle.a(this.a).getCurrentAccountUin(), false);
      return;
    }
    EquipmentLockImpl.a().a(DeviceMsgHandle.a(this.a), BaseApplicationImpl.getApplication(), DeviceMsgHandle.a(this.a).getCurrentAccountUin(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.msg.data.DeviceMsgHandle.4
 * JD-Core Version:    0.7.0.1
 */