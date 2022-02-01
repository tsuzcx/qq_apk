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
  protected final BaseSessionInfo a;
  protected final AIOContext a;
  protected final QQAppInterface a;
  
  public BaseMessageSender(AIOContext paramAIOContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramAIOContext.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = paramAIOContext.a();
  }
  
  public void a()
  {
    IMsgSendListener localIMsgSendListener = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a(2);
    if (localIMsgSendListener.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)) {
      return;
    }
    long l1 = System.currentTimeMillis();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" onClick fun_btn start text.length ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().a().length());
      localStringBuilder.append(" currentPanel:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a());
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
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().a().length());
        localStringBuilder.append("cast time :");
        localStringBuilder.append(l2 - l1);
        QLog.d("MessageSender", 2, localStringBuilder.toString());
      }
    }
    localIMsgSendListener.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext);
  }
  
  public void a(AIOContext paramAIOContext)
  {
    try
    {
      EditTextUI localEditTextUI = paramAIOContext.a().a().a();
      localEditTextUI.a("");
      localEditTextUI.a(null, null, null, null);
      localEditTextUI.c(0);
    }
    catch (Exception localException)
    {
      QLog.e("MessageSender", 1, localException, new Object[0]);
    }
    Iterator localIterator = paramAIOContext.a().a().f().iterator();
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a(1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext);
  }
  
  public void c()
  {
    Object localObject = new ChatActivityFacade.SendMsgParams();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a((ChatActivityFacade.SendMsgParams)localObject);
    SendLogicParam localSendLogicParam = new SendLogicParam();
    localSendLogicParam.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().a().toString());
    localSendLogicParam.a((ChatActivityFacade.SendMsgParams)localObject);
    localObject = new ArrayList();
    List localList = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().c();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext()) {
      if (((ISendMessageCallback)localIterator.next()).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, localSendLogicParam)) {
        return;
      }
    }
    ((ChatPieInputHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(6)).a = false;
    localIterator = localList.iterator();
    while (localIterator.hasNext()) {
      if (((ISendMessageCallback)localIterator.next()).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, localSendLogicParam, (ArrayList)localObject))
      {
        i = 1;
        break label190;
      }
    }
    int i = 0;
    label190:
    if (i == 0) {
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), (SessionInfo)this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo, localSendLogicParam.a(), (ArrayList)localObject, localSendLogicParam.a());
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(1002, new Object[] { localSendLogicParam.a() });
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getConfiguration().orientation == 2) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005C7C", "0X8005C7C", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.c, -1, "");
    localObject = localList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ISendMessageCallback)((Iterator)localObject).next()).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, localSendLogicParam);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.input.BaseMessageSender
 * JD-Core Version:    0.7.0.1
 */