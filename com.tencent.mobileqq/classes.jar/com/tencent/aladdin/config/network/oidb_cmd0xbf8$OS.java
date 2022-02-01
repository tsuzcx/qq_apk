package com.tencent.aladdin.config.network;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_cmd0xbf8$OS
  extends MessageMicro<OS>
{
  public static final int ANDROID = 2;
  public static final int IOS = 1;
  public static final int OTHER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "type", "version", "sdk", "kernel" }, new Object[] { Integer.valueOf(1), "", "", "" }, OS.class);
  public final PBStringField kernel = PBField.initString("");
  public final PBStringField sdk = PBField.initString("");
  public final PBEnumField type = PBField.initEnum(1);
  public final PBStringField version = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aladdin.config.network.oidb_cmd0xbf8.OS
 * JD-Core Version:    0.7.0.1
 */