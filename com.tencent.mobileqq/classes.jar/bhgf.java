import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.networkedmodule.QzoneModuleConst;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class bhgf
  implements Handler.Callback
{
  private static String jdField_a_of_type_JavaLangString = "QzoneModuleDownloadManager";
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bhaa jdField_a_of_type_Bhaa;
  private Downloader.DownloadListener jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener = new bhgg(this);
  private Map<String, bhgh> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  public bhgf(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_Bhaa = bhaa.a();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(QzoneHandlerThreadFactory.getHandlerThreadLooper("Normal_HandlerThread"), this);
  }
  
  private void a(bhgh parambhgh)
  {
    String str1 = parambhgh.jdField_a_of_type_Bhgd.d;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(str1)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(str1, parambhgh);
    Object localObject = parambhgh.jdField_a_of_type_Bhgd;
    String str2 = QzoneModuleConst.getModuleSavePath(this.jdField_a_of_type_AndroidContentContext, (bhgd)localObject);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "----------savePath--" + str2);
    }
    File localFile = new File(str2);
    if (localFile.exists())
    {
      String str3 = ((bhgd)localObject).e;
      if ((TextUtils.isEmpty(str3)) || ((((bhgd)localObject).jdField_a_of_type_Long != 0L) && (((bhgd)localObject).jdField_a_of_type_Long == localFile.length())))
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "download succeed: from cache.");
        bhgc.a().a((bhgd)localObject);
        if (parambhgh.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null)
        {
          parambhgh.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadSucceed(parambhgh.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_JavaUtilMap.remove(str1);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 1, "before download-- orgMD5: " + str3 + " , downloadFilePath: " + localFile.getPath());
        }
        localObject = new File(str2);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        QLog.i(jdField_a_of_type_JavaLangString, 1, "check download cache failed: md5 verify is not passed.");
      }
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "start download--" + parambhgh.jdField_a_of_type_JavaLangString + ",priority: " + parambhgh.jdField_a_of_type_Boolean + " ,startImmediately: " + parambhgh.b);
    parambhgh.jdField_a_of_type_Long = System.nanoTime();
    this.jdField_a_of_type_Bhaa.a(str1, str2, parambhgh.jdField_a_of_type_Boolean, parambhgh.b, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener);
  }
  
  private void c(String paramString)
  {
    bhgh localbhgh = (bhgh)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    String str2;
    bhgd localbhgd;
    String str3;
    long l;
    if (localbhgh != null)
    {
      str2 = QzoneModuleConst.getModuleSavePath(this.jdField_a_of_type_AndroidContentContext, localbhgh.jdField_a_of_type_Bhgd);
      localbhgd = localbhgh.jdField_a_of_type_Bhgd;
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "download complete: " + str2);
      }
      str3 = localbhgd.e;
      String str1 = "";
      if (!TextUtils.isEmpty(str3)) {
        str1 = bdhv.a(str2);
      }
      l = (System.nanoTime() - localbhgh.jdField_a_of_type_Long) / 1000000L;
      if ((!TextUtils.isEmpty(str3)) && (!str3.equalsIgnoreCase(str1))) {
        break label253;
      }
      bhgc.a().a(localbhgd);
    }
    for (;;)
    {
      try
      {
        if (QzoneModuleConst.QZONE_MODULES_NEED_INSTALL.contains(localbhgd.jdField_a_of_type_JavaLangString)) {
          new DexClassLoader(str2, this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getDir("dex", 0).getAbsolutePath(), str2, this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getClassLoader());
        }
        if (localbhgh.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null) {
          localbhgh.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadSucceed(localbhgh.jdField_a_of_type_JavaLangString);
        }
        bhgo.a(localbhgd, true, l);
        this.jdField_a_of_type_JavaUtilMap.remove(paramString);
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "after download,new DexClassLoader error: ", localThrowable);
        continue;
      }
      label253:
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "download complete-- orgMD5: " + str3 + " , downloadMD5: " + localThrowable);
      }
      File localFile = new File(str2);
      if (localFile.exists()) {
        localFile.delete();
      }
      QLog.i(jdField_a_of_type_JavaLangString, 1, "download failed: md5 verify is not passed.");
      if (localbhgh.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null) {
        localbhgh.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadFailed(localbhgh.jdField_a_of_type_JavaLangString);
      }
      bhgo.a(localbhgd, false, l);
    }
  }
  
  public void a(String paramString)
  {
    paramString = bhgc.a().a(paramString);
    if ((paramString == null) || (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString.d))) {}
    do
    {
      return;
      paramString = (bhgh)this.jdField_a_of_type_JavaUtilMap.get(paramString.d);
    } while (paramString == null);
    Message localMessage = Message.obtain(this.jdField_a_of_type_AndroidOsHandler);
    localMessage.what = 4;
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public boolean a(bhgd parambhgd, ModuleDownloadListener paramModuleDownloadListener)
  {
    return a(parambhgd, false, paramModuleDownloadListener);
  }
  
  public boolean a(bhgd parambhgd, boolean paramBoolean, ModuleDownloadListener paramModuleDownloadListener)
  {
    return a(parambhgd, paramBoolean, false, paramModuleDownloadListener);
  }
  
  public boolean a(bhgd parambhgd, boolean paramBoolean1, boolean paramBoolean2, ModuleDownloadListener paramModuleDownloadListener)
  {
    if (parambhgd == null) {
      return false;
    }
    bhgh localbhgh = new bhgh(null);
    localbhgh.jdField_a_of_type_JavaLangString = parambhgd.jdField_a_of_type_JavaLangString;
    localbhgh.jdField_a_of_type_Bhgd = parambhgd;
    localbhgh.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener = paramModuleDownloadListener;
    localbhgh.jdField_a_of_type_Boolean = paramBoolean1;
    localbhgh.b = paramBoolean2;
    parambhgd = Message.obtain(this.jdField_a_of_type_AndroidOsHandler);
    parambhgd.what = 1;
    parambhgd.obj = localbhgh;
    parambhgd.sendToTarget();
    return true;
  }
  
  public void b(String paramString)
  {
    paramString = bhgc.a().a(paramString);
    if ((paramString == null) || (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString.d))) {}
    do
    {
      return;
      paramString = (bhgh)this.jdField_a_of_type_JavaUtilMap.get(paramString.d);
    } while (paramString == null);
    Message localMessage = Message.obtain(this.jdField_a_of_type_AndroidOsHandler);
    localMessage.what = 7;
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    bhgh localbhgh;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      a((bhgh)paramMessage.obj);
      return true;
    case 2: 
      c((String)paramMessage.obj);
      return true;
    case 3: 
      paramMessage = (String)paramMessage.obj;
      localbhgh = (bhgh)this.jdField_a_of_type_JavaUtilMap.get(paramMessage);
      if (localbhgh != null)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "download failed: " + localbhgh.jdField_a_of_type_JavaLangString);
        if (localbhgh.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null) {
          localbhgh.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadFailed(localbhgh.jdField_a_of_type_JavaLangString);
        }
        long l = (System.nanoTime() - localbhgh.jdField_a_of_type_Long) / 1000000L;
        bhgo.a(localbhgh.jdField_a_of_type_Bhgd, false, l);
      }
      this.jdField_a_of_type_JavaUtilMap.remove(paramMessage);
      return true;
    case 4: 
      paramMessage = (bhgh)paramMessage.obj;
      QLog.w(jdField_a_of_type_JavaLangString, 1, "cancel download: " + paramMessage.jdField_a_of_type_JavaLangString);
      paramMessage = paramMessage.jdField_a_of_type_Bhgd.d;
      this.jdField_a_of_type_Bhaa.a(paramMessage, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener);
      return true;
    case 5: 
      paramMessage = (String)paramMessage.obj;
      localbhgh = (bhgh)this.jdField_a_of_type_JavaUtilMap.get(paramMessage);
      if (localbhgh != null)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "download canceled: " + localbhgh.jdField_a_of_type_JavaLangString);
        if (localbhgh.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null) {
          localbhgh.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadCanceled(localbhgh.jdField_a_of_type_JavaLangString);
        }
      }
      this.jdField_a_of_type_JavaUtilMap.remove(paramMessage);
      return true;
    case 6: 
      paramMessage = (bhgh)paramMessage.obj;
      if ((paramMessage != null) && (paramMessage.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null))
      {
        float f = ((Float)paramMessage.jdField_a_of_type_JavaLangObject).floatValue();
        paramMessage.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadProgress(paramMessage.jdField_a_of_type_JavaLangString, f);
      }
      return true;
    }
    paramMessage = (bhgh)paramMessage.obj;
    QLog.w(jdField_a_of_type_JavaLangString, 1, "abort download: " + paramMessage.jdField_a_of_type_JavaLangString);
    paramMessage = paramMessage.jdField_a_of_type_Bhgd.d;
    this.jdField_a_of_type_Bhaa.b(paramMessage, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhgf
 * JD-Core Version:    0.7.0.1
 */