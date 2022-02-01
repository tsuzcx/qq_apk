import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class anas
{
  private static final SharedPreferences a = BaseApplicationImpl.getApplication().getSharedPreferences("cmgame_robot", 4);
  
  public static void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      a.edit().putLong(paramString, System.currentTimeMillis()).commit();
    }
  }
  
  public static boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      long l = a.getLong(paramString, 0L);
      if (System.currentTimeMillis() - l < 86400000L)
      {
        QLog.i("CmGameTemp_RobotDataUtil", 1, "isRobotUin:" + paramString);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anas
 * JD-Core Version:    0.7.0.1
 */