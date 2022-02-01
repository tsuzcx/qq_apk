import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/business/NativeUiJumpScheme;", "Lcom/tencent/mobileqq/notification/modularize/BaseJumpScheme;", "()V", "customJumpIntent", "Landroid/app/PendingIntent;", "pushComponent", "Lcom/tencent/mobileqq/notification/modularize/PushComponent;", "nativeUiIntent", "needCustomJump", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ayvc
  extends ayup
{
  @NotNull
  protected PendingIntent a(@NotNull ayut paramayut)
  {
    Intrinsics.checkParameterIsNotNull(paramayut, "pushComponent");
    return e(paramayut);
  }
  
  protected boolean a()
  {
    return true;
  }
  
  @NotNull
  public final PendingIntent e(@NotNull ayut paramayut)
  {
    Intrinsics.checkParameterIsNotNull(paramayut, "pushComponent");
    BaseApplication localBaseApplication = BaseApplication.context;
    Intent localIntent = new Intent((Context)localBaseApplication, NotifyPushSettingActivity.class);
    localIntent.addFlags(268435456);
    paramayut = PendingIntent.getActivity((Context)localBaseApplication, paramayut.d, localIntent, 134217728);
    Intrinsics.checkExpressionValueIsNotNull(paramayut, "PendingIntent.getActivit…tent.FLAG_UPDATE_CURRENT)");
    return paramayut;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayvc
 * JD-Core Version:    0.7.0.1
 */