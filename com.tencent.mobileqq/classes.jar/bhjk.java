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

public class bhjk
  implements Handler.Callback
{
  private static int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long;
  private static String jdField_a_of_type_JavaLangString;
  private static long jdField_b_of_type_Long = 20971520L;
  private Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler;
  private Downloader jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader;
  private Map<String, bhjn> jdField_a_of_type_JavaUtilMap;
  private int jdField_b_of_type_Int;
  
  bhjk(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    DownloaderFactory.getInstance(this.jdField_a_of_type_AndroidContentContext);
    DownloaderFactory.init(new bhjg(), new bhjp());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader = DownloaderFactory.createDownloader("QZonePluginDownloader");
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setPortConfigStrategy(new bhjj());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setDirectIPConfigStrategy(new bhji());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setBackupIPConfigStrategy(new bhjf());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setKeepAliveStrategy(new bhjh());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setDownloadMode(Downloader.DownloadMode.StrictMode);
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.enableResumeTransfer(true);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private void a(bhjn parambhjn)
  {
    PluginRecord localPluginRecord = bhjn.a(parambhjn);
    Object localObject = bhjn.a(parambhjn);
    bhjn.a(parambhjn).state = 1;
    ((bhjo)localObject).a(localPluginRecord);
    File localFile = bhkh.e(this.jdField_a_of_type_AndroidContentContext, localPluginRecord.id);
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
      } while (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.download(localPluginRecord.url, localFile.getAbsolutePath(), new bhjm(this, parambhjn)));
      localObject = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 3);
      ((Message)localObject).obj = parambhjn;
      ((Message)localObject).sendToTarget();
    }
    jdField_a_of_type_JavaLangString = jdField_a_of_type_Long + "_" + (String)localObject;
    this.jdField_b_of_type_Int = 0;
    if (a(localFile.getParent()))
    {
      localObject = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 3);
      ((Message)localObject).obj = parambhjn;
      ((Message)localObject).arg1 = -9998;
      ((Message)localObject).sendToTarget();
      return;
    }
  }
  
  private void a(bhjn parambhjn, int paramInt, String paramString)
  {
    PluginRecord localPluginRecord = bhjn.a(parambhjn);
    long l1 = System.currentTimeMillis();
    long l2 = jdField_a_of_type_Long;
    LpReportInfo_dc01500.reportDownload(localPluginRecord.id, localPluginRecord.old_ver, localPluginRecord.ver, jdField_a_of_type_JavaLangString, jdField_a_of_type_Int + "", bhjn.a(parambhjn), (l1 - l2) / 1000.0D, paramInt, this.jdField_b_of_type_Int, paramString);
  }
  
  private void a(bhjn parambhjn, int paramInt, String paramString1, String paramString2)
  {
    PluginRecord localPluginRecord = bhjn.a(parambhjn);
    long l1 = System.currentTimeMillis();
    long l2 = jdField_a_of_type_Long;
    LpReportInfo_dc01500.reportDownload(localPluginRecord.id, localPluginRecord.old_ver, localPluginRecord.ver, jdField_a_of_type_JavaLangString, jdField_a_of_type_Int + "", bhjn.a(parambhjn), (l1 - l2) / 1000.0D, paramInt, this.jdField_b_of_type_Int, paramString1, paramString2);
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
  
  private void b(bhjn parambhjn)
  {
    if ((parambhjn == null) || (bhjn.a(parambhjn) == null))
    {
      QLog.w("QZonePluginManger", 1, "cancelDownLoadPlugin, downloadRecord or record is null, downloadRecord=" + parambhjn);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "cancelDownLoadPlugin url:" + bhjn.a(parambhjn).url);
    }
    PluginRecord localPluginRecord = bhjn.a(parambhjn);
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.abort(localPluginRecord.url, new bhjm(this, parambhjn));
  }
  
  public void a()
  {
    jdField_a_of_type_Long = 0L;
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_JavaLangString = null;
  }
  
  public void a(PluginRecord paramPluginRecord, bhjo parambhjo)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    bhjn localbhjn = new bhjn(null);
    bhjn.a(localbhjn, paramPluginRecord.id);
    bhjn.a(localbhjn, paramPluginRecord);
    bhjn.a(localbhjn, -1);
    bhjn.a(localbhjn, parambhjo);
    localMessage.obj = localbhjn;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(PluginRecord paramPluginRecord, bhjo parambhjo, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    bhjn localbhjn = new bhjn(null);
    bhjn.a(localbhjn, paramPluginRecord.id);
    paramPluginRecord.state = 0;
    bhjn.a(localbhjn, paramPluginRecord);
    bhjn.a(localbhjn, parambhjo);
    bhjn.a(localbhjn, paramInt);
    localMessage.obj = localbhjn;
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
      paramMessage = (bhjn)paramMessage.obj;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(bhjn.a(paramMessage))) {
        return false;
      }
      this.jdField_a_of_type_JavaUtilMap.put(bhjn.a(paramMessage), paramMessage);
      a(paramMessage);
      return true;
      paramMessage = (bhjn)paramMessage.obj;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(bhjn.a(paramMessage)))
      {
        a(paramMessage, 3, "");
        this.jdField_a_of_type_JavaUtilMap.remove(bhjn.a(paramMessage));
        b(paramMessage);
        Object localObject = bhjn.a(paramMessage);
        if (localObject != null)
        {
          ((bhjo)localObject).b(bhjn.a(paramMessage));
          continue;
          paramMessage = (bhjn)paramMessage.obj;
          if (this.jdField_a_of_type_JavaUtilMap.containsKey(bhjn.a(paramMessage)))
          {
            a(paramMessage, 1, "");
            this.jdField_a_of_type_JavaUtilMap.remove(bhjn.a(paramMessage));
            localObject = bhjn.a(paramMessage);
            if (localObject != null)
            {
              ((bhjo)localObject).b(bhjn.a(paramMessage));
              continue;
              localObject = (bhjn)paramMessage.obj;
              if (this.jdField_a_of_type_JavaUtilMap.containsKey(bhjn.a((bhjn)localObject)))
              {
                a((bhjn)localObject, 2, paramMessage.arg1 + "", paramMessage.arg2 + "");
                this.jdField_a_of_type_JavaUtilMap.remove(bhjn.a((bhjn)localObject));
                bhjo localbhjo = bhjn.a((bhjn)localObject);
                if (localbhjo != null)
                {
                  localbhjo.a(bhjn.a((bhjn)localObject), paramMessage.arg1);
                  continue;
                  paramMessage = (bhjn)paramMessage.obj;
                  if (this.jdField_a_of_type_JavaUtilMap.containsKey(bhjn.a(paramMessage)))
                  {
                    a(paramMessage, 0, "");
                    this.jdField_a_of_type_JavaUtilMap.remove(bhjn.a(paramMessage));
                    localObject = bhjn.a(paramMessage);
                    if (localObject != null)
                    {
                      bhjn.a(paramMessage).state = 2;
                      ((bhjo)localObject).b(bhjn.a(paramMessage), bhjn.a(paramMessage));
                      continue;
                      paramMessage = (bhjn)paramMessage.obj;
                      if (this.jdField_a_of_type_JavaUtilMap.containsKey(bhjn.a(paramMessage)))
                      {
                        localObject = bhjn.a(paramMessage);
                        if (localObject != null) {
                          ((bhjo)localObject).c(bhjn.a(paramMessage));
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
 * Qualified Name:     bhjk
 * JD-Core Version:    0.7.0.1
 */