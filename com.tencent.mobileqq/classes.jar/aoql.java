import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import org.json.JSONException;
import org.json.JSONObject;

public class aoql
  extends aopw<QVipBigTroopExpiredConfig>
{
  public static QVipBigTroopExpiredConfig c()
  {
    QVipBigTroopExpiredConfig localQVipBigTroopExpiredConfig2 = (QVipBigTroopExpiredConfig)aogj.a().a(428);
    QVipBigTroopExpiredConfig localQVipBigTroopExpiredConfig1 = localQVipBigTroopExpiredConfig2;
    if (localQVipBigTroopExpiredConfig2 == null) {
      localQVipBigTroopExpiredConfig1 = new QVipBigTroopExpiredConfig();
    }
    return localQVipBigTroopExpiredConfig1;
  }
  
  public int a()
  {
    return 428;
  }
  
  @NonNull
  public QVipBigTroopExpiredConfig a()
  {
    return new QVipBigTroopExpiredConfig();
  }
  
  @NonNull
  public QVipBigTroopExpiredConfig a(aogf[] paramArrayOfaogf)
  {
    boolean bool = true;
    localQVipBigTroopExpiredConfig = new QVipBigTroopExpiredConfig();
    paramArrayOfaogf = paramArrayOfaogf[0].a;
    try
    {
      if (!TextUtils.isEmpty(paramArrayOfaogf))
      {
        paramArrayOfaogf = new JSONObject(paramArrayOfaogf);
        if (paramArrayOfaogf.optInt("enable", 1) != 1) {
          break label164;
        }
      }
      for (;;)
      {
        localQVipBigTroopExpiredConfig.mIsEnable = bool;
        localQVipBigTroopExpiredConfig.mNotifyTipsMaxDay = paramArrayOfaogf.optInt("NotifyTipsMaxDay", 15);
        localQVipBigTroopExpiredConfig.mNotifyTipsMinDay = paramArrayOfaogf.optInt("NotifyTipsMinDay", 7);
        localQVipBigTroopExpiredConfig.mNotifyTipsMaxCount = paramArrayOfaogf.optInt("NotifyTipsMaxCount", 2);
        localQVipBigTroopExpiredConfig.mNotifyTipsPerDay = paramArrayOfaogf.optInt("NotifyTipsPerDay", 1);
        localQVipBigTroopExpiredConfig.mNotifyTipsMaxCloseCount = paramArrayOfaogf.optInt("NotifyTipsMaxCloseCount", 3);
        localQVipBigTroopExpiredConfig.mNotifyDialogMaxDay = paramArrayOfaogf.optInt("NotifyDialogMaxDay", 7);
        localQVipBigTroopExpiredConfig.mNotifyDialogMinDay = paramArrayOfaogf.optInt("NotifyDialogMinDay", 0);
        localQVipBigTroopExpiredConfig.mNotifyDialogMaxCount = paramArrayOfaogf.optInt("NotifyDialogMaxCount", 2);
        localQVipBigTroopExpiredConfig.mNotifyDialogPerDay = paramArrayOfaogf.optInt("NotifyDialogPerDay", 1);
        localQVipBigTroopExpiredConfig.mNotifyDialogExpiredIntervalDay = paramArrayOfaogf.optInt("NotifyDialogExpiredIntervalDay", 5);
        return localQVipBigTroopExpiredConfig;
        label164:
        bool = false;
      }
      return localQVipBigTroopExpiredConfig;
    }
    catch (JSONException paramArrayOfaogf)
    {
      wsv.e("QVipBigTroopExpiredProcessor", "QVipBigTroopExpiredConfig onParsed exception :" + paramArrayOfaogf.getMessage());
    }
  }
  
  public Class<QVipBigTroopExpiredConfig> a()
  {
    return QVipBigTroopExpiredConfig.class;
  }
  
  @NonNull
  public QVipBigTroopExpiredConfig b()
  {
    return new QVipBigTroopExpiredConfig();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoql
 * JD-Core Version:    0.7.0.1
 */