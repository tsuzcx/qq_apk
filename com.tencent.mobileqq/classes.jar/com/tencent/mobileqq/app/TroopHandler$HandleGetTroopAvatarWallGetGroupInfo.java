package com.tencent.mobileqq.app;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspGroupInfo;

class TroopHandler$HandleGetTroopAvatarWallGetGroupInfo
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private oidb_0x88d.GroupInfo jdField_a_of_type_TencentImOidbCmd0x88dOidb_0x88d$GroupInfo;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public TroopHandler$HandleGetTroopAvatarWallGetGroupInfo(TroopHandler paramTroopHandler, String paramString, long paramLong, int paramInt, byte... paramVarArgs)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ArrayOfByte = paramVarArgs;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public HandleGetTroopAvatarWallGetGroupInfo a()
  {
    oidb_0x88d.RspBody localRspBody = new oidb_0x88d.RspBody();
    localRspBody.mergeFrom(this.jdField_a_of_type_ArrayOfByte);
    if ((this.jdField_a_of_type_Int != 0) && (localRspBody.str_errorinfo.has())) {
      this.jdField_a_of_type_JavaLangString = String.valueOf(localRspBody.str_errorinfo.get().toByteArray());
    }
    this.jdField_a_of_type_TencentImOidbCmd0x88dOidb_0x88d$GroupInfo = null;
    List localList = localRspBody.stzrspgroupinfo.get();
    int i;
    int j;
    label74:
    oidb_0x88d.RspGroupInfo localRspGroupInfo;
    if (localList == null)
    {
      i = 0;
      j = 0;
      if ((this.jdField_a_of_type_TencentImOidbCmd0x88dOidb_0x88d$GroupInfo != null) || (j >= i)) {
        break label186;
      }
      localRspGroupInfo = (oidb_0x88d.RspGroupInfo)localList.get(j);
      if ((localRspGroupInfo != null) && (localRspGroupInfo.uint64_group_code.get() == this.jdField_a_of_type_Long)) {
        break label138;
      }
    }
    for (;;)
    {
      j += 1;
      break label74;
      i = localList.size();
      break;
      label138:
      this.jdField_a_of_type_Int = localRspGroupInfo.uint32_result.get();
      if ((this.jdField_a_of_type_Int == 0) && (localRspGroupInfo.stgroupinfo.has())) {
        this.jdField_a_of_type_TencentImOidbCmd0x88dOidb_0x88d$GroupInfo = ((oidb_0x88d.GroupInfo)localRspGroupInfo.stgroupinfo.get());
      }
    }
    label186:
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler", 2, "oidb_0x88d_7.RspBody: {\n" + OidbWrapper.proto2String(localRspBody) + "}");
    }
    return this;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public oidb_0x88d.GroupInfo a()
  {
    return this.jdField_a_of_type_TencentImOidbCmd0x88dOidb_0x88d$GroupInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopHandler.HandleGetTroopAvatarWallGetGroupInfo
 * JD-Core Version:    0.7.0.1
 */