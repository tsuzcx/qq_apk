import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class bmfc
  extends bmft
{
  bmfc(bmfa parambmfa) {}
  
  public void a(bmfs parambmfs)
  {
    parambmfs = parambmfs.a();
    if (parambmfs == null) {
      bmgm.a("ReaderTabConfigDataHelper", "Response json is null");
    }
    do
    {
      return;
      if (parambmfs.length() == 0)
      {
        bmgm.a("ReaderTabConfigDataHelper", "后台数据异常");
        return;
      }
    } while (!bmfa.a(this.a, parambmfs, false));
    bmfa.a(this.a).getSharedPreferences("CGI_RESPONSE", 0).edit().putString("SP_TAB_CONFIG_DATA" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), parambmfs.toString()).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmfc
 * JD-Core Version:    0.7.0.1
 */