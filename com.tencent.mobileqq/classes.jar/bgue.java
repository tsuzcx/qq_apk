import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class bgue
  extends bgut
{
  bgue(bgud parambgud) {}
  
  public void a(@NonNull bgus parambgus)
  {
    parambgus = parambgus.a();
    if (parambgus == null) {
      bgvo.a("ReaderUrlConfigDataHelper", "Response json is null");
    }
    do
    {
      return;
      if (parambgus.length() == 0)
      {
        bgvo.a("ReaderUrlConfigDataHelper", "后台数据异常");
        return;
      }
    } while (!bgud.a(this.a, parambgus));
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    bgud.a(this.a).getSharedPreferences("CGI_RESPONSE", 0).edit().putString("SP_URL_CONFIG_DATA" + str, parambgus.toString()).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgue
 * JD-Core Version:    0.7.0.1
 */