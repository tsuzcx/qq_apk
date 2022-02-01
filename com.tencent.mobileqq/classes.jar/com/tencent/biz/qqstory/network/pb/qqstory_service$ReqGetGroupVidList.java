package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class qqstory_service$ReqGetGroupVidList
  extends MessageMicro<ReqGetGroupVidList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "union_id", "pull_type" }, new Object[] { "", Integer.valueOf(1) }, ReqGetGroupVidList.class);
  public final PBEnumField pull_type = PBField.initEnum(1);
  public final PBStringField union_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetGroupVidList
 * JD-Core Version:    0.7.0.1
 */