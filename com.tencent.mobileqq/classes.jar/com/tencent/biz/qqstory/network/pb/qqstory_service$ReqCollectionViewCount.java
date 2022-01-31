package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqstory_service$ReqCollectionViewCount
  extends MessageMicro<ReqCollectionViewCount>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "collection_id" }, new Object[] { null }, ReqCollectionViewCount.class);
  public final PBRepeatMessageField<qqstory_struct.DateVideoCollectionID> collection_id = PBField.initRepeatMessage(qqstory_struct.DateVideoCollectionID.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqCollectionViewCount
 * JD-Core Version:    0.7.0.1
 */