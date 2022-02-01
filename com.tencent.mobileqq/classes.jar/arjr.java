import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class arjr
  extends arjj<arjq>
{
  @NonNull
  public arjq a()
  {
    return new arjq();
  }
  
  @NonNull
  public arjq a(aqxa[] paramArrayOfaqxa)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    int j = paramArrayOfaqxa.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        String str = paramArrayOfaqxa[i].a;
        if (QLog.isColorLevel()) {
          QLog.i("PushOpenNotify", 2, "config :" + str);
        }
        if (!TextUtils.isEmpty(str))
        {
          aora.a(localQQAppInterface, str, false);
          PreferenceManager.getDefaultSharedPreferences(localQQAppInterface.getApp()).edit().putString(localQQAppInterface.getCurrentUin() + "_" + "push_open_notify_xml", str).commit();
        }
      }
      else
      {
        return new arjq();
      }
      i += 1;
    }
  }
  
  @NonNull
  public arjq b()
  {
    return new arjq();
  }
  
  public Class<arjq> clazz()
  {
    return arjq.class;
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
 * Qualified Name:     arjr
 * JD-Core Version:    0.7.0.1
 */