import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.business.qvip.SSOErrorInfoMapConfig;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class aorp
  extends aopw<SSOErrorInfoMapConfig>
{
  public static SSOErrorInfoMapConfig c()
  {
    SSOErrorInfoMapConfig localSSOErrorInfoMapConfig2 = (SSOErrorInfoMapConfig)aogj.a().a(477);
    SSOErrorInfoMapConfig localSSOErrorInfoMapConfig1 = localSSOErrorInfoMapConfig2;
    if (localSSOErrorInfoMapConfig2 == null) {
      localSSOErrorInfoMapConfig1 = new SSOErrorInfoMapConfig();
    }
    return localSSOErrorInfoMapConfig1;
  }
  
  public int a()
  {
    return 477;
  }
  
  @NonNull
  public SSOErrorInfoMapConfig a()
  {
    return new SSOErrorInfoMapConfig();
  }
  
  @NonNull
  public SSOErrorInfoMapConfig a(aogf[] paramArrayOfaogf)
  {
    SSOErrorInfoMapConfig localSSOErrorInfoMapConfig = new SSOErrorInfoMapConfig();
    paramArrayOfaogf = paramArrayOfaogf[0].a;
    for (;;)
    {
      String str1;
      aorn localaorn;
      String str2;
      aoro localaoro;
      try
      {
        if (!TextUtils.isEmpty(paramArrayOfaogf))
        {
          paramArrayOfaogf = new JSONObject(paramArrayOfaogf);
          Iterator localIterator1 = paramArrayOfaogf.keys();
          if (localIterator1.hasNext())
          {
            str1 = (String)localIterator1.next();
            JSONObject localJSONObject1 = paramArrayOfaogf.optJSONObject(str1);
            Iterator localIterator2 = localJSONObject1.keys();
            localaorn = new aorn();
            if (!localIterator2.hasNext()) {
              break label220;
            }
            str2 = (String)localIterator2.next();
            JSONObject localJSONObject2 = localJSONObject1.optJSONObject(str2);
            Iterator localIterator3 = localJSONObject2.keys();
            localaoro = new aoro();
            if (!localIterator3.hasNext()) {
              break label204;
            }
            String str3 = (String)localIterator3.next();
            String str4 = localJSONObject2.optString(str3);
            localaoro.a.put(str3, str4);
            continue;
          }
        }
        return localSSOErrorInfoMapConfig;
      }
      catch (JSONException paramArrayOfaogf)
      {
        wsv.e("SSOErrorInfoMapProcessor", "SSOErrorInfoMapConfig onParsed exception :" + paramArrayOfaogf.getMessage());
      }
      label204:
      localaorn.a.put(str2, localaoro);
      continue;
      label220:
      localSSOErrorInfoMapConfig.mErrorMap.put(str1, localaorn);
    }
  }
  
  public Class<SSOErrorInfoMapConfig> a()
  {
    return SSOErrorInfoMapConfig.class;
  }
  
  @NonNull
  public SSOErrorInfoMapConfig b()
  {
    return new SSOErrorInfoMapConfig();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aorp
 * JD-Core Version:    0.7.0.1
 */