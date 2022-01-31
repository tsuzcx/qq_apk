import com.tencent.qphone.base.util.QLog;
import cooperation.hce.HcePluginInstallActivity;
import org.json.JSONObject;

public class bgkv
  implements aabi
{
  public bgkv(HcePluginInstallActivity paramHcePluginInstallActivity) {}
  
  public void onComplete() {}
  
  public void onFailure(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HcePluginInstallActivity", 2, "mApiCallback onFailure code:" + paramInt + "msg:" + paramString);
    }
    bcql.a(this.a.getApplicationContext(), ajya.a(2131705443), 0).a();
    this.a.finish();
  }
  
  public void onPermission(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HcePluginInstallActivity", 2, "mApiCallback onPermission " + paramInt);
    }
    bcql.a(this.a.getApplicationContext(), ajya.a(2131705445), 0).a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgkv
 * JD-Core Version:    0.7.0.1
 */