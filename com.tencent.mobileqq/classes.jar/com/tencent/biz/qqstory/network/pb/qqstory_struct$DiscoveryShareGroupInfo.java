package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqstory_struct$DiscoveryShareGroupInfo
  extends MessageMicro<DiscoveryShareGroupInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "group", "video_info" }, new Object[] { null, null }, DiscoveryShareGroupInfo.class);
  public qqstory_struct.ShareGroupInfo group = new qqstory_struct.ShareGroupInfo();
  public final PBRepeatMessageField<qqstory_struct.DiscoveryShareGroupVideoInfo> video_info = PBField.initRepeatMessage(qqstory_struct.DiscoveryShareGroupVideoInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.DiscoveryShareGroupInfo
 * JD-Core Version:    0.7.0.1
 */