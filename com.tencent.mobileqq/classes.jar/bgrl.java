import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.manager.BaseLibManager.1;
import com.tencent.qqmini.sdk.utils.AssetsUtil;
import com.tencent.qqmini.sdk.utils.MD5Utils;
import com.tencent.qqmini.sdk.utils.StorageUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class bgrl
{
  private static int jdField_a_of_type_Int = 2;
  private static bgrl jdField_a_of_type_Bgrl;
  public static final String a;
  private static byte[] jdField_a_of_type_ArrayOfByte;
  public static final String b;
  private List<bgrp> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  static
  {
    jdField_a_of_type_JavaLangString = AppLoaderFactory.g().getMiniAppEnv().getContext().getFilesDir().getPath() + "/minigame/";
    jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + ".baseengine";
    jdField_a_of_type_ArrayOfByte = new byte[0];
  }
  
  private bgrl()
  {
    File localFile = new File(jdField_b_of_type_JavaLangString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  public static bgrl a()
  {
    if (jdField_a_of_type_Bgrl == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Bgrl == null) {
        jdField_a_of_type_Bgrl = new bgrl();
      }
      return jdField_a_of_type_Bgrl;
    }
  }
  
  public static BaseLibInfo a()
  {
    Object localObject = bglq.a("qqtriton", "MiniGameBaseLib", "{\"key1\":\"https://d3g.qq.com/sngapp/app/update/20190708174635_6988/lib-1.4.7.zip\",\"key2\":\"\",\"key3\":\"1.4.7\",\"key4\": {\"file_length\": 6336933},\"key5\":2}");
    QMLog.i("minigame", "MiniEng getWnsGameBaseLibInfo " + (String)localObject);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      try
      {
        localObject = BaseLibInfo.fromJSON(new JSONObject((String)localObject));
        return localObject;
      }
      catch (Exception localException)
      {
        QMLog.e("minigame", "MiniEng getWnsGameBaseLibInfo failed", localException);
      }
    }
    return null;
  }
  
  private Boolean a(BaseLibInfo paramBaseLibInfo)
  {
    if (paramBaseLibInfo == null) {
      return Boolean.valueOf(false);
    }
    String str = StorageUtil.getPreference().getString("version", "1.14.0.00225");
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
        ((bgrp)((Iterator)localObject1).next()).a(paramInt);
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
          QMLog.e("miniapp-process_BaseLibManager", "isBaseLibDirValid exception!", paramFile);
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
            localObject1 = new JSONObject(bgkv.b((File)localObject1));
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
          QMLog.e("miniapp-start", "ApkgManager--verifyBaselib exception.", paramFile);
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
        QMLog.e("miniapp-start", "配置文件格式异常！！请使用json工具检测");
        break label281;
      }
      localObject2 = (JSONObject)((JSONArray)localObject1).get(i);
      str = ((JSONObject)localObject2).getString("name");
      j = ((JSONObject)localObject2).getInt("length");
      localObject2 = new File(paramFile, str);
      QMLog.i("miniapp-start", "ApkgManager--verifyBaselib file: " + str + " config_length=" + j + " local_length=" + ((File)localObject2).length());
      if ((((File)localObject2).exists()) && (((File)localObject2).isFile()))
      {
        l = ((File)localObject2).length();
        if (l == j) {
          break label281;
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
    return MiniSDKConst.BASE_LIB_PATH_DIR + File.separator + MD5Utils.toMD5(paramString1) + "_" + paramString2 + ".zip";
  }
  
  public void a(bgrp parambgrp)
  {
    try
    {
      a(null, false, parambgrp);
      return;
    }
    finally
    {
      parambgrp = finally;
      throw parambgrp;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, bgrp parambgrp)
  {
    QMLog.i("miniapp-process_BaseLibManager", "doDownloadBaselib url=" + paramString1 + " version=" + paramString2 + " oldUrl=" + paramString3 + " oldVersion=" + paramString4);
    bgyd.a(bghu.a(), 4, null, null, null, 0);
    String str = a(paramString1, paramString2);
    ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(paramString1, null, str, 60, new bgro(this, parambgrp, paramString1, paramString2, paramString4, str, paramString3));
  }
  
  /* Error */
  public void a(String paramString, boolean paramBoolean, bgrp parambgrp)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 74	bgrl:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6: aload_3
    //   7: invokeinterface 343 2 0
    //   12: pop
    //   13: ldc 216
    //   15: new 17	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   22: ldc_w 345
    //   25: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_0
    //   29: getfield 194	bgrl:jdField_a_of_type_Boolean	Z
    //   32: invokevirtual 348	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   35: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 112	com/tencent/qqmini/sdk/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload_0
    //   42: getfield 194	bgrl:jdField_a_of_type_Boolean	Z
    //   45: istore 4
    //   47: iload 4
    //   49: ifeq +6 -> 55
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: aload_0
    //   56: iconst_1
    //   57: putfield 194	bgrl:jdField_a_of_type_Boolean	Z
    //   60: invokestatic 353	com/tencent/qqmini/sdk/core/manager/ThreadManager:a	()Landroid/os/Handler;
    //   63: new 355	com/tencent/qqmini/sdk/manager/BaseLibManager$2
    //   66: dup
    //   67: aload_0
    //   68: iload_2
    //   69: aload_1
    //   70: aload_3
    //   71: invokespecial 358	com/tencent/qqmini/sdk/manager/BaseLibManager$2:<init>	(Lbgrl;ZLjava/lang/String;Lbgrp;)V
    //   74: invokevirtual 364	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   77: pop
    //   78: goto -26 -> 52
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	bgrl
    //   0	86	1	paramString	String
    //   0	86	2	paramBoolean	boolean
    //   0	86	3	parambgrp	bgrp
    //   45	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	47	81	finally
    //   55	78	81	finally
  }
  
  public boolean a()
  {
    String str = a().b("mini", "1.14.0.00225");
    if (a().a(str))
    {
      QMLog.i("miniapp-process_BaseLibManager", "[MiniEng] inner baseLib already installed, version:1.14.0.00225");
      return true;
    }
    int j = bglq.a("qqminiapp", "mini_app_inner_baselib_retry_count", jdField_a_of_type_Int);
    QMLog.i("miniapp-process_BaseLibManager", "[MiniEng]installInnerBaseLib, version:1.14.0.00225, totalCount:" + j);
    int i = 0;
    while (i < j)
    {
      boolean bool = AssetsUtil.copyFileOrDir(AppLoaderFactory.g().getMiniAppEnv().getContext(), "mini", str);
      if ((bool) && (a().c(str)))
      {
        QMLog.i("miniapp-process_BaseLibManager", "[MiniEng] install inner baseLib success, from mini to " + str + ", tryCount:" + i + ", totalCount:" + j);
        return bool;
      }
      File localFile = new File(str);
      if (localFile.exists()) {
        bgkv.a(localFile);
      }
      QMLog.w("miniapp-process_BaseLibManager", "[MiniEng] install inner baseLib fail, from mini to " + str + ", tryCount:" + i + ", totalCount:" + j);
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
        QMLog.e("miniapp-process_BaseLibManager", "isBaseLibDirValid path, exception!", paramString);
      }
    }
    return false;
  }
  
  public BaseLibInfo b()
  {
    BaseLibInfo localBaseLibInfo = new BaseLibInfo();
    String str = StorageUtil.getPreference().getString("downloadUrl", null);
    localBaseLibInfo.baseLibVersion = StorageUtil.getPreference().getString("version", "1.14.0.00225");
    localBaseLibInfo.baseLibUrl = str;
    return localBaseLibInfo;
  }
  
  public String b(String paramString1, String paramString2)
  {
    return MiniSDKConst.getAppBaseLibDir(paramString1, paramString2);
  }
  
  public void b(bgrp parambgrp)
  {
    try
    {
      ThreadManager.a().post(new BaseLibManager.1(this, parambgrp));
      return;
    }
    finally
    {
      parambgrp = finally;
      throw parambgrp;
    }
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
      QMLog.e("miniapp-process_BaseLibManager", "isBaseLibDirValid4MiniApp path, exception!", paramString);
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
      QMLog.e("miniapp-process_BaseLibManager", "isBaseLibDirValid4MiniGame path, exception!", paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgrl
 * JD-Core Version:    0.7.0.1
 */