package com.tencent.mobileqq.activity.aio.coreui.oneclickjump;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.oneclickjump.JumpState;
import com.tencent.mobileqq.activity.aio.oneclickjump.StateMachine;
import java.util.Arrays;

public class EndStateProcessor
  extends DefaultStateProcessor
{
  public EndStateProcessor(AIOContext paramAIOContext, StateMachine<JumpState> paramStateMachine)
  {
    super(JumpState.END, Arrays.asList(new JumpState[] { JumpState.END, JumpState.JUMP_SUCCESS, JumpState.PULL_UP_SUCCESS, JumpState.PULL_UP_FAILURE, JumpState.GRAY_TIP_ABOVE }));
    this.a = paramStateMachine;
    this.b = paramAIOContext;
  }
  
  public void a(JumpState paramJumpState)
  {
    super.a(paramJumpState);
    this.b.e().b().a(false);
    this.b.e().b().c(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.oneclickjump.EndStateProcessor
 * JD-Core Version:    0.7.0.1
 */