package com.tencent.ims;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class intchk$ReportCheckResultRsp
  extends MessageMicro<ReportCheckResultRsp>
{
  public static final int BYTES_STRIKE_CONFIG_FIELD_NUMBER = 3;
  public static final int UINT32_INTCHK_ID_FIELD_NUMBER = 2;
  public static final int UINT32_NEED_STRIKE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_strike_config = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_intchk_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_strike = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_need_strike", "uint32_intchk_id", "bytes_strike_config" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, ReportCheckResultRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ims.intchk.ReportCheckResultRsp
 * JD-Core Version:    0.7.0.1
 */