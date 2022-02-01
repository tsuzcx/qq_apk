import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.identification.IdentificationPoseReflect.5.1;
import com.tencent.mobileqq.identification.IdentificationPoseReflect.5.2;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitFrameworkEventListener;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser;
import java.util.HashMap;
import org.json.JSONObject;

public class aukm
  implements YtSDKKitFramework.IYtSDKKitFrameworkEventListener
{
  aukm(aukk paramaukk) {}
  
  public void onFrameworkEvent(HashMap<String, Object> paramHashMap)
  {
    aukk.a(this.a, new IdentificationPoseReflect.5.1(this, paramHashMap));
  }
  
  public void onNetworkRequestEvent(String paramString1, String paramString2, HashMap<String, String> paramHashMap, YtSDKKitFramework.IYtSDKKitNetResponseParser paramIYtSDKKitNetResponseParser)
  {
    paramHashMap = aukt.a().a(5);
    if (paramHashMap == null) {
      QLog.e("qq_Identification.Model", 1, "post face data error : config is empty");
    }
    do
    {
      return;
      paramHashMap = paramHashMap.optString("result_api_url", "");
      if (TextUtils.isEmpty(paramHashMap))
      {
        QLog.e("qq_Identification.Model", 1, "post face data error : config url is empty");
        return;
      }
    } while (!paramHashMap.equals(paramString1));
    QLog.d("qq_Identification.Model", 1, "start upload face data");
    if (this.a.jdField_a_of_type_Aujp == null) {
      this.a.jdField_a_of_type_Aujp = new aujn(aukk.a(this.a), paramString2, this.a.jdField_a_of_type_Aukp);
    }
    for (;;)
    {
      aukk.a(this.a, new IdentificationPoseReflect.5.2(this));
      if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getApplication())) {
        break;
      }
      ((aujn)this.a.jdField_a_of_type_Aujp).b();
      return;
      ((aujn)this.a.jdField_a_of_type_Aujp).a(paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aukm
 * JD-Core Version:    0.7.0.1
 */