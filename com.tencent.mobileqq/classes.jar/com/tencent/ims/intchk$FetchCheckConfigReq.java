package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class intchk$FetchCheckConfigReq
  extends MessageMicro
{
  public static final int UINT32_RESERVED_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_reserved" }, new Object[] { Integer.valueOf(0) }, FetchCheckConfigReq.class);
  public final PBUInt32Field uint32_reserved = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.ims.intchk.FetchCheckConfigReq
 * JD-Core Version:    0.7.0.1
 */