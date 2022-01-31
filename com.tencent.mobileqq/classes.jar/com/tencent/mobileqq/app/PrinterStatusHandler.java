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
import zjr;
import zjs;
import zjt;
import zju;

public class PrinterStatusHandler
  extends BusinessHandler
{
  private int jdField_a_of_type_Int;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new zjt(this);
  private RegisterProxySvcPackObserver jdField_a_of_type_ComTencentMobileqqAppRegisterProxySvcPackObserver = new zju(this);
  private Timer jdField_a_of_type_JavaUtilTimer;
  private boolean jdField_a_of_type_Boolean;
  
  public PrinterStatusHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.b.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.b.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppRegisterProxySvcPackObserver);
    b();
  }
  
  private ToServiceMsg a(boolean paramBoolean, long paramLong1, String paramString, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = a("MessageSvc.PbSendMsg");
    localToServiceMsg.extraData.putInt("SEND_MSG_CMD_MSG_TYPE", 1);
    localToServiceMsg.extraData.putInt("ROUNTING_TYPE", 13);
    localToServiceMsg.extraData.putBoolean("ISFROM_DATALINE", true);
    localToServiceMsg.extraData.putInt("DATALINE_CMD", paramInt3);
    localToServiceMsg.addAttribute("cookie", Long.valueOf(paramLong1));
    localToServiceMsg.addAttribute("sendFromNative", Boolean.valueOf(paramBoolean));
    localToServiceMsg.extraData.putInt("DATALINE_TRYINDEX", 0);
    paramLong1 = FileManagerUtil.b();
    paramLong2 = FileManagerUtil.a();
    TransMsgContext localTransMsgContext = new TransMsgContext();
    localTransMsgContext.jdField_a_of_type_Int = paramInt2;
    localTransMsgContext.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    paramString = MessageProtoCodec.a(this.b, 13, paramString, localTransMsgContext, paramLong2, MessageUtils.b(paramLong1));
    paramArrayOfByte = new im_msg_head.InstInfo();
    paramArrayOfByte.uint32_apppid.set(1);
    paramArrayOfByte.uint32_instid.set(0);
    paramArrayOfByte.enum_device_type.set(1);
    paramArrayOfByte.setHasFlag(true);
    paramString.routing_head.trans_0x211.inst_ctrl.rpt_msg_send_to_inst.add(paramArrayOfByte);
    paramArrayOfByte = new im_msg_head.InstInfo();
    paramArrayOfByte.uint32_apppid.set(1001);
    paramArrayOfByte.uint32_instid.set(AppSetting.jdField_a_of_type_Int);
    paramArrayOfByte.enum_device_type.set(2);
    paramArrayOfByte.setHasFlag(true);
    paramString.routing_head.trans_0x211.inst_ctrl.msg_from_inst = paramArrayOfByte;
    paramString.routing_head.trans_0x211.inst_ctrl.setHasFlag(true);
    localToServiceMsg.putWupBuffer(paramString.toByteArray());
    b(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg a(long paramLong1, String paramString, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, long paramLong2)
  {
    return a(true, paramLong1, paramString, paramInt1, paramInt2, paramInt3, paramArrayOfByte, paramLong2);
  }
  
  protected Class a()
  {
    return DataLineObserver.class;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver != null)
    {
      this.b.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = null;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"MessageSvc.PbSendMsg".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("dataline.Printer", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
      }
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new zjs(this, paramToServiceMsg, paramFromServiceMsg, paramObject));
      return;
    }
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    Object localObject1 = (RegisterProxySvcPackHandler)this.b.a(10);
    if ((((RegisterProxySvcPackHandler)localObject1).a() != 0) && (((RegisterProxySvcPackHandler)localObject1).h() == 1))
    {
      if (this.jdField_a_of_type_JavaUtilTimer == null)
      {
        localObject1 = new zjr(this);
        this.jdField_a_of_type_JavaUtilTimer = new Timer();
        this.jdField_a_of_type_JavaUtilTimer.schedule((TimerTask)localObject1, 30000L);
        Object localObject2 = new C2CType0x211_SubC2CType0x9.MsgBody();
        ((C2CType0x211_SubC2CType0x9.MsgBody)localObject2).str_service.set("printer");
        ((C2CType0x211_SubC2CType0x9.MsgBody)localObject2).uint32_CMD.set(1);
        this.jdField_a_of_type_Int += 1;
        localObject1 = this.b.getCurrentAccountUin();
        localObject2 = ((C2CType0x211_SubC2CType0x9.MsgBody)localObject2).toByteArray();
        a(this.jdField_a_of_type_Int, (String)localObject1, 529, 9, 1021, (byte[])localObject2, 0L);
      }
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    a(12, false, null);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.Printer", 2, "received a cmd=" + paramFromServiceMsg.getServiceCmd());
    }
    if ((paramToServiceMsg.extraData.getInt("ROUNTING_TYPE") != 13) || (!paramToServiceMsg.extraData.getBoolean("ISFROM_DATALINE"))) {}
    int i;
    do
    {
      do
      {
        return;
      } while (paramFromServiceMsg.getResultCode() == 1000);
      i = paramToServiceMsg.extraData.getInt("DATALINE_TRYINDEX");
      if (QLog.isColorLevel()) {
        QLog.d("dataline.Printer", 2, "<PbSendMsg><R><---handle0x211C2CMessageError, retry = " + i);
      }
    } while (i >= 3);
    paramToServiceMsg.extraData.putInt("DATALINE_TRYINDEX", i + 1);
    b(paramToServiceMsg);
  }
  
  public void c()
  {
    Object localObject1 = (RegisterProxySvcPackHandler)this.b.a(10);
    if ((((RegisterProxySvcPackHandler)localObject1).a() != 0) && (((RegisterProxySvcPackHandler)localObject1).h() == 1))
    {
      Object localObject2 = new C2CType0x211_SubC2CType0x9.MsgBody();
      ((C2CType0x211_SubC2CType0x9.MsgBody)localObject2).str_service.set("printer");
      ((C2CType0x211_SubC2CType0x9.MsgBody)localObject2).uint32_CMD.set(5);
      this.jdField_a_of_type_Int += 1;
      localObject1 = this.b.getCurrentAccountUin();
      localObject2 = ((C2CType0x211_SubC2CType0x9.MsgBody)localObject2).toByteArray();
      a(this.jdField_a_of_type_Int, (String)localObject1, 529, 9, 1021, (byte[])localObject2, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PrinterStatusHandler
 * JD-Core Version:    0.7.0.1
 */