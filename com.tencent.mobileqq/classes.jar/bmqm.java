import android.content.res.Resources;
import android.widget.TextView;
import cooperation.qqreader.net.BaseCgiTask;
import cooperation.qqreader.ui.ForceUserUpdateActivity;
import org.json.JSONObject;

public class bmqm
  extends bmqd
{
  public bmqm(ForceUserUpdateActivity paramForceUserUpdateActivity) {}
  
  public void a(bmqc parambmqc)
  {
    JSONObject localJSONObject = parambmqc.a();
    if (localJSONObject == null) {}
    try
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: QueryGrayUpdate response json is null");
      return;
    }
    catch (Exception parambmqc)
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: QueryGrayUpdate parse failed: " + parambmqc.getMessage());
      return;
    }
    int i = localJSONObject.getInt("ret");
    parambmqc = localJSONObject.getString("msg");
    localJSONObject = localJSONObject.getJSONObject("data");
    if ((i != 0) || (localJSONObject == null) || (localJSONObject.length() == 0))
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: QueryGrayUpdate ret=" + i + "|msg=" + parambmqc);
      return;
    }
    i = localJSONObject.optInt("gray_level", 0);
    int j = localJSONObject.optInt("updateStatus", 0);
    int k = localJSONObject.optInt("updateStatus", 0);
    int m = localJSONObject.optInt("remainMaxTime", 0);
    bmqu.a(ForceUserUpdateActivity.a(this.a), i);
    bmqu.b(ForceUserUpdateActivity.a(this.a), j);
    bmqu.c(ForceUserUpdateActivity.a(this.a), k);
    bmqu.d(ForceUserUpdateActivity.a(this.a), m);
    bmqw.d("ForceUserUpdateActivity", "onReceiveData: QueryGrayUpdate result: level=" + i + "|status=" + j + "|remain=" + m + "|interval=" + k);
    if (j == 1)
    {
      ForceUserUpdateActivity.c(this.a);
      return;
    }
    if (j == 2)
    {
      ForceUserUpdateActivity.a(this.a, k);
      ForceUserUpdateActivity.a(this.a).setText(this.a.getResources().getString(2131715910, new Object[] { Integer.valueOf(m) }));
      return;
    }
    ForceUserUpdateActivity.d(this.a);
    bmqu.b(ForceUserUpdateActivity.a(this.a), 2);
  }
  
  public void a(BaseCgiTask paramBaseCgiTask, String paramString)
  {
    ForceUserUpdateActivity.a(this.a, "onConnectionError: QueryGrayUpdate error: " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmqm
 * JD-Core Version:    0.7.0.1
 */