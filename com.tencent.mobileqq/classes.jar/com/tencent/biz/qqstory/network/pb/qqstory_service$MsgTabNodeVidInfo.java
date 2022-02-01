package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_service$MsgTabNodeVidInfo
  extends MessageMicro<MsgTabNodeVidInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<Integer> recommand_id_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField<ByteStringMicro> vid_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatField<Long> video_index_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "feed_id", "vid_list", "video_index_list", "recommand_id_list" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Integer.valueOf(0) }, MsgTabNodeVidInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodeVidInfo
 * JD-Core Version:    0.7.0.1
 */