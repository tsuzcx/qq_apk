package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_group$RspGetGroupHotRankVideo
  extends MessageMicro<RspGetGroupHotRankVideo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field is_end = PBField.initUInt32(0);
  public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public final PBUInt64Field seq = PBField.initUInt64(0L);
  public final PBUInt32Field total = PBField.initUInt32(0);
  public final PBRepeatMessageField<qqstory_group.HotVideoCard> video_card_list = PBField.initRepeatMessage(qqstory_group.HotVideoCard.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 48 }, new String[] { "result", "video_card_list", "is_end", "next_cookie", "seq", "total" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0) }, RspGetGroupHotRankVideo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_group.RspGetGroupHotRankVideo
 * JD-Core Version:    0.7.0.1
 */