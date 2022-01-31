import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class bflz
  extends bfmj
{
  bflz(bfly parambfly) {}
  
  public void a(@NonNull bfmi parambfmi)
  {
    parambfmi = parambfmi.a();
    if (parambfmi == null) {
      bfne.a("ReaderUrlConfigDataHelper", "Response json is null");
    }
    do
    {
      return;
      if (parambfmi.length() == 0)
      {
        bfne.a("ReaderUrlConfigDataHelper", "后台数据异常");
        return;
      }
    } while (!bfly.a(this.a, parambfmi));
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    bfly.a(this.a).getSharedPreferences("CGI_RESPONSE", 0).edit().putString("SP_URL_CONFIG_DATA" + str, parambfmi.toString()).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bflz
 * JD-Core Version:    0.7.0.1
 */