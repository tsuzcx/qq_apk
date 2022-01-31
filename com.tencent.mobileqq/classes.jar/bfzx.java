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

public class bfzx
  implements Handler.Callback
{
  private static String jdField_a_of_type_JavaLangString = "livepluginso.jar";
  private Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler;
  private Downloader jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader;
  private Map<String, bfzy> jdField_a_of_type_JavaUtilMap;
  
  bfzx(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader = DownloaderFactory.getInstance(this.jdField_a_of_type_AndroidContentContext).getCommonDownloader();
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.enableResumeTransfer(true);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private static void a()
  {
    String str = bgbf.a(BaseApplicationImpl.getContext());
    if (TextUtils.isEmpty(str)) {}
    File localFile;
    do
    {
      return;
      localFile = new File(str + jdField_a_of_type_JavaLangString);
    } while (!localFile.exists());
    try
    {
      bgfb.b(localFile, new File(str));
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
  
  private void a(bfzy parambfzy)
  {
    if (parambfzy != null)
    {
      Object localObject = bfzy.a(parambfzy);
      if (localObject != null) {
        ((bfzz)localObject).a(parambfzy);
      }
      localObject = bgbf.a(BaseApplicationImpl.getContext()) + jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("QZoneLiveSoDownloader", 2, "downloadSoInner url:" + bfzy.a(parambfzy) + "     path:" + (String)localObject);
      }
      if (!this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.download(bfzy.a(parambfzy), (String)localObject, new bgaa(this, parambfzy)))
      {
        localObject = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 3);
        ((Message)localObject).obj = parambfzy;
        ((Message)localObject).sendToTarget();
      }
    }
  }
  
  private void a(bfzy parambfzy, int paramInt1, int paramInt2)
  {
    parambfzy = new HashMap();
    parambfzy.put("ret_code", String.valueOf(paramInt1));
    parambfzy.put("refer", String.valueOf(paramInt2));
    if ((BaseApplicationImpl.getApplication() != null) && (BaseApplicationImpl.getApplication().getRuntime() != null)) {
      awrn.a(BaseApplicationImpl.getContext()).a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "actQZLiveDownloadSoReport", true, 0L, 0L, parambfzy, null);
    }
  }
  
  private void b(bfzy parambfzy)
  {
    if (parambfzy != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.cancel(bfzy.a(parambfzy), new bgaa(this, parambfzy));
    }
  }
  
  public void a(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = paramString;
  }
  
  public void a(String paramString, bfzz parambfzz, int paramInt)
  {
    bfzy localbfzy = new bfzy();
    bfzy.a(localbfzy, paramString);
    bfzy.a(localbfzy, parambfzz);
    bfzy.a(localbfzy, paramInt);
    if ((bgbf.a(BaseApplicationImpl.getContext())) && (parambfzz != null))
    {
      parambfzz.d(localbfzy);
      return;
    }
    paramString = Message.obtain();
    paramString.what = 0;
    paramString.obj = localbfzy;
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
      if ((paramMessage.obj instanceof bfzy))
      {
        paramMessage = (bfzy)paramMessage.obj;
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(bfzy.a(paramMessage))) {
          return false;
        }
        this.jdField_a_of_type_JavaUtilMap.put(bfzy.a(paramMessage), paramMessage);
        a(paramMessage);
        return true;
        if ((paramMessage.obj instanceof String))
        {
          paramMessage = (String)paramMessage.obj;
          if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramMessage))
          {
            Object localObject = (bfzy)this.jdField_a_of_type_JavaUtilMap.get(paramMessage);
            a((bfzy)localObject, 3, bfzy.a((bfzy)localObject));
            this.jdField_a_of_type_JavaUtilMap.remove(paramMessage);
            b((bfzy)localObject);
            continue;
            if ((paramMessage.obj instanceof bfzy))
            {
              paramMessage = (bfzy)paramMessage.obj;
              if (this.jdField_a_of_type_JavaUtilMap.containsKey(bfzy.a(paramMessage)))
              {
                a(paramMessage, 1, bfzy.a(paramMessage));
                this.jdField_a_of_type_JavaUtilMap.remove(bfzy.a(paramMessage));
                localObject = bfzy.a(paramMessage);
                if (localObject != null)
                {
                  ((bfzz)localObject).b(paramMessage);
                  continue;
                  if ((paramMessage.obj instanceof bfzy))
                  {
                    paramMessage = (bfzy)paramMessage.obj;
                    if (this.jdField_a_of_type_JavaUtilMap.containsKey(bfzy.a(paramMessage)))
                    {
                      a(paramMessage, 2, bfzy.a(paramMessage));
                      this.jdField_a_of_type_JavaUtilMap.remove(bfzy.a(paramMessage));
                      localObject = bfzy.a(paramMessage);
                      if (localObject != null)
                      {
                        ((bfzz)localObject).c(paramMessage);
                        continue;
                        if ((paramMessage.obj instanceof bfzy))
                        {
                          paramMessage = (bfzy)paramMessage.obj;
                          if (this.jdField_a_of_type_JavaUtilMap.containsKey(bfzy.a(paramMessage)))
                          {
                            localObject = bfzy.a(paramMessage);
                            a();
                            LocalMultiProcConfig.putInt("QzoneLiveSoVersion", QzoneConfig.getInstance().getConfig("LiveSetting", "LivePluginSOVersion", 5));
                            if (bgbf.a(BaseApplicationImpl.getContext()))
                            {
                              a(paramMessage, 0, bfzy.a(paramMessage));
                              this.jdField_a_of_type_JavaUtilMap.remove(bfzy.a(paramMessage));
                              if (localObject != null) {
                                ((bfzz)localObject).d(paramMessage);
                              }
                            }
                            else if (localObject != null)
                            {
                              ((bfzz)localObject).c(paramMessage);
                              continue;
                              if ((paramMessage.obj instanceof bfzy))
                              {
                                paramMessage = (bfzy)paramMessage.obj;
                                if (this.jdField_a_of_type_JavaUtilMap.containsKey(bfzy.a(paramMessage)))
                                {
                                  localObject = bfzy.a(paramMessage);
                                  if (localObject != null) {
                                    ((bfzz)localObject).e(paramMessage);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfzx
 * JD-Core Version:    0.7.0.1
 */