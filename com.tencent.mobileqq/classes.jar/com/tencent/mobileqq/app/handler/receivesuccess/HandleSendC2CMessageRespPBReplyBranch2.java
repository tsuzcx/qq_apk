package com.tencent.mobileqq.app.handler.receivesuccess;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.app.handler.Report;
import com.tencent.mobileqq.app.message.AddMessageHelper;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.PbSendMsgResp;

public class HandleSendC2CMessageRespPBReplyBranch2
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private MessageHandler jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
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
  
  public HandleSendC2CMessageRespPBReplyBranch2(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, int paramInt5, boolean paramBoolean2, int paramInt6, msg_svc.PbSendMsgResp paramPbSendMsgResp, SendMessageHandler paramSendMessageHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler = paramMessageHandler;
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
    } else if (paramInt1 == 1022) {
      e(paramPbSendMsgResp, paramString, paramInt1, paramInt2);
    } else if (paramInt1 == 1010) {
      d(paramPbSendMsgResp, paramString, paramInt1, paramInt2);
    } else if ((paramInt1 != 1001) && (paramInt1 != 10002))
    {
      if (paramInt1 == 0) {
        b(paramPbSendMsgResp, paramString, paramInt1, paramInt2);
      }
    }
    else {
      c(paramPbSendMsgResp, paramString, paramInt1, paramInt2);
    }
    if ((paramPbSendMsgResp.errmsg.has()) && (paramInt2 == 201)) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramInt1, paramPbSendMsgResp.errmsg.get(), paramString);
    }
  }
  
  private void b(msg_svc.PbSendMsgResp paramPbSendMsgResp, String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 16)
    {
      String str = paramPbSendMsgResp.errmsg.get();
      paramPbSendMsgResp = str;
      if (TextUtils.isEmpty(str)) {
        paramPbSendMsgResp = HardCodeUtil.a(2131706663);
      }
      paramPbSendMsgResp = new UniteGrayTipParam(paramString, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.getCurrentAccountUin(), paramPbSendMsgResp, paramInt1, -5020, 1376257, MessageCache.a());
      paramString = new MessageForUniteGrayTip();
      paramString.initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a, paramPbSendMsgResp);
      UniteGrayTipMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a, paramString);
    }
  }
  
  private void c(msg_svc.PbSendMsgResp paramPbSendMsgResp, String paramString, int paramInt1, int paramInt2)
  {
    if (((paramPbSendMsgResp.errmsg.has()) && ((paramInt2 == 63) || (paramInt2 == 64) || (paramInt2 == 65) || ((paramInt2 >= 10000) && (paramInt2 < 20000)))) || (paramInt2 == 10109) || (paramInt2 == 10110))
    {
      Object localObject;
      if ((paramInt2 != 10109) && (paramInt2 != 10110))
      {
        AddMessageHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a, paramString, paramPbSendMsgResp.errmsg.get(), paramInt1, false, false);
      }
      else
      {
        paramPbSendMsgResp = paramPbSendMsgResp.errmsg.get();
        paramString = new UniteGrayTipParam(paramString, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.getCurrentAccountUin(), paramPbSendMsgResp, paramInt1, -5000, 655381, MessageCache.a());
        localObject = new Bundle();
        ((Bundle)localObject).putInt("key_action", 66);
        paramString.a(paramPbSendMsgResp.length() - 4, paramPbSendMsgResp.length(), (Bundle)localObject);
        paramPbSendMsgResp = new MessageForUniteGrayTip();
        paramPbSendMsgResp.initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a, paramString);
        UniteGrayTipMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a, paramPbSendMsgResp);
      }
      switch (paramInt2)
      {
      default: 
        break;
      case 65: 
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a, "CliOper", "", "", "0X80052AA", "0X80052AA", 0, 0, "", "", "", "");
        break;
      case 64: 
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a, "CliOper", "", "", "0X80052A9", "0X80052A9", 0, 0, "", "", "", "");
        break;
      case 63: 
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a, "CliOper", "", "", "0X80052A8", "0X80052A8", 0, 0, "", "", "", "");
      }
      if ((paramInt2 >= 10000) && (paramInt2 < 20000))
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a;
        if (paramInt1 == 1001) {
          paramPbSendMsgResp = "0";
        } else {
          paramPbSendMsgResp = "1";
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramInt2);
        ReportController.b(paramString, "dc00899", "grp_lbs", "", "c2c_tmp", "no_send", 0, 0, paramPbSendMsgResp, ((StringBuilder)localObject).toString(), "", "");
      }
    }
  }
  
  private void d(msg_svc.PbSendMsgResp paramPbSendMsgResp, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramPbSendMsgResp.errmsg.has()) && ((paramInt2 == 54) || (paramInt2 == 61) || (paramInt2 == 62) || (paramInt2 == 63) || (paramInt2 == 64) || (paramInt2 == 65)))
    {
      AddMessageHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a, paramString, paramPbSendMsgResp.errmsg.get(), paramInt1, false, false);
      switch (paramInt2)
      {
      default: 
        return;
      case 65: 
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a, "CliOper", "", "", "0X80052AA", "0X80052AA", 0, 0, "", "", "", "");
        return;
      case 64: 
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a, "CliOper", "", "", "0X80052A9", "0X80052A9", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a, "CliOper", "", "", "0X80052A8", "0X80052A8", 0, 0, "", "", "", "");
    }
  }
  
  private void e(msg_svc.PbSendMsgResp paramPbSendMsgResp, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramPbSendMsgResp.errmsg.has()) && (paramInt2 == 201)) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramInt1, paramPbSendMsgResp.errmsg.get(), paramString);
    }
  }
  
  private void f(msg_svc.PbSendMsgResp paramPbSendMsgResp, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramPbSendMsgResp.errmsg.has()) && ((paramInt2 == 1600) || (paramInt2 == 1601) || (paramInt2 == 1602) || (paramInt2 == 1603))) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramInt1, paramPbSendMsgResp.errmsg.get(), paramString);
    }
  }
  
  public HandleSendC2CMessageRespPBReplyBranch2 a()
  {
    a(this.jdField_a_of_type_MsfMsgsvcMsg_svc$PbSendMsgResp, this.jdField_a_of_type_JavaLangString, this.d, this.f);
    int i = this.f;
    Object localObject1;
    if ((i == 10) || (i == 34))
    {
      this.jdField_b_of_type_Boolean = true;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.getMessageFacade().b(this.jdField_a_of_type_JavaLangString, this.d, this.jdField_a_of_type_Long);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
      if (((MessageHandler)localObject2).a((MessageRecord)localObject1, ((MessageHandler)localObject2).a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg)))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(this.jdField_b_of_type_Long);
        this.jdField_a_of_type_Boolean = true;
        return this;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, this.jdField_a_of_type_MsfMsgsvcMsg_svc$PbSendMsgResp);
    i = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(this.jdField_c_of_type_Int);
    Object localObject2 = new Object[8];
    localObject2[0] = this.jdField_a_of_type_JavaLangString;
    localObject2[1] = Integer.valueOf(this.d);
    localObject2[2] = Integer.valueOf(this.f);
    localObject2[3] = this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getAttribute("sendmsgHandler");
    localObject2[4] = Long.valueOf(this.jdField_c_of_type_Long);
    localObject2[5] = Long.valueOf(this.jdField_a_of_type_Long);
    if (this.jdField_a_of_type_MsfMsgsvcMsg_svc$PbSendMsgResp.errmsg.has()) {
      localObject1 = this.jdField_a_of_type_MsfMsgsvcMsg_svc$PbSendMsgResp.errmsg.get();
    } else {
      localObject1 = "";
    }
    localObject2[6] = localObject1;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a((Object[])localObject2, this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getUin(), this.f);
    if (UinTypeUtil.a(this.d) == 1032) {
      localObject2[7] = Integer.valueOf(this.e);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(i, true, localObject2);
    if (this.jdField_c_of_type_Boolean)
    {
      i = this.jdField_a_of_type_Int;
      localObject1 = new StatictisInfo();
      ((StatictisInfo)localObject1).jdField_b_of_type_Int = 2900;
      ((StatictisInfo)localObject1).jdField_a_of_type_Long = this.f;
      ((StatictisInfo)localObject1).jdField_c_of_type_Int = (i + 1);
      ((StatictisInfo)localObject1).jdField_a_of_type_JavaLangString = BaseMessageHandler.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg);
      ((StatictisInfo)localObject1).d = 1;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, 5006, false, new Object[] { Long.valueOf(this.jdField_a_of_type_Long), localObject1 });
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(this.jdField_a_of_type_JavaLangString, this.d, this.jdField_a_of_type_Long, false);
    }
    if ((this.jdField_b_of_type_Int == -7005) && (QLog.isColorLevel()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ExtendFriendLimitChat SendC2CMessageResp_PB MessageForLimitChatConfirm Uniseq = ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject1).append(" replyCode = ");
      ((StringBuilder)localObject1).append(this.f);
      QLog.e("Q.msg.MessageHandler", 2, ((StringBuilder)localObject1).toString());
    }
    Report.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg, true);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(this.jdField_b_of_type_Long);
    Report.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg);
    i = this.d;
    if ((i == 1025) || (i == 1024))
    {
      long l = System.currentTimeMillis();
      l = this.jdField_a_of_type_ComTencentMobileqqUtilsSendMessageHandler.a(l);
      ((QidianHandler)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).a(this.jdField_a_of_type_JavaLangString, this.f, l);
    }
    this.jdField_a_of_type_Boolean = false;
    return this;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.HandleSendC2CMessageRespPBReplyBranch2
 * JD-Core Version:    0.7.0.1
 */