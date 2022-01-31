import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.manager.BaseLibManager.1;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class bdoa
{
  private static int jdField_a_of_type_Int = 2;
  private static bdoa jdField_a_of_type_Bdoa;
  public static final String a;
  private static byte[] jdField_a_of_type_ArrayOfByte;
  public static final String b;
  private List<bdoe> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  static
  {
    jdField_a_of_type_JavaLangString = MiniAppEnv.g().getContext().getFilesDir().getPath() + "/minigame/";
    jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + ".baseengine";
    jdField_a_of_type_ArrayOfByte = new byte[0];
  }
  
  private bdoa()
  {
    File localFile = new File(jdField_b_of_type_JavaLangString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  public static bdoa a()
  {
    if (jdField_a_of_type_Bdoa == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Bdoa == null) {
        jdField_a_of_type_Bdoa = new bdoa();
      }
      return jdField_a_of_type_Bdoa;
    }
  }
  
  public static BaseLibInfo a()
  {
    Object localObject = bdhg.a("MiniGame", "MiniGameBaseLib", "{\"key1\":\"https://d3g.qq.com/sngapp/app/update/20190708174635_6988/lib-1.4.7.zip\",\"key2\":\"\",\"key3\":\"1.4.7\",\"key4\": {\"file_length\": 6336933},\"key5\":2}");
    bdnw.b("minigame", "MiniEng getWnsGameBaseLibInfo " + (String)localObject);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      try
      {
        localObject = BaseLibInfo.fromJSON(new JSONObject((String)localObject));
        return localObject;
      }
      catch (Exception localException)
      {
        bdnw.d("minigame", "MiniEng getWnsGameBaseLibInfo failed", localException);
      }
    }
    return null;
  }
  
  private Boolean a(BaseLibInfo paramBaseLibInfo)
  {
    if (paramBaseLibInfo == null) {
      return Boolean.valueOf(false);
    }
    String str = bdzf.a().getString("version", "1.10.0.00173");
    return Boolean.valueOf(BaseLibInfo.needUpdateVersion(paramBaseLibInfo.baseLibVersion, str));
  }
  
  private void a(int paramInt)
  {
    try
    {
      Object localObject1 = new ArrayList(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_JavaUtilList.clear();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((bdoe)((Iterator)localObject1).next()).a(paramInt);
      }
      this.jdField_a_of_type_Boolean = false;
    }
    finally {}
  }
  
  private boolean a(File paramFile, String[] paramArrayOfString)
  {
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory())) {}
    for (;;)
    {
      return false;
      if ((paramArrayOfString != null) && (paramArrayOfString.length != 0))
      {
        int i = 0;
        try
        {
          for (;;)
          {
            if (i >= paramArrayOfString.length) {
              break label77;
            }
            File localFile = new File(paramFile, paramArrayOfString[i]);
            if (!localFile.exists()) {
              break;
            }
            boolean bool = localFile.isDirectory();
            if (bool) {
              break;
            }
            i += 1;
          }
          label77:
          return true;
        }
        catch (Throwable paramFile)
        {
          bdnw.d("miniapp-process_BaseLibManager", "isBaseLibDirValid exception!", paramFile);
        }
      }
    }
    return false;
  }
  
  private boolean d(File paramFile)
  {
    boolean bool2 = true;
    if ((paramFile == null) || (!paramFile.exists()) || (paramFile.isFile())) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      try
      {
        localObject1 = new File(paramFile, "verify.json");
        bool1 = bool2;
        if (((File)localObject1).exists())
        {
          bool1 = bool2;
          if (((File)localObject1).isFile())
          {
            localObject1 = new JSONObject(bdgo.b((File)localObject1));
            bool1 = bool2;
            if (((JSONObject)localObject1).has("verify_list"))
            {
              localObject1 = ((JSONObject)localObject1).getJSONArray("verify_list");
              i = 0;
            }
          }
        }
      }
      catch (Exception paramFile)
      {
        for (;;)
        {
          Object localObject1;
          int i;
          Object localObject2;
          String str;
          int j;
          long l;
          bdnw.d("miniapp-start", "ApkgManager--verifyBaselib exception.", paramFile);
          bool1 = false;
          continue;
          bool1 = true;
          continue;
          i += 1;
        }
      }
    }
    if (i < ((JSONArray)localObject1).length())
    {
      if (((JSONArray)localObject1).get(i) == null)
      {
        bdnw.d("miniapp-start", "配置文件格式异常！！请使用json工具检测");
        break label279;
      }
      localObject2 = (JSONObject)((JSONArray)localObject1).get(i);
      str = ((JSONObject)localObject2).getString("name");
      j = ((JSONObject)localObject2).getInt("length");
      localObject2 = new File(paramFile, str);
      bdnw.b("miniapp-start", "ApkgManager--verifyBaselib file: " + str + " config_length=" + j + " local_length=" + ((File)localObject2).length());
      if ((((File)localObject2).exists()) && (((File)localObject2).isFile()))
      {
        l = ((File)localObject2).length();
        if (l == j) {
          break label279;
        }
      }
      bool1 = false;
      return bool1;
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    return bdly.jdField_b_of_type_JavaLangString + File.separator + bdyv.c(paramString1) + "_" + paramString2 + ".zip";
  }
  
  public void a(bdoe parambdoe)
  {
    try
    {
      bdew.a().post(new BaseLibManager.1(this, parambdoe));
      return;
    }
    finally
    {
      parambdoe = finally;
      throw parambdoe;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, bdoe parambdoe)
  {
    bdnw.b("miniapp-process_BaseLibManager", "doDownloadBaselib url=" + paramString1 + " version=" + paramString2 + " oldUrl=" + paramString3 + " oldVersion=" + paramString4);
    bdsu.a(bddc.a(), 4, null, null, null, 0);
    String str = a(paramString1, paramString2);
    ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(paramString1, null, str, 60, new bdod(this, parambdoe, paramString1, paramString2, paramString4, str, paramString3));
  }
  
  public boolean a()
  {
    String str = a().b("mini", "1.10.0.00173");
    if (a().a(str))
    {
      bdnw.b("miniapp-process_BaseLibManager", "[MiniEng] inner baseLib already installed, version:1.10.0.00173");
      return true;
    }
    int j = bdhg.a("MiniApp", "mini_app_inner_baselib_retry_count", jdField_a_of_type_Int);
    bdnw.b("miniapp-process_BaseLibManager", "[MiniEng]installInnerBaseLib, version:1.10.0.00173, totalCount:" + j);
    int i = 0;
    while (i < j)
    {
      boolean bool = bdyi.a(MiniAppEnv.g().getContext(), "mini", str);
      if ((bool) && (a().a(str)))
      {
        bdnw.b("miniapp-process_BaseLibManager", "[MiniEng] install inner baseLib success, from mini to " + str + ", tryCount:" + i + ", totalCount:" + j);
        return bool;
      }
      File localFile = new File(str);
      if (localFile.exists()) {
        bdgo.a(localFile);
      }
      bdnw.c("miniapp-process_BaseLibManager", "[MiniEng] install inner baseLib fail, from mini to " + str + ", tryCount:" + i + ", totalCount:" + j);
      i += 1;
    }
    return false;
  }
  
  public boolean a(File paramFile)
  {
    return a(paramFile, new String[] { "QView.js", "QLogic.js", "QVConsole.js", "QRemoteDebug.js", "QWebview.js" });
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        if (b(paramString))
        {
          boolean bool = c(paramString);
          if (bool) {
            return true;
          }
        }
      }
      catch (Throwable paramString)
      {
        bdnw.d("miniapp-process_BaseLibManager", "isBaseLibDirValid path, exception!", paramString);
      }
    }
    return false;
  }
  
  public BaseLibInfo b()
  {
    BaseLibInfo localBaseLibInfo = new BaseLibInfo();
    String str = bdzf.a().getString("downloadUrl", null);
    localBaseLibInfo.baseLibVersion = bdzf.a().getString("version", "1.10.0.00173");
    localBaseLibInfo.baseLibUrl = str;
    return localBaseLibInfo;
  }
  
  public String b(String paramString1, String paramString2)
  {
    return bdly.a(paramString1, paramString2);
  }
  
  public boolean b(File paramFile)
  {
    return a(paramFile, new String[] { "QGame.js", "QGameOpenDataContext.js", "QGameWorkerContext.js" });
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      boolean bool = a(new File(paramString));
      return bool;
    }
    catch (Throwable paramString)
    {
      bdnw.d("miniapp-process_BaseLibManager", "isBaseLibDirValid4MiniApp path, exception!", paramString);
    }
    return false;
  }
  
  public boolean c(File paramFile)
  {
    return (a(paramFile)) && (b(paramFile));
  }
  
  public boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      boolean bool = b(new File(paramString));
      return bool;
    }
    catch (Throwable paramString)
    {
      bdnw.d("miniapp-process_BaseLibManager", "isBaseLibDirValid4MiniGame path, exception!", paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdoa
 * JD-Core Version:    0.7.0.1
 */