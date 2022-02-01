import cooperation.qqreader.net.BaseCgiTask;
import cooperation.qqreader.ui.ForceUserUpdateActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class blpl
  extends blpb
{
  public blpl(ForceUserUpdateActivity paramForceUserUpdateActivity) {}
  
  public void a(blpa paramblpa)
  {
    boolean bool = false;
    JSONObject localJSONObject = paramblpa.a();
    if (localJSONObject == null) {}
    try
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore response json is null");
      return;
    }
    catch (JSONException paramblpa)
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore parse failed: " + paramblpa.getMessage());
      return;
    }
    int i = localJSONObject.getInt("ret");
    paramblpa = localJSONObject.getString("msg");
    localJSONObject = localJSONObject.getJSONObject("data");
    if ((i != 0) || (localJSONObject == null) || (localJSONObject.length() == 0))
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore ret=" + i + "|msg=" + paramblpa);
      return;
    }
    i = localJSONObject.optInt("err_code", 0);
    paramblpa = localJSONObject.optString("err_msg");
    if (i == 0) {
      bool = true;
    }
    blps.b(ForceUserUpdateActivity.a(this.a), bool);
    if (bool)
    {
      blpu.d("ForceUserUpdateActivity", "onReceiveData: UpdateToQQBookstore succeed");
      ForceUserUpdateActivity.c(this.a);
      return;
    }
    ForceUserUpdateActivity.a(this.a, "onReceiveData: UpdateToQQBookstore errMsg=" + paramblpa);
  }
  
  public void a(BaseCgiTask paramBaseCgiTask, String paramString)
  {
    ForceUserUpdateActivity.a(this.a, "onConnectionError: UpdateToQQBookstore error: " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blpl
 * JD-Core Version:    0.7.0.1
 */