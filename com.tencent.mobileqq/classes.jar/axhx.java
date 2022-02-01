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
public abstract class axhx
{
  private final PendingIntent e(axib paramaxib)
  {
    BaseApplication localBaseApplication = BaseApplication.context;
    Intent localIntent = new Intent((Context)localBaseApplication, SplashActivity.class);
    localIntent.putExtra("tab_index", MainFragment.b);
    localIntent.putExtra("fragment_id", 1);
    localIntent.setFlags(335544320);
    paramaxib = PendingIntent.getActivity((Context)localBaseApplication, paramaxib.jdField_d_of_type_Int, localIntent, 134217728);
    Intrinsics.checkExpressionValueIsNotNull(paramaxib, "jumpPendingIntent");
    return paramaxib;
  }
  
  @NotNull
  protected abstract PendingIntent a(@NotNull axib paramaxib);
  
  protected boolean a()
  {
    return false;
  }
  
  @NotNull
  public final PendingIntent b(@NotNull axib paramaxib)
  {
    Intrinsics.checkParameterIsNotNull(paramaxib, "pushComponent");
    if (a()) {
      return a(paramaxib);
    }
    return c(paramaxib);
  }
  
  @NotNull
  public final PendingIntent c(@NotNull axib paramaxib)
  {
    Intrinsics.checkParameterIsNotNull(paramaxib, "pushComponent");
    if (Intrinsics.areEqual(paramaxib.jdField_d_of_type_JavaLangString, "")) {
      return e(paramaxib);
    }
    BaseApplication localBaseApplication = BaseApplication.context;
    Intent localIntent = new Intent((Context)localBaseApplication, QQBrowserActivity.class);
    localIntent.putExtra("url", paramaxib.jdField_d_of_type_JavaLangString);
    localIntent.addFlags(268435456);
    axic.a(localIntent, paramaxib);
    localIntent.putExtra("param_notifyid", paramaxib.jdField_d_of_type_Int);
    paramaxib = PendingIntent.getActivity((Context)localBaseApplication, paramaxib.jdField_d_of_type_Int, localIntent, 134217728);
    Intrinsics.checkExpressionValueIsNotNull(paramaxib, "jumpPendingIntent");
    return paramaxib;
  }
  
  @NotNull
  public final PendingIntent d(@NotNull axib paramaxib)
  {
    Intrinsics.checkParameterIsNotNull(paramaxib, "pushComponent");
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramaxib.jdField_d_of_type_JavaLangString));
    localIntent.setFlags(268435456);
    paramaxib = PendingIntent.getActivity((Context)BaseApplication.context, paramaxib.jdField_d_of_type_Int, localIntent, 134217728);
    Intrinsics.checkExpressionValueIsNotNull(paramaxib, "PendingIntent.getActivit…tent.FLAG_UPDATE_CURRENT)");
    return paramaxib;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axhx
 * JD-Core Version:    0.7.0.1
 */