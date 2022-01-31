import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aoun
  extends aouf<aoum>
{
  public int a()
  {
    return 95;
  }
  
  @NonNull
  public aoum a()
  {
    return new aoum();
  }
  
  @NonNull
  public aoum a(aoko[] paramArrayOfaoko)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    int j = paramArrayOfaoko.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        String str = paramArrayOfaoko[i].a;
        if (QLog.isColorLevel()) {
          QLog.i("PushOpenNotify", 2, "config :" + str);
        }
        if (!TextUtils.isEmpty(str))
        {
          ammy.a(localQQAppInterface, str, false);
          PreferenceManager.getDefaultSharedPreferences(localQQAppInterface.getApp()).edit().putString(localQQAppInterface.c() + "_" + "push_open_notify_xml", str).commit();
        }
      }
      else
      {
        return new aoum();
      }
      i += 1;
    }
  }
  
  public Class<aoum> a()
  {
    return aoum.class;
  }
  
  @NonNull
  public aoum b()
  {
    return new aoum();
  }
  
  public boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoun
 * JD-Core Version:    0.7.0.1
 */