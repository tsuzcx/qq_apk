import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amim
  extends amie<amil>
{
  public int a()
  {
    return 95;
  }
  
  @NonNull
  public amil a()
  {
    return new amil();
  }
  
  @NonNull
  public amil a(alzs[] paramArrayOfalzs)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    int j = paramArrayOfalzs.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        String str = paramArrayOfalzs[i].a;
        if (QLog.isColorLevel()) {
          QLog.i("PushOpenNotify", 2, "config :" + str);
        }
        if (!TextUtils.isEmpty(str))
        {
          akdt.a(localQQAppInterface, str, false);
          PreferenceManager.getDefaultSharedPreferences(localQQAppInterface.getApp()).edit().putString(localQQAppInterface.c() + "_" + "push_open_notify_xml", str).commit();
        }
      }
      else
      {
        return new amil();
      }
      i += 1;
    }
  }
  
  public Class<amil> a()
  {
    return amil.class;
  }
  
  @NonNull
  public amil b()
  {
    return new amil();
  }
  
  public boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amim
 * JD-Core Version:    0.7.0.1
 */