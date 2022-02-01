import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aqgk
  extends aqgc<aqgj>
{
  @NonNull
  public aqgj a()
  {
    return new aqgj();
  }
  
  @NonNull
  public aqgj a(aptx[] paramArrayOfaptx)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    int j = paramArrayOfaptx.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        String str = paramArrayOfaptx[i].a;
        if (QLog.isColorLevel()) {
          QLog.i("PushOpenNotify", 2, "config :" + str);
        }
        if (!TextUtils.isEmpty(str))
        {
          anoh.a(localQQAppInterface, str, false);
          PreferenceManager.getDefaultSharedPreferences(localQQAppInterface.getApp()).edit().putString(localQQAppInterface.getCurrentUin() + "_" + "push_open_notify_xml", str).commit();
        }
      }
      else
      {
        return new aqgj();
      }
      i += 1;
    }
  }
  
  @NonNull
  public aqgj b()
  {
    return new aqgj();
  }
  
  public Class<aqgj> clazz()
  {
    return aqgj.class;
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
 * Qualified Name:     aqgk
 * JD-Core Version:    0.7.0.1
 */