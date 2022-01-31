import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import org.json.JSONException;
import org.json.JSONObject;

public class amze
  extends amyp<QVipBigTroopExpiredConfig>
{
  public static QVipBigTroopExpiredConfig c()
  {
    QVipBigTroopExpiredConfig localQVipBigTroopExpiredConfig2 = (QVipBigTroopExpiredConfig)ampl.a().a(428);
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
  public QVipBigTroopExpiredConfig a(amph[] paramArrayOfamph)
  {
    boolean bool = true;
    localQVipBigTroopExpiredConfig = new QVipBigTroopExpiredConfig();
    paramArrayOfamph = paramArrayOfamph[0].a;
    try
    {
      if (!TextUtils.isEmpty(paramArrayOfamph))
      {
        paramArrayOfamph = new JSONObject(paramArrayOfamph);
        if (paramArrayOfamph.optInt("enable", 1) != 1) {
          break label164;
        }
      }
      for (;;)
      {
        localQVipBigTroopExpiredConfig.mIsEnable = bool;
        localQVipBigTroopExpiredConfig.mNotifyTipsMaxDay = paramArrayOfamph.optInt("NotifyTipsMaxDay", 15);
        localQVipBigTroopExpiredConfig.mNotifyTipsMinDay = paramArrayOfamph.optInt("NotifyTipsMinDay", 7);
        localQVipBigTroopExpiredConfig.mNotifyTipsMaxCount = paramArrayOfamph.optInt("NotifyTipsMaxCount", 2);
        localQVipBigTroopExpiredConfig.mNotifyTipsPerDay = paramArrayOfamph.optInt("NotifyTipsPerDay", 1);
        localQVipBigTroopExpiredConfig.mNotifyTipsMaxCloseCount = paramArrayOfamph.optInt("NotifyTipsMaxCloseCount", 3);
        localQVipBigTroopExpiredConfig.mNotifyDialogMaxDay = paramArrayOfamph.optInt("NotifyDialogMaxDay", 7);
        localQVipBigTroopExpiredConfig.mNotifyDialogMinDay = paramArrayOfamph.optInt("NotifyDialogMinDay", 0);
        localQVipBigTroopExpiredConfig.mNotifyDialogMaxCount = paramArrayOfamph.optInt("NotifyDialogMaxCount", 2);
        localQVipBigTroopExpiredConfig.mNotifyDialogPerDay = paramArrayOfamph.optInt("NotifyDialogPerDay", 1);
        localQVipBigTroopExpiredConfig.mNotifyDialogExpiredIntervalDay = paramArrayOfamph.optInt("NotifyDialogExpiredIntervalDay", 5);
        return localQVipBigTroopExpiredConfig;
        label164:
        bool = false;
      }
      return localQVipBigTroopExpiredConfig;
    }
    catch (JSONException paramArrayOfamph)
    {
      ved.e("QVipBigTroopExpiredProcessor", "QVipBigTroopExpiredConfig onParsed exception :" + paramArrayOfamph.getMessage());
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
 * Qualified Name:     amze
 * JD-Core Version:    0.7.0.1
 */