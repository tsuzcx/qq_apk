package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class qqstory_struct$QimVideoInfo
  extends MessageMicro<QimVideoInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField qim_feedID = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField qim_unionid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField qim_vid = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "qim_vid", "qim_unionid", "qim_feedID" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, QimVideoInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.QimVideoInfo
 * JD-Core Version:    0.7.0.1
 */