package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IHeadMsgRefresher;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.troop.data.TroopMessageManager.UserActionStateInParallelPullPeriod;
import com.tencent.mobileqq.troop.navigatebar.AioAgent.Message;
import com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class AttentionHeadMsgRefresher
  implements Handler.Callback, IHeadMsgRefresher
{
  private final MqqHandler a = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  private Scroller b;
  private TroopMessageManager.UserActionStateInParallelPullPeriod c;
  
  public void a(AIOContext paramAIOContext)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      if ((((TroopMessageManager.UserActionStateInParallelPullPeriod)localObject).d == TroopMessageManager.UserActionStateInParallelPullPeriod.c) && (this.c.e != null)) {
        paramAIOContext.e().d().a(this.c.e.e, this.c.e.a(), this.c.e.f);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("update,mUserActionState.actionType");
        ((StringBuilder)localObject).append(this.c.d);
        QLog.d("AttentionHeadMsgRefresh.trooptroop_pull_msg", 2, ((StringBuilder)localObject).toString());
      }
      this.c = null;
      paramAIOContext.a().getMessageFacade().p().deleteObservers();
    }
  }
  
  public void a(AIOContext paramAIOContext, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, Runnable paramRunnable)
  {
    Scroller localScroller = paramAIOContext.e().d();
    this.b = localScroller;
    Object localObject = paramAIOContext.a().getMessageFacade().d(paramAIOContext.O().b, paramAIOContext.O().a, paramLong1);
    if ((localObject != null) && (paramInt2 <= 200))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("refreshHeadMessage==>unreadMsgCount:");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(", fistseq:");
        localStringBuilder.append(paramLong2);
        localStringBuilder.append(", mr.shmsgseq:");
        localStringBuilder.append(((MessageRecord)localObject).shmsgseq);
        QLog.d("AttentionHeadMsgRefresh.troop.special_msg", 2, localStringBuilder.toString());
      }
      if ((int)paramLong2 >= ((MessageRecord)localObject).shmsgseq + 1L)
      {
        localScroller.a(paramLong2, ((MessageRecord)localObject).shmsgseq, false);
        localScroller.a(paramInt1, 0, -1, paramRunnable, this.a, 6);
        return;
      }
      paramInt2 = paramAIOContext.e().b().c(paramLong1);
      if (paramInt2 != -1) {
        localScroller.a(paramInt1, paramInt2, paramInt2, null, this.a, 6);
      }
    }
    else
    {
      boolean bool = paramAIOContext.a().getMessageFacade().p().c(paramAIOContext.O().b);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("所要定位的消息还没拉回来本地，并发拉取中...mUserActionState create, natvigateSeq:");
        ((StringBuilder)localObject).append(paramLong1);
        ((StringBuilder)localObject).append(",isAioParallelPullMsgDone:");
        ((StringBuilder)localObject).append(bool);
        QLog.d("AttentionHeadMsgRefresh.trooptroop_pull_msg", 2, ((StringBuilder)localObject).toString());
      }
      if (bool)
      {
        if ((int)paramLong2 >= 1L + paramLong1)
        {
          localScroller.a(paramLong2, paramLong1, false);
          localScroller.a(paramInt1, 0, -1, paramRunnable, this.a, 6);
          return;
        }
        paramInt2 = paramAIOContext.e().b().c(paramLong1);
        if (paramInt2 != -1) {
          localScroller.a(paramInt1, paramInt2, paramInt2, null, this.a, 6);
        }
      }
      else
      {
        this.c = new TroopMessageManager.UserActionStateInParallelPullPeriod();
        this.c.d = TroopMessageManager.UserActionStateInParallelPullPeriod.c;
        this.c.e = AioAgent.Message.a(paramInt1, paramLong1, paramInt2);
        paramAIOContext.a().getMessageFacade().p().addObserver(paramAIOContext.f());
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 50) && (this.b.b()))
    {
      paramMessage = (TroopAioMsgNavigateBar)this.b.e();
      if (paramMessage.f.get()) {
        paramMessage.f.set(false);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.AttentionHeadMsgRefresher
 * JD-Core Version:    0.7.0.1
 */