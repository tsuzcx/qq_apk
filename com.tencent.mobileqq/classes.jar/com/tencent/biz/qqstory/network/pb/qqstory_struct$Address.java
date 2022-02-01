package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_struct$Address
  extends MessageMicro<Address>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField building = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField city = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field coordinate = PBField.initUInt32(0);
  public final PBBytesField country = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField district = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_struct.GpsMsg gps = new qqstory_struct.GpsMsg();
  public final PBBytesField province = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField street = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 64, 74, 82 }, new String[] { "street", "province", "city", "country", "building", "coordinate", "gps", "district" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), null, localByteStringMicro6 }, Address.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.Address
 * JD-Core Version:    0.7.0.1
 */