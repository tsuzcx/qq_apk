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

public class bmfr
  implements bmey
{
  private static bmfr a;
  
  public static bmfr a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bmfr();
      }
      return a;
    }
    finally {}
  }
  
  private void a(boolean paramBoolean)
  {
    QLog.e("IlivePreDownloadManager", 1, "onPreloadDownloadComplete isSuccess = " + paramBoolean);
    Object localObject1 = bmfc.a().a();
    if ((localObject1 == null) || (TextUtils.isEmpty(((bmfl)localObject1).c()))) {
      return;
    }
    Object localObject2 = new File(((bmfl)localObject1).a());
    if (((File)localObject2).exists()) {}
    for (long l = ((File)localObject2).length();; l = -1L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("IlivePreDownloadManager", 2, "onPreloadDownloadComplete isSuccess = " + paramBoolean + " url = " + ((bmfl)localObject1).c() + " fileSize = " + l);
      }
      localObject2 = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject2 instanceof QQAppInterface))
      {
        localObject2 = (bezv)((QQAppInterface)localObject2).getManager(193);
        localObject1 = ((bmfl)localObject1).c();
        if (paramBoolean) {}
        for (;;)
        {
          ((bezv)localObject2).a((String)localObject1, l);
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
    bmfl localbmfl = bmfc.a().a();
    if ((localbmfl == null) || (TextUtils.isEmpty(localbmfl.c()))) {
      return;
    }
    bmfv.a().b("PLUGIN_PRE_DOWNLOAD");
    Object localObject1 = new IlivePreDownloadManager.2(this);
    QLog.e("IlivePreDownloadManager", 1, "add preload dispatch");
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject2 instanceof QQAppInterface))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)localObject2;
      localObject2 = (bezv)localQQAppInterface.getManager(193);
      localObject1 = new bezw(localQQAppInterface, localbmfl.c(), (Runnable)localObject1, 4000L);
      ((bezv)localObject2).a(10095, "vas", localbmfl.b(), ((Integer)bezx.c.get(Integer.valueOf(10095))).intValue(), localbmfl.c(), localbmfl.a(), 2, 0, false, (bezs)localObject1);
      return;
    }
    QLog.e("IlivePreDownloadManager", 1, "onPreloadDownloadStart app is not QQAppInterface");
    ((Runnable)localObject1).run();
  }
  
  private void c()
  {
    bmfv.a().b("PLUGIN_DOWNLOAD");
    bmfc.a().a(true);
  }
  
  public void a()
  {
    bmfl localbmfl = bmfc.a().a();
    if ((localbmfl == null) || (TextUtils.isEmpty(localbmfl.c()))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("IlivePreDownloadManager", 2, " cancelPreloadDownload ");
    }
    bmfc.a().a();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      ((bezv)((QQAppInterface)localAppRuntime).getManager(193)).a(localbmfl.c());
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
    if (!bmfx.b())
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
      bmfv.a().a("PLUGIN_PRE_DOWNLOAD").a("plugin_pre_download_result", paramString);
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
    bmfv.a().a("PLUGIN_PRE_DOWNLOAD").a("plugin_pre_download_result", localHashMap);
    if (!bmfc.a().b())
    {
      onFail(102, "pre download success but local apk file is not exist");
      return;
    }
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmfr
 * JD-Core Version:    0.7.0.1
 */