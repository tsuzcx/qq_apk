import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/business/NativeUiJumpScheme;", "Lcom/tencent/mobileqq/notification/modularize/BaseJumpScheme;", "()V", "customJumpIntent", "Landroid/app/PendingIntent;", "pushComponent", "Lcom/tencent/mobileqq/notification/modularize/PushComponent;", "nativeUiIntent", "needCustomJump", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class aycj
  extends aybw
{
  @NotNull
  protected PendingIntent a(@NotNull ayca paramayca)
  {
    Intrinsics.checkParameterIsNotNull(paramayca, "pushComponent");
    return e(paramayca);
  }
  
  protected boolean a()
  {
    return true;
  }
  
  @NotNull
  public final PendingIntent e(@NotNull ayca paramayca)
  {
    Intrinsics.checkParameterIsNotNull(paramayca, "pushComponent");
    BaseApplication localBaseApplication = BaseApplication.context;
    Intent localIntent = new Intent((Context)localBaseApplication, NotifyPushSettingActivity.class);
    localIntent.addFlags(268435456);
    paramayca = PendingIntent.getActivity((Context)localBaseApplication, paramayca.d, localIntent, 134217728);
    Intrinsics.checkExpressionValueIsNotNull(paramayca, "PendingIntent.getActivit…tent.FLAG_UPDATE_CURRENT)");
    return paramayca;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aycj
 * JD-Core Version:    0.7.0.1
 */