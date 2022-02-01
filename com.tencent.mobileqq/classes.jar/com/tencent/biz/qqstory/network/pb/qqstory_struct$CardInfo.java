package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class qqstory_struct$CardInfo
  extends MessageMicro<CardInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField card_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField card_type = PBField.initEnum(1);
  public qqstory_struct.GatherCardInfo gather_card = new qqstory_struct.GatherCardInfo();
  public qqstory_struct.NearbyCardInfo nearby_card = new qqstory_struct.NearbyCardInfo();
  public qqstory_struct.NormalCardInfo normal_card = new qqstory_struct.NormalCardInfo();
  public qqstory_struct.OperationCardInfo operation_card = new qqstory_struct.OperationCardInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50 }, new String[] { "card_id", "card_type", "normal_card", "nearby_card", "operation_card", "gather_card" }, new Object[] { localByteStringMicro, Integer.valueOf(1), null, null, null, null }, CardInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.CardInfo
 * JD-Core Version:    0.7.0.1
 */