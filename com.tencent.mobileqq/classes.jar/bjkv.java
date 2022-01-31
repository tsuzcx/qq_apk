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

public class bjkv
  implements Handler.Callback
{
  private static int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long;
  private static String jdField_a_of_type_JavaLangString;
  private static long jdField_b_of_type_Long = 20971520L;
  private Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler;
  private Downloader jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader;
  private Map<String, bjky> jdField_a_of_type_JavaUtilMap;
  private int jdField_b_of_type_Int;
  
  bjkv(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    DownloaderFactory.getInstance(this.jdField_a_of_type_AndroidContentContext);
    DownloaderFactory.init(new bjkr(), new bjla());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader = DownloaderFactory.createDownloader("QZonePluginDownloader");
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setPortConfigStrategy(new bjku());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setDirectIPConfigStrategy(new bjkt());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setBackupIPConfigStrategy(new bjkq());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setKeepAliveStrategy(new bjks());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setDownloadMode(Downloader.DownloadMode.StrictMode);
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.enableResumeTransfer(true);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private void a(bjky parambjky)
  {
    PluginRecord localPluginRecord = bjky.a(parambjky);
    Object localObject = bjky.a(parambjky);
    bjky.a(parambjky).state = 1;
    ((bjkz)localObject).a(localPluginRecord);
    File localFile = bjls.e(this.jdField_a_of_type_AndroidContentContext, localPluginRecord.id);
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
      } while (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.download(localPluginRecord.url, localFile.getAbsolutePath(), new bjkx(this, parambjky)));
      localObject = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 3);
      ((Message)localObject).obj = parambjky;
      ((Message)localObject).sendToTarget();
    }
    jdField_a_of_type_JavaLangString = jdField_a_of_type_Long + "_" + (String)localObject;
    this.jdField_b_of_type_Int = 0;
    if (a(localFile.getParent()))
    {
      localObject = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 3);
      ((Message)localObject).obj = parambjky;
      ((Message)localObject).arg1 = -9998;
      ((Message)localObject).sendToTarget();
      return;
    }
  }
  
  private void a(bjky parambjky, int paramInt, String paramString)
  {
    PluginRecord localPluginRecord = bjky.a(parambjky);
    long l1 = System.currentTimeMillis();
    long l2 = jdField_a_of_type_Long;
    LpReportInfo_dc01500.reportDownload(localPluginRecord.id, localPluginRecord.old_ver, localPluginRecord.ver, jdField_a_of_type_JavaLangString, jdField_a_of_type_Int + "", bjky.a(parambjky), (l1 - l2) / 1000.0D, paramInt, this.jdField_b_of_type_Int, paramString);
  }
  
  private void a(bjky parambjky, int paramInt, String paramString1, String paramString2)
  {
    PluginRecord localPluginRecord = bjky.a(parambjky);
    long l1 = System.currentTimeMillis();
    long l2 = jdField_a_of_type_Long;
    LpReportInfo_dc01500.reportDownload(localPluginRecord.id, localPluginRecord.old_ver, localPluginRecord.ver, jdField_a_of_type_JavaLangString, jdField_a_of_type_Int + "", bjky.a(parambjky), (l1 - l2) / 1000.0D, paramInt, this.jdField_b_of_type_Int, paramString1, paramString2);
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
  
  private void b(bjky parambjky)
  {
    if ((parambjky == null) || (bjky.a(parambjky) == null))
    {
      QLog.w("QZonePluginManger", 1, "cancelDownLoadPlugin, downloadRecord or record is null, downloadRecord=" + parambjky);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "cancelDownLoadPlugin url:" + bjky.a(parambjky).url);
    }
    PluginRecord localPluginRecord = bjky.a(parambjky);
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.abort(localPluginRecord.url, new bjkx(this, parambjky));
  }
  
  public void a()
  {
    jdField_a_of_type_Long = 0L;
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_JavaLangString = null;
  }
  
  public void a(PluginRecord paramPluginRecord, bjkz parambjkz)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    bjky localbjky = new bjky(null);
    bjky.a(localbjky, paramPluginRecord.id);
    bjky.a(localbjky, paramPluginRecord);
    bjky.a(localbjky, -1);
    bjky.a(localbjky, parambjkz);
    localMessage.obj = localbjky;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(PluginRecord paramPluginRecord, bjkz parambjkz, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    bjky localbjky = new bjky(null);
    bjky.a(localbjky, paramPluginRecord.id);
    paramPluginRecord.state = 0;
    bjky.a(localbjky, paramPluginRecord);
    bjky.a(localbjky, parambjkz);
    bjky.a(localbjky, paramInt);
    localMessage.obj = localbjky;
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
      paramMessage = (bjky)paramMessage.obj;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(bjky.a(paramMessage))) {
        return false;
      }
      this.jdField_a_of_type_JavaUtilMap.put(bjky.a(paramMessage), paramMessage);
      a(paramMessage);
      return true;
      paramMessage = (bjky)paramMessage.obj;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(bjky.a(paramMessage)))
      {
        a(paramMessage, 3, "");
        this.jdField_a_of_type_JavaUtilMap.remove(bjky.a(paramMessage));
        b(paramMessage);
        Object localObject = bjky.a(paramMessage);
        if (localObject != null)
        {
          ((bjkz)localObject).b(bjky.a(paramMessage));
          continue;
          paramMessage = (bjky)paramMessage.obj;
          if (this.jdField_a_of_type_JavaUtilMap.containsKey(bjky.a(paramMessage)))
          {
            a(paramMessage, 1, "");
            this.jdField_a_of_type_JavaUtilMap.remove(bjky.a(paramMessage));
            localObject = bjky.a(paramMessage);
            if (localObject != null)
            {
              ((bjkz)localObject).b(bjky.a(paramMessage));
              continue;
              localObject = (bjky)paramMessage.obj;
              if (this.jdField_a_of_type_JavaUtilMap.containsKey(bjky.a((bjky)localObject)))
              {
                a((bjky)localObject, 2, paramMessage.arg1 + "", paramMessage.arg2 + "");
                this.jdField_a_of_type_JavaUtilMap.remove(bjky.a((bjky)localObject));
                bjkz localbjkz = bjky.a((bjky)localObject);
                if (localbjkz != null)
                {
                  localbjkz.a(bjky.a((bjky)localObject), paramMessage.arg1);
                  continue;
                  paramMessage = (bjky)paramMessage.obj;
                  if (this.jdField_a_of_type_JavaUtilMap.containsKey(bjky.a(paramMessage)))
                  {
                    a(paramMessage, 0, "");
                    this.jdField_a_of_type_JavaUtilMap.remove(bjky.a(paramMessage));
                    localObject = bjky.a(paramMessage);
                    if (localObject != null)
                    {
                      bjky.a(paramMessage).state = 2;
                      ((bjkz)localObject).b(bjky.a(paramMessage), bjky.a(paramMessage));
                      continue;
                      paramMessage = (bjky)paramMessage.obj;
                      if (this.jdField_a_of_type_JavaUtilMap.containsKey(bjky.a(paramMessage)))
                      {
                        localObject = bjky.a(paramMessage);
                        if (localObject != null) {
                          ((bjkz)localObject).c(bjky.a(paramMessage));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjkv
 * JD-Core Version:    0.7.0.1
 */