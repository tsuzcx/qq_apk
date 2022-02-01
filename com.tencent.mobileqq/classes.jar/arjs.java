import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.business.qvip.QQFriendRelation2Config;
import org.json.JSONException;
import org.json.JSONObject;

public class arjs
  extends arjj<QQFriendRelation2Config>
{
  public static QQFriendRelation2Config c()
  {
    QQFriendRelation2Config localQQFriendRelation2Config2 = (QQFriendRelation2Config)aqxe.a().a(491);
    QQFriendRelation2Config localQQFriendRelation2Config1 = localQQFriendRelation2Config2;
    if (localQQFriendRelation2Config2 == null) {
      localQQFriendRelation2Config1 = new QQFriendRelation2Config();
    }
    return localQQFriendRelation2Config1;
  }
  
  @NonNull
  public QQFriendRelation2Config a()
  {
    return new QQFriendRelation2Config();
  }
  
  @NonNull
  public QQFriendRelation2Config a(aqxa[] paramArrayOfaqxa)
  {
    boolean bool = true;
    localQQFriendRelation2Config = new QQFriendRelation2Config();
    paramArrayOfaqxa = paramArrayOfaqxa[0].a;
    try
    {
      if (!TextUtils.isEmpty(paramArrayOfaqxa)) {
        if (new JSONObject(paramArrayOfaqxa).optInt("enable", 1) != 1) {
          break label49;
        }
      }
      for (;;)
      {
        localQQFriendRelation2Config.mIsEnable = bool;
        return localQQFriendRelation2Config;
        label49:
        bool = false;
      }
      return localQQFriendRelation2Config;
    }
    catch (JSONException paramArrayOfaqxa)
    {
      ykq.e("QQFriendRelation2Processor", "QQFriendRelation2Config onParsed exception :" + paramArrayOfaqxa.getMessage());
    }
  }
  
  @NonNull
  public QQFriendRelation2Config b()
  {
    return new QQFriendRelation2Config();
  }
  
  public Class<QQFriendRelation2Config> clazz()
  {
    return QQFriendRelation2Config.class;
  }
  
  public int type()
  {
    return 491;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arjs
 * JD-Core Version:    0.7.0.1
 */