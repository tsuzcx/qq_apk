import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.business.qvip.QVipGiftConfig;
import com.tencent.qphone.base.util.QLog;

public class arkl
  extends arjj<QVipGiftConfig>
{
  public static QVipGiftConfig a()
  {
    QVipGiftConfig localQVipGiftConfig2 = (QVipGiftConfig)aqxe.a().a(667);
    QVipGiftConfig localQVipGiftConfig1 = localQVipGiftConfig2;
    if (localQVipGiftConfig2 == null) {
      localQVipGiftConfig1 = new QVipGiftConfig();
    }
    return localQVipGiftConfig1;
  }
  
  @NonNull
  public QVipGiftConfig a(@NonNull aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVIP.SDK.QVipGfitProcessor", 1, paramArrayOfaqxa[0].a);
    }
    Object localObject = null;
    String str = paramArrayOfaqxa[0].a;
    paramArrayOfaqxa = localObject;
    if (!TextUtils.isEmpty(str)) {
      paramArrayOfaqxa = (QVipGiftConfig)avyx.a(str, QVipGiftConfig.class);
    }
    return paramArrayOfaqxa;
  }
  
  @NonNull
  public QVipGiftConfig b()
  {
    return new QVipGiftConfig();
  }
  
  @NonNull
  public QVipGiftConfig c()
  {
    return new QVipGiftConfig();
  }
  
  public Class<QVipGiftConfig> clazz()
  {
    return QVipGiftConfig.class;
  }
  
  public int type()
  {
    return 667;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arkl
 * JD-Core Version:    0.7.0.1
 */