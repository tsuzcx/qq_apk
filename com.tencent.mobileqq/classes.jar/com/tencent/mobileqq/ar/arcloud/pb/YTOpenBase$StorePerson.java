package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class YTOpenBase$StorePerson
  extends MessageMicro<StorePerson>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "person_id", "person_name", "face_ids", "group_ids", "tag" }, new Object[] { "", "", "", "", "" }, StorePerson.class);
  public final PBRepeatField<String> face_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField<String> group_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField person_id = PBField.initString("");
  public final PBStringField person_name = PBField.initString("");
  public final PBStringField tag = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.YTOpenBase.StorePerson
 * JD-Core Version:    0.7.0.1
 */