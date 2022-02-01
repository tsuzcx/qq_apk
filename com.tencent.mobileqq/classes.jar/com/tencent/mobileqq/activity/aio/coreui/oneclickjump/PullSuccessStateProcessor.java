package com.tencent.mobileqq.activity.aio.coreui.oneclickjump;

import com.tencent.imcore.message.RefreshMessageContext;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.oneclickjump.JumpState;
import com.tencent.mobileqq.activity.aio.oneclickjump.StateMachine;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.navigatebar.AioTips;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;

public class PullSuccessStateProcessor
  extends DefaultStateProcessor
{
  RefreshMessageContext c;
  
  public PullSuccessStateProcessor(AIOContext paramAIOContext, StateMachine<JumpState> paramStateMachine)
  {
    super(JumpState.PULL_UP_SUCCESS, Collections.singletonList(JumpState.JUMP_SUCCESS));
    this.a = paramStateMachine;
    this.b = paramAIOContext;
  }
  
  public void a(RefreshMessageContext paramRefreshMessageContext)
  {
    this.c = paramRefreshMessageContext;
  }
  
  public void a(JumpState paramJumpState)
  {
    super.a(paramJumpState);
    try
    {
      paramJumpState = this.b.e().d().f();
      List localList = this.c.b;
      if (paramJumpState.h - ((MessageRecord)localList.get(localList.size() - 1)).shmsgseq > 1L)
      {
        this.a.a(JumpState.JUMP_SUCCESS);
        return;
      }
      this.a.a(JumpState.END);
      return;
    }
    catch (Exception paramJumpState)
    {
      this.a.a(JumpState.END);
      QLog.d("JumpStateMachineController", 1, paramJumpState, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.oneclickjump.PullSuccessStateProcessor
 * JD-Core Version:    0.7.0.1
 */