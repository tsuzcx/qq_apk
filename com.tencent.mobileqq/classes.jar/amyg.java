import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amyg
  implements ampd<String>
{
  public boolean a;
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("QFileIPv6ConfigBean", 1, "receiveAllConfigs|type: 449configContent is empty");
      return;
    }
    try
    {
      this.a = new JSONObject(paramString).getJSONObject("ipv6Config").getBoolean("allSwitch");
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("QFileIPv6ConfigBean", 1, paramString, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amyg
 * JD-Core Version:    0.7.0.1
 */