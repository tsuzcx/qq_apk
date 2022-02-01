import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import org.json.JSONException;
import org.json.JSONObject;

public class armu
  extends armf<QVipBigTroopExpiredConfig>
{
  public static QVipBigTroopExpiredConfig c()
  {
    QVipBigTroopExpiredConfig localQVipBigTroopExpiredConfig2 = (QVipBigTroopExpiredConfig)aran.a().a(428);
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
  public QVipBigTroopExpiredConfig a(araj[] paramArrayOfaraj)
  {
    boolean bool = true;
    localQVipBigTroopExpiredConfig = new QVipBigTroopExpiredConfig();
    paramArrayOfaraj = paramArrayOfaraj[0].a;
    try
    {
      if (!TextUtils.isEmpty(paramArrayOfaraj))
      {
        paramArrayOfaraj = new JSONObject(paramArrayOfaraj);
        if (paramArrayOfaraj.optInt("enable", 1) != 1) {
          break label164;
        }
      }
      for (;;)
      {
        localQVipBigTroopExpiredConfig.mIsEnable = bool;
        localQVipBigTroopExpiredConfig.mNotifyTipsMaxDay = paramArrayOfaraj.optInt("NotifyTipsMaxDay", 15);
        localQVipBigTroopExpiredConfig.mNotifyTipsMinDay = paramArrayOfaraj.optInt("NotifyTipsMinDay", 7);
        localQVipBigTroopExpiredConfig.mNotifyTipsMaxCount = paramArrayOfaraj.optInt("NotifyTipsMaxCount", 2);
        localQVipBigTroopExpiredConfig.mNotifyTipsPerDay = paramArrayOfaraj.optInt("NotifyTipsPerDay", 1);
        localQVipBigTroopExpiredConfig.mNotifyTipsMaxCloseCount = paramArrayOfaraj.optInt("NotifyTipsMaxCloseCount", 3);
        localQVipBigTroopExpiredConfig.mNotifyDialogMaxDay = paramArrayOfaraj.optInt("NotifyDialogMaxDay", 7);
        localQVipBigTroopExpiredConfig.mNotifyDialogMinDay = paramArrayOfaraj.optInt("NotifyDialogMinDay", 0);
        localQVipBigTroopExpiredConfig.mNotifyDialogMaxCount = paramArrayOfaraj.optInt("NotifyDialogMaxCount", 2);
        localQVipBigTroopExpiredConfig.mNotifyDialogPerDay = paramArrayOfaraj.optInt("NotifyDialogPerDay", 1);
        localQVipBigTroopExpiredConfig.mNotifyDialogExpiredIntervalDay = paramArrayOfaraj.optInt("NotifyDialogExpiredIntervalDay", 5);
        return localQVipBigTroopExpiredConfig;
        label164:
        bool = false;
      }
      return localQVipBigTroopExpiredConfig;
    }
    catch (JSONException paramArrayOfaraj)
    {
      yuk.e("QVipBigTroopExpiredProcessor", "QVipBigTroopExpiredConfig onParsed exception :" + paramArrayOfaraj.getMessage());
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
 * Qualified Name:     armu
 * JD-Core Version:    0.7.0.1
 */