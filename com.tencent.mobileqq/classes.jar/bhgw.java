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

public final class bhgw
  implements Handler.Callback
{
  private static String jdField_a_of_type_JavaLangString = "QzoneModuleDownloadManager";
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bhar jdField_a_of_type_Bhar;
  private Downloader.DownloadListener jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener = new bhgx(this);
  private Map<String, bhgy> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  public bhgw(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_Bhar = bhar.a();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(QzoneHandlerThreadFactory.getHandlerThreadLooper("Normal_HandlerThread"), this);
  }
  
  private void a(bhgy parambhgy)
  {
    String str1 = parambhgy.jdField_a_of_type_Bhgu.d;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(str1)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(str1, parambhgy);
    Object localObject = parambhgy.jdField_a_of_type_Bhgu;
    String str2 = QzoneModuleConst.getModuleSavePath(this.jdField_a_of_type_AndroidContentContext, (bhgu)localObject);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "----------savePath--" + str2);
    }
    File localFile = new File(str2);
    if (localFile.exists())
    {
      String str3 = ((bhgu)localObject).e;
      if ((TextUtils.isEmpty(str3)) || ((((bhgu)localObject).jdField_a_of_type_Long != 0L) && (((bhgu)localObject).jdField_a_of_type_Long == localFile.length())))
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "download succeed: from cache.");
        bhgt.a().a((bhgu)localObject);
        if (parambhgy.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null)
        {
          parambhgy.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadSucceed(parambhgy.jdField_a_of_type_JavaLangString);
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
    QLog.i(jdField_a_of_type_JavaLangString, 1, "start download--" + parambhgy.jdField_a_of_type_JavaLangString + ",priority: " + parambhgy.jdField_a_of_type_Boolean + " ,startImmediately: " + parambhgy.b);
    parambhgy.jdField_a_of_type_Long = System.nanoTime();
    this.jdField_a_of_type_Bhar.a(str1, str2, parambhgy.jdField_a_of_type_Boolean, parambhgy.b, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener);
  }
  
  private void c(String paramString)
  {
    bhgy localbhgy = (bhgy)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    String str2;
    bhgu localbhgu;
    String str3;
    long l;
    if (localbhgy != null)
    {
      str2 = QzoneModuleConst.getModuleSavePath(this.jdField_a_of_type_AndroidContentContext, localbhgy.jdField_a_of_type_Bhgu);
      localbhgu = localbhgy.jdField_a_of_type_Bhgu;
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "download complete: " + str2);
      }
      str3 = localbhgu.e;
      String str1 = "";
      if (!TextUtils.isEmpty(str3)) {
        str1 = bdik.a(str2);
      }
      l = (System.nanoTime() - localbhgy.jdField_a_of_type_Long) / 1000000L;
      if ((!TextUtils.isEmpty(str3)) && (!str3.equalsIgnoreCase(str1))) {
        break label253;
      }
      bhgt.a().a(localbhgu);
    }
    for (;;)
    {
      try
      {
        if (QzoneModuleConst.QZONE_MODULES_NEED_INSTALL.contains(localbhgu.jdField_a_of_type_JavaLangString)) {
          new DexClassLoader(str2, this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getDir("dex", 0).getAbsolutePath(), str2, this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getClassLoader());
        }
        if (localbhgy.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null) {
          localbhgy.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadSucceed(localbhgy.jdField_a_of_type_JavaLangString);
        }
        bhhf.a(localbhgu, true, l);
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
      if (localbhgy.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null) {
        localbhgy.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadFailed(localbhgy.jdField_a_of_type_JavaLangString);
      }
      bhhf.a(localbhgu, false, l);
    }
  }
  
  public void a(String paramString)
  {
    paramString = bhgt.a().a(paramString);
    if ((paramString == null) || (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString.d))) {}
    do
    {
      return;
      paramString = (bhgy)this.jdField_a_of_type_JavaUtilMap.get(paramString.d);
    } while (paramString == null);
    Message localMessage = Message.obtain(this.jdField_a_of_type_AndroidOsHandler);
    localMessage.what = 4;
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public boolean a(bhgu parambhgu, ModuleDownloadListener paramModuleDownloadListener)
  {
    return a(parambhgu, false, paramModuleDownloadListener);
  }
  
  public boolean a(bhgu parambhgu, boolean paramBoolean, ModuleDownloadListener paramModuleDownloadListener)
  {
    return a(parambhgu, paramBoolean, false, paramModuleDownloadListener);
  }
  
  public boolean a(bhgu parambhgu, boolean paramBoolean1, boolean paramBoolean2, ModuleDownloadListener paramModuleDownloadListener)
  {
    if (parambhgu == null) {
      return false;
    }
    bhgy localbhgy = new bhgy(null);
    localbhgy.jdField_a_of_type_JavaLangString = parambhgu.jdField_a_of_type_JavaLangString;
    localbhgy.jdField_a_of_type_Bhgu = parambhgu;
    localbhgy.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener = paramModuleDownloadListener;
    localbhgy.jdField_a_of_type_Boolean = paramBoolean1;
    localbhgy.b = paramBoolean2;
    parambhgu = Message.obtain(this.jdField_a_of_type_AndroidOsHandler);
    parambhgu.what = 1;
    parambhgu.obj = localbhgy;
    parambhgu.sendToTarget();
    return true;
  }
  
  public void b(String paramString)
  {
    paramString = bhgt.a().a(paramString);
    if ((paramString == null) || (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString.d))) {}
    do
    {
      return;
      paramString = (bhgy)this.jdField_a_of_type_JavaUtilMap.get(paramString.d);
    } while (paramString == null);
    Message localMessage = Message.obtain(this.jdField_a_of_type_AndroidOsHandler);
    localMessage.what = 7;
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    bhgy localbhgy;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      a((bhgy)paramMessage.obj);
      return true;
    case 2: 
      c((String)paramMessage.obj);
      return true;
    case 3: 
      paramMessage = (String)paramMessage.obj;
      localbhgy = (bhgy)this.jdField_a_of_type_JavaUtilMap.get(paramMessage);
      if (localbhgy != null)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "download failed: " + localbhgy.jdField_a_of_type_JavaLangString);
        if (localbhgy.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null) {
          localbhgy.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadFailed(localbhgy.jdField_a_of_type_JavaLangString);
        }
        long l = (System.nanoTime() - localbhgy.jdField_a_of_type_Long) / 1000000L;
        bhhf.a(localbhgy.jdField_a_of_type_Bhgu, false, l);
      }
      this.jdField_a_of_type_JavaUtilMap.remove(paramMessage);
      return true;
    case 4: 
      paramMessage = (bhgy)paramMessage.obj;
      QLog.w(jdField_a_of_type_JavaLangString, 1, "cancel download: " + paramMessage.jdField_a_of_type_JavaLangString);
      paramMessage = paramMessage.jdField_a_of_type_Bhgu.d;
      this.jdField_a_of_type_Bhar.a(paramMessage, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener);
      return true;
    case 5: 
      paramMessage = (String)paramMessage.obj;
      localbhgy = (bhgy)this.jdField_a_of_type_JavaUtilMap.get(paramMessage);
      if (localbhgy != null)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "download canceled: " + localbhgy.jdField_a_of_type_JavaLangString);
        if (localbhgy.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null) {
          localbhgy.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadCanceled(localbhgy.jdField_a_of_type_JavaLangString);
        }
      }
      this.jdField_a_of_type_JavaUtilMap.remove(paramMessage);
      return true;
    case 6: 
      paramMessage = (bhgy)paramMessage.obj;
      if ((paramMessage != null) && (paramMessage.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null))
      {
        float f = ((Float)paramMessage.jdField_a_of_type_JavaLangObject).floatValue();
        paramMessage.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadProgress(paramMessage.jdField_a_of_type_JavaLangString, f);
      }
      return true;
    }
    paramMessage = (bhgy)paramMessage.obj;
    QLog.w(jdField_a_of_type_JavaLangString, 1, "abort download: " + paramMessage.jdField_a_of_type_JavaLangString);
    paramMessage = paramMessage.jdField_a_of_type_Bhgu.d;
    this.jdField_a_of_type_Bhar.b(paramMessage, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhgw
 * JD-Core Version:    0.7.0.1
 */