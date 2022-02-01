import com.tencent.mobileqq.apollo.player.CMSActionStatus;
import com.tencent.mobileqq.apollo.player.action.CMSAction;
import com.tencent.mobileqq.apollo.player.action.CMSAction.Companion.MODE;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/apollo/player/manager/CMSBornPlayerManager$recordActionByRecorder$listenerWrapper$1", "Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;", "hasCompleteOrInterrupt", "", "onActionStatusChange", "", "action", "Lcom/tencent/mobileqq/apollo/player/action/CMSAction;", "status", "Lcom/tencent/mobileqq/apollo/player/CMSActionStatus;", "onRecordDone", "success", "recordKey", "", "recordPath", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class amwb
  implements amvk
{
  private boolean jdField_a_of_type_Boolean;
  
  amwb(amvz paramamvz, amvq paramamvq) {}
  
  public void a(@NotNull CMSAction paramCMSAction)
  {
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "action");
    amvl.a(this, paramCMSAction);
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
    anis.a(paramCMSAction.a().toReportFeatureId(), CMSAction.a(paramCMSAction, null, null, 3, null), 1, paramCMSActionStatus.toReportErrorCode(), new Object[0]);
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 1, "recordAction " + paramCMSAction.d() + ", state change, but hasCompleteOrInterrupt skip!!");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 1, "recordAction " + paramCMSAction.d() + " state change to " + paramCMSActionStatus);
    if ((paramCMSActionStatus == CMSActionStatus.INTERRUPT) || (paramCMSActionStatus == CMSActionStatus.COMPLETE))
    {
      paramCMSAction = (Lock)amvy.a(amvy.a);
      paramCMSAction.lock();
    }
    try
    {
      if (!amvy.a(amvy.a).contains(this.jdField_a_of_type_Amvz)) {
        amvy.a(amvy.a).add(this.jdField_a_of_type_Amvz);
      }
      paramCMSActionStatus = Unit.INSTANCE;
      paramCMSAction.unlock();
      amvy.a(amvy.a, this.jdField_a_of_type_Amvq);
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
    Lock localLock = (Lock)amvy.a(amvy.a);
    localLock.lock();
    if (paramBoolean) {}
    try
    {
      for (Object localObject1 = CMSActionStatus.COMPLETE;; localObject1 = CMSActionStatus.ERROR_APNG_ENCODE_FAIL)
      {
        a(paramCMSAction, (CMSActionStatus)localObject1);
        amvy.a(amvy.a).remove(this.jdField_a_of_type_Amvz);
        anis.b(paramCMSAction.a().toReportFeatureId(), CMSAction.a(paramCMSAction, null, null, 3, null));
        List localList = (List)amvy.a(amvy.a).remove(paramString1);
        StringBuilder localStringBuilder = new StringBuilder().append("recordAction recordDone ").append(this.jdField_a_of_type_Amvz.a().d()).append(", success:").append(paramBoolean).append(" path:").append(paramString2).append(", listeners size:");
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
          ((amvk)((Iterator)localObject1).next()).a(paramCMSAction, paramBoolean, paramString1, paramString2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amwb
 * JD-Core Version:    0.7.0.1
 */