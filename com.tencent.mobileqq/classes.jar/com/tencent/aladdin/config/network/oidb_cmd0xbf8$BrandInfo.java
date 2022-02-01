package com.tencent.aladdin.config.network;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_cmd0xbf8$BrandInfo
  extends MessageMicro<BrandInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "brand", "model", "manufacturer" }, new Object[] { "", "", "" }, BrandInfo.class);
  public final PBStringField brand = PBField.initString("");
  public final PBStringField manufacturer = PBField.initString("");
  public final PBStringField model = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aladdin.config.network.oidb_cmd0xbf8.BrandInfo
 * JD-Core Version:    0.7.0.1
 */