package com.tencent.mobileqq.activity.aio.coreui.oneclickjump;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.oneclickjump.JumpState;
import com.tencent.mobileqq.activity.aio.oneclickjump.StateMachine;
import java.util.Collections;

public class GrayTipAboveStateProcessor
  extends DefaultStateProcessor
{
  public GrayTipAboveStateProcessor(AIOContext paramAIOContext, StateMachine<JumpState> paramStateMachine)
  {
    super(JumpState.GRAY_TIP_ABOVE, Collections.singletonList(JumpState.PULL_UP_FAILURE));
    this.a = paramStateMachine;
    this.b = paramAIOContext;
  }
  
  public void a(JumpState paramJumpState)
  {
    super.a(paramJumpState);
    this.a.a(JumpState.END);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.oneclickjump.GrayTipAboveStateProcessor
 * JD-Core Version:    0.7.0.1
 */