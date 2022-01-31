import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aoob
{
  public boolean a;
  
  public static aoob a(aoko[] paramArrayOfaoko)
  {
    boolean bool = false;
    aoob localaoob = new aoob();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaoko != null) {
      localObject1 = localObject2;
    }
    try
    {
      if (paramArrayOfaoko.length > 0) {
        localObject1 = paramArrayOfaoko[0].a;
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.i("LebaRedTouchSwitchBean", 1, "content is empty");
        return localaoob;
      }
      if (new JSONObject((String)localObject1).optInt("red_touch_all_tianshu", 0) == 1) {
        bool = true;
      }
      localaoob.a = bool;
      QLog.i("LebaRedTouchSwitchBean", 1, "parse config=" + (String)localObject1 + ",mRedTouchAllTianshu=" + localaoob.a);
      return localaoob;
    }
    catch (Exception paramArrayOfaoko)
    {
      QLog.i("LebaRedTouchSwitchBean", 1, "handleLebaConfig parse", paramArrayOfaoko);
    }
    return localaoob;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoob
 * JD-Core Version:    0.7.0.1
 */