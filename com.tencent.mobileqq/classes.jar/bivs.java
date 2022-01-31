import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class bivs
  extends biwj
{
  bivs(bivq parambivq) {}
  
  public void a(biwi parambiwi)
  {
    parambiwi = parambiwi.a();
    if (parambiwi == null) {
      bixe.a("ReaderTabConfigDataHelper", "Response json is null");
    }
    do
    {
      return;
      if (parambiwi.length() == 0)
      {
        bixe.a("ReaderTabConfigDataHelper", "后台数据异常");
        return;
      }
    } while (!bivq.a(this.a, parambiwi, false));
    bivq.a(this.a).getSharedPreferences("CGI_RESPONSE", 0).edit().putString("SP_TAB_CONFIG_DATA" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), parambiwi.toString()).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bivs
 * JD-Core Version:    0.7.0.1
 */