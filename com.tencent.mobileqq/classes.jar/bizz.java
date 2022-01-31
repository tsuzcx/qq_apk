import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class bizz
  extends bjaq
{
  bizz(bizx parambizx) {}
  
  public void a(bjap parambjap)
  {
    parambjap = parambjap.a();
    if (parambjap == null) {
      bjbl.a("ReaderTabConfigDataHelper", "Response json is null");
    }
    do
    {
      return;
      if (parambjap.length() == 0)
      {
        bjbl.a("ReaderTabConfigDataHelper", "后台数据异常");
        return;
      }
    } while (!bizx.a(this.a, parambjap, false));
    bizx.a(this.a).getSharedPreferences("CGI_RESPONSE", 0).edit().putString("SP_TAB_CONFIG_DATA" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), parambjap.toString()).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bizz
 * JD-Core Version:    0.7.0.1
 */