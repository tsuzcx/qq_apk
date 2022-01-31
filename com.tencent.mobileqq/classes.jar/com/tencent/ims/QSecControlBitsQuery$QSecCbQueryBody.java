package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QSecControlBitsQuery$QSecCbQueryBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "u32_cfg_id", "u32_qsec_ver" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, QSecCbQueryBody.class);
  public final PBUInt32Field u32_cfg_id = PBField.initUInt32(0);
  public final PBUInt32Field u32_qsec_ver = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ims.QSecControlBitsQuery.QSecCbQueryBody
 * JD-Core Version:    0.7.0.1
 */