package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_struct$BigVColleciton
  extends MessageMicro<BigVColleciton>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field color = PBField.initUInt32(0);
  public final PBBytesField cover = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField desc = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field fans = PBField.initUInt32(0);
  public final PBUInt32Field id = PBField.initUInt32(0);
  public final PBBytesField logo = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_struct.UserInfo user = new qqstory_struct.UserInfo();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 56 }, new String[] { "id", "user", "cover", "logo", "color", "desc", "fans" }, new Object[] { localInteger, null, localByteStringMicro1, localByteStringMicro2, localInteger, localByteStringMicro3, localInteger }, BigVColleciton.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.BigVColleciton
 * JD-Core Version:    0.7.0.1
 */