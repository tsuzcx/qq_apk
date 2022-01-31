import com.tencent.qphone.base.util.QLog;
import cooperation.hce.HcePluginInstallActivity;
import org.json.JSONObject;

public class bfcn
  implements zrt
{
  public bfcn(HcePluginInstallActivity paramHcePluginInstallActivity) {}
  
  public void onComplete() {}
  
  public void onFailure(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HcePluginInstallActivity", 2, "mApiCallback onFailure code:" + paramInt + "msg:" + paramString);
    }
    bbmy.a(this.a.getApplicationContext(), ajjy.a(2131639647), 0).a();
    this.a.finish();
  }
  
  public void onPermission(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HcePluginInstallActivity", 2, "mApiCallback onPermission " + paramInt);
    }
    bbmy.a(this.a.getApplicationContext(), ajjy.a(2131639649), 0).a();
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
 * Qualified Name:     bfcn
 * JD-Core Version:    0.7.0.1
 */