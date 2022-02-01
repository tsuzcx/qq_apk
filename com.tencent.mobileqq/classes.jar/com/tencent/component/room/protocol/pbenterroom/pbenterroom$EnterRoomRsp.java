package com.tencent.component.room.protocol.pbenterroom;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class pbenterroom$EnterRoomRsp
  extends MessageMicro<EnterRoomRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public pbenterroom.UserInfo anchor_info = new pbenterroom.UserInfo();
  public pbenterroom.AnchorAvInfo av_info = new pbenterroom.AnchorAvInfo();
  public final PBBytesField buff_login_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField buz_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field buz_time = PBField.initUInt32(0);
  public pbenterroom.CatchDollVideoInfo catch_doll_video_info = new pbenterroom.CatchDollVideoInfo();
  public final PBStringField close_jump_url = PBField.initString("");
  public final PBUInt32Field close_media = PBField.initUInt32(0);
  public pbenterroom.CmdInfo cmd_info = new pbenterroom.CmdInfo();
  public final PBStringField doll_info_url = PBField.initString("");
  public final PBBoolField enable_rank_list = PBField.initBool(false);
  public final PBStringField endpage_jump_url = PBField.initString("");
  public final PBStringField err_msg = PBField.initString("");
  public final PBBytesField ext_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<String> h5_url = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField<String> hls_url = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt32Field jump_type = PBField.initUInt32(0);
  public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField media_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public pbenterroom.ProgramInfo program_info = new pbenterroom.ProgramInfo();
  public pbenterroom.RecordInfo record_info = new pbenterroom.RecordInfo();
  public final PBUInt32Field result = PBField.initUInt32(0);
  public pbenterroom.RoomInfo room_info = new pbenterroom.RoomInfo();
  public final PBRepeatField<String> rtmp_url = PBField.initRepeat(PBStringField.__repeatHelper__);
  public pbenterroom.OpenSkdInfo sdk_info = new pbenterroom.OpenSkdInfo();
  public pbenterroom.UserInfo self_info = new pbenterroom.UserInfo();
  public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field st_type = PBField.initUInt32(0);
  public final PBBytesField token = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field use_url = PBField.initUInt32(0);
  public pbenterroom.VideoInfo video_info = new pbenterroom.VideoInfo();
  public pbenterroom.VoiceInfo voice_info = new pbenterroom.VoiceInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74, 80, 90, 98, 106, 114, 120, 130, 138, 146, 154, 162, 170, 178, 186, 194, 200, 208, 218, 226, 232, 242, 248, 282 }, new String[] { "result", "err_msg", "room_info", "anchor_info", "voice_info", "video_info", "sig", "cmd_info", "self_info", "st_type", "buff_login_key", "media_data", "record_info", "sdk_info", "jump_type", "jump_url", "rtmp_url", "hls_url", "h5_url", "ext_info", "av_info", "catch_doll_video_info", "doll_info_url", "token", "close_media", "use_url", "close_jump_url", "buz_data", "buz_time", "endpage_jump_url", "enable_rank_list", "program_info" }, new Object[] { Integer.valueOf(0), "", null, null, null, null, localByteStringMicro1, null, null, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, null, null, Integer.valueOf(0), localByteStringMicro4, "", "", "", localByteStringMicro5, null, null, "", localByteStringMicro6, Integer.valueOf(0), Integer.valueOf(0), "", localByteStringMicro7, Integer.valueOf(0), "", Boolean.valueOf(false), null }, EnterRoomRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.room.protocol.pbenterroom.pbenterroom.EnterRoomRsp
 * JD-Core Version:    0.7.0.1
 */