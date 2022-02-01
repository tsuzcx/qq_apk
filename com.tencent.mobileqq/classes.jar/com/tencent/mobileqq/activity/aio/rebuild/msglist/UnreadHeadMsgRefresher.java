package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IHeadMsgRefresher;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.coreui.msglist.TroopListUI;
import com.tencent.mobileqq.activity.aio.oneclickjump.JumpState;
import com.tencent.mobileqq.activity.aio.oneclickjump.JumpStateMachineController;
import com.tencent.mobileqq.activity.aio.oneclickjump.OneClickJumpConfBean;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class UnreadHeadMsgRefresher
  implements IHeadMsgRefresher
{
  private void a(AIOContext paramAIOContext, long paramLong1, long paramLong2, Runnable paramRunnable, ListUI paramListUI)
  {
    if ((int)paramLong2 >= 1L + paramLong1)
    {
      long l = paramLong1;
      if (paramLong2 - paramLong1 > 200L) {
        l = paramLong2 - 200L;
      }
      com.tencent.mobileqq.activity.aio.oneclickjump.OneClickJumpUtil.a = paramLong2 - l;
      if ((OneClickJumpConfBean.a()) && ((paramListUI instanceof TroopListUI)))
      {
        paramListUI = (TroopListUI)paramListUI;
        if (paramListUI.y() != null) {
          paramListUI.y().a(JumpState.INACTIVATED);
        }
      }
      paramAIOContext.e().d().a(paramLong2, l, true);
      paramAIOContext.e().d().a(0, -1, paramRunnable, 6, true);
    }
  }
  
  private void b(AIOContext paramAIOContext, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, Runnable paramRunnable)
  {
    Object localObject = paramAIOContext.e().b();
    if (((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).judgeGuildListUIJumpStateMachineControllerIsNotNull(localObject)) {
      ((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).setGuildListUIJumpStateINACTIVATED(localObject);
    }
    localObject = paramAIOContext.e().d();
    if (paramLong2 >= 1L + paramLong1)
    {
      paramAIOContext.e().d().a(paramLong2, paramLong1, true);
      paramAIOContext.e().d().a(0, -1, paramRunnable, 6, true);
      return;
    }
    paramInt2 = paramAIOContext.e().b().c(paramLong1);
    if (paramInt2 != -1) {
      ((Scroller)localObject).a(paramInt1, paramInt2, paramInt2, null, 6);
    }
  }
  
  public void a(AIOContext paramAIOContext, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, Runnable paramRunnable)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshHeadMessage, type: ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", value: ");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(", unreadMsgCount: ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", fistseq: ");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append(", reportType: ");
      ((StringBuilder)localObject).append(paramInt3);
      QLog.d("UnreadHeadMsgRefresher", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramAIOContext.e().b();
    if (((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).judgeListUiIsGuildListUI(localObject))
    {
      b(paramAIOContext, paramInt1, paramLong1, paramInt2, paramLong2, paramInt3, paramRunnable);
      return;
    }
    a(paramAIOContext, paramLong1, paramLong2, paramRunnable, (ListUI)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.UnreadHeadMsgRefresher
 * JD-Core Version:    0.7.0.1
 */