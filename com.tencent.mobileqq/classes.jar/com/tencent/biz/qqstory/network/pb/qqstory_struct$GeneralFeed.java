package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_struct$GeneralFeed
  extends MessageMicro<GeneralFeed>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field date = PBField.initUInt32(0);
  public final PBBytesField feed_attr = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<qqstory_struct.FeedVideoInfo> feed_video_info_list = PBField.initRepeatMessage(qqstory_struct.FeedVideoInfo.class);
  public final PBUInt32Field hasVideoTag = PBField.initUInt32(0);
  public final PBUInt32Field has_public_video = PBField.initUInt32(0);
  public final PBUInt32Field is_end = PBField.initUInt32(0);
  public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field pull_type = PBField.initUInt32(0);
  public final PBBytesField qim_sync_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field seq = PBField.initUInt32(0);
  public final PBUInt32Field share_to_discover = PBField.initUInt32(0);
  public qqstory_struct.UserInfo user = new qqstory_struct.UserInfo();
  public final PBUInt32Field video_total = PBField.initUInt32(0);
  public final PBRepeatField<ByteStringMicro> ws_schemas = PBField.initRepeat(PBBytesField.__repeatHelper__);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 48, 58, 64, 72, 80, 88, 96, 104, 114, 122 }, new String[] { "user", "date", "feed_attr", "feed_video_info_list", "next_cookie", "seq", "feed_id", "is_end", "pull_type", "video_total", "share_to_discover", "hasVideoTag", "has_public_video", "qim_sync_wording", "ws_schemas" }, new Object[] { null, Integer.valueOf(0), localByteStringMicro1, null, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5 }, GeneralFeed.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.GeneralFeed
 * JD-Core Version:    0.7.0.1
 */