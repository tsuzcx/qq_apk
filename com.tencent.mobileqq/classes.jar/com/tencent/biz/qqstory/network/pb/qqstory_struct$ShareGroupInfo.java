package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class qqstory_struct$ShareGroupInfo
  extends MessageMicro<ShareGroupInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "basic_info", "ext_info" }, new Object[] { null, null }, ShareGroupInfo.class);
  public qqstory_struct.ShareGroupBasicInfo basic_info = new qqstory_struct.ShareGroupBasicInfo();
  public qqstory_struct.ShareGroupExtInfo ext_info = new qqstory_struct.ShareGroupExtInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.ShareGroupInfo
 * JD-Core Version:    0.7.0.1
 */