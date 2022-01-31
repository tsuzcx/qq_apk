import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class bflx
  extends bfmj
{
  bflx(bflv parambflv) {}
  
  public void a(bfmi parambfmi)
  {
    parambfmi = parambfmi.a();
    if (parambfmi == null) {
      bfne.a("ReaderTabConfigDataHelper", "Response json is null");
    }
    do
    {
      return;
      if (parambfmi.length() == 0)
      {
        bfne.a("ReaderTabConfigDataHelper", "后台数据异常");
        return;
      }
    } while (!bflv.a(this.a, parambfmi, false));
    bflv.a(this.a).getSharedPreferences("CGI_RESPONSE", 0).edit().putString("SP_TAB_CONFIG_DATA" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), parambfmi.toString()).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bflx
 * JD-Core Version:    0.7.0.1
 */