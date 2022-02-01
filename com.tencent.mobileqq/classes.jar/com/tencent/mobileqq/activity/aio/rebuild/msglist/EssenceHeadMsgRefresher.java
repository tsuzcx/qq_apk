package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IHeadMsgRefresher;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class EssenceHeadMsgRefresher
  implements IHeadMsgRefresher
{
  public void a(AIOContext paramAIOContext, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, Runnable paramRunnable)
  {
    if (paramLong2 - paramLong1 > 200L)
    {
      QQToast.a(paramAIOContext.a(), 2131719843, 0).b(paramAIOContext.a().getTitleBarHeight());
      if (QLog.isColorLevel()) {
        QLog.d("EssenceHeadMsgRefresher", 2, "refreshHeadMessage: invalidate unread count TYPE_TROOP_ESSENCEMSG");
      }
      return;
    }
    if ((int)paramLong2 >= 1L + paramLong1)
    {
      if (!NetworkUtil.isNetworkAvailable(paramAIOContext.a()))
      {
        QQToast.a(paramAIOContext.a(), 2131697226, 0).b(paramAIOContext.a().getTitleBarHeight());
        return;
      }
      paramAIOContext.a().a().a(paramLong2, paramLong1, false);
      paramAIOContext.a().a().a(paramInt1, 0, -1, paramRunnable, 6);
      return;
    }
    paramInt2 = paramAIOContext.a().a().c(paramLong1);
    if (paramInt2 != -1)
    {
      paramAIOContext.a().a().a(paramInt1, paramInt2, paramInt2, null, 6);
      return;
    }
    QQToast.a(paramAIOContext.a(), 2131719843, 0).b(paramAIOContext.a().getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.EssenceHeadMsgRefresher
 * JD-Core Version:    0.7.0.1
 */