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

public final class bmax
  implements Handler.Callback
{
  private static String jdField_a_of_type_JavaLangString = "QzoneModuleDownloadManager";
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private blum jdField_a_of_type_Blum;
  private Downloader.DownloadListener jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener = new bmay(this);
  private Map<String, bmaz> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  public bmax(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_Blum = blum.a();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(QzoneHandlerThreadFactory.getHandlerThreadLooper("Normal_HandlerThread"), this);
  }
  
  private void a(bmaz parambmaz)
  {
    String str1 = parambmaz.jdField_a_of_type_Bmav.d;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(str1)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(str1, parambmaz);
    Object localObject = parambmaz.jdField_a_of_type_Bmav;
    String str2 = QzoneModuleConst.getModuleSavePath(this.jdField_a_of_type_AndroidContentContext, (bmav)localObject);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "----------savePath--" + str2);
    }
    File localFile = new File(str2);
    if (localFile.exists())
    {
      String str3 = ((bmav)localObject).e;
      if ((TextUtils.isEmpty(str3)) || ((((bmav)localObject).jdField_a_of_type_Long != 0L) && (((bmav)localObject).jdField_a_of_type_Long == localFile.length())))
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "download succeed: from cache.");
        bmau.a().a((bmav)localObject);
        if (parambmaz.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null)
        {
          parambmaz.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadSucceed(parambmaz.jdField_a_of_type_JavaLangString);
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
    QLog.i(jdField_a_of_type_JavaLangString, 1, "start download--" + parambmaz.jdField_a_of_type_JavaLangString + ",priority: " + parambmaz.jdField_a_of_type_Boolean + " ,startImmediately: " + parambmaz.b);
    parambmaz.jdField_a_of_type_Long = System.nanoTime();
    this.jdField_a_of_type_Blum.a(str1, str2, parambmaz.jdField_a_of_type_Boolean, parambmaz.b, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener);
  }
  
  private void c(String paramString)
  {
    bmaz localbmaz = (bmaz)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    String str2;
    bmav localbmav;
    String str3;
    long l;
    if (localbmaz != null)
    {
      str2 = QzoneModuleConst.getModuleSavePath(this.jdField_a_of_type_AndroidContentContext, localbmaz.jdField_a_of_type_Bmav);
      localbmav = localbmaz.jdField_a_of_type_Bmav;
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "download complete: " + str2);
      }
      str3 = localbmav.e;
      String str1 = "";
      if (!TextUtils.isEmpty(str3)) {
        str1 = bita.a(str2);
      }
      l = (System.nanoTime() - localbmaz.jdField_a_of_type_Long) / 1000000L;
      if ((!TextUtils.isEmpty(str3)) && (!str3.equalsIgnoreCase(str1))) {
        break label253;
      }
      bmau.a().a(localbmav);
    }
    for (;;)
    {
      try
      {
        if (QzoneModuleConst.QZONE_MODULES_NEED_INSTALL.contains(localbmav.jdField_a_of_type_JavaLangString)) {
          new DexClassLoader(str2, this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getDir("dex", 0).getAbsolutePath(), str2, this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getClassLoader());
        }
        if (localbmaz.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null) {
          localbmaz.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadSucceed(localbmaz.jdField_a_of_type_JavaLangString);
        }
        bmbg.a(localbmav, true, l);
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
      if (localbmaz.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null) {
        localbmaz.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadFailed(localbmaz.jdField_a_of_type_JavaLangString);
      }
      bmbg.a(localbmav, false, l);
    }
  }
  
  public void a(String paramString)
  {
    paramString = bmau.a().a(paramString);
    if ((paramString == null) || (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString.d))) {}
    do
    {
      return;
      paramString = (bmaz)this.jdField_a_of_type_JavaUtilMap.get(paramString.d);
    } while (paramString == null);
    Message localMessage = Message.obtain(this.jdField_a_of_type_AndroidOsHandler);
    localMessage.what = 4;
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public boolean a(bmav parambmav, ModuleDownloadListener paramModuleDownloadListener)
  {
    return a(parambmav, false, paramModuleDownloadListener);
  }
  
  public boolean a(bmav parambmav, boolean paramBoolean, ModuleDownloadListener paramModuleDownloadListener)
  {
    return a(parambmav, paramBoolean, false, paramModuleDownloadListener);
  }
  
  public boolean a(bmav parambmav, boolean paramBoolean1, boolean paramBoolean2, ModuleDownloadListener paramModuleDownloadListener)
  {
    if (parambmav == null) {
      return false;
    }
    bmaz localbmaz = new bmaz(null);
    localbmaz.jdField_a_of_type_JavaLangString = parambmav.jdField_a_of_type_JavaLangString;
    localbmaz.jdField_a_of_type_Bmav = parambmav;
    localbmaz.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener = paramModuleDownloadListener;
    localbmaz.jdField_a_of_type_Boolean = paramBoolean1;
    localbmaz.b = paramBoolean2;
    parambmav = Message.obtain(this.jdField_a_of_type_AndroidOsHandler);
    parambmav.what = 1;
    parambmav.obj = localbmaz;
    parambmav.sendToTarget();
    return true;
  }
  
  public void b(String paramString)
  {
    paramString = bmau.a().a(paramString);
    if ((paramString == null) || (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString.d))) {}
    do
    {
      return;
      paramString = (bmaz)this.jdField_a_of_type_JavaUtilMap.get(paramString.d);
    } while (paramString == null);
    Message localMessage = Message.obtain(this.jdField_a_of_type_AndroidOsHandler);
    localMessage.what = 7;
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    bmaz localbmaz;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      a((bmaz)paramMessage.obj);
      return true;
    case 2: 
      c((String)paramMessage.obj);
      return true;
    case 3: 
      paramMessage = (String)paramMessage.obj;
      localbmaz = (bmaz)this.jdField_a_of_type_JavaUtilMap.get(paramMessage);
      if (localbmaz != null)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "download failed: " + localbmaz.jdField_a_of_type_JavaLangString);
        if (localbmaz.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null) {
          localbmaz.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadFailed(localbmaz.jdField_a_of_type_JavaLangString);
        }
        long l = (System.nanoTime() - localbmaz.jdField_a_of_type_Long) / 1000000L;
        bmbg.a(localbmaz.jdField_a_of_type_Bmav, false, l);
      }
      this.jdField_a_of_type_JavaUtilMap.remove(paramMessage);
      return true;
    case 4: 
      paramMessage = (bmaz)paramMessage.obj;
      QLog.w(jdField_a_of_type_JavaLangString, 1, "cancel download: " + paramMessage.jdField_a_of_type_JavaLangString);
      paramMessage = paramMessage.jdField_a_of_type_Bmav.d;
      this.jdField_a_of_type_Blum.a(paramMessage, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener);
      return true;
    case 5: 
      paramMessage = (String)paramMessage.obj;
      localbmaz = (bmaz)this.jdField_a_of_type_JavaUtilMap.get(paramMessage);
      if (localbmaz != null)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "download canceled: " + localbmaz.jdField_a_of_type_JavaLangString);
        if (localbmaz.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null) {
          localbmaz.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadCanceled(localbmaz.jdField_a_of_type_JavaLangString);
        }
      }
      this.jdField_a_of_type_JavaUtilMap.remove(paramMessage);
      return true;
    case 6: 
      paramMessage = (bmaz)paramMessage.obj;
      if ((paramMessage != null) && (paramMessage.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener != null))
      {
        float f = ((Float)paramMessage.jdField_a_of_type_JavaLangObject).floatValue();
        paramMessage.jdField_a_of_type_CooperationQzoneNetworkedmoduleModuleDownloadListener.onDownloadProgress(paramMessage.jdField_a_of_type_JavaLangString, f);
      }
      return true;
    }
    paramMessage = (bmaz)paramMessage.obj;
    QLog.w(jdField_a_of_type_JavaLangString, 1, "abort download: " + paramMessage.jdField_a_of_type_JavaLangString);
    paramMessage = paramMessage.jdField_a_of_type_Bmav.d;
    this.jdField_a_of_type_Blum.b(paramMessage, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmax
 * JD-Core Version:    0.7.0.1
 */