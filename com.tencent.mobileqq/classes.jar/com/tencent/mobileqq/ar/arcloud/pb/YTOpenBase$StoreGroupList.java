package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class YTOpenBase$StoreGroupList
  extends MessageMicro<StoreGroupList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "app_id", "group_ids" }, new Object[] { "", "" }, StoreGroupList.class);
  public final PBStringField app_id = PBField.initString("");
  public final PBRepeatField<String> group_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.YTOpenBase.StoreGroupList
 * JD-Core Version:    0.7.0.1
 */