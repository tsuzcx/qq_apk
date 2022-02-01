import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.banner.GdtBannerAd;
import com.tencent.gdtad.statistics.GdtDwellTimeStatisticsAfterClick;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.AdProxyImpl;
import com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKBannerAdView.4;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.MiniAdPosInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBannerAdView;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBannerAdListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.IGetAdPosInfo;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class bkwb
  extends AdProxy.AbsBannerAdView
{
  int jdField_a_of_type_Int = 53;
  long jdField_a_of_type_Long;
  acos jdField_a_of_type_Acos;
  acpm jdField_a_of_type_Acpm;
  public AdExposureChecker.ExposureCallback a;
  GdtBannerAd jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd;
  IMiniAppContext jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext;
  AdProxy.IBannerAdListener jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBannerAdListener;
  public IGetAdPosInfo a;
  String jdField_a_of_type_JavaLangString;
  WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  public ArrayList<AdExposureChecker> a;
  protected qq_ad_get.QQAdGetRsp.AdInfo a;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  int jdField_d_of_type_Int;
  String jdField_d_of_type_JavaLangString;
  int jdField_e_of_type_Int;
  String jdField_e_of_type_JavaLangString;
  String f;
  String g;
  String h;
  String i;
  
  public bkwb(AdProxyImpl paramAdProxyImpl, Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt3, int paramInt4, AdProxy.IBannerAdListener paramIBannerAdListener, IMiniAppContext paramIMiniAppContext, IGetAdPosInfo paramIGetAdPosInfo)
  {
    super(paramAdProxyImpl);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBannerAdListener = paramIBannerAdListener;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_d_of_type_JavaLangString = paramString4;
    this.jdField_e_of_type_JavaLangString = paramString5;
    this.f = paramString6;
    this.g = paramString7;
    this.h = paramString8;
    this.jdField_d_of_type_Int = paramInt3;
    this.jdField_e_of_type_Int = paramInt4;
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext = paramIMiniAppContext;
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyIGetAdPosInfo = paramIGetAdPosInfo;
    a(paramActivity);
  }
  
  private acpm a(Activity paramActivity, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, int paramInt1, int paramInt2, IMiniAppContext paramIMiniAppContext)
  {
    QLog.i("AdProxyImpl", 1, "createBannerAdView width = " + paramInt1 + ", height = " + paramInt2);
    if ((paramAdInfo == null) || (paramActivity == null)) {
      return null;
    }
    try
    {
      QLog.i("AdProxyImpl", 1, "createBannerAd");
      acpl localacpl = new acpl();
      localacpl.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = AdProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl, paramActivity, paramAdInfo, paramIMiniAppContext);
      localacpl.jdField_a_of_type_Int = 0;
      localacpl.jdField_b_of_type_Int = paramInt1;
      localacpl.jdField_c_of_type_Int = paramInt2;
      this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd = new GdtBannerAd(localacpl);
      paramActivity = this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd.render(paramActivity, paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd.setListener(new WeakReference(this.jdField_a_of_type_Acos));
      if (paramActivity != null)
      {
        localacpl.jdField_a_of_type_ComTencentGdtadStatisticsGdtDwellTimeStatisticsAfterClick = new GdtDwellTimeStatisticsAfterClick(new GdtAd(paramAdInfo), new WeakReference(paramActivity.a()));
        return paramActivity;
      }
    }
    catch (Exception paramActivity)
    {
      QLog.e("AdProxyImpl", 1, "createBannerAd, error", paramActivity);
      return null;
    }
    QLog.e("AdProxyImpl", 1, "build Ad error");
    return paramActivity;
  }
  
  private String a(MiniAdPosInfo paramMiniAdPosInfo)
  {
    if (paramMiniAdPosInfo == null) {
      return "";
    }
    int j = paramMiniAdPosInfo.left;
    int k = paramMiniAdPosInfo.top;
    int m = paramMiniAdPosInfo.width;
    int n = paramMiniAdPosInfo.height;
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("px", String.valueOf(j));
      ((JSONObject)localObject).put("py", String.valueOf(k));
      ((JSONObject)localObject).put("da", String.valueOf(m));
      ((JSONObject)localObject).put("db", String.valueOf(n));
      localObject = "s=" + URLEncoder.encode(((JSONObject)localObject).toString(), "utf-8");
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("AdProxyImpl", 1, "getBannerExtraReportParams error", localJSONException);
      QLog.i("AdProxyImpl", 1, "getBannerExtraReportParams = " + paramMiniAdPosInfo);
      return "";
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        QLog.e("AdProxyImpl", 1, "getBannerExtraReportParams error", localUnsupportedEncodingException);
      }
    }
  }
  
  private void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_Acos == null) {
      this.jdField_a_of_type_Acos = new bkwc(this, paramActivity);
    }
  }
  
  private void a(String paramString)
  {
    ThreadManager.executeOnNetWorkThread(new AdProxyImpl.SDKBannerAdView.4(this, paramString));
  }
  
  private void a(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, View paramView)
  {
    if ((paramAdInfo == null) || (paramView == null)) {
      QLog.i("AdProxyImpl", 1, "initAdExposureChecker null");
    }
    while (!AdUtils.isHitReport50ViewAndOneSecond(new GdtAd(paramAdInfo))) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    paramAdInfo = new AdExposureChecker(new GdtAd(paramAdInfo), new WeakReference(paramView));
    if (this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback == null) {
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = new bkwe(this);
    }
    paramAdInfo.setCallback(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback));
    this.jdField_a_of_type_JavaUtilArrayList.add(paramAdInfo);
    paramAdInfo.startCheck();
    QLog.i("AdProxyImpl", 1, "startonExposure");
  }
  
  public void destroy(Context paramContext)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      paramContext = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramContext.hasNext())
      {
        AdExposureChecker localAdExposureChecker = (AdExposureChecker)paramContext.next();
        localAdExposureChecker.onActivityDestroy();
        localAdExposureChecker.setCallback(null);
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = null;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBannerAdListener = null;
    this.jdField_a_of_type_Acpm = null;
    this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo = null;
    this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd = null;
  }
  
  public long getAdID()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String getReportUrl()
  {
    return this.i;
  }
  
  public View getView()
  {
    if (this.jdField_a_of_type_Acpm != null) {
      return this.jdField_a_of_type_Acpm.a();
    }
    return null;
  }
  
  public void loadAD()
  {
    Object localObject;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localObject = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null) {
        break label92;
      }
      localObject = new StringBuilder().append("loadAD, act is null, ");
      if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBannerAdListener == null) {
        break label87;
      }
    }
    label87:
    for (boolean bool = true;; bool = false)
    {
      QLog.e("AdProxyImpl", 1, bool);
      if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBannerAdListener != null) {
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBannerAdListener.onNoAD(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
      }
      return;
      localObject = null;
      break;
    }
    label92:
    this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl.requestAdInfo((Context)localObject, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.f, this.g, this.h, 1, new bkwd(this, (Activity)localObject));
  }
  
  public void onExposure()
  {
    if (AdUtils.isHitReport50ViewAndOneSecond(new GdtAd(this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo))) {
      a(this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo, getView());
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.i)) {
        bkxw.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext, this.i, System.currentTimeMillis());
      }
      this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd.onDisplay();
      return;
      a(this.i);
    }
  }
  
  public void pause(Context paramContext)
  {
    if (this.jdField_a_of_type_Acpm != null) {
      this.jdField_a_of_type_Acpm.a(paramContext);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      paramContext = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramContext.hasNext())
      {
        AdExposureChecker localAdExposureChecker = (AdExposureChecker)paramContext.next();
        if (localAdExposureChecker != null) {
          localAdExposureChecker.onActivityPause();
        }
      }
    }
  }
  
  public void resume(Context paramContext)
  {
    if (this.jdField_a_of_type_Acpm != null) {
      this.jdField_a_of_type_Acpm.b(paramContext);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      paramContext = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramContext.hasNext())
      {
        AdExposureChecker localAdExposureChecker = (AdExposureChecker)paramContext.next();
        if (localAdExposureChecker != null) {
          localAdExposureChecker.onActivityResume();
        }
      }
    }
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Acpm != null) {
      this.jdField_a_of_type_Acpm.setSize(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkwb
 * JD-Core Version:    0.7.0.1
 */