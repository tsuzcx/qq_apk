package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_struct$StoryVideoFeature
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field deny_comment = PBField.initUInt32(0);
  public final PBUInt32Field has_like = PBField.initUInt32(0);
  public final PBRepeatMessageField newest_like_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoLikeInfo.class);
  public final PBUInt32Field stranger_view_total_num = PBField.initUInt32(0);
  public final PBUInt32Field total_comment_num = PBField.initUInt32(0);
  public final PBUInt32Field total_like_num = PBField.initUInt32(0);
  public final PBUInt32Field uncheck_like_num = PBField.initUInt32(0);
  public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field viewer_total_num = PBField.initUInt32(0);
  public final PBUInt32Field viewing_total_num = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56, 66, 72, 80 }, new String[] { "vid", "viewer_total_num", "stranger_view_total_num", "has_like", "uncheck_like_num", "total_like_num", "total_comment_num", "newest_like_list", "deny_comment", "viewing_total_num" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, StoryVideoFeature.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoFeature
 * JD-Core Version:    0.7.0.1
 */