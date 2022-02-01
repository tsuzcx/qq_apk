import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.business.qvip.QVipWatchWordConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class arom
  extends armf<QVipWatchWordConfig>
{
  public static QVipWatchWordConfig a()
  {
    return (QVipWatchWordConfig)aran.a().a(648);
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    Object localObject = a();
    boolean bool1 = bool2;
    int i;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((QVipWatchWordConfig)localObject).isEnable())
      {
        if (QLog.isColorLevel()) {
          QLog.d("QVipWatchWordProcessor", 2, "isShowWatchWord:" + paramString + " configUrl:" + ((QVipWatchWordConfig)localObject).getWatchUrl() + " configPattern:" + ((QVipWatchWordConfig)localObject).getPattern());
        }
        localObject = ((QVipWatchWordConfig)localObject).getWatchUrl();
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < ((ArrayList)localObject).size())
      {
        if (paramString.contains((CharSequence)((ArrayList)localObject).get(i))) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  @NonNull
  public QVipWatchWordConfig a(@NonNull araj[] paramArrayOfaraj)
  {
    QVipWatchWordConfig localQVipWatchWordConfig = null;
    String str = paramArrayOfaraj[0].a;
    paramArrayOfaraj = localQVipWatchWordConfig;
    if (!TextUtils.isEmpty(str))
    {
      localQVipWatchWordConfig = (QVipWatchWordConfig)awfy.a(str, QVipWatchWordConfig.class);
      paramArrayOfaraj = localQVipWatchWordConfig;
      if (QLog.isColorLevel())
      {
        QLog.d("QVipWatchWordProcessor", 2, "content:" + str + " config:" + localQVipWatchWordConfig.toString());
        paramArrayOfaraj = localQVipWatchWordConfig;
      }
    }
    return paramArrayOfaraj;
  }
  
  @NonNull
  public QVipWatchWordConfig b()
  {
    return new QVipWatchWordConfig();
  }
  
  @NonNull
  public QVipWatchWordConfig c()
  {
    return new QVipWatchWordConfig();
  }
  
  public Class<QVipWatchWordConfig> clazz()
  {
    return QVipWatchWordConfig.class;
  }
  
  public int type()
  {
    return 648;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arom
 * JD-Core Version:    0.7.0.1
 */