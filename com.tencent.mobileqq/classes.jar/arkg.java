import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.business.qvip.QVipFeatureSwitchConfig;
import com.tencent.qphone.base.util.QLog;

public class arkg
  extends arjj<QVipFeatureSwitchConfig>
{
  public static QVipFeatureSwitchConfig a()
  {
    return new QVipFeatureSwitchConfig();
  }
  
  @NonNull
  public QVipFeatureSwitchConfig a(@NonNull aqxa[] paramArrayOfaqxa)
  {
    QVipFeatureSwitchConfig localQVipFeatureSwitchConfig = null;
    String str = paramArrayOfaqxa[0].a;
    paramArrayOfaqxa = localQVipFeatureSwitchConfig;
    if (!TextUtils.isEmpty(str))
    {
      localQVipFeatureSwitchConfig = (QVipFeatureSwitchConfig)avyx.a(str, QVipFeatureSwitchConfig.class);
      paramArrayOfaqxa = localQVipFeatureSwitchConfig;
      if (QLog.isColorLevel())
      {
        QLog.d("QVipFeatureSwitchProcessor", 2, "content:" + str + " config:" + localQVipFeatureSwitchConfig.toString());
        paramArrayOfaqxa = localQVipFeatureSwitchConfig;
      }
    }
    return paramArrayOfaqxa;
  }
  
  @NonNull
  public QVipFeatureSwitchConfig b()
  {
    return new QVipFeatureSwitchConfig();
  }
  
  @NonNull
  public QVipFeatureSwitchConfig c()
  {
    return new QVipFeatureSwitchConfig();
  }
  
  public Class<QVipFeatureSwitchConfig> clazz()
  {
    return QVipFeatureSwitchConfig.class;
  }
  
  public int type()
  {
    return 648;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arkg
 * JD-Core Version:    0.7.0.1
 */