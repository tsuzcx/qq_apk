import com.tencent.mobileqq.apollo.player.CMSActionStatus;
import com.tencent.mobileqq.apollo.player.CMSPlayer.getFrameImage.1;
import com.tencent.mobileqq.apollo.player.action.CMSAction;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/apollo/player/CMSPlayer$getFrameImage$1$listener$1", "Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;", "onRecordDone", "", "action", "Lcom/tencent/mobileqq/apollo/player/action/CMSAction;", "success", "", "recordKey", "", "recordPath", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class amvi
  implements amvk
{
  public amvi(long paramLong, String paramString) {}
  
  public void a(@NotNull CMSAction paramCMSAction)
  {
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "action");
    amvl.a(this, paramCMSAction);
  }
  
  public void a(@NotNull CMSAction paramCMSAction, @NotNull CMSActionStatus paramCMSActionStatus)
  {
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "action");
    Intrinsics.checkParameterIsNotNull(paramCMSActionStatus, "status");
    amvl.a(this, paramCMSAction, paramCMSActionStatus);
  }
  
  public void a(@NotNull CMSAction paramCMSAction, boolean paramBoolean, @NotNull String paramString1, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "action");
    Intrinsics.checkParameterIsNotNull(paramString1, "recordKey");
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    QLog.w("cmshow_scripted_[CMSPlayer]", 1, "getFrameImage result, " + paramCMSAction.d() + ", success:" + paramBoolean + ", path:" + paramString2 + ", costTime:" + (l1 - l2));
    paramCMSAction = amve.a;
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerCMSPlayer$getFrameImage$1.$callback.a(paramBoolean, paramString2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amvi
 * JD-Core Version:    0.7.0.1
 */