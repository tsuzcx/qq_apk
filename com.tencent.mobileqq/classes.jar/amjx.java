import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.business.qvip.SSOErrorInfoMapConfig;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class amjx
  extends amie<SSOErrorInfoMapConfig>
{
  public static SSOErrorInfoMapConfig c()
  {
    SSOErrorInfoMapConfig localSSOErrorInfoMapConfig2 = (SSOErrorInfoMapConfig)alzw.a().a(477);
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
  public SSOErrorInfoMapConfig a(alzs[] paramArrayOfalzs)
  {
    SSOErrorInfoMapConfig localSSOErrorInfoMapConfig = new SSOErrorInfoMapConfig();
    paramArrayOfalzs = paramArrayOfalzs[0].a;
    for (;;)
    {
      String str1;
      amjv localamjv;
      String str2;
      amjw localamjw;
      try
      {
        if (!TextUtils.isEmpty(paramArrayOfalzs))
        {
          paramArrayOfalzs = new JSONObject(paramArrayOfalzs);
          Iterator localIterator1 = paramArrayOfalzs.keys();
          if (localIterator1.hasNext())
          {
            str1 = (String)localIterator1.next();
            JSONObject localJSONObject1 = paramArrayOfalzs.optJSONObject(str1);
            Iterator localIterator2 = localJSONObject1.keys();
            localamjv = new amjv();
            if (!localIterator2.hasNext()) {
              break label220;
            }
            str2 = (String)localIterator2.next();
            JSONObject localJSONObject2 = localJSONObject1.optJSONObject(str2);
            Iterator localIterator3 = localJSONObject2.keys();
            localamjw = new amjw();
            if (!localIterator3.hasNext()) {
              break label204;
            }
            String str3 = (String)localIterator3.next();
            String str4 = localJSONObject2.optString(str3);
            localamjw.a.put(str3, str4);
            continue;
          }
        }
        return localSSOErrorInfoMapConfig;
      }
      catch (JSONException paramArrayOfalzs)
      {
        urk.e("SSOErrorInfoMapProcessor", "SSOErrorInfoMapConfig onParsed exception :" + paramArrayOfalzs.getMessage());
      }
      label204:
      localamjv.a.put(str2, localamjw);
      continue;
      label220:
      localSSOErrorInfoMapConfig.mErrorMap.put(str1, localamjv);
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
 * Qualified Name:     amjx
 * JD-Core Version:    0.7.0.1
 */