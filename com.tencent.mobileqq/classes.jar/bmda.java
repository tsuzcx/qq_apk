import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class bmda
  implements Handler.Callback
{
  private static String jdField_a_of_type_JavaLangString = "livepluginso.jar";
  private Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler;
  private Downloader jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader;
  private Map<String, bmdb> jdField_a_of_type_JavaUtilMap;
  
  bmda(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader = DownloaderFactory.getInstance(this.jdField_a_of_type_AndroidContentContext).getCommonDownloader();
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.enableResumeTransfer(true);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private static void a()
  {
    String str = bmei.a(BaseApplicationImpl.getContext());
    if (TextUtils.isEmpty(str)) {}
    File localFile;
    do
    {
      return;
      localFile = new File(str + jdField_a_of_type_JavaLangString);
    } while (!localFile.exists());
    try
    {
      bmij.b(localFile, new File(str));
      if (QLog.isColorLevel()) {
        QLog.d("QZoneLiveSoDownloader", 2, "unZipPluginSo success");
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.w("QZoneLiveSoDownloader", 1, "unzipTofolder" + localException.getMessage());
      return;
    }
    finally
    {
      localFile.delete();
    }
  }
  
  private void a(bmdb parambmdb)
  {
    if (parambmdb != null)
    {
      Object localObject = bmdb.a(parambmdb);
      if (localObject != null) {
        ((bmdc)localObject).a(parambmdb);
      }
      localObject = bmei.a(BaseApplicationImpl.getContext()) + jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("QZoneLiveSoDownloader", 2, "downloadSoInner url:" + bmdb.a(parambmdb) + "     path:" + (String)localObject);
      }
      if (!this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.download(bmdb.a(parambmdb), (String)localObject, new bmdd(this, parambmdb)))
      {
        localObject = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 3);
        ((Message)localObject).obj = parambmdb;
        ((Message)localObject).sendToTarget();
      }
    }
  }
  
  private void a(bmdb parambmdb, int paramInt1, int paramInt2)
  {
    parambmdb = new HashMap();
    parambmdb.put("ret_code", String.valueOf(paramInt1));
    parambmdb.put("refer", String.valueOf(paramInt2));
    if ((BaseApplicationImpl.getApplication() != null) && (BaseApplicationImpl.getApplication().getRuntime() != null)) {
      bctj.a(BaseApplicationImpl.getContext()).a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "actQZLiveDownloadSoReport", true, 0L, 0L, parambmdb, null);
    }
  }
  
  private void b(bmdb parambmdb)
  {
    if (parambmdb != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.cancel(bmdb.a(parambmdb), new bmdd(this, parambmdb));
    }
  }
  
  public void a(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = paramString;
  }
  
  public void a(String paramString, bmdc parambmdc, int paramInt)
  {
    bmdb localbmdb = new bmdb();
    bmdb.a(localbmdb, paramString);
    bmdb.a(localbmdb, parambmdc);
    bmdb.a(localbmdb, paramInt);
    if ((bmei.a(BaseApplicationImpl.getContext())) && (parambmdc != null))
    {
      parambmdc.d(localbmdb);
      return;
    }
    paramString = Message.obtain();
    paramString.what = 0;
    paramString.obj = localbmdb;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if ((paramMessage.obj instanceof bmdb))
      {
        paramMessage = (bmdb)paramMessage.obj;
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(bmdb.a(paramMessage))) {
          return false;
        }
        this.jdField_a_of_type_JavaUtilMap.put(bmdb.a(paramMessage), paramMessage);
        a(paramMessage);
        return true;
        if ((paramMessage.obj instanceof String))
        {
          paramMessage = (String)paramMessage.obj;
          if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramMessage))
          {
            Object localObject = (bmdb)this.jdField_a_of_type_JavaUtilMap.get(paramMessage);
            a((bmdb)localObject, 3, bmdb.a((bmdb)localObject));
            this.jdField_a_of_type_JavaUtilMap.remove(paramMessage);
            b((bmdb)localObject);
            continue;
            if ((paramMessage.obj instanceof bmdb))
            {
              paramMessage = (bmdb)paramMessage.obj;
              if (this.jdField_a_of_type_JavaUtilMap.containsKey(bmdb.a(paramMessage)))
              {
                a(paramMessage, 1, bmdb.a(paramMessage));
                this.jdField_a_of_type_JavaUtilMap.remove(bmdb.a(paramMessage));
                localObject = bmdb.a(paramMessage);
                if (localObject != null)
                {
                  ((bmdc)localObject).b(paramMessage);
                  continue;
                  if ((paramMessage.obj instanceof bmdb))
                  {
                    paramMessage = (bmdb)paramMessage.obj;
                    if (this.jdField_a_of_type_JavaUtilMap.containsKey(bmdb.a(paramMessage)))
                    {
                      a(paramMessage, 2, bmdb.a(paramMessage));
                      this.jdField_a_of_type_JavaUtilMap.remove(bmdb.a(paramMessage));
                      localObject = bmdb.a(paramMessage);
                      if (localObject != null)
                      {
                        ((bmdc)localObject).c(paramMessage);
                        continue;
                        if ((paramMessage.obj instanceof bmdb))
                        {
                          paramMessage = (bmdb)paramMessage.obj;
                          if (this.jdField_a_of_type_JavaUtilMap.containsKey(bmdb.a(paramMessage)))
                          {
                            localObject = bmdb.a(paramMessage);
                            a();
                            LocalMultiProcConfig.putInt("QzoneLiveSoVersion", QzoneConfig.getInstance().getConfig("LiveSetting", "LivePluginSOVersion", 5));
                            if (bmei.a(BaseApplicationImpl.getContext()))
                            {
                              a(paramMessage, 0, bmdb.a(paramMessage));
                              this.jdField_a_of_type_JavaUtilMap.remove(bmdb.a(paramMessage));
                              if (localObject != null) {
                                ((bmdc)localObject).d(paramMessage);
                              }
                            }
                            else if (localObject != null)
                            {
                              ((bmdc)localObject).c(paramMessage);
                              continue;
                              if ((paramMessage.obj instanceof bmdb))
                              {
                                paramMessage = (bmdb)paramMessage.obj;
                                if (this.jdField_a_of_type_JavaUtilMap.containsKey(bmdb.a(paramMessage)))
                                {
                                  localObject = bmdb.a(paramMessage);
                                  if (localObject != null) {
                                    ((bmdc)localObject).e(paramMessage);
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
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmda
 * JD-Core Version:    0.7.0.1
 */