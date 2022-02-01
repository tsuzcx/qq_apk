import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.business.qvip.QVipFeatureConfig;
import com.tencent.qphone.base.util.QLog;

public class aqgy
  extends aqgc<QVipFeatureConfig>
{
  @NonNull
  public QVipFeatureConfig a()
  {
    return new QVipFeatureConfig();
  }
  
  @NonNull
  public QVipFeatureConfig a(@NonNull aptx[] paramArrayOfaptx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVIP.SDK.QVipFeatureProcessor", 1, paramArrayOfaptx[0].a);
    }
    Object localObject = null;
    try
    {
      String str = paramArrayOfaptx[0].a;
      paramArrayOfaptx = localObject;
      if (!TextUtils.isEmpty(str)) {
        paramArrayOfaptx = (QVipFeatureConfig)ausy.a(str, QVipFeatureConfig.class);
      }
      a(paramArrayOfaptx.enableSplashAnim);
      return paramArrayOfaptx;
    }
    catch (Exception paramArrayOfaptx)
    {
      paramArrayOfaptx.printStackTrace();
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
 * Qualified Name:     aqgy
 * JD-Core Version:    0.7.0.1
 */