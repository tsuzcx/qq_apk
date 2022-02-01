import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.business.qvip.QVipGiftConfig;
import com.tencent.qphone.base.util.QLog;

public class aqhd
  extends aqgc<QVipGiftConfig>
{
  public static QVipGiftConfig a()
  {
    QVipGiftConfig localQVipGiftConfig2 = (QVipGiftConfig)apub.a().a(667);
    QVipGiftConfig localQVipGiftConfig1 = localQVipGiftConfig2;
    if (localQVipGiftConfig2 == null) {
      localQVipGiftConfig1 = new QVipGiftConfig();
    }
    return localQVipGiftConfig1;
  }
  
  @NonNull
  public QVipGiftConfig a(@NonNull aptx[] paramArrayOfaptx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVIP.SDK.QVipGfitProcessor", 1, paramArrayOfaptx[0].a);
    }
    Object localObject = null;
    String str = paramArrayOfaptx[0].a;
    paramArrayOfaptx = localObject;
    if (!TextUtils.isEmpty(str)) {
      paramArrayOfaptx = (QVipGiftConfig)ausy.a(str, QVipGiftConfig.class);
    }
    return paramArrayOfaptx;
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
 * Qualified Name:     aqhd
 * JD-Core Version:    0.7.0.1
 */