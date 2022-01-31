import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amsr
{
  public boolean a;
  
  public static amsr a(ampi[] paramArrayOfampi)
  {
    boolean bool = false;
    amsr localamsr = new amsr();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfampi != null) {
      localObject1 = localObject2;
    }
    try
    {
      if (paramArrayOfampi.length > 0) {
        localObject1 = paramArrayOfampi[0].a;
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.i("LebaRedTouchSwitchBean", 1, "content is empty");
        return localamsr;
      }
      if (new JSONObject((String)localObject1).optInt("red_touch_all_tianshu", 0) == 1) {
        bool = true;
      }
      localamsr.a = bool;
      QLog.i("LebaRedTouchSwitchBean", 1, "parse config=" + (String)localObject1 + ",mRedTouchAllTianshu=" + localamsr.a);
      return localamsr;
    }
    catch (Exception paramArrayOfampi)
    {
      QLog.i("LebaRedTouchSwitchBean", 1, "handleLebaConfig parse", paramArrayOfampi);
    }
    return localamsr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amsr
 * JD-Core Version:    0.7.0.1
 */