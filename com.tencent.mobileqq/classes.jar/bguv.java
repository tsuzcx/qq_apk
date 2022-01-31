import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class bguv
  extends bgvk
{
  bguv(bguu parambguu) {}
  
  public void a(@NonNull bgvj parambgvj)
  {
    parambgvj = parambgvj.a();
    if (parambgvj == null) {
      bgwf.a("ReaderUrlConfigDataHelper", "Response json is null");
    }
    do
    {
      return;
      if (parambgvj.length() == 0)
      {
        bgwf.a("ReaderUrlConfigDataHelper", "后台数据异常");
        return;
      }
    } while (!bguu.a(this.a, parambgvj));
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    bguu.a(this.a).getSharedPreferences("CGI_RESPONSE", 0).edit().putString("SP_URL_CONFIG_DATA" + str, parambgvj.toString()).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bguv
 * JD-Core Version:    0.7.0.1
 */