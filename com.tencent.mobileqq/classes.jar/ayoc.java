import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/BaseJumpScheme;", "", "()V", "customJumpIntent", "Landroid/app/PendingIntent;", "pushComponent", "Lcom/tencent/mobileqq/notification/modularize/PushComponent;", "fallbackJumpIntent", "jumpActionIntent", "jumpIntent", "jumpMsgTabIntent", "needCustomJump", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract class ayoc
{
  private final PendingIntent e(ayog paramayog)
  {
    BaseApplication localBaseApplication = BaseApplication.context;
    Intent localIntent = new Intent((Context)localBaseApplication, SplashActivity.class);
    localIntent.putExtra("tab_index", MainFragment.b);
    localIntent.putExtra("fragment_id", 1);
    localIntent.setFlags(335544320);
    paramayog = PendingIntent.getActivity((Context)localBaseApplication, paramayog.jdField_d_of_type_Int, localIntent, 134217728);
    Intrinsics.checkExpressionValueIsNotNull(paramayog, "jumpPendingIntent");
    return paramayog;
  }
  
  @NotNull
  protected abstract PendingIntent a(@NotNull ayog paramayog);
  
  protected boolean a()
  {
    return false;
  }
  
  @NotNull
  public final PendingIntent b(@NotNull ayog paramayog)
  {
    Intrinsics.checkParameterIsNotNull(paramayog, "pushComponent");
    if (a()) {
      return a(paramayog);
    }
    return c(paramayog);
  }
  
  @NotNull
  public final PendingIntent c(@NotNull ayog paramayog)
  {
    Intrinsics.checkParameterIsNotNull(paramayog, "pushComponent");
    if (Intrinsics.areEqual(paramayog.jdField_d_of_type_JavaLangString, "")) {
      return e(paramayog);
    }
    BaseApplication localBaseApplication = BaseApplication.context;
    Intent localIntent = new Intent((Context)localBaseApplication, QQBrowserActivity.class);
    localIntent.putExtra("url", paramayog.jdField_d_of_type_JavaLangString);
    localIntent.addFlags(268435456);
    ayoh.a(localIntent, paramayog);
    localIntent.putExtra("param_notifyid", paramayog.jdField_d_of_type_Int);
    paramayog = PendingIntent.getActivity((Context)localBaseApplication, paramayog.jdField_d_of_type_Int, localIntent, 134217728);
    Intrinsics.checkExpressionValueIsNotNull(paramayog, "jumpPendingIntent");
    return paramayog;
  }
  
  @NotNull
  public final PendingIntent d(@NotNull ayog paramayog)
  {
    Intrinsics.checkParameterIsNotNull(paramayog, "pushComponent");
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramayog.jdField_d_of_type_JavaLangString));
    localIntent.setFlags(268435456);
    paramayog = PendingIntent.getActivity((Context)BaseApplication.context, paramayog.jdField_d_of_type_Int, localIntent, 134217728);
    Intrinsics.checkExpressionValueIsNotNull(paramayog, "PendingIntent.getActivit…tent.FLAG_UPDATE_CURRENT)");
    return paramayog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayoc
 * JD-Core Version:    0.7.0.1
 */