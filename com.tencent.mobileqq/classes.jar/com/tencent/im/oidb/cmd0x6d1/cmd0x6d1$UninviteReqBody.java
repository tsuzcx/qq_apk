package com.tencent.im.oidb.cmd0x6d1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x6d1$UninviteReqBody
  extends MessageMicro<UninviteReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_id = PBField.initString("");
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_group_code", "uint64_uin", "str_id" }, new Object[] { localLong, localLong, "" }, UninviteReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.im.oidb.cmd0x6d1.cmd0x6d1.UninviteReqBody
 * JD-Core Version:    0.7.0.1
 */