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
public abstract class ayup
{
  private final PendingIntent e(ayut paramayut)
  {
    BaseApplication localBaseApplication = BaseApplication.context;
    Intent localIntent = new Intent((Context)localBaseApplication, SplashActivity.class);
    localIntent.putExtra("tab_index", MainFragment.b);
    localIntent.putExtra("fragment_id", 1);
    localIntent.setFlags(335544320);
    paramayut = PendingIntent.getActivity((Context)localBaseApplication, paramayut.jdField_d_of_type_Int, localIntent, 134217728);
    Intrinsics.checkExpressionValueIsNotNull(paramayut, "jumpPendingIntent");
    return paramayut;
  }
  
  @NotNull
  protected abstract PendingIntent a(@NotNull ayut paramayut);
  
  protected boolean a()
  {
    return false;
  }
  
  @NotNull
  public final PendingIntent b(@NotNull ayut paramayut)
  {
    Intrinsics.checkParameterIsNotNull(paramayut, "pushComponent");
    if (a()) {
      return a(paramayut);
    }
    return c(paramayut);
  }
  
  @NotNull
  public final PendingIntent c(@NotNull ayut paramayut)
  {
    Intrinsics.checkParameterIsNotNull(paramayut, "pushComponent");
    if (Intrinsics.areEqual(paramayut.jdField_d_of_type_JavaLangString, "")) {
      return e(paramayut);
    }
    BaseApplication localBaseApplication = BaseApplication.context;
    Intent localIntent = new Intent((Context)localBaseApplication, QQBrowserActivity.class);
    localIntent.putExtra("url", paramayut.jdField_d_of_type_JavaLangString);
    localIntent.addFlags(268435456);
    ayuu.a(localIntent, paramayut);
    localIntent.putExtra("param_notifyid", paramayut.jdField_d_of_type_Int);
    paramayut = PendingIntent.getActivity((Context)localBaseApplication, paramayut.jdField_d_of_type_Int, localIntent, 134217728);
    Intrinsics.checkExpressionValueIsNotNull(paramayut, "jumpPendingIntent");
    return paramayut;
  }
  
  @NotNull
  public final PendingIntent d(@NotNull ayut paramayut)
  {
    Intrinsics.checkParameterIsNotNull(paramayut, "pushComponent");
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramayut.jdField_d_of_type_JavaLangString));
    localIntent.setFlags(268435456);
    paramayut = PendingIntent.getActivity((Context)BaseApplication.context, paramayut.jdField_d_of_type_Int, localIntent, 134217728);
    Intrinsics.checkExpressionValueIsNotNull(paramayut, "PendingIntent.getActivit…tent.FLAG_UPDATE_CURRENT)");
    return paramayut;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayup
 * JD-Core Version:    0.7.0.1
 */