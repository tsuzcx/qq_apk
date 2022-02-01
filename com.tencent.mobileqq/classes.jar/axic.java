import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/PushUtil;", "", "()V", "INVALID_MAIN_BUSINESS_ID", "", "KEY_MAIN_BUSINESS_ID", "", "KEY_PUSH_ID", "KEY_SUB_BUSINESS_ID", "addBrowserIntent", "", "intent", "Landroid/content/Intent;", "pushComponent", "Lcom/tencent/mobileqq/notification/modularize/PushComponent;", "getBitmapFromUrl", "Landroid/graphics/Bitmap;", "iconUrl", "reportAdBoss", "selfUin", "actionId", "pushId", "reportPushClick", "mainBusinessId", "subBusinessId", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class axic
{
  public static final axic a = new axic();
  
  @JvmStatic
  public static final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 != -1)
    {
      bcef.b(null, "dc00898", "", "", "0X800AE74", "0X800AE74", paramInt1, 0, String.valueOf(paramInt2), String.valueOf(paramInt3), "", "");
      localObject1 = BaseApplicationImpl.getApplication();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplicationImpl.getApplication()");
      localObject2 = ((BaseApplicationImpl)localObject1).getRuntime();
      localObject1 = a;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "runtime");
      localObject2 = ((AppRuntime)localObject2).getAccount();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "runtime.account");
      ((axic)localObject1).a((String)localObject2, 118, String.valueOf(paramInt3));
    }
    while (!QLog.isColorLevel())
    {
      Object localObject1;
      Object localObject2;
      return;
    }
    QLog.d("PushUtil", 2, new Object[] { "reportPushClick: called. ", "no need report mainBusinessId: " + paramInt1 });
  }
  
  @JvmStatic
  public static final void a(@NotNull Intent paramIntent, @NotNull axib paramaxib)
  {
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    Intrinsics.checkParameterIsNotNull(paramaxib, "pushComponent");
    paramIntent.putExtra("KEY_MAIN_BUSINESS_ID", paramaxib.jdField_a_of_type_Int);
    paramIntent.putExtra("KEY_SUB_BUSINESS_ID", paramaxib.b);
    paramIntent.putExtra("KEY_PUSH_ID", paramaxib.c);
  }
  
  @Nullable
  public final Bitmap a(@Nullable String paramString)
  {
    return avre.a(paramString);
  }
  
  public final void a(@NotNull String paramString1, int paramInt, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "selfUin");
    Intrinsics.checkParameterIsNotNull(paramString2, "pushId");
    blbx localblbx = new blbx();
    long l = System.currentTimeMillis() / 1000;
    localblbx.b = (paramString1 + '_' + l);
    localblbx.d = paramInt;
    localblbx.jdField_e_of_type_Int = 1;
    localblbx.g = paramString2;
    localblbx.jdField_a_of_type_Long = l;
    localblbx.jdField_a_of_type_Int = 1;
    localblbx.jdField_e_of_type_JavaLangString = "vab_push";
    localblbx.f = "vab_push";
    localblbx.i = "";
    blbw.a().a(localblbx);
    if (QLog.isColorLevel()) {
      QLog.d("PushUtil", 2, new Object[] { "reportAdBoss: called. ", "pushId: " + paramString2 + "  actionId: " + paramInt });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axic
 * JD-Core Version:    0.7.0.1
 */