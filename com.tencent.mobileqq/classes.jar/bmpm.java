import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class bmpm
  extends bmqd
{
  bmpm(bmpk parambmpk) {}
  
  public void a(bmqc parambmqc)
  {
    parambmqc = parambmqc.a();
    if (parambmqc == null) {
      bmqw.a("ReaderTabConfigDataHelper", "Response json is null");
    }
    do
    {
      return;
      if (parambmqc.length() == 0)
      {
        bmqw.a("ReaderTabConfigDataHelper", "后台数据异常");
        return;
      }
    } while (!bmpk.a(this.a, parambmqc, false));
    bmpk.a(this.a).getSharedPreferences("CGI_RESPONSE", 0).edit().putString("SP_TAB_CONFIG_DATA" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), parambmqc.toString()).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmpm
 * JD-Core Version:    0.7.0.1
 */