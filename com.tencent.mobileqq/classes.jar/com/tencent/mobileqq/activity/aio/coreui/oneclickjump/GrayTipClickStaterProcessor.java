package com.tencent.mobileqq.activity.aio.coreui.oneclickjump;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListRefresher;
import com.tencent.mobileqq.activity.aio.oneclickjump.JumpState;
import com.tencent.mobileqq.activity.aio.oneclickjump.OneClickJumpUtil;
import com.tencent.mobileqq.activity.aio.oneclickjump.StateMachine;
import java.util.Collections;

public class GrayTipClickStaterProcessor
  extends DefaultStateProcessor
{
  public GrayTipClickStaterProcessor(AIOContext paramAIOContext, StateMachine<JumpState> paramStateMachine)
  {
    super(JumpState.GRAY_TIP_CLICK, Collections.singletonList(JumpState.PULL_UP_FAILURE));
    this.a = paramStateMachine;
    this.b = paramAIOContext;
  }
  
  public void a(JumpState paramJumpState)
  {
    super.a(paramJumpState);
    OneClickJumpUtil.a(this.b.a());
    this.a.a(JumpState.JUMP_SUCCESS);
    this.b.e().f().a(131074);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.oneclickjump.GrayTipClickStaterProcessor
 * JD-Core Version:    0.7.0.1
 */