package com.tencent.mobileqq.activity.aio.coreui.oneclickjump;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.oneclickjump.JumpState;
import com.tencent.mobileqq.activity.aio.oneclickjump.StateMachine;
import java.util.Collections;

public class GrayTipBelowStateProcessor
  extends DefaultStateProcessor
{
  public GrayTipBelowStateProcessor(AIOContext paramAIOContext, StateMachine<JumpState> paramStateMachine)
  {
    super(JumpState.GRAY_TIP_BELOW, Collections.singletonList(JumpState.PULL_UP_FAILURE));
    this.a = paramStateMachine;
    this.b = paramAIOContext;
  }
  
  public void a(JumpState paramJumpState)
  {
    super.a(paramJumpState);
    this.a.a(JumpState.JUMP_SUCCESS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.oneclickjump.GrayTipBelowStateProcessor
 * JD-Core Version:    0.7.0.1
 */