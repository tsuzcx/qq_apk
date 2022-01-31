import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class bgut
  extends bgvk
{
  bgut(bgur parambgur) {}
  
  public void a(bgvj parambgvj)
  {
    parambgvj = parambgvj.a();
    if (parambgvj == null) {
      bgwf.a("ReaderTabConfigDataHelper", "Response json is null");
    }
    do
    {
      return;
      if (parambgvj.length() == 0)
      {
        bgwf.a("ReaderTabConfigDataHelper", "后台数据异常");
        return;
      }
    } while (!bgur.a(this.a, parambgvj, false));
    bgur.a(this.a).getSharedPreferences("CGI_RESPONSE", 0).edit().putString("SP_TAB_CONFIG_DATA" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), parambgvj.toString()).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgut
 * JD-Core Version:    0.7.0.1
 */