import cooperation.qqreader.net.BaseCgiTask;
import cooperation.qqreader.ui.ForceUserUpdateActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class bfmv
  extends bfmj
{
  public bfmv(ForceUserUpdateActivity paramForceUserUpdateActivity) {}
  
  public void a(bfmi parambfmi)
  {
    boolean bool = false;
    JSONObject localJSONObject = parambfmi.a();
    if (localJSONObject == null) {}
    try
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore response json is null");
      return;
    }
    catch (JSONException parambfmi)
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore parse failed: " + parambfmi.getMessage());
      return;
    }
    int i = localJSONObject.getInt("ret");
    parambfmi = localJSONObject.getString("msg");
    localJSONObject = localJSONObject.getJSONObject("data");
    if ((i != 0) || (localJSONObject == null) || (localJSONObject.length() == 0))
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore ret=" + i + "|msg=" + parambfmi);
      return;
    }
    i = localJSONObject.optInt("err_code", 0);
    parambfmi = localJSONObject.optString("err_msg");
    if (i == 0) {
      bool = true;
    }
    bfnc.b(ForceUserUpdateActivity.a(this.a), bool);
    if (bool)
    {
      bfne.c("ForceUserUpdateActivity", "onReceiveData: UpdateToQQBookstore succeed");
      ForceUserUpdateActivity.c(this.a);
      return;
    }
    ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore errMsg=" + parambfmi);
  }
  
  public void a(BaseCgiTask paramBaseCgiTask, String paramString)
  {
    ForceUserUpdateActivity.a(this.a, "onConnectionError: UpdateToQQBookstore error: " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfmv
 * JD-Core Version:    0.7.0.1
 */