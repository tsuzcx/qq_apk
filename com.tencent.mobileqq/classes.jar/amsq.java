import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amsq
{
  public boolean a;
  
  public static amsq a(amph[] paramArrayOfamph)
  {
    boolean bool = false;
    amsq localamsq = new amsq();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfamph != null) {
      localObject1 = localObject2;
    }
    try
    {
      if (paramArrayOfamph.length > 0) {
        localObject1 = paramArrayOfamph[0].a;
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.i("LebaRedTouchSwitchBean", 1, "content is empty");
        return localamsq;
      }
      if (new JSONObject((String)localObject1).optInt("red_touch_all_tianshu", 0) == 1) {
        bool = true;
      }
      localamsq.a = bool;
      QLog.i("LebaRedTouchSwitchBean", 1, "parse config=" + (String)localObject1 + ",mRedTouchAllTianshu=" + localamsq.a);
      return localamsq;
    }
    catch (Exception paramArrayOfamph)
    {
      QLog.i("LebaRedTouchSwitchBean", 1, "handleLebaConfig parse", paramArrayOfamph);
    }
    return localamsq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amsq
 * JD-Core Version:    0.7.0.1
 */