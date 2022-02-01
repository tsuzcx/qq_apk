package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_struct$CardVideoInfo
  extends MessageMicro<CardVideoInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField label = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field total_comment_num = PBField.initUInt32(0);
  public final PBUInt32Field total_like_num = PBField.initUInt32(0);
  public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<ByteStringMicro> vid_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBBytesField video_cover = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field view_total_num = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 58, 66 }, new String[] { "vid", "video_cover", "label", "view_total_num", "total_like_num", "total_comment_num", "feed_id", "vid_list" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5 }, CardVideoInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.CardVideoInfo
 * JD-Core Version:    0.7.0.1
 */