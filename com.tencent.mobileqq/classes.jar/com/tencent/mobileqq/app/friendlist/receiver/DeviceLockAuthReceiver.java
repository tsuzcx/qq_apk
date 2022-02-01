package com.tencent.mobileqq.app.friendlist.receiver;

import com.tencent.ims.device_lock_recommend_auth.DeviceInfo;
import com.tencent.ims.device_lock_recommend_auth.RspBody;
import com.tencent.mobileqq.antiphing.DeviceLockItemInfo;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class DeviceLockAuthReceiver
  extends BaseHandlerReceiver
{
  public DeviceLockAuthReceiver(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    super(paramQQAppInterface, paramFriendListHandler);
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.isSuccess()) {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "onReceive: onReceive handleRecommendDeviceList");
      }
    }
    for (paramFromServiceMsg = new device_lock_recommend_auth.RspBody();; paramFromServiceMsg = null)
    {
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.uint64_uin.has()) {
          paramFromServiceMsg.uint64_uin.get();
        }
        if (paramFromServiceMsg.uint32_seq.has()) {
          paramFromServiceMsg.uint32_seq.get();
        }
        if (paramFromServiceMsg.uint32_ret.has()) {
          paramFromServiceMsg.uint32_ret.get();
        }
        if (!paramFromServiceMsg.rpt_msg_devicelist.has()) {
          continue;
        }
        paramFromServiceMsg = paramFromServiceMsg.rpt_msg_devicelist.get();
        paramObject = new ArrayList();
        if (paramFromServiceMsg == null) {}
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        try
        {
          int j = paramFromServiceMsg.size();
          int i = 0;
          label135:
          if (i < j)
          {
            device_lock_recommend_auth.DeviceInfo localDeviceInfo = (device_lock_recommend_auth.DeviceInfo)paramFromServiceMsg.get(i);
            if (localDeviceInfo == null) {}
            for (;;)
            {
              i += 1;
              break label135;
              paramObject = paramObject;
              if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "onReceive: onReceive sec_server package:sigResult parse fail");
              }
              paramObject.printStackTrace();
              break;
              DeviceLockItemInfo localDeviceLockItemInfo = new DeviceLockItemInfo();
              if (localDeviceInfo.bytes_appname.has())
              {
                localDeviceLockItemInfo.jdField_c_of_type_JavaLangString = new String(localDeviceInfo.bytes_appname.get().toByteArray(), "UTF-8");
                if (localDeviceInfo.bytes_guid.has())
                {
                  localDeviceLockItemInfo.jdField_a_of_type_ArrayOfByte = localDeviceInfo.bytes_guid.get().toByteArray();
                  if (localDeviceInfo.bytes_device_typeinfo.has())
                  {
                    localDeviceLockItemInfo.jdField_b_of_type_JavaLangString = new String(localDeviceInfo.bytes_device_typeinfo.get().toByteArray(), "UTF-8");
                    new StringBuffer();
                    if (localDeviceInfo.bytes_device_name.has())
                    {
                      localDeviceLockItemInfo.jdField_a_of_type_JavaLangString = new String(localDeviceInfo.bytes_device_name.get().toByteArray(), "UTF-8");
                      if (localDeviceInfo.uint32_auth_status.has())
                      {
                        localDeviceLockItemInfo.jdField_c_of_type_Int = localDeviceInfo.uint32_auth_status.get();
                        if (localDeviceInfo.uint32_appid.has())
                        {
                          localDeviceLockItemInfo.jdField_a_of_type_Int = localDeviceInfo.uint32_appid.get();
                          if (localDeviceInfo.uint32_subappid.has())
                          {
                            localDeviceLockItemInfo.jdField_b_of_type_Int = localDeviceInfo.uint32_subappid.get();
                            paramObject.add(localDeviceLockItemInfo);
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          if (paramObject.size() <= 0) {
            break label441;
          }
        }
        catch (Exception paramFromServiceMsg) {}
        this.a.notifyUI(69, true, paramObject);
        return;
      }
      label441:
      this.a.notifyUI(69, false, null);
      return;
    }
  }
  
  public boolean a(String paramString)
  {
    return ("DevLockAuthSvc.RecommendAuth".equals(paramString)) || ("DevLockAuthSvc.ConfirmAuth".equals(paramString));
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = paramFromServiceMsg.getServiceCmd();
    if ("DevLockAuthSvc.RecommendAuth".equals(paramToServiceMsg)) {
      a(paramFromServiceMsg, paramObject);
    }
    while (!"DevLockAuthSvc.ConfirmAuth".equals(paramToServiceMsg)) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.receiver.DeviceLockAuthReceiver
 * JD-Core Version:    0.7.0.1
 */