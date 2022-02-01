package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.message.AddMessageHelper;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.PbSendMsgResp;

class MessageHandler$HandleSendC2CMessageRespPBReplyBranch2
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private SendMessageHandler jdField_a_of_type_ComTencentMobileqqUtilsSendMessageHandler;
  private FromServiceMsg jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
  private ToServiceMsg jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg;
  private String jdField_a_of_type_JavaLangString;
  private msg_svc.PbSendMsgResp jdField_a_of_type_MsfMsgsvcMsg_svc$PbSendMsgResp;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  private int e;
  private int f;
  
  public MessageHandler$HandleSendC2CMessageRespPBReplyBranch2(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, int paramInt5, boolean paramBoolean2, int paramInt6, msg_svc.PbSendMsgResp paramPbSendMsgResp, SendMessageHandler paramSendMessageHandler)
  {
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg = paramToServiceMsg;
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg = paramFromServiceMsg;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_c_of_type_Long = paramLong3;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.d = paramInt4;
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.e = paramInt5;
    this.jdField_c_of_type_Boolean = paramBoolean2;
    this.f = paramInt6;
    this.jdField_a_of_type_MsfMsgsvcMsg_svc$PbSendMsgResp = paramPbSendMsgResp;
    this.jdField_a_of_type_ComTencentMobileqqUtilsSendMessageHandler = paramSendMessageHandler;
  }
  
  private void a(msg_svc.PbSendMsgResp paramPbSendMsgResp, String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1006) {
      f(paramPbSendMsgResp, paramString, paramInt1, paramInt2);
    }
    for (;;)
    {
      if ((paramPbSendMsgResp.errmsg.has()) && (paramInt2 == 201)) {
        MessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramInt1, paramPbSendMsgResp.errmsg.get(), paramString);
      }
      return;
      if (paramInt1 == 1022) {
        e(paramPbSendMsgResp, paramString, paramInt1, paramInt2);
      } else if (paramInt1 == 1010) {
        d(paramPbSendMsgResp, paramString, paramInt1, paramInt2);
      } else if ((paramInt1 == 1001) || (paramInt1 == 10002)) {
        c(paramPbSendMsgResp, paramString, paramInt1, paramInt2);
      } else if (paramInt1 == 0) {
        b(paramPbSendMsgResp, paramString, paramInt1, paramInt2);
      }
    }
  }
  
  private void b(msg_svc.PbSendMsgResp paramPbSendMsgResp, String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 16)
    {
      String str = paramPbSendMsgResp.errmsg.get();
      paramPbSendMsgResp = str;
      if (TextUtils.isEmpty(str)) {
        paramPbSendMsgResp = HardCodeUtil.a(2131706641);
      }
      paramPbSendMsgResp = new UniteGrayTipParam(paramString, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.getCurrentAccountUin(), paramPbSendMsgResp, paramInt1, -5020, 1376257, MessageCache.a());
      paramString = new MessageForUniteGrayTip();
      paramString.initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a, paramPbSendMsgResp);
      UniteGrayTipUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a, paramString);
    }
  }
  
  private void c(msg_svc.PbSendMsgResp paramPbSendMsgResp, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramPbSendMsgResp.errmsg.has()) && ((paramInt2 == 63) || (paramInt2 == 64) || (paramInt2 == 65) || ((paramInt2 >= 10000) && (paramInt2 < 20000))))
    {
      AddMessageHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a, paramString, paramPbSendMsgResp.errmsg.get(), paramInt1, false, false);
      switch (paramInt2)
      {
      default: 
        if ((paramInt2 >= 10000) && (paramInt2 < 20000))
        {
          paramString = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a;
          if (paramInt1 != 1001) {
            break label271;
          }
        }
        break;
      }
    }
    label271:
    for (paramPbSendMsgResp = "0";; paramPbSendMsgResp = "1")
    {
      ReportController.b(paramString, "dc00899", "grp_lbs", "", "c2c_tmp", "no_send", 0, 0, paramPbSendMsgResp, "" + paramInt2, "", "");
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a, "CliOper", "", "", "0X80052A8", "0X80052A8", 0, 0, "", "", "", "");
      break;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a, "CliOper", "", "", "0X80052A9", "0X80052A9", 0, 0, "", "", "", "");
      break;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a, "CliOper", "", "", "0X80052AA", "0X80052AA", 0, 0, "", "", "", "");
      break;
    }
  }
  
  private void d(msg_svc.PbSendMsgResp paramPbSendMsgResp, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramPbSendMsgResp.errmsg.has()) && ((paramInt2 == 54) || (paramInt2 == 61) || (paramInt2 == 62) || (paramInt2 == 63) || (paramInt2 == 64) || (paramInt2 == 65))) {
      AddMessageHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a, paramString, paramPbSendMsgResp.errmsg.get(), paramInt1, false, false);
    }
    switch (paramInt2)
    {
    default: 
      return;
    case 63: 
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a, "CliOper", "", "", "0X80052A8", "0X80052A8", 0, 0, "", "", "", "");
      return;
    case 64: 
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a, "CliOper", "", "", "0X80052A9", "0X80052A9", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a, "CliOper", "", "", "0X80052AA", "0X80052AA", 0, 0, "", "", "", "");
  }
  
  private void e(msg_svc.PbSendMsgResp paramPbSendMsgResp, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramPbSendMsgResp.errmsg.has()) && (paramInt2 == 201)) {
      MessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramInt1, paramPbSendMsgResp.errmsg.get(), paramString);
    }
  }
  
  private void f(msg_svc.PbSendMsgResp paramPbSendMsgResp, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramPbSendMsgResp.errmsg.has()) && ((paramInt2 == 1600) || (paramInt2 == 1601) || (paramInt2 == 1602) || (paramInt2 == 1603))) {
      MessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramInt1, paramPbSendMsgResp.errmsg.get(), paramString);
    }
  }
  
  public HandleSendC2CMessageRespPBReplyBranch2 a()
  {
    a(this.jdField_a_of_type_MsfMsgsvcMsg_svc$PbSendMsgResp, this.jdField_a_of_type_JavaLangString, this.d, this.f);
    if ((this.f == 10) || (this.f == 34))
    {
      this.jdField_b_of_type_Boolean = true;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.getMessageFacade().b(this.jdField_a_of_type_JavaLangString, this.d, this.jdField_a_of_type_Long);
      if (MessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, (MessageRecord)localObject, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg)))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(this.jdField_b_of_type_Long);
        this.jdField_a_of_type_Boolean = true;
        return this;
      }
    }
    MessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, this.jdField_a_of_type_MsfMsgsvcMsg_svc$PbSendMsgResp);
    int i = MessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, this.jdField_c_of_type_Int);
    Object[] arrayOfObject = new Object[8];
    arrayOfObject[0] = this.jdField_a_of_type_JavaLangString;
    arrayOfObject[1] = Integer.valueOf(this.d);
    arrayOfObject[2] = Integer.valueOf(this.f);
    arrayOfObject[3] = this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getAttribute("sendmsgHandler");
    arrayOfObject[4] = Long.valueOf(this.jdField_c_of_type_Long);
    arrayOfObject[5] = Long.valueOf(this.jdField_a_of_type_Long);
    if (this.jdField_a_of_type_MsfMsgsvcMsg_svc$PbSendMsgResp.errmsg.has()) {}
    for (Object localObject = this.jdField_a_of_type_MsfMsgsvcMsg_svc$PbSendMsgResp.errmsg.get();; localObject = "")
    {
      arrayOfObject[6] = localObject;
      MessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, arrayOfObject, this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getUin(), this.f);
      if (UinTypeUtil.a(this.d) == 1032) {
        arrayOfObject[7] = Integer.valueOf(this.e);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(i, true, arrayOfObject);
      if (this.jdField_c_of_type_Boolean)
      {
        i = this.jdField_a_of_type_Int;
        localObject = new StatictisInfo();
        ((StatictisInfo)localObject).jdField_b_of_type_Int = 2900;
        ((StatictisInfo)localObject).jdField_a_of_type_Long = this.f;
        ((StatictisInfo)localObject).jdField_c_of_type_Int = (i + 1);
        ((StatictisInfo)localObject).jdField_a_of_type_JavaLangString = MessageHandler.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg);
        ((StatictisInfo)localObject).d = 1;
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, 5006, false, new Object[] { Long.valueOf(this.jdField_a_of_type_Long), localObject });
        MessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, this.jdField_a_of_type_JavaLangString, this.d, this.jdField_a_of_type_Long, false);
      }
      if ((this.jdField_b_of_type_Int == -7005) && (QLog.isColorLevel())) {
        QLog.e("Q.msg.MessageHandler", 2, "ExtendFriendLimitChat SendC2CMessageResp_PB MessageForLimitChatConfirm Uniseq = " + this.jdField_a_of_type_Long + " replyCode = " + this.f);
      }
      MessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg, true);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(this.jdField_b_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.c(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg);
      if ((this.d == 1025) || (this.d == 1024))
      {
        long l = System.currentTimeMillis();
        l = this.jdField_a_of_type_ComTencentMobileqqUtilsSendMessageHandler.a(l);
        ((QidianHandler)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).a(this.jdField_a_of_type_JavaLangString, this.f, l);
      }
      this.jdField_a_of_type_Boolean = false;
      return this;
    }
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandler.HandleSendC2CMessageRespPBReplyBranch2
 * JD-Core Version:    0.7.0.1
 */