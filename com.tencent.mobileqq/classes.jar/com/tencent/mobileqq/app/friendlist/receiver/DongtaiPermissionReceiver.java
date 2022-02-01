package com.tencent.mobileqq.app.friendlist.receiver;

import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x7c7.cmd0x7c7.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class DongtaiPermissionReceiver
  extends BaseHandlerReceiver
{
  public DongtaiPermissionReceiver(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    super(paramQQAppInterface, paramFriendListHandler);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("key_permission_opcode");
    boolean bool3 = paramToServiceMsg.extraData.getBoolean("key_dongtai_permission", false);
    FriendListHandler localFriendListHandler = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
    if (FriendListHandler.parseSSOPkg(paramToServiceMsg, paramFromServiceMsg, paramObject) == null) {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handleSetDongtaiPermission: ssoPkg parse failed");
      }
    }
    for (;;)
    {
      bool2 = false;
      break label171;
      if (i == 1) {}
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setNotAllowedSeeMyDongtai(bool3, false);
      }
      catch (Exception paramFromServiceMsg)
      {
        boolean bool1;
        break label125;
      }
      if (i == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setShieldHisDongtai(bool3, false);
        break;
      }
      if (i != 3) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setNotAllowedSeeMyDongtai(bool3, false);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setShieldHisDongtai(bool3, false);
      break;
      label125:
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleSetDongtaiPermission ");
        paramToServiceMsg.append(paramFromServiceMsg.getMessage());
        QLog.d("FriendListHandler.BaseHandlerReceiver", 2, paramToServiceMsg.toString());
      }
    }
    boolean bool2 = true;
    label171:
    bool1 = bool3;
    if (!bool2) {
      if (i == 1)
      {
        bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNotAllowedSeeMyDongtai(false);
      }
      else
      {
        bool1 = bool3;
        if (i == 2) {
          bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getShieldHisDongtai(false);
        }
      }
    }
    if (i == 1)
    {
      a(79, bool2, Boolean.valueOf(bool1));
      return;
    }
    if (i == 2)
    {
      a(81, bool2, Boolean.valueOf(bool1));
      return;
    }
    if (i == 3) {
      a(83, bool2, null);
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2;
    if ((paramObject != null) && (paramFromServiceMsg.isSuccess())) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    int i = paramToServiceMsg.extraData.getInt("key_permission_opcode");
    Object localObject2 = null;
    Object localObject1 = null;
    paramToServiceMsg = null;
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = null;
    paramFromServiceMsg = null;
    if (bool2) {}
    for (;;)
    {
      try
      {
        localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.mergeFrom((byte[])paramObject);
        if (localOIDBSSOPkg.uint32_result.get() != 0) {
          break label650;
        }
        bool2 = true;
        int j;
        if (bool2)
        {
          paramObject = new cmd0x7c7.RspBody();
          paramObject.mergeFrom(localOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
          if (i == 1)
          {
            j = paramObject.uint32_not_see_qzone.get();
            if (j == 1) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            bool3 = bool1;
            try
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setNotAllowedSeeMyDongtai(bool1, false);
              paramToServiceMsg = localObject2;
            }
            catch (Exception paramFromServiceMsg)
            {
              continue;
            }
          }
          if (i == 2)
          {
            j = paramObject.uint32_prevent_dynamic.get();
            if (j == 1) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            bool3 = bool1;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setShieldHisDongtai(bool1, false);
            paramToServiceMsg = localObject2;
            continue;
          }
          paramToServiceMsg = paramFromServiceMsg;
          if (i == 3)
          {
            paramToServiceMsg = new ArrayList();
            try
            {
              if (paramObject.uint32_not_see_qzone.get() != 1) {
                break label656;
              }
              bool1 = true;
              paramToServiceMsg.add(Boolean.valueOf(bool1));
              if (paramObject.uint32_prevent_dynamic.get() != 1) {
                break label662;
              }
              bool1 = true;
              paramToServiceMsg.add(Boolean.valueOf(bool1));
              paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              if (paramObject.uint32_not_see_qzone.get() != 1) {
                break label668;
              }
              bool1 = true;
              paramFromServiceMsg.setNotAllowedSeeMyDongtai(bool1, false);
              paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              if (paramObject.uint32_prevent_dynamic.get() != 1) {
                break label674;
              }
              bool1 = true;
              paramFromServiceMsg.setShieldHisDongtai(bool1, false);
            }
            catch (Exception paramFromServiceMsg)
            {
              continue;
            }
          }
        }
        else
        {
          j = localOIDBSSOPkg.uint32_result.get();
          paramToServiceMsg = paramFromServiceMsg;
          if (QLog.isColorLevel())
          {
            paramToServiceMsg = new StringBuilder();
            paramToServiceMsg.append("handleGetDongtaiPermission  fail resultCode : ");
            paramToServiceMsg.append(j);
            QLog.d("FriendListHandler.BaseHandlerReceiver", 2, paramToServiceMsg.toString());
            paramToServiceMsg = paramFromServiceMsg;
          }
        }
        bool1 = true;
      }
      catch (Exception paramFromServiceMsg)
      {
        paramToServiceMsg = localObject1;
        bool3 = true;
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("handleGetDongtaiPermission Exception ");
          paramObject.append(paramFromServiceMsg.getMessage());
          QLog.d("FriendListHandler.BaseHandlerReceiver", 2, paramObject.toString());
        }
        bool1 = bool3;
        bool2 = false;
      }
      boolean bool1 = true;
      paramToServiceMsg = localOIDBSSOPkg;
      paramFromServiceMsg = paramToServiceMsg;
      boolean bool3 = bool1;
      if (!bool2) {
        if (i == 1)
        {
          bool3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNotAllowedSeeMyDongtai(false);
          paramFromServiceMsg = paramToServiceMsg;
        }
        else if (i == 2)
        {
          bool3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getShieldHisDongtai(false);
          paramFromServiceMsg = paramToServiceMsg;
        }
        else
        {
          paramFromServiceMsg = paramToServiceMsg;
          bool3 = bool1;
          if (i == 3)
          {
            paramFromServiceMsg = new ArrayList();
            paramFromServiceMsg.add(Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNotAllowedSeeMyDongtai(false)));
            paramFromServiceMsg.add(Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getShieldHisDongtai(false)));
            bool3 = bool1;
          }
        }
      }
      if (i == 1)
      {
        a(80, bool2, Boolean.valueOf(bool3));
        return;
      }
      if (i == 2)
      {
        a(82, bool2, Boolean.valueOf(bool3));
        return;
      }
      if (i == 3) {
        a(84, bool2, paramFromServiceMsg);
      }
      return;
      label650:
      bool2 = false;
      continue;
      label656:
      bool1 = false;
      continue;
      label662:
      bool1 = false;
      continue;
      label668:
      bool1 = false;
      continue;
      label674:
      bool1 = false;
    }
  }
  
  public boolean a(String paramString)
  {
    return ("OidbSvc.0x7c6_0".equals(paramString)) || ("OidbSvc.0x7c7_0".equals(paramString));
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("OidbSvc.0x7c6_0".equals(str))
    {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x7c7_0".equals(str)) {
      d(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.receiver.DongtaiPermissionReceiver
 * JD-Core Version:    0.7.0.1
 */