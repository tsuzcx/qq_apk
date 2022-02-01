import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoFragment;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.AdProxyImpl;
import com.tencent.qqmini.proxyimpl.AdProxyImpl.AdResultReceiver;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsRewardVideoAdView;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IRewardVideoAdListener;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.ICommonManager;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class bjcc
  extends AdProxy.AbsRewardVideoAdView
{
  int jdField_a_of_type_Int = 53;
  GdtMotiveVideoPageData jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoPageData;
  IMiniAppContext jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext;
  AdProxy.IRewardVideoAdListener jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener;
  String jdField_a_of_type_JavaLangString;
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  String d;
  String e;
  String f;
  String g;
  String h;
  String i;
  
  public bjcc(AdProxyImpl paramAdProxyImpl, Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, AdProxy.IRewardVideoAdListener paramIRewardVideoAdListener, IMiniAppContext paramIMiniAppContext)
  {
    super(paramAdProxyImpl);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener = paramIRewardVideoAdListener;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.d = paramString3;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.e = paramString4;
    this.f = paramString5;
    this.g = paramString6;
    this.h = paramString7;
    this.i = paramString8;
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext = paramIMiniAppContext;
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdProxyImpl", 2, "onReceiveResult() called with: resultCode = [" + paramInt + "], resultData = [" + paramBundle + "]");
    }
    long l2 = paramBundle.getLong("duration_time");
    long l3 = paramBundle.getLong("elapsed_time");
    boolean bool = paramBundle.getBoolean("profitable_flag", false);
    long l1;
    if (l2 > l3)
    {
      l1 = l3;
      int k = (int)(l1 / 1000L);
      int j = k;
      if (k > 15) {
        j = 15;
      }
      paramBundle = null;
      BaseRuntime localBaseRuntime = AppLoaderFactory.g().getCommonManager().getCurrentRuntime();
      if (localBaseRuntime != null) {
        paramBundle = localBaseRuntime.getMiniAppInfo();
      }
      if (paramBundle == null) {
        break label289;
      }
      paramBundle.gameAdsTotalTime += j;
      QLog.d("AdProxyImpl", 1, "RewardedAd now gameAdsTotalTime = " + paramBundle.gameAdsTotalTime + ", reportTime = " + j);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener != null)
      {
        if ((bool) && (paramInt == -1)) {
          this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener.onReward();
        }
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener.onADClose(this.jdField_a_of_type_JavaLangString);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AdProxyImpl", 1, "RewardedAd ActivityResultListener receive durationTime= " + l2 + " elaspedTime=" + l3 + " profitable=" + bool + ", resultCode = " + paramInt);
      }
      return;
      l1 = l2;
      break;
      label289:
      QLog.d("AdProxyImpl", 1, "RewardedAd miniAppInfo is null");
    }
  }
  
  public void loadAD(Context paramContext)
  {
    if (paramContext == null)
    {
      if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener != null) {
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
      }
      return;
    }
    QLog.i("AdProxyImpl", 1, "reward load");
    this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl.requestAdInfo(paramContext, this.d, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.e, this.f, this.g, this.h, this.i, 1, new bjcd(this));
  }
  
  public void showAD(Context paramContext, String paramString)
  {
    boolean bool = false;
    Object localObject;
    if ((paramContext != null) && ((paramContext instanceof Activity)))
    {
      localObject = (Activity)paramContext;
      if ((paramContext instanceof GameActivity1))
      {
        bool = true;
        paramContext = (Context)localObject;
      }
    }
    for (;;)
    {
      if ((paramContext == null) || (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoPageData == null))
      {
        QLog.d("AdProxyImpl", 1, "data is not GdtMotiveVideoPageData");
        if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener != null) {
          this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
        }
        return;
      }
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoPageData.refId = "biz_src_miniapp";
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoPageData.containerType = 1;
      if ((this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoPageData.vSize == 185) || (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoPageData.vSize == 585)) {}
      for (paramString = new AdProxyImpl.AdResultReceiver(new Handler(Looper.getMainLooper()), this);; paramString = null)
      {
        this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoPageData.antiSpamParams = bjds.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoPageData.adId + "", System.currentTimeMillis(), bool);
        GdtMotiveVideoFragment.a(paramContext, GdtMotiveVideoFragment.class, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoPageData, paramString);
        if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener.onADShow();
        return;
        paramString = new bjbq(this, null);
        localObject = bjbq.a(paramString);
        QLog.i("AdProxyImpl", 1, "mvBrowing dataKey = " + (String)localObject + ", data =" + bjbq.a(paramString));
        if (AdProxyImpl.a() == null) {
          AdProxyImpl.a(new HashMap());
        }
        this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoPageData.motiveBrowsingKey = ((String)localObject);
        AdProxyImpl.a().put(localObject, paramString);
      }
      paramContext = (Context)localObject;
      continue;
      paramContext = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjcc
 * JD-Core Version:    0.7.0.1
 */