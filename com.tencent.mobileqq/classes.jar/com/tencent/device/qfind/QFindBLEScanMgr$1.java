package com.tencent.device.qfind;

import com.tencent.device.ble.QFindGattManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.im.oidb.qfind.QFind.DeviceInfo;

class QFindBLEScanMgr$1
  extends SosoInterfaceOnLocationListener
{
  QFindBLEScanMgr$1(QFindBLEScanMgr paramQFindBLEScanMgr, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString1, String paramString2)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString1);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramInt == 0)
    {
      QFind.DeviceInfo localDeviceInfo = (QFind.DeviceInfo)this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr.c.get(this.jdField_a_of_type_JavaLangString);
      BlePeerInfo localBlePeerInfo = (BlePeerInfo)this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr.a.remove(this.jdField_a_of_type_JavaLangString);
      localBlePeerInfo.a = paramSosoLbsInfo;
      Object localObject;
      if (localDeviceInfo.bytes_sig.has()) {
        localObject = localDeviceInfo.bytes_sig.get().toByteArray();
      } else {
        localObject = null;
      }
      localBlePeerInfo.jdField_b_of_type_ArrayOfByte = ((byte[])localObject);
      localBlePeerInfo.d = localDeviceInfo.uint32_need_verify_dev.get();
      boolean bool;
      if ((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L) - localDeviceInfo.timestamp.get() > localDeviceInfo.uint32_verify_dev_interval.get()) {
        bool = true;
      } else {
        bool = false;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reportDevWithLoc get location errorCode=");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(" ; needVerify = ");
        ((StringBuilder)localObject).append(localBlePeerInfo.d);
        ((StringBuilder)localObject).append(" ; exceedVerifyInterval= ");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(" ; peerInfo.ble_id = ");
        ((StringBuilder)localObject).append(localBlePeerInfo.c);
        QLog.i("QFindBLE", 2, ((StringBuilder)localObject).toString());
      }
      if ((localBlePeerInfo.d > 0) && (bool))
      {
        localBlePeerInfo.jdField_b_of_type_Boolean = true;
        QFindGattManager.a().a(this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr.a(localBlePeerInfo));
      }
      else
      {
        localBlePeerInfo.jdField_b_of_type_Boolean = false;
        QFindBLEScanMgr.a(this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr, localBlePeerInfo, paramSosoLbsInfo, false);
      }
      this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr.a.put(this.jdField_a_of_type_JavaLangString, localBlePeerInfo);
      return;
    }
    paramSosoLbsInfo = new StringBuilder();
    paramSosoLbsInfo.append("reportDevWithLoc get location failed errorCode=");
    paramSosoLbsInfo.append(paramInt);
    QLog.e("QFindBLE", 1, paramSosoLbsInfo.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.qfind.QFindBLEScanMgr.1
 * JD-Core Version:    0.7.0.1
 */