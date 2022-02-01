package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_bhd_upload_pic$ReqStoryPic
  extends MessageMicro<ReqStoryPic>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField img_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField platform = PBField.initEnum(1);
  public final PBUInt32Field tojpg = PBField.initUInt32(0);
  public final PBBytesField version = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "img_data", "tojpg", "platform", "version" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(1), localByteStringMicro2 }, ReqStoryPic.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_bhd_upload_pic.ReqStoryPic
 * JD-Core Version:    0.7.0.1
 */