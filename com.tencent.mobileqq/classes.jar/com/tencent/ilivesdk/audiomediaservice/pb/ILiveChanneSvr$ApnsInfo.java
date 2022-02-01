package com.tencent.ilivesdk.audiomediaservice.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ILiveChanneSvr$ApnsInfo
  extends MessageMicro<ApnsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "badge_mode", "sound", "image" }, new Object[] { Integer.valueOf(0), "", "" }, ApnsInfo.class);
  public final PBUInt32Field badge_mode = PBField.initUInt32(0);
  public final PBStringField image = PBField.initString("");
  public final PBStringField sound = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.pb.ILiveChanneSvr.ApnsInfo
 * JD-Core Version:    0.7.0.1
 */