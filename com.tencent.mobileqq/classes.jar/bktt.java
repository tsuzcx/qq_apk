import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class bktt
  extends bkuk
{
  bktt(bktr parambktr) {}
  
  public void a(bkuj parambkuj)
  {
    parambkuj = parambkuj.a();
    if (parambkuj == null) {
      bkvd.a("ReaderTabConfigDataHelper", "Response json is null");
    }
    do
    {
      return;
      if (parambkuj.length() == 0)
      {
        bkvd.a("ReaderTabConfigDataHelper", "后台数据异常");
        return;
      }
    } while (!bktr.a(this.a, parambkuj, false));
    bktr.a(this.a).getSharedPreferences("CGI_RESPONSE", 0).edit().putString("SP_TAB_CONFIG_DATA" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), parambkuj.toString()).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bktt
 * JD-Core Version:    0.7.0.1
 */