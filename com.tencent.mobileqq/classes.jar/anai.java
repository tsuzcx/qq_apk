import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.business.qvip.SSOErrorInfoMapConfig;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class anai
  extends amyp<SSOErrorInfoMapConfig>
{
  public static SSOErrorInfoMapConfig c()
  {
    SSOErrorInfoMapConfig localSSOErrorInfoMapConfig2 = (SSOErrorInfoMapConfig)ampl.a().a(477);
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
  public SSOErrorInfoMapConfig a(amph[] paramArrayOfamph)
  {
    SSOErrorInfoMapConfig localSSOErrorInfoMapConfig = new SSOErrorInfoMapConfig();
    paramArrayOfamph = paramArrayOfamph[0].a;
    for (;;)
    {
      String str1;
      anag localanag;
      String str2;
      anah localanah;
      try
      {
        if (!TextUtils.isEmpty(paramArrayOfamph))
        {
          paramArrayOfamph = new JSONObject(paramArrayOfamph);
          Iterator localIterator1 = paramArrayOfamph.keys();
          if (localIterator1.hasNext())
          {
            str1 = (String)localIterator1.next();
            JSONObject localJSONObject1 = paramArrayOfamph.optJSONObject(str1);
            Iterator localIterator2 = localJSONObject1.keys();
            localanag = new anag();
            if (!localIterator2.hasNext()) {
              break label220;
            }
            str2 = (String)localIterator2.next();
            JSONObject localJSONObject2 = localJSONObject1.optJSONObject(str2);
            Iterator localIterator3 = localJSONObject2.keys();
            localanah = new anah();
            if (!localIterator3.hasNext()) {
              break label204;
            }
            String str3 = (String)localIterator3.next();
            String str4 = localJSONObject2.optString(str3);
            localanah.a.put(str3, str4);
            continue;
          }
        }
        return localSSOErrorInfoMapConfig;
      }
      catch (JSONException paramArrayOfamph)
      {
        ved.e("SSOErrorInfoMapProcessor", "SSOErrorInfoMapConfig onParsed exception :" + paramArrayOfamph.getMessage());
      }
      label204:
      localanag.a.put(str2, localanah);
      continue;
      label220:
      localSSOErrorInfoMapConfig.mErrorMap.put(str1, localanag);
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
 * Qualified Name:     anai
 * JD-Core Version:    0.7.0.1
 */