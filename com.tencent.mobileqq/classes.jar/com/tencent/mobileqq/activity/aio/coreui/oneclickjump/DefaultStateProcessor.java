package com.tencent.mobileqq.activity.aio.coreui.oneclickjump;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.oneclickjump.JumpState;
import com.tencent.mobileqq.activity.aio.oneclickjump.StateMachine;
import com.tencent.mobileqq.activity.aio.oneclickjump.StateProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class DefaultStateProcessor
  extends StateProcessor<JumpState>
{
  protected StateMachine<JumpState> a;
  protected AIOContext b;
  
  public DefaultStateProcessor(JumpState paramJumpState, List<JumpState> paramList)
  {
    super(paramJumpState, paramList);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (paramInt != 1) {
      return;
    }
    if ((this.a.a() == JumpState.JUMP_SUCCESS) && (this.a.b() == JumpState.GRAY_TIP_CLICK))
    {
      if (QLog.isColorLevel()) {
        QLog.d("JumpStateMachineController", 2, "scroll to bottom after click gray tip");
      }
    }
    else {
      this.a.a(JumpState.END);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.oneclickjump.DefaultStateProcessor
 * JD-Core Version:    0.7.0.1
 */