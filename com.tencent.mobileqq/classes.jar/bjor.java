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

public class bjor
  implements Handler.Callback
{
  private static String jdField_a_of_type_JavaLangString = "livepluginso.jar";
  private Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler;
  private Downloader jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader;
  private Map<String, bjos> jdField_a_of_type_JavaUtilMap;
  
  bjor(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader = DownloaderFactory.getInstance(this.jdField_a_of_type_AndroidContentContext).getCommonDownloader();
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.enableResumeTransfer(true);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private static void a()
  {
    String str = bjpz.a(BaseApplicationImpl.getContext());
    if (TextUtils.isEmpty(str)) {}
    File localFile;
    do
    {
      return;
      localFile = new File(str + jdField_a_of_type_JavaLangString);
    } while (!localFile.exists());
    try
    {
      bjtz.b(localFile, new File(str));
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
  
  private void a(bjos parambjos)
  {
    if (parambjos != null)
    {
      Object localObject = bjos.a(parambjos);
      if (localObject != null) {
        ((bjot)localObject).a(parambjos);
      }
      localObject = bjpz.a(BaseApplicationImpl.getContext()) + jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("QZoneLiveSoDownloader", 2, "downloadSoInner url:" + bjos.a(parambjos) + "     path:" + (String)localObject);
      }
      if (!this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.download(bjos.a(parambjos), (String)localObject, new bjou(this, parambjos)))
      {
        localObject = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 3);
        ((Message)localObject).obj = parambjos;
        ((Message)localObject).sendToTarget();
      }
    }
  }
  
  private void a(bjos parambjos, int paramInt1, int paramInt2)
  {
    parambjos = new HashMap();
    parambjos.put("ret_code", String.valueOf(paramInt1));
    parambjos.put("refer", String.valueOf(paramInt2));
    if ((BaseApplicationImpl.getApplication() != null) && (BaseApplicationImpl.getApplication().getRuntime() != null)) {
      azri.a(BaseApplicationImpl.getContext()).a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "actQZLiveDownloadSoReport", true, 0L, 0L, parambjos, null);
    }
  }
  
  private void b(bjos parambjos)
  {
    if (parambjos != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.cancel(bjos.a(parambjos), new bjou(this, parambjos));
    }
  }
  
  public void a(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = paramString;
  }
  
  public void a(String paramString, bjot parambjot, int paramInt)
  {
    bjos localbjos = new bjos();
    bjos.a(localbjos, paramString);
    bjos.a(localbjos, parambjot);
    bjos.a(localbjos, paramInt);
    if ((bjpz.a(BaseApplicationImpl.getContext())) && (parambjot != null))
    {
      parambjot.d(localbjos);
      return;
    }
    paramString = Message.obtain();
    paramString.what = 0;
    paramString.obj = localbjos;
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
      if ((paramMessage.obj instanceof bjos))
      {
        paramMessage = (bjos)paramMessage.obj;
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(bjos.a(paramMessage))) {
          return false;
        }
        this.jdField_a_of_type_JavaUtilMap.put(bjos.a(paramMessage), paramMessage);
        a(paramMessage);
        return true;
        if ((paramMessage.obj instanceof String))
        {
          paramMessage = (String)paramMessage.obj;
          if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramMessage))
          {
            Object localObject = (bjos)this.jdField_a_of_type_JavaUtilMap.get(paramMessage);
            a((bjos)localObject, 3, bjos.a((bjos)localObject));
            this.jdField_a_of_type_JavaUtilMap.remove(paramMessage);
            b((bjos)localObject);
            continue;
            if ((paramMessage.obj instanceof bjos))
            {
              paramMessage = (bjos)paramMessage.obj;
              if (this.jdField_a_of_type_JavaUtilMap.containsKey(bjos.a(paramMessage)))
              {
                a(paramMessage, 1, bjos.a(paramMessage));
                this.jdField_a_of_type_JavaUtilMap.remove(bjos.a(paramMessage));
                localObject = bjos.a(paramMessage);
                if (localObject != null)
                {
                  ((bjot)localObject).b(paramMessage);
                  continue;
                  if ((paramMessage.obj instanceof bjos))
                  {
                    paramMessage = (bjos)paramMessage.obj;
                    if (this.jdField_a_of_type_JavaUtilMap.containsKey(bjos.a(paramMessage)))
                    {
                      a(paramMessage, 2, bjos.a(paramMessage));
                      this.jdField_a_of_type_JavaUtilMap.remove(bjos.a(paramMessage));
                      localObject = bjos.a(paramMessage);
                      if (localObject != null)
                      {
                        ((bjot)localObject).c(paramMessage);
                        continue;
                        if ((paramMessage.obj instanceof bjos))
                        {
                          paramMessage = (bjos)paramMessage.obj;
                          if (this.jdField_a_of_type_JavaUtilMap.containsKey(bjos.a(paramMessage)))
                          {
                            localObject = bjos.a(paramMessage);
                            a();
                            LocalMultiProcConfig.putInt("QzoneLiveSoVersion", QzoneConfig.getInstance().getConfig("LiveSetting", "LivePluginSOVersion", 5));
                            if (bjpz.a(BaseApplicationImpl.getContext()))
                            {
                              a(paramMessage, 0, bjos.a(paramMessage));
                              this.jdField_a_of_type_JavaUtilMap.remove(bjos.a(paramMessage));
                              if (localObject != null) {
                                ((bjot)localObject).d(paramMessage);
                              }
                            }
                            else if (localObject != null)
                            {
                              ((bjot)localObject).c(paramMessage);
                              continue;
                              if ((paramMessage.obj instanceof bjos))
                              {
                                paramMessage = (bjos)paramMessage.obj;
                                if (this.jdField_a_of_type_JavaUtilMap.containsKey(bjos.a(paramMessage)))
                                {
                                  localObject = bjos.a(paramMessage);
                                  if (localObject != null) {
                                    ((bjot)localObject).e(paramMessage);
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
 * Qualified Name:     bjor
 * JD-Core Version:    0.7.0.1
 */