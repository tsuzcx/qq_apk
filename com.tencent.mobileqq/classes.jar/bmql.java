import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qqreader.net.BaseCgiTask;
import cooperation.qqreader.ui.ForceUserUpdateActivity;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class bmql
  extends bmqd
{
  public bmql(ForceUserUpdateActivity paramForceUserUpdateActivity) {}
  
  public void a(bmqc parambmqc)
  {
    int j = 0;
    i = 0;
    parambmqc = parambmqc.a();
    if ((parambmqc == null) || (parambmqc.length() == 0)) {
      ForceUserUpdateActivity.a(this.a, "onReceiveData: FetchTabConfigData response illegal: " + parambmqc);
    }
    for (;;)
    {
      if (i == 0) {
        ForceUserUpdateActivity.b(this.a, "拉取新书城配置失败，请检查网络重试");
      }
      return;
      for (;;)
      {
        for (;;)
        {
          try
          {
            localObject = (JSONArray)parambmqc.get("tabList");
            if ((localObject != null) && (((JSONArray)localObject).length() > 0))
            {
              bmqw.d("ForceUserUpdateActivity", "onReceiveData: FetchTabConfigData succeed, length = " + ((JSONArray)localObject).length());
              localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
              ForceUserUpdateActivity.a(this.a).getSharedPreferences("CGI_RESPONSE", 0).edit().putString("SP_TAB_CONFIG_DATA" + (String)localObject, parambmqc.toString()).apply();
              bmqu.d(ForceUserUpdateActivity.a(this.a), true);
            }
          }
          catch (Exception parambmqc)
          {
            Object localObject;
            i = j;
          }
          try
          {
            ForceUserUpdateActivity.b(this.a);
            i = 1;
          }
          catch (Exception parambmqc)
          {
            for (;;)
            {
              i = 1;
            }
          }
        }
        ForceUserUpdateActivity.a(this.a, "onReceiveData: FetchTabConfigData empty: " + localObject);
        i = 0;
      }
      ForceUserUpdateActivity.a(this.a, "onReceiveData: FetchTabConfigData parse failed: " + parambmqc.getMessage());
    }
  }
  
  public void a(BaseCgiTask paramBaseCgiTask, String paramString)
  {
    ForceUserUpdateActivity.a(this.a, "onConnectionError: FetchTabConfigData error: " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmql
 * JD-Core Version:    0.7.0.1
 */