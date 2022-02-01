import android.content.res.Resources;
import android.widget.TextView;
import cooperation.qqreader.net.BaseCgiTask;
import cooperation.qqreader.ui.ForceUserUpdateActivity;
import org.json.JSONObject;

public class bmgc
  extends bmft
{
  public bmgc(ForceUserUpdateActivity paramForceUserUpdateActivity) {}
  
  public void a(bmfs parambmfs)
  {
    JSONObject localJSONObject = parambmfs.a();
    if (localJSONObject == null) {}
    try
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: QueryGrayUpdate response json is null");
      return;
    }
    catch (Exception parambmfs)
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: QueryGrayUpdate parse failed: " + parambmfs.getMessage());
      return;
    }
    int i = localJSONObject.getInt("ret");
    parambmfs = localJSONObject.getString("msg");
    localJSONObject = localJSONObject.getJSONObject("data");
    if ((i != 0) || (localJSONObject == null) || (localJSONObject.length() == 0))
    {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: QueryGrayUpdate ret=" + i + "|msg=" + parambmfs);
      return;
    }
    i = localJSONObject.optInt("gray_level", 0);
    int j = localJSONObject.optInt("updateStatus", 0);
    int k = localJSONObject.optInt("updateStatus", 0);
    int m = localJSONObject.optInt("remainMaxTime", 0);
    bmgk.a(ForceUserUpdateActivity.a(this.a), i);
    bmgk.b(ForceUserUpdateActivity.a(this.a), j);
    bmgk.c(ForceUserUpdateActivity.a(this.a), k);
    bmgk.d(ForceUserUpdateActivity.a(this.a), m);
    bmgm.d("ForceUserUpdateActivity", "onReceiveData: QueryGrayUpdate result: level=" + i + "|status=" + j + "|remain=" + m + "|interval=" + k);
    if (j == 1)
    {
      ForceUserUpdateActivity.c(this.a);
      return;
    }
    if (j == 2)
    {
      ForceUserUpdateActivity.a(this.a, k);
      ForceUserUpdateActivity.a(this.a).setText(this.a.getResources().getString(2131716500, new Object[] { Integer.valueOf(m) }));
      return;
    }
    ForceUserUpdateActivity.d(this.a);
    bmgk.b(ForceUserUpdateActivity.a(this.a), 2);
  }
  
  public void a(BaseCgiTask paramBaseCgiTask, String paramString)
  {
    ForceUserUpdateActivity.a(this.a, "onConnectionError: QueryGrayUpdate error: " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmgc
 * JD-Core Version:    0.7.0.1
 */