package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_struct$TagItem
  extends MessageMicro<TagItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "base_info", "join_count", "wording" }, new Object[] { null, Integer.valueOf(0), "" }, TagItem.class);
  public qqstory_struct.TagInfoBase base_info = new qqstory_struct.TagInfoBase();
  public final PBUInt32Field join_count = PBField.initUInt32(0);
  public final PBStringField wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.TagItem
 * JD-Core Version:    0.7.0.1
 */