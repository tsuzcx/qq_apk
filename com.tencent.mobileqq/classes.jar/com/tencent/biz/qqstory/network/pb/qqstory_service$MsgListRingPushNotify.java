package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$MsgListRingPushNotify
  extends MessageMicro<MsgListRingPushNotify>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_msglist_current_seq = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_service.MsgTabNodeInfo msglist_head_notify_node_info = new qqstory_service.MsgTabNodeInfo();
  public final PBUInt32Field uint32_is_test_env = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msglist_notify_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "msglist_head_notify_node_info", "uint32_msglist_notify_type", "bytes_msglist_current_seq", "uint32_is_test_env" }, new Object[] { null, Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, MsgListRingPushNotify.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.MsgListRingPushNotify
 * JD-Core Version:    0.7.0.1
 */