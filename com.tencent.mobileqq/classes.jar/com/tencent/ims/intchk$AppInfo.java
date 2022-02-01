package com.tencent.ims;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class intchk$AppInfo
  extends MessageMicro<AppInfo>
{
  public static final int BYTES_APP_VERSION_FIELD_NUMBER = 3;
  public static final int BYTES_PACKAGE_NAME_FIELD_NUMBER = 2;
  public static final int UINT32_INTCHK_MODULE_VERSION_FIELD_NUMBER = 4;
  public static final int UINT32_NET_TYPE_FIELD_NUMBER = 5;
  public static final int UINT32_PLATFORM_TYPE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_app_version = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_package_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_intchk_module_version = PBField.initUInt32(0);
  public final PBUInt32Field uint32_net_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_platform_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40 }, new String[] { "uint32_platform_type", "bytes_package_name", "bytes_app_version", "uint32_intchk_module_version", "uint32_net_type" }, new Object[] { localInteger, localByteStringMicro1, localByteStringMicro2, localInteger, localInteger }, AppInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ims.intchk.AppInfo
 * JD-Core Version:    0.7.0.1
 */