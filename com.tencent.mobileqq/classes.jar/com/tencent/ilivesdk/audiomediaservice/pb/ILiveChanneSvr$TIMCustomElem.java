package com.tencent.ilivesdk.audiomediaservice.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class ILiveChanneSvr$TIMCustomElem
  extends MessageMicro<TIMCustomElem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "data", "desc", "ext", "sound" }, new Object[] { "", "", "", "" }, TIMCustomElem.class);
  public final PBStringField data = PBField.initString("");
  public final PBStringField desc = PBField.initString("");
  public final PBStringField ext = PBField.initString("");
  public final PBStringField sound = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.pb.ILiveChanneSvr.TIMCustomElem
 * JD-Core Version:    0.7.0.1
 */