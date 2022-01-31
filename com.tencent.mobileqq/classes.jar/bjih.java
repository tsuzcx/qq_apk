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

public final class bjih
  implements Handler.Callback
{
  private static String jdField_a_of_type_JavaLangString = "QzoneModuleDownloadManager";
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bjby jdField_a_of_type_Bjby;
  private Downloader.DownloadListener jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener = new bjii(this);
  private Map<String, bjij> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  public bjih(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_Bjby = bjby.a();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(QzoneHandlerThreadFactory.getHandlerThreadLooper("Normal_HandlerThread"), this);
  }
  
  private void a(bjij parambjij)
  {
    String str1 = parambjij.jdField_a_of_type_Bjif.d;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(str1)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(str1, parambjij);
    Object localObject = parambjij.jdField_a_of_type_Bjif;
    String str2 = QzoneModuleConst.getModuleSavePath(this.jdField_a_of_type_AndroidContentContext, (bjif)localObject);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "----------savePath--" + str2);
    }
    File localFile = new File(str2);
    if (localFile.exists())
    {
      String str3 = ((bjif)localObject).e;
      if ((TextUtils.isEmpty(str3)) || ((((bjif)localObject).jdField_a_of_type_Long != 0L) && (((bjif)localObject).jdField_a_of_type_Long == localFile.length())))
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "download succeed: from cache.");
        bjie.a().a((bjif)localObject);
        if (parambjij.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null)
        {
          parambjij.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadSucceed(parambjij.jdField_a_of_type_JavaLangString);
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
    QLog.i(jdField_a_of_type_JavaLangString, 1, "start download--" + parambjij.jdField_a_of_type_JavaLangString + ",priority: " + parambjij.jdField_a_of_type_Boolean + " ,startImmediately: " + parambjij.b);
    parambjij.jdField_a_of_type_Long = System.nanoTime();
    this.jdField_a_of_type_Bjby.a(str1, str2, parambjij.jdField_a_of_type_Boolean, parambjij.b, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener);
  }
  
  private void c(String paramString)
  {
    bjij localbjij = (bjij)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    String str2;
    bjif localbjif;
    String str3;
    long l;
    if (localbjij != null)
    {
      str2 = QzoneModuleConst.getModuleSavePath(this.jdField_a_of_type_AndroidContentContext, localbjij.jdField_a_of_type_Bjif);
      localbjif = localbjij.jdField_a_of_type_Bjif;
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "download complete: " + str2);
      }
      str3 = localbjif.e;
      String str1 = "";
      if (!TextUtils.isEmpty(str3)) {
        str1 = bfhi.a(str2);
      }
      l = (System.nanoTime() - localbjij.jdField_a_of_type_Long) / 1000000L;
      if ((!TextUtils.isEmpty(str3)) && (!str3.equalsIgnoreCase(str1))) {
        break label253;
      }
      bjie.a().a(localbjif);
    }
    for (;;)
    {
      try
      {
        if (QzoneModuleConst.QZONE_MODULES_NEED_INSTALL.contains(localbjif.jdField_a_of_type_JavaLangString)) {
          new DexClassLoader(str2, this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getDir("dex", 0).getAbsolutePath(), str2, this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getClassLoader());
        }
        if (localbjij.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null) {
          localbjij.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadSucceed(localbjij.jdField_a_of_type_JavaLangString);
        }
        bjiq.a(localbjif, true, l);
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
      if (localbjij.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null) {
        localbjij.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadFailed(localbjij.jdField_a_of_type_JavaLangString);
      }
      bjiq.a(localbjif, false, l);
    }
  }
  
  public void a(String paramString)
  {
    paramString = bjie.a().a(paramString);
    if ((paramString == null) || (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString.d))) {}
    do
    {
      return;
      paramString = (bjij)this.jdField_a_of_type_JavaUtilMap.get(paramString.d);
    } while (paramString == null);
    Message localMessage = Message.obtain(this.jdField_a_of_type_AndroidOsHandler);
    localMessage.what = 4;
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public boolean a(bjif parambjif, ModuleDownloadListener paramModuleDownloadListener)
  {
    return a(parambjif, false, paramModuleDownloadListener);
  }
  
  public boolean a(bjif parambjif, boolean paramBoolean, ModuleDownloadListener paramModuleDownloadListener)
  {
    return a(parambjif, paramBoolean, false, paramModuleDownloadListener);
  }
  
  public boolean a(bjif parambjif, boolean paramBoolean1, boolean paramBoolean2, ModuleDownloadListener paramModuleDownloadListener)
  {
    if (parambjif == null) {
      return false;
    }
    bjij localbjij = new bjij(null);
    localbjij.jdField_a_of_type_JavaLangString = parambjif.jdField_a_of_type_JavaLangString;
    localbjij.jdField_a_of_type_Bjif = parambjif;
    localbjij.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener = paramModuleDownloadListener;
    localbjij.jdField_a_of_type_Boolean = paramBoolean1;
    localbjij.b = paramBoolean2;
    parambjif = Message.obtain(this.jdField_a_of_type_AndroidOsHandler);
    parambjif.what = 1;
    parambjif.obj = localbjij;
    parambjif.sendToTarget();
    return true;
  }
  
  public void b(String paramString)
  {
    paramString = bjie.a().a(paramString);
    if ((paramString == null) || (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString.d))) {}
    do
    {
      return;
      paramString = (bjij)this.jdField_a_of_type_JavaUtilMap.get(paramString.d);
    } while (paramString == null);
    Message localMessage = Message.obtain(this.jdField_a_of_type_AndroidOsHandler);
    localMessage.what = 7;
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    bjij localbjij;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      a((bjij)paramMessage.obj);
      return true;
    case 2: 
      c((String)paramMessage.obj);
      return true;
    case 3: 
      paramMessage = (String)paramMessage.obj;
      localbjij = (bjij)this.jdField_a_of_type_JavaUtilMap.get(paramMessage);
      if (localbjij != null)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "download failed: " + localbjij.jdField_a_of_type_JavaLangString);
        if (localbjij.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null) {
          localbjij.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadFailed(localbjij.jdField_a_of_type_JavaLangString);
        }
        long l = (System.nanoTime() - localbjij.jdField_a_of_type_Long) / 1000000L;
        bjiq.a(localbjij.jdField_a_of_type_Bjif, false, l);
      }
      this.jdField_a_of_type_JavaUtilMap.remove(paramMessage);
      return true;
    case 4: 
      paramMessage = (bjij)paramMessage.obj;
      QLog.w(jdField_a_of_type_JavaLangString, 1, "cancel download: " + paramMessage.jdField_a_of_type_JavaLangString);
      paramMessage = paramMessage.jdField_a_of_type_Bjif.d;
      this.jdField_a_of_type_Bjby.a(paramMessage, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener);
      return true;
    case 5: 
      paramMessage = (String)paramMessage.obj;
      localbjij = (bjij)this.jdField_a_of_type_JavaUtilMap.get(paramMessage);
      if (localbjij != null)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "download canceled: " + localbjij.jdField_a_of_type_JavaLangString);
        if (localbjij.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null) {
          localbjij.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadCanceled(localbjij.jdField_a_of_type_JavaLangString);
        }
      }
      this.jdField_a_of_type_JavaUtilMap.remove(paramMessage);
      return true;
    case 6: 
      paramMessage = (bjij)paramMessage.obj;
      if ((paramMessage != null) && (paramMessage.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null))
      {
        float f = ((Float)paramMessage.jdField_a_of_type_JavaLangObject).floatValue();
        paramMessage.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadProgress(paramMessage.jdField_a_of_type_JavaLangString, f);
      }
      return true;
    }
    paramMessage = (bjij)paramMessage.obj;
    QLog.w(jdField_a_of_type_JavaLangString, 1, "abort download: " + paramMessage.jdField_a_of_type_JavaLangString);
    paramMessage = paramMessage.jdField_a_of_type_Bjif.d;
    this.jdField_a_of_type_Bjby.b(paramMessage, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjih
 * JD-Core Version:    0.7.0.1
 */