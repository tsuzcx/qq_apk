package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_struct$GatherCardInfo
  extends MessageMicro<GatherCardInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field join_num = PBField.initUInt32(0);
  public final PBUInt32Field rsp_type = PBField.initUInt32(0);
  public final PBBytesField rsp_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField topic_cover = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field topic_id = PBField.initUInt64(0L);
  public final PBBytesField topic_label = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField topic_name = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 58 }, new String[] { "topic_id", "topic_name", "topic_cover", "topic_label", "join_num", "rsp_type", "rsp_url" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4 }, GatherCardInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.GatherCardInfo
 * JD-Core Version:    0.7.0.1
 */