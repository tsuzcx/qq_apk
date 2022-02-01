import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class blom
  extends blpb
{
  blom(blol paramblol) {}
  
  public void a(@NonNull blpa paramblpa)
  {
    paramblpa = paramblpa.a();
    if (paramblpa == null) {
      blpu.a("ReaderUrlConfigDataHelper", "Response json is null");
    }
    do
    {
      return;
      if (paramblpa.length() == 0)
      {
        blpu.a("ReaderUrlConfigDataHelper", "后台数据异常");
        return;
      }
    } while (!blol.a(this.a, paramblpa));
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    blol.a(this.a).getSharedPreferences("CGI_RESPONSE", 0).edit().putString("SP_URL_CONFIG_DATA" + str, paramblpa.toString()).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blom
 * JD-Core Version:    0.7.0.1
 */