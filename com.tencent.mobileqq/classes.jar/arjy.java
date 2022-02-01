import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import org.json.JSONException;
import org.json.JSONObject;

public class arjy
  extends arjj<QVipBigTroopExpiredConfig>
{
  public static QVipBigTroopExpiredConfig c()
  {
    QVipBigTroopExpiredConfig localQVipBigTroopExpiredConfig2 = (QVipBigTroopExpiredConfig)aqxe.a().a(428);
    QVipBigTroopExpiredConfig localQVipBigTroopExpiredConfig1 = localQVipBigTroopExpiredConfig2;
    if (localQVipBigTroopExpiredConfig2 == null) {
      localQVipBigTroopExpiredConfig1 = new QVipBigTroopExpiredConfig();
    }
    return localQVipBigTroopExpiredConfig1;
  }
  
  @NonNull
  public QVipBigTroopExpiredConfig a()
  {
    return new QVipBigTroopExpiredConfig();
  }
  
  @NonNull
  public QVipBigTroopExpiredConfig a(aqxa[] paramArrayOfaqxa)
  {
    boolean bool = true;
    localQVipBigTroopExpiredConfig = new QVipBigTroopExpiredConfig();
    paramArrayOfaqxa = paramArrayOfaqxa[0].a;
    try
    {
      if (!TextUtils.isEmpty(paramArrayOfaqxa))
      {
        paramArrayOfaqxa = new JSONObject(paramArrayOfaqxa);
        if (paramArrayOfaqxa.optInt("enable", 1) != 1) {
          break label164;
        }
      }
      for (;;)
      {
        localQVipBigTroopExpiredConfig.mIsEnable = bool;
        localQVipBigTroopExpiredConfig.mNotifyTipsMaxDay = paramArrayOfaqxa.optInt("NotifyTipsMaxDay", 15);
        localQVipBigTroopExpiredConfig.mNotifyTipsMinDay = paramArrayOfaqxa.optInt("NotifyTipsMinDay", 7);
        localQVipBigTroopExpiredConfig.mNotifyTipsMaxCount = paramArrayOfaqxa.optInt("NotifyTipsMaxCount", 2);
        localQVipBigTroopExpiredConfig.mNotifyTipsPerDay = paramArrayOfaqxa.optInt("NotifyTipsPerDay", 1);
        localQVipBigTroopExpiredConfig.mNotifyTipsMaxCloseCount = paramArrayOfaqxa.optInt("NotifyTipsMaxCloseCount", 3);
        localQVipBigTroopExpiredConfig.mNotifyDialogMaxDay = paramArrayOfaqxa.optInt("NotifyDialogMaxDay", 7);
        localQVipBigTroopExpiredConfig.mNotifyDialogMinDay = paramArrayOfaqxa.optInt("NotifyDialogMinDay", 0);
        localQVipBigTroopExpiredConfig.mNotifyDialogMaxCount = paramArrayOfaqxa.optInt("NotifyDialogMaxCount", 2);
        localQVipBigTroopExpiredConfig.mNotifyDialogPerDay = paramArrayOfaqxa.optInt("NotifyDialogPerDay", 1);
        localQVipBigTroopExpiredConfig.mNotifyDialogExpiredIntervalDay = paramArrayOfaqxa.optInt("NotifyDialogExpiredIntervalDay", 5);
        return localQVipBigTroopExpiredConfig;
        label164:
        bool = false;
      }
      return localQVipBigTroopExpiredConfig;
    }
    catch (JSONException paramArrayOfaqxa)
    {
      ykq.e("QVipBigTroopExpiredProcessor", "QVipBigTroopExpiredConfig onParsed exception :" + paramArrayOfaqxa.getMessage());
    }
  }
  
  @NonNull
  public QVipBigTroopExpiredConfig b()
  {
    return new QVipBigTroopExpiredConfig();
  }
  
  public Class<QVipBigTroopExpiredConfig> clazz()
  {
    return QVipBigTroopExpiredConfig.class;
  }
  
  public int type()
  {
    return 428;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arjy
 * JD-Core Version:    0.7.0.1
 */