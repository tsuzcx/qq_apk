import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.business.qvip.SSOErrorInfoMapConfig;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class arop
  extends armf<SSOErrorInfoMapConfig>
{
  public static SSOErrorInfoMapConfig c()
  {
    SSOErrorInfoMapConfig localSSOErrorInfoMapConfig2 = (SSOErrorInfoMapConfig)aran.a().a(477);
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
  public SSOErrorInfoMapConfig a(araj[] paramArrayOfaraj)
  {
    SSOErrorInfoMapConfig localSSOErrorInfoMapConfig = new SSOErrorInfoMapConfig();
    paramArrayOfaraj = paramArrayOfaraj[0].a;
    for (;;)
    {
      String str1;
      aron localaron;
      String str2;
      aroo localaroo;
      try
      {
        if (!TextUtils.isEmpty(paramArrayOfaraj))
        {
          paramArrayOfaraj = new JSONObject(paramArrayOfaraj);
          Iterator localIterator1 = paramArrayOfaraj.keys();
          if (localIterator1.hasNext())
          {
            str1 = (String)localIterator1.next();
            JSONObject localJSONObject1 = paramArrayOfaraj.optJSONObject(str1);
            Iterator localIterator2 = localJSONObject1.keys();
            localaron = new aron();
            if (!localIterator2.hasNext()) {
              break label220;
            }
            str2 = (String)localIterator2.next();
            JSONObject localJSONObject2 = localJSONObject1.optJSONObject(str2);
            Iterator localIterator3 = localJSONObject2.keys();
            localaroo = new aroo();
            if (!localIterator3.hasNext()) {
              break label204;
            }
            String str3 = (String)localIterator3.next();
            String str4 = localJSONObject2.optString(str3);
            localaroo.a.put(str3, str4);
            continue;
          }
        }
        return localSSOErrorInfoMapConfig;
      }
      catch (JSONException paramArrayOfaraj)
      {
        yuk.e("SSOErrorInfoMapProcessor", "SSOErrorInfoMapConfig onParsed exception :" + paramArrayOfaraj.getMessage());
      }
      label204:
      localaron.a.put(str2, localaroo);
      continue;
      label220:
      localSSOErrorInfoMapConfig.mErrorMap.put(str1, localaron);
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
 * Qualified Name:     arop
 * JD-Core Version:    0.7.0.1
 */