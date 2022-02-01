import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.hce.HcePluginInstallActivity;
import org.json.JSONObject;

public class blub
  implements adaa
{
  public blub(HcePluginInstallActivity paramHcePluginInstallActivity) {}
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HcePluginInstallActivity", 2, "mApiCallback onPermission " + paramInt);
    }
    QQToast.a(this.a.getApplicationContext(), anvx.a(2131704918), 0).a();
    this.a.finish();
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HcePluginInstallActivity", 2, "mApiCallback onFailure code:" + paramInt + "msg:" + paramString);
    }
    QQToast.a(this.a.getApplicationContext(), anvx.a(2131704916), 0).a();
    this.a.finish();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      HcePluginInstallActivity.a(this.a, paramJSONObject.optString("openid"));
    }
    HcePluginInstallActivity.b(this.a);
  }
  
  public void b(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blub
 * JD-Core Version:    0.7.0.1
 */