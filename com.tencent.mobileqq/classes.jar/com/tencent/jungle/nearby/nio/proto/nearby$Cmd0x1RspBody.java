package com.tencent.jungle.nearby.nio.proto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearby$Cmd0x1RspBody
  extends MessageMicro<Cmd0x1RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public nearby.FansInfo FansInfo_fans = new nearby.FansInfo();
  public final PBBoolField bool_follow = PBField.initBool(false);
  public final PBBytesField bytes_aio_grey_tips_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_bars_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_chat_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_common.DataCardConfig bytes_face_score_config = new oidb_common.DataCardConfig();
  public final PBBytesField bytes_feed_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_feed_wording_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_feeds_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_mask_gift_reason = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_mask_msg_reason = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_official_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_qunlist_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public nearby.NearbyJumpInfo nearby_popover_info = new nearby.NearbyJumpInfo();
  public final PBRepeatMessageField<nearby.BarInfo> rpt_BarInfo_bars = PBField.initRepeatMessage(nearby.BarInfo.class);
  public final PBRepeatMessageField<nearby.FeedInfo> rpt_FeedInfo_feeds = PBField.initRepeatMessage(nearby.FeedInfo.class);
  public final PBStringField str_jump_app_result_msg = PBField.initString("");
  public final PBStringField str_jump_app_url = PBField.initString("");
  public final PBStringField str_plus_download_app_msg = PBField.initString("");
  public final PBUInt32Field uint32_bars_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_err_code = PBField.initUInt32(0);
  public final PBUInt32Field uint32_high_score_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_if_mask_gift = PBField.initUInt32(0);
  public final PBUInt32Field uint32_if_mask_msg = PBField.initUInt32(0);
  public final PBUInt32Field uint32_jump_app_open = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro10 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro11 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 56, 66, 74, 82, 90, 96, 104, 114, 120, 130, 138, 146, 152, 162, 168, 178, 186, 194, 202, 210, 218 }, new String[] { "uint32_seq", "uint32_err_code", "bytes_err_msg", "rpt_FeedInfo_feeds", "bytes_feeds_url", "rpt_BarInfo_bars", "uint32_bars_num", "bytes_bars_url", "FansInfo_fans", "bytes_qunlist_url", "bytes_chat_sig", "bool_follow", "uint32_if_mask_msg", "bytes_mask_msg_reason", "uint32_if_mask_gift", "bytes_mask_gift_reason", "bytes_feed_wording", "bytes_feed_wording_title", "uint32_high_score_num", "bytes_face_score_config", "uint32_jump_app_open", "str_jump_app_result_msg", "str_jump_app_url", "str_plus_download_app_msg", "nearby_popover_info", "bytes_official_wording", "bytes_aio_grey_tips_wording" }, new Object[] { localInteger, localInteger, localByteStringMicro1, null, localByteStringMicro2, null, localInteger, localByteStringMicro3, null, localByteStringMicro4, localByteStringMicro5, Boolean.valueOf(false), localInteger, localByteStringMicro6, localInteger, localByteStringMicro7, localByteStringMicro8, localByteStringMicro9, localInteger, null, localInteger, "", "", "", null, localByteStringMicro10, localByteStringMicro11 }, Cmd0x1RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.jungle.nearby.nio.proto.nearby.Cmd0x1RspBody
 * JD-Core Version:    0.7.0.1
 */