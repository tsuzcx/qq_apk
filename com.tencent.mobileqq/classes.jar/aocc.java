import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.PbSendMsgResp;

public class aocc
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
  
  public aocc(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, int paramInt5, boolean paramBoolean2, int paramInt6, msg_svc.PbSendMsgResp paramPbSendMsgResp, SendMessageHandler paramSendMessageHandler)
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
        paramPbSendMsgResp = anzj.a(2131705520);
      }
      paramPbSendMsgResp = new avpd(paramString, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getCurrentAccountUin(), paramPbSendMsgResp, paramInt1, -5020, 1376257, bcrg.a());
      paramString = new MessageForUniteGrayTip();
      paramString.initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app, paramPbSendMsgResp);
      avpe.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app, paramString);
    }
  }
  
  private void c(msg_svc.PbSendMsgResp paramPbSendMsgResp, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramPbSendMsgResp.errmsg.has()) && ((paramInt2 == 63) || (paramInt2 == 64) || (paramInt2 == 65) || ((paramInt2 >= 10000) && (paramInt2 < 20000))))
    {
      aosd.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app, paramString, paramPbSendMsgResp.errmsg.get(), paramInt1, false, false);
      switch (paramInt2)
      {
      default: 
        if ((paramInt2 >= 10000) && (paramInt2 < 20000))
        {
          paramString = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app;
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
      bdll.b(paramString, "dc00899", "grp_lbs", "", "c2c_tmp", "no_send", 0, 0, paramPbSendMsgResp, "" + paramInt2, "", "");
      return;
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app, "CliOper", "", "", "0X80052A8", "0X80052A8", 0, 0, "", "", "", "");
      break;
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app, "CliOper", "", "", "0X80052A9", "0X80052A9", 0, 0, "", "", "", "");
      break;
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app, "CliOper", "", "", "0X80052AA", "0X80052AA", 0, 0, "", "", "", "");
      break;
    }
  }
  
  private void d(msg_svc.PbSendMsgResp paramPbSendMsgResp, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramPbSendMsgResp.errmsg.has()) && ((paramInt2 == 54) || (paramInt2 == 61) || (paramInt2 == 62) || (paramInt2 == 63) || (paramInt2 == 64) || (paramInt2 == 65))) {
      aosd.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app, paramString, paramPbSendMsgResp.errmsg.get(), paramInt1, false, false);
    }
    switch (paramInt2)
    {
    default: 
      return;
    case 63: 
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app, "CliOper", "", "", "0X80052A8", "0X80052A8", 0, 0, "", "", "", "");
      return;
    case 64: 
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app, "CliOper", "", "", "0X80052A9", "0X80052A9", 0, 0, "", "", "", "");
      return;
    }
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app, "CliOper", "", "", "0X80052AA", "0X80052AA", 0, 0, "", "", "", "");
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
  
  public aocc a()
  {
    a(this.jdField_a_of_type_MsfMsgsvcMsg_svc$PbSendMsgResp, this.jdField_a_of_type_JavaLangString, this.d, this.f);
    if ((this.f == 10) || (this.f == 34))
    {
      this.jdField_b_of_type_Boolean = true;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.a().b(this.jdField_a_of_type_JavaLangString, this.d, this.jdField_a_of_type_Long);
      if (MessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, (MessageRecord)localObject, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.removeMessageObserver(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg)))
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
      if (adak.a(this.d) == 1032) {
        arrayOfObject[7] = Integer.valueOf(this.e);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(i, true, arrayOfObject);
      if (this.jdField_c_of_type_Boolean)
      {
        i = this.jdField_a_of_type_Int;
        localObject = new aock();
        ((aock)localObject).jdField_b_of_type_Int = 2900;
        ((aock)localObject).jdField_a_of_type_Long = this.f;
        ((aock)localObject).jdField_c_of_type_Int = (i + 1);
        ((aock)localObject).jdField_a_of_type_JavaLangString = MessageHandler.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg);
        ((aock)localObject).d = 1;
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
        ((bkib)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.a(85)).a(this.jdField_a_of_type_JavaLangString, this.f, l);
      }
      this.jdField_a_of_type_Boolean = false;
      return this;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aocc
 * JD-Core Version:    0.7.0.1
 */