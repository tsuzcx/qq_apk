import NS_MINI_AD.MiniAppAd.StGetAdRsp;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.manager.MiniLoadingAdManager;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.AdProxyImpl;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener;
import org.json.JSONException;
import org.json.JSONObject;

public class bkvx
  implements MiniAppCmdInterface
{
  public bkvx(AdProxyImpl paramAdProxyImpl, String paramString1, String paramString2, AdProxy.ILoadingAdListener paramILoadingAdListener) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QLog.d("MiniLoadingAdManager", 1, "requestPreloadLoadingAd receive isSuc= " + paramBoolean);
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        Object localObject = (MiniAppAd.StGetAdRsp)paramJSONObject.get("response");
        i = paramJSONObject.getInt("retCode");
        String str = paramJSONObject.getString("errMsg");
        localObject = ((MiniAppAd.StGetAdRsp)localObject).strAdsJson.get();
        QLog.d("MiniLoadingAdManager", 1, "requestPreloadLoadingAd receive retCode= " + i + " errMsg=" + str + " adJson=" + (String)localObject);
        if ((i == 0) && (!TextUtils.isEmpty((CharSequence)localObject)))
        {
          MiniLoadingAdManager.downloadAndSaveLoadingAd((String)localObject, this.jdField_a_of_type_JavaLangString, this.b);
          if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$ILoadingAdListener != null) {
            this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$ILoadingAdListener.onPreloadAdReceive(i);
          }
          return;
        }
      }
      catch (JSONException localJSONException) {}
      if (paramJSONObject != null) {}
      for (int i = paramJSONObject.optInt("retCode", -1); this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$ILoadingAdListener != null; i = -1)
      {
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$ILoadingAdListener.onPreloadAdReceive(i);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkvx
 * JD-Core Version:    0.7.0.1
 */