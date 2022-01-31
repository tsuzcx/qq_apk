package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_struct$TagInfoBase
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "tag_id", "tag_name", "tag_desc", "tag_type" }, new Object[] { Long.valueOf(0L), "", "", Integer.valueOf(0) }, TagInfoBase.class);
  public final PBStringField tag_desc = PBField.initString("");
  public final PBUInt64Field tag_id = PBField.initUInt64(0L);
  public final PBStringField tag_name = PBField.initString("");
  public final PBUInt32Field tag_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.TagInfoBase
 * JD-Core Version:    0.7.0.1
 */