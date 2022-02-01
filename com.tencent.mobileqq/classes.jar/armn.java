import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class armn
  extends armf<armm>
{
  @NonNull
  public armm a()
  {
    return new armm();
  }
  
  @NonNull
  public armm a(araj[] paramArrayOfaraj)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    int j = paramArrayOfaraj.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        String str = paramArrayOfaraj[i].a;
        if (QLog.isColorLevel()) {
          QLog.i("PushOpenNotify", 2, "config :" + str);
        }
        if (!TextUtils.isEmpty(str))
        {
          aovh.a(localQQAppInterface, str, false);
          PreferenceManager.getDefaultSharedPreferences(localQQAppInterface.getApp()).edit().putString(localQQAppInterface.c() + "_" + "push_open_notify_xml", str).commit();
        }
      }
      else
      {
        return new armm();
      }
      i += 1;
    }
  }
  
  @NonNull
  public armm b()
  {
    return new armm();
  }
  
  public Class<armm> clazz()
  {
    return armm.class;
  }
  
  public boolean isNeedCompressed()
  {
    return false;
  }
  
  public int type()
  {
    return 95;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     armn
 * JD-Core Version:    0.7.0.1
 */