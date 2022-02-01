import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.business.qvip.QVipFeatureConfig;
import com.tencent.qphone.base.util.QLog;

public class arkf
  extends arjj<QVipFeatureConfig>
{
  @NonNull
  public QVipFeatureConfig a()
  {
    return new QVipFeatureConfig();
  }
  
  @NonNull
  public QVipFeatureConfig a(@NonNull aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVIP.SDK.QVipFeatureProcessor", 1, paramArrayOfaqxa[0].a);
    }
    try
    {
      paramArrayOfaqxa = paramArrayOfaqxa[0].a;
      if (!TextUtils.isEmpty(paramArrayOfaqxa))
      {
        paramArrayOfaqxa = (QVipFeatureConfig)avyx.a(paramArrayOfaqxa, QVipFeatureConfig.class);
        a(paramArrayOfaqxa.enableSplashAnim);
        return paramArrayOfaqxa;
      }
    }
    catch (Exception paramArrayOfaqxa)
    {
      paramArrayOfaqxa.printStackTrace();
    }
    return new QVipFeatureConfig();
  }
  
  public void a(boolean paramBoolean)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("banner_and_splash", 4).edit().putBoolean("splashAnim", paramBoolean).commit();
  }
  
  @NonNull
  public QVipFeatureConfig b()
  {
    return new QVipFeatureConfig();
  }
  
  public Class<QVipFeatureConfig> clazz()
  {
    return QVipFeatureConfig.class;
  }
  
  public int type()
  {
    return 690;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arkf
 * JD-Core Version:    0.7.0.1
 */