package com.tencent.mobileqq.app;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.TransMsgContext;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import java.util.TimerTask;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import msf.msgsvc.msg_svc.RoutingHead;
import msf.msgsvc.msg_svc.Trans0x211;
import tencent.im.msg.im_msg_head.InstCtrl;
import tencent.im.msg.im_msg_head.InstInfo;
import tencent.im.s2c.msgtype0x211.submsgtype0x9.C2CType0x211_SubC2CType0x9.MsgBody;

public class PrinterStatusHandler
  extends BusinessHandler
{
  private boolean a = false;
  private Timer b = null;
  private int c = 0;
  private QQAppInterface d;
  private MessageObserver e = new PrinterStatusHandler.3(this);
  private RegisterProxySvcPackObserver f = new PrinterStatusHandler.4(this);
  
  public PrinterStatusHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.d = paramQQAppInterface;
    this.d.addObserver(this.e);
    this.d.addObserver(this.f);
    b();
  }
  
  private ToServiceMsg a(boolean paramBoolean, long paramLong1, String paramString, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("MessageSvc.PbSendMsg");
    localToServiceMsg.extraData.putInt("SEND_MSG_CMD_MSG_TYPE", 1);
    localToServiceMsg.extraData.putInt("ROUNTING_TYPE", 13);
    localToServiceMsg.extraData.putBoolean("ISFROM_DATALINE", true);
    localToServiceMsg.extraData.putInt("DATALINE_CMD", paramInt3);
    localToServiceMsg.addAttribute("cookie", Long.valueOf(paramLong1));
    localToServiceMsg.addAttribute("sendFromNative", Boolean.valueOf(paramBoolean));
    localToServiceMsg.extraData.putInt("DATALINE_TRYINDEX", 0);
    paramLong1 = FileManagerUtil.g();
    paramLong2 = FileManagerUtil.f();
    TransMsgContext localTransMsgContext = new TransMsgContext();
    localTransMsgContext.a = paramInt2;
    localTransMsgContext.b = paramArrayOfByte;
    paramString = MessageProtoCodec.a(this.d, 13, paramString, localTransMsgContext, paramLong2, MessageUtils.b(paramLong1));
    paramArrayOfByte = new im_msg_head.InstInfo();
    paramArrayOfByte.uint32_apppid.set(1);
    paramArrayOfByte.uint32_instid.set(0);
    paramArrayOfByte.enum_device_type.set(1);
    paramArrayOfByte.setHasFlag(true);
    paramString.routing_head.trans_0x211.inst_ctrl.rpt_msg_send_to_inst.add(paramArrayOfByte);
    paramArrayOfByte = new im_msg_head.InstInfo();
    paramArrayOfByte.uint32_apppid.set(1001);
    paramArrayOfByte.uint32_instid.set(AppSetting.d());
    paramArrayOfByte.enum_device_type.set(2);
    paramArrayOfByte.setHasFlag(true);
    paramString.routing_head.trans_0x211.inst_ctrl.msg_from_inst = paramArrayOfByte;
    paramString.routing_head.trans_0x211.inst_ctrl.setHasFlag(true);
    localToServiceMsg.putWupBuffer(paramString.toByteArray());
    sendPbReq(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg a(long paramLong1, String paramString, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, long paramLong2)
  {
    return a(true, paramLong1, paramString, paramInt1, paramInt2, paramInt3, paramArrayOfByte, paramLong2);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("received a cmd=");
      paramObject.append(paramFromServiceMsg.getServiceCmd());
      QLog.d("dataline.Printer", 2, paramObject.toString());
    }
    if (paramToServiceMsg.extraData.getInt("ROUNTING_TYPE") == 13)
    {
      if (!paramToServiceMsg.extraData.getBoolean("ISFROM_DATALINE")) {
        return;
      }
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        int i = paramToServiceMsg.extraData.getInt("DATALINE_TRYINDEX");
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("<PbSendMsg><R><---handle0x211C2CMessageError, retry = ");
          paramFromServiceMsg.append(i);
          QLog.d("dataline.Printer", 2, paramFromServiceMsg.toString());
        }
        if (i < 3)
        {
          paramToServiceMsg.extraData.putInt("DATALINE_TRYINDEX", i + 1);
          sendPbReq(paramToServiceMsg);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Timer localTimer = this.b;
    if (localTimer != null)
    {
      localTimer.cancel();
      this.b = null;
    }
    this.a = paramBoolean;
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public void b()
  {
    Object localObject1 = (RegisterProxySvcPackHandler)this.d.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER);
    if ((((RegisterProxySvcPackHandler)localObject1).d() != 0) && (((RegisterProxySvcPackHandler)localObject1).h() == 1))
    {
      if (this.b == null)
      {
        localObject1 = new PrinterStatusHandler.1(this);
        this.b = new Timer();
        this.b.schedule((TimerTask)localObject1, 30000L);
        Object localObject2 = new C2CType0x211_SubC2CType0x9.MsgBody();
        ((C2CType0x211_SubC2CType0x9.MsgBody)localObject2).str_service.set("printer");
        ((C2CType0x211_SubC2CType0x9.MsgBody)localObject2).uint32_CMD.set(1);
        this.c += 1;
        localObject1 = this.d.getCurrentAccountUin();
        localObject2 = ((C2CType0x211_SubC2CType0x9.MsgBody)localObject2).toByteArray();
        a(this.c, (String)localObject1, 529, 9, 1021, (byte[])localObject2, 0L);
      }
    }
    else
    {
      this.a = false;
      notifyUI(12, false, null);
    }
  }
  
  public void c()
  {
    Object localObject1 = (RegisterProxySvcPackHandler)this.d.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER);
    if ((((RegisterProxySvcPackHandler)localObject1).d() != 0) && (((RegisterProxySvcPackHandler)localObject1).h() == 1))
    {
      Object localObject2 = new C2CType0x211_SubC2CType0x9.MsgBody();
      ((C2CType0x211_SubC2CType0x9.MsgBody)localObject2).str_service.set("printer");
      ((C2CType0x211_SubC2CType0x9.MsgBody)localObject2).uint32_CMD.set(5);
      this.c += 1;
      localObject1 = this.d.getCurrentAccountUin();
      localObject2 = ((C2CType0x211_SubC2CType0x9.MsgBody)localObject2).toByteArray();
      a(this.c, (String)localObject1, 529, 9, 1021, (byte[])localObject2, 0L);
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return DataLineObserver.class;
  }
  
  public void onDestroy()
  {
    MessageObserver localMessageObserver = this.e;
    if (localMessageObserver != null)
    {
      this.d.removeObserver(localMessageObserver);
      this.e = null;
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"MessageSvc.PbSendMsg".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("cmdfilter error=");
        paramToServiceMsg.append(paramFromServiceMsg.getServiceCmd());
        QLog.d("dataline.Printer", 2, paramToServiceMsg.toString());
      }
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new PrinterStatusHandler.2(this, paramToServiceMsg, paramFromServiceMsg, paramObject));
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.PrinterStatusHandler
 * JD-Core Version:    0.7.0.1
 */