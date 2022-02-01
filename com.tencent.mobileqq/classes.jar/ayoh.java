import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.tianshu.TianShuManager;
import cooperation.vip.tianshu.TianShuReportData;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/PushUtil;", "", "()V", "INVALID_MAIN_BUSINESS_ID", "", "KEY_MAIN_BUSINESS_ID", "", "KEY_PUSH_ID", "KEY_SUB_BUSINESS_ID", "addBrowserIntent", "", "intent", "Landroid/content/Intent;", "pushComponent", "Lcom/tencent/mobileqq/notification/modularize/PushComponent;", "getBitmapFromUrl", "Landroid/graphics/Bitmap;", "iconUrl", "reportAdBoss", "selfUin", "actionId", "pushId", "reportPushClick", "mainBusinessId", "subBusinessId", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ayoh
{
  public static final ayoh a = new ayoh();
  
  @JvmStatic
  public static final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 != -1)
    {
      bdla.b(null, "dc00898", "", "", "0X800AE74", "0X800AE74", paramInt1, 0, String.valueOf(paramInt2), String.valueOf(paramInt3), "", "");
      localObject1 = BaseApplicationImpl.getApplication();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplicationImpl.getApplication()");
      localObject2 = ((BaseApplicationImpl)localObject1).getRuntime();
      localObject1 = a;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "runtime");
      localObject2 = ((AppRuntime)localObject2).getAccount();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "runtime.account");
      ((ayoh)localObject1).a((String)localObject2, 118, String.valueOf(paramInt3));
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
  public static final void a(@NotNull Intent paramIntent, @NotNull ayog paramayog)
  {
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    Intrinsics.checkParameterIsNotNull(paramayog, "pushComponent");
    paramIntent.putExtra("KEY_MAIN_BUSINESS_ID", paramayog.a);
    paramIntent.putExtra("KEY_SUB_BUSINESS_ID", paramayog.b);
    paramIntent.putExtra("KEY_PUSH_ID", paramayog.c);
  }
  
  @Nullable
  public final Bitmap a(@Nullable String paramString)
  {
    return awxj.a(paramString);
  }
  
  public final void a(@NotNull String paramString1, int paramInt, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "selfUin");
    Intrinsics.checkParameterIsNotNull(paramString2, "pushId");
    TianShuReportData localTianShuReportData = new TianShuReportData();
    long l = System.currentTimeMillis() / 1000;
    localTianShuReportData.mTraceId = (paramString1 + '_' + l);
    localTianShuReportData.mActionId = paramInt;
    localTianShuReportData.mActionValue = 1;
    localTianShuReportData.mItemId = paramString2;
    localTianShuReportData.mOperTime = l;
    localTianShuReportData.mTraceNum = 1;
    localTianShuReportData.mAppId = "vab_push";
    localTianShuReportData.mPageId = "vab_push";
    localTianShuReportData.mModuleId = "";
    TianShuManager.getInstance().report(localTianShuReportData);
    if (QLog.isColorLevel()) {
      QLog.d("PushUtil", 2, new Object[] { "reportAdBoss: called. ", "pushId: " + paramString2 + "  actionId: " + paramInt });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayoh
 * JD-Core Version:    0.7.0.1
 */