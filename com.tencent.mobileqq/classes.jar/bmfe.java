import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class bmfe
  extends bmft
{
  bmfe(bmfd parambmfd) {}
  
  public void a(@NonNull bmfs parambmfs)
  {
    parambmfs = parambmfs.a();
    if (parambmfs == null) {
      bmgm.a("ReaderUrlConfigDataHelper", "Response json is null");
    }
    do
    {
      return;
      if (parambmfs.length() == 0)
      {
        bmgm.a("ReaderUrlConfigDataHelper", "后台数据异常");
        return;
      }
    } while (!bmfd.a(this.a, parambmfs));
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    bmfd.a(this.a).getSharedPreferences("CGI_RESPONSE", 0).edit().putString("SP_URL_CONFIG_DATA" + str, parambmfs.toString()).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmfe
 * JD-Core Version:    0.7.0.1
 */