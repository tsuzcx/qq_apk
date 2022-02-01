package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class SougouSearch$DeviceV2
  extends MessageMicro<DeviceV2>
{
  public static final int Android = 1;
  public static final int IOS = 0;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "platform" }, new Object[] { Integer.valueOf(0) }, DeviceV2.class);
  public final PBEnumField platform = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.SougouSearch.DeviceV2
 * JD-Core Version:    0.7.0.1
 */