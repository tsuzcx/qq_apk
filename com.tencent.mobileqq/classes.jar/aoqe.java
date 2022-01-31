import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aoqe
  extends aopw<aoqd>
{
  public int a()
  {
    return 95;
  }
  
  @NonNull
  public aoqd a()
  {
    return new aoqd();
  }
  
  @NonNull
  public aoqd a(aogf[] paramArrayOfaogf)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    int j = paramArrayOfaogf.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        String str = paramArrayOfaogf[i].a;
        if (QLog.isColorLevel()) {
          QLog.i("PushOpenNotify", 2, "config :" + str);
        }
        if (!TextUtils.isEmpty(str))
        {
          amij.a(localQQAppInterface, str, false);
          PreferenceManager.getDefaultSharedPreferences(localQQAppInterface.getApp()).edit().putString(localQQAppInterface.c() + "_" + "push_open_notify_xml", str).commit();
        }
      }
      else
      {
        return new aoqd();
      }
      i += 1;
    }
  }
  
  public Class<aoqd> a()
  {
    return aoqd.class;
  }
  
  @NonNull
  public aoqd b()
  {
    return new aoqd();
  }
  
  public boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoqe
 * JD-Core Version:    0.7.0.1
 */