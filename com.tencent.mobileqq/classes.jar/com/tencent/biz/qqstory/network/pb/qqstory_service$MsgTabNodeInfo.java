package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_service$MsgTabNodeInfo
  extends MessageMicro<MsgTabNodeInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_union_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField link_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field no_update = PBField.initUInt32(0);
  public final PBInt32Field node_position = PBField.initInt32(0);
  public final PBBytesField node_vid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField passthrough = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field recommend_id = PBField.initUInt64(0L);
  public final PBBytesField recommend_name_icon = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBoolField redpoint = PBField.initBool(false);
  public final PBRepeatMessageField<qqstory_service.MsgTabNodeVideoInfo> rpt_msg_video_info_list = PBField.initRepeatMessage(qqstory_service.MsgTabNodeVideoInfo.class);
  public final PBUInt32Field uint32_node_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_cache_seq = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_node_info_time_stamp = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_req_time_stamp = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uid = PBField.initUInt64(0L);
  public final PBBytesField video_cover = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field video_cover_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48, 58, 66, 72, 82, 90, 98, 104, 114, 120, 130, 136, 144, 800 }, new String[] { "uint32_node_type", "uint64_uid", "bytes_union_id", "rpt_msg_video_info_list", "uint64_req_time_stamp", "uint64_node_info_time_stamp", "bytes_title", "bytes_icon_url", "recommend_id", "link_url", "node_vid", "video_cover", "node_position", "recommend_name_icon", "uint64_cache_seq", "passthrough", "redpoint", "video_cover_type", "no_update" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, null, Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3, Long.valueOf(0L), localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, Integer.valueOf(0), localByteStringMicro7, Long.valueOf(0L), localByteStringMicro8, Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0) }, MsgTabNodeInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodeInfo
 * JD-Core Version:    0.7.0.1
 */