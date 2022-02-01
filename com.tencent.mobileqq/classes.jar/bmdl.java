import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.component.network.module.common.NetworkState;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.plugin.PluginRecord;
import cooperation.qzone.report.lp.LpReportInfo_dc01500;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class bmdl
  implements Handler.Callback
{
  private static int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long;
  private static String jdField_a_of_type_JavaLangString;
  private static long jdField_b_of_type_Long = 20971520L;
  private Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler;
  private Downloader jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader;
  private Map<String, bmdo> jdField_a_of_type_JavaUtilMap;
  private int jdField_b_of_type_Int;
  
  bmdl(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    DownloaderFactory.getInstance(this.jdField_a_of_type_AndroidContentContext);
    DownloaderFactory.init(new bmdh(), new bmdq());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader = DownloaderFactory.createDownloader("QZonePluginDownloader");
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setPortConfigStrategy(new bmdk());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setDirectIPConfigStrategy(new bmdj());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setBackupIPConfigStrategy(new bmdg());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setKeepAliveStrategy(new bmdi());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setDownloadMode(Downloader.DownloadMode.StrictMode);
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.enableResumeTransfer(true);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private void a(bmdo parambmdo)
  {
    PluginRecord localPluginRecord = bmdo.a(parambmdo);
    Object localObject = bmdo.a(parambmdo);
    bmdo.a(parambmdo).state = 1;
    ((bmdp)localObject).a(localPluginRecord);
    File localFile = bmei.e(this.jdField_a_of_type_AndroidContentContext, localPluginRecord.id);
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "downloadPluginInner url:" + localPluginRecord.url + ",path:" + localFile);
    }
    jdField_a_of_type_Long = System.currentTimeMillis();
    jdField_a_of_type_Int = NetworkState.g().getNetworkType();
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      localObject = "";
    }
    try
    {
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      localObject = str;
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          QLog.w("QZonePluginManger", 1, "", localException);
        }
      } while (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.download(localPluginRecord.url, localFile.getAbsolutePath(), new bmdn(this, parambmdo)));
      localObject = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 3);
      ((Message)localObject).obj = parambmdo;
      ((Message)localObject).sendToTarget();
    }
    jdField_a_of_type_JavaLangString = jdField_a_of_type_Long + "_" + (String)localObject;
    this.jdField_b_of_type_Int = 0;
    if (a(localFile.getParent()))
    {
      localObject = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 3);
      ((Message)localObject).obj = parambmdo;
      ((Message)localObject).arg1 = -9998;
      ((Message)localObject).sendToTarget();
      return;
    }
  }
  
  private void a(bmdo parambmdo, int paramInt, String paramString)
  {
    PluginRecord localPluginRecord = bmdo.a(parambmdo);
    long l1 = System.currentTimeMillis();
    long l2 = jdField_a_of_type_Long;
    LpReportInfo_dc01500.reportDownload(localPluginRecord.id, localPluginRecord.old_ver, localPluginRecord.ver, jdField_a_of_type_JavaLangString, jdField_a_of_type_Int + "", bmdo.a(parambmdo), (l1 - l2) / 1000.0D, paramInt, this.jdField_b_of_type_Int, paramString);
  }
  
  private void a(bmdo parambmdo, int paramInt, String paramString1, String paramString2)
  {
    PluginRecord localPluginRecord = bmdo.a(parambmdo);
    long l1 = System.currentTimeMillis();
    long l2 = jdField_a_of_type_Long;
    LpReportInfo_dc01500.reportDownload(localPluginRecord.id, localPluginRecord.old_ver, localPluginRecord.ver, jdField_a_of_type_JavaLangString, jdField_a_of_type_Int + "", bmdo.a(parambmdo), (l1 - l2) / 1000.0D, paramInt, this.jdField_b_of_type_Int, paramString1, paramString2);
  }
  
  private boolean a(String paramString)
  {
    try
    {
      StatFs localStatFs = new StatFs(paramString);
      long l = localStatFs.getAvailableBlocks() * localStatFs.getBlockSize();
      if (l < QzoneConfig.getInstance().getConfig("LiveSetting", "livePluginDownloadAvailableSpace", jdField_b_of_type_Long)) {}
      for (boolean bool = true;; bool = false)
      {
        if (bool) {
          QLog.w("QZonePluginManger", 1, "low storage: totalSize=" + localStatFs.getBlockCount() * localStatFs.getBlockSize() + ", availableSize=" + l + ", path=" + paramString);
        }
        return bool;
      }
      return true;
    }
    catch (Throwable paramString)
    {
      QLog.e("QZonePluginManger", 1, "", paramString);
    }
  }
  
  private void b(bmdo parambmdo)
  {
    if ((parambmdo == null) || (bmdo.a(parambmdo) == null))
    {
      QLog.w("QZonePluginManger", 1, "cancelDownLoadPlugin, downloadRecord or record is null, downloadRecord=" + parambmdo);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "cancelDownLoadPlugin url:" + bmdo.a(parambmdo).url);
    }
    PluginRecord localPluginRecord = bmdo.a(parambmdo);
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.abort(localPluginRecord.url, new bmdn(this, parambmdo));
  }
  
  public void a()
  {
    jdField_a_of_type_Long = 0L;
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_JavaLangString = null;
  }
  
  public void a(PluginRecord paramPluginRecord, bmdp parambmdp)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    bmdo localbmdo = new bmdo(null);
    bmdo.a(localbmdo, paramPluginRecord.id);
    bmdo.a(localbmdo, paramPluginRecord);
    bmdo.a(localbmdo, -1);
    bmdo.a(localbmdo, parambmdp);
    localMessage.obj = localbmdo;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(PluginRecord paramPluginRecord, bmdp parambmdp, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    bmdo localbmdo = new bmdo(null);
    bmdo.a(localbmdo, paramPluginRecord.id);
    paramPluginRecord.state = 0;
    bmdo.a(localbmdo, paramPluginRecord);
    bmdo.a(localbmdo, parambmdp);
    bmdo.a(localbmdo, paramInt);
    localMessage.obj = localbmdo;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      paramMessage = (bmdo)paramMessage.obj;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(bmdo.a(paramMessage))) {
        return false;
      }
      this.jdField_a_of_type_JavaUtilMap.put(bmdo.a(paramMessage), paramMessage);
      a(paramMessage);
      return true;
      paramMessage = (bmdo)paramMessage.obj;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(bmdo.a(paramMessage)))
      {
        a(paramMessage, 3, "");
        this.jdField_a_of_type_JavaUtilMap.remove(bmdo.a(paramMessage));
        b(paramMessage);
        Object localObject = bmdo.a(paramMessage);
        if (localObject != null)
        {
          ((bmdp)localObject).b(bmdo.a(paramMessage));
          continue;
          paramMessage = (bmdo)paramMessage.obj;
          if (this.jdField_a_of_type_JavaUtilMap.containsKey(bmdo.a(paramMessage)))
          {
            a(paramMessage, 1, "");
            this.jdField_a_of_type_JavaUtilMap.remove(bmdo.a(paramMessage));
            localObject = bmdo.a(paramMessage);
            if (localObject != null)
            {
              ((bmdp)localObject).b(bmdo.a(paramMessage));
              continue;
              localObject = (bmdo)paramMessage.obj;
              if (this.jdField_a_of_type_JavaUtilMap.containsKey(bmdo.a((bmdo)localObject)))
              {
                a((bmdo)localObject, 2, paramMessage.arg1 + "", paramMessage.arg2 + "");
                this.jdField_a_of_type_JavaUtilMap.remove(bmdo.a((bmdo)localObject));
                bmdp localbmdp = bmdo.a((bmdo)localObject);
                if (localbmdp != null)
                {
                  localbmdp.a(bmdo.a((bmdo)localObject), paramMessage.arg1);
                  continue;
                  paramMessage = (bmdo)paramMessage.obj;
                  if (this.jdField_a_of_type_JavaUtilMap.containsKey(bmdo.a(paramMessage)))
                  {
                    a(paramMessage, 0, "");
                    this.jdField_a_of_type_JavaUtilMap.remove(bmdo.a(paramMessage));
                    localObject = bmdo.a(paramMessage);
                    if (localObject != null)
                    {
                      bmdo.a(paramMessage).state = 2;
                      ((bmdp)localObject).b(bmdo.a(paramMessage), bmdo.a(paramMessage));
                      continue;
                      paramMessage = (bmdo)paramMessage.obj;
                      if (this.jdField_a_of_type_JavaUtilMap.containsKey(bmdo.a(paramMessage)))
                      {
                        localObject = bmdo.a(paramMessage);
                        if (localObject != null) {
                          ((bmdp)localObject).c(bmdo.a(paramMessage));
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmdl
 * JD-Core Version:    0.7.0.1
 */