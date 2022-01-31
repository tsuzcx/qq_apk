package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_service$RspGetTagInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "result", "tag_info", "music_type", "music_id" }, new Object[] { null, null, Integer.valueOf(0), Long.valueOf(0L) }, RspGetTagInfo.class);
  public final PBUInt64Field music_id = PBField.initUInt64(0L);
  public final PBUInt32Field music_type = PBField.initUInt32(0);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public qqstory_struct.TagInfoBase tag_info = new qqstory_struct.TagInfoBase();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetTagInfo
 * JD-Core Version:    0.7.0.1
 */