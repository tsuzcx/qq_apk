import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.DomainUtil.1;
import com.tencent.qqmini.sdk.utils.DomainUtil.2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bfgm
{
  private static String jdField_a_of_type_JavaLangString;
  private static ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private static ConcurrentHashMap<Integer, ArrayList<berp>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "Request", "Websocket", "Download", "Upload", "Webview" };
  
  private static ArrayList<String> a()
  {
    try
    {
      if (jdField_a_of_type_JavaUtilArrayList == null)
      {
        String str1 = bema.a("MiniGame", "MiniGameDomainWhiteList", "\\S*\\.qq\\.com,thirdqq\\.qlogo\\.cn,c\\d{4}\\.myh5\\.90wmoyu\\.com,\\S*\\.gtimg\\.cn");
        if ((str1 != null) && (!str1.equals(jdField_a_of_type_JavaLangString)))
        {
          betc.b("[mini] http.", "Default white domain:" + str1);
          jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          try
          {
            String[] arrayOfString = str1.split(",");
            if (arrayOfString != null)
            {
              int j = arrayOfString.length;
              int i = 0;
              while (i < j)
              {
                String str2 = arrayOfString[i];
                if (!TextUtils.isEmpty(str2)) {
                  jdField_a_of_type_JavaUtilArrayList.add(str2);
                }
                i += 1;
              }
            }
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
            jdField_a_of_type_JavaLangString = str1;
          }
        }
      }
      return jdField_a_of_type_JavaUtilArrayList;
    }
    finally {}
  }
  
  private static void a(berp paramberp, int paramInt)
  {
    if (paramberp == null) {}
    ArrayList localArrayList1;
    do
    {
      return;
      if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      }
      ArrayList localArrayList2 = (ArrayList)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
      localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localArrayList1);
      }
    } while (localArrayList1.contains(paramberp));
    localArrayList1.add(paramberp);
  }
  
  private static boolean a(berp paramberp, int paramInt)
  {
    if (paramberp == null) {
      return false;
    }
    Object localObject = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localObject == null) {
      return false;
    }
    localObject = (ArrayList)((Map)localObject).get(Integer.valueOf(paramInt));
    return (localObject != null) && (((ArrayList)localObject).contains(paramberp));
  }
  
  private static boolean a(MiniAppInfo paramMiniAppInfo)
  {
    return (paramMiniAppInfo != null) && (paramMiniAppInfo.verType == 3);
  }
  
  public static boolean a(MiniAppInfo paramMiniAppInfo, boolean paramBoolean, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (paramBoolean)
    {
      betc.a("[mini] http.domainValid", jdField_a_of_type_ArrayOfJavaLangString[paramInt] + ":域名检查 skipDomainCheckFromJs:" + paramString);
      return true;
    }
    if (paramMiniAppInfo.skipDomainCheck == 1) {}
    for (int i = 1; i != 0; i = 0)
    {
      betc.a("[mini] http.domainValid", jdField_a_of_type_ArrayOfJavaLangString[paramInt] + ":域名检查 skip:" + paramString);
      return true;
    }
    Object localObject1 = paramString.toLowerCase();
    if ((!a(paramMiniAppInfo)) && (a(paramMiniAppInfo.appId)))
    {
      if (!a((String)localObject1, true))
      {
        betc.a("[mini] http.domainValid", jdField_a_of_type_ArrayOfJavaLangString[paramInt] + "域名不合法，需使用https或wss协议:" + paramString);
        return false;
      }
      betc.a("[mini] http.domainValid", "debug opened and not online version, skip:" + paramString);
      return true;
    }
    if ((((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) && (paramString.startsWith(bema.a("MiniApp", "MiniAppRMDDomainWhiteList", "https://www.urlshare.cn/"))))
    {
      betc.a("[mini] http.domainValid", "rdm mode, https://www.urlshare.cn/ is valid, current Url is: " + paramString);
      return true;
    }
    if (!a((String)localObject1, false))
    {
      betc.d("[mini] http.domainValid", jdField_a_of_type_ArrayOfJavaLangString[paramInt] + ":请求域名不合法，请使用https或wss协议,reqeustUrl:" + paramString);
      if (!a(paramMiniAppInfo))
      {
        bejn.c().post(new DomainUtil.1(paramInt, (String)localObject1));
        return false;
      }
      return false;
    }
    berp localberp = berp.a((String)localObject1);
    if (a(localberp, paramInt)) {
      return true;
    }
    if ((localberp != null) && (!TextUtils.isEmpty(localberp.jdField_a_of_type_JavaLangString)))
    {
      localObject1 = a().iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          Pattern localPattern = Pattern.compile((String)((Iterator)localObject1).next(), 2);
          if (localPattern == null) {
            continue;
          }
          try
          {
            paramBoolean = localPattern.matcher(localberp.jdField_a_of_type_JavaLangString).matches();
            if (paramBoolean)
            {
              a(localberp, paramInt);
              return true;
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              betc.d("[mini] http.domainValid", "", localException);
              paramBoolean = false;
            }
          }
        }
      }
      if (paramMiniAppInfo != null)
      {
        localObject1 = paramMiniAppInfo.requestDomainList;
        switch (paramInt)
        {
        default: 
          if (localObject1 != null) {
            localObject1 = ((List)localObject1).iterator();
          }
          break;
        case 1: 
        case 2: 
        case 3: 
        case 4: 
          for (;;)
          {
            for (;;)
            {
              if (!((Iterator)localObject1).hasNext()) {
                break label660;
              }
              Object localObject2 = (String)((Iterator)localObject1).next();
              try
              {
                if (!TextUtils.isEmpty((CharSequence)localObject2))
                {
                  localObject2 = berp.a(((String)localObject2).toLowerCase());
                  if (berp.a((berp)localObject2, localberp))
                  {
                    a(localberp, paramInt);
                    return true;
                    localObject1 = paramMiniAppInfo.socketDomainList;
                    break;
                    localObject1 = paramMiniAppInfo.downloadFileDomainList;
                    break;
                    localObject1 = paramMiniAppInfo.uploadFileDomainList;
                    break;
                    localObject1 = paramMiniAppInfo.businessDomainList;
                    break;
                  }
                  betc.b("[mini] http.domainValid", "request:" + localberp + ",allow:" + localObject2);
                }
              }
              catch (Throwable localThrowable)
              {
                betc.d("[mini] http.domainValid", "check domainValid error, requestUrl:" + paramString, localThrowable);
              }
            }
          }
        }
      }
    }
    label660:
    betc.d("[mini] http.domainValid", jdField_a_of_type_ArrayOfJavaLangString[paramInt] + ":请求域名不合法，请配置，requestUrl:" + paramString);
    if (!a(paramMiniAppInfo))
    {
      bejn.c().post(new DomainUtil.2(paramInt, localberp));
      return false;
    }
    return false;
  }
  
  private static boolean a(String paramString)
  {
    return bfhm.a().getBoolean(paramString + "_debug", false);
  }
  
  private static boolean a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      if ((TextUtils.isEmpty(paramString)) || ((!paramString.startsWith("https://")) && (!paramString.startsWith("wss://")) && (!paramString.startsWith("http://")))) {}
    }
    while ((!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("https://")) || (paramString.startsWith("wss://"))))
    {
      return true;
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfgm
 * JD-Core Version:    0.7.0.1
 */