import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.core.proxy.service.DownloaderProxyDefault;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.model.ApkgBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.SubPkgInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.MD5Utils;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class bgjh
{
  private static volatile bgjh jdField_a_of_type_Bgjh;
  public static final String a;
  private static volatile byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  public static final String b = AppLoaderFactory.g().getMiniAppEnv().getContext().getFilesDir().getPath() + "/mini/";
  public static final String c = AppLoaderFactory.g().getMiniAppEnv().getContext().getFilesDir().getPath() + "/mini_tissue/";
  
  static
  {
    jdField_a_of_type_JavaLangString = AppLoaderFactory.g().getMiniAppEnv().getContext().getFilesDir().getPath() + "/minigame/";
  }
  
  public static bgjh a()
  {
    if (jdField_a_of_type_Bgjh == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Bgjh == null) {
        jdField_a_of_type_Bgjh = new bgjh();
      }
      return jdField_a_of_type_Bgjh;
    }
  }
  
  public static String a(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    return b(paramMiniAppBaseInfo, false);
  }
  
  private String a(MiniAppBaseInfo paramMiniAppBaseInfo, String paramString)
  {
    paramMiniAppBaseInfo = paramMiniAppBaseInfo.subpkgs;
    if ((paramMiniAppBaseInfo != null) && (paramMiniAppBaseInfo.size() > 0) && (!TextUtils.isEmpty(paramString)))
    {
      paramMiniAppBaseInfo = paramMiniAppBaseInfo.iterator();
      while (paramMiniAppBaseInfo.hasNext())
      {
        SubPkgInfo localSubPkgInfo = (SubPkgInfo)paramMiniAppBaseInfo.next();
        if (paramString.equals(localSubPkgInfo.subPkgName)) {
          return localSubPkgInfo.downloadUrl;
        }
      }
    }
    return null;
  }
  
  public static String a(MiniAppBaseInfo paramMiniAppBaseInfo, boolean paramBoolean)
  {
    if ((paramMiniAppBaseInfo == null) || (TextUtils.isEmpty(paramMiniAppBaseInfo.appId))) {
      return "";
    }
    if (paramMiniAppBaseInfo.verType == 3) {
      return b(paramMiniAppBaseInfo, paramBoolean) + MD5Utils.toMD5(paramMiniAppBaseInfo.appId) + "_" + paramMiniAppBaseInfo.version;
    }
    return b(paramMiniAppBaseInfo, paramBoolean) + paramMiniAppBaseInfo.appId + "_debug";
  }
  
  private String b(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    return a(paramMiniAppBaseInfo) + "apkg/" + paramMiniAppBaseInfo.appId + "_" + paramMiniAppBaseInfo.version + ".qapkg";
  }
  
  private String b(MiniAppBaseInfo paramMiniAppBaseInfo, String paramString)
  {
    return a(paramMiniAppBaseInfo) + "apkg/" + paramString + "_" + paramMiniAppBaseInfo.appId + "_" + paramMiniAppBaseInfo.version + ".qapkg";
  }
  
  public static String b(MiniAppBaseInfo paramMiniAppBaseInfo, boolean paramBoolean)
  {
    if (paramMiniAppBaseInfo.isEngineTypeMiniGame()) {
      return jdField_a_of_type_JavaLangString;
    }
    if ((paramBoolean) && (paramMiniAppBaseInfo.supportNativeRenderMode())) {
      return c;
    }
    return b;
  }
  
  public void a(Context paramContext, boolean paramBoolean, MiniAppBaseInfo paramMiniAppBaseInfo, bgjk parambgjk)
  {
    if (paramBoolean) {}
    do
    {
      try
      {
        paramContext = a(paramMiniAppBaseInfo, paramBoolean) + "_maintmp";
        if (new File(paramContext).exists())
        {
          localObject = bgjw.a(paramContext, null, paramMiniAppBaseInfo);
          if (localObject != null)
          {
            QMLog.i("ApkgManager", "apkg has download in main process. folder:" + paramContext);
            bgxn.c(paramMiniAppBaseInfo.appId, true);
            if (parambgjk != null) {
              parambgjk.a((bgjw)localObject, 0, "加载成功");
            }
          }
          return;
        }
      }
      catch (Throwable paramContext)
      {
        QMLog.e("ApkgManager", "", paramContext);
      }
      paramContext = a(paramMiniAppBaseInfo, paramBoolean);
      if (!new File(paramContext).exists()) {
        break;
      }
      QMLog.e("ApkgManager", "startLoadApkg");
      paramContext = bgjw.a(paramContext, null, paramMiniAppBaseInfo);
      QMLog.e("ApkgManager", "endLoadApkg");
      if (paramContext == null) {
        break;
      }
      bgxn.c(paramMiniAppBaseInfo.appId, true);
    } while (parambgjk == null);
    parambgjk.a(paramContext, 0, "");
    return;
    bgxn.c(paramMiniAppBaseInfo.appId, false);
    paramContext = new DownloaderProxyDefault();
    Object localObject = b(paramMiniAppBaseInfo);
    paramContext.download(paramMiniAppBaseInfo.downloadUrl, null, (String)localObject, 20, new bgji(this, parambgjk, paramMiniAppBaseInfo, paramBoolean));
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, String paramString, bgjk parambgjk)
  {
    if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramString))) {
      if (parambgjk != null) {
        parambgjk.a(null, -1, "参数错误");
      }
    }
    String str1;
    String str2;
    label97:
    do
    {
      return;
      String str3 = a(paramMiniAppInfo, false);
      if ("/__APP__/".equals(paramString))
      {
        str1 = paramMiniAppInfo.downloadUrl;
        str2 = "";
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(str1)) {
          break label97;
        }
        if (parambgjk == null) {
          break;
        }
        parambgjk.a(null, -1, "下载链接错误");
        return;
        str2 = paramMiniAppInfo.apkgInfo.getRootPath(paramString);
        str1 = a(paramMiniAppInfo, str2);
      }
      if (("/__APP__/".equals(paramString)) || (!new File(str3, str2).exists())) {
        break;
      }
    } while (parambgjk == null);
    parambgjk.a((bgjw)paramMiniAppInfo.apkgInfo, 0, null);
    return;
    new DownloaderProxyDefault().download(str1, null, b(paramMiniAppInfo, str2), 20, new bgjj(this, paramMiniAppInfo, str2, parambgjk));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgjh
 * JD-Core Version:    0.7.0.1
 */