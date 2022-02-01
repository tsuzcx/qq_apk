package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class YTOpenBase$StoreFeature
  extends MessageMicro<StoreFeature>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 34, 50 }, new String[] { "person_id", "feature", "group_ids", "version" }, new Object[] { "", null, "", "" }, StoreFeature.class);
  public final PBRepeatMessageField<YTOpenBase.FeatureItem> feature = PBField.initRepeatMessage(YTOpenBase.FeatureItem.class);
  public final PBRepeatField<String> group_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField person_id = PBField.initString("");
  public final PBStringField version = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.YTOpenBase.StoreFeature
 * JD-Core Version:    0.7.0.1
 */