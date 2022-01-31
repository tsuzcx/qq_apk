import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class bdfx
  extends bdmk
{
  public bdml a;
  private Map<String, String> a;
  private Map<String, Bitmap> b;
  
  public bdfx()
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
  }
  
  public bdfx(String paramString, MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    super(paramString, paramMiniAppBaseInfo);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
  }
  
  public static bdfx a(String paramString1, String paramString2, MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    if ((TextUtils.isEmpty(paramString1)) || (!new File(paramString1).exists())) {
      return null;
    }
    paramString1 = new bdfx(paramString1, paramMiniAppBaseInfo);
    paramString1.a(paramString2);
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
    if (MiniAppEnv.g().getBaselibLoader().isBaseLibInit()) {
      str = MiniAppEnv.g().getBaselibLoader().getBaselib().g;
    }
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    return "<!DOCTYPE html><html lang=\"zh-CN\"><head><meta charset=\"UTF-8\" /><meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\" /><meta http-equiv=\"Content-Security-Policy\" content=\"script-src 'self' 'unsafe-inline' 'unsafe-eval'\"><link rel=\"icon\" href=\"data:image/ico;base64,aWNv\"><script></script></head><body><div></div></body></html>";
  }
  
  public bdfy a()
  {
    Object localObject = new File(e(), "page-frame.html");
    bdfy localbdfy = new bdfy();
    if (!((File)localObject).exists())
    {
      localbdfy.jdField_a_of_type_JavaLangString = b();
      return localbdfy;
    }
    try
    {
      localObject = bdgo.a((File)localObject);
      String str = ((String)localObject).substring(((String)localObject).indexOf("<script>") + "<script>".length(), ((String)localObject).indexOf("</script>"));
      localbdfy.jdField_a_of_type_JavaLangString = ((String)localObject);
      localbdfy.jdField_b_of_type_JavaLangString = str;
      return localbdfy;
    }
    catch (Exception localException) {}
    return localbdfy;
  }
  
  public bdml a()
  {
    return this.jdField_a_of_type_Bdml;
  }
  
  public String a()
  {
    return e() + "/" + "app-service.js";
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        this.jdField_b_of_type_JavaLangString = bdgo.b(new File(e() + "/" + paramString, "app-config.json"));
        paramString = new JSONObject(this.jdField_b_of_type_JavaLangString);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("USER_DATA_PATH", "wxfile://usr");
        paramString.put("env", localJSONObject);
        this.jdField_b_of_type_JavaLangString = paramString.toString();
        this.jdField_a_of_type_Bdml = bdml.a(this.jdField_b_of_type_JavaLangString);
        return;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
      this.jdField_b_of_type_JavaLangString = bdgo.b(new File(e(), "app-config.json"));
    }
  }
  
  public boolean a(String paramString)
  {
    paramString = bdgj.a(paramString);
    Object localObject = this.jdField_a_of_type_Bdml.jdField_a_of_type_Bdni;
    if (localObject != null)
    {
      localObject = ((bdni)localObject).a.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((bdnj)((Iterator)localObject).next()).jdField_a_of_type_JavaLangString.equals(paramString)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean a(String paramString, MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    paramString = c(paramString);
    if (TextUtils.isEmpty(paramString)) {}
    boolean bool;
    do
    {
      return true;
      paramString = new File(bdep.a(paramMiniAppBaseInfo, false), paramString).getAbsolutePath();
      bool = new File(paramString).exists();
      bdnw.a("ApkgInfo", "isUrlResReady | subFolderPath :" + paramString + "isExist:" + bool);
    } while (bool);
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
      String str3 = bdgo.b(new File(e(), str2));
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
      paramString = bdgj.a(paramString);
    } while ((!a(paramString)) && (!paramString.equals(this.jdField_a_of_type_Bdml.jdField_a_of_type_JavaLangString)));
    return true;
  }
  
  public String c(String paramString)
  {
    return this.jdField_a_of_type_Bdml.a(paramString);
  }
  
  public boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!new File(g(bdgj.a(paramString))).exists()) {
      return false;
    }
    return true;
  }
  
  public String d()
  {
    File localFile = new File(new File(e()), "app-wxss.js");
    if (localFile.exists()) {
      return bdgo.a(localFile);
    }
    return "";
  }
  
  public String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return e() + "/" + "app-service.js";
    }
    return new File(new File(e(), paramString), "app-service.js").getAbsolutePath();
  }
  
  public String e(String paramString)
  {
    return bdgo.a(new File(d(paramString)));
  }
  
  public String f(String paramString)
  {
    paramString = this.jdField_a_of_type_Bdml.a(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = new File(new File(e(), paramString), "page-frame.js");
    if (paramString.exists()) {
      return bdgo.a(paramString);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdfx
 * JD-Core Version:    0.7.0.1
 */