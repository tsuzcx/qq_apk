import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class bktv
  extends bkuk
{
  bktv(bktu parambktu) {}
  
  public void a(@NonNull bkuj parambkuj)
  {
    parambkuj = parambkuj.a();
    if (parambkuj == null) {
      bkvd.a("ReaderUrlConfigDataHelper", "Response json is null");
    }
    do
    {
      return;
      if (parambkuj.length() == 0)
      {
        bkvd.a("ReaderUrlConfigDataHelper", "后台数据异常");
        return;
      }
    } while (!bktu.a(this.a, parambkuj));
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    bktu.a(this.a).getSharedPreferences("CGI_RESPONSE", 0).edit().putString("SP_URL_CONFIG_DATA" + str, parambkuj.toString()).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bktv
 * JD-Core Version:    0.7.0.1
 */