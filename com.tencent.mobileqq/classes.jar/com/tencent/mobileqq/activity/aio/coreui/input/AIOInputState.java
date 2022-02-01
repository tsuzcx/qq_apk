package com.tencent.mobileqq.activity.aio.coreui.input;

import android.annotation.TargetApi;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.rebuild.input.InputCallbackRegister;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class AIOInputState
{
  private AIOContext a;
  private int b = 0;
  
  public AIOInputState(AIOContext paramAIOContext)
  {
    this.a = paramAIOContext;
  }
  
  public int a()
  {
    return this.b;
  }
  
  @TargetApi(11)
  public void a(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" setInputStat start stat = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" mInputStat= ");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(" currenttime:");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("AIOInputState", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt != this.b)
    {
      this.b = paramInt;
      localObject = this.a.p().d().f();
      ((EditTextUI)localObject).a(0);
      this.a.p().d().d().c();
      ((EditTextUI)localObject).b(true);
      localObject = this.a.p().c().f().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((IInputStateChangeCallback)((Iterator)localObject).next()).a(0, this.a);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" setInputStat end currenttime:");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("AIOInputState", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  @TargetApi(11)
  public void b()
  {
    Object localObject = this.a.p().d().f();
    if (this.a.a().getMessageFacade().l() == null) {
      return;
    }
    if (((EditTextUI)localObject).b() == null) {
      return;
    }
    this.b = 2;
    ((EditTextUI)localObject).a(8);
    ((EditTextUI)localObject).b(false);
    this.a.p().d().d().c(false);
    localObject = this.a.p().c().f().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IInputStateChangeCallback)((Iterator)localObject).next()).a(2, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.input.AIOInputState
 * JD-Core Version:    0.7.0.1
 */