import android.app.Activity;
import android.content.Context;
import cooperation.vip.VasAdvSupport.Companion.instance.2;
import cooperation.vip.VasAdvSupport.initDeviceInfo.1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcooperation/vip/VasAdvSupport;", "Lcooperation/vip/VasAdvAppInterface;", "Lcooperation/vip/VasAdvGdtInterface;", "app", "gdt", "(Lcooperation/vip/VasAdvAppInterface;Lcooperation/vip/VasAdvGdtInterface;)V", "account", "", "context", "Landroid/content/Context;", "execute", "", "runnable", "Ljava/lang/Runnable;", "getDeviceInfo", "Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;", "gdtBizId", "", "getDeviceInfoAsJson", "initDeviceInfo", "initGdtContext", "sendCmd", "cmd", "cmdKey", "reqBytes", "", "callback", "Lcooperation/vip/VasAdvCallback;", "showMotiveAd", "activity", "Landroid/app/Activity;", "adInfo", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "profitableCallback", "Lcooperation/vip/reward/VasProfitableCallback;", "rewardText", "bizSrc", "vasGdtBizId", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bmkk
  implements bmkc, bmke
{
  public static final bmkl a;
  private static final Lazy jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)VasAdvSupport.Companion.instance.2.INSTANCE);
  private final bmkc jdField_a_of_type_Bmkc;
  private final bmke jdField_a_of_type_Bmke;
  
  static
  {
    jdField_a_of_type_Bmkl = new bmkl(null);
  }
  
  private bmkk(bmkc parambmkc, bmke parambmke)
  {
    this.jdField_a_of_type_Bmkc = parambmkc;
    this.jdField_a_of_type_Bmke = parambmke;
    a(a());
  }
  
  @JvmStatic
  @NotNull
  public static final bmkk a()
  {
    return jdField_a_of_type_Bmkl.a();
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Bmkc.a();
  }
  
  @NotNull
  public Context a()
  {
    return this.jdField_a_of_type_Bmkc.a();
  }
  
  @NotNull
  public String a()
  {
    return this.jdField_a_of_type_Bmke.a();
  }
  
  @Nullable
  public String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "gdtBizId");
    return this.jdField_a_of_type_Bmke.a(paramString);
  }
  
  @Nullable
  public qq_ad_get.QQAdGet.DeviceInfo a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "gdtBizId");
    return this.jdField_a_of_type_Bmke.a(paramString);
  }
  
  public void a(@NotNull Activity paramActivity, @NotNull qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, @NotNull bmoi parambmoi, @Nullable String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramAdInfo, "adInfo");
    Intrinsics.checkParameterIsNotNull(parambmoi, "profitableCallback");
    Intrinsics.checkParameterIsNotNull(paramString2, "bizSrc");
    this.jdField_a_of_type_Bmke.a(paramActivity, paramAdInfo, parambmoi, paramString1, paramString2);
  }
  
  public void a(@NotNull Runnable paramRunnable)
  {
    Intrinsics.checkParameterIsNotNull(paramRunnable, "runnable");
    this.jdField_a_of_type_Bmkc.a(paramRunnable);
  }
  
  public final void a(@Nullable String paramString)
  {
    this.jdField_a_of_type_Bmkc.a((Runnable)new VasAdvSupport.initDeviceInfo.1(this, paramString));
  }
  
  public void a(@NotNull String paramString1, @NotNull String paramString2, @NotNull byte[] paramArrayOfByte, @NotNull bmkd parambmkd)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "cmd");
    Intrinsics.checkParameterIsNotNull(paramString2, "cmdKey");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "reqBytes");
    Intrinsics.checkParameterIsNotNull(parambmkd, "callback");
    this.jdField_a_of_type_Bmkc.a(paramString1, paramString2, paramArrayOfByte, parambmkd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmkk
 * JD-Core Version:    0.7.0.1
 */