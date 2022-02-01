package com.tencent.mobileqq.apollo.meme.manager;

import com.tencent.mobileqq.apollo.meme.IMemePlayerListener;
import com.tencent.mobileqq.apollo.meme.MemeHelper;
import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.cmshow.engine.action.ActionStatus;
import com.tencent.mobileqq.cmshow.engine.action.COMPLETE;
import com.tencent.mobileqq.cmshow.engine.action.INTERRUPT;
import com.tencent.mobileqq.cmshow.engine.action.START;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/apollo/meme/manager/MemeBornPlayerManager$recordActionByRecorder$listenerWrapper$1", "Lcom/tencent/mobileqq/apollo/meme/manager/InnerMemePlayerListener;", "hasCompleteOrInterrupt", "", "onActionStatusChange", "", "action", "Lcom/tencent/mobileqq/apollo/meme/action/MemeAction;", "status", "Lcom/tencent/mobileqq/cmshow/engine/action/ActionStatus;", "onRecordDone", "success", "recordKey", "", "recordPath", "onRecordFrame", "index", "", "pixels", "", "width", "height", "frameTime", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class MemeBornPlayerManager$recordActionByRecorder$listenerWrapper$1
  implements InnerMemePlayerListener
{
  private boolean c;
  
  MemeBornPlayerManager$recordActionByRecorder$listenerWrapper$1(MemeBornPlayerManager.ActionItem paramActionItem, MemeBornPlayer paramMemeBornPlayer) {}
  
  public void a(@NotNull MemeAction paramMemeAction, int paramInt1, @NotNull byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4)
  {
    Intrinsics.checkParameterIsNotNull(paramMemeAction, "action");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "pixels");
    Object localObject = (List)MemeBornPlayerManager.d(MemeBornPlayerManager.a).get(MemeAction.a(paramMemeAction, null, null, 3, null));
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((IMemePlayerListener)((Iterator)localObject).next()).a(paramMemeAction, paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramInt4);
      }
    }
  }
  
  public void a(@NotNull MemeAction paramMemeAction, @NotNull ActionStatus paramActionStatus)
  {
    Intrinsics.checkParameterIsNotNull(paramMemeAction, "action");
    Intrinsics.checkParameterIsNotNull(paramActionStatus, "status");
    StringBuilder localStringBuilder;
    if (Intrinsics.areEqual(paramActionStatus, START.a))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("recordAction ");
      localStringBuilder.append(paramMemeAction.h());
      localStringBuilder.append(" state change to ");
      localStringBuilder.append(paramActionStatus);
      QLog.w("[cmshow][MemePlayer]MemeBornPlayerManager", 1, localStringBuilder.toString());
      return;
    }
    if (paramActionStatus.b())
    {
      TraceReportUtil.a(MemeHelper.a.a(paramMemeAction.i()), MemeAction.a(paramMemeAction, null, null, 3, null), 1, paramActionStatus.a(), new Object[] { paramMemeAction.h() });
      if (this.c)
      {
        paramActionStatus = new StringBuilder();
        paramActionStatus.append("recordAction ");
        paramActionStatus.append(paramMemeAction.h());
        paramActionStatus.append(", state change, but hasCompleteOrInterrupt skip!!");
        QLog.w("[cmshow][MemePlayer]MemeBornPlayerManager", 1, paramActionStatus.toString());
        return;
      }
      this.c = true;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("recordAction ");
      localStringBuilder.append(paramMemeAction.h());
      localStringBuilder.append(" state change to ");
      localStringBuilder.append(paramActionStatus);
      QLog.w("[cmshow][MemePlayer]MemeBornPlayerManager", 1, localStringBuilder.toString());
      if ((Intrinsics.areEqual(paramActionStatus, INTERRUPT.a)) || (Intrinsics.areEqual(paramActionStatus, COMPLETE.a)))
      {
        paramMemeAction = (Lock)MemeBornPlayerManager.b(MemeBornPlayerManager.a);
        paramMemeAction.lock();
      }
      try
      {
        if (!MemeBornPlayerManager.c(MemeBornPlayerManager.a).contains(this.a)) {
          MemeBornPlayerManager.c(MemeBornPlayerManager.a).add(this.a);
        }
        paramActionStatus = Unit.INSTANCE;
        paramMemeAction.unlock();
        MemeBornPlayerManager.a(MemeBornPlayerManager.a, this.b);
        return;
      }
      finally
      {
        paramMemeAction.unlock();
      }
    }
  }
  
  public void a(@NotNull MemeAction paramMemeAction, boolean paramBoolean, @NotNull String paramString1, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramMemeAction, "action");
    Intrinsics.checkParameterIsNotNull(paramString1, "recordKey");
    Lock localLock = (Lock)MemeBornPlayerManager.b(MemeBornPlayerManager.a);
    localLock.lock();
    try
    {
      a(paramMemeAction, paramMemeAction.k());
      MemeBornPlayerManager.c(MemeBornPlayerManager.a).remove(this.a);
      int i = MemeHelper.a.a(paramMemeAction.i());
      Object localObject = null;
      TraceReportUtil.b(i, MemeAction.a(paramMemeAction, null, null, 3, null));
      List localList = (List)MemeBornPlayerManager.d(MemeBornPlayerManager.a).remove(paramString1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("recordAction recordDone ");
      localStringBuilder.append(this.a.c().h());
      localStringBuilder.append(", success:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" path:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", listeners size:");
      if (localList != null) {
        localObject = Integer.valueOf(localList.size());
      }
      localStringBuilder.append(localObject);
      QLog.w("[cmshow][MemePlayer]MemeBornPlayerManager", 1, localStringBuilder.toString());
      if (localList != null)
      {
        localObject = ((Iterable)localList).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((IMemePlayerListener)((Iterator)localObject).next()).a(paramMemeAction, paramBoolean, paramString1, paramString2);
        }
        paramMemeAction = Unit.INSTANCE;
      }
      localLock.unlock();
      return;
    }
    finally
    {
      localLock.unlock();
    }
    for (;;)
    {
      throw paramMemeAction;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.manager.MemeBornPlayerManager.recordActionByRecorder.listenerWrapper.1
 * JD-Core Version:    0.7.0.1
 */