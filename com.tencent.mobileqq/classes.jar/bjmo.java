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

public final class bjmo
  implements Handler.Callback
{
  private static String jdField_a_of_type_JavaLangString = "QzoneModuleDownloadManager";
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bjgf jdField_a_of_type_Bjgf;
  private Downloader.DownloadListener jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener = new bjmp(this);
  private Map<String, bjmq> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  public bjmo(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_Bjgf = bjgf.a();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(QzoneHandlerThreadFactory.getHandlerThreadLooper("Normal_HandlerThread"), this);
  }
  
  private void a(bjmq parambjmq)
  {
    String str1 = parambjmq.jdField_a_of_type_Bjmm.d;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(str1)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(str1, parambjmq);
    Object localObject = parambjmq.jdField_a_of_type_Bjmm;
    String str2 = QzoneModuleConst.getModuleSavePath(this.jdField_a_of_type_AndroidContentContext, (bjmm)localObject);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "----------savePath--" + str2);
    }
    File localFile = new File(str2);
    if (localFile.exists())
    {
      String str3 = ((bjmm)localObject).e;
      if ((TextUtils.isEmpty(str3)) || ((((bjmm)localObject).jdField_a_of_type_Long != 0L) && (((bjmm)localObject).jdField_a_of_type_Long == localFile.length())))
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "download succeed: from cache.");
        bjml.a().a((bjmm)localObject);
        if (parambjmq.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null)
        {
          parambjmq.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadSucceed(parambjmq.jdField_a_of_type_JavaLangString);
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
    QLog.i(jdField_a_of_type_JavaLangString, 1, "start download--" + parambjmq.jdField_a_of_type_JavaLangString + ",priority: " + parambjmq.jdField_a_of_type_Boolean + " ,startImmediately: " + parambjmq.b);
    parambjmq.jdField_a_of_type_Long = System.nanoTime();
    this.jdField_a_of_type_Bjgf.a(str1, str2, parambjmq.jdField_a_of_type_Boolean, parambjmq.b, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener);
  }
  
  private void c(String paramString)
  {
    bjmq localbjmq = (bjmq)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    String str2;
    bjmm localbjmm;
    String str3;
    long l;
    if (localbjmq != null)
    {
      str2 = QzoneModuleConst.getModuleSavePath(this.jdField_a_of_type_AndroidContentContext, localbjmq.jdField_a_of_type_Bjmm);
      localbjmm = localbjmq.jdField_a_of_type_Bjmm;
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "download complete: " + str2);
      }
      str3 = localbjmm.e;
      String str1 = "";
      if (!TextUtils.isEmpty(str3)) {
        str1 = bflr.a(str2);
      }
      l = (System.nanoTime() - localbjmq.jdField_a_of_type_Long) / 1000000L;
      if ((!TextUtils.isEmpty(str3)) && (!str3.equalsIgnoreCase(str1))) {
        break label253;
      }
      bjml.a().a(localbjmm);
    }
    for (;;)
    {
      try
      {
        if (QzoneModuleConst.QZONE_MODULES_NEED_INSTALL.contains(localbjmm.jdField_a_of_type_JavaLangString)) {
          new DexClassLoader(str2, this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getDir("dex", 0).getAbsolutePath(), str2, this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getClassLoader());
        }
        if (localbjmq.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null) {
          localbjmq.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadSucceed(localbjmq.jdField_a_of_type_JavaLangString);
        }
        bjmx.a(localbjmm, true, l);
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
      if (localbjmq.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null) {
        localbjmq.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadFailed(localbjmq.jdField_a_of_type_JavaLangString);
      }
      bjmx.a(localbjmm, false, l);
    }
  }
  
  public void a(String paramString)
  {
    paramString = bjml.a().a(paramString);
    if ((paramString == null) || (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString.d))) {}
    do
    {
      return;
      paramString = (bjmq)this.jdField_a_of_type_JavaUtilMap.get(paramString.d);
    } while (paramString == null);
    Message localMessage = Message.obtain(this.jdField_a_of_type_AndroidOsHandler);
    localMessage.what = 4;
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public boolean a(bjmm parambjmm, ModuleDownloadListener paramModuleDownloadListener)
  {
    return a(parambjmm, false, paramModuleDownloadListener);
  }
  
  public boolean a(bjmm parambjmm, boolean paramBoolean, ModuleDownloadListener paramModuleDownloadListener)
  {
    return a(parambjmm, paramBoolean, false, paramModuleDownloadListener);
  }
  
  public boolean a(bjmm parambjmm, boolean paramBoolean1, boolean paramBoolean2, ModuleDownloadListener paramModuleDownloadListener)
  {
    if (parambjmm == null) {
      return false;
    }
    bjmq localbjmq = new bjmq(null);
    localbjmq.jdField_a_of_type_JavaLangString = parambjmm.jdField_a_of_type_JavaLangString;
    localbjmq.jdField_a_of_type_Bjmm = parambjmm;
    localbjmq.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener = paramModuleDownloadListener;
    localbjmq.jdField_a_of_type_Boolean = paramBoolean1;
    localbjmq.b = paramBoolean2;
    parambjmm = Message.obtain(this.jdField_a_of_type_AndroidOsHandler);
    parambjmm.what = 1;
    parambjmm.obj = localbjmq;
    parambjmm.sendToTarget();
    return true;
  }
  
  public void b(String paramString)
  {
    paramString = bjml.a().a(paramString);
    if ((paramString == null) || (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString.d))) {}
    do
    {
      return;
      paramString = (bjmq)this.jdField_a_of_type_JavaUtilMap.get(paramString.d);
    } while (paramString == null);
    Message localMessage = Message.obtain(this.jdField_a_of_type_AndroidOsHandler);
    localMessage.what = 7;
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    bjmq localbjmq;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      a((bjmq)paramMessage.obj);
      return true;
    case 2: 
      c((String)paramMessage.obj);
      return true;
    case 3: 
      paramMessage = (String)paramMessage.obj;
      localbjmq = (bjmq)this.jdField_a_of_type_JavaUtilMap.get(paramMessage);
      if (localbjmq != null)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "download failed: " + localbjmq.jdField_a_of_type_JavaLangString);
        if (localbjmq.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null) {
          localbjmq.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadFailed(localbjmq.jdField_a_of_type_JavaLangString);
        }
        long l = (System.nanoTime() - localbjmq.jdField_a_of_type_Long) / 1000000L;
        bjmx.a(localbjmq.jdField_a_of_type_Bjmm, false, l);
      }
      this.jdField_a_of_type_JavaUtilMap.remove(paramMessage);
      return true;
    case 4: 
      paramMessage = (bjmq)paramMessage.obj;
      QLog.w(jdField_a_of_type_JavaLangString, 1, "cancel download: " + paramMessage.jdField_a_of_type_JavaLangString);
      paramMessage = paramMessage.jdField_a_of_type_Bjmm.d;
      this.jdField_a_of_type_Bjgf.a(paramMessage, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener);
      return true;
    case 5: 
      paramMessage = (String)paramMessage.obj;
      localbjmq = (bjmq)this.jdField_a_of_type_JavaUtilMap.get(paramMessage);
      if (localbjmq != null)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "download canceled: " + localbjmq.jdField_a_of_type_JavaLangString);
        if (localbjmq.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null) {
          localbjmq.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadCanceled(localbjmq.jdField_a_of_type_JavaLangString);
        }
      }
      this.jdField_a_of_type_JavaUtilMap.remove(paramMessage);
      return true;
    case 6: 
      paramMessage = (bjmq)paramMessage.obj;
      if ((paramMessage != null) && (paramMessage.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null))
      {
        float f = ((Float)paramMessage.jdField_a_of_type_JavaLangObject).floatValue();
        paramMessage.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadProgress(paramMessage.jdField_a_of_type_JavaLangString, f);
      }
      return true;
    }
    paramMessage = (bjmq)paramMessage.obj;
    QLog.w(jdField_a_of_type_JavaLangString, 1, "abort download: " + paramMessage.jdField_a_of_type_JavaLangString);
    paramMessage = paramMessage.jdField_a_of_type_Bjmm.d;
    this.jdField_a_of_type_Bjgf.b(paramMessage, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjmo
 * JD-Core Version:    0.7.0.1
 */