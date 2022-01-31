import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.model.ApkgBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.AppConfigInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.TabBarInfo;
import com.tencent.qqmini.sdk.launcher.model.TabBarInfo.ButtonInfo;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.log.QMLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class bgod
  extends ApkgBaseInfo
{
  public AppConfigInfo a;
  private Map<String, String> a;
  private Map<String, Bitmap> b = new HashMap();
  
  public bgod()
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public bgod(String paramString, MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    super(paramString, paramMiniAppBaseInfo);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static bgod a(String paramString1, String paramString2, MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    if ((TextUtils.isEmpty(paramString1)) || (!new File(paramString1).exists())) {
      return null;
    }
    paramString1 = new bgod(paramString1, paramMiniAppBaseInfo);
    paramString1.init(paramString2);
    return paramString1;
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      int j = paramString.indexOf("?");
      int i = j;
      if (j == -1) {
        i = paramString.length();
      }
      str = paramString.substring(0, i);
    }
    return str;
  }
  
  public static String c()
  {
    String str = null;
    if (AppLoaderFactory.g().getMiniAppEnv().getBaselibLoader().isBaseLibInit()) {
      str = AppLoaderFactory.g().getMiniAppEnv().getBaselibLoader().getBaselib().pageFrameStr;
    }
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    return "<!DOCTYPE html><html lang=\"zh-CN\"><head><meta charset=\"UTF-8\" /><meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\" /><meta http-equiv=\"Content-Security-Policy\" content=\"script-src 'self' 'unsafe-inline' 'unsafe-eval'\"><link rel=\"icon\" href=\"data:image/ico;base64,aWNv\"><script></script></head><body><div></div></body></html>";
  }
  
  public bgoe a()
  {
    Object localObject = new File(getApkgFolderPath(), "page-frame.html");
    bgoe localbgoe = new bgoe();
    if (!((File)localObject).exists())
    {
      localbgoe.a = b();
      return localbgoe;
    }
    try
    {
      localObject = bgpc.a((File)localObject);
      String str = ((String)localObject).substring(((String)localObject).indexOf("<script>") + "<script>".length(), ((String)localObject).indexOf("</script>"));
      localbgoe.a = ((String)localObject);
      localbgoe.b = str;
      return localbgoe;
    }
    catch (Exception localException) {}
    return localbgoe;
  }
  
  public AppConfigInfo a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelAppConfigInfo;
  }
  
  public String a()
  {
    return getApkgFolderPath() + "/" + "app-service.js";
  }
  
  public boolean a(String paramString)
  {
    paramString = bgos.a(paramString);
    Object localObject = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelAppConfigInfo.tabBarInfo;
    if (localObject != null)
    {
      localObject = ((TabBarInfo)localObject).list.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((TabBarInfo.ButtonInfo)((Iterator)localObject).next()).pagePath.equals(paramString)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      if ((TextUtils.isEmpty(paramString)) || ((!paramString.startsWith("https://")) && (!paramString.startsWith("wss://")) && (!paramString.startsWith("ws://")) && (!paramString.startsWith("http://")))) {}
    }
    while ((!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("https://")) || (paramString.startsWith("wss://"))))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public String b()
  {
    return c();
  }
  
  public String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = "";
    }
    String str2;
    String str1;
    do
    {
      return paramString;
      str2 = a(paramString);
      str1 = (String)this.jdField_a_of_type_JavaUtilMap.get(str2);
      paramString = str1;
    } while (!TextUtils.isEmpty(str1));
    paramString = str1;
    try
    {
      String str3 = bgpc.b(new File(getApkgFolderPath(), str2));
      paramString = str1;
      str1 = str3.substring(str3.indexOf("<script>") + "<script>".length(), str3.indexOf("</script>"));
      paramString = str1;
      this.jdField_a_of_type_JavaUtilMap.put(str2, str1);
      return str1;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return paramString;
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = bgos.a(paramString);
    } while ((!a(paramString)) && (!paramString.equals(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelAppConfigInfo.entryPagePath)));
    return true;
  }
  
  public String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return getApkgFolderPath() + "/" + "app-service.js";
    }
    return new File(new File(getApkgFolderPath(), paramString), "app-service.js").getAbsolutePath();
  }
  
  public boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!new File(getChildFileAbsolutePath(bgos.a(paramString))).exists()) {
      return false;
    }
    return true;
  }
  
  public String d()
  {
    File localFile = new File(new File(getApkgFolderPath()), "app-wxss.js");
    if (localFile.exists()) {
      return bgpc.a(localFile);
    }
    return "";
  }
  
  public String d(String paramString)
  {
    return bgpc.a(new File(c(paramString)));
  }
  
  public String e(String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelAppConfigInfo.getRootPath(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = new File(new File(getApkgFolderPath(), paramString), "page-frame.js");
    if (paramString.exists()) {
      return bgpc.a(paramString);
    }
    return "";
  }
  
  public String getRootPath(String paramString)
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelAppConfigInfo.getRootPath(paramString);
  }
  
  public String getWorkerPath(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return getApkgFolderPath() + File.separator + paramString2;
    }
    return new File(new File(getApkgFolderPath(), paramString1), paramString2).getAbsolutePath();
  }
  
  public void init(String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        this.mConfigStr = bgpc.b(new File(getApkgFolderPath() + "/" + paramString, "app-config.json"));
        paramString = new JSONObject(this.mConfigStr);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("USER_DATA_PATH", "wxfile://usr");
        paramString.put("env", localJSONObject);
        this.mConfigStr = paramString.toString();
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelAppConfigInfo = AppConfigInfo.parseAppConfig(paramString);
        return;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
      this.mConfigStr = bgpc.b(new File(getApkgFolderPath(), "app-config.json"));
    }
  }
  
  public boolean isUrlResReady(String paramString, MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    paramString = getRootPath(paramString);
    if (TextUtils.isEmpty(paramString)) {}
    boolean bool;
    do
    {
      return true;
      paramString = new File(bgno.a(paramMiniAppBaseInfo, false), paramString).getAbsolutePath();
      bool = new File(paramString).exists();
      QMLog.d("ApkgInfo", "isUrlResReady | subFolderPath :" + paramString + "isExist:" + bool);
    } while (bool);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgod
 * JD-Core Version:    0.7.0.1
 */