package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqstory_service$RspCollectionViewCount
  extends MessageMicro<RspCollectionViewCount>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "collection_list" }, new Object[] { null, null }, RspCollectionViewCount.class);
  public final PBRepeatMessageField<qqstory_struct.DateVideoCollection> collection_list = PBField.initRepeatMessage(qqstory_struct.DateVideoCollection.class);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspCollectionViewCount
 * JD-Core Version:    0.7.0.1
 */