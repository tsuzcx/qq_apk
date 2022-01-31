package com.tencent.im.msg.hummer.resv12;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MarketFaceExtPb$SupportSize
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_width", "uint32_height" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, SupportSize.class);
  public final PBUInt32Field uint32_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_width = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.im.msg.hummer.resv12.MarketFaceExtPb.SupportSize
 * JD-Core Version:    0.7.0.1
 */