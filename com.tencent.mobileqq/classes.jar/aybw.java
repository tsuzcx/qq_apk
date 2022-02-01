import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/BaseJumpScheme;", "", "()V", "customJumpIntent", "Landroid/app/PendingIntent;", "pushComponent", "Lcom/tencent/mobileqq/notification/modularize/PushComponent;", "fallbackJumpIntent", "jumpActionIntent", "jumpIntent", "jumpMsgTabIntent", "needCustomJump", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract class aybw
{
  private final PendingIntent e(ayca paramayca)
  {
    BaseApplication localBaseApplication = BaseApplication.context;
    Intent localIntent = new Intent((Context)localBaseApplication, SplashActivity.class);
    localIntent.putExtra("tab_index", MainFragment.b);
    localIntent.putExtra("fragment_id", 1);
    localIntent.setFlags(335544320);
    paramayca = PendingIntent.getActivity((Context)localBaseApplication, paramayca.jdField_d_of_type_Int, localIntent, 134217728);
    Intrinsics.checkExpressionValueIsNotNull(paramayca, "jumpPendingIntent");
    return paramayca;
  }
  
  @NotNull
  protected abstract PendingIntent a(@NotNull ayca paramayca);
  
  protected boolean a()
  {
    return false;
  }
  
  @NotNull
  public final PendingIntent b(@NotNull ayca paramayca)
  {
    Intrinsics.checkParameterIsNotNull(paramayca, "pushComponent");
    if (a()) {
      return a(paramayca);
    }
    return c(paramayca);
  }
  
  @NotNull
  public final PendingIntent c(@NotNull ayca paramayca)
  {
    Intrinsics.checkParameterIsNotNull(paramayca, "pushComponent");
    if (Intrinsics.areEqual(paramayca.jdField_d_of_type_JavaLangString, "")) {
      return e(paramayca);
    }
    BaseApplication localBaseApplication = BaseApplication.context;
    Intent localIntent = new Intent((Context)localBaseApplication, QQBrowserActivity.class);
    localIntent.putExtra("url", paramayca.jdField_d_of_type_JavaLangString);
    localIntent.addFlags(268435456);
    aycb.a(localIntent, paramayca);
    localIntent.putExtra("param_notifyid", paramayca.jdField_d_of_type_Int);
    paramayca = PendingIntent.getActivity((Context)localBaseApplication, paramayca.jdField_d_of_type_Int, localIntent, 134217728);
    Intrinsics.checkExpressionValueIsNotNull(paramayca, "jumpPendingIntent");
    return paramayca;
  }
  
  @NotNull
  public final PendingIntent d(@NotNull ayca paramayca)
  {
    Intrinsics.checkParameterIsNotNull(paramayca, "pushComponent");
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramayca.jdField_d_of_type_JavaLangString));
    localIntent.setFlags(268435456);
    paramayca = PendingIntent.getActivity((Context)BaseApplication.context, paramayca.jdField_d_of_type_Int, localIntent, 134217728);
    Intrinsics.checkExpressionValueIsNotNull(paramayca, "PendingIntent.getActivit…tent.FLAG_UPDATE_CURRENT)");
    return paramayca;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aybw
 * JD-Core Version:    0.7.0.1
 */