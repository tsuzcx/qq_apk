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

public class bgai
  implements Handler.Callback
{
  private static int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long;
  private static String jdField_a_of_type_JavaLangString;
  private static long jdField_b_of_type_Long = 20971520L;
  private Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler;
  private Downloader jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader;
  private Map<String, bgal> jdField_a_of_type_JavaUtilMap;
  private int jdField_b_of_type_Int;
  
  bgai(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    DownloaderFactory.getInstance(this.jdField_a_of_type_AndroidContentContext);
    DownloaderFactory.init(new bgae(), new bgan());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader = DownloaderFactory.createDownloader("QZonePluginDownloader");
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setPortConfigStrategy(new bgah());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setDirectIPConfigStrategy(new bgag());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setBackupIPConfigStrategy(new bgad());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setKeepAliveStrategy(new bgaf());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setDownloadMode(Downloader.DownloadMode.StrictMode);
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.enableResumeTransfer(true);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private void a(bgal parambgal)
  {
    PluginRecord localPluginRecord = bgal.a(parambgal);
    Object localObject = bgal.a(parambgal);
    bgal.a(parambgal).state = 1;
    ((bgam)localObject).a(localPluginRecord);
    File localFile = bgbf.e(this.jdField_a_of_type_AndroidContentContext, localPluginRecord.id);
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
      } while (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.download(localPluginRecord.url, localFile.getAbsolutePath(), new bgak(this, parambgal)));
      localObject = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 3);
      ((Message)localObject).obj = parambgal;
      ((Message)localObject).sendToTarget();
    }
    jdField_a_of_type_JavaLangString = jdField_a_of_type_Long + "_" + (String)localObject;
    this.jdField_b_of_type_Int = 0;
    if (a(localFile.getParent()))
    {
      localObject = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 3);
      ((Message)localObject).obj = parambgal;
      ((Message)localObject).arg1 = -9998;
      ((Message)localObject).sendToTarget();
      return;
    }
  }
  
  private void a(bgal parambgal, int paramInt, String paramString)
  {
    PluginRecord localPluginRecord = bgal.a(parambgal);
    long l1 = System.currentTimeMillis();
    long l2 = jdField_a_of_type_Long;
    LpReportInfo_dc01500.reportDownload(localPluginRecord.id, localPluginRecord.old_ver, localPluginRecord.ver, jdField_a_of_type_JavaLangString, jdField_a_of_type_Int + "", bgal.a(parambgal), (l1 - l2) / 1000.0D, paramInt, this.jdField_b_of_type_Int, paramString);
  }
  
  private void a(bgal parambgal, int paramInt, String paramString1, String paramString2)
  {
    PluginRecord localPluginRecord = bgal.a(parambgal);
    long l1 = System.currentTimeMillis();
    long l2 = jdField_a_of_type_Long;
    LpReportInfo_dc01500.reportDownload(localPluginRecord.id, localPluginRecord.old_ver, localPluginRecord.ver, jdField_a_of_type_JavaLangString, jdField_a_of_type_Int + "", bgal.a(parambgal), (l1 - l2) / 1000.0D, paramInt, this.jdField_b_of_type_Int, paramString1, paramString2);
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
  
  private void b(bgal parambgal)
  {
    if ((parambgal == null) || (bgal.a(parambgal) == null))
    {
      QLog.w("QZonePluginManger", 1, "cancelDownLoadPlugin, downloadRecord or record is null, downloadRecord=" + parambgal);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "cancelDownLoadPlugin url:" + bgal.a(parambgal).url);
    }
    PluginRecord localPluginRecord = bgal.a(parambgal);
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.abort(localPluginRecord.url, new bgak(this, parambgal));
  }
  
  public void a()
  {
    jdField_a_of_type_Long = 0L;
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_JavaLangString = null;
  }
  
  public void a(PluginRecord paramPluginRecord, bgam parambgam)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    bgal localbgal = new bgal(null);
    bgal.a(localbgal, paramPluginRecord.id);
    bgal.a(localbgal, paramPluginRecord);
    bgal.a(localbgal, -1);
    bgal.a(localbgal, parambgam);
    localMessage.obj = localbgal;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(PluginRecord paramPluginRecord, bgam parambgam, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    bgal localbgal = new bgal(null);
    bgal.a(localbgal, paramPluginRecord.id);
    paramPluginRecord.state = 0;
    bgal.a(localbgal, paramPluginRecord);
    bgal.a(localbgal, parambgam);
    bgal.a(localbgal, paramInt);
    localMessage.obj = localbgal;
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
      paramMessage = (bgal)paramMessage.obj;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(bgal.a(paramMessage))) {
        return false;
      }
      this.jdField_a_of_type_JavaUtilMap.put(bgal.a(paramMessage), paramMessage);
      a(paramMessage);
      return true;
      paramMessage = (bgal)paramMessage.obj;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(bgal.a(paramMessage)))
      {
        a(paramMessage, 3, "");
        this.jdField_a_of_type_JavaUtilMap.remove(bgal.a(paramMessage));
        b(paramMessage);
        Object localObject = bgal.a(paramMessage);
        if (localObject != null)
        {
          ((bgam)localObject).b(bgal.a(paramMessage));
          continue;
          paramMessage = (bgal)paramMessage.obj;
          if (this.jdField_a_of_type_JavaUtilMap.containsKey(bgal.a(paramMessage)))
          {
            a(paramMessage, 1, "");
            this.jdField_a_of_type_JavaUtilMap.remove(bgal.a(paramMessage));
            localObject = bgal.a(paramMessage);
            if (localObject != null)
            {
              ((bgam)localObject).b(bgal.a(paramMessage));
              continue;
              localObject = (bgal)paramMessage.obj;
              if (this.jdField_a_of_type_JavaUtilMap.containsKey(bgal.a((bgal)localObject)))
              {
                a((bgal)localObject, 2, paramMessage.arg1 + "", paramMessage.arg2 + "");
                this.jdField_a_of_type_JavaUtilMap.remove(bgal.a((bgal)localObject));
                bgam localbgam = bgal.a((bgal)localObject);
                if (localbgam != null)
                {
                  localbgam.a(bgal.a((bgal)localObject), paramMessage.arg1);
                  continue;
                  paramMessage = (bgal)paramMessage.obj;
                  if (this.jdField_a_of_type_JavaUtilMap.containsKey(bgal.a(paramMessage)))
                  {
                    a(paramMessage, 0, "");
                    this.jdField_a_of_type_JavaUtilMap.remove(bgal.a(paramMessage));
                    localObject = bgal.a(paramMessage);
                    if (localObject != null)
                    {
                      bgal.a(paramMessage).state = 2;
                      ((bgam)localObject).b(bgal.a(paramMessage), bgal.a(paramMessage));
                      continue;
                      paramMessage = (bgal)paramMessage.obj;
                      if (this.jdField_a_of_type_JavaUtilMap.containsKey(bgal.a(paramMessage)))
                      {
                        localObject = bgal.a(paramMessage);
                        if (localObject != null) {
                          ((bgam)localObject).c(bgal.a(paramMessage));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgai
 * JD-Core Version:    0.7.0.1
 */