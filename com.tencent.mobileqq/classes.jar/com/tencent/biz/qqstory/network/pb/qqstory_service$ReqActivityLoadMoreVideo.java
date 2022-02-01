package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$ReqActivityLoadMoreVideo
  extends MessageMicro<ReqActivityLoadMoreVideo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "req_list", "fetch_num" }, new Object[] { null, Integer.valueOf(0) }, ReqActivityLoadMoreVideo.class);
  public final PBUInt32Field fetch_num = PBField.initUInt32(0);
  public final PBRepeatMessageField<qqstory_struct.LoadMoreReqNode> req_list = PBField.initRepeatMessage(qqstory_struct.LoadMoreReqNode.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqActivityLoadMoreVideo
 * JD-Core Version:    0.7.0.1
 */