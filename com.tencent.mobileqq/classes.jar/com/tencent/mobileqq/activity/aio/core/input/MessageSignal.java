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
  private final AIOContext a;
  private boolean b = false;
  private boolean c = false;
  private int d = 0;
  private int e = 0;
  private int f = 0;
  private int g = 10;
  private int h = 0;
  private Runnable i;
  
  public MessageSignal(AIOContext paramAIOContext)
  {
    this.a = paramAIOContext;
  }
  
  private void h()
  {
    this.i = new MessageSignal.1(this);
  }
  
  public void a(Editable paramEditable)
  {
    if (a()) {
      if ((!this.c) && (paramEditable.length() > 0))
      {
        this.h = e();
        int j = this.h;
        if ((j == 2) || (j == 3))
        {
          this.c = true;
          this.d = 1;
          if (this.i == null) {
            h();
          }
          ThreadManager.getSubThreadHandler().post(this.i);
        }
      }
      else if (paramEditable.length() == 0)
      {
        ThreadManager.getSubThreadHandler().removeCallbacks(this.i);
        this.c = false;
        this.d = 40;
        this.f = 0;
        this.e = 0;
        this.h = 0;
      }
    }
  }
  
  public void a(ChatActivityFacade.SendMsgParams paramSendMsgParams)
  {
    paramSendMsgParams.d = c();
    paramSendMsgParams.c = b();
    paramSendMsgParams.e = a();
    paramSendMsgParams.f = e();
    paramSendMsgParams.g = System.currentTimeMillis();
    paramSendMsgParams.x = ((ChatPieInputHelper)this.a.a(6)).a;
    paramSendMsgParams.h = ((ReplyHelper)this.a.a(119)).c();
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public int b()
  {
    return this.d;
  }
  
  public int c()
  {
    return this.f;
  }
  
  public void d()
  {
    int j = this.a.a().getMsgCache().F();
    boolean bool = true;
    if (j != 1) {
      bool = false;
    }
    this.b = bool;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mIsMsgSignalOpen: ");
      localStringBuilder.append(this.b);
      QLog.d("MessageSignal", 2, localStringBuilder.toString());
    }
  }
  
  int e()
  {
    return NetworkUtil.getSystemNetwork(BaseApplication.getContext());
  }
  
  int f()
  {
    return this.a.p().d().f().a().length();
  }
  
  public void g()
  {
    this.c = false;
    this.d = 60;
    this.f = 0;
    this.h = 0;
    ThreadManager.getSubThreadHandler().removeCallbacks(this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.input.MessageSignal
 * JD-Core Version:    0.7.0.1
 */