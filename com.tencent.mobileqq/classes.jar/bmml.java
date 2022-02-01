import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoFragment;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.impl.VasAdvGdtImpl.showMotiveAd.browsingAdReceiver.1;
import cooperation.vip.impl.VasAdvGdtImpl.showMotiveAd.motiveAdReceiver.1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcooperation/vip/impl/VasAdvGdtImpl;", "Lcooperation/vip/VasAdvGdtInterface;", "appInterface", "Lcooperation/vip/VasAdvAppInterface;", "(Lcooperation/vip/VasAdvAppInterface;)V", "convertMotiveAdData", "Lcom/tencent/gdtad/api/motivevideo/GdtMotiveVideoPageData;", "adInfo", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "rewardText", "", "bizSrc", "getDeviceInfo", "Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;", "gdtBizId", "getDeviceInfoAsJson", "initGdtContext", "", "showMotiveAd", "activity", "Landroid/app/Activity;", "profitableCallback", "Lcooperation/vip/reward/VasProfitableCallback;", "vasGdtBizId", "isBrowsingAd", "", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bmml
  implements bmke
{
  public static final bmmm a;
  private final bmkc a;
  
  static
  {
    jdField_a_of_type_Bmmm = new bmmm(null);
  }
  
  public bmml(@NotNull bmkc parambmkc)
  {
    this.jdField_a_of_type_Bmkc = parambmkc;
  }
  
  private final GdtMotiveVideoPageData a(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, String paramString1, String paramString2)
  {
    GdtAd localGdtAd = new GdtAd(paramAdInfo);
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = new GdtMotiveVideoPageData();
    localGdtMotiveVideoPageData.productType = localGdtAd.getProductType();
    localGdtMotiveVideoPageData.vSize = localGdtAd.getCreativeSize();
    localGdtMotiveVideoPageData.screenOrientation = 1;
    localGdtMotiveVideoPageData.adId = localGdtAd.getAdvertiserId();
    localGdtMotiveVideoPageData.vid = localGdtAd.getTencent_video_id();
    localGdtMotiveVideoPageData.url = localGdtAd.getVideoUrl();
    if (!TextUtils.isEmpty((CharSequence)localGdtMotiveVideoPageData.url))
    {
      paramAdInfo = localGdtMotiveVideoPageData.url;
      Intrinsics.checkExpressionValueIsNotNull(paramAdInfo, "url");
      if (StringsKt.startsWith$default(paramAdInfo, "https://", false, 2, null))
      {
        paramAdInfo = localGdtMotiveVideoPageData.url;
        Intrinsics.checkExpressionValueIsNotNull(paramAdInfo, "url");
        paramAdInfo = (CharSequence)paramAdInfo;
        localGdtMotiveVideoPageData.url = new Regex("https://").replaceFirst(paramAdInfo, "http://");
      }
    }
    if (localGdtAd.getImageData() == null)
    {
      paramAdInfo = "";
      localGdtMotiveVideoPageData.previewImgUrl = paramAdInfo;
      localGdtMotiveVideoPageData.bannerImgName = localGdtAd.getAdvertiser_corporate_image_name();
      localGdtMotiveVideoPageData.bannerBaseInfoText = localGdtAd.getText();
      localGdtMotiveVideoPageData.bannerLogo = localGdtAd.getAdvertiser_corporate_logo();
      localGdtMotiveVideoPageData.exposureUrl = localGdtAd.getUrlForImpression();
      localGdtMotiveVideoPageData.appScore = localGdtAd.getAppScore();
      localGdtMotiveVideoPageData.downloadNum = localGdtAd.getAppDownloadNum();
      localGdtMotiveVideoPageData.style = localGdtAd.getStyle();
      localGdtMotiveVideoPageData.endcardUrl = localGdtAd.getEndcardUrl();
      localGdtMotiveVideoPageData.endcardLoadTime = localGdtAd.getEndcardLoadTime();
      paramAdInfo = achn.a((PBField)localGdtAd.info);
      if (paramAdInfo == null) {
        break label334;
      }
      paramAdInfo = paramAdInfo.toString();
      if (paramAdInfo == null) {
        break label334;
      }
    }
    for (;;)
    {
      localGdtMotiveVideoPageData.adsContent = paramAdInfo;
      localGdtMotiveVideoPageData.processId = BaseApplicationImpl.sProcessId;
      localGdtMotiveVideoPageData.refId = paramString2;
      localGdtMotiveVideoPageData.containerType = 1;
      if (paramString1 != null) {
        localGdtMotiveVideoPageData.setRewardText(paramString1);
      }
      return localGdtMotiveVideoPageData;
      paramAdInfo = localGdtAd.getImageData().a;
      break;
      label334:
      paramAdInfo = "";
    }
  }
  
  private final boolean a(@NotNull GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    return (paramGdtMotiveVideoPageData.vSize != 585) && (paramGdtMotiveVideoPageData.vSize != 185);
  }
  
  @NotNull
  public String a()
  {
    return "1018ec";
  }
  
  @Nullable
  public String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "gdtBizId");
    paramString = a(paramString);
    if (paramString != null)
    {
      paramString = achn.a((PBField)paramString);
      if (paramString != null) {
        return paramString.toString();
      }
      return null;
    }
    return null;
  }
  
  @Nullable
  public qq_ad_get.QQAdGet.DeviceInfo a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "gdtBizId");
    try
    {
      Object localObject = new GdtDeviceInfoHelper.Params();
      ((GdtDeviceInfoHelper.Params)localObject).businessIdForAidTicketAndTaidTicket = paramString;
      localObject = GdtDeviceInfoHelper.create(this.jdField_a_of_type_Bmkc.a(), (GdtDeviceInfoHelper.Params)localObject);
      if (localObject != null) {}
      for (localObject = ((GdtDeviceInfoHelper.Result)localObject).deviceInfo; localObject != null; localObject = null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VasAdvGdtImpl", 2, "gdt device info init success, gdtBizId:" + paramString);
        }
        return localObject;
      }
      return null;
    }
    catch (Exception localException)
    {
      QLog.e("VasAdvGdtImpl", 1, "Error when get gdt device info, biz id " + paramString, (Throwable)localException);
    }
  }
  
  public void a(@NotNull Activity paramActivity, @NotNull qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, @NotNull bmoi parambmoi, @Nullable String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramAdInfo, "adInfo");
    Intrinsics.checkParameterIsNotNull(parambmoi, "profitableCallback");
    Intrinsics.checkParameterIsNotNull(paramString2, "bizSrc");
    paramAdInfo = a(paramAdInfo, paramString1, paramString2);
    if (a(paramAdInfo))
    {
      paramAdInfo.motiveBrowsingKey = "cooperation.vip.impl.vas_browsing_ad_action#";
      paramActivity.registerReceiver((BroadcastReceiver)new VasAdvGdtImpl.showMotiveAd.browsingAdReceiver.1(paramActivity, parambmoi), new IntentFilter("cooperation.vip.impl.vas_browsing_ad_action"));
      GdtMotiveVideoFragment.a(paramActivity, GdtMotiveVideoFragment.class, paramAdInfo);
      return;
    }
    paramString1 = new Handler(Looper.getMainLooper());
    GdtMotiveVideoFragment.a(paramActivity, GdtMotiveVideoFragment.class, paramAdInfo, (ResultReceiver)new VasAdvGdtImpl.showMotiveAd.motiveAdReceiver.1(parambmoi, paramString1, paramString1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmml
 * JD-Core Version:    0.7.0.1
 */