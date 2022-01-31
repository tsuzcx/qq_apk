import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class bekj
{
  public static int a(int paramInt)
  {
    String str1 = belj.a("MiniApp", "configSceneMap", "{}");
    besl.a("AppBrandUtil", "getWikiScene " + str1 + "  scene:" + paramInt);
    try
    {
      String str2 = new JSONObject(str1).optString(String.valueOf(paramInt));
      int i = paramInt;
      if (!TextUtils.isEmpty(str2)) {
        i = Integer.parseInt(str2);
      }
      return i;
    }
    catch (Exception localException)
    {
      besl.d("AppBrandUtil", "getWikiScene fail, " + str1 + "  scene:" + paramInt);
    }
    return paramInt;
  }
  
  private static int a(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.launchParam != null)) {
      return paramMiniAppInfo.launchParam.jdField_a_of_type_Int;
    }
    return 9999;
  }
  
  private static String a(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.launchParam != null)) {
      return paramMiniAppInfo.launchParam.h;
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return paramString;
      i = paramString.indexOf("?");
    } while (i == -1);
    return paramString.substring(0, i);
  }
  
  private static JSONObject a(MiniAppInfo paramMiniAppInfo)
  {
    JSONObject localJSONObject1;
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.launchParam != null))
    {
      JSONObject localJSONObject2 = new JSONObject();
      int i = paramMiniAppInfo.launchParam.jdField_a_of_type_Int;
      try
      {
        localJSONObject2.put("appId", paramMiniAppInfo.launchParam.f);
        if (i != 1037)
        {
          localJSONObject1 = localJSONObject2;
          if (i != 1038) {
            return localJSONObject1;
          }
        }
        paramMiniAppInfo = paramMiniAppInfo.launchParam.e;
        localJSONObject1 = localJSONObject2;
        if (TextUtils.isEmpty(paramMiniAppInfo)) {
          return localJSONObject1;
        }
        if (beks.a(paramMiniAppInfo))
        {
          localJSONObject2.put("extraData", new JSONObject(paramMiniAppInfo));
          return localJSONObject2;
        }
        localJSONObject2.put("extraData", paramMiniAppInfo);
        return localJSONObject2;
      }
      catch (Throwable paramMiniAppInfo)
      {
        besl.d("getReferrerInfo", "error,", paramMiniAppInfo);
        return localJSONObject2;
      }
    }
    else
    {
      localJSONObject1 = null;
    }
    return localJSONObject1;
  }
  
  public static JSONObject a(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      String str1;
      try
      {
        Iterator localIterator = Uri.parse("file:///" + paramString).getQueryParameterNames().iterator();
        if (localIterator.hasNext())
        {
          str1 = (String)localIterator.next();
          if (str1.startsWith("$"))
          {
            localObject2 = str1.substring(1);
            localObject1 = "[\\\\?&]" + "\\$";
            String str2 = "";
            localObject2 = Pattern.compile((String)localObject1 + (String)localObject2 + "=([^&#]*)").matcher(paramString);
            localObject1 = str2;
            if (((Matcher)localObject2).find()) {
              localObject1 = ((Matcher)localObject2).group(1);
            }
            localJSONObject.put(str1, localObject1);
          }
        }
        else
        {
          return localJSONObject;
        }
      }
      catch (Throwable paramString)
      {
        besl.d("AppBrandUtil", "getQueryJson err:", paramString);
      }
      Object localObject1 = "[\\\\?&]";
      Object localObject2 = str1;
    }
  }
  
  public static JSONObject a(String paramString, MiniAppInfo paramMiniAppInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("path", a(paramString));
        localJSONObject.put("query", a(paramString));
        localJSONObject.put("scene", a(a(paramMiniAppInfo)));
        localJSONObject.put("shareTicket", a(paramMiniAppInfo));
        localJSONObject.put("referrerInfo", a(paramMiniAppInfo));
        paramString = b(paramMiniAppInfo);
        if (!TextUtils.isEmpty(paramString))
        {
          boolean bool = beks.a(paramString);
          if (!bool) {}
        }
        else
        {
          try
          {
            localJSONObject.put("extendData", new JSONObject(paramString));
            localJSONObject.put("entryDataHash", c(paramMiniAppInfo));
            return localJSONObject;
          }
          catch (JSONException paramString)
          {
            besl.d("AppBrandUtil", "dispatch extendData parse error", paramString);
            continue;
          }
        }
        localJSONObject.put("extendData", paramString);
      }
      catch (Throwable paramString)
      {
        besl.d("AppBrandUtil", "getAppLaunchInfo error, ", paramString);
        return localJSONObject;
      }
    }
  }
  
  public static JSONObject a(String paramString1, String paramString2, MiniAppInfo paramMiniAppInfo)
  {
    localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("path", a(paramString1));
        localJSONObject.put("query", a(paramString1));
        localJSONObject.put("openType", paramString2);
        if ("appLaunch".equals(paramString2))
        {
          localJSONObject.put("scene", a(paramMiniAppInfo));
          localJSONObject.put("shareTicket", a(paramMiniAppInfo));
          localJSONObject.put("referrerInfo", a(paramMiniAppInfo));
          paramString1 = b(paramMiniAppInfo);
          if (!TextUtils.isEmpty(paramString1))
          {
            boolean bool = beks.a(paramString1);
            if (!bool) {
              continue;
            }
          }
        }
      }
      catch (Throwable paramString1)
      {
        besl.d("AppBrandUtil", "getPageShowInfo error, ", paramString1);
        continue;
        localJSONObject.put("extendData", paramString1);
        continue;
      }
      try
      {
        localJSONObject.put("extendData", new JSONObject(paramString1));
        besl.b("AppBrandUtil", "getPageLoadInfo : " + localJSONObject.toString());
        return localJSONObject;
      }
      catch (JSONException paramString1)
      {
        besl.d("AppBrandUtil", "dispatch extendData parse error", paramString1);
      }
    }
  }
  
  public static boolean a(MiniAppInfo paramMiniAppInfo1, MiniAppInfo paramMiniAppInfo2)
  {
    if ((paramMiniAppInfo1 != null) && (paramMiniAppInfo2 != null))
    {
      if ((paramMiniAppInfo1.versionId != null) && (!paramMiniAppInfo1.versionId.equals(paramMiniAppInfo2.versionId)) && (paramMiniAppInfo1.versionUpdateTime > 0) && (paramMiniAppInfo2.versionUpdateTime > paramMiniAppInfo1.versionUpdateTime))
      {
        besl.b("AppBrandUtil", "needUpdate=true oldVersionUpdateTime=" + paramMiniAppInfo1.versionUpdateTime + " newVersionUpdateTime=" + paramMiniAppInfo2.versionUpdateTime + " oldVersionId=" + paramMiniAppInfo1.versionId + " newVersionId=" + paramMiniAppInfo2.versionId);
        return true;
      }
      besl.b("AppBrandUtil", "needUpdate=false oldVersionUpdateTime=" + paramMiniAppInfo1.versionUpdateTime + " newVersionUpdateTime=" + paramMiniAppInfo2.versionUpdateTime + " oldVersionId=" + paramMiniAppInfo1.versionId + " newVersionId=" + paramMiniAppInfo2.versionId);
    }
    return false;
  }
  
  private static String b(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo != null) {
      return paramMiniAppInfo.extendData;
    }
    return null;
  }
  
  private static String c(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.launchParam != null) && (paramMiniAppInfo.launchParam.jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel != null)) {
      return paramMiniAppInfo.launchParam.jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel.a();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bekj
 * JD-Core Version:    0.7.0.1
 */