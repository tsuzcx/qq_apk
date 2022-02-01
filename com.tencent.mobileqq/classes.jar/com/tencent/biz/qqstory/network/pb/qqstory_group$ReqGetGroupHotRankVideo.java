package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_group$ReqGetGroupHotRankVideo
  extends MessageMicro<ReqGetGroupHotRankVideo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field seq = PBField.initUInt64(0L);
  public final PBUInt32Field size = PBField.initUInt32(0);
  public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "union_id", "start_cookie", "size", "seq" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Long.valueOf(0L) }, ReqGetGroupHotRankVideo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_group.ReqGetGroupHotRankVideo
 * JD-Core Version:    0.7.0.1
 */