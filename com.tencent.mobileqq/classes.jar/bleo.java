import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.manager.IlivePreDownloadManager.1;
import cooperation.ilive.manager.IlivePreDownloadManager.2;
import java.io.File;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class bleo
  implements bldv
{
  private static bleo a;
  
  public static bleo a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bleo();
      }
      return a;
    }
    finally {}
  }
  
  private void a(boolean paramBoolean)
  {
    QLog.e("IlivePreDownloadManager", 1, "onPreloadDownloadComplete isSuccess = " + paramBoolean);
    Object localObject1 = bldz.a().a();
    if ((localObject1 == null) || (TextUtils.isEmpty(((blei)localObject1).c()))) {
      return;
    }
    Object localObject2 = new File(((blei)localObject1).a());
    if (((File)localObject2).exists()) {}
    for (long l = ((File)localObject2).length();; l = -1L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("IlivePreDownloadManager", 2, "onPreloadDownloadComplete isSuccess = " + paramBoolean + " url = " + ((blei)localObject1).c() + " fileSize = " + l);
      }
      localObject2 = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject2 instanceof QQAppInterface))
      {
        localObject2 = (beaw)((QQAppInterface)localObject2).getManager(193);
        localObject1 = ((blei)localObject1).c();
        if (paramBoolean) {}
        for (;;)
        {
          ((beaw)localObject2).a((String)localObject1, l);
          return;
          l = -1L;
        }
      }
      QLog.e("IlivePreDownloadManager", 1, "onPreloadDownloadComplete app is not QQAppInterface");
      return;
    }
  }
  
  private void b()
  {
    blei localblei = bldz.a().a();
    if ((localblei == null) || (TextUtils.isEmpty(localblei.c()))) {
      return;
    }
    bles.a().b("PLUGIN_PRE_DOWNLOAD");
    Object localObject1 = new IlivePreDownloadManager.2(this);
    QLog.e("IlivePreDownloadManager", 1, "add preload dispatch");
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject2 instanceof QQAppInterface))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)localObject2;
      localObject2 = (beaw)localQQAppInterface.getManager(193);
      localObject1 = new beax(localQQAppInterface, localblei.c(), (Runnable)localObject1, 4000L);
      ((beaw)localObject2).a(10095, "vas", localblei.b(), ((Integer)beay.c.get(Integer.valueOf(10095))).intValue(), localblei.c(), localblei.a(), 2, 0, false, (beat)localObject1);
      return;
    }
    QLog.e("IlivePreDownloadManager", 1, "onPreloadDownloadStart app is not QQAppInterface");
    ((Runnable)localObject1).run();
  }
  
  private void c()
  {
    bles.a().b("PLUGIN_DOWNLOAD");
    bldz.a().a(true);
  }
  
  public void a()
  {
    blei localblei = bldz.a().a();
    if ((localblei == null) || (TextUtils.isEmpty(localblei.c()))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("IlivePreDownloadManager", 2, " cancelPreloadDownload ");
    }
    bldz.a().a();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      ((beaw)((QQAppInterface)localAppRuntime).getManager(193)).a(localblei.c());
      return;
    }
    QLog.e("IlivePreDownloadManager", 1, "cancelPreloadDownload app is not QQAppInterface");
  }
  
  public void a(int paramInt)
  {
    QLog.e("IlivePreDownloadManager", 1, "preloadPluginConfig isPreload = " + paramInt);
    if (paramInt != 1) {
      return;
    }
    if (!bleu.b())
    {
      QLog.e("IlivePreDownloadManager", 1, "stop preloadPluginConfig current version disable predownload");
      return;
    }
    ThreadManagerV2.executeOnFileThread(new IlivePreDownloadManager.1(this));
  }
  
  public void onFail(int paramInt, String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    try
    {
      paramString = str.substring(str.lastIndexOf("errorCode="));
      if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("-106")))
      {
        QLog.e("IlivePreDownloadManager", 1, "preload onFail -106 ,cancel report ");
        return;
      }
      QLog.e("IlivePreDownloadManager", 1, "preload onFail code = " + paramInt + " msg = " + str + paramString);
      paramString = new HashMap();
      paramString.put("status", "fail");
      paramString.put("errorCode", paramInt + str);
      bles.a().a("PLUGIN_PRE_DOWNLOAD").a("plugin_pre_download_result", paramString);
      a(false);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void onProgress(float paramFloat) {}
  
  public void onSuccess()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("status", "success");
    bles.a().a("PLUGIN_PRE_DOWNLOAD").a("plugin_pre_download_result", localHashMap);
    if (!bldz.a().b())
    {
      onFail(102, "pre download success but local apk file is not exist");
      return;
    }
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bleo
 * JD-Core Version:    0.7.0.1
 */