package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_struct$ShareGroupBasicInfo
  extends MessageMicro<ShareGroupBasicInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 56, 64, 72 }, new String[] { "shared_group_id", "name", "owner", "header_unionid_list", "allow_stranger_visit_and_post", "background_url", "type", "group_code", "has_disband" }, new Object[] { "", "", "", "", Integer.valueOf(0), "", Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, ShareGroupBasicInfo.class);
  public final PBUInt32Field allow_stranger_visit_and_post = PBField.initUInt32(0);
  public final PBStringField background_url = PBField.initString("");
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBUInt32Field has_disband = PBField.initUInt32(0);
  public final PBRepeatField<String> header_unionid_list = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField name = PBField.initString("");
  public final PBStringField owner = PBField.initString("");
  public final PBStringField shared_group_id = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.ShareGroupBasicInfo
 * JD-Core Version:    0.7.0.1
 */