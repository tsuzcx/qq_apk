import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amyx
  extends amyp<amyw>
{
  public int a()
  {
    return 95;
  }
  
  @NonNull
  public amyw a()
  {
    return new amyw();
  }
  
  @NonNull
  public amyw a(amph[] paramArrayOfamph)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    int j = paramArrayOfamph.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        String str = paramArrayOfamph[i].a;
        if (QLog.isColorLevel()) {
          QLog.i("PushOpenNotify", 2, "config :" + str);
        }
        if (!TextUtils.isEmpty(str))
        {
          akse.a(localQQAppInterface, str, false);
          PreferenceManager.getDefaultSharedPreferences(localQQAppInterface.getApp()).edit().putString(localQQAppInterface.c() + "_" + "push_open_notify_xml", str).commit();
        }
      }
      else
      {
        return new amyw();
      }
      i += 1;
    }
  }
  
  public Class<amyw> a()
  {
    return amyw.class;
  }
  
  @NonNull
  public amyw b()
  {
    return new amyw();
  }
  
  public boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amyx
 * JD-Core Version:    0.7.0.1
 */