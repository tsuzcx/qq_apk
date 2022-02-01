import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqpi
{
  public boolean a;
  
  public static aqpi a(aqlg[] paramArrayOfaqlg)
  {
    boolean bool = false;
    aqpi localaqpi = new aqpi();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaqlg != null) {
      localObject1 = localObject2;
    }
    try
    {
      if (paramArrayOfaqlg.length > 0) {
        localObject1 = paramArrayOfaqlg[0].a;
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.i("LebaRedTouchSwitchBean", 1, "content is empty");
        return localaqpi;
      }
      if (new JSONObject((String)localObject1).optInt("red_touch_all_tianshu", 0) == 1) {
        bool = true;
      }
      localaqpi.a = bool;
      QLog.i("LebaRedTouchSwitchBean", 1, "parse config=" + (String)localObject1 + ",mRedTouchAllTianshu=" + localaqpi.a);
      return localaqpi;
    }
    catch (Exception paramArrayOfaqlg)
    {
      QLog.i("LebaRedTouchSwitchBean", 1, "handleLebaConfig parse", paramArrayOfaqlg);
    }
    return localaqpi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqpi
 * JD-Core Version:    0.7.0.1
 */