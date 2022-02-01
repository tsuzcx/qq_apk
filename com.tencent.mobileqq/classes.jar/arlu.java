import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.business.qvip.QVipTroopNickConfig;
import com.tencent.qphone.base.util.QLog;

public class arlu
  extends arjj<QVipTroopNickConfig>
{
  @NonNull
  public static QVipTroopNickConfig c()
  {
    QVipTroopNickConfig localQVipTroopNickConfig2 = (QVipTroopNickConfig)aqxe.a().a(684);
    QVipTroopNickConfig localQVipTroopNickConfig1 = localQVipTroopNickConfig2;
    if (localQVipTroopNickConfig2 == null) {
      localQVipTroopNickConfig1 = new QVipTroopNickConfig();
    }
    return localQVipTroopNickConfig1;
  }
  
  @NonNull
  public QVipTroopNickConfig a()
  {
    return new QVipTroopNickConfig();
  }
  
  @NonNull
  public QVipTroopNickConfig a(@NonNull aqxa[] paramArrayOfaqxa)
  {
    Object localObject = null;
    String str = paramArrayOfaqxa[0].a;
    paramArrayOfaqxa = (aqxa[])localObject;
    if (!TextUtils.isEmpty(str))
    {
      localObject = (QVipTroopNickConfig)avyx.a(str, QVipTroopNickConfig.class);
      paramArrayOfaqxa = (aqxa[])localObject;
      if (QLog.isColorLevel())
      {
        QLog.d("QVipTroopNickConfig", 2, "content:" + str + " config:" + localObject.toString());
        paramArrayOfaqxa = (aqxa[])localObject;
      }
    }
    localObject = paramArrayOfaqxa;
    if (paramArrayOfaqxa == null) {
      localObject = new QVipTroopNickConfig();
    }
    return localObject;
  }
  
  @NonNull
  public QVipTroopNickConfig b()
  {
    return new QVipTroopNickConfig();
  }
  
  public Class<QVipTroopNickConfig> clazz()
  {
    return QVipTroopNickConfig.class;
  }
  
  public int type()
  {
    return 684;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arlu
 * JD-Core Version:    0.7.0.1
 */