package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class YTOpenBase$StoreGroup
  extends MessageMicro<StoreGroup>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "group_id", "person_ids", "tag" }, new Object[] { "", "", "" }, StoreGroup.class);
  public final PBStringField group_id = PBField.initString("");
  public final PBRepeatField<String> person_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField tag = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.YTOpenBase.StoreGroup
 * JD-Core Version:    0.7.0.1
 */