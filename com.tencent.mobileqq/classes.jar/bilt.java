import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.hce.HcePluginInstallActivity;
import org.json.JSONObject;

public class bilt
  implements absf
{
  public bilt(HcePluginInstallActivity paramHcePluginInstallActivity) {}
  
  public void onComplete() {}
  
  public void onFailure(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HcePluginInstallActivity", 2, "mApiCallback onFailure code:" + paramInt + "msg:" + paramString);
    }
    QQToast.a(this.a.getApplicationContext(), alpo.a(2131705815), 0).a();
    this.a.finish();
  }
  
  public void onPermission(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HcePluginInstallActivity", 2, "mApiCallback onPermission " + paramInt);
    }
    QQToast.a(this.a.getApplicationContext(), alpo.a(2131705817), 0).a();
    this.a.finish();
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      HcePluginInstallActivity.a(this.a, paramJSONObject.optString("openid"));
    }
    HcePluginInstallActivity.b(this.a);
  }
  
  public void onTrigger(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bilt
 * JD-Core Version:    0.7.0.1
 */