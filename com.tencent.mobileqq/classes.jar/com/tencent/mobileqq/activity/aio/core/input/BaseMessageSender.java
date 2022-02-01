package com.tencent.mobileqq.activity.aio.core.input;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.Editable;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.coreui.input.IClearInputCallback;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.rebuild.input.InputCallbackRegister;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.haoliyou.orion.ChatPieInputHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class BaseMessageSender
{
  protected final AIOContext a;
  protected final QQAppInterface b;
  protected final BaseSessionInfo c;
  
  public BaseMessageSender(AIOContext paramAIOContext)
  {
    this.a = paramAIOContext;
    this.b = paramAIOContext.a();
    this.c = paramAIOContext.O();
  }
  
  public void a()
  {
    IMsgSendListener localIMsgSendListener = this.a.p().c().a(2);
    if (localIMsgSendListener.a(this.a)) {
      return;
    }
    long l1 = System.currentTimeMillis();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" onClick fun_btn start text.length ");
      localStringBuilder.append(this.a.p().d().f().a().length());
      localStringBuilder.append(" currentPanel:");
      localStringBuilder.append(this.a.k());
      localStringBuilder.append(" currenttime:");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("MessageSender", 2, localStringBuilder.toString());
    }
    b();
    if (QLog.isColorLevel())
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(" onClick fun_btn end text.length");
        localStringBuilder.append(this.a.p().d().f().a().length());
        localStringBuilder.append("cast time :");
        localStringBuilder.append(l2 - l1);
        QLog.d("MessageSender", 2, localStringBuilder.toString());
      }
    }
    localIMsgSendListener.b(this.a);
  }
  
  public void a(AIOContext paramAIOContext)
  {
    try
    {
      EditTextUI localEditTextUI = paramAIOContext.p().d().f();
      localEditTextUI.a("");
      localEditTextUI.a(null, null, null, null);
      localEditTextUI.d(0);
    }
    catch (Exception localException)
    {
      QLog.e("MessageSender", 1, localException, new Object[0]);
    }
    Iterator localIterator = paramAIOContext.p().c().g().iterator();
    while (localIterator.hasNext()) {
      ((IClearInputCallback)localIterator.next()).a(paramAIOContext);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" send start: currenttime:");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("SendMsgBtn", 2, localStringBuilder.toString());
    }
    c();
    this.a.p().c().a(1).b(this.a);
  }
  
  public void c()
  {
    Object localObject = new ChatActivityFacade.SendMsgParams();
    this.a.p().b().a((ChatActivityFacade.SendMsgParams)localObject);
    SendLogicParam localSendLogicParam = new SendLogicParam();
    localSendLogicParam.a(this.a.p().d().f().a().toString());
    localSendLogicParam.a((ChatActivityFacade.SendMsgParams)localObject);
    localObject = new ArrayList();
    List localList = this.a.p().c().d();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext()) {
      if (((ISendMessageCallback)localIterator.next()).beforeMessageSend(this.a, localSendLogicParam)) {
        return;
      }
    }
    ((ChatPieInputHelper)this.a.a(6)).a = false;
    localIterator = localList.iterator();
    while (localIterator.hasNext()) {
      if (((ISendMessageCallback)localIterator.next()).onMessageSending(this.a, localSendLogicParam, (ArrayList)localObject))
      {
        i = 1;
        break label190;
      }
    }
    int i = 0;
    label190:
    if (i == 0) {
      ChatActivityFacade.a(this.b, this.a.b(), (SessionInfo)this.c, localSendLogicParam.a(), (ArrayList)localObject, localSendLogicParam.b());
    }
    a(this.a);
    this.a.c().a(1002, new Object[] { localSendLogicParam.a() });
    if (this.b.getApplication().getResources().getConfiguration().orientation == 2) {
      ReportController.b(this.b, "CliOper", "", "", "0X8005C7C", "0X8005C7C", 0, 0, "", "", "", "");
    }
    this.a.a(this.c.s, -1, "");
    localObject = localList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ISendMessageCallback)((Iterator)localObject).next()).afterMessageSend(this.a, localSendLogicParam);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.input.BaseMessageSender
 * JD-Core Version:    0.7.0.1
 */