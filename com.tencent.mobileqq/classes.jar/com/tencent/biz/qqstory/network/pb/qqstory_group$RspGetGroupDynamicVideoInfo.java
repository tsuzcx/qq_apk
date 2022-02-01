package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqstory_group$RspGetGroupDynamicVideoInfo
  extends MessageMicro<RspGetGroupDynamicVideoInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 42 }, new String[] { "result", "info_list" }, new Object[] { null, null }, RspGetGroupDynamicVideoInfo.class);
  public final PBRepeatMessageField<qqstory_group.GroupDynamicVideoItem> info_list = PBField.initRepeatMessage(qqstory_group.GroupDynamicVideoItem.class);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_group.RspGetGroupDynamicVideoInfo
 * JD-Core Version:    0.7.0.1
 */