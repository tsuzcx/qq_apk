package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_service$MsgTabNodeVideoInfo
  extends MessageMicro<MsgTabNodeVideoInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField bottom_link = PBField.initString("");
  public final PBStringField bottom_wording = PBField.initString("");
  public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field recommand_id = PBField.initUInt32(0);
  public final PBUInt32Field show_bottom = PBField.initUInt32(0);
  public final PBUInt32Field show_text = PBField.initUInt32(0);
  public final PBStringField text_link = PBField.initString("");
  public final PBStringField text_wording = PBField.initString("");
  public final PBUInt32Field uint32_did_read = PBField.initUInt32(0);
  public final PBUInt64Field uint64_video_index = PBField.initUInt64(0L);
  public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_struct.StoryVideoFullInfo video_info = new qqstory_struct.StoryVideoFullInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 56, 66, 74, 80, 90, 98 }, new String[] { "uint64_video_index", "uint32_did_read", "feed_id", "video_info", "vid", "recommand_id", "show_bottom", "bottom_wording", "bottom_link", "show_text", "text_wording", "text_link" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, null, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), "", "" }, MsgTabNodeVideoInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodeVideoInfo
 * JD-Core Version:    0.7.0.1
 */