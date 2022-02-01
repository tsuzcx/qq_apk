import cooperation.qqreader.net.BaseCgiTask;
import cooperation.qqreader.ui.ForceUserUpdateActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class bkuu
  extends bkuk
{
  public bkuu(ForceUserUpdateActivity paramForceUserUpdateActivity) {}
  
  public void a(bkuj parambkuj)
  {
    boolean bool = false;
    JSONObject localJSONObject = parambkuj.a();
    if (localJSONObject == null) {}
    try
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore response json is null");
      return;
    }
    catch (JSONException parambkuj)
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore parse failed: " + parambkuj.getMessage());
      return;
    }
    int i = localJSONObject.getInt("ret");
    parambkuj = localJSONObject.getString("msg");
    localJSONObject = localJSONObject.getJSONObject("data");
    if ((i != 0) || (localJSONObject == null) || (localJSONObject.length() == 0))
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore ret=" + i + "|msg=" + parambkuj);
      return;
    }
    i = localJSONObject.optInt("err_code", 0);
    parambkuj = localJSONObject.optString("err_msg");
    if (i == 0) {
      bool = true;
    }
    bkvb.b(ForceUserUpdateActivity.a(this.a), bool);
    if (bool)
    {
      bkvd.d("ForceUserUpdateActivity", "onReceiveData: UpdateToQQBookstore succeed");
      ForceUserUpdateActivity.c(this.a);
      return;
    }
    ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore errMsg=" + parambkuj);
  }
  
  public void a(BaseCgiTask paramBaseCgiTask, String paramString)
  {
    ForceUserUpdateActivity.a(this.a, "onConnectionError: UpdateToQQBookstore error: " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkuu
 * JD-Core Version:    0.7.0.1
 */