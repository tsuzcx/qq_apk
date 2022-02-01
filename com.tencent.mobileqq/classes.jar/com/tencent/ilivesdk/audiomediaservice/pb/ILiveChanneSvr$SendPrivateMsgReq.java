package com.tencent.ilivesdk.audiomediaservice.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ILiveChanneSvr$SendPrivateMsgReq
  extends MessageMicro<SendPrivateMsgReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 58 }, new String[] { "msg_head", "msg_body", "admin_account", "sub_type", "msg_sync_option", "account_type", "sync_ext" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, SendPrivateMsgReq.class);
  public final PBUInt32Field account_type = PBField.initUInt32(0);
  public final PBEnumField admin_account = PBField.initEnum(0);
  public ILiveChanneSvr.MsgBody msg_body = new ILiveChanneSvr.MsgBody();
  public ILiveChanneSvr.MsgHead msg_head = new ILiveChanneSvr.MsgHead();
  public final PBUInt32Field msg_sync_option = PBField.initUInt32(0);
  public final PBEnumField sub_type = PBField.initEnum(0);
  public ILiveChanneSvr.SyncExt sync_ext = new ILiveChanneSvr.SyncExt();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.pb.ILiveChanneSvr.SendPrivateMsgReq
 * JD-Core Version:    0.7.0.1
 */