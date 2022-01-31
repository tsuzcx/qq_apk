package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class bankcode_info$ElemPos
  extends MessageMicro<ElemPos>
{
  public static final int END_OFFSET_FIELD_NUMBER = 2;
  public static final int START_OFFSET_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "start_offset", "end_offset" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, ElemPos.class);
  public final PBUInt32Field end_offset = PBField.initUInt32(0);
  public final PBUInt32Field start_offset = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ims.bankcode_info.ElemPos
 * JD-Core Version:    0.7.0.1
 */