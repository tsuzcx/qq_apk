package com.tencent.mobileqq.apollo.player.manager;

import com.tencent.mobileqq.apollo.player.CMSActionStatus;
import com.tencent.mobileqq.apollo.player.CMSHelper;
import com.tencent.mobileqq.apollo.player.ICMSPlayerListener;
import com.tencent.mobileqq.apollo.player.ICMSPlayerListener.DefaultImpls;
import com.tencent.mobileqq.apollo.player.action.CMSAction;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/apollo/player/manager/CMSBornPlayerManager$recordActionByRecorder$listenerWrapper$1", "Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;", "hasCompleteOrInterrupt", "", "onActionStatusChange", "", "action", "Lcom/tencent/mobileqq/apollo/player/action/CMSAction;", "status", "Lcom/tencent/mobileqq/apollo/player/CMSActionStatus;", "onRecordDone", "success", "recordKey", "", "recordPath", "onRecordFrame", "index", "", "pixels", "", "width", "height", "frameTime", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CMSBornPlayerManager$recordActionByRecorder$listenerWrapper$1
  implements ICMSPlayerListener
{
  private boolean jdField_a_of_type_Boolean;
  
  CMSBornPlayerManager$recordActionByRecorder$listenerWrapper$1(CMSBornPlayerManager.ActionItem paramActionItem, CMSBornPlayer paramCMSBornPlayer) {}
  
  public void a(@NotNull CMSAction paramCMSAction)
  {
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "action");
    ICMSPlayerListener.DefaultImpls.a(this, paramCMSAction);
  }
  
  public void a(@NotNull CMSAction paramCMSAction, int paramInt1, @NotNull byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4)
  {
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "action");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "pixels");
    Object localObject = (List)CMSBornPlayerManager.b(CMSBornPlayerManager.a).get(CMSAction.a(paramCMSAction, null, null, 3, null));
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ICMSPlayerListener)((Iterator)localObject).next()).a(paramCMSAction, paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramInt4);
      }
    }
  }
  
  public void a(@NotNull CMSAction paramCMSAction, @NotNull CMSActionStatus paramCMSActionStatus)
  {
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "action");
    Intrinsics.checkParameterIsNotNull(paramCMSActionStatus, "status");
    StringBuilder localStringBuilder;
    if (paramCMSActionStatus == CMSActionStatus.START)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("recordAction ");
      localStringBuilder.append(paramCMSAction.d());
      localStringBuilder.append(" state change to ");
      localStringBuilder.append(paramCMSActionStatus);
      QLog.w("[cmshow][scripted][CMSPlayer]CMSBornPlayerManager", 1, localStringBuilder.toString());
      return;
    }
    if (paramCMSActionStatus.isEndState())
    {
      TraceReportUtil.a(CMSHelper.a.a(paramCMSAction.a()), CMSAction.a(paramCMSAction, null, null, 3, null), 1, paramCMSActionStatus.toReportErrorCode(), new Object[0]);
      if (this.jdField_a_of_type_Boolean)
      {
        paramCMSActionStatus = new StringBuilder();
        paramCMSActionStatus.append("recordAction ");
        paramCMSActionStatus.append(paramCMSAction.d());
        paramCMSActionStatus.append(", state change, but hasCompleteOrInterrupt skip!!");
        QLog.w("[cmshow][scripted][CMSPlayer]CMSBornPlayerManager", 1, paramCMSActionStatus.toString());
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("recordAction ");
      localStringBuilder.append(paramCMSAction.d());
      localStringBuilder.append(" state change to ");
      localStringBuilder.append(paramCMSActionStatus);
      QLog.w("[cmshow][scripted][CMSPlayer]CMSBornPlayerManager", 1, localStringBuilder.toString());
      if ((paramCMSActionStatus == CMSActionStatus.INTERRUPT) || (paramCMSActionStatus == CMSActionStatus.COMPLETE))
      {
        paramCMSAction = (Lock)CMSBornPlayerManager.a(CMSBornPlayerManager.a);
        paramCMSAction.lock();
      }
      try
      {
        if (!CMSBornPlayerManager.a(CMSBornPlayerManager.a).contains(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager$ActionItem)) {
          CMSBornPlayerManager.a(CMSBornPlayerManager.a).add(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager$ActionItem);
        }
        paramCMSActionStatus = Unit.INSTANCE;
        paramCMSAction.unlock();
        CMSBornPlayerManager.a(CMSBornPlayerManager.a, this.jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayer);
        return;
      }
      finally
      {
        paramCMSAction.unlock();
      }
    }
  }
  
  public void a(@NotNull CMSAction paramCMSAction, boolean paramBoolean, @NotNull String paramString1, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "action");
    Intrinsics.checkParameterIsNotNull(paramString1, "recordKey");
    Lock localLock = (Lock)CMSBornPlayerManager.a(CMSBornPlayerManager.a);
    localLock.lock();
    if (paramBoolean) {}
    try
    {
      Object localObject = CMSActionStatus.COMPLETE;
      break label47;
      localObject = CMSActionStatus.ERROR_APNG_ENCODE_FAIL;
      label47:
      a(paramCMSAction, (CMSActionStatus)localObject);
      CMSBornPlayerManager.a(CMSBornPlayerManager.a).remove(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager$ActionItem);
      int i = CMSHelper.a.a(paramCMSAction.a());
      localObject = null;
      TraceReportUtil.b(i, CMSAction.a(paramCMSAction, null, null, 3, null));
      List localList = (List)CMSBornPlayerManager.b(CMSBornPlayerManager.a).remove(paramString1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("recordAction recordDone ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager$ActionItem.a().d());
      localStringBuilder.append(", success:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" path:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", listeners size:");
      if (localList != null) {
        localObject = Integer.valueOf(localList.size());
      }
      localStringBuilder.append(localObject);
      QLog.w("[cmshow][scripted][CMSPlayer]CMSBornPlayerManager", 1, localStringBuilder.toString());
      if (localList != null)
      {
        localObject = ((Iterable)localList).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((ICMSPlayerListener)((Iterator)localObject).next()).a(paramCMSAction, paramBoolean, paramString1, paramString2);
        }
        paramCMSAction = Unit.INSTANCE;
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
      throw paramCMSAction;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSBornPlayerManager.recordActionByRecorder.listenerWrapper.1
 * JD-Core Version:    0.7.0.1
 */