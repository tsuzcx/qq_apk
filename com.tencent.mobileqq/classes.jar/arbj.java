import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arbj
{
  public boolean a;
  
  public static arbj a(aqxa[] paramArrayOfaqxa)
  {
    boolean bool = false;
    arbj localarbj = new arbj();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaqxa != null) {
      localObject1 = localObject2;
    }
    try
    {
      if (paramArrayOfaqxa.length > 0) {
        localObject1 = paramArrayOfaqxa[0].a;
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.i("LebaRedTouchSwitchBean", 1, "content is empty");
        return localarbj;
      }
      if (new JSONObject((String)localObject1).optInt("red_touch_all_tianshu", 0) == 1) {
        bool = true;
      }
      localarbj.a = bool;
      QLog.i("LebaRedTouchSwitchBean", 1, "parse config=" + (String)localObject1 + ",mRedTouchAllTianshu=" + localarbj.a);
      return localarbj;
    }
    catch (Exception paramArrayOfaqxa)
    {
      QLog.i("LebaRedTouchSwitchBean", 1, "handleLebaConfig parse", paramArrayOfaqxa);
    }
    return localarbj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arbj
 * JD-Core Version:    0.7.0.1
 */