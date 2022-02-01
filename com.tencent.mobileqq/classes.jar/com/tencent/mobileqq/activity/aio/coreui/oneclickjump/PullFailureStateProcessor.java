package com.tencent.mobileqq.activity.aio.coreui.oneclickjump;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.oneclickjump.JumpState;
import com.tencent.mobileqq.activity.aio.oneclickjump.OneClickJumpUtil;
import com.tencent.mobileqq.activity.aio.oneclickjump.StateMachine;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Arrays;
import java.util.List;

public class PullFailureStateProcessor
  extends DefaultStateProcessor
{
  public PullFailureStateProcessor(AIOContext paramAIOContext, StateMachine<JumpState> paramStateMachine)
  {
    super(JumpState.PULL_UP_FAILURE, Arrays.asList(new JumpState[] { JumpState.PULL_UP_FAILURE, JumpState.JUMP_SUCCESS }));
    this.a = paramStateMachine;
    this.b = paramAIOContext;
  }
  
  public void a(JumpState paramJumpState)
  {
    super.a(paramJumpState);
    if (this.a.b() == JumpState.JUMP_SUCCESS)
    {
      paramJumpState = this.b.e().b().d();
      OneClickJumpUtil.b(this.b.a(), (MessageRecord)paramJumpState.get(paramJumpState.size() - 1));
      OneClickJumpUtil.a(this.b.b());
    }
    this.b.e().b().a(false);
    this.b.e().b().c(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.oneclickjump.PullFailureStateProcessor
 * JD-Core Version:    0.7.0.1
 */