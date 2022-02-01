package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IHeadMsgRefresher;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.helper.TroopToDoHelper;
import com.tencent.mobileqq.activity.aio.troop.trooptodo.TroopToDoTipsBar;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.todo.TroopTodoReportUtils.ReportData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class TodoHeadMsgRefresher
  implements IHeadMsgRefresher
{
  private void a(AIOContext paramAIOContext, int paramInt)
  {
    Object localObject = (TroopToDoHelper)paramAIOContext.a(139);
    if (localObject == null)
    {
      QLog.e("TodoHeadMsgRefresher-TodoInfo", 2, "reportStatus: can't get TroopToDoHelper");
      return;
    }
    localObject = ((TroopToDoHelper)localObject).b();
    if (localObject == null)
    {
      QLog.e("TodoHeadMsgRefresher-TodoInfo", 2, "reportStatus: troopToDoTipsBar == null");
      return;
    }
    localObject = ((TroopToDoTipsBar)localObject).b();
    paramAIOContext = paramAIOContext.a();
    int i = ((TroopTodoReportUtils.ReportData)localObject).a;
    int j = ((TroopTodoReportUtils.ReportData)localObject).b;
    localObject = ((TroopTodoReportUtils.ReportData)localObject).c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt);
    ReportController.b(paramAIOContext, "dc00898", "", "", "0X800BC75", "0X800BC75", 0, 0, String.valueOf(i), String.valueOf(j), (String)localObject, localStringBuilder.toString());
  }
  
  public void a(AIOContext paramAIOContext, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, Runnable paramRunnable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[refreshHeadMessage] invoke, type = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", firstSeq = ");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(", targetSeq = ");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(", count = ");
    long l1 = paramLong2 - paramLong1;
    localStringBuilder.append(l1);
    localStringBuilder.append(", unreadMsgCount = ");
    localStringBuilder.append(paramInt2);
    QLog.i("TodoHeadMsgRefresher-TodoInfo", 2, localStringBuilder.toString());
    long l2 = (int)paramLong2;
    paramInt2 = 0;
    if (l2 >= 1L + paramLong1)
    {
      if (l1 > 200L)
      {
        QLog.w("TodoHeadMsgRefresher-TodoInfo", 2, "[refreshHeadMessage] not in cache, exceed 200, show toast");
        QQToast.makeText(paramAIOContext.b(), 2131917649, 0).show(paramAIOContext.b().getTitleBarHeight());
        a(paramAIOContext, 2);
        return;
      }
      QLog.i("TodoHeadMsgRefresher-TodoInfo", 2, "[refreshHeadMessage] not in cache, refresh msg and scroll to 0, POSITION_OFFSET = 2");
      paramAIOContext.e().d().a(paramLong2, paramLong1 - 2L, true);
      paramAIOContext.e().d().a(paramInt1, 2, -1, paramRunnable, 6);
      a(paramAIOContext, 1);
      return;
    }
    paramInt3 = paramAIOContext.e().b().c(paramLong1);
    paramRunnable = new StringBuilder();
    paramRunnable.append("[refreshHeadMessage] in cache, start scroll to positinByShmsgseq:");
    paramRunnable.append(paramInt3);
    QLog.i("TodoHeadMsgRefresher-TodoInfo", 2, paramRunnable.toString());
    if (paramInt3 != -1)
    {
      paramRunnable = (TroopToDoHelper)paramAIOContext.a(139);
      if (paramRunnable == null)
      {
        QLog.e("TodoHeadMsgRefresher-TodoInfo", 2, "refreshHeadMessage: can't get TroopToDoHelper");
        return;
      }
      paramRunnable = paramRunnable.b();
      if (paramRunnable != null) {
        paramInt2 = paramRunnable.a();
      }
      paramAIOContext.e().d().a(paramInt2 * 2);
      paramAIOContext.e().d().a(paramInt1, paramInt3, paramInt3, null, 6);
      a(paramAIOContext, 1);
      return;
    }
    QQToast.makeText(paramAIOContext.b(), 2131917649, 0).show(paramAIOContext.b().getTitleBarHeight());
    a(paramAIOContext, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.TodoHeadMsgRefresher
 * JD-Core Version:    0.7.0.1
 */