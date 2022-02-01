import cooperation.qqreader.net.BaseCgiTask;
import cooperation.qqreader.ui.ForceUserUpdateActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class bmgd
  extends bmft
{
  public bmgd(ForceUserUpdateActivity paramForceUserUpdateActivity) {}
  
  public void a(bmfs parambmfs)
  {
    boolean bool = false;
    JSONObject localJSONObject = parambmfs.a();
    if (localJSONObject == null) {}
    try
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore response json is null");
      return;
    }
    catch (JSONException parambmfs)
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore parse failed: " + parambmfs.getMessage());
      return;
    }
    int i = localJSONObject.getInt("ret");
    parambmfs = localJSONObject.getString("msg");
    localJSONObject = localJSONObject.getJSONObject("data");
    if ((i != 0) || (localJSONObject == null) || (localJSONObject.length() == 0))
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore ret=" + i + "|msg=" + parambmfs);
      return;
    }
    i = localJSONObject.optInt("err_code", 0);
    parambmfs = localJSONObject.optString("err_msg");
    if (i == 0) {
      bool = true;
    }
    bmgk.b(ForceUserUpdateActivity.a(this.a), bool);
    if (bool)
    {
      bmgm.d("ForceUserUpdateActivity", "onReceiveData: UpdateToQQBookstore succeed");
      ForceUserUpdateActivity.c(this.a);
      return;
    }
    ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore errMsg=" + parambmfs);
  }
  
  public void a(BaseCgiTask paramBaseCgiTask, String paramString)
  {
    ForceUserUpdateActivity.a(this.a, "onConnectionError: UpdateToQQBookstore error: " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmgd
 * JD-Core Version:    0.7.0.1
 */