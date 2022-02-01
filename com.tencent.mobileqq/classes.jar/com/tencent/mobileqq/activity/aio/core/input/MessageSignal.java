package com.tencent.mobileqq.activity.aio.core.input;

import android.text.Editable;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.helper.ReplyHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.haoliyou.orion.ChatPieInputHelper;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class MessageSignal
{
  private int jdField_a_of_type_Int = 0;
  private final AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = false;
  private int c;
  private int d = 10;
  private int e = 0;
  
  public MessageSignal(AIOContext paramAIOContext)
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaLangRunnable = new MessageSignal.1(this);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getMsgCache().b();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mIsMsgSignalOpen: ");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      QLog.d("MessageSignal", 2, localStringBuilder.toString());
    }
  }
  
  public void a(Editable paramEditable)
  {
    if (a()) {
      if ((!this.jdField_b_of_type_Boolean) && (paramEditable.length() > 0))
      {
        this.e = c();
        int i = this.e;
        if ((i == 2) || (i == 3))
        {
          this.jdField_b_of_type_Boolean = true;
          this.jdField_a_of_type_Int = 1;
          if (this.jdField_a_of_type_JavaLangRunnable == null) {
            c();
          }
          ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
        }
      }
      else if (paramEditable.length() == 0)
      {
        ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_Int = 40;
        this.jdField_c_of_type_Int = 0;
        this.jdField_b_of_type_Int = 0;
        this.e = 0;
      }
    }
  }
  
  public void a(ChatActivityFacade.SendMsgParams paramSendMsgParams)
  {
    paramSendMsgParams.jdField_b_of_type_Int = b();
    paramSendMsgParams.jdField_a_of_type_Int = a();
    paramSendMsgParams.jdField_c_of_type_Boolean = a();
    paramSendMsgParams.jdField_c_of_type_Int = c();
    paramSendMsgParams.jdField_a_of_type_Long = System.currentTimeMillis();
    paramSendMsgParams.h = ((ChatPieInputHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(6)).jdField_a_of_type_Boolean;
    paramSendMsgParams.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = ((ReplyHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(119)).b();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 60;
    this.jdField_c_of_type_Int = 0;
    this.e = 0;
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  int c()
  {
    return NetworkUtil.getSystemNetwork(BaseApplication.getContext());
  }
  
  int d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().a().length();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.input.MessageSignal
 * JD-Core Version:    0.7.0.1
 */