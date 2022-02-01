package com.tencent.mobileqq.app;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x58a.cmd0x58a.ConfBaseInfo;
import tencent.im.oidb.cmd0x58a.cmd0x58a.GetConfListRsp;
import tencent.im.oidb.cmd0x58a.cmd0x58a.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

class DiscussionHandler$HandleGetDiscussRespCheck
{
  private List<cmd0x58a.ConfBaseInfo> jdField_a_of_type_JavaUtilList;
  private oidb_sso.OIDBSSOPkg jdField_a_of_type_TencentImOidbOidb_sso$OIDBSSOPkg;
  private boolean jdField_a_of_type_Boolean;
  private List<Long> b;
  
  public DiscussionHandler$HandleGetDiscussRespCheck(DiscussionHandler paramDiscussionHandler, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    this.jdField_a_of_type_TencentImOidbOidb_sso$OIDBSSOPkg = paramOIDBSSOPkg;
  }
  
  public HandleGetDiscussRespCheck a()
  {
    if ((this.jdField_a_of_type_TencentImOidbOidb_sso$OIDBSSOPkg == null) || (!this.jdField_a_of_type_TencentImOidbOidb_sso$OIDBSSOPkg.uint32_result.has()) || (this.jdField_a_of_type_TencentImOidbOidb_sso$OIDBSSOPkg.uint32_result.get() != 0) || (!this.jdField_a_of_type_TencentImOidbOidb_sso$OIDBSSOPkg.bytes_bodybuffer.has()) || (this.jdField_a_of_type_TencentImOidbOidb_sso$OIDBSSOPkg.bytes_bodybuffer.get() == null))
    {
      if (QLog.isColorLevel()) {
        if (this.jdField_a_of_type_TencentImOidbOidb_sso$OIDBSSOPkg == null) {
          break label127;
        }
      }
      label127:
      for (int i = this.jdField_a_of_type_TencentImOidbOidb_sso$OIDBSSOPkg.uint32_result.get();; i = -1)
      {
        QLog.e("Q.contacttab.dscs", 2, "sso check fail " + i);
        this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.notifyUI(1000, false, null);
        this.jdField_a_of_type_Boolean = true;
        return this;
      }
    }
    for (Object localObject = new cmd0x58a.RspBody();; localList1 = null) {
      try
      {
        ((cmd0x58a.RspBody)localObject).mergeFrom(this.jdField_a_of_type_TencentImOidbOidb_sso$OIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
        if (((cmd0x58a.RspBody)localObject).msg_get_conf_list.has())
        {
          localObject = (cmd0x58a.GetConfListRsp)((cmd0x58a.RspBody)localObject).msg_get_conf_list.get();
          if (localObject != null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.e("Q.contacttab.dscs", 2, "getConfInfoRsp is null");
          }
          this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.notifyUI(1000, true, null);
          this.jdField_a_of_type_Boolean = true;
          return this;
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.contacttab.dscs", 2, "rspBody merge fail " + localInvalidProtocolBufferMicroException.toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.notifyUI(1000, false, null);
        this.jdField_a_of_type_Boolean = true;
        return this;
      }
    }
    List localList2;
    if (localList1.rpt_msg_conf_base_info.has())
    {
      localList2 = localList1.rpt_msg_conf_base_info.get();
      this.jdField_a_of_type_JavaUtilList = localList2;
      if (!localList1.rpt_uint64_other_conf_list.has()) {
        break label366;
      }
    }
    label366:
    for (List localList1 = localList1.rpt_uint64_other_conf_list.get();; localList1 = null)
    {
      this.b = localList1;
      if (this.jdField_a_of_type_JavaUtilList != null) {
        break label371;
      }
      if (QLog.isColorLevel()) {
        QLog.e("Q.contacttab.dscs", 2, "baseInfo is null");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.notifyUI(1000, false, null);
      this.jdField_a_of_type_Boolean = true;
      return this;
      localList2 = null;
      break;
    }
    label371:
    this.jdField_a_of_type_Boolean = false;
    return this;
  }
  
  public List<cmd0x58a.ConfBaseInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public List<Long> b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.DiscussionHandler.HandleGetDiscussRespCheck
 * JD-Core Version:    0.7.0.1
 */