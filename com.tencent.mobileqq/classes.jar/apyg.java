import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class apyg
{
  public boolean a;
  
  public static apyg a(aptx[] paramArrayOfaptx)
  {
    boolean bool = false;
    apyg localapyg = new apyg();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaptx != null) {
      localObject1 = localObject2;
    }
    try
    {
      if (paramArrayOfaptx.length > 0) {
        localObject1 = paramArrayOfaptx[0].a;
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.i("LebaRedTouchSwitchBean", 1, "content is empty");
        return localapyg;
      }
      if (new JSONObject((String)localObject1).optInt("red_touch_all_tianshu", 0) == 1) {
        bool = true;
      }
      localapyg.a = bool;
      QLog.i("LebaRedTouchSwitchBean", 1, "parse config=" + (String)localObject1 + ",mRedTouchAllTianshu=" + localapyg.a);
      return localapyg;
    }
    catch (Exception paramArrayOfaptx)
    {
      QLog.i("LebaRedTouchSwitchBean", 1, "handleLebaConfig parse", paramArrayOfaptx);
    }
    return localapyg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apyg
 * JD-Core Version:    0.7.0.1
 */