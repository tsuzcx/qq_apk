import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class blok
  extends blpb
{
  blok(bloi parambloi) {}
  
  public void a(blpa paramblpa)
  {
    paramblpa = paramblpa.a();
    if (paramblpa == null) {
      blpu.a("ReaderTabConfigDataHelper", "Response json is null");
    }
    do
    {
      return;
      if (paramblpa.length() == 0)
      {
        blpu.a("ReaderTabConfigDataHelper", "后台数据异常");
        return;
      }
    } while (!bloi.a(this.a, paramblpa, false));
    bloi.a(this.a).getSharedPreferences("CGI_RESPONSE", 0).edit().putString("SP_TAB_CONFIG_DATA" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramblpa.toString()).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blok
 * JD-Core Version:    0.7.0.1
 */