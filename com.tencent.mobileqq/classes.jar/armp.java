import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.business.qvip.QQLevelIconConfig;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class armp
  extends armf<QQLevelIconConfig>
{
  public static QQLevelIconConfig c()
  {
    QQLevelIconConfig localQQLevelIconConfig2 = (QQLevelIconConfig)aran.a().a(542);
    QQLevelIconConfig localQQLevelIconConfig1 = localQQLevelIconConfig2;
    if (localQQLevelIconConfig2 == null) {
      localQQLevelIconConfig1 = new QQLevelIconConfig();
    }
    return localQQLevelIconConfig1;
  }
  
  @NonNull
  public QQLevelIconConfig a()
  {
    return new QQLevelIconConfig();
  }
  
  @NonNull
  public QQLevelIconConfig a(araj[] paramArrayOfaraj)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("QQLevelIconProcessor", 1, paramArrayOfaraj[0].a);
    }
    QQLevelIconConfig localQQLevelIconConfig = new QQLevelIconConfig();
    paramArrayOfaraj = paramArrayOfaraj[0].a;
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramArrayOfaraj))
        {
          paramArrayOfaraj = new JSONObject(paramArrayOfaraj);
          if (paramArrayOfaraj.optInt("newguideswitch", 1) != 1) {
            continue;
          }
          bool1 = true;
          localQQLevelIconConfig.mIsEnableGuide = bool1;
          bool1 = bool2;
          if (paramArrayOfaraj.optInt("rushfeeswitch", 1) == 1) {
            bool1 = true;
          }
          localQQLevelIconConfig.mIsNotifyPayment = bool1;
          localQQLevelIconConfig.mNotifyPaymentText = paramArrayOfaraj.optString("rushfeetips", localQQLevelIconConfig.mNotifyPaymentText);
          localQQLevelIconConfig.mExpiredNotifyPaymentText = paramArrayOfaraj.optString("expiredtips", localQQLevelIconConfig.mExpiredNotifyPaymentText);
        }
      }
      catch (JSONException paramArrayOfaraj)
      {
        boolean bool1;
        yuk.e("QQLevelIconProcessor", "QVipBigClubSVIP9Config onParsed exception :" + paramArrayOfaraj.getMessage());
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.e("QQLevelIconProcessor", 1, " : " + localQQLevelIconConfig.toString());
      }
      return localQQLevelIconConfig;
      bool1 = false;
    }
  }
  
  @NonNull
  public QQLevelIconConfig b()
  {
    return new QQLevelIconConfig();
  }
  
  public Class<QQLevelIconConfig> clazz()
  {
    return QQLevelIconConfig.class;
  }
  
  public int type()
  {
    return 542;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     armp
 * JD-Core Version:    0.7.0.1
 */