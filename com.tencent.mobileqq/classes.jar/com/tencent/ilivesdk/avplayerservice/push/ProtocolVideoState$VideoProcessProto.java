package com.tencent.ilivesdk.avplayerservice.push;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ProtocolVideoState$VideoProcessProto
  extends MessageMicro<VideoProcessProto>
{
  public static final int MSGGETROOMVIDEOINFOREQ_FIELD_NUMBER = 4;
  public static final int MSGGETROOMVIDEOINFORES_FIELD_NUMBER = 5;
  public static final int MSGNOTIFYREMOVEVIDEOBYVIDEOSVRREQ_FIELD_NUMBER = 10;
  public static final int MSGNOTIFYREMOVEVIDEOBYVIDEOSVRRESP_FIELD_NUMBER = 11;
  public static final int MSGNOTIFYVIDEOARRIVEBYVIDEOSVRREQ_FIELD_NUMBER = 8;
  public static final int MSGNOTIFYVIDEOARRIVEBYVIDEOSVRRESP_FIELD_NUMBER = 9;
  public static final int MSGNOTIFYVIDEOSVRREMOVEVIDEOREQ_FIELD_NUMBER = 12;
  public static final int MSGNOTIFYVIDEOSVRREMOVEVIDEORESP_FIELD_NUMBER = 13;
  public static final int MSGPUSHONVIDEOREQ_FIELD_NUMBER = 2;
  public static final int MSGPUSHONVIDEORES_FIELD_NUMBER = 3;
  public static final int MSGSETVIDEOSWITCHREQ_FIELD_NUMBER = 6;
  public static final int MSGSETVIDEOSWITCHRESP_FIELD_NUMBER = 7;
  public static final int SDK_TYPE_FIELD_NUMBER = 14;
  public static final int SUBCMD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 112 }, new String[] { "SubCmd", "MsgPushOnVideoReq", "MsgPushOnVideoRes", "MsgGetRoomVideoInfoReq", "MsgGetRoomVideoInfoRes", "MsgSetVideoSwitchReq", "MsgSetVideoSwitchResp", "MsgNotifyVideoArriveByVideoSvrReq", "MsgNotifyVideoArriveByVideoSvrResp", "MsgNotifyRemoveVideoByVideoSvrReq", "MsgNotifyRemoveVideoByVideoSvrResp", "MsgNotifyVideoSvrRemoveVideoReq", "MsgNotifyVideoSvrRemoveVideoResp", "sdk_type" }, new Object[] { Integer.valueOf(0), null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(0) }, VideoProcessProto.class);
  public ProtocolVideoState.GetRoomVideoInfoReq MsgGetRoomVideoInfoReq = new ProtocolVideoState.GetRoomVideoInfoReq();
  public ProtocolVideoState.GetRoomVideoInfoRes MsgGetRoomVideoInfoRes = new ProtocolVideoState.GetRoomVideoInfoRes();
  public ProtocolVideoState.NotifyRemoveVideoByVideoSvrReq MsgNotifyRemoveVideoByVideoSvrReq = new ProtocolVideoState.NotifyRemoveVideoByVideoSvrReq();
  public ProtocolVideoState.NotifyRemoveVideoByVideoSvrResp MsgNotifyRemoveVideoByVideoSvrResp = new ProtocolVideoState.NotifyRemoveVideoByVideoSvrResp();
  public ProtocolVideoState.NotifyVideoArriveByVideoSvrReq MsgNotifyVideoArriveByVideoSvrReq = new ProtocolVideoState.NotifyVideoArriveByVideoSvrReq();
  public ProtocolVideoState.NotifyVideoArriveByVideoSvrResp MsgNotifyVideoArriveByVideoSvrResp = new ProtocolVideoState.NotifyVideoArriveByVideoSvrResp();
  public ProtocolVideoState.NotifyVideoSvrRemoveVideoReq MsgNotifyVideoSvrRemoveVideoReq = new ProtocolVideoState.NotifyVideoSvrRemoveVideoReq();
  public ProtocolVideoState.NotifyVideoSvrRemoveVideoResp MsgNotifyVideoSvrRemoveVideoResp = new ProtocolVideoState.NotifyVideoSvrRemoveVideoResp();
  public ProtocolVideoState.PushOnVideoReq MsgPushOnVideoReq = new ProtocolVideoState.PushOnVideoReq();
  public ProtocolVideoState.PushOnVideoRes MsgPushOnVideoRes = new ProtocolVideoState.PushOnVideoRes();
  public ProtocolVideoState.SetVideoSwitchReq MsgSetVideoSwitchReq = new ProtocolVideoState.SetVideoSwitchReq();
  public ProtocolVideoState.SetVideoSwitchResp MsgSetVideoSwitchResp = new ProtocolVideoState.SetVideoSwitchResp();
  public final PBUInt32Field SubCmd = PBField.initUInt32(0);
  public final PBUInt32Field sdk_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.push.ProtocolVideoState.VideoProcessProto
 * JD-Core Version:    0.7.0.1
 */