package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQProtectUpdate$UpdateQueryBody
  extends MessageMicro<UpdateQueryBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_file_id", "uint32_file_local_version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, UpdateQueryBody.class);
  public final PBUInt32Field uint32_file_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_local_version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ims.QQProtectUpdate.UpdateQueryBody
 * JD-Core Version:    0.7.0.1
 */