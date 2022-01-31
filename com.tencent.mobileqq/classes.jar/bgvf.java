import cooperation.qqreader.net.BaseCgiTask;
import cooperation.qqreader.ui.ForceUserUpdateActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class bgvf
  extends bgut
{
  public bgvf(ForceUserUpdateActivity paramForceUserUpdateActivity) {}
  
  public void a(bgus parambgus)
  {
    boolean bool = false;
    JSONObject localJSONObject = parambgus.a();
    if (localJSONObject == null) {}
    try
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore response json is null");
      return;
    }
    catch (JSONException parambgus)
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore parse failed: " + parambgus.getMessage());
      return;
    }
    int i = localJSONObject.getInt("ret");
    parambgus = localJSONObject.getString("msg");
    localJSONObject = localJSONObject.getJSONObject("data");
    if ((i != 0) || (localJSONObject == null) || (localJSONObject.length() == 0))
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore ret=" + i + "|msg=" + parambgus);
      return;
    }
    i = localJSONObject.optInt("err_code", 0);
    parambgus = localJSONObject.optString("err_msg");
    if (i == 0) {
      bool = true;
    }
    bgvm.b(ForceUserUpdateActivity.a(this.a), bool);
    if (bool)
    {
      bgvo.d("ForceUserUpdateActivity", "onReceiveData: UpdateToQQBookstore succeed");
      ForceUserUpdateActivity.c(this.a);
      return;
    }
    ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore errMsg=" + parambgus);
  }
  
  public void a(BaseCgiTask paramBaseCgiTask, String paramString)
  {
    ForceUserUpdateActivity.a(this.a, "onConnectionError: UpdateToQQBookstore error: " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgvf
 * JD-Core Version:    0.7.0.1
 */