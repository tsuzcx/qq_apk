import cooperation.qqreader.net.BaseCgiTask;
import cooperation.qqreader.ui.ForceUserUpdateActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class biwv
  extends biwj
{
  public biwv(ForceUserUpdateActivity paramForceUserUpdateActivity) {}
  
  public void a(biwi parambiwi)
  {
    boolean bool = false;
    JSONObject localJSONObject = parambiwi.a();
    if (localJSONObject == null) {}
    try
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore response json is null");
      return;
    }
    catch (JSONException parambiwi)
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore parse failed: " + parambiwi.getMessage());
      return;
    }
    int i = localJSONObject.getInt("ret");
    parambiwi = localJSONObject.getString("msg");
    localJSONObject = localJSONObject.getJSONObject("data");
    if ((i != 0) || (localJSONObject == null) || (localJSONObject.length() == 0))
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore ret=" + i + "|msg=" + parambiwi);
      return;
    }
    i = localJSONObject.optInt("err_code", 0);
    parambiwi = localJSONObject.optString("err_msg");
    if (i == 0) {
      bool = true;
    }
    bixc.b(ForceUserUpdateActivity.a(this.a), bool);
    if (bool)
    {
      bixe.d("ForceUserUpdateActivity", "onReceiveData: UpdateToQQBookstore succeed");
      ForceUserUpdateActivity.c(this.a);
      return;
    }
    ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore errMsg=" + parambiwi);
  }
  
  public void a(BaseCgiTask paramBaseCgiTask, String paramString)
  {
    ForceUserUpdateActivity.a(this.a, "onConnectionError: UpdateToQQBookstore error: " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biwv
 * JD-Core Version:    0.7.0.1
 */