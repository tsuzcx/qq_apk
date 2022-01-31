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

public class bjkk
  implements Handler.Callback
{
  private static String jdField_a_of_type_JavaLangString = "livepluginso.jar";
  private Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler;
  private Downloader jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader;
  private Map<String, bjkl> jdField_a_of_type_JavaUtilMap;
  
  bjkk(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader = DownloaderFactory.getInstance(this.jdField_a_of_type_AndroidContentContext).getCommonDownloader();
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.enableResumeTransfer(true);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private static void a()
  {
    String str = bjls.a(BaseApplicationImpl.getContext());
    if (TextUtils.isEmpty(str)) {}
    File localFile;
    do
    {
      return;
      localFile = new File(str + jdField_a_of_type_JavaLangString);
    } while (!localFile.exists());
    try
    {
      bjps.b(localFile, new File(str));
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
  
  private void a(bjkl parambjkl)
  {
    if (parambjkl != null)
    {
      Object localObject = bjkl.a(parambjkl);
      if (localObject != null) {
        ((bjkm)localObject).a(parambjkl);
      }
      localObject = bjls.a(BaseApplicationImpl.getContext()) + jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("QZoneLiveSoDownloader", 2, "downloadSoInner url:" + bjkl.a(parambjkl) + "     path:" + (String)localObject);
      }
      if (!this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.download(bjkl.a(parambjkl), (String)localObject, new bjkn(this, parambjkl)))
      {
        localObject = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 3);
        ((Message)localObject).obj = parambjkl;
        ((Message)localObject).sendToTarget();
      }
    }
  }
  
  private void a(bjkl parambjkl, int paramInt1, int paramInt2)
  {
    parambjkl = new HashMap();
    parambjkl.put("ret_code", String.valueOf(paramInt1));
    parambjkl.put("refer", String.valueOf(paramInt2));
    if ((BaseApplicationImpl.getApplication() != null) && (BaseApplicationImpl.getApplication().getRuntime() != null)) {
      azmz.a(BaseApplicationImpl.getContext()).a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "actQZLiveDownloadSoReport", true, 0L, 0L, parambjkl, null);
    }
  }
  
  private void b(bjkl parambjkl)
  {
    if (parambjkl != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.cancel(bjkl.a(parambjkl), new bjkn(this, parambjkl));
    }
  }
  
  public void a(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = paramString;
  }
  
  public void a(String paramString, bjkm parambjkm, int paramInt)
  {
    bjkl localbjkl = new bjkl();
    bjkl.a(localbjkl, paramString);
    bjkl.a(localbjkl, parambjkm);
    bjkl.a(localbjkl, paramInt);
    if ((bjls.a(BaseApplicationImpl.getContext())) && (parambjkm != null))
    {
      parambjkm.d(localbjkl);
      return;
    }
    paramString = Message.obtain();
    paramString.what = 0;
    paramString.obj = localbjkl;
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
      if ((paramMessage.obj instanceof bjkl))
      {
        paramMessage = (bjkl)paramMessage.obj;
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(bjkl.a(paramMessage))) {
          return false;
        }
        this.jdField_a_of_type_JavaUtilMap.put(bjkl.a(paramMessage), paramMessage);
        a(paramMessage);
        return true;
        if ((paramMessage.obj instanceof String))
        {
          paramMessage = (String)paramMessage.obj;
          if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramMessage))
          {
            Object localObject = (bjkl)this.jdField_a_of_type_JavaUtilMap.get(paramMessage);
            a((bjkl)localObject, 3, bjkl.a((bjkl)localObject));
            this.jdField_a_of_type_JavaUtilMap.remove(paramMessage);
            b((bjkl)localObject);
            continue;
            if ((paramMessage.obj instanceof bjkl))
            {
              paramMessage = (bjkl)paramMessage.obj;
              if (this.jdField_a_of_type_JavaUtilMap.containsKey(bjkl.a(paramMessage)))
              {
                a(paramMessage, 1, bjkl.a(paramMessage));
                this.jdField_a_of_type_JavaUtilMap.remove(bjkl.a(paramMessage));
                localObject = bjkl.a(paramMessage);
                if (localObject != null)
                {
                  ((bjkm)localObject).b(paramMessage);
                  continue;
                  if ((paramMessage.obj instanceof bjkl))
                  {
                    paramMessage = (bjkl)paramMessage.obj;
                    if (this.jdField_a_of_type_JavaUtilMap.containsKey(bjkl.a(paramMessage)))
                    {
                      a(paramMessage, 2, bjkl.a(paramMessage));
                      this.jdField_a_of_type_JavaUtilMap.remove(bjkl.a(paramMessage));
                      localObject = bjkl.a(paramMessage);
                      if (localObject != null)
                      {
                        ((bjkm)localObject).c(paramMessage);
                        continue;
                        if ((paramMessage.obj instanceof bjkl))
                        {
                          paramMessage = (bjkl)paramMessage.obj;
                          if (this.jdField_a_of_type_JavaUtilMap.containsKey(bjkl.a(paramMessage)))
                          {
                            localObject = bjkl.a(paramMessage);
                            a();
                            LocalMultiProcConfig.putInt("QzoneLiveSoVersion", QzoneConfig.getInstance().getConfig("LiveSetting", "LivePluginSOVersion", 5));
                            if (bjls.a(BaseApplicationImpl.getContext()))
                            {
                              a(paramMessage, 0, bjkl.a(paramMessage));
                              this.jdField_a_of_type_JavaUtilMap.remove(bjkl.a(paramMessage));
                              if (localObject != null) {
                                ((bjkm)localObject).d(paramMessage);
                              }
                            }
                            else if (localObject != null)
                            {
                              ((bjkm)localObject).c(paramMessage);
                              continue;
                              if ((paramMessage.obj instanceof bjkl))
                              {
                                paramMessage = (bjkl)paramMessage.obj;
                                if (this.jdField_a_of_type_JavaUtilMap.containsKey(bjkl.a(paramMessage)))
                                {
                                  localObject = bjkl.a(paramMessage);
                                  if (localObject != null) {
                                    ((bjkm)localObject).e(paramMessage);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjkk
 * JD-Core Version:    0.7.0.1
 */