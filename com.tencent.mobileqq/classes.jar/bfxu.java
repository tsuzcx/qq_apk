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

public final class bfxu
  implements Handler.Callback
{
  private static String jdField_a_of_type_JavaLangString = "QzoneModuleDownloadManager";
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bfrt jdField_a_of_type_Bfrt;
  private Downloader.DownloadListener jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener = new bfxv(this);
  private Map<String, bfxw> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  public bfxu(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_Bfrt = bfrt.a();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(QzoneHandlerThreadFactory.getHandlerThreadLooper("Normal_HandlerThread"), this);
  }
  
  private void a(bfxw parambfxw)
  {
    String str1 = parambfxw.jdField_a_of_type_Bfxs.d;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(str1)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(str1, parambfxw);
    Object localObject = parambfxw.jdField_a_of_type_Bfxs;
    String str2 = QzoneModuleConst.getModuleSavePath(this.jdField_a_of_type_AndroidContentContext, (bfxs)localObject);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "----------savePath--" + str2);
    }
    File localFile = new File(str2);
    if (localFile.exists())
    {
      String str3 = ((bfxs)localObject).e;
      if ((TextUtils.isEmpty(str3)) || ((((bfxs)localObject).jdField_a_of_type_Long != 0L) && (((bfxs)localObject).jdField_a_of_type_Long == localFile.length())))
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "download succeed: from cache.");
        bfxr.a().a((bfxs)localObject);
        if (parambfxw.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null)
        {
          parambfxw.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadSucceed(parambfxw.jdField_a_of_type_JavaLangString);
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
    QLog.i(jdField_a_of_type_JavaLangString, 1, "start download--" + parambfxw.jdField_a_of_type_JavaLangString + ",priority: " + parambfxw.jdField_a_of_type_Boolean + " ,startImmediately: " + parambfxw.b);
    parambfxw.jdField_a_of_type_Long = System.nanoTime();
    this.jdField_a_of_type_Bfrt.a(str1, str2, parambfxw.jdField_a_of_type_Boolean, parambfxw.b, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener);
  }
  
  private void c(String paramString)
  {
    bfxw localbfxw = (bfxw)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    String str2;
    bfxs localbfxs;
    String str3;
    long l;
    if (localbfxw != null)
    {
      str2 = QzoneModuleConst.getModuleSavePath(this.jdField_a_of_type_AndroidContentContext, localbfxw.jdField_a_of_type_Bfxs);
      localbfxs = localbfxw.jdField_a_of_type_Bfxs;
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "download complete: " + str2);
      }
      str3 = localbfxs.e;
      String str1 = "";
      if (!TextUtils.isEmpty(str3)) {
        str1 = bcdu.a(str2);
      }
      l = (System.nanoTime() - localbfxw.jdField_a_of_type_Long) / 1000000L;
      if ((!TextUtils.isEmpty(str3)) && (!str3.equalsIgnoreCase(str1))) {
        break label253;
      }
      bfxr.a().a(localbfxs);
    }
    for (;;)
    {
      try
      {
        if (QzoneModuleConst.QZONE_MODULES_NEED_INSTALL.contains(localbfxs.jdField_a_of_type_JavaLangString)) {
          new DexClassLoader(str2, this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getDir("dex", 0).getAbsolutePath(), str2, this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getClassLoader());
        }
        if (localbfxw.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null) {
          localbfxw.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadSucceed(localbfxw.jdField_a_of_type_JavaLangString);
        }
        bfyd.a(localbfxs, true, l);
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
      if (localbfxw.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null) {
        localbfxw.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadFailed(localbfxw.jdField_a_of_type_JavaLangString);
      }
      bfyd.a(localbfxs, false, l);
    }
  }
  
  public void a(String paramString)
  {
    paramString = bfxr.a().a(paramString);
    if ((paramString == null) || (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString.d))) {}
    do
    {
      return;
      paramString = (bfxw)this.jdField_a_of_type_JavaUtilMap.get(paramString.d);
    } while (paramString == null);
    Message localMessage = Message.obtain(this.jdField_a_of_type_AndroidOsHandler);
    localMessage.what = 4;
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public boolean a(bfxs parambfxs, ModuleDownloadListener paramModuleDownloadListener)
  {
    return a(parambfxs, false, paramModuleDownloadListener);
  }
  
  public boolean a(bfxs parambfxs, boolean paramBoolean, ModuleDownloadListener paramModuleDownloadListener)
  {
    return a(parambfxs, paramBoolean, false, paramModuleDownloadListener);
  }
  
  public boolean a(bfxs parambfxs, boolean paramBoolean1, boolean paramBoolean2, ModuleDownloadListener paramModuleDownloadListener)
  {
    if (parambfxs == null) {
      return false;
    }
    bfxw localbfxw = new bfxw(null);
    localbfxw.jdField_a_of_type_JavaLangString = parambfxs.jdField_a_of_type_JavaLangString;
    localbfxw.jdField_a_of_type_Bfxs = parambfxs;
    localbfxw.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener = paramModuleDownloadListener;
    localbfxw.jdField_a_of_type_Boolean = paramBoolean1;
    localbfxw.b = paramBoolean2;
    parambfxs = Message.obtain(this.jdField_a_of_type_AndroidOsHandler);
    parambfxs.what = 1;
    parambfxs.obj = localbfxw;
    parambfxs.sendToTarget();
    return true;
  }
  
  public void b(String paramString)
  {
    paramString = bfxr.a().a(paramString);
    if ((paramString == null) || (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString.d))) {}
    do
    {
      return;
      paramString = (bfxw)this.jdField_a_of_type_JavaUtilMap.get(paramString.d);
    } while (paramString == null);
    Message localMessage = Message.obtain(this.jdField_a_of_type_AndroidOsHandler);
    localMessage.what = 7;
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    bfxw localbfxw;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      a((bfxw)paramMessage.obj);
      return true;
    case 2: 
      c((String)paramMessage.obj);
      return true;
    case 3: 
      paramMessage = (String)paramMessage.obj;
      localbfxw = (bfxw)this.jdField_a_of_type_JavaUtilMap.get(paramMessage);
      if (localbfxw != null)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "download failed: " + localbfxw.jdField_a_of_type_JavaLangString);
        if (localbfxw.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null) {
          localbfxw.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadFailed(localbfxw.jdField_a_of_type_JavaLangString);
        }
        long l = (System.nanoTime() - localbfxw.jdField_a_of_type_Long) / 1000000L;
        bfyd.a(localbfxw.jdField_a_of_type_Bfxs, false, l);
      }
      this.jdField_a_of_type_JavaUtilMap.remove(paramMessage);
      return true;
    case 4: 
      paramMessage = (bfxw)paramMessage.obj;
      QLog.w(jdField_a_of_type_JavaLangString, 1, "cancel download: " + paramMessage.jdField_a_of_type_JavaLangString);
      paramMessage = paramMessage.jdField_a_of_type_Bfxs.d;
      this.jdField_a_of_type_Bfrt.a(paramMessage, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener);
      return true;
    case 5: 
      paramMessage = (String)paramMessage.obj;
      localbfxw = (bfxw)this.jdField_a_of_type_JavaUtilMap.get(paramMessage);
      if (localbfxw != null)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "download canceled: " + localbfxw.jdField_a_of_type_JavaLangString);
        if (localbfxw.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null) {
          localbfxw.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadCanceled(localbfxw.jdField_a_of_type_JavaLangString);
        }
      }
      this.jdField_a_of_type_JavaUtilMap.remove(paramMessage);
      return true;
    case 6: 
      paramMessage = (bfxw)paramMessage.obj;
      if ((paramMessage != null) && (paramMessage.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null))
      {
        float f = ((Float)paramMessage.jdField_a_of_type_JavaLangObject).floatValue();
        paramMessage.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadProgress(paramMessage.jdField_a_of_type_JavaLangString, f);
      }
      return true;
    }
    paramMessage = (bfxw)paramMessage.obj;
    QLog.w(jdField_a_of_type_JavaLangString, 1, "abort download: " + paramMessage.jdField_a_of_type_JavaLangString);
    paramMessage = paramMessage.jdField_a_of_type_Bfxs.d;
    this.jdField_a_of_type_Bfrt.b(paramMessage, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfxu
 * JD-Core Version:    0.7.0.1
 */