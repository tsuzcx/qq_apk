package com.tencent.im.oidb.cmd0x6d1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x6d1$DealInviteReqBody
  extends MessageMicro<DealInviteReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint64_group_code", "uint64_uin", "str_id", "uint32_deal_result" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0) }, DealInviteReqBody.class);
  public final PBStringField str_id = PBField.initString("");
  public final PBUInt32Field uint32_deal_result = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.im.oidb.cmd0x6d1.cmd0x6d1.DealInviteReqBody
 * JD-Core Version:    0.7.0.1
 */