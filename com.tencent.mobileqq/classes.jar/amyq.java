import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amyq
  extends amyi<amyp>
{
  public int a()
  {
    return 95;
  }
  
  @NonNull
  public amyp a()
  {
    return new amyp();
  }
  
  @NonNull
  public amyp a(ampi[] paramArrayOfampi)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    int j = paramArrayOfampi.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        String str = paramArrayOfampi[i].a;
        if (QLog.isColorLevel()) {
          QLog.i("PushOpenNotify", 2, "config :" + str);
        }
        if (!TextUtils.isEmpty(str))
        {
          aksf.a(localQQAppInterface, str, false);
          PreferenceManager.getDefaultSharedPreferences(localQQAppInterface.getApp()).edit().putString(localQQAppInterface.c() + "_" + "push_open_notify_xml", str).commit();
        }
      }
      else
      {
        return new amyp();
      }
      i += 1;
    }
  }
  
  public Class<amyp> a()
  {
    return amyp.class;
  }
  
  @NonNull
  public amyp b()
  {
    return new amyp();
  }
  
  public boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amyq
 * JD-Core Version:    0.7.0.1
 */