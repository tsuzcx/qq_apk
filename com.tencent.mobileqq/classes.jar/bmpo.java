import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class bmpo
  extends bmqd
{
  bmpo(bmpn parambmpn) {}
  
  public void a(@NonNull bmqc parambmqc)
  {
    parambmqc = parambmqc.a();
    if (parambmqc == null) {
      bmqw.a("ReaderUrlConfigDataHelper", "Response json is null");
    }
    do
    {
      return;
      if (parambmqc.length() == 0)
      {
        bmqw.a("ReaderUrlConfigDataHelper", "后台数据异常");
        return;
      }
    } while (!bmpn.a(this.a, parambmqc));
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    bmpn.a(this.a).getSharedPreferences("CGI_RESPONSE", 0).edit().putString("SP_URL_CONFIG_DATA" + str, parambmqc.toString()).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmpo
 * JD-Core Version:    0.7.0.1
 */