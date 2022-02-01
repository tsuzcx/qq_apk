import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.business.qvip.QVipBigClubSVIP9Config;
import org.json.JSONException;
import org.json.JSONObject;

public class arjx
  extends arjj<QVipBigClubSVIP9Config>
{
  public static QVipBigClubSVIP9Config c()
  {
    QVipBigClubSVIP9Config localQVipBigClubSVIP9Config2 = (QVipBigClubSVIP9Config)aqxe.a().a(427);
    QVipBigClubSVIP9Config localQVipBigClubSVIP9Config1 = localQVipBigClubSVIP9Config2;
    if (localQVipBigClubSVIP9Config2 == null) {
      localQVipBigClubSVIP9Config1 = new QVipBigClubSVIP9Config();
    }
    return localQVipBigClubSVIP9Config1;
  }
  
  @NonNull
  public QVipBigClubSVIP9Config a()
  {
    return new QVipBigClubSVIP9Config();
  }
  
  @NonNull
  public QVipBigClubSVIP9Config a(aqxa[] paramArrayOfaqxa)
  {
    boolean bool = true;
    localQVipBigClubSVIP9Config = new QVipBigClubSVIP9Config();
    paramArrayOfaqxa = paramArrayOfaqxa[0].a;
    try
    {
      if (!TextUtils.isEmpty(paramArrayOfaqxa))
      {
        paramArrayOfaqxa = new JSONObject(paramArrayOfaqxa);
        if (paramArrayOfaqxa.optInt("enable", 1) != 1) {
          break label93;
        }
      }
      for (;;)
      {
        localQVipBigClubSVIP9Config.mIsEnable = bool;
        localQVipBigClubSVIP9Config.mAPngIconUrl = paramArrayOfaqxa.optString("apng_icon_url_pattern", localQVipBigClubSVIP9Config.mAPngIconUrl);
        localQVipBigClubSVIP9Config.mAPngIconUrlNewGray = paramArrayOfaqxa.optString("apng_gray_icon_url_pattern", localQVipBigClubSVIP9Config.mAPngIconUrlNewGray);
        localQVipBigClubSVIP9Config.mVipIconSettingsUrl = paramArrayOfaqxa.optString("vipicon_setting_url_pattern", localQVipBigClubSVIP9Config.mVipIconSettingsUrl);
        return localQVipBigClubSVIP9Config;
        label93:
        bool = false;
      }
      return localQVipBigClubSVIP9Config;
    }
    catch (JSONException paramArrayOfaqxa)
    {
      ykq.e("QVipBigTroopExpiredProcessor", "QVipBigClubSVIP9Config onParsed exception :" + paramArrayOfaqxa.getMessage());
    }
  }
  
  @NonNull
  public QVipBigClubSVIP9Config b()
  {
    return new QVipBigClubSVIP9Config();
  }
  
  public Class<QVipBigClubSVIP9Config> clazz()
  {
    return QVipBigClubSVIP9Config.class;
  }
  
  public int type()
  {
    return 427;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arjx
 * JD-Core Version:    0.7.0.1
 */