import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class bguc
  extends bgut
{
  bguc(bgua parambgua) {}
  
  public void a(bgus parambgus)
  {
    parambgus = parambgus.a();
    if (parambgus == null) {
      bgvo.a("ReaderTabConfigDataHelper", "Response json is null");
    }
    do
    {
      return;
      if (parambgus.length() == 0)
      {
        bgvo.a("ReaderTabConfigDataHelper", "后台数据异常");
        return;
      }
    } while (!bgua.a(this.a, parambgus, false));
    bgua.a(this.a).getSharedPreferences("CGI_RESPONSE", 0).edit().putString("SP_TAB_CONFIG_DATA" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), parambgus.toString()).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bguc
 * JD-Core Version:    0.7.0.1
 */