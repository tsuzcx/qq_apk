import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class bjab
  extends bjaq
{
  bjab(bjaa parambjaa) {}
  
  public void a(@NonNull bjap parambjap)
  {
    parambjap = parambjap.a();
    if (parambjap == null) {
      bjbl.a("ReaderUrlConfigDataHelper", "Response json is null");
    }
    do
    {
      return;
      if (parambjap.length() == 0)
      {
        bjbl.a("ReaderUrlConfigDataHelper", "后台数据异常");
        return;
      }
    } while (!bjaa.a(this.a, parambjap));
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    bjaa.a(this.a).getSharedPreferences("CGI_RESPONSE", 0).edit().putString("SP_URL_CONFIG_DATA" + str, parambjap.toString()).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjab
 * JD-Core Version:    0.7.0.1
 */