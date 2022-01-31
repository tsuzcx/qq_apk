import cooperation.qqreader.net.BaseCgiTask;
import cooperation.qqreader.ui.ForceUserUpdateActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class bgvw
  extends bgvk
{
  public bgvw(ForceUserUpdateActivity paramForceUserUpdateActivity) {}
  
  public void a(bgvj parambgvj)
  {
    boolean bool = false;
    JSONObject localJSONObject = parambgvj.a();
    if (localJSONObject == null) {}
    try
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore response json is null");
      return;
    }
    catch (JSONException parambgvj)
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore parse failed: " + parambgvj.getMessage());
      return;
    }
    int i = localJSONObject.getInt("ret");
    parambgvj = localJSONObject.getString("msg");
    localJSONObject = localJSONObject.getJSONObject("data");
    if ((i != 0) || (localJSONObject == null) || (localJSONObject.length() == 0))
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore ret=" + i + "|msg=" + parambgvj);
      return;
    }
    i = localJSONObject.optInt("err_code", 0);
    parambgvj = localJSONObject.optString("err_msg");
    if (i == 0) {
      bool = true;
    }
    bgwd.b(ForceUserUpdateActivity.a(this.a), bool);
    if (bool)
    {
      bgwf.d("ForceUserUpdateActivity", "onReceiveData: UpdateToQQBookstore succeed");
      ForceUserUpdateActivity.c(this.a);
      return;
    }
    ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore errMsg=" + parambgvj);
  }
  
  public void a(BaseCgiTask paramBaseCgiTask, String paramString)
  {
    ForceUserUpdateActivity.a(this.a, "onConnectionError: UpdateToQQBookstore error: " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgvw
 * JD-Core Version:    0.7.0.1
 */