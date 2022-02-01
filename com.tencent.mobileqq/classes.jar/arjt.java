import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.business.qvip.QQLevelIconConfig;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arjt
  extends arjj<QQLevelIconConfig>
{
  public static QQLevelIconConfig c()
  {
    QQLevelIconConfig localQQLevelIconConfig2 = (QQLevelIconConfig)aqxe.a().a(542);
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
  public QQLevelIconConfig a(aqxa[] paramArrayOfaqxa)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("QQLevelIconProcessor", 1, paramArrayOfaqxa[0].a);
    }
    QQLevelIconConfig localQQLevelIconConfig = new QQLevelIconConfig();
    paramArrayOfaqxa = paramArrayOfaqxa[0].a;
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramArrayOfaqxa))
        {
          paramArrayOfaqxa = new JSONObject(paramArrayOfaqxa);
          if (paramArrayOfaqxa.optInt("newguideswitch", 1) != 1) {
            continue;
          }
          bool1 = true;
          localQQLevelIconConfig.mIsEnableGuide = bool1;
          bool1 = bool2;
          if (paramArrayOfaqxa.optInt("rushfeeswitch", 1) == 1) {
            bool1 = true;
          }
          localQQLevelIconConfig.mIsNotifyPayment = bool1;
          localQQLevelIconConfig.mNotifyPaymentText = paramArrayOfaqxa.optString("rushfeetips", localQQLevelIconConfig.mNotifyPaymentText);
          localQQLevelIconConfig.mExpiredNotifyPaymentText = paramArrayOfaqxa.optString("expiredtips", localQQLevelIconConfig.mExpiredNotifyPaymentText);
        }
      }
      catch (JSONException paramArrayOfaqxa)
      {
        boolean bool1;
        ykq.e("QQLevelIconProcessor", "QVipBigClubSVIP9Config onParsed exception :" + paramArrayOfaqxa.getMessage());
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
 * Qualified Name:     arjt
 * JD-Core Version:    0.7.0.1
 */