package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class qqstory_struct$StoryVideoTotalInfo
  extends MessageMicro<StoryVideoTotalInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "feature", "basic_info" }, new Object[] { null, null }, StoryVideoTotalInfo.class);
  public qqstory_struct.StoryVideoBasicInfo basic_info = new qqstory_struct.StoryVideoBasicInfo();
  public qqstory_struct.StoryVideoFeature feature = new qqstory_struct.StoryVideoFeature();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoTotalInfo
 * JD-Core Version:    0.7.0.1
 */