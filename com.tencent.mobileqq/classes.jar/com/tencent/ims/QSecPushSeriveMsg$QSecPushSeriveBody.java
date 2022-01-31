package com.tencent.ims;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QSecPushSeriveMsg$QSecPushSeriveBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field canCache = PBField.initUInt32(0);
  public final PBBytesField extraInfo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField packageName = PBField.initString("");
  public final PBUInt32Field platform = PBField.initUInt32(0);
  public final PBUInt32Field pluginCmd = PBField.initUInt32(0);
  public final PBUInt32Field pluginId = PBField.initUInt32(0);
  public final PBUInt32Field pluginVer = PBField.initUInt32(0);
  public final PBUInt32Field qsecJavaVer = PBField.initUInt32(0);
  public final PBUInt32Field qsecNativeVer = PBField.initUInt32(0);
  public final PBUInt32Field ver = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 74, 82 }, new String[] { "ver", "platform", "qsecJavaVer", "qsecNativeVer", "pluginId", "pluginCmd", "pluginVer", "canCache", "extraInfo", "packageName" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, "" }, QSecPushSeriveBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.ims.QSecPushSeriveMsg.QSecPushSeriveBody
 * JD-Core Version:    0.7.0.1
 */