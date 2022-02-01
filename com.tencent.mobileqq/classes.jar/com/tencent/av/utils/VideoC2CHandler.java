package com.tencent.av.utils;

import android.os.Bundle;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.TransMsgContext;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import msf.msgsvc.msg_svc.RoutingHead;
import msf.msgsvc.msg_svc.Trans0x211;
import tencent.im.msg.im_msg_head.InstCtrl;
import tencent.im.msg.im_msg_head.InstInfo;
import tencent.im.s2c.msgtype0x211.submsgtype0xb.C2CType0x211_SubC2CType0xb.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0xb.C2CType0x211_SubC2CType0xb.MsgBody.MsgHeader;

public class VideoC2CHandler
  extends BusinessHandler
{
  static String a = "VideoC2CHandler";
  public String b = null;
  public long c = 0L;
  public C2CType0x211_SubC2CType0xb.MsgBody.MsgHeader d = new C2CType0x211_SubC2CType0xb.MsgBody.MsgHeader();
  private QQAppInterface e;
  
  public VideoC2CHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.e = paramQQAppInterface;
  }
  
  private msg_svc.PbSendMsgReq a(int paramInt1, String paramString, TransMsgContext paramTransMsgContext, long paramLong1, int paramInt2, long paramLong2)
  {
    return MessageProtoCodec.a(this.e, paramInt1, paramString, paramTransMsgContext, paramLong1, paramInt2);
  }
  
  private void a(C2CType0x211_SubC2CType0xb.MsgBody.MsgHeader paramMsgHeader)
  {
    String str = this.b;
    if (str != null)
    {
      long l = CharacterUtil.b(str);
      paramMsgHeader.uint64_to_uin.set(l);
    }
    if (this.c != 0L) {
      paramMsgHeader.uint64_room_id.set(this.c);
    }
    paramMsgHeader.setHasFlag(true);
  }
  
  public ToServiceMsg a(long paramLong1, int paramInt, C2CType0x211_SubC2CType0xb.MsgBody paramMsgBody, long paramLong2)
  {
    paramMsgBody = paramMsgBody.toByteArray();
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("send0x211C2CQavMsg QavMsgRecord:");
      localStringBuilder.append(paramLong2);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return a(paramLong1, this.b, 529, 11, paramInt, paramMsgBody, paramLong2);
  }
  
  public ToServiceMsg a(long paramLong1, String paramString, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("MessageSvc.PbSendMsg");
    localToServiceMsg.extraData.putInt("SEND_MSG_CMD_MSG_TYPE", 1);
    localToServiceMsg.extraData.putInt("ROUNTING_TYPE", 13);
    localToServiceMsg.extraData.putBoolean("ISFROM_QAV", true);
    localToServiceMsg.addAttribute("cookie", Long.valueOf(paramLong1));
    paramLong1 = FileManagerUtil.g();
    long l = FileManagerUtil.f();
    Object localObject = new TransMsgContext();
    ((TransMsgContext)localObject).a = paramInt2;
    ((TransMsgContext)localObject).b = paramArrayOfByte;
    paramString = a(13, paramString, (TransMsgContext)localObject, l, MessageUtils.b(paramLong1), paramLong2);
    paramArrayOfByte = new im_msg_head.InstInfo();
    paramArrayOfByte.uint32_apppid.set(AppSetting.d());
    paramArrayOfByte.uint32_instid.set(AppSetting.d());
    paramArrayOfByte.setHasFlag(true);
    paramString.routing_head.trans_0x211.inst_ctrl.rpt_msg_send_to_inst.add(paramArrayOfByte);
    localObject = new im_msg_head.InstInfo();
    paramArrayOfByte.uint32_apppid.set(AppSetting.d());
    paramArrayOfByte.uint32_instid.set(AppSetting.d());
    ((im_msg_head.InstInfo)localObject).setHasFlag(true);
    paramString.routing_head.trans_0x211.inst_ctrl.msg_from_inst = ((im_msg_head.InstInfo)localObject);
    paramString.routing_head.trans_0x211.inst_ctrl.setHasFlag(true);
    localToServiceMsg.putWupBuffer(paramString.toByteArray());
    sendPbReq(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public void a()
  {
    C2CType0x211_SubC2CType0xb.MsgBody localMsgBody = new C2CType0x211_SubC2CType0xb.MsgBody();
    a(this.d);
    this.d.uint32_body_type.set(102);
    this.d.uint32_session_type.set(0);
    localMsgBody.msg_msg_header.set(this.d);
    localMsgBody.setHasFlag(true);
    a(1L, 102, localMsgBody, 1L);
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("MessageSvc.PbSendMsg");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.VideoC2CHandler
 * JD-Core Version:    0.7.0.1
 */