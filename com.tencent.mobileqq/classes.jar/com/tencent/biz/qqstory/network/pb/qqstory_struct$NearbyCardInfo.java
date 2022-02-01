package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class qqstory_struct$NearbyCardInfo
  extends MessageMicro<NearbyCardInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public qqstory_struct.NormalCardInfo card_info = new qqstory_struct.NormalCardInfo();
  public final PBBytesField distance = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "card_info", "distance" }, new Object[] { null, localByteStringMicro }, NearbyCardInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.NearbyCardInfo
 * JD-Core Version:    0.7.0.1
 */