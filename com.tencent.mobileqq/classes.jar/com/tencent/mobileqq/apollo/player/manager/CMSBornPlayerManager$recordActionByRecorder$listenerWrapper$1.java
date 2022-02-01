package com.tencent.mobileqq.apollo.player.manager;

import com.tencent.mobileqq.apollo.api.player.action.CMSAction;
import com.tencent.mobileqq.apollo.api.player.action.MODE;
import com.tencent.mobileqq.apollo.player.CMSActionStatus;
import com.tencent.mobileqq.apollo.player.ICMSPlayerListener;
import com.tencent.mobileqq.apollo.player.ICMSPlayerListener.DefaultImpls;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/apollo/player/manager/CMSBornPlayerManager$recordActionByRecorder$listenerWrapper$1", "Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;", "hasCompleteOrInterrupt", "", "onActionStatusChange", "", "action", "Lcom/tencent/mobileqq/apollo/api/player/action/CMSAction;", "status", "Lcom/tencent/mobileqq/apollo/player/CMSActionStatus;", "onRecordDone", "success", "recordKey", "", "recordPath", "onRecordFrame", "index", "", "pixels", "", "width", "height", "frameTime", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
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
    if (paramCMSActionStatus == CMSActionStatus.START) {
      QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 1, "recordAction " + paramCMSAction.d() + " state change to " + paramCMSActionStatus);
    }
    while (!paramCMSActionStatus.isEndState()) {
      return;
    }
    TraceReportUtil.a(paramCMSAction.a().toReportFeatureId(), CMSAction.a(paramCMSAction, null, null, 3, null), 1, paramCMSActionStatus.toReportErrorCode(), new Object[0]);
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 1, "recordAction " + paramCMSAction.d() + ", state change, but hasCompleteOrInterrupt skip!!");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 1, "recordAction " + paramCMSAction.d() + " state change to " + paramCMSActionStatus);
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
      CMSBornPlayerManager.b(CMSBornPlayerManager.a, this.jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayer);
      this.jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayer.a();
      return;
    }
    finally
    {
      paramCMSAction.unlock();
    }
  }
  
  public void a(@NotNull CMSAction paramCMSAction, boolean paramBoolean, @NotNull String paramString1, @Nullable String paramString2)
  {
    Object localObject2 = null;
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "action");
    Intrinsics.checkParameterIsNotNull(paramString1, "recordKey");
    Lock localLock = (Lock)CMSBornPlayerManager.a(CMSBornPlayerManager.a);
    localLock.lock();
    if (paramBoolean) {}
    try
    {
      for (Object localObject1 = CMSActionStatus.COMPLETE;; localObject1 = CMSActionStatus.ERROR_APNG_ENCODE_FAIL)
      {
        a(paramCMSAction, (CMSActionStatus)localObject1);
        CMSBornPlayerManager.a(CMSBornPlayerManager.a).remove(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager$ActionItem);
        TraceReportUtil.b(paramCMSAction.a().toReportFeatureId(), CMSAction.a(paramCMSAction, null, null, 3, null));
        List localList = (List)CMSBornPlayerManager.b(CMSBornPlayerManager.a).remove(paramString1);
        StringBuilder localStringBuilder = new StringBuilder().append("recordAction recordDone ").append(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager$ActionItem.a().d()).append(", success:").append(paramBoolean).append(" path:").append(paramString2).append(", listeners size:");
        localObject1 = localObject2;
        if (localList != null) {
          localObject1 = Integer.valueOf(localList.size());
        }
        QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 1, localObject1);
        if (localList == null) {
          break label250;
        }
        localObject1 = ((Iterable)localList).iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((ICMSPlayerListener)((Iterator)localObject1).next()).a(paramCMSAction, paramBoolean, paramString1, paramString2);
        }
      }
      paramCMSAction = Unit.INSTANCE;
      label250:
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSBornPlayerManager.recordActionByRecorder.listenerWrapper.1
 * JD-Core Version:    0.7.0.1
 */