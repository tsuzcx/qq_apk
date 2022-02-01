import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.manager.IlivePreDownloadManager.1;
import cooperation.ilive.manager.IlivePreDownloadManager.2;
import java.io.File;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class bkjy
  implements bkiv
{
  private static bkjy a;
  
  public static bkjy a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bkjy();
      }
      return a;
    }
    finally {}
  }
  
  private void a(boolean paramBoolean)
  {
    QLog.e("IlivePreDownloadManager", 1, "onPreloadDownloadComplete isSuccess = " + paramBoolean);
    Object localObject1 = bkiz.a().a();
    if ((localObject1 == null) || (TextUtils.isEmpty(((bkji)localObject1).c()))) {
      return;
    }
    Object localObject2 = new File(((bkji)localObject1).a());
    if (((File)localObject2).exists()) {}
    for (long l = ((File)localObject2).length();; l = -1L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("IlivePreDownloadManager", 2, "onPreloadDownloadComplete isSuccess = " + paramBoolean + " url = " + ((bkji)localObject1).c() + " fileSize = " + l);
      }
      localObject2 = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject2 instanceof QQAppInterface))
      {
        localObject2 = (PreDownloadController)((QQAppInterface)localObject2).getManager(193);
        localObject1 = ((bkji)localObject1).c();
        if (paramBoolean) {}
        for (;;)
        {
          ((PreDownloadController)localObject2).preDownloadSuccess((String)localObject1, l);
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
    bkji localbkji = bkiz.a().a();
    if ((localbkji == null) || (TextUtils.isEmpty(localbkji.c()))) {
      return;
    }
    bkkc.a().b("PLUGIN_PRE_DOWNLOAD");
    Object localObject1 = new IlivePreDownloadManager.2(this);
    QLog.e("IlivePreDownloadManager", 1, "add preload dispatch");
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject2 instanceof QQAppInterface))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)localObject2;
      localObject2 = (PreDownloadController)localQQAppInterface.getManager(193);
      localObject1 = new RunnableTask(localQQAppInterface, localbkji.c(), (Runnable)localObject1, 4000L);
      ((PreDownloadController)localObject2).requestPreDownload(10095, "vas", localbkji.b(), ((Integer)PreDownloadConstants.BUSINESS_PRIORITY.get(Integer.valueOf(10095))).intValue(), localbkji.c(), localbkji.a(), 2, 0, false, (AbsPreDownloadTask)localObject1);
      return;
    }
    QLog.e("IlivePreDownloadManager", 1, "onPreloadDownloadStart app is not QQAppInterface");
    ((Runnable)localObject1).run();
  }
  
  private void c()
  {
    bkkc.a().b("PLUGIN_DOWNLOAD");
    bkiz.a().a(true);
  }
  
  public void a()
  {
    bkji localbkji = bkiz.a().a();
    if ((localbkji == null) || (TextUtils.isEmpty(localbkji.c()))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("IlivePreDownloadManager", 2, " cancelPreloadDownload ");
    }
    bkiz.a().a();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      ((PreDownloadController)((QQAppInterface)localAppRuntime).getManager(193)).cancelPreDownload(localbkji.c());
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
    if (!bkke.b())
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
      bkkc.a().a("PLUGIN_PRE_DOWNLOAD").a("plugin_pre_download_result", paramString);
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
    bkkc.a().a("PLUGIN_PRE_DOWNLOAD").a("plugin_pre_download_result", localHashMap);
    if (!bkiz.a().b())
    {
      onFail(102, "pre download success but local apk file is not exist");
      return;
    }
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkjy
 * JD-Core Version:    0.7.0.1
 */