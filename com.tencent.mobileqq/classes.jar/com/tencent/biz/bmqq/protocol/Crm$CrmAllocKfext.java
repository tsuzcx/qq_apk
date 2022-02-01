package com.tencent.biz.bmqq.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Crm$CrmAllocKfext
  extends MessageMicro<CrmAllocKfext>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField crm_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field crm_msg_flag = PBField.initUInt32(0);
  public final PBInt32Field int32_flag = PBField.initInt32(0);
  public final PBStringField str_add_tips = PBField.initString("");
  public final PBUInt32Field uint32_track_right = PBField.initUInt32(0);
  public final PBUInt64Field uint64_alloc_from_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_alloc_to_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48, 58 }, new String[] { "int32_flag", "crm_msg_flag", "crm_msg", "uint64_alloc_from_uin", "uint64_alloc_to_uin", "uint32_track_right", "str_add_tips" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), "" }, CrmAllocKfext.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.bmqq.protocol.Crm.CrmAllocKfext
 * JD-Core Version:    0.7.0.1
 */