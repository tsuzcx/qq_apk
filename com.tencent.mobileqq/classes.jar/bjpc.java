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

public class bjpc
  implements Handler.Callback
{
  private static int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long;
  private static String jdField_a_of_type_JavaLangString;
  private static long jdField_b_of_type_Long = 20971520L;
  private Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler;
  private Downloader jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader;
  private Map<String, bjpf> jdField_a_of_type_JavaUtilMap;
  private int jdField_b_of_type_Int;
  
  bjpc(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    DownloaderFactory.getInstance(this.jdField_a_of_type_AndroidContentContext);
    DownloaderFactory.init(new bjoy(), new bjph());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader = DownloaderFactory.createDownloader("QZonePluginDownloader");
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setPortConfigStrategy(new bjpb());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setDirectIPConfigStrategy(new bjpa());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setBackupIPConfigStrategy(new bjox());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setKeepAliveStrategy(new bjoz());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setDownloadMode(Downloader.DownloadMode.StrictMode);
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.enableResumeTransfer(true);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private void a(bjpf parambjpf)
  {
    PluginRecord localPluginRecord = bjpf.a(parambjpf);
    Object localObject = bjpf.a(parambjpf);
    bjpf.a(parambjpf).state = 1;
    ((bjpg)localObject).a(localPluginRecord);
    File localFile = bjpz.e(this.jdField_a_of_type_AndroidContentContext, localPluginRecord.id);
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
      } while (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.download(localPluginRecord.url, localFile.getAbsolutePath(), new bjpe(this, parambjpf)));
      localObject = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 3);
      ((Message)localObject).obj = parambjpf;
      ((Message)localObject).sendToTarget();
    }
    jdField_a_of_type_JavaLangString = jdField_a_of_type_Long + "_" + (String)localObject;
    this.jdField_b_of_type_Int = 0;
    if (a(localFile.getParent()))
    {
      localObject = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 3);
      ((Message)localObject).obj = parambjpf;
      ((Message)localObject).arg1 = -9998;
      ((Message)localObject).sendToTarget();
      return;
    }
  }
  
  private void a(bjpf parambjpf, int paramInt, String paramString)
  {
    PluginRecord localPluginRecord = bjpf.a(parambjpf);
    long l1 = System.currentTimeMillis();
    long l2 = jdField_a_of_type_Long;
    LpReportInfo_dc01500.reportDownload(localPluginRecord.id, localPluginRecord.old_ver, localPluginRecord.ver, jdField_a_of_type_JavaLangString, jdField_a_of_type_Int + "", bjpf.a(parambjpf), (l1 - l2) / 1000.0D, paramInt, this.jdField_b_of_type_Int, paramString);
  }
  
  private void a(bjpf parambjpf, int paramInt, String paramString1, String paramString2)
  {
    PluginRecord localPluginRecord = bjpf.a(parambjpf);
    long l1 = System.currentTimeMillis();
    long l2 = jdField_a_of_type_Long;
    LpReportInfo_dc01500.reportDownload(localPluginRecord.id, localPluginRecord.old_ver, localPluginRecord.ver, jdField_a_of_type_JavaLangString, jdField_a_of_type_Int + "", bjpf.a(parambjpf), (l1 - l2) / 1000.0D, paramInt, this.jdField_b_of_type_Int, paramString1, paramString2);
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
  
  private void b(bjpf parambjpf)
  {
    if ((parambjpf == null) || (bjpf.a(parambjpf) == null))
    {
      QLog.w("QZonePluginManger", 1, "cancelDownLoadPlugin, downloadRecord or record is null, downloadRecord=" + parambjpf);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "cancelDownLoadPlugin url:" + bjpf.a(parambjpf).url);
    }
    PluginRecord localPluginRecord = bjpf.a(parambjpf);
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.abort(localPluginRecord.url, new bjpe(this, parambjpf));
  }
  
  public void a()
  {
    jdField_a_of_type_Long = 0L;
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_JavaLangString = null;
  }
  
  public void a(PluginRecord paramPluginRecord, bjpg parambjpg)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    bjpf localbjpf = new bjpf(null);
    bjpf.a(localbjpf, paramPluginRecord.id);
    bjpf.a(localbjpf, paramPluginRecord);
    bjpf.a(localbjpf, -1);
    bjpf.a(localbjpf, parambjpg);
    localMessage.obj = localbjpf;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(PluginRecord paramPluginRecord, bjpg parambjpg, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    bjpf localbjpf = new bjpf(null);
    bjpf.a(localbjpf, paramPluginRecord.id);
    paramPluginRecord.state = 0;
    bjpf.a(localbjpf, paramPluginRecord);
    bjpf.a(localbjpf, parambjpg);
    bjpf.a(localbjpf, paramInt);
    localMessage.obj = localbjpf;
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
      paramMessage = (bjpf)paramMessage.obj;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(bjpf.a(paramMessage))) {
        return false;
      }
      this.jdField_a_of_type_JavaUtilMap.put(bjpf.a(paramMessage), paramMessage);
      a(paramMessage);
      return true;
      paramMessage = (bjpf)paramMessage.obj;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(bjpf.a(paramMessage)))
      {
        a(paramMessage, 3, "");
        this.jdField_a_of_type_JavaUtilMap.remove(bjpf.a(paramMessage));
        b(paramMessage);
        Object localObject = bjpf.a(paramMessage);
        if (localObject != null)
        {
          ((bjpg)localObject).b(bjpf.a(paramMessage));
          continue;
          paramMessage = (bjpf)paramMessage.obj;
          if (this.jdField_a_of_type_JavaUtilMap.containsKey(bjpf.a(paramMessage)))
          {
            a(paramMessage, 1, "");
            this.jdField_a_of_type_JavaUtilMap.remove(bjpf.a(paramMessage));
            localObject = bjpf.a(paramMessage);
            if (localObject != null)
            {
              ((bjpg)localObject).b(bjpf.a(paramMessage));
              continue;
              localObject = (bjpf)paramMessage.obj;
              if (this.jdField_a_of_type_JavaUtilMap.containsKey(bjpf.a((bjpf)localObject)))
              {
                a((bjpf)localObject, 2, paramMessage.arg1 + "", paramMessage.arg2 + "");
                this.jdField_a_of_type_JavaUtilMap.remove(bjpf.a((bjpf)localObject));
                bjpg localbjpg = bjpf.a((bjpf)localObject);
                if (localbjpg != null)
                {
                  localbjpg.a(bjpf.a((bjpf)localObject), paramMessage.arg1);
                  continue;
                  paramMessage = (bjpf)paramMessage.obj;
                  if (this.jdField_a_of_type_JavaUtilMap.containsKey(bjpf.a(paramMessage)))
                  {
                    a(paramMessage, 0, "");
                    this.jdField_a_of_type_JavaUtilMap.remove(bjpf.a(paramMessage));
                    localObject = bjpf.a(paramMessage);
                    if (localObject != null)
                    {
                      bjpf.a(paramMessage).state = 2;
                      ((bjpg)localObject).b(bjpf.a(paramMessage), bjpf.a(paramMessage));
                      continue;
                      paramMessage = (bjpf)paramMessage.obj;
                      if (this.jdField_a_of_type_JavaUtilMap.containsKey(bjpf.a(paramMessage)))
                      {
                        localObject = bjpf.a(paramMessage);
                        if (localObject != null) {
                          ((bjpg)localObject).c(bjpf.a(paramMessage));
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
 * Qualified Name:     bjpc
 * JD-Core Version:    0.7.0.1
 */