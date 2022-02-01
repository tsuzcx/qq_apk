package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_struct$ShareGroupFeed
  extends MessageMicro<ShareGroupFeed>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field date = PBField.initUInt32(0);
  public final PBBytesField des = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_struct.ShareGroupInfo info = new qqstory_struct.ShareGroupInfo();
  public final PBUInt32Field is_end = PBField.initUInt32(0);
  public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field pull_type = PBField.initUInt32(0);
  public final PBUInt32Field seq = PBField.initUInt32(0);
  public final PBRepeatMessageField<qqstory_struct.UserInfo> today_new_member = PBField.initRepeatMessage(qqstory_struct.UserInfo.class);
  public final PBRepeatMessageField<qqstory_struct.ShareGroupVideoInfo> video_list = PBField.initRepeatMessage(qqstory_struct.ShareGroupVideoInfo.class);
  public final PBUInt32Field video_total = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 26, 34, 42, 48, 56, 64, 74, 96, 106 }, new String[] { "date", "info", "video_list", "next_cookie", "is_end", "seq", "video_total", "des", "pull_type", "today_new_member" }, new Object[] { Integer.valueOf(0), null, null, localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), null }, ShareGroupFeed.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.ShareGroupFeed
 * JD-Core Version:    0.7.0.1
 */