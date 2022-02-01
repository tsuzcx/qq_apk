import cooperation.qqreader.net.BaseCgiTask;
import cooperation.qqreader.ui.ForceUserUpdateActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class bmqn
  extends bmqd
{
  public bmqn(ForceUserUpdateActivity paramForceUserUpdateActivity) {}
  
  public void a(bmqc parambmqc)
  {
    boolean bool = false;
    JSONObject localJSONObject = parambmqc.a();
    if (localJSONObject == null) {}
    try
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore response json is null");
      return;
    }
    catch (JSONException parambmqc)
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore parse failed: " + parambmqc.getMessage());
      return;
    }
    int i = localJSONObject.getInt("ret");
    parambmqc = localJSONObject.getString("msg");
    localJSONObject = localJSONObject.getJSONObject("data");
    if ((i != 0) || (localJSONObject == null) || (localJSONObject.length() == 0))
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore ret=" + i + "|msg=" + parambmqc);
      return;
    }
    i = localJSONObject.optInt("err_code", 0);
    parambmqc = localJSONObject.optString("err_msg");
    if (i == 0) {
      bool = true;
    }
    bmqu.b(ForceUserUpdateActivity.a(this.a), bool);
    if (bool)
    {
      bmqw.d("ForceUserUpdateActivity", "onReceiveData: UpdateToQQBookstore succeed");
      ForceUserUpdateActivity.c(this.a);
      return;
    }
    ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore errMsg=" + parambmqc);
  }
  
  public void a(BaseCgiTask paramBaseCgiTask, String paramString)
  {
    ForceUserUpdateActivity.a(this.a, "onConnectionError: UpdateToQQBookstore error: " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmqn
 * JD-Core Version:    0.7.0.1
 */