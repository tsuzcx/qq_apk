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

public class bnen
  implements Handler.Callback
{
  private static int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long;
  private static String jdField_a_of_type_JavaLangString;
  private static long jdField_b_of_type_Long = 20971520L;
  private Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler;
  private Downloader jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader;
  private Map<String, bneq> jdField_a_of_type_JavaUtilMap;
  private int jdField_b_of_type_Int;
  
  bnen(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    DownloaderFactory.getInstance(this.jdField_a_of_type_AndroidContentContext);
    DownloaderFactory.init(new bnej(), new bnes());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader = DownloaderFactory.createDownloader("QZonePluginDownloader");
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setPortConfigStrategy(new bnem());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setDirectIPConfigStrategy(new bnel());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setBackupIPConfigStrategy(new bnei());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setKeepAliveStrategy(new bnek());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setDownloadMode(Downloader.DownloadMode.StrictMode);
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.enableResumeTransfer(true);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private void a(bneq parambneq)
  {
    PluginRecord localPluginRecord = bneq.a(parambneq);
    Object localObject = bneq.a(parambneq);
    bneq.a(parambneq).state = 1;
    ((bner)localObject).a(localPluginRecord);
    File localFile = bnfk.e(this.jdField_a_of_type_AndroidContentContext, localPluginRecord.id);
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
      } while (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.download(localPluginRecord.url, localFile.getAbsolutePath(), new bnep(this, parambneq)));
      localObject = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 3);
      ((Message)localObject).obj = parambneq;
      ((Message)localObject).sendToTarget();
    }
    jdField_a_of_type_JavaLangString = jdField_a_of_type_Long + "_" + (String)localObject;
    this.jdField_b_of_type_Int = 0;
    if (a(localFile.getParent()))
    {
      localObject = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 3);
      ((Message)localObject).obj = parambneq;
      ((Message)localObject).arg1 = -9998;
      ((Message)localObject).sendToTarget();
      return;
    }
  }
  
  private void a(bneq parambneq, int paramInt, String paramString)
  {
    PluginRecord localPluginRecord = bneq.a(parambneq);
    long l1 = System.currentTimeMillis();
    long l2 = jdField_a_of_type_Long;
    LpReportInfo_dc01500.reportDownload(localPluginRecord.id, localPluginRecord.old_ver, localPluginRecord.ver, jdField_a_of_type_JavaLangString, jdField_a_of_type_Int + "", bneq.a(parambneq), (l1 - l2) / 1000.0D, paramInt, this.jdField_b_of_type_Int, paramString);
  }
  
  private void a(bneq parambneq, int paramInt, String paramString1, String paramString2)
  {
    PluginRecord localPluginRecord = bneq.a(parambneq);
    long l1 = System.currentTimeMillis();
    long l2 = jdField_a_of_type_Long;
    LpReportInfo_dc01500.reportDownload(localPluginRecord.id, localPluginRecord.old_ver, localPluginRecord.ver, jdField_a_of_type_JavaLangString, jdField_a_of_type_Int + "", bneq.a(parambneq), (l1 - l2) / 1000.0D, paramInt, this.jdField_b_of_type_Int, paramString1, paramString2);
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
  
  private void b(bneq parambneq)
  {
    if ((parambneq == null) || (bneq.a(parambneq) == null))
    {
      QLog.w("QZonePluginManger", 1, "cancelDownLoadPlugin, downloadRecord or record is null, downloadRecord=" + parambneq);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "cancelDownLoadPlugin url:" + bneq.a(parambneq).url);
    }
    PluginRecord localPluginRecord = bneq.a(parambneq);
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.abort(localPluginRecord.url, new bnep(this, parambneq));
  }
  
  public void a()
  {
    jdField_a_of_type_Long = 0L;
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_JavaLangString = null;
  }
  
  public void a(PluginRecord paramPluginRecord, bner parambner)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    bneq localbneq = new bneq(null);
    bneq.a(localbneq, paramPluginRecord.id);
    bneq.a(localbneq, paramPluginRecord);
    bneq.a(localbneq, -1);
    bneq.a(localbneq, parambner);
    localMessage.obj = localbneq;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(PluginRecord paramPluginRecord, bner parambner, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    bneq localbneq = new bneq(null);
    bneq.a(localbneq, paramPluginRecord.id);
    paramPluginRecord.state = 0;
    bneq.a(localbneq, paramPluginRecord);
    bneq.a(localbneq, parambner);
    bneq.a(localbneq, paramInt);
    localMessage.obj = localbneq;
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
      paramMessage = (bneq)paramMessage.obj;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(bneq.a(paramMessage))) {
        return false;
      }
      this.jdField_a_of_type_JavaUtilMap.put(bneq.a(paramMessage), paramMessage);
      a(paramMessage);
      return true;
      paramMessage = (bneq)paramMessage.obj;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(bneq.a(paramMessage)))
      {
        a(paramMessage, 3, "");
        this.jdField_a_of_type_JavaUtilMap.remove(bneq.a(paramMessage));
        b(paramMessage);
        Object localObject = bneq.a(paramMessage);
        if (localObject != null)
        {
          ((bner)localObject).b(bneq.a(paramMessage));
          continue;
          paramMessage = (bneq)paramMessage.obj;
          if (this.jdField_a_of_type_JavaUtilMap.containsKey(bneq.a(paramMessage)))
          {
            a(paramMessage, 1, "");
            this.jdField_a_of_type_JavaUtilMap.remove(bneq.a(paramMessage));
            localObject = bneq.a(paramMessage);
            if (localObject != null)
            {
              ((bner)localObject).b(bneq.a(paramMessage));
              continue;
              localObject = (bneq)paramMessage.obj;
              if (this.jdField_a_of_type_JavaUtilMap.containsKey(bneq.a((bneq)localObject)))
              {
                a((bneq)localObject, 2, paramMessage.arg1 + "", paramMessage.arg2 + "");
                this.jdField_a_of_type_JavaUtilMap.remove(bneq.a((bneq)localObject));
                bner localbner = bneq.a((bneq)localObject);
                if (localbner != null)
                {
                  localbner.a(bneq.a((bneq)localObject), paramMessage.arg1);
                  continue;
                  paramMessage = (bneq)paramMessage.obj;
                  if (this.jdField_a_of_type_JavaUtilMap.containsKey(bneq.a(paramMessage)))
                  {
                    a(paramMessage, 0, "");
                    this.jdField_a_of_type_JavaUtilMap.remove(bneq.a(paramMessage));
                    localObject = bneq.a(paramMessage);
                    if (localObject != null)
                    {
                      bneq.a(paramMessage).state = 2;
                      ((bner)localObject).b(bneq.a(paramMessage), bneq.a(paramMessage));
                      continue;
                      paramMessage = (bneq)paramMessage.obj;
                      if (this.jdField_a_of_type_JavaUtilMap.containsKey(bneq.a(paramMessage)))
                      {
                        localObject = bneq.a(paramMessage);
                        if (localObject != null) {
                          ((bner)localObject).c(bneq.a(paramMessage));
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
 * Qualified Name:     bnen
 * JD-Core Version:    0.7.0.1
 */