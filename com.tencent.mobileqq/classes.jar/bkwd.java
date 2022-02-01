import android.app.Activity;
import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.AdProxyImpl;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBannerAdListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ICmdListener;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

class bkwd
  implements AdProxy.ICmdListener
{
  bkwd(bkwb parambkwb, Activity paramActivity) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((!paramBoolean) || (paramJSONObject == null)) {
      if (this.jdField_a_of_type_Bkwb.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBannerAdListener != null) {
        this.jdField_a_of_type_Bkwb.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBannerAdListener.onNoAD(1000, PluginConst.AdConst.ERROR_MSG_SERVICE_FAIL);
      }
    }
    int i;
    String str;
    label322:
    label333:
    label362:
    do
    {
      do
      {
        return;
        for (;;)
        {
          try
          {
            i = paramJSONObject.getInt("retCode");
            str = paramJSONObject.getString("errMsg");
            paramJSONObject = paramJSONObject.getString("response");
            if ((i != 0) || (TextUtils.isEmpty(paramJSONObject))) {
              break label362;
            }
            str = AdProxyImpl.a(this.jdField_a_of_type_Bkwb.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl, paramJSONObject);
            paramJSONObject = null;
            if (!TextUtils.isEmpty(str)) {
              paramJSONObject = AdProxyImpl.a(this.jdField_a_of_type_Bkwb.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl, str);
            }
            if (paramJSONObject == null) {
              break label322;
            }
            GdtAd localGdtAd = new GdtAd(paramJSONObject);
            acoo.a().a(localGdtAd);
            this.jdField_a_of_type_Bkwb.i = paramJSONObject.report_info.exposure_url.get();
            this.jdField_a_of_type_Bkwb.jdField_a_of_type_Long = paramJSONObject.report_info.trace_info.aid.get();
            this.jdField_a_of_type_Bkwb.jdField_a_of_type_Acpm = bkwb.a(this.jdField_a_of_type_Bkwb, this.jdField_a_of_type_AndroidAppActivity, paramJSONObject, this.jdField_a_of_type_Bkwb.d, this.jdField_a_of_type_Bkwb.e, this.jdField_a_of_type_Bkwb.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext);
            this.jdField_a_of_type_Bkwb.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo = paramJSONObject;
            if (this.jdField_a_of_type_Bkwb.jdField_a_of_type_Acpm == null) {
              break label333;
            }
            if (this.jdField_a_of_type_Bkwb.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBannerAdListener != null)
            {
              this.jdField_a_of_type_Bkwb.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBannerAdListener.onADReceive();
              AdProxyImpl.a(this.jdField_a_of_type_Bkwb.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl, this.jdField_a_of_type_Bkwb.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext, paramJSONObject);
            }
            AdProxyImpl.a(this.jdField_a_of_type_Bkwb.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl, str, this.jdField_a_of_type_Bkwb.b);
            return;
          }
          catch (JSONException paramJSONObject)
          {
            QLog.e("AdProxyImpl", 1, "loadAD, err", paramJSONObject);
          }
          if (this.jdField_a_of_type_Bkwb.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBannerAdListener == null) {
            break;
          }
          this.jdField_a_of_type_Bkwb.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBannerAdListener.onNoAD(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
          return;
          QLog.e("AdProxyImpl", 1, "adInfo is null");
        }
      } while (this.jdField_a_of_type_Bkwb.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBannerAdListener == null);
      this.jdField_a_of_type_Bkwb.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBannerAdListener.onNoAD(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
      return;
    } while (this.jdField_a_of_type_Bkwb.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBannerAdListener == null);
    int j = PluginConst.AdConst.getRetCodeByServerResult(i);
    if (j != -1) {
      i = j;
    }
    for (;;)
    {
      this.jdField_a_of_type_Bkwb.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBannerAdListener.onNoAD(i, str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkwd
 * JD-Core Version:    0.7.0.1
 */