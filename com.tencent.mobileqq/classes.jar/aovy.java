import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.business.qvip.SSOErrorInfoMapConfig;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class aovy
  extends aouf<SSOErrorInfoMapConfig>
{
  public static SSOErrorInfoMapConfig c()
  {
    SSOErrorInfoMapConfig localSSOErrorInfoMapConfig2 = (SSOErrorInfoMapConfig)aoks.a().a(477);
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
  public SSOErrorInfoMapConfig a(aoko[] paramArrayOfaoko)
  {
    SSOErrorInfoMapConfig localSSOErrorInfoMapConfig = new SSOErrorInfoMapConfig();
    paramArrayOfaoko = paramArrayOfaoko[0].a;
    for (;;)
    {
      String str1;
      aovw localaovw;
      String str2;
      aovx localaovx;
      try
      {
        if (!TextUtils.isEmpty(paramArrayOfaoko))
        {
          paramArrayOfaoko = new JSONObject(paramArrayOfaoko);
          Iterator localIterator1 = paramArrayOfaoko.keys();
          if (localIterator1.hasNext())
          {
            str1 = (String)localIterator1.next();
            JSONObject localJSONObject1 = paramArrayOfaoko.optJSONObject(str1);
            Iterator localIterator2 = localJSONObject1.keys();
            localaovw = new aovw();
            if (!localIterator2.hasNext()) {
              break label220;
            }
            str2 = (String)localIterator2.next();
            JSONObject localJSONObject2 = localJSONObject1.optJSONObject(str2);
            Iterator localIterator3 = localJSONObject2.keys();
            localaovx = new aovx();
            if (!localIterator3.hasNext()) {
              break label204;
            }
            String str3 = (String)localIterator3.next();
            String str4 = localJSONObject2.optString(str3);
            localaovx.a.put(str3, str4);
            continue;
          }
        }
        return localSSOErrorInfoMapConfig;
      }
      catch (JSONException paramArrayOfaoko)
      {
        wxe.e("SSOErrorInfoMapProcessor", "SSOErrorInfoMapConfig onParsed exception :" + paramArrayOfaoko.getMessage());
      }
      label204:
      localaovw.a.put(str2, localaovx);
      continue;
      label220:
      localSSOErrorInfoMapConfig.mErrorMap.put(str1, localaovw);
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
 * Qualified Name:     aovy
 * JD-Core Version:    0.7.0.1
 */