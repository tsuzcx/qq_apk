import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.business.qvip.QVipBigClubSVIP9Config;
import org.json.JSONException;
import org.json.JSONObject;

public class amzd
  extends amyp<QVipBigClubSVIP9Config>
{
  public static QVipBigClubSVIP9Config c()
  {
    QVipBigClubSVIP9Config localQVipBigClubSVIP9Config2 = (QVipBigClubSVIP9Config)ampl.a().a(427);
    QVipBigClubSVIP9Config localQVipBigClubSVIP9Config1 = localQVipBigClubSVIP9Config2;
    if (localQVipBigClubSVIP9Config2 == null) {
      localQVipBigClubSVIP9Config1 = new QVipBigClubSVIP9Config();
    }
    return localQVipBigClubSVIP9Config1;
  }
  
  public int a()
  {
    return 427;
  }
  
  @NonNull
  public QVipBigClubSVIP9Config a()
  {
    return new QVipBigClubSVIP9Config();
  }
  
  @NonNull
  public QVipBigClubSVIP9Config a(amph[] paramArrayOfamph)
  {
    boolean bool = true;
    localQVipBigClubSVIP9Config = new QVipBigClubSVIP9Config();
    paramArrayOfamph = paramArrayOfamph[0].a;
    try
    {
      if (!TextUtils.isEmpty(paramArrayOfamph))
      {
        paramArrayOfamph = new JSONObject(paramArrayOfamph);
        if (paramArrayOfamph.optInt("enable", 1) != 1) {
          break label93;
        }
      }
      for (;;)
      {
        localQVipBigClubSVIP9Config.mIsEnable = bool;
        localQVipBigClubSVIP9Config.mAPngIconUrl = paramArrayOfamph.optString("apng_icon_url_pattern", localQVipBigClubSVIP9Config.mAPngIconUrl);
        localQVipBigClubSVIP9Config.mAPngIconUrlNew_Gray = paramArrayOfamph.optString("apng_gray_icon_url_pattern", localQVipBigClubSVIP9Config.mAPngIconUrlNew_Gray);
        localQVipBigClubSVIP9Config.mVipIconSettingsUrl = paramArrayOfamph.optString("vipicon_setting_url_pattern", localQVipBigClubSVIP9Config.mVipIconSettingsUrl);
        return localQVipBigClubSVIP9Config;
        label93:
        bool = false;
      }
      return localQVipBigClubSVIP9Config;
    }
    catch (JSONException paramArrayOfamph)
    {
      ved.e("QVipBigTroopExpiredProcessor", "QVipBigClubSVIP9Config onParsed exception :" + paramArrayOfamph.getMessage());
    }
  }
  
  public Class<QVipBigClubSVIP9Config> a()
  {
    return QVipBigClubSVIP9Config.class;
  }
  
  @NonNull
  public QVipBigClubSVIP9Config b()
  {
    return new QVipBigClubSVIP9Config();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amzd
 * JD-Core Version:    0.7.0.1
 */