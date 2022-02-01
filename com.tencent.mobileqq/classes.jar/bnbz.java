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

public final class bnbz
  implements Handler.Callback
{
  private static String jdField_a_of_type_JavaLangString = "QzoneModuleDownloadManager";
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bmvo jdField_a_of_type_Bmvo;
  private Downloader.DownloadListener jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener = new bnca(this);
  private Map<String, bncb> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  public bnbz(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_Bmvo = bmvo.a();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(QzoneHandlerThreadFactory.getHandlerThreadLooper("Normal_HandlerThread"), this);
  }
  
  private void a(bncb parambncb)
  {
    String str1 = parambncb.jdField_a_of_type_Bnbx.d;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(str1)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(str1, parambncb);
    Object localObject = parambncb.jdField_a_of_type_Bnbx;
    String str2 = QzoneModuleConst.getModuleSavePath(this.jdField_a_of_type_AndroidContentContext, (bnbx)localObject);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "----------savePath--" + str2);
    }
    File localFile = new File(str2);
    if (localFile.exists())
    {
      String str3 = ((bnbx)localObject).e;
      if ((TextUtils.isEmpty(str3)) || ((((bnbx)localObject).jdField_a_of_type_Long != 0L) && (((bnbx)localObject).jdField_a_of_type_Long == localFile.length())))
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "download succeed: from cache.");
        bnbw.a().a((bnbx)localObject);
        if (parambncb.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null)
        {
          parambncb.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadSucceed(parambncb.jdField_a_of_type_JavaLangString);
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
    QLog.i(jdField_a_of_type_JavaLangString, 1, "start download--" + parambncb.jdField_a_of_type_JavaLangString + ",priority: " + parambncb.jdField_a_of_type_Boolean + " ,startImmediately: " + parambncb.b);
    parambncb.jdField_a_of_type_Long = System.nanoTime();
    this.jdField_a_of_type_Bmvo.a(str1, str2, parambncb.jdField_a_of_type_Boolean, parambncb.b, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener);
  }
  
  private void c(String paramString)
  {
    bncb localbncb = (bncb)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    String str2;
    bnbx localbnbx;
    String str3;
    long l;
    if (localbncb != null)
    {
      str2 = QzoneModuleConst.getModuleSavePath(this.jdField_a_of_type_AndroidContentContext, localbncb.jdField_a_of_type_Bnbx);
      localbnbx = localbncb.jdField_a_of_type_Bnbx;
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "download complete: " + str2);
      }
      str3 = localbnbx.e;
      String str1 = "";
      if (!TextUtils.isEmpty(str3)) {
        str1 = bjtz.a(str2);
      }
      l = (System.nanoTime() - localbncb.jdField_a_of_type_Long) / 1000000L;
      if ((!TextUtils.isEmpty(str3)) && (!str3.equalsIgnoreCase(str1))) {
        break label253;
      }
      bnbw.a().a(localbnbx);
    }
    for (;;)
    {
      try
      {
        if (QzoneModuleConst.QZONE_MODULES_NEED_INSTALL.contains(localbnbx.jdField_a_of_type_JavaLangString)) {
          new DexClassLoader(str2, this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getDir("dex", 0).getAbsolutePath(), str2, this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getClassLoader());
        }
        if (localbncb.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null) {
          localbncb.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadSucceed(localbncb.jdField_a_of_type_JavaLangString);
        }
        bnci.a(localbnbx, true, l);
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
      if (localbncb.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null) {
        localbncb.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadFailed(localbncb.jdField_a_of_type_JavaLangString);
      }
      bnci.a(localbnbx, false, l);
    }
  }
  
  public void a(String paramString)
  {
    paramString = bnbw.a().a(paramString);
    if ((paramString == null) || (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString.d))) {}
    do
    {
      return;
      paramString = (bncb)this.jdField_a_of_type_JavaUtilMap.get(paramString.d);
    } while (paramString == null);
    Message localMessage = Message.obtain(this.jdField_a_of_type_AndroidOsHandler);
    localMessage.what = 4;
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public boolean a(bnbx parambnbx, ModuleDownloadListener paramModuleDownloadListener)
  {
    return a(parambnbx, false, paramModuleDownloadListener);
  }
  
  public boolean a(bnbx parambnbx, boolean paramBoolean, ModuleDownloadListener paramModuleDownloadListener)
  {
    return a(parambnbx, paramBoolean, false, paramModuleDownloadListener);
  }
  
  public boolean a(bnbx parambnbx, boolean paramBoolean1, boolean paramBoolean2, ModuleDownloadListener paramModuleDownloadListener)
  {
    if (parambnbx == null) {
      return false;
    }
    bncb localbncb = new bncb(null);
    localbncb.jdField_a_of_type_JavaLangString = parambnbx.jdField_a_of_type_JavaLangString;
    localbncb.jdField_a_of_type_Bnbx = parambnbx;
    localbncb.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener = paramModuleDownloadListener;
    localbncb.jdField_a_of_type_Boolean = paramBoolean1;
    localbncb.b = paramBoolean2;
    parambnbx = Message.obtain(this.jdField_a_of_type_AndroidOsHandler);
    parambnbx.what = 1;
    parambnbx.obj = localbncb;
    parambnbx.sendToTarget();
    return true;
  }
  
  public void b(String paramString)
  {
    paramString = bnbw.a().a(paramString);
    if ((paramString == null) || (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString.d))) {}
    do
    {
      return;
      paramString = (bncb)this.jdField_a_of_type_JavaUtilMap.get(paramString.d);
    } while (paramString == null);
    Message localMessage = Message.obtain(this.jdField_a_of_type_AndroidOsHandler);
    localMessage.what = 7;
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    bncb localbncb;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      a((bncb)paramMessage.obj);
      return true;
    case 2: 
      c((String)paramMessage.obj);
      return true;
    case 3: 
      paramMessage = (String)paramMessage.obj;
      localbncb = (bncb)this.jdField_a_of_type_JavaUtilMap.get(paramMessage);
      if (localbncb != null)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "download failed: " + localbncb.jdField_a_of_type_JavaLangString);
        if (localbncb.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null) {
          localbncb.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadFailed(localbncb.jdField_a_of_type_JavaLangString);
        }
        long l = (System.nanoTime() - localbncb.jdField_a_of_type_Long) / 1000000L;
        bnci.a(localbncb.jdField_a_of_type_Bnbx, false, l);
      }
      this.jdField_a_of_type_JavaUtilMap.remove(paramMessage);
      return true;
    case 4: 
      paramMessage = (bncb)paramMessage.obj;
      QLog.w(jdField_a_of_type_JavaLangString, 1, "cancel download: " + paramMessage.jdField_a_of_type_JavaLangString);
      paramMessage = paramMessage.jdField_a_of_type_Bnbx.d;
      this.jdField_a_of_type_Bmvo.a(paramMessage, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener);
      return true;
    case 5: 
      paramMessage = (String)paramMessage.obj;
      localbncb = (bncb)this.jdField_a_of_type_JavaUtilMap.get(paramMessage);
      if (localbncb != null)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "download canceled: " + localbncb.jdField_a_of_type_JavaLangString);
        if (localbncb.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null) {
          localbncb.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadCanceled(localbncb.jdField_a_of_type_JavaLangString);
        }
      }
      this.jdField_a_of_type_JavaUtilMap.remove(paramMessage);
      return true;
    case 6: 
      paramMessage = (bncb)paramMessage.obj;
      if ((paramMessage != null) && (paramMessage.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null))
      {
        float f = ((Float)paramMessage.jdField_a_of_type_JavaLangObject).floatValue();
        paramMessage.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadProgress(paramMessage.jdField_a_of_type_JavaLangString, f);
      }
      return true;
    }
    paramMessage = (bncb)paramMessage.obj;
    QLog.w(jdField_a_of_type_JavaLangString, 1, "abort download: " + paramMessage.jdField_a_of_type_JavaLangString);
    paramMessage = paramMessage.jdField_a_of_type_Bnbx.d;
    this.jdField_a_of_type_Bmvo.b(paramMessage, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnbz
 * JD-Core Version:    0.7.0.1
 */