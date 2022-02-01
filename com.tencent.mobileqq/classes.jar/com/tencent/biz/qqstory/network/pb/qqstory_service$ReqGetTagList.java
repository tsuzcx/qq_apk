package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_service$ReqGetTagList
  extends MessageMicro<ReqGetTagList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "start_cookie", "size", "music_type", "music_id" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, ReqGetTagList.class);
  public final PBUInt64Field music_id = PBField.initUInt64(0L);
  public final PBUInt32Field music_type = PBField.initUInt32(0);
  public final PBUInt32Field size = PBField.initUInt32(0);
  public final PBStringField start_cookie = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetTagList
 * JD-Core Version:    0.7.0.1
 */