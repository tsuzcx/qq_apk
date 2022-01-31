package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$MsgTabNodePushNotify
  extends MessageMicro<MsgTabNodePushNotify>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_current_seq = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_msglist_current_seq = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_service.MsgTabNodeInfo msg_notify_node_info = new qqstory_service.MsgTabNodeInfo();
  public qqstory_service.MsgTabNodeInfo msglist_head_notify_node_info = new qqstory_service.MsgTabNodeInfo();
  public final PBUInt32Field uint32_animate = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_test_env = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msglist_notify_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_notify_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 48, 58, 64 }, new String[] { "bytes_current_seq", "msg_notify_node_info", "uint32_notify_type", "msglist_head_notify_node_info", "uint32_msglist_notify_type", "uint32_animate", "bytes_msglist_current_seq", "uint32_is_test_env" }, new Object[] { localByteStringMicro1, null, Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0) }, MsgTabNodePushNotify.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodePushNotify
 * JD-Core Version:    0.7.0.1
 */