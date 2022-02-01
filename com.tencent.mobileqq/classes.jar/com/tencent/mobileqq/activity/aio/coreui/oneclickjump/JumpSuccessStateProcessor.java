package com.tencent.mobileqq.activity.aio.coreui.oneclickjump;

import com.tencent.imcore.message.RefreshMessageContext;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.oneclickjump.JumpState;
import com.tencent.mobileqq.activity.aio.oneclickjump.OneClickJumpUtil;
import com.tencent.mobileqq.activity.aio.oneclickjump.StateMachine;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.navigatebar.AioTips;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;

public class JumpSuccessStateProcessor
  extends DefaultStateProcessor
{
  RefreshMessageContext c;
  
  public JumpSuccessStateProcessor(AIOContext paramAIOContext, StateMachine<JumpState> paramStateMachine)
  {
    super(JumpState.JUMP_SUCCESS, Arrays.asList(new JumpState[] { JumpState.INACTIVATED, JumpState.PULL_UP_SUCCESS, JumpState.PULL_UP_FAILURE, JumpState.GRAY_TIP_BELOW, JumpState.GRAY_TIP_CLICK }));
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
    paramJumpState = this.b.e().b();
    paramJumpState.a(true);
    paramJumpState.c(true);
    try
    {
      if (this.a.b() == JumpState.INACTIVATED)
      {
        paramJumpState = this.b.e().d().f();
        List localList = this.c.b;
        if ((!localList.isEmpty()) && (paramJumpState.h - ((MessageRecord)localList.get(localList.size() - 1)).shmsgseq <= 1L))
        {
          this.a.a(JumpState.END);
          this.a.a(JumpState.END);
        }
      }
      else if (this.a.b() == JumpState.GRAY_TIP_BELOW)
      {
        OneClickJumpUtil.a(this.b.a());
        return;
      }
    }
    catch (Exception paramJumpState)
    {
      this.a.a(JumpState.END);
      QLog.e("JumpStateMachineController", 1, paramJumpState, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.oneclickjump.JumpSuccessStateProcessor
 * JD-Core Version:    0.7.0.1
 */