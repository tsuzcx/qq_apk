package com.tencent.mobileqq.activity.aio.coreui.oneclickjump;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.oneclickjump.JumpState;
import com.tencent.mobileqq.activity.aio.oneclickjump.StateMachine;
import java.util.Collections;

public class InactivatedStateProcessor
  extends DefaultStateProcessor
{
  public InactivatedStateProcessor(AIOContext paramAIOContext, StateMachine<JumpState> paramStateMachine)
  {
    super(JumpState.INACTIVATED, Collections.singletonList(JumpState.START));
    this.a = paramStateMachine;
    this.b = paramAIOContext;
  }
  
  public void a(JumpState paramJumpState)
  {
    super.a(paramJumpState);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.oneclickjump.InactivatedStateProcessor
 * JD-Core Version:    0.7.0.1
 */