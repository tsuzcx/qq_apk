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
  private MessageHandler a;
  private boolean b;
  private ToServiceMsg c;
  private FromServiceMsg d;
  private String e;
  private long f;
  private long g;
  private long h;
  private int i;
  private int j;
  private int k;
  private int l;
  private boolean m;
  private int n;
  private boolean o;
  private int p;
  private msg_svc.PbSendMsgResp q;
  private SendMessageHandler r;
  
  public HandleSendC2CMessageRespPBReplyBranch2(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, int paramInt5, boolean paramBoolean2, int paramInt6, msg_svc.PbSendMsgResp paramPbSendMsgResp, SendMessageHandler paramSendMessageHandler)
  {
    this.a = paramMessageHandler;
    this.c = paramToServiceMsg;
    this.d = paramFromServiceMsg;
    this.e = paramString;
    this.f = paramLong1;
    this.g = paramLong2;
    this.h = paramLong3;
    this.i = paramInt1;
    this.j = paramInt2;
    this.k = paramInt3;
    this.l = paramInt4;
    this.m = paramBoolean1;
    this.n = paramInt5;
    this.o = paramBoolean2;
    this.p = paramInt6;
    this.q = paramPbSendMsgResp;
    this.r = paramSendMessageHandler;
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
      this.a.a(paramInt1, paramPbSendMsgResp.errmsg.get(), paramString);
    }
  }
  
  private void b(msg_svc.PbSendMsgResp paramPbSendMsgResp, String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 16)
    {
      String str = paramPbSendMsgResp.errmsg.get();
      paramPbSendMsgResp = str;
      if (TextUtils.isEmpty(str)) {
        paramPbSendMsgResp = HardCodeUtil.a(2131904514);
      }
      paramPbSendMsgResp = new UniteGrayTipParam(paramString, this.a.n.getCurrentAccountUin(), paramPbSendMsgResp, paramInt1, -5020, 1376257, MessageCache.c());
      paramString = new MessageForUniteGrayTip();
      paramString.initGrayTipMsg(this.a.n, paramPbSendMsgResp);
      UniteGrayTipMsgUtil.a(this.a.n, paramString);
    }
  }
  
  private void c(msg_svc.PbSendMsgResp paramPbSendMsgResp, String paramString, int paramInt1, int paramInt2)
  {
    if (((paramPbSendMsgResp.errmsg.has()) && ((paramInt2 == 63) || (paramInt2 == 64) || (paramInt2 == 65) || ((paramInt2 >= 10000) && (paramInt2 < 20000)))) || (paramInt2 == 10109) || (paramInt2 == 10110))
    {
      Object localObject;
      if ((paramInt2 != 10109) && (paramInt2 != 10110))
      {
        AddMessageHelper.a(this.a.n, paramString, paramPbSendMsgResp.errmsg.get(), paramInt1, false, false);
      }
      else
      {
        paramPbSendMsgResp = paramPbSendMsgResp.errmsg.get();
        paramString = new UniteGrayTipParam(paramString, this.a.n.getCurrentAccountUin(), paramPbSendMsgResp, paramInt1, -5000, 655381, MessageCache.c());
        localObject = new Bundle();
        ((Bundle)localObject).putInt("key_action", 66);
        paramString.a(paramPbSendMsgResp.length() - 4, paramPbSendMsgResp.length(), (Bundle)localObject);
        paramPbSendMsgResp = new MessageForUniteGrayTip();
        paramPbSendMsgResp.initGrayTipMsg(this.a.n, paramString);
        UniteGrayTipMsgUtil.a(this.a.n, paramPbSendMsgResp);
      }
      switch (paramInt2)
      {
      default: 
        break;
      case 65: 
        ReportController.b(this.a.n, "CliOper", "", "", "0X80052AA", "0X80052AA", 0, 0, "", "", "", "");
        break;
      case 64: 
        ReportController.b(this.a.n, "CliOper", "", "", "0X80052A9", "0X80052A9", 0, 0, "", "", "", "");
        break;
      case 63: 
        ReportController.b(this.a.n, "CliOper", "", "", "0X80052A8", "0X80052A8", 0, 0, "", "", "", "");
      }
      if ((paramInt2 >= 10000) && (paramInt2 < 20000))
      {
        paramString = this.a.n;
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
      AddMessageHelper.a(this.a.n, paramString, paramPbSendMsgResp.errmsg.get(), paramInt1, false, false);
      switch (paramInt2)
      {
      default: 
        return;
      case 65: 
        ReportController.b(this.a.n, "CliOper", "", "", "0X80052AA", "0X80052AA", 0, 0, "", "", "", "");
        return;
      case 64: 
        ReportController.b(this.a.n, "CliOper", "", "", "0X80052A9", "0X80052A9", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(this.a.n, "CliOper", "", "", "0X80052A8", "0X80052A8", 0, 0, "", "", "", "");
    }
  }
  
  private void e(msg_svc.PbSendMsgResp paramPbSendMsgResp, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramPbSendMsgResp.errmsg.has()) && (paramInt2 == 201)) {
      this.a.a(paramInt1, paramPbSendMsgResp.errmsg.get(), paramString);
    }
  }
  
  private void f(msg_svc.PbSendMsgResp paramPbSendMsgResp, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramPbSendMsgResp.errmsg.has()) && ((paramInt2 == 1600) || (paramInt2 == 1601) || (paramInt2 == 1602) || (paramInt2 == 1603))) {
      this.a.a(paramInt1, paramPbSendMsgResp.errmsg.get(), paramString);
    }
  }
  
  boolean a()
  {
    return this.b;
  }
  
  public boolean b()
  {
    return this.m;
  }
  
  public HandleSendC2CMessageRespPBReplyBranch2 c()
  {
    a(this.q, this.e, this.l, this.p);
    int i1 = this.p;
    Object localObject1;
    if ((i1 == 10) || (i1 == 34))
    {
      this.m = true;
      localObject1 = this.a.n.getMessageFacade().b(this.e, this.l, this.f);
      localObject2 = this.a;
      if (((MessageHandler)localObject2).a((MessageRecord)localObject1, ((MessageHandler)localObject2).d(this.c)))
      {
        this.a.c(this.g);
        this.b = true;
        return this;
      }
    }
    this.a.a(this.c, this.q);
    i1 = this.a.c(this.k);
    Object localObject2 = new Object[8];
    localObject2[0] = this.e;
    localObject2[1] = Integer.valueOf(this.l);
    localObject2[2] = Integer.valueOf(this.p);
    localObject2[3] = this.c.getAttribute("sendmsgHandler");
    localObject2[4] = Long.valueOf(this.h);
    localObject2[5] = Long.valueOf(this.f);
    if (this.q.errmsg.has()) {
      localObject1 = this.q.errmsg.get();
    } else {
      localObject1 = "";
    }
    localObject2[6] = localObject1;
    this.a.a((Object[])localObject2, this.d.getUin(), this.p);
    if (UinTypeUtil.e(this.l) == 1032) {
      localObject2[7] = Integer.valueOf(this.n);
    }
    this.a.a(i1, true, localObject2);
    if (this.o)
    {
      i1 = this.i;
      localObject1 = new StatictisInfo();
      ((StatictisInfo)localObject1).b = 2900;
      ((StatictisInfo)localObject1).d = this.p;
      ((StatictisInfo)localObject1).c = (i1 + 1);
      ((StatictisInfo)localObject1).e = BaseMessageHandler.a(this.d);
      ((StatictisInfo)localObject1).f = 1;
      this.a.a(this.c, 5006, false, new Object[] { Long.valueOf(this.f), localObject1 });
      this.a.a(this.e, this.l, this.f, false);
    }
    if ((this.j == -7005) && (QLog.isColorLevel()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ExtendFriendLimitChat SendC2CMessageResp_PB MessageForLimitChatConfirm Uniseq = ");
      ((StringBuilder)localObject1).append(this.f);
      ((StringBuilder)localObject1).append(" replyCode = ");
      ((StringBuilder)localObject1).append(this.p);
      QLog.e("Q.msg.MessageHandler", 2, ((StringBuilder)localObject1).toString());
    }
    Report.c(this.a, this.c, this.d, true);
    this.a.c(this.g);
    Report.a(this.a.n, this.c, this.d);
    i1 = this.l;
    if ((i1 == 1025) || (i1 == 1024))
    {
      long l1 = System.currentTimeMillis();
      l1 = this.r.a(l1);
      ((QidianHandler)this.a.n.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).a(this.e, this.p, l1);
    }
    this.b = false;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.HandleSendC2CMessageRespPBReplyBranch2
 * JD-Core Version:    0.7.0.1
 */