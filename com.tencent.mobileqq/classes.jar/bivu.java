import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class bivu
  extends biwj
{
  bivu(bivt parambivt) {}
  
  public void a(@NonNull biwi parambiwi)
  {
    parambiwi = parambiwi.a();
    if (parambiwi == null) {
      bixe.a("ReaderUrlConfigDataHelper", "Response json is null");
    }
    do
    {
      return;
      if (parambiwi.length() == 0)
      {
        bixe.a("ReaderUrlConfigDataHelper", "后台数据异常");
        return;
      }
    } while (!bivt.a(this.a, parambiwi));
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    bivt.a(this.a).getSharedPreferences("CGI_RESPONSE", 0).edit().putString("SP_URL_CONFIG_DATA" + str, parambiwi.toString()).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bivu
 * JD-Core Version:    0.7.0.1
 */