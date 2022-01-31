import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

public class apjj
{
  public static int a(AppInterface paramAppInterface, Context paramContext)
  {
    int i = 0;
    if ((paramAppInterface == null) || (paramContext == null)) {
      QLog.e("TencentDocGuideHelper", 1, "getShownTimes sth is null");
    }
    int j;
    do
    {
      return i;
      j = paramContext.getSharedPreferences("tencent_doc", 4).getInt("shown_" + paramAppInterface.getCurrentAccountUin(), 0);
      i = j;
    } while (!QLog.isColorLevel());
    QLog.i("TencentDocGuideHelper", 2, "getShownTimes " + j);
    return j;
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TencentDocGuideHelper", 2, "setShownTimes " + paramInt);
    }
    if ((paramAppInterface == null) || (paramContext == null))
    {
      QLog.e("TencentDocGuideHelper", 1, "setShownTimes sth is null");
      return;
    }
    paramContext.getSharedPreferences("tencent_doc", 4).edit().putInt("shown_" + paramAppInterface.getCurrentAccountUin(), paramInt).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apjj
 * JD-Core Version:    0.7.0.1
 */