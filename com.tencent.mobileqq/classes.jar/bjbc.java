import cooperation.qqreader.net.BaseCgiTask;
import cooperation.qqreader.ui.ForceUserUpdateActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class bjbc
  extends bjaq
{
  public bjbc(ForceUserUpdateActivity paramForceUserUpdateActivity) {}
  
  public void a(bjap parambjap)
  {
    boolean bool = false;
    JSONObject localJSONObject = parambjap.a();
    if (localJSONObject == null) {}
    try
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore response json is null");
      return;
    }
    catch (JSONException parambjap)
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore parse failed: " + parambjap.getMessage());
      return;
    }
    int i = localJSONObject.getInt("ret");
    parambjap = localJSONObject.getString("msg");
    localJSONObject = localJSONObject.getJSONObject("data");
    if ((i != 0) || (localJSONObject == null) || (localJSONObject.length() == 0))
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore ret=" + i + "|msg=" + parambjap);
      return;
    }
    i = localJSONObject.optInt("err_code", 0);
    parambjap = localJSONObject.optString("err_msg");
    if (i == 0) {
      bool = true;
    }
    bjbj.b(ForceUserUpdateActivity.a(this.a), bool);
    if (bool)
    {
      bjbl.d("ForceUserUpdateActivity", "onReceiveData: UpdateToQQBookstore succeed");
      ForceUserUpdateActivity.c(this.a);
      return;
    }
    ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore errMsg=" + parambjap);
  }
  
  public void a(BaseCgiTask paramBaseCgiTask, String paramString)
  {
    ForceUserUpdateActivity.a(this.a, "onConnectionError: UpdateToQQBookstore error: " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjbc
 * JD-Core Version:    0.7.0.1
 */