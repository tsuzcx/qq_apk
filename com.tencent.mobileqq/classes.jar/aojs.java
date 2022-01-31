import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aojs
{
  public boolean a;
  
  public static aojs a(aogf[] paramArrayOfaogf)
  {
    boolean bool = false;
    aojs localaojs = new aojs();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaogf != null) {
      localObject1 = localObject2;
    }
    try
    {
      if (paramArrayOfaogf.length > 0) {
        localObject1 = paramArrayOfaogf[0].a;
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.i("LebaRedTouchSwitchBean", 1, "content is empty");
        return localaojs;
      }
      if (new JSONObject((String)localObject1).optInt("red_touch_all_tianshu", 0) == 1) {
        bool = true;
      }
      localaojs.a = bool;
      QLog.i("LebaRedTouchSwitchBean", 1, "parse config=" + (String)localObject1 + ",mRedTouchAllTianshu=" + localaojs.a);
      return localaojs;
    }
    catch (Exception paramArrayOfaogf)
    {
      QLog.i("LebaRedTouchSwitchBean", 1, "handleLebaConfig parse", paramArrayOfaogf);
    }
    return localaojs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aojs
 * JD-Core Version:    0.7.0.1
 */