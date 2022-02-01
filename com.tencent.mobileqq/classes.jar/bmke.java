import android.app.Activity;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcooperation/vip/VasAdvGdtInterface;", "", "getDeviceInfo", "Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;", "gdtBizId", "", "getDeviceInfoAsJson", "initGdtContext", "", "showMotiveAd", "activity", "Landroid/app/Activity;", "adInfo", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "profitableCallback", "Lcooperation/vip/reward/VasProfitableCallback;", "rewardText", "bizSrc", "vasGdtBizId", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface bmke
{
  @NotNull
  public abstract String a();
  
  @Nullable
  public abstract String a(@NotNull String paramString);
  
  @Nullable
  public abstract qq_ad_get.QQAdGet.DeviceInfo a(@NotNull String paramString);
  
  public abstract void a(@NotNull Activity paramActivity, @NotNull qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, @NotNull bmoi parambmoi, @Nullable String paramString1, @NotNull String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmke
 * JD-Core Version:    0.7.0.1
 */