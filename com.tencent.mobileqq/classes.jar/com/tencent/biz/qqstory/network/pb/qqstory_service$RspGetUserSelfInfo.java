package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$RspGetUserSelfInfo
  extends MessageMicro<RspGetUserSelfInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field fans_count = PBField.initUInt32(0);
  public final PBBytesField head_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field is_vip = PBField.initUInt32(0);
  public final PBBytesField newest_video_cover = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField newest_video_vid = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field video_count = PBField.initUInt32(0);
  public final PBUInt32Field visit_total_count = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 48, 58, 66, 74 }, new String[] { "result", "is_vip", "fans_count", "union_id", "video_count", "visit_total_count", "newest_video_cover", "newest_video_vid", "head_url" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, RspGetUserSelfInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetUserSelfInfo
 * JD-Core Version:    0.7.0.1
 */