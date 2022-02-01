import com.tencent.mobileqq.apollo.player.action.CMSAction;
import com.tencent.mobileqq.apollo.player.action.CMSAction.Companion.MODE;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.app.ThreadManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/player/manager/CMSBornPlayer$CMSRecordListener;", "Lcom/tencent/mobileqq/apollo/screenshot/IApolloActionRecordListener;", "action", "Lcom/tencent/mobileqq/apollo/player/action/CMSAction;", "listener", "Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;", "timeoutRunnable", "Ljava/lang/Runnable;", "(Lcom/tencent/mobileqq/apollo/player/action/CMSAction;Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;Ljava/lang/Runnable;)V", "encodeEnd", "", "success", "", "encodeStart", "getCurrentRecordKey", "", "getTaskId", "", "isFrameRecord", "onRecordEnd", "errorCode", "recordKey", "path", "onRecordStart", "director", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
final class amvw
  implements anbp
{
  private final amvk jdField_a_of_type_Amvk;
  private final CMSAction jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction;
  private final Runnable jdField_a_of_type_JavaLangRunnable;
  
  public amvw(@NotNull CMSAction paramCMSAction, @NotNull amvk paramamvk, @NotNull Runnable paramRunnable)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction = paramCMSAction;
    this.jdField_a_of_type_Amvk = paramamvk;
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction.a().a;
  }
  
  @NotNull
  public String a()
  {
    return CMSAction.a(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction, null, null, 3, null);
  }
  
  public void a()
  {
    anis.a(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction.a().toReportFeatureId(), CMSAction.a(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction, null, null, 3, null), 3);
  }
  
  public void a(int paramInt, @NotNull String paramString1, @Nullable String paramString2)
  {
    boolean bool = true;
    Intrinsics.checkParameterIsNotNull(paramString1, "recordKey");
    anis.a(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction.a().toReportFeatureId(), CMSAction.a(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction, null, null, 3, null), 2, paramInt, new Object[] { paramString2 });
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    amvk localamvk = this.jdField_a_of_type_Amvk;
    CMSAction localCMSAction = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction;
    if (paramInt == 0) {}
    for (;;)
    {
      localamvk.a(localCMSAction, bool, paramString1, paramString2);
      return;
      bool = false;
    }
  }
  
  public void a(long paramLong)
  {
    anis.a(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction.a().toReportFeatureId(), CMSAction.a(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction, null, null, 3, null), 2);
  }
  
  public void a(boolean paramBoolean)
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction.a().toReportFeatureId();
    String str = CMSAction.a(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction, null, null, 3, null);
    if (paramBoolean) {}
    for (int i = 0;; i = -1)
    {
      anis.a(j, str, 3, i, new Object[0]);
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction.a() == CMSAction.Companion.MODE.ACTION_MODE_FRAME;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amvw
 * JD-Core Version:    0.7.0.1
 */