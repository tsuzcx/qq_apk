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

public class bhit
  implements Handler.Callback
{
  private static int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long;
  private static String jdField_a_of_type_JavaLangString;
  private static long jdField_b_of_type_Long = 20971520L;
  private Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler;
  private Downloader jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader;
  private Map<String, bhiw> jdField_a_of_type_JavaUtilMap;
  private int jdField_b_of_type_Int;
  
  bhit(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    DownloaderFactory.getInstance(this.jdField_a_of_type_AndroidContentContext);
    DownloaderFactory.init(new bhip(), new bhiy());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader = DownloaderFactory.createDownloader("QZonePluginDownloader");
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setPortConfigStrategy(new bhis());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setDirectIPConfigStrategy(new bhir());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setBackupIPConfigStrategy(new bhio());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setKeepAliveStrategy(new bhiq());
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.setDownloadMode(Downloader.DownloadMode.StrictMode);
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.enableResumeTransfer(true);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private void a(bhiw parambhiw)
  {
    PluginRecord localPluginRecord = bhiw.a(parambhiw);
    Object localObject = bhiw.a(parambhiw);
    bhiw.a(parambhiw).state = 1;
    ((bhix)localObject).a(localPluginRecord);
    File localFile = bhjq.e(this.jdField_a_of_type_AndroidContentContext, localPluginRecord.id);
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
      } while (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.download(localPluginRecord.url, localFile.getAbsolutePath(), new bhiv(this, parambhiw)));
      localObject = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 3);
      ((Message)localObject).obj = parambhiw;
      ((Message)localObject).sendToTarget();
    }
    jdField_a_of_type_JavaLangString = jdField_a_of_type_Long + "_" + (String)localObject;
    this.jdField_b_of_type_Int = 0;
    if (a(localFile.getParent()))
    {
      localObject = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 3);
      ((Message)localObject).obj = parambhiw;
      ((Message)localObject).arg1 = -9998;
      ((Message)localObject).sendToTarget();
      return;
    }
  }
  
  private void a(bhiw parambhiw, int paramInt, String paramString)
  {
    PluginRecord localPluginRecord = bhiw.a(parambhiw);
    long l1 = System.currentTimeMillis();
    long l2 = jdField_a_of_type_Long;
    LpReportInfo_dc01500.reportDownload(localPluginRecord.id, localPluginRecord.old_ver, localPluginRecord.ver, jdField_a_of_type_JavaLangString, jdField_a_of_type_Int + "", bhiw.a(parambhiw), (l1 - l2) / 1000.0D, paramInt, this.jdField_b_of_type_Int, paramString);
  }
  
  private void a(bhiw parambhiw, int paramInt, String paramString1, String paramString2)
  {
    PluginRecord localPluginRecord = bhiw.a(parambhiw);
    long l1 = System.currentTimeMillis();
    long l2 = jdField_a_of_type_Long;
    LpReportInfo_dc01500.reportDownload(localPluginRecord.id, localPluginRecord.old_ver, localPluginRecord.ver, jdField_a_of_type_JavaLangString, jdField_a_of_type_Int + "", bhiw.a(parambhiw), (l1 - l2) / 1000.0D, paramInt, this.jdField_b_of_type_Int, paramString1, paramString2);
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
  
  private void b(bhiw parambhiw)
  {
    if ((parambhiw == null) || (bhiw.a(parambhiw) == null))
    {
      QLog.w("QZonePluginManger", 1, "cancelDownLoadPlugin, downloadRecord or record is null, downloadRecord=" + parambhiw);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "cancelDownLoadPlugin url:" + bhiw.a(parambhiw).url);
    }
    PluginRecord localPluginRecord = bhiw.a(parambhiw);
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.abort(localPluginRecord.url, new bhiv(this, parambhiw));
  }
  
  public void a()
  {
    jdField_a_of_type_Long = 0L;
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_JavaLangString = null;
  }
  
  public void a(PluginRecord paramPluginRecord, bhix parambhix)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    bhiw localbhiw = new bhiw(null);
    bhiw.a(localbhiw, paramPluginRecord.id);
    bhiw.a(localbhiw, paramPluginRecord);
    bhiw.a(localbhiw, -1);
    bhiw.a(localbhiw, parambhix);
    localMessage.obj = localbhiw;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(PluginRecord paramPluginRecord, bhix parambhix, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    bhiw localbhiw = new bhiw(null);
    bhiw.a(localbhiw, paramPluginRecord.id);
    paramPluginRecord.state = 0;
    bhiw.a(localbhiw, paramPluginRecord);
    bhiw.a(localbhiw, parambhix);
    bhiw.a(localbhiw, paramInt);
    localMessage.obj = localbhiw;
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
      paramMessage = (bhiw)paramMessage.obj;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(bhiw.a(paramMessage))) {
        return false;
      }
      this.jdField_a_of_type_JavaUtilMap.put(bhiw.a(paramMessage), paramMessage);
      a(paramMessage);
      return true;
      paramMessage = (bhiw)paramMessage.obj;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(bhiw.a(paramMessage)))
      {
        a(paramMessage, 3, "");
        this.jdField_a_of_type_JavaUtilMap.remove(bhiw.a(paramMessage));
        b(paramMessage);
        Object localObject = bhiw.a(paramMessage);
        if (localObject != null)
        {
          ((bhix)localObject).b(bhiw.a(paramMessage));
          continue;
          paramMessage = (bhiw)paramMessage.obj;
          if (this.jdField_a_of_type_JavaUtilMap.containsKey(bhiw.a(paramMessage)))
          {
            a(paramMessage, 1, "");
            this.jdField_a_of_type_JavaUtilMap.remove(bhiw.a(paramMessage));
            localObject = bhiw.a(paramMessage);
            if (localObject != null)
            {
              ((bhix)localObject).b(bhiw.a(paramMessage));
              continue;
              localObject = (bhiw)paramMessage.obj;
              if (this.jdField_a_of_type_JavaUtilMap.containsKey(bhiw.a((bhiw)localObject)))
              {
                a((bhiw)localObject, 2, paramMessage.arg1 + "", paramMessage.arg2 + "");
                this.jdField_a_of_type_JavaUtilMap.remove(bhiw.a((bhiw)localObject));
                bhix localbhix = bhiw.a((bhiw)localObject);
                if (localbhix != null)
                {
                  localbhix.a(bhiw.a((bhiw)localObject), paramMessage.arg1);
                  continue;
                  paramMessage = (bhiw)paramMessage.obj;
                  if (this.jdField_a_of_type_JavaUtilMap.containsKey(bhiw.a(paramMessage)))
                  {
                    a(paramMessage, 0, "");
                    this.jdField_a_of_type_JavaUtilMap.remove(bhiw.a(paramMessage));
                    localObject = bhiw.a(paramMessage);
                    if (localObject != null)
                    {
                      bhiw.a(paramMessage).state = 2;
                      ((bhix)localObject).b(bhiw.a(paramMessage), bhiw.a(paramMessage));
                      continue;
                      paramMessage = (bhiw)paramMessage.obj;
                      if (this.jdField_a_of_type_JavaUtilMap.containsKey(bhiw.a(paramMessage)))
                      {
                        localObject = bhiw.a(paramMessage);
                        if (localObject != null) {
                          ((bhix)localObject).c(bhiw.a(paramMessage));
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
 * Qualified Name:     bhit
 * JD-Core Version:    0.7.0.1
 */