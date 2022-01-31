import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.business.qvip.QQLevelIconConfig;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aoqg
  extends aopw<QQLevelIconConfig>
{
  public static QQLevelIconConfig c()
  {
    QQLevelIconConfig localQQLevelIconConfig2 = (QQLevelIconConfig)aogj.a().a(542);
    QQLevelIconConfig localQQLevelIconConfig1 = localQQLevelIconConfig2;
    if (localQQLevelIconConfig2 == null) {
      localQQLevelIconConfig1 = new QQLevelIconConfig();
    }
    return localQQLevelIconConfig1;
  }
  
  public int a()
  {
    return 542;
  }
  
  @NonNull
  public QQLevelIconConfig a()
  {
    return new QQLevelIconConfig();
  }
  
  @NonNull
  public QQLevelIconConfig a(aogf[] paramArrayOfaogf)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("QQLevelIconProcessor", 1, paramArrayOfaogf[0].a);
    }
    QQLevelIconConfig localQQLevelIconConfig = new QQLevelIconConfig();
    paramArrayOfaogf = paramArrayOfaogf[0].a;
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramArrayOfaogf))
        {
          paramArrayOfaogf = new JSONObject(paramArrayOfaogf);
          if (paramArrayOfaogf.optInt("newguideswitch", 1) != 1) {
            continue;
          }
          bool1 = true;
          localQQLevelIconConfig.mIsEnableGuide = bool1;
          bool1 = bool2;
          if (paramArrayOfaogf.optInt("rushfeeswitch", 1) == 1) {
            bool1 = true;
          }
          localQQLevelIconConfig.mIsNotifyPayment = bool1;
          localQQLevelIconConfig.mNotifyPaymentText = paramArrayOfaogf.optString("rushfeetips", localQQLevelIconConfig.mNotifyPaymentText);
          localQQLevelIconConfig.mExpiredNotifyPaymentText = paramArrayOfaogf.optString("expiredtips", localQQLevelIconConfig.mExpiredNotifyPaymentText);
        }
      }
      catch (JSONException paramArrayOfaogf)
      {
        boolean bool1;
        wsv.e("QQLevelIconProcessor", "QVipBigClubSVIP9Config onParsed exception :" + paramArrayOfaogf.getMessage());
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.e("QQLevelIconProcessor", 1, " : " + localQQLevelIconConfig.toString());
      }
      return localQQLevelIconConfig;
      bool1 = false;
    }
  }
  
  public Class<QQLevelIconConfig> a()
  {
    return QQLevelIconConfig.class;
  }
  
  @NonNull
  public QQLevelIconConfig b()
  {
    return new QQLevelIconConfig();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoqg
 * JD-Core Version:    0.7.0.1
 */