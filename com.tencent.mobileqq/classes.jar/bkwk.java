import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler.Options;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.AdProxyImpl;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsInterstitialAdView;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.InterstitialADLisener;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class bkwk
  extends AdProxy.AbsInterstitialAdView
{
  int jdField_a_of_type_Int = 53;
  acqa jdField_a_of_type_Acqa;
  AdProxy.InterstitialADLisener jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$InterstitialADLisener;
  String jdField_a_of_type_JavaLangString;
  WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  String d;
  String e;
  String f;
  String g;
  String h;
  
  public bkwk(AdProxyImpl paramAdProxyImpl, Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, AdProxy.InterstitialADLisener paramInterstitialADLisener)
  {
    super(paramAdProxyImpl);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$InterstitialADLisener = paramInterstitialADLisener;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramString6;
    this.g = paramString7;
    this.h = paramString8;
  }
  
  private GdtHandler.Options a(JSONObject paramJSONObject)
  {
    Object localObject = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(acvb.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramJSONObject));
    paramJSONObject = new GdtHandler.Options();
    paramJSONObject.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject);
    paramJSONObject.jdField_a_of_type_Boolean = true;
    paramJSONObject.b = true;
    localObject = new Bundle();
    ((Bundle)localObject).putString("big_brother_ref_source_key", "biz_src_miniapp");
    paramJSONObject.jdField_a_of_type_AndroidOsBundle = ((Bundle)localObject);
    return paramJSONObject;
  }
  
  public void destroy()
  {
    this.jdField_a_of_type_Acqa = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$InterstitialADLisener = null;
  }
  
  public void loadAD()
  {
    Object localObject;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localObject = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null) {
        break label91;
      }
      localObject = new StringBuilder().append("loadAD, act is null, ");
      if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$InterstitialADLisener == null) {
        break label86;
      }
    }
    label86:
    for (boolean bool = true;; bool = false)
    {
      QLog.e("AdProxyImpl", 1, bool);
      if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$InterstitialADLisener != null) {
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$InterstitialADLisener.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
      }
      return;
      localObject = null;
      break;
    }
    label91:
    this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl.requestAdInfo((Context)localObject, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.d, this.e, this.f, this.g, this.h, 1, new bkwl(this, (Activity)localObject));
  }
  
  public void onClose(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    try
    {
      if ((this.jdField_a_of_type_Acqa != null) && (paramActivity != null)) {
        this.jdField_a_of_type_Acqa.a(paramActivity, paramInt, paramIntent);
      }
      return;
    }
    catch (Exception paramActivity)
    {
      QLog.e("AdProxyImpl", 1, "onClose", paramActivity);
    }
  }
  
  public boolean show(Activity paramActivity)
  {
    if ((this.jdField_a_of_type_Acqa != null) && (paramActivity != null))
    {
      boolean bool = this.jdField_a_of_type_Acqa.a(paramActivity);
      if ((bool) && (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$InterstitialADLisener != null)) {
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$InterstitialADLisener.onShow();
      }
      return bool;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkwk
 * JD-Core Version:    0.7.0.1
 */