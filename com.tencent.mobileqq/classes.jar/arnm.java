import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arnm
{
  public boolean a = true;
  
  public static arnm a(String paramString)
  {
    arnm localarnm = new arnm();
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return localarnm;
        try
        {
          localarnm.a = new JSONObject(paramString).optBoolean("isEnable", true);
          if (QLog.isColorLevel())
          {
            QLog.d("QVipPrettyAccountConfig", 2, "pretty_account config :" + localarnm.a);
            return localarnm;
          }
        }
        catch (JSONException paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("QVipPrettyAccountConfig", 2, "pretty_account config init error:" + paramString);
    return localarnm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arnm
 * JD-Core Version:    0.7.0.1
 */