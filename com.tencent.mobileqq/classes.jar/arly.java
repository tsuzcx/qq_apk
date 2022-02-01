import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.business.qvip.SSOErrorInfoMapConfig;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class arly
  extends arjj<SSOErrorInfoMapConfig>
{
  public static SSOErrorInfoMapConfig c()
  {
    SSOErrorInfoMapConfig localSSOErrorInfoMapConfig2 = (SSOErrorInfoMapConfig)aqxe.a().a(477);
    SSOErrorInfoMapConfig localSSOErrorInfoMapConfig1 = localSSOErrorInfoMapConfig2;
    if (localSSOErrorInfoMapConfig2 == null) {
      localSSOErrorInfoMapConfig1 = new SSOErrorInfoMapConfig();
    }
    return localSSOErrorInfoMapConfig1;
  }
  
  @NonNull
  public SSOErrorInfoMapConfig a()
  {
    return new SSOErrorInfoMapConfig();
  }
  
  @NonNull
  public SSOErrorInfoMapConfig a(aqxa[] paramArrayOfaqxa)
  {
    SSOErrorInfoMapConfig localSSOErrorInfoMapConfig = new SSOErrorInfoMapConfig();
    paramArrayOfaqxa = paramArrayOfaqxa[0].a;
    for (;;)
    {
      String str1;
      arlw localarlw;
      String str2;
      arlx localarlx;
      try
      {
        if (!TextUtils.isEmpty(paramArrayOfaqxa))
        {
          paramArrayOfaqxa = new JSONObject(paramArrayOfaqxa);
          Iterator localIterator1 = paramArrayOfaqxa.keys();
          if (localIterator1.hasNext())
          {
            str1 = (String)localIterator1.next();
            JSONObject localJSONObject1 = paramArrayOfaqxa.optJSONObject(str1);
            Iterator localIterator2 = localJSONObject1.keys();
            localarlw = new arlw();
            if (!localIterator2.hasNext()) {
              break label220;
            }
            str2 = (String)localIterator2.next();
            JSONObject localJSONObject2 = localJSONObject1.optJSONObject(str2);
            Iterator localIterator3 = localJSONObject2.keys();
            localarlx = new arlx();
            if (!localIterator3.hasNext()) {
              break label204;
            }
            String str3 = (String)localIterator3.next();
            String str4 = localJSONObject2.optString(str3);
            localarlx.a.put(str3, str4);
            continue;
          }
        }
        return localSSOErrorInfoMapConfig;
      }
      catch (JSONException paramArrayOfaqxa)
      {
        ykq.e("SSOErrorInfoMapProcessor", "SSOErrorInfoMapConfig onParsed exception :" + paramArrayOfaqxa.getMessage());
      }
      label204:
      localarlw.a.put(str2, localarlx);
      continue;
      label220:
      localSSOErrorInfoMapConfig.mErrorMap.put(str1, localarlw);
    }
  }
  
  @NonNull
  public SSOErrorInfoMapConfig b()
  {
    return new SSOErrorInfoMapConfig();
  }
  
  public Class<SSOErrorInfoMapConfig> clazz()
  {
    return SSOErrorInfoMapConfig.class;
  }
  
  public int type()
  {
    return 477;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arly
 * JD-Core Version:    0.7.0.1
 */