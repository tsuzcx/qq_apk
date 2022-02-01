package com.tencent.mobileqq.activity.aio.oneclickjump;

import com.tencent.imcore.message.RefreshMessageContext;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.coreui.oneclickjump.EndStateProcessor;
import com.tencent.mobileqq.activity.aio.coreui.oneclickjump.GrayTipAboveStateProcessor;
import com.tencent.mobileqq.activity.aio.coreui.oneclickjump.GrayTipBelowStateProcessor;
import com.tencent.mobileqq.activity.aio.coreui.oneclickjump.GrayTipClickStaterProcessor;
import com.tencent.mobileqq.activity.aio.coreui.oneclickjump.InactivatedStateProcessor;
import com.tencent.mobileqq.activity.aio.coreui.oneclickjump.JumpSuccessStateProcessor;
import com.tencent.mobileqq.activity.aio.coreui.oneclickjump.PullFailureStateProcessor;
import com.tencent.mobileqq.activity.aio.coreui.oneclickjump.PullSuccessStateProcessor;
import com.tencent.qphone.base.util.QLog;

public class JumpStateMachineController
{
  private StateMachine<JumpState> a;
  private AIOContext b;
  
  public JumpStateMachineController(AIOContext paramAIOContext)
  {
    this.b = paramAIOContext;
  }
  
  public JumpState a()
  {
    return (JumpState)this.a.a();
  }
  
  public void a(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void a(RefreshMessageContext paramRefreshMessageContext)
  {
    ((JumpSuccessStateProcessor)this.a.b(JumpState.JUMP_SUCCESS)).a(paramRefreshMessageContext);
    ((PullSuccessStateProcessor)this.a.b(JumpState.PULL_UP_SUCCESS)).a(paramRefreshMessageContext);
  }
  
  public void a(JumpState paramJumpState)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setState, state = ");
      localStringBuilder.append(paramJumpState);
      QLog.d("JumpStateMachineController", 1, localStringBuilder.toString());
    }
    this.a.a(paramJumpState);
  }
  
  public JumpState b()
  {
    return (JumpState)this.a.b();
  }
  
  public void c()
  {
    this.a = new StateMachine(JumpState.START, "JumpStateMachineController");
    StateMachine localStateMachine = this.a;
    localStateMachine.a(new InactivatedStateProcessor(this.b, localStateMachine));
    localStateMachine = this.a;
    localStateMachine.a(new JumpSuccessStateProcessor(this.b, localStateMachine));
    localStateMachine = this.a;
    localStateMachine.a(new PullSuccessStateProcessor(this.b, localStateMachine));
    localStateMachine = this.a;
    localStateMachine.a(new PullFailureStateProcessor(this.b, localStateMachine));
    localStateMachine = this.a;
    localStateMachine.a(new GrayTipAboveStateProcessor(this.b, localStateMachine));
    localStateMachine = this.a;
    localStateMachine.a(new GrayTipBelowStateProcessor(this.b, localStateMachine));
    localStateMachine = this.a;
    localStateMachine.a(new GrayTipClickStaterProcessor(this.b, localStateMachine));
    localStateMachine = this.a;
    localStateMachine.a(new EndStateProcessor(this.b, localStateMachine));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.oneclickjump.JumpStateMachineController
 * JD-Core Version:    0.7.0.1
 */