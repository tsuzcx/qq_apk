import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class areq
{
  public boolean a;
  
  public static areq a(araj[] paramArrayOfaraj)
  {
    boolean bool = false;
    areq localareq = new areq();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaraj != null) {
      localObject1 = localObject2;
    }
    try
    {
      if (paramArrayOfaraj.length > 0) {
        localObject1 = paramArrayOfaraj[0].a;
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.i("LebaRedTouchSwitchBean", 1, "content is empty");
        return localareq;
      }
      if (new JSONObject((String)localObject1).optInt("red_touch_all_tianshu", 0) == 1) {
        bool = true;
      }
      localareq.a = bool;
      QLog.i("LebaRedTouchSwitchBean", 1, "parse config=" + (String)localObject1 + ",mRedTouchAllTianshu=" + localareq.a);
      return localareq;
    }
    catch (Exception paramArrayOfaraj)
    {
      QLog.i("LebaRedTouchSwitchBean", 1, "handleLebaConfig parse", paramArrayOfaraj);
    }
    return localareq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     areq
 * JD-Core Version:    0.7.0.1
 */