package com.tencent.ims;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SafeReport$LogItem
  extends MessageMicro<LogItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_rpt_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_rpt_id = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_rpt_id", "bytes_rpt_data" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, LogItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ims.SafeReport.LogItem
 * JD-Core Version:    0.7.0.1
 */