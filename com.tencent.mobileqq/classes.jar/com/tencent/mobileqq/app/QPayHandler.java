package com.tencent.mobileqq.app;

import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPayReminderActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import tencent.im.s2c.msgtype0x210.submsgtype0x72.SubMsgType0x72.MsgBody;
import tencent.mobileim.structmsg.QPayReminderMsg.GetInfoReq;
import tencent.mobileim.structmsg.QPayReminderMsg.GetInfoRsp;

public class QPayHandler
  extends BusinessHandler
{
  private String a;
  
  public QPayHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(BaseActivity.sTopActivity, QPayReminderActivity.class);
    localIntent.putExtra("URGENCY", paramInt1);
    localIntent.putExtra("TEMPLATE", paramInt2);
    localIntent.putExtra("CONTENT", paramString1);
    BaseActivity.sTopActivity.startActivity(localIntent);
    BaseActivity.sTopActivity.overridePendingTransition(2130772434, 2130772007);
    if (QLog.isColorLevel()) {
      QLog.d("QPayHandler", 2, "QPayReminder: lauching popup QPayReminderActivity");
    }
    a(paramString2);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!((Boolean)paramToServiceMsg.getAttribute("is_query", Boolean.valueOf(false))).booleanValue()) {
      return;
    }
    paramToServiceMsg = new QPayReminderMsg.GetInfoRsp();
    try
    {
      paramFromServiceMsg = (QPayReminderMsg.GetInfoRsp)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if (paramFromServiceMsg.result_code.get() != 0)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("QPayReminder: receive pull response, but result_code = ");
        paramToServiceMsg.append(paramFromServiceMsg.result_code.get());
        QLog.d("QPayHandler", 2, paramToServiceMsg.toString());
        return;
      }
      int i = paramFromServiceMsg.urgency.get();
      int j = paramFromServiceMsg.template_no.get();
      paramToServiceMsg = paramFromServiceMsg.content.get();
      paramFromServiceMsg = paramFromServiceMsg.info_date.get();
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("QPayReminder: receive pull response, message content: ");
        paramObject.append(paramToServiceMsg);
        QLog.d("QPayHandler", 2, paramObject.toString());
      }
      a(i, j, paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      label179:
      break label179;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QPayHandler", 2, "QPayReminder: receive pull response, parse error");
    }
    return;
  }
  
  public void a(String paramString)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("QPayReminderSvc.query_over_due_info");
    QPayReminderMsg.GetInfoReq localGetInfoReq = new QPayReminderMsg.GetInfoReq();
    localGetInfoReq.scene.set("qpay");
    localGetInfoReq.sub_cmd.set("feedback_overdue");
    localGetInfoReq.info_date.set(paramString);
    localToServiceMsg.putWupBuffer(localGetInfoReq.toByteArray());
    localToServiceMsg.setNeedCallback(false);
    sendPbReq(localToServiceMsg);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.appRuntime.getAccount());
      ((StringBuilder)localObject1).append(":");
      ((StringBuilder)localObject1).append(SimpleDateFormat.getDateInstance().format(new Date()));
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = this.a;
      if ((localObject2 != null) && (((String)localObject2).equals(localObject1)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QPayHandler", 2, "QPayReminder: only one offline msg is processed everyday");
        }
        return;
      }
      this.a = ((String)localObject1);
    }
    Object localObject1 = createToServiceMsg("QPayReminderSvc.query_over_due_info");
    Object localObject2 = new QPayReminderMsg.GetInfoReq();
    ((QPayReminderMsg.GetInfoReq)localObject2).scene.set("qpay");
    ((QPayReminderMsg.GetInfoReq)localObject2).sub_cmd.set("query_overdue");
    ((ToServiceMsg)localObject1).putWupBuffer(((QPayReminderMsg.GetInfoReq)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).addAttribute("is_query", Boolean.valueOf(true));
    sendPbReq((ToServiceMsg)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("QPayHandler", 2, "QPayReminder: send pull request");
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    Object localObject = new SubMsgType0x72.MsgBody();
    try
    {
      localObject = (SubMsgType0x72.MsgBody)((SubMsgType0x72.MsgBody)localObject).mergeFrom(paramArrayOfByte);
      if (((SubMsgType0x72.MsgBody)localObject).uint32_sub_cmd.get() != 2)
      {
        a(false);
        return;
      }
      int i = ((SubMsgType0x72.MsgBody)localObject).uint32_urgency.get();
      int j = ((SubMsgType0x72.MsgBody)localObject).uint32_template_no.get();
      paramArrayOfByte = ((SubMsgType0x72.MsgBody)localObject).str_content.get();
      localObject = ((SubMsgType0x72.MsgBody)localObject).str_info_date.get();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("QPayReminder: receive online push message, message content: ");
        localStringBuilder.append(paramArrayOfByte);
        QLog.d("QPayHandler", 2, localStringBuilder.toString());
      }
      a(i, j, paramArrayOfByte, (String)localObject);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      label131:
      break label131;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QPayHandler", 2, "QPayReminder: receive online push message, parse error");
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("QPayReminderSvc.query_over_due_info".equals(paramFromServiceMsg.getServiceCmd())) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.QPayHandler
 * JD-Core Version:    0.7.0.1
 */