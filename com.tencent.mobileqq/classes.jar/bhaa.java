import android.content.Context;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.minigame.ui.MiniGameAdBannerPopup;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public final class bhaa
  implements AsyncResult
{
  public bhaa(WeakReference paramWeakReference, String paramString, int paramInt) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean) {}
    try
    {
      TianShuAccess.GetAdsRsp localGetAdsRsp = (TianShuAccess.GetAdsRsp)paramJSONObject.get("response");
      QMLog.d("MiniGameAdBannerPopup", "onGetAdvs() called with: result = [" + paramJSONObject + "], getAdsRsp = [" + localGetAdsRsp + "]");
      if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
        return;
      }
      MiniGameAdBannerPopup.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, paramBoolean, localGetAdsRsp);
      return;
    }
    catch (Exception paramJSONObject)
    {
      QMLog.e("MiniGameAdBannerPopup", "tianshuRequestAdv onReceiveResult", paramJSONObject);
    }
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      MiniGameAdBannerPopup.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, paramBoolean, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhaa
 * JD-Core Version:    0.7.0.1
 */