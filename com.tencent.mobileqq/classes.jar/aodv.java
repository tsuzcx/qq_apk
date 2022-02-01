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

public class aodv
  extends aods
{
  public aodv(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    super(paramQQAppInterface, paramFriendListHandler);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("key_permission_opcode");
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("key_dongtai_permission", false);
    FriendListHandler localFriendListHandler = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
    boolean bool1;
    if (FriendListHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject) == null)
    {
      if (!QLog.isColorLevel()) {
        break label169;
      }
      QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handleSetDongtaiPermission: ssoPkg parse failed");
      bool1 = false;
    }
    for (;;)
    {
      if (!bool1) {
        if (i == 1) {
          bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e(false);
        }
      }
      label259:
      for (;;)
      {
        label76:
        if (i == 1) {
          a(81, bool1, Boolean.valueOf(bool2));
        }
        label169:
        do
        {
          return;
          if (i == 1) {}
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(bool2, false);
          }
          catch (Exception paramToServiceMsg)
          {
            if (!QLog.isColorLevel()) {
              break label169;
            }
            QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handleSetDongtaiPermission " + paramToServiceMsg.getMessage());
          }
          if (i == 2)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.g(bool2, false);
            break label262;
            bool1 = false;
            break;
          }
          if (i != 3) {
            break label262;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(bool2, false);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.g(bool2, false);
          break label262;
          if (i != 2) {
            break label259;
          }
          bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(false);
          break label76;
          if (i == 2)
          {
            a(83, bool1, Boolean.valueOf(bool2));
            return;
          }
        } while (i != 3);
        a(85, bool1, null);
        return;
      }
      label262:
      bool1 = true;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool1;
    int i;
    Object localObject;
    if ((paramObject != null) && (paramFromServiceMsg.isSuccess()))
    {
      bool1 = true;
      i = paramToServiceMsg.extraData.getInt("key_permission_opcode");
      paramFromServiceMsg = null;
      localObject = null;
      if (!bool1) {
        break label698;
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.get() == 0))
        {
          bool2 = true;
          if (!bool2) {
            continue;
          }
          paramObject = new cmd0x7c7.RspBody();
          paramObject.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          if (i != 1) {
            continue;
          }
          j = paramObject.uint32_not_see_qzone.get();
          if (j != 1) {
            continue;
          }
          bool1 = true;
          bool3 = bool1;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        try
        {
          if (paramObject.uint32_not_see_qzone.get() == 1)
          {
            bool1 = true;
            paramToServiceMsg.add(Boolean.valueOf(bool1));
            if (paramObject.uint32_prevent_dynamic.get() == 1)
            {
              bool1 = true;
              paramToServiceMsg.add(Boolean.valueOf(bool1));
              paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              if (paramObject.uint32_not_see_qzone.get() != 1) {
                continue;
              }
              bool1 = true;
              paramFromServiceMsg.f(bool1, false);
              paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              if (paramObject.uint32_prevent_dynamic.get() != 1) {
                continue;
              }
              bool1 = true;
              paramFromServiceMsg.g(bool1, false);
              bool1 = true;
            }
          }
          else
          {
            bool1 = false;
            continue;
          }
          bool1 = false;
          continue;
          bool1 = false;
          continue;
          bool1 = false;
          continue;
          if (paramToServiceMsg == null) {
            continue;
          }
          int j = paramToServiceMsg.uint32_result.get();
          paramToServiceMsg = localObject;
          bool1 = bool4;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handleGetDongtaiPermission  fail resultCode : " + j);
          paramToServiceMsg = localObject;
          bool1 = bool4;
        }
        catch (Exception paramObject)
        {
          paramFromServiceMsg = paramToServiceMsg;
          paramToServiceMsg = paramObject;
          bool1 = bool3;
          continue;
        }
        paramToServiceMsg = paramToServiceMsg;
        bool1 = bool3;
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handleGetDongtaiPermission Exception " + paramToServiceMsg.getMessage());
        }
        paramToServiceMsg = paramFromServiceMsg;
        bool2 = false;
        continue;
        paramToServiceMsg = localObject;
        bool1 = bool4;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "ssoPkg is null");
        paramToServiceMsg = localObject;
        bool1 = bool4;
        continue;
        if (i == 2)
        {
          bool3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(false);
          paramFromServiceMsg = paramToServiceMsg;
          continue;
        }
        paramFromServiceMsg = paramToServiceMsg;
        bool3 = bool1;
        if (i != 3) {
          continue;
        }
        paramFromServiceMsg = new ArrayList();
        paramFromServiceMsg.add(Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e(false)));
        paramFromServiceMsg.add(Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(false)));
        bool3 = bool1;
        continue;
        if (i == 2)
        {
          a(84, bool2, Boolean.valueOf(bool3));
          return;
        }
        if (i != 3) {
          continue;
        }
        a(86, bool2, paramFromServiceMsg);
        return;
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(bool1, false);
        paramToServiceMsg = null;
      }
      catch (Exception paramToServiceMsg)
      {
        bool1 = bool3;
        continue;
        paramToServiceMsg = null;
        bool1 = true;
        continue;
      }
      paramFromServiceMsg = paramToServiceMsg;
      bool3 = bool1;
      if (!bool2)
      {
        if (i == 1)
        {
          bool3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e(false);
          paramFromServiceMsg = paramToServiceMsg;
        }
      }
      else
      {
        if (i != 1) {
          continue;
        }
        a(82, bool2, Boolean.valueOf(bool3));
        return;
        bool1 = false;
        break;
        bool2 = false;
        continue;
        bool1 = false;
        continue;
        if (i == 2)
        {
          j = paramObject.uint32_prevent_dynamic.get();
          if (j == 1)
          {
            bool1 = true;
            bool3 = bool1;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.g(bool1, false);
            paramToServiceMsg = null;
            continue;
          }
          bool1 = false;
          continue;
        }
        if (i != 3) {
          break label690;
        }
        paramToServiceMsg = new ArrayList();
      }
      label690:
      label698:
      bool3 = true;
      boolean bool2 = bool1;
      paramToServiceMsg = null;
      bool1 = bool3;
    }
  }
  
  public boolean a(String paramString)
  {
    return ("OidbSvc.0x7c6_0".equals(paramString)) || ("OidbSvc.0x7c7_0".equals(paramString));
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("OidbSvc.0x7c6_0".equals(str)) {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    while (!"OidbSvc.0x7c7_0".equals(str)) {
      return;
    }
    d(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aodv
 * JD-Core Version:    0.7.0.1
 */