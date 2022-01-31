import android.content.res.Resources;
import android.widget.TextView;
import cooperation.qqreader.net.BaseCgiTask;
import cooperation.qqreader.ui.ForceUserUpdateActivity;
import org.json.JSONObject;

public class bfmu
  extends bfmj
{
  public bfmu(ForceUserUpdateActivity paramForceUserUpdateActivity) {}
  
  public void a(bfmi parambfmi)
  {
    JSONObject localJSONObject = parambfmi.a();
    if (localJSONObject == null) {}
    try
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: QueryGrayUpdate response json is null");
      return;
    }
    catch (Exception parambfmi)
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: QueryGrayUpdate parse failed: " + parambfmi.getMessage());
      return;
    }
    int i = localJSONObject.getInt("ret");
    parambfmi = localJSONObject.getString("msg");
    localJSONObject = localJSONObject.getJSONObject("data");
    if ((i != 0) || (localJSONObject == null) || (localJSONObject.length() == 0))
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: QueryGrayUpdate ret=" + i + "|msg=" + parambfmi);
      return;
    }
    i = localJSONObject.optInt("gray_level", 0);
    int j = localJSONObject.optInt("updateStatus", 0);
    int k = localJSONObject.optInt("updateStatus", 0);
    int m = localJSONObject.optInt("remainMaxTime", 0);
    bfnc.a(ForceUserUpdateActivity.a(this.a), i);
    bfnc.b(ForceUserUpdateActivity.a(this.a), j);
    bfnc.c(ForceUserUpdateActivity.a(this.a), k);
    bfnc.d(ForceUserUpdateActivity.a(this.a), m);
    bfne.c("ForceUserUpdateActivity", "onReceiveData: QueryGrayUpdate result: level=" + i + "|status=" + j + "|remain=" + m + "|interval=" + k);
    if (j == 1)
    {
      ForceUserUpdateActivity.c(this.a);
      return;
    }
    if (j == 2)
    {
      ForceUserUpdateActivity.a(this.a, k);
      ForceUserUpdateActivity.a(this.a).setText(this.a.getResources().getString(2131651385, new Object[] { Integer.valueOf(m) }));
      return;
    }
    ForceUserUpdateActivity.d(this.a);
    bfnc.b(ForceUserUpdateActivity.a(this.a), 2);
  }
  
  public void a(BaseCgiTask paramBaseCgiTask, String paramString)
  {
    ForceUserUpdateActivity.a(this.a, "onConnectionError: QueryGrayUpdate error: " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfmu
 * JD-Core Version:    0.7.0.1
 */