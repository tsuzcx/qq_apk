package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqstory_service$RspDiscoveryShareGroupInfoList
  extends MessageMicro<RspDiscoveryShareGroupInfoList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "share_group_info_list" }, new Object[] { null, null }, RspDiscoveryShareGroupInfoList.class);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public final PBRepeatMessageField<qqstory_struct.DiscoveryShareGroupInfo> share_group_info_list = PBField.initRepeatMessage(qqstory_struct.DiscoveryShareGroupInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspDiscoveryShareGroupInfoList
 * JD-Core Version:    0.7.0.1
 */