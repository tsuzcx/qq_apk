package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$RspGetHotTopicInfo
  extends MessageMicro<RspGetHotTopicInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field bkg_color = PBField.initUInt32(0);
  public final PBBytesField cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField guide_word = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field join_count = PBField.initUInt32(0);
  public final PBBytesField pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public final PBBytesField subject = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField topic_label = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 48, 58, 66 }, new String[] { "result", "pic_url", "subject", "join_count", "guide_word", "bkg_color", "topic_label", "cover_url" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5 }, RspGetHotTopicInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetHotTopicInfo
 * JD-Core Version:    0.7.0.1
 */